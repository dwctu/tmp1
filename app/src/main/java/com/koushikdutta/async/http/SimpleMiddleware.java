package com.koushikdutta.async.http;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;

/* loaded from: classes3.dex */
public class SimpleMiddleware implements AsyncHttpClientMiddleware {
    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public boolean exchangeHeaders(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        return false;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        return null;
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDecoderData onBodyDecoderData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedData onHeadersReceivedData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequest(AsyncHttpClientMiddleware.OnRequestData onRequestData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
    }

    @Override // com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public AsyncHttpRequest onResponseReady(AsyncHttpClientMiddleware.OnResponseReadyData onResponseReadyData) {
        return null;
    }
}
