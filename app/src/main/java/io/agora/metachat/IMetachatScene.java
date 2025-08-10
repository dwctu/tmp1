package io.agora.metachat;

import io.agora.base.VideoFrame;
import io.agora.rtc2.video.AgoraVideoFrame;

/* loaded from: classes4.dex */
public abstract class IMetachatScene {
    public abstract int addEventHandler(IMetachatSceneEventHandler iMetachatSceneEventHandler);

    public abstract int enableUserPositionNotification(boolean z);

    public abstract int enableVideoDisplay(String str, boolean z);

    public abstract int enterScene(EnterSceneConfig enterSceneConfig);

    public abstract int enumerateVideoDisplays();

    public abstract ILocalUserAvatar getLocalUserAvatar();

    public abstract int leaveScene();

    public abstract int pushVideoFrameToDisplay(String str, VideoFrame videoFrame);

    public abstract int pushVideoFrameToDisplay(String str, AgoraVideoFrame agoraVideoFrame);

    public abstract int release();

    public abstract int removeEventHandler(IMetachatSceneEventHandler iMetachatSceneEventHandler);

    public abstract int sendMessageToScene(byte[] bArr);

    public abstract int setSceneParameters(String str);
}
