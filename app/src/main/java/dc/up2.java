package dc;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.Nullable;
import com.broadcom.bt.service.ftp.BluetoothFTP;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleService;
import java.util.List;
import java.util.Set;
import org.webrtc.ThreadUtils;

/* compiled from: AppRTCBluetoothManager.java */
/* loaded from: classes3.dex */
public class up2 {
    public final Context a;
    public final tp2 b;

    @Nullable
    public final AudioManager c;
    public final Handler d;
    public final BluetoothProfile.ServiceListener e;
    public final BroadcastReceiver f;
    public int g;
    public d h;

    @Nullable
    public BluetoothAdapter i;

    @Nullable
    public BluetoothHeadset j;

    @Nullable
    public BluetoothDevice k;
    public final Runnable l = new a();

    /* compiled from: AppRTCBluetoothManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            up2.this.i();
        }
    }

    /* compiled from: AppRTCBluetoothManager.java */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (up2.this.h == d.UNINITIALIZED) {
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                String str = "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_CONNECTION_STATE_CHANGED, s=" + up2.this.v(intExtra) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + up2.this.h;
                if (intExtra == 2) {
                    up2 up2Var = up2.this;
                    up2Var.g = 0;
                    up2Var.z();
                } else if (intExtra != 1 && intExtra != 3 && intExtra == 0) {
                    up2.this.x();
                    up2.this.z();
                }
            } else if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(action)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                String str2 = "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_AUDIO_STATE_CHANGED, s=" + up2.this.v(intExtra2) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + up2.this.h;
                if (intExtra2 == 12) {
                    up2.this.j();
                    if (up2.this.h == d.SCO_CONNECTING) {
                        up2.this.h = d.SCO_CONNECTED;
                        up2 up2Var2 = up2.this;
                        up2Var2.g = 0;
                        up2Var2.z();
                    }
                } else if (intExtra2 != 11 && intExtra2 == 10) {
                    if (isInitialStickyBroadcast()) {
                        return;
                    } else {
                        up2.this.z();
                    }
                }
            }
            String str3 = "onReceive done: BT state=" + up2.this.h;
        }

        public /* synthetic */ b(up2 up2Var, a aVar) {
            this();
        }
    }

    /* compiled from: AppRTCBluetoothManager.java */
    public class c implements BluetoothProfile.ServiceListener {
        public c() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i != 1 || up2.this.h == d.UNINITIALIZED) {
                return;
            }
            String str = "BluetoothServiceListener.onServiceConnected: BT state=" + up2.this.h;
            up2.this.j = (BluetoothHeadset) bluetoothProfile;
            up2.this.z();
            String str2 = "onServiceConnected done: BT state=" + up2.this.h;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            if (i != 1 || up2.this.h == d.UNINITIALIZED) {
                return;
            }
            String str = "BluetoothServiceListener.onServiceDisconnected: BT state=" + up2.this.h;
            up2.this.x();
            up2.this.j = null;
            up2.this.k = null;
            up2.this.h = d.HEADSET_UNAVAILABLE;
            up2.this.z();
            String str2 = "onServiceDisconnected done: BT state=" + up2.this.h;
        }

        public /* synthetic */ c(up2 up2Var, a aVar) {
            this();
        }
    }

    /* compiled from: AppRTCBluetoothManager.java */
    public enum d {
        UNINITIALIZED,
        ERROR,
        HEADSET_UNAVAILABLE,
        HEADSET_AVAILABLE,
        SCO_DISCONNECTING,
        SCO_CONNECTING,
        SCO_CONNECTED
    }

    public up2(Context context, tp2 tp2Var) {
        ThreadUtils.checkIsOnMainThread();
        this.a = context;
        this.b = tp2Var;
        this.c = l(context);
        this.h = d.UNINITIALIZED;
        a aVar = null;
        this.e = new c(this, aVar);
        this.f = new b(this, aVar);
        this.d = new Handler(Looper.getMainLooper());
    }

    public static up2 k(Context context, tp2 tp2Var) {
        String str = "create" + wp2.b();
        return new up2(context, tp2Var);
    }

    public void A() {
        if (this.h == d.UNINITIALIZED || this.j == null) {
            return;
        }
        List<BluetoothDevice> connectedDevices = this.j.getConnectedDevices();
        if (connectedDevices.isEmpty()) {
            this.k = null;
            this.h = d.HEADSET_UNAVAILABLE;
        } else {
            this.k = connectedDevices.get(0);
            this.h = d.HEADSET_AVAILABLE;
            String str = "Connected bluetooth headset: name=" + this.k.getName() + ", state=" + v(this.j.getConnectionState(this.k)) + ", SCO audio=" + this.j.isAudioConnected(this.k);
        }
        String str2 = "updateDevice done: BT state=" + this.h;
    }

    public final void i() {
        boolean z;
        ThreadUtils.checkIsOnMainThread();
        if (this.h == d.UNINITIALIZED || this.j == null) {
            return;
        }
        String str = "bluetoothTimeout: BT state=" + this.h + ", attempts: " + this.g + ", SCO is on: " + p();
        if (this.h != d.SCO_CONNECTING) {
            return;
        }
        List<BluetoothDevice> connectedDevices = this.j.getConnectedDevices();
        if (connectedDevices.size() > 0) {
            BluetoothDevice bluetoothDevice = connectedDevices.get(0);
            this.k = bluetoothDevice;
            if (this.j.isAudioConnected(bluetoothDevice)) {
                String str2 = "SCO connected with " + this.k.getName();
                z = true;
            } else {
                String str3 = "SCO is not connected with " + this.k.getName();
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            this.h = d.SCO_CONNECTED;
            this.g = 0;
        } else {
            x();
        }
        z();
        String str4 = "bluetoothTimeout done: BT state=" + this.h;
    }

    public final void j() {
        ThreadUtils.checkIsOnMainThread();
        this.d.removeCallbacks(this.l);
    }

    @Nullable
    public AudioManager l(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public boolean m(Context context, BluetoothProfile.ServiceListener serviceListener, int i) {
        return this.i.getProfileProxy(context, serviceListener, i);
    }

    public d n() {
        ThreadUtils.checkIsOnMainThread();
        return this.h;
    }

    public boolean o(Context context, String str) {
        return this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final boolean p() {
        return this.c.isBluetoothScoOn();
    }

    @SuppressLint({"HardwareIds"})
    public void q(BluetoothAdapter bluetoothAdapter) {
        String str = "BluetoothAdapter: enabled=" + bluetoothAdapter.isEnabled() + ", state=" + v(bluetoothAdapter.getState()) + ", name=" + bluetoothAdapter.getName() + ", address=" + bluetoothAdapter.getAddress();
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if (bondedDevices.isEmpty()) {
            return;
        }
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            String str2 = " name=" + bluetoothDevice.getName() + ", address=" + bluetoothDevice.getAddress();
        }
    }

    public void r(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            this.a.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            this.a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public void s() {
        ThreadUtils.checkIsOnMainThread();
        if (!o(this.a, BluetoothFTP.BLUETOOTH_PERM)) {
            String str = "Process (pid=" + Process.myPid() + ") lacks BLUETOOTH permission";
            return;
        }
        if (this.h != d.UNINITIALIZED) {
            return;
        }
        this.j = null;
        this.k = null;
        this.g = 0;
        BluetoothAdapter adapter = ((BluetoothManager) WearUtils.x.getSystemService("bluetooth")).getAdapter();
        this.i = adapter;
        if (adapter != null && this.c.isBluetoothScoAvailableOffCall()) {
            q(this.i);
            if (m(this.a, this.e, 1)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                r(this.f, intentFilter);
                String str2 = "HEADSET profile state: " + v(this.i.getProfileConnectionState(1));
                this.h = d.HEADSET_UNAVAILABLE;
                String str3 = "start done: BT state=" + this.h;
            }
        }
    }

    public boolean t() {
        ThreadUtils.checkIsOnMainThread();
        String str = "startSco: BT state=" + this.h + ", attempts: " + this.g + ", SCO is on: " + p();
        if (this.g >= 2 || this.h != d.HEADSET_AVAILABLE) {
            return false;
        }
        this.h = d.SCO_CONNECTING;
        this.c.startBluetoothSco();
        this.c.setSpeakerphoneOn(false);
        this.c.setBluetoothScoOn(true);
        this.g++;
        u();
        String str2 = "startScoAudio done: BT state=" + this.h + ", SCO is on: " + p();
        return true;
    }

    public final void u() {
        ThreadUtils.checkIsOnMainThread();
        this.d.postDelayed(this.l, 4000L);
    }

    public final String v(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i == 1) {
            return "CONNECTING";
        }
        if (i == 2) {
            return BleService.EXTRA_CONNECTED;
        }
        if (i == 3) {
            return "DISCONNECTING";
        }
        switch (i) {
            case 10:
                return "OFF";
            case 11:
                return "TURNING_ON";
            case 12:
                return "ON";
            case 13:
                return "TURNING_OFF";
            default:
                return "INVALID";
        }
    }

    public void w() {
        ThreadUtils.checkIsOnMainThread();
        String str = "stop: BT state=" + this.h;
        if (this.i == null) {
            return;
        }
        x();
        d dVar = this.h;
        d dVar2 = d.UNINITIALIZED;
        if (dVar == dVar2) {
            return;
        }
        y(this.f);
        j();
        BluetoothHeadset bluetoothHeadset = this.j;
        if (bluetoothHeadset != null) {
            this.i.closeProfileProxy(1, bluetoothHeadset);
            this.j = null;
        }
        this.i = null;
        this.k = null;
        this.h = dVar2;
        String str2 = "stop done: BT state=" + this.h;
    }

    public void x() {
        ThreadUtils.checkIsOnMainThread();
        String str = "stopScoAudio: BT state=" + this.h + ", SCO is on: " + p();
        d dVar = this.h;
        if (dVar == d.SCO_CONNECTING || dVar == d.SCO_CONNECTED) {
            j();
            this.c.stopBluetoothSco();
            this.c.setBluetoothScoOn(false);
            this.h = d.SCO_DISCONNECTING;
            String str2 = "stopScoAudio done: BT state=" + this.h + ", SCO is on: " + p();
        }
    }

    public void y(BroadcastReceiver broadcastReceiver) {
        this.a.unregisterReceiver(broadcastReceiver);
    }

    public final void z() {
        ThreadUtils.checkIsOnMainThread();
        this.b.n();
    }
}
