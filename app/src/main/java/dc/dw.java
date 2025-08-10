package dc;

import dc.qt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleReadRssiResponse.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "Lcom/component/dxbluetooth/lib/listener/IBaseBleResponse;", "", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface dw extends qt<Integer> {

    /* compiled from: BleReadRssiResponse.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(@NotNull dw dwVar, @NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(dwVar, "this");
            Intrinsics.checkNotNullParameter(code, "code");
            qt.a.a(dwVar, code, str);
        }
    }
}
