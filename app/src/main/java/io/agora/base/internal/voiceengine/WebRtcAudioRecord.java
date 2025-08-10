package io.agora.base.internal.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRouting;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.Nullable;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALCULATE_LATENCY_PERIOD = 400;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AUDIO_SOURCE;
    private static final int DEFAULT_RECORD_LATENCY = 60;
    private static final int MAX_RECORD_LATENCY = 250;
    private static final String TAG = "WebRtcAudioRecord [JavaAdm]";

    @Nullable
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int audioSource;

    @Nullable
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;

    @Nullable
    private static AudioRecordRouteCallback recordRouteCallback;
    private final AudioManager audioManager;
    private ByteBuffer byteBuffer;

    @Nullable
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;

    @Nullable
    private AudioRecordRoutingListener recordRouteListener;

    @Nullable
    private AudioRecordRoutingListenerForAPI23 recordRouteListenerForAPI23;

    @Nullable
    private AudioRecord audioRecord = null;

    @Nullable
    private AudioRecordThread audioThread = null;
    private int mRecordLatency = 0;
    private long mFramesRead = 0;
    private int mBytesPerFrame = 2;
    private int mRecordLoopCounter = 0;

    public interface AudioRecordRouteCallback {
        void onAudioRecordRouteNotify(int i, AudioDeviceInfo audioDeviceInfo);
    }

    public class AudioRecordRoutingListener implements AudioRouting.OnRoutingChangedListener {
        private AudioRecordRoutingListener() {
        }

        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo preferredDevice = audioRouting.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioRecord.recordRouteCallback != null) {
                WebRtcAudioRecord.recordRouteCallback.onAudioRecordRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioRecord.TAG, "[USB] [AudioRecord-audioRouting] onRoutingChanged: " + type);
        }
    }

    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    public class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            WebRtcAudioRecord.assertTrue(WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3);
            System.nanoTime();
            while (this.keepAlive) {
                int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    if (this.keepAlive) {
                        WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                        webRtcAudioRecord.nativeDataIsRecorded(i, webRtcAudioRecord.mRecordLatency, WebRtcAudioRecord.this.nativeAudioRecord);
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity())));
                    }
                } else {
                    String str = "AudioRecord.read failed: " + i;
                    Logging.e(WebRtcAudioRecord.TAG, str);
                    if (i == -3) {
                        this.keepAlive = false;
                        WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                    }
                }
                if (WebRtcAudioRecord.this.mFramesRead == 0) {
                    Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread read first frame : " + (i / WebRtcAudioRecord.this.mBytesPerFrame) + " finished. ");
                }
                WebRtcAudioRecord.access$1114(WebRtcAudioRecord.this, i / r4.mBytesPerFrame);
                try {
                    if (WebRtcAudioRecord.this.mRecordLoopCounter % 400 == 0) {
                        WebRtcAudioRecord.this.calculateLatencyMillis();
                    }
                    WebRtcAudioRecord webRtcAudioRecord2 = WebRtcAudioRecord.this;
                    webRtcAudioRecord2.mRecordLoopCounter = (webRtcAudioRecord2.mRecordLoopCounter + 1) % 400;
                } catch (Throwable th) {
                    Logging.e(WebRtcAudioRecord.TAG, "calculateLatencyMillis failed: " + th.getMessage());
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (IllegalStateException e) {
                Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e.getMessage());
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        private AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }
    }

    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
        microphoneMute = false;
        errorCallback = null;
        recordRouteCallback = null;
        audioSamplesReadyCallback = null;
    }

    public WebRtcAudioRecord(long j) {
        this.effects = null;
        this.recordRouteListenerForAPI23 = null;
        this.recordRouteListener = null;
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = j;
        this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        this.effects = WebRtcAudioEffects.create();
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            this.recordRouteListenerForAPI23 = new AudioRecordRoutingListenerForAPI23();
        } else if (i > 23) {
            this.recordRouteListener = new AudioRecordRoutingListener();
        }
    }

    public static /* synthetic */ long access$1114(WebRtcAudioRecord webRtcAudioRecord, long j) {
        long j2 = webRtcAudioRecord.mFramesRead + j;
        webRtcAudioRecord.mFramesRead = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateLatencyMillis() {
        if (this.audioRecord == null) {
            Logging.e(TAG, "audioRecord is null");
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (this.audioRecord.getTimestamp(audioTimestamp, 0) != 0) {
                Logging.e(TAG, "audioTimestamp is unavailable");
                return -1;
            }
            int iNanoTime = (int) ((System.nanoTime() - (audioTimestamp.nanoTime + (((((this.mFramesRead - audioTimestamp.framePosition) * 1000) * 1000) * 1000) / this.audioRecord.getSampleRate()))) / 1000000);
            int bufferSizeInFrames = (this.audioRecord.getBufferSizeInFrames() * 1000) / this.audioRecord.getSampleRate();
            if (iNanoTime > 0 && iNanoTime <= 250) {
                this.mRecordLatency = iNanoTime + (bufferSizeInFrames > 20 ? bufferSizeInFrames / 2 : 10);
            }
        } else {
            this.mRecordLatency = 60;
        }
        return this.mRecordLatency;
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    private boolean enableBuiltInAEC(boolean z) {
        Logging.d(TAG, "enableBuiltInAEC(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAEC(z);
        }
        Logging.e(TAG, "Built-in AEC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInAGC(boolean z) {
        Logging.d(TAG, "enableBuiltInAGC(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAGC(z);
        }
        Logging.e(TAG, "Built-in AGC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInNS(boolean z) {
        Logging.d(TAG, "enableBuiltInNS(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setNS(z);
        }
        Logging.e(TAG, "Built-in NS is not supported on this platform");
        return false;
    }

    private static int getDefaultAudioSource() {
        return 7;
    }

    private int initRecording(int i, int i2, int i3) {
        AudioRecordRoutingListener audioRecordRoutingListener;
        AudioRecordRouteCallback audioRecordRouteCallback;
        String str;
        Logging.d(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + ", minBufMs " + i3 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i4 = i2 * 2;
        this.mBytesPerFrame = i4;
        int i5 = i / 100;
        this.byteBuffer = ByteBuffer.allocateDirect(i4 * i5);
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = AudioRecord.getMinBufferSize(i, iChannelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        int i6 = i3 * (i / 1000) * i2 * 2;
        int i7 = iMax < i6 ? i6 : iMax;
        Logging.d(TAG, "bufferSizeInBytes: " + i7);
        Logging.d(TAG, "initRecording audio mode: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()) + ", source: " + WebRtcAudioUtils.sourceToString(audioSource) + ", sampleRate: " + i);
        if (!ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone")) {
            Logging.d(TAG, "[USB] Before create audiorecord instance: has no PackageManager.FEATURE_MICROPHONE");
        }
        try {
            AudioRecord audioRecord = new AudioRecord(audioSource, i, iChannelCountToConfiguration, 2, i7);
            this.audioRecord = audioRecord;
            if (audioRecord.getState() != 1) {
                if (("Failed to create a new AudioRecord instance: instance= " + this.audioRecord) == null) {
                    str = "null";
                } else {
                    str = "success state = " + this.audioRecord.getState();
                }
                reportWebRtcAudioRecordInitError(str);
                releaseAudioResources();
                return -1;
            }
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
            }
            logMainParameters();
            logMainParametersExtended();
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 23) {
                AudioDeviceInfo preferredDevice = this.audioRecord.getPreferredDevice();
                if (preferredDevice != null) {
                    Logging.d(TAG, "[USB] deviceType = " + preferredDevice.getType());
                } else {
                    Logging.d(TAG, "[USB] has no preferred device");
                    preferredDevice = this.audioRecord.getRoutedDevice();
                    if (preferredDevice != null) {
                        Logging.d(TAG, "[USB] initRecording-getRoutedDevice deviceType = " + preferredDevice.getType());
                    }
                }
                if (preferredDevice != null && (audioRecordRouteCallback = recordRouteCallback) != null) {
                    audioRecordRouteCallback.onAudioRecordRouteNotify(0, preferredDevice);
                }
                Logging.d(TAG, "android.os.Build.VERSION.SDK_INT = " + i8);
                if (i8 == 23) {
                    AudioRecordRoutingListenerForAPI23 audioRecordRoutingListenerForAPI23 = this.recordRouteListenerForAPI23;
                    if (audioRecordRoutingListenerForAPI23 != null) {
                        this.audioRecord.addOnRoutingChangedListener((AudioRecord.OnRoutingChangedListener) audioRecordRoutingListenerForAPI23, (Handler) null);
                    }
                } else if (i8 > 23 && (audioRecordRoutingListener = this.recordRouteListener) != null) {
                    this.audioRecord.addOnRoutingChangedListener(audioRecordRoutingListener, (Handler) null);
                }
            }
            return i5;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
    }

    @TargetApi(23)
    private void logMainParametersExtended() {
        if (WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
            Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i, int i2, long j);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        try {
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.release();
            }
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
                this.audioRecord = null;
            }
        } catch (Exception e) {
            Logging.w(TAG, "releaseAudioResources e: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    public static synchronized int setAudioSource(int i) {
        Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + i);
        audioSource = i;
        return 0;
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = webRtcAudioRecordErrorCallback;
    }

    public static void setMicrophoneMute(boolean z) {
        Logging.w(TAG, "setMicrophoneMute(" + z + ")");
        microphoneMute = z;
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
    }

    public static void setRecordRouteCallback(AudioRecordRouteCallback audioRecordRouteCallback) {
        Logging.d(TAG, "[USB] Set AudioRecordRouteCallback");
        recordRouteCallback = audioRecordRouteCallback;
    }

    private int startRecording() throws IllegalStateException {
        Logging.d(TAG, "startRecording");
        assertTrue(this.audioRecord != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioRecord.startRecording();
            int recordingState = this.audioRecord.getRecordingState();
            if (recordingState == 3) {
                this.mFramesRead = 0L;
                AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                return this.audioRecord.getAudioSessionId();
            }
            releaseAudioResources();
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + recordingState);
            return -1;
        } catch (IllegalStateException e) {
            releaseAudioResources();
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
            return -1;
        }
    }

    private boolean stopRecording() {
        AudioRecordRoutingListener audioRecordRoutingListener;
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        this.audioThread = null;
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            AudioRecordRoutingListenerForAPI23 audioRecordRoutingListenerForAPI23 = this.recordRouteListenerForAPI23;
            if (audioRecordRoutingListenerForAPI23 != null) {
                this.audioRecord.removeOnRoutingChangedListener((AudioRecord.OnRoutingChangedListener) audioRecordRoutingListenerForAPI23);
            }
        } else if (i > 23 && (audioRecordRoutingListener = this.recordRouteListener) != null) {
            this.audioRecord.removeOnRoutingChangedListener(audioRecordRoutingListener);
        }
        releaseAudioResources();
        return true;
    }

    public class AudioRecordRoutingListenerForAPI23 implements AudioRecord.OnRoutingChangedListener {
        private AudioRecordRoutingListenerForAPI23() {
        }

        @Override // android.media.AudioRecord.OnRoutingChangedListener
        public void onRoutingChanged(AudioRecord audioRecord) {
            AudioDeviceInfo preferredDevice = audioRecord.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioRecord.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioRecord.recordRouteCallback != null) {
                WebRtcAudioRecord.recordRouteCallback.onAudioRecordRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioRecord.TAG, "[USB] [AudioRecord-audioRecord] onRoutingChanged:" + type);
        }

        @Override // android.media.AudioRecord.OnRoutingChangedListener, android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo preferredDevice = audioRouting.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioRecord.recordRouteCallback != null) {
                WebRtcAudioRecord.recordRouteCallback.onAudioRecordRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioRecord.TAG, "[USB] [AudioRecord-audioRouting] onRoutingChanged: " + type);
        }
    }
}
