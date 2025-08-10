package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.component.dxbluetooth.lib.receiver.BleReceiver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sun.jna.Callback;
import dc.bv;
import dc.cv;
import dc.dv;
import dc.ev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: BleListener.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001dH\u0002J(\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0018\u0010+\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0012\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010.\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u00101\u001a\u00020\u001bJ\u0012\u00102\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00103\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u00104\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0014J\u001e\u00105\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J&\u00106\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u00107\u001a\u00020\u0015J\u0012\u00108\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00109\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u0010:\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010;\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007Rq\u0010\u0012\u001aX\u0012\u0004\u0012\u00020\u0014\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00130\u0013j6\u0012\u0004\u0012\u00020\u0014\u0012,\u0012*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0004`\u0016`\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018¨\u0006<"}, d2 = {"Lcom/component/dxbluetooth/lib/manager/BleListener;", "Lcom/component/dxbluetooth/lib/listener/IBleListenerApi;", "()V", "bluetoothBondListenerList", "", "Lcom/component/dxbluetooth/lib/listener/IBluetoothBondListener;", "getBluetoothBondListenerList", "()Ljava/util/List;", "bluetoothBondListenerList$delegate", "Lkotlin/Lazy;", "bluetoothStateListenerList", "Lcom/component/dxbluetooth/lib/listener/IBluetoothStateListener;", "getBluetoothStateListenerList", "bluetoothStateListenerList$delegate", "connectStatusListenerMap", "Lcom/component/dxbluetooth/lib/listener/IBleConnectStatusListener;", "getConnectStatusListenerMap", "connectStatusListenerMap$delegate", "notifyResponseMap", "Ljava/util/HashMap;", "", "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "Lkotlin/collections/HashMap;", "getNotifyResponseMap", "()Ljava/util/HashMap;", "notifyResponseMap$delegate", "dispatchBluetoothStateChanged", "", "currentState", "", "dispatchBondStateChanged", "mac", "bondState", "dispatchCharacterNotify", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "dispatchConnectionStatus", "status", "failedResult", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "generateCharacterKey", "registerBluetoothBondListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerBluetoothPhyCallback", Callback.METHOD_NAME, "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "registerBluetoothReceiver", "registerBluetoothStateListener", "registerConnectStatusListener", "removeAllNotifyListener", "removeNotifyListener", "saveNotifyListener", SaslStreamElements.Response.ELEMENT, "unregisterBluetoothBondListener", "unregisterBluetoothPhyCallback", "unregisterBluetoothStateListener", "unregisterConnectStatusListener", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class mu {

    @NotNull
    public static final mu a = new mu();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy e = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/component/dxbluetooth/lib/listener/IBluetoothBondListener;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<ArrayList<ut>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ArrayList<ut> invoke() {
            return new ArrayList<>();
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/component/dxbluetooth/lib/listener/IBluetoothStateListener;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<ArrayList<wt>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ArrayList<wt> invoke() {
            return new ArrayList<>();
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/component/dxbluetooth/lib/listener/IBleConnectStatusListener;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<ArrayList<rt>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ArrayList<rt> invoke() {
            return new ArrayList<>();
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00010\u0001j \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d extends Lambda implements Function0<HashMap<String, HashMap<String, List<bw>>>> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, HashMap<String, List<bw>>> invoke() {
            return new HashMap<>();
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/component/dxbluetooth/lib/manager/BleListener$registerBluetoothReceiver$1", "Lcom/component/dxbluetooth/lib/receiver/listener/BluetoothStateChangeListener;", "onBluetoothStateChanged", "", "prevState", "", "curState", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements ev {
        @Override // dc.ev
        public void c(int i, int i2) {
            mu.a.e(i2);
        }

        @Override // dc.av
        @NotNull
        public String getName() {
            return ev.a.a(this);
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/component/dxbluetooth/lib/manager/BleListener$registerBluetoothReceiver$2", "Lcom/component/dxbluetooth/lib/receiver/listener/BluetoothBondStateChangeListener;", "onBondStateChanged", "", "mac", "", "bondState", "", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements dv {
        @Override // dc.dv
        public void b(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            mu.a.g(mac, i);
        }

        @Override // dc.av
        @NotNull
        public String getName() {
            return dv.a.a(this);
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/component/dxbluetooth/lib/manager/BleListener$registerBluetoothReceiver$3", "Lcom/component/dxbluetooth/lib/receiver/listener/BleConnectStatusChangeListener;", "onConnectStatusChanged", "", "mac", "", "status", "", "failedResult", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements cv {
        @Override // dc.cv
        public void a(@NotNull String mac, int i, @Nullable BleResultBean bleResultBean) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (i == lt.DISCONNECTED.getStatus()) {
                mu.a.A(mac);
            }
            mu.a.k(mac, i, bleResultBean);
        }

        @Override // dc.av
        @NotNull
        public String getName() {
            return cv.a.a(this);
        }
    }

    /* compiled from: BleListener.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/component/dxbluetooth/lib/manager/BleListener$registerBluetoothReceiver$4", "Lcom/component/dxbluetooth/lib/receiver/listener/BleCharacterChangeListener;", "onCharacterChanged", "", "mac", "", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h implements bv {
        @Override // dc.bv
        public void d(@Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
            if (str == null || uuid == null || uuid2 == null || bArr == null) {
                return;
            }
            mu.a.i(str, uuid, uuid2, bArr);
        }

        @Override // dc.av
        @NotNull
        public String getName() {
            return bv.a.a(this);
        }
    }

    public static final void f(wt listener, int i) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(i == 12);
    }

    public static final void h(ut listener, String mac, int i) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(mac, "$mac");
        listener.b(mac, i);
    }

    public static final void j(bw response, UUID service, UUID character, byte[] value) {
        Intrinsics.checkNotNullParameter(response, "$response");
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(character, "$character");
        Intrinsics.checkNotNullParameter(value, "$value");
        response.c(service, character, value);
    }

    public static final void l(rt listener, String mac, int i, BleResultBean bleResultBean) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(mac, "$mac");
        listener.a(mac, i, bleResultBean);
    }

    public final void A(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        q().remove(mac);
    }

    public final void B(@NotNull String mac, @NotNull UUID service, @NotNull UUID character, @NotNull bw response) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(character, "character");
        Intrinsics.checkNotNullParameter(response, "response");
        HashMap<String, List<bw>> map = q().get(mac);
        if (map == null) {
            map = new HashMap<>();
            q().put(mac, map);
        }
        String strM = m(service, character);
        List<bw> arrayList = map.get(strM);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(strM, arrayList);
        }
        arrayList.add(response);
    }

    public final void e(final int i) {
        if (i == 10 || i == 12) {
            for (final wt wtVar : o()) {
                se0.f(new Runnable() { // from class: dc.ku
                    @Override // java.lang.Runnable
                    public final void run() {
                        mu.f(wtVar, i);
                    }
                });
            }
        }
    }

    public final void g(final String str, final int i) {
        for (final ut utVar : n()) {
            se0.f(new Runnable() { // from class: dc.ju
                @Override // java.lang.Runnable
                public final void run() {
                    mu.h(utVar, str, i);
                }
            });
        }
    }

    public final void i(String str, final UUID uuid, final UUID uuid2, final byte[] bArr) {
        List<bw> list;
        HashMap<String, List<bw>> map = q().get(str);
        if (map == null || (list = map.get(m(uuid, uuid2))) == null) {
            return;
        }
        for (final bw bwVar : list) {
            se0.f(new Runnable() { // from class: dc.iu
                @Override // java.lang.Runnable
                public final void run() {
                    mu.j(bwVar, uuid, uuid2, bArr);
                }
            });
        }
    }

    public final void k(final String str, final int i, final BleResultBean bleResultBean) {
        for (final rt rtVar : p()) {
            se0.f(new Runnable() { // from class: dc.hu
                @Override // java.lang.Runnable
                public final void run() {
                    mu.l(rtVar, str, i, bleResultBean);
                }
            });
        }
    }

    public final String m(UUID uuid, UUID uuid2) {
        StringBuilder sb = new StringBuilder();
        sb.append(uuid);
        sb.append('_');
        sb.append(uuid2);
        return sb.toString();
    }

    public final List<ut> n() {
        return (List) e.getValue();
    }

    public final List<wt> o() {
        return (List) d.getValue();
    }

    public final List<rt> p() {
        return (List) c.getValue();
    }

    public final HashMap<String, HashMap<String, List<bw>>> q() {
        return (HashMap) b.getValue();
    }

    public void v(@Nullable ut utVar) {
        if (utVar == null || n().contains(utVar)) {
            return;
        }
        n().add(utVar);
    }

    public void w(@Nullable String str, @Nullable vt vtVar) {
        if (str == null) {
            return;
        }
        ot.a(kt.a, str).v(vtVar);
    }

    public final void x() {
        BleReceiver bleReceiver = BleReceiver.a;
        bleReceiver.h(new e());
        bleReceiver.h(new f());
        bleReceiver.h(new g());
        bleReceiver.h(new h());
    }

    public void y(@Nullable wt wtVar) {
        if (wtVar == null || o().contains(wtVar)) {
            return;
        }
        o().add(wtVar);
    }

    public void z(@Nullable rt rtVar) {
        if (rtVar == null || p().contains(rtVar)) {
            return;
        }
        p().add(rtVar);
    }
}
