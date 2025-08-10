package dc;

/* compiled from: Segment.java */
/* loaded from: classes5.dex */
public final class be4 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public be4 f;
    public be4 g;

    public be4() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        be4 be4Var = this.g;
        if (be4Var == this) {
            throw new IllegalStateException();
        }
        if (be4Var.e) {
            int i = this.c - this.b;
            if (i > (8192 - be4Var.c) + (be4Var.d ? 0 : be4Var.b)) {
                return;
            }
            g(be4Var, i);
            b();
            ce4.a(this);
        }
    }

    public final be4 b() {
        be4 be4Var = this.f;
        be4 be4Var2 = be4Var != this ? be4Var : null;
        be4 be4Var3 = this.g;
        be4Var3.f = be4Var;
        this.f.g = be4Var3;
        this.f = null;
        this.g = null;
        return be4Var2;
    }

    public final be4 c(be4 be4Var) {
        be4Var.g = this;
        be4Var.f = this.f;
        this.f.g = be4Var;
        this.f = be4Var;
        return be4Var;
    }

    public final be4 d() {
        this.d = true;
        return new be4(this.a, this.b, this.c, true, false);
    }

    public final be4 e(int i) {
        be4 be4VarB;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            be4VarB = d();
        } else {
            be4VarB = ce4.b();
            System.arraycopy(this.a, this.b, be4VarB.a, 0, i);
        }
        be4VarB.c = be4VarB.b + i;
        this.b += i;
        this.g.c(be4VarB);
        return be4VarB;
    }

    public final be4 f() {
        return new be4((byte[]) this.a.clone(), this.b, this.c, false, true);
    }

    public final void g(be4 be4Var, int i) {
        if (!be4Var.e) {
            throw new IllegalArgumentException();
        }
        int i2 = be4Var.c;
        if (i2 + i > 8192) {
            if (be4Var.d) {
                throw new IllegalArgumentException();
            }
            int i3 = be4Var.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = be4Var.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            be4Var.c -= be4Var.b;
            be4Var.b = 0;
        }
        System.arraycopy(this.a, this.b, be4Var.a, be4Var.c, i);
        be4Var.c += i;
        this.b += i;
    }

    public be4(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
