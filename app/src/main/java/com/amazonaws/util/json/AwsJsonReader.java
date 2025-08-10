package com.amazonaws.util.json;

import java.io.IOException;

/* loaded from: classes.dex */
public interface AwsJsonReader {
    void a() throws IOException;

    void b() throws IOException;

    void c() throws IOException;

    void close() throws IOException;

    boolean d() throws IOException;

    String e() throws IOException;

    String f() throws IOException;

    boolean hasNext() throws IOException;

    AwsJsonToken peek() throws IOException;
}
