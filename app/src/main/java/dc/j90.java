package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyOnReceiveCommandEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/component/dxtoy/core/api/event/ToyOnReceiveCommandEvent;", "", "mac", "", "command", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)V", "getBytes", "()[B", "getCommand", "()Ljava/lang/String;", "getMac", "getSendCommand", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class j90 {

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @NotNull
    public final byte[] c;

    public j90(@NotNull String mac, @NotNull String command, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        this.a = mac;
        this.b = command;
        this.c = bytes;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final byte[] getC() {
        return this.c;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getB() {
        return this.b;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getA() {
        return this.a;
    }
}
