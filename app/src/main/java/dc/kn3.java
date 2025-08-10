package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* compiled from: CommonDialog.java */
/* loaded from: classes4.dex */
public class kn3 extends Dialog {
    public Context a;
    public d b;
    public c c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public LinearLayout k;
    public TextView l;
    public View m;
    public boolean n;
    public View o;
    public TextView p;
    public TextView q;
    public ImageView r;

    /* compiled from: CommonDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (kn3.this.c == null || kn3.this.c.a()) {
                if (kn3.this.b != null) {
                    kn3.this.b.doConfirm();
                }
                kn3.this.dismiss();
            }
        }
    }

    /* compiled from: CommonDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (kn3.this.b != null) {
                kn3.this.b.doCancel();
            }
            kn3.this.dismiss();
        }
    }

    /* compiled from: CommonDialog.java */
    public interface c {
        boolean a();
    }

    /* compiled from: CommonDialog.java */
    public interface d {
        void doCancel();

        void doConfirm();
    }

    public kn3(Context context, String str, String str2, String str3, boolean z, d dVar) {
        this(context, str, str2, str3, z, dVar, false);
    }

    public TextView c() {
        return this.l;
    }

    public void d() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.common_dialog, (ViewGroup) null);
        setContentView(viewInflate);
        this.o = viewInflate.findViewById(R.id.dialog_root_layout);
        this.r = (ImageView) viewInflate.findViewById(R.id.iv_notice);
        this.q = (TextView) viewInflate.findViewById(R.id.done);
        this.p = (TextView) viewInflate.findViewById(R.id.cancel);
        this.l = (TextView) viewInflate.findViewById(R.id.text);
        this.k = (LinearLayout) findViewById(R.id.dialog_content);
        this.m = viewInflate.findViewById(R.id.dialog_btns);
        if (this.n) {
            this.l.setText(Html.fromHtml(this.d));
        } else {
            this.l.setText(this.d);
        }
        this.q.setText(this.e);
        this.p.setText(this.f);
        this.q.setOnClickListener(new a());
        if (!this.j) {
            this.p.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            layoutParams.width = ce3.a(this.a, 180.0f);
            this.q.setLayoutParams(layoutParams);
        }
        this.p.setOnClickListener(new b());
        setCanceledOnTouchOutside(this.g);
        setCancelable(this.g);
        j();
    }

    public void e(int i) {
        View view = this.m;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void f(c cVar) {
        this.c = cVar;
    }

    public void g(d dVar) {
        this.b = dVar;
    }

    public void h(View view) {
        if (this.k != null) {
            TextView textView = this.l;
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.k.setVisibility(0);
            this.k.removeAllViews();
            this.k.addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void i(int i) {
        this.o.setBackgroundResource(i);
    }

    public Dialog j() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.a.getResources().getDisplayMetrics();
        attributes.width = ce3.a(this.a, this.i);
        int i = this.h;
        attributes.height = i == 0 ? -2 : ce3.a(this.a, i);
        window.setAttributes(attributes);
        return this;
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s(int i) {
        this.r.setBackgroundResource(i);
        this.r.setVisibility(0);
    }

    public kn3(Context context, String str, String str2, String str3, boolean z, d dVar, boolean z2) {
        this(context, str, str2, str3, true, z, 311, 0, dVar, z2);
    }

    public kn3(Context context, String str, String str2, String str3, boolean z, int i, int i2, d dVar) {
        this(context, str, str2, str3, true, z, i, i2, dVar, false);
    }

    public kn3(Context context, String str, String str2, boolean z, boolean z2, d dVar, boolean z3) {
        this(context, str, str2, z, z2, 311, 0, dVar, z3);
    }

    public kn3(Context context, String str, String str2, boolean z, boolean z2, d dVar) {
        this(context, str, str2, z, z2, 311, 0, dVar);
    }

    public kn3(Context context, String str, String str2, boolean z, boolean z2, int i, int i2, d dVar) {
        this(context, str, str2, z, z2, i, i2, dVar, false);
    }

    public kn3(Context context, String str, String str2, boolean z, boolean z2, int i, int i2, d dVar, boolean z3) {
        this(context, str, str2, "", z, z2, i, i2, dVar, z3);
    }

    public kn3(Context context, String str, String str2, String str3, boolean z, boolean z2, int i, int i2, d dVar, boolean z3) {
        super(context, R.style.dialog);
        this.j = true;
        this.n = false;
        this.a = context;
        this.d = str;
        this.e = WearUtils.e1(str2) ? ah4.e(R.string.common_accept) : str2;
        this.f = WearUtils.e1(str3) ? ah4.e(R.string.common_cancel) : str3;
        this.j = z;
        this.g = z2;
        this.i = i;
        this.h = i2;
        this.b = dVar;
        this.n = z3;
    }
}
