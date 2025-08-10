package com.koushikdutta.async.http.body;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class UrlEncodedFormBody implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private byte[] mBodyBytes;
    private Multimap mParameters;

    public UrlEncodedFormBody(Multimap multimap) {
        this.mParameters = multimap;
    }

    private void buildData() {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<NameValuePair> it = this.mParameters.iterator();
            boolean z = true;
            while (it.hasNext()) {
                NameValuePair next = it.next();
                if (next.getValue() != null) {
                    if (!z) {
                        sb.append(Typography.amp);
                    }
                    z = false;
                    sb.append(URLEncoder.encode(next.getName(), "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                }
            }
            this.mBodyBytes = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/x-www-form-urlencoded; charset=utf-8";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (this.mBodyBytes == null) {
            buildData();
        }
        return this.mBodyBytes.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        final ByteBufferList byteBufferList = new ByteBufferList();
        dataEmitter.setDataCallback(new DataCallback() { // from class: com.koushikdutta.async.http.body.UrlEncodedFormBody.1
            @Override // com.koushikdutta.async.callback.DataCallback
            public void onDataAvailable(DataEmitter dataEmitter2, ByteBufferList byteBufferList2) {
                byteBufferList2.get(byteBufferList);
            }
        });
        dataEmitter.setEndCallback(new CompletedCallback() { // from class: com.koushikdutta.async.http.body.UrlEncodedFormBody.2
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) throws Exception {
                try {
                    if (exc != null) {
                        throw exc;
                    }
                    UrlEncodedFormBody.this.mParameters = Multimap.parseUrlEncoded(byteBufferList.readString());
                    completedCallback.onCompleted(null);
                } catch (Exception e) {
                    completedCallback.onCompleted(e);
                }
            }
        });
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.mBodyBytes == null) {
            buildData();
        }
        Util.writeAll(dataSink, this.mBodyBytes, completedCallback);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Multimap get() {
        return this.mParameters;
    }

    public UrlEncodedFormBody(List<NameValuePair> list) {
        this.mParameters = new Multimap(list);
    }

    public UrlEncodedFormBody() {
    }
}
