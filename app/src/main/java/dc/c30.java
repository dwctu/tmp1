package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDeviceTypeChangeEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/business/toyinfo/devicetype/event/ToyDeviceTypeChangeEvent;", "", "mac", "", "oldDeviceType", "newDeviceType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", "getNewDeviceType", "getOldDeviceType", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class c30 {

    @NotNull
    public final String a;

    @Nullable
    public final String b;

    public c30(@NotNull String mac, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getB() {
        return this.b;
    }
}
