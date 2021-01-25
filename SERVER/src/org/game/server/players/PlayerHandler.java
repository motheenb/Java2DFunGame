package org.game.server.players;

import org.game.server.GameServer;

import java.net.Socket;

public class PlayerHandler {

    private final GameServer gameServer;

    public PlayerHandler(final GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public void acceptConnection(final Socket socket) {

    }

    public GameServer getGameServer() {
        return gameServer;
    }
}
