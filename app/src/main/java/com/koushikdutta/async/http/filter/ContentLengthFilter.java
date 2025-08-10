package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

/* loaded from: classes3.dex */
public class ContentLengthFilter extends FilteredDataEmitter {
    public long contentLength;
    public long totalRead;
    public ByteBufferList transformed = new ByteBufferList();

    public ContentLengthFilter(long j) {
        this.contentLength = j;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        byteBufferList.get(this.transformed, (int) Math.min(this.contentLength - this.totalRead, byteBufferList.remaining()));
        int iRemaining = this.transformed.remaining();
        super.onDataAvailable(dataEmitter, this.transformed);
        this.totalRead += iRemaining - this.transformed.remaining();
        this.transformed.get(byteBufferList);
        if (this.totalRead == this.contentLength) {
            report(null);
        }
    }

    @Override // com.koushikdutta.async.DataEmitterBase
    public void report(Exception exc) {
        if (exc == null && this.totalRead != this.contentLength) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.totalRead + "/" + this.contentLength + " Paused: " + isPaused());
        }
        super.report(exc);
    }
}
