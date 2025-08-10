package io.agora.rtc2;

import io.agora.rtc2.internal.RtcEngineImpl;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class AgoraMediaRecorder {
    public static final int CONTAINER_MP4 = 1;
    public static final int RECORDER_ERROR_CONFIG_CHANGED = 4;
    public static final int RECORDER_ERROR_NONE = 0;
    public static final int RECORDER_ERROR_NO_STREAM = 2;
    public static final int RECORDER_ERROR_OVER_MAX_DURATION = 3;
    public static final int RECORDER_ERROR_WRITE_FAILED = 1;
    public static final int RECORDER_STATE_ERROR = -1;
    public static final int RECORDER_STATE_START = 2;
    public static final int RECORDER_STATE_STOP = 3;
    public static final int STREAM_TYPE_AUDIO = 1;
    public static final int STREAM_TYPE_BOTH = 3;
    public static final int STREAM_TYPE_VIDEO = 2;
    public String mChannelId;
    public WeakReference<RtcEngineImpl> mEngineReference;
    public boolean mIsLocal;
    public int mRemoteUid = 0;
    public RecorderStreamInfo mStreamInfo;

    public static class MediaRecorderConfiguration {
        public int containerFormat;
        public int maxDurationMs;
        public int recorderInfoUpdateInterval;
        public String storagePath;
        public int streamType;

        public MediaRecorderConfiguration(String str, int i, int i2, int i3, int i4) {
            this.containerFormat = 1;
            this.streamType = 3;
            this.maxDurationMs = 120000;
            this.recorderInfoUpdateInterval = 0;
            this.storagePath = str;
            this.containerFormat = i;
            this.streamType = i2;
            this.maxDurationMs = i3;
            this.recorderInfoUpdateInterval = i4;
        }
    }

    public AgoraMediaRecorder(RtcEngineImpl rtcEngineImpl, RecorderStreamInfo recorderStreamInfo) {
        this.mIsLocal = true;
        this.mEngineReference = new WeakReference<>(rtcEngineImpl);
        this.mIsLocal = true;
        this.mStreamInfo = recorderStreamInfo;
        if (recorderStreamInfo.channelId == null) {
            recorderStreamInfo.channelId = "";
        }
    }

    public static String getChannelId(RecorderStreamInfo recorderStreamInfo) {
        if (recorderStreamInfo != null) {
            return recorderStreamInfo.channelId;
        }
        return null;
    }

    public static int getUserId(RecorderStreamInfo recorderStreamInfo) {
        if (recorderStreamInfo != null) {
            return recorderStreamInfo.uid;
        }
        return 0;
    }

    public void release() {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            rtcEngineImpl.releaseRecorder(this.mIsLocal ? getChannelId(this.mStreamInfo) : this.mChannelId, this.mIsLocal ? getUserId(this.mStreamInfo) : this.mRemoteUid, this.mIsLocal);
        }
        this.mEngineReference = null;
    }

    public int setMediaRecorderObserver(IMediaRecorderCallback iMediaRecorderCallback) {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            return rtcEngineImpl.setMediaRecorderObserver(iMediaRecorderCallback, this.mIsLocal ? getUserId(this.mStreamInfo) : this.mRemoteUid, this.mIsLocal ? getChannelId(this.mStreamInfo) : this.mChannelId, this.mIsLocal);
        }
        this.mEngineReference = null;
        return -7;
    }

    public int startRecording(MediaRecorderConfiguration mediaRecorderConfiguration) {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            return rtcEngineImpl.startRecording(mediaRecorderConfiguration.storagePath, mediaRecorderConfiguration.containerFormat, mediaRecorderConfiguration.streamType, mediaRecorderConfiguration.maxDurationMs, mediaRecorderConfiguration.recorderInfoUpdateInterval, this.mIsLocal ? getUserId(this.mStreamInfo) : this.mRemoteUid, this.mIsLocal ? getChannelId(this.mStreamInfo) : this.mChannelId, this.mIsLocal);
        }
        this.mEngineReference = null;
        return -7;
    }

    public int stopRecording() {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            return rtcEngineImpl.stopRecording(this.mIsLocal ? getChannelId(this.mStreamInfo) : this.mChannelId, this.mIsLocal ? getUserId(this.mStreamInfo) : this.mRemoteUid, this.mIsLocal);
        }
        this.mEngineReference = null;
        return -7;
    }
}
