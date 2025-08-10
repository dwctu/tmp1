package io.agora.metachat;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMetachatSceneEventHandler {
    @CalledByNative
    void onEnterSceneResult(int i);

    @CalledByNative
    void onEnumerateVideoDisplaysResult(String[] strArr);

    @CalledByNative
    void onLeaveSceneResult(int i);

    @CalledByNative
    void onRecvMessageFromScene(byte[] bArr);

    @CalledByNative
    void onReleasedScene(int i);

    @CalledByNative
    void onUserPositionChanged(String str, MetachatUserPositionInfo metachatUserPositionInfo);
}
