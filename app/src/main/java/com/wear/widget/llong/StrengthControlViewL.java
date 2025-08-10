package com.wear.widget.llong;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import dc.de3;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes4.dex */
public class StrengthControlViewL extends RelativeLayout {
    public d a;
    public View b;
    public TextView c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public View h;
    public TextView i;
    public int j;
    public float k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StrengthControlViewL strengthControlViewL = StrengthControlViewL.this;
            strengthControlViewL.setVibrationBgColor(strengthControlViewL.j);
        }
    }

    public class b implements View.OnTouchListener {
        public float a;
        public final /* synthetic */ View b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ View d;

        public b(View view, TextView textView, View view2) {
            this.b = view;
            this.c = textView;
            this.d = view2;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.llong.StrengthControlViewL.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StrengthControlViewL strengthControlViewL = StrengthControlViewL.this;
            float f = strengthControlViewL.j * strengthControlViewL.k;
            int i = strengthControlViewL.d;
            int i2 = strengthControlViewL.e;
            if (f > i - (i2 * 4)) {
                f = i - (i2 * 4);
            }
            strengthControlViewL.h.setVisibility(StrengthControlViewL.this.g ? 0 : 4);
            if (f == 0.0f) {
                StrengthControlViewL.this.i.setText("0%");
                StrengthControlViewL.this.setVibrationBgColor(0);
            } else {
                StrengthControlViewL.this.i.setText(StrengthControlViewL.this.j + "%");
                StrengthControlViewL strengthControlViewL2 = StrengthControlViewL.this;
                strengthControlViewL2.setVibrationBgColor(strengthControlViewL2.j);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(StrengthControlViewL.this.b, "x", f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat);
            animatorSet.setDuration(0L);
            animatorSet.start();
        }
    }

    public interface d {
        void e(int i);

        void setDeth(int i);
    }

    public StrengthControlViewL(Context context) {
        super(context);
        this.j = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeth(float f) {
        if (this.a == null) {
            return;
        }
        try {
            int iH = h(f);
            this.a.setDeth(iH);
            this.j = iH;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVibrationBgColor(int i) {
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = (((this.d - (this.e * 2)) * i) / 100) - 2;
        this.c.setLayoutParams(layoutParams);
        invalidate();
    }

    public final int h(float f) {
        int iIntValue = new BigDecimal(f).divide(new BigDecimal(this.k), 0, RoundingMode.HALF_UP).intValue();
        if (iIntValue >= 100) {
            return 100;
        }
        return iIntValue;
    }

    public final int i(float f) {
        int iH = h(f);
        d dVar = this.a;
        if (dVar != null) {
            dVar.e(iH);
        }
        return iH;
    }

    public final void j(View view, TextView textView, View view2) {
        view.setOnTouchListener(new b(view, textView, view2));
    }

    public final void k() {
        postDelayed(new c(), 50L);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        this.d = measuredWidth;
        if (measuredWidth != 0) {
            this.k = (measuredWidth - (this.e * 4)) / 100.0f;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        k();
    }

    public void setListener(d dVar) {
        this.a = dVar;
    }

    public void setShowTipAlways(boolean z) {
        this.g = z;
    }

    public void setStepSize(int i) {
        this.f = i;
    }

    public void setViewLocation(int i) {
        this.j = i;
        k();
        setVibrationBgColor(i);
    }

    public StrengthControlViewL(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 100;
        this.e = de3.a(context, 10.0f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_toy_strength_l, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_v_1);
        this.i = textView;
        textView.setText(this.j + "%");
        this.h = viewInflate.findViewById(R.id.rl_tip);
        View viewFindViewById = viewInflate.findViewById(R.id.rl_tip_c);
        this.c = (TextView) viewInflate.findViewById(R.id.v_vibration_bg);
        addView(viewInflate);
        this.b = viewFindViewById;
        j(viewFindViewById, this.i, this.h);
        this.c.post(new a());
    }
}
