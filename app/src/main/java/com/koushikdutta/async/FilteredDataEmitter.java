package com.koushikdutta.async;

import com.koushikdutta.async.DataTrackingEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;

/* loaded from: classes3.dex */
public class FilteredDataEmitter extends DataEmitterBase implements DataEmitter, DataCallback, DataEmitterWrapper, DataTrackingEmitter {
    public boolean closed;
    private DataEmitter mEmitter;
    private int totalRead;
    private DataTrackingEmitter.DataTracker tracker;

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public String charset() {
        DataEmitter dataEmitter = this.mEmitter;
        if (dataEmitter == null) {
            return null;
        }
        return dataEmitter.charset();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.closed = true;
        DataEmitter dataEmitter = this.mEmitter;
        if (dataEmitter != null) {
            dataEmitter.close();
        }
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public int getBytesRead() {
        return this.totalRead;
    }

    @Override // com.koushikdutta.async.wrapper.DataEmitterWrapper
    public DataEmitter getDataEmitter() {
        return this.mEmitter;
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public DataTrackingEmitter.DataTracker getDataTracker() {
        return this.tracker;
    }

    @Override // com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mEmitter.getServer();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.mEmitter.isChunked();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.mEmitter.isPaused();
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.closed) {
            byteBufferList.recycle();
            return;
        }
        if (byteBufferList != null) {
            this.totalRead += byteBufferList.remaining();
        }
        Util.emitAllData(this, byteBufferList);
        if (byteBufferList != null) {
            this.totalRead -= byteBufferList.remaining();
        }
        DataTrackingEmitter.DataTracker dataTracker = this.tracker;
        if (dataTracker == null || byteBufferList == null) {
            return;
        }
        dataTracker.onData(this.totalRead);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.mEmitter.pause();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.mEmitter.resume();
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public void setDataEmitter(DataEmitter dataEmitter) {
        DataEmitter dataEmitter2 = this.mEmitter;
        if (dataEmitter2 != null) {
            dataEmitter2.setDataCallback(null);
        }
        this.mEmitter = dataEmitter;
        dataEmitter.setDataCallback(this);
        this.mEmitter.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.FilteredDataEmitter.1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                FilteredDataEmitter.this.report(exc);
            }
        });
    }

    @Override // com.koushikdutta.async.DataTrackingEmitter
    public void setDataTracker(DataTrackingEmitter.DataTracker dataTracker) {
        this.tracker = dataTracker;
    }
}
