package com.wear.widget.control.multiToys;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.widget.control.FingImageLayout;
import dc.de3;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: classes4.dex */
public class MultiTradSeekBar extends RelativeLayout implements View.OnTouchListener {
    public c a;
    public TextView b;
    public RelativeLayout c;
    public int d;
    public int e;
    public int f;
    public MultiControlBallView g;
    public float h;
    public int i;
    public boolean j;
    public int k;
    public float l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiTradSeekBar multiTradSeekBar = MultiTradSeekBar.this;
            multiTradSeekBar.setVibrationBgColor(multiTradSeekBar.i);
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0) {
                MultiTradSeekBar multiTradSeekBar = MultiTradSeekBar.this;
                multiTradSeekBar.onTouch(multiTradSeekBar.g, motionEvent);
                return false;
            }
            float y = motionEvent.getY();
            float height = view.getHeight();
            MultiTradSeekBar.this.setProgress((int) (((height - y) * 100.0f) / height));
            motionEvent.setAction(0);
            MultiTradSeekBar multiTradSeekBar2 = MultiTradSeekBar.this;
            multiTradSeekBar2.onTouch(multiTradSeekBar2.g, motionEvent);
            return true;
        }
    }

    public interface c {
        void a(int i);

        void b(int i);
    }

    public MultiTradSeekBar(Context context) {
        super(context);
        this.i = 0;
        this.j = false;
    }

    private void setDeth(float f) {
        if (this.a == null) {
            return;
        }
        try {
            int iD = d(f);
            this.a.a(100 - iD);
            this.i = iD;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVibrationBgColor(int i) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = ((this.d - (this.e * 2)) * (100 - i)) / 100;
        this.b.setLayoutParams(layoutParams);
        invalidate();
    }

    public final int d(float f) {
        int iIntValue = new BigDecimal(f).divide(new BigDecimal(this.l), 0, RoundingMode.HALF_UP).intValue();
        if (iIntValue >= 100) {
            return 100;
        }
        return iIntValue;
    }

    public void e(ControlBallBean controlBallBean) {
        this.g.j(controlBallBean, true);
        this.k = controlBallBean.getProgress();
        setProgress(controlBallBean.getProgress());
        List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
        if (baseBallBeans != null) {
            try {
                GradientDrawable gradientDrawable = (GradientDrawable) this.b.getBackground();
                gradientDrawable.setColor(getResources().getColor(baseBallBeans.size() <= 1 ? Toy.getCurveLineColor(baseBallBeans.get(0).getToyFun()) : Toy.getCurveLineColor(PSOProgramService.VS_Key)));
                this.b.setBackground(gradientDrawable);
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public final int f(float f) {
        int i;
        int iD = d(f);
        c cVar = this.a;
        if (cVar != null && (i = 100 - iD) != this.k) {
            cVar.b(i);
            this.k = i;
        }
        return iD;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void g() {
        if (this.j) {
            this.c.setOnTouchListener(new b());
        }
    }

    public final void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, FingImageLayout.ObjectAnimatorY, this.i * this.l);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = getMeasuredHeight();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = (i2 - (this.e * 4)) / 100.0f;
        setProgress(this.k);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiTradSeekBar.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setListener(c cVar) {
        this.a = cVar;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        int i2 = 100 - i;
        this.i = i2;
        h();
        setVibrationBgColor(i2);
    }

    public void setStepSize(int i) {
        this.f = i;
    }

    public MultiTradSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.j = false;
        this.e = de3.a(context, 10.0f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_multi_trad_seekbar, (ViewGroup) null);
        this.g = (MultiControlBallView) viewInflate.findViewById(R.id.multi_seekbar_slid);
        this.b = (TextView) viewInflate.findViewById(R.id.multi_seekbar_bg);
        this.c = (RelativeLayout) viewInflate.findViewById(R.id.multi_seekbar_bg_layout);
        addView(viewInflate);
        this.g.setOnTouchListener(this);
        this.b.post(new a());
        g();
    }
}
