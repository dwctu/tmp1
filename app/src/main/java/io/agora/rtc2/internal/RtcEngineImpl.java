package io.agora.rtc2.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.agora.base.VideoFrame;
import io.agora.base.internal.BuildConfig;
import io.agora.base.internal.CalledByNative;
import io.agora.mediaplayer.IMediaPlayer;
import io.agora.mediaplayer.IMediaPlayerAudioFrameObserver;
import io.agora.mediaplayer.IMediaPlayerCacheManager;
import io.agora.mediaplayer.IMediaPlayerCustomDataProvider;
import io.agora.mediaplayer.IMediaPlayerObserver;
import io.agora.mediaplayer.IMediaPlayerVideoFrameObserver;
import io.agora.mediaplayer.data.MediaPlayerSource;
import io.agora.mediaplayer.data.MediaStreamInfo;
import io.agora.rtc2.AgoraMediaRecorder;
import io.agora.rtc2.ChannelMediaOptions;
import io.agora.rtc2.ClientRoleOptions;
import io.agora.rtc2.Constants;
import io.agora.rtc2.DataStreamConfig;
import io.agora.rtc2.DeviceInfo;
import io.agora.rtc2.DirectCdnStreamingMediaOptions;
import io.agora.rtc2.EchoTestConfiguration;
import io.agora.rtc2.EncodedVideoTrackOptions;
import io.agora.rtc2.ExtensionInfo;
import io.agora.rtc2.IAgoraEventHandler;
import io.agora.rtc2.IAudioEffectManager;
import io.agora.rtc2.IAudioEncodedFrameObserver;
import io.agora.rtc2.IAudioFrameObserver;
import io.agora.rtc2.IDirectCdnStreamingEventHandler;
import io.agora.rtc2.IH265Transcoder;
import io.agora.rtc2.IH265TranscoderObserver;
import io.agora.rtc2.IMediaRecorderCallback;
import io.agora.rtc2.IMetadataObserver;
import io.agora.rtc2.IRtcEngineEventHandler;
import io.agora.rtc2.LeaveChannelOptions;
import io.agora.rtc2.LocalTranscoderConfiguration;
import io.agora.rtc2.PublisherConfiguration;
import io.agora.rtc2.RecorderStreamInfo;
import io.agora.rtc2.RtcConnection;
import io.agora.rtc2.RtcEngineConfig;
import io.agora.rtc2.RtcEngineInternal;
import io.agora.rtc2.ScreenCaptureParameters;
import io.agora.rtc2.SimulcastStreamConfig;
import io.agora.rtc2.SpatialAudioParams;
import io.agora.rtc2.UserInfo;
import io.agora.rtc2.audio.AdvancedAudioOptions;
import io.agora.rtc2.audio.AgoraRhythmPlayerConfig;
import io.agora.rtc2.audio.AudioTrackConfig;
import io.agora.rtc2.audio.IAudioSpectrumObserver;
import io.agora.rtc2.internal.RtcEngineEvent;
import io.agora.rtc2.internal.RtcEngineMessage;
import io.agora.rtc2.live.LiveTranscoding;
import io.agora.rtc2.proxy.LocalAccessPointConfiguration;
import io.agora.rtc2.video.AgoraImage;
import io.agora.rtc2.video.AgoraVideoFrame;
import io.agora.rtc2.video.BeautyOptions;
import io.agora.rtc2.video.CameraCapturerConfiguration;
import io.agora.rtc2.video.ChannelMediaInfo;
import io.agora.rtc2.video.ChannelMediaRelayConfiguration;
import io.agora.rtc2.video.CodecCapInfo;
import io.agora.rtc2.video.ColorEnhanceOptions;
import io.agora.rtc2.video.ContentInspectConfig;
import io.agora.rtc2.video.EncodedVideoFrameInfo;
import io.agora.rtc2.video.IVideoEncodedFrameObserver;
import io.agora.rtc2.video.IVideoFrameObserver;
import io.agora.rtc2.video.ImageTrackOptions;
import io.agora.rtc2.video.LowLightEnhanceOptions;
import io.agora.rtc2.video.SegmentationProperty;
import io.agora.rtc2.video.VideoCanvas;
import io.agora.rtc2.video.VideoDenoiserOptions;
import io.agora.rtc2.video.VideoEncoderConfiguration;
import io.agora.rtc2.video.VideoSubscriptionOptions;
import io.agora.rtc2.video.VirtualBackgroundSource;
import io.agora.rtc2.video.WatermarkOptions;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLContext;
import org.bouncycastle.crypto.tls.CipherSuite;

/* loaded from: classes4.dex */
public class RtcEngineImpl extends RtcEngineInternal implements IAudioEffectManager {
    private static final int DEFAULT_EXTERNAL_AUDIO_SOURCE_COUNT = 1;
    private static final String TAG = "RtcEngine";
    private static boolean sLibLoaded = false;
    private PublisherConfiguration mConfiguration;
    private final WeakReference<Context> mContext;
    private long mNativeHandle;
    private static ConcurrentHashMap<String, ExtensionLoadState> mLoadedExtensions = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<AgoraMediaRecorder, Pair<String, Object>> mMediaRecorders = new ConcurrentHashMap<>();
    private static final String[] PRELOAD_EXTENSIONS = {"agora_clear_vision_extension", "agora_segmentation_extension", "agora_screen_capture_extension", "agora_audio_beauty_extension", "agora_spatial_audio_extension", "agora_video_decoder_extension", "agora_video_encoder_extension", "agora_content_inspect_extension", "agora_video_quality_analyzer_extension", "agora_face_detection_extension", "agora_ai_noise_suppression_extension", "agora_ai_echo_cancellation_extension"};
    public static String nativeLibraryName = "agora-rtc-sdk";
    public static String nativeLibraryPrefix = "lib";
    public static String nativeLibrarySurffix = ".so";
    private int mExSourceAudioSampleRate = 0;
    private int mExSourceAudioChannels = 0;
    private int mExSinkAudioSampleRate = 0;
    private int mExSinkAudioChannels = 0;
    private int mPushVideoFrameInvalidCnt = 0;
    private final ConcurrentHashMap<IAgoraEventHandler, Integer> mRtcHandlers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Pair<String, Object>, IAgoraEventHandler> mRtcExHandlers = new ConcurrentHashMap<>();
    private IRtcEngineEventHandler.RtcStats mRtcStats = null;
    private WifiManager.WifiLock mWifiLock = null;

    public enum ExtensionLoadState {
        LOADED,
        LOAD_FAIL
    }

    public static class InitResult {
        private long nativeHandle;
        private int retVal;

        @CalledByNative("InitResult")
        public InitResult(int i, long j) {
            this.retVal = i;
            this.nativeHandle = j;
        }
    }

    public RtcEngineImpl(RtcEngineConfig rtcEngineConfig) throws Exception {
        this.mNativeHandle = 0L;
        if (rtcEngineConfig.mAutoRegisterAgoraExtensions) {
            rtcEngineConfig.mExtensionList.addAll(Arrays.asList(PRELOAD_EXTENSIONS));
        }
        for (String str : rtcEngineConfig.mExtensionList) {
            Logging.i(TAG, "load extension: " + str);
            safeLoadLibrary(rtcEngineConfig.mNativeLibPath, str);
        }
        this.mContext = new WeakReference<>(rtcEngineConfig.mContext);
        addHandler(rtcEngineConfig.mEventHandler);
        InitResult initResult = (InitResult) nativeObjectInit(rtcEngineConfig);
        if (initResult.retVal != 0) {
            throw new IllegalArgumentException(String.format(Locale.getDefault(), "cannot initialize Agora Rtc Engine, error=%d", Integer.valueOf(Math.abs(initResult.retVal))));
        }
        this.mNativeHandle = initResult.nativeHandle;
        setUidCompatibleMode(true);
    }

    private boolean checkRelayConfiguration(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (channelMediaRelayConfiguration == null || channelMediaRelayConfiguration.getSrcChannelMediaInfo() == null || channelMediaRelayConfiguration.getDestChannelMediaInfos() == null || channelMediaRelayConfiguration.getDestChannelMediaInfos().isEmpty() || channelMediaRelayConfiguration.getDestChannelMediaInfos().size() > 4) {
            return false;
        }
        for (ChannelMediaInfo channelMediaInfo : channelMediaRelayConfiguration.getDestChannelMediaInfos().values()) {
            if (channelMediaInfo == null || TextUtils.isEmpty(channelMediaInfo.getChannelName())) {
                return false;
            }
        }
        return true;
    }

    private void doMonitorSystemEvent(Context context) {
        WifiManager.WifiLock wifiLock;
        if (Connectivity.getNetworkType(context) == 2 && (wifiLock = this.mWifiLock) != null) {
            wifiLock.acquire();
            Logging.i(TAG, "hp connection mode detected");
        }
    }

