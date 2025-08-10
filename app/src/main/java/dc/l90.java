package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: ToyScanConnectActionEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/core/api/event/ToyScanConnectActionEvent;", "", "mac", "", AMPExtension.Action.ATTRIBUTE_NAME, "", "deviceName", "rssi", "uuid", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAction", "()I", "getDeviceName", "()Ljava/lang/String;", "getMac", "getRssi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUuid", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class l90 {

    @NotNull
    public final String a;
    public final int b;

    @Nullable
    public final String c;

    @Nullable
    public final Integer d;

    @Nullable
    public final String e;

    public l90(@NotNull String mac, int i, @Nullable String str, @Nullable Integer num, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = i;
        this.c = str;
        this.d = num;
        this.e = str2;
    }

    /* renamed from: a, reason: from getter */
    public final int getB() {
        return this.b;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getD() {
        return this.d;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getE() {
        return this.e;
    }

    public /* synthetic */ l90(String str, int i, String str2, Integer num, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : str3);
    }
}
