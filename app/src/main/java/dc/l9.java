package dc;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class l9 {
    public static final l9 c = new l9("COMPOSITION");
    public final List<String> a;

    @Nullable
    public m9 b;

    public l9(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l9 a(String str) {
        l9 l9Var = new l9(this);
        l9Var.a.add(str);
        return l9Var;
    }

    public final boolean b() {
        return this.a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.a.size()) {
            return false;
        }
        boolean z = i == this.a.size() - 1;
        String str2 = this.a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.a.get(i + 1).equals(str)) {
            return i == this.a.size() + (-2) || (i == this.a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.a.size() - 1) {
            return false;
        }
        return this.a.get(i2).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m9 d() {
        return this.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (this.a.get(i).equals("**")) {
            return (i != this.a.size() - 1 && this.a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean f(String str) {
        return "__container".equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.a.size()) {
            return false;
        }
        return this.a.get(i).equals(str) || this.a.get(i).equals("**") || this.a.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        return "__container".equals(str) || i < this.a.size() - 1 || this.a.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l9 i(m9 m9Var) {
        l9 l9Var = new l9(this);
        l9Var.b = m9Var;
        return l9Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }

    public l9(l9 l9Var) {
        this.a = new ArrayList(l9Var.a);
        this.b = l9Var.b;
    }
}
