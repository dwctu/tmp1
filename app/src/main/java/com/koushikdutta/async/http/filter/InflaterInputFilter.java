package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.Util;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public class InflaterInputFilter extends FilteredDataEmitter {
    private Inflater mInflater;
    public ByteBufferList transformed;

    public InflaterInputFilter() {
        this(new Inflater());
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) throws DataFormatException {
        try {
            ByteBuffer byteBufferObtain = ByteBufferList.obtain(byteBufferList.remaining() * 2);
            while (byteBufferList.size() > 0) {
                ByteBuffer byteBufferRemove = byteBufferList.remove();
                if (byteBufferRemove.hasRemaining()) {
                    byteBufferRemove.remaining();
                    this.mInflater.setInput(byteBufferRemove.array(), byteBufferRemove.arrayOffset() + byteBufferRemove.position(), byteBufferRemove.remaining());
                    do {
                        byteBufferObtain.position(byteBufferObtain.position() + this.mInflater.inflate(byteBufferObtain.array(), byteBufferObtain.arrayOffset() + byteBufferObtain.position(), byteBufferObtain.remaining()));
                        if (!byteBufferObtain.hasRemaining()) {
                            byteBufferObtain.flip();
                            this.transformed.add(byteBufferObtain);
                            byteBufferObtain = ByteBufferList.obtain(byteBufferObtain.capacity() * 2);
                        }
                        if (!this.mInflater.needsInput()) {
                        }
                    } while (!this.mInflater.finished());
                }
                ByteBufferList.reclaim(byteBufferRemove);
            }
            byteBufferObtain.flip();
            this.transformed.add(byteBufferObtain);
            Util.emitAllData(this, this.transformed);
        } catch (Exception e) {
            report(e);
        }
    }

    @Override // com.koushikdutta.async.DataEmitterBase
    public void report(Exception exc) {
        this.mInflater.end();
        if (exc != null && this.mInflater.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.report(exc);
    }

    public InflaterInputFilter(Inflater inflater) {
        this.transformed = new ByteBufferList();
        this.mInflater = inflater;
    }
}
