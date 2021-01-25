package org.game.client.io;

import org.game.client.GameClient;

import java.io.IOException;
import java.net.Socket;

public class GameSocket implements Runnable{

    private Socket socket;
    //
    private final GameClient gameClient;
    //
    private final Thread socketThread = new Thread(this);

    public GameSocket(final GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public boolean connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 43594);
            socketThread.start();
            return true;
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            gameClient.getPlayer().process();
        }
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public Socket getSocket() {
        return socket;
    }

    public Thread getSocketThread() {
        return socketThread;
    }
}
