package io.agora.rtc2.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.ThreadUtils;
import io.agora.base.internal.voiceengine.WebRtcAudioRecord;
import io.agora.base.internal.voiceengine.WebRtcAudioTrack;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class AudioRoutingController {
    public static final int AUDIO_DEVICE_EVENT_FALLBACK_TO_A2DP = 4;
    private static final int BLUETOOTH_SCO_TIMEOUT_MS = 3000;
    private static final int BT_SCO_STATE_CONNECTED = 1;
    private static final int BT_SCO_STATE_CONNECTING = 0;
    private static final int BT_SCO_STATE_DISCONNECTED = 3;
    private static final int BT_SCO_STATE_DISCONNECTING = 2;
    public static final int CMD_FORCE_TO_A2DP = 16;
    public static final int CMD_FORCE_TO_SPEAKER = 11;
    public static final int CMD_MUTE_VIDEO_ALL = 14;
    public static final int CMD_MUTE_VIDEO_LOCAL = 12;
    public static final int CMD_MUTE_VIDEO_REMOTES = 13;
    public static final int CMD_SET_DEFAULT_ROUTING = 10;
    public static final int CMD_START_BT_SCO = 15;
    public static final int DEVICE_EVT_BT_OFF = 0;
    public static final int DEVICE_EVT_BT_RECONNECT = 1;
    public static final int DEVICE_OUTPUT_OUT_IP = 8388608;
    public static final int DEVICE_OUT_AUX_DIGITAL = 1024;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 128;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final int DEVICE_OUT_EARPIECE = 1;
    public static final int DEVICE_OUT_SPEAKER = 2;
    public static final int DEVICE_OUT_USB_DEVICE = 16384;
    public static final int DEVICE_OUT_USB_HEADSET = 67108864;
    public static final int DEVICE_OUT_WIRED_HEADPHONE = 8;
    public static final int DEVICE_OUT_WIRED_HEADSET = 4;
    private static final int ERROR = 4;
    private static final int EVT_BT_HEADSET = 2;
    private static final int EVT_BT_HEADSET_RECONNECT = 23;
    private static final int EVT_BT_SCO = 3;
    public static final int EVT_CHANNEL_PROFILE = 20;
    public static final int EVT_ENGINE_ROLE_CHANGED = 21;
    private static final int EVT_HDMI = 6;
    private static final int EVT_HEADSET = 1;
    public static final int EVT_PHONE_STATE_CHANGED = 22;
    private static final int EVT_USB = 4;
    private static final int EVT_USB_HEADSET = 5;
    private static final int MAX_SCO_CONNECT_ATTEMPS = 2;
    public static final int OFF = 0;
    public static final int ON = 1;
    private static final SparseIntArray ROUTE_TYPE_TO_EVT;
    private static final int START = 1;
    private static final int STOP = 2;
    private static final String TAG = "AudioRoute";
    private static final int UNINIT = 0;
    public static final int UNSET = -1;

    @Nullable
    private static AudioDeviceChangedSpecialMonitor deviceSpecialMonitor = null;
    private static boolean mockBlueToothEnable = false;
    private static AudioManager mockedAudioManager;
    private static MockedBroadcaseter mockedBroadcaster;
    private AudioDeviceInventory mAudioDeviceInventory;
    private final WeakReference<Context> mContext;
    private EventHandler mEventHandler;
    private long mNativeHandle;
    private int mScoConnectionAttemps;
    private ControllerState mState;
    private int mVersionInUsed;
    private boolean mIsWiredHeadsetPlugged = false;
    private int mHeadsetType = -1;
    private boolean mIsBTHeadsetPlugged = false;
    private int mCurrentRouting = -1;
    private int mDefaultRouting = 3;
    private int mForcedRouting = -1;
    private int mDefaultSystemRouting = -1;
    private int mChannelProfile = -1;
    private boolean mVideoDisabled = true;
    private boolean mMuteLocal = false;
    private boolean mMuteRemotes = false;
    private int mEngineRole = -1;
    private boolean mPhoneInCall = false;
    private int mSpeakerCommVolume = -1;
    private boolean mForceUseA2dp = true;
    private int mBtScoState = 3;
    private boolean mIsBTScoStarted = false;
    private int dynamic_timeout = 3000;
    private ControllerStopState mStopState = null;
    private ControllerStartState mStartState = null;
    private ControllerErrorState mErrorState = null;
    private final Runnable bluetoothTimeoutRunnable = new Runnable() { // from class: io.agora.rtc2.internal.AudioRoutingController.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                AudioRoutingController.this.bluetoothTimeout();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Nullable
    private ControllerAudioDeviceChangeCallback ctrlAudioDeviceCb = null;
    private boolean mDisposed = false;
    public AudioManagerScoStateReceiver mScoStateReceiver = null;

    @NonNull
    private final ThreadUtils.ThreadChecker mThreadChecker = new ThreadUtils.ThreadChecker();

    public interface AudioDeviceChangedCallback {
        void onAudioDeviceChanged(boolean z, int i);

        void onAudioDeviceEvent(int i);
    }

    public class AudioDeviceChangedCallbackImpl implements AudioDeviceChangedCallback {
        private AudioDeviceChangedCallbackImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r5v1, types: [io.agora.rtc2.internal.AudioRoutingController] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.StringBuilder] */
        @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceChangedCallback
        public void onAudioDeviceChanged(boolean z, int i) {
            String str;
            int i2 = AudioRoutingController.ROUTE_TYPE_TO_EVT.get(i);
            if (i2 == 0) {
                str = "not handle this route " + i + " yet!";
            } else {
                ?? r4 = z;
                if (i != 5) {
                    r4 = z ? i : -1;
                }
                AudioRoutingController.this.sendEvent(i2, r4);
                str = "route event: " + AudioRoutingController.this.evtAsString(i2) + " arg: " + r4;
            }
            Logging.i(AudioRoutingController.TAG, str);
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceChangedCallback
        public void onAudioDeviceEvent(int i) {
            if (i == 0) {
                AudioRoutingController.this.cancelTimer();
            } else if (i == 1) {
                AudioRoutingController.this.sendEvent(23, 0);
            }
        }
    }

    public interface AudioDeviceChangedSpecialMonitor {
        void AudioDeviceChangeCallback(boolean z, AudioDeviceInfo audioDeviceInfo);

        String GetUSBDevicePID(int i);

        String GetUSBDeviceVID(int i);

        int GetUSBRouteType();
    }

    public interface AudioDeviceInventory {
        void dispose();

        void initialize();

        boolean isDeviceAvaliable(int i);

        void setAudioDeviceChangeCallback(AudioDeviceChangedCallback audioDeviceChangedCallback);
    }

    public class AudioManagerScoStateReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private AudioManagerScoStateReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                Logging.i(AudioRoutingController.TAG, "BT ACTION_SCO_AUDIO_STATE_UPDATED prev " + intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -99) + "," + intExtra);
                if (intExtra == 0) {
                    Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state disconnected");
                    AudioRoutingController.this.sendEvent(3, 0);
                } else if (intExtra == 1) {
                    Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state connected");
                    AudioRoutingController.this.sendEvent(3, 1);
                } else {
                    Logging.i(AudioRoutingController.TAG, "Bluetooth SCO device unknown event, state=" + intExtra);
                }
            }
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }
    }

    public class ControllerAudioDeviceChangeCallback implements WebRtcAudioRecord.AudioRecordRouteCallback, WebRtcAudioTrack.AudioTrackRouteCallback {
        private ControllerAudioDeviceChangeCallback() {
        }

        @Override // io.agora.base.internal.voiceengine.WebRtcAudioRecord.AudioRecordRouteCallback
        public void onAudioRecordRouteNotify(int i, AudioDeviceInfo audioDeviceInfo) {
            Logging.i(AudioRoutingController.TAG, "[ADM] Enter ControllerAudioDeviceChangeCallback.onAudioRecordRouteNotify");
            if (AudioRoutingController.deviceSpecialMonitor != null) {
                AudioRoutingController.deviceSpecialMonitor.AudioDeviceChangeCallback(true, audioDeviceInfo);
                AudioRoutingController.this.nativeAudioDeviceStateChanged(Integer.toString(audioDeviceInfo.getId()), audioDeviceInfo.getProductName().toString(), 1, 1);
            }
        }

        @Override // io.agora.base.internal.voiceengine.WebRtcAudioTrack.AudioTrackRouteCallback
        public void onAudioTrackRouteNotify(int i, AudioDeviceInfo audioDeviceInfo) {
            Logging.i(AudioRoutingController.TAG, "[ADM] Enter ControllerAudioDeviceChangeCallback.onAudioTrackRouteNotify");
            if (AudioRoutingController.deviceSpecialMonitor != null) {
                AudioRoutingController.deviceSpecialMonitor.AudioDeviceChangeCallback(false, audioDeviceInfo);
                AudioRoutingController.this.sendEvent(4, AudioRoutingController.deviceSpecialMonitor.GetUSBRouteType());
            }
        }
    }

    public abstract class ControllerBaseState implements ControllerState {
        private ControllerBaseState() {
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public int getState() {
            return 0;
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void onEvent(int i, int i2) throws InterruptedException {
            if (i != 1) {
                if (i == 2) {
                    AudioRoutingController.this.mIsBTHeadsetPlugged = i2 == 1;
                    int iQueryCurrentAudioRouting = AudioRoutingController.this.mIsBTHeadsetPlugged ? 5 : AudioRoutingController.this.queryCurrentAudioRouting();
                    if (AudioRoutingController.mockBlueToothEnable) {
                        AudioRoutingController.this.mDefaultSystemRouting = iQueryCurrentAudioRouting;
                    }
                    AudioRoutingController.this.notifyAudioRoutingChanged(iQueryCurrentAudioRouting);
                    return;
                }
                if (i != 4 && i != 5 && i != 6) {
                    if (i == 10) {
                        AudioRoutingController.this.mDefaultRouting = i2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("User set default routing to:");
                        AudioRoutingController audioRoutingController = AudioRoutingController.this;
                        sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mDefaultRouting));
                        Logging.i(AudioRoutingController.TAG, sb.toString());
                        return;
                    }
                    if (i == 16) {
                        AudioRoutingController.this.mForceUseA2dp = i2 == 1;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("bluetooth protocol to: ");
                        sb2.append(AudioRoutingController.this.mForceUseA2dp ? "a2dp" : "hfp");
                        Logging.w(AudioRoutingController.TAG, sb2.toString());
                        AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                        audioRoutingController2.updateBluetoothSco(audioRoutingController2.mCurrentRouting);
                        return;
                    }
                    switch (i) {
                        case 12:
                            AudioRoutingController.this.mMuteLocal = i2 > 0;
                            break;
                        case 13:
                            AudioRoutingController.this.mMuteRemotes = i2 > 0;
                            break;
                        case 14:
                            AudioRoutingController.this.mVideoDisabled = i2 > 0;
                            break;
                        default:
                            switch (i) {
                                case 20:
                                    AudioRoutingController.this.mChannelProfile = i2;
                                    break;
                                case 21:
                                    AudioRoutingController.this.mEngineRole = i2;
                                    break;
                                case 22:
                                    AudioRoutingController.this.mPhoneInCall = i2 > 0;
                                    break;
                            }
                    }
                    return;
                }
                if (i2 != 6 && i2 != 7) {
                    i2 = AudioRoutingController.this.queryCurrentAudioRouting();
                }
            } else {
                AudioRoutingController.this.mHeadsetType = i2;
                AudioRoutingController.this.mIsWiredHeadsetPlugged = i2 >= 0;
                if (!AudioRoutingController.this.mIsWiredHeadsetPlugged) {
                    i2 = AudioRoutingController.this.queryCurrentAudioRouting();
                }
                if (AudioRoutingController.mockedBroadcaster != null) {
                    AudioRoutingController.this.mDefaultSystemRouting = i2;
                }
            }
            AudioRoutingController.this.notifyAudioRoutingChanged(i2);
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void reset() {
            AudioRoutingController.this.resetAudioRouting();
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void setState(int i) {
            if (i == getState()) {
                Logging.i(AudioRoutingController.TAG, "setState: state not changed!");
            } else {
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.mState = audioRoutingController.changeState(i);
            }
        }
    }

    public class ControllerErrorState extends ControllerBaseState {
        private ControllerErrorState() {
            super();
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public int getState() {
            return 4;
        }
    }

    public class ControllerStartState extends ControllerBaseState {
        public ControllerStartState() {
            super();
            resetImpl();
            Logging.i(AudioRoutingController.TAG, "Monitor start: default routing: " + AudioRoutingController.this.getAudioRouteDesc(AudioRoutingController.this.mDefaultRouting) + ", current routing: " + AudioRoutingController.this.getAudioRouteDesc(AudioRoutingController.this.mCurrentRouting));
        }

        private void resetImpl() {
            if (AudioRoutingController.this.mDefaultRouting == -1) {
                if (AudioRoutingController.this.mChannelProfile == 1) {
                    AudioRoutingController.this.mDefaultRouting = 3;
                } else {
                    AudioRoutingController.this.mDefaultRouting = 1;
                }
            }
            AudioRoutingController.this.mCurrentRouting = -1;
            AudioRoutingController.this.mForcedRouting = -1;
            if (!AudioRoutingController.mockBlueToothEnable && AudioRoutingController.mockedBroadcaster == null) {
                int currSystemRouting = AudioRoutingController.this.getCurrSystemRouting();
                AudioRoutingController.this.mDefaultSystemRouting = currSystemRouting != -1 ? currSystemRouting : 3;
            }
            AudioRoutingController.this.resetAudioRouting();
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public int getState() {
            return 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
        
            if (r7 != 7) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x014f, code lost:
        
            if (r5.this$0.mCurrentRouting != r7) goto L28;
         */
        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onEvent(int r6, int r7) throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 460
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.AudioRoutingController.ControllerStartState.onEvent(int, int):void");
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void reset() {
            resetImpl();
            StringBuilder sb = new StringBuilder();
            sb.append("Monitor reset: default routing: ");
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mDefaultRouting));
            sb.append(", current routing: ");
            AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
            sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mCurrentRouting));
            Logging.i(AudioRoutingController.TAG, sb.toString());
        }
    }

    public interface ControllerState {
        int getState();

        void onEvent(int i, int i2);

        void reset();

        void setState(int i);
    }

    public class ControllerStopState extends ControllerBaseState {
        public ControllerStopState() {
            super();
            Logging.i(AudioRoutingController.TAG, "Monitor stopped");
            resetImpl();
        }

        private void resetImpl() {
            AudioRoutingController.this.cancelTimer();
            AudioManager audioManager = AudioRoutingController.this.getAudioManager();
            if (AudioRoutingController.this.mIsBTScoStarted || (audioManager != null && audioManager.isBluetoothScoOn())) {
                AudioRoutingController.this.mIsBTScoStarted = false;
                AudioRoutingController.this.stopBtSco();
            }
            AudioRoutingController.this.mCurrentRouting = -1;
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public int getState() {
            return 2;
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void onEvent(int i, int i2) {
            Logging.d(AudioRoutingController.TAG, "StopState: onEvent: " + AudioRoutingController.this.evtAsString(i) + ", info: " + i2);
            try {
                AudioManager audioManager = AudioRoutingController.this.getAudioManager();
                if (i != 11) {
                    super.onEvent(i, i2);
                } else {
                    audioManager.setSpeakerphoneOn(i2 == 1);
                    AudioRoutingController.this.mCurrentRouting = i2 == 1 ? 3 : -1;
                    AudioRoutingController audioRoutingController = AudioRoutingController.this;
                    audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.queryCurrentAudioRouting());
                }
            } catch (Exception e) {
                Logging.e(AudioRoutingController.TAG, "onEvent: Exception ", e);
            }
        }

        @Override // io.agora.rtc2.internal.AudioRoutingController.ControllerBaseState, io.agora.rtc2.internal.AudioRoutingController.ControllerState
        public void reset() {
            Logging.i(AudioRoutingController.TAG, "Monitor stop state, reset");
            resetImpl();
        }
    }

    public class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (AudioRoutingController.this.mState != null) {
                AudioRoutingController.this.mState.onEvent(message.what, message.arg1);
            }
        }
    }

    public interface MockedBroadcaseter {
        void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

        void unRegisterReceiver(BroadcastReceiver broadcastReceiver);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ROUTE_TYPE_TO_EVT = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(2, 1);
        sparseIntArray.put(5, 2);
        sparseIntArray.put(6, 4);
        sparseIntArray.put(7, 6);
    }

    @CalledByNative
    public AudioRoutingController(Context context, long j) {
        this.mContext = new WeakReference<>(context);
        this.mNativeHandle = j;
        if (Build.VERSION.SDK_INT >= 31) {
            this.mVersionInUsed = 1;
        } else {
            this.mVersionInUsed = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bluetoothTimeout() throws InterruptedException {
        AudioManager audioManager = getAudioManager();
        boolean zIsBluetoothScoOn = audioManager != null ? audioManager.isBluetoothScoOn() : false;
        if (this.mScoConnectionAttemps >= 2) {
            Logging.e(TAG, "start bluetooth sco timeout, actual routing: " + queryCurrentAudioRouting());
            cancelTimer();
            nativeAudioRoutingError(1030);
            checkFallbackA2dpIfNeed();
            return;
        }
        Logging.w(TAG, "attemps trying, bt sco started: " + this.mIsBTScoStarted + " sco connected: " + zIsBluetoothScoOn + " " + this.mScoConnectionAttemps + " times " + this.mBtScoState + "[" + btStateAsString(this.mBtScoState) + "]");
        if (zIsBluetoothScoOn) {
            Logging.d(TAG, "soc connected");
            cancelTimer();
            return;
        }
        startTimer();
        this.mScoConnectionAttemps++;
        stopBtSco();
        audioManager.stopBluetoothSco();
        doStartBTSco(audioManager);
    }

    private String btStateAsString(int i) {
        if (i == 0) {
            return "SCO_CONNECTING";
        }
        if (i == 1) {
            return "SCO_CONNECTED";
        }
        if (i == 2) {
            return "SCO_DISCONNECTING";
        }
        if (i == 3) {
            return "SCO_DISCONNECTED";
        }
        return "Unknown " + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimer() {
        this.mScoConnectionAttemps = 0;
        Logging.d(TAG, "cancel bluetooth timer");
        this.mEventHandler.removeCallbacks(this.bluetoothTimeoutRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ControllerState changeState(int i) {
        if (i == 2) {
            ControllerStopState controllerStopState = this.mStopState;
            if (controllerStopState == null) {
                this.mStopState = new ControllerStopState();
            } else {
                controllerStopState.reset();
            }
            return this.mStopState;
        }
        if (i == 1) {
            ControllerStartState controllerStartState = this.mStartState;
            if (controllerStartState == null) {
                this.mStartState = new ControllerStartState();
            } else {
                controllerStartState.reset();
            }
            return this.mStartState;
        }
        ControllerErrorState controllerErrorState = this.mErrorState;
        if (controllerErrorState == null) {
            this.mErrorState = new ControllerErrorState();
        } else {
            controllerErrorState.reset();
        }
        return this.mErrorState;
    }

    private void checkFallbackA2dpIfNeed() {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null && this.mIsBTHeadsetPlugged && audioManager.isBluetoothA2dpOn()) {
            nativeAudioRoutingCallbackEvent(4);
            return;
        }
        Logging.i(TAG, "could not use a2dp also..");
        this.mIsBTHeadsetPlugged = false;
        resetAudioRouting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doSetAudioOutputRouting(int i) {
        Logging.i(TAG, "set audio output routing from " + getAudioRouteDesc(this.mCurrentRouting) + " to " + getAudioRouteDesc(i));
        try {
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                audioManager.setSpeakerphoneOn(i == 3);
            }
            if (queryCurrentAudioRouting() != i) {
                int iQueryCurrentAudioRouting = queryCurrentAudioRouting();
                Logging.i(TAG, "different audio routing from target " + i + ", actual routing: " + iQueryCurrentAudioRouting + "[" + getAudioRouteDesc(iQueryCurrentAudioRouting) + "]");
            }
            updateBluetoothSco(i);
        } catch (Exception e) {
            Logging.e(TAG, "set audio output routing failed:", e);
        }
        if (i == this.mCurrentRouting) {
            Logging.i(TAG, "audio routing not changed, ignore: " + i);
            return 0;
        }
        this.mCurrentRouting = i;
        notifyAudioRoutingChanged(i);
        Logging.i(TAG, "audio routing changed to " + getAudioRouteDesc(this.mCurrentRouting));
        return 0;
    }

    private void doStartBTSco(AudioManager audioManager) throws InterruptedException {
        try {
            int mode = audioManager.getMode();
            StringBuilder sb = new StringBuilder();
            sb.append("doStartBTSco ");
            int i = Build.VERSION.SDK_INT;
            sb.append(i);
            sb.append(" sco on: ");
            sb.append(audioManager.isBluetoothScoOn());
            sb.append(" ");
            sb.append(mode);
            sb.append("[");
            sb.append(modeAsString(mode));
            sb.append("]");
            Logging.i(TAG, sb.toString());
            if (i < 22) {
                audioManager.setStreamMute(0, true);
            } else {
                audioManager.setStreamVolume(0, 1, 0);
            }
            if (audioManager.isBluetoothScoOn()) {
                audioManager.stopBluetoothSco();
                Thread.sleep(600L);
                Logging.i(TAG, "doStartBTSco in sco already on, try stop old connect firstly!");
            }
            audioManager.startBluetoothSco();
        } catch (Exception e) {
            Logging.e(TAG, "doStartBTSco fail ", e);
        }
        Logging.d(TAG, "doStartBTSco done sco on: " + audioManager.isBluetoothScoOn() + " " + audioManager.getMode() + "[" + modeAsString(audioManager.getMode()) + "]");
    }

    private void doStopBTSco(AudioManager audioManager) {
        Logging.i(TAG, "doStopBTSco " + Build.VERSION.SDK_INT + " sco on: " + audioManager.isBluetoothScoOn());
        try {
            audioManager.stopBluetoothSco();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String evtAsString(int i) {
        if (i == 1) {
            return "EVT_HEADSET";
        }
        if (i == 2) {
            return "EVT_BT_HEADSET";
        }
        if (i == 3) {
            return "EVT_BT_SCO";
        }
        if (i == 4) {
            return "EVT_USB";
        }
        if (i == 10) {
            return "CMD_SET_DEFAULT_ROUTING";
        }
        if (i == 11) {
            return "CMD_FORCE_TO_SPEAKER";
        }
        if (i == 14) {
            return "CMD_MUTE_VIDEO_REMOTES";
        }
        if (i == 16) {
            return "CMD_FORCE_TO_A2DP";
        }
        if (i == 20) {
            return "EVT_CHANNEL_PROFILE";
        }
        if (i == 22) {
            return "EVT_PHONE_STATE_CHANGED";
        }
        return "evt " + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AudioManager getAudioManager() {
        AudioManager audioManager = mockedAudioManager;
        if (audioManager != null) {
            return audioManager;
        }
        Context context = this.mContext.get();
        if (context == null) {
            return null;
        }
        return (AudioManager) context.getSystemService("audio");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAudioRouteDesc(int i) {
        switch (i) {
            case -1:
                return "Default";
            case 0:
                return "Headset";
            case 1:
                return "Earpiece";
            case 2:
                return "HeadsetOnly";
            case 3:
                return "Speakerphone";
            case 4:
                return "Loudspeaker";
            case 5:
                return "HeadsetBluetooth";
            case 6:
                return "USBDevice";
            case 7:
            default:
                return "Unknown";
            case 8:
                return "USB_HEADSET";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getCurrSystemRouting() {
        /*
            r9 = this;
            java.lang.String r0 = "AudioRoute"
            android.media.AudioManager r1 = r9.getAudioManager()
            r2 = 3
            r3 = 0
            java.lang.Class<android.media.AudioManager> r4 = android.media.AudioManager.class
            java.lang.String r5 = "getDevicesForStream"
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L40
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L40
            r7[r3] = r8     // Catch: java.lang.Exception -> L40
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch: java.lang.Exception -> L40
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L40
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L40
            r5[r3] = r6     // Catch: java.lang.Exception -> L40
            java.lang.Object r1 = r4.invoke(r1, r5)     // Catch: java.lang.Exception -> L40
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Exception -> L40
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L40
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3e
            r4.<init>()     // Catch: java.lang.Exception -> L3e
            java.lang.String r5 = "System playout device: "
            r4.append(r5)     // Catch: java.lang.Exception -> L3e
            r4.append(r1)     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L3e
            io.agora.rtc2.internal.Logging.i(r0, r4)     // Catch: java.lang.Exception -> L3e
            goto L47
        L3e:
            r4 = move-exception
            goto L42
        L40:
            r4 = move-exception
            r1 = 0
        L42:
            java.lang.String r5 = "Error while getDevicesForStream! "
            io.agora.rtc2.internal.Logging.e(r0, r5, r4)
        L47:
            r0 = 6
            r4 = 2
            if (r1 == r4) goto L7b
            r2 = 4
            if (r1 == r2) goto L7a
            r2 = 8
            if (r1 == r2) goto L78
            r2 = 128(0x80, float:1.8E-43)
            if (r1 == r2) goto L76
            r2 = 256(0x100, float:3.59E-43)
            if (r1 == r2) goto L76
            r2 = 512(0x200, float:7.17E-43)
            if (r1 == r2) goto L76
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 == r2) goto L74
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r1 == r2) goto L72
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            if (r1 == r2) goto L72
            r2 = 8388608(0x800000, float:1.1754944E-38)
            r1 = r1 & r2
            if (r1 == 0) goto L70
            goto L72
        L70:
            r2 = -1
            goto L7b
        L72:
            r2 = 6
            goto L7b
        L74:
            r2 = 7
            goto L7b
        L76:
            r2 = 5
            goto L7b
        L78:
            r2 = 2
            goto L7b
        L7a:
            r2 = 0
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.AudioRoutingController.getCurrSystemRouting():int");
    }

    private boolean isAudioOnly() {
        return this.mVideoDisabled || (this.mMuteLocal && this.mMuteRemotes);
    }

    private String modeAsString(int i) {
        if (i == 0) {
            return "MODE_NORMAL";
        }
        if (i == 1) {
            return "MODE_RINGTONE";
        }
        if (i == 2) {
            return "MODE_IN_CALL";
        }
        if (i == 3) {
            return "MODE_IN_COMMUNICATION";
        }
        return "Unknown " + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeAudioDeviceStateChanged(String str, String str2, int i, int i2);

    private native void nativeAudioRoutingCallbackEvent(int i);

    private native void nativeAudioRoutingChanged(int i);

    private native void nativeAudioRoutingError(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioRoutingChanged(int i) {
        Logging.i(TAG, "Enter notifyAudioRoutingChanged: " + i);
        if (this.mDisposed) {
            Logging.w(TAG, "notifyAudioRoutingChanged returned cause of disposed");
        } else {
            nativeAudioRoutingChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[PHI: r0
  0x001c: PHI (r0v9 int) = (r0v2 int), (r0v6 int), (r0v6 int) binds: [B:13:0x001a, B:24:0x003d, B:25:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resetAudioRouting() {
        /*
            r3 = this;
            boolean r0 = r3.mIsBTHeadsetPlugged
            r1 = 6
            if (r0 == 0) goto Lc
            boolean r2 = r3.mIsWiredHeadsetPlugged
            if (r2 == 0) goto Lc
            int r1 = r3.mDefaultSystemRouting
            goto L44
        Lc:
            if (r0 == 0) goto L10
            r1 = 5
            goto L44
        L10:
            boolean r0 = r3.mIsWiredHeadsetPlugged
            if (r0 == 0) goto L17
            int r1 = r3.mHeadsetType
            goto L44
        L17:
            int r0 = r3.mForcedRouting
            r2 = -1
            if (r0 == r2) goto L1e
        L1c:
            r1 = r0
            goto L44
        L1e:
            io.agora.rtc2.internal.AudioRoutingController$AudioDeviceChangedSpecialMonitor r0 = io.agora.rtc2.internal.AudioRoutingController.deviceSpecialMonitor
            if (r0 == 0) goto L2f
            int r0 = r0.GetUSBRouteType()
            if (r0 == r2) goto L2f
            io.agora.rtc2.internal.AudioRoutingController$AudioDeviceChangedSpecialMonitor r0 = io.agora.rtc2.internal.AudioRoutingController.deviceSpecialMonitor
            int r1 = r0.GetUSBRouteType()
            goto L44
        L2f:
            io.agora.rtc2.internal.AudioRoutingController$AudioDeviceInventory r0 = r3.mAudioDeviceInventory
            boolean r0 = r0.isDeviceAvaliable(r1)
            if (r0 == 0) goto L38
            goto L44
        L38:
            int r0 = r3.getCurrSystemRouting()
            r2 = 7
            if (r0 == r2) goto L1c
            if (r0 != r1) goto L42
            goto L1c
        L42:
            int r1 = r3.mDefaultRouting
        L44:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "reset audio routing, default routing: "
            r0.append(r2)
            int r2 = r3.mDefaultRouting
            java.lang.String r2 = r3.getAudioRouteDesc(r2)
            r0.append(r2)
            java.lang.String r2 = ", current routing: "
            r0.append(r2)
            int r2 = r3.mCurrentRouting
            java.lang.String r2 = r3.getAudioRouteDesc(r2)
            r0.append(r2)
            java.lang.String r2 = ", target routing: "
            r0.append(r2)
            java.lang.String r2 = r3.getAudioRouteDesc(r1)
            r0.append(r2)
            java.lang.String r2 = ", actual system routing: "
            r0.append(r2)
            int r2 = r3.queryCurrentAudioRouting()
            java.lang.String r2 = r3.getAudioRouteDesc(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "AudioRoute"
            io.agora.rtc2.internal.Logging.i(r2, r0)
            int r0 = r3.mCurrentRouting
            if (r0 != r1) goto L96
            int r0 = r3.queryCurrentAudioRouting()
            int r2 = r3.mCurrentRouting
            if (r0 == r2) goto L99
        L96:
            r3.doSetAudioOutputRouting(r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.AudioRoutingController.resetAudioRouting():void");
    }

    public static void setAudioDeviceChangedSpecialMonitor(AudioDeviceChangedSpecialMonitor audioDeviceChangedSpecialMonitor) {
        Logging.i(TAG, "setAudioDeviceChangedSpecialMonitor");
        deviceSpecialMonitor = audioDeviceChangedSpecialMonitor;
    }

    @VisibleForTesting
    public static void setMockBlueToothEnable(boolean z) {
        mockBlueToothEnable = z;
    }

    @VisibleForTesting
    public static void setMockedAudioManager(AudioManager audioManager) {
        mockedAudioManager = audioManager;
    }

    @VisibleForTesting
    public static void setMockedBroadcaster(MockedBroadcaseter mockedBroadcaseter) {
        mockedBroadcaster = mockedBroadcaseter;
        AudioDeviceInventoryLowerThanM.setMockedBroadcaster(mockedBroadcaseter);
    }

    private void setupHotPlugDeviceInitValue() {
        int i = 6;
        if (this.mIsBTHeadsetPlugged) {
            i = 5;
        } else if (this.mIsWiredHeadsetPlugged) {
            i = this.mHeadsetType;
        } else if (!this.mAudioDeviceInventory.isDeviceAvaliable(6)) {
            i = -1;
        }
        if (i != -1) {
            notifyAudioRoutingChanged(i);
        }
    }

    private void startBtSco() throws InterruptedException {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            int mode = audioManager.getMode();
            Logging.i(TAG, "try to opening bt sco " + this.mScoConnectionAttemps + " " + mode + "[" + modeAsString(mode) + "] " + this.mBtScoState + "[" + btStateAsString(this.mBtScoState) + "] sco on: " + audioManager.isBluetoothScoOn());
            StringBuilder sb = new StringBuilder();
            sb.append("Off call sco support = ");
            sb.append(audioManager.isBluetoothScoAvailableOffCall());
            Logging.d(TAG, sb.toString());
            this.mBtScoState = 0;
            doStartBTSco(audioManager);
        }
    }

    private void startTimer() {
        this.dynamic_timeout += this.mScoConnectionAttemps * 3000;
        Logging.w(TAG, "start bluetooth timer " + this.dynamic_timeout);
        this.mEventHandler.postDelayed(this.bluetoothTimeoutRunnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopBtSco() {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            int mode = audioManager.getMode();
            Logging.i(TAG, "try to stopping bt sco " + mode + "[" + modeAsString(mode) + "] " + this.mBtScoState + "[" + btStateAsString(this.mBtScoState) + "] sco on: " + audioManager.isBluetoothScoOn());
            this.mBtScoState = !audioManager.isBluetoothScoOn() ? 3 : 2;
            doStopBTSco(audioManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateBluetoothSco(int i) throws InterruptedException {
        if (this.mPhoneInCall) {
            Logging.d(TAG, "not process updateBluetoothSco in call");
            return 0;
        }
        Logging.d(TAG, "updateBluetoothSco sco started: " + this.mIsBTScoStarted + ", audio route target: " + i + "[" + getAudioRouteDesc(i) + "] current: " + this.mCurrentRouting + "[" + getAudioRouteDesc(this.mCurrentRouting) + "], engine role: " + this.mEngineRole);
        if (i == 5) {
            if (!this.mForceUseA2dp) {
                Logging.w(TAG, "enable hfp");
                this.mIsBTScoStarted = true;
                startTimer();
                startBtSco();
            } else if (this.mIsBTScoStarted) {
                Logging.w(TAG, "enable a2dp");
                this.mIsBTScoStarted = false;
                cancelTimer();
                stopBtSco();
            }
        } else if (this.mCurrentRouting == 5 && this.mIsBTScoStarted) {
            this.mIsBTScoStarted = false;
            cancelTimer();
            stopBtSco();
        }
        return 0;
    }

    @CalledByNative
    public boolean checkVersion(int i) {
        int i2 = this.mVersionInUsed;
        boolean z = true;
        if ((i2 == 0 && i == 1 && Build.VERSION.SDK_INT >= 23) || (i2 == 1 && i == 0)) {
            this.mVersionInUsed = i;
        } else {
            z = false;
        }
        if (z) {
            dispose();
            initialize();
        }
        return z;
    }

    @CalledByNative
    public void dispose() {
        this.mThreadChecker.checkIsOnValidThread();
        if (this.mDisposed) {
            return;
        }
        this.mDisposed = true;
        this.mNativeHandle = 0L;
        AudioDeviceInventory audioDeviceInventory = this.mAudioDeviceInventory;
        if (audioDeviceInventory != null) {
            audioDeviceInventory.dispose();
        }
        AudioManagerScoStateReceiver audioManagerScoStateReceiver = this.mScoStateReceiver;
        if (audioManagerScoStateReceiver != null && audioManagerScoStateReceiver.getRegistered()) {
            MockedBroadcaseter mockedBroadcaseter = mockedBroadcaster;
            if (mockedBroadcaseter != null) {
                mockedBroadcaseter.unRegisterReceiver(this.mScoStateReceiver);
            }
            Context context = this.mContext.get();
            if (context != null) {
                context.unregisterReceiver(this.mScoStateReceiver);
            }
            this.mScoStateReceiver.setRegistered(false);
        }
        this.mEventHandler.getLooper().quit();
        Logging.d(TAG, "dispose");
    }

    @CalledByNative
    public String getCurrentUsbAudioDevicePID(int i) {
        AudioDeviceChangedSpecialMonitor audioDeviceChangedSpecialMonitor = deviceSpecialMonitor;
        String strGetUSBDevicePID = audioDeviceChangedSpecialMonitor != null ? audioDeviceChangedSpecialMonitor.GetUSBDevicePID(i) : null;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = strGetUSBDevicePID == null ? "null" : strGetUSBDevicePID;
        Logging.d(TAG, String.format("getPIDFromNative: mic_or_spk=%d, pid=%s", objArr));
        return strGetUSBDevicePID;
    }

    @CalledByNative
    public String getCurrentUsbAudioDeviceVID(int i) {
        AudioDeviceChangedSpecialMonitor audioDeviceChangedSpecialMonitor = deviceSpecialMonitor;
        String strGetUSBDeviceVID = audioDeviceChangedSpecialMonitor != null ? audioDeviceChangedSpecialMonitor.GetUSBDeviceVID(i) : null;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = strGetUSBDeviceVID == null ? "null" : strGetUSBDeviceVID;
        Logging.d(TAG, String.format("getVIDFromNative: mic_or_spk=%d, vid=%s", objArr));
        return strGetUSBDeviceVID;
    }

    @CalledByNative
    public long getNativeHandle() {
        this.mThreadChecker.checkIsOnValidThread();
        return this.mNativeHandle;
    }

    @CalledByNative
    public int initialize() {
        String str;
        Logging.i(TAG, "initialize +");
        Context context = this.mContext.get();
        if (context == null) {
            str = "context has been GCed";
        } else {
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                ControllerAudioDeviceChangeCallback controllerAudioDeviceChangeCallback = new ControllerAudioDeviceChangeCallback();
                this.ctrlAudioDeviceCb = controllerAudioDeviceChangeCallback;
                WebRtcAudioRecord.setRecordRouteCallback(controllerAudioDeviceChangeCallback);
                WebRtcAudioTrack.setTrackRouteCallback(this.ctrlAudioDeviceCb);
                HandlerThread handlerThread = new HandlerThread(TAG);
                handlerThread.start();
                this.mEventHandler = new EventHandler(handlerThread.getLooper());
                this.mAudioDeviceInventory = (this.mVersionInUsed != 1 || Build.VERSION.SDK_INT < 23) ? new AudioDeviceInventoryLowerThanM(context) : new AudioDeviceInventoryMorHigher(context);
                this.mAudioDeviceInventory.setAudioDeviceChangeCallback(new AudioDeviceChangedCallbackImpl());
                this.mAudioDeviceInventory.initialize();
                if (mockedBroadcaster != null) {
                    boolean zIsWiredHeadsetOn = audioManager.isWiredHeadsetOn();
                    this.mIsWiredHeadsetPlugged = zIsWiredHeadsetOn;
                    this.mHeadsetType = zIsWiredHeadsetOn ? 0 : -1;
                }
                if (this.mAudioDeviceInventory.isDeviceAvaliable(0)) {
                    this.mIsWiredHeadsetPlugged = true;
                    this.mHeadsetType = 0;
                } else if (this.mAudioDeviceInventory.isDeviceAvaliable(2)) {
                    this.mIsWiredHeadsetPlugged = true;
                    this.mHeadsetType = 2;
                }
                Logging.i(TAG, "Headset setup: Plugged = " + this.mIsWiredHeadsetPlugged + " mHeadsetType " + this.mHeadsetType);
                this.mIsBTHeadsetPlugged = this.mAudioDeviceInventory.isDeviceAvaliable(5);
                StringBuilder sb = new StringBuilder();
                sb.append("BT Headset setup: Plugged = ");
                sb.append(this.mIsBTHeadsetPlugged);
                Logging.i(TAG, sb.toString());
                this.mBtScoState = audioManager.isBluetoothScoOn() ? 1 : 3;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initial Bluetooth SCO state ");
                sb2.append(this.mBtScoState == 1 ? " enable " : " disable");
                Logging.i(TAG, sb2.toString());
                this.mScoStateReceiver = new AudioManagerScoStateReceiver();
                IntentFilter intentFilter = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                context.registerReceiver(this.mScoStateReceiver, intentFilter);
                MockedBroadcaseter mockedBroadcaseter = mockedBroadcaster;
                if (mockedBroadcaseter != null) {
                    mockedBroadcaseter.registerReceiver(this.mScoStateReceiver, intentFilter);
                }
                this.mScoStateReceiver.setRegistered(true);
                this.mDisposed = false;
                this.mState = changeState(2);
                setupHotPlugDeviceInitValue();
                Logging.i(TAG, "initialize -");
                return 0;
            }
            str = "invalid context: can't get AudioManager";
        }
        Logging.e(TAG, str);
        return -1;
    }

    @CalledByNative
    public int queryCurrentAudioRouting() {
        AudioManager audioManager = getAudioManager();
        try {
            if (audioManager.isSpeakerphoneOn()) {
                return 3;
            }
            if (!audioManager.isBluetoothScoOn() && !audioManager.isBluetoothA2dpOn()) {
                if (audioManager.isWiredHeadsetOn()) {
                    return 0;
                }
                int currSystemRouting = getCurrSystemRouting();
                if (currSystemRouting == 7 || currSystemRouting == 6) {
                    return currSystemRouting;
                }
                return 1;
            }
            return 5;
        } catch (Exception e) {
            Logging.e(TAG, "fatal error @queryCurrentAudioRouting", e);
            return -1;
        }
    }

    @CalledByNative
    public void sendEvent(int i, int i2) {
        Logging.d(TAG, "sendEvent: [" + i + "], extra arg: " + i2 + "... " + this.mEventHandler);
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            this.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, 0));
        }
    }

    @CalledByNative
    public int startMonitoring() {
        Logging.d(TAG, "startMonitoring()");
        this.mEventHandler.post(new Runnable() { // from class: io.agora.rtc2.internal.AudioRoutingController.2
            @Override // java.lang.Runnable
            public void run() {
                AudioRoutingController.this.mState.setState(1);
            }
        });
        if (this.mIsBTHeadsetPlugged) {
            return 5;
        }
        return this.mIsWiredHeadsetPlugged ? this.mHeadsetType : this.mDefaultRouting;
    }

    @CalledByNative
    public void stopMonitoring() {
        Logging.d(TAG, "stopMonitoring()");
        this.mEventHandler.post(new Runnable() { // from class: io.agora.rtc2.internal.AudioRoutingController.3
            @Override // java.lang.Runnable
            public void run() {
                AudioRoutingController.this.mState.setState(2);
            }
        });
    }
}
