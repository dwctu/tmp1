package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.parser.AsyncParser;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface AsyncHttpServerResponse extends DataSink, CompletedCallback {
    int code();

    AsyncHttpServerResponse code(int i);

    @Override // com.koushikdutta.async.DataSink
    void end();

    Headers getHeaders();

    String getHttpVersion();

    AsyncHttpServerRequest getRequest();

    AsyncSocket getSocket();

    @Override // com.koushikdutta.async.callback.CompletedCallback
    void onCompleted(Exception exc);

    void proxy(AsyncHttpResponse asyncHttpResponse);

    void redirect(String str);

    void send(String str);

    void send(String str, ByteBufferList byteBufferList);

    void send(String str, String str2);

    void send(String str, ByteBuffer byteBuffer);

    void send(String str, byte[] bArr);

    void send(JSONArray jSONArray);

    void send(JSONObject jSONObject);

    <T> void sendBody(AsyncParser<T> asyncParser, T t);

    void sendFile(File file);

    void sendStream(InputStream inputStream, long j);

    void setContentType(String str);

    void setHttpVersion(String str);

    void setSocket(AsyncSocket asyncSocket);

    void writeHead();
}
