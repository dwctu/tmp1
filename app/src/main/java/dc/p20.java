package dc;

import dc.sa0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdGetPattenHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ5\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/component/dxtoy/business/program/handler/ToyCmdGetPattenHandler;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "()V", "getPatten", "mac", "", "value", "", "handleCommand", "Unit", "bytes", "", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isHandle", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class p20 implements sa0<Unit> {

    @NotNull
    public static final p20 b = new p20();

    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // dc.sa0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(@org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull byte[] r6) {
        /*
            r3 = this;
            java.lang.String r0 = "mac"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            java.lang.String r4 = "p"
            boolean r4 = dc.d90.i(r5, r4)
            r6 = 1
            r0 = 0
            if (r4 == 0) goto L6d
            r4 = 2
            r1 = 0
            java.lang.String r2 = "/"
            boolean r4 = kotlin.text.StringsKt__StringsKt.contains$default(r5, r2, r0, r4, r1)
            if (r4 == 0) goto L6d
            kotlin.text.Regex r4 = new kotlin.text.Regex
            java.lang.String r1 = ":"
            r4.<init>(r1)
            java.util.List r4 = r4.split(r5, r0)
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L5e
            int r5 = r4.size()
            java.util.ListIterator r5 = r4.listIterator(r5)
        L3d:
            boolean r1 = r5.hasPrevious()
            if (r1 == 0) goto L5e
            java.lang.Object r1 = r5.previous()
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            if (r1 != 0) goto L51
            r1 = 1
            goto L52
        L51:
            r1 = 0
        L52:
            if (r1 != 0) goto L3d
            int r5 = r5.nextIndex()
            int r5 = r5 + r6
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.take(r4, r5)
            goto L62
        L5e:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L62:
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.Object[] r4 = r4.toArray(r5)
            int r4 = r4.length
            r5 = 3
            if (r4 != r5) goto L6d
            goto L6e
        L6d:
            r6 = 0
        L6e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.p20.a(java.lang.String, java.lang.String, byte[]):boolean");
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <Unit> Unit c(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        if (yb0.e(mac) == null) {
            return null;
        }
        d90.d(value, "p", null, null, 6, null);
        return null;
    }

    public final void d(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        new e60(mac, i).e();
    }

    @Override // dc.sa0
    @Nullable
    public ta0<Unit> getCallback() {
        return sa0.b.a(this);
    }
}
