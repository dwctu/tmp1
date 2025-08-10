package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.NameValuePair;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class StreamPart extends Part {
    public StreamPart(String str, long j, List<NameValuePair> list) {
        super(str, j, list);
    }

    public abstract InputStream getInputStream() throws IOException;

    @Override // com.koushikdutta.async.http.body.Part
    public void write(DataSink dataSink, CompletedCallback completedCallback) {
        try {
            Util.pump(getInputStream(), dataSink, completedCallback);
        } catch (Exception e) {
            completedCallback.onCompleted(e);
        }
    }
}
