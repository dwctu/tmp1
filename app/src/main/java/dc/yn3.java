package dc;

import android.content.Context;
import android.text.InputFilter;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.kn3;

/* compiled from: SavePatternDialog.java */
/* loaded from: classes4.dex */
public class yn3 {
    public Context a;
    public c b;
    public String c;
    public String d;

    /* compiled from: SavePatternDialog.java */
    public class a implements kn3.c {
        public final /* synthetic */ do3 a;

        public a(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            if (!WearUtils.e1(this.a.a().getText().toString())) {
                return true;
            }
            sg3.i(yn3.this.a, R.string.pattern_name_empty);
            return false;
        }
    }

    /* compiled from: SavePatternDialog.java */
    public class b implements kn3.d {
        public final /* synthetic */ do3 a;

        public b(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), yn3.this.a);
            if (yn3.this.b != null) {
                yn3.this.b.doCancel();
            }
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ue3.a(this.a.a(), yn3.this.a);
            if (yn3.this.b != null) {
                yn3.this.b.a(yn3.this.c, this.a.a().getText().toString());
            }
        }
    }

    /* compiled from: SavePatternDialog.java */
    public interface c {
        void a(String str, String str2);

        void doCancel();
    }

    public yn3(Context context, String str, String str2, c cVar) {
        this.a = context;
        this.c = str;
        this.d = str2;
        this.b = cVar;
        d();
    }

    public final void d() {
        do3 do3Var = new do3(this.a, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(ah4.e(R.string.closeRange_patterns));
        do3Var.i(ah4.e(R.string.pattern_name));
        if (!WearUtils.e1(this.d)) {
            do3Var.h(this.d);
        }
        do3Var.a().setSelection(this.d.length());
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new a(do3Var));
        do3Var.c(new b(do3Var));
        do3Var.e();
    }
}
