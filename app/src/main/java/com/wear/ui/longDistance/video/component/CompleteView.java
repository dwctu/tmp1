package com.wear.ui.longDistance.video.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.gk4;
import dc.ha3;
import dc.mj4;
import dc.nj4;

/* loaded from: classes4.dex */
public class CompleteView extends FrameLayout implements nj4, SeekBar.OnSeekBarChangeListener {
    public mj4 a;
    public SeekBar b;
    public TextView c;
    public TextView d;
    public final View e;
    public final View f;
    public final View g;
    public ha3 h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteView.this.a.d(true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteView.this.a.d(true);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CompleteView.this.h != null) {
                CompleteView.this.h.a();
            }
        }
    }

    public CompleteView(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new a());
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.e = viewFindViewById;
        this.g = findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.b = seekBar;
        seekBar.setThumbOffset(0);
        this.b.setOnSeekBarChangeListener(this);
        this.c = (TextView) findViewById(R.id.total_time);
        this.d = (TextView) findViewById(R.id.curr_time);
        View viewFindViewById2 = findViewById(R.id.iv_play);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        viewFindViewById.setOnClickListener(new c());
        setClickable(true);
    }

    @Override // dc.nj4
    public void a(int i) {
        if (i != 5) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.b.setProgress(0);
        this.b.setSecondaryProgress(0);
        bringToFront();
    }

    @Override // dc.nj4
    public void b(int i) {
        Activity activityL = gk4.l(getContext());
        if (activityL == null || !this.a.b()) {
            return;
        }
        activityL.getRequestedOrientation();
        this.a.getCutoutHeight();
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

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (this.a.getDuration() * i) / this.b.getMax();
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(gk4.m((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.a.k();
        this.a.h();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.seekTo((int) ((this.a.getDuration() * seekBar.getProgress()) / this.b.getMax()));
        this.a.i();
        this.a.e();
    }

    public void setCloseViewVisibility() {
        View view = this.e;
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
        View view2 = this.g;
        view2.setVisibility(view2.getVisibility() != 0 ? 0 : 8);
    }

    public void setOnCloseListener(ha3 ha3Var) {
        this.h = ha3Var;
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
        int duration;
        SeekBar seekBar = this.b;
        if (seekBar != null) {
            seekBar.setProgress(0);
            this.b.setEnabled(false);
        }
        if (this.c != null && (duration = (int) this.a.getDuration()) != 0) {
            if (duration < 1000) {
                duration = 1000;
            }
            this.c.setText(gk4.m(duration));
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(gk4.m(0));
        }
    }

    public CompleteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new a());
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.e = viewFindViewById;
        this.g = findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.b = seekBar;
        seekBar.setThumbOffset(0);
        this.b.setOnSeekBarChangeListener(this);
        this.c = (TextView) findViewById(R.id.total_time);
        this.d = (TextView) findViewById(R.id.curr_time);
        View viewFindViewById2 = findViewById(R.id.iv_play);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        viewFindViewById.setOnClickListener(new c());
        setClickable(true);
    }

    public CompleteView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new a());
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.e = viewFindViewById;
        this.g = findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.b = seekBar;
        seekBar.setThumbOffset(0);
        this.b.setOnSeekBarChangeListener(this);
        this.c = (TextView) findViewById(R.id.total_time);
        this.d = (TextView) findViewById(R.id.curr_time);
        View viewFindViewById2 = findViewById(R.id.iv_play);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        viewFindViewById.setOnClickListener(new c());
        setClickable(true);
    }
}
