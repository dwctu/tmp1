package dc;

import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseBluetoothBleSearcher.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0004J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/component/dxbluetooth/lib/search/BaseBluetoothBleSearcher;", "", "()V", "searchResponse", "Lcom/component/dxbluetooth/lib/search/BluetoothSearchResponse;", "cancelScanBluetooth", "", "notifyDeviceFounded", "device", "Lcom/component/dxbluetooth/lib/bean/BleSearchDeviceBean;", "notifySearchCanceled", "notifySearchStarted", "notifySearchStopped", "startScanBluetooth", Callback.METHOD_NAME, "stopScanBluetooth", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class jw {

    @Nullable
    public mw a;

    public void a() {
        c();
        this.a = null;
    }

    public final void b(@NotNull BleSearchDeviceBean device) {
        Intrinsics.checkNotNullParameter(device, "device");
        mw mwVar = this.a;
        if (mwVar == null) {
            return;
        }
        mwVar.d(device);
    }

    public final void c() {
        mw mwVar = this.a;
        if (mwVar == null) {
            return;
        }
        mwVar.a();
    }

    public final void d() {
        mw mwVar = this.a;
        if (mwVar == null) {
            return;
        }
        mwVar.c();
    }

    public final void e() {
        mw mwVar = this.a;
        if (mwVar == null) {
            return;
        }
        mwVar.b();
    }

    public void f(@Nullable mw mwVar) {
        this.a = mwVar;
        d();
    }

    public void g() {
        e();
        this.a = null;
    }
}
