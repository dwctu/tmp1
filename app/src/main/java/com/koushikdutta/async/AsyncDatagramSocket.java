package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class AsyncDatagramSocket extends AsyncNetworkSocket {
    public void connect(InetSocketAddress inetSocketAddress) throws IOException {
        this.socketAddress = inetSocketAddress;
        ((DatagramChannelWrapper) getChannel()).mChannel.connect(inetSocketAddress);
    }

    public void disconnect() throws IOException {
        this.socketAddress = null;
        ((DatagramChannelWrapper) getChannel()).disconnect();
    }

    @Override // com.koushikdutta.async.AsyncNetworkSocket
    public InetSocketAddress getRemoteAddress() {
        return isOpen() ? super.getRemoteAddress() : ((DatagramChannelWrapper) getChannel()).getRemoteAddress();
    }

    public void send(final String str, final int i, final ByteBuffer byteBuffer) throws InterruptedException, IOException {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new Runnable() { // from class: com.koushikdutta.async.AsyncDatagramSocket.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException, IOException {
                    AsyncDatagramSocket.this.send(str, i, byteBuffer);
                }
            });
        } else {
            try {
                ((DatagramChannelWrapper) getChannel()).mChannel.send(byteBuffer, new InetSocketAddress(str, i));
            } catch (IOException unused) {
            }
        }
    }

    public void send(final InetSocketAddress inetSocketAddress, final ByteBuffer byteBuffer) throws InterruptedException, IOException {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().run(new Runnable() { // from class: com.koushikdutta.async.AsyncDatagramSocket.2
                @Override // java.lang.Runnable
                public void run() throws InterruptedException, IOException {
                    AsyncDatagramSocket.this.send(inetSocketAddress, byteBuffer);
                }
            });
        } else {
            try {
                ((DatagramChannelWrapper) getChannel()).mChannel.send(byteBuffer, new InetSocketAddress(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
            } catch (IOException unused) {
            }
        }
    }
}
