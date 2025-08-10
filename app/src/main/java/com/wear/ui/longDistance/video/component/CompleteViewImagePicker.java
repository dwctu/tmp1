package com.wear.ui.longDistance.video.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.gk4;
import dc.ha3;
import dc.mj4;
import dc.nj4;

/* loaded from: classes4.dex */
public class CompleteViewImagePicker extends FrameLayout implements nj4 {
    public mj4 a;
    public ImageView b;
    public final View c;
    public ha3 d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CompleteViewImagePicker.this.a.d(true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CompleteViewImagePicker.this.d != null) {
                CompleteViewImagePicker.this.d.a();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityL;
            if (!CompleteViewImagePicker.this.a.c() || (activityL = gk4.l(CompleteViewImagePicker.this.getContext())) == null || activityL.isFinishing()) {
                return;
            }
            activityL.setRequestedOrientation(1);
            CompleteViewImagePicker.this.a.f();
        }
    }

    public CompleteViewImagePicker(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view_image_picker, (ViewGroup) this, true);
        findViewById(R.id.iv_play).setOnClickListener(new a());
        this.b = (ImageView) findViewById(R.id.stop_fullscreen);
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.c = viewFindViewById;
        viewFindViewById.setVisibility(8);
        viewFindViewById.setOnClickListener(new b());
        this.b.setOnClickListener(new c());
        setClickable(true);
    }

    @Override // dc.nj4
    public void a(int i) {
        if (i != 5) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.b.setVisibility(this.a.c() ? 0 : 8);
        bringToFront();
    }

    @Override // dc.nj4
    public void b(int i) {
        if (i == 11) {
            this.b.setVisibility(0);
        } else if (i == 10) {
            this.b.setVisibility(8);
        }
        Activity activityL = gk4.l(getContext());
        if (activityL == null || !this.a.b()) {
            return;
        }
        int requestedOrientation = activityL.getRequestedOrientation();
        int cutoutHeight = this.a.getCutoutHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        if (requestedOrientation == 1) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            layoutParams.setMargins(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            layoutParams.setMargins(0, 0, 0, 0);
        }
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

    public void setCloseViewVisibility() {
        View view = this.c;
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }

    public void setOnCloseListener(ha3 ha3Var) {
        this.d = ha3Var;
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public CompleteViewImagePicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view_image_picker, (ViewGroup) this, true);
        findViewById(R.id.iv_play).setOnClickListener(new a());
        this.b = (ImageView) findViewById(R.id.stop_fullscreen);
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.c = viewFindViewById;
        viewFindViewById.setVisibility(8);
        viewFindViewById.setOnClickListener(new b());
        this.b.setOnClickListener(new c());
        setClickable(true);
    }

    public CompleteViewImagePicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_complete_view_image_picker, (ViewGroup) this, true);
        findViewById(R.id.iv_play).setOnClickListener(new a());
        this.b = (ImageView) findViewById(R.id.stop_fullscreen);
        View viewFindViewById = findViewById(R.id.ac_video_close);
        this.c = viewFindViewById;
        viewFindViewById.setVisibility(8);
        viewFindViewById.setOnClickListener(new b());
        this.b.setOnClickListener(new c());
        setClickable(true);
    }
}
