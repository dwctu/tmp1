package dc;

import android.os.Build;

/* compiled from: DownsampleStrategy.java */
/* loaded from: classes.dex */
public abstract class ql {
    public static final ql a = new c();
    public static final ql b = new a();
    public static final ql c;
    public static final ql d;
    public static final ql e;
    public static final zg<ql> f;
    public static final boolean g;

    /* compiled from: DownsampleStrategy.java */
    public static class a extends ql {
        @Override // dc.ql
        public e a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? e.QUALITY : ql.a.a(i, i2, i3, i4);
        }

        @Override // dc.ql
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, ql.a.b(i, i2, i3, i4));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    public static class b extends ql {
        @Override // dc.ql
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // dc.ql
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    public static class c extends ql {
        @Override // dc.ql
        public e a(int i, int i2, int i3, int i4) {
            return ql.g ? e.QUALITY : e.MEMORY;
        }

        @Override // dc.ql
        public float b(int i, int i2, int i3, int i4) {
            if (ql.g) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    public static class d extends ql {
        @Override // dc.ql
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // dc.ql
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    public enum e {
        MEMORY,
        QUALITY
    }

    static {
        b bVar = new b();
        c = bVar;
        d = new d();
        e = bVar;
        f = zg.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", bVar);
        g = Build.VERSION.SDK_INT >= 19;
    }

    public abstract e a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
