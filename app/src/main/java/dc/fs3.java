package dc;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.main.toy.ToyActivity;

/* compiled from: GameModeBottomDialog.java */
/* loaded from: classes4.dex */
public class fs3 extends Dialog {
    public Context a;
    public String b;
    public int c;
    public TextView d;
    public TextView e;
    public TextView f;

    /* compiled from: GameModeBottomDialog.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fs3.this.c(2);
            fs3.this.dismiss();
        }
    }

    /* compiled from: GameModeBottomDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fs3.this.c(1);
            pj3.f(fs3.this.a, ToyActivity.class);
            fs3.this.dismiss();
        }
    }

    public fs3(@NonNull Context context, String str) {
        super(context, R.style.dialog);
        this.b = "";
        this.c = -1;
        this.a = context;
        this.c = -1;
        this.b = str;
        b();
    }

    public final void b() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_layout_mode_bottom, (ViewGroup) null);
        this.d = (TextView) viewInflate.findViewById(R.id.tv_text_content);
        this.e = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.f = (TextView) viewInflate.findViewById(R.id.tv_confirm);
        this.d.setText(ng3.e(this.b));
        this.e.setOnClickListener(new a());
        this.f.setOnClickListener(new b());
        setContentView(viewInflate);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ce3.a(getContext(), 311.0f);
        window.setAttributes(attributes);
    }

    public void c(int i) {
        ye3.j("game mode", "game_mode_please_connect_popup_click", "click", "game_mode_please_connect_popup", "button", i != 1 ? i != 2 ? "" : "cancel" : "connect now", "", -1L);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.a != null) {
            super.show();
        }
    }
}
