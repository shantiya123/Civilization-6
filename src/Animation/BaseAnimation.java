package Animation;

public abstract class BaseAnimation {
    protected final int totalSteps;
    protected int currentStep = 0;
    private boolean finished = false;

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    /**
     * Process a single tick. Returns false when finished.
     */
    public boolean step() {
        if (finished) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        // Perform calculation step
        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
        }
        return !finished;
    }

    protected abstract void onTick(double progress);
    protected void onComplete() {}
}