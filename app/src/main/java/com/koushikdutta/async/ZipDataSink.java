package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class ZipDataSink extends FilteredDataSink {
    public ByteArrayOutputStream bout;
    public ZipOutputStream zop;

    public ZipDataSink(DataSink dataSink) {
        super(dataSink);
        this.bout = new ByteArrayOutputStream();
        this.zop = new ZipOutputStream(this.bout);
    }

    public void closeEntry() throws IOException {
        this.zop.closeEntry();
    }

    @Override // com.koushikdutta.async.BufferedDataSink, com.koushikdutta.async.DataSink
    public void end() throws IOException {
        try {
            this.zop.close();
            setMaxBuffer(Integer.MAX_VALUE);
            write(new ByteBufferList());
            super.end();
        } catch (IOException e) {
            report(e);
        }
    }

    @Override // com.koushikdutta.async.FilteredDataSink
    public ByteBufferList filter(ByteBufferList byteBufferList) {
        if (byteBufferList != null) {
            while (byteBufferList.size() > 0) {
                try {
                    try {
                        ByteBuffer byteBufferRemove = byteBufferList.remove();
                        ByteBufferList.writeOutputStream(this.zop, byteBufferRemove);
                        ByteBufferList.reclaim(byteBufferRemove);
                    } catch (IOException e) {
                        report(e);
                        if (byteBufferList != null) {
                            byteBufferList.recycle();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    throw th;
                }
            }
        }
        ByteBufferList byteBufferList2 = new ByteBufferList(this.bout.toByteArray());
        this.bout.reset();
        if (byteBufferList != null) {
            byteBufferList.recycle();
        }
        return byteBufferList2;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        this.zop.putNextEntry(zipEntry);
    }

    public void report(Exception exc) {
        CompletedCallback closedCallback = getClosedCallback();
        if (closedCallback != null) {
            closedCallback.onCompleted(exc);
        }
    }
}
