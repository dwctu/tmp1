package dc;

import java.util.Arrays;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class ra implements fa {
    public final String a;
    public final List<fa> b;
    public final boolean c;

    public ra(String str, List<fa> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new z7(h7Var, vaVar, this);
    }

    public List<fa> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + MessageFormatter.DELIM_STOP;
    }
}
