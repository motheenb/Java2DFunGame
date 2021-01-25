package org.game.server.io.utils;

import org.game.server.GameServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Streams {

    private final Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;

    public Streams(final Socket socket) {
        this.socket = socket;
    }

    public static Streams open(final Socket socket) {
        final Streams streams = new Streams(socket);
        try {
            streams.outputStream = new DataOutputStream(socket.getOutputStream());
            streams.inputStream = new DataInputStream(socket.getInputStream());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return streams;
    }

    public PacketBuffer pullPacket() {
        int packetSize = -1;
        byte byteBuffer[] = null;
        try {
            packetSize = inputStream.readInt();
            GameServer.log("Packet Size: " + packetSize);
            if (packetSize > -1) {
                byteBuffer = new byte[packetSize];
                inputStream.readFully(byteBuffer);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return new PacketBuffer(byteBuffer);
    }

    public void pushPacket(final PacketBuffer packetBuffer) {
        if (packetBuffer == null) {
            return;
        }
        try {
            outputStream.writeInt(packetBuffer.getBuffer().length);
            outputStream.write(packetBuffer.getBuffer());
        } catch (final IOException e) {
            GameServer.log("Error pushing packet !");
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public DataInputStream getInputStream() {
        return inputStream;
    }

}
