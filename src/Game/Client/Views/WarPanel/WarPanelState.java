package Game.Client.Views.WarPanel;

import Game.Client.Controllers.WarController;
import Game.Server.Systems.EventSystem.Events.WarEvent;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.CombatUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * View model for the War Panel (battle report).
 *
 * Per DESIGN.md this is a panel-state class: it exposes display-ready values
 * and user-intent methods, and holds the corresponding controller reference.
 * {@link #confirmAttack()} and {@link #attackWall()} are the only user
 * intents backed by a real gameplay action, so those two delegate to
 * {@link WarController} (one system call each, no gameplay rules here).
 * {@link #retreat()} and {@link #closeReport()} dismiss the report without
 * changing any game state, so there is no system for them to call; that is
 * documented on each method rather than left as an unexplained TODO.
 *
 * {@link #fromWarEvent(WarEvent, WarController)} converts a real, already-resolved
 * {@code WarEvent} into display-ready fields, so the panel can show an actual
 * battle report instead of only sample data.
 */
public final class WarPanelState {

    /** Which kind of battle report this state currently describes. */
    public enum TargetType { UNIT, STRUCTURE, CAPTURED_EMPTY_HEX }

    /** Final result of the battle, mirrored in the outcome banner. */
    public enum Outcome {
        ATTACKER_WON("Attacker Won"),
        DEFENDER_WON("Defender Won"),
        DRAW("Draw"),
        TERRITORY_CAPTURED("Territory Captured");

        private final String label;

        Outcome(String label) { this.label = label; }

        public String getLabel() { return label; }
    }

    /** Which side a dice roll or unit summary row belongs to. */
    public enum Side { ATTACKER, DEFENDER }

    /** Before/after row for a single unit involved in the battle. */
    public static final class UnitBattleSummary {
        private final String unitTypeName;
        private final Side side;
        private final int hpBefore;
        private final int hpAfter;
        private final boolean defeated;

        public UnitBattleSummary(String unitTypeName, Side side, int hpBefore, int hpAfter, boolean defeated) {
            this.unitTypeName = unitTypeName;
            this.side = side;
            this.hpBefore = hpBefore;
            this.hpAfter = hpAfter;
            this.defeated = defeated;
        }

        public String getUnitTypeName() { return unitTypeName; }
        public Side getSide() { return side; }
        public int getHpBefore() { return hpBefore; }
        public int getHpAfter() { return hpAfter; }
        public boolean isDefeated() { return defeated; }
    }

    /** One contributor to structure damage when no dice are involved (wall/building/tribe camp). */
    public static final class StructureDamageEntry {
        private final String unitTypeName;
        private final int damage;

        public StructureDamageEntry(String unitTypeName, int damage) {
            this.unitTypeName = unitTypeName;
            this.damage = damage;
        }

        public String getUnitTypeName() { return unitTypeName; }
        public int getDamage() { return damage; }
    }

    private final WarController controller;

    private String attackerLabel;
    private String defenderLabel;
    private TargetType targetType;
    private Outcome outcome;

    // The pending/most recent command, needed by confirmAttack()/attackWall() to call the controller.
    private Hex offensiveHex;
    private Hex defensiveHex;

    // Dice-battle fields (used when targetType == UNIT).
    private List<Integer> attackerDice;
    private List<Integer> defenderDice;
    private int attackerHitsTaken;
    private int defenderHitsTaken;

    // Structure-attack fields (used when targetType == STRUCTURE).
    private String structureName;
    private int structureHpBefore;
    private int structureHpAfter;
    private List<StructureDamageEntry> structureDamageEntries;

    private List<UnitBattleSummary> unitSummaries;

    /** Demo/standalone constructor: no controller, sample data only. */
    public WarPanelState() {
        this(null);
    }

    /** Live constructor: {@code controller} may be null for a read-only report with no pending command. */
    public WarPanelState(WarController controller) {
        this.controller = controller;
        loadSampleDiceBattle();
    }

    /** Builds a fully real battle report from an already-resolved war command. */
    public static WarPanelState fromWarEvent(WarEvent event, WarController controller) {
        WarPanelState state = new WarPanelState(controller);
        state.applyWarEvent(event);
        return state;
    }

    /**
     * Prepares the state for a proposed attack the player has not confirmed yet, e.g. right after
     * picking an offensive/defensive hex pair on the board. Clears any stale dice/summary data
     * from a previous report so the panel shows a clean "awaiting confirmation" view.
     */
    public void proposeAttack(Hex offensiveHex, Hex defensiveHex, String attackerLabel, String defenderLabel) {
        this.offensiveHex = offensiveHex;
        this.defensiveHex = defensiveHex;
        this.attackerLabel = attackerLabel;
        this.defenderLabel = defenderLabel;
        this.targetType = TargetType.UNIT;
        this.outcome = null;
        this.attackerDice = List.of();
        this.defenderDice = List.of();
        this.attackerHitsTaken = 0;
        this.defenderHitsTaken = 0;
        this.structureName = null;
        this.structureDamageEntries = List.of();
        this.unitSummaries = List.of();
    }

    /** Replaces every display field with the real outcome of a resolved war command. */
    public void applyWarEvent(WarEvent event) {
        this.offensiveHex = event.offensiveHex();
        this.defensiveHex = event.defensiveHex();
        this.attackerLabel = event.attackerTribe() != null ? displayName(event.attackerTribe().getClass()) : "Player";
        this.defenderLabel = event.defenderTribe() != null ? displayName(event.defenderTribe().getClass()) : "Player";
        this.outcome = mapOutcome(event.outcome());

        switch (event.targetType()) {
            case COMBAT_UNITS -> applyDiceBattle(event);
            case WALL, CAMP, BUILDING -> applyStructureBattle(event);
            case CAPTURED_EMPTY_HEX -> applyCapturedEmptyHex();
        }
        this.unitSummaries = buildUnitSummaries(event);
    }

    private void applyDiceBattle(WarEvent event) {
        this.targetType = TargetType.UNIT;
        this.attackerDice = event.attackerDice();
        this.defenderDice = event.defenderDice();
        // The battle rule damages the defender for every attacker-favoring pair and the attacker
        // for every defender-favoring pair (see BattleManager.battle()), so the hits each side
        // *takes* are the other side's wins.
        this.defenderHitsTaken = event.attackerHits();
        this.attackerHitsTaken = event.defenderHits();
        this.structureName = null;
        this.structureDamageEntries = List.of();
    }

    private void applyStructureBattle(WarEvent event) {
        this.targetType = TargetType.STRUCTURE;
        this.attackerDice = List.of();
        this.defenderDice = List.of();
        this.attackerHitsTaken = 0;
        this.defenderHitsTaken = 0;
        this.structureName = switch (event.targetType()) {
            case WALL -> "Wall";
            case CAMP -> "Tribe Camp";
            case BUILDING -> "Building";
            default -> "Structure";
        };
        this.structureHpBefore = event.structureHpBefore();
        this.structureHpAfter = event.structureHpAfter();

        List<StructureDamageEntry> entries = new ArrayList<>();
        for (WarEvent.UnitSnapshot snapshot : event.unitsBefore()) {
            if (snapshot.hex() == event.offensiveHex() && snapshot.unit() instanceof CombatUnit combatUnit) {
                entries.add(new StructureDamageEntry(snapshot.unitType(), combatUnit.getCombatPower()));
            }
        }
        this.structureDamageEntries = entries;
    }

    private void applyCapturedEmptyHex() {
        this.targetType = TargetType.CAPTURED_EMPTY_HEX;
        this.attackerDice = List.of();
        this.defenderDice = List.of();
        this.attackerHitsTaken = 0;
        this.defenderHitsTaken = 0;
        this.structureName = null;
        this.structureDamageEntries = List.of();
    }

    private static List<UnitBattleSummary> buildUnitSummaries(WarEvent event) {
        List<UnitBattleSummary> summaries = new ArrayList<>();
        for (WarEvent.UnitSnapshot before : event.unitsBefore()) {
            WarEvent.UnitSnapshot after = event.unitsAfter().stream()
                    .filter(current -> current.unit() == before.unit())
                    .findFirst().orElse(null);
            boolean defeated = after == null;
            Side side = before.hex() == event.offensiveHex() ? Side.ATTACKER : Side.DEFENDER;
            int hpAfter = defeated ? 0 : after.hp();
            summaries.add(new UnitBattleSummary(before.unitType(), side, before.hp(), hpAfter, defeated));
        }
        return summaries;
    }

    private static Outcome mapOutcome(WarEvent.Outcome outcome) {
        return switch (outcome) {
            case ATTACKER_WON -> Outcome.ATTACKER_WON;
            case DEFENDER_WON -> Outcome.DEFENDER_WON;
            case DRAW -> Outcome.DRAW;
            case CAPTURED -> Outcome.TERRITORY_CAPTURED;
        };
    }

    private static String displayName(Class<?> type) {
        return type.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }

    /** Fills the state with a sample dice battle, mirroring the worked example in Phase2.md. */
    public void loadSampleDiceBattle() {
        this.attackerLabel = "Attacker";
        this.defenderLabel = "Barbarian Warband";
        this.targetType = TargetType.UNIT;
        this.attackerDice = List.of(6, 3, 1);
        this.defenderDice = List.of(5, 4);
        this.attackerHitsTaken = 1;
        this.defenderHitsTaken = 1;
        this.outcome = Outcome.DRAW;
        this.unitSummaries = List.of(
                new UnitBattleSummary("Swordsman", Side.ATTACKER, 1, 0, true),
                new UnitBattleSummary("Cavalry", Side.ATTACKER, 2, 2, false),
                new UnitBattleSummary("Archer", Side.DEFENDER, 1, 1, false),
                new UnitBattleSummary("Swordsman", Side.DEFENDER, 1, 0, true)
        );
        this.structureName = null;
        this.structureDamageEntries = List.of();
    }

    /** Fills the state with a sample structure attack (no dice), e.g. attacking a wall or tribe camp. */
    public void loadSampleStructureBattle() {
        this.attackerLabel = "Attacker";
        this.defenderLabel = "Tribe Camp";
        this.targetType = TargetType.STRUCTURE;
        this.structureName = "Warrior Tribe Camp";
        this.structureHpBefore = 70;
        List<StructureDamageEntry> entries = new ArrayList<>();
        entries.add(new StructureDamageEntry("Swordsman", 10));
        entries.add(new StructureDamageEntry("Cavalry", 8));
        entries.add(new StructureDamageEntry("Catapult", 20));
        this.structureDamageEntries = entries;
        int totalDamage = entries.stream().mapToInt(StructureDamageEntry::getDamage).sum();
        this.structureHpAfter = Math.max(0, structureHpBefore - totalDamage);
        this.outcome = structureHpAfter == 0 ? Outcome.TERRITORY_CAPTURED : Outcome.ATTACKER_WON;
        this.unitSummaries = List.of(
                new UnitBattleSummary("Swordsman", Side.ATTACKER, 1, 1, false),
                new UnitBattleSummary("Cavalry", Side.ATTACKER, 2, 2, false),
                new UnitBattleSummary("Catapult", Side.ATTACKER, 1, 1, false)
        );
        this.attackerDice = List.of();
        this.defenderDice = List.of();
        this.attackerHitsTaken = 0;
        this.defenderHitsTaken = 0;
    }

    public String getAttackerLabel() { return attackerLabel; }
    public void setAttackerLabel(String attackerLabel) { this.attackerLabel = attackerLabel; }

    public String getDefenderLabel() { return defenderLabel; }
    public void setDefenderLabel(String defenderLabel) { this.defenderLabel = defenderLabel; }

    public TargetType getTargetType() { return targetType; }
    public void setTargetType(TargetType targetType) { this.targetType = targetType; }

    public Outcome getOutcome() { return outcome; }
    public void setOutcome(Outcome outcome) { this.outcome = outcome; }

    public Hex getOffensiveHex() { return offensiveHex; }
    public Hex getDefensiveHex() { return defensiveHex; }

    public List<Integer> getAttackerDice() { return attackerDice; }
    public void setAttackerDice(List<Integer> attackerDice) { this.attackerDice = attackerDice; }

    public List<Integer> getDefenderDice() { return defenderDice; }
    public void setDefenderDice(List<Integer> defenderDice) { this.defenderDice = defenderDice; }

    public int getAttackerHitsTaken() { return attackerHitsTaken; }
    public void setAttackerHitsTaken(int attackerHitsTaken) { this.attackerHitsTaken = attackerHitsTaken; }

    public int getDefenderHitsTaken() { return defenderHitsTaken; }
    public void setDefenderHitsTaken(int defenderHitsTaken) { this.defenderHitsTaken = defenderHitsTaken; }

    public String getStructureName() { return structureName; }
    public void setStructureName(String structureName) { this.structureName = structureName; }

    public int getStructureHpBefore() { return structureHpBefore; }
    public void setStructureHpBefore(int structureHpBefore) { this.structureHpBefore = structureHpBefore; }

    public int getStructureHpAfter() { return structureHpAfter; }
    public void setStructureHpAfter(int structureHpAfter) { this.structureHpAfter = structureHpAfter; }

    public List<StructureDamageEntry> getStructureDamageEntries() { return structureDamageEntries; }
    public void setStructureDamageEntries(List<StructureDamageEntry> structureDamageEntries) {
        this.structureDamageEntries = structureDamageEntries;
    }

    public List<UnitBattleSummary> getUnitSummaries() { return unitSummaries; }
    public void setUnitSummaries(List<UnitBattleSummary> unitSummaries) { this.unitSummaries = unitSummaries; }

    /**
     * User intent: confirm and carry out the proposed attack. Delegates to
     * {@link WarController#attack(Hex, Hex)}; the real dice, hits, and HP changes arrive on the
     * {@code WarEvent} this publishes, and {@link #applyWarEvent(WarEvent)} should be called with
     * it afterward to refresh this same report with the real outcome.
     */
    public void confirmAttack() {
        if (controller == null || offensiveHex == null || defensiveHex == null) return;
        controller.attack(offensiveHex, defensiveHex);
    }

    /**
     * User intent: attack only the wall standing between the two hexes, without engaging any
     * defenders behind it. Delegates to {@link WarController#attackWall(Hex, Hex)}.
     */
    public void attackWall() {
        if (controller == null || offensiveHex == null || defensiveHex == null) return;
        controller.attackWall(offensiveHex, defensiveHex);
    }

    /**
     * User intent: retreat instead of carrying out the proposed attack. Retreating means the
     * attack is simply never issued, so there is no system call to make; this only clears the
     * pending command.
     */
    public void retreat() {
        this.offensiveHex = null;
        this.defensiveHex = null;
    }

    /**
     * User intent: dismiss the battle report. This is a UI-only action (closing the panel/dialog
     * that hosts it) with no corresponding game-state change, so there is no system to call.
     */
    public void closeReport() {
        // Intentionally empty: dismissing the report changes no game state.
    }
}