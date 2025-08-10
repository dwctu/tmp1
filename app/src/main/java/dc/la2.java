package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovense.wear.R;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.widget.FloatingNewControlView;
import com.wear.widget.SkinLottieAnimationView;
import dc.jv1;

/* compiled from: BaseSyncLiveControl.java */
/* loaded from: classes3.dex */
public abstract class la2<T extends IPeopleInfo, E extends jv1> extends ka2<T, E> {
    public int n = -2;
    public int o = -2;

    /* compiled from: BaseSyncLiveControl.java */
    public class a implements fv1 {
        public final /* synthetic */ View a;

        public a(la2 la2Var, View view) {
            this.a = view;
        }

        @Override // dc.fv1
        public void a() {
            this.a.setBackgroundResource(R.drawable.minimize_drag);
        }

        @Override // dc.fv1
        public void b(boolean z) {
            if (z) {
                this.a.setBackgroundResource(R.drawable.minimize_left_bg);
            } else {
                this.a.setBackgroundResource(R.drawable.minimize_right_bg);
            }
        }
    }

    @Override // dc.ka2
    public void F() {
        this.e = true;
        this.a.setVisibility(8);
    }

    @Override // dc.ka2
    public void R() {
        H();
    }

    @Override // dc.ka2
    public void W() {
        this.e = false;
        this.a.setVisibility(0);
    }

    public void c0() {
        if (r()) {
            this.a.setVisibility(8);
        }
    }

    public void d0(Context context, int i, String str) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_control, (ViewGroup) null);
        this.n = ce3.a(this.g, 60.0f);
        this.o = ce3.a(this.g, 60.0f);
        if (this.a == null) {
            this.a = new FloatingNewControlView(this.g);
        }
        K(this.a, viewInflate);
        SkinLottieAnimationView skinLottieAnimationView = (SkinLottieAnimationView) viewInflate.findViewById(R.id.iv_small);
        if (str.equals("ds_dark.json")) {
            skinLottieAnimationView.setDs(true);
            skinLottieAnimationView.P1();
        } else {
            skinLottieAnimationView.setDs(false);
            skinLottieAnimationView.setAnimation(str);
        }
        this.h = i;
        this.a.setListener(new a(this, viewInflate));
    }

    public void e0() {
        FloatingNewControlView floatingNewControlView = this.a;
        if (floatingNewControlView != null) {
            floatingNewControlView.b();
        }
    }

    @Override // dc.ra2
    public int getMinHeight() {
        return this.o;
    }

    @Override // dc.ra2
    public int getMinWidth() {
        return this.n;
    }

    @Override // dc.ka2, dc.pd3.b
    public void p() {
        if (!r() || this.e) {
            return;
        }
        if (!c83.R1().r()) {
            W();
        } else if (c83.R1().d0()) {
            W();
        } else {
            this.a.setVisibility(8);
        }
    }

    @Override // dc.ka2, dc.pd3.b
    public void q() {
        if (!r() || this.e) {
            return;
        }
        this.a.setVisibility(8);
    }
}
