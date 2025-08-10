package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import dc.gg3;
import dc.kf;
import dc.uu1;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class GroupLdrToyAdapter extends BaseAdapter<Toy> {
    public int j;
    public boolean k;
    public a l;
    public ArrayList<Toy> m;
    public boolean n;
    public HashMap<Toy, ImageView> o;
    public HashMap<String, ImageView> p;

    public interface a {
        void a(View view);

        void b(BaseAdapter.ViewHolder viewHolder, Toy toy, int i);
    }

    public GroupLdrToyAdapter(ArrayList<Toy> arrayList, int i) {
        super(arrayList, i);
        this.j = -1;
        this.k = true;
        this.n = false;
        this.o = new HashMap<>();
        this.p = new HashMap<>();
        this.m = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(BaseAdapter.ViewHolder viewHolder, Toy toy, int i, View view) {
        a aVar = this.l;
        if (aVar != null) {
            aVar.b(viewHolder, toy, i);
        }
    }

    public void B(a aVar) {
        this.l = aVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(final BaseAdapter.ViewHolder viewHolder, final Toy toy, final int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.cl_toy);
        View view = viewHolder.getView(R.id.iv_toy_level);
        View view2 = viewHolder.getView(R.id.iv_toy_battery);
        View view3 = viewHolder.getView(R.id.ll_toy_info);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewHolder.getView(R.id.lottie_animation);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) view3.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        int iE = (gg3.e(this.c) - ((int) (gg3.b(this.c).i() * 60.0f))) / 2;
        if (this.m.size() <= 2) {
            int i2 = (int) (iE / 2.5d);
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams5).width = i2;
            ((ViewGroup.MarginLayoutParams) layoutParams5).height = i2;
            imageView.setLayoutParams(layoutParams);
            lottieAnimationView.setLayoutParams(layoutParams5);
            if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 18;
                view3.setLayoutParams(layoutParams4);
                layoutParams2.leftMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 0;
                view3.setLayoutParams(layoutParams4);
                layoutParams2.leftMargin = 4;
            }
            layoutParams2.width = (int) (gg3.b(this.c).i() * 30.0f);
            layoutParams2.height = (int) (gg3.b(this.c).i() * 30.0f);
            view.setLayoutParams(layoutParams2);
            layoutParams3.width = (int) (gg3.b(this.c).i() * 27.0f);
            layoutParams3.height = (int) (gg3.b(this.c).i() * 27.0f);
            view2.setLayoutParams(layoutParams3);
        } else {
            int i3 = iE / 3;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams5).width = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams5).height = i3;
            imageView.setLayoutParams(layoutParams);
            lottieAnimationView.setLayoutParams(layoutParams5);
            if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 18;
                view3.setLayoutParams(layoutParams4);
                layoutParams2.leftMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 0;
                view3.setLayoutParams(layoutParams4);
                layoutParams2.leftMargin = 4;
            }
            layoutParams2.width = (int) (gg3.b(this.c).i() * 27.0f);
            layoutParams2.height = (int) (gg3.b(this.c).i() * 27.0f);
            view.setLayoutParams(layoutParams2);
            layoutParams3.width = (int) (gg3.b(this.c).i() * 25.0f);
            layoutParams3.height = (int) (gg3.b(this.c).i() * 25.0f);
            view2.setLayoutParams(layoutParams3);
        }
        kf.w(this.c).t(Integer.valueOf(toy.getLdrIcon())).A0(imageView);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_text);
        textView.setText(uu1.a(toy.getShowName(), 3));
        if (toy.isMiniXMachine()) {
            textView.setMaxLines(2);
        } else {
            textView.setMaxLines(1);
        }
        if (i == this.j && this.k) {
            imageView.setSelected(true);
        } else {
            imageView.setSelected(false);
        }
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.iv_toy_level);
        ImageView imageView3 = (ImageView) viewHolder.getView(R.id.iv_toy_battery);
        this.o.put(toy, imageView2);
        this.p.put(toy.getAndUpdateDeviceId(), imageView3);
        Toy.updateToyBattery(imageView3, toy.getBattery());
        if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.nk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                this.a.A(viewHolder, toy, i, view4);
            }
        });
        if (!this.n || i != this.j || !toy.isSynControlAnimation()) {
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.q();
            view3.setVisibility(0);
            return;
        }
        String strH = WearUtils.H(toy);
        if (TextUtils.isEmpty(strH) || !this.k) {
            lottieAnimationView.setVisibility(8);
            if (!TextUtils.equals(toy.getName(), "touch_icon_flag")) {
                view3.setVisibility(0);
            }
        } else {
            view3.setVisibility(8);
            lottieAnimationView.setVisibility(0);
            if (toy.isBAToy()) {
                lottieAnimationView.setImageAssetsFolder("anim/solacepro/images/");
                lottieAnimationView.setAnimation("anim/solacepro/solace_pro.json");
            } else {
                lottieAnimationView.setAnimation(strH);
            }
            lottieAnimationView.r();
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(lottieAnimationView);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
    }

    public GroupLdrToyAdapter(ArrayList<Toy> arrayList, int i, boolean z) {
        super(arrayList, i);
        this.j = -1;
        this.k = true;
        this.n = false;
        this.o = new HashMap<>();
        this.p = new HashMap<>();
        this.m = arrayList;
        this.n = z;
    }
}
