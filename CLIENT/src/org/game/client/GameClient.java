package org.game.client;

import org.game.client.input.InputHandler;
import org.game.client.io.GameSocket;
import org.game.client.players.Player;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JFrame {

    private final InputHandler inputHandler = new InputHandler(this);
    //
    private Player player = new Player(this);
    //
    private GameSocket gameSocket = new GameSocket(this);
    //
    private Image img;
    private Graphics gfx;

    public GameClient() {
        if (gameSocket.connectToServer()) {
            createGUI();
        }
    }

    public void paint(final Graphics g) {
        if (img == null) {
            return;
        }
        gfx.clearRect(0, 0, Configs.WIDTH, Configs.HEIGHT);
        player.paint(gfx);
        g.drawImage(img, 0, 0, this);
        repaint();
    }

    public void createGUI() {
        setTitle(Configs.NAME);
        setSize(Configs.WIDTH, Configs.HEIGHT);
        setVisible(true);
        setResizable(false);
        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addKeyListener(inputHandler);
        img = createImage(Configs.WIDTH, Configs.HEIGHT);
        gfx = img.getGraphics();
    }

    public static void log(final Object o) {
        System.out.println(o);
    }

    public GameSocket getGameSocket() {
        return gameSocket;
    }

    public Image getImg() {
        return img;
    }

    public Graphics getGfx() {
        return gfx;
    }

    public static void main(final String...args) {
        new GameClient();
    }

    public Player getPlayer() {
        return player;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}
