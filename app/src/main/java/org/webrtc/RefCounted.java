package org.webrtc;

/* loaded from: classes5.dex */
public interface RefCounted {
    @CalledByNative
    void release();

    void retain();
}
