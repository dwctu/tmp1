package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes3.dex */
public abstract class DataEmitterBase implements DataEmitter {
    public CompletedCallback endCallback;
    private boolean ended;
    public DataCallback mDataCallback;

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.mDataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public final CompletedCallback getEndCallback() {
        return this.endCallback;
    }

    public void report(Exception exc) {
        if (this.ended) {
            return;
        }
        this.ended = true;
        if (getEndCallback() != null) {
            getEndCallback().onCompleted(exc);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public final void setEndCallback(CompletedCallback completedCallback) {
        this.endCallback = completedCallback;
    }
}
