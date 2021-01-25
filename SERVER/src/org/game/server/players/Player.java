package org.game.server.players;

import java.net.Socket;

public class Player implements Runnable {

    private final int clientID;
    private final Socket socket;

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
}
