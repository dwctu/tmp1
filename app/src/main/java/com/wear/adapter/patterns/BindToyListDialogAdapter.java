package com.wear.adapter.patterns;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.WearUtils;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class BindToyListDialogAdapter extends BaseQuickAdapter<Toy, BaseViewHolder> {
    public b A;
    public List<Toy> z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toy toy = (Toy) view.getTag();
            if (toy.getType() == null || toy.getType().equals("...")) {
                BindToyListDialogAdapter.this.A.b();
            } else {
                BindToyListDialogAdapter.this.A.a(toy);
            }
        }
    }

    public interface b {
        void a(Toy toy);

        void b();
    }

    public BindToyListDialogAdapter(Context context, List<Toy> list) {
        super(R.layout.dialog_item_choose_toys_creat_pattern, list);
        this.z = list;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder baseViewHolder, Toy toy) {
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.fl_toy);
        AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R.id.tv_toy_name);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_toy_more);
        String showName = "";
        if (toy.isF01Toy()) {
            showName = Toy.TOY_XMACHINE;
        } else if (!WearUtils.e1(toy.getType())) {
            for (ToyConfigInfoBean toyConfigInfoBean : Toy.toyConfigBean) {
                if (TextUtils.equals(toy.getType().toLowerCase(), toyConfigInfoBean.getType())) {
                    showName = toyConfigInfoBean.getShowName();
                }
            }
        }
        if (toy.getType() == null || !toy.getType().equals("...")) {
            imageView.setVisibility(8);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setText(showName);
        } else {
            imageView.setVisibility(0);
            appCompatTextView.setVisibility(8);
        }
        frameLayout.setTag(toy);
        frameLayout.setOnClickListener(new a());
    }

    public void J0(b bVar) {
        this.A = bVar;
    }
}
