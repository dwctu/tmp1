package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* loaded from: classes3.dex */
public abstract class ChannelWrapper implements ReadableByteChannel, ScatteringByteChannel {
    private AbstractSelectableChannel mChannel;

    public ChannelWrapper(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.mChannel = abstractSelectableChannel;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mChannel.close();
    }

    public abstract InetAddress getLocalAddress();

    public abstract int getLocalPort();

    public abstract Object getSocket();

    public boolean isChunked() {
        return false;
    }

    public abstract boolean isConnected();

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mChannel.isOpen();
    }

    public abstract SelectionKey register(Selector selector) throws ClosedChannelException;

    public SelectionKey register(Selector selector, int i) throws ClosedChannelException {
        return this.mChannel.register(selector, i);
    }

    public abstract void shutdownInput();

    public abstract void shutdownOutput();

    public abstract int write(ByteBuffer byteBuffer) throws IOException;

    public abstract int write(ByteBuffer[] byteBufferArr) throws IOException;
}
