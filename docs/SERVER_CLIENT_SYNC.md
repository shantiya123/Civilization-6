# Server-Client Synchronization

## 1. Purpose

Implement the server-client synchronization architecture for the Civilization project.

The server is authoritative over the game state. Each client maintains a local copy of the game state so it can render the game and run client-side animations without constantly querying the server.

Synchronization is based on:

- `SuperWorld.ChangeTracker`
- immutable commits
- incremental update delivery
- client-side `lastAppliedCommit`
- reconnect synchronization
- serialization/deserialization
- a thread pool for network I/O
- a single authoritative game-state owner/thread

This document defines the architecture and rules that must be followed during implementation.

---

# 2. Core Architecture

The server owns the authoritative state.

```text
SERVER
│
├── SuperWorld
│   ├── shared game state
│   └── ChangeTracker
│
├── World (Player A)
├── World (Player B)
├── World (Player C)
│
└── CommitHistory
```

Every `World` references the same `SuperWorld.ChangeTracker`.

There must not be a separate change tracker for each `World` for synchronization purposes.

Conceptually:

```text
World A ─┐
World B ─┤
World C ─┼──> SuperWorld.ChangeTracker
World D ─┘
```

`sendUpdate()` operates on the `SuperWorld` change tracker.

---

# 3. Client World

Every connected client maintains its own local copy of the relevant game state.

Conceptually:

```text
SERVER                         CLIENT A

SuperWorld                     ClientWorld
World A             ────────>  local copy
                              
World B
World C
```

The client copy exists primarily so that:

- rendering can happen locally
- animations can happen locally
- the client does not need to request game state every frame
- the UI can operate on local state

The client copy is **never authoritative**.

The server remains the source of truth.

If the client predicts or calculates something incorrectly, the server's state always wins.

---

# 4. ChangeTracker

The existing `ChangeTracker` is the basis of synchronization.

It contains:

```java
Set<Model> created;
Set<Model> modified;
Set<Model> deleted;
```

The tracker records changes made to the authoritative game state.

Its responsibilities remain limited to tracking changes.

It must NOT:

- serialize models
- send network messages
- know about sockets
- know about clients
- decide which player receives data
- mutate client state

The tracker only answers:

> What changed since the last synchronization commit?

---

# 5. Synchronization Point

`sendUpdate()` is explicitly called by the game/server code.

It is analogous to the existing explicit refresh calls.

The system must NOT automatically trigger synchronization from inside `ChangeTracker`.

The intended flow is:

```text
Game operation
    ↓
Logic modifies Models
    ↓
ChangeTracker records changes
    ↓
operation finishes
    ↓
sendUpdate()
```

The programmer/game logic decides when the operation is complete and calls `sendUpdate()`.

---

# 6. Empty Updates

If `sendUpdate()` is called while the `ChangeTracker` contains no changes:

```text
created   = empty
modified  = empty
deleted   = empty
```

then:

- no commit is created
- no commit ID is consumed
- nothing is sent
- the method returns immediately

---

# 7. Commit

A commit represents one synchronization batch.

A commit is created every time `sendUpdate()` is called and there are pending changes.

Conceptually:

```text
Commit
    commitId
    created[]
    modified[]
    deleted[]
```

The exact implementation may introduce additional metadata where necessary.

---

# 8. Commit IDs

Each commit has an incrementing integer ID:

```text
1
2
3
4
...
```

Commit IDs belong to the game.

They must remain monotonic.

When a game is saved and later loaded, the next commit must continue from the previous value.

Example:

```text
Before save:

Commit 97
Commit 98
Commit 99

Save
Load

Next commit:
Commit 100
```

Do not reset commit numbering after loading.

---

# 9. Immutable Commits

Once a commit has been created, it is immutable.

For example:

```text
Commit #25
```

must never later be modified.

If another change occurs, it belongs to another commit:

```text
Commit #25
Commit #26
```

A commit therefore represents a historical synchronization point.

---

# 10. Creating a Commit

When `sendUpdate()` is called:

### Step 1

Check whether the shared `SuperWorld.ChangeTracker` contains changes.

If not, return.

### Step 2

Capture:

```text
created
modified
deleted
```

from the tracker.

### Step 3

Create the next immutable commit.

### Step 4

Store the commit in the server's commit history.

### Step 5

Clear the `SuperWorld.ChangeTracker`.

### Step 6

