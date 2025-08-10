package com.wear.widget.dialog;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import dc.is3;
import dc.xo1;
import java.util.List;

/* loaded from: classes4.dex */
public class SelectToyDailog extends is3<List<Toy>> {
    public xo1 f;
    public a g;

    @BindView(R.id.lv_toys)
    public ListView lvToys;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_text)
    public TextView tvText;

    public interface a {
        void a(Toy toy);
    }

    public SelectToyDailog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public void e() {
        super.e();
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this.f.d);
        }
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_select_toy;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        xo1 xo1Var = new xo1((List) this.c, this.a.a, R.layout.item_select_toy);
        this.f = xo1Var;
        this.lvToys.setAdapter((ListAdapter) xo1Var);
    }

    public void setListener(a aVar) {
        this.g = aVar;
    }
}
