package io.agora.base.internal;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class ContextUtils {
    private static final String TAG = "ContextUtils";

    @Nullable
    private static Context applicationContext;

    @Nullable
    @Deprecated
    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void initialize(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
        }
        applicationContext = context;
    }

    public static void uninitialize() {
        applicationContext = null;
    }
}
