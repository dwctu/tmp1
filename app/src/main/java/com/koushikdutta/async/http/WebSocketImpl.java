package com.koushikdutta.async.http;

import android.text.TextUtils;
import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes3.dex */
public class WebSocketImpl implements WebSocket {
    public static final String MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private DataCallback mDataCallback;
    public CompletedCallback mExceptionCallback;
    public HybiParser mParser;
    private WebSocket.PingCallback mPingCallback;
    private WebSocket.PongCallback mPongCallback;
    public BufferedDataSink mSink;
    private AsyncSocket mSocket;
    private WebSocket.StringCallback mStringCallback;
    private LinkedList<ByteBufferList> pending;
    public String protocol;

    public WebSocketImpl(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) throws NoSuchAlgorithmException {
        this(asyncHttpServerRequest.getSocket());
        String strSHA1 = SHA1(asyncHttpServerRequest.getHeaders().get("Sec-WebSocket-Key") + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        asyncHttpServerRequest.getHeaders().get(HttpHeaders.ORIGIN);
        asyncHttpServerResponse.code(101);
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.UPGRADE, "WebSocket");
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        asyncHttpServerResponse.getHeaders().set("Sec-WebSocket-Accept", strSHA1);
        String str = asyncHttpServerRequest.getHeaders().get("Sec-WebSocket-Protocol");
        if (!TextUtils.isEmpty(str)) {
            asyncHttpServerResponse.getHeaders().set("Sec-WebSocket-Protocol", str);
        }
        asyncHttpServerResponse.writeHead();
        setupParser(false, false);
    }

