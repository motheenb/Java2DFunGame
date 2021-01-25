package org.game.server;

import java.io.IOException;
import java.net.ServerSocket;

public class GameServer implements Runnable {

    private Thread serverThread = new Thread(this);
    //
    private final int port;
    private ServerSocket serverSocket;

    public GameServer(final int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(this.port);
            serverThread.start();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {

        }
    }

    public static void main(final String...args) {
        new GameServer(43594);
    }

    public int getPort() {
        return port;
    }

    public Thread getServerThread() {
        return serverThread;
    }
}
