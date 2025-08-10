package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BluetoothBondStateChangeListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/listener/BluetoothBondStateChangeListener;", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "getName", "", "onBondStateChanged", "", "mac", "bondState", "", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface dv extends av {

    /* compiled from: BluetoothBondStateChangeListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        @NotNull
        public static String a(@NotNull dv dvVar) {
            Intrinsics.checkNotNullParameter(dvVar, "this");
            String simpleName = dv.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "BluetoothBondStateChange…er::class.java.simpleName");
            return simpleName;
        }
    }

    void b(@NotNull String str, int i);
}
