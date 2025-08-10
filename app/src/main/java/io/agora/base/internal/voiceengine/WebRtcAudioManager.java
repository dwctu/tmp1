package io.agora.base.internal.voiceengine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTrack;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.agora.base.internal.ContextUtils;
import io.agora.base.internal.Logging;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class WebRtcAudioManager {
    private static final int BITS_PER_SAMPLE = 16;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final String TAG = "WebRtcAudioManager";
    private static final boolean blacklistDeviceForAAudioUsage = true;
    private static boolean blacklistDeviceForOpenSLESUsage = false;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden = false;
    private static AudioManager mockedAudioManager = null;
    private static boolean useStereoInput = false;
    private static boolean useStereoOutput = true;
    private boolean aAudio;
    private final AudioManager audioManager;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private int inputBufferSize;
    private int inputChannels;
    private boolean lowLatencyInput;
    private boolean lowLatencyOutput;
    private int mBufferPeriodMs;
    private final long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int outputChannels;
    private boolean proAudio;
    private int sampleRate;
    private boolean initialized = false;

    @Nullable
    private VolumeChangeReceiver mVolumeChangeReceiver = null;
    private int playoutVolume = 0;

    public static class VolumeChangeReceiver extends BroadcastReceiver {
        private WeakReference<WebRtcAudioManager> mWebRtcAudioManager;

        public VolumeChangeReceiver(WebRtcAudioManager webRtcAudioManager) {
            this.mWebRtcAudioManager = new WeakReference<>(webRtcAudioManager);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WebRtcAudioManager webRtcAudioManager = this.mWebRtcAudioManager.get();
            if (webRtcAudioManager == null) {
                return;
            }
            int streamType = webRtcAudioManager.getStreamType();
            webRtcAudioManager.notifyPlayoutVolumeChange(webRtcAudioManager.audioManager.getStreamVolume(streamType), streamType);
        }
    }

    public static class VolumeLogger {
        private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
        private static final int TIMER_PERIOD_IN_SECONDS = 30;
        private final AudioManager audioManager;

        @Nullable
        private Timer timer;

        public class LogVolumeTask extends TimerTask {
            private final int maxRingVolume;
            private final int maxVoiceCallVolume;

            public LogVolumeTask(int i, int i2) {
                this.maxRingVolume = i;
                this.maxVoiceCallVolume = i2;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int mode = VolumeLogger.this.audioManager.getMode();
                if (mode == 1) {
                    Logging.d(WebRtcAudioManager.TAG, "STREAM_RING stream volume: " + VolumeLogger.this.audioManager.getStreamVolume(2) + " (max=" + this.maxRingVolume + ")");
                    return;
                }
                if (mode == 3) {
                    Logging.d(WebRtcAudioManager.TAG, "VOICE_CALL stream volume: " + VolumeLogger.this.audioManager.getStreamVolume(0) + " (max=" + this.maxVoiceCallVolume + ")");
                }
            }
        }

        public VolumeLogger(AudioManager audioManager) {
            this.audioManager = audioManager;
        }

        private void stop() {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
        }

        public void start() {
            Timer timer = new Timer(THREAD_NAME);
            this.timer = timer;
            timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
        }
    }

    public WebRtcAudioManager(long j, int i) {
        this.mBufferPeriodMs = 10;
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioManager = j;
        this.mBufferPeriodMs = i;
        Logging.w(TAG, "bufferPeriodMs is: " + this.mBufferPeriodMs);
        AudioManager audioManager = mockedAudioManager;
        if (audioManager != null) {
            this.audioManager = audioManager;
        } else {
            this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        }
        storeAudioParameters();
        nativeCacheAudioParameters(this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, i, j);
        WebRtcAudioUtils.logAudioState(TAG);
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean checkRecordingOcccupiedInfo(int i) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && Build.VERSION.SDK_INT >= 24) {
            Iterator<AudioRecordingConfiguration> it = audioManager.getActiveRecordingConfigurations().iterator();
            while (it.hasNext()) {
                if (it.next().getClientAudioSessionId() != i) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRecordingPermission() {
        Context applicationContext = ContextUtils.getApplicationContext();
        return applicationContext == null || Build.VERSION.SDK_INT < 23 || applicationContext.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
    }

    private void dispose() {
        Logging.d(TAG, "dispose" + WebRtcAudioUtils.getThreadInfo());
        if (!this.initialized) {
        }
    }

    private boolean enableChatMode(boolean z) {
        assertTrue(this.audioManager != null);
        int i = z ? 3 : 0;
        try {
            Logging.d(TAG, "set audio mode to: " + WebRtcAudioUtils.modeToString(i) + " curr: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            this.audioManager.setMode(i);
        } catch (Exception e) {
            Logging.e(TAG, "audioManager.setMode failed: " + e.getMessage());
        }
        return true;
    }

    private int getBufferSizeByPeriod(int i, int i2) {
        return (i / 1000) * i2;
    }

    private int getCallState() {
        if (mockedAudioManager == null) {
            return (this.audioManager.getMode() == 2 || this.audioManager.getMode() == 1) ? 2 : 0;
        }
        Logging.d(TAG, "mock call state: " + mockedAudioManager.getRingerMode());
        return mockedAudioManager.getRingerMode();
    }

    private boolean getChatMode() {
        assertTrue(this.audioManager != null);
        int mode = this.audioManager.getMode();
        Logging.d(TAG, "current audio mode: " + WebRtcAudioUtils.modeToString(mode));
        return mode == 3;
    }

    private int getCurrentPlayoutDevices() {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) AudioManager.class.getMethod("getDevicesForStream", Integer.TYPE).invoke(this.audioManager, Integer.valueOf(getStreamType()))).intValue();
            Logging.d(TAG, "get current playout devices: " + iIntValue);
            return iIntValue;
        } catch (Exception e) {
            Logging.e(TAG, "Error getDevicesForStream! ", e);
            return iIntValue;
        }
    }

    private int getLowLatencyInputFramesPerBuffer() {
        assertTrue(isLowLatencyInputSupported());
        return getLowLatencyOutputFramesPerBuffer();
    }

    @TargetApi(17)
    private int getLowLatencyOutputFramesPerBuffer() {
        String property;
        assertTrue(isLowLatencyOutputSupported());
        if (WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher() && (property = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
            return Integer.parseInt(property);
        }
        return 256;
    }

    private static int getMinInputFrameSize(int i, int i2) {
        return AudioRecord.getMinBufferSize(i, i2 == 1 ? 16 : 12, 2) / (i2 * 2);
    }

    private static int getMinOutputFrameSize(int i, int i2) {
        return AudioTrack.getMinBufferSize(i, i2 == 1 ? 4 : 12, 2) / (i2 * 2);
    }

    private int getNativeOutputSampleRate() {
        if (WebRtcAudioUtils.runningOnEmulator()) {
            Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        if (WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
            Logging.d(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        int sampleRateOnJellyBeanMR10OrHigher = WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher() ? getSampleRateOnJellyBeanMR10OrHigher() : WebRtcAudioUtils.getDefaultSampleRateHz();
        Logging.d(TAG, "Sample rate is set to " + sampleRateOnJellyBeanMR10OrHigher + " Hz");
        return sampleRateOnJellyBeanMR10OrHigher;
    }

    @TargetApi(17)
    private int getSampleRateOnJellyBeanMR10OrHigher() {
        String property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        return property == null ? WebRtcAudioUtils.getDefaultSampleRateHz() : Integer.parseInt(property);
    }

    public static synchronized boolean getStereoInput() {
        return useStereoInput;
    }

    public static synchronized boolean getStereoOutput() {
        return useStereoOutput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStreamType() {
        int mode = this.audioManager.getMode();
        int i = 3;
        if (mode == 3) {
            i = 0;
        } else if (mode != 0) {
            Logging.w(TAG, "invalid audio mode");
            i = 0;
        }
        Logging.d(TAG, "get stream type is " + i);
        return i;
    }

    private boolean hasEarpiece() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private boolean init() {
        Logging.d(TAG, "init" + WebRtcAudioUtils.getThreadInfo());
        if (this.initialized) {
            return true;
        }
        Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        this.initialized = true;
        return true;
    }

    private boolean isAAudioSupported() {
        Logging.w(TAG, "AAudio support is currently disabled on all devices!");
        return false;
    }

    private static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private boolean isCommunicationModeEnabled() {
        return this.audioManager.getMode() == 3;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        boolean zDeviceIsBlacklistedForOpenSLESUsage = blacklistDeviceForOpenSLESUsageIsOverridden ? blacklistDeviceForOpenSLESUsage : WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        if (zDeviceIsBlacklistedForOpenSLESUsage) {
            Logging.d(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
        }
        return zDeviceIsBlacklistedForOpenSLESUsage;
    }

    private boolean isLowLatencyOutputSupported() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    @TargetApi(23)
    private boolean isProAudioSupported() {
        return WebRtcAudioUtils.runningOnMarshmallowOrHigher() && ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro");
    }

    @SuppressLint({"NewApi"})
    private boolean isVolumeFixed() {
        if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
            return this.audioManager.isVolumeFixed();
        }
        return false;
    }

    private boolean monitorPlayoutVolumeChange(boolean z) {
        Logging.d(TAG, "monitorPlayoutVolumeChange monitor: " + z);
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext != null && mockedAudioManager == null) {
            if (z) {
                int streamType = getStreamType();
                notifyPlayoutVolumeChange(this.audioManager.getStreamVolume(streamType), streamType);
                if (this.mVolumeChangeReceiver == null) {
                    try {
                        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver(this);
                        this.mVolumeChangeReceiver = volumeChangeReceiver;
                        if (volumeChangeReceiver == null) {
                            return false;
                        }
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(io.agora.rtc2.internal.VolumeChangeReceiver.ACTION_VOLUME_CHANGED);
                        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                        applicationContext.registerReceiver(this.mVolumeChangeReceiver, intentFilter);
                        return true;
                    } catch (Exception e) {
                        Logging.e(TAG, "Unable to create VolumeChangeReceiver, ", e);
                    }
                }
                return false;
            }
            try {
                VolumeChangeReceiver volumeChangeReceiver2 = this.mVolumeChangeReceiver;
                if (volumeChangeReceiver2 != null) {
                    applicationContext.unregisterReceiver(volumeChangeReceiver2);
                    this.mVolumeChangeReceiver = null;
                }
                return true;
            } catch (Exception e2) {
                Logging.e(TAG, "unregister VolumeChangeReceiver failed ", e2);
            }
        }
        return false;
    }

    private native void nativeCacheAudioParameters(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, int i5, int i6, long j);

    private native void nativeNotifyPlayoutVolumeChange(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPlayoutVolumeChange(int i, int i2) {
        if (this.playoutVolume == i || this.mVolumeChangeReceiver == null) {
            return;
        }
        this.playoutVolume = i;
        int streamMaxVolume = this.audioManager.getStreamMaxVolume(i2);
        if (streamMaxVolume != 0) {
            i = (int) ((i / streamMaxVolume) * 255.0f);
        }
        nativeNotifyPlayoutVolumeChange(i, this.nativeAudioManager);
        Logging.d(TAG, "notifyPlayoutVolumeChange: " + i);
    }

    private int notifyRecordingStatus(int i) {
        int clientAudioSessionId = -1;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        if (i > 0) {
            Iterator<AudioRecordingConfiguration> it = this.audioManager.getActiveRecordingConfigurations().iterator();
            while (it.hasNext()) {
                clientAudioSessionId = it.next().getClientAudioSessionId();
            }
        }
        return clientAudioSessionId;
    }

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean z) {
        blacklistDeviceForOpenSLESUsageIsOverridden = true;
        blacklistDeviceForOpenSLESUsage = z;
    }

    @VisibleForTesting
    public static void setMockedAudioManager(AudioManager audioManager) {
        mockedAudioManager = audioManager;
    }

    public static synchronized void setStereoInput(boolean z) {
        Logging.w(TAG, "Overriding default input behavior: setStereoInput(" + z + ')');
        useStereoInput = z;
    }

    public static synchronized void setStereoOutput(boolean z) {
        Logging.w(TAG, "Overriding default output behavior: setStereoOutput(" + z + ')');
        useStereoOutput = z;
    }

    private boolean setStreamVolume(int i) {
        Logging.d(TAG, "setStreamVolume(" + i + ")");
        assertTrue(this.audioManager != null);
        if (isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(getStreamType(), i, 0);
        return true;
    }

    private void storeAudioParameters() {
        this.outputChannels = getStereoOutput() ? 2 : 1;
        this.inputChannels = getStereoInput() ? 2 : 1;
        this.sampleRate = getNativeOutputSampleRate();
        this.hardwareAEC = isAcousticEchoCancelerSupported();
        this.hardwareAGC = false;
        this.hardwareNS = isNoiseSuppressorSupported();
        this.lowLatencyOutput = isLowLatencyOutputSupported();
        this.lowLatencyInput = isLowLatencyInputSupported();
        this.proAudio = isProAudioSupported();
        this.aAudio = isAAudioSupported();
        this.outputBufferSize = getBufferSizeByPeriod(this.sampleRate, this.mBufferPeriodMs);
        this.inputBufferSize = getBufferSizeByPeriod(this.sampleRate, this.mBufferPeriodMs);
    }

    public boolean isLowLatencyInputSupported() {
        return WebRtcAudioUtils.runningOnLollipopOrHigher() && isLowLatencyOutputSupported();
    }
}
