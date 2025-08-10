package dc;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: XXPermissions.java */
/* loaded from: classes2.dex */
public final class q61 {
    public static q51 e;
    public static Boolean f;

    @NonNull
    public final List<String> a = new ArrayList();

    @Nullable
    public final Context b;

    @Nullable
    public q51 c;

    @Nullable
    public Boolean d;

    /* compiled from: XXPermissions.java */
    public static class a implements q51 {
        @Override // dc.q51
        public /* synthetic */ void a(Activity activity, List list, u51 u51Var) {
            p51.d(this, activity, list, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void b(Activity activity, List list, List list2, boolean z, u51 u51Var) {
            p51.c(this, activity, list, list2, z, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void c(Activity activity, List list, boolean z, u51 u51Var) {
            p51.b(this, activity, list, z, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void d(Activity activity, List list, List list2, boolean z, u51 u51Var) {
            p51.a(this, activity, list, list2, z, u51Var);
        }
    }

    public q61(@Nullable Context context) {
        this.b = context;
    }

    public static List<String> a(@NonNull Context context, @NonNull List<String> list) {
        return w51.b(context, list);
    }

    public static List<String> b(@NonNull Context context, @NonNull String... strArr) {
        return a(context, m61.b(strArr));
    }

    public static q51 c() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public static boolean e(@NonNull Context context, @NonNull List<String> list) {
        return w51.g(context, list);
    }

    public static boolean f(@NonNull Context context, @NonNull String... strArr) {
        return e(context, m61.b(strArr));
    }

    public static void k(@NonNull Activity activity, @NonNull List<String> list) {
        l(activity, list, 1025);
    }

    public static void l(@NonNull Activity activity, @NonNull List<String> list, int i) {
        o61.d(activity, m61.m(activity, list), i);
    }

    public static q61 m(@NonNull Context context) {
        return new q61(context);
    }

    public static q61 n(@NonNull Fragment fragment) {
        return m(fragment.getActivity());
    }

    public final boolean d(@NonNull Context context) {
        if (this.d == null) {
            if (f == null) {
                f = Boolean.valueOf(m61.o(context));
            }
            this.d = f;
        }
        return this.d.booleanValue();
    }

    public q61 g(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!m61.g(this.a, str)) {
                    this.a.add(str);
                }
            }
        }
        return this;
    }

    public q61 h(@Nullable String... strArr) {
        g(m61.b(strArr));
        return this;
    }

    public q61 i(@Nullable String[]... strArr) {
        g(m61.c(strArr));
        return this;
    }

    public void j(@Nullable u51 u51Var) {
        if (this.b == null) {
            return;
        }
        if (this.c == null) {
            this.c = c();
        }
        Context context = this.b;
        q51 q51Var = this.c;
        ArrayList arrayList = new ArrayList(this.a);
        boolean zD = d(context);
        Activity activityI = m61.i(context);
        if (x51.a(activityI, zD) && x51.j(arrayList, zD)) {
            if (zD) {
                l51 l51VarK = m61.k(context);
                x51.g(context, arrayList);
                x51.l(context, arrayList, l51VarK);
                x51.b(arrayList);
                x51.c(arrayList);
                x51.k(activityI, arrayList, l51VarK);
                x51.i(arrayList, l51VarK);
                x51.h(arrayList, l51VarK);
                x51.m(context, arrayList);
                x51.f(context, arrayList, l51VarK);
            }
            x51.n(arrayList);
            if (!w51.g(context, arrayList)) {
                q51Var.a(activityI, arrayList, u51Var);
            } else if (u51Var != null) {
                q51Var.b(activityI, arrayList, arrayList, true, u51Var);
                q51Var.c(activityI, arrayList, true, u51Var);
            }
        }
    }
}
