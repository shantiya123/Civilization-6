package Game;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {

    private Clip clip;

    public void playLoop(String path) {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(path));

            clip = AudioSystem.getClip();
            clip.open(audioStream);


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
}
