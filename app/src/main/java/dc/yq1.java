package dc;

import dc.ToyControlBuilder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: IToyControlProxy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0016J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0002\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J.\u0010\u0002\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J&\u0010\r\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0016J*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J.\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/wear/component/dxtoy/command/control/listener/IToyControlSend;", "", "sendAllFunction", "", "motorV", "", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "motorF", "", "motorFs", "", "motorVs", "sendAllMap", "cmdMap", "", "sendFunction", "mac", "sendMap", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface yq1 {

    /* compiled from: IToyControlProxy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static void a(@NotNull yq1 yq1Var, int i) {
            yq1Var.e(i, new ToyControlBuilder((ToyControlBuilder.a) null, 1, (DefaultConstructorMarker) null));
        }

        public static void b(@NotNull yq1 yq1Var, @NotNull List<String> motorFs, @NotNull List<String> motorVs) {
            Intrinsics.checkNotNullParameter(motorFs, "motorFs");
            Intrinsics.checkNotNullParameter(motorVs, "motorVs");
            yq1Var.d(motorFs, motorVs, new ToyControlBuilder((ToyControlBuilder.a) null, 1, (DefaultConstructorMarker) null));
        }

        public static void c(@NotNull yq1 yq1Var, @NotNull Map<String, Integer> cmdMap) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            yq1Var.c(cmdMap, new ToyControlBuilder((ToyControlBuilder.a) null, 1, (DefaultConstructorMarker) null));
        }

        public static void d(@NotNull yq1 yq1Var, @NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            yq1Var.a(mac, i, new ToyControlBuilder((ToyControlBuilder.a) null, 1, (DefaultConstructorMarker) null));
        }

        public static void e(@NotNull yq1 yq1Var, @NotNull String mac, @NotNull Map<String, Integer> cmdMap) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            yq1Var.b(mac, cmdMap, new ToyControlBuilder((ToyControlBuilder.a) null, 1, (DefaultConstructorMarker) null));
        }
    }

    void a(@NotNull String str, int i, @NotNull ToyControlBuilder toyControlBuilder);

    void b(@NotNull String str, @NotNull Map<String, Integer> map, @NotNull ToyControlBuilder toyControlBuilder);

    void c(@NotNull Map<String, Integer> map, @NotNull ToyControlBuilder toyControlBuilder);

    void d(@NotNull List<String> list, @NotNull List<String> list2, @NotNull ToyControlBuilder toyControlBuilder);

    void e(int i, @NotNull ToyControlBuilder toyControlBuilder);
}
