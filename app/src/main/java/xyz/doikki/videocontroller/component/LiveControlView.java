package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.gk4;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.nj4;

/* loaded from: classes5.dex */
public class LiveControlView extends FrameLayout implements nj4, View.OnClickListener {
    public mj4 a;
    public final ImageView b;
    public final LinearLayout c;
    public final ImageView d;

    public LiveControlView(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(this);
        this.c = (LinearLayout) findViewById(ij4.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.d = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(ij4.iv_refresh)).setOnClickListener(this);
    }

    @Override // dc.nj4
    public void a(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 5:
            case 8:
                setVisibility(8);
                break;
            case 3:
                this.d.setSelected(true);
                break;
            case 4:
                this.d.setSelected(false);
                break;
            case 6:
            case 7:
                this.d.setSelected(this.a.isPlaying());
                break;
        }
    }

    @Override // dc.nj4
    public void b(int i) {
        if (i == 10) {
            this.b.setSelected(false);
        } else if (i == 11) {
            this.b.setSelected(true);
        }
        Activity activityL = gk4.l(getContext());
        if (activityL == null || !this.a.b()) {
            return;
        }
        int requestedOrientation = activityL.getRequestedOrientation();
        int cutoutHeight = this.a.getCutoutHeight();
        if (requestedOrientation == 1) {
            this.c.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.c.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.c.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
        if (z) {
            if (getVisibility() == 8) {
                setVisibility(0);
                if (animation != null) {
                    startAnimation(animation);
                    return;
                }
                return;
            }
            return;
        }
        if (getVisibility() == 0) {
            setVisibility(8);
            if (animation != null) {
                startAnimation(animation);
            }
        }
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
        d(!z, null);
    }

    public final void k() {
        this.a.l(gk4.l(getContext()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ij4.fullscreen) {
            k();
        } else if (id == ij4.iv_play) {
            this.a.n();
        } else if (id == ij4.iv_refresh) {
            this.a.d(true);
        }
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public LiveControlView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(this);
        this.c = (LinearLayout) findViewById(ij4.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.d = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(ij4.iv_refresh)).setOnClickListener(this);
    }

    public LiveControlView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(this);
        this.c = (LinearLayout) findViewById(ij4.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.d = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(ij4.iv_refresh)).setOnClickListener(this);
    }
}
