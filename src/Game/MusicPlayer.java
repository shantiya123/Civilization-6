package Game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class MusicPlayer {

    private Clip clip;
    private FloatControl gainControl;
    private FloatControl volumeControl;
    private float pendingVolume = 0.7f;

    public void playLoop(String classpathPath) {
        try (InputStream raw = MusicPlayer.class.getResourceAsStream(classpathPath)) {
            if (raw == null) {
                System.err.println("MusicPlayer: resource not found on classpath: " + classpathPath);
                return;
            }
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new BufferedInputStream(raw));

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            gainControl = null;
            volumeControl = null;
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            } else if (clip.isControlSupported(FloatControl.Type.VOLUME)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
            }
            applyVolume(pendingVolume);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void setVolume(float linear) {
        pendingVolume = Math.max(0f, Math.min(1f, linear));
        applyVolume(pendingVolume);
    }

    private void applyVolume(float linear) {
        float clamped = Math.max(0.0001f, Math.min(1f, linear));
        if (gainControl != null) {
            float dB = (float) (Math.log10(clamped) * 20.0);
            dB = Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), dB));
            gainControl.setValue(dB);
        } else if (volumeControl != null) {
            float value = volumeControl.getMinimum() + clamped * (volumeControl.getMaximum() - volumeControl.getMinimum());
            volumeControl.setValue(value);
        }
    }
}