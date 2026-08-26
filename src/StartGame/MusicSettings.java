package StartGame;


public class MusicSettings {

    private boolean musicOn = true;
    private float volume = 0.7f; // 0.0 (silent) .. 1.0 (full)

    public boolean isMusicOn() {
        return musicOn;
    }

    public void toggleMusic() {
        musicOn = !musicOn;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = Math.max(0f, Math.min(1f, volume));
    }
}