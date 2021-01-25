package org.game.server.io;

import org.game.server.io.utils.PacketBuffer;
import org.game.server.players.Player;

public class PacketHandler {

    private final Player player;

    public PacketHandler(final Player player) {
        this.player = player;
    }

    public void handlePacket(final PacketBuffer packetBuffer) {
        if (packetBuffer == null) {
            return;
        }
    }

    public Player getPlayer() {
        return player;
    }
}
