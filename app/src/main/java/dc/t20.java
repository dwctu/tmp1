package dc;

import dc.f90;
import dc.sa0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdQCode.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J5\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/business/qcode/ToyCmdQCode;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "()V", "handleCommand", "Unit", "mac", "", "value", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isHandle", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class t20 implements sa0<Unit> {

    @NotNull
    public static final t20 b = new t20();

    public static final void d(String mac, String qCode) {
        Intrinsics.checkNotNullParameter(mac, "$mac");
        Intrinsics.checkNotNullParameter(qCode, "$qCode");
        f90.a.m(f90.a, mac, qCode, null, false, 12, null);
    }

    @Override // dc.sa0
    public boolean a(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ga0.g(value);
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <Unit> Unit c(@NotNull final String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        de0.i("handleCommand - QCode - " + mac + " - " + value);
        final String strD = ga0.d(value);
        Intrinsics.checkNotNullExpressionValue(strD, "getDecode(value)");
        if (re0.e(strD)) {
            return null;
        }
        se0.g(new Runnable() { // from class: dc.s20
            @Override // java.lang.Runnable
            public final void run() {
                t20.d(mac, strD);
            }
        }, 200L);
        return null;
    }

    @Override // dc.sa0
    @Nullable
    public ta0<Unit> getCallback() {
        return sa0.b.a(this);
    }
}
