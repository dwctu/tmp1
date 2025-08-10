package com.koushikdutta.async.http.server;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class AsyncProxyServer extends AsyncHttpServer {
    public AsyncHttpClient proxyClient;

    public AsyncProxyServer(AsyncServer asyncServer) {
        this.proxyClient = new AsyncHttpClient(asyncServer);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServer
    public void onRequest(HttpServerRequestCallback httpServerRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, final AsyncHttpServerResponse asyncHttpServerResponse) throws Exception {
        Uri uri;
        super.onRequest(httpServerRequestCallback, asyncHttpServerRequest, asyncHttpServerResponse);
        if (httpServerRequestCallback != null) {
            return;
        }
        try {
            try {
                uri = Uri.parse(asyncHttpServerRequest.getPath());
            } catch (Exception unused) {
                String str = asyncHttpServerRequest.getHeaders().get(HttpHeaders.HOST);
                int i = 80;
                if (str != null) {
                    String[] strArrSplit = str.split(SignatureImpl.INNER_SEP, 2);
                    if (strArrSplit.length == 2) {
                        str = strArrSplit[0];
                        i = Integer.parseInt(strArrSplit[1]);
                    }
                }
                uri = Uri.parse("http://" + str + SignatureImpl.INNER_SEP + i + asyncHttpServerRequest.getPath());
            }
            if (uri.getScheme() == null) {
                throw new Exception("no host or full uri provided");
            }
            this.proxyClient.execute(new AsyncHttpRequest(uri, asyncHttpServerRequest.getMethod(), asyncHttpServerRequest.getHeaders()), new HttpConnectCallback() { // from class: com.koushikdutta.async.http.server.AsyncProxyServer.1
                @Override // com.koushikdutta.async.http.callback.HttpConnectCallback
                public void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                    if (exc == null) {
                        asyncHttpServerResponse.proxy(asyncHttpResponse);
                    } else {
                        asyncHttpServerResponse.code(500);
                        asyncHttpServerResponse.send(exc.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            asyncHttpServerResponse.code(500);
            asyncHttpServerResponse.send(e.getMessage());
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServer
    public boolean onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return true;
    }
}
