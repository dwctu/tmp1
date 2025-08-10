package dc;

import com.component.dxbluetooth.lib.bean.BleResultBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleConnectStatusChangeListener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/listener/BleConnectStatusChangeListener;", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "getName", "", "onConnectStatusChanged", "", "mac", "status", "", "failedResult", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface cv extends av {

    /* compiled from: BleConnectStatusChangeListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        @NotNull
        public static String a(@NotNull cv cvVar) {
            Intrinsics.checkNotNullParameter(cvVar, "this");
            String simpleName = cv.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "BleConnectStatusChangeLi…er::class.java.simpleName");
            return simpleName;
        }
    }

    void a(@NotNull String str, int i, @Nullable BleResultBean bleResultBean);
}
