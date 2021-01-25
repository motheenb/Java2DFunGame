package org.game.client.players;

import org.game.client.GameClient;

import java.awt.*;

public class Player {

    private final GameClient gameClient;
    //
    private int absX, absY, dX, dY;

    public Player(final GameClient gameClient) {
        this.gameClient = gameClient;
        setCoords(30, 30);
    }

    public void paint(final Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(absX, absY, 5, 5);
        g.setColor(Color.BLACK);
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
}
