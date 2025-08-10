package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import dc.lp1;

/* compiled from: TestPop.java */
/* loaded from: classes4.dex */
public class ls3 {
    public final String a;
    public Context b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public PopupWindow g;
    public View h;

    /* compiled from: TestPop.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lp1.a aVar = lp1.a;
            ls3 ls3Var = ls3.this;
            aVar.e(ls3Var.b, ls3Var.a);
            ls3.this.g.dismiss();
        }
    }

    /* compiled from: TestPop.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lp1.a aVar = lp1.a;
            ls3 ls3Var = ls3.this;
            aVar.e(ls3Var.b, ls3Var.a);
            ls3.this.g.dismiss();
        }
    }

    /* compiled from: TestPop.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lp1.a aVar = lp1.a;
            ls3 ls3Var = ls3.this;
            aVar.e(ls3Var.b, ls3Var.a);
            ls3.this.g.dismiss();
        }
    }

    /* compiled from: TestPop.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ls3.this.g.dismiss();
        }
    }

    /* compiled from: TestPop.java */
    public class e implements PopupWindow.OnDismissListener {
        public e() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ls3.this.c(1.0f);
        }
    }

    public ls3(Context context, String str) {
        this.b = context;
        this.a = str;
        d();
    }

    public void c(float f) {
        try {
            WindowManager.LayoutParams attributes = ((Activity) this.b).getWindow().getAttributes();
            attributes.alpha = f;
            if (f == 1.0f) {
                ((Activity) this.b).getWindow().clearFlags(2);
            } else {
                ((Activity) this.b).getWindow().addFlags(2);
            }
            ((Activity) this.b).getWindow().setAttributes(attributes);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public void d() {
        this.g = new PopupWindow(this.b);
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.pop_test, (ViewGroup) null);
        this.h = viewInflate;
        this.c = (TextView) viewInflate.findViewById(R.id.g_reflash);
        this.d = (TextView) this.h.findViewById(R.id.r_reflash);
        this.e = (TextView) this.h.findViewById(R.id.g_error);
        this.f = (TextView) this.h.findViewById(R.id.r_error);
        this.c.setOnClickListener(new a());
        this.d.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
        this.f.setOnClickListener(new d());
        this.g.setContentView(this.h);
        this.g.setFocusable(true);
        this.g.setBackgroundDrawable(new ColorDrawable(0));
        this.g.setOutsideTouchable(true);
        this.g.setWidth(-2);
        this.g.setHeight(-2);
        this.g.setOnDismissListener(new e());
    }

    public void e() {
        try {
            if (this.g != null) {
                Context context = this.b;
                if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.g.isShowing()) {
                    return;
                }
                c(0.7f);
                this.g.showAtLocation(this.h, 17, 0, 0);
                this.g.setAnimationStyle(-1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }
}
