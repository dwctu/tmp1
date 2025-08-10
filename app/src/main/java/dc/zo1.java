package dc;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.bean.ToyLedBean;
import dc.hs3;
import java.util.List;

/* compiled from: ToyLedColorAdapter.java */
/* loaded from: classes3.dex */
public class zo1 extends vj1<ToyLedBean> {
    public hs3.b d;

    /* compiled from: ToyLedColorAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ToyLedBean a;

        public a(ToyLedBean toyLedBean) {
            this.a = toyLedBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            hs3.b bVar = zo1.this.d;
            if (bVar != null) {
                bVar.k0(this.a);
            }
        }
    }

    public zo1(List<ToyLedBean> list, Activity activity, int i) {
        super(list, activity, i);
    }

    public void c(hs3.b bVar) {
        this.d = bVar;
    }

    @Override // dc.vj1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, ToyLedBean toyLedBean, int i) {
        TextView textView = (TextView) wj1Var.b(R.id.tv_name);
        wj1Var.d(R.id.tv_name, toyLedBean.getName());
        if (toyLedBean.isSelect()) {
            wj1Var.b(R.id.iv_select).setVisibility(0);
            textView.setTextColor(ContextCompat.getColor(this.b, R.color.color_accent));
        } else {
            wj1Var.b(R.id.iv_select).setVisibility(8);
            textView.setTextColor(th4.b(this.b, R.color.text_color_85));
        }
        if (i == 0) {
            wj1Var.b(R.id.iv_color).setVisibility(0);
            wj1Var.b(R.id.v_color).setVisibility(8);
        } else {
            wj1Var.b(R.id.iv_color).setVisibility(8);
            View viewB = wj1Var.b(R.id.v_color);
            viewB.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(toyLedBean.getColor());
            gradientDrawable.setCornerRadius(ce3.a(this.b, 18.0f));
            gradientDrawable.setGradientType(0);
            viewB.setBackground(gradientDrawable);
        }
        wj1Var.a().setOnClickListener(new a(toyLedBean));
    }
}
