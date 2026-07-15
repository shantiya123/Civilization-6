package StartGame;

import Game.Generate;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartGamePanel extends JPanel {

    private static Image backgroundImage;

    static {
        backgroundImage = ImageLoader.load("/Images/ChatGPT Image Jul 14, 2026, 10_23_30 PM.png");
    }
    private final VolumeSlider volumeSlider;
    private final MusicToggleButton musicToggleButton;
    private final StartButton startButton;

    public StartGamePanel(StartGameState state) {
        setLayout(null);
        setOpaque(false);

        musicToggleButton = new MusicToggleButton(state);
        startButton = new StartButton(state);

        add(musicToggleButton);
        add(startButton);
        volumeSlider = new VolumeSlider(state.getMusicSettings(), v -> Generate.getGame().getMusicPlayer().setVolume(v));
        add(volumeSlider);
    }

    public MusicToggleButton getMusicToggleButton() {
        return musicToggleButton;
    }

    public StartButton getStartButton() {
        return startButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2.setPaint(new GradientPaint(0, 0, new Color(15, 13, 10), 0, getHeight(), new Color(35, 30, 24)));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }
    public VolumeSlider getVolumeSlider() {
        return volumeSlider;
    }
}