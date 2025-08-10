package dc;

import android.app.Activity;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import dc.af1;

/* compiled from: WebViewAuthHandler.java */
/* loaded from: classes3.dex */
public class hf1 implements af1 {
    public gf1 a;
    public af1.a b;

    @Override // dc.af1
    public boolean a(Activity activity, AuthorizationRequest authorizationRequest) {
        gf1 gf1Var = new gf1(activity, authorizationRequest);
        this.a = gf1Var;
        gf1Var.l(this.b);
        this.a.show();
        return true;
    }

    @Override // dc.af1
    public void b(af1.a aVar) {
        this.b = aVar;
        gf1 gf1Var = this.a;
        if (gf1Var != null) {
            gf1Var.l(aVar);
        }
    }

    @Override // dc.af1
    public void stop() {
        gf1 gf1Var = this.a;
        if (gf1Var != null) {
            gf1Var.f();
            this.a = null;
        }
    }
}
