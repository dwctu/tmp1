package io.agora.base.internal.voiceengine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRouting;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.Nullable;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import io.agora.base.internal.ThreadUtils;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class WebRtcAudioTrack {
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALCULATE_LATENCY_PERIOD = 400;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_PLAYOUT_LATENCY = 160;
    private static final int DEFAULT_USAGE;
    private static final int MAX_PLAYOUT_LATENCY = 400;
    private static final String TAG = "WebRtcAudioTrack [JavaAdm]";

    @TargetApi(21)
    private static int contentType;
    private static boolean enableLowlatencyPlayout;

    @Nullable
    private static ErrorCallback errorCallback;

    @Nullable
    private static WebRtcAudioTrackErrorCallback errorCallbackOld;
    private static volatile boolean speakerMute;
    private static int streamType;

    @Nullable
    private static AudioTrackRouteCallback trackRouteCallback;
    private static int usageAttribute;
    private final AudioManager audioManager;

    @Nullable
    private AudioTrackThread audioThread;

    @Nullable
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private byte[] emptyBytes;
    private int mBytesPerFrame;
    private long mFramesWritten;
    private int mPlayPreviousUnderrun;
    private int mPlayoutLatency;
    private int mPlayoutLoopCounter;
    private final long nativeAudioTrack;
    private final ThreadUtils.ThreadChecker threadChecker;

    @Nullable
    private AudioTrackRoutingListener trackRouteListener;

    @Nullable
    private AudioTrackRoutingListenerForAPI23 trackRouteListenerForAPI23;

    public interface AudioTrackRouteCallback {
        void onAudioTrackRouteNotify(int i, AudioDeviceInfo audioDeviceInfo);
    }

    public class AudioTrackRoutingListener implements AudioRouting.OnRoutingChangedListener {
        private AudioTrackRoutingListener() {
        }

        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo preferredDevice = audioRouting.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioTrack.trackRouteCallback != null) {
                WebRtcAudioTrack.trackRouteCallback.onAudioTrackRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioTrack.TAG, "[USB] [AudioTrack-audioRouting] onRoutingChanged: " + type);
        }
    }

    public enum AudioTrackStartErrorCode {
        AUDIO_TRACK_START_EXCEPTION,
        AUDIO_TRACK_START_STATE_MISMATCH
    }

    public class AudioTrackThread extends Thread {
        private volatile boolean keepAlive;

        public AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @TargetApi(21)
        private int writeOnLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer, i, 0);
        }

        private int writePreLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
            WebRtcAudioTrack.assertTrue(WebRtcAudioTrack.this.audioTrack.getPlayState() == 3);
            int iCapacity = WebRtcAudioTrack.this.byteBuffer.capacity();
            while (this.keepAlive) {
                WebRtcAudioTrack webRtcAudioTrack = WebRtcAudioTrack.this;
                webRtcAudioTrack.nativeGetPlayoutData(iCapacity, webRtcAudioTrack.mPlayoutLatency, WebRtcAudioTrack.this.nativeAudioTrack);
                WebRtcAudioTrack.assertTrue(iCapacity <= WebRtcAudioTrack.this.byteBuffer.remaining());
                if (WebRtcAudioTrack.speakerMute) {
                    WebRtcAudioTrack.this.byteBuffer.clear();
                    WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
                    WebRtcAudioTrack.this.byteBuffer.position(0);
                }
                int iWriteOnLollipop = WebRtcAudioUtils.runningOnLollipopOrHigher() ? writeOnLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, iCapacity) : writePreLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, iCapacity);
                if (iWriteOnLollipop != iCapacity) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + iWriteOnLollipop);
                    if (iWriteOnLollipop < 0) {
                        this.keepAlive = false;
                        WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write failed: " + iWriteOnLollipop);
                    }
                }
                if (WebRtcAudioTrack.this.mFramesWritten == 0) {
                    Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread write first frame : " + iWriteOnLollipop + " finished.");
                }
                WebRtcAudioTrack.access$914(WebRtcAudioTrack.this, iWriteOnLollipop / r5.mBytesPerFrame);
                try {
                    if (WebRtcAudioTrack.this.mPlayoutLoopCounter % 400 == 0) {
                        WebRtcAudioTrack.this.calculateLatencyMillis();
                    }
                    WebRtcAudioTrack webRtcAudioTrack2 = WebRtcAudioTrack.this;
                    webRtcAudioTrack2.mPlayoutLoopCounter = (webRtcAudioTrack2.mPlayoutLoopCounter + 1) % 400;
                } catch (Throwable th) {
                    Logging.e(WebRtcAudioTrack.TAG, "calculateLatencyMillis failed: " + th.getMessage());
                }
                WebRtcAudioTrack.this.byteBuffer.rewind();
            }
            if (WebRtcAudioTrack.this.audioTrack != null) {
                Logging.d(WebRtcAudioTrack.TAG, "Calling AudioTrack.stop...");
                try {
                    WebRtcAudioTrack.this.audioTrack.stop();
                    Logging.d(WebRtcAudioTrack.TAG, "AudioTrack.stop is done.");
                } catch (Exception e) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.stop failed: " + e.getMessage());
                }
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioTrack.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    public interface ErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    @Deprecated
    public interface WebRtcAudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(String str);
    }

    static {
        int defaultUsageAttribute = getDefaultUsageAttribute();
        DEFAULT_USAGE = defaultUsageAttribute;
        usageAttribute = defaultUsageAttribute;
        streamType = 0;
        contentType = 1;
        enableLowlatencyPlayout = false;
        speakerMute = false;
        errorCallbackOld = null;
        errorCallback = null;
        trackRouteCallback = null;
    }

    public WebRtcAudioTrack(long j) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.audioTrack = null;
        this.audioThread = null;
        this.mPlayoutLatency = 0;
        this.mFramesWritten = 0L;
        this.mBytesPerFrame = 0;
        this.mPlayoutLoopCounter = 0;
        this.mPlayPreviousUnderrun = 0;
        this.trackRouteListenerForAPI23 = null;
        this.trackRouteListener = null;
        threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioTrack = j;
        this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            this.trackRouteListenerForAPI23 = new AudioTrackRoutingListenerForAPI23();
        } else if (i > 23) {
            this.trackRouteListener = new AudioTrackRoutingListener();
        }
    }

    public static /* synthetic */ long access$914(WebRtcAudioTrack webRtcAudioTrack, long j) {
        long j2 = webRtcAudioTrack.mFramesWritten + j;
        webRtcAudioTrack.mFramesWritten = j2;
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
        if (this.audioTrack == null) {
            Logging.e(TAG, "audiotrack is null");
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (!this.audioTrack.getTimestamp(audioTimestamp)) {
                Logging.e(TAG, "audioTimestamp is unavailable");
                return -1;
            }
            int sampleRate = (int) (((audioTimestamp.nanoTime + (((((this.mFramesWritten - audioTimestamp.framePosition) * 1000) * 1000) * 1000) / this.audioTrack.getSampleRate())) - System.nanoTime()) / 1000000);
            int bufferSizeInFrames = (this.audioTrack.getBufferSizeInFrames() * 1000) / this.audioTrack.getSampleRate();
            if (sampleRate > 0 && sampleRate <= 400) {
                this.mPlayoutLatency = sampleRate + (bufferSizeInFrames > 20 ? bufferSizeInFrames / 2 : 10);
            }
        } else {
            this.mPlayoutLatency = 160;
        }
        return this.mPlayoutLatency;
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 4 : 12;
    }

    @TargetApi(21)
    private static AudioTrack createAudioTrackOnLollipopOrHigher(int i, int i2, int i3) {
        Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(0);
        Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate + ", enableLowlatencyPlayout " + enableLowlatencyPlayout);
        if (i != nativeOutputSampleRate) {
            Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
        if (usageAttribute != DEFAULT_USAGE) {
            Logging.w(TAG, "A non default usage attribute is used: " + usageAttribute);
        }
        if (!WebRtcAudioUtils.runningOnOreoOrHigher() || !enableLowlatencyPlayout) {
            return new AudioTrack(new AudioAttributes.Builder().setUsage(usageAttribute).setContentType(contentType).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(i).setChannelMask(i2).build(), i3, 1, 0);
        }
        return new AudioTrack.Builder().setPerformanceMode(enableLowlatencyPlayout ? 1 : 0).setAudioAttributes(new AudioAttributes.Builder().setUsage(usageAttribute).setContentType(contentType).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(i).setChannelMask(i2).build()).setBufferSizeInBytes(i3).build();
    }

    private static AudioTrack createAudioTrackOnLowerThanLollipop(int i, int i2, int i3) {
        return new AudioTrack(streamType, i, i2, 2, i3, 1);
    }

    private boolean enableLowlatencyPlayout(boolean z) {
        enableLowlatencyPlayout = z;
        return true;
    }

    private static int getDefaultUsageAttribute() {
        if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
            return getDefaultUsageAttributeOnLollipopOrHigher();
        }
        return 0;
    }

    @TargetApi(21)
    private static int getDefaultUsageAttributeOnLollipopOrHigher() {
        return 2;
    }

    private int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamMaxVolume");
        assertTrue(this.audioManager != null);
        return this.audioManager.getStreamMaxVolume(streamType);
    }

    private int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamVolume");
        assertTrue(this.audioManager != null);
        return this.audioManager.getStreamVolume(streamType);
    }

    @TargetApi(24)
    private int getUnderrunCount() {
        return WebRtcAudioUtils.runningOnNougatOrHigher() ? getUnderrunCountOnNougatOrHigher() : getUnderrunCountOnLowerThanNougat();
    }

    private int getUnderrunCountOnLowerThanNougat() {
        return -1;
    }

    @TargetApi(24)
    private int getUnderrunCountOnNougatOrHigher() {
        AudioTrack audioTrack;
        try {
            audioTrack = this.audioTrack;
        } catch (Exception e) {
            Logging.e(TAG, "getUnderrun fail ", e);
        }
        int underrunCount = (audioTrack == null || audioTrack.getPlayState() != 3) ? 0 : this.audioTrack.getUnderrunCount();
        int i = underrunCount - this.mPlayPreviousUnderrun;
        int i2 = i >= 0 ? i : 0;
        this.mPlayPreviousUnderrun = underrunCount;
        if (i2 > 0) {
            Logging.d(TAG, "Android AudioTrack underrun count: " + i2);
        }
        return i2;
    }

    private boolean initPlayout(int i, int i2, float f, boolean z) {
        AudioTrackRoutingListener audioTrackRoutingListener;
        AudioTrackRouteCallback audioTrackRouteCallback;
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initPlayout(sampleRate=" + i + ", channels=" + i2 + ", bufferSizeFactor=" + f + ", enableLowlatencyPlayout = " + enableLowlatencyPlayout + ", chatMode = " + z + ")");
        int i3 = i2 * 2;
        this.mBytesPerFrame = i3;
        this.byteBuffer = ByteBuffer.allocateDirect(i3 * (i / 100));
        StringBuilder sb = new StringBuilder();
        sb.append("byteBuffer.capacity: ");
        sb.append(this.byteBuffer.capacity());
        Logging.d(TAG, sb.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = (int) (((float) AudioTrack.getMinBufferSize(i, iChannelCountToConfiguration, 2)) * f);
        Logging.d(TAG, "minBufferSizeInBytes: " + minBufferSize);
        if (minBufferSize < this.byteBuffer.capacity()) {
            reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            return false;
        }
        if (this.audioTrack != null) {
            reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
            return false;
        }
        try {
            Logging.d(TAG, "initPlayout audio mode: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                initPlayoutParametersOnLollipopOrHigher(z);
                this.audioTrack = createAudioTrackOnLollipopOrHigher(i, iChannelCountToConfiguration, minBufferSize);
            } else {
                initPlayoutParametersOnLowerThanLollipop(z);
                this.audioTrack = createAudioTrackOnLowerThanLollipop(i, iChannelCountToConfiguration, minBufferSize);
            }
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack == null || audioTrack.getState() != 1) {
                reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                releaseAudioResources();
                return false;
            }
            logMainParameters();
            logMainParametersExtended();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 23 || !ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.output")) {
                Logging.d(TAG, "[USB] audioTrack has no PackageManager.FEATURE_AUDIO_OUTPUT");
            } else {
                AudioDeviceInfo preferredDevice = this.audioTrack.getPreferredDevice();
                if (preferredDevice != null) {
                    Logging.d(TAG, "[USB] audio track deviceType = " + preferredDevice.getType());
                } else {
                    Logging.d(TAG, "[USB] audioTrack has no preferred device");
                    preferredDevice = this.audioTrack.getRoutedDevice();
                    if (preferredDevice != null) {
                        Logging.d(TAG, "[USB] initPlayout-getRoutedDevice deviceType = " + preferredDevice.getType());
                    }
                }
                if (preferredDevice != null && (audioTrackRouteCallback = trackRouteCallback) != null) {
                    audioTrackRouteCallback.onAudioTrackRouteNotify(1, preferredDevice);
                }
            }
            if (i4 == 23) {
                AudioTrackRoutingListenerForAPI23 audioTrackRoutingListenerForAPI23 = this.trackRouteListenerForAPI23;
                if (audioTrackRoutingListenerForAPI23 != null) {
                    this.audioTrack.addOnRoutingChangedListener((AudioTrack.OnRoutingChangedListener) audioTrackRoutingListenerForAPI23, (Handler) null);
                }
            } else if (i4 > 23 && (audioTrackRoutingListener = this.trackRouteListener) != null) {
                this.audioTrack.addOnRoutingChangedListener(audioTrackRoutingListener, (Handler) null);
            }
            return true;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioTrackInitError(e.getMessage());
            releaseAudioResources();
            return false;
        }
    }

    @TargetApi(21)
    private void initPlayoutParametersOnLollipopOrHigher(boolean z) {
        if (z) {
            contentType = 1;
            setAudioTrackUsageAttribute(2);
        } else {
            contentType = 2;
            setAudioTrackUsageAttribute(1);
        }
    }

    private void initPlayoutParametersOnLowerThanLollipop(boolean z) {
        if (z) {
            streamType = 0;
        } else {
            streamType = 3;
        }
    }

    @SuppressLint({"NewApi"})
    private boolean isVolumeFixed() {
        if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
            return this.audioManager.isVolumeFixed();
        }
        return false;
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
    }

    @TargetApi(24)
    private void logMainParametersExtended() {
        if (WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
            Logging.d(TAG, "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
        }
        if (WebRtcAudioUtils.runningOnNougatOrHigher()) {
            Logging.d(TAG, "AudioTrack: buffer capacity in frames: " + this.audioTrack.getBufferCapacityInFrames());
        }
    }

    @TargetApi(24)
    private void logUnderrunCount() {
        if (WebRtcAudioUtils.runningOnNougatOrHigher()) {
            Logging.d(TAG, "underrun count: " + this.audioTrack.getUnderrunCount());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGetPlayoutData(int i, int i2, long j);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String str) {
        Logging.e(TAG, "Run-time playback error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackError(str);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackError(str);
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Logging.e(TAG, "Init playout error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackInitError(str);
        }
    }

    private void reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackStartError(str);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
        }
    }

    public static synchronized void setAudioTrackUsageAttribute(int i) {
        Logging.w(TAG, "Default usage attribute is changed from: " + DEFAULT_USAGE + " to " + i);
        usageAttribute = i;
    }

    @Deprecated
    public static void setErrorCallback(WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback) {
        Logging.d(TAG, "Set error callback (deprecated");
        errorCallbackOld = webRtcAudioTrackErrorCallback;
    }

    public static void setSpeakerMute(boolean z) {
        Logging.w(TAG, "setSpeakerMute(" + z + ")");
        speakerMute = z;
    }

    private boolean setStreamVolume(int i) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "setStreamVolume(" + i + ")");
        assertTrue(this.audioManager != null);
        if (isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(streamType, i, 0);
        return true;
    }

    public static void setTrackRouteCallback(AudioTrackRouteCallback audioTrackRouteCallback) {
        Logging.d(TAG, "[USB] Set AudioTrackRouteCallback");
        trackRouteCallback = audioTrackRouteCallback;
    }

    private boolean startPlayout() throws IllegalStateException {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "startPlayout");
        assertTrue(this.audioTrack != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioTrack.play();
            if (this.audioTrack.getPlayState() == 3) {
                this.mFramesWritten = 0L;
                AudioTrackThread audioTrackThread = new AudioTrackThread("AudioTrackJavaThread");
                this.audioThread = audioTrackThread;
                audioTrackThread.start();
                return true;
            }
            reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
            releaseAudioResources();
            return false;
        } catch (IllegalStateException e) {
            reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + e.getMessage());
            releaseAudioResources();
            return false;
        }
    }

    private boolean stopPlayout() {
        AudioTrackRoutingListener audioTrackRoutingListener;
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "stopPlayout");
        assertTrue(this.audioThread != null);
        logUnderrunCount();
        this.audioThread.stopThread();
        Logging.d(TAG, "Stopping the AudioTrackThread...");
        this.audioThread.interrupt();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
            Logging.e(TAG, "Join of AudioTrackThread timed out.");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        Logging.d(TAG, "AudioTrackThread has now been stopped.");
        this.audioThread = null;
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            AudioTrackRoutingListenerForAPI23 audioTrackRoutingListenerForAPI23 = this.trackRouteListenerForAPI23;
            if (audioTrackRoutingListenerForAPI23 != null) {
                this.audioTrack.removeOnRoutingChangedListener((AudioTrack.OnRoutingChangedListener) audioTrackRoutingListenerForAPI23);
            }
        } else if (i > 23 && (audioTrackRoutingListener = this.trackRouteListener) != null) {
            this.audioTrack.removeOnRoutingChangedListener(audioTrackRoutingListener);
        }
        releaseAudioResources();
        this.mPlayPreviousUnderrun = 0;
        return true;
    }

    public static void setErrorCallback(ErrorCallback errorCallback2) {
        Logging.d(TAG, "Set extended error callback");
        errorCallback = errorCallback2;
    }

    public class AudioTrackRoutingListenerForAPI23 implements AudioTrack.OnRoutingChangedListener {
        private AudioTrackRoutingListenerForAPI23() {
        }

        @Override // android.media.AudioTrack.OnRoutingChangedListener
        public void onRoutingChanged(AudioTrack audioTrack) {
            AudioDeviceInfo preferredDevice = audioTrack.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioTrack.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioTrack.trackRouteCallback != null) {
                WebRtcAudioTrack.trackRouteCallback.onAudioTrackRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioTrack.TAG, "[USB] [AudioTrack-audioTrack] onRoutingChanged: " + type);
        }

        @Override // android.media.AudioTrack.OnRoutingChangedListener, android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo preferredDevice = audioRouting.getPreferredDevice();
            int type = preferredDevice != null ? preferredDevice.getType() : -1;
            AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
            if (routedDevice != null && type == -1) {
                type = routedDevice.getType();
            }
            if (routedDevice != null && WebRtcAudioTrack.trackRouteCallback != null) {
                WebRtcAudioTrack.trackRouteCallback.onAudioTrackRouteNotify(1, routedDevice);
            }
            Logging.d(WebRtcAudioTrack.TAG, "[USB] [AudioTrack-audioRouting] onRoutingChanged: " + type);
        }
    }
}
