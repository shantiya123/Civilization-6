package Animation;

public abstract class Animation {

    protected int totalSteps;
    protected int currentStep;
    protected Thread animationThread;

    protected abstract boolean timerStopper();
    public abstract void StartAnimation();

    public void stopAnimation() {
        if (animationThread != null && animationThread.isAlive()) {
            animationThread.interrupt();
        }
    }

    public boolean isRunning() {
        return animationThread != null && animationThread.isAlive();
    }

    protected double getProgress() {
        return (double) currentStep / totalSteps;
    }
}