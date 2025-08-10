package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.gk4;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.nj4;

/* loaded from: classes5.dex */
public class VodControlView extends FrameLayout implements nj4, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public mj4 a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final LinearLayout e;
    public final SeekBar f;
    public final ProgressBar g;
    public final ImageView h;
    public boolean i;
    public boolean j;

    public VodControlView(@NonNull Context context) {
        super(context);
        this.j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(ij4.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(ij4.seekBar);
        this.f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(ij4.total_time);
        this.c = (TextView) findViewById(ij4.curr_time);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.h = imageView2;
        imageView2.setOnClickListener(this);
        this.g = (ProgressBar) findViewById(ij4.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            seekBar.getLayoutParams().height = -2;
        }
    }

    @Override // dc.nj4
    public void a(int i) {
        switch (i) {
            case -1:
            case 1:
            case 2:
            case 8:
                setVisibility(8);
                break;
            case 0:
            case 5:
                setVisibility(8);
                this.g.setProgress(0);
                this.g.setSecondaryProgress(0);
                this.f.setProgress(0);
                this.f.setSecondaryProgress(0);
                break;
            case 3:
                this.h.setSelected(true);
                if (!this.j) {
                    this.e.setVisibility(8);
                } else if (this.a.isShowing()) {
                    this.g.setVisibility(8);
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.g.setVisibility(0);
                }
                setVisibility(0);
                this.a.i();
                break;
            case 4:
                this.h.setSelected(false);
                break;
            case 6:
                this.h.setSelected(this.a.isPlaying());
                this.a.k();
                break;
            case 7:
                this.h.setSelected(this.a.isPlaying());
                this.a.i();
                break;
        }
    }

    @Override // dc.nj4
    public void b(int i) {
        if (i == 10) {
            this.d.setSelected(false);
        } else if (i == 11) {
            this.d.setSelected(true);
        }
        Activity activityL = gk4.l(getContext());
        if (activityL == null || !this.a.b()) {
            return;
        }
        int requestedOrientation = activityL.getRequestedOrientation();
        int cutoutHeight = this.a.getCutoutHeight();
        if (requestedOrientation == 1) {
            this.e.setPadding(0, 0, 0, 0);
            this.g.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.e.setPadding(cutoutHeight, 0, 0, 0);
            this.g.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.e.setPadding(0, 0, cutoutHeight, 0);
            this.g.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
        if (z) {
            this.e.setVisibility(0);
            if (animation != null) {
                this.e.startAnimation(animation);
            }
            if (this.j) {
                this.g.setVisibility(8);
                return;
            }
            return;
        }
        this.e.setVisibility(8);
        if (animation != null) {
            this.e.startAnimation(animation);
        }
        if (this.j) {
            this.g.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.g.startAnimation(alphaAnimation);
        }
    }

    @Override // dc.nj4
    public void e(@NonNull mj4 mj4Var) {
        this.a = mj4Var;
    }

    public int getLayoutId() {
        return jj4.dkplayer_layout_vod_control_view;
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
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (this.a.getDuration() * i) / this.f.getMax();
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(gk4.m((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.i = true;
        this.a.k();
        this.a.h();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.seekTo((int) ((this.a.getDuration() * seekBar.getProgress()) / this.f.getMax()));
        this.i = false;
        this.a.i();
        this.a.e();
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
        if (this.i) {
            return;
        }
        SeekBar seekBar = this.f;
        if (seekBar != null) {
            if (i > 0) {
                seekBar.setEnabled(true);
                int max = (int) (((i2 * 1.0d) / i) * this.f.getMax());
                this.f.setProgress(max);
                this.g.setProgress(max);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferedPercentage = this.a.getBufferedPercentage();
            if (bufferedPercentage >= 95) {
                SeekBar seekBar2 = this.f;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.g;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i3 = bufferedPercentage * 10;
                this.f.setSecondaryProgress(i3);
                this.g.setSecondaryProgress(i3);
            }
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(gk4.m(i));
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(gk4.m(i2));
        }
    }

    public VodControlView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(ij4.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(ij4.seekBar);
        this.f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(ij4.total_time);
        this.c = (TextView) findViewById(ij4.curr_time);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.h = imageView2;
        imageView2.setOnClickListener(this);
        this.g = (ProgressBar) findViewById(ij4.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            seekBar.getLayoutParams().height = -2;
        }
    }

    public VodControlView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(ij4.fullscreen);
        this.d = imageView;
        imageView.setOnClickListener(this);
        this.e = (LinearLayout) findViewById(ij4.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(ij4.seekBar);
        this.f = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.b = (TextView) findViewById(ij4.total_time);
        this.c = (TextView) findViewById(ij4.curr_time);
        ImageView imageView2 = (ImageView) findViewById(ij4.iv_play);
        this.h = imageView2;
        imageView2.setOnClickListener(this);
        this.g = (ProgressBar) findViewById(ij4.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            seekBar.getLayoutParams().height = -2;
        }
    }
}
