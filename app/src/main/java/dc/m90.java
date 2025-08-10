package dc;

import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyScanDFUDeviceEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/core/api/event/ToyScanDFUDeviceEvent;", "", "data", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "(Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;)V", "getData", "()Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class m90 {

    @NotNull
    public final BleSearchDeviceBean a;

    public m90(@NotNull BleSearchDeviceBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final BleSearchDeviceBean getA() {
        return this.a;
    }
}
