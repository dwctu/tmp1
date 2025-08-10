package dc;

import dc.sw;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleEnableInterceptor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbluetooth/lib/interceptor/BleEnableInterceptor;", "", "()V", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class pt {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BleEnableInterceptor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u0007"}, d2 = {"Lcom/component/dxbluetooth/lib/interceptor/BleEnableInterceptor$Companion;", "", "()V", "checkBleEnable", "Lkotlin/Pair;", "", "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Pair<Boolean, mt> a() {
            mt mtVar = mt.REQUEST_SUCCESS;
            sw.b bVar = sw.a;
            boolean z = false;
            if (!bVar.e()) {
                mtVar = mt.BLE_NOT_SUPPORT;
            } else if (!bVar.f()) {
                mtVar = mt.BLE_NOT_OPEN;
            } else if (bVar.a() == null) {
                mtVar = mt.BLE_NOT_ADAPTER;
            } else {
                z = true;
            }
            return new Pair<>(Boolean.valueOf(z), mtVar);
        }
    }
}
