package dc;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* compiled from: BasePickerView.java */
/* loaded from: classes.dex */
public class gf {
    public Context b;
    public ViewGroup c;
    public ViewGroup d;
    public ViewGroup e;
    public ViewGroup f;
    public cf k;
    public boolean l;
    public Animation m;
    public Animation n;
    public boolean o;
    public Dialog q;
    public boolean r;
    public View s;
    public final FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -2, 80);
    public int g = -16417281;
    public int h = -657931;
    public int i = ViewCompat.MEASURED_STATE_MASK;
    public int j = -1;
    public int p = 80;
    public boolean t = true;
    public View.OnKeyListener u = new d();
    public final View.OnTouchListener v = new e();

    /* compiled from: BasePickerView.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gf.this.f();
        }
    }

    /* compiled from: BasePickerView.java */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            gf.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: BasePickerView.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gf gfVar = gf.this;
            gfVar.d.removeView(gfVar.e);
            gf.this.o = false;
            gf.this.l = false;
            if (gf.this.k != null) {
                gf.this.k.a(gf.this);
            }
        }
    }

    /* compiled from: BasePickerView.java */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !gf.this.p()) {
                return false;
            }
            gf.this.f();
            return true;
        }
    }

    /* compiled from: BasePickerView.java */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            gf.this.f();
            return false;
        }
    }

    /* compiled from: BasePickerView.java */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (gf.this.k != null) {
                gf.this.k.a(gf.this);
            }
        }
    }

    public gf(Context context) {
        this.b = context;
    }

    public void e() {
        if (this.f != null) {
            Dialog dialog = new Dialog(this.b, qe.custom_dialog2);
            this.q = dialog;
            dialog.setCancelable(this.r);
            this.q.setContentView(this.f);
            this.q.getWindow().setWindowAnimations(qe.pickerview_dialogAnim);
            this.q.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (o()) {
            g();
            return;
        }
        if (this.l) {
            return;
        }
        if (this.t) {
            this.m.setAnimationListener(new b());
            this.c.startAnimation(this.m);
        } else {
            h();
        }
        this.l = true;
    }

    public void g() {
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void h() {
        this.d.post(new c());
    }

    public View i(int i) {
        return this.c.findViewById(i);
    }

    public Animation j() {
        return AnimationUtils.loadAnimation(this.b, ff.a(this.p, true));
    }

    public Animation k() {
        return AnimationUtils.loadAnimation(this.b, ff.a(this.p, false));
    }

    public void l() {
        this.n = j();
        this.m = k();
    }

    public void m() {
    }

    public void n(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.b);
        if (o()) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(oe.layout_basepickerview, (ViewGroup) null, false);
            this.f = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(ne.content_container);
            this.c = viewGroup2;
            FrameLayout.LayoutParams layoutParams = this.a;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f.setOnClickListener(new a());
        } else {
            if (this.d == null) {
                this.d = (ViewGroup) ((Activity) this.b).getWindow().getDecorView().findViewById(R.id.content);
            }
            ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(oe.layout_basepickerview, this.d, false);
            this.e = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (i != 0) {
                this.e.setBackgroundColor(i);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.e.findViewById(ne.content_container);
            this.c = viewGroup4;
            viewGroup4.setLayoutParams(this.a);
        }
        s(true);
    }

    public boolean o() {
        throw null;
    }

    public boolean p() {
        if (o()) {
            return false;
        }
        return this.e.getParent() != null || this.o;
    }

    public final void q(View view) {
        this.d.addView(view);
        if (this.t) {
            this.c.startAnimation(this.n);
        }
    }

    public void r(boolean z) {
        this.r = z;
    }

    public void s(boolean z) {
        ViewGroup viewGroup = o() ? this.f : this.e;
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.u);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public gf t(boolean z) {
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(ne.outmost_container);
            if (z) {
                viewFindViewById.setOnTouchListener(this.v);
            } else {
                viewFindViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void u() {
        if (o()) {
            w();
        } else {
            if (p()) {
                return;
            }
            this.o = true;
            q(this.e);
            this.e.requestFocus();
        }
    }

    public void v(boolean z) {
        this.t = z;
        u();
    }

    public void w() {
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.show();
        }
    }
}
