package dc;

import android.graphics.Path;
import androidx.annotation.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class qa implements fa {
    public final boolean a;
    public final Path.FillType b;
    public final String c;

    @Nullable
    public final q9 d;

    @Nullable
    public final t9 e;
    public final boolean f;

    public qa(String str, boolean z, Path.FillType fillType, @Nullable q9 q9Var, @Nullable t9 t9Var, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = q9Var;
        this.e = t9Var;
        this.f = z2;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new c8(h7Var, vaVar, this);
    }

    @Nullable
    public q9 b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Nullable
    public t9 e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + MessageFormatter.DELIM_STOP;
    }
}
