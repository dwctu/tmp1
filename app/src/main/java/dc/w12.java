package dc;

import java.util.Map;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlInterface.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class w12 {
    @JvmDefault
    public static boolean a(@Nullable x12 _this, @Nullable f22 f22Var, Map map) {
        e22 e22VarK;
        if (f22Var == null || (e22VarK = _this.k()) == null || !e22VarK.d(_this)) {
            return false;
        }
        e22VarK.a(_this, f22Var);
        if (f22Var == _this.e()) {
            f22Var.b(map);
            return true;
        }
        f22 f22VarE = _this.e();
        if (f22VarE != null) {
            f22VarE.c(map);
        }
        _this.c(f22Var);
        f22Var.b(map);
        return true;
    }

    @JvmDefault
    public static boolean b(@NotNull x12 _this, Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        f22 f22VarE = _this.e();
        return _this.b(f22VarE != null ? f22VarE.a(_this, event) : null, event.b());
    }
}
