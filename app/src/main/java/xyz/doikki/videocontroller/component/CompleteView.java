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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.gk4;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.nj4;

/* loaded from: classes5.dex */
public class CompleteView extends FrameLayout implements nj4 {
    public mj4 a;
    public final ImageView b;

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
            Activity activityL;
            if (!CompleteView.this.a.c() || (activityL = gk4.l(CompleteView.this.getContext())) == null || activityL.isFinishing()) {
                return;
            }
            activityL.setRequestedOrientation(1);
            CompleteView.this.a.f();
        }
    }

    public CompleteView(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(ij4.iv_replay).setOnClickListener(new a());
        ImageView imageView = (ImageView) findViewById(ij4.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new b());
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

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public CompleteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(ij4.iv_replay).setOnClickListener(new a());
        ImageView imageView = (ImageView) findViewById(ij4.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new b());
        setClickable(true);
    }

    public CompleteView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(ij4.iv_replay).setOnClickListener(new a());
        ImageView imageView = (ImageView) findViewById(ij4.stop_fullscreen);
        this.b = imageView;
        imageView.setOnClickListener(new b());
        setClickable(true);
    }
}
