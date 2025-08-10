package com.google.firebase.auth;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class FacebookAuthProvider {

    @NonNull
    public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";

    @NonNull
    public static final String PROVIDER_ID = "facebook.com";

    private FacebookAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(@NonNull String str) {
        return new FacebookAuthCredential(str);
    }
}
