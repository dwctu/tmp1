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
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import dc.de3;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DepthControlView extends RelativeLayout {
    public ArrayList<View> a;
    public int b;
    public b c;
    public float[] d;
    public float e;

    public class a implements View.OnTouchListener {
        public float a;
        public int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ View e;
        public final /* synthetic */ View f;

        public a(int i, TextView textView, View view, View view2) {
            this.c = i;
            this.d = textView;
            this.e = view;
            this.f = view2;
            this.b = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                int r0 = r9.getActionMasked()
                java.lang.String r1 = ""
                r2 = 0
                r3 = 1
                if (r0 == 0) goto Laa
                if (r0 == r3) goto L90
                r8 = 2
                if (r0 == r8) goto L14
                r8 = 3
                if (r0 == r8) goto L90
                goto La9
            L14:
                float r0 = r7.a
                float r4 = r9.getRawX()
                float r0 = r0 - r4
                android.view.View r4 = r7.f
                float r4 = r4.getX()
                float r4 = r4 - r0
                r0 = 0
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 >= 0) goto L29
                r4 = 0
                goto L43
            L29:
                com.wear.widget.DepthControlView r0 = com.wear.widget.DepthControlView.this
                int r0 = r0.getRight()
                com.wear.widget.DepthControlView r5 = com.wear.widget.DepthControlView.this
                int r6 = r5.b
                int r0 = r0 - r6
                float r0 = (float) r0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 <= 0) goto L43
                int r0 = r5.getRight()
                com.wear.widget.DepthControlView r4 = com.wear.widget.DepthControlView.this
                int r4 = r4.b
                int r0 = r0 - r4
                float r4 = (float) r0
            L43:
                android.view.View r0 = r7.f
                float[] r8 = new float[r8]
                float r5 = r0.getX()
                r8[r2] = r5
                r8[r3] = r4
                java.lang.String r4 = "x"
                android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r0, r4, r8)
                android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
                r0.<init>()
                android.animation.Animator[] r3 = new android.animation.Animator[r3]
                r3[r2] = r8
                r0.playTogether(r3)
                r3 = 0
                r0.setDuration(r3)
                r0.start()
                float r8 = r9.getRawX()
                r7.a = r8
                com.wear.widget.DepthControlView r8 = com.wear.widget.DepthControlView.this
                android.view.View r9 = r7.f
                float r9 = r9.getX()
                int r8 = com.wear.widget.DepthControlView.b(r8, r9)
                android.widget.TextView r9 = r7.d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r9.setText(r8)
                goto La9
            L90:
                float r8 = r9.getRawX()
                r7.a = r8
                android.view.View r8 = r7.e
                r9 = 4
                r8.setVisibility(r9)
                com.wear.widget.DepthControlView r8 = com.wear.widget.DepthControlView.this
                int r9 = r7.b
                android.view.View r0 = r7.f
                float r0 = r0.getX()
                com.wear.widget.DepthControlView.c(r8, r9, r0)
            La9:
                return r2
            Laa:
                float r9 = r9.getRawX()
                r7.a = r9
                android.widget.TextView r9 = r7.d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                com.wear.widget.DepthControlView r1 = com.wear.widget.DepthControlView.this
                float r4 = r7.a
                int r1 = com.wear.widget.DepthControlView.a(r1, r4)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r9.setText(r0)
                android.view.View r9 = r7.e
                r9.setVisibility(r2)
                r8.bringToFront()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.DepthControlView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public interface b {
        void G3(int i, int i2);

        void e(int i);
    }

    public DepthControlView(Context context) {
        super(context);
        this.a = new ArrayList<>();
    }

    public final int d(float f) {
        int i = (int) (f / this.e);
        if (i >= 20) {
            return 20;
        }
        return i;
    }

    public final int e(float f) {
        int iD = d(f);
        b bVar = this.c;
        if (bVar != null) {
            bVar.e(iD);
        }
        return iD;
    }

    public final void f(int i, float f) {
        if (this.c == null) {
            return;
        }
        try {
            int iD = d(f);
            this.c.G3(i, iD);
            this.d[i - 1] = iD;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void g(View view, TextView textView, View view2, int i) {
        view.setOnTouchListener(new a(i, textView, view2, view));
    }

    public final void h() {
        float[] fArr = this.d;
        if (fArr == null || fArr.length != this.a.size()) {
            return;
        }
        for (int i = 0; i < this.d.length; i++) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a.get(i), "x", this.d[i] * this.e);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat);
            animatorSet.setDuration(0L);
            animatorSet.start();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.d == null) {
            this.d = new float[]{3.0f, 8.0f, 13.0f, 18.0f};
        }
        this.e = (i - this.b) / 20.0f;
        h();
    }

    public void setListener(b bVar) {
        this.c = bVar;
    }

    public void setViewLocation(int[] iArr) {
        if (iArr == null || iArr.length != this.a.size()) {
            return;
        }
        if (this.d == null) {
            this.d = new float[]{5.0f, 10.0f, 15.0f, 20.0f};
        }
        int i = 0;
        while (true) {
            float[] fArr = this.d;
            if (i >= fArr.length) {
                h();
                return;
            } else {
                fArr[i] = iArr[i];
                i++;
            }
        }
    }

    public DepthControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList<>();
        int[] iArr = {1, 2, 3, 4};
        this.b = de3.a(context, 50.0f);
        int iA = de3.a(context, 70.0f);
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_depth_control, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_v_2);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            textView.setLineSpacing(1.0f, 1.0f);
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
            textView.setBackgroundResource(R.drawable.line_trans_bg_blue_round);
            textView.setText("" + i2);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_tip_v_1);
            View viewFindViewById = viewInflate.findViewById(R.id.rl_tip);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.b, iA);
            layoutParams.addRule(15);
            addView(viewInflate, layoutParams);
            this.a.add(viewInflate);
            g(viewInflate, textView2, viewFindViewById, i2);
        }
    }
}
