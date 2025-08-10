package dc;

import android.app.Activity;
import androidx.annotation.NonNull;

/* compiled from: ControlWrapper.java */
/* loaded from: classes5.dex */
public class mj4 implements qj4, pj4 {
    public final qj4 a;
    public final pj4 b;

    public mj4(@NonNull qj4 qj4Var, @NonNull pj4 pj4Var) {
        this.a = qj4Var;
        this.b = pj4Var;
    }

    @Override // dc.pj4
    public void a() {
        this.b.a();
    }

    @Override // dc.pj4
    public boolean b() {
        return this.b.b();
    }

    @Override // dc.qj4
    public boolean c() {
        return this.a.c();
    }

    @Override // dc.qj4
    public void d(boolean z) {
        this.a.d(z);
    }

    @Override // dc.pj4
    public void e() {
        this.b.e();
    }

    @Override // dc.qj4
    public void f() {
        this.a.f();
    }

    @Override // dc.pj4
    public boolean g() {
        return this.b.g();
    }

    @Override // dc.qj4
    public int getBufferedPercentage() {
        return this.a.getBufferedPercentage();
    }

    @Override // dc.qj4
    public long getCurrentPosition() {
        return this.a.getCurrentPosition();
    }

    @Override // dc.pj4
    public int getCutoutHeight() {
        return this.b.getCutoutHeight();
    }

    @Override // dc.qj4
    public long getDuration() {
        return this.a.getDuration();
    }

    @Override // dc.qj4
    public float getSpeed() {
        return this.a.getSpeed();
    }

    @Override // dc.pj4
    public void h() {
        this.b.h();
    }

    @Override // dc.pj4
    public void i() {
        this.b.i();
    }

    @Override // dc.qj4
    public boolean isPlaying() {
        return this.a.isPlaying();
    }

    @Override // dc.pj4
    public boolean isShowing() {
        return this.b.isShowing();
    }

    @Override // dc.qj4
    public void j() {
        this.a.j();
    }

    @Override // dc.pj4
    public void k() {
        this.b.k();
    }

    public void l(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (c()) {
            activity.setRequestedOrientation(1);
            f();
        } else {
            activity.setRequestedOrientation(0);
            j();
        }
    }

    public void m() {
        setLocked(!g());
    }

    public void n() {
        if (isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    public void o() {
        if (isShowing()) {
            a();
        } else {
            show();
        }
    }

    @Override // dc.qj4
    public void pause() {
        this.a.pause();
    }

    @Override // dc.qj4
    public void seekTo(long j) {
        this.a.seekTo(j);
    }

    @Override // dc.pj4
    public void setLocked(boolean z) {
        this.b.setLocked(z);
    }

    @Override // dc.pj4
    public void show() {
        this.b.show();
    }

    @Override // dc.qj4
    public void start() {
        this.a.start();
    }
}
