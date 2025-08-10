package androidx.webkit.internal;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface ConditionallySupportedFeature {
    @NonNull
    String getPublicFeatureName();

    boolean isSupported();
}
