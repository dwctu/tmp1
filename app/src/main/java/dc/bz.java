package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* compiled from: TestActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/component/dxhttp/test/Test;", "", "pf", "", RosterVer.ELEMENT, "(Ljava/lang/String;Ljava/lang/String;)V", "getPf", "()Ljava/lang/String;", "setPf", "(Ljava/lang/String;)V", "getVer", "setVer", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: dc.bz, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class Test {

    /* renamed from: a, reason: from toString */
    @NotNull
    public String pf;

    /* renamed from: b, reason: from toString */
    @NotNull
    public String ver;

    public Test() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Test(@NotNull String pf, @NotNull String ver) {
        Intrinsics.checkNotNullParameter(pf, "pf");
        Intrinsics.checkNotNullParameter(ver, "ver");
        this.pf = pf;
        this.ver = ver;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Test)) {
            return false;
        }
        Test test = (Test) other;
        return Intrinsics.areEqual(this.pf, test.pf) && Intrinsics.areEqual(this.ver, test.ver);
    }

    public int hashCode() {
        return (this.pf.hashCode() * 31) + this.ver.hashCode();
    }

    @NotNull
    public String toString() {
        return "Test(pf=" + this.pf + ", ver=" + this.ver + ')';
    }

    public /* synthetic */ Test(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "surfease-ios" : str, (i & 2) != 0 ? "9.9.9" : str2);
    }
}
