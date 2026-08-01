package Game.Systems.EventSystem.Events;

/** Published by WorkSystem when a worker action cannot be performed. */
public class WorkerActionFailedEvent implements Event {
    private String reason;

    public WorkerActionFailedEvent(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
