package org.game.server;

import org.game.server.players.PlayerHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class GameServer implements Runnable {

    private Thread serverThread = new Thread(this);
    //
    private final int port;
    private ServerSocket serverSocket;
    //
    private final PlayerHandler clientHandler = new PlayerHandler(this);

    public GameServer(final int port) {
        this.port = port;
        try {
            log("Server listening on port: " + port);
            serverSocket = new ServerSocket(this.port);
            serverThread.start();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                clientHandler.acceptConnection(serverSocket.accept());
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopListening() {
        try {
            serverSocket.close();
            serverSocket = null;
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(final Object o) {
        System.out.println(o);
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

    public PlayerHandler getClientHandler() {
        return clientHandler;
    }
}
