package dc;

/* compiled from: AESExtraDataRecord.java */
/* loaded from: classes5.dex */
public class d94 extends r94 {
    public u94 a;
    public t94 b;
    public v94 c;

    public d94() {
        a(o84.AES_EXTRA_DATA_RECORD);
        this.a = u94.TWO;
        this.b = t94.KEY_STRENGTH_256;
        this.c = v94.DEFLATE;
    }

    public t94 b() {
        return this.b;
    }

    public u94 c() {
        return this.a;
    }

    public v94 d() {
        return this.c;
    }

    public void e(t94 t94Var) {
        this.b = t94Var;
    }

    public void f(u94 u94Var) {
        this.a = u94Var;
    }

    public void g(v94 v94Var) {
        this.c = v94Var;
    }

    public void h(int i) {
    }

    public void i(String str) {
    }
}
