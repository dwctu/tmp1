package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetPinC;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "valueLength", "", "isValidNumberString", "", TypedValues.Custom.S_STRING, "verifyValues", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b80 extends b90 {

    @NotNull
    public static final a h = new a(null);

    @NotNull
    public final String f;
    public final int g;

    /* compiled from: ToyCommandCode+Function.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/command/code/CmdSetPinC$Companion;", "", "()V", "initToyCommandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "mac", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final la0 b(String str) {
            pa0 pa0Var = pa0.a;
            la0 la0VarO0 = pa0Var.o0();
            nb0 nb0Var = hb0.a.e().get(str);
            boolean z = false;
            if (!(nb0Var != null ? ub0.h(nb0Var) : false)) {
                return la0VarO0;
            }
            if (nb0Var != null && nb0Var.getVersion() == 206) {
                z = true;
            }
            return z ? pa0Var.p0() : la0VarO0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b80(@NotNull String mac, @NotNull String value) {
        super(h.b(mac), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f = value;
        this.g = 6;
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (nb0VarC != null ? tb0.s(nb0VarC) : false) {
            if (this.f.length() == this.g && h(this.f)) {
                setValues(this.f);
                return true;
            }
            onError(mt.ILLEGAL_ARGUMENT, "Toy command value is invalid");
            return false;
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }

    public final boolean h(String str) {
        return new Regex("^[0-9]{6}$").matches(str);
    }
}
