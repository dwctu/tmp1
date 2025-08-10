package dc;

import android.os.Handler;
import io.agora.rtm2.RtmConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnimPlayer.kt */
/* loaded from: classes3.dex */
public final class pg1 {

    @Nullable
    public dh1 a;

    @Nullable
    public sg1 b;

    @Nullable
    public qg1 c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;

    @Nullable
    public Runnable m;
    public boolean n;
    public boolean o;

    @NotNull
    public final og1 p;

    @NotNull
    public final vh1 q;

    @NotNull
    public final wg1 r;

    /* compiled from: AnimPlayer.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ ch1 b;

        public a(ch1 ch1Var) {
            this.b = ch1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            pg1.this.m(this.b);
        }
    }

    /* compiled from: AnimPlayer.kt */
    public static final class b implements Runnable {
        public final /* synthetic */ ch1 b;

        public b(ch1 ch1Var) {
            this.b = ch1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            dh1 dh1VarB;
            int iE = pg1.this.d().e(this.b, pg1.this.g(), pg1.this.l(), pg1.this.f());
            if (iE != 0) {
                pg1.this.z(false);
                sg1 sg1VarE = pg1.this.e();
                if (sg1VarE != null) {
                    sg1VarE.c(iE, rg1.b(rg1.a, iE, null, 2, null));
                }
                sg1 sg1VarE2 = pg1.this.e();
                if (sg1VarE2 != null) {
                    sg1VarE2.a();
                    return;
                }
                return;
            }
            xh1 xh1Var = xh1.c;
            xh1Var.d("AnimPlayer.AnimPlayer", "parse " + pg1.this.d().b());
            ng1 ng1VarB = pg1.this.d().b();
            if (ng1VarB == null || (!ng1VarB.k() && ((dh1VarB = pg1.this.b()) == null || !dh1VarB.f(ng1VarB)))) {
                xh1Var.d("AnimPlayer.AnimPlayer", "onVideoConfigReady return false");
            } else {
                pg1.this.m(this.b);
            }
        }
    }

    public pg1(@NotNull wg1 animView) {
        Intrinsics.checkParameterIsNotNull(animView, "animView");
        this.r = animView;
        this.j = 1;
        this.p = new og1(this);
        this.q = new vh1(this);
    }

    public final void A(int i) {
        this.j = i;
    }

    public final void B(@NotNull ch1 fileContainer) {
        ug1 ug1VarM;
        Handler handlerA;
        Intrinsics.checkParameterIsNotNull(fileContainer, "fileContainer");
        this.n = true;
        s();
        sg1 sg1Var = this.b;
        if (sg1Var == null || sg1Var.t()) {
            sg1 sg1Var2 = this.b;
            if (sg1Var2 == null || (ug1VarM = sg1Var2.m()) == null || (handlerA = ug1VarM.a()) == null) {
                return;
            }
            handlerA.post(new b(fileContainer));
            return;
        }
        this.n = false;
        sg1 sg1Var3 = this.b;
        if (sg1Var3 != null) {
            sg1Var3.c(RtmConstants.RTM_ERR_INVALID_TOPIC_NAME, "0x3 thread create fail");
        }
        sg1 sg1Var4 = this.b;
        if (sg1Var4 != null) {
            sg1Var4.a();
        }
    }

    @Nullable
    public final dh1 b() {
        return this.a;
    }

    @NotNull
    public final wg1 c() {
        return this.r;
    }

    @NotNull
    public final og1 d() {
        return this.p;
    }

    @Nullable
    public final sg1 e() {
        return this.b;
    }

    public final int f() {
        return this.e;
    }

    public final boolean g() {
        return this.i;
    }

    public final boolean h() {
        return this.h;
    }

    public final int i() {
        return this.f;
    }

    @NotNull
    public final vh1 j() {
        return this.q;
    }

    public final boolean k() {
        return this.g;
    }

    public final int l() {
        return this.j;
    }

    public final void m(ch1 ch1Var) {
        qg1 qg1Var;
        synchronized (pg1.class) {
            if (this.l) {
                this.n = false;
                sg1 sg1Var = this.b;
                if (sg1Var != null) {
                    sg1Var.z(ch1Var);
                }
                if (!this.o && (qg1Var = this.c) != null) {
                    qg1Var.i(ch1Var);
                }
            } else {
                this.m = new a(ch1Var);
                this.r.a();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean n() {
        return this.k;
    }

    public final boolean o() {
        if (!this.n) {
            sg1 sg1Var = this.b;
            if (!(sg1Var != null ? sg1Var.o() : false)) {
                return false;
            }
        }
        return true;
    }

    public final void p(int i, int i2) {
        this.l = true;
        Runnable runnable = this.m;
        if (runnable != null) {
            runnable.run();
        }
        this.m = null;
    }

    public final void q() {
        this.l = false;
        this.n = false;
        sg1 sg1Var = this.b;
        if (sg1Var != null) {
            sg1Var.g();
        }
        qg1 qg1Var = this.c;
        if (qg1Var != null) {
            qg1Var.c();
        }
    }

    public final void r(int i, int i2) {
        sg1 sg1Var = this.b;
        if (sg1Var != null) {
            sg1Var.q(i, i2);
        }
    }

    public final void s() {
        if (this.b == null) {
            vg1 vg1Var = new vg1(this);
            vg1Var.v(this.f);
            vg1Var.u(this.d);
            this.b = vg1Var;
        }
        if (this.c == null) {
            qg1 qg1Var = new qg1(this);
            qg1Var.h(this.f);
            this.c = qg1Var;
        }
    }

    public final void t(@Nullable dh1 dh1Var) {
        this.a = dh1Var;
    }

    public final void u(int i) {
        this.e = i;
    }

    public final void v(boolean z) {
        this.k = z;
    }

    public final void w(int i) {
        sg1 sg1Var = this.b;
        if (sg1Var != null) {
            sg1Var.u(i);
        }
        this.d = i;
    }

    public final void x(boolean z) {
        this.o = z;
    }

    public final void y(int i) {
        sg1 sg1Var = this.b;
        if (sg1Var != null) {
            sg1Var.v(i);
        }
        qg1 qg1Var = this.c;
        if (qg1Var != null) {
            qg1Var.h(i);
        }
        this.f = i;
    }

    public final void z(boolean z) {
        this.n = z;
    }
}
