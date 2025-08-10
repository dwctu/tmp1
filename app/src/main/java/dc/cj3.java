package dc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.widget.BaseFloatIngView;
import com.wear.widget.FloatingNewControlView;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MinRootControl.java */
/* loaded from: classes4.dex */
public class cj3 {
    public static cj3 g;
    public final ConcurrentHashMap<Integer, c> a = new ConcurrentHashMap<>();
    public boolean b = true;
    public LottieAnimationView c;
    public BaseFloatIngView d;
    public View e;
    public int f;

    /* compiled from: MinRootControl.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (cj3.this.a.get(Integer.valueOf(cj3.this.f)) != null) {
                ((c) cj3.this.a.get(Integer.valueOf(cj3.this.f))).a();
            }
        }
    }

    /* compiled from: MinRootControl.java */
    public class b implements fv1 {
        public b() {
        }

        @Override // dc.fv1
        public void a() {
            cj3.this.e.setBackgroundResource(R.drawable.minimize_drag);
        }

        @Override // dc.fv1
        public void b(boolean z) {
            if (z) {
                cj3.this.e.setBackgroundResource(R.drawable.minimize_left_bg);
            } else {
                cj3.this.e.setBackgroundResource(R.drawable.minimize_right_bg);
            }
        }
    }

    /* compiled from: MinRootControl.java */
    public interface c {
        void a();
    }

    public static cj3 f() {
        if (g == null) {
            synchronized (cj3.class) {
                if (g == null) {
                    g = new cj3();
                }
            }
        }
        return g;
    }

    public void b(Activity activity, boolean z, int i) {
        if (!z) {
            d(i);
            return;
        }
        l(i);
        this.d.setWidthAndHeight(activity, ce3.a(activity, 60.0f), ce3.a(activity, 60.0f));
        this.d.setPointX(BaseFloatIngView.e, BaseFloatIngView.f, BaseFloatIngView.g);
    }

    public void c(boolean z) {
        if (z) {
            this.c.q();
        } else {
            this.c.r();
        }
    }

    public void d(int i) {
        if (this.f == i) {
            this.b = true;
            this.d.setVisibility(8);
        }
    }

    public boolean e() {
        LottieAnimationView lottieAnimationView = this.c;
        if (lottieAnimationView != null) {
            return lottieAnimationView.o();
        }
        return false;
    }

    public BaseFloatIngView g() {
        return this.d;
    }

    public BaseFloatIngView.b h() {
        return this.d.getData();
    }

    public void i(MyApplication myApplication) {
        this.d = new FloatingNewControlView(myApplication);
        View viewInflate = LayoutInflater.from(myApplication).inflate(R.layout.view_float_drag_view, (ViewGroup) null);
        this.e = viewInflate;
        this.c = (LottieAnimationView) viewInflate.findViewById(R.id.iv_small);
        this.d.setOnClickListener(new a());
        this.d.setListener(new b());
        this.d.addView(this.e);
    }

    public boolean j(int i) {
        if (this.f == i) {
            return this.b;
        }
        return true;
    }

    public void k(int i, c cVar) {
        this.a.put(Integer.valueOf(i), cVar);
    }

    public void l(int i) {
        this.b = false;
        this.d.setVisibility(0);
        if (this.f != i) {
            if (i == 0) {
                this.c.setAnimation("music.json");
            } else if (i == 1) {
                this.c.setAnimation("pattern_anim.json");
            } else if (i == 2) {
                this.c.setAnimation("speed_mode_anim.json");
            } else if (i == 3) {
                this.c.setAnimation("sound_data.json");
            } else if (i == 4) {
                this.c.setAnimation("remote_data.json");
            }
        }
        this.f = i;
    }
}
