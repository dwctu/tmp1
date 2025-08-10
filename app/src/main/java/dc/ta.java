package dc;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class ta implements fa {
    public final String a;

    @Nullable
    public final r9 b;
    public final List<r9> c;
    public final q9 d;
    public final t9 e;
    public final r9 f;
    public final b g;
    public final c h;
    public final float i;
    public final boolean j;

    /* compiled from: ShapeStroke.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.values().length];
            b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* compiled from: ShapeStroke.java */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ta(String str, @Nullable r9 r9Var, List<r9> list, q9 q9Var, t9 t9Var, r9 r9Var2, b bVar, c cVar, float f, boolean z) {
        this.a = str;
        this.b = r9Var;
        this.c = list;
        this.d = q9Var;
        this.e = t9Var;
        this.f = r9Var2;
        this.g = bVar;
        this.h = cVar;
        this.i = f;
        this.j = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new n8(h7Var, vaVar, this);
    }

    public b b() {
        return this.g;
    }

    public q9 c() {
        return this.d;
    }

    public r9 d() {
        return this.b;
    }

    public c e() {
        return this.h;
    }

    public List<r9> f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public t9 i() {
        return this.e;
    }

    public r9 j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
