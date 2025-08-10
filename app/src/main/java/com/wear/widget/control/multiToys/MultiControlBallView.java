package com.wear.widget.control.multiToys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import dc.be3;
import dc.ce3;
import dc.gg3;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class MultiControlBallView extends FrameLayout {
    public LayoutInflater a;
    public int b;
    public int c;

    @BindView(R.id.cl_merge_ball)
    public ConstraintLayout clMergeBall;
    public int d;
    public Map<Integer, Integer> e;
    public Map<Integer, Integer> f;
    public long g;
    public boolean h;
    public MultiControlBallView i;

    @BindView(R.id.iv_activate)
    public ImageView ivActivate;

    @BindView(R.id.iv_control_mode)
    public ImageView ivControlMode;

    @BindView(R.id.iv_cross_bg)
    public ImageView ivCrossBg;

    @BindView(R.id.iv_function)
    public ImageView ivFunction;
    public int j;
    public String k;

    @BindView(R.id.ll_ball)
    public LinearLayout llBall;

    @BindView(R.id.tv_name)
    public AppCompatTextView tvName;

    public MultiControlBallView(@NonNull Context context) {
        super(context);
        g();
    }

    public void A(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivFunction.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.width = ce3.a(getContext(), 24.0f);
        layoutParams.height = ce3.a(getContext(), 14.0f);
        this.ivFunction.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.tvName.getLayoutParams();
        layoutParams2.bottomMargin = i;
        this.tvName.setLayoutParams(layoutParams2);
    }

    public void B() {
        int i = (int) (this.c * 0.293d);
        double d = i;
        C(i, (int) (0.6875d * d), (int) (d * 0.3125d), this.b == 1 ? 12 : 6);
    }

    public final void C(int i, int i2, int i3, int i4) {
        for (int i5 = 4; i5 < this.clMergeBall.getChildCount(); i5++) {
            View childAt = this.clMergeBall.getChildAt(i5);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
            childAt.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_function);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.width = i2;
            layoutParams2.height = i3;
            imageView.setLayoutParams(layoutParams2);
            AppCompatTextView appCompatTextView = (AppCompatTextView) childAt.findViewById(R.id.tv_name);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) appCompatTextView.getLayoutParams();
            layoutParams3.height = i3;
            layoutParams3.leftMargin = ce3.a(getContext(), 2.0f);
            layoutParams3.rightMargin = ce3.a(getContext(), 2.0f);
            appCompatTextView.setLayoutParams(layoutParams3);
            ((TextView) childAt.findViewById(R.id.tv_count)).setTextSize(i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r7) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiControlBallView.a(boolean):void");
    }

    public boolean b(MultiControlBallView multiControlBallView) {
        MultiControlBallView multiControlBallView2 = this.i;
        if (multiControlBallView2 != null && multiControlBallView2 != multiControlBallView) {
            return false;
        }
        float f = multiControlBallView.getCenterLocation()[0];
        float f2 = multiControlBallView.getCenterLocation()[1];
        float f3 = f - getCenterLocation()[0];
        float f4 = f2 - getCenterLocation()[1];
        double dSqrt = Math.sqrt(Math.abs((f3 * f3) + (f4 * f4)));
        this.h = false;
        if (dSqrt < this.c - (this.d * 2)) {
            this.i = multiControlBallView;
            if (this.g == 0) {
                this.g = be3.r();
                return false;
            }
            if (be3.r() - this.g > 300) {
                this.h = true;
                return true;
            }
        } else {
            c();
            this.g = 0L;
        }
        return false;
    }

    public void c() {
        if (this.i != null) {
            this.i = null;
        }
    }

    public int d(int i) {
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public int e(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            return this.e.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public float f() {
        return new BigDecimal(this.c).divide(new BigDecimal(2), 4, 4).floatValue();
    }

    public final void g() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.a = layoutInflaterFrom;
        ButterKnife.bind(this, layoutInflaterFrom.inflate(R.layout.layout_multi_control_ball, this));
        this.e = new HashMap();
        this.f = new HashMap();
        this.b = -1;
    }

    public float[] getCenterLocation() {
        return new float[]{getX() + (getWidth() / 2.0f), getY() + (getHeight() / 2.0f)};
    }

    public int getCurrentMargin() {
        return this.d;
    }

    public int getCurrentSize() {
        return this.c;
    }

    public int getCurrentSizeLevel() {
        return this.b;
    }

    public final View h(BaseBallBean baseBallBean, int i) {
        View viewInflate = this.a.inflate(R.layout.layout_multi_ball, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_function);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        s(baseBallBean, textView, imageView, null, (LinearLayout) viewInflate.findViewById(R.id.ll_ball));
        if (i > 1) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_count);
            textView2.setVisibility(0);
            textView2.setText(i + "+");
        } else {
            textView.setVisibility(baseBallBean.isFunction() ? 8 : 0);
        }
        return viewInflate;
    }

    public void i(ControlBallBean controlBallBean) {
        setX(controlBallBean.getOriginalLocation()[0]);
        setY(controlBallBean.getOriginalLocation()[1]);
        j(controlBallBean, false);
    }

    public void j(ControlBallBean controlBallBean, boolean z) {
        int dimensionPixelSize = this.c;
        List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
        if (z) {
            dimensionPixelSize = (baseBallBeans == null || !controlBallBean.isMergeBall()) ? getResources().getDimensionPixelSize(R.dimen.mutli_toys_trad_ball_size) : getResources().getDimensionPixelSize(R.dimen.mutli_toys_trad_balls_size);
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            setLayoutParams(layoutParams);
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        }
        if (baseBallBeans != null && baseBallBeans.size() > 0) {
            s(baseBallBeans.get(0), this.tvName, this.ivFunction, this.ivActivate, this.llBall);
        }
        this.ivActivate.setVisibility(controlBallBean.isActivate() ? 0 : 4);
        setTag(controlBallBean);
        if (z) {
            z(0);
        } else {
            int controlMode = controlBallBean.getControlMode();
            if (controlMode == 0) {
                this.ivControlMode.setVisibility(8);
            } else {
                this.ivControlMode.setVisibility(0);
                if (baseBallBeans != null && baseBallBeans.size() > 0) {
                    t(controlMode, baseBallBeans.get(0).getToyFun());
                }
            }
        }
        if (baseBallBeans != null && controlBallBean.isMergeBall()) {
            p();
            if (z) {
                C(ce3.a(getContext(), 16.0f), ce3.a(getContext(), 10.0f), ce3.a(getContext(), 6.0f), ce3.g(getContext(), 2.0f));
            } else {
                B();
            }
        } else if (z) {
            p();
        }
        this.tvName.setVisibility(MultiControlPanel.A ? 8 : 0);
        if (!z || MultiControlPanel.A || baseBallBeans == null || baseBallBeans.size() != 1) {
            return;
        }
        A(20);
    }

    public void k(int i) {
        if (!this.e.containsKey(1)) {
            this.e.put(1, Integer.valueOf(Math.min((int) (gg3.c(getContext()) * 0.1d), ce3.a(getContext(), 80.0f))));
        }
        if (!this.f.containsKey(1)) {
            this.f.put(1, Integer.valueOf((int) (this.e.get(1).intValue() * 0.15d)));
        }
        if (!this.f.containsKey(2)) {
            this.f.put(2, Integer.valueOf(ce3.a(getContext(), 10.0f)));
        }
        if (!this.e.containsKey(2)) {
            int iIntValue = this.f.get(2).intValue();
            this.e.put(2, Integer.valueOf(new BigDecimal(i - (iIntValue * 7)).divide(new BigDecimal(6), 2, RoundingMode.HALF_UP).intValue() + (iIntValue * 2)));
        }
        if (!this.e.containsKey(3)) {
            this.e.put(3, Integer.valueOf(this.e.get(2).intValue() - (this.f.get(2).intValue() * 2)));
        }
        if (this.f.containsKey(3)) {
            return;
        }
        this.f.put(3, 0);
    }

    public boolean l() {
        return this.ivCrossBg.getVisibility() == 0;
    }

    public final boolean m(MultiControlBallView multiControlBallView) {
        ControlBallBean controlBallBean = (ControlBallBean) multiControlBallView.getTag();
        ControlBallBean controlBallBean2 = (ControlBallBean) getTag();
        if (controlBallBean == null || controlBallBean2 == null || controlBallBean.getBaseBallBeans().isEmpty() || controlBallBean2.getBaseBallBeans().isEmpty()) {
            return false;
        }
        controlBallBean2.getBaseBallBeans().addAll(controlBallBean.getBaseBallBeans());
        p();
        ViewGroup viewGroup = (ViewGroup) multiControlBallView.getParent();
        if (viewGroup == null) {
            return true;
        }
        viewGroup.removeView(multiControlBallView);
        return true;
    }

    public boolean n(boolean z) {
        MultiControlBallView multiControlBallView = this.i;
        if (multiControlBallView == null || !this.h || !multiControlBallView.m(this)) {
            return false;
        }
        a(z);
        o();
        return true;
    }

    public final void o() {
        c();
        this.h = false;
        this.g = 0L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void p() {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiControlBallView.p():void");
    }

    public void q() {
        r(this.c);
    }

    public void r(int i) {
        this.c = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b7 A[Catch: Exception -> 0x0207, TryCatch #0 {Exception -> 0x0207, blocks: (B:3:0x0008, B:5:0x000f, B:7:0x0026, B:15:0x0044, B:40:0x00a3, B:41:0x00a6, B:82:0x0135, B:84:0x013f, B:88:0x0149, B:90:0x014f, B:94:0x0170, B:97:0x017c, B:131:0x01ea, B:134:0x01f6, B:135:0x01f9, B:132:0x01ee, B:101:0x0189, B:104:0x0191, B:114:0x01b7, B:118:0x01c4, B:121:0x01cc, B:92:0x016a, B:42:0x00ac, B:49:0x00c6, B:55:0x00d7, B:61:0x00eb, B:64:0x00f7, B:67:0x00fc, B:73:0x010d, B:17:0x0048, B:20:0x0052, B:23:0x005b, B:26:0x0065, B:29:0x006f, B:32:0x0079, B:35:0x0083, B:6:0x001b), top: B:140:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017c A[Catch: Exception -> 0x0207, TRY_ENTER, TryCatch #0 {Exception -> 0x0207, blocks: (B:3:0x0008, B:5:0x000f, B:7:0x0026, B:15:0x0044, B:40:0x00a3, B:41:0x00a6, B:82:0x0135, B:84:0x013f, B:88:0x0149, B:90:0x014f, B:94:0x0170, B:97:0x017c, B:131:0x01ea, B:134:0x01f6, B:135:0x01f9, B:132:0x01ee, B:101:0x0189, B:104:0x0191, B:114:0x01b7, B:118:0x01c4, B:121:0x01cc, B:92:0x016a, B:42:0x00ac, B:49:0x00c6, B:55:0x00d7, B:61:0x00eb, B:64:0x00f7, B:67:0x00fc, B:73:0x010d, B:17:0x0048, B:20:0x0052, B:23:0x005b, B:26:0x0065, B:29:0x006f, B:32:0x0079, B:35:0x0083, B:6:0x001b), top: B:140:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(com.wear.bean.controlmutlitoys.BaseBallBean r22, android.widget.TextView r23, android.widget.ImageView r24, android.widget.ImageView r25, android.widget.LinearLayout r26) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiControlBallView.s(com.wear.bean.controlmutlitoys.BaseBallBean, android.widget.TextView, android.widget.ImageView, android.widget.ImageView, android.widget.LinearLayout):void");
    }

    public void setCurrentSizeLevel(int i) {
        this.b = i;
        if (this.e.containsKey(Integer.valueOf(i))) {
            this.c = this.e.get(Integer.valueOf(i)).intValue();
        }
        if (this.f.containsKey(Integer.valueOf(i))) {
            this.d = this.f.get(Integer.valueOf(i)).intValue();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
    }

    public void setIvCrossBgVisible(boolean z) {
        this.ivCrossBg.setVisibility(z ? 0 : 8);
    }

    public void setStyle(int i) {
        this.j = i;
        if (i == 2) {
            this.ivCrossBg.setImageResource(R.drawable.shape_multi_control_expand_panel_bg_dark);
            this.clMergeBall.setBackgroundResource(R.drawable.multi_ingroup_dark);
        }
    }

    public void t(int i, String str) {
        u(i, str, false);
    }

    public void u(int i, String str, boolean z) {
        int i2;
        str.hashCode();
        switch (str) {
            case "d":
            case "r":
            case "v2":
            case "pos":
                if (this.j != 2) {
                    if (i != 2) {
                        i2 = R.drawable.ball_float_vibration_circle_blue;
                        break;
                    } else {
                        i2 = R.drawable.ball_loop_vibration_circle_blue;
                        break;
                    }
                } else if (i != 2) {
                    i2 = R.drawable.ball_float_vibration_circle_blue_dark;
                    break;
                } else {
                    i2 = R.drawable.ball_loop_vibration_circle_blue_dark;
                    break;
                }
            case "f":
            case "p":
            case "v3":
                if (this.j != 2) {
                    if (i != 2) {
                        i2 = R.drawable.ball_float_vibration_circle_purple;
                        break;
                    } else {
                        i2 = R.drawable.ball_loop_vibration_circle_purple;
                        break;
                    }
                } else if (i != 2) {
                    i2 = R.drawable.ball_float_vibration_circle_purple_dark;
                    break;
                } else {
                    i2 = R.drawable.ball_loop_vibration_circle_purple_dark;
                    break;
                }
            default:
                if (this.j != 2) {
                    if (i != 2) {
                        i2 = R.drawable.ball_float_vibration_circle_pink;
                        break;
                    } else {
                        i2 = R.drawable.ball_loop_vibration_circle_pink;
                        break;
                    }
                } else if (i != 2) {
                    i2 = R.drawable.ball_float_vibration_circle_pink_dark;
                    break;
                } else {
                    i2 = R.drawable.ball_loop_vibration_circle_pink_dark;
                    break;
                }
        }
        this.ivControlMode.setImageResource(i2);
        if (z) {
            this.ivControlMode.setVisibility(0);
        }
    }

    public void v() {
        int i = this.c;
        double d = i;
        int i2 = this.b;
        int i3 = (int) (d * (i2 == 3 ? 0.893d : 0.587d));
        int i4 = (int) (i * (i2 == 3 ? 0.402d : 0.267d));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ivFunction.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        this.ivFunction.setLayoutParams(layoutParams);
    }

    @SuppressLint({"RestrictedApi"})
    public void w() throws IllegalArgumentException {
        this.tvName.setAutoSizeTextTypeUniformWithConfiguration(4, this.b == 1 ? 12 : 8, 1, 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tvName.getLayoutParams();
        layoutParams.height = ce3.a(getContext(), this.b == 1 ? 20.0f : 10.0f);
        this.tvName.setLayoutParams(layoutParams);
    }

    public void x(float f, float f2) {
        setX(f);
        setY(f2);
    }

    public void y() {
        z(this.d);
    }

    public void z(int i) {
        this.d = i;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.llBall.getLayoutParams();
        layoutParams.setMargins(i, i, i, i);
        this.llBall.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.clMergeBall.getLayoutParams();
        layoutParams2.setMargins(i, i, i, i);
        this.clMergeBall.setLayoutParams(layoutParams2);
    }

    public MultiControlBallView(@NonNull Context context, String str) {
        super(context);
        g();
        this.k = str;
    }

    public MultiControlBallView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public MultiControlBallView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }
}
