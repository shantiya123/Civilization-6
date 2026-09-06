package Game.Client.Views;

import Base.Network.LobbyChatMessage;
import Game.Client.Controllers.ChatController;

import javax.swing.*;
import java.awt.*;

/** Permanent TCP game chat. It renders messages only; the server owns identity and delivery. */
final class ChatPanel extends JPanel {
    static final int WIDTH = 330;
    static final int HEIGHT = 235;

    private final JTextArea transcript = new JTextArea();
    private final JTextField input = new JTextField();
    private final ChatController controller;
    private Runnable closeAction = () -> { };

    ChatPanel(ChatController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(6, 6));
        setOpaque(true);
        setBackground(new Color(24, 21, 17, 232));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(198, 165, 96), 2),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel title = new JLabel("PLAYER CHAT");
        title.setForeground(new Color(230, 214, 170));
        title.setFont(new Font("Serif", Font.BOLD, 14));
        JButton close = new JButton("×");
        close.setToolTipText("Close chat");
        close.setMargin(new Insets(0, 7, 0, 7));
        close.addActionListener(event -> closeAction.run());
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.add(title, BorderLayout.WEST);
        header.add(close, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        transcript.setEditable(false);
        transcript.setLineWrap(true);
        transcript.setWrapStyleWord(true);
        transcript.setForeground(new Color(238, 230, 207));
        transcript.setBackground(new Color(38, 33, 26));
        transcript.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(new JScrollPane(transcript), BorderLayout.CENTER);

        JButton send = new JButton("Send");
        send.addActionListener(event -> send());
        input.addActionListener(event -> send());
        JPanel composer = new JPanel(new BorderLayout(5, 0));
        composer.setOpaque(false);
        composer.add(input, BorderLayout.CENTER);
        composer.add(send, BorderLayout.EAST);
        add(composer, BorderLayout.SOUTH);
    }

    void receive(LobbyChatMessage message) {
        if (message == null || message.text() == null || message.text().isBlank()) return;
        transcript.append("[" + message.timestamp() + "] " + message.sender() + ": "
                + message.text() + "\n");
        transcript.setCaretPosition(transcript.getDocument().getLength());
    }

    void receiveSystemMessage(String text) {
        if (text == null || text.isBlank()) return;
        transcript.append("[Server] " + text + "\n");
        transcript.setCaretPosition(transcript.getDocument().getLength());
    }

    void setCloseAction(Runnable closeAction) {
        this.closeAction = closeAction == null ? () -> { } : closeAction;
    }

    private void send() {
        String text = input.getText();
        input.setText("");
        controller.send(text);
    }
}
