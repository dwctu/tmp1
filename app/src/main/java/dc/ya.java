package dc;

import androidx.annotation.Nullable;
import com.broadcom.bt.util.io.IOUtils;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* loaded from: classes.dex */
public class ya {
    public final List<fa> a;
    public final f7 b;
    public final String c;
    public final long d;
    public final a e;
    public final long f;

    @Nullable
    public final String g;
    public final List<ka> h;
    public final ba i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;

    @Nullable
    public final z9 q;

    @Nullable
    public final aa r;

    @Nullable
    public final r9 s;
    public final List<id<Float>> t;
    public final b u;
    public final boolean v;

    /* compiled from: Layer.java */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Layer.java */
    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public ya(List<fa> list, f7 f7Var, String str, long j, a aVar, long j2, @Nullable String str2, List<ka> list2, ba baVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable z9 z9Var, @Nullable aa aaVar, List<id<Float>> list3, b bVar, @Nullable r9 r9Var, boolean z) {
        this.a = list;
        this.b = f7Var;
        this.c = str;
        this.d = j;
        this.e = aVar;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = baVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = z9Var;
        this.r = aaVar;
        this.t = list3;
        this.u = bVar;
        this.s = r9Var;
        this.v = z;
    }

    public f7 a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    public List<id<Float>> c() {
        return this.t;
    }

    public a d() {
        return this.e;
    }

    public List<ka> e() {
        return this.h;
    }

    public b f() {
        return this.u;
    }

    public String g() {
        return this.c;
    }

    public long h() {
        return this.f;
    }

    public int i() {
        return this.p;
    }

    public int j() {
        return this.o;
    }

    @Nullable
    public String k() {
        return this.g;
    }

    public List<fa> l() {
        return this.a;
    }

    public int m() {
        return this.l;
    }

    public int n() {
        return this.k;
    }

    public int o() {
        return this.j;
    }

    public float p() {
        return this.n / this.b.e();
    }

    @Nullable
    public z9 q() {
        return this.q;
    }

    @Nullable
    public aa r() {
        return this.r;
    }

    @Nullable
    public r9 s() {
        return this.s;
    }

    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    public ba u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        ya yaVarS = this.b.s(h());
        if (yaVarS != null) {
            sb.append("\t\tParents: ");
            sb.append(yaVarS.g());
            ya yaVarS2 = this.b.s(yaVarS.h());
            while (yaVarS2 != null) {
                sb.append("->");
                sb.append(yaVarS2.g());
                yaVarS2 = this.b.s(yaVarS2.h());
            }
            sb.append(str);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (fa faVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(faVar);
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }
}
