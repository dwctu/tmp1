package com.wear.widget.control;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class FingImageLayout {
    public static final String ObjectAnimatorX = "x";
    public static final String ObjectAnimatorY = "y";
    public ImageView fingerFunc;
    public ImageView fingerRound;
    public RelativeLayout layout;

    public FingImageLayout(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2) {
        this.layout = relativeLayout;
        this.fingerRound = imageView;
        this.fingerFunc = imageView2;
    }

    public void choosed(boolean z) {
        if (z) {
            this.fingerRound.setVisibility(0);
        } else {
            this.fingerRound.setVisibility(8);
        }
    }

    public int getHeight() {
        return this.layout.getHeight();
    }

    public ViewGroup getLayout() {
        return this.layout;
    }

    public Object getTag() {
        return this.layout.getTag();
    }

    public int getVisibility() {
        return this.layout.getVisibility();
    }

    public int getWidth() {
        return this.layout.getWidth();
    }

    public float getX() {
        return this.layout.getX();
    }

    public float getY() {
        return this.layout.getY();
    }

    public void resetViewSize(int i) {
        String str = "resetViewSize size = : " + i;
        ViewGroup.LayoutParams layoutParams = this.layout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.layout.setLayoutParams(layoutParams);
    }

    public void setBackgroundImageResource(int i) {
        this.fingerRound.setBackgroundResource(i);
    }

    public void setImageResource(int i) {
        this.fingerFunc.setBackgroundResource(i);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.layout.setOnTouchListener(onTouchListener);
    }

    public void setTag(Object obj) {
        this.layout.setTag(obj);
    }

    public void setVisibility(int i) {
        this.layout.setVisibility(i);
    }

    public void setX(float f) {
        this.layout.setX(f);
    }

    public void setY(float f) {
        this.layout.setY(f);
    }
}
