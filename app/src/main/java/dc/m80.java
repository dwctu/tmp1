package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/component/dxtoy/command/code/CmdStartMove;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "(Ljava/lang/String;)V", "value", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class m80 extends b90 {

    @NotNull
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m80(@NotNull String mac) {
        super(pa0.a.A0(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.f = "30";
    }

    @Override // dc.b90
    public boolean g() {
        setValues(this.f);
        return true;
    }
}
