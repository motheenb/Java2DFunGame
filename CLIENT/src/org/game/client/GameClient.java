package org.game.client;

import org.game.client.io.GameSocket;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JFrame {

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
        gfx.clearRect(0, 0, 500, 500);
        //
        g.drawImage(img, 0, 0, this);
    }

    public void createGUI() {
        setTitle(Configs.NAME);
        setSize(Configs.WIDTH, Configs.HEIGHT);
        setVisible(true);
        setResizable(false);
        img = createImage(Configs.WIDTH, Configs.HEIGHT);
        gfx = img.getGraphics();
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

}
