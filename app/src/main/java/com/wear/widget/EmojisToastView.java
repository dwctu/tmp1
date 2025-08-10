package com.wear.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.ie3;
import java.io.File;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes4.dex */
public class EmojisToastView extends FrameLayout {
    public View a;
    public FrameLayout.LayoutParams b;
    public ImageView c;
    public TextView d;
    public GifImageView e;
    public ImageView f;
    public LottieAnimationView g;

    public class a extends SimpleImageLoadingListener {
        public a() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                EmojisToastView.this.e.setVisibility(0);
                File file = ImageLoader.getInstance().getDiskCache().get(str);
                if (file.exists()) {
                    try {
                        EmojisToastView.this.e.setImageDrawable(new GifDrawable(file));
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            EmojisToastView.this.e.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public EmojisToastView(@NonNull Context context) {
        super(context);
    }

    public void a(Context context) {
        removeAllViews();
        this.a = LayoutInflater.from(context).inflate(R.layout.item_emojis_toast, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ce3.a(context, 80.0f), ce3.a(context, 141.0f));
        this.b = layoutParams;
        layoutParams.setMargins(0, 0, 0, 0);
        this.a.setLayoutParams(this.b);
        this.c = (ImageView) this.a.findViewById(R.id.iv_emojis_face);
        this.d = (TextView) this.a.findViewById(R.id.tv_emojis_name);
        this.g = (LottieAnimationView) this.a.findViewById(R.id.lottie_view);
        this.a.setVisibility(8);
        addView(this.a);
    }

    public void b(Context context) {
        removeAllViews();
        this.a = LayoutInflater.from(context).inflate(R.layout.item_favorite_toast, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ce3.a(context, 165.0f), ce3.a(context, 165.0f));
        this.b = layoutParams;
        layoutParams.setMargins(0, 0, 0, 0);
        this.a.setLayoutParams(this.b);
        this.e = (GifImageView) this.a.findViewById(R.id.iv_center_gif);
        this.f = (ImageView) this.a.findViewById(R.id.iv_bottom_tip);
        this.a.setVisibility(8);
        addView(this.a);
    }

    public void c() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void d(ie3 ie3Var, int i, int i2, String str) {
        View view = this.a;
        if (view != null) {
            view.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.b;
            if (layoutParams != null) {
                layoutParams.setMargins(i - (layoutParams.width / 2), i2 - layoutParams.height, 0, 0);
                this.d.setText(str.replace("[", "").replace("]", ""));
                String strS = ie3Var.s(str, false);
                if (TextUtils.isEmpty(strS)) {
                    this.g.setVisibility(8);
                    this.g.g();
                    Bitmap bitmapF = ie3Var.F(str);
                    if (bitmapF == null) {
                        this.c.setVisibility(4);
                    } else {
                        this.c.setVisibility(0);
                        this.c.setImageBitmap(bitmapF);
                    }
                } else {
                    this.c.setVisibility(8);
                    this.g.setVisibility(0);
                    ie3Var.O(this.g, strS);
                }
                this.a.setLayoutParams(this.b);
            }
        }
    }

    public void e(ie3 ie3Var, int i, int i2, int i3, int i4, String str, String str2, String str3) {
        View view = this.a;
        if (view != null) {
            view.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.b;
            if (layoutParams != null) {
                int i5 = layoutParams.width;
                int i6 = i - (i5 / 2);
                if (i6 < 0) {
                    i6 = 0;
                } else if (i6 > i3 - i5) {
                    i6 = i3 - i5;
                }
                layoutParams.setMargins(i6, i2 - layoutParams.height, 0, 0);
                this.a.setLayoutParams(this.b);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams2.setMargins(((i - i6) - (i4 / 3)) + (i4 / 6), 0, 0, 0);
                this.f.setLayoutParams(layoutParams2);
                if (WearUtils.e1(str)) {
                    this.e.setVisibility(8);
                    return;
                }
                ImageLoader.getInstance().displayImage(WearUtils.e + str, this.e, MyApplication.Y, new a());
            }
        }
    }

    public EmojisToastView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojisToastView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
