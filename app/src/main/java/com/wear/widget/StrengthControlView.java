package com.wear.widget;

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
public class StrengthControlView extends RelativeLayout {
    public int a;
    public b b;
    public View c;
    public float d;
    public float e;

    public class a implements View.OnTouchListener {
        public float a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public a(TextView textView, View view, View view2) {
            this.b = textView;
            this.c = view;
            this.d = view2;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
            /*
                r8 = this;
                int r0 = r10.getActionMasked()
                java.lang.String r1 = "%"
                java.lang.String r2 = ""
                r3 = 0
                r4 = 1
                if (r0 == 0) goto Lad
                if (r0 == r4) goto L95
                r9 = 2
                if (r0 == r9) goto L16
                r9 = 3
                if (r0 == r9) goto L95
                goto Lac
            L16:
                float r0 = r8.a
                float r5 = r10.getRawX()
                float r0 = r0 - r5
                android.view.View r5 = r8.d
                float r5 = r5.getX()
                float r5 = r5 - r0
                r0 = 0
                int r6 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r6 >= 0) goto L2b
                r5 = 0
                goto L45
            L2b:
                com.wear.widget.StrengthControlView r0 = com.wear.widget.StrengthControlView.this
                int r0 = r0.getRight()
                com.wear.widget.StrengthControlView r6 = com.wear.widget.StrengthControlView.this
                int r7 = r6.a
                int r0 = r0 - r7
                float r0 = (float) r0
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 <= 0) goto L45
                int r0 = r6.getRight()
                com.wear.widget.StrengthControlView r5 = com.wear.widget.StrengthControlView.this
                int r5 = r5.a
                int r0 = r0 - r5
                float r5 = (float) r0
            L45:
                android.view.View r0 = r8.d
                float[] r9 = new float[r9]
                float r6 = r0.getX()
                r9[r3] = r6
                r9[r4] = r5
                java.lang.String r5 = "x"
                android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r0, r5, r9)
                android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
                r0.<init>()
                android.animation.Animator[] r4 = new android.animation.Animator[r4]
                r4[r3] = r9
                r0.playTogether(r4)
                r4 = 0
                r0.setDuration(r4)
                r0.start()
                float r9 = r10.getRawX()
                r8.a = r9
                com.wear.widget.StrengthControlView r9 = com.wear.widget.StrengthControlView.this
                android.view.View r10 = r8.d
                float r10 = r10.getX()
                int r9 = com.wear.widget.StrengthControlView.b(r9, r10)
                android.widget.TextView r10 = r8.b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                r0.append(r9)
                r0.append(r1)
                java.lang.String r9 = r0.toString()
                r10.setText(r9)
                goto Lac
            L95:
                float r9 = r10.getRawX()
                r8.a = r9
                android.view.View r9 = r8.c
                r10 = 4
                r9.setVisibility(r10)
                com.wear.widget.StrengthControlView r9 = com.wear.widget.StrengthControlView.this
                android.view.View r10 = r8.d
                float r10 = r10.getX()
                com.wear.widget.StrengthControlView.c(r9, r10)
            Lac:
                return r3
            Lad:
                float r10 = r10.getRawX()
                r8.a = r10
                android.widget.TextView r10 = r8.b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r2)
                com.wear.widget.StrengthControlView r2 = com.wear.widget.StrengthControlView.this
                float r5 = r8.a
                int r2 = com.wear.widget.StrengthControlView.a(r2, r5)
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r10.setText(r0)
                android.view.View r10 = r8.c
                r10.setVisibility(r3)
                r9.bringToFront()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.StrengthControlView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public interface b {
        void e(int i);

        void setDeth(int i);
    }

    public StrengthControlView(Context context) {
        super(context);
        this.d = 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeth(float f) {
        if (this.b == null) {
            return;
        }
        try {
            int iD = d(f);
            this.b.setDeth(iD);
            this.d = iD;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int d(float f) {
        int i = (int) (f / this.e);
        if (i >= 100) {
            return 100;
        }
        return i;
    }

    public final int e(float f) {
        int iD = d(f);
        b bVar = this.b;
        if (bVar != null) {
            bVar.e(iD);
        }
        return iD;
    }

    public final void f(View view, TextView textView, View view2) {
        view.setOnTouchListener(new a(textView, view2, view));
    }

    public final void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "x", this.d * this.e);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = (i - this.a) / 100.0f;
        g();
    }

    public void setListener(b bVar) {
        this.b = bVar;
    }

    public void setViewLocation(int i) {
        this.d = i;
        g();
    }

    public StrengthControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 100.0f;
        this.a = de3.a(context, 50.0f);
        int iA = de3.a(context, 77.0f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_toy_strength, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_v_1);
        View viewFindViewById = viewInflate.findViewById(R.id.rl_tip);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, iA);
        layoutParams.addRule(15);
        addView(viewInflate, layoutParams);
        this.c = viewInflate;
        f(viewInflate, textView, viewFindViewById);
    }
}
