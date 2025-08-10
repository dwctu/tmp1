package com.koushikdutta.async.http.server;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

/* loaded from: classes3.dex */
public class UnknownRequestBody implements AsyncHttpRequestBody<Void> {
    public DataEmitter emitter;
    public int length;
    private String mContentType;

    public UnknownRequestBody(String str) {
        this.length = -1;
        this.mContentType = str;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Void get() {
        return null;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return this.mContentType;
    }

    public DataEmitter getEmitter() {
        return this.emitter;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        this.emitter = dataEmitter;
        dataEmitter.setEndCallback(completedCallback);
        dataEmitter.setDataCallback(new DataCallback.NullDataCallback());
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return false;
    }

    @Deprecated
    public void setCallbacks(DataCallback dataCallback, CompletedCallback completedCallback) {
        this.emitter.setEndCallback(completedCallback);
        this.emitter.setDataCallback(dataCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.pump(this.emitter, dataSink, completedCallback);
        if (this.emitter.isPaused()) {
            this.emitter.resume();
        }
    }

    public UnknownRequestBody(DataEmitter dataEmitter, String str, int i) {
        this.length = -1;
        this.mContentType = str;
        this.emitter = dataEmitter;
        this.length = i;
    }
}
