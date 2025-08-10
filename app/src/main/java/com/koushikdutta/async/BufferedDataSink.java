package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;

/* loaded from: classes3.dex */
public class BufferedDataSink implements DataSink {
    public boolean endPending;
    public boolean forceBuffering;
    public DataSink mDataSink;
    public WritableCallback mWritable;
    public final ByteBufferList mPendingWrites = new ByteBufferList();
    public int mMaxBuffer = Integer.MAX_VALUE;

    public BufferedDataSink(DataSink dataSink) {
        setDataSink(dataSink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePending() {
        boolean zIsEmpty;
        WritableCallback writableCallback;
        if (this.forceBuffering) {
            return;
        }
        synchronized (this.mPendingWrites) {
            this.mDataSink.write(this.mPendingWrites);
            zIsEmpty = this.mPendingWrites.isEmpty();
        }
        if (zIsEmpty && this.endPending) {
            this.mDataSink.end();
        }
        if (!zIsEmpty || (writableCallback = this.mWritable) == null) {
            return;
        }
        writableCallback.onWriteable();
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().post(new Runnable() { // from class: dc.t81
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.end();
                }
            });
            return;
        }
        synchronized (this.mPendingWrites) {
            if (this.mPendingWrites.hasRemaining()) {
                this.endPending = true;
            } else {
                this.mDataSink.end();
            }
        }
    }

    public void forceBuffering(boolean z) {
        this.forceBuffering = z;
        if (z) {
            return;
        }
        writePending();
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.mDataSink.getClosedCallback();
    }

    public DataSink getDataSink() {
        return this.mDataSink;
    }

    public int getMaxBuffer() {
        return this.mMaxBuffer;
    }

    @Override // com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mDataSink.getServer();
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.mWritable;
    }

    public boolean isBuffering() {
        return this.mPendingWrites.hasRemaining() || this.forceBuffering;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.mDataSink.isOpen();
    }

    public boolean isWritable() {
        boolean z;
        synchronized (this.mPendingWrites) {
            z = this.mPendingWrites.remaining() < this.mMaxBuffer;
        }
        return z;
    }

    public void onDataAccepted(ByteBufferList byteBufferList) {
    }

    public int remaining() {
        return this.mPendingWrites.remaining();
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.mDataSink.setClosedCallback(completedCallback);
    }

    public void setDataSink(DataSink dataSink) {
        this.mDataSink = dataSink;
        dataSink.setWriteableCallback(new WritableCallback() { // from class: dc.r81
            @Override // com.koushikdutta.async.callback.WritableCallback
            public final void onWriteable() {
                this.a.writePending();
            }
        });
    }

    public void setMaxBuffer(int i) {
        this.mMaxBuffer = i;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.mWritable = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        if (getServer().getAffinity() == Thread.currentThread()) {
            onDataAccepted(byteBufferList);
            if (!isBuffering()) {
                this.mDataSink.write(byteBufferList);
            }
            synchronized (this.mPendingWrites) {
                byteBufferList.get(this.mPendingWrites);
            }
            return;
        }
        synchronized (this.mPendingWrites) {
            if (this.mPendingWrites.remaining() >= this.mMaxBuffer) {
                return;
            }
            onDataAccepted(byteBufferList);
            byteBufferList.get(this.mPendingWrites);
            getServer().post(new Runnable() { // from class: dc.s81
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.writePending();
                }
            });
        }
    }
}
