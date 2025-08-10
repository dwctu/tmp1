package dc;

import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import dc.ha0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyBtHyttoManager.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/hytto/ToyBtHyttoManager;", "", "()V", "isRequestListToy", "", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ea0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyBtHyttoManager.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0014\u001a\u00020\b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/hytto/ToyBtHyttoManager$Companion;", "", "()V", "DFU_DEVICE_NAME", "", "DFU_NEW_DEVICE_NAME", "OLD_DEVICE_NAME", "checkDfuDevice", "", "data", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "checkHyttoToy", "Lkotlin/Pair;", "Lcom/component/dxtoy/core/bluetooth/utils/UuidDeviceUtils$Device;", "isBond", "mac", "isHyttoToy", "device", "isPingCodeIntercept", "uuid", "removeBond", "btClass", "Ljava/lang/Class;", "btDevice", "Landroid/bluetooth/BluetoothDevice;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull BleSearchDeviceBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String name = data.getName();
            Locale locale = Locale.ROOT;
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (StringsKt__StringsJVMKt.startsWith$default(lowerCase, DfuBaseService.NOTIFICATION_CHANNEL_DFU, false, 2, null)) {
                return true;
            }
            String lowerCase2 = data.getName().toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return StringsKt__StringsJVMKt.startsWith$default(lowerCase2, "new", false, 2, null);
        }

        @NotNull
        public final Pair<Boolean, ha0.a> b(@NotNull BleSearchDeviceBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ha0.a aVarB = ha0.b(data.getMac(), data.getScanRecord(), data.getName());
            return new Pair<>(Boolean.valueOf(c(data, aVarB)), aVarB);
        }

        public final boolean c(BleSearchDeviceBean bleSearchDeviceBean, ha0.a aVar) {
            if (aVar != null) {
                return true;
            }
            String lowerCase = bleSearchDeviceBean.getName().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return StringsKt__StringsJVMKt.startsWith$default(lowerCase, "lvs", false, 2, null);
        }
    }
}
