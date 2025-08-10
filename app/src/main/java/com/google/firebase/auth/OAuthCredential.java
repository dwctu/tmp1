package com.google.firebase.auth;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class OAuthCredential extends AuthCredential {
    @Nullable
    public abstract String getAccessToken();

    @Nullable
    public abstract String getIdToken();

    @Nullable
    public abstract String getSecret();
}