Send the newly created commit to all connected clients.

Conceptually:

```text
SuperWorld.ChangeTracker
        │
        ▼
   capture changes
        │
        ▼
     Commit #N
        │
        ├────────> CommitHistory
        │
        └────────> connected clients
                         │
                         ▼
                    serialization
```

The commit must be stored independently of whether every client successfully receives it.

---

# 11. Commit History

The server keeps all commits for the lifetime of the game.

Conceptually:

```text
CommitHistory

Commit 1
Commit 2
Commit 3
...
Commit N
```

Do not delete old commits during normal gameplay.

The commit history belongs to the game and should be associated with `SuperWorld`.

A suitable conceptual structure is:

```text
SuperWorld
    ├── ChangeTracker
    └── CommitHistory
```

The exact class names and placement should be adapted to the existing repository architecture rather than creating unnecessary duplicate infrastructure.

---

# 12. One Global Commit

There is one global commit per `sendUpdate()` call.

It contains all changes that were recorded in the shared synchronization tracker.

There must not be:

```text
Commit for World A
Commit for World B
Commit for World C
```

Instead:

```text
Commit #20
    all game changes
```

All `World` instances use the same `SuperWorld.ChangeTracker`.

---

# 13. Public and Private Changes

A commit contains **all changes**, regardless of whether they are public or private.

For example:

```text
Commit #30

created:
    Unit #42

modified:
    Hex #100
    Resources(Player A)
    Technology(Player A)
    Resources(Player B)

deleted:
    Unit #7
```

The complete commit is stored on the server.

The same commit is sent to clients.

The recipient/visibility information attached to serialized entries determines which client should apply a particular entry.

The server must not create different historical commits for different clients.

---

# 14. Recipient Token

Synchronization entries may contain recipient information.

Conceptually:

```text
recipientToken = null
```

means:

```text
available to every client
```

A player-specific token means:

```text
available only to the corresponding player
```

For example:

```text
Unit #42
recipientToken = null
```

is public.

```text
Resources(Player A)
recipientToken = PlayerA_token
```

is private to Player A.

The server is responsible for determining the correct recipient information.

The client must never be trusted to decide what private information it is allowed to receive.

The precise representation of this metadata should be designed without unnecessarily modifying the domain Models.

Prefer keeping networking metadata separate from authoritative game-state fields when practical.

---

# 15. Modified Objects

A `modified` entry should contain the object's complete current state rather than a field-level diff.

Example:

```text
modified:
    Unit #42
        id
        owner
        position
        health
        ...
```

Do NOT initially implement:

```text
Unit #42
    position: old → new
    health: old → new
```

Complete current state is intentionally preferred because it makes synchronization simpler and more robust.

The client replaces/updates its local representation using the authoritative state.

---

# 16. Created Objects

A `created` entry must contain enough information for the client to construct its local copy of the object.

Example:

```text
created:
    Unit #50
        complete serialized state
```

The client does not already possess this object.

---

# 17. Deleted Objects

A `deleted` entry does not need the complete object state.

It must contain enough information to uniquely identify the object to remove.

The existing `Model.id` mechanism should be used.

Conceptually:

```text
deleted:
    type = Unit
    id = 50
```

The client then removes the corresponding local object.

---

# 18. Model IDs

The existing `Model.id` system must be preserved.

Synchronization should identify objects using their stable model IDs.

Do not replace the existing ID architecture unnecessarily.

The synchronization system must be able to determine:

```text
object type
+
object ID
```

for serialized objects.

---

# 19. Serialization

Commits are stored on the server as commit objects.

They are serialized when they are being sent.

Do not store only serialized network data as the primary commit representation unless there is a specific architectural reason to do so.

Conceptually:

```text
Commit object
      ↓
serialization
      ↓
network payload
      ↓
client
      ↓
deserialization
      ↓
ClientWorld
```

Use the repository's existing serialization/save-load architecture where appropriate.

Before implementing a new serialization mechanism, inspect the existing save/load implementation.

Do not create a second incompatible serialization architecture without a strong reason.

---

# 20. Initial Client Connection

A client connecting for the first time has no previous commit.

It must receive an initial snapshot of the current game state.

Conceptually:

```text
Client
    │
    │ CONNECT
    ▼
Server
    │
    │ INITIAL SNAPSHOT
    ▼
ClientWorld
```

The initial snapshot establishes the client's starting synchronization state.

