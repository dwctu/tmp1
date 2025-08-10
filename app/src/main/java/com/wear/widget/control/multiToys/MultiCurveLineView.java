package com.wear.widget.control.multiToys;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.CurveLineView;
import dc.ce3;
import dc.ek2;
import dc.th4;
import dc.uu1;

/* loaded from: classes4.dex */
public class MultiCurveLineView extends RelativeLayout {
    public LayoutInflater a;
    public CurveLineView b;
    public TextView c;
    public ImageView d;
    public LinearLayout e;
    public LottieAnimationView f;
    public View g;
    public String h;
    public MultiToyOFunBean i;
    public RelativeLayout j;
    public int k;
    public TextView l;
    public ImageView m;
    public a n;

    public interface a {
        void a(String str);
    }

    public MultiCurveLineView(Context context) {
        super(context);
        this.k = ek2.SPEED.ordinal();
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(this.h);
        }
    }

    public void a(boolean z) {
        if (this.i.isFysModel()) {
            this.e.setVisibility(8);
            return;
        }
        if (!z) {
            this.e.setVisibility(4);
            this.f.q();
            return;
        }
        this.e.setVisibility(0);
        int i = MyApplication.m0;
        if (i == 2 || (i == 0 && MyApplication.l0)) {
            this.f.setAnimation("mutli_toys_reconnect_dark.json");
        } else {
            this.f.setAnimation("mutli_toys_reconnect_light.json");
        }
        this.f.r();
    }

    public final void b(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_curveline_item, this);
        this.b = (CurveLineView) viewInflate.findViewById(R.id.curveline);
        this.c = (TextView) viewInflate.findViewById(R.id.toy_name);
        this.d = (ImageView) viewInflate.findViewById(R.id.toy_battery);
        this.e = (LinearLayout) viewInflate.findViewById(R.id.multi_curve_ll_reconnect);
        this.f = (LottieAnimationView) viewInflate.findViewById(R.id.multi_curve_lottie_reconnect);
        this.g = viewInflate.findViewById(R.id.multi_curve_item_top_line);
        this.j = (RelativeLayout) viewInflate.findViewById(R.id.rl_velvo_preview);
        this.l = (TextView) viewInflate.findViewById(R.id.tv_preview_toy_name);
        this.m = (ImageView) viewInflate.findViewById(R.id.img_velvo_preview_play);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: dc.bp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(view);
            }
        });
    }

    public void c(@NonNull MultiToyOFunBean multiToyOFunBean) throws Resources.NotFoundException {
        this.i = multiToyOFunBean;
        this.c.setText(uu1.a(multiToyOFunBean.getName(), 1));
        this.h = multiToyOFunBean.getToyAddress();
        this.c.setText(multiToyOFunBean.getName());
        if (!WearUtils.e1(multiToyOFunBean.getToyName())) {
            this.l.setText(multiToyOFunBean.getToyName());
        }
        if (multiToyOFunBean.isFunction()) {
            this.d.setVisibility(8);
            this.e.setVisibility(4);
        } else {
            Toy.updateToyBatteryTrans(this.d, multiToyOFunBean.getBattery());
            if (multiToyOFunBean.isXMachine()) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(multiToyOFunBean.isFysModel() ? 8 : 0);
            }
            a(!multiToyOFunBean.isConnected());
        }
        this.c.setVisibility(multiToyOFunBean.isFysModel() ? 8 : 0);
        j();
    }

    public final void d() {
        this.j.setBackground(getResources().getDrawable(R.drawable.solace_preview_btn_dark_bg));
        this.m.setBackground(getResources().getDrawable(R.drawable.icon_cruve_preview_play_dark));
        this.l.setTextColor(getResources().getColor(R.color.curve_line_view_preview_dark));
    }

    public void g(a aVar) {
        this.n = aVar;
    }

    public void h() {
        this.b.a();
    }

    public void i() {
        this.c.setTextColor(th4.b(getContext(), R.color.multi_toys_select_toyname_dark));
        this.g.setBackgroundResource(R.color.multi_toys_select_line_dark);
    }

    public final void j() throws Resources.NotFoundException {
        String fun = this.i.isFunction() ? this.i.getFun() : this.i.getAllFun();
        if (WearUtils.e1(fun)) {
            return;
        }
        String[] strArrSplit = fun.split(",");
        this.b.setShowBothLine(strArrSplit.length);
        for (int i = 0; i < strArrSplit.length; i++) {
            int curveLineColor = this.i.isFysModel() ? R.color.fys_model_line_color : Toy.getCurveLineColor(strArrSplit[i]);
            if (i == 0) {
                this.b.setOneLineColor(curveLineColor);
            } else if (i == 1) {
                this.b.setSecondLineColor(curveLineColor);
            } else if (i == 2) {
                this.b.setThreeLineColor(curveLineColor);
            }
        }
    }

    public void k(int i) {
        if (this.i.isFysModel() || this.i.isXMachine()) {
            return;
        }
        Toy.updateToyBatteryTrans(this.d, i);
    }

    public void setBothLinePoint(String str) {
        this.b.setBothLinePoint(str);
    }

    public void setModel(int i, boolean z, boolean z2) throws Resources.NotFoundException {
        this.k = i;
        if (z) {
            h();
            setBothLinePoint("0");
        }
        RelativeLayout relativeLayout = this.j;
        int i2 = this.k;
        ek2 ek2Var = ek2.POSITION;
        relativeLayout.setVisibility(i2 == ek2Var.ordinal() ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        if (this.k != ek2Var.ordinal()) {
            layoutParams.rightMargin = 0;
        } else if (z2) {
            this.j.setVisibility(8);
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ce3.a(getContext(), 110.0f);
        }
        this.b.setPaintModel(this.k);
        this.b.setLayoutParams(layoutParams);
        if (ChatVideoControl.a1().z()) {
            d();
        }
    }

    public MultiCurveLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = ek2.SPEED.ordinal();
        b(context);
    }

    public MultiCurveLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = ek2.SPEED.ordinal();
        b(context);
    }
}
