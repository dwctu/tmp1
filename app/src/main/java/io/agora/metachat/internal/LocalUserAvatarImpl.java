package io.agora.metachat.internal;

import io.agora.base.internal.CalledByNative;
import io.agora.metachat.AvatarModelInfo;
import io.agora.metachat.DressInfo;
import io.agora.metachat.FaceInfo;
import io.agora.metachat.ILocalUserAvatar;
import io.agora.metachat.MetachatUserInfo;

/* loaded from: classes4.dex */
public class LocalUserAvatarImpl implements ILocalUserAvatar {
    private long mNativeHandle;

    @CalledByNative
    public LocalUserAvatarImpl(long j) {
        this.mNativeHandle = 0L;
        this.mNativeHandle = j;
    }

    private native int nativeApplyInfo(long j);

    private native DressInfo nativeGetDressInfo(long j);

    private native byte[] nativeGetExtraCustomInfo(long j);

    private native FaceInfo nativeGetFaceInfo(long j);

    private native AvatarModelInfo nativeGetModelInfo(long j);

    private native MetachatUserInfo nativeGetUserInfo(long j);

    private native int nativeSetDressInfo(long j, DressInfo dressInfo);

    private native int nativeSetExtraCustomInfo(long j, byte[] bArr);

    private native int nativeSetFaceInfo(long j, FaceInfo faceInfo);

    private native int nativeSetModelInfo(long j, AvatarModelInfo avatarModelInfo);

    private native int nativeSetUserInfo(long j, MetachatUserInfo metachatUserInfo);

    @Override // io.agora.metachat.ILocalUserAvatar
    public int applyInfo() {
        return nativeApplyInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    @CalledByNative
    public DressInfo getDressInfo() {
        return nativeGetDressInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    @CalledByNative
    public byte[] getExtraCustomInfo() {
        return nativeGetExtraCustomInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    @CalledByNative
    public FaceInfo getFaceInfo() {
        return nativeGetFaceInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    @CalledByNative
    public AvatarModelInfo getModelInfo() {
        return nativeGetModelInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    @CalledByNative
    public MetachatUserInfo getUserInfo() {
        return nativeGetUserInfo(this.mNativeHandle);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    public int setDressInfo(DressInfo dressInfo) {
        return nativeSetDressInfo(this.mNativeHandle, dressInfo);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    public int setExtraCustomInfo(byte[] bArr) {
        return nativeSetExtraCustomInfo(this.mNativeHandle, bArr);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    public int setFaceInfo(FaceInfo faceInfo) {
        return nativeSetFaceInfo(this.mNativeHandle, faceInfo);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    public int setModelInfo(AvatarModelInfo avatarModelInfo) {
        return nativeSetModelInfo(this.mNativeHandle, avatarModelInfo);
    }

    @Override // io.agora.metachat.ILocalUserAvatar
    public int setUserInfo(MetachatUserInfo metachatUserInfo) {
        return nativeSetUserInfo(this.mNativeHandle, metachatUserInfo);
    }
}
