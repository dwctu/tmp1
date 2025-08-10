package com.broadcom.bt.util.mime4j.message;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
public interface TextBody extends Body {
    Reader getReader() throws IOException;
}
