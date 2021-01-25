package org.game.client.players;

import org.game.client.Configs;
import org.game.client.GameClient;
import org.game.client.sprites.Sprite;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Player {

    private Sprite sprite;
    //
    private final GameClient gameClient;
    //
    private int absX, absY, dX, dY;

    public Player(final GameClient gameClient) {
        this.gameClient = gameClient;
        sprite = new Sprite(Sprite.loadSprite("player.png"));
        setCoords(35, 435);
    }

    public void paint(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        final double angle = Math.atan2(absY - Configs.MOUSE_Y, absX - Configs.MOUSE_X) - Math.PI / 2;
        g2d.rotate(angle, absX, absY);
        g2d.drawImage(sprite.get(), absX-16, absY-16, null);
    }

    public void process() {

    }

    public void translate(final int dX, final int dY) {
        if (dX > absX) {
            absX++;
        } else if (dX < absX) {
            absX--;
        } else if (dY > absY) {
            absY++;
        } else if (dY < absY) {
            absY--;
        }
    }

    public void setCoords(final int absX, final int absY) {
        this.absX = absX;
        this.absY = absY;
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(final int dY) {
        this.dY = dY;
    }

    public int getdX() {
        return dX;
    }

    public void setdX(final int dX) {
        this.dX = dX;
    }

    public int getAbsY() {
        return absY;
    }

    public void setAbsY(final int absY) {
        this.absY = absY;
    }

    public int getAbsX() {
        return absX;
    }

    public void setAbsX(final int absX) {
        this.absX = absX;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
