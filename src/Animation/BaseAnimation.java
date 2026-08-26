package Animation;

public abstract class BaseAnimation {
    protected final int totalSteps;
    protected int currentStep = 0;
    private boolean finished = false;
    private boolean cancelled = false;
    private Runnable completionCallback;

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }


    public boolean step() {
        if (finished || cancelled) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
            if (completionCallback != null) completionCallback.run();
        }
        return !finished;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }
    public void setCompletionCallback(Runnable completionCallback) { this.completionCallback = completionCallback; }


    public boolean isAmbient() {
        return false;
    }

    protected abstract void onTick(double progress);
    protected void onComplete() {}
}
