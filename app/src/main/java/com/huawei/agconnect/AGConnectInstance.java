package com.huawei.agconnect;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.agconnect.core.a.a;

/* loaded from: classes2.dex */
public abstract class AGConnectInstance {

    @SuppressLint({"StaticFieldLeak"})
    private static AGConnectInstance INSTANCE;

    public static AGConnectInstance getInstance() {
        return INSTANCE;
    }

    public static synchronized void initialize(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        if (INSTANCE == null) {
            INSTANCE = new a(context);
        }
    }

    public abstract Context getContext();

    public abstract <T> T getService(Class<? super T> cls);
}
