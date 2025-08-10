package dc;

import android.app.Activity;
import android.view.View;
import com.lovense.wear.R;
import java.util.List;

/* compiled from: SettingLanguageAdapter.java */
/* loaded from: classes3.dex */
public class go1 extends vj1<String> {
    public String d;
    public b e;

    /* compiled from: SettingLanguageAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            go1 go1Var;
            b bVar;
            if (this.a.equals(go1.this.d) || (bVar = (go1Var = go1.this).e) == null) {
                return;
            }
            String str = this.a;
            go1Var.d = str;
            bVar.a(str);
            go1.this.notifyDataSetChanged();
        }
    }

    /* compiled from: SettingLanguageAdapter.java */
    public interface b {
        void a(String str);
    }

    public go1(List<String> list, Activity activity, int i) {
        super(list, activity, i);
    }

    public void c(b bVar) {
        this.e = bVar;
    }

    public void d(String str) {
        this.d = str;
    }

    @Override // dc.vj1
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, String str, int i) {
        wj1Var.d(R.id.tv_language, str);
        if (str.equals(this.d)) {
            wj1Var.b(R.id.iv_language).setVisibility(0);
        } else {
            wj1Var.b(R.id.iv_language).setVisibility(8);
        }
        wj1Var.a().setOnClickListener(new a(str));
    }
}
