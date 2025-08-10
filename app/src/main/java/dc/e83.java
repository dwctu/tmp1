package dc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.UserControlLink;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.WearUtils;
import com.wear.widget.FloatingNewControlView;
import com.wear.widget.SkinLottieAnimationView;
import dc.jv1;

/* compiled from: IControlLinkChatControl.java */
/* loaded from: classes4.dex */
public abstract class e83<T extends IPeopleInfo, E extends jv1> extends ka2<T, E> implements tz1, cv1 {
    public int n = -2;
    public int o = -2;
    public boolean p = false;

    /* compiled from: IControlLinkChatControl.java */
    public class a implements fv1 {
        public final /* synthetic */ View a;

        public a(e83 e83Var, View view) {
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
    public void B() {
    }

    @Override // dc.cv1
    public void E3(long j) {
    }

    @Override // dc.ka2
    public void P() {
    }

    @Override // dc.ka2
    public void Q(Activity activity) {
        if (!(activity instanceof ControlLinkChatActivity)) {
            pj3.j(activity, ControlLinkChatActivity.class, "linkId", this.b.getControlLinkId());
            return;
        }
        ControlLinkChatActivity controlLinkChatActivity = (ControlLinkChatActivity) activity;
        if (controlLinkChatActivity.C() == this.c) {
            controlLinkChatActivity.V2();
        } else {
            pj3.j(activity, ControlLinkChatActivity.class, "linkId", this.b.getControlLinkId());
        }
    }

    @Override // dc.ka2
    public void R() {
        Account account = this.b;
        pj3.j(I(), ControlLinkChatActivity.class, "linkId", (account == null || WearUtils.e1(account.getControlLinkId())) ? "" : this.b.getControlLinkId());
    }

    @Override // dc.cv1
    public void V2() {
    }

    @Override // dc.cv1
    public void X() {
    }

    public void c0(Context context, int i, String str) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_control, (ViewGroup) null);
        this.n = ce3.a(this.g, 60.0f);
        this.o = ce3.a(this.g, 60.0f);
        K(new FloatingNewControlView(this.g), viewInflate);
        SkinLottieAnimationView skinLottieAnimationView = (SkinLottieAnimationView) viewInflate.findViewById(R.id.iv_small);
        skinLottieAnimationView.setDs(false);
        skinLottieAnimationView.setAnimation(str);
        this.h = i;
        this.a.setListener(new a(this, viewInflate));
    }

    public boolean d0() {
        return this.p;
    }

    public void e0(boolean z) {
        this.p = z;
    }

    @Override // dc.na2.b
    public void g() {
    }

    @Override // dc.ra2
    public int getMinHeight() {
        return this.o;
    }

    @Override // dc.ra2
    public int getMinWidth() {
        return this.n;
    }

    @Override // dc.cv1
    public void h2() {
    }

    @Override // dc.cv1
    public void j2(ControlLinkBean controlLinkBean, UserControlLink userControlLink, boolean z, String str, String str2, boolean z2, int i, boolean z3) {
    }

    @Override // dc.cv1
    public void j3() {
    }

    @Override // dc.na2.b
    public void k() {
    }

    @Override // dc.ka2, dc.pd3.b
    public void p() {
        if (!r() || this.e) {
            return;
        }
        if (this.p) {
            this.a.setVisibility(8);
        } else {
            W();
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.ka2, dc.pd3.b
    public void q() {
        if (!r() || this.e) {
            return;
        }
        this.a.setVisibility(8);
    }

    @Override // dc.cv1
    public void r2() {
    }

    @Override // dc.tz1
    public void recovery() {
    }
}
