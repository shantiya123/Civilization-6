package Animation;

public class MessageAnimation extends BaseAnimation{
    private String message;

    public MessageAnimation(int totalSteps , String message) {
        super(totalSteps);
    }

    @Override
    protected void onTick(double progress) {

    }

    @Override
    protected void onComplete() {
        super.onComplete();
    }
}
