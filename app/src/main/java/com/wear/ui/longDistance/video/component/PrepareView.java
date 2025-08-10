package com.wear.ui.longDistance.video.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.mj4;
import dc.nj4;
import dc.zj4;

/* loaded from: classes4.dex */
public class PrepareView extends FrameLayout implements nj4 {
    public mj4 a;
    public ImageView b;
    public ImageView c;
    public ProgressBar d;
    public FrameLayout e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrepareView.this.e.setVisibility(8);
            zj4.d().h(true);
            PrepareView.this.a.start();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrepareView.this.a.start();
        }
    }

    public PrepareView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.thumb);
        this.c = (ImageView) findViewById(R.id.start_play);
        this.d = (ProgressBar) findViewById(R.id.loading);
        this.e = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new a());
    }

    @Override // dc.nj4
    public void a(int i) {
        switch (i) {
            case -1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setVisibility(8);
                break;
            case 0:
                setVisibility(0);
                bringToFront();
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                this.c.setVisibility(0);
                this.b.setVisibility(0);
                break;
            case 1:
                bringToFront();
                setVisibility(0);
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                this.d.setVisibility(0);
                break;
            case 8:
                setVisibility(0);
                this.e.setVisibility(0);
                this.e.bringToFront();
                break;
        }
    }

    @Override // dc.nj4
    public void b(int i) {
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
    }

    @Override // dc.nj4
    public void e(@NonNull mj4 mj4Var) {
        this.a = mj4Var;
    }

    @Override // dc.nj4
    public View getView() {
        return this;
    }

    @Override // dc.nj4
    public void i(boolean z) {
    }

    public void setClickStart() {
        setOnClickListener(new b());
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public PrepareView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.thumb);
        this.c = (ImageView) findViewById(R.id.start_play);
        this.d = (ProgressBar) findViewById(R.id.loading);
        this.e = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new a());
    }

    public PrepareView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_prepare_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.thumb);
        this.c = (ImageView) findViewById(R.id.start_play);
        this.d = (ProgressBar) findViewById(R.id.loading);
        this.e = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new a());
    }
}
