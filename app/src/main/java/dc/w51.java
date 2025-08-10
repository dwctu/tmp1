package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PermissionApi.java */
/* loaded from: classes2.dex */
public final class w51 {

    @NonNull
    public static final y51 a;

    static {
        if (n51.f()) {
            a = new j61();
            return;
        }
        if (n51.e()) {
            a = new i61();
            return;
        }
        if (n51.d()) {
            a = new h61();
            return;
        }
        if (n51.c()) {
            a = new g61();
            return;
        }
        if (n51.o()) {
            a = new f61();
            return;
        }
        if (n51.n()) {
            a = new e61();
            return;
        }
        if (n51.l()) {
            a = new d61();
            return;
        }
        if (n51.j()) {
            a = new c61();
            return;
        }
        if (n51.i()) {
            a = new b61();
        } else if (n51.h()) {
            a = new a61();
        } else {
            a = new z51();
        }
    }

    public static boolean a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (j(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> b(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!f(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> c(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static List<String> d(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    public static Intent e(@NonNull Context context, @NonNull String str) {
        return a.c(context, str);
    }

    public static boolean f(@NonNull Context context, @NonNull String str) {
        return a.a(context, str);
    }

    public static boolean g(@NonNull Context context, @NonNull List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!f(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(@NonNull Activity activity, @NonNull String str) {
        return a.b(activity, str);
    }

    public static boolean i(@NonNull Activity activity, @NonNull List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (h(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(@NonNull String str) {
        return m61.q(str);
    }
}
