package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StreamBody implements AsyncHttpRequestBody<InputStream> {
    public static final String CONTENT_TYPE = "application/binary";
    public String contentType = "application/binary";
    public int length;
    public InputStream stream;

    public StreamBody(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.length = i;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public StreamBody setContentType(String str) {
        this.contentType = str;
        return this;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        InputStream inputStream = this.stream;
        int i = this.length;
        Util.pump(inputStream, i < 0 ? 2147483647L : i, dataSink, completedCallback);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public InputStream get() {
        return this.stream;
    }
}
