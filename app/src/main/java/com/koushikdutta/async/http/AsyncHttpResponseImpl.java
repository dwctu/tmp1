package com.koushikdutta.async.http;

import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class AsyncHttpResponseImpl extends FilteredDataEmitter implements DataEmitter, AsyncHttpResponse, AsyncHttpClientMiddleware.ResponseHead {
    public int code;
    public Headers mHeaders;
    private AsyncHttpRequest mRequest;
    public DataSink mSink;
    private AsyncSocket mSocket;
    public String message;
    public String protocol;
    private CompletedCallback mReporter = new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncHttpResponseImpl.2
        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (AsyncHttpResponseImpl.this.headers() == null) {
                AsyncHttpResponseImpl.this.report(new ConnectionClosedException("connection closed before headers received.", exc));
                return;
            }
            if (exc != null) {
                AsyncHttpResponseImpl asyncHttpResponseImpl = AsyncHttpResponseImpl.this;
                if (!asyncHttpResponseImpl.mCompleted) {
                    asyncHttpResponseImpl.report(new ConnectionClosedException("connection closed before response completed.", exc));
                    return;
                }
            }
            AsyncHttpResponseImpl.this.report(exc);
        }
    };
    public boolean mCompleted = false;
    private boolean mFirstWrite = true;

    public AsyncHttpResponseImpl(AsyncHttpRequest asyncHttpRequest) {
        this.mRequest = asyncHttpRequest;
    }

    private void assertContent() {
        if (this.mFirstWrite) {
            this.mFirstWrite = false;
        }
    }

    private void terminate() {
        this.mSocket.setDataCallback(new DataCallback.NullDataCallback() { // from class: com.koushikdutta.async.http.AsyncHttpResponseImpl.3
            @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                super.onDataAvailable(dataEmitter, byteBufferList);
                AsyncHttpResponseImpl.this.mSocket.close();
            }
        });
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public String charset() {
        String string;
        Multimap semicolonDelimited = Multimap.parseSemicolonDelimited(headers().get("Content-Type"));
        if (semicolonDelimited == null || (string = semicolonDelimited.getString(ContentTypeField.PARAM_CHARSET)) == null || !Charset.isSupported(string)) {
            return null;
        }
        return string;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter
    public void close() {
        super.close();
        terminate();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public int code() {
        return this.code;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public DataEmitter emitter() {
        return getDataEmitter();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse
    public AsyncHttpRequest getRequest() {
        return this.mRequest;
    }

    @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public Headers headers() {
        return this.mHeaders;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead message(String str) {
        this.message = str;
        return this;
    }

    public void onHeadersReceived() {
    }

    public void onHeadersSent() {
        AsyncHttpRequestBody body = this.mRequest.getBody();
        if (body != null) {
            body.write(this.mRequest, this.mSink, new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncHttpResponseImpl.1
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public void onCompleted(Exception exc) {
                    AsyncHttpResponseImpl.this.onRequestCompleted(exc);
                }
            });
        } else {
            onRequestCompleted(null);
        }
    }

    public void onRequestCompleted(Exception exc) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead protocol(String str) {
        this.protocol = str;
        return this;
    }

    @Override // com.koushikdutta.async.DataEmitterBase
    public void report(Exception exc) {
        super.report(exc);
        terminate();
        this.mSocket.setWriteableCallback(null);
        this.mSocket.setClosedCallback(null);
        this.mSocket.setEndCallback(null);
        this.mCompleted = true;
    }

    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
        if (asyncSocket == null) {
            return;
        }
        asyncSocket.setEndCallback(this.mReporter);
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public DataSink sink() {
        return this.mSink;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncSocket socket() {
        return this.mSocket;
    }

    public String toString() {
        Headers headers = this.mHeaders;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.protocol + " " + this.code + " " + this.message);
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead code(int i) {
        this.code = i;
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead emitter(DataEmitter dataEmitter) {
        setDataEmitter(dataEmitter);
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead headers(Headers headers) {
        this.mHeaders = headers;
        return this;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public String message() {
        return this.message;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpResponse, com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public String protocol() {
        return this.protocol;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware.ResponseHead
    public AsyncHttpClientMiddleware.ResponseHead sink(DataSink dataSink) {
        this.mSink = dataSink;
        return this;
    }
}
