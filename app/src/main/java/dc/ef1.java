package dc;

import android.app.Activity;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import dc.af1;

/* compiled from: SpotifyAuthHandler.java */
/* loaded from: classes3.dex */
public class ef1 implements af1 {
    public ff1 a;

    @Override // dc.af1
    public boolean a(Activity activity, AuthorizationRequest authorizationRequest) {
        ff1 ff1Var = new ff1(activity, authorizationRequest);
        this.a = ff1Var;
        return ff1Var.d();
    }

    @Override // dc.af1
    public void b(af1.a aVar) {
    }

    @Override // dc.af1
    public void stop() {
        ff1 ff1Var = this.a;
        if (ff1Var != null) {
            ff1Var.e();
        }
    }
}
