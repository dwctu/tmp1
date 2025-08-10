package com.broadcom.bt.util.mime4j.message;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface BinaryBody extends Body {
    InputStream getInputStream() throws IOException;
}
