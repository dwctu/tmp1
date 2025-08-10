package com.wear.widget.control;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import dc.ce3;

/* loaded from: classes4.dex */
public class FingerImageVerticalSeekBarView extends RelativeLayout {
    public LayoutInflater a;
    public View b;
    public ImageView c;
    public int d;
    public int e;
    public float f;
    public float g;
    public ViewGroup.LayoutParams h;
    public FingerImageVerticalSeekBarView i;
    public View.OnTouchListener j;
    public b k;

    public class a implements View.OnTouchListener {
        public final /* synthetic */ ImageView a;

        public a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                FingerImageVerticalSeekBarView.this.f = motionEvent.getRawX();
                FingerImageVerticalSeekBarView.this.g = motionEvent.getRawY();
                return true;
            }
            if (actionMasked == 2) {
                float rawX = FingerImageVerticalSeekBarView.this.f - motionEvent.getRawX();
                float y = this.a.getY() - (FingerImageVerticalSeekBarView.this.g - motionEvent.getRawY());
                float x = this.a.getX() - rawX;
                if (y < 0.0f) {
                    y = 0.0f;
                } else if (y > FingerImageVerticalSeekBarView.this.e - this.a.getHeight()) {
                    y = FingerImageVerticalSeekBarView.this.e - this.a.getHeight();
                }
                if (x >= 0.0f && x > FingerImageVerticalSeekBarView.this.d - this.a.getWidth()) {
                    int unused = FingerImageVerticalSeekBarView.this.d;
                    this.a.getWidth();
                }
                ImageView imageView = this.a;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, FingImageLayout.ObjectAnimatorY, imageView.getY(), y);
                ImageView imageView2 = this.a;
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "x", imageView2.getX(), this.a.getX());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                animatorSet.setDuration(0L);
                animatorSet.start();
                if (FingerImageVerticalSeekBarView.this.k != null) {
                    b bVar = FingerImageVerticalSeekBarView.this.k;
                    FingerImageVerticalSeekBarView fingerImageVerticalSeekBarView = FingerImageVerticalSeekBarView.this.i;
                    FingerImageVerticalSeekBarView fingerImageVerticalSeekBarView2 = FingerImageVerticalSeekBarView.this;
                    bVar.a(fingerImageVerticalSeekBarView, fingerImageVerticalSeekBarView2.h(fingerImageVerticalSeekBarView2.c), true);
                }
                FingerImageVerticalSeekBarView.this.f = motionEvent.getRawX();
                FingerImageVerticalSeekBarView.this.g = motionEvent.getRawY();
            }
            return false;
        }
    }

    public interface b {
        void a(FingerImageVerticalSeekBarView fingerImageVerticalSeekBarView, int i, boolean z);
    }

    public FingerImageVerticalSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = null;
        g(context, attributeSet);
    }

    public void f(ImageView imageView) {
        a aVar = new a(imageView);
        this.j = aVar;
        imageView.setOnTouchListener(aVar);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        this.i = this;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_finger_vertical_seekbar_image, (ViewGroup) null);
        addView(viewInflate);
        viewInflate.findViewById(R.id.vertical_bar_background);
        this.b = viewInflate.findViewById(R.id.finger_length);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.finger_image);
        this.c = imageView;
        f(imageView);
        this.h = this.b.getLayoutParams();
    }

    public int getContainerHeight() {
        return this.e;
    }

    public int getProgress() {
        return h(this.c);
    }

    public final int h(ImageView imageView) {
        float height = imageView.getHeight() / 2;
        return 100 - ((int) ((((imageView.getY() + height) - height) * 100.0f) / ((getContainerHeight() - r0) - r0)));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = ce3.e(i);
        this.e = ce3.d(i2);
    }

    public void setOnSeekBarChangeListener(b bVar) {
        this.k = bVar;
    }

    public void setProgress(int i) {
        if (i > 100) {
            i = 100;
        }
        if (i < 0) {
            i = 0;
        }
        int containerHeight = (int) (getContainerHeight() * ((100 - i) / 100.0f));
        if (containerHeight >= getContainerHeight() - this.c.getHeight()) {
            containerHeight = getContainerHeight() - this.c.getHeight();
        }
        ImageView imageView = this.c;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, FingImageLayout.ObjectAnimatorY, imageView.getY(), containerHeight);
        ImageView imageView2 = this.c;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "x", imageView2.getX(), (this.d / 2) - (this.c.getWidth() / 2));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        animatorSet.setDuration(0L);
        animatorSet.start();
        ViewGroup.LayoutParams layoutParams = this.h;
        layoutParams.height = 0;
        this.b.setLayoutParams(layoutParams);
    }

    public void setProgressDrawable(Drawable drawable) {
        this.b.setBackground(drawable);
    }

    public void setThumb(Drawable drawable) {
        this.c.setBackground(drawable);
    }
}
