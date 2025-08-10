package dc;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.main.toy.ToyActivity;

/* compiled from: GameModeUpdateDfuDialog.java */
/* loaded from: classes4.dex */
public class gs3 extends Dialog {
    public Context a;
    public String b;
    public int c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;

    /* compiled from: GameModeUpdateDfuDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs3.this.dismiss();
        }
    }

    /* compiled from: GameModeUpdateDfuDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gs3.this.dismiss();
        }
    }

    /* compiled from: GameModeUpdateDfuDialog.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.f(gs3.this.a, ToyActivity.class);
            gs3.this.dismiss();
        }
    }

    public gs3(@NonNull Context context, int i, String str) {
        super(context, R.style.dialog);
        this.b = "";
        this.c = -1;
        this.a = context;
        this.c = i;
        this.b = str;
        b();
    }

    public final void b() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_layout_mode_update_dfu, (ViewGroup) null);
        this.d = (TextView) viewInflate.findViewById(R.id.tv_text_content);
        this.e = (TextView) viewInflate.findViewById(R.id.tv_bottom_2);
        this.f = (LinearLayout) viewInflate.findViewById(R.id.ll_bottom_1);
        this.g = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.h = (TextView) viewInflate.findViewById(R.id.tv_confirm);
        this.d.setText(ng3.e(this.b));
        if (this.c == 1) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
        } else {
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
        this.e.setOnClickListener(new a());
        this.g.setOnClickListener(new b());
        this.h.setOnClickListener(new c());
        setContentView(viewInflate);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ce3.a(getContext(), 311.0f);
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.a != null) {
            super.show();
        }
    }
}
