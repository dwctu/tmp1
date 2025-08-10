package com.wear.util.camera;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import dc.ce3;
import dc.th4;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class TakeView extends RelativeLayout {
    public static boolean p;
    public ImageView a;
    public CircularProgressBar b;
    public TextView c;
    public Context d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public i i;
    public Timer j;
    public Handler k;
    public Runnable l;
    public boolean m;
    public long n;
    public h o;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TakeView.this.h) {
                return;
            }
            TakeView.f(TakeView.this, 0.05f);
            String str = "run curRecordSeconds: " + TakeView.this.g;
            TakeView.this.b.setProgress((int) ((TakeView.this.g / TakeView.this.e) * 100.0f));
            if (TakeView.p || TakeView.this.g >= TakeView.this.e) {
                TakeView.this.h = true;
                TakeView.this.j.cancel();
                TakeView.this.v();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b(TakeView takeView) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                TakeView.this.m = false;
                TakeView.p = false;
                TakeView.this.k.postDelayed(TakeView.this.i, 200L);
            } else if (action == 1 || action == 3) {
                TakeView.this.q();
            }
            return true;
        }
    }

    public class d implements Runnable {
        public d(TakeView takeView) {
        }

        @Override // java.lang.Runnable
        public void run() {
            TakeView.p = true;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TakeView.this.a.getLayoutParams().width = iIntValue;
            TakeView.this.a.getLayoutParams().height = iIntValue;
            TakeView.this.a.requestLayout();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TakeView.this.s();
        }
    }

    public class g extends TimerTask {
        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (TakeView.this.h) {
                return;
            }
            TakeView.this.k.post(TakeView.this.l);
        }
    }

    public interface h {
        void a();

        void b();

        void c();

        void d();
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TakeView.this.u();
            TakeView.this.m = true;
        }

        public /* synthetic */ i(TakeView takeView, a aVar) {
            this();
        }
    }

    public TakeView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ float f(TakeView takeView, float f2) {
        float f3 = takeView.g + f2;
        takeView.g = f3;
        return f3;
    }

    public final void p() {
        if (System.currentTimeMillis() - this.n < 1000) {
            return;
        }
        this.n = System.currentTimeMillis();
        h hVar = this.o;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void q() {
        this.k.removeCallbacks(this.i);
        if (this.m) {
            this.m = false;
            this.k.postDelayed(new d(this), 200L);
        } else {
            this.m = false;
            if (this.o != null) {
                p();
            }
        }
    }

    public final void r() {
        this.a.setImageDrawable(th4.d(this.d, R.drawable.chat_camera_photo_hold_btn));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(ce3.a(this.d, 75.0f), ce3.a(this.d, 98.0f));
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.addUpdateListener(new e());
        valueAnimatorOfInt.start();
        this.k.postDelayed(new f(), 200L);
    }

    public final void s() {
        setTakeState(1, false);
        h hVar = this.o;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void setProgress() {
        this.h = false;
        this.g = 0.0f;
        Timer timer = this.j;
        if (timer == null) {
            this.j = new Timer();
        } else {
            timer.cancel();
        }
        this.j.schedule(new g(), 0L, 50L);
    }

    public void setTakeListener(h hVar) {
        this.o = hVar;
    }

    public void setTakeState(int i2, boolean z) {
        StringBuilder sb;
        String str;
        String str2 = "setTakeState takeType: " + i2 + ",isHasTake:" + z;
        if (i2 == 0) {
            if (z) {
                this.a.setVisibility(4);
            } else {
                this.a.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                layoutParams.width = ce3.a(this.d, 75.0f);
                layoutParams.height = ce3.a(this.d, 75.0f);
                this.a.setLayoutParams(layoutParams);
                this.a.setImageDrawable(th4.d(this.d, R.drawable.chat_camera_photo_take_btn));
            }
            this.b.setVisibility(0);
            this.c.setVisibility(4);
            this.b.setProgress(0.0f);
            return;
        }
        if (z) {
            this.a.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams2.width = ce3.a(this.d, 75.0f);
            layoutParams2.height = ce3.a(this.d, 75.0f);
            this.a.setLayoutParams(layoutParams2);
            this.a.setImageDrawable(th4.d(this.d, R.drawable.chat_camera_photo_take_btn));
            this.b.setVisibility(0);
            this.c.setVisibility(4);
            int iCeil = (int) Math.ceil(this.g);
            if (iCeil > 30) {
                iCeil = 30;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("00:");
            if (iCeil < 10) {
                sb = new StringBuilder();
                str = "0";
            } else {
                sb = new StringBuilder();
                str = "";
            }
            sb.append(str);
            sb.append(iCeil);
            sb2.append(sb.toString());
            this.c.setText(sb2.toString());
        } else {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setVisibility(4);
        }
        this.b.setProgress(0.0f);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void t(Context context) {
        this.d = context;
        LayoutInflater.from(context).inflate(R.layout.takeview, this);
        this.a = (ImageView) findViewById(R.id.takeview_iv_take);
        this.b = (CircularProgressBar) findViewById(R.id.takeview_hold_cpv);
        this.c = (TextView) findViewById(R.id.takeview_tv_record_time);
        this.a.setOnClickListener(new b(this));
        this.i = new i(this, null);
        this.a.setOnTouchListener(new c());
    }

    public final void u() {
        r();
    }

    public void v() {
        if (this.g < this.f) {
            setTakeState(0, false);
            h hVar = this.o;
            if (hVar != null) {
                hVar.b();
                return;
            }
            return;
        }
        setTakeState(1, true);
        h hVar2 = this.o;
        if (hVar2 != null) {
            hVar2.c();
        }
    }

    public void w(boolean z) {
        if (z) {
            setTakeState(0, false);
        } else {
            setTakeState(1, true);
        }
    }

    public TakeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TakeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = 30.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.k = new Handler();
        this.l = new a();
        t(context);
    }

    public void setProgress(float f2) {
        this.b.setProgress((f2 / this.e) * 100.0f);
        this.g = f2;
    }
}
