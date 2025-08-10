package dc;

import java.util.List;

/* compiled from: AbstractFileHeader.java */
/* loaded from: classes5.dex */
public abstract class e94 extends r94 {
    public byte[] a;
    public v94 b;
    public long c;
    public int g;
    public String h;
    public boolean i;
    public boolean k;
    public q94 l;
    public d94 m;
    public boolean n;
    public List<j94> o;
    public boolean p;
    public long d = 0;
    public long e = 0;
    public long f = 0;
    public w94 j = w94.NONE;

    public void A(int i) {
        this.g = i;
    }

    public void B(String str) {
        this.h = str;
    }

    public void C(int i) {
    }

    public void D(boolean z) {
        this.n = z;
    }

    public void E(byte[] bArr) {
        this.a = bArr;
    }

    public void F(long j) {
        this.c = j;
    }

    public void G(long j) {
        this.f = j;
    }

    public void H(int i) {
    }

    public void I(q94 q94Var) {
        this.l = q94Var;
    }

    public d94 b() {
        return this.m;
    }

    public long c() {
        return this.e;
    }

    public v94 d() {
        return this.b;
    }

    public long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e94)) {
            return i().equals(((e94) obj).i());
        }
        return false;
    }

    public w94 f() {
        return this.j;
    }

    public List<j94> g() {
        return this.o;
    }

    public int h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public byte[] j() {
        return this.a;
    }

    public long k() {
        return this.c;
    }

    public long l() {
        return this.f;
    }

    public q94 m() {
        return this.l;
    }

    public boolean n() {
        return this.k;
    }

    public boolean o() {
        return this.p;
    }

    public boolean p() {
        return this.i;
    }

    public boolean q() {
        return this.n;
    }

    public void r(d94 d94Var) {
        this.m = d94Var;
    }

    public void s(long j) {
        this.e = j;
    }

    public void t(v94 v94Var) {
        this.b = v94Var;
    }

    public void u(long j) {
        this.d = j;
    }

    public void v(boolean z) {
        this.k = z;
    }

    public void w(boolean z) {
        this.p = z;
    }

    public void x(boolean z) {
        this.i = z;
    }

    public void y(w94 w94Var) {
        this.j = w94Var;
    }

    public void z(List<j94> list) {
        this.o = list;
    }
}
