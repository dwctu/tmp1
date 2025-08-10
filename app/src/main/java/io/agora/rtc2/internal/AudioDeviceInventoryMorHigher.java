package io.agora.rtc2.internal;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.HashMap;

@RequiresApi(api = 23)
/* loaded from: classes4.dex */
public class AudioDeviceInventoryMorHigher implements AudioRoutingController.AudioDeviceInventory {
    private static final HashMap<Integer, Integer> DEVICE_TYPE_TO_ROUTE;
    private static final String TAG = "AudioRoute";
    private AudioManager mAm;
    private AudioRoutingController.AudioDeviceChangedCallback mAudioDeviceChangedCb = null;
    private AudioDeviceCallbackImpl mDevCb;

    public class AudioDeviceCallbackImpl extends AudioDeviceCallback {
        public AudioDeviceCallbackImpl() {
            Logging.i(AudioDeviceInventoryMorHigher.TAG, "AudioDeviceCallbackImpl ctor!");
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioDeviceInventoryMorHigher.this.processDevicesChanged(audioDeviceInfoArr, true);
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioDeviceInventoryMorHigher.this.processDevicesChanged(audioDeviceInfoArr, false);
        }
    }

    static {
        HashMap<Integer, Integer> map = new HashMap<>();
        DEVICE_TYPE_TO_ROUTE = map;
        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 0);
        map.put(4, 2);
        map.put(7, 5);
        map.put(11, 6);
        map.put(22, 6);
        map.put(9, 7);
    }

    public AudioDeviceInventoryMorHigher(Context context) {
        this.mAm = (AudioManager) context.getSystemService("audio");
    }

    private void onAudioDeviceChanged(int i, boolean z) {
        AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback = this.mAudioDeviceChangedCb;
        if (audioDeviceChangedCallback != null) {
            audioDeviceChangedCallback.onAudioDeviceChanged(z, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void processDevicesChanged(android.media.AudioDeviceInfo[] r10, boolean r11) {
        /*
            r9 = this;
            int r0 = r10.length
            r1 = 0
        L2:
            if (r1 >= r0) goto L85
            r2 = r10[r1]
            boolean r3 = r2.isSource()
            int r4 = r2.getType()
            java.lang.String r5 = "connect"
            java.lang.String r6 = "disconnect"
            java.lang.String r7 = "AudioRoute"
            if (r3 != 0) goto L59
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r8 = io.agora.rtc2.internal.AudioDeviceInventoryMorHigher.DEVICE_TYPE_TO_ROUTE
            int r2 = r2.getType()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r8.containsKey(r2)
            if (r2 != 0) goto L27
            goto L59
        L27:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Object r2 = r8.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r9.onAudioDeviceChanged(r2, r11)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "processDevicesChanged : "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " "
            r3.append(r2)
            if (r11 == 0) goto L4d
            goto L4e
        L4d:
            r5 = r6
        L4e:
            r3.append(r5)
            java.lang.String r2 = r3.toString()
        L55:
            io.agora.rtc2.internal.Logging.i(r7, r2)
            goto L81
        L59:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "not process "
            r2.append(r8)
            if (r11 == 0) goto L66
            goto L67
        L66:
            r5 = r6
        L67:
            r2.append(r5)
            if (r3 == 0) goto L6f
            java.lang.String r3 = " input "
            goto L71
        L6f:
            java.lang.String r3 = " output "
        L71:
            r2.append(r3)
            java.lang.String r3 = "device type: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L55
        L81:
            int r1 = r1 + 1
            goto L2
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc2.internal.AudioDeviceInventoryMorHigher.processDevicesChanged(android.media.AudioDeviceInfo[], boolean):void");
    }

    @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceInventory
    public void dispose() {
        this.mAm.unregisterAudioDeviceCallback(this.mDevCb);
    }

    @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceInventory
    public void initialize() {
        AudioDeviceCallbackImpl audioDeviceCallbackImpl = new AudioDeviceCallbackImpl();
        this.mDevCb = audioDeviceCallbackImpl;
        this.mAm.registerAudioDeviceCallback(audioDeviceCallbackImpl, null);
    }

    @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceInventory
    public boolean isDeviceAvaliable(int i) {
        for (AudioDeviceInfo audioDeviceInfo : this.mAm.getDevices(2)) {
            int type = audioDeviceInfo.getType();
            HashMap<Integer, Integer> map = DEVICE_TYPE_TO_ROUTE;
            if (map.containsKey(Integer.valueOf(type)) && map.get(Integer.valueOf(type)).intValue() == i) {
                return true;
            }
        }
        return false;
    }

    @Override // io.agora.rtc2.internal.AudioRoutingController.AudioDeviceInventory
    public void setAudioDeviceChangeCallback(AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback) {
        this.mAudioDeviceChangedCb = audioDeviceChangedCallback;
    }
}
