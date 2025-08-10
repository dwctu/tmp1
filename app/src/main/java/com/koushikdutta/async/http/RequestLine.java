package com.koushikdutta.async.http;

/* loaded from: classes3.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
