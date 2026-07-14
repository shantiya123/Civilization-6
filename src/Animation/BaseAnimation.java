package Animation;

public abstract class BaseAnimation {
    protected final int totalSteps;
    protected int currentStep = 0;
    private boolean finished = false;
    private boolean cancelled = false;

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    /**
     * Process a single tick. Returns false when finished or cancelled.
     */
    public boolean step() {
        if (finished || cancelled) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
        }
        return !finished;
    }

    /** Stops this animation immediately without running onComplete — used when a newer animation supersedes it. */
    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    protected abstract void onTick(double progress);
    protected void onComplete() {}
}