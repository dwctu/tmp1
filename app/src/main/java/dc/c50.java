package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAutoSwith;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "turnOn1", "", "turnOn2", "(Ljava/lang/String;ZZ)V", "value1", "value2", "verifyValues", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c50 extends b90 {

    @NotNull
    public final String f;

    @NotNull
    public final String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c50(@NotNull String mac, boolean z, boolean z2) {
        super(pa0.a.e(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.f = z ? "On" : "Off";
        this.g = z2 ? "On" : "Off";
    }

    @Override // dc.b90
    public boolean g() {
        setValues(this.f, this.g);
        return true;
    }
}
