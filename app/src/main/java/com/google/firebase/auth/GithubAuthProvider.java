package com.google.firebase.auth;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class GithubAuthProvider {

    @NonNull
    public static final String GITHUB_SIGN_IN_METHOD = "github.com";

    @NonNull
    public static final String PROVIDER_ID = "github.com";

    private GithubAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(@NonNull String str) {
        return new GithubAuthCredential(str);
    }
}
