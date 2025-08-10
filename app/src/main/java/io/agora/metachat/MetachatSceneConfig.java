package io.agora.metachat;

import android.content.Context;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class MetachatSceneConfig {
    public Context mActivityContext = null;

    @CalledByNative
    public Context getActivityContext() {
        return this.mActivityContext;
    }
}
