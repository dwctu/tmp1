package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyDeviceTypeEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/component/dxtoy/business/toyinfo/devicetype/event/ToyDeviceTypeEvent;", "", "mac", "", "deviceType", "value", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getMac", "getSendCommand", "getValue", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class d30 {

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @NotNull
    public final String c;

    public d30(@NotNull String mac, @NotNull String deviceType, @NotNull String value, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        this.a = mac;
        this.b = deviceType;
        this.c = value;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getB() {
        return this.b;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getC() {
        return this.c;
    }
}
