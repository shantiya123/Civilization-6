package StartGame;

/**
 * Shared music on/off + volume state. Create exactly one instance
 * (in Generate/Main, wherever your app wiring starts) and hand the
 * SAME instance to both StartGameState and HUDState — there's only
 * one MusicPlayer/Clip actually playing, so there should only be
 * one source of truth for what it's set to.
 */
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