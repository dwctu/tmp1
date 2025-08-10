package dc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.up2;
import java.util.HashSet;
import java.util.Set;
import org.webrtc.ThreadUtils;

/* compiled from: AppRTCAudioManager.java */
/* loaded from: classes3.dex */
public class tp2 {
    public final Context a;
    public final String b;
    public final up2 c;

    @Nullable
    public AudioManager d;

    @Nullable
    public d e;
    public e f;
    public boolean h;
    public boolean i;
    public boolean j;
    public c k;
    public c l;
    public c m;

    @Nullable
    public vp2 n;
    public BroadcastReceiver p;

    @Nullable
    public AudioManager.OnAudioFocusChangeListener q;
    public int g = -2;
    public Set<c> o = new HashSet();

    /* compiled from: AppRTCAudioManager.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a(tp2 tp2Var) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            String str = "onAudioFocusChange: " + (i != -3 ? i != -2 ? i != -1 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "AUDIOFOCUS_INVALID" : "AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE" : "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK" : "AUDIOFOCUS_GAIN_TRANSIENT" : "AUDIOFOCUS_GAIN" : "AUDIOFOCUS_LOSS" : "AUDIOFOCUS_LOSS_TRANSIENT" : "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
        }
    }

    /* compiled from: AppRTCAudioManager.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.SPEAKER_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.WIRED_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: AppRTCAudioManager.java */
    public enum c {
        SPEAKER_PHONE,
        WIRED_HEADSET,
        EARPIECE,
        BLUETOOTH,
        NONE
    }

    /* compiled from: AppRTCAudioManager.java */
    public interface d {
        void a(c cVar, Set<c> set);
    }

    /* compiled from: AppRTCAudioManager.java */
    public enum e {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING
    }

