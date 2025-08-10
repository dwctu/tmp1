package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* compiled from: SheetDialog.java */
/* loaded from: classes4.dex */
public class bo3 extends Dialog {
    public Context a;
    public int b;
    public View c;
    public int d;
    public int e;
    public View.OnClickListener f;

    /* compiled from: SheetDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bo3.this.dismiss();
        }
    }

    /* compiled from: SheetDialog.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ int b;

        public b(bo3 bo3Var, d dVar, int i) {
            this.a = dVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }

    /* compiled from: SheetDialog.java */
    public class c implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ int b;

        public c(d dVar, int i) {
            this.a = dVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
            bo3.this.dismiss();
        }
    }

    /* compiled from: SheetDialog.java */
    public interface d {
        void a(int i);
    }

    public bo3(Context context, int i) {
        super(context, R.style.MaterialDialogSheet);
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.a = context;
        this.b = i;
    }

    public View a(int i) {
        View view = this.c;
        if (view != null) {
            return view.findViewById(i);
        }
        return null;
    }

    public void b() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
        View viewInflate = layoutInflaterFrom.inflate(R.layout.sheet_dialog, (ViewGroup) null);
        setContentView(viewInflate);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.sheet_layout);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.sheet_content);
        View viewInflate2 = layoutInflaterFrom.inflate(this.b, (ViewGroup) null);
        this.c = viewInflate2;
        if (this.d == 0 || this.e == 0) {
            frameLayout.addView(viewInflate2, new LinearLayout.LayoutParams(-1, -2));
        } else {
            frameLayout.addView(viewInflate2, new LinearLayout.LayoutParams(this.d, this.e));
        }
        linearLayout.setOnClickListener(new a());
        setCanceledOnTouchOutside(this.f == null);
        setCancelable(this.f == null);
        if (this.f != null) {
            viewInflate.findViewById(R.id.sheet_layout).setOnClickListener(this.f);
        }
    }

    public void c(int i, d dVar) {
        View view = this.c;
        if (view == null || view.findViewById(i) == null) {
            return;
        }
        this.c.findViewById(i).setOnClickListener(new b(this, dVar, i));
    }

    public void d(int i, d dVar) {
        View view = this.c;
        if (view == null || view.findViewById(i) == null) {
            return;
        }
        this.c.findViewById(i).setOnClickListener(new c(dVar, i));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    public bo3(Context context, int i, View.OnClickListener onClickListener) {
        super(context, R.style.MaterialDialogSheet);
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.a = context;
        this.b = i;
        this.f = onClickListener;
    }

    public bo3(Context context, int i, int i2, int i3) {
        super(context, R.style.MaterialDialogSheet);
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.a = context;
        this.b = i;
        this.d = i2;
        this.e = i3;
    }
}
