package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAIW;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "isValidNumberString", "", TypedValues.Custom.S_STRING, "verifyValues", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class r40 extends b90 {

    @NotNull
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r40(@NotNull String mac, @NotNull String value) {
        super(pa0.a.d(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f = value;
    }

    @Override // dc.b90
    public boolean g() {
        if (this.f.length() == 6 && h(this.f)) {
            setValues(this.f);
            return true;
        }
        onError(mt.ILLEGAL_ARGUMENT, getC() + " value is invalid");
        return false;
    }

    public final boolean h(String str) {
        return new Regex("^[0-9]{6}$").matches(str);
    }
}
