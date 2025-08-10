package dc;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dc.aw;
import dc.f90;
import dc.wc0;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyOTAUpdate.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0019J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0014\u0010$\u001a\u00020\u001e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/component/dxtoy/update/ota/ToyOTAUpdate;", "", "()V", "MTU", "", "UPDATE_RESULT_CHANGE_MTU_ERR", "", "WRITE_OTA_END", "", "WRITE_OTA_START", "deviceAddress", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "mtuDivisible", "otaControl", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "otaData", "otaFileBytes", "otaLength", "otaListener", "Lcom/component/dxtoy/update/UpdateListener;", "otaService", "updateFile", "Ljava/io/File;", "doOtaUpdate", "", "file", "devAddress", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getOtaWriteData", "hasWriteDataSize", "handleConnectResult", "event", "Lcom/component/dxtoy/core/api/event/ToyConnectEvent;", "sendMtuCommand", "sendOTAData", "writtenDataSize", "sendOTAEndCommand", "sendOTAStartCommand", "setMtuDivisible", "mtu", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class wc0 {
    public static int g;
    public static File h;
    public static String i;
    public static oc0 j;
    public static int l;

    @NotNull
    public static final wc0 a = new wc0();

    @NotNull
    public static final byte[] b = {0};

    @NotNull
    public static final byte[] c = {3};
    public static final UUID d = UUID.fromString("1d14d6ee-fd63-4fa1-bfa4-8f47b42119f0");
    public static final UUID e = UUID.fromString("f7bf3564-fb6d-4e53-88a4-5e37e0326063");
    public static final UUID f = UUID.fromString("984227f3-34fc-4045-a5d0-2c581f81a153");

    @NotNull
    public static byte[] k = new byte[0];

    @NotNull
    public static final Lazy m = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ToyOTAUpdate.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Handler> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler();
        }
    }

    /* compiled from: ToyOTAUpdate.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/update/ota/ToyOTAUpdate$sendMtuCommand$1", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements aw {
        public static final void f() {
            wc0.a.r();
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            aw.a.a(this, code, str);
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.a(false, "Can not change mtu");
            hx.d("Toy ota update", "sendMtuCommand onError code = " + code, new Object[0]);
        }

        @Override // dc.qt
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            wc0 wc0Var = wc0.a;
            wc0Var.s(num != null ? num.intValue() : 247);
            wc0Var.k().postDelayed(new Runnable() { // from class: dc.sc0
                @Override // java.lang.Runnable
                public final void run() {
                    wc0.b.f();
                }
            }, 200L);
            de0.v("sendMtuCommand onResponse code = " + code + ' ');
            StringBuilder sb = new StringBuilder();
            sb.append("sendMtuCommand onResponse code = ");
            sb.append(code);
            hx.f("Toy ota update", sb.toString(), new Object[0]);
        }
    }

    /* compiled from: ToyOTAUpdate.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/update/ota/ToyOTAUpdate$sendOTAData$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements fw {
        public final /* synthetic */ int a;
        public final /* synthetic */ byte[] b;

        public c(int i, byte[] bArr) {
            this.a = i;
            this.b = bArr;
        }

        public static final void f() {
            wc0.a.q();
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            String str2 = "Ota data write fail code: " + code + " , msg: " + str;
            de0.l(str2);
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.a(false, str2);
            hx.d("Toy ota update", "sendOTAData onError code = " + code, new Object[0]);
        }

        @Override // dc.qt
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            int length = this.a + this.b.length;
            if (length <= wc0.l - 1) {
                wc0.a.p(length);
            } else {
                wc0.a.k().postDelayed(new Runnable() { // from class: dc.tc0
                    @Override // java.lang.Runnable
                    public final void run() {
                        wc0.c.f();
                    }
                }, 200L);
            }
            int i = (length * 100) / wc0.l;
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.c(i);
            hx.f("Toy ota update", "sendOTAData onResponse code = " + code, new Object[0]);
        }
    }

    /* compiled from: ToyOTAUpdate.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/update/ota/ToyOTAUpdate$sendOTAEndCommand$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements fw {
        public static final void f() {
            f90.a aVar = f90.a;
            String str = wc0.i;
            File file = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
                str = null;
            }
            aVar.d(str);
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.a(true, null);
            File file2 = wc0.h;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateFile");
            } else {
                file = file2;
            }
            vd0.d(file);
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.a(false, "Ota end command write fail: " + str);
            hx.d("Toy ota update", "sendOTAEndCommand onError code = " + code, new Object[0]);
        }

        @Override // dc.qt
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            wc0.a.k().postDelayed(new Runnable() { // from class: dc.uc0
                @Override // java.lang.Runnable
                public final void run() {
                    wc0.d.f();
                }
            }, 500L);
            de0.v("sendOTAEndCommand onResponse code = " + code + ' ');
            StringBuilder sb = new StringBuilder();
            sb.append("sendOTAEndCommand onResponse code = ");
            sb.append(code);
            hx.f("Toy ota update", sb.toString(), new Object[0]);
        }
    }

    /* compiled from: ToyOTAUpdate.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/update/ota/ToyOTAUpdate$sendOTAStartCommand$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements fw {
        public static final void f() {
            wc0.a.p(0);
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            oc0 oc0Var = wc0.j;
            if (oc0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
                oc0Var = null;
            }
            oc0Var.a(false, "Ota start command write fail: " + str);
            hx.d("Toy ota update", "sendOTAStartCommand onError code = " + code, new Object[0]);
        }

        @Override // dc.qt
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            wc0.a.k().postDelayed(new Runnable() { // from class: dc.vc0
                @Override // java.lang.Runnable
                public final void run() {
                    wc0.e.f();
                }
            }, 500L);
            de0.v("sendOTAStartCommand onResponse code = " + code + ' ');
            StringBuilder sb = new StringBuilder();
            sb.append("sendOTAStartCommand onResponse code = ");
            sb.append(code);
            hx.f("Toy ota update", sb.toString(), new Object[0]);
        }
    }

    public static /* synthetic */ void n(wc0 wc0Var, i90 i90Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i90Var = null;
        }
        wc0Var.m(i90Var);
    }

    public final void j(@NotNull File file, @NotNull String devAddress, @NotNull oc0 listener) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(devAddress, "devAddress");
        Intrinsics.checkNotNullParameter(listener, "listener");
        h = file;
        i = devAddress;
        j = listener;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int iAvailable = fileInputStream.available();
            byte[] bArr = new byte[iAvailable];
            fileInputStream.read(bArr);
            fileInputStream.close();
            k = bArr;
            l = iAvailable;
            n(this, null, 1, null);
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th.getMessage());
            hx.d("Toy ota update", "init file error = " + th.getMessage(), new Object[0]);
            listener.a(false, "OTA File not found!");
        }
    }

    public final Handler k() {
        return (Handler) m.getValue();
    }

    public final byte[] l(int i2) {
        int i3 = g;
        int i4 = i2 + i3;
        int i5 = l;
        int i6 = 0;
        if (i4 <= i5 - 1) {
            byte[] bArr = new byte[i3];
            while (i6 < i3) {
                bArr[i6] = k[i2 + i6];
                i6++;
            }
            return bArr;
        }
        int i7 = i5 - i2;
        while (i7 % 4 != 0) {
            i7++;
        }
        byte[] bArr2 = new byte[i7];
        while (i6 < i7) {
            int i8 = i2 + i6;
            bArr2[i6] = i8 > l + (-1) ? (byte) -1 : k[i8];
            i6++;
        }
        return bArr2;
    }

    public final void m(i90 i90Var) {
        sb0 f2;
        ConcurrentHashMap<String, nb0> concurrentHashMapE = hb0.a.e();
        String str = i;
        oc0 oc0Var = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
            str = null;
        }
        nb0 nb0Var = concurrentHashMapE.get(str);
        if (nb0Var == null) {
            oc0 oc0Var2 = j;
            if (oc0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
            } else {
                oc0Var = oc0Var2;
            }
            oc0Var.a(false, "Device disconnect");
            return;
        }
        if (i90Var == null || (f2 = i90Var.getB()) == null) {
            f2 = nb0Var.getF();
        }
        if (f2 == sb0.CONNECT_SUC) {
            o();
            return;
        }
        if (f2 == sb0.NOT_CONNECT) {
            oc0 oc0Var3 = j;
            if (oc0Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
            } else {
                oc0Var = oc0Var3;
            }
            oc0Var.a(false, "Device disconnect");
        }
    }

    public final void o() {
        f90.a aVar = f90.a;
        String str = i;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
            str = null;
        }
        aVar.j(str, 247, new b());
    }

    public final void p(int i2) {
        oc0 oc0Var = null;
        try {
            byte[] bArrL = l(i2);
            f90.a aVar = f90.a;
            String str = i;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
                str = null;
            }
            aVar.o(str, d, f, bArrL, new c(i2, bArrL));
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th);
            oc0 oc0Var2 = j;
            if (oc0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otaListener");
            } else {
                oc0Var = oc0Var2;
            }
            oc0Var.a(false, "Ota data write fail code  msg: " + th.getMessage());
            hx.d("Toy ota update", "sendOTAData try-catch error = " + th.getMessage(), new Object[0]);
        }
    }

    public final void q() {
        f90.a aVar = f90.a;
        String str = i;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
            str = null;
        }
        aVar.o(str, d, e, c, new d());
    }

    public final void r() {
        f90.a aVar = f90.a;
        String str = i;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceAddress");
            str = null;
        }
        aVar.o(str, d, e, b, new e());
    }

    public final void s(int i2) {
        g = i2 - 3;
        while (true) {
            int i3 = g;
            if (i3 % 4 == 0) {
                return;
            } else {
                g = i3 - 1;
            }
        }
    }
}
