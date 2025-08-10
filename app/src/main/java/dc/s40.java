package dc;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAP;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class s40 extends b90 {

    @NotNull
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s40(@NotNull String mac, @NotNull String value) {
        super(pa0.a.b(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f = value;
        f(CollectionsKt__CollectionsJVMKt.listOf(new IntRange(0, 497)));
        setLongCommand(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
    
        if ((139 <= r0 && r0 < 200) != false) goto L50;
     */
    @Override // dc.b90
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g() {
        /*
            r5 = this;
            dc.nb0 r0 = r5.c()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            boolean r0 = dc.tb0.n(r0)
            if (r0 != r1) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 != 0) goto L33
            dc.mt r0 = dc.mt.ILLEGAL_ARGUMENT
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Toy not support "
            r1.append(r3)
            java.lang.String r3 = r5.getC()
            r1.append(r3)
            java.lang.String r3 = " command"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r5.onError(r0, r1)
            return r2
        L33:
            java.lang.String r0 = r5.f
            int r0 = r0.length()
            if (r0 != 0) goto L3d
            r0 = 1
            goto L3e
        L3d:
            r0 = 0
        L3e:
            if (r0 != 0) goto Lba
            java.util.List r0 = r5.d()
            java.lang.Object r0 = r0.get(r2)
            kotlin.ranges.IntRange r0 = (kotlin.ranges.IntRange) r0
            java.lang.String r3 = r5.f
            int r3 = r3.length()
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L57
            goto Lba
        L57:
            dc.nb0 r0 = r5.c()
            if (r0 == 0) goto Lb2
            boolean r3 = dc.tb0.m(r0)
            if (r3 != 0) goto La8
            boolean r3 = dc.ub0.d(r0)
            if (r3 == 0) goto L7a
            int r3 = r0.getVersion()
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 > r3) goto L77
            r4 = 140(0x8c, float:1.96E-43)
            if (r3 >= r4) goto L77
            r3 = 1
            goto L78
        L77:
            r3 = 0
        L78:
            if (r3 != 0) goto La8
        L7a:
            boolean r3 = dc.ub0.e(r0)
            if (r3 == 0) goto L91
            int r3 = r0.getVersion()
            r4 = 215(0xd7, float:3.01E-43)
            if (r4 > r3) goto L8e
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 >= r4) goto L8e
            r3 = 1
            goto L8f
        L8e:
            r3 = 0
        L8f:
            if (r3 != 0) goto La8
        L91:
            boolean r3 = dc.ub0.g(r0)
            if (r3 == 0) goto Lb2
            int r0 = r0.getVersion()
            r3 = 139(0x8b, float:1.95E-43)
            if (r3 > r0) goto La5
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 >= r3) goto La5
            r0 = 1
            goto La6
        La5:
            r0 = 0
        La6:
            if (r0 == 0) goto Lb2
        La8:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r3 = r5.f
            r0[r2] = r3
            r5.setValues(r0)
            return r1
        Lb2:
            dc.mt r0 = dc.mt.ILLEGAL_ARGUMENT
            java.lang.String r1 = "Toy command value is invalid"
            r5.onError(r0, r1)
            return r2
        Lba:
            dc.mt r0 = dc.mt.ILLEGAL_ARGUMENT
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r5.getC()
            r1.append(r3)
            java.lang.String r3 = " command is empty, or too long"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r5.onError(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.s40.g():boolean");
    }
}
