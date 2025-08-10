package dc;

import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyFirmwareUpdateFindDeviceEvent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/component/dxtoy/update/event/ToyFirmwareUpdateFindDeviceEvent;", "", "updateMac", "", "scanAllDeviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "getScanAllDeviceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getUpdateMac", "()Ljava/lang/String;", "getScanAllDeviceName", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class rc0 {

    @NotNull
    public final String a;

    @NotNull
    public final ConcurrentHashMap<String, BleSearchDeviceBean> b;

    public rc0(@NotNull String updateMac, @NotNull ConcurrentHashMap<String, BleSearchDeviceBean> scanAllDeviceMap) {
        Intrinsics.checkNotNullParameter(updateMac, "updateMac");
        Intrinsics.checkNotNullParameter(scanAllDeviceMap, "scanAllDeviceMap");
        this.a = updateMac;
        this.b = scanAllDeviceMap;
    }

    @NotNull
    public final ConcurrentHashMap<String, BleSearchDeviceBean> a() {
        return this.b;
    }

    @NotNull
    public final String b() {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, BleSearchDeviceBean>> setEntrySet = this.b.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "scanAllDeviceMap.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            sb.append(((BleSearchDeviceBean) ((Map.Entry) it.next()).getValue()).getName());
            sb.append(",");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getA() {
        return this.a;
    }
}
