package org.game.client.io.utils;

/**
 *
 * @author Motheen Baig
 *
 */
public class PacketBuffer {

    private byte buffer[];
    private int bufferSize;
    private int bufferOffset = 0;

    public PacketBuffer(final int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer = new byte[this.bufferSize];
        this.bufferOffset = 0;
    }

    public PacketBuffer(final byte buffer[]) {
        this.buffer = buffer;
        this.bufferOffset = 0;
    }

    public void skip(final int i) {
        bufferOffset += i;
    }

    public void writeQWord(final long l) {
        ensureBufferSize(8);
        buffer[bufferOffset++] = (byte) (int) (l >> 56);
        buffer[bufferOffset++] = (byte) (int) (l >> 48);
        buffer[bufferOffset++] = (byte) (int) (l >> 40);
        buffer[bufferOffset++] = (byte) (int) (l >> 32);
        buffer[bufferOffset++] = (byte) (int) (l >> 24);
        buffer[bufferOffset++] = (byte) (int) (l >> 16);
        buffer[bufferOffset++] = (byte) (int) (l >> 8);
        buffer[bufferOffset++] = (byte) (int) l;
    }

    public long readQWord() {
        long l = (long) readDWord() & 0xffffffffL;
        long l1 = (long) readDWord() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public void writeDWord(final int i) {
        ensureBufferSize(4);
        buffer[bufferOffset++] = (byte) (i >> 24);
        buffer[bufferOffset++] = (byte) (i >> 16);
        buffer[bufferOffset++] = (byte) (i >> 8);
        buffer[bufferOffset++] = (byte) i;
    }

    public int readDWord() {
        bufferOffset += 4;
        final int dWord = ((buffer[bufferOffset - 4] & 0xff) << 24)
                + ((buffer[bufferOffset - 3] & 0xff) << 16)
                + ((buffer[bufferOffset - 2] & 0xff) << 8)
                + (buffer[bufferOffset - 1] & 0xff);
        return dWord;
    }


    public void writeByte(final int b) {
        ensureBufferSize(1);
        buffer[bufferOffset++] = (byte) b;
    }

    public byte readSignedByte() {
        return buffer[bufferOffset++];
    }

    public void ensureBufferSize(final int len) {
        byte oldBuffer[];
        int newLength;
        if ((bufferOffset + len + 1) >= buffer.length) {
            oldBuffer = buffer;
            newLength = (buffer.length * 2);
            buffer = new byte[newLength];
            System.arraycopy(oldBuffer, 0, buffer, 0, oldBuffer.length);
            ensureBufferSize(len);
        }
    }

    public byte[] getBuffer() {
        return buffer;
    }

}