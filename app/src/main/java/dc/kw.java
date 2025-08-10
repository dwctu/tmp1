package dc;

import android.os.Bundle;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.component.dxbluetooth.lib.bean.config.BleSearchConfigBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.kw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

/* compiled from: BleSearch.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/component/dxbluetooth/lib/search/BleSearch;", "", "()V", "SEARCH_TIME_INTERVAL", "", "SEARCH_TIME_MAX", "", "isSearching", "", "startSearchTimeList", "", "getStartSearchTimeList", "()Ljava/util/List;", "startSearchTimeList$delegate", "Lkotlin/Lazy;", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "timeoutRunnable$delegate", "cancelSearch", "", "isTooFast", "removeTimeout", FirebaseAnalytics.Event.SEARCH, "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "setTimeout", DeliveryReceiptRequest.ELEMENT, "stopSearch", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class kw {
    public static volatile boolean c;

    @NotNull
    public static final kw a = new kw();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(c.a);

    /* compiled from: BleSearch.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/component/dxbluetooth/lib/search/BleSearch$search$1", "Lcom/component/dxbluetooth/lib/search/BluetoothSearchResponse;", "onDeviceFounded", "", "device", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "onSearchCanceled", "onSearchStarted", "onSearchStopped", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements mw {
        public final /* synthetic */ zv a;

        public a(zv zvVar) {
            this.a = zvVar;
        }

        @Override // dc.mw
        public void a() {
            zv zvVar = this.a;
            if (zvVar == null) {
                return;
            }
            zvVar.a(mt.SEARCH_CANCEL, null);
        }

        @Override // dc.mw
        public void b() {
            zv zvVar = this.a;
            if (zvVar == null) {
                return;
            }
            zvVar.a(mt.SEARCH_STOP, null);
        }

        @Override // dc.mw
        public void c() {
            zv zvVar = this.a;
            if (zvVar == null) {
                return;
            }
            zvVar.a(mt.SEARCH_START, null);
        }

        @Override // dc.mw
        public void d(@NotNull BleSearchDeviceBean device) {
            Intrinsics.checkNotNullParameter(device, "device");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_response", device);
            zv zvVar = this.a;
            if (zvVar == null) {
                return;
            }
            zvVar.a(mt.SEARCH_DEVICE_FOUND, bundle);
        }
    }

    /* compiled from: BleSearch.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<List<Long>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<Long> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: BleSearch.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<Runnable> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        public static final void b() {
            kw.a.h();
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Runnable invoke() {
            return new Runnable() { // from class: dc.hw
                @Override // java.lang.Runnable
                public final void run() {
                    kw.c.b();
                }
            };
        }
    }

    public final void a() {
        e();
        c = false;
        lw.b.a();
    }

    public final List<Long> b() {
        return (List) b.getValue();
    }

    public final Runnable c() {
        return (Runnable) d.getValue();
    }

    public final boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = b().size() > 0 ? ((Number) CollectionsKt___CollectionsKt.first((List) b())).longValue() : 0L;
        boolean z = b().size() == 5 && jCurrentTimeMillis - jLongValue < 30000;
        de0.l(Intrinsics.stringPlus("isTooFast: ", Boolean.valueOf(z)), Intrinsics.stringPlus("time: ", Long.valueOf(jCurrentTimeMillis - jLongValue)), Intrinsics.stringPlus("size: ", Integer.valueOf(b().size())));
        if (!z) {
            b().add(Long.valueOf(jCurrentTimeMillis));
            if (b().size() > 5) {
                b().remove(0);
            }
        }
        return z;
    }

    public final void e() {
        sw.a.c().removeCallbacks(c());
    }

    public final synchronized void f(@Nullable BleSearchConfigBean bleSearchConfigBean, @Nullable zv zvVar) {
        Pair<Boolean, mt> pairA = pt.a.a();
        boolean zBooleanValue = pairA.component1().booleanValue();
        mt mtVarComponent2 = pairA.component2();
        if (!zBooleanValue) {
            if (zvVar != null) {
                zvVar.b(mtVarComponent2, null);
            }
            return;
        }
        if (c) {
            if (zvVar != null) {
                zvVar.a(mt.SEARCHING, null);
            }
        } else if (d()) {
            if (zvVar != null) {
                zvVar.b(mt.SEARCH_TOO_FAST, null);
            }
        } else {
            g(bleSearchConfigBean);
            c = true;
            lw.b.f(new a(zvVar));
        }
    }

    public final void g(BleSearchConfigBean bleSearchConfigBean) {
        Long timeout;
        e();
        if (bleSearchConfigBean == null || (timeout = bleSearchConfigBean.getTimeout()) == null) {
            return;
        }
        sw.a.c().postDelayed(a.c(), timeout.longValue());
    }

    public final synchronized void h() {
        e();
        c = false;
        lw.b.g();
    }
}
