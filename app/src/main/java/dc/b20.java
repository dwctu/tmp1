package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToySetPinCodeStatusEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/business/pincode/event/ToySetPinCodeStatusEvent;", "", "mac", "", "state", "", "(Ljava/lang/String;I)V", "getMac", "()Ljava/lang/String;", "getState", "()I", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b20 {

    @NotNull
    public final String a;
    public final int b;

    public b20(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = i;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* renamed from: b, reason: from getter */
    public final int getB() {
        return this.b;
    }
}
