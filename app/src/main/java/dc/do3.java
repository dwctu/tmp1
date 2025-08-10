package dc;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.kn3;

/* compiled from: SingleLineEditWidget.java */
/* loaded from: classes4.dex */
public class do3 {
    public Context a;
    public kn3 b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public TextView i;
    public TextView j;
    public EditText k;
    public ImageView l;

    /* compiled from: SingleLineEditWidget.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            do3.this.k.setText("");
        }
    }

    /* compiled from: SingleLineEditWidget.java */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            do3.this.l.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: SingleLineEditWidget.java */
    public class c implements TextWatcher {
        public String a = "";
        public final /* synthetic */ String b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ String d;

        public c(String str, EditText editText, String str2) {
            this.b = str;
            this.c = editText;
            this.d = str2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().matches(this.b) || "".equals(editable.toString())) {
                return;
            }
            this.c.setText(this.a);
            EditText editText = this.c;
            editText.setSelection(editText.getText().toString().length());
            String str = this.d;
            if (str != null) {
                sg3.l(str);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a = charSequence.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public do3(Context context, String str, String str2) {
        this.b = null;
        this.g = true;
        this.h = false;
        this.a = context;
        this.c = str;
        this.d = str2;
        this.e = ah4.e(R.string.pattern_save);
        this.f = "";
        k();
    }

    public static void d(EditText editText, String str, String str2) {
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new c(str, editText, str2));
    }

    public EditText a() {
        return this.k;
    }

    public void b(kn3.c cVar) {
        this.b.f(cVar);
    }

    public void c(kn3.d dVar) {
        this.b.g(dVar);
    }

    public void e() {
        kn3 kn3Var = this.b;
        if (kn3Var != null) {
            kn3Var.l();
        }
    }

    public void f() {
        kn3 kn3Var = this.b;
        if (kn3Var != null) {
            kn3Var.n();
        }
    }

    public void g(String str) {
        if (WearUtils.e1(str)) {
            this.i.setVisibility(8);
        } else {
            this.i.setText(str);
            this.i.setVisibility(0);
        }
    }

    public void h(String str) {
        this.k.setText(str);
        EditText editText = this.k;
        editText.setSelection(editText.length());
    }

    public void i(String str) {
        this.k.setHint(str);
    }

    public void j() {
        kn3 kn3Var = this.b;
        if (kn3Var != null) {
            kn3Var.p();
        }
    }

    public void k() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_edit_common_layout, (ViewGroup) null, false);
        this.i = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.j = (TextView) viewInflate.findViewById(R.id.tv_notice);
        this.k = (EditText) viewInflate.findViewById(R.id.edt_value);
        this.l = (ImageView) viewInflate.findViewById(R.id.iv_clear);
        if (WearUtils.e1(this.e)) {
            this.i.setVisibility(8);
        } else {
            this.i.setText(this.e);
            this.i.setVisibility(0);
        }
        if (WearUtils.e1(this.f)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(this.f);
            this.j.setVisibility(0);
        }
        if (this.h) {
            this.l.setOnClickListener(new a());
            this.k.addTextChangedListener(new b());
        }
        if (this.g) {
            this.b = new kn3(this.a, (String) null, this.c, this.d, false, (kn3.d) null);
        } else {
            this.b = new kn3(this.a, (String) null, this.c, this.g, false, (kn3.d) null);
        }
        this.b.show();
        this.b.h(viewInflate);
    }

    public do3(Context context, String str, String str2, boolean z, String str3, String str4) {
        this.b = null;
        this.g = true;
        this.h = false;
        this.a = context;
        this.c = str;
        this.d = str2;
        this.g = z;
        this.e = str3;
        this.f = str4;
        k();
    }
}
