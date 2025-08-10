package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/* loaded from: classes3.dex */
public class AsyncNetworkSocket implements AsyncSocket {
    public Allocator allocator;
    public boolean closeReported;
    private ChannelWrapper mChannel;
    public CompletedCallback mClosedHander;
    private CompletedCallback mCompletedCallback;
    public DataCallback mDataHandler;
    public boolean mEndReported;
    private SelectionKey mKey;
    public Exception mPendingEndException;
    private AsyncServer mServer;
    public WritableCallback mWriteableHandler;
    public InetSocketAddress socketAddress;
    private ByteBufferList pending = new ByteBufferList();
    public boolean mPaused = false;

    private void closeInternal() {
        this.mKey.cancel();
        try {
            this.mChannel.close();
        } catch (IOException unused) {
        }
    }

    private void handleRemaining(int i) throws IOException {
        if (!this.mKey.isValid()) {
            throw new IOException(new CancelledKeyException());
        }
        if (i > 0) {
            SelectionKey selectionKey = this.mKey;
            selectionKey.interestOps(selectionKey.interestOps() | 4);
        } else {
            SelectionKey selectionKey2 = this.mKey;
            selectionKey2.interestOps(selectionKey2.interestOps() & (-5));
        }
    }

    private void spitPending() {
        if (this.pending.hasRemaining()) {
            Util.emitAllData(this, this.pending);
        }
    }

    public void attach(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) throws IOException {
        this.socketAddress = inetSocketAddress;
        this.allocator = new Allocator();
        this.mChannel = new SocketChannelWrapper(socketChannel);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        closeInternal();
        reportClose(null);
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.mChannel.shutdownOutput();
    }

    public ChannelWrapper getChannel() {
        return this.mChannel;
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.mClosedHander;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.mDataHandler;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.mCompletedCallback;
    }

    public InetAddress getLocalAddress() {
        return this.mChannel.getLocalAddress();
    }

    public int getLocalPort() {
        return this.mChannel.getLocalPort();
    }

    public InetSocketAddress getRemoteAddress() {
        return this.socketAddress;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mServer;
    }

    public Object getSocket() {
        return getChannel().getSocket();
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.mWriteableHandler;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.mChannel.isChunked();
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.mChannel.isConnected() && this.mKey.isValid();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.mPaused;
    }

    public void onDataWritable() {
        if (!this.mChannel.isChunked()) {
            SelectionKey selectionKey = this.mKey;
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
        }
        WritableCallback writableCallback = this.mWriteableHandler;
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }

    public int onReadable() {
        long j;
        int i;
        spitPending();
        boolean z = false;
        if (this.mPaused) {
            return 0;
        }
        ByteBuffer byteBufferAllocate = this.allocator.allocate();
        try {
            j = this.mChannel.read(byteBufferAllocate);
        } catch (Exception e) {
            closeInternal();
            reportEndPending(e);
            reportClose(e);
            j = -1;
        }
        if (j < 0) {
            closeInternal();
            z = true;
            i = 0;
        } else {
            i = (int) (0 + j);
        }
        if (j > 0) {
            this.allocator.track(j);
            byteBufferAllocate.flip();
            this.pending.add(byteBufferAllocate);
            Util.emitAllData(this, this.pending);
        } else {
            ByteBufferList.reclaim(byteBufferAllocate);
        }
        if (z) {
            reportEndPending(null);
            reportClose(null);
        }
        return i;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() throws InterruptedException {
        if (this.mServer.getAffinity() != Thread.currentThread()) {
            this.mServer.run(new Runnable() { // from class: com.koushikdutta.async.AsyncNetworkSocket.2
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    AsyncNetworkSocket.this.pause();
                }
            });
        } else {
            if (this.mPaused) {
                return;
            }
            this.mPaused = true;
            try {
                SelectionKey selectionKey = this.mKey;
                selectionKey.interestOps(selectionKey.interestOps() & (-2));
            } catch (Exception unused) {
            }
        }
    }

    public void reportClose(Exception exc) {
        if (this.closeReported) {
            return;
        }
        this.closeReported = true;
        CompletedCallback completedCallback = this.mClosedHander;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
            this.mClosedHander = null;
        }
    }

    public void reportEnd(Exception exc) {
        if (this.mEndReported) {
            return;
        }
        this.mEndReported = true;
        CompletedCallback completedCallback = this.mCompletedCallback;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public void reportEndPending(Exception exc) {
        if (this.pending.hasRemaining()) {
            this.mPendingEndException = exc;
        } else {
            reportEnd(exc);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() throws InterruptedException {
        if (this.mServer.getAffinity() != Thread.currentThread()) {
            this.mServer.run(new Runnable() { // from class: com.koushikdutta.async.AsyncNetworkSocket.3
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    AsyncNetworkSocket.this.resume();
                }
            });
            return;
        }
        if (this.mPaused) {
            this.mPaused = false;
            try {
                SelectionKey selectionKey = this.mKey;
                selectionKey.interestOps(selectionKey.interestOps() | 1);
            } catch (Exception unused) {
            }
            spitPending();
            if (isOpen()) {
                return;
            }
            reportEndPending(this.mPendingEndException);
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.mClosedHander = completedCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.mDataHandler = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.mCompletedCallback = completedCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.mWriteableHandler = writableCallback;
    }

    public void setup(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.mServer = asyncServer;
        this.mKey = selectionKey;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(final ByteBufferList byteBufferList) throws InterruptedException {
        if (this.mServer.getAffinity() != Thread.currentThread()) {
            this.mServer.run(new Runnable() { // from class: com.koushikdutta.async.AsyncNetworkSocket.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    AsyncNetworkSocket.this.write(byteBufferList);
                }
            });
            return;
        }
        if (this.mChannel.isConnected()) {
            try {
                int iRemaining = byteBufferList.remaining();
                ByteBuffer[] allArray = byteBufferList.getAllArray();
                this.mChannel.write(allArray);
                byteBufferList.addAll(allArray);
                handleRemaining(byteBufferList.remaining());
                this.mServer.onDataSent(iRemaining - byteBufferList.remaining());
            } catch (IOException e) {
                closeInternal();
                reportEndPending(e);
                reportClose(e);
            }
        }
    }

    public void attach(DatagramChannel datagramChannel) throws IOException {
        this.mChannel = new DatagramChannelWrapper(datagramChannel);
        this.allocator = new Allocator(8192);
    }
}
