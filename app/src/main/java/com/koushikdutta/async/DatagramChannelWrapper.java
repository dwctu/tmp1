package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* loaded from: classes3.dex */
public class DatagramChannelWrapper extends ChannelWrapper {
    public InetSocketAddress address;
    public DatagramChannel mChannel;

    public DatagramChannelWrapper(DatagramChannel datagramChannel) throws IOException {
        super(datagramChannel);
        this.mChannel = datagramChannel;
    }

    public void disconnect() throws IOException {
        this.mChannel.disconnect();
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public InetAddress getLocalAddress() {
        return this.mChannel.socket().getLocalAddress();
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public int getLocalPort() {
        return this.mChannel.socket().getLocalPort();
    }

    public InetSocketAddress getRemoteAddress() {
        return this.address;
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public Object getSocket() {
        return this.mChannel.socket();
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public boolean isChunked() {
        return true;
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public boolean isConnected() {
        return this.mChannel.isConnected();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (isConnected()) {
            this.address = null;
            return this.mChannel.read(byteBuffer);
        }
        int iPosition = byteBuffer.position();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.mChannel.receive(byteBuffer);
        this.address = inetSocketAddress;
        if (inetSocketAddress == null) {
            return -1;
        }
        return byteBuffer.position() - iPosition;
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public SelectionKey register(Selector selector, int i) throws ClosedChannelException {
        return this.mChannel.register(selector, i);
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public void shutdownInput() {
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public void shutdownOutput() {
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.mChannel.write(byteBuffer);
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public SelectionKey register(Selector selector) throws ClosedChannelException {
        return register(selector, 1);
    }

    @Override // com.koushikdutta.async.ChannelWrapper
    public int write(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.mChannel.write(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.mChannel.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        return this.mChannel.read(byteBufferArr, i, i2);
    }
}
