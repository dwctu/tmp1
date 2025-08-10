package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import java.util.List;

/* compiled from: DisPlayPannelSelectToyAdapter.java */
/* loaded from: classes3.dex */
public class xo1 extends vj1<Toy> {
    public Toy d;

    /* compiled from: DisPlayPannelSelectToyAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Toy a;

        public a(Toy toy) {
            this.a = toy;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            xo1 xo1Var = xo1.this;
            xo1Var.d = this.a;
            xo1Var.notifyDataSetChanged();
        }
    }

    public xo1(List<Toy> list, Context context, int i) {
        super(list, context, i);
        if (list != null && list.size() > 0) {
            this.d = list.get(0);
        }
        if (list != null && list.size() == 2 && TextUtils.equals(this.d.getType(), list.get(1).getType()) && this.d.typeInt() == 1 && list.get(1).typeInt() == 2) {
            this.d = list.get(1);
        }
    }

    @Override // dc.vj1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, Toy toy, int i) {
        TextView textView = (TextView) wj1Var.b(R.id.tv_toy);
        View viewB = wj1Var.b(R.id.rl_root);
        if (this.d == toy) {
            textView.setTextColor(ContextCompat.getColor(this.b, R.color.tab_text_selected));
            viewB.setBackgroundResource(R.drawable.bnt_background_pink_corners_3);
        } else {
            textView.setTextColor(ContextCompat.getColor(this.b, R.color.tab_text_normal));
            viewB.setBackgroundResource(R.drawable.bnt_background_gray_corners_3);
        }
        textView.setText(toy.getSimpleName());
        if (!TextUtils.isEmpty(toy.getDefineRename())) {
            textView.setText(toy.getDefineRename());
        }
        viewB.setOnClickListener(new a(toy));
    }
}