The client then begins receiving normal incremental commits.

Do not make a new client replay the entire commit history from Commit #1.

---

# 21. Client Commit State

The client stores:

```text
lastAppliedCommit
```

This represents the latest commit that the client has successfully applied completely.

Example:

```text
Client A
lastAppliedCommit = 25
```

The client must update this value only after successfully applying the entire corresponding commit.

---

# 22. Normal Update Delivery

During normal gameplay, clients do NOT repeatedly ask the server for commits.

The server pushes commits when `sendUpdate()` is called.

Example:

```text
Server:

sendUpdate()
    ↓
Commit #26
    ↓
broadcast to all connected clients
```

Every currently connected client receives Commit #26.

There is no polling loop where clients repeatedly ask:

```text
"Do you have a new commit?"
```

---

# 23. Reconnection

When a client reconnects, it sends its last successfully applied commit number.

Example:

```text
Client:
lastAppliedCommit = 20
```

The server compares that against its commit history.

If the server has:

```text
Commit 21
Commit 22
Commit 23
Commit 24
```

the server sends the missing commits.

The client applies them sequentially:

```text
21
22
23
24
```

and eventually reaches:

```text
lastAppliedCommit = 24
```

---

# 24. Reconnection Does Not Change Normal Delivery

The distinction is:

### Normal connection

```text
Server calls sendUpdate()
        ↓
Server pushes commit
        ↓
All connected clients receive it
```

### Reconnection

```text
Client connects
        ↓
Client reports lastAppliedCommit
        ↓
Server determines missing commits
        ↓
Server sends missing commits
```

The client does not normally request every update.

It only requests synchronization information when reconnecting.

---

# 25. Missing Commit

If a client expects Commit #11 but receives Commit #12:

```text
Client:
lastAppliedCommit = 10

received:
Commit #12
```

it must NOT blindly apply Commit #12.

The expected next commit is:

```text
11
```

The client must recover the missing commit before applying later commits.

---

# 26. Client Ahead of Server

If the client reports:

```text
lastAppliedCommit = 55
```

while the server currently has:

```text
latestCommit = 50
```

the client's synchronization state is invalid.

The server should not attempt to continue incremental synchronization.

Instead, it should send a fresh snapshot and establish a new valid synchronization point.

---

# 27. Snapshot Fallback

A fresh snapshot is the recovery mechanism when incremental synchronization is no longer possible.

For example:

```text
Client:
lastAppliedCommit = 20

Server:
available history does not contain everything required
```

The server sends:

```text
CURRENT SNAPSHOT
```

The client replaces/rebuilds its local state from the snapshot.

The snapshot establishes the new `lastAppliedCommit`.

---

# 28. Client Application of a Commit

A client should apply a received commit as one synchronization operation.

Conceptually:

```text
Receive commit
      ↓
Validate commit ID
      ↓
Deserialize
      ↓
Filter entries using recipient information
      ↓
Apply created entries
      ↓
Apply modified entries
      ↓
Apply deleted entries
      ↓
Update lastAppliedCommit
      ↓
Notify client systems/UI
```

The commit must not be considered applied until the complete operation succeeds.

---

# 29. Rendering and Synchronization

The existing rendering refresh mechanism must not be used as the networking mechanism.

Currently the architecture contains a refresh event that eventually causes:

```text
animation.refresh()
frame refresh
```

The new architecture separates these concerns.

Server:

```text
Game operation
    ↓
ChangeTracker
    ↓
sendUpdate()
    ↓
Commit
    ↓
Network
```

Client:

```text
Network
    ↓
Commit received
    ↓
ClientWorld updated
    ↓
Client event
    ↓
Drawing / Animation / UI refresh
```

Rendering is therefore a consequence of receiving updated state, not the mechanism that distributes state.

---

# 30. Client Rendering Frequency

Synchronization must not be tied to rendering FPS.

Do NOT implement:

```text
60 FPS
    ↓
serialize state
    ↓
send network update
```

The client can render at its own frame rate using its local `ClientWorld`.

Network synchronization occurs only at explicit `sendUpdate()` points.

---

# 31. Thread Pool

A thread pool should be used for network I/O.

The authoritative game state must not be concurrently mutated by arbitrary network worker threads.

Preferred architecture:

