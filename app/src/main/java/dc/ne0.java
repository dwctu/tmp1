package dc;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: SPUtils.java */
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes.dex */
public final class ne0 {
    public static final Map<String, ne0> b = new HashMap();
    public SharedPreferences a;

    public ne0(String str, int i) {
        this.a = ve0.a().getSharedPreferences(str, i);
    }

    public static ne0 d() {
        return f("", 0);
    }

    public static ne0 e(String str) {
        return f(str, 0);
    }

    public static ne0 f(String str, int i) {
        if (k(str)) {
            str = "spUtils";
        }
        Map<String, ne0> map = b;
        ne0 ne0Var = map.get(str);
        if (ne0Var == null) {
            synchronized (ne0.class) {
                ne0Var = map.get(str);
                if (ne0Var == null) {
                    ne0Var = new ne0(str, i);
                    map.put(str, ne0Var);
                }
            }
        }
        return ne0Var;
    }

    public static boolean k(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) b(str, cls, null);
    }

    public <T> T b(String str, Class<T> cls, @Nullable T t) {
        T t2;
        String string = this.a.getString(str, null);
        return (TextUtils.isEmpty(string) || (t2 = (T) xd0.h().fromJson(string, (Class) cls)) == null) ? t : t2;
    }

    public boolean c(@NonNull String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public String g(@NonNull String str) {
        return h(str, "");
    }

    public String h(@NonNull String str, String str2) {
        return this.a.getString(str, str2);
    }

    public Set<String> i(@NonNull String str) {
        return j(str, Collections.emptySet());
    }

    public Set<String> j(@NonNull String str, Set<String> set) {
        return this.a.getStringSet(str, set);
    }

    public void l(String str, Object obj) {
        m(str, xd0.h().toJson(obj));
    }

    public void m(@NonNull String str, String str2) {
        n(str, str2, false);
    }

    public void n(@NonNull String str, String str2, boolean z) {
        if (z) {
            this.a.edit().putString(str, str2).commit();
        } else {
            this.a.edit().putString(str, str2).apply();
        }
    }

    public void o(@NonNull String str, Set<String> set) {
        p(str, set, false);
    }

    public void p(@NonNull String str, Set<String> set, boolean z) {
        if (z) {
            this.a.edit().putStringSet(str, set).commit();
        } else {
            this.a.edit().putStringSet(str, set).apply();
        }
    }

    public void q(@NonNull String str, boolean z) {
        r(str, z, false);
    }

    public void r(@NonNull String str, boolean z, boolean z2) {
        if (z2) {
            this.a.edit().putBoolean(str, z).commit();
        } else {
            this.a.edit().putBoolean(str, z).apply();
        }
    }

    public void s(@NonNull String str) {
        t(str, false);
    }

    public void t(@NonNull String str, boolean z) {
        if (z) {
            this.a.edit().remove(str).commit();
        } else {
            this.a.edit().remove(str).apply();
        }
    }
}
