package com.wear.util.camera.record.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.lovense.wear.R;
import dc.vi1;

/* loaded from: classes4.dex */
public class FocusImageView extends AppCompatImageView {
    public int a;
    public int b;
    public int c;
    public Animation d;
    public Handler e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusImageView.this.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusImageView.this.setVisibility(8);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusImageView.this.setVisibility(8);
        }
    }

    public FocusImageView(Context context) {
        super(context);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = AnimationUtils.loadAnimation(getContext(), R.anim.focusview_show);
        setVisibility(8);
        this.e = new Handler();
    }

    public void a() {
        setImageResource(this.c);
        this.e.removeCallbacks(null, null);
        this.e.postDelayed(new c(), 1000L);
    }

    public void b() {
        setImageResource(this.b);
        this.e.removeCallbacks(null, null);
        this.e.postDelayed(new b(), 1000L);
    }

    public void c(Point point) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.topMargin = point.y - (getHeight() / 2);
        layoutParams.leftMargin = point.x - (getWidth() / 2);
        setLayoutParams(layoutParams);
        setVisibility(0);
        setImageResource(this.a);
        startAnimation(this.d);
        this.e.postDelayed(new a(), 3500L);
    }

    public void setFocusImg(int i) {
        this.a = i;
    }

    public void setFocusSucceedImg(int i) {
        this.b = i;
    }

    public FocusImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = AnimationUtils.loadAnimation(getContext(), R.anim.focusview_show);
        this.e = new Handler();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.FocusImageView);
        this.a = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.c = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
    }
}
