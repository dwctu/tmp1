package dc;

import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class la implements fa {
    public final String a;
    public final a b;
    public final boolean c;

    /* compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public la(String str, a aVar, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = z;
    }

    @Override // dc.fa
    @Nullable
    public y7 a(h7 h7Var, va vaVar) {
        if (h7Var.o()) {
            return new h8(this);
        }
        dd.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + MessageFormatter.DELIM_STOP;
    }
}