    private void doStopMonitorSystemEvent() {
        WifiManager.WifiLock wifiLock = this.mWifiLock;
        if (wifiLock == null || !wifiLock.isHeld()) {
            return;
        }
        this.mWifiLock.release();
        Logging.i(TAG, "hp connection mode ended");
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String getChannelId(RtcConnection rtcConnection) {
        if (rtcConnection != null) {
            return rtcConnection.channelId;
        }
        return null;
    }

    public static String getNativeLibFullPath(String str, String str2) {
        String str3 = nativeLibraryPrefix + str2 + nativeLibrarySurffix;
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String str4 = File.separator;
        if (str.endsWith(str4)) {
            return str + str3;
        }
        return str + str4 + str3;
    }

    private IRtcEngineEventHandler.RtcStats getRtcStats() {
        if (this.mRtcStats == null) {
            this.mRtcStats = new IRtcEngineEventHandler.RtcStats();
        }
        return this.mRtcStats;
    }

    public static int getUserId(RtcConnection rtcConnection) {
        if (rtcConnection != null) {
            return rtcConnection.localUid;
        }
        return 0;
    }

    public static synchronized boolean initializeNativeLibs() {
        return initializeNativeLibs(null);
    }

    public static synchronized boolean initializeNativeLibs(String str) {
        if (!sLibLoaded) {
            int i = 0;
            while (true) {
                List<String> list = BuildConfig.so_list;
                if (i >= list.size()) {
                    sLibLoaded = safeLoadLibrary(str, nativeLibraryName);
                    break;
                }
                boolean zSafeLoadLibrary = safeLoadLibrary(str, list.get(i));
                sLibLoaded = zSafeLoadLibrary;
                if (!zSafeLoadLibrary) {
                    return zSafeLoadLibrary;
                }
                i++;
            }
        }
        return sLibLoaded;
    }

    private native int nativeAddVideoWatermark(long j, String str, boolean z, int[] iArr, int[] iArr2, String str2, int i);

    private native int nativeAdjustAudioMixingPlayoutVolume(long j, int i);

    private native int nativeAdjustAudioMixingPublishVolume(long j, int i);

    private native int nativeAdjustAudioMixingVolume(long j, int i);

    private native int nativeAdjustCustomAudioPlayoutVolume(long j, int i, int i2);

    private native int nativeAdjustCustomAudioPublishVolume(long j, int i, int i2);

    private native int nativeAdjustPlaybackSignalVolume(long j, int i);

    private native int nativeAdjustRecordingSignalVolume(long j, int i, String str, int i2);

    private native int nativeAdjustUserPlaybackSignalVolume(long j, int i, int i2, String str, int i3);

    private native int nativeClearVideoWatermarkEx(long j, String str, int i);

    private native int nativeClearVideoWatermarks(long j);

    private native int nativeComplain(long j, String str, String str2);

    private native int nativeConfigRhythmPlayer(long j, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    private native int nativeCreateCustomAudioTrack(long j, int i, boolean z);

    private native int nativeCreateCustomEncodedVideoTrack(long j, EncodedVideoTrackOptions encodedVideoTrackOptions);

    private native int nativeCreateCustomVideoTrack(long j);

    private native int nativeCreateDataStream(long j, boolean z, boolean z2, String str, int i);

    private native int nativeCreateDataStream2(long j, boolean z, boolean z2, String str, int i);

    private native int nativeCreateH265Transcoder(long j);

    private native int nativeCreateMediaPlayer(long j);

    private static native int nativeDestroy(long j);

    private native int nativeDestroyCustomAudioTrack(long j, int i);

    private native int nativeDestroyCustomEncodedVideoTrack(long j, int i);

    private native int nativeDestroyCustomVideoTrack(long j, int i);

    private native int nativeDisableAudioSpectrumMonitor(long j);

    private native int nativeDisableVideo(long j);

    private native int nativeEnableAudio(long j, boolean z);

    private native int nativeEnableAudioSpectrumMonitor(long j, int i);

    private native int nativeEnableAudioVolumeIndication(long j, int i, int i2, boolean z, String str, int i3);

    private native int nativeEnableContentInspect(long j, boolean z, byte[] bArr);

    private native int nativeEnableCustomAudioLocalPlayback(long j, int i, boolean z);

    private native int nativeEnableDualStreamModeEx(long j, boolean z, SimulcastStreamConfig simulcastStreamConfig, String str, int i);

    private native int nativeEnableEncryption(long j, boolean z, int i, String str, byte[] bArr);

    private native int nativeEnableExtension(long j, String str, String str2, boolean z, int i);

    private native int nativeEnableExtension2(long j, String str, String str2, boolean z, int i, int i2, String str3, int i3);

    private native int nativeEnableExternalAudioSourceLocalPlayback(long j, boolean z);

    private native int nativeEnableFaceDetection(long j, boolean z);

    private native int nativeEnableInEarMonitoring(long j, boolean z, int i);

    private native int nativeEnableInstantMediaRendering(long j);

    private native int nativeEnableLocalAudio(long j, boolean z);

    private native int nativeEnableLocalVideo(long j, boolean z);

    private native int nativeEnableSoundPositionIndication(long j, boolean z);

    private native int nativeEnableSpatialAudio(long j, boolean z);

    private native int nativeEnableVideo(long j);

    private native int nativeEnableVideoImageSource(long j, boolean z, String str, int i, int i2);

    private native int nativeEnableVirtualBackground(long j, boolean z, int i, int i2, String str, int i3, int i4, float f, int i5);

    private native DeviceInfo nativeGetAudioDeviceInfo(long j);

    private native int nativeGetAudioMixingCurrentPosition(long j);

    private native int nativeGetAudioMixingDuration(long j);

    private native int nativeGetAudioMixingPlayoutVolume(long j);

    private native int nativeGetAudioMixingPublishVolume(long j);

    private native String nativeGetAudioOptionParams(long j);

    private native int nativeGetAudioTrackCount(long j);

    private native String nativeGetCallId(long j);

    private native boolean nativeGetCameraAutoFocusFaceModeSupported(long j);

    private native boolean nativeGetCameraExposurePositionSupported(long j);

    private native boolean nativeGetCameraFaceDetectSupported(long j);

    private native boolean nativeGetCameraFocusSupported(long j);

    private native float nativeGetCameraMaxZoomFactor(long j);

    private native boolean nativeGetCameraTorchSupported(long j);

    private native boolean nativeGetCameraZoomSupported(long j);

    public static native String nativeGetChatEngineVersion();

    private native int nativeGetConnectionState(long j, String str, int i);

    private native long nativeGetCurrentMonotonicTimeInMs(long j);

    private native int nativeGetEffectCurrentPosition(long j, int i);

    private native int nativeGetEffectDuration(long j, String str);

    private native double nativeGetEffectsVolume(long j);

    public static native String nativeGetErrorDescription(int i);

    private native String nativeGetExtensionProperty(long j, String str, String str2, String str3, int i);

    private native String nativeGetExtensionProperty2(long j, String str, String str2, String str3, int i, int i2, String str4, int i3);

    private native long nativeGetMediaPlayer(long j, int i);

    private native int nativeGetNetworkType(long j);

    private native long nativeGetNtpWallTimeInMs(long j);

    private native String nativeGetParameter(long j, String str, String str2);

    private native String nativeGetParameters(long j, String str);

    private native String nativeGetProfile(long j);

    private native long nativeGetRtcEngine(long j);

    public static native String nativeGetSdkVersion();

    private native int nativeGetUserInfoByUid(long j, int i, UserInfo userInfo);

    private native int nativeGetUserInfoByUidEx(long j, int i, UserInfo userInfo, String str, int i2);

    private native int nativeGetUserInfoByUserAccount(long j, String str, UserInfo userInfo);

    private native int nativeGetUserInfoByUserAccountEx(long j, String str, UserInfo userInfo, String str2, int i);

    private native int nativeGetVolumeOfEffect(long j, int i);

    private native int nativeH265TranscoderEnableTranscode(long j, String str, String str2, int i);

    private native int nativeH265TranscoderQueryChannel(long j, String str, String str2, int i);

    private native int nativeH265TranscoderRegisterObserver(long j, IH265TranscoderObserver iH265TranscoderObserver);

    private native int nativeH265TranscoderTriggerTranscode(long j, String str, String str2, int i);

    private native int nativeH265TranscoderUnregisterObserver(long j, IH265TranscoderObserver iH265TranscoderObserver);

    private native int nativeInitMediaPlayerCacheManager(long j);

    private native boolean nativeIsSpeakerphoneEnabled(long j);

    private native int nativeJoinChannel(long j, String str, String str2, String str3, int i);

    private native int nativeJoinChannel2(long j, String str, String str2, int i, ChannelMediaOptions channelMediaOptions);

    private native int nativeJoinChannelEx(long j, String str, String str2, int i, ChannelMediaOptions channelMediaOptions);

    private native int nativeJoinChannelWithUserAccount(long j, String str, String str2, String str3, ChannelMediaOptions channelMediaOptions);

    private native int nativeJoinChannelWithUserAccountEx(long j, String str, String str2, String str3, ChannelMediaOptions channelMediaOptions);

    private native int nativeLeaveChannel(long j, LeaveChannelOptions leaveChannelOptions);

    private native int nativeLeaveChannelEx(long j, String str, int i, LeaveChannelOptions leaveChannelOptions);

    private native int nativeLoadExtensionProvider(long j, String str);

    public static native int nativeLog(int i, String str);

    private native String nativeMakeQualityReportUrl(long j, String str, String str2, String str3, int i);

    private native int nativeMediaPlayerAdjustPlayoutVolume(long j, int i, int i2);

    private native int nativeMediaPlayerAdjustPublishSignalVolume(long j, int i, int i2);

    private native int nativeMediaPlayerChangePlaybackSpeed(long j, int i, int i2);

    private native int nativeMediaPlayerDestroy(long j, int i);

    private native int nativeMediaPlayerEnableAutoRemoveCache(long j, boolean z);

    private native int nativeMediaPlayerEnableAutoSwitchAgoraCDN(long j, int i, boolean z);

    private native int nativeMediaPlayerGetAgoraCDNLineCount(long j, int i);

    private native String nativeMediaPlayerGetCacheDir(long j);

    private native int nativeMediaPlayerGetCacheFileCount(long j);

    private native int nativeMediaPlayerGetCurrentAgoraCDNIndex(long j, int i);

    private native long nativeMediaPlayerGetDuration(long j, int i);

    private native int nativeMediaPlayerGetMaxCacheFileCount(long j);

    private native long nativeMediaPlayerGetMaxCacheFileSize(long j);

    private native boolean nativeMediaPlayerGetMute(long j, int i);

    private native long nativeMediaPlayerGetPlayPosition(long j, int i);

    private native String nativeMediaPlayerGetPlaySrc(long j, int i);

    private native int nativeMediaPlayerGetPlayoutVolume(long j, int i);

    private native int nativeMediaPlayerGetPublishSignalVolume(long j, int i);

    private native int nativeMediaPlayerGetState(long j, int i);

    private native int nativeMediaPlayerGetStreamCount(long j, int i);

    private native MediaStreamInfo nativeMediaPlayerGetStreamInfo(long j, int i, int i2);

    private native int nativeMediaPlayerMute(long j, int i, boolean z);

    private native int nativeMediaPlayerOpen(long j, int i, String str, long j2);

    private native int nativeMediaPlayerOpenWithAgoraCDNSrc(long j, int i, String str, long j2);

    private native int nativeMediaPlayerOpenWithCustormProviderData(long j, int i, long j2, IMediaPlayerCustomDataProvider iMediaPlayerCustomDataProvider);

    private native int nativeMediaPlayerOpenWithSource(long j, int i, MediaPlayerSource mediaPlayerSource);

    private native int nativeMediaPlayerPause(long j, int i);

    private native int nativeMediaPlayerPlay(long j, int i);

    private native int nativeMediaPlayerPlayPreloadedSrc(long j, int i, String str);

    private native int nativeMediaPlayerPreloadSrc(long j, int i, String str, long j2);

    private native int nativeMediaPlayerRegisterAudioFrameObserver(long j, int i, IMediaPlayerAudioFrameObserver iMediaPlayerAudioFrameObserver, int i2);

    private native int nativeMediaPlayerRegisterPlayerObserver(long j, int i, IMediaPlayerObserver iMediaPlayerObserver);

    private native int nativeMediaPlayerRegisterVideoFrameObserver(long j, int i, IMediaPlayerVideoFrameObserver iMediaPlayerVideoFrameObserver);

    private native int nativeMediaPlayerRemoveAllCaches(long j);

    private native int nativeMediaPlayerRemoveCacheByUri(long j, String str);

    private native int nativeMediaPlayerRemoveOldCache(long j);

    private native int nativeMediaPlayerRenewAgoraCDNSrcToken(long j, int i, String str, long j2);

    private native int nativeMediaPlayerResume(long j, int i);

    private native int nativeMediaPlayerSeek(long j, int i, long j2);

    private native int nativeMediaPlayerSelectAudioTrack(long j, int i, int i2);

    private native int nativeMediaPlayerSelectInternalSubtitle(long j, int i, int i2);

    private native int nativeMediaPlayerSetAudioDualMonoMode(long j, int i, int i2);

    private native int nativeMediaPlayerSetAudioPitch(long j, int i, int i2);

    private native int nativeMediaPlayerSetCacheDir(long j, String str);

    private native int nativeMediaPlayerSetExternalSubtitle(long j, int i, String str);

    private native int nativeMediaPlayerSetLoopCount(long j, int i, int i2);

    private native int nativeMediaPlayerSetMaxCacheFileCount(long j, int i);

    private native int nativeMediaPlayerSetMaxCacheFileSize(long j, long j2);

    private native int nativeMediaPlayerSetPlayerOption(long j, int i, String str, int i2);

    private native int nativeMediaPlayerSetPlayerOptionString(long j, int i, String str, String str2);

    private native int nativeMediaPlayerSetRenderMode(long j, int i, int i2);

    private native int nativeMediaPlayerSetSpatialAudioParams(long j, int i, SpatialAudioParams spatialAudioParams);

    private native int nativeMediaPlayerSetView(long j, int i, View view);

    private native int nativeMediaPlayerStop(long j, int i);

    private native int nativeMediaPlayerSwitchAgoraCDNLineByIndex(long j, int i, int i2);

    private native int nativeMediaPlayerSwitchAgoraCDNSrc(long j, int i, String str, boolean z);

    private native int nativeMediaPlayerSwitchSrc(long j, int i, String str, boolean z);

    private native int nativeMediaPlayerTakeScreenshot(long j, int i, String str);

    private native int nativeMediaPlayerUnRegisterPlayerObserver(long j, int i, IMediaPlayerObserver iMediaPlayerObserver);

    private native int nativeMediaPlayerUnloadSrc(long j, int i, String str);

    private native int nativeMuteAllRemoteAudioStreams(long j, boolean z, String str, int i);

    private native int nativeMuteAllRemoteVideoStreams(long j, boolean z, String str, int i);

    private native int nativeMuteLocalAudioStream(long j, boolean z, String str, int i);

    private native int nativeMuteLocalVideoStream(long j, boolean z, String str, int i);

    private native int nativeMuteRecordingSignal(long j, boolean z, String str, int i);

    private native int nativeMuteRemoteAudioStream(long j, int i, boolean z, String str, int i2);

    private native int nativeMuteRemoteVideoStream(long j, int i, boolean z, String str, int i2);

    private native Object nativeObjectInit(RtcEngineConfig rtcEngineConfig);

    private native int nativePauseAllChannelMediaRelay(long j, String str, int i);

    private native int nativePauseAllEffects(long j);

    private native int nativePauseAudio(long j);

    private native int nativePauseAudioMixing(long j);

    private native int nativePauseEffect(long j, int i);

    private native int nativePlayAllEffects(long j, int i, double d, double d2, double d3, boolean z);

    private native int nativePlayEffectWithFilePath(long j, int i, String str, int i2, double d, double d2, double d3, boolean z, int i3);

    private native int nativePreloadEffect(long j, int i, String str, int i2);

    private native int nativePullAudioFrame(long j, ByteBuffer byteBuffer, int i, int i2, int i3);

    private native int nativePushExternalAgoraVideoFrame(long j, int i, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, EGLContext eGLContext, android.opengl.EGLContext eGLContext2, long j3, float[] fArr, int i9);

    private native int nativePushExternalAudioFrameRawData(long j, ByteBuffer byteBuffer, long j2, int i, int i2, int i3, int i4);

    private native int nativePushExternalEncodedVideoFrame(long j, ByteBuffer byteBuffer, EncodedVideoFrameInfo encodedVideoFrameInfo, int i);

    private native CodecCapInfo[] nativeQueryCodecCapability(long j);

    private native int nativeQueryScreenCaptureCapability(long j);

    private native int nativeRate(long j, String str, int i, String str2);

    private native int nativeRegisterAudioFrameObserver(long j, IAudioFrameObserver iAudioFrameObserver);

    private native int nativeRegisterAudioSpectrumObserver(long j, IAudioSpectrumObserver iAudioSpectrumObserver);

    private native int nativeRegisterExtension(long j, String str, String str2, int i);

    private native int nativeRegisterLocalUserAccount(long j, String str, String str2);

    private native int nativeRegisterMediaMetadataObserver(long j, Object obj, int i);

    private native int nativeRegisterMediaPlayerAudioSpectrumObserver(long j, int i, IAudioSpectrumObserver iAudioSpectrumObserver, int i2);

    private native int nativeRegisterVideoEncodedFrameObserver(long j, IVideoEncodedFrameObserver iVideoEncodedFrameObserver);

    private native int nativeRegisterVideoFrameObserver(long j, IVideoFrameObserver iVideoFrameObserver);

    private native int nativeReleaseRecorder(long j, int i, String str, boolean z);

    private native int nativeRenewToken(long j, String str);

    private native int nativeResumeAllChannelMediaRelay(long j, String str, int i);

    private native int nativeResumeAllEffects(long j);

    private native int nativeResumeAudio(long j);

    private native int nativeResumeAudioMixing(long j);

    private native int nativeResumeEffect(long j, int i);

    private native int nativeSelectAudioTrack(long j, int i);

    private native int nativeSendCustomReportMessage(long j, String str, String str2, String str3, String str4, int i, String str5, int i2);

    private native int nativeSendStreamMessage(long j, int i, byte[] bArr, String str, int i2);

    private native int nativeSetAVSyncSource(long j, String str, int i);

    private native int nativeSetAdvancedAudioOptions(long j, int i);

    private native int nativeSetApiCallMode(long j, int i);

    private native int nativeSetAudioEffectParameters(long j, int i, int i2, int i3);

    private native int nativeSetAudioEffectPreset(long j, int i);

    private native int nativeSetAudioMixingDualMonoMode(long j, int i);

    private native int nativeSetAudioMixingPitch(long j, int i);

    private native int nativeSetAudioMixingPosition(long j, int i);

    private native int nativeSetAudioOptionParams(long j, String str);

    private native int nativeSetAudioProfile(long j, int i);

    private native int nativeSetAudioProfileScenario(long j, int i, int i2);

    private native int nativeSetAudioScenario(long j, int i);

    private native int nativeSetBeautyEffectOptions(long j, boolean z, int i, float f, float f2, float f3, float f4, int i2);

    private native int nativeSetCameraAutoFocusFaceModeEnabled(long j, boolean z);

    private native int nativeSetCameraCapturerConfiguration(long j, CameraCapturerConfiguration cameraCapturerConfiguration);

    private native int nativeSetCameraExposurePosition(long j, float f, float f2);

    private native int nativeSetCameraFocusPositionInPreview(long j, float f, float f2);

    private native int nativeSetCameraTorchOn(long j, boolean z);

    private native int nativeSetCameraZoomFactor(long j, float f);

    private native int nativeSetChannelProfile(long j, int i);

    private native int nativeSetClientRole(long j, int i, Object obj);

    private native int nativeSetCloudProxy(long j, int i);

    private native int nativeSetColorEnhanceOptions(long j, boolean z, float f, float f2, int i);

    private native int nativeSetDefaultAudioRoutetoSpeakerphone(long j, boolean z);

    private native int nativeSetDefaultMuteAllRemoteAudioStreams(long j, boolean z);

    private native int nativeSetDefaultMuteAllRemoteVideoStreams(long j, boolean z);

    private native int nativeSetDirectCdnStreamingAudioConfiguration(long j, int i);

    private native int nativeSetDirectCdnStreamingVideoConfiguration(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    private native int nativeSetDualStreamModeEx(long j, int i, SimulcastStreamConfig simulcastStreamConfig, String str, int i2);

    private native int nativeSetEarMonitoringAudioFrameParameters(long j, int i, int i2, int i3, int i4);

    private native int nativeSetEffectPosition(long j, int i, int i2);

    private native int nativeSetEffectsVolume(long j, double d);

    private native int nativeSetEnableSpeakerphone(long j, boolean z);

    private native int nativeSetEncryptionMode(long j, String str);

    private native int nativeSetEncryptionSecret(long j, String str);

    private native int nativeSetExtensionProperty(long j, String str, String str2, String str3, String str4, int i);

    private native int nativeSetExtensionProperty2(long j, String str, String str2, String str3, String str4, int i, int i2, String str5, int i3);

    private native int nativeSetExtensionProviderProperty(long j, String str, String str2, String str3);

    private native int nativeSetExternalAudioSink(long j, boolean z, int i, int i2);

    private native int nativeSetExternalAudioSource(long j, boolean z, int i, int i2, boolean z2, boolean z3);

    private native int nativeSetExternalVideoSource(long j, boolean z, boolean z2, int i, EncodedVideoTrackOptions encodedVideoTrackOptions);

    private native int nativeSetHeadphoneEQParameters(long j, int i, int i2);

    private native int nativeSetHeadphoneEQPreset(long j, int i);

    private native int nativeSetHighPriorityUserList(long j, int[] iArr, int i, String str, int i2);

    private native int nativeSetInEarMonitoringVolume(long j, int i);

    private native int nativeSetLocalAccessPoint(long j, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, int i, Object obj);

    private native int nativeSetLocalRenderMode(long j, int i, int i2);

    private native int nativeSetLocalVideoMirrorMode(long j, int i);

    private native int nativeSetLocalVoiceEqualization(long j, int i, int i2);

    private native int nativeSetLocalVoiceFormant(long j, double d);

    private native int nativeSetLocalVoicePitch(long j, double d);

    private native int nativeSetLocalVoiceReverb(long j, int i, int i2);

    private native int nativeSetLogFile(long j, String str);

    private native int nativeSetLogFileSize(long j, long j2);

    private native int nativeSetLogFilter(long j, int i);

    private native int nativeSetLogLevel(long j, int i);

    private native int nativeSetLowlightEnhanceOptions(long j, boolean z, int i, int i2, int i3);

    private native int nativeSetMediaRecorderObserver(long j, Object obj, int i, String str, boolean z);

    private native int nativeSetMixedAudioFrameParameters(long j, int i, int i2, int i3);

    private native int nativeSetParameters(long j, String str);

    private native int nativeSetPlaybackAudioFrameBeforeMixingParameters(long j, int i, int i2);

    private native int nativeSetPlaybackAudioFrameParameters(long j, int i, int i2, int i3, int i4);

    private native int nativeSetProfile(long j, String str, boolean z);

    private native int nativeSetRecordingAudioFrameParameters(long j, int i, int i2, int i3, int i4);

    private native int nativeSetRemoteDefaultVideoStreamType(long j, int i);

    private native int nativeSetRemoteRenderMode(long j, int i, int i2, int i3, String str, int i4);

    private native int nativeSetRemoteUserPriority(long j, int i, int i2);

    private native int nativeSetRemoteUserSpatialAudioParams(long j, int i, SpatialAudioParams spatialAudioParams, String str, int i2);

    private native int nativeSetRemoteVideoStreamType(long j, int i, int i2, String str, int i3);

    private native int nativeSetRemoteVideoSubscriptionOptions(long j, int i, VideoSubscriptionOptions videoSubscriptionOptions, String str, int i2);

    private native int nativeSetRemoteVoicePosition(long j, int i, double d, double d2, String str, int i2);

    private native int nativeSetScreenCaptureScenario(long j, int i);

    private native int nativeSetSubscribeAudioBlacklist(long j, int[] iArr, String str, int i);

    private native int nativeSetSubscribeAudioWhitelist(long j, int[] iArr, String str, int i);

    private native int nativeSetSubscribeVideoBlacklist(long j, int[] iArr, String str, int i);

    private native int nativeSetSubscribeVideoWhitelist(long j, int[] iArr, String str, int i);

    private native int nativeSetVideoDenoiserOptions(long j, boolean z, int i, int i2, int i3);

    private native int nativeSetVideoEncoderConfiguration(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str, int i11);

    private native int nativeSetVoiceBeautifierParameters(long j, int i, int i2, int i3);

    private native int nativeSetVoiceBeautifierPreset(long j, int i);

    private native int nativeSetVoiceConversionParameters(long j, int i, int i2, int i3);

    private native int nativeSetVoiceConversionPreset(long j, int i);

    private native int nativeSetVolumeOfEffect(long j, int i, double d);

    private native int nativeSetupLocalVideo(long j, View view, int i, int i2, int i3, int i4, int[] iArr, int i5);

    private native int nativeSetupRemoteVideo(long j, View view, int i, int i2, int i3, int[] iArr, int i4, String str, int i5);

    private native int nativeStartAudioMixing(long j, String str, boolean z, int i, int i2);

    private native int nativeStartAudioRecording(long j, String str, int i);

    private native int nativeStartAudioRecording2(long j, String str, boolean z, int i, int i2, int i3, int i4);

    private native int nativeStartCameraCapture(long j, int i, CameraCapturerConfiguration cameraCapturerConfiguration);

    private native int nativeStartChannelMediaRelay(long j, ChannelMediaInfo channelMediaInfo, ChannelMediaInfo[] channelMediaInfoArr, String str, int i);

    private native int nativeStartDirectCdnStreaming(long j, Object obj, String str, DirectCdnStreamingMediaOptions directCdnStreamingMediaOptions);

    private native int nativeStartEchoTest(long j);

    private native int nativeStartEchoTestWithConfig(long j, View view, boolean z, boolean z2, String str, String str2, int i);

    private native int nativeStartEchoTestWithInterval(long j, int i);

    private native int nativeStartLastmileProbeTest(long j, boolean z, boolean z2, int i, int i2);

    private native int nativeStartLocalVideoTranscoder(long j, byte[] bArr);

    private native int nativeStartMediaRenderingTracing(long j);

    private native int nativeStartMediaRenderingTracingEx(long j, String str, int i);

    private native int nativeStartOrUpdateChannelMediaRelay(long j, ChannelMediaInfo channelMediaInfo, ChannelMediaInfo[] channelMediaInfoArr, String str, int i);

    private native int nativeStartPreview(long j);

    private native int nativeStartPreviewForSourceType(long j, int i);

    private native int nativeStartRecording(long j, String str, int i, int i2, int i3, int i4, int i5, String str2, boolean z);

    private native int nativeStartRecordingDeviceTest(long j, int i);

    private native int nativeStartRhythmPlayer(long j, String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    private native int nativeStartRtmpStreamWithTranscoding(long j, String str, byte[] bArr, String str2, int i);

    private native int nativeStartRtmpStreamWithoutTranscoding(long j, String str, String str2, int i);

    private native int nativeStartScreenCapture(long j, ScreenCaptureParameters screenCaptureParameters);

    private native int nativeStopAllEffects(long j);

    private native int nativeStopAudioMixing(long j);

    private native int nativeStopAudioRecording(long j);

    private native int nativeStopCameraCapture(long j, int i);

    private native int nativeStopChannelMediaRelay(long j, String str, int i);

    private native int nativeStopDirectCdnStreaming(long j);

    private native int nativeStopEchoTest(long j);

    private native int nativeStopEffect(long j, int i);

    private native int nativeStopLastmileProbeTest(long j);

    private native int nativeStopLocalVideoTranscoder(long j);

    private native int nativeStopPreview(long j);

    private native int nativeStopPreviewForSourceType(long j, int i);

    private native int nativeStopRecording(long j, int i, String str, boolean z);

    private native int nativeStopRecordingDeviceTest(long j);

    private native int nativeStopRhythmPlayer(long j);

    private native int nativeStopRtmpStream(long j, String str, String str2, int i);

    private native int nativeStopScreenCapture(long j);

    private native int nativeSwitchCamera(long j);

    private native int nativeTakeSnapshot(long j, int i, String str, String str2, int i2);

    private native int nativeUnRegisterAudioSpectrumObserver(long j, IAudioSpectrumObserver iAudioSpectrumObserver);

    private native int nativeUnRegisterMediaPlayerAudioSpectrumObserver(long j, int i, IAudioSpectrumObserver iAudioSpectrumObserver);

    private native int nativeUnloadAllEffects(long j);

    private native int nativeUnloadEffect(long j, int i);

    private native int nativeUnregisterMediaMetadataObserver(long j, Object obj, int i);

    private native int nativeUpdateChannelMediaOptions(long j, ChannelMediaOptions channelMediaOptions, String str, int i);

    private native int nativeUpdateChannelMediaRelay(long j, ChannelMediaInfo channelMediaInfo, ChannelMediaInfo[] channelMediaInfoArr, String str, int i);

    private native int nativeUpdateDirectCdnStreamingMediaOptions(long j, DirectCdnStreamingMediaOptions directCdnStreamingMediaOptions);

    private native int nativeUpdateLocalTranscoderConfiguration(long j, byte[] bArr);

    private native int nativeUpdateRtmpTranscoding(long j, byte[] bArr, String str, int i);

    private native int nativeUpdateScreenCaptureParameters(long j, ScreenCaptureParameters screenCaptureParameters);

    private native String nativeUploadLogFile(long j);

    private native int nativeregisterAudioEncodedFrameObserver(long j, IAudioEncodedFrameObserver iAudioEncodedFrameObserver, int i, int i2);

    private native int nativesetAINSMode(long j, boolean z, int i);

    private native int nativesetVideoScenario(long j, int i);

    private void onCameraExposureAreaChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PCameraExposureAreaChanged pCameraExposureAreaChanged = new RtcEngineMessage.PCameraExposureAreaChanged();
        pCameraExposureAreaChanged.unmarshall(bArr);
        int i = pCameraExposureAreaChanged.x;
        int i2 = pCameraExposureAreaChanged.y;
        iAgoraEventHandler.onCameraExposureAreaChanged(new Rect(i, i2, pCameraExposureAreaChanged.width + i, pCameraExposureAreaChanged.height + i2));
    }

    private void onCameraFocusAreaChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PCameraFocusAreaChanged pCameraFocusAreaChanged = new RtcEngineMessage.PCameraFocusAreaChanged();
        pCameraFocusAreaChanged.unmarshall(bArr);
        int i = pCameraFocusAreaChanged.x;
        int i2 = pCameraFocusAreaChanged.y;
        iAgoraEventHandler.onCameraFocusAreaChanged(new Rect(i, i2, pCameraFocusAreaChanged.width + i, pCameraFocusAreaChanged.height + i2));
    }

    private void onChannelMediaRelayEvent(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PCrossChannelEvent pCrossChannelEvent = new RtcEngineMessage.PCrossChannelEvent();
        pCrossChannelEvent.unmarshall(bArr);
        iAgoraEventHandler.onChannelMediaRelayEvent(pCrossChannelEvent.code);
    }

    private void onChannelMediaRelayStateChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PCrossChannelState pCrossChannelState = new RtcEngineMessage.PCrossChannelState();
        pCrossChannelState.unmarshall(bArr);
        iAgoraEventHandler.onChannelMediaRelayStateChanged(pCrossChannelState.state, pCrossChannelState.code);
    }

    private void onContentInspectResult(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PContentInspectResult pContentInspectResult = new RtcEngineMessage.PContentInspectResult();
        pContentInspectResult.unmarshall(bArr);
        iAgoraEventHandler.onContentInspectResult(pContentInspectResult.result);
    }

    private void onFacePositionChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        IRtcEngineEventHandler.AgoraFacePositionInfo[] agoraFacePositionInfoArr;
        RtcEngineMessage.PFacePositionChanged pFacePositionChanged = new RtcEngineMessage.PFacePositionChanged();
        pFacePositionChanged.unmarshall(bArr);
        RtcEngineMessage.PFacePositionChanged.FaceRect[] faceRectArr = pFacePositionChanged.rectArr;
        int i = 0;
        if (faceRectArr != null && faceRectArr.length > 0) {
            agoraFacePositionInfoArr = new IRtcEngineEventHandler.AgoraFacePositionInfo[faceRectArr.length];
            while (true) {
                RtcEngineMessage.PFacePositionChanged.FaceRect[] faceRectArr2 = pFacePositionChanged.rectArr;
                if (i >= faceRectArr2.length) {
                    break;
                }
                RtcEngineMessage.PFacePositionChanged.FaceRect faceRect = faceRectArr2[i];
                IRtcEngineEventHandler.AgoraFacePositionInfo agoraFacePositionInfo = new IRtcEngineEventHandler.AgoraFacePositionInfo();
                agoraFacePositionInfo.x = faceRect.x;
                agoraFacePositionInfo.y = faceRect.y;
                agoraFacePositionInfo.width = faceRect.width;
                agoraFacePositionInfo.height = faceRect.height;
                agoraFacePositionInfo.distance = pFacePositionChanged.disArr[i];
                agoraFacePositionInfoArr[i] = agoraFacePositionInfo;
                i++;
            }
        } else {
            agoraFacePositionInfoArr = new IRtcEngineEventHandler.AgoraFacePositionInfo[0];
        }
        iAgoraEventHandler.onFacePositionChanged(pFacePositionChanged.imageWidth, pFacePositionChanged.imageHeight, agoraFacePositionInfoArr);
    }

