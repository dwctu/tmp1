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
import dc.rq1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class LdrToyAdapter extends BaseAdapter<Toy> {
    public int j;
    public boolean k;
    public b l;
    public Map<String, Boolean> m;
    public HashMap<Toy, ImageView> n;
    public HashMap<String, ImageView> o;
    public ArrayList<Toy> p;
    public boolean q;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Toy a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ImageView c;

        public a(Toy toy, int i, ImageView imageView) {
            this.a = toy;
            this.b = i;
            this.c = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LdrToyAdapter.this.m.containsKey(this.a.getDeviceId())) {
                LdrToyAdapter.this.m.put(this.a.getDeviceId(), Boolean.valueOf(!((Boolean) LdrToyAdapter.this.m.get(this.a.getDeviceId())).booleanValue()));
                LdrToyAdapter.this.notifyItemChanged(this.b, this.c);
                rq1.d.f(this.a.getAddress());
            }
        }
    }

    public interface b {
        void a(View view);

        void b(BaseAdapter.ViewHolder viewHolder, Toy toy, int i);
    }

    public LdrToyAdapter(ArrayList<Toy> arrayList, int i, boolean z) {
        super(arrayList, i);
        this.j = -1;
        this.k = true;
        this.m = new HashMap();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.q = false;
        this.p = arrayList;
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(BaseAdapter.ViewHolder viewHolder, Toy toy, int i, View view) {
        b bVar = this.l;
        if (bVar != null) {
            bVar.b(viewHolder, toy, i);
        }
    }

    public void C(b bVar) {
        this.l = bVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void y(final BaseAdapter.ViewHolder viewHolder, final Toy toy, int i) {
        int i2;
        final int i3;
        ImageView imageView = (ImageView) viewHolder.getView(R.id.cl_toy);
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.nora_rotation_icon);
        ImageView imageView3 = (ImageView) viewHolder.getView(R.id.iv_toy_level);
        ImageView imageView4 = (ImageView) viewHolder.getView(R.id.iv_toy_battery);
        View view = viewHolder.getView(R.id.ll_toy_info);
        TextView textView = (TextView) viewHolder.getView(R.id.tv_text);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewHolder.getView(R.id.lottie_animation);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView4.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        int iE = (gg3.e(this.c) - ((int) (gg3.b(this.c).i() * 60.0f))) / 2;
        if (this.p.size() <= 2) {
            int i4 = iE / 3;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
            ((ViewGroup.MarginLayoutParams) layoutParams5).width = i4;
            ((ViewGroup.MarginLayoutParams) layoutParams5).height = i4;
            imageView.setLayoutParams(layoutParams);
            lottieAnimationView.setLayoutParams(layoutParams5);
            if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 18;
                ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = 0;
                view.setLayoutParams(layoutParams4);
                lottieAnimationView.setLayoutParams(layoutParams5);
                layoutParams2.leftMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = 0;
                view.setLayoutParams(layoutParams4);
                lottieAnimationView.setLayoutParams(layoutParams5);
                layoutParams2.leftMargin = 2;
            }
            layoutParams2.width = (int) (gg3.b(this.c).i() * 30.0f);
            layoutParams2.height = (int) (gg3.b(this.c).i() * 30.0f);
            imageView3.setLayoutParams(layoutParams2);
            layoutParams3.width = (int) (gg3.b(this.c).i() * 27.0f);
            layoutParams3.height = (int) (gg3.b(this.c).i() * 27.0f);
            imageView4.setLayoutParams(layoutParams3);
            textView.setTextSize(9.0f);
        } else {
            int i5 = (int) (iE / 3.5d);
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i5;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i5;
            ((ViewGroup.MarginLayoutParams) layoutParams5).width = i5;
            ((ViewGroup.MarginLayoutParams) layoutParams5).height = i5;
            imageView.setLayoutParams(layoutParams);
            lottieAnimationView.setLayoutParams(layoutParams5);
            if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 18;
                ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = 0;
                view.setLayoutParams(layoutParams4);
                lottieAnimationView.setLayoutParams(layoutParams5);
                layoutParams2.leftMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = 0;
                view.setLayoutParams(layoutParams4);
                lottieAnimationView.setLayoutParams(layoutParams5);
                layoutParams2.leftMargin = 2;
            }
            layoutParams2.width = (int) (gg3.b(this.c).i() * 27.0f);
            layoutParams2.height = (int) (gg3.b(this.c).i() * 27.0f);
            imageView3.setLayoutParams(layoutParams2);
            layoutParams3.width = (int) (gg3.b(this.c).i() * 25.0f);
            layoutParams3.height = (int) (gg3.b(this.c).i() * 25.0f);
            imageView4.setLayoutParams(layoutParams3);
            textView.setTextSize(7.0f);
        }
        if (TextUtils.equals(toy.getName(), "touch_icon_flag")) {
            kf.w(this.c).t(Integer.valueOf(R.drawable.lds_control)).A0(imageView);
            view.setVisibility(8);
            textView.setVisibility(8);
            i3 = i;
            i2 = 0;
        } else {
            kf.w(this.c).t(Integer.valueOf(toy.getLdrIcon())).A0(imageView);
            textView.setVisibility(0);
            i2 = 0;
            textView.setText(toy.getToyUINameSpecialForMiniXMachine(3));
            i3 = i;
            if (i3 == this.j && this.k) {
                imageView.setSelected(true);
            } else {
                imageView.setSelected(false);
            }
            view.setVisibility(0);
            this.n.put(toy, imageView3);
            this.o.put(toy.getAndUpdateDeviceId(), imageView4);
            Toy.updateToyBattery(imageView4, toy.getBattery());
            if (toy.isF01Toy() || toy.getName().equalsIgnoreCase(Toy.TOY_XMACHINE) || toy.getSimpleType().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                imageView4.setVisibility(8);
            } else {
                imageView4.setVisibility(0);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.rk1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.B(viewHolder, toy, i3, view2);
                }
            });
            toy.isNora();
            imageView2.setVisibility(8);
            imageView2.setOnClickListener(new a(toy, i3, imageView2));
        }
        if (!this.q || i3 != this.j || !toy.isSynControlAnimation()) {
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.q();
            if (TextUtils.equals(toy.getName(), "touch_icon_flag")) {
                return;
            }
            view.setVisibility(i2);
            return;
        }
        String strH = WearUtils.H(toy);
        if (TextUtils.isEmpty(strH) || !this.k) {
            lottieAnimationView.setVisibility(8);
            if (TextUtils.equals(toy.getName(), "touch_icon_flag")) {
                return;
            }
            view.setVisibility(i2);
            return;
        }
        view.setVisibility(8);
        lottieAnimationView.setVisibility(i2);
        if (toy.isBAToy()) {
            lottieAnimationView.setImageAssetsFolder("anim/solacepro/images/");
            lottieAnimationView.setAnimation("anim/solacepro/solace_pro.json");
        } else {
            lottieAnimationView.setAnimation(strH);
        }
        lottieAnimationView.r();
        b bVar = this.l;
        if (bVar != null) {
            bVar.a(lottieAnimationView);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
    }
}
