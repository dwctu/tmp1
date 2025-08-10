package com.amazonaws.util.json;

import java.io.Reader;
import java.io.Writer;

/* loaded from: classes.dex */
public interface AwsJsonFactory {
    AwsJsonWriter a(Writer writer);

    AwsJsonReader b(Reader reader);
}
