package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;

/* compiled from: SheetListDialog.java */
/* loaded from: classes4.dex */
public class co3 extends Dialog {
    public Context a;
    public BaseAdapter b;
    public View c;
    public View d;
    public ListView e;
    public View.OnClickListener f;

    /* compiled from: SheetListDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            co3.this.dismiss();
        }
    }

    /* compiled from: SheetListDialog.java */
    public class b implements View.OnClickListener {
        public b(co3 co3Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public co3(Context context, BaseAdapter baseAdapter) {
        super(context, R.style.MaterialDialogSheet);
        this.f = null;
        this.a = context;
        this.b = baseAdapter;
    }

    public View a(int i) {
        View view = this.c;
        if (view != null) {
            return view.findViewById(i);
        }
        return null;
    }

    public void b() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.sheet_list_dialog, (ViewGroup) null);
        this.c = viewInflate;
        setContentView(viewInflate);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.sheet_layout);
        this.d = this.c.findViewById(R.id.sheet_top_bar);
        ListView listView = (ListView) this.c.findViewById(R.id.sheet_list);
        this.e = listView;
        listView.setAdapter((ListAdapter) this.b);
        int iC = (int) (((gg3.c(MyApplication.H()) + gg3.g(MyApplication.H())) * 1.6f) / 4.0f);
        float f = 64;
        if (this.b.getCount() * ce3.a(WearUtils.x, f) < iC) {
            iC = this.b.getCount() * ce3.a(WearUtils.x, f);
        }
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, iC));
        linearLayout.setOnClickListener(new a());
        this.d.setOnClickListener(new b(this));
        setCanceledOnTouchOutside(this.f == null);
        setCancelable(this.f == null);
        if (this.f != null) {
            this.c.findViewById(R.id.sheet_layout).setOnClickListener(this.f);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }
}
