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

/* loaded from: classes4.dex */
public class MyStrengthControlViewL extends RelativeLayout {
    public c a;
    public View b;
    public TextView c;
    public int d;
    public int e;
    public float f;
    public float g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyStrengthControlViewL myStrengthControlViewL = MyStrengthControlViewL.this;
            myStrengthControlViewL.setVibrationBgColor((int) myStrengthControlViewL.f);
        }
    }

    public class b implements View.OnTouchListener {
        public float a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ View c;

        public b(TextView textView, View view) {
            this.b = textView;
            this.c = view;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
            /*
                r8 = this;
                android.view.ViewParent r0 = r9.getParent()
                r1 = 1
                r0.requestDisallowInterceptTouchEvent(r1)
                int r0 = r10.getActionMasked()
                java.lang.String r2 = "%"
                java.lang.String r3 = ""
                if (r0 == 0) goto Lac
                r9 = 0
                if (r0 == r1) goto L9a
                r4 = 2
                if (r0 == r4) goto L1d
                r1 = 3
                if (r0 == r1) goto L9a
                goto Lab
            L1d:
                float r0 = r8.a
                float r5 = r10.getRawX()
                float r0 = r0 - r5
                android.view.View r5 = r8.c
                float r5 = r5.getX()
                float r5 = r5 - r0
                r0 = 0
                int r6 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r6 >= 0) goto L32
                r5 = 0
                goto L45
            L32:
                com.wear.widget.llong.MyStrengthControlViewL r0 = com.wear.widget.llong.MyStrengthControlViewL.this
                int r6 = r0.d
                int r0 = r0.e
                int r7 = r0 * 4
                int r7 = r6 - r7
                float r7 = (float) r7
                int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r7 <= 0) goto L45
                int r0 = r0 * 4
                int r6 = r6 - r0
                float r5 = (float) r6
            L45:
                android.view.View r0 = r8.c
                float[] r4 = new float[r4]
                float r6 = r0.getX()
                r4[r9] = r6
                r4[r1] = r5
                java.lang.String r5 = "x"
                android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r5, r4)
                android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
                r4.<init>()
                android.animation.Animator[] r1 = new android.animation.Animator[r1]
                r1[r9] = r0
                r4.playTogether(r1)
                r0 = 0
                r4.setDuration(r0)
                r4.start()
                float r10 = r10.getRawX()
                r8.a = r10
                com.wear.widget.llong.MyStrengthControlViewL r10 = com.wear.widget.llong.MyStrengthControlViewL.this
                android.view.View r0 = r8.c
                float r0 = r0.getX()
                int r10 = com.wear.widget.llong.MyStrengthControlViewL.c(r10, r0)
                android.widget.TextView r0 = r8.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                r1.append(r10)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.setText(r1)
                com.wear.widget.llong.MyStrengthControlViewL r0 = com.wear.widget.llong.MyStrengthControlViewL.this
                com.wear.widget.llong.MyStrengthControlViewL.a(r0, r10)
                goto Lab
            L9a:
                float r10 = r10.getRawX()
                r8.a = r10
                com.wear.widget.llong.MyStrengthControlViewL r10 = com.wear.widget.llong.MyStrengthControlViewL.this
                android.view.View r0 = r8.c
                float r0 = r0.getX()
                com.wear.widget.llong.MyStrengthControlViewL.d(r10, r0)
            Lab:
                return r9
            Lac:
                float r10 = r10.getRawX()
                r8.a = r10
                android.widget.TextView r10 = r8.b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r3)
                com.wear.widget.llong.MyStrengthControlViewL r3 = com.wear.widget.llong.MyStrengthControlViewL.this
                float r4 = r8.a
                int r3 = com.wear.widget.llong.MyStrengthControlViewL.b(r3, r4)
                r0.append(r3)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r10.setText(r0)
                r9.bringToFront()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.llong.MyStrengthControlViewL.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public interface c {
        void e(int i);

        void setDeth(int i);
    }

    public MyStrengthControlViewL(Context context) {
        super(context);
        this.f = 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeth(float f) {
        if (this.a == null) {
            return;
        }
        try {
            int iE = e(f);
            this.a.setDeth(iE);
            this.f = iE;
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

    public final int e(float f) {
        int i = (int) (f / this.g);
        if (i >= 100) {
            return 100;
        }
        return i;
    }

    public final int f(float f) {
        int iE = e(f);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(iE);
        }
        return iE;
    }

    public final void g(View view, TextView textView, View view2) {
        view.setOnTouchListener(new b(textView, view));
    }

    public final void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "x", this.f * this.g);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = getMeasuredWidth();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = (i - (this.e * 4)) / 100.0f;
        h();
    }

    public void setListener(c cVar) {
        this.a = cVar;
    }

    public void setViewLocation(int i) {
        this.f = i;
        h();
        setVibrationBgColor(i);
    }

    public MyStrengthControlViewL(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 100.0f;
        this.e = de3.a(context, 10.0f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.my_view_toy_strength_l, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_v_1);
        View viewFindViewById = viewInflate.findViewById(R.id.rl_tip);
        View viewFindViewById2 = viewInflate.findViewById(R.id.rl_tip_c);
        this.c = (TextView) viewInflate.findViewById(R.id.v_vibration_bg);
        addView(viewInflate);
        this.b = viewFindViewById2;
        g(viewFindViewById2, textView, viewFindViewById);
        this.c.post(new a());
    }
}
