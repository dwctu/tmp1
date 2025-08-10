package com.koushikdutta.async.http.server;

import android.annotation.TargetApi;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.ValueCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.server.AsyncHttpServerRouter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

@TargetApi(5)
/* loaded from: classes3.dex */
public class AsyncHttpServer extends AsyncHttpServerRouter {
    private static Hashtable<Integer, String> mCodes;
    public CompletedCallback mCompletedCallback;
    public ArrayList<AsyncServerSocket> mListeners = new ArrayList<>();
    public ListenCallback mListenCallback = new AnonymousClass1();

    /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$1, reason: invalid class name */
    public class AnonymousClass1 implements ListenCallback {

        /* renamed from: com.koushikdutta.async.http.server.AsyncHttpServer$1$1, reason: invalid class name and collision with other inner class name */
        public class C00611 extends AsyncHttpServerRouter.AsyncHttpServerRequestImpl {
            public String fullPath;
            public boolean handled;
            public boolean hasContinued;
            public final ValueCallback<Exception> onException;
            public final Runnable onFinally;
            public String path;
            public HttpServerRequestCallback requestCallback;
            public boolean requestComplete;
            public AsyncHttpServerResponseImpl res;
            public boolean responseComplete;
            public AsyncHttpServerRouter.AsyncHttpServerRequestImpl self;
            public final /* synthetic */ AsyncSocket val$socket;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00611(AsyncSocket asyncSocket) {
                super();
                this.val$socket = asyncSocket;
                this.self = this;
                this.onFinally = new Runnable() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                };
                this.onException = new ValueCallback<Exception>() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.1.1.2
                    @Override // com.koushikdutta.async.callback.ValueCallback
                    public void onResult(Exception exc) {
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void handleOnCompleted() {
                if (this.requestComplete && this.responseComplete && !AsyncHttpServer.this.isSwitchingProtocols(this.res)) {
                    if (AsyncHttpServer.this.isKeepAlive(this.self, this.res)) {
                        AnonymousClass1.this.onAccepted(this.val$socket);
                    } else {
                        this.val$socket.close();
                    }
                }
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
            public String getPath() {
                return this.path;
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
            public Multimap getQuery() {
                String[] strArrSplit = this.fullPath.split("\\?", 2);
                return strArrSplit.length < 2 ? new Multimap() : Multimap.parseQuery(strArrSplit[1]);
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
            public String getUrl() {
                return this.fullPath;
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl
            public AsyncHttpRequestBody onBody(Headers headers) {
                String[] strArrSplit = getStatusLine().split(" ");
                String str = strArrSplit[1];
                this.fullPath = str;
                String strDecode = URLDecoder.decode(str.split("\\?")[0]);
                this.path = strDecode;
                String str2 = strArrSplit[0];
                this.method = str2;
                AsyncHttpServerRouter.RouteMatch routeMatchRoute = AsyncHttpServer.this.route(str2, strDecode);
                if (routeMatchRoute == null) {
                    return null;
                }
                this.matcher = routeMatchRoute.matcher;
                this.requestCallback = routeMatchRoute.callback;
                AsyncHttpRequestBodyProvider asyncHttpRequestBodyProvider = routeMatchRoute.bodyCallback;
                if (asyncHttpRequestBodyProvider == null) {
                    return null;
                }
                return asyncHttpRequestBodyProvider.getBody(headers);
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl, com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                if (AsyncHttpServer.this.isSwitchingProtocols(this.res)) {
                    return;
                }
                this.requestComplete = true;
                super.onCompleted(exc);
                this.mSocket.setDataCallback(new DataCallback.NullDataCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.1.1.5
                    @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
                    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                        super.onDataAvailable(dataEmitter, byteBufferList);
                        C00611.this.mSocket.close();
                    }
                });
                if (exc != null) {
                    this.mSocket.close();
                    return;
                }
                handleOnCompleted();
                if (!getBody().readFullyOnRequest() || this.handled) {
                    return;
                }
                onRequest();
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl
            public void onHeadersReceived() {
                Headers headers = getHeaders();
                if (!this.hasContinued && "100-continue".equals(headers.get(HttpHeaders.EXPECT))) {
                    pause();
                    Util.writeAll(this.mSocket, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), new CompletedCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.1.1.3
                        @Override // com.koushikdutta.async.callback.CompletedCallback
                        public void onCompleted(Exception exc) {
                            C00611.this.resume();
                            if (exc != null) {
                                C00611.this.report(exc);
                                return;
                            }
                            C00611 c00611 = C00611.this;
                            c00611.hasContinued = true;
                            c00611.onHeadersReceived();
                        }
                    });
                    return;
                }
                AsyncHttpServerResponseImpl asyncHttpServerResponseImpl = new AsyncHttpServerResponseImpl(this.val$socket, this) { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.1.1.4
                    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponseImpl
                    public void onEnd() {
                        C00611.this.responseComplete = true;
                        super.onEnd();
                        this.mSocket.setEndCallback(null);
                        AsyncHttpServer.this.onResponseCompleted(getRequest(), C00611.this.res);
                        C00611.this.handleOnCompleted();
                    }

                    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponseImpl
                    public void report(Exception exc) {
                        super.report(exc);
                        if (exc != null) {
                            C00611.this.val$socket.setDataCallback(new DataCallback.NullDataCallback());
                            C00611.this.val$socket.setEndCallback(new CompletedCallback.NullCompletedCallback());
                            C00611.this.val$socket.close();
                        }
                    }
                };
                this.res = asyncHttpServerResponseImpl;
                boolean zOnRequest = AsyncHttpServer.this.onRequest(this, asyncHttpServerResponseImpl);
                this.handled = zOnRequest;
                if (zOnRequest) {
                    return;
                }
                if (this.requestCallback == null) {
                    this.res.code(404);
                    this.res.end();
                } else if (!getBody().readFullyOnRequest() || this.requestComplete) {
                    onRequest();
                }
            }

            public void onRequest() {
                AsyncHttpServer.this.onRequest(this.requestCallback, this, this.res);
            }

            @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl
            public AsyncHttpRequestBody onUnknownBody(Headers headers) {
                return AsyncHttpServer.this.onUnknownBody(headers);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onAccepted(AsyncSocket asyncSocket) {
            new C00611(asyncSocket).setSocket(asyncSocket);
            asyncSocket.resume();
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            AsyncHttpServer.this.report(exc);
        }

        @Override // com.koushikdutta.async.callback.ListenCallback
        public void onListening(AsyncServerSocket asyncServerSocket) {
            AsyncHttpServer.this.mListeners.add(asyncServerSocket);
        }
    }

    public interface WebSocketRequestCallback {
        void onConnected(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest);
    }

    static {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        mCodes = hashtable;
        hashtable.put(200, "OK");
        mCodes.put(202, "Accepted");
        mCodes.put(206, "Partial Content");
        mCodes.put(101, "Switching Protocols");
        mCodes.put(301, "Moved Permanently");
        mCodes.put(302, "Found");
        mCodes.put(304, "Not Modified");
        mCodes.put(400, "Bad Request");
        mCodes.put(404, "Not Found");
        mCodes.put(500, "Internal Server Error");
    }

    public static String getResponseCodeDescription(int i) {
        String str = mCodes.get(Integer.valueOf(i));
        return str == null ? "Unknown" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(Exception exc) {
        CompletedCallback completedCallback = this.mCompletedCallback;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public CompletedCallback getErrorCallback() {
        return this.mCompletedCallback;
    }

    public ListenCallback getListenCallback() {
        return this.mListenCallback;
    }

    public boolean isKeepAlive(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return HttpUtil.isKeepAlive(asyncHttpServerResponse.getHttpVersion(), asyncHttpServerRequest.getHeaders());
    }

    public boolean isSwitchingProtocols(AsyncHttpServerResponse asyncHttpServerResponse) {
        return asyncHttpServerResponse.code() == 101;
    }

    public AsyncServerSocket listen(AsyncServer asyncServer, int i) {
        return asyncServer.listen(null, i, this.mListenCallback);
    }

    public void listenSecure(final int i, final SSLContext sSLContext) throws InterruptedException {
        AsyncServer.getDefault().listen(null, i, new ListenCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.2
            @Override // com.koushikdutta.async.callback.ListenCallback
            public void onAccepted(AsyncSocket asyncSocket) {
                AsyncSSLSocketWrapper.handshake(asyncSocket, null, i, sSLContext.createSSLEngine(), null, null, false, new AsyncSSLSocketWrapper.HandshakeCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServer.2.1
                    @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
                    public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                        if (asyncSSLSocket != null) {
                            AsyncHttpServer.this.mListenCallback.onAccepted(asyncSSLSocket);
                        }
                    }
                });
            }

            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                AsyncHttpServer.this.mListenCallback.onCompleted(exc);
            }

            @Override // com.koushikdutta.async.callback.ListenCallback
            public void onListening(AsyncServerSocket asyncServerSocket) {
                AsyncHttpServer.this.mListenCallback.onListening(asyncServerSocket);
            }
        });
    }

    public void onRequest(HttpServerRequestCallback httpServerRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        if (httpServerRequestCallback != null) {
            try {
                httpServerRequestCallback.onRequest(asyncHttpServerRequest, asyncHttpServerResponse);
            } catch (Exception unused) {
                asyncHttpServerResponse.code(500);
                asyncHttpServerResponse.end();
            }
        }
    }

    public boolean onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return false;
    }

    public void onResponseCompleted(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
    }

    public AsyncHttpRequestBody onUnknownBody(Headers headers) {
        return new UnknownRequestBody(headers.get("Content-Type"));
    }

    public void setErrorCallback(CompletedCallback completedCallback) {
        this.mCompletedCallback = completedCallback;
    }

    public void stop() {
        ArrayList<AsyncServerSocket> arrayList = this.mListeners;
        if (arrayList != null) {
            Iterator<AsyncServerSocket> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    public AsyncServerSocket listen(int i) {
        return listen(AsyncServer.getDefault(), i);
    }
}
