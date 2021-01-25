package org.game.server.players;

import java.net.Socket;

public class Player implements Runnable {

    private Thread playerThread = new Thread(this);
    //
    private final int clientID;
    private final Socket socket;
    //
    private int asbX, absY;
    private int deltaX, deltaY;

    public Player(final int clientID, final Socket socket) {
        this.clientID = clientID;
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public int getClientID() {
        return clientID;
    }

    public int getAbsY() {
        return absY;
    }

    public int getAsbX() {
        return asbX;
    }

    public void setAsbX(final int asbX) {
        this.asbX = asbX;
    }

    public void setAbsY(final int absY) {
        this.absY = absY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(final int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(final int deltaY) {
        this.deltaY = deltaY;
    }

    public Thread getPlayerThread() {
        return playerThread;
    }
}
