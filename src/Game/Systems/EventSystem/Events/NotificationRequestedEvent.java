package Game.Systems.EventSystem.Events;

/** Published when the presentation layer should display a player-facing message. */
public class NotificationRequestedEvent implements Event {
    private String message;

    public NotificationRequestedEvent(String message) { this.message = message; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
