package com.koushikdutta.async.http.body;

import android.text.TextUtils;
import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.google.android.vending.expansion.downloader.Constants;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Continuation;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.server.BoundaryEmitter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public class MultipartFormDataBody extends BoundaryEmitter implements AsyncHttpRequestBody<Multimap> {
    public static final String CONTENT_TYPE = "multipart/form-data";
    public static final String PRIMARY_TYPE = "multipart/";
    public String contentType = "multipart/form-data";
    public Headers formData;
    public ByteBufferList lastData;
    public Part lastPart;
    public LineEmitter liner;
    public MultipartCallback mCallback;
    private ArrayList<Part> mParts;
    public int totalToWrite;
    public int written;

    public interface MultipartCallback {
        void onPart(Part part);
    }

    public MultipartFormDataBody(String str) {
        String string = Multimap.parseSemicolonDelimited(str).getString(ContentTypeField.PARAM_BOUNDARY);
        if (string == null) {
            report(new Exception("No boundary found for multipart/form-data"));
        } else {
            setBoundary(string);
        }
    }

    public void addFilePart(String str, File file) {
        addPart(new FilePart(str, file));
    }

    public void addPart(Part part) {
        if (this.mParts == null) {
            this.mParts = new ArrayList<>();
        }
        this.mParts.add(part);
    }

    public void addStringPart(String str, String str2) {
        addPart(new StringPart(str, str2));
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public String getContentType() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
        }
        return this.contentType + "; boundary=" + getBoundary();
    }

    public String getField(String str) {
        Headers headers = this.formData;
        if (headers == null) {
            return null;
        }
        return headers.get(str);
    }

    public MultipartCallback getMultipartCallback() {
        return this.mCallback;
    }

    public List<Part> getParts() {
        if (this.mParts == null) {
            return null;
        }
        return new ArrayList(this.mParts);
    }

    public void handleLast() {
        if (this.lastData == null) {
            return;
        }
        if (this.formData == null) {
            this.formData = new Headers();
        }
        String strPeekString = this.lastData.peekString();
        String name = TextUtils.isEmpty(this.lastPart.getName()) ? "unnamed" : this.lastPart.getName();
        StringPart stringPart = new StringPart(name, strPeekString);
        stringPart.mHeaders = this.lastPart.mHeaders;
        addPart(stringPart);
        this.formData.add(name, strPeekString);
        this.lastPart = null;
        this.lastData = null;
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public int length() {
        if (getBoundary() == null) {
            setBoundary("----------------------------" + UUID.randomUUID().toString().replace(Constants.FILENAME_SEQUENCE_SEPARATOR, ""));
        }
        int length = 0;
        Iterator<Part> it = this.mParts.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            String prefixString = next.getRawHeaders().toPrefixString(getBoundaryStart());
            if (next.length() == -1) {
                return -1;
            }
            length = (int) (length + next.length() + prefixString.getBytes().length + 2);
        }
        int length2 = length + getBoundaryEnd().getBytes().length;
        this.totalToWrite = length2;
        return length2;
    }

    @Override // com.koushikdutta.async.http.server.BoundaryEmitter
    public void onBoundaryEnd() {
        super.onBoundaryEnd();
        handleLast();
    }

    @Override // com.koushikdutta.async.http.server.BoundaryEmitter
    public void onBoundaryStart() {
        final Headers headers = new Headers();
        LineEmitter lineEmitter = new LineEmitter();
        this.liner = lineEmitter;
        lineEmitter.setLineCallback(new LineEmitter.StringCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.1
            @Override // com.koushikdutta.async.LineEmitter.StringCallback
            public void onStringAvailable(String str) {
                if (!"\r".equals(str)) {
                    headers.addLine(str);
                    return;
                }
                MultipartFormDataBody.this.handleLast();
                MultipartFormDataBody multipartFormDataBody = MultipartFormDataBody.this;
                multipartFormDataBody.liner = null;
                multipartFormDataBody.setDataCallback(null);
                Part part = new Part(headers);
                MultipartCallback multipartCallback = MultipartFormDataBody.this.mCallback;
                if (multipartCallback != null) {
                    multipartCallback.onPart(part);
                }
                if (MultipartFormDataBody.this.getDataCallback() == null) {
                    MultipartFormDataBody multipartFormDataBody2 = MultipartFormDataBody.this;
                    multipartFormDataBody2.lastPart = part;
                    multipartFormDataBody2.lastData = new ByteBufferList();
                    MultipartFormDataBody.this.setDataCallback(new DataCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.1.1
                        @Override // com.koushikdutta.async.callback.DataCallback
                        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                            byteBufferList.get(MultipartFormDataBody.this.lastData);
                        }
                    });
                }
            }
        });
        setDataCallback(this.liner);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        setDataEmitter(dataEmitter);
        setEndCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public boolean readFullyOnRequest() {
        return false;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setMultipartCallback(MultipartCallback multipartCallback) {
        this.mCallback = multipartCallback;
    }

    public String toString() {
        Iterator<Part> it = getParts().iterator();
        return it.hasNext() ? it.next().toString() : "multipart content is empty";
    }

    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public void write(AsyncHttpRequest asyncHttpRequest, final DataSink dataSink, final CompletedCallback completedCallback) {
        if (this.mParts == null) {
            return;
        }
        Continuation continuation = new Continuation(new CompletedCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.2
            @Override // com.koushikdutta.async.callback.CompletedCallback
            public void onCompleted(Exception exc) {
                completedCallback.onCompleted(exc);
            }
        });
        Iterator<Part> it = this.mParts.iterator();
        while (it.hasNext()) {
            final Part next = it.next();
            continuation.add(new ContinuationCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.5
                @Override // com.koushikdutta.async.callback.ContinuationCallback
                public void onContinue(Continuation continuation2, CompletedCallback completedCallback2) throws Exception {
                    byte[] bytes = next.getRawHeaders().toPrefixString(MultipartFormDataBody.this.getBoundaryStart()).getBytes();
                    Util.writeAll(dataSink, bytes, completedCallback2);
                    MultipartFormDataBody.this.written += bytes.length;
                }
            }).add(new ContinuationCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.4
                @Override // com.koushikdutta.async.callback.ContinuationCallback
                public void onContinue(Continuation continuation2, CompletedCallback completedCallback2) throws Exception {
                    long length = next.length();
                    if (length >= 0) {
                        MultipartFormDataBody.this.written = (int) (r5.written + length);
                    }
                    next.write(dataSink, completedCallback2);
                }
            }).add(new ContinuationCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.3
                @Override // com.koushikdutta.async.callback.ContinuationCallback
                public void onContinue(Continuation continuation2, CompletedCallback completedCallback2) throws Exception {
                    byte[] bytes = "\r\n".getBytes();
                    Util.writeAll(dataSink, bytes, completedCallback2);
                    MultipartFormDataBody.this.written += bytes.length;
                }
            });
        }
        continuation.add(new ContinuationCallback() { // from class: com.koushikdutta.async.http.body.MultipartFormDataBody.6
            @Override // com.koushikdutta.async.callback.ContinuationCallback
            public void onContinue(Continuation continuation2, CompletedCallback completedCallback2) throws Exception {
                byte[] bytes = MultipartFormDataBody.this.getBoundaryEnd().getBytes();
                Util.writeAll(dataSink, bytes, completedCallback2);
                MultipartFormDataBody.this.written += bytes.length;
            }
        });
        continuation.start();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.koushikdutta.async.http.body.AsyncHttpRequestBody
    public Multimap get() {
        return new Multimap(this.formData.getMultiMap());
    }

    public MultipartFormDataBody() {
    }
}
