package com.spotify.sdk.android.player;

import com.spotify.sdk.android.player.Player;
import com.wear.main.closeRange.music.MusicControl;
import dc.l12;

/* loaded from: classes3.dex */
public class PlayerOperationCallback implements Player.OperationCallback {
    private static final String TAG = "PlayerOperationCallback";
    public int flag;
    public String operation;

    @Override // com.spotify.sdk.android.player.Player.OperationCallback
    public void onError(Error error) {
        String str = "==ERROR:" + error;
        if (l12.u) {
            if (Error.kSpErrorFailed == error || Error.kSpErrorNotActiveDevice == error) {
                MusicControl.h0().e.E();
            }
        }
    }

    @Override // com.spotify.sdk.android.player.Player.OperationCallback
    public void onSuccess() {
    }
}