```text
                 GAME THREAD
                     │
                     ▼
             modify game state
                     │
                     ▼
                ChangeTracker
                     │
                     ▼
                 sendUpdate()
                     │
                     ▼
              immutable Commit
                     │
             ┌───────┼────────┐
             ▼       ▼        ▼
         Worker A Worker B Worker C
             │       │        │
             ▼       ▼        ▼
          Client A Client B Client C
```

Network workers are responsible for sending already-created synchronization data.

They should not modify the authoritative `SuperWorld` or `World` objects.

---

# 32. Serialization and Thread Safety

The network workers should preferably operate on the immutable commit/synchronization representation rather than reading arbitrary live game state while it is being mutated.

The intended sequence is:

```text
Game thread
    ↓
capture state
    ↓
immutable Commit
    ↓
workers receive Commit
    ↓
serialize/send
```

This prevents network workers from observing partially modified game objects.

---

# 33. Failed Client Send

Suppose:

```text
Commit #50

Client A → success
Client B → success
Client C → disconnected
```

The server still keeps:

```text
Commit #50
```

because all commits are stored for the lifetime of the game.

When Client C reconnects:

```text
Client C:
lastAppliedCommit = 49

Server:
send Commit #50
```

There is no need to keep retrying the failed socket indefinitely.

---

# 34. Acknowledgments

Clients should acknowledge successfully applied commits.

Example:

```text
Client
    ↓
"Commit #50 applied successfully"
    ↓
Server
```

ACKs are useful for tracking client synchronization state.

However, the server's commit history must not depend on ACKs for correctness.

The server does not delete Commit #50 merely because all clients acknowledged it.

---

# 35. Saving the Game

Commit history is part of the saved game state.

Saving must preserve:

```text
Game State
+
Commit History
+
Latest Commit ID
```

After loading:

```text
latestCommit = previous latest commit
```

and new commits continue from that number.

Example:

```text
Saved:
Commit 100

Loaded:
latestCommit = 100

Next:
Commit 101
```

---

# 36. Saving with Pending Changes

Before saving the game, pending changes must be committed.

If:

```text
latestCommit = 50

ChangeTracker:
    modified Unit #42
```

then saving performs:

```text
ChangeTracker
    ↓
sendUpdate()
    ↓
Commit #51
    ↓
ChangeTracker.clear()
    ↓
save game
```

A saved game must therefore represent a clean committed synchronization state.

The intended invariant is:

```text
Saved game
    ↓
empty ChangeTracker
```

---

# 37. Commit History After Loading

Commit history continues across save/load.

Example:

```text
Game before save:

Commit 1
...
Commit 80
```

Save.

Load.

The server still has:

```text
Commit 1
...
Commit 80
```

New synchronization produces:

```text
Commit 81
Commit 82
...
```

Commit numbering must not restart.

---

# 38. ACK / Reconnection Example

Complete example:

```text
SERVER
latestCommit = 30

Client A
lastAppliedCommit = 30

Client B
lastAppliedCommit = 27
(disconnected)
```

Server performs an operation:

```text
sendUpdate()
    ↓
Commit #31
```

Client A receives:

```text
31
```

Client B receives nothing because it is disconnected.

Another operation:

```text
sendUpdate()
    ↓
Commit #32
```

Client A receives:

```text
32
```

Commit history now contains:

```text
...
27
28
29
30
31
32
```

Client B reconnects:

```text
Client B:
lastAppliedCommit = 27
```

Server sends:

```text
28
29
30
31
32
```

Client B applies them sequentially.

Result:

```text
Client B:
lastAppliedCommit = 32
```

Both clients are synchronized.

---

# 39. Important Architectural Boundaries

## Server

The server is authoritative.

It decides:

- whether an action is legal
- what the actual game state becomes
- what changes are recorded
- when `sendUpdate()` is called
- commit numbering
- commit history
- recipient information

## Client

The client is a replica.

It is responsible for:

- receiving updates
- deserializing them
- maintaining `ClientWorld`
- rendering
- animation
- UI
- local selection
- visual previews

The client must not be trusted to determine authoritative game state.

---

# 40. Do Not Put Networking in Models

Models should not contain:

```text
socket
client connection
sendUpdate()
serialization
network token handling
```

Models represent game state.

Synchronization infrastructure should remain outside the domain models whenever practical.

---

# 41. Do Not Put Networking in ChangeTracker

`ChangeTracker` must remain a simple change-recording utility.

It should not know about:

```text
clients
connections
thread pools
serialization
commits
sockets
```

