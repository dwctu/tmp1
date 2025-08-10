package dc;

import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/component/dxbluetooth/lib/data/BleData;", "", "()V", "deviceBeanHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "getDeviceBeanHashMap$hytto_apps_android_components_core_dxbluetooth", "()Ljava/util/concurrent/ConcurrentHashMap;", "deviceBeanHashMap$delegate", "Lkotlin/Lazy;", "deviceHashMap", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "getDeviceHashMap$hytto_apps_android_components_core_dxbluetooth", "deviceHashMap$delegate", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class kt {

    @NotNull
    public static final kt a = new kt();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BleData.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxbluetooth/lib/bean/BleDeviceBean;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<ConcurrentHashMap<String, BleDeviceBean>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, BleDeviceBean> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    /* compiled from: BleData.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/component/dxbluetooth/lib/manager/BleDevice;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<ConcurrentHashMap<String, lu>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConcurrentHashMap<String, lu> invoke() {
            return new ConcurrentHashMap<>();
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, BleDeviceBean> a() {
        return (ConcurrentHashMap) c.getValue();
    }

    @NotNull
    public final ConcurrentHashMap<String, lu> b() {
        return (ConcurrentHashMap) b.getValue();
    }
}
