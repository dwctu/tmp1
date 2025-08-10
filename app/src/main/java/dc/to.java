package dc;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import dc.no;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class to implements no, mo {

    @Nullable
    public final no a;
    public final Object b;
    public volatile mo c;
    public volatile mo d;

    @GuardedBy("requestLock")
    public no.a e;

    @GuardedBy("requestLock")
    public no.a f;

    @GuardedBy("requestLock")
    public boolean g;

    public to(Object obj, @Nullable no noVar) {
        no.a aVar = no.a.CLEARED;
        this.e = aVar;
        this.f = aVar;
        this.b = obj;
        this.a = noVar;
    }

    @Override // dc.no, dc.mo
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.d.a() || this.c.a();
        }
        return z;
    }

    @Override // dc.no
    public boolean b(mo moVar) {
        boolean z;
        synchronized (this.b) {
            z = k() && moVar.equals(this.c) && !a();
        }
        return z;
    }

    @Override // dc.no
    public boolean c(mo moVar) {
        boolean z;
        synchronized (this.b) {
            z = l() && (moVar.equals(this.c) || this.e != no.a.SUCCESS);
        }
        return z;
    }

    @Override // dc.mo
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            no.a aVar = no.a.CLEARED;
            this.e = aVar;
            this.f = aVar;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // dc.no
    public void d(mo moVar) {
        synchronized (this.b) {
            if (!moVar.equals(this.c)) {
                this.f = no.a.FAILED;
                return;
            }
            this.e = no.a.FAILED;
            no noVar = this.a;
            if (noVar != null) {
                noVar.d(this);
            }
        }
    }

    @Override // dc.mo
    public boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == no.a.CLEARED;
        }
        return z;
    }

    @Override // dc.no
    public void f(mo moVar) {
        synchronized (this.b) {
            if (moVar.equals(this.d)) {
                this.f = no.a.SUCCESS;
                return;
            }
            this.e = no.a.SUCCESS;
            no noVar = this.a;
            if (noVar != null) {
                noVar.f(this);
            }
            if (!this.f.isComplete()) {
                this.d.clear();
            }
        }
    }

    @Override // dc.mo
    public boolean g(mo moVar) {
        if (!(moVar instanceof to)) {
            return false;
        }
        to toVar = (to) moVar;
        if (this.c == null) {
            if (toVar.c != null) {
                return false;
            }
        } else if (!this.c.g(toVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (toVar.d != null) {
                return false;
            }
        } else if (!this.d.g(toVar.d)) {
            return false;
        }
        return true;
    }

    @Override // dc.no
    public no getRoot() {
        no root;
        synchronized (this.b) {
            no noVar = this.a;
            root = noVar != null ? noVar.getRoot() : this;
        }
        return root;
    }

    @Override // dc.mo
    public void h() {
        synchronized (this.b) {
            this.g = true;
            try {
                if (this.e != no.a.SUCCESS) {
                    no.a aVar = this.f;
                    no.a aVar2 = no.a.RUNNING;
                    if (aVar != aVar2) {
                        this.f = aVar2;
                        this.d.h();
                    }
                }
                if (this.g) {
                    no.a aVar3 = this.e;
                    no.a aVar4 = no.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.e = aVar4;
                        this.c.h();
                    }
                }
            } finally {
                this.g = false;
            }
        }
    }

    @Override // dc.no
    public boolean i(mo moVar) {
        boolean z;
        synchronized (this.b) {
            z = j() && moVar.equals(this.c) && this.e != no.a.PAUSED;
        }
        return z;
    }

    @Override // dc.mo
    public boolean isComplete() {
        boolean z;
        synchronized (this.b) {
            z = this.e == no.a.SUCCESS;
        }
        return z;
    }

    @Override // dc.mo
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == no.a.RUNNING;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final boolean j() {
        no noVar = this.a;
        return noVar == null || noVar.i(this);
    }

    @GuardedBy("requestLock")
    public final boolean k() {
        no noVar = this.a;
        return noVar == null || noVar.b(this);
    }

    @GuardedBy("requestLock")
    public final boolean l() {
        no noVar = this.a;
        return noVar == null || noVar.c(this);
    }

    public void m(mo moVar, mo moVar2) {
        this.c = moVar;
        this.d = moVar2;
    }

    @Override // dc.mo
    public void pause() {
        synchronized (this.b) {
            if (!this.f.isComplete()) {
                this.f = no.a.PAUSED;
                this.d.pause();
            }
            if (!this.e.isComplete()) {
                this.e = no.a.PAUSED;
                this.c.pause();
            }
        }
    }
}
