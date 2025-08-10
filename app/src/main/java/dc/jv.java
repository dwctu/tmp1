package dc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.tt;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BaseBleRequest.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001hB\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0010J\b\u0010-\u001a\u00020&H&J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u001d2\u0006\u00105\u001a\u000203J\b\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0016J\u0012\u0010<\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020+H\u0004J\u0018\u0010A\u001a\u00020&2\u0006\u0010@\u001a\u00020+2\u0006\u0010B\u001a\u00020$H\u0004J\u000e\u0010C\u001a\u00020&2\u0006\u0010@\u001a\u00020+J\u0006\u0010D\u001a\u00020\u0010J\u0010\u0010E\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020&H\u0016J\u001a\u0010G\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\u001d2\b\u0010H\u001a\u0004\u0018\u00010IJ\u0018\u0010J\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\u001d2\u0006\u0010K\u001a\u000203J\u001a\u0010L\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010\u001d2\b\u0010M\u001a\u0004\u0018\u00010NJ\u001a\u0010O\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010QJ$\u0010S\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010T\u001a\u0004\u0018\u00010QJ\u0006\u0010U\u001a\u00020\u0010J\u0006\u0010V\u001a\u00020\u0010J\u0006\u0010W\u001a\u00020\u0010J\u0012\u0010X\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u000203J\"\u0010[\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010\\\u001a\u0004\u0018\u00010Q2\u0006\u0010]\u001a\u00020\u0010J\"\u0010^\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010\\\u001a\u0004\u0018\u00010Q2\u0006\u0010]\u001a\u00020\u0010J\u001e\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u0002032\u0006\u0010a\u001a\u0002032\u0006\u0010b\u001a\u000203J\b\u0010c\u001a\u00020&H\u0004J\b\u0010d\u001a\u00020&H\u0004J$\u0010e\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010\\\u001a\u0004\u0018\u00010Q2\b\u0010K\u001a\u0004\u0018\u00010IJ$\u0010f\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010\\\u001a\u0004\u0018\u00010Q2\b\u0010K\u001a\u0004\u0018\u00010IJ.\u0010g\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010T\u001a\u0004\u0018\u00010Q2\b\u0010K\u001a\u0004\u0018\u00010IR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "Lcom/component/dxbluetooth/lib/listener/request/IBaseBleRequest;", "Lcom/component/dxbluetooth/lib/connect/listener/GattResponseListener;", "Landroid/os/Handler$Callback;", "mResponse", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "(Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;)V", "dispatcher", "Lcom/component/dxbluetooth/lib/listener/request/IBleConnectDispatcher;", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra$delegate", "Lkotlin/Lazy;", "<set-?>", "", "finished", "getFinished", "()Z", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "getMResponse", "()Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "setMResponse", "mac", "", "getMac", "()Ljava/lang/String;", "setMac", "(Ljava/lang/String;)V", "requestTimeout", "startTime", "", "cancel", "", "clearGattResponseListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "closeGatt", "result", "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "discoverService", "doing", "getCurrentStatus", "Lcom/component/dxbluetooth/lib/data/BleEum$DevcieStatus;", "getDevice", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "getIntExtra", "", "key", "defaultValue", "getTimeoutMillis", "getWorker", "Lcom/component/dxbluetooth/lib/connect/BleWorker;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "log", "onConnectStatusChanged", "connectedOrDisconnected", "onRequestCompleted", XHTMLText.CODE, "onRequestCompletedByDelay", DelayInformation.ELEMENT, "onResponse", "openGatt", "process", "processRequest", "putByteArray", "bytes", "", "putIntExtra", "value", "putParcelable", "parcelable", "Landroid/os/Parcelable;", "readCharacteristic", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", "characteristic", "readDescriptor", "descriptor", "readPhy", "readRemoteRssi", "refreshDeviceCache", "registerGattResponseListener", "requestMtu", "mtu", "setCharacteristicIndication", FirebaseAnalytics.Param.CHARACTER, StreamManagement.Enable.ELEMENT, "setCharacteristicNotification", "setPreferredPhy", "tx", "rx", "phyOptions", "startRequestTiming", "stopRequestTiming", "writeCharacteristic", "writeCharacteristicWithNoRsp", "writeDescriptor", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class jv implements ht, Handler.Callback {

    @Nullable
    public zv a;
    public String c;

    @Nullable
    public xt d;
    public volatile boolean f;
    public boolean g;
    public long h;

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new c());

    /* compiled from: BaseBleRequest.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[lt.values().length];
            iArr[lt.DISCONNECTED.ordinal()] = 1;
            iArr[lt.CONNECTED.ordinal()] = 2;
            iArr[lt.SERVICE_READY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: BaseBleRequest.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<Bundle> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Bundle invoke() {
            return new Bundle();
        }
    }

    /* compiled from: BaseBleRequest.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<Handler> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = Looper.getMainLooper();
            }
            return new Handler(looperMyLooper, jv.this);
        }
    }

    public jv(@Nullable zv zvVar) {
        this.a = zvVar;
    }

    public static final void B(jv this$0, mt code) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(code, "$code");
        this$0.z(code);
    }

    public static final void D(mt code, jv this$0) {
        Intrinsics.checkNotNullParameter(code, "$code");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (code == mt.REQUEST_SUCCESS) {
                zv zvVar = this$0.a;
                if (zvVar != null) {
                    zvVar.a(code, this$0.r());
                }
            } else {
                zv zvVar2 = this$0.a;
                if (zvVar2 != null) {
                    zvVar2.b(code, null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void A(@NotNull final mt code, long j) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (j > 0) {
            s().postDelayed(new Runnable() { // from class: dc.gv
                @Override // java.lang.Runnable
                public final void run() {
                    jv.B(this.a, code);
                }
            }, j);
        } else {
            z(code);
        }
    }

    public final void C(@NotNull final mt code) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (this.f) {
            return;
        }
        this.f = true;
        se0.f(new Runnable() { // from class: dc.hv
            @Override // java.lang.Runnable
            public final void run() {
                jv.D(code, this);
            }
        });
    }

    public final boolean E() {
        return v().w();
    }

    public void F(@NotNull xt dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.d = dispatcher;
        this.h = System.currentTimeMillis();
        rw.a.e("Process " + ((Object) getClass().getSimpleName()) + ", status = " + p());
        Pair<Boolean, mt> pairA = pt.a.a();
        boolean zBooleanValue = pairA.component1().booleanValue();
        mt mtVarComponent2 = pairA.component2();
        if (!zBooleanValue) {
            z(mtVarComponent2);
            return;
        }
        try {
            P(this);
            G();
        } catch (Throwable th) {
            th.printStackTrace();
            z(mt.REQUEST_EXCEPTION);
        }
    }

    public void G() {
        int i = a.a[p().ordinal()];
        if (i == 1) {
            z(mt.REQUEST_FAILED);
            return;
        }
        if (i == 2) {
            o();
        } else if (i != 3) {
            z(mt.REQUEST_FAILED);
        } else {
            o();
        }
    }

    public final void H(@Nullable String str, @Nullable byte[] bArr) {
        r().putByteArray(str, bArr);
    }

    public final void I(@Nullable String str, int i) {
        r().putInt(str, i);
    }

    public final void J(@Nullable String str, @Nullable Parcelable parcelable) {
        r().putParcelable(str, parcelable);
    }

    public final boolean K(@Nullable UUID uuid, @Nullable UUID uuid2) {
        return v().x(uuid, uuid2);
    }

    public final boolean L(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3) {
        return v().y(uuid, uuid2, uuid3);
    }

    public final boolean M() {
        return v().z();
    }

    public final boolean N() {
        return v().A();
    }

    public final boolean O() {
        return v().C();
    }

    public final void P(ht htVar) {
        v().D(htVar);
    }

    public final boolean Q(int i) {
        return v().E(i);
    }

    public final boolean R(@Nullable UUID uuid, @Nullable UUID uuid2, boolean z) {
        return v().H(uuid, uuid2, z);
    }

    public final boolean S(@Nullable UUID uuid, @Nullable UUID uuid2, boolean z) {
        return v().I(uuid, uuid2, z);
    }

    public final void T(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final boolean U(int i, int i2, int i3) {
        return v().K(i, i2, i3);
    }

    public final void V() {
        s().sendEmptyMessageDelayed(32, u());
    }

    public final void W() {
        s().removeMessages(32);
    }

    public final boolean X(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
        return v().L(uuid, uuid2, bArr);
    }

    public final boolean Y(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
        return v().M(uuid, uuid2, bArr);
    }

    public final boolean Z(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable byte[] bArr) {
        return v().N(uuid, uuid2, uuid3, bArr);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 32) {
            if (this instanceof wv) {
                y("handleMessage write no rsp request timeout bean: " + this + " isFinish: " + this.f + " cmd: " + ((Object) qd0.c(((wv) this).getK())));
            } else if (this instanceof xv) {
                y("handleMessage write request timeout bean: " + this + " isFinish: " + this.f + " cmd: " + ((Object) qd0.c(((xv) this).getK())));
            } else {
                y("handleMessage request timeout bean: " + this + " isFinish: " + this.f);
            }
            if (this.f) {
                return true;
            }
            this.g = true;
            m(mt.CONNECT_FAILED_BY_BASE_REQUEST_TIMEOUT);
        }
        return true;
    }

    @Override // dc.ht
    public void i(boolean z) {
        if (z) {
            return;
        }
        z(this.g ? mt.REQUEST_TIMEOUT : mt.REQUEST_FAILED);
    }

    public void k() {
        s().removeCallbacksAndMessages(null);
        l(this);
        C(mt.REQUEST_CANCEL);
    }

    public final void l(ht htVar) {
        v().o(htVar);
    }

    public final void m(@NotNull mt result) {
        Intrinsics.checkNotNullParameter(result, "result");
        tt.a.a(v(), result, null, 2, null);
    }

    public final boolean n() {
        return v().p();
    }

    public abstract void o();

    @NotNull
    public final lt p() {
        return q().getB();
    }

    @NotNull
    public final lu q() {
        return ot.a(kt.a, t());
    }

    public final Bundle r() {
        return (Bundle) this.b.getValue();
    }

    @NotNull
    public final Handler s() {
        return (Handler) this.e.getValue();
    }

    @NotNull
    public final String t() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mac");
        return null;
    }

    public long u() {
        return 30000L;
    }

    public final gt v() {
        return ot.a(kt.a, t()).f();
    }

    public void y(@Nullable String str) {
        rw.a.d(((Object) getClass().getSimpleName()) + ' ' + t() + " >>> " + ((Object) str));
    }

    public final synchronized void z(@NotNull mt code) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (this.f) {
            return;
        }
        y(Intrinsics.stringPlus("request complete: code = ", code));
        s().removeCallbacksAndMessages(null);
        l(this);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.h;
        if (jCurrentTimeMillis > 500) {
            rw.a.a("\n            addNewRequest cmd: " + this + "\n            mac = " + t() + "\n            startTime = " + this.h + "\n            time = " + jCurrentTimeMillis);
        }
        C(code);
        xt xtVar = this.d;
        if (xtVar != null) {
            xtVar.a(this);
        }
    }
}
