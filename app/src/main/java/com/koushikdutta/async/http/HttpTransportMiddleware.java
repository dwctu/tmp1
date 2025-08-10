package com.koushikdutta.async.http;

import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import java.io.IOException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes3.dex */
public class HttpTransportMiddleware extends SimpleMiddleware {
    public static boolean responseIsEmpty(int i) {
        return (i >= 100 && i <= 199) || i == 204 || i == 304;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public boolean exchangeHeaders(final AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        final BufferedDataSink bufferedDataSink;
        AsyncSocket asyncSocket;
        Protocol protocol = Protocol.get(onExchangeHeaderData.protocol);
        if (protocol != null && protocol != Protocol.HTTP_1_0 && protocol != Protocol.HTTP_1_1) {
            return super.exchangeHeaders(onExchangeHeaderData);
        }
        AsyncHttpRequest asyncHttpRequest = onExchangeHeaderData.request;
        AsyncHttpRequestBody body = asyncHttpRequest.getBody();
        if (body != null) {
            if (body.length() >= 0) {
                asyncHttpRequest.getHeaders().set(HttpHeaders.CONTENT_LENGTH, String.valueOf(body.length()));
                onExchangeHeaderData.response.sink(onExchangeHeaderData.socket);
            } else if (Close.ELEMENT.equals(asyncHttpRequest.getHeaders().get(HttpHeaders.CONNECTION))) {
                onExchangeHeaderData.response.sink(onExchangeHeaderData.socket);
            } else {
                asyncHttpRequest.getHeaders().set(HttpHeaders.TRANSFER_ENCODING, "Chunked");
                onExchangeHeaderData.response.sink(new ChunkedOutputFilter(onExchangeHeaderData.socket));
            }
        }
        String prefixString = asyncHttpRequest.getHeaders().toPrefixString(asyncHttpRequest.getRequestLine().toString());
        byte[] bytes = prefixString.getBytes();
        if (body != null && body.length() >= 0 && body.length() + bytes.length < 1024) {
            BufferedDataSink bufferedDataSink2 = new BufferedDataSink(onExchangeHeaderData.response.sink());
            bufferedDataSink2.forceBuffering(true);
            onExchangeHeaderData.response.sink(bufferedDataSink2);
            bufferedDataSink = bufferedDataSink2;
            asyncSocket = bufferedDataSink2;
        } else {
            bufferedDataSink = null;
            asyncSocket = onExchangeHeaderData.socket;
        }
        asyncHttpRequest.logv(IOUtils.LINE_SEPARATOR_UNIX + prefixString);
        final CompletedCallback completedCallback = onExchangeHeaderData.sendHeadersCallback;
        Util.writeAll(asyncSocket, bytes, new CompletedCallback() { // from class: com.koushikdutta.async.http.HttpTransportMiddleware.1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                Util.end(completedCallback, exc);
                BufferedDataSink bufferedDataSink3 = bufferedDataSink;
                if (bufferedDataSink3 != null) {
                    bufferedDataSink3.forceBuffering(false);
                    bufferedDataSink.setMaxBuffer(0);
                }
            }
        });
        LineEmitter.StringCallback stringCallback = new LineEmitter.StringCallback() { // from class: com.koushikdutta.async.http.HttpTransportMiddleware.2
            public Headers mRawHeaders = new Headers();
            public String statusLine;

            @Override // com.koushikdutta.async.LineEmitter.StringCallback
            public void onStringAvailable(String str) throws Exception {
                try {
                    String strTrim = str.trim();
                    if (this.statusLine == null) {
                        this.statusLine = strTrim;
                        return;
                    }
                    if (!TextUtils.isEmpty(strTrim)) {
                        this.mRawHeaders.addLine(strTrim);
                        return;
                    }
                    String[] strArrSplit = this.statusLine.split(" ", 3);
                    if (strArrSplit.length < 2) {
                        throw new Exception(new IOException("Not HTTP"));
                    }
                    onExchangeHeaderData.response.headers(this.mRawHeaders);
                    String str2 = strArrSplit[0];
                    onExchangeHeaderData.response.protocol(str2);
                    onExchangeHeaderData.response.code(Integer.parseInt(strArrSplit[1]));
                    onExchangeHeaderData.response.message(strArrSplit.length == 3 ? strArrSplit[2] : "");
                    onExchangeHeaderData.receiveHeadersCallback.onCompleted(null);
                    AsyncSocket asyncSocketSocket = onExchangeHeaderData.response.socket();
                    if (asyncSocketSocket == null) {
                        return;
                    }
                    DataEmitter bodyDecoder = (onExchangeHeaderData.request.hasBody() && !HttpTransportMiddleware.responseIsEmpty(onExchangeHeaderData.response.code())) ? HttpUtil.getBodyDecoder(asyncSocketSocket, Protocol.get(str2), this.mRawHeaders, false) : HttpUtil.EndEmitter.create(asyncSocketSocket.getServer(), null);
                    onExchangeHeaderData.response.emitter(bodyDecoder);
                } catch (Exception e) {
                    onExchangeHeaderData.receiveHeadersCallback.onCompleted(e);
                }
            }
        };
        LineEmitter lineEmitter = new LineEmitter();
        onExchangeHeaderData.socket.setDataCallback(lineEmitter);
        lineEmitter.setLineCallback(stringCallback);
        return true;
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
        Protocol protocol = Protocol.get(onRequestSentData.protocol);
        if ((protocol == null || protocol == Protocol.HTTP_1_0 || protocol == Protocol.HTTP_1_1) && (onRequestSentData.response.sink() instanceof ChunkedOutputFilter)) {
            onRequestSentData.response.sink().end();
        }
    }
}
