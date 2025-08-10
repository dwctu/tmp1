package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONArrayParser;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class JSONArrayBody implements AsyncHttpRequestBody<JSONArray> {
    public static final String CONTENT_TYPE = "application/json";
    public JSONArray json;
    public byte[] mBodyBytes;

    public JSONArrayBody() {
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        return "application/json";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        byte[] bytes = this.json.toString().getBytes();
        this.mBodyBytes = bytes;
        return bytes.length;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new JSONArrayParser().parse(dataEmitter).setCallback(new FutureCallback<JSONArray>() { // from class: com.koushikdutta.async.http.body.JSONArrayBody.1
            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, JSONArray jSONArray) {
                JSONArrayBody.this.json = jSONArray;
                completedCallback.onCompleted(exc);
            }
        });
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return true;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        Util.writeAll(dataSink, this.mBodyBytes, completedCallback);
    }

    public JSONArrayBody(JSONArray jSONArray) {
        this();
        this.json = jSONArray;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public JSONArray get() {
        return this.json;
    }
}
