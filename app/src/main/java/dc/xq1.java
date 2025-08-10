package dc;

import com.wear.bean.Toy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ICmdMapStrategy.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J,\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/wear/component/dxtoy/command/control/listener/ICmdMapStrategy;", "", "cmdMapHandleByToy", "", "cmdMap", "", "", "", "interceptor", "", "toy", "Lcom/wear/bean/Toy;", "builder", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "sendCommand", "valueMap", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface xq1 {

    /* compiled from: ICmdMapStrategy.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static boolean a(@NotNull xq1 xq1Var, @NotNull Map<String, Integer> cmdMap, @NotNull Toy toy, @NotNull ToyControlBuilder builder) {
            Intrinsics.checkNotNullParameter(cmdMap, "cmdMap");
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(builder, "builder");
            Function2<Toy, Map<String, Integer>, Boolean> function2A = builder.a();
            boolean zBooleanValue = function2A != null ? function2A.invoke(toy, cmdMap).booleanValue() : false;
            if (zBooleanValue) {
                cmdMap.clear();
            }
            return zBooleanValue;
        }
    }

    void a(@NotNull Map<String, Integer> map);

    void b(@NotNull Map<String, Integer> map);
}
