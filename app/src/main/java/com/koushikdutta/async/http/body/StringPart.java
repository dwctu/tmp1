package com.koushikdutta.async.http.body;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StringPart extends StreamPart {
    public String value;

    public StringPart(String str, String str2) {
        super(str, str2.getBytes().length, null);
        this.value = str2;
    }

    @Override // com.koushikdutta.async.http.body.StreamPart
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.value.getBytes());
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
