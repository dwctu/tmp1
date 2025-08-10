package dc;

/* compiled from: MusicEvent.java */
/* loaded from: classes3.dex */
public class i12 {
    public int a;
    public int b;

    /* compiled from: MusicEvent.java */
    public static class a {
        public static i12 a() {
            return new i12(6);
        }

        public static i12 b(int i) {
            return new i12(4, i);
        }

        public static i12 c() {
            return new i12(7);
        }

        public static i12 d(int i) {
            return new i12(8, i);
        }

        public static i12 e() {
            return new i12(2);
        }

        public static i12 f() {
            return new i12(1);
        }

        public static i12 g(int i) {
            return new i12(16, i);
        }

        public static i12 h(int i) {
            return new i12(3, i);
        }

        public static i12 i() {
            return new i12(9);
        }

        public static i12 j() {
            return new i12(5);
        }
    }

    public i12(int i) {
        this.a = i;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public i12(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
