package com.koushikdutta.async.http;

import android.net.Uri;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.FailCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.Futures;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.ThenFutureCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.util.ArrayDeque;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Locale;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class AsyncSocketMiddleware extends SimpleMiddleware {
    public boolean connectAllAddresses;
    public Hashtable<String, ConnectionInfo> connectionInfo;
    public int idleTimeoutMs;
    public AsyncHttpClient mClient;
    public int maxConnectionCount;
    public int port;
    public InetSocketAddress proxyAddress;
    public String proxyHost;
    public int proxyPort;
    public String scheme;

    public static class ConnectionInfo {
        public int openCount;
        public ArrayDeque<AsyncHttpClientMiddleware.GetSocketData> queue = new ArrayDeque<>();
        public ArrayDeque<IdleSocketHolder> sockets = new ArrayDeque<>();
    }

    public class IdleSocketHolder {
        public long idleTime = System.currentTimeMillis();
        public AsyncSocket socket;

        public IdleSocketHolder(AsyncSocket asyncSocket) {
            this.socket = asyncSocket;
        }
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient, String str, int i) {
        this.idleTimeoutMs = 300000;
        this.connectionInfo = new Hashtable<>();
        this.maxConnectionCount = Integer.MAX_VALUE;
        this.mClient = asyncHttpClient;
        this.scheme = str;
        this.port = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Future b(final int i, final AsyncHttpClientMiddleware.GetSocketData getSocketData, InetAddress[] inetAddressArr) throws Exception {
        return Futures.loopUntil(inetAddressArr, new ThenFutureCallback() { // from class: dc.ha1
            @Override // com.koushikdutta.async.future.ThenFutureCallback
            public final Future then(Object obj) {
                return this.a.h(i, getSocketData, (InetAddress) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, Exception exc) throws Exception {
        wrapCallback(getSocketData, uri, i, false, getSocketData.connectCallback).onConnectCompleted(exc, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, Exception exc, AsyncSocket asyncSocket) {
        if (asyncSocket == null) {
            return;
        }
        if (exc == null) {
            wrapCallback(getSocketData, uri, i, false, getSocketData.connectCallback).onConnectCompleted(null, asyncSocket);
            return;
        }
        getSocketData.request.logd("Recycling extra socket leftover from cancelled operation");
        idleSocket(asyncSocket);
        recycleSocket(asyncSocket, getSocketData.request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Future h(int i, AsyncHttpClientMiddleware.GetSocketData getSocketData, InetAddress inetAddress) throws Exception {
        final SimpleFuture simpleFuture = new SimpleFuture();
        String str = String.format(Locale.ENGLISH, "%s:%s", inetAddress, Integer.valueOf(i));
        getSocketData.request.logv("attempting connection to " + str);
        this.mClient.getServer().connectSocket(new InetSocketAddress(inetAddress, i), new ConnectCallback() { // from class: dc.oa1
            @Override // com.koushikdutta.async.callback.ConnectCallback
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                simpleFuture.setComplete(exc, (Exception) asyncSocket);
            }
        });
        return simpleFuture;
    }

    private ConnectionInfo getOrCreateConnectionInfo(String str) {
        ConnectionInfo connectionInfo = this.connectionInfo.get(str);
        if (connectionInfo != null) {
            return connectionInfo;
        }
        ConnectionInfo connectionInfo2 = new ConnectionInfo();
        this.connectionInfo.put(str, connectionInfo2);
        return connectionInfo2;
    }

    private void idleSocket(final AsyncSocket asyncSocket) {
        asyncSocket.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncSocketMiddleware.2
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                asyncSocket.setClosedCallback(null);
                asyncSocket.close();
            }
        });
        asyncSocket.setWriteableCallback(null);
        asyncSocket.setDataCallback(new DataCallback.NullDataCallback() { // from class: com.koushikdutta.async.http.AsyncSocketMiddleware.3
            @Override // com.koushikdutta.async.callback.DataCallback.NullDataCallback, com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                super.onDataAvailable(dataEmitter, byteBufferList);
                byteBufferList.recycle();
                asyncSocket.setClosedCallback(null);
                asyncSocket.close();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeCleanupConnectionInfo(String str) {
        ConnectionInfo connectionInfo = this.connectionInfo.get(str);
        if (connectionInfo == null) {
            return;
        }
        while (!connectionInfo.sockets.isEmpty()) {
            IdleSocketHolder idleSocketHolderPeekLast = connectionInfo.sockets.peekLast();
            AsyncSocket asyncSocket = idleSocketHolderPeekLast.socket;
            if (idleSocketHolderPeekLast.idleTime + this.idleTimeoutMs > System.currentTimeMillis()) {
                break;
            }
            connectionInfo.sockets.pop();
            asyncSocket.setClosedCallback(null);
            asyncSocket.close();
        }
        if (connectionInfo.openCount == 0 && connectionInfo.queue.isEmpty() && connectionInfo.sockets.isEmpty()) {
            this.connectionInfo.remove(str);
        }
    }

    private void nextConnection(AsyncHttpRequest asyncHttpRequest) {
        Uri uri = asyncHttpRequest.getUri();
        String strComputeLookup = computeLookup(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
        synchronized (this) {
            ConnectionInfo connectionInfo = this.connectionInfo.get(strComputeLookup);
            if (connectionInfo == null) {
                return;
            }
            connectionInfo.openCount--;
            while (connectionInfo.openCount < this.maxConnectionCount && connectionInfo.queue.size() > 0) {
                AsyncHttpClientMiddleware.GetSocketData getSocketDataRemove = connectionInfo.queue.remove();
                SimpleCancellable simpleCancellable = (SimpleCancellable) getSocketDataRemove.socketCancellable;
                if (!simpleCancellable.isCancelled()) {
                    simpleCancellable.setParent(getSocket(getSocketDataRemove));
                }
            }
            maybeCleanupConnectionInfo(strComputeLookup);
        }
    }

    private void recycleSocket(AsyncSocket asyncSocket, AsyncHttpRequest asyncHttpRequest) {
        final ArrayDeque<IdleSocketHolder> arrayDeque;
        if (asyncSocket == null) {
            return;
        }
        Uri uri = asyncHttpRequest.getUri();
        final String strComputeLookup = computeLookup(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
        final IdleSocketHolder idleSocketHolder = new IdleSocketHolder(asyncSocket);
        synchronized (this) {
            arrayDeque = getOrCreateConnectionInfo(strComputeLookup).sockets;
            arrayDeque.push(idleSocketHolder);
        }
        asyncSocket.setClosedCallback(new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncSocketMiddleware.1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                synchronized (AsyncSocketMiddleware.this) {
                    arrayDeque.remove(idleSocketHolder);
                    AsyncSocketMiddleware.this.maybeCleanupConnectionInfo(strComputeLookup);
                }
            }
        });
    }

    public String computeLookup(Uri uri, int i, String str, int i2) {
        String str2;
        if (str != null) {
            str2 = str + SignatureImpl.INNER_SEP + i2;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + SignatureImpl.INNER_SEP + i2;
        }
        return uri.getScheme() + ResourceConstants.CMT + uri.getHost() + SignatureImpl.INNER_SEP + i + "?proxy=" + str2;
    }

    public void disableProxy() {
        this.proxyPort = -1;
        this.proxyHost = null;
        this.proxyAddress = null;
    }

    public void enableProxy(String str, int i) {
        this.proxyHost = str;
        this.proxyPort = i;
        this.proxyAddress = null;
    }

    public boolean getConnectAllAddresses() {
        return this.connectAllAddresses;
    }

    public int getMaxConnectionCount() {
        return this.maxConnectionCount;
    }

    public int getSchemePort(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.scheme)) {
            return -1;
        }
        return uri.getPort() == -1 ? this.port : uri.getPort();
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(final AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        String host;
        int proxyPort;
        String str;
        final Uri uri = getSocketData.request.getUri();
        final int schemePort = getSchemePort(getSocketData.request.getUri());
        if (schemePort == -1) {
            return null;
        }
        getSocketData.state.put("socket-owner", this);
        ConnectionInfo orCreateConnectionInfo = getOrCreateConnectionInfo(computeLookup(uri, schemePort, getSocketData.request.getProxyHost(), getSocketData.request.getProxyPort()));
        synchronized (this) {
            int i = orCreateConnectionInfo.openCount;
            if (i >= this.maxConnectionCount) {
                SimpleCancellable simpleCancellable = new SimpleCancellable();
                orCreateConnectionInfo.queue.add(getSocketData);
                return simpleCancellable;
            }
            boolean z = true;
            orCreateConnectionInfo.openCount = i + 1;
            while (!orCreateConnectionInfo.sockets.isEmpty()) {
                IdleSocketHolder idleSocketHolderPop = orCreateConnectionInfo.sockets.pop();
                AsyncSocket asyncSocket = idleSocketHolderPop.socket;
                if (idleSocketHolderPop.idleTime + this.idleTimeoutMs < System.currentTimeMillis()) {
                    asyncSocket.setClosedCallback(null);
                    asyncSocket.close();
                } else if (asyncSocket.isOpen()) {
                    getSocketData.request.logd("Reusing keep-alive socket");
                    getSocketData.connectCallback.onConnectCompleted(null, asyncSocket);
                    SimpleCancellable simpleCancellable2 = new SimpleCancellable();
                    simpleCancellable2.setComplete();
                    return simpleCancellable2;
                }
            }
            if (this.connectAllAddresses && this.proxyHost == null && getSocketData.request.getProxyHost() == null) {
                getSocketData.request.logv("Resolving domain and connecting to all available addresses");
                SimpleFuture simpleFuture = new SimpleFuture();
                simpleFuture.setComplete(this.mClient.getServer().getAllByName(uri.getHost()).then(new ThenFutureCallback() { // from class: dc.fa1
                    @Override // com.koushikdutta.async.future.ThenFutureCallback
                    public final Future then(Object obj) {
                        return this.a.b(schemePort, getSocketData, (InetAddress[]) obj);
                    }
                }).fail(new FailCallback() { // from class: dc.ga1
                    @Override // com.koushikdutta.async.future.FailCallback
                    public final void fail(Exception exc) throws Exception {
                        this.a.d(getSocketData, uri, schemePort, exc);
                    }
                })).setCallback(new FutureCallback() { // from class: dc.ia1
                    @Override // com.koushikdutta.async.future.FutureCallback
                    public final void onCompleted(Exception exc, Object obj) {
                        this.a.f(getSocketData, uri, schemePort, exc, (AsyncSocket) obj);
                    }
                });
                return simpleFuture;
            }
            getSocketData.request.logd("Connecting socket");
            if (getSocketData.request.getProxyHost() == null && (str = this.proxyHost) != null) {
                getSocketData.request.enableProxy(str, this.proxyPort);
            }
            if (getSocketData.request.getProxyHost() != null) {
                host = getSocketData.request.getProxyHost();
                proxyPort = getSocketData.request.getProxyPort();
            } else {
                host = uri.getHost();
                proxyPort = schemePort;
                z = false;
            }
            if (z) {
                getSocketData.request.logv("Using proxy: " + host + SignatureImpl.INNER_SEP + proxyPort);
            }
            return this.mClient.getServer().connectSocket(host, proxyPort, wrapCallback(getSocketData, uri, schemePort, z, getSocketData.connectCallback));
        }
    }

    public boolean isKeepAlive(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        return HttpUtil.isKeepAlive(onResponseCompleteData.response.protocol(), onResponseCompleteData.response.headers()) && HttpUtil.isKeepAlive(Protocol.HTTP_1_1, onResponseCompleteData.request.getHeaders());
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        if (onResponseCompleteData.state.get("socket-owner") != this) {
            return;
        }
        try {
            idleSocket(onResponseCompleteData.socket);
            if (onResponseCompleteData.exception != null || !onResponseCompleteData.socket.isOpen()) {
                onResponseCompleteData.request.logv("closing out socket (exception)");
                onResponseCompleteData.socket.setClosedCallback(null);
                onResponseCompleteData.socket.close();
            } else if (isKeepAlive(onResponseCompleteData)) {
                onResponseCompleteData.request.logd("Recycling keep-alive socket");
                recycleSocket(onResponseCompleteData.socket, onResponseCompleteData.request);
            } else {
                onResponseCompleteData.request.logv("closing out socket (not keep alive)");
                onResponseCompleteData.socket.setClosedCallback(null);
                onResponseCompleteData.socket.close();
            }
        } finally {
            nextConnection(onResponseCompleteData.request);
        }
    }

    public void setConnectAllAddresses(boolean z) {
        this.connectAllAddresses = z;
    }

    public void setIdleTimeoutMs(int i) {
        this.idleTimeoutMs = i;
    }

    public void setMaxConnectionCount(int i) {
        this.maxConnectionCount = i;
    }

    public ConnectCallback wrapCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, boolean z, ConnectCallback connectCallback) {
        return connectCallback;
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        this(asyncHttpClient, "http", 80);
    }
}
