package dc;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import dc.no;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class ko implements no, mo {
    public final Object a;

    @Nullable
    public final no b;
    public volatile mo c;
    public volatile mo d;

    @GuardedBy("requestLock")
    public no.a e;

    @GuardedBy("requestLock")
    public no.a f;

    public ko(Object obj, @Nullable no noVar) {
        no.a aVar = no.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.a = obj;
        this.b = noVar;
    }

    @Override // dc.no, dc.mo
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c.a() || this.d.a();
        }
        return z;
    }

    @Override // dc.no
    public boolean b(mo moVar) {
        boolean z;
        synchronized (this.a) {
            z = l() && j(moVar);
        }
        return z;
    }

    @Override // dc.no
    public boolean c(mo moVar) {
        boolean z;
        synchronized (this.a) {
            z = m() && j(moVar);
        }
        return z;
    }

    @Override // dc.mo
    public void clear() {
        synchronized (this.a) {
            no.a aVar = no.a.CLEARED;
            this.e = aVar;
            this.c.clear();
            if (this.f != aVar) {
                this.f = aVar;
                this.d.clear();
            }
        }
    }

    @Override // dc.no
    public void d(mo moVar) {
        synchronized (this.a) {
            if (moVar.equals(this.d)) {
                this.f = no.a.FAILED;
                no noVar = this.b;
                if (noVar != null) {
                    noVar.d(this);
                }
                return;
            }
            this.e = no.a.FAILED;
            no.a aVar = this.f;
            no.a aVar2 = no.a.RUNNING;
            if (aVar != aVar2) {
                this.f = aVar2;
                this.d.h();
            }
        }
    }

    @Override // dc.mo
    public boolean e() {
        boolean z;
        synchronized (this.a) {
            no.a aVar = this.e;
            no.a aVar2 = no.a.CLEARED;
            z = aVar == aVar2 && this.f == aVar2;
        }
        return z;
    }

    @Override // dc.no
    public void f(mo moVar) {
        synchronized (this.a) {
            if (moVar.equals(this.c)) {
                this.e = no.a.SUCCESS;
            } else if (moVar.equals(this.d)) {
                this.f = no.a.SUCCESS;
            }
            no noVar = this.b;
            if (noVar != null) {
                noVar.f(this);
            }
        }
    }

    @Override // dc.mo
    public boolean g(mo moVar) {
        if (!(moVar instanceof ko)) {
            return false;
        }
        ko koVar = (ko) moVar;
        return this.c.g(koVar.c) && this.d.g(koVar.d);
    }

    @Override // dc.no
    public no getRoot() {
        no root;
        synchronized (this.a) {
            no noVar = this.b;
            root = noVar != null ? noVar.getRoot() : this;
        }
        return root;
    }

    @Override // dc.mo
    public void h() {
        synchronized (this.a) {
            no.a aVar = this.e;
            no.a aVar2 = no.a.RUNNING;
            if (aVar != aVar2) {
                this.e = aVar2;
                this.c.h();
            }
        }
    }

    @Override // dc.no
    public boolean i(mo moVar) {
        boolean z;
        synchronized (this.a) {
            z = k() && j(moVar);
        }
        return z;
    }

    @Override // dc.mo
    public boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            no.a aVar = this.e;
            no.a aVar2 = no.a.SUCCESS;
            z = aVar == aVar2 || this.f == aVar2;
        }
        return z;
    }

    @Override // dc.mo
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            no.a aVar = this.e;
            no.a aVar2 = no.a.RUNNING;
            z = aVar == aVar2 || this.f == aVar2;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean j(mo moVar) {
        return moVar.equals(this.c) || (this.e == no.a.FAILED && moVar.equals(this.d));
    }

    @GuardedBy("requestLock")
    public final boolean k() {
        no noVar = this.b;
        return noVar == null || noVar.i(this);
    }

    @GuardedBy("requestLock")
    public final boolean l() {
        no noVar = this.b;
        return noVar == null || noVar.b(this);
    }

    @GuardedBy("requestLock")
    public final boolean m() {
        no noVar = this.b;
        return noVar == null || noVar.c(this);
    }

    public void n(mo moVar, mo moVar2) {
        this.c = moVar;
        this.d = moVar2;
    }

    @Override // dc.mo
    public void pause() {
        synchronized (this.a) {
            no.a aVar = this.e;
            no.a aVar2 = no.a.RUNNING;
            if (aVar == aVar2) {
                this.e = no.a.PAUSED;
                this.c.pause();
            }
            if (this.f == aVar2) {
                this.f = no.a.PAUSED;
                this.d.pause();
            }
        }
    }
}
