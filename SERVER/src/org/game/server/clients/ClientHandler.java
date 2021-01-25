package org.game.server.clients;

import org.game.server.GameServer;

public class ClientHandler {

    private final GameServer gameServer;

    public ClientHandler(final GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public GameServer getGameServer() {
        return gameServer;
    }
}
