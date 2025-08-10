package io.agora.metachat.internal;

import io.agora.base.VideoFrame;
import io.agora.base.internal.CalledByNative;
import io.agora.metachat.EnterSceneConfig;
import io.agora.metachat.ILocalUserAvatar;
import io.agora.metachat.IMetachatScene;
import io.agora.metachat.IMetachatSceneEventHandler;
import io.agora.rtc2.video.AgoraVideoFrame;

/* loaded from: classes4.dex */
public class MetachatSceneImpl extends IMetachatScene {
    private static final String TAG = "MetachatSceneImpl";
    private final ILocalUserAvatar mLocalUserAvatar;
    private long mNativeHandle;

    @CalledByNative
    public MetachatSceneImpl(long j) {
        this.mNativeHandle = 0L;
        this.mNativeHandle = j;
        this.mLocalUserAvatar = new LocalUserAvatarImpl(nativeGetLocalUserAvatar(j));
    }

    private native int nativeAddEventHandler(long j, Object obj);

    private static native int nativeDestroy(long j);

    private native int nativeEnableUserPositionNotification(long j, boolean z);

    private native int nativeEnableVideoDisplay(long j, String str, boolean z);

    private native int nativeEnterScene(long j, EnterSceneConfig enterSceneConfig);

    private native int nativeEnumerateVideoDisplays(long j);

    private native long nativeGetLocalUserAvatar(long j);

    private native int nativeLeaveScene(long j);

    private native int nativePushAgoraVideoFrameToDisplay(long j, String str, int i, byte[] bArr, int i2, int i3, long j2);

    private native int nativePushVideoFrameToDisplay(long j, String str, VideoFrame videoFrame);

    private native int nativeRemoveEventHandler(long j, Object obj);

    private native int nativeSendMessageToScene(long j, byte[] bArr);

    private native int nativeSetSceneParameters(long j, String str);

    @Override // io.agora.metachat.IMetachatScene
    public int addEventHandler(IMetachatSceneEventHandler iMetachatSceneEventHandler) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAddEventHandler(j, iMetachatSceneEventHandler);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int enableUserPositionNotification(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableUserPositionNotification(j, z);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int enableVideoDisplay(String str, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableVideoDisplay(j, str, z);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int enterScene(EnterSceneConfig enterSceneConfig) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnterScene(j, enterSceneConfig);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int enumerateVideoDisplays() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnumerateVideoDisplays(j);
    }

    @Override // io.agora.metachat.IMetachatScene
    public ILocalUserAvatar getLocalUserAvatar() {
        return this.mLocalUserAvatar;
    }

    @Override // io.agora.metachat.IMetachatScene
    public int leaveScene() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeLeaveScene(j);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int pushVideoFrameToDisplay(String str, VideoFrame videoFrame) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePushVideoFrameToDisplay(j, str, videoFrame);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int pushVideoFrameToDisplay(String str, AgoraVideoFrame agoraVideoFrame) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePushAgoraVideoFrameToDisplay(j, str, agoraVideoFrame.format, agoraVideoFrame.buf, agoraVideoFrame.stride, agoraVideoFrame.height, agoraVideoFrame.timeStamp);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int release() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        nativeDestroy(j);
        this.mNativeHandle = 0L;
        return 0;
    }

    @Override // io.agora.metachat.IMetachatScene
    public int removeEventHandler(IMetachatSceneEventHandler iMetachatSceneEventHandler) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRemoveEventHandler(j, iMetachatSceneEventHandler);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int sendMessageToScene(byte[] bArr) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSendMessageToScene(j, bArr);
    }

    @Override // io.agora.metachat.IMetachatScene
    public int setSceneParameters(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetSceneParameters(j, str);
    }
}
