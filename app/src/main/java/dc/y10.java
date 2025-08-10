package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyGetPinCodeEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/business/pincode/event/ToyGetPinCodeEvent;", "", "mac", "", "pinCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", "getPinCode", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class y10 {

    @NotNull
    public final String a;

    public y10(@NotNull String mac, @NotNull String pinCode) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(pinCode, "pinCode");
        this.a = mac;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getA() {
        return this.a;
    }
}