    /* compiled from: AppRTCAudioManager.java */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("state", 0);
            int intExtra2 = intent.getIntExtra("microphone", 0);
            String stringExtra = intent.getStringExtra("name");
            StringBuilder sb = new StringBuilder();
            sb.append("WiredHeadsetReceiver.onReceive");
            sb.append(wp2.b());
            sb.append(": a=");
            sb.append(intent.getAction());
            sb.append(", s=");
            sb.append(intExtra == 0 ? "unplugged" : "plugged");
            sb.append(", m=");
            sb.append(intExtra2 == 1 ? "mic" : "no mic");
            sb.append(", n=");
            sb.append(stringExtra);
            sb.append(", sb=");
            sb.append(isInitialStickyBroadcast());
            sb.toString();
            tp2.this.j = intExtra == 1;
            tp2.this.n();
        }

        public /* synthetic */ f(tp2 tp2Var, a aVar) {
            this();
        }
    }

    public tp2(Context context) {
        ThreadUtils.checkIsOnMainThread();
        this.a = context;
        this.d = (AudioManager) context.getSystemService("audio");
        this.c = up2.k(context, this);
        this.p = new f(this, null);
        this.f = e.UNINITIALIZED;
        this.b = TtmlNode.TEXT_EMPHASIS_AUTO;
        String str = "useSpeakerphone: " + TtmlNode.TEXT_EMPHASIS_AUTO;
        if (TtmlNode.TEXT_EMPHASIS_AUTO.equals("false")) {
            this.k = c.EARPIECE;
        } else {
            this.k = c.SPEAKER_PHONE;
        }
        this.n = vp2.a(context, new Runnable() { // from class: dc.rp2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        });
        String str2 = "defaultAudioDevice: " + this.k;
        wp2.c("AppRTCAudioManager");
    }

    public static tp2 b(Context context) {
        return new tp2(context);
    }

    public final boolean c() {
        return this.a.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @Deprecated
    public final boolean d() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.d.isWiredHeadsetOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : this.d.getDevices(3)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 11) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.b.equals(TtmlNode.TEXT_EMPHASIS_AUTO) && this.o.size() == 2) {
            Set<c> set = this.o;
            c cVar = c.EARPIECE;
            if (set.contains(cVar)) {
                Set<c> set2 = this.o;
                c cVar2 = c.SPEAKER_PHONE;
                if (set2.contains(cVar2)) {
                    if (this.n.b()) {
                        h(cVar);
                    } else {
                        h(cVar2);
                    }
                }
            }
        }
    }

    public final void g(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            this.a.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            this.a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final void h(c cVar) {
        String str = "setAudioDeviceInternal(device=" + cVar + ")";
        wp2.a(this.o.contains(cVar));
        int i = b.a[cVar.ordinal()];
        if (i == 1) {
            j(true);
        } else if (i == 2 || i == 3 || i == 4) {
            j(false);
        }
        this.l = cVar;
    }

    public final void i(boolean z) {
        if (this.d.isMicrophoneMute() == z) {
            return;
        }
        this.d.setMicrophoneMute(z);
    }

    public final void j(boolean z) {
        if (this.d.isSpeakerphoneOn() == z) {
            return;
        }
        this.d.setSpeakerphoneOn(z);
    }

    public void k(d dVar) {
        ThreadUtils.checkIsOnMainThread();
        e eVar = this.f;
        e eVar2 = e.RUNNING;
        if (eVar == eVar2) {
            return;
        }
        this.e = dVar;
        this.f = eVar2;
        this.g = this.d.getMode();
        this.h = this.d.isSpeakerphoneOn();
        this.i = this.d.isMicrophoneMute();
        this.j = d();
        a aVar = new a(this);
        this.q = aVar;
        this.d.requestAudioFocus(aVar, 0, 2);
        this.d.setMode(3);
        i(false);
        c cVar = c.NONE;
        this.m = cVar;
        this.l = cVar;
        this.o.clear();
        this.c.s();
        n();
        g(this.p, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    public void l() {
        ThreadUtils.checkIsOnMainThread();
        if (this.f != e.RUNNING) {
            String str = "Trying to stop AudioManager in incorrect state: " + this.f;
            return;
        }
        this.f = e.UNINITIALIZED;
        m(this.p);
        this.c.w();
        j(this.h);
        i(this.i);
        this.d.setMode(this.g);
        this.d.abandonAudioFocus(this.q);
        this.q = null;
        vp2 vp2Var = this.n;
        if (vp2Var != null) {
            vp2Var.c();
            this.n = null;
        }
        this.e = null;
    }

    public final void m(BroadcastReceiver broadcastReceiver) {
        this.a.unregisterReceiver(broadcastReceiver);
    }

    public void n() {
        c cVar;
        c cVar2;
        ThreadUtils.checkIsOnMainThread();
        String str = "--- updateAudioDeviceState: wired headset=" + this.j + ", BT state=" + this.c.n();
        String str2 = "Device status: status_available=" + this.o + ", selected=" + this.l + ", user selected=" + this.m;
        up2.d dVarN = this.c.n();
        up2.d dVar = up2.d.HEADSET_AVAILABLE;
        if (dVarN == dVar || this.c.n() == up2.d.HEADSET_UNAVAILABLE || this.c.n() == up2.d.SCO_DISCONNECTING) {
            this.c.A();
        }
        HashSet hashSet = new HashSet();
        up2.d dVarN2 = this.c.n();
        up2.d dVar2 = up2.d.SCO_CONNECTED;
        if (dVarN2 == dVar2 || this.c.n() == up2.d.SCO_CONNECTING || this.c.n() == dVar) {
            hashSet.add(c.BLUETOOTH);
        }
        if (this.j) {
            hashSet.add(c.WIRED_HEADSET);
        } else {
            hashSet.add(c.SPEAKER_PHONE);
            if (c()) {
                hashSet.add(c.EARPIECE);
            }
        }
        boolean z = true;
        boolean z2 = !this.o.equals(hashSet);
        this.o = hashSet;
        if (this.c.n() == up2.d.HEADSET_UNAVAILABLE && this.m == c.BLUETOOTH) {
            this.m = c.NONE;
        }
        boolean z3 = this.j;
        if (z3 && this.m == c.SPEAKER_PHONE) {
            this.m = c.WIRED_HEADSET;
        }
        if (!z3 && this.m == c.WIRED_HEADSET) {
            this.m = c.SPEAKER_PHONE;
        }
        boolean z4 = false;
        boolean z5 = this.c.n() == dVar && ((cVar2 = this.m) == c.NONE || cVar2 == c.BLUETOOTH);
        if ((this.c.n() == dVar2 || this.c.n() == up2.d.SCO_CONNECTING) && (cVar = this.m) != c.NONE && cVar != c.BLUETOOTH) {
            z4 = true;
        }
        if (this.c.n() == dVar || this.c.n() == up2.d.SCO_CONNECTING || this.c.n() == dVar2) {
            String str3 = "Need BT audio: start=" + z5 + ", stop=" + z4 + ", BT state=" + this.c.n();
        }
        if (z4) {
            this.c.x();
            this.c.A();
        }
        if (!z5 || z4 || this.c.t()) {
            z = z2;
        } else {
            this.o.remove(c.BLUETOOTH);
        }
        c cVar3 = this.c.n() == dVar2 ? c.BLUETOOTH : this.j ? c.WIRED_HEADSET : this.k;
        if (cVar3 != this.l || z) {
            h(cVar3);
            String str4 = "New device status: status_available=" + this.o + ", selected=" + cVar3;
            d dVar3 = this.e;
            if (dVar3 != null) {
                dVar3.a(this.l, this.o);
            }
        }
    }
}
