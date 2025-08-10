package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONObjectParser;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONObjectBody implements AsyncHttpRequestBody<JSONObject> {
    public static final String CONTENT_TYPE = "application/json";
    public JSONObject json;
    public byte[] mBodyBytes;

    public JSONObjectBody() {
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
        new JSONObjectParser().parse(dataEmitter).setCallback(new FutureCallback<JSONObject>() { // from class: com.koushikdutta.async.http.body.JSONObjectBody.1
            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, JSONObject jSONObject) {
                JSONObjectBody.this.json = jSONObject;
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

    public JSONObjectBody(JSONObject jSONObject) {
        this();
        this.json = jSONObject;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public JSONObject get() {
        return this.json;
    }
}
