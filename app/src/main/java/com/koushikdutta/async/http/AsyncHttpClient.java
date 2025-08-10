package com.koushikdutta.async.http;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.async.http.callback.RequestCallback;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.JSONArrayParser;
import com.koushikdutta.async.parser.JSONObjectParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.OutputStreamDataCallback;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AsyncHttpClient {
    private static final String LOGTAG = "AsyncHttp";
    private static AsyncHttpClient mDefaultInstance;
    public HttpTransportMiddleware httpTransportMiddleware;
    public final List<AsyncHttpClientMiddleware> mMiddleware = new CopyOnWriteArrayList();
    public AsyncServer mServer;
    public AsyncSocketMiddleware socketMiddleware;
    public AsyncSSLSocketMiddleware sslSocketMiddleware;

    /* renamed from: com.koushikdutta.async.http.AsyncHttpClient$4, reason: invalid class name */
    public class AnonymousClass4 extends AsyncHttpResponseImpl {
        public final /* synthetic */ HttpConnectCallback val$callback;
        public final /* synthetic */ FutureAsyncHttpResponse val$cancel;
        public final /* synthetic */ AsyncHttpClientMiddleware.OnResponseCompleteData val$data;
        public final /* synthetic */ int val$redirectCount;
        public final /* synthetic */ AsyncHttpRequest val$request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AsyncHttpRequest asyncHttpRequest, FutureAsyncHttpResponse futureAsyncHttpResponse, AsyncHttpRequest asyncHttpRequest2, HttpConnectCallback httpConnectCallback, AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData, int i) {
            super(asyncHttpRequest);
            this.val$cancel = futureAsyncHttpResponse;
            this.val$request = asyncHttpRequest2;
            this.val$callback = httpConnectCallback;
            this.val$data = onResponseCompleteData;
            this.val$redirectCount = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(AsyncHttpRequest asyncHttpRequest, int i, FutureAsyncHttpResponse futureAsyncHttpResponse, HttpConnectCallback httpConnectCallback) {
            AsyncHttpClient.this.execute(asyncHttpRequest, i, futureAsyncHttpResponse, httpConnectCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(AsyncHttpRequest asyncHttpRequest, int i, FutureAsyncHttpResponse futureAsyncHttpResponse, HttpConnectCallback httpConnectCallback) {
            AsyncHttpClient.this.execute(asyncHttpRequest, i + 1, futureAsyncHttpResponse, httpConnectCallback);
        }

        @Override // com.koushikdutta.async.http.AsyncHttpResponse
        public AsyncSocket detachSocket() {
            this.val$request.logd("Detaching socket");
            AsyncSocket asyncSocketSocket = socket();
            if (asyncSocketSocket == null) {
                return null;
            }
            asyncSocketSocket.setWriteableCallback(null);
            asyncSocketSocket.setClosedCallback(null);
            asyncSocketSocket.setEndCallback(null);
            asyncSocketSocket.setDataCallback(null);
            setSocket(null);
            return asyncSocketSocket;
        }

        @Override // com.koushikdutta.async.http.AsyncHttpResponseImpl
        public void onHeadersReceived() {
            super.onHeadersReceived();
            if (this.val$cancel.isCancelled()) {
                return;
            }
            FutureAsyncHttpResponse futureAsyncHttpResponse = this.val$cancel;
            if (futureAsyncHttpResponse.timeoutRunnable != null) {
                futureAsyncHttpResponse.scheduled.cancel();
            }
            this.val$request.logv("Received headers:\n" + toString());
            Iterator<AsyncHttpClientMiddleware> it = AsyncHttpClient.this.mMiddleware.iterator();
            while (it.hasNext()) {
                it.next().onHeadersReceived(this.val$data);
            }
        }

        @Override // com.koushikdutta.async.http.AsyncHttpResponseImpl
        public void onRequestCompleted(Exception exc) {
            if (exc != null) {
                AsyncHttpClient.this.reportConnectedCompleted(this.val$cancel, exc, null, this.val$request, this.val$callback);
                return;
            }
            this.val$request.logv("request completed");
            if (this.val$cancel.isCancelled()) {
                return;
            }
            FutureAsyncHttpResponse futureAsyncHttpResponse = this.val$cancel;
            if (futureAsyncHttpResponse.timeoutRunnable != null && this.mHeaders == null) {
                futureAsyncHttpResponse.scheduled.cancel();
                FutureAsyncHttpResponse futureAsyncHttpResponse2 = this.val$cancel;
                futureAsyncHttpResponse2.scheduled = AsyncHttpClient.this.mServer.postDelayed(futureAsyncHttpResponse2.timeoutRunnable, AsyncHttpClient.getTimeoutRemaining(this.val$request));
            }
            Iterator<AsyncHttpClientMiddleware> it = AsyncHttpClient.this.mMiddleware.iterator();
            while (it.hasNext()) {
                it.next().onRequestSent(this.val$data);
            }
        }

        @Override // com.koushikdutta.async.http.AsyncHttpResponseImpl, com.koushikdutta.async.DataEmitterBase
        public void report(Exception exc) {
            if (exc != null) {
                this.val$request.loge("exception during response", exc);
            }
            if (this.val$cancel.isCancelled()) {
                return;
            }
            if (exc instanceof AsyncSSLException) {
                this.val$request.loge("SSL Exception", exc);
                AsyncSSLException asyncSSLException = (AsyncSSLException) exc;
                this.val$request.onHandshakeException(asyncSSLException);
                if (asyncSSLException.getIgnore()) {
                    return;
                }
            }
            AsyncSocket asyncSocketSocket = socket();
            if (asyncSocketSocket == null) {
                return;
            }
            super.report(exc);
            if ((!asyncSocketSocket.isOpen() || exc != null) && headers() == null && exc != null) {
                AsyncHttpClient.this.reportConnectedCompleted(this.val$cancel, exc, null, this.val$request, this.val$callback);
            }
            this.val$data.exception = exc;
            Iterator<AsyncHttpClientMiddleware> it = AsyncHttpClient.this.mMiddleware.iterator();
            while (it.hasNext()) {
                it.next().onResponseComplete(this.val$data);
            }
        }

        @Override // com.koushikdutta.async.FilteredDataEmitter, com.koushikdutta.async.DataTrackingEmitter
        public void setDataEmitter(DataEmitter dataEmitter) {
            this.val$data.bodyEmitter = dataEmitter;
            Iterator<AsyncHttpClientMiddleware> it = AsyncHttpClient.this.mMiddleware.iterator();
            while (it.hasNext()) {
                it.next().onBodyDecoder(this.val$data);
            }
            super.setDataEmitter(this.val$data.bodyEmitter);
            Iterator<AsyncHttpClientMiddleware> it2 = AsyncHttpClient.this.mMiddleware.iterator();
            while (it2.hasNext()) {
                final AsyncHttpRequest asyncHttpRequestOnResponseReady = it2.next().onResponseReady(this.val$data);
                if (asyncHttpRequestOnResponseReady != null) {
                    AsyncHttpRequest asyncHttpRequest = this.val$request;
                    asyncHttpRequestOnResponseReady.executionTime = asyncHttpRequest.executionTime;
                    asyncHttpRequestOnResponseReady.logLevel = asyncHttpRequest.logLevel;
                    asyncHttpRequestOnResponseReady.LOGTAG = asyncHttpRequest.LOGTAG;
                    asyncHttpRequestOnResponseReady.proxyHost = asyncHttpRequest.proxyHost;
                    asyncHttpRequestOnResponseReady.proxyPort = asyncHttpRequest.proxyPort;
                    AsyncHttpClient.setupAndroidProxy(asyncHttpRequestOnResponseReady);
                    this.val$request.logi("Response intercepted by middleware");
                    asyncHttpRequestOnResponseReady.logi("Request initiated by middleware intercept by middleware");
                    AsyncServer asyncServer = AsyncHttpClient.this.mServer;
                    final int i = this.val$redirectCount;
                    final FutureAsyncHttpResponse futureAsyncHttpResponse = this.val$cancel;
                    final HttpConnectCallback httpConnectCallback = this.val$callback;
                    asyncServer.post(new Runnable() { // from class: dc.ba1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b(asyncHttpRequestOnResponseReady, i, futureAsyncHttpResponse, httpConnectCallback);
                        }
                    });
                    setDataCallback(new DataCallback.NullDataCallback());
                    return;
                }
            }
            Headers headers = this.mHeaders;
            int iCode = code();
            if ((iCode != 301 && iCode != 302 && iCode != 307) || !this.val$request.getFollowRedirect()) {
                this.val$request.logv("Final (post cache response) headers:\n" + toString());
                AsyncHttpClient.this.reportConnectedCompleted(this.val$cancel, null, this, this.val$request, this.val$callback);
                return;
            }
            String str = headers.get(HttpHeaders.LOCATION);
            try {
                Uri uri = Uri.parse(str);
                if (uri.getScheme() == null) {
                    uri = Uri.parse(new URL(new URL(this.val$request.getUri().toString()), str).toString());
                }
                String method = this.val$request.getMethod();
                String str2 = AsyncHttpHead.METHOD;
                if (!method.equals(AsyncHttpHead.METHOD)) {
                    str2 = "GET";
                }
                final AsyncHttpRequest asyncHttpRequest2 = new AsyncHttpRequest(uri, str2);
                AsyncHttpRequest asyncHttpRequest3 = this.val$request;
                asyncHttpRequest2.executionTime = asyncHttpRequest3.executionTime;
                asyncHttpRequest2.logLevel = asyncHttpRequest3.logLevel;
                asyncHttpRequest2.LOGTAG = asyncHttpRequest3.LOGTAG;
                asyncHttpRequest2.proxyHost = asyncHttpRequest3.proxyHost;
                asyncHttpRequest2.proxyPort = asyncHttpRequest3.proxyPort;
                AsyncHttpClient.setupAndroidProxy(asyncHttpRequest2);
                AsyncHttpClient.copyHeader(this.val$request, asyncHttpRequest2, "User-Agent");
                AsyncHttpClient.copyHeader(this.val$request, asyncHttpRequest2, HttpHeaders.RANGE);
                this.val$request.logi("Redirecting");
                asyncHttpRequest2.logi("Redirected");
                AsyncServer asyncServer2 = AsyncHttpClient.this.mServer;
                final int i2 = this.val$redirectCount;
                final FutureAsyncHttpResponse futureAsyncHttpResponse2 = this.val$cancel;
                final HttpConnectCallback httpConnectCallback2 = this.val$callback;
                asyncServer2.post(new Runnable() { // from class: dc.aa1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(asyncHttpRequest2, i2, futureAsyncHttpResponse2, httpConnectCallback2);
                    }
                });
                setDataCallback(new DataCallback.NullDataCallback());
            } catch (Exception e) {
                AsyncHttpClient.this.reportConnectedCompleted(this.val$cancel, e, this, this.val$request, this.val$callback);
            }
        }
    }

    /* renamed from: com.koushikdutta.async.http.AsyncHttpClient$9, reason: invalid class name */
    public class AnonymousClass9 implements HttpConnectCallback {
        public long mDownloaded = 0;
        public final /* synthetic */ FileCallback val$callback;
        public final /* synthetic */ File val$file;
        public final /* synthetic */ OutputStream val$fout;
        public final /* synthetic */ SimpleFuture val$ret;

        public AnonymousClass9(OutputStream outputStream, File file, FileCallback fileCallback, SimpleFuture simpleFuture) {
            this.val$fout = outputStream;
            this.val$file = file;
            this.val$callback = fileCallback;
            this.val$ret = simpleFuture;
        }

        @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
        public void onConnectCompleted(Exception exc, final AsyncHttpResponse asyncHttpResponse) throws IOException {
            if (exc != null) {
                try {
                    this.val$fout.close();
                } catch (IOException unused) {
                }
                this.val$file.delete();
                AsyncHttpClient.this.c(this.val$callback, this.val$ret, asyncHttpResponse, exc, null);
            } else {
                AsyncHttpClient.this.invokeConnect(this.val$callback, asyncHttpResponse);
                final long jContentLength = HttpUtil.contentLength(asyncHttpResponse.headers());
                asyncHttpResponse.setDataCallback(new OutputStreamDataCallback(this.val$fout) { // from class: com.koushikdutta.async.http.AsyncHttpClient.9.1
                    @Override // com.koushikdutta.async.stream.OutputStreamDataCallback, com.koushikdutta.async.callback.DataCallback
                    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                        AnonymousClass9.this.mDownloaded += byteBufferList.remaining();
                        super.onDataAvailable(dataEmitter, byteBufferList);
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        AsyncHttpClient.this.invokeProgress(anonymousClass9.val$callback, asyncHttpResponse, anonymousClass9.mDownloaded, jContentLength);
                    }
                });
                asyncHttpResponse.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncHttpClient.9.2
                    @Override // com.koushikdutta.async.callback.CompletedCallback
                    public void onCompleted(Exception e) throws IOException {
                        try {
                            AnonymousClass9.this.val$fout.close();
                        } catch (IOException e2) {
                            e = e2;
                        }
                        Exception exc2 = e;
                        if (exc2 == null) {
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            AsyncHttpClient.this.c(anonymousClass9.val$callback, anonymousClass9.val$ret, asyncHttpResponse, null, anonymousClass9.val$file);
                        } else {
                            AnonymousClass9.this.val$file.delete();
                            AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                            AsyncHttpClient.this.c(anonymousClass92.val$callback, anonymousClass92.val$ret, asyncHttpResponse, exc2, null);
                        }
                    }
                });
            }
        }
    }

    public static abstract class DownloadCallback extends RequestCallbackBase<ByteBufferList> {
    }

    public static abstract class FileCallback extends RequestCallbackBase<File> {
    }

    public class FutureAsyncHttpResponse extends SimpleFuture<AsyncHttpResponse> {
        public Cancellable scheduled;
        public AsyncSocket socket;
        public Runnable timeoutRunnable;

        private FutureAsyncHttpResponse() {
        }

        @Override // com.koushikdutta.async.future.SimpleFuture, com.koushikdutta.async.future.SimpleCancellable, com.koushikdutta.async.future.Cancellable
        public boolean cancel() {
            if (!super.cancel()) {
                return false;
            }
            AsyncSocket asyncSocket = this.socket;
            if (asyncSocket != null) {
                asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                this.socket.close();
            }
            Cancellable cancellable = this.scheduled;
            if (cancellable == null) {
                return true;
            }
            cancellable.cancel();
            return true;
        }
    }

    public static abstract class JSONArrayCallback extends RequestCallbackBase<JSONArray> {
    }

    public static abstract class JSONObjectCallback extends RequestCallbackBase<JSONObject> {
    }

    public static abstract class RequestCallbackBase<T> implements RequestCallback<T> {
        @Override // com.koushikdutta.async.http.callback.RequestCallback
        public void onConnect(AsyncHttpResponse asyncHttpResponse) {
        }

        @Override // com.koushikdutta.async.http.callback.RequestCallback
        public void onProgress(AsyncHttpResponse asyncHttpResponse, long j, long j2) {
        }
    }

    public static abstract class StringCallback extends RequestCallbackBase<String> {
    }

    public interface WebSocketConnectCallback {
        void onCompleted(Exception exc, WebSocket webSocket);
    }

    public AsyncHttpClient(AsyncServer asyncServer) {
        this.mServer = asyncServer;
        AsyncSocketMiddleware asyncSocketMiddleware = new AsyncSocketMiddleware(this);
        this.socketMiddleware = asyncSocketMiddleware;
        insertMiddleware(asyncSocketMiddleware);
        AsyncSSLSocketMiddleware asyncSSLSocketMiddleware = new AsyncSSLSocketMiddleware(this);
        this.sslSocketMiddleware = asyncSSLSocketMiddleware;
        insertMiddleware(asyncSSLSocketMiddleware);
        HttpTransportMiddleware httpTransportMiddleware = new HttpTransportMiddleware();
        this.httpTransportMiddleware = httpTransportMiddleware;
        insertMiddleware(httpTransportMiddleware);
        this.sslSocketMiddleware.addEngineConfigurator(new SSLEngineSNIConfigurator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(final RequestCallback requestCallback, final SimpleFuture simpleFuture, AsyncParser asyncParser, Exception exc, final AsyncHttpResponse asyncHttpResponse) {
        if (exc != null) {
            c(requestCallback, simpleFuture, asyncHttpResponse, exc, null);
            return;
        }
        invokeConnect(requestCallback, asyncHttpResponse);
        Future future = asyncParser.parse(asyncHttpResponse);
        future.setCallback(new FutureCallback() { // from class: dc.ea1
            @Override // com.koushikdutta.async.future.FutureCallback
            public final void onCompleted(Exception exc2, Object obj) {
                this.a.d(requestCallback, simpleFuture, asyncHttpResponse, exc2, obj);
            }
        });
        simpleFuture.setParent(future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void copyHeader(AsyncHttpRequest asyncHttpRequest, AsyncHttpRequest asyncHttpRequest2, String str) {
        String str2 = asyncHttpRequest.getHeaders().get(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        asyncHttpRequest2.getHeaders().set(str, str2);
    }

    public static /* synthetic */ void e(SimpleFuture simpleFuture, WebSocketConnectCallback webSocketConnectCallback, AsyncHttpRequest asyncHttpRequest, Exception exc, AsyncHttpResponse asyncHttpResponse) {
        if (exc != null) {
            if (!simpleFuture.setComplete(exc) || webSocketConnectCallback == null) {
                return;
            }
            webSocketConnectCallback.onCompleted(exc, null);
            return;
        }
        WebSocket webSocketFinishHandshake = WebSocketImpl.finishHandshake(asyncHttpRequest.getHeaders(), asyncHttpResponse);
        if (webSocketFinishHandshake == null) {
            exc = new WebSocketHandshakeException("Unable to complete websocket handshake");
            asyncHttpResponse.close();
            if (!simpleFuture.setComplete(exc)) {
                return;
            }
        } else if (!simpleFuture.setComplete((SimpleFuture) webSocketFinishHandshake)) {
            return;
        }
        if (webSocketConnectCallback != null) {
            webSocketConnectCallback.onCompleted(exc, webSocketFinishHandshake);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAffinity(final AsyncHttpRequest asyncHttpRequest, final int i, final FutureAsyncHttpResponse futureAsyncHttpResponse, final HttpConnectCallback httpConnectCallback) {
        if (i > 15) {
            reportConnectedCompleted(futureAsyncHttpResponse, new RedirectLimitExceededException("too many redirects"), null, asyncHttpRequest, httpConnectCallback);
            return;
        }
        asyncHttpRequest.getUri();
        final AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData = new AsyncHttpClientMiddleware.OnResponseCompleteData();
        asyncHttpRequest.executionTime = System.currentTimeMillis();
        onResponseCompleteData.request = asyncHttpRequest;
        asyncHttpRequest.logd("Executing request.");
        Iterator<AsyncHttpClientMiddleware> it = this.mMiddleware.iterator();
        while (it.hasNext()) {
            it.next().onRequest(onResponseCompleteData);
        }
        if (asyncHttpRequest.getTimeout() > 0) {
            Runnable runnable = new Runnable() { // from class: com.koushikdutta.async.http.AsyncHttpClient.2
                @Override // java.lang.Runnable
                public void run() {
                    Cancellable cancellable = onResponseCompleteData.socketCancellable;
                    if (cancellable != null) {
                        cancellable.cancel();
                        AsyncSocket asyncSocket = onResponseCompleteData.socket;
                        if (asyncSocket != null) {
                            asyncSocket.close();
                        }
                    }
                    AsyncHttpClient.this.reportConnectedCompleted(futureAsyncHttpResponse, new TimeoutException(), null, asyncHttpRequest, httpConnectCallback);
                }
            };
            futureAsyncHttpResponse.timeoutRunnable = runnable;
            futureAsyncHttpResponse.scheduled = this.mServer.postDelayed(runnable, getTimeoutRemaining(asyncHttpRequest));
        }
        onResponseCompleteData.connectCallback = new ConnectCallback() { // from class: com.koushikdutta.async.http.AsyncHttpClient.3
            public boolean reported;

            @Override // com.koushikdutta.async.callback.ConnectCallback
            public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                if (this.reported && asyncSocket != null) {
                    asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                    asyncSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
                    asyncSocket.close();
                    throw new AssertionError("double connect callback");
                }
                this.reported = true;
                asyncHttpRequest.logv("socket connected");
                if (futureAsyncHttpResponse.isCancelled()) {
                    if (asyncSocket != null) {
                        asyncSocket.close();
                        return;
                    }
                    return;
                }
                FutureAsyncHttpResponse futureAsyncHttpResponse2 = futureAsyncHttpResponse;
                if (futureAsyncHttpResponse2.timeoutRunnable != null) {
                    futureAsyncHttpResponse2.scheduled.cancel();
                }
                if (exc != null) {
                    AsyncHttpClient.this.reportConnectedCompleted(futureAsyncHttpResponse, exc, null, asyncHttpRequest, httpConnectCallback);
                    return;
                }
                AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData2 = onResponseCompleteData;
                onResponseCompleteData2.socket = asyncSocket;
                FutureAsyncHttpResponse futureAsyncHttpResponse3 = futureAsyncHttpResponse;
                futureAsyncHttpResponse3.socket = asyncSocket;
                AsyncHttpClient.this.executeSocket(asyncHttpRequest, i, futureAsyncHttpResponse3, httpConnectCallback, onResponseCompleteData2);
            }
        };
        setupAndroidProxy(asyncHttpRequest);
        if (asyncHttpRequest.getBody() != null && asyncHttpRequest.getHeaders().get("Content-Type") == null) {
            asyncHttpRequest.getHeaders().set("Content-Type", asyncHttpRequest.getBody().getContentType());
        }
        Iterator<AsyncHttpClientMiddleware> it2 = this.mMiddleware.iterator();
        while (it2.hasNext()) {
            Cancellable socket = it2.next().getSocket(onResponseCompleteData);
            if (socket != null) {
                onResponseCompleteData.socketCancellable = socket;
                futureAsyncHttpResponse.setParent(socket);
                return;
            }
        }
        reportConnectedCompleted(futureAsyncHttpResponse, new IllegalArgumentException("invalid uri=" + asyncHttpRequest.getUri() + " middlewares=" + this.mMiddleware), null, asyncHttpRequest, httpConnectCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSocket(AsyncHttpRequest asyncHttpRequest, int i, FutureAsyncHttpResponse futureAsyncHttpResponse, HttpConnectCallback httpConnectCallback, AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        final AnonymousClass4 anonymousClass4 = new AnonymousClass4(asyncHttpRequest, futureAsyncHttpResponse, asyncHttpRequest, httpConnectCallback, onResponseCompleteData, i);
        onResponseCompleteData.sendHeadersCallback = new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncHttpClient.5
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    anonymousClass4.report(exc);
                } else {
                    anonymousClass4.onHeadersSent();
                }
            }
        };
        onResponseCompleteData.receiveHeadersCallback = new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncHttpClient.6
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (exc != null) {
                    anonymousClass4.report(exc);
                } else {
                    anonymousClass4.onHeadersReceived();
                }
            }
        };
        onResponseCompleteData.response = anonymousClass4;
        anonymousClass4.setSocket(onResponseCompleteData.socket);
        Iterator<AsyncHttpClientMiddleware> it = this.mMiddleware.iterator();
        while (it.hasNext() && !it.next().exchangeHeaders(onResponseCompleteData)) {
        }
    }

    public static AsyncHttpClient getDefaultInstance() {
        if (mDefaultInstance == null) {
            mDefaultInstance = new AsyncHttpClient(AsyncServer.getDefault());
        }
        return mDefaultInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getTimeoutRemaining(AsyncHttpRequest asyncHttpRequest) {
        return asyncHttpRequest.getTimeout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public <T> void d(final RequestCallback<T> requestCallback, final SimpleFuture<T> simpleFuture, final AsyncHttpResponse asyncHttpResponse, final Exception exc, final T t) {
        this.mServer.post(new Runnable() { // from class: com.koushikdutta.async.http.AsyncHttpClient.7
            @Override // java.lang.Runnable
            public void run() {
                AsyncHttpClient.this.invokeWithAffinity(requestCallback, simpleFuture, asyncHttpResponse, exc, t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeConnect(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse) {
        if (requestCallback != null) {
            requestCallback.onConnect(asyncHttpResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeProgress(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse, long j, long j2) {
        if (requestCallback != null) {
            requestCallback.onProgress(asyncHttpResponse, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void invokeWithAffinity(RequestCallback<T> requestCallback, SimpleFuture<T> simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, T t) {
        if ((exc != null ? simpleFuture.setComplete(exc) : simpleFuture.setComplete((SimpleFuture<T>) t)) && requestCallback != null) {
            requestCallback.onCompleted(exc, asyncHttpResponse, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportConnectedCompleted(FutureAsyncHttpResponse futureAsyncHttpResponse, Exception exc, AsyncHttpResponseImpl asyncHttpResponseImpl, AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        boolean complete;
        futureAsyncHttpResponse.scheduled.cancel();
        if (exc != null) {
            asyncHttpRequest.loge("Connection error", exc);
            complete = futureAsyncHttpResponse.setComplete(exc);
        } else {
            asyncHttpRequest.logd("Connection successful");
            complete = futureAsyncHttpResponse.setComplete((FutureAsyncHttpResponse) asyncHttpResponseImpl);
        }
        if (complete) {
            httpConnectCallback.onConnectCompleted(exc, asyncHttpResponseImpl);
        } else if (asyncHttpResponseImpl != null) {
            asyncHttpResponseImpl.setDataCallback(new DataCallback.NullDataCallback());
            asyncHttpResponseImpl.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void setupAndroidProxy(AsyncHttpRequest asyncHttpRequest) {
        String hostAddress;
        if (asyncHttpRequest.proxyHost != null) {
            return;
        }
        try {
            List<Proxy> listSelect = ProxySelector.getDefault().select(URI.create(asyncHttpRequest.getUri().toString()));
            if (listSelect.isEmpty()) {
                return;
            }
            Proxy proxy = listSelect.get(0);
            if (proxy.type() == Proxy.Type.HTTP && (proxy.address() instanceof InetSocketAddress)) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                if (Build.VERSION.SDK_INT >= 14) {
                    hostAddress = inetSocketAddress.getHostString();
                } else {
                    InetAddress address = inetSocketAddress.getAddress();
                    hostAddress = address != null ? address.getHostAddress() : inetSocketAddress.getHostName();
                }
                asyncHttpRequest.enableProxy(hostAddress, inetSocketAddress.getPort());
            }
        } catch (Exception unused) {
        }
    }

    public Future<AsyncHttpResponse> execute(AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
        execute(asyncHttpRequest, 0, futureAsyncHttpResponse, httpConnectCallback);
        return futureAsyncHttpResponse;
    }

    public Future<ByteBufferList> executeByteBufferList(AsyncHttpRequest asyncHttpRequest, DownloadCallback downloadCallback) {
        return execute(asyncHttpRequest, new ByteBufferListParser(), downloadCallback);
    }

    public Future<File> executeFile(AsyncHttpRequest asyncHttpRequest, String str, FileCallback fileCallback) {
        final File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            final FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
            SimpleFuture<File> simpleFuture = new SimpleFuture<File>() { // from class: com.koushikdutta.async.http.AsyncHttpClient.8
                @Override // com.koushikdutta.async.future.SimpleCancellable
                public void cancelCleanup() throws IOException {
                    try {
                        futureAsyncHttpResponse.get().setDataCallback(new DataCallback.NullDataCallback());
                        futureAsyncHttpResponse.get().close();
                    } catch (Exception unused) {
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    file.delete();
                }
            };
            simpleFuture.setParent(futureAsyncHttpResponse);
            execute(asyncHttpRequest, 0, futureAsyncHttpResponse, new AnonymousClass9(bufferedOutputStream, file, fileCallback, simpleFuture));
            return simpleFuture;
        } catch (FileNotFoundException e) {
            SimpleFuture simpleFuture2 = new SimpleFuture();
            simpleFuture2.setComplete((Exception) e);
            return simpleFuture2;
        }
    }

    public Future<JSONArray> executeJSONArray(AsyncHttpRequest asyncHttpRequest, JSONArrayCallback jSONArrayCallback) {
        return execute(asyncHttpRequest, new JSONArrayParser(), jSONArrayCallback);
    }

    public Future<JSONObject> executeJSONObject(AsyncHttpRequest asyncHttpRequest, JSONObjectCallback jSONObjectCallback) {
        return execute(asyncHttpRequest, new JSONObjectParser(), jSONObjectCallback);
    }

    public Future<String> executeString(AsyncHttpRequest asyncHttpRequest, StringCallback stringCallback) {
        return execute(asyncHttpRequest, new StringParser(), stringCallback);
    }

    public Collection<AsyncHttpClientMiddleware> getMiddleware() {
        return this.mMiddleware;
    }

    public AsyncSSLSocketMiddleware getSSLSocketMiddleware() {
        return this.sslSocketMiddleware;
    }

    public AsyncServer getServer() {
        return this.mServer;
    }

    public AsyncSocketMiddleware getSocketMiddleware() {
        return this.socketMiddleware;
    }

    public void insertMiddleware(AsyncHttpClientMiddleware asyncHttpClientMiddleware) {
        this.mMiddleware.add(0, asyncHttpClientMiddleware);
    }

    public Future<WebSocket> websocket(AsyncHttpRequest asyncHttpRequest, String str, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket(asyncHttpRequest, str != null ? new String[]{str} : null, webSocketConnectCallback);
    }

    public Future<AsyncHttpResponse> execute(String str, HttpConnectCallback httpConnectCallback) {
        return execute(new AsyncHttpGet(str), httpConnectCallback);
    }

    public Future<WebSocket> websocket(final AsyncHttpRequest asyncHttpRequest, String[] strArr, final WebSocketConnectCallback webSocketConnectCallback) {
        WebSocketImpl.addWebSocketUpgradeHeaders(asyncHttpRequest, strArr);
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(execute(asyncHttpRequest, new HttpConnectCallback() { // from class: dc.ca1
            @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                AsyncHttpClient.e(simpleFuture, webSocketConnectCallback, asyncHttpRequest, exc, asyncHttpResponse);
            }
        }));
        return simpleFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute(final AsyncHttpRequest asyncHttpRequest, final int i, final FutureAsyncHttpResponse futureAsyncHttpResponse, final HttpConnectCallback httpConnectCallback) {
        if (this.mServer.isAffinityThread()) {
            executeAffinity(asyncHttpRequest, i, futureAsyncHttpResponse, httpConnectCallback);
        } else {
            this.mServer.post(new Runnable() { // from class: com.koushikdutta.async.http.AsyncHttpClient.1
                @Override // java.lang.Runnable
                public void run() {
                    AsyncHttpClient.this.executeAffinity(asyncHttpRequest, i, futureAsyncHttpResponse, httpConnectCallback);
                }
            });
        }
    }

    public <T> SimpleFuture<T> execute(AsyncHttpRequest asyncHttpRequest, final AsyncParser<T> asyncParser, final RequestCallback<T> requestCallback) {
        FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
        final SimpleFuture<T> simpleFuture = new SimpleFuture<>();
        execute(asyncHttpRequest, 0, futureAsyncHttpResponse, new HttpConnectCallback() { // from class: dc.da1
            @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                this.a.b(requestCallback, simpleFuture, asyncParser, exc, asyncHttpResponse);
            }
        });
        simpleFuture.setParent(futureAsyncHttpResponse);
        return simpleFuture;
    }

    public Future<WebSocket> websocket(String str, String str2, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket(new AsyncHttpGet(str.replace("ws://", "http://").replace("wss://", "https://")), str2, webSocketConnectCallback);
    }

    public Future<WebSocket> websocket(String str, String[] strArr, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket(new AsyncHttpGet(str.replace("ws://", "http://").replace("wss://", "https://")), strArr, webSocketConnectCallback);
    }
}
