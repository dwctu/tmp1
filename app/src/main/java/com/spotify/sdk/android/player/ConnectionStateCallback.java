package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public interface ConnectionStateCallback {
    void onConnectionMessage(String str);

    void onLoggedIn();

    void onLoggedOut();

    void onLoginFailed(Error error);

    void onTemporaryError();
}
