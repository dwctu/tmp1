package dc;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
public class aj implements jj {
    public final b a = new b();
    public final fj<a, Bitmap> b = new fj<>();

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    public static class a implements kj {
        public final b a;
        public int b;
        public int c;
        public Bitmap.Config d;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // dc.kj
        public void a() {
            this.a.c(this);
        }

        public void b(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return aj.f(this.b, this.c, this.d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    public static class b extends bj<a> {
        @Override // dc.bj
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i, int i2, Bitmap.Config config) {
            a aVarB = b();
            aVarB.b(i, i2, config);
            return aVarB;
        }
    }

    public static String f(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    public static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // dc.jj
    public String a(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // dc.jj
    public String b(int i, int i2, Bitmap.Config config) {
        return f(i, i2, config);
    }

    @Override // dc.jj
    public void c(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // dc.jj
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return this.b.a(this.a.e(i, i2, config));
    }

    @Override // dc.jj
    public int e(Bitmap bitmap) {
        return wp.h(bitmap);
    }

    @Override // dc.jj
    public Bitmap removeLast() {
        return this.b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
