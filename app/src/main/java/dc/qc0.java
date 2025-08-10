package dc;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.component.dxtoy.update.dfu.DfuService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dc.wb0;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyDFUUpdate.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u001bJ\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0004H\u0002J2\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0007J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020.H\u0007J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/component/dxtoy/update/dfu/ToyDFUUpdate;", "", "()V", "DFU_COMMAND", "", "UPDATE_RESULT_NO_FOUND_DFU_DEV", "UPDATE_RESULT_OPEN_DFU_FAIL", "deviceName", "dfuFile", "Ljava/io/File;", "dfuProgressListener", "Lno/nordicsemi/android/dfu/DfuProgressListener;", "doingDfuMac", "handler", "Landroid/os/Handler;", "isDoUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRetry", "originalDevMac", "scanAllDeviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "getScanAllDeviceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "scanAllDeviceMap$delegate", "Lkotlin/Lazy;", "updateListener", "Lcom/component/dxtoy/update/UpdateListener;", "addOne", "value", "doDfuUpdate", "", "file", "deviceAddress", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "doingDfuUpdate", "dfuDeviceAddress", "handleDFUUpdate", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "devName", "macAddOne", "mac", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyScanAllDeviceEvent;", "Lcom/component/dxtoy/core/api/event/ToyScanDFUDeviceEvent;", "registerUpdateListener", "setScanAllDeviceSwitch", "isOn", "", "startScanOverTime", "stopScanOverTime", "unregisterUpdateListener", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class qc0 {

    @Nullable
    public static oc0 e;
    public static File f;
    public static String g;

    @Nullable
    public static String h;

    @Nullable
    public static String i;

    @NotNull
    public static final qc0 a = new qc0();

    @NotNull
    public static final AtomicBoolean b = new AtomicBoolean(false);

    @NotNull
    public static final AtomicBoolean c = new AtomicBoolean(false);

    @NotNull
    public static final Handler d = new Handler(Looper.getMainLooper());

    @NotNull
    public static final Lazy j = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final DfuProgressListener k = new a();

    /* compiled from: ToyDFUUpdate.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J8\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016¨\u0006\u0017"}, d2 = {"com/component/dxtoy/update/dfu/ToyDFUUpdate$dfuProgressListener$1", "Lno/nordicsemi/android/dfu/DfuProgressListenerAdapter;", "onDeviceConnecting", "", "deviceAddress", "", "onDeviceDisconnecting", "onDfuAborted", "onDfuCompleted", "onDfuProcessStarting", "onError", "error", "", "errorType", "message", "onFirmwareValidating", "onProgressChanged", "percent", "speed", "", "avgSpeed", "currentPart", "partsTotal", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends DfuProgressListenerAdapter {
        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnecting(@NotNull String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.v("dfu update onDeviceConnecting");
            hx.d("Toy dfu update", "dfuProgressListener onDeviceConnecting", new Object[0]);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(@Nullable String deviceAddress) {
            de0.v("dfu update onDfuAborted");
            hx.d("Toy dfu update", "dfuProgressListener onDeviceDisconnecting", new Object[0]);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(@NotNull String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.v("dfu update onDfuAborted");
            hx.d("Toy dfu update", "dfuProgressListener onDfuAborted", new Object[0]);
            qc0.a.s();
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.a(false, "dfu update onDfuAborted");
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(@NotNull String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.v("dfu update onDfuCompleted");
            qc0.a.s();
            File file = qc0.f;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dfuFile");
                file = null;
            }
            vd0.d(file);
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.a(true, null);
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(@NotNull String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.v("dfu update onDfuProcessStarting");
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.c(0);
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(@NotNull String deviceAddress, int error, int errorType, @Nullable String message) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.l("dfu update error " + error + ' ' + errorType + ' ' + message);
            qc0.a.s();
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.a(false, message);
            }
            hx.d("Toy dfu update", "dfuProgressListener onError " + error + ' ' + errorType + ' ' + message, new Object[0]);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onFirmwareValidating(@NotNull String deviceAddress) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            de0.v("dfu update onFirmwareValidating");
            hx.d("Toy dfu update", "dfuProgressListener onFirmwareValidating", new Object[0]);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(@NotNull String deviceAddress, int percent, float speed, float avgSpeed, int currentPart, int partsTotal) {
            Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.c(percent);
            }
            de0.v("dfu update progress " + percent);
            hx.f("Toy dfu update", "dfuProgressListener onProgressChanged progress " + percent, new Object[0]);
        }
    }

    /* compiled from: ToyDFUUpdate.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/update/dfu/ToyDFUUpdate$doDfuUpdate$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements fw {
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ oc0 d;

        public b(File file, String str, String str2, oc0 oc0Var) {
            this.a = file;
            this.b = str;
            this.c = str2;
            this.d = oc0Var;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            qc0.a.k(code, this.a, this.b, this.c, this.d);
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(code, "code");
            qc0.a.k(code, this.a, this.b, this.c, this.d);
        }
    }

    /* compiled from: ToyDFUUpdate.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ConcurrentHashMap<String, BleSearchDeviceBean>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, BleSearchDeviceBean> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: ToyDFUUpdate.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (qc0.c.get()) {
                return;
            }
            oc0 oc0Var = qc0.e;
            if (oc0Var != null) {
                oc0Var.a(false, "Can not find dfu device");
            }
            z90.a.d().x();
            qc0.a.o(false);
            wb0.a.c(qc0.this);
        }
    }

    public static final void q(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final String g(String str) {
        if (Intrinsics.areEqual(str, "FF")) {
            return "00";
        }
        String string = Integer.toString(Integer.parseInt(str, CharsKt__CharJVMKt.checkRadix(16)) + 1, CharsKt__CharJVMKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() != 1) {
            return upperCase;
        }
        return '0' + upperCase;
    }

    public final void h(@NotNull File file, @NotNull String deviceAddress, @Nullable String str, @NotNull oc0 listener) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Intrinsics.checkNotNullParameter(listener, "listener");
        f90.a.n(deviceAddress, "DFU;", new b(file, deviceAddress, str, listener));
    }

    public final void i(String str) {
        DfuServiceInitiator unsafeExperimentalButtonlessServiceInSecureDfuEnabled = new DfuServiceInitiator(str).setDeviceName(h).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(Build.VERSION.SDK_INT < 23).setPacketsReceiptNotificationsValue(12).setPrepareDataObjectDelay(400L).setDisableNotification(!q61.f(ed0.e(), "android.permission.NOTIFICATION_SERVICE")).setForeground(false).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
        File file = f;
        File file2 = null;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfuFile");
            file = null;
        }
        Uri uriFromFile = Uri.fromFile(file);
        File file3 = f;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dfuFile");
        } else {
            file2 = file3;
        }
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setZip(uriFromFile, file2.getAbsolutePath());
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.start(ve0.a(), DfuService.class);
    }

    public final ConcurrentHashMap<String, BleSearchDeviceBean> j() {
        return (ConcurrentHashMap) j.getValue();
    }

    public final void k(mt mtVar, File file, String str, String str2, oc0 oc0Var) {
        if (mtVar != mt.REQUEST_SUCCESS) {
            AtomicBoolean atomicBoolean = b;
            if (atomicBoolean.compareAndSet(false, true)) {
                h(file, str, h, oc0Var);
                return;
            }
            atomicBoolean.set(false);
            oc0 oc0Var2 = e;
            if (oc0Var2 != null) {
                oc0Var2.a(false, "Open DFU mode fail");
                return;
            }
            return;
        }
        f = file;
        g = str;
        h = str2;
        e = oc0Var;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originalDevMac");
            str = null;
        }
        i = m(str);
        b.set(false);
        n();
        z90.a.d().w();
        o(true);
        p();
    }

    public final String m(String str) {
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null));
        for (int i2 = 5; i2 >= 0; i2--) {
            String strG = g((String) mutableList.get(i2));
            mutableList.set(i2, strG);
            if (!Intrinsics.areEqual("00", strG)) {
                break;
            }
        }
        return CollectionsKt___CollectionsKt.joinToString$default(mutableList, SignatureImpl.INNER_SEP, null, null, 0, null, null, 62, null);
    }

    public final void n() {
        wb0.a.b(this);
        DfuServiceListenerHelper.registerProgressListener(ve0.a(), k);
    }

    public final void o(boolean z) {
        if (z) {
            j().clear();
        }
        b00.a.h(z);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public final void onMessageEvent(@NotNull m90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        de0.i("ToyScanDFUDeviceEvent = " + event.getA().getMac() + " , " + event.getA().getName());
        if (!Intrinsics.areEqual(event.getA().getMac(), i)) {
            String mac = event.getA().getMac();
            String str = g;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("originalDevMac");
                str = null;
            }
            if (!Intrinsics.areEqual(mac, str)) {
                return;
            }
        }
        if (c.compareAndSet(false, true)) {
            String str2 = i;
            Intrinsics.checkNotNull(str2);
            i(str2);
            z90.a.d().x();
            o(false);
            r();
            wb0.a aVar = wb0.a;
            aVar.c(this);
            String str3 = i;
            Intrinsics.checkNotNull(str3);
            aVar.a(new rc0(str3, j()));
        }
    }

    public final void p() {
        final d dVar = new d();
        d.postDelayed(new Runnable() { // from class: dc.pc0
            @Override // java.lang.Runnable
            public final void run() {
                qc0.q(dVar);
            }
        }, 10000L);
    }

    public final void r() {
        d.removeCallbacksAndMessages(null);
    }

    public final void s() {
        c.set(false);
        wb0.a.c(this);
        DfuServiceListenerHelper.unregisterProgressListener(ve0.a(), k);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public final void onMessageEvent(@NotNull k90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        j().put(event.getA().getMac(), event.getA());
    }
}
