package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class Part {
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    private long length;
    public Multimap mContentDisposition;
    public Headers mHeaders;

    public Part(Headers headers) {
        this.length = -1L;
        this.mHeaders = headers;
        this.mContentDisposition = Multimap.parseSemicolonDelimited(headers.get("Content-Disposition"));
    }

    public String getContentType() {
        return this.mHeaders.get("Content-Type");
    }

    public String getFilename() {
        String string = this.mContentDisposition.getString("filename");
        if (string == null) {
            return null;
        }
        return new File(string).getName();
    }

    public String getName() {
        return this.mContentDisposition.getString("name");
    }

    public Headers getRawHeaders() {
        return this.mHeaders;
    }

    public boolean isFile() {
        return this.mContentDisposition.containsKey("filename");
    }

    public long length() {
        return this.length;
    }

    public void setContentType(String str) {
        this.mHeaders.set("Content-Type", str);
    }

    public void write(DataSink dataSink, CompletedCallback completedCallback) {
    }

    public Part(String str, long j, List<NameValuePair> list) {
        this.length = -1L;
        this.length = j;
        this.mHeaders = new Headers();
        StringBuilder sb = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                sb.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", nameValuePair.getName(), nameValuePair.getValue()));
            }
        }
        this.mHeaders.set("Content-Disposition", sb.toString());
        this.mContentDisposition = Multimap.parseSemicolonDelimited(this.mHeaders.get("Content-Disposition"));
    }
}
