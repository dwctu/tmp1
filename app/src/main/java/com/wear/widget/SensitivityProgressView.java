package com.wear.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.ce3;

/* loaded from: classes4.dex */
public class SensitivityProgressView extends RelativeLayout {
    public final LottieAnimationView a;
    public final View.OnTouchListener b;
    public int c;
    public LayoutInflater d;
    public float e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public float j;
    public b k;

    public class a implements View.OnTouchListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00dd  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.SensitivityProgressView.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public interface b {
        void a(int i);

        void b(int i);
    }

    public SensitivityProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 100;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.d = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_sensitivity, (ViewGroup) null);
        addView(viewInflate);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(R.id.progress_view);
        this.a = lottieAnimationView;
        this.c = ce3.a(WearUtils.x, 40.0f);
        a aVar = new a();
        this.b = aVar;
        lottieAnimationView.setOnTouchListener(aVar);
    }

    public int getProgress() {
        return this.g;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = getMeasuredHeight();
        this.h = measuredHeight;
        int i5 = this.g;
        if (i5 != 100) {
            float f = this.e;
            float f2 = ((measuredHeight - this.c) * (100 - i5)) / 100;
            this.e = f2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "translationY", f, f2);
            objectAnimatorOfFloat.setDuration(0L);
            objectAnimatorOfFloat.start();
        }
    }

    public void setProgress(int i) {
        this.g = i;
    }

    public void setResume(int i) {
        this.g = i;
        int measuredHeight = getMeasuredHeight();
        this.h = measuredHeight;
        float f = this.e;
        float f2 = ((measuredHeight - this.c) * (100 - i)) / 100;
        this.e = f2;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "translationY", f, f2);
        objectAnimatorOfFloat.setDuration(0L);
        objectAnimatorOfFloat.start();
    }

    public void setSetProgressListen(b bVar) {
        this.k = bVar;
    }
}
