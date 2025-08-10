package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class OutputStreamDataCallback implements DataCallback, CompletedCallback {
    private OutputStream mOutput;

    public OutputStreamDataCallback(OutputStream outputStream) {
        this.mOutput = outputStream;
    }

    public void close() throws IOException {
        try {
            this.mOutput.close();
        } catch (IOException e) {
            onCompleted(e);
        }
    }

    public OutputStream getOutputStream() {
        return this.mOutput;
    }

    @Override // com.koushikdutta.async.callback.CompletedCallback
    public void onCompleted(Exception exc) {
        exc.printStackTrace();
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                try {
                    ByteBuffer byteBufferRemove = byteBufferList.remove();
                    this.mOutput.write(byteBufferRemove.array(), byteBufferRemove.arrayOffset() + byteBufferRemove.position(), byteBufferRemove.remaining());
                    ByteBufferList.reclaim(byteBufferRemove);
                } catch (Exception e) {
                    onCompleted(e);
                }
            } finally {
                byteBufferList.recycle();
            }
        }
    }
}
