package com.wear.ui.longDistance.video.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.gk4;
import xyz.doikki.videoplayer.controller.GestureVideoController;

/* loaded from: classes4.dex */
public class StandardVideoController extends GestureVideoController implements View.OnClickListener {
    public ImageView G;
    public ProgressBar K;

    public StandardVideoController(@NonNull Context context) {
        this(context, null);
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public int getLayoutId() {
        return R.layout.dkplayer_layout_standard_controller;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.lock) {
            this.a.m();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.GestureVideoController, xyz.doikki.videoplayer.controller.BaseVideoController
    public void s() {
        super.s();
        ImageView imageView = (ImageView) findViewById(R.id.lock);
        this.G = imageView;
        imageView.setOnClickListener(this);
        this.K = (ProgressBar) findViewById(R.id.loading);
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void t(boolean z) {
        if (z) {
            this.G.setSelected(true);
        } else {
            this.G.setSelected(false);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void x(int i) {
        super.x(i);
        switch (i) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 7:
                this.K.setVisibility(8);
                break;
            case 0:
                this.G.setSelected(false);
                this.K.setVisibility(8);
                break;
            case 1:
            case 6:
                this.K.setVisibility(0);
                break;
            case 5:
                this.K.setVisibility(8);
                this.G.setVisibility(8);
                this.G.setSelected(false);
                break;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void y(int i) {
        super.y(i);
        if (i == 10) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.G.setVisibility(8);
        } else if (i == 11) {
            if (isShowing()) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(8);
            }
        }
        if (this.b == null || !b()) {
            return;
        }
        int requestedOrientation = this.b.getRequestedOrientation();
        int iA = gk4.a(getContext(), 24.0f);
        int cutoutHeight = getCutoutHeight();
        if (requestedOrientation == 1) {
            ((FrameLayout.LayoutParams) this.G.getLayoutParams()).setMargins(iA, 0, iA, 0);
            return;
        }
        if (requestedOrientation == 0) {
            int i2 = iA + cutoutHeight;
            ((FrameLayout.LayoutParams) this.G.getLayoutParams()).setMargins(i2, 0, i2, 0);
        } else if (requestedOrientation == 8) {
            ((FrameLayout.LayoutParams) this.G.getLayoutParams()).setMargins(iA, 0, iA, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void z(boolean z, Animation animation) {
        if (this.a.c()) {
            if (!z) {
                this.G.setVisibility(8);
                if (animation != null) {
                    this.G.startAnimation(animation);
                    return;
                }
                return;
            }
            if (this.G.getVisibility() == 8) {
                this.G.setVisibility(8);
                if (animation != null) {
                    this.G.startAnimation(animation);
                }
            }
        }
    }

    public StandardVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StandardVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
    }
}
