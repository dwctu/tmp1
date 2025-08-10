package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class ByteBufferListParser implements AsyncParser<ByteBufferList> {
    @Override // com.koushikdutta.async.parser.AsyncParser
    public String getMime() {
        return null;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Type getType() {
        return ByteBufferList.class;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public Future<ByteBufferList> parse(final DataEmitter dataEmitter) {
        final ByteBufferList byteBufferList = new ByteBufferList();
        final SimpleFuture<ByteBufferList> simpleFuture = new SimpleFuture<ByteBufferList>() { // from class: com.koushikdutta.async.parser.ByteBufferListParser.1
            @Override // com.koushikdutta.async.future.SimpleCancellable
            public void cancelCleanup() {
                dataEmitter.close();
            }
        };
        dataEmitter.setDataCallback(new DataCallback() { // from class: com.koushikdutta.async.parser.ByteBufferListParser.2
            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter2, ByteBufferList byteBufferList2) {
                byteBufferList2.get(byteBufferList);
            }
        });
        dataEmitter.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.parser.ByteBufferListParser.3
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    simpleFuture.setComplete(exc);
                    return;
                }
                try {
                    simpleFuture.setComplete((SimpleFuture) byteBufferList);
                } catch (Exception e) {
                    simpleFuture.setComplete(e);
                }
            }
        });
        return simpleFuture;
    }

    @Override // com.koushikdutta.async.parser.AsyncParser
    public void write(DataSink dataSink, ByteBufferList byteBufferList, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, byteBufferList, completedCallback);
    }
}
