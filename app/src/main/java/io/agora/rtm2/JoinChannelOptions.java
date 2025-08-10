package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class JoinChannelOptions {
    public String token = "";

    @CalledByNative
    public String getToken() {
        return this.token;
    }
}
