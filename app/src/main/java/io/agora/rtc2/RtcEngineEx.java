package io.agora.rtc2;

import io.agora.base.VideoFrame;
import io.agora.rtc2.Constants;
import io.agora.rtc2.live.LiveTranscoding;
import io.agora.rtc2.video.AgoraVideoFrame;
import io.agora.rtc2.video.ChannelMediaRelayConfiguration;
import io.agora.rtc2.video.EncodedVideoFrameInfo;
import io.agora.rtc2.video.VideoCanvas;
import io.agora.rtc2.video.VideoEncoderConfiguration;
import io.agora.rtc2.video.VideoSubscriptionOptions;
import io.agora.rtc2.video.WatermarkOptions;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class RtcEngineEx extends RtcEngine {
    public abstract int addVideoWatermarkEx(String str, WatermarkOptions watermarkOptions, RtcConnection rtcConnection);

    public abstract int adjustRecordingSignalVolumeEx(int i, RtcConnection rtcConnection);

    public abstract int adjustUserPlaybackSignalVolumeEx(int i, int i2, RtcConnection rtcConnection);

    public abstract int clearVideoWatermarkEx(RtcConnection rtcConnection);

    public abstract int createDataStreamEx(DataStreamConfig dataStreamConfig, RtcConnection rtcConnection);

    public abstract int createDataStreamEx(boolean z, boolean z2, RtcConnection rtcConnection);

    public abstract int enableAudioVolumeIndicationEx(int i, int i2, boolean z, RtcConnection rtcConnection);

    @Deprecated
    public abstract int enableDualStreamModeEx(boolean z, SimulcastStreamConfig simulcastStreamConfig, RtcConnection rtcConnection);

    public abstract int getConnectionStateEx(RtcConnection rtcConnection);

    public abstract int getUserInfoByUidEx(int i, UserInfo userInfo, RtcConnection rtcConnection);

    public abstract int getUserInfoByUserAccountEx(String str, UserInfo userInfo, RtcConnection rtcConnection);

    public abstract int joinChannelEx(String str, RtcConnection rtcConnection, ChannelMediaOptions channelMediaOptions, IRtcEngineEventHandler iRtcEngineEventHandler);

    public abstract int joinChannelWithUserAccountEx(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions, IRtcEngineEventHandler iRtcEngineEventHandler);

    public abstract int leaveChannelEx(RtcConnection rtcConnection);

    public abstract int leaveChannelEx(RtcConnection rtcConnection, LeaveChannelOptions leaveChannelOptions);

    public abstract int muteAllRemoteAudioStreamsEx(boolean z, RtcConnection rtcConnection);

    public abstract int muteAllRemoteVideoStreamsEx(boolean z, RtcConnection rtcConnection);

    public abstract int muteLocalAudioStreamEx(boolean z, RtcConnection rtcConnection);

    public abstract int muteLocalVideoStreamEx(boolean z, RtcConnection rtcConnection);

    public abstract int muteRecordingSignalEx(boolean z, RtcConnection rtcConnection);

    public abstract int muteRemoteAudioStreamEx(int i, boolean z, RtcConnection rtcConnection);

    public abstract int muteRemoteVideoStreamEx(int i, boolean z, RtcConnection rtcConnection);

    public abstract int pauseAllChannelMediaRelayEx(RtcConnection rtcConnection);

    public abstract int pushExternalEncodedVideoFrameEx(ByteBuffer byteBuffer, EncodedVideoFrameInfo encodedVideoFrameInfo, int i);

    public abstract int pushExternalVideoFrameEx(VideoFrame videoFrame, int i);

    public abstract int pushExternalVideoFrameEx(AgoraVideoFrame agoraVideoFrame, int i);

    public abstract int resumeAllChannelMediaRelayEx(RtcConnection rtcConnection);

    public abstract int sendCustomReportMessageEx(String str, String str2, String str3, String str4, int i, RtcConnection rtcConnection);

    public abstract int sendStreamMessageEx(int i, byte[] bArr, RtcConnection rtcConnection);

    public abstract int setDualStreamModeEx(Constants.SimulcastStreamMode simulcastStreamMode, SimulcastStreamConfig simulcastStreamConfig, RtcConnection rtcConnection);

    public abstract int setHighPriorityUserListEx(int[] iArr, int i, RtcConnection rtcConnection);

    public abstract int setRemoteRenderModeEx(int i, int i2, int i3, RtcConnection rtcConnection);

    public abstract int setRemoteUserSpatialAudioParamsEx(int i, SpatialAudioParams spatialAudioParams, RtcConnection rtcConnection);

    public abstract int setRemoteVideoStreamTypeEx(int i, int i2, RtcConnection rtcConnection);

    public abstract int setRemoteVideoSubscriptionOptionsEx(int i, VideoSubscriptionOptions videoSubscriptionOptions, RtcConnection rtcConnection);

    public abstract int setRemoteVoicePositionEx(int i, double d, double d2, RtcConnection rtcConnection);

    public abstract int setSubscribeAudioAllowlistEx(int[] iArr, RtcConnection rtcConnection);

    public abstract int setSubscribeAudioBlocklistEx(int[] iArr, RtcConnection rtcConnection);

    public abstract int setSubscribeVideoAllowlistEx(int[] iArr, RtcConnection rtcConnection);

    public abstract int setSubscribeVideoBlocklistEx(int[] iArr, RtcConnection rtcConnection);

    public abstract int setVideoEncoderConfigurationEx(VideoEncoderConfiguration videoEncoderConfiguration, RtcConnection rtcConnection);

    public abstract int setupRemoteVideoEx(VideoCanvas videoCanvas, RtcConnection rtcConnection);

    @Deprecated
    public abstract int startChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection);

    public abstract int startMediaRenderingTracingEx(RtcConnection rtcConnection);

    public abstract int startOrUpdateChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection);

    public abstract int startRtmpStreamWithTranscodingEx(String str, LiveTranscoding liveTranscoding, RtcConnection rtcConnection);

    public abstract int startRtmpStreamWithoutTranscodingEx(String str, RtcConnection rtcConnection);

    public abstract int stopChannelMediaRelayEx(RtcConnection rtcConnection);

    public abstract int stopRtmpStreamEx(String str, RtcConnection rtcConnection);

    public abstract int takeSnapshotEx(RtcConnection rtcConnection, int i, String str);

    public abstract int updateChannelMediaOptionsEx(ChannelMediaOptions channelMediaOptions, RtcConnection rtcConnection);

    @Deprecated
    public abstract int updateChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection);

    public abstract int updateRtmpTranscodingEx(LiveTranscoding liveTranscoding, RtcConnection rtcConnection);
}
