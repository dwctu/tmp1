package io.agora.spatialaudio;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class RemoteVoicePositionInfo {
    public float[] position = {0.0f, 0.0f, 0.0f};
    public float[] forward = {0.0f, 0.0f, 0.0f};

    @CalledByNative
    public float[] getForward() {
        return this.forward;
    }

    @CalledByNative
    public float[] getPosition() {
        return this.position;
    }
}
