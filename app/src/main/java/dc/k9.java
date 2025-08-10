package dc;

import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class k9 {
    public final List<ra> a;
    public final char b;
    public final double c;
    public final String d;
    public final String e;

    public k9(List<ra> list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d2;
        this.d = str;
        this.e = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ra> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return c(this.b, this.e, this.d);
    }
}
