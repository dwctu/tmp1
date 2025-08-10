package dc;

/* compiled from: MagicFilterFactory.java */
/* loaded from: classes4.dex */
public class gi3 {

    /* compiled from: MagicFilterFactory.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[hi3.values().length];
            a = iArr;
            try {
                iArr[hi3.ANTIQUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[hi3.BRANNAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[hi3.FREUD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[hi3.HEFE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[hi3.HUDSON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[hi3.INKWELL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[hi3.N1977.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[hi3.NASHVILLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[hi3.COOL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[hi3.WARM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: MagicFilterFactory.java */
    public static class b extends uh3 {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        hi3 hi3Var = hi3.NONE;
    }

    public static uh3 a(hi3 hi3Var) {
        a aVar = null;
        if (hi3Var == null) {
            return null;
        }
        switch (a.a[hi3Var.ordinal()]) {
        }
        return null;
    }
}
