package dc;

/* compiled from: VideoVioceStatus.java */
/* loaded from: classes3.dex */
public class bd2 {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public void a(boolean z) {
        this.c = z;
        this.b = false;
        this.d = false;
    }

    public void b() {
        this.c = false;
    }

    public void c() {
        this.a = false;
        this.b = false;
        this.d = false;
        this.c = false;
    }

    public boolean d() {
        return this.a || this.d;
    }

    public boolean e() {
        return (this.a || this.d || this.b) ? false : true;
    }

    public boolean f() {
        return this.b;
    }

    public boolean g() {
        return this.c;
    }

    public void h() {
        this.b = false;
    }

    public boolean i() {
        return this.b || this.d || e();
    }

    public void j() {
        this.d = true;
    }

    public void k() {
        this.a = true;
        this.d = false;
        this.b = false;
    }

    public void l(boolean z) {
        this.c = z;
        this.b = true;
        this.d = false;
    }
}
