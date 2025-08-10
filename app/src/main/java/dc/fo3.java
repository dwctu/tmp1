package dc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* compiled from: VersionUpdateDialog.java */
/* loaded from: classes4.dex */
public class fo3 extends AlertDialog {
    public final String a;
    public boolean b;
    public Context c;
    public c d;
    public View e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* compiled from: VersionUpdateDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fo3.this.d.doCancel();
            fo3.this.dismiss();
        }
    }

    /* compiled from: VersionUpdateDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fo3.this.d.a();
            fo3.this.dismiss();
        }
    }

    /* compiled from: VersionUpdateDialog.java */
    public interface c {
        void a();

        void doCancel();
    }

    public fo3(Context context, String str, boolean z, c cVar) {
        super(context, R.style.dialog);
        this.b = false;
        this.c = context;
        this.d = cVar;
        this.a = str;
        this.b = z;
        this.e = LayoutInflater.from(context).inflate(R.layout.dialog_version_update, (ViewGroup) null, true);
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
        this.f = (TextView) this.e.findViewById(R.id.tv_text);
        this.g = (TextView) this.e.findViewById(R.id.tv_cancel);
        this.h = (TextView) this.e.findViewById(R.id.tv_confirm);
        String strE = ah4.e(R.string.common_cancel);
        if (this.b) {
            strE = ah4.e(R.string.common_exit);
        }
        this.g.setText(strE);
        if (WearUtils.e1(this.a)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.setText(this.a);
        }
        this.g.setOnClickListener(new a());
        this.h.setOnClickListener(new b());
    }
}
