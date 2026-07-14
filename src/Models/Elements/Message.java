package Models.Elements.Messages;

import Models.Draw.MessageDraw;
import Models.Elements.Showable;

public class Message implements Showable {

    private final String content;
    private final MessageDraw draw;

    // Position, size, and visual opacity
    private int x;
    private int y;
    private int size; // We'll map this to the visual height/width scale
    private float alpha = 0.0f;
    private boolean active = false;

    public Message(String content) {
        this.content = content;
        this.draw = new MessageDraw(this);
    }

    public String getContent() {
        return content;
    }

    public MessageDraw getDraw() {
        return draw;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    @Override
    public int getY() { return y; }

    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getSize() { return size; }

    @Override
    public void setSize(int size) { this.size = size; }
}