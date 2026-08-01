package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.Event;

import java.util.*;
import java.util.function.Consumer;

/**
 * Central communication hub between game systems.
 *
 * Systems publish events when something has already happened.
 * Other systems subscribe to event types they are interested in.
 *
 * The bus is synchronous: listeners are called immediately
 * in the order they were registered.
 */
public class EventBus {

    private final Map<Class<? extends Event>, List<Consumer<? extends Event>>> listeners;

    public EventBus() {
        this.listeners = new HashMap<>();
    }

    /**
     * Register a listener for a specific event type.
     */
    public <T extends Event> void subscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(listener);
    }

    /**
     * Remove a previously registered listener.
     */
    public <T extends Event> void unsubscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * Broadcast an event to all subscribers of that event type.
     */
    @SuppressWarnings("unchecked")
    public <T extends Event> void publish(T event) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(event.getClass());

        if (eventListeners == null) {
            return;
        }

        for (Consumer<? extends Event> listener : eventListeners) {
            ((Consumer<T>) listener).accept(event);
        }
    }

    /**
     * Remove all registered listeners.
     * Useful when resetting or loading a game.
     */
    public void clear() {
        listeners.clear();
    }
}