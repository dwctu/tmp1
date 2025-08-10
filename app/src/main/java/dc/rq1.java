package dc;

import dc.ar1;
import dc.br1;
import dc.cr1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlProxy.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\u0006H\u0096\u0001J\u0015\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001J\u001b\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0096\u0001J#\u0010\r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J%\u0010\r\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096\u0001J/\u0010\r\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u001d\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0017H\u0096\u0001J'\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001J#\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0096\u0001J+\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J-\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096\u0001J7\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J%\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0017H\u0096\u0001J/\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0006H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/wear/component/dxtoy/command/control/ToyControlProxy;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlSend;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlStop;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlSingle;", "()V", "airLevel", "", "mac", "", "value", "", "rotate", "rotateChange", "sendAllFunction", "motorV", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "motorF", "motorFs", "", "motorVs", "sendAllMap", "cmdMap", "", "sendFunction", "sendMap", "stopToysAction", "thrusting", "vibrate", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class rq1 implements yq1, zq1 {

    @NotNull
    public static final rq1 d = new rq1();
    public final /* synthetic */ ar1.a a = ar1.a;
    public final /* synthetic */ cr1.a b = cr1.a;
    public final /* synthetic */ br1.a c = br1.a;

    @Override // dc.yq1
    public void a(@NotNull String mac, int i, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.a(mac, i, builder);
    }

    @Override // dc.yq1
    public void b(@NotNull String mac, @NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.b(mac, cmdMap, builder);
    }

    @Override // dc.yq1
    public void c(@NotNull Map<String, Integer> cmdMap, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.c(cmdMap, builder);
    }

    @Override // dc.yq1
    public void d(@NotNull List<String> motorFs, @NotNull List<String> motorVs, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(motorFs, "motorFs");
        Intrinsics.checkNotNullParameter(motorVs, "motorVs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.d(motorFs, motorVs, builder);
    }

    @Override // dc.yq1
    public void e(int i, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.e(i, builder);
    }

    @Override // dc.zq1
    public void f(@Nullable String str) {
        this.c.f(str);
    }

    public void g(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.c.a(mac, i);
    }

    public void h(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.c.b(mac, i);
    }

    public void i() {
        this.c.c();
    }

    public void j(int i) {
        this.a.h(i);
    }

    public void k(@NotNull List<String> motorFs, @NotNull List<String> motorVs) {
        Intrinsics.checkNotNullParameter(motorFs, "motorFs");
        Intrinsics.checkNotNullParameter(motorVs, "motorVs");
        this.a.i(motorFs, motorVs);
    }

    public void l(@NotNull Map<String, Integer> cmdMap) {
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        this.a.j(cmdMap);
    }

    public void m(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a.k(mac, i);
    }

    public void n(@NotNull String mac, @NotNull String motorF, @NotNull String motorV, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(motorF, "motorF");
        Intrinsics.checkNotNullParameter(motorV, "motorV");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.l(mac, motorF, motorV, builder);
    }

    public void o(@NotNull String mac, @NotNull List<String> motorFs, @NotNull List<String> motorVs, @NotNull ToyControlBuilder builder) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(motorFs, "motorFs");
        Intrinsics.checkNotNullParameter(motorVs, "motorVs");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a.m(mac, motorFs, motorVs, builder);
    }

    public void p(@NotNull String mac, @NotNull Map<String, Integer> cmdMap) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
        this.a.n(mac, cmdMap);
    }

    public void q() {
        this.b.a();
    }

    public void r(@Nullable String str) {
        this.b.b(str);
    }

    public void s(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.c.d(mac, i);
    }

    public void t(@NotNull String mac, int i) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.c.e(mac, i);
    }
}