    private void onFirstLocalAudioFramePublished(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PFirstLocalAudioFrame pFirstLocalAudioFrame = new RtcEngineMessage.PFirstLocalAudioFrame();
        pFirstLocalAudioFrame.unmarshall(bArr);
        iAgoraEventHandler.onFirstLocalAudioFramePublished(pFirstLocalAudioFrame.elapsed);
    }

    private void onFirstLocalVideoFrame(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PFirstLocalVideoFrame pFirstLocalVideoFrame = new RtcEngineMessage.PFirstLocalVideoFrame();
        pFirstLocalVideoFrame.unmarshall(bArr);
        iAgoraEventHandler.onFirstLocalVideoFrame(Constants.VideoSourceType.fromInt(pFirstLocalVideoFrame.source), pFirstLocalVideoFrame.width, pFirstLocalVideoFrame.height, pFirstLocalVideoFrame.elapsed);
    }

    private void onFirstLocalVideoFramePublished(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PFirstLocalVideoFramePublished pFirstLocalVideoFramePublished = new RtcEngineMessage.PFirstLocalVideoFramePublished();
        pFirstLocalVideoFramePublished.unmarshall(bArr);
        iAgoraEventHandler.onFirstLocalVideoFramePublished(Constants.VideoSourceType.fromInt(pFirstLocalVideoFramePublished.source), pFirstLocalVideoFramePublished.elapsed);
    }

