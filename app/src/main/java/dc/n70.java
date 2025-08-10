package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetBt;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "turnOn", "", "(Ljava/lang/String;Z)V", "value", "getValue", "()Ljava/lang/String;", "verifyValues", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class n70 extends b90 {

    @NotNull
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n70(@NotNull String mac, boolean z) {
        super(pa0.a.b0(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.f = z ? "On" : "Off";
    }

    @Override // dc.b90
    public boolean g() {
        setValues(this.f);
        return true;
    }
}
