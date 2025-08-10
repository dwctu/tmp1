package dc;

import dc.pw3;

/* compiled from: On.java */
/* loaded from: classes4.dex */
public class mw3 {

    /* compiled from: On.java */
    public class a implements b {
        public final /* synthetic */ pw3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pw3.a c;

        public a(pw3 pw3Var, String str, pw3.a aVar) {
            this.a = pw3Var;
            this.b = str;
            this.c = aVar;
        }

        @Override // dc.mw3.b
        public void destroy() {
            this.a.e(this.b, this.c);
        }
    }

    /* compiled from: On.java */
    public interface b {
        void destroy();
    }

    public static b a(pw3 pw3Var, String str, pw3.a aVar) {
        pw3Var.f(str, aVar);
        return new a(pw3Var, str, aVar);
    }
}
