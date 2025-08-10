package xyz.doikki.videocontroller.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.nj4;

/* loaded from: classes5.dex */
public class ErrorView extends LinearLayout implements nj4 {
    public float a;
    public float b;
    public mj4 c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorView.this.setVisibility(8);
            ErrorView.this.c.d(false);
        }
    }

    public ErrorView(Context context) {
        this(context, null);
    }

    @Override // dc.nj4
    public void a(int i) {
        if (i == -1) {
            bringToFront();
            setVisibility(0);
        } else if (i == 0) {
            setVisibility(8);
        }
    }

    @Override // dc.nj4
    public void b(int i) {
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.a);
            float fAbs2 = Math.abs(motionEvent.getY() - this.b);
            if (fAbs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || fAbs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // dc.nj4
    public void e(@NonNull mj4 mj4Var) {
        this.c = mj4Var;
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

    public ErrorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(ij4.status_btn).setOnClickListener(new a());
        setClickable(true);
    }

    public ErrorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(ij4.status_btn).setOnClickListener(new a());
        setClickable(true);
    }
}
