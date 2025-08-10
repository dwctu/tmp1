package dc;

import android.content.Context;
import android.text.InputFilter;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.kn3;

/* compiled from: EditDialog.java */
/* loaded from: classes4.dex */
public class on3 {
    public Context a;
    public c b;
    public String c;
    public String d;

    /* compiled from: EditDialog.java */
    public class a implements kn3.c {
        public final /* synthetic */ do3 a;

        public a(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String string = this.a.a().getText().toString();
            if (WearUtils.e1(string)) {
                sg3.i(on3.this.a, R.string.edit_email);
                return false;
            }
            if (WearUtils.G2(string)) {
                return true;
            }
            sg3.i(on3.this.a, R.string.system_email_error);
            return false;
        }
    }

    /* compiled from: EditDialog.java */
    public class b implements kn3.d {
        public final /* synthetic */ do3 a;

        public b(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), on3.this.a);
            if (on3.this.b != null) {
                on3.this.b.doCancel();
            }
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ue3.a(this.a.a(), on3.this.a);
            if (on3.this.b != null) {
                on3.this.b.a(this.a.a().getText().toString());
            }
        }
    }

    /* compiled from: EditDialog.java */
    public interface c {
        void a(String str);

        void doCancel();
    }

    public on3(Context context, String str, String str2, c cVar) {
        this.a = context;
        this.c = str;
        this.d = str2;
        this.b = cVar;
        c();
    }

    public final void c() {
        do3 do3Var = new do3(this.a, ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel));
        do3Var.g(this.d);
        do3Var.i(this.c);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new a(do3Var));
        do3Var.c(new b(do3Var));
        do3Var.e();
    }
}
