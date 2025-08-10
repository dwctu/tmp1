package io.agora.metachat;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface ILocalUserAvatar {
    int applyInfo();

    @CalledByNative
    DressInfo getDressInfo();

    @CalledByNative
    byte[] getExtraCustomInfo();

    @CalledByNative
    FaceInfo getFaceInfo();

    @CalledByNative
    AvatarModelInfo getModelInfo();

    @CalledByNative
    MetachatUserInfo getUserInfo();

    int setDressInfo(DressInfo dressInfo);

    int setExtraCustomInfo(byte[] bArr);

    int setFaceInfo(FaceInfo faceInfo);

    int setModelInfo(AvatarModelInfo avatarModelInfo);

    int setUserInfo(MetachatUserInfo metachatUserInfo);
}