    private void onFirstRemoteVideoDecoded(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PFirstRemoteVideoDecoded pFirstRemoteVideoDecoded = new RtcEngineMessage.PFirstRemoteVideoDecoded();
        pFirstRemoteVideoDecoded.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onFirstRemoteVideoDecoded(pFirstRemoteVideoDecoded.uid, pFirstRemoteVideoDecoded.width, pFirstRemoteVideoDecoded.height, pFirstRemoteVideoDecoded.elapsed);
        }
    }

    private void onFirstRemoteVideoFrame(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PFirstRemoteVideoFrame pFirstRemoteVideoFrame = new RtcEngineMessage.PFirstRemoteVideoFrame();
        pFirstRemoteVideoFrame.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onFirstRemoteVideoFrame(pFirstRemoteVideoFrame.uid, pFirstRemoteVideoFrame.width, pFirstRemoteVideoFrame.height, pFirstRemoteVideoFrame.elapsed);
        }
    }

    private void onLocalAudioStat(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PLocalAudioStat pLocalAudioStat = new RtcEngineMessage.PLocalAudioStat();
        pLocalAudioStat.unmarshall(bArr);
        iAgoraEventHandler.onLocalAudioStats(pLocalAudioStat.stats);
    }

    private void onLocalVideoStat(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PLocalVideoStat pLocalVideoStat = new RtcEngineMessage.PLocalVideoStat();
        pLocalVideoStat.unmarshall(bArr);
        iAgoraEventHandler.onLocalVideoStats(Constants.VideoSourceType.fromInt(pLocalVideoStat.source), pLocalVideoStat.stats);
    }

    @CalledByNative
    private void onLogEvent(int i, String str) {
    }

    private void onRemoteAudioStat(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PRemoteAudioStat pRemoteAudioStat = new RtcEngineMessage.PRemoteAudioStat();
        pRemoteAudioStat.unmarshall(bArr);
        IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats = pRemoteAudioStat.stats;
        if (remoteAudioStats.uid == 0) {
            return;
        }
        iAgoraEventHandler.onRemoteAudioStats(remoteAudioStats);
    }

    private void onRemoteAudioStateChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PRemoteAudioState pRemoteAudioState = new RtcEngineMessage.PRemoteAudioState();
        pRemoteAudioState.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onRemoteAudioStateChanged(pRemoteAudioState.uid, pRemoteAudioState.state, pRemoteAudioState.reason, pRemoteAudioState.elapsed);
        }
    }

    private void onRemoteVideoStat(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PRemoteVideoStat pRemoteVideoStat = new RtcEngineMessage.PRemoteVideoStat();
        pRemoteVideoStat.unmarshall(bArr);
        iAgoraEventHandler.onRemoteVideoStats(pRemoteVideoStat.stats);
    }

    private void onRemoteVideoStateChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PRemoteVideoState pRemoteVideoState = new RtcEngineMessage.PRemoteVideoState();
        pRemoteVideoState.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onRemoteVideoStateChanged(pRemoteVideoState.uid, pRemoteVideoState.state, pRemoteVideoState.reason, pRemoteVideoState.elapsed);
        }
    }

    private void onRhythmPlayerStateChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PRhythmPlayerStateChanged pRhythmPlayerStateChanged = new RtcEngineMessage.PRhythmPlayerStateChanged();
        pRhythmPlayerStateChanged.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onRhythmPlayerStateChanged(pRhythmPlayerStateChanged.state, pRhythmPlayerStateChanged.errorCode);
        }
    }

    private void onSnapshotTaken(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PSnapshotTaken pSnapshotTaken = new RtcEngineMessage.PSnapshotTaken();
        pSnapshotTaken.unmarshall(bArr);
        iAgoraEventHandler.onSnapshotTaken(pSnapshotTaken.uid, pSnapshotTaken.filepath, pSnapshotTaken.width, pSnapshotTaken.height, pSnapshotTaken.errCode);
    }

    private void onSpeakersReport(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        if (bArr == null) {
            return;
        }
        RtcEngineMessage.PMediaResSpeakersReport pMediaResSpeakersReport = new RtcEngineMessage.PMediaResSpeakersReport();
        pMediaResSpeakersReport.unmarshall(bArr);
        RtcEngineMessage.PMediaResSpeakersReport.Speaker[] speakerArr = pMediaResSpeakersReport.speakers;
        if (speakerArr == null || speakerArr.length <= 0) {
            iAgoraEventHandler.onAudioVolumeIndication(new IRtcEngineEventHandler.AudioVolumeInfo[0], pMediaResSpeakersReport.mixVolume);
            return;
        }
        IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr = new IRtcEngineEventHandler.AudioVolumeInfo[speakerArr.length];
        for (int i = 0; i < pMediaResSpeakersReport.speakers.length; i++) {
            audioVolumeInfoArr[i] = new IRtcEngineEventHandler.AudioVolumeInfo();
            IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo = audioVolumeInfoArr[i];
            RtcEngineMessage.PMediaResSpeakersReport.Speaker[] speakerArr2 = pMediaResSpeakersReport.speakers;
            audioVolumeInfo.uid = speakerArr2[i].uid;
            audioVolumeInfoArr[i].volume = speakerArr2[i].volume;
            audioVolumeInfoArr[i].vad = speakerArr2[i].vad;
            audioVolumeInfoArr[i].voicePitch = speakerArr2[i].voicePitch;
        }
        iAgoraEventHandler.onAudioVolumeIndication(audioVolumeInfoArr, pMediaResSpeakersReport.mixVolume);
    }

    private void onStreamMessage(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PStreamMessage pStreamMessage = new RtcEngineMessage.PStreamMessage();
        pStreamMessage.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onStreamMessage(pStreamMessage.uid, pStreamMessage.streamId, pStreamMessage.payload);
        }
    }

    private void onStreamMessageError(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PStreamMessageError pStreamMessageError = new RtcEngineMessage.PStreamMessageError();
        pStreamMessageError.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onStreamMessageError(pStreamMessageError.uid, pStreamMessageError.streamId, pStreamMessageError.error, pStreamMessageError.missed, pStreamMessageError.cached);
        }
    }

    private void onUserStateChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        if (bArr == null) {
            return;
        }
        RtcEngineMessage.PUserStateChanged pUserStateChanged = new RtcEngineMessage.PUserStateChanged();
        pUserStateChanged.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onUserStateChanged(pUserStateChanged.uid, pUserStateChanged.state);
        }
    }

    private void onVideoSizeChanged(byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        RtcEngineMessage.PVideoSizeChanged pVideoSizeChanged = new RtcEngineMessage.PVideoSizeChanged();
        pVideoSizeChanged.unmarshall(bArr);
        if (iAgoraEventHandler instanceof IRtcEngineEventHandler) {
            ((IRtcEngineEventHandler) iAgoraEventHandler).onVideoSizeChanged(Constants.VideoSourceType.fromInt(pVideoSizeChanged.source), pVideoSizeChanged.uid, pVideoSizeChanged.width, pVideoSizeChanged.height, pVideoSizeChanged.rotation);
        }
    }

    public static synchronized boolean preloadExtensions() {
        return preloadExtensions("", null);
    }

    public static synchronized boolean preloadExtensions(String str, String[] strArr) {
        String[] strArr2 = PRELOAD_EXTENSIONS;
        if (strArr == null || strArr.length <= 0) {
            strArr = strArr2;
        }
        boolean zSafeLoadLibrary = false;
        for (String str2 : strArr) {
            Logging.i(TAG, "load extension: " + str2);
            zSafeLoadLibrary = safeLoadLibrary(str, str2);
            if (!zSafeLoadLibrary) {
                return zSafeLoadLibrary;
            }
        }
        return zSafeLoadLibrary;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static boolean safeLoadLibrary(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                System.loadLibrary(str2);
            } else {
                System.load(getNativeLibFullPath(str, str2));
            }
            z = true;
        } catch (NullPointerException | SecurityException | Exception | UnsatisfiedLinkError unused) {
        }
        if (!z) {
            String str3 = "failed to load library " + str2 + " from " + str;
        }
        return z;
    }

    private void sendLogEvent(byte[] bArr) {
        try {
            onLogEvent(0, new String(bArr, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private int setParameter(String str, int i) {
        return setParameters(formatString("{\"%s\":%d}", str, Integer.valueOf(i)));
    }

    private int setParameter(String str, String str2) {
        return setParameters(formatString("{\"%s\":\"%s\"}", str, str2));
    }

    private int setParameter(String str, boolean z) {
        return setParameters(formatString("{\"%s\":%b}", str, Boolean.valueOf(z)));
    }

    private int setParameterObject(String str, String str2) {
        return setParameters(formatString("{\"%s\":%s}", str, str2));
    }

    private int setUidCompatibleMode(boolean z) {
        return setParameter("rtc.api.set_uid_compatible_mode", z);
    }

    private static String toStringUserId(int i) {
        return RtcEngineMessage.toStringUserId(i);
    }

    private void updateRtcStats(RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats) {
        IRtcEngineEventHandler.RtcStats rtcStats = getRtcStats();
        rtcStats.totalDuration = pMediaResRtcStats.totalDuration;
        rtcStats.txBytes = pMediaResRtcStats.totalTxBytes;
        rtcStats.rxBytes = pMediaResRtcStats.totalRxBytes;
        rtcStats.txAudioBytes = pMediaResRtcStats.txAudioBytes;
        rtcStats.rxAudioBytes = pMediaResRtcStats.rxAudioBytes;
        rtcStats.txVideoBytes = pMediaResRtcStats.txVideoBytes;
        rtcStats.rxVideoBytes = pMediaResRtcStats.rxVideoBytes;
        rtcStats.txKBitRate = pMediaResRtcStats.txKBitRate;
        rtcStats.rxKBitRate = pMediaResRtcStats.rxKBitRate;
        rtcStats.txAudioKBitRate = pMediaResRtcStats.txAudioKBitRate;
        rtcStats.rxAudioKBitRate = pMediaResRtcStats.rxAudioKBitRate;
        rtcStats.txVideoKBitRate = pMediaResRtcStats.txVideoKBitRate;
        rtcStats.rxVideoKBitRate = pMediaResRtcStats.rxVideoKBitRate;
        rtcStats.lastmileDelay = pMediaResRtcStats.lastmileDelay;
        rtcStats.users = pMediaResRtcStats.users;
        rtcStats.cpuTotalUsage = pMediaResRtcStats.cpuTotalUsage / 100.0d;
        rtcStats.gatewayRtt = pMediaResRtcStats.gatewayRtt;
        rtcStats.cpuAppUsage = pMediaResRtcStats.cpuAppUsage / 100.0d;
        rtcStats.connectTimeMs = pMediaResRtcStats.connectTimeMs;
        rtcStats.txPacketLossRate = pMediaResRtcStats.txPacketLossRate;
        rtcStats.rxPacketLossRate = pMediaResRtcStats.rxPacketLossRate;
        rtcStats.memoryAppUsageRatio = pMediaResRtcStats.memoryAppUsageRatio;
        rtcStats.memoryTotalUsageRatio = pMediaResRtcStats.memoryTotalUsageRatio;
        rtcStats.memoryAppUsageInKbytes = pMediaResRtcStats.memoryAppUsageInKbytes;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int validatePushExternalVideoFrame(io.agora.rtc2.video.AgoraVideoFrame r10) {
        /*
            r9 = this;
            r0 = -2
            if (r10 != 0) goto L4
            return r0
        L4:
            int r1 = r10.format
            r2 = 10
            r3 = 0
            if (r1 == r2) goto L8e
            r2 = 11
            if (r1 != r2) goto L11
            goto L8e
        L11:
            byte[] r2 = r10.buf
            if (r2 == 0) goto L8d
            int r4 = r2.length
            if (r4 != 0) goto L1a
            goto L8d
        L1a:
            r4 = 1
            r5 = 2
            if (r1 != r4) goto L3c
            int r1 = r10.stride
            int r6 = r1 + 1
            int r6 = r6 / r5
            int r7 = r10.height
            int r8 = r7 + 1
            int r8 = r8 / r5
            int r1 = r1 * r7
            int r8 = r8 * r6
            int r8 = r8 * 2
            int r1 = r1 + r8
            int r7 = r10.cropRight
            int r7 = r7 + r4
            int r7 = r7 / r5
        L33:
            int r1 = r1 - r7
            int r10 = r10.cropBottom
            int r10 = r10 + r4
            int r10 = r10 / r5
        L38:
            int r10 = r10 * r6
            int r1 = r1 - r10
            goto L88
        L3c:
            r6 = 4
            if (r1 == r5) goto L77
            if (r1 != r6) goto L42
            goto L77
        L42:
            r6 = 3
            if (r1 != r6) goto L5c
            int r1 = r10.stride
            int r6 = r1 % 2
            if (r6 != 0) goto L4d
            r6 = r1
            goto L4f
        L4d:
            int r6 = r1 + 1
        L4f:
            int r7 = r10.height
            int r8 = r7 + 1
            int r8 = r8 / r5
            int r1 = r1 * r7
            int r8 = r8 * r6
            int r1 = r1 + r8
            int r7 = r10.cropRight
            goto L33
        L5c:
            r6 = 16
            if (r1 != r6) goto L76
            int r1 = r10.stride
            int r6 = r1 + 1
            int r6 = r6 / r5
            int r7 = r10.height
            int r1 = r1 * r7
            int r7 = r7 * r6
            int r7 = r7 * 2
            int r1 = r1 + r7
            int r7 = r10.cropRight
            int r7 = r7 + r4
            int r7 = r7 / r5
            int r1 = r1 - r7
            int r10 = r10.cropBottom
            goto L38
        L76:
            return r0
        L77:
            int r1 = r10.stride
            int r4 = r10.height
            int r4 = r4 * r1
            int r4 = r4 * 4
            int r5 = r10.cropRight
            int r4 = r4 - r5
            int r10 = r10.cropBottom
            int r10 = r10 * r1
            int r1 = r4 - r10
        L88:
            int r10 = r2.length
            if (r10 >= r1) goto L8c
            return r0
        L8c:
            return r3
        L8d:
            return r0
        L8e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.RtcEngineImpl.validatePushExternalVideoFrame(io.agora.rtc2.video.AgoraVideoFrame):int");
    }

    private boolean validateVideoRendererView(View view) {
        return view == null || (view instanceof SurfaceView) || (view instanceof TextureView);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int SetAdvancedAudioOptions(AdvancedAudioOptions advancedAudioOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAdvancedAudioOptions(j, advancedAudioOptions.audioProcessingChannels.getValue());
    }

    public synchronized void addHandler(IAgoraEventHandler iAgoraEventHandler) {
        this.mRtcHandlers.put(iAgoraEventHandler, 0);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int addVideoWatermark(AgoraImage agoraImage) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (agoraImage != null && !TextUtils.isEmpty(agoraImage.url)) {
                WatermarkOptions watermarkOptions = new WatermarkOptions();
                String str = agoraImage.url;
                watermarkOptions.visibleInPreview = false;
                WatermarkOptions.Rectangle rectangle = new WatermarkOptions.Rectangle(agoraImage.x, agoraImage.y, agoraImage.width, agoraImage.height);
                watermarkOptions.positionInLandscapeMode = rectangle;
                watermarkOptions.positionInPortraitMode = rectangle;
                return addVideoWatermark(str, watermarkOptions);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int addVideoWatermark(String str, WatermarkOptions watermarkOptions) {
        return addVideoWatermarkEx(str, watermarkOptions, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int addVideoWatermarkEx(String str, WatermarkOptions watermarkOptions, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (str != null && !TextUtils.isEmpty(str) && watermarkOptions != null) {
                int[] iArr = new int[4];
                int[] iArr2 = new int[4];
                WatermarkOptions.Rectangle rectangle = watermarkOptions.positionInLandscapeMode;
                if (rectangle != null) {
                    iArr[0] = rectangle.x;
                    iArr[1] = rectangle.y;
                    iArr[2] = rectangle.width;
                    iArr[3] = rectangle.height;
                }
                WatermarkOptions.Rectangle rectangle2 = watermarkOptions.positionInPortraitMode;
                if (rectangle2 != null) {
                    iArr2[0] = rectangle2.x;
                    iArr2[1] = rectangle2.y;
                    iArr2[2] = rectangle2.width;
                    iArr2[3] = rectangle2.height;
                }
                return nativeAddVideoWatermark(this.mNativeHandle, str, watermarkOptions.visibleInPreview, iArr, iArr2, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustAudioMixingPlayoutVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustAudioMixingPlayoutVolume(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustAudioMixingPublishVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustAudioMixingPublishVolume(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustAudioMixingVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustAudioMixingVolume(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustCustomAudioPlayoutVolume(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustCustomAudioPlayoutVolume(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustCustomAudioPublishVolume(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustCustomAudioPublishVolume(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustPlaybackSignalVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustPlaybackSignalVolume(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustRecordingSignalVolume(int i) {
        return adjustRecordingSignalVolumeEx(i, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int adjustRecordingSignalVolumeEx(int i, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustRecordingSignalVolume(j, i, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int adjustUserPlaybackSignalVolume(int i, int i2) {
        return adjustUserPlaybackSignalVolumeEx(i, i2, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int adjustUserPlaybackSignalVolumeEx(int i, int i2, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAdjustUserPlaybackSignalVolume(j, i, i2, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    public void allowCaptureCurrentApp() {
        if (Build.VERSION.SDK_INT >= 29 && this.mContext.get() != null) {
            ((AudioManager) getContext().getSystemService("audio")).setAllowedCapturePolicy(1);
        }
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int clearVideoWatermarkEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeClearVideoWatermarkEx(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int clearVideoWatermarks() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeClearVideoWatermarks(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int complain(String str, String str2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeComplain(j, str, str2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int configRhythmPlayer(AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (agoraRhythmPlayerConfig != null) {
                return nativeConfigRhythmPlayer(j, agoraRhythmPlayerConfig);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int createCustomAudioTrack(Constants.AudioTrackType audioTrackType, AudioTrackConfig audioTrackConfig) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeCreateCustomAudioTrack(j, Constants.AudioTrackType.getValue(audioTrackType), audioTrackConfig.enableLocalPlayback);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int createCustomEncodedVideoTrack(EncodedVideoTrackOptions encodedVideoTrackOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeCreateCustomEncodedVideoTrack(j, encodedVideoTrackOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int createCustomVideoTrack() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeCreateCustomVideoTrack(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int createDataStream(DataStreamConfig dataStreamConfig) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return createDataStreamEx(dataStreamConfig, null);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int createDataStream(boolean z, boolean z2) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return createDataStreamEx(z, z2, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int createDataStreamEx(DataStreamConfig dataStreamConfig, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeCreateDataStream2(j, dataStreamConfig.ordered, dataStreamConfig.syncWithAudio, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int createDataStreamEx(boolean z, boolean z2, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeCreateDataStream(j, z, z2, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized IMediaPlayer createMediaPlayer() {
        long j = this.mNativeHandle;
        MediaPlayerImpl mediaPlayerImpl = null;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        int iNativeCreateMediaPlayer = nativeCreateMediaPlayer(j);
        if (iNativeCreateMediaPlayer >= 0) {
            mediaPlayerImpl = new MediaPlayerImpl(this, iNativeCreateMediaPlayer);
        } else {
            Logging.e(TAG, "Create media player failed " + iNativeCreateMediaPlayer);
        }
        return mediaPlayerImpl;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized AgoraMediaRecorder createMediaRecorder(RecorderStreamInfo recorderStreamInfo) {
        if (this.mNativeHandle == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        AgoraMediaRecorder agoraMediaRecorder = new AgoraMediaRecorder(this, recorderStreamInfo);
        mMediaRecorders.put(agoraMediaRecorder, Pair.create(recorderStreamInfo.channelId, Integer.valueOf(recorderStreamInfo.uid)));
        return agoraMediaRecorder;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int destroyCustomAudioTrack(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeDestroyCustomAudioTrack(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int destroyCustomEncodedVideoTrack(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeDestroyCustomEncodedVideoTrack(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int destroyCustomVideoTrack(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeDestroyCustomVideoTrack(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized void destroyMediaRecorder(AgoraMediaRecorder agoraMediaRecorder) {
        if (this.mNativeHandle == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
        } else {
            agoraMediaRecorder.release();
            mMediaRecorders.remove(agoraMediaRecorder);
        }
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int disableAudio() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableAudio(j, false);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int disableAudioSpectrumMonitor() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeDisableAudioSpectrumMonitor(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int disableVideo() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeDisableVideo(j);
    }

    public synchronized void doDestroy() {
        setExternalAudioSource(false, 0, 0, false, false);
        setExternalVideoSource(false, false, Constants.ExternalVideoSourceType.VIDEO_FRAME);
        Iterator<Map.Entry<AgoraMediaRecorder, Pair<String, Object>>> it = mMediaRecorders.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().release();
        }
        mMediaRecorders.clear();
        MediaPlayerCacheManagerImpl.destroyMediaPlayerCacheManager();
        H265TranscoderImpl.destroyInstance();
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeHandle = 0L;
            sLibLoaded = false;
        }
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableAudio() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableAudio(j, true);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableAudioQualityIndication(boolean z) {
        return setParameter("che.audio.quality_indication", z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableAudioSpectrumMonitor(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableAudioSpectrumMonitor(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableAudioVolumeIndication(int i, int i2, boolean z) {
        return enableAudioVolumeIndicationEx(i, i2, z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int enableAudioVolumeIndicationEx(int i, int i2, boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableAudioVolumeIndication(j, i, i2, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableContentInspect(boolean z, ContentInspectConfig contentInspectConfig) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        byte[] bArrMarshall = null;
        if (z) {
            if (contentInspectConfig == null) {
                return -7;
            }
            bArrMarshall = new RtcEngineMessage.PContentInspectConfig().marshall(contentInspectConfig);
        }
        return nativeEnableContentInspect(this.mNativeHandle, z, bArrMarshall);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableCustomAudioLocalPlayback(int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableCustomAudioLocalPlayback(j, i, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableDualStreamMode(boolean z) {
        return enableDualStreamMode(z, new SimulcastStreamConfig());
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableDualStreamMode(boolean z, SimulcastStreamConfig simulcastStreamConfig) {
        return enableDualStreamModeEx(z, simulcastStreamConfig, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public int enableDualStreamModeEx(boolean z, SimulcastStreamConfig simulcastStreamConfig, RtcConnection rtcConnection) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (simulcastStreamConfig == null) {
            simulcastStreamConfig = new SimulcastStreamConfig();
        }
        return nativeEnableDualStreamModeEx(this.mNativeHandle, z, simulcastStreamConfig, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableEncryption(boolean z, EncryptionConfig encryptionConfig) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableEncryption(j, z, encryptionConfig.encryptionMode.getValue(), encryptionConfig.encryptionKey, encryptionConfig.encryptionKdfSalt);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableExtension(String str, String str2, ExtensionInfo extensionInfo, boolean z) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (extensionInfo != null) {
                return nativeEnableExtension2(j, str, str2, z, Constants.MediaSourceType.getValue(extensionInfo.mediaSourceType), extensionInfo.remoteUid, extensionInfo.channelId, extensionInfo.localUid);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableExtension(String str, String str2, boolean z) {
        return enableExtension(str, str2, z, Constants.MediaSourceType.UNKNOWN_MEDIA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableExtension(String str, String str2, boolean z, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableExtension(j, str, str2, z, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableExternalAudioSourceLocalPlayback(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableExternalAudioSourceLocalPlayback(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableFaceDetection(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableFaceDetection(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean enableHighPerfWifiMode(boolean z) {
        Context context = this.mContext.get();
        if (context == null) {
            return false;
        }
        if (!z) {
            this.mWifiLock = null;
        } else {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0) {
                Logging.w(TAG, "Failed to enableHighPerfWifiMode, permission WAKE_LOCK not granted ");
                this.mWifiLock = null;
                return false;
            }
            if (this.mWifiLock == null) {
                this.mWifiLock = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).createWifiLock(3, "agora.voip.lock");
            }
        }
        return true;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableInEarMonitoring(boolean z) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return enableInEarMonitoring(z, 1);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableInEarMonitoring(boolean z, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableInEarMonitoring(j, z, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableInstantMediaRendering() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableInstantMediaRendering(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableLocalAudio(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableLocalAudio(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableLocalVideo(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableLocalVideo(j, z);
    }

    public synchronized int enableRemoteVideo(boolean z, int i) {
        return setParameterObject("che.video.peer.receive", formatString("{\"enable\":%b, \"uid\":\"%s\"}", Boolean.valueOf(z), toStringUserId(i)));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableSoundPositionIndication(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableSoundPositionIndication(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableSpatialAudio(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableSpatialAudio(j, z);
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int enableTransportQualityIndication(boolean z) {
        return setParameter("rtc.transport_quality_indication", z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableVideo() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeEnableVideo(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableVideoImageSource(boolean z, ImageTrackOptions imageTrackOptions) {
        String str;
        int mirrorMode;
        int fps;
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (!z || (imageTrackOptions != null && !TextUtils.isEmpty(imageTrackOptions.getImageUrl()) && imageTrackOptions.getFps() > 0)) {
                int value = VideoEncoderConfiguration.MIRROR_MODE_TYPE.MIRROR_MODE_DISABLED.getValue();
                if (imageTrackOptions != null) {
                    String imageUrl = imageTrackOptions.getImageUrl();
                    str = imageUrl;
                    fps = imageTrackOptions.getFps();
                    mirrorMode = imageTrackOptions.getMirrorMode();
                } else {
                    str = "";
                    mirrorMode = value;
                    fps = 0;
                }
                return nativeEnableVideoImageSource(this.mNativeHandle, z, str, fps, mirrorMode);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableVirtualBackground(boolean z, VirtualBackgroundSource virtualBackgroundSource, SegmentationProperty segmentationProperty) {
        return enableVirtualBackground(z, virtualBackgroundSource, segmentationProperty, Constants.MediaSourceType.PRIMARY_CAMERA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableVirtualBackground(boolean z, VirtualBackgroundSource virtualBackgroundSource, SegmentationProperty segmentationProperty, Constants.MediaSourceType mediaSourceType) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (virtualBackgroundSource == null) {
            if (z) {
                return -2;
            }
            virtualBackgroundSource = new VirtualBackgroundSource();
        }
        if (segmentationProperty == null) {
            if (z) {
                return -2;
            }
            segmentationProperty = new SegmentationProperty();
        }
        return nativeEnableVirtualBackground(this.mNativeHandle, z, virtualBackgroundSource.backgroundSourceType, virtualBackgroundSource.color, virtualBackgroundSource.source, virtualBackgroundSource.blurDegree, segmentationProperty.modelType, segmentationProperty.greenCapacity, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableWebSdkInteroperability(boolean z) {
        return setParameters(String.format("{\"rtc.video.web_h264_interop_enable\":%b,\"che.video.web_h264_interop_enable\":%b}", Boolean.valueOf(z), Boolean.valueOf(z)));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int enableWirelessAccelerate(boolean z) {
        Object[] objArr;
        objArr = new Object[1];
        objArr[0] = z ? "true" : "false";
        return setParameters(formatString("{\"rtc.video.wifi_acc_enable\":%s}", objArr));
    }

    public void finalize() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDestroy(j);
        }
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized DeviceInfo getAudioDeviceInfo() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return nativeGetAudioDeviceInfo(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public IAudioEffectManager getAudioEffectManager() {
        return this;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getAudioMixingCurrentPosition() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetAudioMixingCurrentPosition(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getAudioMixingDuration() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetAudioMixingDuration(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getAudioMixingPlayoutVolume() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetAudioMixingPlayoutVolume(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getAudioMixingPublishVolume() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetAudioMixingPublishVolume(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getAudioOptionParams() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeGetAudioOptionParams(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getAudioTrackCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetAudioTrackCount(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getCallId() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeGetCallId(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized float getCameraMaxZoomFactor() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 1.0f;
        }
        return nativeGetCameraMaxZoomFactor(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getConnectionState() {
        return getConnectionStateEx(null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int getConnectionStateEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return -7;
        }
        return nativeGetConnectionState(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    public Context getContext() {
        return this.mContext.get();
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized long getCurrentMonotonicTimeInMs() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7L;
        }
        return nativeGetCurrentMonotonicTimeInMs(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getEffectCurrentPosition(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetEffectCurrentPosition(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getEffectDuration(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetEffectDuration(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized double getEffectsVolume() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return nativeGetEffectsVolume(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getExtensionProperty(String str, String str2, ExtensionInfo extensionInfo, String str3) {
        long j = this.mNativeHandle;
        if (j != 0 && extensionInfo != null) {
            return nativeGetExtensionProperty2(j, str, str2, str3, Constants.MediaSourceType.getValue(extensionInfo.mediaSourceType), extensionInfo.remoteUid, extensionInfo.channelId, extensionInfo.localUid);
        }
        return null;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getExtensionProperty(String str, String str2, String str3) {
        return getExtensionProperty(str, str2, str3, Constants.MediaSourceType.UNKNOWN_MEDIA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getExtensionProperty(String str, String str2, String str3, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return nativeGetExtensionProperty(j, str, str2, str3, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized IH265Transcoder getH265Transcoder() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeCreateH265Transcoder(j) >= 0 ? H265TranscoderImpl.getInstance(this) : null;
        }
        Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (createH265Transcoder)");
        return null;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized IMediaPlayerCacheManager getMediaPlayerCacheManager() {
        IMediaPlayerCacheManager iMediaPlayerCacheManager = null;
        if (this.mNativeHandle != 0) {
            IMediaPlayerCacheManager mediaPlayerCacheManager = MediaPlayerCacheManagerImpl.getMediaPlayerCacheManager(this);
            if (mediaPlayerCacheManager == null) {
                Logging.e(TAG, "mediaPlayerCacheManager is not init");
                return null;
            }
            iMediaPlayerCacheManager = mediaPlayerCacheManager;
        } else {
            Logging.e(TAG, "mNativeHandle is not init");
        }
        return iMediaPlayerCacheManager;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized long getNativeHandle() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0L;
        }
        return nativeGetRtcEngine(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized long getNativeMediaPlayer(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7L;
        }
        return nativeGetMediaPlayer(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getNetworkType() {
        return nativeGetNetworkType(this.mNativeHandle);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized long getNtpWallTimeInMs() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0L;
        }
        return nativeGetNtpWallTimeInMs(j);
    }

    public int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getParameter(String str, String str2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeGetParameter(j, str, str2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String getParameters(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeGetParameters(j, str);
    }

    public synchronized String getProfile() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeGetProfile(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getUserInfoByUid(int i, UserInfo userInfo) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (userInfo != null) {
                return nativeGetUserInfoByUid(j, i, userInfo);
            }
            Logging.e(TAG, "Failed to getUserInfoByUid, userInfo null");
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int getUserInfoByUidEx(int i, UserInfo userInfo, RtcConnection rtcConnection) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (userInfo == null) {
            Logging.e(TAG, "Failed to getUserInfoByUidEx, userInfo null");
            return -2;
        }
        if (rtcConnection == null) {
            return -2;
        }
        return nativeGetUserInfoByUidEx(this.mNativeHandle, i, userInfo, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getUserInfoByUserAccount(String str, UserInfo userInfo) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (userInfo != null) {
                return nativeGetUserInfoByUserAccount(j, str, userInfo);
            }
            Logging.e(TAG, "Failed to getUserInfoByUserAccount, userInfo null");
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int getUserInfoByUserAccountEx(String str, UserInfo userInfo, RtcConnection rtcConnection) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (userInfo == null) {
            Logging.e(TAG, "Failed to getUserInfoByUserAccountEx, userInfo null");
            return -2;
        }
        if (rtcConnection == null) {
            return -2;
        }
        return nativeGetUserInfoByUserAccountEx(this.mNativeHandle, str, userInfo, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int getVolumeOfEffect(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetVolumeOfEffect(j, i);
    }

    public synchronized int h265TranscoderEnableTranscode(String str, String str2, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeH265TranscoderEnableTranscode(j, str, str2, i);
    }

    public synchronized int h265TranscoderQueryChannel(String str, String str2, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeH265TranscoderQueryChannel(j, str, str2, i);
    }

    public synchronized int h265TranscoderRegisterObserver(IH265TranscoderObserver iH265TranscoderObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeH265TranscoderRegisterObserver(j, iH265TranscoderObserver);
    }

    public synchronized int h265TranscoderTriggerTranscode(String str, String str2, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeH265TranscoderTriggerTranscode(j, str, str2, i);
    }

    public synchronized int h265TranscoderUnregisterObserver(IH265TranscoderObserver iH265TranscoderObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeH265TranscoderUnregisterObserver(j, iH265TranscoderObserver);
    }

    public void handleEvent(int i, byte[] bArr, IAgoraEventHandler iAgoraEventHandler) {
        if (iAgoraEventHandler == null || !(iAgoraEventHandler instanceof IRtcEngineEventHandler)) {
            return;
        }
        if (i == 100) {
            sendLogEvent(bArr);
            return;
        }
        if (i == 101) {
            RtcEngineMessage.PError pError = new RtcEngineMessage.PError();
            pError.unmarshall(bArr);
            iAgoraEventHandler.onError(pError.err);
            return;
        }
        if (i == 1108) {
            iAgoraEventHandler.onRequestToken();
            return;
        }
        if (i == 1109) {
            RtcEngineMessage.PClientRoleChanged pClientRoleChanged = new RtcEngineMessage.PClientRoleChanged();
            pClientRoleChanged.unmarshall(bArr);
            ClientRoleOptions clientRoleOptions = new ClientRoleOptions();
            clientRoleOptions.audienceLatencyLevel = pClientRoleChanged.newRoleLatencyLevel;
            iAgoraEventHandler.onClientRoleChanged(pClientRoleChanged.oldRole, pClientRoleChanged.newRole, clientRoleOptions);
            return;
        }
        switch (i) {
            case 1002:
                iAgoraEventHandler.onMediaEngineLoadSuccess();
                return;
            case 1102:
                RtcEngineMessage.PMediaResAudioQuality pMediaResAudioQuality = new RtcEngineMessage.PMediaResAudioQuality();
                pMediaResAudioQuality.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onAudioQuality(pMediaResAudioQuality.uid, pMediaResAudioQuality.quality, pMediaResAudioQuality.delay, pMediaResAudioQuality.lost);
                return;
            case 1104:
                RtcEngineMessage.PMediaEngineEvent pMediaEngineEvent = new RtcEngineMessage.PMediaEngineEvent();
                pMediaEngineEvent.unmarshall(bArr);
                if (pMediaEngineEvent.code != 10) {
                    return;
                }
                break;
            case RtcEngineEvent.EvtType.EVT_LIVE_TRANSCODING /* 1112 */:
                iAgoraEventHandler.onTranscodingUpdated();
                return;
            case RtcEngineEvent.EvtType.EVT_OPEN_CHANNEL_SUCCESS /* 13001 */:
                RtcEngineMessage.PMediaResJoinMedia pMediaResJoinMedia = new RtcEngineMessage.PMediaResJoinMedia();
                pMediaResJoinMedia.unmarshall(bArr);
                IRtcEngineEventHandler iRtcEngineEventHandler = (IRtcEngineEventHandler) iAgoraEventHandler;
                if (pMediaResJoinMedia.firstSuccess) {
                    iRtcEngineEventHandler.onJoinChannelSuccess(pMediaResJoinMedia.channel, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                    return;
                } else {
                    iRtcEngineEventHandler.onRejoinChannelSuccess(pMediaResJoinMedia.channel, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                    return;
                }
            case RtcEngineEvent.EvtType.EVT_RTC_STATS /* 13010 */:
                RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats = new RtcEngineMessage.PMediaResRtcStats();
                pMediaResRtcStats.unmarshall(bArr);
                updateRtcStats(pMediaResRtcStats);
                iAgoraEventHandler.onRtcStats(getRtcStats());
                return;
            case RtcEngineEvent.EvtType.EVT_USER_JOINED /* 13013 */:
                RtcEngineMessage.PMediaResUserJoinedEvent pMediaResUserJoinedEvent = new RtcEngineMessage.PMediaResUserJoinedEvent();
                pMediaResUserJoinedEvent.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserJoined(pMediaResUserJoinedEvent.uid, pMediaResUserJoinedEvent.elapsed);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_MUTE_AUDIO /* 13014 */:
                RtcEngineMessage.PMediaResUserState pMediaResUserState = new RtcEngineMessage.PMediaResUserState();
                pMediaResUserState.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserMuteAudio(pMediaResUserState.uid, pMediaResUserState.state);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_MUTE_VIDEO /* 13015 */:
                RtcEngineMessage.PMediaResUserState pMediaResUserState2 = new RtcEngineMessage.PMediaResUserState();
                pMediaResUserState2.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserMuteVideo(pMediaResUserState2.uid, pMediaResUserState2.state);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_ENABLE_VIDEO /* 13016 */:
                RtcEngineMessage.PMediaResUserState pMediaResUserState3 = new RtcEngineMessage.PMediaResUserState();
                pMediaResUserState3.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserEnableVideo(pMediaResUserState3.uid, pMediaResUserState3.state);
                return;
            case RtcEngineEvent.EvtType.EVT_LASTMILE_QUALITY /* 13017 */:
                RtcEngineMessage.PMediaResLastmileQuality pMediaResLastmileQuality = new RtcEngineMessage.PMediaResLastmileQuality();
                pMediaResLastmileQuality.unmarshall(bArr);
                iAgoraEventHandler.onLastmileQuality(pMediaResLastmileQuality.quality);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_EFFECT_FINISHED /* 13018 */:
                RtcEngineMessage.PMediaResAudioEffectFinished pMediaResAudioEffectFinished = new RtcEngineMessage.PMediaResAudioEffectFinished();
                pMediaResAudioEffectFinished.unmarshall(bArr);
                iAgoraEventHandler.onAudioEffectFinished(pMediaResAudioEffectFinished.soundId);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_ENABLE_LOCAL_VIDEO /* 13019 */:
                RtcEngineMessage.PMediaResUserState pMediaResUserState4 = new RtcEngineMessage.PMediaResUserState();
                pMediaResUserState4.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserEnableLocalVideo(pMediaResUserState4.uid, pMediaResUserState4.state);
                return;
            case RtcEngineEvent.EvtType.EVT_LASTMILE_PROBE_RESULT /* 13020 */:
                RtcEngineMessage.PMediaResLastmileProbeResult pMediaResLastmileProbeResult = new RtcEngineMessage.PMediaResLastmileProbeResult();
                pMediaResLastmileProbeResult.unmarshall(bArr);
                IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult = new IRtcEngineEventHandler.LastmileProbeResult();
                lastmileProbeResult.state = pMediaResLastmileProbeResult.state;
                lastmileProbeResult.rtt = pMediaResLastmileProbeResult.rtt;
                IRtcEngineEventHandler.LastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult = lastmileProbeResult.uplinkReport;
                RtcEngineMessage.PMediaResLastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult2 = pMediaResLastmileProbeResult.uplinkReport;
                lastmileProbeOneWayResult.packetLossRate = lastmileProbeOneWayResult2.packetLossRate;
                lastmileProbeOneWayResult.jitter = lastmileProbeOneWayResult2.jitter;
                lastmileProbeOneWayResult.availableBandwidth = lastmileProbeOneWayResult2.availableBandwidth;
                IRtcEngineEventHandler.LastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult3 = lastmileProbeResult.downlinkReport;
                RtcEngineMessage.PMediaResLastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult4 = pMediaResLastmileProbeResult.downlinkReport;
                lastmileProbeOneWayResult3.packetLossRate = lastmileProbeOneWayResult4.packetLossRate;
                lastmileProbeOneWayResult3.jitter = lastmileProbeOneWayResult4.jitter;
                lastmileProbeOneWayResult3.availableBandwidth = lastmileProbeOneWayResult4.availableBandwidth;
                iAgoraEventHandler.onLastmileProbeResult(lastmileProbeResult);
                return;
            case RtcEngineEvent.EvtType.EVT_UPLINK_NETWORK_INFO_UPDATE /* 13021 */:
                RtcEngineMessage.PUplinkNetworkInfoUpdated pUplinkNetworkInfoUpdated = new RtcEngineMessage.PUplinkNetworkInfoUpdated();
                pUplinkNetworkInfoUpdated.unmarshall(bArr);
                IRtcEngineEventHandler.UplinkNetworkInfo uplinkNetworkInfo = new IRtcEngineEventHandler.UplinkNetworkInfo();
                uplinkNetworkInfo.video_encoder_target_bitrate_bps = pUplinkNetworkInfoUpdated.videoEncoderTargetBitrateBps;
                iAgoraEventHandler.onUplinkNetworkInfoUpdated(uplinkNetworkInfo);
                return;
            case RtcEngineEvent.EvtType.EVT_DOWNLINK_NETWORK_INFO_UPDATE /* 13022 */:
                RtcEngineMessage.PDownlinkNetworkInfoUpdated pDownlinkNetworkInfoUpdated = new RtcEngineMessage.PDownlinkNetworkInfoUpdated();
                pDownlinkNetworkInfoUpdated.unmarshall(bArr);
                IRtcEngineEventHandler.DownlinkNetworkInfo downlinkNetworkInfo = new IRtcEngineEventHandler.DownlinkNetworkInfo();
                downlinkNetworkInfo.lastmile_buffer_delay_time_ms = pDownlinkNetworkInfoUpdated.lastmile_buffer_delay_time_ms;
                downlinkNetworkInfo.bandwidth_estimation_bps = pDownlinkNetworkInfoUpdated.bandwidth_estimation_bps;
                iAgoraEventHandler.onDownlinkNetworkInfoUpdated(downlinkNetworkInfo);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_STATE_CHANGED /* 13023 */:
                onUserStateChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_CONNECTION_BANNED /* 14019 */:
                iAgoraEventHandler.onConnectionBanned();
                return;
            case RtcEngineEvent.EvtType.EVT_CAMERA_FOCUS_AREA_CHANGED /* 14020 */:
                onCameraFocusAreaChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STATE_CHANGED /* 14021 */:
                onRemoteVideoStateChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_LOCAL_PUBLISH_FALLBACK_TO_AUDIO_ONLY /* 14022 */:
                RtcEngineMessage.PLocalFallbackStatus pLocalFallbackStatus = new RtcEngineMessage.PLocalFallbackStatus();
                pLocalFallbackStatus.unmarshall(bArr);
                iAgoraEventHandler.onLocalPublishFallbackToAudioOnly(pLocalFallbackStatus.state);
                return;
            case RtcEngineEvent.EvtType.EVT_REMOTE_SUBSCRIBE_FALLBACK_TO_AUDIO_ONLY /* 14023 */:
                RtcEngineMessage.PMediaResUserState pMediaResUserState5 = new RtcEngineMessage.PMediaResUserState();
                pMediaResUserState5.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onRemoteSubscribeFallbackToAudioOnly(pMediaResUserState5.uid, pMediaResUserState5.state);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_TRANSPORT_STAT /* 14024 */:
                RtcEngineMessage.PUserTransportStat pUserTransportStat = new RtcEngineMessage.PUserTransportStat();
                pUserTransportStat.unmarshall(bArr);
                IRtcEngineEventHandler iRtcEngineEventHandler2 = (IRtcEngineEventHandler) iAgoraEventHandler;
                if (pUserTransportStat.isAudio) {
                    iRtcEngineEventHandler2.onRemoteAudioTransportStats(pUserTransportStat.peer_uid, pUserTransportStat.delay, pUserTransportStat.lost, pUserTransportStat.rxKBitRate);
                    return;
                } else {
                    iRtcEngineEventHandler2.onRemoteVideoTransportStats(pUserTransportStat.peer_uid, pUserTransportStat.delay, pUserTransportStat.lost, pUserTransportStat.rxKBitRate);
                    return;
                }
            case 14028:
                RtcEngineMessage.PConnectionState pConnectionState = new RtcEngineMessage.PConnectionState();
                pConnectionState.unmarshall(bArr);
                iAgoraEventHandler.onConnectionStateChanged(pConnectionState.state, pConnectionState.reason);
                return;
            case RtcEngineEvent.EvtType.EVT_CAMERA_EXPOSURE_AREA_CHANGED /* 14029 */:
                onCameraExposureAreaChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STAT /* 14030 */:
                onRemoteAudioStat(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_NETWORK_TYPE_CHANGED /* 14031 */:
                RtcEngineMessage.PNetworkTypeChanged pNetworkTypeChanged = new RtcEngineMessage.PNetworkTypeChanged();
                pNetworkTypeChanged.unmarshall(bArr);
                iAgoraEventHandler.onNetworkTypeChanged(pNetworkTypeChanged.type);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_ROUTING_CHANGED /* 14032 */:
                RtcEngineMessage.PAudioRoutingChanged pAudioRoutingChanged = new RtcEngineMessage.PAudioRoutingChanged();
                pAudioRoutingChanged.unmarshall(bArr);
                iAgoraEventHandler.onAudioRouteChanged(pAudioRoutingChanged.routing);
                return;
            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_AUDIO_DECODED /* 14033 */:
                RtcEngineMessage.PFirstRemoteAudioDecoded pFirstRemoteAudioDecoded = new RtcEngineMessage.PFirstRemoteAudioDecoded();
                pFirstRemoteAudioDecoded.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onFirstRemoteAudioDecoded(pFirstRemoteAudioDecoded.uid, pFirstRemoteAudioDecoded.elapsed);
                return;
            case RtcEngineEvent.EvtType.EVT_LOCAL_USER_REGISTERED /* 14034 */:
                RtcEngineMessage.PUserInfoState pUserInfoState = new RtcEngineMessage.PUserInfoState();
                pUserInfoState.unmarshall(bArr);
                iAgoraEventHandler.onLocalUserRegistered(pUserInfoState.uid, pUserInfoState.userAccount);
                return;
            case RtcEngineEvent.EvtType.EVT_USER_INFO_UPDATED /* 14035 */:
                RtcEngineMessage.PUserInfoState pUserInfoState2 = new RtcEngineMessage.PUserInfoState();
                pUserInfoState2.unmarshall(bArr);
                iAgoraEventHandler.onUserInfoUpdated(pUserInfoState2.uid, new UserInfo(pUserInfoState2.uid, pUserInfoState2.userAccount));
                return;
            case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_STATE /* 14037 */:
                onChannelMediaRelayStateChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_EVENT /* 14038 */:
                onChannelMediaRelayEvent(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STATE_CHANGED /* 14040 */:
                onRemoteAudioStateChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_LOCAL_AUDIO_STAT /* 14041 */:
                onLocalAudioStat(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_LOCAL_AUDIO_STATE_CHANGED /* 14042 */:
                RtcEngineMessage.PLocalAudioState pLocalAudioState = new RtcEngineMessage.PLocalAudioState();
                pLocalAudioState.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onLocalAudioStateChanged(pLocalAudioState.state, pLocalAudioState.errorCode);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_MIXING_STATE_CHANGED /* 14043 */:
                RtcEngineMessage.PAudioMixingStateChanged pAudioMixingStateChanged = new RtcEngineMessage.PAudioMixingStateChanged();
                pAudioMixingStateChanged.unmarshall(bArr);
                iAgoraEventHandler.onAudioMixingStateChanged(pAudioMixingStateChanged.state, pAudioMixingStateChanged.reasonCode);
                if (pAudioMixingStateChanged.state != 713) {
                    return;
                }
                break;
            case RtcEngineEvent.EvtType.EVT_INTRA_REQUEST_RECEIVED /* 14044 */:
                iAgoraEventHandler.onIntraRequestReceived();
                return;
            case RtcEngineEvent.EvtType.EVT_ENCRYPTION_ERROR /* 14046 */:
                RtcEngineMessage.PEncryptionError pEncryptionError = new RtcEngineMessage.PEncryptionError();
                pEncryptionError.unmarshall(bArr);
                iAgoraEventHandler.onEncryptionError(pEncryptionError.errorType);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_SUBSCRIBE_STATE_CHANGED /* 14048 */:
                RtcEngineMessage.PSubscribeAudioStateChanged pSubscribeAudioStateChanged = new RtcEngineMessage.PSubscribeAudioStateChanged();
                pSubscribeAudioStateChanged.unmarshall(bArr);
                iAgoraEventHandler.onAudioSubscribeStateChanged(pSubscribeAudioStateChanged.channelId, pSubscribeAudioStateChanged.uid, pSubscribeAudioStateChanged.oldState, pSubscribeAudioStateChanged.newState, pSubscribeAudioStateChanged.elapseSinceLastState);
                return;
            case RtcEngineEvent.EvtType.EVT_VIDEO_SUBSCRIBE_STATE_CHANGED /* 14049 */:
                RtcEngineMessage.PSubscribeVideoStateChanged pSubscribeVideoStateChanged = new RtcEngineMessage.PSubscribeVideoStateChanged();
                pSubscribeVideoStateChanged.unmarshall(bArr);
                iAgoraEventHandler.onVideoSubscribeStateChanged(pSubscribeVideoStateChanged.channelId, pSubscribeVideoStateChanged.uid, pSubscribeVideoStateChanged.oldState, pSubscribeVideoStateChanged.newState, pSubscribeVideoStateChanged.elapseSinceLastState);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_PUBLISH_STATE_CHANGED /* 14050 */:
                RtcEngineMessage.PPublishAudioStateChanged pPublishAudioStateChanged = new RtcEngineMessage.PPublishAudioStateChanged();
                pPublishAudioStateChanged.unmarshall(bArr);
                iAgoraEventHandler.onAudioPublishStateChanged(pPublishAudioStateChanged.channelId, pPublishAudioStateChanged.oldState, pPublishAudioStateChanged.newState, pPublishAudioStateChanged.elapseSinceLastState);
                return;
            case RtcEngineEvent.EvtType.EVT_VIDEO_PUBLISH_STATE_CHANGED /* 14051 */:
                RtcEngineMessage.PPublishVideoStateChanged pPublishVideoStateChanged = new RtcEngineMessage.PPublishVideoStateChanged();
                pPublishVideoStateChanged.unmarshall(bArr);
                iAgoraEventHandler.onVideoPublishStateChanged(Constants.VideoSourceType.fromInt(pPublishVideoStateChanged.source), pPublishVideoStateChanged.channelId, pPublishVideoStateChanged.oldState, pPublishVideoStateChanged.newState, pPublishVideoStateChanged.elapseSinceLastState);
                return;
            case RtcEngineEvent.EvtType.EVT_PERMISSION_ERROR /* 14052 */:
                RtcEngineMessage.PPermissionError pPermissionError = new RtcEngineMessage.PPermissionError();
                pPermissionError.unmarshall(bArr);
                iAgoraEventHandler.onPermissionError(pPermissionError.permission);
                return;
            case RtcEngineEvent.EvtType.EVT_FACE_DETECT_VALUE /* 14053 */:
                onFacePositionChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_RHYTHM_PLAYFR_STATE_CHANGED /* 14054 */:
                onRhythmPlayerStateChanged(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_UPLOAD_LOG_RESULT /* 14055 */:
                RtcEngineMessage.PUploadLogResult pUploadLogResult = new RtcEngineMessage.PUploadLogResult();
                pUploadLogResult.unmarshall(bArr);
                iAgoraEventHandler.onUploadLogResult(pUploadLogResult.requestId, pUploadLogResult.success, pUploadLogResult.reason);
                return;
            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_AUDIO_FRAME /* 14058 */:
                RtcEngineMessage.PFirstRemoteAudioFrame pFirstRemoteAudioFrame = new RtcEngineMessage.PFirstRemoteAudioFrame();
                pFirstRemoteAudioFrame.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onFirstRemoteAudioFrame(pFirstRemoteAudioFrame.uid, pFirstRemoteAudioFrame.elapsed);
                return;
            case RtcEngineEvent.EvtType.EVT_PROXY_CONNECTED /* 14059 */:
                RtcEngineMessage.PProxyConnect pProxyConnect = new RtcEngineMessage.PProxyConnect();
                pProxyConnect.unmarshall(bArr);
                ((IRtcEngineEventHandler) iAgoraEventHandler).onProxyConnected(pProxyConnect.channel, pProxyConnect.uid, pProxyConnect.proxyType, pProxyConnect.localProxyIp, pProxyConnect.elapsed);
                return;
            case RtcEngineEvent.EvtType.EVT_WLACC_MESSAGE /* 14060 */:
                RtcEngineMessage.PMediaResWlAccMessage pMediaResWlAccMessage = new RtcEngineMessage.PMediaResWlAccMessage();
                pMediaResWlAccMessage.unmarshall(bArr);
                iAgoraEventHandler.onWlAccMessage(pMediaResWlAccMessage.reason, pMediaResWlAccMessage.action, pMediaResWlAccMessage.wlAccMsg);
                return;
            case RtcEngineEvent.EvtType.EVT_WLACC_STATS /* 14061 */:
                RtcEngineMessage.PMediaResWlAccStats pMediaResWlAccStats = new RtcEngineMessage.PMediaResWlAccStats();
                pMediaResWlAccStats.unmarshall(bArr);
                IRtcEngineEventHandler.WlAccStats wlAccStats = new IRtcEngineEventHandler.WlAccStats();
                wlAccStats.e2eDelayPercent = pMediaResWlAccStats.e2eDelayPercentCur;
                wlAccStats.frozenRatioPercent = pMediaResWlAccStats.frozenRatioPercentCur;
                wlAccStats.lossRatePercent = pMediaResWlAccStats.lossRatePercentCur;
                IRtcEngineEventHandler.WlAccStats wlAccStats2 = new IRtcEngineEventHandler.WlAccStats();
                wlAccStats2.e2eDelayPercent = pMediaResWlAccStats.e2eDelayPercentAve;
                wlAccStats2.frozenRatioPercent = pMediaResWlAccStats.frozenRatioPercentAve;
                wlAccStats2.lossRatePercent = pMediaResWlAccStats.lossRatePercentAve;
                iAgoraEventHandler.onWlAccStats(wlAccStats, wlAccStats2);
                return;
            case RtcEngineEvent.EvtType.EVT_SNAPSHOT_TAKEN_VALUE /* 14062 */:
                onSnapshotTaken(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_CONTENT_INSPECT_RESULT_VALUE /* 14063 */:
                onContentInspectResult(bArr, iAgoraEventHandler);
                return;
            case RtcEngineEvent.EvtType.EVT_AUDIO_MIXING_POSITION_CHANGED /* 14064 */:
                RtcEngineMessage.PAudioMixingPositionChanged pAudioMixingPositionChanged = new RtcEngineMessage.PAudioMixingPositionChanged();
                pAudioMixingPositionChanged.unmarshall(bArr);
                iAgoraEventHandler.onAudioMixingPositionChanged(pAudioMixingPositionChanged.position);
                return;
            case RtcEngineEvent.EvtType.EVT_LICENSE_VERIFY /* 14065 */:
                RtcEngineMessage.PLicenseVerifyFailed pLicenseVerifyFailed = new RtcEngineMessage.PLicenseVerifyFailed();
                pLicenseVerifyFailed.unmarshall(bArr);
                iAgoraEventHandler.onLicenseValidationFailure(pLicenseVerifyFailed.reason);
                return;
            case RtcEngineEvent.EvtType.EVT_VIDEO_RENDERING_TRACING_RESULT /* 14066 */:
                RtcEngineMessage.PVideoRenderingTracingInfo pVideoRenderingTracingInfo = new RtcEngineMessage.PVideoRenderingTracingInfo();
                pVideoRenderingTracingInfo.unmarshall(bArr);
                IRtcEngineEventHandler.VideoRenderingTracingInfo videoRenderingTracingInfo = new IRtcEngineEventHandler.VideoRenderingTracingInfo();
                Constants.MEDIA_TRACE_EVENT media_trace_eventFromInt = Constants.MEDIA_TRACE_EVENT.fromInt(pVideoRenderingTracingInfo.event);
                videoRenderingTracingInfo.elapsedTime = pVideoRenderingTracingInfo.elapsedTime;
                videoRenderingTracingInfo.start2JoinChannel = pVideoRenderingTracingInfo.start2JoinChannel;
                videoRenderingTracingInfo.join2JoinSuccess = pVideoRenderingTracingInfo.join2JoinSuccess;
                videoRenderingTracingInfo.joinSuccess2RemoteJoined = pVideoRenderingTracingInfo.joinSuccess2RemoteJoined;
                videoRenderingTracingInfo.remoteJoined2SetView = pVideoRenderingTracingInfo.remoteJoined2SetView;
                videoRenderingTracingInfo.remoteJoined2UnmuteVideo = pVideoRenderingTracingInfo.remoteJoined2UnmuteVideo;
                videoRenderingTracingInfo.remoteJoined2PacketReceived = pVideoRenderingTracingInfo.remoteJoined2PacketReceived;
                iAgoraEventHandler.onVideoRenderingTracingResult(pVideoRenderingTracingInfo.uid, media_trace_eventFromInt, videoRenderingTracingInfo);
                return;
            case RtcEngineEvent.EvtType.EVT_LOCAL_TRANSCODING /* 14067 */:
                RtcEngineMessage.PTranscodingVideoStream pTranscodingVideoStream = new RtcEngineMessage.PTranscodingVideoStream();
                pTranscodingVideoStream.unmarshall(bArr);
                LocalTranscoderConfiguration.TranscodingVideoStream transcodingVideoStream = new LocalTranscoderConfiguration.TranscodingVideoStream();
                transcodingVideoStream.sourceType = Constants.VideoSourceType.fromInt(pTranscodingVideoStream.sourceType);
                transcodingVideoStream.remoteUserUid = pTranscodingVideoStream.remoteUserUid;
                transcodingVideoStream.imageUrl = pTranscodingVideoStream.imageUrl;
                transcodingVideoStream.x = pTranscodingVideoStream.x;
                transcodingVideoStream.y = pTranscodingVideoStream.y;
                transcodingVideoStream.width = pTranscodingVideoStream.width;
                transcodingVideoStream.height = pTranscodingVideoStream.height;
                transcodingVideoStream.zOrder = pTranscodingVideoStream.zOrder;
                transcodingVideoStream.alpha = pTranscodingVideoStream.alpha;
                transcodingVideoStream.mirror = pTranscodingVideoStream.mirror;
                ((IRtcEngineEventHandler) iAgoraEventHandler).onLocalVideoTranscoderError(transcodingVideoStream, pTranscodingVideoStream.error);
                return;
            default:
                switch (i) {
                    case 1005:
                        iAgoraEventHandler.onCameraReady();
                        break;
                    case 1006:
                        iAgoraEventHandler.onMediaEngineStartCallSuccess();
                        break;
                    case 1007:
                        iAgoraEventHandler.onVideoStopped();
                        break;
                    default:
                        switch (i) {
                            case RtcEngineEvent.EvtType.EVT_STREAM_INJECTED_STATUS /* 1116 */:
                                RtcEngineMessage.PStreamInjectedStatus pStreamInjectedStatus = new RtcEngineMessage.PStreamInjectedStatus();
                                pStreamInjectedStatus.unmarshall(bArr);
                                ((IRtcEngineEventHandler) iAgoraEventHandler).onStreamInjectedStatus(pStreamInjectedStatus.url, pStreamInjectedStatus.userId, pStreamInjectedStatus.status);
                                break;
                            case RtcEngineEvent.EvtType.EVT_PRIVILEGE_WILL_EXPIRE /* 1117 */:
                                RtcEngineMessage.PPrivilegeWillExpire pPrivilegeWillExpire = new RtcEngineMessage.PPrivilegeWillExpire();
                                pPrivilegeWillExpire.unmarshall(bArr);
                                iAgoraEventHandler.onTokenPrivilegeWillExpire(pPrivilegeWillExpire.token);
                                break;
                            case RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STATE_CHANGED /* 1118 */:
                                RtcEngineMessage.PLocalVideoState pLocalVideoState = new RtcEngineMessage.PLocalVideoState();
                                pLocalVideoState.unmarshall(bArr);
                                ((IRtcEngineEventHandler) iAgoraEventHandler).onLocalVideoStateChanged(Constants.VideoSourceType.fromInt(pLocalVideoState.source), pLocalVideoState.state, pLocalVideoState.errorCode);
                                break;
                            default:
                                switch (i) {
                                    case RtcEngineEvent.EvtType.EVT_PUBLISH_STREAM_STATE /* 1120 */:
                                        RtcEngineMessage.PStreamPublishState pStreamPublishState = new RtcEngineMessage.PStreamPublishState();
                                        pStreamPublishState.unmarshall(bArr);
                                        iAgoraEventHandler.onRtmpStreamingStateChanged(pStreamPublishState.url, pStreamPublishState.state, pStreamPublishState.error);
                                        break;
                                    case RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGE_FAILED /* 1121 */:
                                        RtcEngineMessage.PClientRoleChangeFailed pClientRoleChangeFailed = new RtcEngineMessage.PClientRoleChangeFailed();
                                        pClientRoleChangeFailed.unmarshall(bArr);
                                        iAgoraEventHandler.onClientRoleChangeFailed(pClientRoleChangeFailed.reason, pClientRoleChangeFailed.currentRole);
                                        break;
                                    case RtcEngineEvent.EvtType.EVT_PUBLISH_STREAM_EVENT /* 1122 */:
                                        RtcEngineMessage.PStreamPublishEvent pStreamPublishEvent = new RtcEngineMessage.PStreamPublishEvent();
                                        pStreamPublishEvent.unmarshall(bArr);
                                        iAgoraEventHandler.onRtmpStreamingEvent(pStreamPublishEvent.url, pStreamPublishEvent.event);
                                        break;
                                    default:
                                        switch (i) {
                                            case RtcEngineEvent.EvtType.EVT_LEAVE_CHANNEL /* 13006 */:
                                                RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats2 = new RtcEngineMessage.PMediaResRtcStats();
                                                pMediaResRtcStats2.unmarshall(bArr);
                                                updateRtcStats(pMediaResRtcStats2);
                                                iAgoraEventHandler.onLeaveChannel(getRtcStats());
                                                break;
                                            case RtcEngineEvent.EvtType.EVT_NETWORK_QUALITY /* 13007 */:
                                                RtcEngineMessage.PMediaResNetworkQuality pMediaResNetworkQuality = new RtcEngineMessage.PMediaResNetworkQuality();
                                                pMediaResNetworkQuality.unmarshall(bArr);
                                                ((IRtcEngineEventHandler) iAgoraEventHandler).onNetworkQuality(pMediaResNetworkQuality.uid, pMediaResNetworkQuality.txQuality, pMediaResNetworkQuality.rxQuality);
                                                break;
                                            case RtcEngineEvent.EvtType.EVT_USER_OFFLINE /* 13008 */:
                                                RtcEngineMessage.PMediaResUserOfflineEvent pMediaResUserOfflineEvent = new RtcEngineMessage.PMediaResUserOfflineEvent();
                                                pMediaResUserOfflineEvent.unmarshall(bArr);
                                                ((IRtcEngineEventHandler) iAgoraEventHandler).onUserOffline(pMediaResUserOfflineEvent.uid, pMediaResUserOfflineEvent.reason);
                                                break;
                                            default:
                                                switch (i) {
                                                    case RtcEngineEvent.EvtType.EVT_AUDIO_VOLUME_INDICATION /* 14001 */:
                                                        onSpeakersReport(bArr, iAgoraEventHandler);
                                                        break;
                                                    case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_VIDEO_FRAME /* 14002 */:
                                                        onFirstRemoteVideoFrame(bArr, iAgoraEventHandler);
                                                        break;
                                                    case RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STAT /* 14003 */:
                                                        onLocalVideoStat(bArr, iAgoraEventHandler);
                                                        break;
                                                    case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STAT /* 14004 */:
                                                        onRemoteVideoStat(bArr, iAgoraEventHandler);
                                                        break;
                                                    case RtcEngineEvent.EvtType.EVT_FIRST_LOCAL_VIDEO_FRAME /* 14005 */:
                                                        onFirstLocalVideoFrame(bArr, iAgoraEventHandler);
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_VIDEO_DECODED /* 14007 */:
                                                                onFirstRemoteVideoDecoded(bArr, iAgoraEventHandler);
                                                                break;
                                                            case RtcEngineEvent.EvtType.EVT_CONNECTION_LOST /* 14008 */:
                                                                iAgoraEventHandler.onConnectionLost();
                                                                break;
                                                            case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE /* 14009 */:
                                                                onStreamMessage(bArr, iAgoraEventHandler);
                                                                break;
                                                            case RtcEngineEvent.EvtType.EVT_CONNECTION_INTERRUPTED /* 14010 */:
                                                                iAgoraEventHandler.onConnectionInterrupted();
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE_ERROR /* 14012 */:
                                                                        onStreamMessageError(bArr, iAgoraEventHandler);
                                                                        break;
                                                                    case RtcEngineEvent.EvtType.EVT_VIDEO_SIZE_CHANGED /* 14013 */:
                                                                        onVideoSizeChanged(bArr, iAgoraEventHandler);
                                                                        break;
                                                                    case RtcEngineEvent.EvtType.EVT_FIRST_LOCAL_AUDIO_FRAME_PUBLISHED /* 14014 */:
                                                                        onFirstLocalAudioFramePublished(bArr, iAgoraEventHandler);
                                                                        break;
                                                                    case RtcEngineEvent.EvtType.EVT_FIRST_LOCAL_VIDEO_FRAME_PUBLISHED /* 14015 */:
                                                                        onFirstLocalVideoFramePublished(bArr, iAgoraEventHandler);
                                                                        break;
                                                                    case RtcEngineEvent.EvtType.EVT_ACTIVE_SPEAKER /* 14016 */:
                                                                        RtcEngineMessage.PActiveSpeaker pActiveSpeaker = new RtcEngineMessage.PActiveSpeaker();
                                                                        pActiveSpeaker.unmarshall(bArr);
                                                                        ((IRtcEngineEventHandler) iAgoraEventHandler).onActiveSpeaker(pActiveSpeaker.uid);
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
                return;
        }
        iAgoraEventHandler.onAudioMixingFinished();
    }

    public synchronized int initMediaPlayerCacheManager() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeInitMediaPlayerCacheManager(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraAutoFocusFaceModeSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraAutoFocusFaceModeSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraExposurePositionSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraExposurePositionSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraFaceDetectSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraFaceDetectSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraFocusSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraFocusSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraTorchSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraTorchSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isCameraZoomSupported() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeGetCameraZoomSupported(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isSpeakerphoneEnabled() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return false;
        }
        return nativeIsSpeakerphoneEnabled(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean isTextureEncodeSupported() {
        return DeviceUtils.getRecommendedEncoderType() == 0;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int joinChannel(String str, String str2, int i, ChannelMediaOptions channelMediaOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeJoinChannel2(j, str, str2, i, channelMediaOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int joinChannel(String str, String str2, String str3, int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        PublisherConfiguration publisherConfiguration = this.mConfiguration;
        if (publisherConfiguration != null && publisherConfiguration.validate()) {
            if (str3 != null) {
                Logging.w(TAG, "override optionalInfo by publisherConfiguration");
            }
            str3 = this.mConfiguration.toJsonString();
        }
        return nativeJoinChannel(this.mNativeHandle, str, str2, str3, i);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int joinChannelEx(String str, RtcConnection rtcConnection, ChannelMediaOptions channelMediaOptions, IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        String channelId = getChannelId(rtcConnection);
        int userId = getUserId(rtcConnection);
        int iNativeJoinChannelEx = nativeJoinChannelEx(this.mNativeHandle, str, channelId, userId, channelMediaOptions);
        if (iNativeJoinChannelEx == 0) {
            this.mRtcExHandlers.put(Pair.create(channelId, Integer.valueOf(userId)), iRtcEngineEventHandler);
        }
        return iNativeJoinChannelEx;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int joinChannelWithUserAccount(String str, String str2, String str3) {
        return joinChannelWithUserAccount(str, str2, str3, null);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeJoinChannelWithUserAccount(j, str, str2, str3, channelMediaOptions);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int joinChannelWithUserAccountEx(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions, IRtcEngineEventHandler iRtcEngineEventHandler) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        int iNativeJoinChannelWithUserAccountEx = nativeJoinChannelWithUserAccountEx(j, str, str2, str3, channelMediaOptions);
        if (iNativeJoinChannelWithUserAccountEx == 0) {
            this.mRtcExHandlers.put(Pair.create(str2, str3), iRtcEngineEventHandler);
        }
        return iNativeJoinChannelWithUserAccountEx;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int leaveChannel() {
        return leaveChannel(new LeaveChannelOptions());
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int leaveChannel(LeaveChannelOptions leaveChannelOptions) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        doStopMonitorSystemEvent();
        return nativeLeaveChannel(this.mNativeHandle, leaveChannelOptions);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int leaveChannelEx(RtcConnection rtcConnection) {
        return leaveChannelEx(rtcConnection, new LeaveChannelOptions());
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int leaveChannelEx(RtcConnection rtcConnection, LeaveChannelOptions leaveChannelOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeLeaveChannelEx(j, getChannelId(rtcConnection), getUserId(rtcConnection), leaveChannelOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int loadExtensionProvider(String str) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            ExtensionLoadState extensionLoadState = mLoadedExtensions.get(str);
            ExtensionLoadState extensionLoadState2 = ExtensionLoadState.LOADED;
            if (extensionLoadState != extensionLoadState2) {
                int iNativeLoadExtensionProvider = nativeLoadExtensionProvider(this.mNativeHandle, str);
                ConcurrentHashMap<String, ExtensionLoadState> concurrentHashMap = mLoadedExtensions;
                if (iNativeLoadExtensionProvider != 0) {
                    extensionLoadState2 = ExtensionLoadState.LOAD_FAIL;
                }
                concurrentHashMap.put(str, extensionLoadState2);
                return iNativeLoadExtensionProvider;
            }
            i = 0;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized String makeQualityReportUrl(String str, String str2, String str3, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeMakeQualityReportUrl(j, str, str2, str3, i);
    }

    public synchronized int mediaPlayerAdjustPlayoutVolume(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerAdjustPlayoutVolume)");
            return -7;
        }
        return nativeMediaPlayerAdjustPlayoutVolume(j, i, i2);
    }

    public synchronized int mediaPlayerAdjustPublishSignalVolume(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerAdjustPublishSignalVolume)");
            return -7;
        }
        return nativeMediaPlayerAdjustPublishSignalVolume(j, i, i2);
    }

    public synchronized int mediaPlayerCacheEnableAutoRemoveCache(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerEnableAutoRemoveCache(j, z);
    }

    public synchronized String mediaPlayerCacheGetCacheDir() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        return nativeMediaPlayerGetCacheDir(j);
    }

    public synchronized int mediaPlayerCacheGetCacheFileCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerGetCacheFileCount(j);
    }

    public synchronized int mediaPlayerCacheGetMaxCacheFileCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerGetMaxCacheFileCount(j);
    }

    public synchronized long mediaPlayerCacheGetMaxCacheFileSize() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7L;
        }
        return nativeMediaPlayerGetMaxCacheFileSize(j);
    }

    public synchronized int mediaPlayerCacheRemoveAllCaches() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerRemoveAllCaches(j);
    }

    public synchronized int mediaPlayerCacheRemoveCacheByUri(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerRemoveCacheByUri(j, str);
    }

    public synchronized int mediaPlayerCacheRemoveOldCache() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerRemoveOldCache(j);
    }

    public synchronized int mediaPlayerCacheSetCacheDir(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerSetCacheDir(j, str);
    }

    public synchronized int mediaPlayerCacheSetMaxCacheFileCount(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerSetMaxCacheFileCount(j, i);
    }

    public synchronized int mediaPlayerCacheSetMaxCacheFileSize(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeMediaPlayerSetMaxCacheFileSize(j2, j);
    }

    public synchronized int mediaPlayerChangePlaybackSpeed(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerChangePlaybackSpeed)");
            return -7;
        }
        return nativeMediaPlayerChangePlaybackSpeed(j, i, i2);
    }

    public synchronized int mediaPlayerDestroy(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSourceDestroy)");
            return -7;
        }
        return nativeMediaPlayerDestroy(j, i);
    }

    public synchronized int mediaPlayerEnableAutoSwitchAgoraCDN(int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerEnableAutoSwitchAgoraCDN(j, i, z);
    }

    public synchronized int mediaPlayerGetAgoraCDNLineCount(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerGetAgoraCDNLineCount(j, i);
    }

    public synchronized int mediaPlayerGetCurrentAgoraCDNIndex(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerGetCurrentAgoraCDNIndex(j, i);
    }

    public synchronized long mediaPlayerGetDuration(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetDuration)");
            return -7L;
        }
        return nativeMediaPlayerGetDuration(j, i);
    }

    public synchronized boolean mediaPlayerGetMute(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerIsMuted)");
            return false;
        }
        return nativeMediaPlayerGetMute(j, i);
    }

    public synchronized long mediaPlayerGetPlayPosition(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetPlayPosition)");
            return -7L;
        }
        return nativeMediaPlayerGetPlayPosition(j, i);
    }

    public synchronized String mediaPlayerGetPlaySrc(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetPlaySrc)");
            return null;
        }
        return nativeMediaPlayerGetPlaySrc(j, i);
    }

    public synchronized int mediaPlayerGetPlayoutVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetPlayoutVolume)");
            return -7;
        }
        return nativeMediaPlayerGetPlayoutVolume(j, i);
    }

    public synchronized int mediaPlayerGetPublishSignalVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetPublishSignalVolume)");
            return -7;
        }
        return nativeMediaPlayerGetPublishSignalVolume(j, i);
    }

    public synchronized int mediaPlayerGetState(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetState)");
            return -7;
        }
        return nativeMediaPlayerGetState(j, i);
    }

    public synchronized int mediaPlayerGetStreamCount(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetStreamCount)");
            return -7;
        }
        return nativeMediaPlayerGetStreamCount(j, i);
    }

    public synchronized MediaStreamInfo mediaPlayerGetStreamInfo(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerGetStreamInfo)");
            return null;
        }
        return nativeMediaPlayerGetStreamInfo(j, i, i2);
    }

    public synchronized int mediaPlayerMute(int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerMute)");
            return -7;
        }
        return nativeMediaPlayerMute(j, i, z);
    }

    public synchronized int mediaPlayerOpen(int i, String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerOpen)");
            return -7;
        }
        return nativeMediaPlayerOpen(j2, i, str, j);
    }

    public synchronized int mediaPlayerOpenWithAgoraCDNSrc(int i, String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeMediaPlayerOpenWithAgoraCDNSrc(j2, i, str, j);
    }

    @Deprecated
    public synchronized int mediaPlayerOpenWithCustomSource(int i, long j, IMediaPlayerCustomDataProvider iMediaPlayerCustomDataProvider) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerOpenWithCustomSource)");
            return -7;
        }
        return nativeMediaPlayerOpenWithCustormProviderData(j2, i, j, iMediaPlayerCustomDataProvider);
    }

    public synchronized int mediaPlayerOpenWithMediaSource(int i, MediaPlayerSource mediaPlayerSource) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerOpenWithSource(j, i, mediaPlayerSource);
    }

    public synchronized int mediaPlayerPause(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerPause)");
            return -7;
        }
        return nativeMediaPlayerPause(j, i);
    }

    public synchronized int mediaPlayerPlay(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerPlay)");
            return -7;
        }
        return nativeMediaPlayerPlay(j, i);
    }

    public synchronized int mediaPlayerPlayPreloadedSrc(int i, String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerPlayPreloadedSrc(j, i, str);
    }

    public synchronized int mediaPlayerPreloadSrc(int i, String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeMediaPlayerPreloadSrc(j2, i, str, j);
    }

    public synchronized int mediaPlayerRegisterAudioFrameObserver(int i, IMediaPlayerAudioFrameObserver iMediaPlayerAudioFrameObserver, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerRegisterAudioFrameObserver)");
            return -7;
        }
        return nativeMediaPlayerRegisterAudioFrameObserver(j, i, iMediaPlayerAudioFrameObserver, i2);
    }

    public synchronized int mediaPlayerRegisterPlayerObserver(int i, IMediaPlayerObserver iMediaPlayerObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerRegisterPlayerObserver)");
            return -7;
        }
        return nativeMediaPlayerRegisterPlayerObserver(j, i, iMediaPlayerObserver);
    }

    public synchronized int mediaPlayerRegisterVideoFrameObserver(int i, IMediaPlayerVideoFrameObserver iMediaPlayerVideoFrameObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerRegisterVideoFrameObserver)");
            return -7;
        }
        return nativeMediaPlayerRegisterVideoFrameObserver(j, i, iMediaPlayerVideoFrameObserver);
    }

    public synchronized int mediaPlayerRenewAgoraCDNSrcToken(int i, String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeMediaPlayerRenewAgoraCDNSrcToken(j2, i, str, j);
    }

    public synchronized int mediaPlayerResume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerResume)");
            return -7;
        }
        return nativeMediaPlayerResume(j, i);
    }

    public synchronized int mediaPlayerSeek(int i, long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSeek)");
            return -7;
        }
        return nativeMediaPlayerSeek(j2, i, j);
    }

    public synchronized int mediaPlayerSelectAudioTrack(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSelectAudioTrack)");
            return -7;
        }
        return nativeMediaPlayerSelectAudioTrack(j, i, i2);
    }

    public synchronized int mediaPlayerSelectInternalSubtitle(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSelectInternalSubtitle)");
            return -7;
        }
        return nativeMediaPlayerSelectInternalSubtitle(j, i, i2);
    }

    public synchronized int mediaPlayerSetAudioDualMonoMode(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetAudioDualMonoMode)");
            return -7;
        }
        return nativeMediaPlayerSetAudioDualMonoMode(j, i, i2);
    }

    public synchronized int mediaPlayerSetAudioPitch(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetAudioPitch)");
            return -7;
        }
        return nativeMediaPlayerSetAudioPitch(j, i, i2);
    }

    public synchronized int mediaPlayerSetExternalSubtitle(int i, String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetExternalSubtitle)");
            return -7;
        }
        return nativeMediaPlayerSetExternalSubtitle(j, i, str);
    }

    public synchronized int mediaPlayerSetLoopCount(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetLoopCount)");
            return -7;
        }
        return nativeMediaPlayerSetLoopCount(j, i, i2);
    }

    public synchronized int mediaPlayerSetPlayerOption(int i, String str, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetPlayerOption)");
            return -7;
        }
        return nativeMediaPlayerSetPlayerOption(j, i, str, i2);
    }

    public synchronized int mediaPlayerSetPlayerOptionString(int i, String str, String str2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetPlayerOption)");
            return -7;
        }
        return nativeMediaPlayerSetPlayerOptionString(j, i, str, str2);
    }

    public synchronized int mediaPlayerSetRenderMode(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetRenderMode)");
            return -7;
        }
        return nativeMediaPlayerSetRenderMode(j, i, i2);
    }

    public synchronized int mediaPlayerSetSpatialAudioParams(int i, SpatialAudioParams spatialAudioParams) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetSpatialAudioParams)");
            return -7;
        }
        return nativeMediaPlayerSetSpatialAudioParams(j, i, spatialAudioParams);
    }

    public synchronized int mediaPlayerSetView(int i, View view) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerSetView)");
            return -7;
        }
        return nativeMediaPlayerSetView(j, i, view);
    }

    public synchronized int mediaPlayerStop(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerStop)");
            return -7;
        }
        return nativeMediaPlayerStop(j, i);
    }

    public synchronized int mediaPlayerSwitchAgoraCDNLineByIndex(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerSwitchAgoraCDNLineByIndex(j, i, i2);
    }

    public synchronized int mediaPlayerSwitchAgoraCDNSrc(int i, String str, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerSwitchAgoraCDNSrc(j, i, str, z);
    }

    public synchronized int mediaPlayerSwitchSrc(int i, String str, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerSwitchSrc(j, i, str, z);
    }

    public synchronized int mediaPlayerTakeScreenshot(int i, String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerTakeScreenshot)");
            return -7;
        }
        return nativeMediaPlayerTakeScreenshot(j, i, str);
    }

    public synchronized int mediaPlayerUnRegisterPlayerObserver(int i, IMediaPlayerObserver iMediaPlayerObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerUnRegisterPlayerObserver)");
            return -7;
        }
        return nativeMediaPlayerUnRegisterPlayerObserver(j, i, iMediaPlayerObserver);
    }

    public synchronized int mediaPlayerUnloadSrc(int i, String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMediaPlayerUnloadSrc(j, i, str);
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int monitorAudioRouteChange(boolean z) {
        Logging.i("API call monitorAudioRouteChange:" + z);
        return 0;
    }

    @Override // io.agora.rtc2.RtcEngine
    @TargetApi(11)
    @Deprecated
    public synchronized void monitorBluetoothHeadsetEvent(boolean z) {
        Logging.i(TAG, "enter monitorBluetoothHeadsetEvent:" + z);
    }

    @Override // io.agora.rtc2.RtcEngine
    @Deprecated
    public synchronized void monitorHeadsetEvent(boolean z) {
        Logging.i(TAG, "enter monitorHeadsetEvent:" + z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteAllRemoteAudioStreams(boolean z) {
        return muteAllRemoteAudioStreamsEx(z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteAllRemoteAudioStreamsEx(boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteAllRemoteAudioStreams(j, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteAllRemoteVideoStreams(boolean z) {
        return muteAllRemoteVideoStreamsEx(z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteAllRemoteVideoStreamsEx(boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteAllRemoteVideoStreams(j, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteLocalAudioStream(boolean z) {
        return muteLocalAudioStreamEx(z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteLocalAudioStreamEx(boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteLocalAudioStream(j, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteLocalVideoStream(boolean z) {
        return muteLocalVideoStreamEx(z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteLocalVideoStreamEx(boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteLocalVideoStream(j, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteRecordingSignal(boolean z) {
        return muteRecordingSignalEx(z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteRecordingSignalEx(boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteRecordingSignal(j, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteRemoteAudioStream(int i, boolean z) {
        return muteRemoteAudioStreamEx(i, z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteRemoteAudioStreamEx(int i, boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteRemoteAudioStream(j, i, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int muteRemoteVideoStream(int i, boolean z) {
        return muteRemoteVideoStreamEx(i, z, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int muteRemoteVideoStreamEx(int i, boolean z, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeMuteRemoteVideoStream(j, i, z, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    public native int nativePushExternalVideoFrame(long j, VideoFrame videoFrame, int i);

    @CalledByNative
    public void onEvent(int i, byte[] bArr) {
        Iterator<IAgoraEventHandler> it = this.mRtcHandlers.keySet().iterator();
        while (it.hasNext()) {
            IAgoraEventHandler next = it.next();
            if (next == null) {
                it.remove();
            } else {
                handleEvent(i, bArr, next);
            }
        }
    }

    @CalledByNative
    public void onEventEx(String str, int i, String str2, int i2, byte[] bArr) {
        IAgoraEventHandler iAgoraEventHandler = !TextUtils.isEmpty(str2) ? this.mRtcExHandlers.get(Pair.create(str, str2)) : null;
        if (iAgoraEventHandler == null) {
            iAgoraEventHandler = this.mRtcExHandlers.get(Pair.create(str, Integer.valueOf(i)));
        }
        if (iAgoraEventHandler != null) {
            handleEvent(i2, bArr, iAgoraEventHandler);
            return;
        }
        String str3 = "onEventEx: can't find exhandler for channelId=" + str + " uid=" + i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pauseAllChannelMediaRelay() {
        return pauseAllChannelMediaRelayEx(null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int pauseAllChannelMediaRelayEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePauseAllChannelMediaRelay(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int pauseAllEffects() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePauseAllEffects(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pauseAudio() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePauseAudio(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pauseAudioMixing() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePauseAudioMixing(j);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int pauseEffect(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePauseEffect(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int playAllEffects(int i, double d, double d2, double d3, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePlayAllEffects(j, i, d, d2, d3, z);
    }

    @Override // io.agora.rtc2.IAudioEffectManager
    @Deprecated
    public synchronized int playEffect(int i, String str, int i2, double d, double d2, double d3) {
        return playEffect(i, str, i2, d, d2, d3, false);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z) {
        return playEffect(i, str, i2, d, d2, d3, z, 0);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativePlayEffectWithFilePath(j, i, str, i2, d, d2, d3, z, i3);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int preloadEffect(int i, String str) {
        return preloadEffect(i, str, 0);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int preloadEffect(int i, String str, int i2) {
        int i3;
        if (this.mNativeHandle == 0) {
            i3 = -7;
        } else {
            if (!TextUtils.isEmpty(str)) {
                return nativePreloadEffect(this.mNativeHandle, i, str, i2);
            }
            i3 = -2;
        }
        return i3;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pullPlaybackAudioFrame(ByteBuffer byteBuffer, int i) {
        int i2;
        if (this.mNativeHandle == 0) {
            i2 = -7;
        } else {
            if (byteBuffer != null && byteBuffer.capacity() == i) {
                if (!byteBuffer.isDirect()) {
                    throw new IllegalArgumentException("data must be direct buffer!");
                }
                return nativePullAudioFrame(this.mNativeHandle, byteBuffer, i, this.mExSinkAudioSampleRate, this.mExSinkAudioChannels);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pullPlaybackAudioFrame(byte[] bArr, int i) {
        int i2;
        if (this.mNativeHandle == 0) {
            i2 = -7;
        } else {
            if (bArr != null && bArr.length == i) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                int iPullPlaybackAudioFrame = pullPlaybackAudioFrame(byteBufferAllocateDirect, i);
                if (iPullPlaybackAudioFrame == 0) {
                    byteBufferAllocateDirect.get(bArr, 0, i);
                }
                return iPullPlaybackAudioFrame;
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pushExternalAudioFrame(ByteBuffer byteBuffer, long j, int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("data must be direct buffer!");
        }
        return nativePushExternalAudioFrameRawData(this.mNativeHandle, byteBuffer, j, this.mExSourceAudioSampleRate, 2, this.mExSourceAudioChannels, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pushExternalAudioFrame(ByteBuffer byteBuffer, long j, int i, int i2, Constants.BytesPerSample bytesPerSample, int i3) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("data must be direct buffer!");
        }
        return nativePushExternalAudioFrameRawData(this.mNativeHandle, byteBuffer, j, i, Constants.BytesPerSample.getValue(bytesPerSample), i2, i3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pushExternalAudioFrame(byte[] bArr, long j) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (bArr != null) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocateDirect.put(bArr, 0, bArr.length);
                byteBufferAllocateDirect.flip();
                return pushExternalAudioFrame(byteBufferAllocateDirect, j, 0);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, Constants.BytesPerSample bytesPerSample, int i3) {
        int i4;
        if (this.mNativeHandle == 0) {
            i4 = -7;
        } else {
            if (bArr != null) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocateDirect.put(bArr, 0, bArr.length);
                byteBufferAllocateDirect.flip();
                return nativePushExternalAudioFrameRawData(this.mNativeHandle, byteBufferAllocateDirect, j, i, Constants.BytesPerSample.getValue(bytesPerSample), i2, i3);
            }
            i4 = -2;
        }
        return i4;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int pushExternalEncodedVideoFrame(ByteBuffer byteBuffer, EncodedVideoFrameInfo encodedVideoFrameInfo) {
        return pushExternalEncodedVideoFrameEx(byteBuffer, encodedVideoFrameInfo, 0);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int pushExternalEncodedVideoFrameEx(ByteBuffer byteBuffer, EncodedVideoFrameInfo encodedVideoFrameInfo, int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("data must be direct buffer!");
        }
        return nativePushExternalEncodedVideoFrame(this.mNativeHandle, byteBuffer, encodedVideoFrameInfo, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean pushExternalVideoFrame(VideoFrame videoFrame) {
        int iPushExternalVideoFrameEx = pushExternalVideoFrameEx(videoFrame, 0);
        if (iPushExternalVideoFrameEx == 0) {
            return true;
        }
        Logging.e(TAG, "Failed to pushExternalVideoFrame, " + iPushExternalVideoFrameEx);
        return false;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame) {
        return pushExternalVideoFrameEx(agoraVideoFrame, 0) == 0;
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int pushExternalVideoFrameEx(VideoFrame videoFrame, int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (videoFrame != null) {
                return nativePushExternalVideoFrame(j, videoFrame, i);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int pushExternalVideoFrameEx(AgoraVideoFrame agoraVideoFrame, int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        int iValidatePushExternalVideoFrame = validatePushExternalVideoFrame(agoraVideoFrame);
        if (iValidatePushExternalVideoFrame == 0) {
            return nativePushExternalAgoraVideoFrame(this.mNativeHandle, agoraVideoFrame.format, agoraVideoFrame.buf, agoraVideoFrame.stride, agoraVideoFrame.height, agoraVideoFrame.cropLeft, agoraVideoFrame.cropTop, agoraVideoFrame.cropRight, agoraVideoFrame.cropBottom, agoraVideoFrame.rotation, agoraVideoFrame.timeStamp, agoraVideoFrame.eglContext10, agoraVideoFrame.eglContext14, agoraVideoFrame.textureID, agoraVideoFrame.transform, i);
        }
        int i2 = this.mPushVideoFrameInvalidCnt + 1;
        this.mPushVideoFrameInvalidCnt = i2;
        if (i2 % CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA == 1) {
            Logging.e(TAG, "failed to push video frame: " + agoraVideoFrame);
        }
        return iValidatePushExternalVideoFrame;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized CodecCapInfo[] queryCodecCapability() {
        return nativeQueryCodecCapability(this.mNativeHandle);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int queryScreenCaptureCapability() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeQueryScreenCaptureCapability(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int rate(String str, int i, String str2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRate(j, str, i, str2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerAudioEncodedFrameObserver(AudioEncodedFrameObserverConfig audioEncodedFrameObserverConfig, IAudioEncodedFrameObserver iAudioEncodedFrameObserver) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (audioEncodedFrameObserverConfig == null) {
            audioEncodedFrameObserverConfig = new AudioEncodedFrameObserverConfig();
        }
        return nativeregisterAudioEncodedFrameObserver(this.mNativeHandle, iAudioEncodedFrameObserver, audioEncodedFrameObserverConfig.postionType, audioEncodedFrameObserverConfig.encodingType);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterAudioFrameObserver(j, iAudioFrameObserver);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerAudioSpectrumObserver(IAudioSpectrumObserver iAudioSpectrumObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterAudioSpectrumObserver(j, iAudioSpectrumObserver);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerExtension(String str, String str2, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterExtension(j, str, str2, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerLocalUserAccount(String str, String str2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterLocalUserAccount(j, str, str2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (iMetadataObserver != null) {
                return nativeRegisterMediaMetadataObserver(j, iMetadataObserver, i);
            }
            Logging.e(TAG, "Failed to registerMediaMetadataObserver, observer null");
            i2 = -2;
        }
        return i2;
    }

    public synchronized int registerMediaPlayerAudioSpectrumObserver(int i, IAudioSpectrumObserver iAudioSpectrumObserver, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerRegisterPlayerObserver)");
            return -7;
        }
        return nativeRegisterMediaPlayerAudioSpectrumObserver(j, i, iAudioSpectrumObserver, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerVideoEncodedFrameObserver(IVideoEncodedFrameObserver iVideoEncodedFrameObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterVideoEncodedFrameObserver(j, iVideoEncodedFrameObserver);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int registerVideoFrameObserver(IVideoFrameObserver iVideoFrameObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRegisterVideoFrameObserver(j, iVideoFrameObserver);
    }

    public synchronized void reinitialize(RtcEngineConfig rtcEngineConfig) {
        addHandler(rtcEngineConfig.mEventHandler);
    }

    public int releaseRecorder(String str, int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeReleaseRecorder(j, i, str, z);
    }

    public synchronized void removeHandler(IAgoraEventHandler iAgoraEventHandler) {
        this.mRtcHandlers.remove(iAgoraEventHandler);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int renewToken(String str) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (str != null) {
                return nativeRenewToken(j, str);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int resumeAllChannelMediaRelay() {
        return resumeAllChannelMediaRelayEx(null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int resumeAllChannelMediaRelayEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeResumeAllChannelMediaRelay(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int resumeAllEffects() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeResumeAllEffects(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int resumeAudio() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeResumeAudio(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int resumeAudioMixing() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeResumeAudioMixing(j);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int resumeEffect(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeResumeEffect(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int selectAudioTrack(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSelectAudioTrack(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int sendCustomReportMessage(String str, String str2, String str3, String str4, int i) {
        return sendCustomReportMessageEx(str, str2, str3, str4, i, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int sendCustomReportMessageEx(String str, String str2, String str3, String str4, int i, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSendCustomReportMessage(j, str, str2, str3, str4, i, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int sendStreamMessage(int i, byte[] bArr) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return sendStreamMessageEx(i, bArr, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int sendStreamMessageEx(int i, byte[] bArr, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSendStreamMessage(j, i, bArr, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAINSMode(boolean z, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativesetAINSMode(j, z, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAVSyncSource(String str, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAVSyncSource(j, str, i);
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int setApiCallMode(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetApiCallMode(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioEffectParameters(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioEffectParameters(j, i, i2, i3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioEffectPreset(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioEffectPreset(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioMixingDualMonoMode(Constants.AudioMixingDualMonoMode audioMixingDualMonoMode) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioMixingDualMonoMode(j, Constants.AudioMixingDualMonoMode.getValue(audioMixingDualMonoMode));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioMixingPitch(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioMixingPitch(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioMixingPosition(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioMixingPosition(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioOptionParams(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioOptionParams(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioProfile(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioProfile(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioProfile(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioProfileScenario(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setAudioScenario(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetAudioScenario(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions) {
        return setBeautyEffectOptions(z, beautyOptions, Constants.MediaSourceType.PRIMARY_CAMERA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetBeautyEffectOptions(j, z, beautyOptions.lighteningContrastLevel, beautyOptions.lighteningLevel, beautyOptions.smoothnessLevel, beautyOptions.rednessLevel, beautyOptions.sharpnessLevel, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraAutoFocusFaceModeEnabled(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetCameraAutoFocusFaceModeEnabled(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (cameraCapturerConfiguration != null) {
                return nativeSetCameraCapturerConfiguration(j, cameraCapturerConfiguration);
            }
            Logging.e(TAG, "CameraCapturerConfiguration is null");
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraExposurePosition(float f, float f2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetCameraExposurePosition(j, f, f2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraFocusPositionInPreview(float f, float f2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetCameraFocusPositionInPreview(j, f, f2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraTorchOn(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetCameraTorchOn(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCameraZoomFactor(float f) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetCameraZoomFactor(j, f);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setChannelProfile(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetChannelProfile(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setClientRole(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetClientRole(j, i, null);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setClientRole(int i, ClientRoleOptions clientRoleOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetClientRole(j, i, clientRoleOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setCloudProxy(int i) {
        return nativeSetCloudProxy(this.mNativeHandle, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setColorEnhanceOptions(boolean z, ColorEnhanceOptions colorEnhanceOptions) {
        return setColorEnhanceOptions(z, colorEnhanceOptions, Constants.MediaSourceType.PRIMARY_CAMERA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setColorEnhanceOptions(boolean z, ColorEnhanceOptions colorEnhanceOptions, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetColorEnhanceOptions(j, z, colorEnhanceOptions.strengthLevel, colorEnhanceOptions.skinProtectLevel, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetDefaultAudioRoutetoSpeakerphone(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        setParameter("che.audio.set_default_mute_peers", z);
        return nativeSetDefaultMuteAllRemoteAudioStreams(this.mNativeHandle, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        setParameter("rtc.video.set_default_mute_peers", z);
        return nativeSetDefaultMuteAllRemoteVideoStreams(this.mNativeHandle, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDirectCdnStreamingAudioConfiguration(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetDirectCdnStreamingAudioConfiguration(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDirectCdnStreamingVideoConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
        return nativeSetDirectCdnStreamingVideoConfiguration(j, videoDimensions.width, videoDimensions.height, videoEncoderConfiguration.frameRate, videoEncoderConfiguration.bitrate, videoEncoderConfiguration.minBitrate, videoEncoderConfiguration.orientationMode.getValue(), videoEncoderConfiguration.mirrorMode.getValue(), videoEncoderConfiguration.degradationPrefer.getValue());
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDualStreamMode(Constants.SimulcastStreamMode simulcastStreamMode) {
        return setDualStreamMode(simulcastStreamMode, new SimulcastStreamConfig());
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setDualStreamMode(Constants.SimulcastStreamMode simulcastStreamMode, SimulcastStreamConfig simulcastStreamConfig) {
        return setDualStreamModeEx(simulcastStreamMode, simulcastStreamConfig, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public int setDualStreamModeEx(Constants.SimulcastStreamMode simulcastStreamMode, SimulcastStreamConfig simulcastStreamConfig, RtcConnection rtcConnection) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (simulcastStreamConfig == null) {
            simulcastStreamConfig = new SimulcastStreamConfig();
        }
        return nativeSetDualStreamModeEx(this.mNativeHandle, Constants.SimulcastStreamMode.getValue(simulcastStreamMode), simulcastStreamConfig, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setEarMonitoringAudioFrameParameters(int i, int i2, int i3, int i4) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEarMonitoringAudioFrameParameters(j, i, i2, i3, i4);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setEffectPosition(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEffectPosition(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int setEffectsVolume(double d) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEffectsVolume(j, d);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setEnableSpeakerphone(boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEnableSpeakerphone(j, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setEncryptionMode(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEncryptionMode(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setEncryptionSecret(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetEncryptionSecret(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExtensionProperty(String str, String str2, ExtensionInfo extensionInfo, String str3, String str4) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (extensionInfo != null) {
                return nativeSetExtensionProperty2(j, str, str2, str3, str4, Constants.MediaSourceType.getValue(extensionInfo.mediaSourceType), extensionInfo.remoteUid, extensionInfo.channelId, extensionInfo.localUid);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExtensionProperty(String str, String str2, String str3, String str4) {
        return setExtensionProperty(str, str2, str3, str4, Constants.MediaSourceType.UNKNOWN_MEDIA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExtensionProperty(String str, String str2, String str3, String str4, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetExtensionProperty(j, str, str2, str3, str4, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExtensionProviderProperty(String str, String str2, String str3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetExtensionProviderProperty(j, str, str2, str3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExternalAudioSink(boolean z, int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        this.mExSinkAudioSampleRate = i;
        this.mExSinkAudioChannels = i2;
        return nativeSetExternalAudioSink(j, z, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExternalAudioSource(boolean z, int i, int i2) {
        return setExternalAudioSource(z, i, i2, false, true);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExternalAudioSource(boolean z, int i, int i2, boolean z2, boolean z3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        this.mExSourceAudioSampleRate = i;
        this.mExSourceAudioChannels = i2;
        return nativeSetExternalAudioSource(j, z, i, i2, z2, z3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExternalVideoSource(boolean z, boolean z2, Constants.ExternalVideoSourceType externalVideoSourceType) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return setExternalVideoSource(z, z2, externalVideoSourceType, null);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setExternalVideoSource(boolean z, boolean z2, Constants.ExternalVideoSourceType externalVideoSourceType, EncodedVideoTrackOptions encodedVideoTrackOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetExternalVideoSource(j, z, z2, Constants.ExternalVideoSourceType.getValue(externalVideoSourceType), encodedVideoTrackOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setHeadphoneEQParameters(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetHeadphoneEQParameters(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setHeadphoneEQPreset(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetHeadphoneEQPreset(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setHighPriorityUserList(int[] iArr, int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return setHighPriorityUserListEx(iArr, i, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setHighPriorityUserListEx(int[] iArr, int i, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetHighPriorityUserList(j, iArr, i, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setHighQualityAudioParameters(boolean z, boolean z2, boolean z3) {
        return setParameterObject("che.audio.codec.hq", formatString("{\"fullband\":%b,\"stereo\":%b,\"fullBitrate\":%b}", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setInEarMonitoringVolume(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetInEarMonitoringVolume(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public int setLocalAccessPoint(LocalAccessPointConfiguration localAccessPointConfiguration) {
        if (localAccessPointConfiguration.ipList == null) {
            localAccessPointConfiguration.ipList = new ArrayList<>();
        }
        if (localAccessPointConfiguration.domainList == null) {
            localAccessPointConfiguration.domainList = new ArrayList<>();
        }
        if (localAccessPointConfiguration.verifyDomainName == null) {
            localAccessPointConfiguration.verifyDomainName = "";
        }
        if (localAccessPointConfiguration.advancedConfig == null) {
            localAccessPointConfiguration.advancedConfig = new LocalAccessPointConfiguration.AdvancedConfigInfo();
        }
        return nativeSetLocalAccessPoint(this.mNativeHandle, localAccessPointConfiguration.ipList, localAccessPointConfiguration.domainList, localAccessPointConfiguration.verifyDomainName, localAccessPointConfiguration.mode, localAccessPointConfiguration.advancedConfig);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalPublishFallbackOption(int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return setParameter("rtc.local_publish_fallback_option", i);
    }

    @Override // io.agora.rtc2.RtcEngine
    @Deprecated
    public synchronized int setLocalRenderMode(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLocalRenderMode(j, i, 0);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalRenderMode(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLocalRenderMode(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    @Deprecated
    public synchronized int setLocalVideoMirrorMode(int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (i == 0 || i == 1 || i == 2) {
                return nativeSetLocalVideoMirrorMode(j, i);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalVoiceEqualization(Constants.AUDIO_EQUALIZATION_BAND_FREQUENCY audio_equalization_band_frequency, int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (audio_equalization_band_frequency != null) {
                return nativeSetLocalVoiceEqualization(j, audio_equalization_band_frequency.getValue(), i);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalVoiceFormant(double d) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLocalVoiceFormant(j, d);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalVoicePitch(double d) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLocalVoicePitch(j, d);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLocalVoiceReverb(Constants.AUDIO_REVERB_TYPE audio_reverb_type, int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (audio_reverb_type != null) {
                return nativeSetLocalVoiceReverb(j, audio_reverb_type.getValue(), i);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLogFile(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLogFile(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLogFileSize(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeSetLogFileSize(j2, j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLogFilter(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLogFilter(j, i & Constants.LOG_FILTER_DEBUG);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLogLevel(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLogLevel(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLowlightEnhanceOptions(boolean z, LowLightEnhanceOptions lowLightEnhanceOptions) {
        return setLowlightEnhanceOptions(z, lowLightEnhanceOptions, Constants.MediaSourceType.PRIMARY_CAMERA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setLowlightEnhanceOptions(boolean z, LowLightEnhanceOptions lowLightEnhanceOptions, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetLowlightEnhanceOptions(j, z, lowLightEnhanceOptions.lowlightEnhanceMode, lowLightEnhanceOptions.lowlightEnhanceLevel, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    public int setMediaRecorderObserver(IMediaRecorderCallback iMediaRecorderCallback, int i, String str, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetMediaRecorderObserver(j, iMediaRecorderCallback, i, str, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setMixedAudioFrameParameters(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetMixedAudioFrameParameters(j, i, i2, i3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setParameters(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetParameters(j, str);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setPlaybackAudioFrameBeforeMixingParameters(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetPlaybackAudioFrameBeforeMixingParameters(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetPlaybackAudioFrameParameters(j, i, i2, i3, i4);
    }

    @Override // io.agora.rtc2.RtcEngine
    @Deprecated
    public synchronized void setPreferHeadset(boolean z) {
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int setProfile(String str, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetProfile(j, str, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRecordingAudioFrameParameters(j, i, i2, i3, i4);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteDefaultVideoStreamType(int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        setParameter("rtc.video.set_remote_default_video_stream_type", i);
        return nativeSetRemoteDefaultVideoStreamType(this.mNativeHandle, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    @Deprecated
    public synchronized int setRemoteRenderMode(int i, int i2) {
        return setRemoteRenderModeEx(i, i2, 2, null);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteRenderMode(int i, int i2, int i3) {
        return setRemoteRenderModeEx(i, i2, i3, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setRemoteRenderModeEx(int i, int i2, int i3, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRemoteRenderMode(j, i, i2, i3, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteSubscribeFallbackOption(int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return setParameter("rtc.remote_subscribe_fallback_option", i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteUserPriority(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRemoteUserPriority(j, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteUserSpatialAudioParams(int i, SpatialAudioParams spatialAudioParams) {
        return setRemoteUserSpatialAudioParamsEx(i, spatialAudioParams, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setRemoteUserSpatialAudioParamsEx(int i, SpatialAudioParams spatialAudioParams, RtcConnection rtcConnection) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (spatialAudioParams != null) {
                return nativeSetRemoteUserSpatialAudioParams(j, i, spatialAudioParams, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteVideoStreamType(int i, int i2) {
        return setRemoteVideoStreamTypeEx(i, i2, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setRemoteVideoStreamTypeEx(int i, int i2, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRemoteVideoStreamType(j, i, i2, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteVideoSubscriptionOptions(int i, VideoSubscriptionOptions videoSubscriptionOptions) {
        return setRemoteVideoSubscriptionOptionsEx(i, videoSubscriptionOptions, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setRemoteVideoSubscriptionOptionsEx(int i, VideoSubscriptionOptions videoSubscriptionOptions, RtcConnection rtcConnection) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (videoSubscriptionOptions != null) {
                return nativeSetRemoteVideoSubscriptionOptions(j, i, videoSubscriptionOptions, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setRemoteVoicePosition(int i, double d, double d2) {
        return setRemoteVoicePositionEx(i, d, d2, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setRemoteVoicePositionEx(int i, double d, double d2, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetRemoteVoicePosition(j, i, d, d2, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setScreenCaptureScenario(Constants.ScreenScenarioType screenScenarioType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetScreenCaptureScenario(j, Constants.ScreenScenarioType.getValue(screenScenarioType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setSubscribeAudioAllowlist(int[] iArr) {
        return setSubscribeAudioAllowlistEx(iArr, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setSubscribeAudioAllowlistEx(int[] iArr, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetSubscribeAudioWhitelist(j, iArr, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setSubscribeAudioBlocklist(int[] iArr) {
        return setSubscribeAudioBlocklistEx(iArr, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setSubscribeAudioBlocklistEx(int[] iArr, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetSubscribeAudioBlacklist(j, iArr, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setSubscribeVideoAllowlist(int[] iArr) {
        return setSubscribeVideoAllowlistEx(iArr, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setSubscribeVideoAllowlistEx(int[] iArr, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetSubscribeVideoWhitelist(j, iArr, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setSubscribeVideoBlocklist(int[] iArr) {
        return setSubscribeVideoBlocklistEx(iArr, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setSubscribeVideoBlocklistEx(int[] iArr, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetSubscribeVideoBlacklist(j, iArr, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int setTextureId(int i, android.opengl.EGLContext eGLContext, int i2, int i3, long j) {
        return -4;
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int setTextureId(int i, EGLContext eGLContext, int i2, int i3, long j) {
        return -4;
    }

    public synchronized int setTextureIdWithMatrix(int i, android.opengl.EGLContext eGLContext, int i2, int i3, int i4, long j, float[] fArr) {
        return -4;
    }

    public synchronized int setTextureIdWithMatrix(int i, EGLContext eGLContext, int i2, int i3, int i4, long j, float[] fArr) {
        return -4;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoDenoiserOptions(boolean z, VideoDenoiserOptions videoDenoiserOptions) {
        return setVideoDenoiserOptions(z, videoDenoiserOptions, Constants.MediaSourceType.PRIMARY_CAMERA_SOURCE);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoDenoiserOptions(boolean z, VideoDenoiserOptions videoDenoiserOptions, Constants.MediaSourceType mediaSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVideoDenoiserOptions(j, z, videoDenoiserOptions.denoiserMode, videoDenoiserOptions.denoiserLevel, Constants.MediaSourceType.getValue(mediaSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        return setVideoEncoderConfigurationEx(videoEncoderConfiguration, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setVideoEncoderConfigurationEx(VideoEncoderConfiguration videoEncoderConfiguration, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
        return nativeSetVideoEncoderConfiguration(j, videoDimensions.width, videoDimensions.height, videoEncoderConfiguration.frameRate, videoEncoderConfiguration.bitrate, videoEncoderConfiguration.minBitrate, videoEncoderConfiguration.orientationMode.getValue(), videoEncoderConfiguration.mirrorMode.getValue(), videoEncoderConfiguration.degradationPrefer.getValue(), videoEncoderConfiguration.advanceOptions.compressionPreference.getValue(), videoEncoderConfiguration.advanceOptions.encodingPreference.getValue(), getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoProfile(int i, boolean z) {
        if (i < 0) {
            return -2;
        }
        return setParameters(formatString("{\"rtc.video.profile\":[%d,%b]}", Integer.valueOf(i), Boolean.valueOf(z)));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoQualityParameters(boolean z) {
        return setParameters(String.format("{\"rtc.video.prefer_frame_rate\":%b,\"che.video.prefer_frame_rate\":%b}", Boolean.valueOf(z), Boolean.valueOf(z)));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVideoScenario(Constants.VideoScenario videoScenario) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativesetVideoScenario(j, Constants.VideoScenario.getValue(videoScenario));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVoiceBeautifierParameters(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVoiceBeautifierParameters(j, i, i2, i3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVoiceBeautifierPreset(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVoiceBeautifierPreset(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVoiceConversionParameters(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVoiceConversionParameters(j, i, i2, i3);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setVoiceConversionPreset(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVoiceConversionPreset(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int setVolumeOfEffect(int i, double d) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSetVolumeOfEffect(j, i, d);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setupLocalVideo(VideoCanvas videoCanvas) {
        int i;
        long j = this.mNativeHandle;
        if (j == 0) {
            i = -7;
        } else {
            if (videoCanvas == null) {
                return nativeSetupLocalVideo(j, null, 1, 0, 0, 0, null, 1);
            }
            if (validateVideoRendererView(videoCanvas.view)) {
                int[] iArr = null;
                Rect rect = videoCanvas.rect;
                if (rect != null) {
                    int i2 = rect.left;
                    int i3 = rect.top;
                    iArr = new int[]{i2, i3, rect.right - i2, rect.bottom - i3};
                }
                return nativeSetupLocalVideo(this.mNativeHandle, videoCanvas.view, videoCanvas.renderMode, videoCanvas.mirrorMode, videoCanvas.sourceType, videoCanvas.mediaPlayerId, iArr, videoCanvas.setupMode);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int setupRemoteVideo(VideoCanvas videoCanvas) {
        return setupRemoteVideoEx(videoCanvas, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int setupRemoteVideoEx(VideoCanvas videoCanvas, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (videoCanvas == null) {
                return -2;
            }
            if (!validateVideoRendererView(videoCanvas.view)) {
                return -2;
            }
            int i2 = videoCanvas.uid;
            if (i2 != 0) {
                int[] iArr = null;
                Rect rect = videoCanvas.rect;
                if (rect != null) {
                    int i3 = rect.left;
                    int i4 = rect.top;
                    iArr = new int[]{i3, i4, rect.right - i3, rect.bottom - i4};
                }
                return nativeSetupRemoteVideo(this.mNativeHandle, videoCanvas.view, videoCanvas.renderMode, videoCanvas.mirrorMode, i2, iArr, videoCanvas.setupMode, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -1;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startAudioMixing(String str, boolean z, int i) {
        return startAudioMixing(str, z, i, 0);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startAudioMixing(String str, boolean z, int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartAudioMixing(j, str, z, i, i2);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startAudioRecording(AudioRecordingConfiguration audioRecordingConfiguration) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (!TextUtils.isEmpty(audioRecordingConfiguration.filePath)) {
                return nativeStartAudioRecording2(this.mNativeHandle, audioRecordingConfiguration.filePath, audioRecordingConfiguration.codec, audioRecordingConfiguration.sampleRate, audioRecordingConfiguration.fileRecordOption, audioRecordingConfiguration.quality, audioRecordingConfiguration.recordingChannel);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startAudioRecording(String str, int i) {
        int i2;
        if (this.mNativeHandle == 0) {
            i2 = -7;
        } else {
            if (!TextUtils.isEmpty(str)) {
                return nativeStartAudioRecording(this.mNativeHandle, str, i);
            }
            i2 = -2;
        }
        return i2;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startCameraCapture(Constants.VideoSourceType videoSourceType, CameraCapturerConfiguration cameraCapturerConfiguration) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartCameraCapture(j, Constants.VideoSourceType.getValue(videoSourceType), cameraCapturerConfiguration);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return startChannelMediaRelayEx(channelMediaRelayConfiguration, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int startChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (checkRelayConfiguration(channelMediaRelayConfiguration)) {
                Map<String, ChannelMediaInfo> destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
                ChannelMediaInfo[] channelMediaInfoArr = new ChannelMediaInfo[destChannelMediaInfos.size()];
                destChannelMediaInfos.values().toArray(channelMediaInfoArr);
                return nativeStartChannelMediaRelay(this.mNativeHandle, channelMediaRelayConfiguration.getSrcChannelMediaInfo(), channelMediaInfoArr, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startDirectCdnStreaming(IDirectCdnStreamingEventHandler iDirectCdnStreamingEventHandler, String str, DirectCdnStreamingMediaOptions directCdnStreamingMediaOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartDirectCdnStreaming(j, iDirectCdnStreamingEventHandler, str, directCdnStreamingMediaOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startEchoTest() {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTest(this.mNativeHandle);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startEchoTest(int i) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTestWithInterval(this.mNativeHandle, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startEchoTest(EchoTestConfiguration echoTestConfiguration) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTestWithConfig(this.mNativeHandle, echoTestConfiguration.view, echoTestConfiguration.enableAudio, echoTestConfiguration.enableVideo, echoTestConfiguration.token, echoTestConfiguration.channelId, echoTestConfiguration.intervalInSeconds);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartLastmileProbeTest(this.mNativeHandle, lastmileProbeConfig.probeUplink, lastmileProbeConfig.probeDownlink, lastmileProbeConfig.expectedUplinkBitrate, lastmileProbeConfig.expectedDownlinkBitrate);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startLocalVideoTranscoder(LocalTranscoderConfiguration localTranscoderConfiguration) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return nativeStartLocalVideoTranscoder(this.mNativeHandle, new RtcEngineMessage.PLocalLiveTranscoderConfiguration().marshall(localTranscoderConfiguration));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startMediaRenderingTracing() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartMediaRenderingTracing(j);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int startMediaRenderingTracingEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartMediaRenderingTracingEx(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startOrUpdateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return startOrUpdateChannelMediaRelayEx(channelMediaRelayConfiguration, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int startOrUpdateChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (checkRelayConfiguration(channelMediaRelayConfiguration)) {
                Map<String, ChannelMediaInfo> destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
                ChannelMediaInfo[] channelMediaInfoArr = new ChannelMediaInfo[destChannelMediaInfos.size()];
                destChannelMediaInfos.values().toArray(channelMediaInfoArr);
                return nativeStartOrUpdateChannelMediaRelay(this.mNativeHandle, channelMediaRelayConfiguration.getSrcChannelMediaInfo(), channelMediaInfoArr, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startPreview() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartPreview(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startPreview(Constants.VideoSourceType videoSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartPreviewForSourceType(j, Constants.VideoSourceType.getValue(videoSourceType));
    }

    public int startRecording(String str, int i, int i2, int i3, int i4, int i5, String str2, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartRecording(j, str, i, i2, i3, i4, i5, str2, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startRecordingDeviceTest(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartRecordingDeviceTest(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startRhythmPlayer(String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && agoraRhythmPlayerConfig != null) {
                return nativeStartRhythmPlayer(this.mNativeHandle, str, str2, agoraRhythmPlayerConfig);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        return startRtmpStreamWithTranscodingEx(str, liveTranscoding, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int startRtmpStreamWithTranscodingEx(String str, LiveTranscoding liveTranscoding, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (liveTranscoding != null) {
                return nativeStartRtmpStreamWithTranscoding(this.mNativeHandle, str, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding), getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startRtmpStreamWithoutTranscoding(String str) {
        return startRtmpStreamWithoutTranscodingEx(str, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int startRtmpStreamWithoutTranscodingEx(String str, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStartRtmpStreamWithoutTranscoding(j, str, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int startScreenCapture(ScreenCaptureParameters screenCaptureParameters) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (screenCaptureParameters == null) {
            Logging.e(TAG, "Failed to startScreenCapture, parameters null");
            return -2;
        }
        if (getOSVersion() < 21) {
            Logging.e("current android version not support for screen capture!");
            return -2;
        }
        int i = 0;
        if (getOSVersion() < 29 && screenCaptureParameters.captureAudio) {
            Logging.e("current android version not support for capture audio!");
            screenCaptureParameters.captureAudio = false;
            i = -3;
        }
        if (screenCaptureParameters.captureAudio) {
            allowCaptureCurrentApp();
        }
        int iNativeStartScreenCapture = nativeStartScreenCapture(this.mNativeHandle, screenCaptureParameters);
        return iNativeStartScreenCapture != 0 ? iNativeStartScreenCapture : i;
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int stopAllEffects() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopAllEffects(j);
    }

    public synchronized int stopAllRemoteVideo() {
        return setParameter("che.video.peer.stop_all_renders", true);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopAudioMixing() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopAudioMixing(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopAudioRecording() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopAudioRecording(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopCameraCapture(Constants.VideoSourceType videoSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopCameraCapture(j, Constants.VideoSourceType.getValue(videoSourceType));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopChannelMediaRelay() {
        return stopChannelMediaRelayEx(null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int stopChannelMediaRelayEx(RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopChannelMediaRelay(j, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopDirectCdnStreaming() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopDirectCdnStreaming(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopEchoTest() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopEchoTest(j);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int stopEffect(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopEffect(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopLastmileProbeTest() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopLastmileProbeTest(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopLocalVideoTranscoder() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopLocalVideoTranscoder(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopPreview() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopPreview(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopPreview(Constants.VideoSourceType videoSourceType) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopPreviewForSourceType(j, Constants.VideoSourceType.getValue(videoSourceType));
    }

    public int stopRecording(String str, int i, boolean z) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopRecording(j, i, str, z);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopRecordingDeviceTest() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopRecordingDeviceTest(j);
    }

    public synchronized int stopRemoteVideo(int i) {
        return setParameter("che.video.peer.stop_video", toStringUserId(i));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopRhythmPlayer() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopRhythmPlayer(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopRtmpStream(String str) {
        return stopRtmpStreamEx(str, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int stopRtmpStreamEx(String str, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopRtmpStream(j, str, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int stopScreenCapture() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeStopScreenCapture(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int switchCamera() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeSwitchCamera(j);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int takeSnapshot(int i, String str) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return takeSnapshotEx(null, i, str);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int takeSnapshotEx(RtcConnection rtcConnection, int i, String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeTakeSnapshot(j, i, str, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int unRegisterAudioSpectrumObserver(IAudioSpectrumObserver iAudioSpectrumObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeUnRegisterAudioSpectrumObserver(j, iAudioSpectrumObserver);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int unloadAllEffects() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeUnloadAllEffects(j);
    }

    @Override // io.agora.rtc2.RtcEngine, io.agora.rtc2.IAudioEffectManager
    public synchronized int unloadEffect(int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeUnloadEffect(j, i);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int unregisterMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        int i2;
        long j = this.mNativeHandle;
        if (j == 0) {
            i2 = -7;
        } else {
            if (iMetadataObserver != null) {
                return nativeUnregisterMediaMetadataObserver(j, iMetadataObserver, i);
            }
            Logging.e(TAG, "Failed to unRegisterMediaMetadataObserver, observer null");
            i2 = -2;
        }
        return i2;
    }

    public synchronized int unregisterMediaPlayerAudioSpectrumObserver(int i, IAudioSpectrumObserver iAudioSpectrumObserver) {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed (mediaPlayerUnRegisterPlayerObserver)");
            return -7;
        }
        return nativeUnRegisterMediaPlayerAudioSpectrumObserver(j, i, iAudioSpectrumObserver);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateChannelMediaOptions(ChannelMediaOptions channelMediaOptions) {
        return updateChannelMediaOptionsEx(channelMediaOptions, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int updateChannelMediaOptionsEx(ChannelMediaOptions channelMediaOptions, RtcConnection rtcConnection) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeUpdateChannelMediaOptions(j, channelMediaOptions, getChannelId(rtcConnection), getUserId(rtcConnection));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return updateChannelMediaRelayEx(channelMediaRelayConfiguration, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int updateChannelMediaRelayEx(ChannelMediaRelayConfiguration channelMediaRelayConfiguration, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (checkRelayConfiguration(channelMediaRelayConfiguration)) {
                Map<String, ChannelMediaInfo> destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
                ChannelMediaInfo[] channelMediaInfoArr = new ChannelMediaInfo[destChannelMediaInfos.size()];
                destChannelMediaInfos.values().toArray(channelMediaInfoArr);
                return nativeUpdateChannelMediaRelay(this.mNativeHandle, channelMediaRelayConfiguration.getSrcChannelMediaInfo(), channelMediaInfoArr, getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateDirectCdnStreamingMediaOptions(DirectCdnStreamingMediaOptions directCdnStreamingMediaOptions) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeUpdateDirectCdnStreamingMediaOptions(j, directCdnStreamingMediaOptions);
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateLocalTranscoderConfiguration(LocalTranscoderConfiguration localTranscoderConfiguration) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        return nativeUpdateLocalTranscoderConfiguration(this.mNativeHandle, new RtcEngineMessage.PLocalLiveTranscoderConfiguration().marshall(localTranscoderConfiguration));
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        return updateRtmpTranscodingEx(liveTranscoding, null);
    }

    @Override // io.agora.rtc2.RtcEngineEx
    public synchronized int updateRtmpTranscodingEx(LiveTranscoding liveTranscoding, RtcConnection rtcConnection) {
        int i;
        if (this.mNativeHandle == 0) {
            i = -7;
        } else {
            if (liveTranscoding != null) {
                return nativeUpdateRtmpTranscoding(this.mNativeHandle, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding), getChannelId(rtcConnection), getUserId(rtcConnection));
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized int updateScreenCaptureParameters(ScreenCaptureParameters screenCaptureParameters) {
        if (this.mNativeHandle == 0) {
            return -7;
        }
        if (screenCaptureParameters == null) {
            Logging.e(TAG, "Failed to updateScreenCaptureParameters, parameters null");
            return -2;
        }
        if (getOSVersion() < 21) {
            Logging.e("current android version not support for screen capture!");
            return -2;
        }
        int i = 0;
        if (getOSVersion() < 29 && screenCaptureParameters.captureAudio) {
            Logging.e("current android version not support for capture audio!");
            screenCaptureParameters.captureAudio = false;
            i = -3;
        }
        if (screenCaptureParameters.captureAudio) {
            allowCaptureCurrentApp();
        }
        int iNativeUpdateScreenCaptureParameters = nativeUpdateScreenCaptureParameters(this.mNativeHandle, screenCaptureParameters);
        return iNativeUpdateScreenCaptureParameters != 0 ? iNativeUpdateScreenCaptureParameters : i;
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int updateSharedContext(android.opengl.EGLContext eGLContext) {
        return -4;
    }

    @Override // io.agora.rtc2.RtcEngineInternal
    public synchronized int updateSharedContext(EGLContext eGLContext) {
        return -4;
    }

    @Override // io.agora.rtc2.RtcEngine
    public synchronized String uploadLogFile() {
        long j = this.mNativeHandle;
        if (j == 0) {
            Logging.e(TAG, "RtcEngine does not initialize or it may be destroyed");
            return null;
        }
        return nativeUploadLogFile(j);
    }
}
