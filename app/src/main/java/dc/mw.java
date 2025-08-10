package dc;

import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: BluetoothSearchResponse.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/component/dxbluetooth/lib/search/BluetoothSearchResponse;", "", "onDeviceFounded", "", "device", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "onSearchCanceled", "onSearchStarted", "onSearchStopped", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface mw {
    void a();

    void b();

    void c();

    void d(@NotNull BleSearchDeviceBean bleSearchDeviceBean);
}
