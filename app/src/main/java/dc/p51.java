package dc;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IPermissionInterceptor.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class p51 {
    public static void a(@NonNull q51 _this, @NonNull Activity activity, @NonNull List list, List list2, @Nullable boolean z, u51 u51Var) {
        if (u51Var == null) {
            return;
        }
        u51Var.a(list2, z);
    }

    public static void b(@NonNull q51 q51Var, @NonNull Activity activity, List list, @Nullable boolean z, u51 u51Var) {
    }

    public static void c(@NonNull q51 _this, @NonNull Activity activity, @NonNull List list, List list2, @Nullable boolean z, u51 u51Var) {
        if (u51Var == null) {
            return;
        }
        u51Var.b(list2, z);
    }

    public static void d(@NonNull q51 _this, @NonNull Activity activity, @Nullable List list, u51 u51Var) {
        k61.c(activity, new ArrayList(list), _this, u51Var);
    }
}
