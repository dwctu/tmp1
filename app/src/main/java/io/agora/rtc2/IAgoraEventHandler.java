package io.agora.rtc2;

import android.graphics.Rect;
import io.agora.rtc2.Constants;
import io.agora.rtc2.IRtcEngineEventHandler;

/* loaded from: classes4.dex */
public interface IAgoraEventHandler {
    void onAudioEffectFinished(int i);

    void onAudioMixingFinished();

    void onAudioMixingPositionChanged(long j);

    void onAudioMixingStateChanged(int i, int i2);

    void onAudioPublishStateChanged(String str, int i, int i2, int i3);

    void onAudioRouteChanged(int i);

    void onAudioSubscribeStateChanged(String str, int i, int i2, int i3, int i4);

    void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i);

    void onCameraExposureAreaChanged(Rect rect);

    void onCameraFocusAreaChanged(Rect rect);

    void onCameraReady();

    @Deprecated
    void onChannelMediaRelayEvent(int i);

    void onChannelMediaRelayStateChanged(int i, int i2);

    void onClientRoleChangeFailed(int i, int i2);

    void onClientRoleChanged(int i, int i2, ClientRoleOptions clientRoleOptions);

    void onConnectionBanned();

    void onConnectionInterrupted();

    void onConnectionLost();

    void onConnectionStateChanged(int i, int i2);

    void onContentInspectResult(int i);

    void onDownlinkNetworkInfoUpdated(IRtcEngineEventHandler.DownlinkNetworkInfo downlinkNetworkInfo);

    void onEncryptionError(int i);

    void onError(int i);

    void onFacePositionChanged(int i, int i2, IRtcEngineEventHandler.AgoraFacePositionInfo[] agoraFacePositionInfoArr);

    void onFirstLocalAudioFramePublished(int i);

    void onFirstLocalVideoFrame(Constants.VideoSourceType videoSourceType, int i, int i2, int i3);

    void onFirstLocalVideoFramePublished(Constants.VideoSourceType videoSourceType, int i);

    void onFirstRemoteAudioDecoded(int i, int i2);

    void onFirstRemoteAudioFrame(int i, int i2);

    void onIntraRequestReceived();

    void onLastmileProbeResult(IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult);

    void onLastmileQuality(int i);

    void onLeaveChannel(IRtcEngineEventHandler.RtcStats rtcStats);

    void onLicenseValidationFailure(int i);

    void onLocalAudioStats(IRtcEngineEventHandler.LocalAudioStats localAudioStats);

    void onLocalPublishFallbackToAudioOnly(boolean z);

    void onLocalUserRegistered(int i, String str);

    @Deprecated
    void onLocalVideoStat(int i, int i2);

    void onLocalVideoStats(Constants.VideoSourceType videoSourceType, IRtcEngineEventHandler.LocalVideoStats localVideoStats);

    void onMediaEngineLoadSuccess();

    void onMediaEngineStartCallSuccess();

    void onNetworkTypeChanged(int i);

    void onPermissionError(int i);

    void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats);

    void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats);

    void onRequestToken();

    void onRtcStats(IRtcEngineEventHandler.RtcStats rtcStats);

    void onRtmpStreamingEvent(String str, int i);

    void onRtmpStreamingStateChanged(String str, int i, int i2);

    void onSnapshotTaken(int i, String str, int i2, int i3, int i4);

    void onTokenPrivilegeWillExpire(String str);

    void onTranscodingUpdated();

    void onUplinkNetworkInfoUpdated(IRtcEngineEventHandler.UplinkNetworkInfo uplinkNetworkInfo);

    void onUploadLogResult(String str, boolean z, int i);

    void onUserInfoUpdated(int i, UserInfo userInfo);

    void onUserStateChanged(int i, int i2);

    void onVideoPublishStateChanged(Constants.VideoSourceType videoSourceType, String str, int i, int i2, int i3);

    void onVideoRenderingTracingResult(int i, Constants.MEDIA_TRACE_EVENT media_trace_event, IRtcEngineEventHandler.VideoRenderingTracingInfo videoRenderingTracingInfo);

    void onVideoStopped();

    void onVideoSubscribeStateChanged(String str, int i, int i2, int i3, int i4);

    void onWlAccMessage(int i, int i2, String str);

    void onWlAccStats(IRtcEngineEventHandler.WlAccStats wlAccStats, IRtcEngineEventHandler.WlAccStats wlAccStats2);
}
