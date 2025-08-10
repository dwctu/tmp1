package com.wear.widget;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import skin.support.widget.SkinCompatImageView;

/* loaded from: classes4.dex */
public class BaseImageButton extends SkinCompatImageView {
    public static final View.OnTouchListener c = new a();

    public class a implements View.OnTouchListener {
        public final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, -50.0f, 0.0f, 1.0f, 0.0f, 0.0f, -50.0f, 0.0f, 0.0f, 1.0f, 0.0f, -50.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        public final float[] b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (view.getBackground() == null) {
                    ((ImageView) view).getDrawable().setColorFilter(new ColorMatrixColorFilter(this.a));
                    return false;
                }
                view.getBackground().setColorFilter(new ColorMatrixColorFilter(this.a));
                view.setBackground(view.getBackground());
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (view.getBackground() == null) {
                ((ImageView) view).getDrawable().setColorFilter(new ColorMatrixColorFilter(this.b));
                return false;
            }
            view.getBackground().setColorFilter(new ColorMatrixColorFilter(this.b));
            view.setBackground(view.getBackground());
            return false;
        }
    }

    public BaseImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        setOnTouchListener(c);
    }
}
