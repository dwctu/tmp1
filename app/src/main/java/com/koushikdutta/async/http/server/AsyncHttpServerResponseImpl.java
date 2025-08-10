package com.koushikdutta.async.http.server;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AsyncHttpServerResponseImpl implements AsyncHttpServerResponse {
    public CompletedCallback closedCallback;
    public boolean ended;
    public boolean mEnded;
    public AsyncHttpServerRequestImpl mRequest;
    public DataSink mSink;
    public AsyncSocket mSocket;
    public WritableCallback writable;
    private Headers mRawHeaders = new Headers();
    private long mContentLength = -1;
    public boolean headWritten = false;
    public int code = 200;
    public String httpVersion = "HTTP/1.1";

    public AsyncHttpServerResponseImpl(AsyncSocket asyncSocket, AsyncHttpServerRequestImpl asyncHttpServerRequestImpl) {
        this.mSocket = asyncSocket;
        this.mRequest = asyncHttpServerRequestImpl;
        if (HttpUtil.isKeepAlive(Protocol.HTTP_1_1, asyncHttpServerRequestImpl.getHeaders())) {
            this.mRawHeaders.set(HttpHeaders.CONNECTION, "Keep-Alive");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(boolean z, Exception exc) {
        if (exc != null) {
            report(exc);
            return;
        }
        if (z) {
            ChunkedOutputFilter chunkedOutputFilter = new ChunkedOutputFilter(this.mSocket);
            chunkedOutputFilter.setMaxBuffer(0);
            this.mSink = chunkedOutputFilter;
        } else {
            this.mSink = this.mSocket;
        }
        this.mSink.setClosedCallback(this.closedCallback);
        this.closedCallback = null;
        this.mSink.setWriteableCallback(this.writable);
        this.writable = null;
        if (this.ended) {
            end();
        } else {
            getServer().post(new Runnable() { // from class: dc.va1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        WritableCallback writeableCallback = getWriteableCallback();
        if (writeableCallback != null) {
            writeableCallback.onWriteable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Exception exc) {
        onEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(InputStream inputStream, Exception exc) throws IOException {
        StreamUtility.closeQuietly(inputStream);
        onEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(AsyncHttpResponse asyncHttpResponse, Exception exc) {
        asyncHttpResponse.setEndCallback(new CompletedCallback.NullCompletedCallback());
        asyncHttpResponse.setDataCallback(new DataCallback.NullDataCallback());
        end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(ByteBufferList byteBufferList, String str) {
        long jRemaining = byteBufferList.remaining();
        this.mContentLength = jRemaining;
        this.mRawHeaders.set(HttpHeaders.CONTENT_LENGTH, Long.toString(jRemaining));
        if (str != null) {
            this.mRawHeaders.set("Content-Type", str);
        }
        Util.writeAll(this, byteBufferList, new CompletedCallback() { // from class: dc.xa1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc) {
                this.a.f(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Exception exc) {
        end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(final InputStream inputStream) {
        Util.pump(inputStream, this.mContentLength, this, new CompletedCallback() { // from class: dc.qa1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc) throws IOException {
                this.a.h(inputStream, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public AsyncHttpServerResponse code(int i) {
        this.code = i;
        return this;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse, com.koushikdutta.async.DataSink
    public void end() {
        if (this.ended) {
            return;
        }
        this.ended = true;
        boolean z = this.headWritten;
        if (z && this.mSink == null) {
            return;
        }
        if (!z) {
            this.mRawHeaders.remove(HttpHeaders.TRANSFER_ENCODING);
        }
        DataSink dataSink = this.mSink;
        if (dataSink instanceof ChunkedOutputFilter) {
            dataSink.end();
            return;
        }
        if (this.headWritten) {
            onEnd();
        } else if (!this.mRequest.getMethod().equalsIgnoreCase(AsyncHttpHead.METHOD)) {
            send("text/html", "");
        } else {
            writeHead();
            onEnd();
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        DataSink dataSink = this.mSink;
        return dataSink != null ? dataSink.getClosedCallback() : this.closedCallback;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public Headers getHeaders() {
        return this.mRawHeaders;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public String getHttpVersion() {
        return this.httpVersion;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public AsyncHttpServerRequest getRequest() {
        return this.mRequest;
    }

    @Override // com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        DataSink dataSink = this.mSink;
        return dataSink != null ? dataSink.getWriteableCallback() : this.writable;
    }

    public void initFirstWrite() {
        final boolean z;
        if (this.headWritten) {
            return;
        }
        this.headWritten = true;
        String str = this.mRawHeaders.get(HttpHeaders.TRANSFER_ENCODING);
        if ("".equals(str)) {
            this.mRawHeaders.removeAll(HttpHeaders.TRANSFER_ENCODING);
        }
        boolean z2 = ("Chunked".equalsIgnoreCase(str) || str == null) && !Close.ELEMENT.equalsIgnoreCase(this.mRawHeaders.get(HttpHeaders.CONNECTION));
        if (this.mContentLength < 0) {
            String str2 = this.mRawHeaders.get(HttpHeaders.CONTENT_LENGTH);
            if (!TextUtils.isEmpty(str2)) {
                this.mContentLength = Long.valueOf(str2).longValue();
            }
        }
        if (this.mContentLength >= 0 || !z2) {
            z = false;
        } else {
            this.mRawHeaders.set(HttpHeaders.TRANSFER_ENCODING, "Chunked");
            z = true;
        }
        Util.writeAll(this.mSocket, this.mRawHeaders.toPrefixString(String.format(Locale.ENGLISH, "%s %s %s", this.httpVersion, Integer.valueOf(this.code), AsyncHttpServer.getResponseCodeDescription(this.code))).getBytes(), new CompletedCallback() { // from class: dc.ta1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc) {
                this.a.b(z, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        DataSink dataSink = this.mSink;
        return dataSink != null ? dataSink.isOpen() : this.mSocket.isOpen();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse, com.koushikdutta.async.callback.CompletedCallback
    public void onCompleted(Exception exc) {
        end();
    }

    public void onEnd() {
        this.mEnded = true;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void proxy(final AsyncHttpResponse asyncHttpResponse) {
        code(asyncHttpResponse.code());
        asyncHttpResponse.headers().removeAll(HttpHeaders.TRANSFER_ENCODING);
        asyncHttpResponse.headers().removeAll(HttpHeaders.CONTENT_ENCODING);
        asyncHttpResponse.headers().removeAll(HttpHeaders.CONNECTION);
        getHeaders().addAll(asyncHttpResponse.headers());
        asyncHttpResponse.headers().set(HttpHeaders.CONNECTION, Close.ELEMENT);
        Util.pump(asyncHttpResponse, this, new CompletedCallback() { // from class: dc.wa1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc) {
                this.a.j(asyncHttpResponse, exc);
            }
        });
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void redirect(String str) {
        code(302);
        this.mRawHeaders.set(HttpHeaders.LOCATION, str);
        end();
    }

    public void report(Exception exc) {
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str, byte[] bArr) {
        send(str, new ByteBufferList(bArr));
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public <T> void sendBody(AsyncParser<T> asyncParser, T t) {
        this.mRawHeaders.set("Content-Type", asyncParser.getMime());
        asyncParser.write(this, t, new CompletedCallback() { // from class: dc.sa1
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public final void onCompleted(Exception exc) {
                this.a.n(exc);
            }
        });
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void sendFile(File file) throws MalformedRangeException, StreamSkipException, NumberFormatException {
        try {
            if (this.mRawHeaders.get("Content-Type") == null) {
                this.mRawHeaders.set("Content-Type", AsyncHttpServerRouter.getContentType(file.getAbsolutePath()));
            }
            sendStream(new BufferedInputStream(new FileInputStream(file), 64000), file.length());
        } catch (FileNotFoundException unused) {
            code(404);
            end();
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void sendStream(final InputStream inputStream, long j) throws MalformedRangeException, StreamSkipException, NumberFormatException {
        long j2;
        long j3 = j - 1;
        String str = this.mRequest.getHeaders().get(HttpHeaders.RANGE);
        if (str != null) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length != 2 || !"bytes".equals(strArrSplit[0])) {
                code(TypedValues.CycleType.TYPE_PATH_ROTATE);
                end();
                return;
            }
            String[] strArrSplit2 = strArrSplit[1].split(Constants.FILENAME_SEQUENCE_SEPARATOR);
            try {
                if (strArrSplit2.length > 2) {
                    throw new MalformedRangeException();
                }
                long j4 = !TextUtils.isEmpty(strArrSplit2[0]) ? Long.parseLong(strArrSplit2[0]) : 0L;
                if (strArrSplit2.length == 2 && !TextUtils.isEmpty(strArrSplit2[1])) {
                    j3 = Long.parseLong(strArrSplit2[1]);
                }
                code(206);
                getHeaders().set(HttpHeaders.CONTENT_RANGE, String.format(Locale.ENGLISH, "bytes %d-%d/%d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j)));
                j2 = j4;
            } catch (Exception unused) {
                code(TypedValues.CycleType.TYPE_PATH_ROTATE);
                end();
                return;
            }
        } else {
            j2 = 0;
        }
        try {
            if (j2 != inputStream.skip(j2)) {
                throw new StreamSkipException("skip failed to skip requested amount");
            }
            long j5 = (j3 - j2) + 1;
            this.mContentLength = j5;
            this.mRawHeaders.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(j5));
            this.mRawHeaders.set(HttpHeaders.ACCEPT_RANGES, "bytes");
            if (this.mRequest.getMethod().equals(AsyncHttpHead.METHOD)) {
                writeHead();
                onEnd();
            } else {
                if (this.mContentLength != 0) {
                    getServer().post(new Runnable() { // from class: dc.ra1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.p(inputStream);
                        }
                    });
                    return;
                }
                writeHead();
                StreamUtility.closeQuietly(inputStream);
                onEnd();
            }
        } catch (Exception unused2) {
            code(500);
            end();
        }
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            dataSink.setClosedCallback(completedCallback);
        } else {
            this.closedCallback = completedCallback;
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void setContentType(String str) {
        this.mRawHeaders.set("Content-Type", str);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void setHttpVersion(String str) {
        this.httpVersion = str;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            dataSink.setWriteableCallback(writableCallback);
        } else {
            this.writable = writableCallback;
        }
    }

    public String toString() {
        return this.mRawHeaders == null ? super.toString() : this.mRawHeaders.toPrefixString(String.format(Locale.ENGLISH, "%s %s %s", this.httpVersion, Integer.valueOf(this.code), AsyncHttpServer.getResponseCodeDescription(this.code)));
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        DataSink dataSink;
        if (!this.headWritten) {
            initFirstWrite();
        }
        if (byteBufferList.remaining() == 0 || (dataSink = this.mSink) == null) {
            return;
        }
        dataSink.write(byteBufferList);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void writeHead() {
        initFirstWrite();
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public int code() {
        return this.code;
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str, ByteBuffer byteBuffer) {
        send(str, new ByteBufferList(byteBuffer));
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(final String str, final ByteBufferList byteBufferList) {
        getServer().post(new Runnable() { // from class: dc.ua1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(byteBufferList, str);
            }
        });
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str, String str2) {
        try {
            send(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(String str) {
        String str2 = this.mRawHeaders.get("Content-Type");
        if (str2 == null) {
            str2 = "text/html; charset=utf-8";
        }
        send(str2, str);
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(JSONObject jSONObject) {
        send("application/json; charset=utf-8", jSONObject.toString());
    }

    @Override // com.koushikdutta.async.http.server.AsyncHttpServerResponse
    public void send(JSONArray jSONArray) {
        send("application/json; charset=utf-8", jSONArray.toString());
    }
}
