package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lovense.wear.R;
import dc.ee3;

/* compiled from: DownApkDialog.java */
/* loaded from: classes4.dex */
public class nn3 extends AlertDialog {
    public final String a;
    public boolean b;
    public Context c;
    public e d;
    public View e;
    public ProgressBar f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public ee3.b n;

    /* compiled from: DownApkDialog.java */
    public class a implements ee3.b {
        public a() {
        }

        @Override // dc.ee3.b
        public void a(long j) {
            try {
                nn3.this.g.setText(j + "%");
                if (j <= 100) {
                    nn3.this.f.setProgress((int) j);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.ee3.b
        public void b(String str) {
            try {
                sg3.f(nn3.this.c, str);
                nn3.this.l.setVisibility(8);
                nn3.this.k.setVisibility(0);
                nn3.this.h.setVisibility(8);
                nn3.this.m.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // dc.ee3.b
        public void c() {
            try {
                nn3.this.g.setText("100%");
                nn3.this.f.setProgress(100);
                nn3.this.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: DownApkDialog.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ ee3 a;

        public b(ee3 ee3Var) {
            this.a = ee3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.y();
            nn3.this.dismiss();
            nn3.this.d.doCancel();
        }
    }

    /* compiled from: DownApkDialog.java */
    public class c implements View.OnClickListener {
        public final /* synthetic */ ee3 a;

        public c(ee3 ee3Var) {
            this.a = ee3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.y();
            nn3.this.dismiss();
            nn3.this.d.doCancel();
        }
    }

    /* compiled from: DownApkDialog.java */
    public class d implements View.OnClickListener {
        public final /* synthetic */ ee3 a;

        public d(ee3 ee3Var) {
            this.a = ee3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            nn3.this.l.setVisibility(0);
            nn3.this.k.setVisibility(8);
            nn3.this.h.setVisibility(0);
            nn3.this.m.setVisibility(8);
            nn3.this.g.setText("0%");
            nn3.this.f.setProgress(0);
            this.a.x(nn3.this.a, nn3.this.c, nn3.this.b, nn3.this.n);
        }
    }

    /* compiled from: DownApkDialog.java */
    public interface e {
        void doCancel();
    }

    public nn3(Context context, String str, boolean z, e eVar) {
        super(context, R.style.dialog);
        this.b = false;
        this.c = context;
        this.d = eVar;
        this.a = str;
        this.b = z;
        this.e = LayoutInflater.from(context).inflate(R.layout.dialog_apk, (ViewGroup) null, true);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.e;
        if (view != null) {
            setContentView(view);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.l = (LinearLayout) this.e.findViewById(R.id.ll_progress);
        this.f = (ProgressBar) this.e.findViewById(R.id.proBar);
        this.g = (TextView) this.e.findViewById(R.id.tv_progress);
        this.k = (TextView) this.e.findViewById(R.id.tv_update_fail);
        this.h = (TextView) this.e.findViewById(R.id.cancel);
        this.i = (TextView) this.e.findViewById(R.id.cancel_two);
        this.j = (TextView) this.e.findViewById(R.id.done);
        this.m = (LinearLayout) this.e.findViewById(R.id.ll_fail);
        if (this.b) {
            this.h.setText(ah4.e(R.string.common_exit));
            this.i.setText(ah4.e(R.string.common_exit));
        } else {
            this.h.setText(ah4.e(R.string.common_cancel));
            this.i.setText(ah4.e(R.string.common_cancel));
        }
        this.h.setVisibility(0);
        this.m.setVisibility(8);
        ee3 ee3Var = new ee3();
        a aVar = new a();
        this.n = aVar;
        ee3Var.x(this.a, this.c, this.b, aVar);
        this.h.setOnClickListener(new b(ee3Var));
        this.i.setOnClickListener(new c(ee3Var));
        this.j.setOnClickListener(new d(ee3Var));
    }
}
