package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.h;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class LazyInputStream {
    private final Context mContext;
    private InputStream mInput;

    public LazyInputStream(Context context) {
        this.mContext = context;
    }

    public final void close() throws IOException {
        h.a(this.mInput);
    }

    public abstract InputStream get(Context context);

    public InputStream loadInputStream() {
        if (this.mInput == null) {
            this.mInput = get(this.mContext);
        }
        return this.mInput;
    }
}
