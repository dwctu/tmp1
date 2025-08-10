package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

/* loaded from: classes3.dex */
public class AsyncSSLSocketMiddleware extends AsyncSocketMiddleware {
    public List<AsyncSSLEngineConfigurator> engineConfigurators;
    public HostnameVerifier hostnameVerifier;
    public SSLContext sslContext;
    public TrustManager[] trustManagers;

    /* renamed from: com.koushikdutta.async.http.AsyncSSLSocketMiddleware$2, reason: invalid class name */
    public class AnonymousClass2 implements ConnectCallback {
        public final /* synthetic */ ConnectCallback val$callback;
        public final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData val$data;
        public final /* synthetic */ int val$port;
        public final /* synthetic */ boolean val$proxied;
        public final /* synthetic */ Uri val$uri;

        public AnonymousClass2(ConnectCallback connectCallback, boolean z, AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i) {
            this.val$callback = connectCallback;
            this.val$proxied = z;
            this.val$data = getSocketData;
            this.val$uri = uri;
            this.val$port = i;
        }

        @Override // com.koushikdutta.async.callback.ConnectCallback
        public void onConnectCompleted(Exception exc, final AsyncSocket asyncSocket) {
            if (exc != null) {
                this.val$callback.onConnectCompleted(exc, asyncSocket);
                return;
            }
            if (!this.val$proxied) {
                AsyncSSLSocketMiddleware.this.tryHandshake(asyncSocket, this.val$data, this.val$uri, this.val$port, this.val$callback);
                return;
            }
            String str = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", this.val$uri.getHost(), Integer.valueOf(this.val$port), this.val$uri.getHost());
            this.val$data.request.logv("Proxying: " + str);
            Util.writeAll(asyncSocket, str.getBytes(), new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncSSLSocketMiddleware.2.1
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public void onCompleted(Exception exc2) {
                    if (exc2 != null) {
                        AnonymousClass2.this.val$callback.onConnectCompleted(exc2, asyncSocket);
                        return;
                    }
                    LineEmitter lineEmitter = new LineEmitter();
                    lineEmitter.setLineCallback(new LineEmitter.StringCallback() { // from class: com.koushikdutta.async.http.AsyncSSLSocketMiddleware.2.1.1
                        public String statusLine;

                        @Override // com.koushikdutta.async.LineEmitter.StringCallback
                        public void onStringAvailable(String str2) {
                            AnonymousClass2.this.val$data.request.logv(str2);
                            if (this.statusLine != null) {
                                if (TextUtils.isEmpty(str2.trim())) {
                                    asyncSocket.setDataCallback(null);
                                    asyncSocket.setEndCallback(null);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    AsyncSSLSocketMiddleware.this.tryHandshake(asyncSocket, anonymousClass2.val$data, anonymousClass2.val$uri, anonymousClass2.val$port, anonymousClass2.val$callback);
                                    return;
                                }
                                return;
                            }
                            String strTrim = str2.trim();
                            this.statusLine = strTrim;
                            if (strTrim.matches("HTTP/1.\\d 2\\d\\d .*")) {
                                return;
                            }
                            asyncSocket.setDataCallback(null);
                            asyncSocket.setEndCallback(null);
                            AnonymousClass2.this.val$callback.onConnectCompleted(new IOException("non 2xx status line: " + this.statusLine), asyncSocket);
                        }
                    });
                    asyncSocket.setDataCallback(lineEmitter);
                    asyncSocket.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.http.AsyncSSLSocketMiddleware.2.1.2
                        @Override // com.koushikdutta.async.callback.CompletedCallback
                        public void onCompleted(Exception exc3) {
                            if (!asyncSocket.isOpen() && exc3 == null) {
                                exc3 = new IOException("socket closed before proxy connect response");
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AnonymousClass2.this.val$callback.onConnectCompleted(exc3, asyncSocket);
                        }
                    });
                }
            });
        }
    }

    public AsyncSSLSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient, "https", 443);
        this.engineConfigurators = new ArrayList();
    }

    public void addEngineConfigurator(AsyncSSLEngineConfigurator asyncSSLEngineConfigurator) {
        this.engineConfigurators.add(asyncSSLEngineConfigurator);
    }

    public void clearEngineConfigurators() {
        this.engineConfigurators.clear();
    }

    public SSLEngine createConfiguredSSLEngine(AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i) {
        SSLContext sSLContext = getSSLContext();
        Iterator<AsyncSSLEngineConfigurator> it = this.engineConfigurators.iterator();
        SSLEngine sSLEngineCreateEngine = null;
        while (it.hasNext() && (sSLEngineCreateEngine = it.next().createEngine(sSLContext, str, i)) == null) {
        }
        Iterator<AsyncSSLEngineConfigurator> it2 = this.engineConfigurators.iterator();
        while (it2.hasNext()) {
            it2.next().configureEngine(sSLEngineCreateEngine, getSocketData, str, i);
        }
        return sSLEngineCreateEngine;
    }

    public AsyncSSLSocketWrapper.HandshakeCallback createHandshakeCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, final ConnectCallback connectCallback) {
        return new AsyncSSLSocketWrapper.HandshakeCallback() { // from class: com.koushikdutta.async.http.AsyncSSLSocketMiddleware.1
            @Override // com.koushikdutta.async.AsyncSSLSocketWrapper.HandshakeCallback
            public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                connectCallback.onConnectCompleted(exc, asyncSSLSocket);
            }
        };
    }

    public SSLContext getSSLContext() {
        SSLContext sSLContext = this.sslContext;
        return sSLContext != null ? sSLContext : AsyncSSLSocketWrapper.getDefaultSSLContext();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.trustManagers = trustManagerArr;
    }

    public void tryHandshake(AsyncSocket asyncSocket, AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, ConnectCallback connectCallback) {
        AsyncSSLSocketWrapper.handshake(asyncSocket, uri.getHost(), i, createConfiguredSSLEngine(getSocketData, uri.getHost(), i), this.trustManagers, this.hostnameVerifier, true, createHandshakeCallback(getSocketData, connectCallback));
    }

    @Override // com.koushikdutta.async.http.AsyncSocketMiddleware
    public ConnectCallback wrapCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, boolean z, ConnectCallback connectCallback) {
        return new AnonymousClass2(connectCallback, z, getSocketData, uri, i);
    }
}
