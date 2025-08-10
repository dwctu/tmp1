package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface ContentHandler {
    void body(BodyDescriptor bodyDescriptor, InputStream inputStream) throws IOException;

    void endBodyPart();

    void endHeader();

    void endMessage();

    void endMultipart();

    void epilogue(InputStream inputStream) throws IOException;

    void field(String str);

    void preamble(InputStream inputStream) throws IOException;

    void raw(InputStream inputStream) throws IOException;

    void startBodyPart();

    void startHeader();

    void startMessage();

    void startMultipart(BodyDescriptor bodyDescriptor);
}
