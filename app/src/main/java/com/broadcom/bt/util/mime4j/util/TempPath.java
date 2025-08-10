package com.broadcom.bt.util.mime4j.util;

import java.io.IOException;

/* loaded from: classes.dex */
public interface TempPath {
    TempFile createTempFile() throws IOException;

    TempFile createTempFile(String str, String str2) throws IOException;

    TempFile createTempFile(String str, String str2, boolean z) throws IOException;

    TempPath createTempPath() throws IOException;

    TempPath createTempPath(String str) throws IOException;

    void delete();

    String getAbsolutePath();
}