The intended relationship is:

```text
ChangeTracker
    ↓
Commit creation
    ↓
Network synchronization
```

not:

```text
ChangeTracker
    ↓
socket.send()
```

---

# 42. Expected Components

The implementation will likely require components conceptually equivalent to:

```text
ChangeTracker
Commit
CommitHistory
UpdateSerializer / SynchronizationSerializer
UpdateDispatcher
ClientWorld
ClientSynchronizationHandler
ServerSynchronizationHandler
```

These are conceptual responsibilities, not mandatory class names.

Before creating new classes, inspect the repository for existing classes that already provide equivalent functionality.

Do not duplicate existing infrastructure.

---

# 43. Existing Architecture Must Be Inspected First

Before implementing anything:

1. Inspect the existing server/client/network classes.
2. Inspect the existing EventBus and event system.
3. Inspect existing save/load functionality.
4. Inspect `Model` and all relevant records.
5. Inspect existing serialization mechanisms.
6. Inspect existing thread-pool/network code.
7. Inspect how `World` and `SuperWorld` are currently constructed.
8. Inspect where the current refresh event is triggered.
9. Inspect how client-side drawing and animation currently obtain state.

Do not replace existing infrastructure simply because a new design is possible.

Reuse compatible existing architecture.

---

# 44. Minimal-Change Rule

This synchronization implementation is part of the existing Civilization project.

Do not:

- rewrite unrelated classes
- redesign the entire game architecture
- change existing game logic unnecessarily
- replace working systems without reason
- introduce a new framework unnecessarily
- modify unrelated UI behavior
- change save/load semantics beyond what is required for commit persistence

Make the smallest coherent changes necessary.

---

# 45. Synchronization Invariants

The following must always remain true:

### Invariant 1

The server is authoritative.

### Invariant 2

Every connected client has a local copy of the game state.

### Invariant 3

The `SuperWorld.ChangeTracker` is the synchronization source.

### Invariant 4

Every non-empty `sendUpdate()` produces exactly one global commit.

### Invariant 5

A commit is immutable after creation.

### Invariant 6

All commits are retained for the lifetime of the game.

### Invariant 7

A client normally receives commits pushed by the server.

### Invariant 8

A reconnecting client reports its `lastAppliedCommit`.

### Invariant 9

A client never applies commits out of order.

### Invariant 10

A client only advances `lastAppliedCommit` after successfully applying the complete commit.

### Invariant 11

The commit contains all changes.

### Invariant 12

Recipient metadata determines which parts of a commit belong to a client.

### Invariant 13

Network worker threads must not directly mutate authoritative game state.

### Invariant 14

Saving commits pending changes first.

### Invariant 15

Commit numbering survives save/load.

---

# 46. Target End-to-End Flow

The final intended architecture is:

```text
                         SERVER
────────────────────────────────────────────────

                     Game Operation
                           │
                           ▼
                     Server Logic
                           │
                           ▼
                 World / SuperWorld
                           │
                           ▼
                  ChangeTracker
                           │
                           │ explicit
                           ▼
                     sendUpdate()
                           │
                           ▼
                    Create Commit
                           │
                  ┌────────┴────────┐
                  ▼                 ▼
            CommitHistory       Clear Tracker
                  │
                  ▼
          immutable Commit
                  │
                  ▼
             UpdateDispatcher
                  │
          ┌───────┼───────┐
          ▼       ▼       ▼
       Client A Client B Client C
          │       │       │
          ▼       ▼       ▼
       Network Network Network
```

Client side:

```text
                         CLIENT
────────────────────────────────────────────────

                     Network
                        │
                        ▼
                 Receive Commit
                        │
                        ▼
                   Deserialize
                        │
                        ▼
              Validate Commit ID
                        │
                        ▼
             Filter by recipient
                        │
                        ▼
                 Apply to ClientWorld
                        │
                        ▼
             lastAppliedCommit = N
                        │
                        ▼
                 Client EventBus
                        │
              ┌─────────┼─────────┐
              ▼         ▼         ▼
           Drawing   Animation     UI
```

Reconnect:

```text
Client
   │
   │ "lastAppliedCommit = N"
   ▼
Server
   │
   ├── commits available
   │
   ├── if incremental recovery possible
   │       ↓
   │   send N+1 ... latest
   │
   └── otherwise
           ↓
       fresh snapshot
```

This is the synchronization architecture to implement.