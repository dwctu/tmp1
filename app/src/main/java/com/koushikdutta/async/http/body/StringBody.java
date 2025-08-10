package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.StringParser;

/* loaded from: classes3.dex */
public class StringBody implements AsyncHttpRequestBody<String> {
    public static final String CONTENT_TYPE = "text/plain";
    public byte[] mBodyBytes;
    public String string;

    public StringBody() {
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "text/plain";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (this.mBodyBytes == null) {
            this.mBodyBytes = this.string.getBytes();
        }
        return this.mBodyBytes.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new StringParser().parse(dataEmitter).setCallback(new FutureCallback<String>() { // from class: com.koushikdutta.async.http.body.StringBody.1
            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, String str) {
                StringBody.this.string = str;
                completedCallback.onCompleted(exc);
            }
        });
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    public String toString() {
        return this.string;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.mBodyBytes == null) {
            this.mBodyBytes = this.string.getBytes();
        }
        Util.writeAll(dataSink, this.mBodyBytes, completedCallback);
    }

    public StringBody(String str) {
        this();
        this.string = str;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String get() {
        return toString();
    }
}
