package org.game.client.input;

import org.game.client.GameClient;

import java.awt.event.*;

public class InputHandler implements MouseListener, MouseMotionListener, KeyListener {

    private final GameClient gameClient;

    public InputHandler(final GameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        GameClient.log("Key Code: " + e.getKeyCode());
        final int keyCode = e.getKeyCode();
        if (keyCode == 87) {
           gameClient.getPlayer().setCoords(gameClient.getPlayer().getAbsX(), (gameClient.getPlayer().getAbsY() - 3));
        } else if (keyCode == 83) {
           gameClient.getPlayer().setCoords(gameClient.getPlayer().getAbsX(), (gameClient.getPlayer().getAbsY() + 3));
        } else if (keyCode == 65) {
            gameClient.getPlayer().setCoords(gameClient.getPlayer().getAbsX() - 3, (gameClient.getPlayer().getAbsY()));
        } else if (keyCode == 68) {
            gameClient.getPlayer().setCoords(gameClient.getPlayer().getAbsX() + 3, (gameClient.getPlayer().getAbsY()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public GameClient getGameClient() {
        return gameClient;
    }
}
