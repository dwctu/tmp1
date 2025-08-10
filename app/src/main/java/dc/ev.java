package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BluetoothStateChangeListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/listener/BluetoothStateChangeListener;", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "getName", "", "onBluetoothStateChanged", "", "prevState", "", "curState", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ev extends av {

    /* compiled from: BluetoothStateChangeListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        @NotNull
        public static String a(@NotNull ev evVar) {
            Intrinsics.checkNotNullParameter(evVar, "this");
            String simpleName = ev.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "BluetoothStateChangeList…er::class.java.simpleName");
            return simpleName;
        }
    }

    void c(int i, int i2);
}
