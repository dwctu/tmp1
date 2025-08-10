package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;

/* loaded from: classes3.dex */
public class DataEmitterReader implements DataCallback {
    public ByteBufferList mPendingData = new ByteBufferList();
    public DataCallback mPendingRead;
    public int mPendingReadLength;

    private boolean handlePendingData(DataEmitter dataEmitter) {
        if (this.mPendingReadLength > this.mPendingData.remaining()) {
            return false;
        }
        DataCallback dataCallback = this.mPendingRead;
        this.mPendingRead = null;
        dataCallback.onDataAvailable(dataEmitter, this.mPendingData);
        return true;
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        do {
            byteBufferList.get(this.mPendingData, Math.min(byteBufferList.remaining(), this.mPendingReadLength - this.mPendingData.remaining()));
            byteBufferList.remaining();
            if (!handlePendingData(dataEmitter)) {
                break;
            }
        } while (this.mPendingRead != null);
        byteBufferList.remaining();
    }

    public void read(int i, DataCallback dataCallback) {
        this.mPendingReadLength = i;
        this.mPendingRead = dataCallback;
        this.mPendingData.recycle();
    }
}
