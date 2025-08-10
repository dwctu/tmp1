package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.ByteBufferListParser;

/* loaded from: classes3.dex */
public class ByteBufferListRequestBody implements AsyncHttpRequestBody<ByteBufferList> {
    public static String CONTENT_TYPE = "application/binary";
    public ByteBufferList bb;

    public ByteBufferListRequestBody() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(CompletedCallback completedCallback, Exception exc, ByteBufferList byteBufferList) {
        this.bb = byteBufferList;
        completedCallback.onCompleted(exc);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return CONTENT_TYPE;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        return this.bb.remaining();
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new ByteBufferListParser().parse(dataEmitter).setCallback(new FutureCallback() { // from class: dc.pa1
            @Override // com.koushikdutta.async.future.FutureCallback
            public final void onCompleted(Exception exc, Object obj) {
                this.a.b(completedCallback, exc, (ByteBufferList) obj);
            }
        });
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, this.bb, completedCallback);
    }

    public ByteBufferListRequestBody(ByteBufferList byteBufferList) {
        this.bb = byteBufferList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public ByteBufferList get() {
        return this.bb;
    }
}
