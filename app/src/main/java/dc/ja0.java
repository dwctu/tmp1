package dc;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandReceive.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/ToyCommandReceive;", "", "()V", "dispatch", "", "mac", "", "command", "bytes", "", "sendCommand", "intercept", "onReceiveCommand", "", "sendCommandEvent", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ja0 {
    public final boolean a(String str, String str2, byte[] bArr, String str3) {
        return ia0.a.b().a(str, str2, bArr, str3);
    }

    public final boolean b(String str, String str2, byte[] bArr) {
        return false;
    }

    public final void c(@NotNull String mac, @NotNull String command, @NotNull byte[] bytes) {
        g90 g90VarB;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (b(mac, command, bytes)) {
            return;
        }
        Triple<String, byte[], String> tripleK = eb0.a.k(mac, command, bytes);
        String strComponent1 = tripleK.component1();
        byte[] bArrComponent2 = tripleK.component2();
        String strComponent3 = tripleK.component3();
        if (a(mac, strComponent1, bArrComponent2, strComponent3) && (g90VarB = hb0.a.b()) != null && g90VarB.b()) {
            return;
        }
        d(mac, strComponent1, bArrComponent2, strComponent3);
    }

    public final void d(String str, String str2, byte[] bArr, String str3) {
        wb0.a.a(new j90(str, str2, bArr, str3));
    }
}
