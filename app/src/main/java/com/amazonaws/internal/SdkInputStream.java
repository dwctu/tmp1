package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean b() {
        Closeable closeableJ = j();
        if (closeableJ instanceof MetricAware) {
            return ((MetricAware) closeableJ).b();
        }
        return false;
    }

    public void e() throws IOException {
    }

    public final void f() {
        if (Thread.interrupted()) {
            try {
                e();
            } catch (IOException e) {
                LogFactory.b(getClass()).e("FYI", e);
            }
            throw new AbortedException();
        }
    }

    public abstract InputStream j();
}
