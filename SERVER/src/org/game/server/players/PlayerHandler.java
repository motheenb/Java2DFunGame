package org.game.server.players;

import org.game.server.Configs;
import org.game.server.GameServer;

import java.net.Socket;

public class PlayerHandler {

    private final GameServer gameServer;
    //
    private final Player players[] = new Player[Configs.MAX_PLAYERS];

    public PlayerHandler(final GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public void acceptConnection(final Socket socket) {
        GameServer.log("Incoming connection from: " + socket.getInetAddress());
        final int freeID = getFreePlayerID();
        players[freeID] = new Player(freeID, socket);
        players[freeID].getPlayerThread().start();
    }

    public int getFreePlayerID() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public Player[] getPlayers() {
        return players;
    }

    public GameServer getGameServer() {
        return gameServer;
    }
}
