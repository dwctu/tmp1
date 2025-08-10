package dc;

import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;

/* compiled from: QuackUtil.java */
/* loaded from: classes4.dex */
public class wf3 {
    public static wf3 b;
    public is3 a;

    /* compiled from: QuackUtil.java */
    public class a implements is3.c {
        public a(wf3 wf3Var) {
        }

        @Override // dc.is3.c
        public void doCancel() {
        }
    }

    /* compiled from: QuackUtil.java */
    public class b implements is3.d {
        public b(wf3 wf3Var) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public static wf3 b() {
        if (b == null) {
            synchronized (wf3.class) {
                if (b == null) {
                    b = new wf3();
                }
            }
        }
        return b;
    }

    public void a() {
        if (og3.a(11)) {
            is3 is3Var = this.a;
            if (is3Var == null || !is3Var.isShowing()) {
                MyApplication myApplication = WearUtils.x;
                FragmentActivity fragmentActivityH = MyApplication.H();
                if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing() || eg3.f(WearUtils.x, WearUtils.r0("quakeChangeName"), 0) != 0) {
                    return;
                }
                is3.b bVar = new is3.b(fragmentActivityH);
                bVar.p(ah4.e(R.string.notification_dolce_replaced_quake));
                bVar.d(new b(this));
                bVar.c(new a(this));
                bVar.b(false);
                is3 is3VarH = cs3.h(bVar);
                this.a = is3VarH;
                is3VarH.show();
                eg3.k(WearUtils.x, WearUtils.r0("quakeChangeName"), 1);
            }
        }
    }
}
