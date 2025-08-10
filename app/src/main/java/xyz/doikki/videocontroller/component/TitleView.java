package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.gk4;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.nj4;

/* loaded from: classes5.dex */
public class TitleView extends FrameLayout implements nj4 {
    public mj4 a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final b e;
    public boolean f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityL = gk4.l(TitleView.this.getContext());
            if (activityL == null || !TitleView.this.a.c()) {
                return;
            }
            activityL.setRequestedOrientation(1);
            TitleView.this.a.f();
        }
    }

    public static class b extends BroadcastReceiver {
        public final ImageView a;

        public b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            this.a.getDrawable().setLevel((extras.getInt(FirebaseAnalytics.Param.LEVEL) * 100) / extras.getInt("scale"));
        }
    }

    public TitleView(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(ij4.title_container);
        ((ImageView) findViewById(ij4.back)).setOnClickListener(new a());
        this.c = (TextView) findViewById(ij4.title);
        this.d = (TextView) findViewById(ij4.sys_time);
        this.e = new b((ImageView) findViewById(ij4.iv_battery));
    }

    @Override // dc.nj4
    public void a(int i) {
        if (i == -1 || i == 0 || i == 1 || i == 2 || i == 5 || i == 8) {
            setVisibility(8);
        }
    }

    @Override // dc.nj4
    public void b(int i) {
        if (i == 11) {
            if (this.a.isShowing() && !this.a.g()) {
                setVisibility(0);
                this.d.setText(gk4.b());
            }
            this.c.setSelected(true);
        } else {
            setVisibility(8);
            this.c.setSelected(false);
        }
        Activity activityL = gk4.l(getContext());
        if (activityL == null || !this.a.b()) {
            return;
        }
        int requestedOrientation = activityL.getRequestedOrientation();
        int cutoutHeight = this.a.getCutoutHeight();
        if (requestedOrientation == 1) {
            this.b.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.b.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.b.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
        if (this.a.c()) {
            if (!z) {
                if (getVisibility() == 0) {
                    setVisibility(8);
                    if (animation != null) {
                        startAnimation(animation);
                        return;
                    }
                    return;
                }
                return;
            }
            if (getVisibility() == 8) {
                this.d.setText(gk4.b());
                setVisibility(0);
                if (animation != null) {
                    startAnimation(animation);
                }
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
        if (z) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.d.setText(gk4.b());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f) {
            return;
        }
        getContext().registerReceiver(this.e, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f) {
            getContext().unregisterReceiver(this.e);
            this.f = false;
        }
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public void setTitle(String str) {
        this.c.setText(str);
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(ij4.title_container);
        ((ImageView) findViewById(ij4.back)).setOnClickListener(new a());
        this.c = (TextView) findViewById(ij4.title);
        this.d = (TextView) findViewById(ij4.sys_time);
        this.e = new b((ImageView) findViewById(ij4.iv_battery));
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(ij4.title_container);
        ((ImageView) findViewById(ij4.back)).setOnClickListener(new a());
        this.c = (TextView) findViewById(ij4.title);
        this.d = (TextView) findViewById(ij4.sys_time);
        this.e = new b((ImageView) findViewById(ij4.iv_battery));
    }
}
