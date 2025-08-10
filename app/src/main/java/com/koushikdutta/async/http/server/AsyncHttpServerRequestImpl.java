package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class AsyncHttpServerRequestImpl extends FilteredDataEmitter implements AsyncHttpServerRequest, CompletedCallback {
    public AsyncHttpRequestBody mBody;
    public AsyncSocket mSocket;
    public String method;
    private String statusLine;
    private Headers mRawHeaders = new Headers();
    private HashMap<String, Object> state = new HashMap<>();
    private CompletedCallback mReporter = new CompletedCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl.1
        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServerRequestImpl.this.onCompleted(exc);
        }
    };
    public LineEmitter.StringCallback mHeaderCallback = new LineEmitter.StringCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl.2
        @Override // com.koushikdutta.async.LineEmitter.StringCallback
        public void onStringAvailable(String str) {
            if (AsyncHttpServerRequestImpl.this.statusLine == null) {
                AsyncHttpServerRequestImpl.this.statusLine = str;
                if (AsyncHttpServerRequestImpl.this.statusLine.contains("HTTP/")) {
                    return;
                }
                AsyncHttpServerRequestImpl.this.onNotHttp();
                AsyncHttpServerRequestImpl.this.mSocket.setDataCallback(new DataCallback.NullDataCallback());
                AsyncHttpServerRequestImpl.this.report(new IOException("data/header received was not not http"));
                return;
            }
            if (!"\r".equals(str)) {
                AsyncHttpServerRequestImpl.this.mRawHeaders.addLine(str);
                return;
            }
            AsyncHttpServerRequestImpl asyncHttpServerRequestImpl = AsyncHttpServerRequestImpl.this;
            DataEmitter bodyDecoder = HttpUtil.getBodyDecoder(asyncHttpServerRequestImpl.mSocket, Protocol.HTTP_1_1, asyncHttpServerRequestImpl.mRawHeaders, true);
            AsyncHttpServerRequestImpl asyncHttpServerRequestImpl2 = AsyncHttpServerRequestImpl.this;
            asyncHttpServerRequestImpl2.mBody = asyncHttpServerRequestImpl2.onBody(asyncHttpServerRequestImpl2.mRawHeaders);
            AsyncHttpServerRequestImpl asyncHttpServerRequestImpl3 = AsyncHttpServerRequestImpl.this;
            if (asyncHttpServerRequestImpl3.mBody == null) {
                asyncHttpServerRequestImpl3.mBody = HttpUtil.getBody(bodyDecoder, asyncHttpServerRequestImpl3.mReporter, AsyncHttpServerRequestImpl.this.mRawHeaders);
                AsyncHttpServerRequestImpl asyncHttpServerRequestImpl4 = AsyncHttpServerRequestImpl.this;
                if (asyncHttpServerRequestImpl4.mBody == null) {
                    asyncHttpServerRequestImpl4.mBody = asyncHttpServerRequestImpl4.onUnknownBody(asyncHttpServerRequestImpl4.mRawHeaders);
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl5 = AsyncHttpServerRequestImpl.this;
                    if (asyncHttpServerRequestImpl5.mBody == null) {
                        asyncHttpServerRequestImpl5.mBody = new UnknownRequestBody(asyncHttpServerRequestImpl5.mRawHeaders.get("Content-Type"));
                    }
                }
            }
            AsyncHttpServerRequestImpl asyncHttpServerRequestImpl6 = AsyncHttpServerRequestImpl.this;
            asyncHttpServerRequestImpl6.mBody.parse(bodyDecoder, asyncHttpServerRequestImpl6.mReporter);
            AsyncHttpServerRequestImpl.this.onHeadersReceived();
        }
    };

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public String get(String str) {
        String string = getQuery().getString(str);
        if (string != null) {
            return string;
        }
        Object obj = getBody().get();
        if (obj instanceof Multimap) {
            return ((Multimap) obj).getString(str);
        }
        return null;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public AsyncHttpRequestBody getBody() {
        return this.mBody;
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.mSocket.getDataCallback();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public Headers getHeaders() {
        return this.mRawHeaders;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public String getMethod() {
        return this.method;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.mSocket.isChunked();
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.mSocket.isPaused();
    }

    public AsyncHttpRequestBody onBody(Headers headers) {
        return null;
    }

    public void onCompleted(Exception exc) {
        report(exc);
    }

    public abstract void onHeadersReceived();

    public void onNotHttp() {
        System.out.println("not http!");
    }

    public AsyncHttpRequestBody onUnknownBody(Headers headers) {
        return null;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void pause() {
        this.mSocket.pause();
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void resume() {
        this.mSocket.resume();
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.mSocket.setDataCallback(dataCallback);
    }

    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
        LineEmitter lineEmitter = new LineEmitter();
        this.mSocket.setDataCallback(lineEmitter);
        lineEmitter.setLineCallback(this.mHeaderCallback);
        this.mSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
    }

    public String toString() {
        Headers headers = this.mRawHeaders;
        return headers == null ? super.toString() : headers.toPrefixString(this.statusLine);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
    public HashMap<String, Object> getState() {
        return this.state;
    }
}
