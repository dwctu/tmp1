package com.wear.util.clipImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/* loaded from: classes4.dex */
public class ClipImageLayout extends RelativeLayout {
    public ClipZoomImageView a;
    public ClipImageBorderView b;
    public ProgressBar c;
    public int d;

    public class a extends SimpleImageLoadingListener {
        public a() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ClipImageLayout.this.a.setImageBitmap(bitmap);
            ClipImageLayout.this.c.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ClipImageLayout.this.a.setImageDrawable(ClipImageLayout.this.getResources().getDrawable(R.drawable.ic_picture_loadfailed));
            ClipImageLayout.this.c.setVisibility(8);
        }
    }

    public ClipImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 20;
        this.a = new ClipZoomImageView(context);
        this.b = new ClipImageBorderView(context);
        this.c = new ProgressBar(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.a, layoutParams);
        addView(this.b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.c, layoutParams2);
        int iApplyDimension = (int) TypedValue.applyDimension(1, this.d, getResources().getDisplayMetrics());
        this.d = iApplyDimension;
        this.a.setHorizontalPadding(iApplyDimension);
        this.b.setHorizontalPadding(this.d);
    }

    public Bitmap c() {
        return this.a.h();
    }

    public final void d(String str) {
        ImageLoader.getInstance().loadImage("file://" + str, new a());
    }

    public void setHorizontalPadding(int i) {
        this.d = i;
    }

    public void setImage(String str) {
        d(str);
    }
}