    private static String SHA1(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str) {
        this.mSink.write(new ByteBufferList(ByteBuffer.wrap(this.mParser.pingFrame(str))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAndEmit(ByteBufferList byteBufferList) {
        if (this.pending == null) {
            Util.emitAllData(this, byteBufferList);
            if (byteBufferList.remaining() > 0) {
                LinkedList<ByteBufferList> linkedList = new LinkedList<>();
                this.pending = linkedList;
                linkedList.add(byteBufferList);
                return;
            }
            return;
        }
        while (!isPaused()) {
            ByteBufferList byteBufferListRemove = this.pending.remove();
            Util.emitAllData(this, byteBufferListRemove);
            if (byteBufferListRemove.remaining() > 0) {
                this.pending.add(0, byteBufferListRemove);
            }
        }
        if (this.pending.size() == 0) {
            this.pending = null;
        }
    }

    public static void addWebSocketUpgradeHeaders(AsyncHttpRequest asyncHttpRequest, String... strArr) {
        Headers headers = asyncHttpRequest.getHeaders();
        String strEncodeToString = Base64.encodeToString(toByteArray(UUID.randomUUID()), 2);
        headers.set("Sec-WebSocket-Version", "13");
        headers.set("Sec-WebSocket-Key", strEncodeToString);
        headers.set("Sec-WebSocket-Extensions", "x-webkit-deflate-frame");
        headers.set(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        headers.set(HttpHeaders.UPGRADE, "websocket");
        if (strArr != null) {
            for (String str : strArr) {
                headers.add("Sec-WebSocket-Protocol", str);
            }
        }
        headers.set(HttpHeaders.PRAGMA, "no-cache");
        headers.set(HttpHeaders.CACHE_CONTROL, "no-cache");
        if (TextUtils.isEmpty(asyncHttpRequest.getHeaders().get("User-Agent"))) {
            asyncHttpRequest.getHeaders().set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str) {
        this.mSink.write(new ByteBufferList(ByteBuffer.wrap(this.mParser.pongFrame(str))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(byte[] bArr) {
        this.mSink.write(new ByteBufferList(this.mParser.frame(bArr)));
    }

    public static WebSocket finishHandshake(Headers headers, AsyncHttpResponse asyncHttpResponse) {
        String str;
        String str2;
        if (asyncHttpResponse == null || asyncHttpResponse.code() != 101 || !"websocket".equalsIgnoreCase(asyncHttpResponse.headers().get(HttpHeaders.UPGRADE)) || (str = asyncHttpResponse.headers().get("Sec-WebSocket-Accept")) == null || (str2 = headers.get("Sec-WebSocket-Key")) == null) {
            return null;
        }
        if (!str.equalsIgnoreCase(SHA1(str2 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").trim())) {
            return null;
        }
        String str3 = headers.get("Sec-WebSocket-Extensions");
        boolean z = false;
        if (str3 != null && str3.equals("x-webkit-deflate-frame")) {
            z = true;
        }
        WebSocketImpl webSocketImpl = new WebSocketImpl(asyncHttpResponse.detachSocket());
        webSocketImpl.protocol = asyncHttpResponse.headers().get("Sec-WebSocket-Protocol");
        webSocketImpl.setupParser(true, z);
        return webSocketImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(byte[] bArr, int i, int i2) {
        this.mSink.write(new ByteBufferList(this.mParser.frame(bArr, i, i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(String str) {
        this.mSink.write(new ByteBufferList(this.mParser.frame(str)));
    }

    private void setupParser(boolean z, boolean z2) {
        HybiParser hybiParser = new HybiParser(this.mSocket) { // from class: com.koushikdutta.async.http.WebSocketImpl.1
            @Override // com.koushikdutta.async.http.HybiParser
            public void onDisconnect(int i, String str) {
                WebSocketImpl.this.mSocket.close();
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void onMessage(byte[] bArr) {
                WebSocketImpl.this.addAndEmit(new ByteBufferList(bArr));
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void onPing(String str) {
                if (WebSocketImpl.this.mPingCallback != null) {
                    WebSocketImpl.this.mPingCallback.onPingReceived(str);
                }
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void onPong(String str) {
                if (WebSocketImpl.this.mPongCallback != null) {
                    WebSocketImpl.this.mPongCallback.onPongReceived(str);
                }
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void report(Exception exc) {
                CompletedCallback completedCallback = WebSocketImpl.this.mExceptionCallback;
                if (completedCallback != null) {
                    completedCallback.onCompleted(exc);
                }
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void sendFrame(byte[] bArr) {
                WebSocketImpl.this.mSink.write(new ByteBufferList(bArr));
            }

            @Override // com.koushikdutta.async.http.HybiParser
            public void onMessage(String str) {
                if (WebSocketImpl.this.mStringCallback != null) {
                    WebSocketImpl.this.mStringCallback.onStringAvailable(str);
                }
            }
        };
        this.mParser = hybiParser;
        hybiParser.setMasking(z);
        this.mParser.setDeflate(z2);
        if (this.mSocket.isPaused()) {
            this.mSocket.resume();
        }
    }

    private static byte[] toByteArray(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.mSocket.close();
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.mSocket.end();
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.mSocket.getClosedCallback();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.mDataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.mExceptionCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public WebSocket.PongCallback getPongCallback() {
        return this.mPongCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public String getProtocol() {
        return this.protocol;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public WebSocket.StringCallback getStringCallback() {
        return this.mStringCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.mSink.getWriteableCallback();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public boolean isBuffering() {
        return this.mSink.remaining() > 0;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return false;
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.mSocket.isOpen();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.mSocket.isPaused();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.mSocket.pause();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void ping(final String str) {
        getServer().post(new Runnable() { // from class: dc.ma1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(str);
            }
        });
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void pong(final String str) {
        getServer().post(new Runnable() { // from class: dc.ka1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(str);
            }
        });
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.mSocket.resume();
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(final byte[] bArr) {
        getServer().post(new Runnable() { // from class: dc.la1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(bArr);
            }
        });
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.mSocket.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.mExceptionCallback = completedCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setPingCallback(WebSocket.PingCallback pingCallback) {
        this.mPingCallback = pingCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setPongCallback(WebSocket.PongCallback pongCallback) {
        this.mPongCallback = pongCallback;
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void setStringCallback(WebSocket.StringCallback stringCallback) {
        this.mStringCallback = stringCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.mSink.setWriteableCallback(writableCallback);
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        send(byteBufferList.getAllByteArray());
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(final byte[] bArr, final int i, final int i2) {
        getServer().post(new Runnable() { // from class: dc.na1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(bArr, i, i2);
            }
        });
    }

    @Override // com.koushikdutta.async.http.WebSocket
    public void send(final String str) {
        getServer().post(new Runnable() { // from class: dc.ja1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(str);
            }
        });
    }

    public WebSocketImpl(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
        this.mSink = new BufferedDataSink(asyncSocket);
    }
}
