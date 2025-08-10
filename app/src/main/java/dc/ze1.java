package dc;

import android.app.Activity;
import android.content.Intent;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.spotify.sdk.android.auth.LoginActivity;
import dc.af1;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* loaded from: classes3.dex */
public class ze1 {
    public final Activity a;
    public boolean b;
    public af1 c;
    public List<af1> d;
    public b e;

    /* compiled from: AuthorizationClient.java */
    public class a implements af1.a {
        public final /* synthetic */ af1 a;

        public a(af1 af1Var) {
            this.a = af1Var;
        }

        @Override // dc.af1.a
        public void a(AuthorizationResponse authorizationResponse) {
            String.format("Spotify auth response:%s", authorizationResponse.e().name());
            ze1.this.i(this.a, authorizationResponse);
        }

        @Override // dc.af1.a
        public void onCancel() {
            AuthorizationResponse.b bVar = new AuthorizationResponse.b();
            bVar.g(AuthorizationResponse.c.EMPTY);
            ze1.this.i(this.a, bVar.a());
        }

        @Override // dc.af1.a
        public void onError(Throwable th) {
            AuthorizationResponse.b bVar = new AuthorizationResponse.b();
            bVar.g(AuthorizationResponse.c.ERROR);
            bVar.d(th.getMessage());
            ze1.this.i(this.a, bVar.a());
        }
    }

    /* compiled from: AuthorizationClient.java */
    public interface b {
        void a();

        void b(AuthorizationResponse authorizationResponse);
    }

    public ze1(Activity activity) {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.a = activity;
        arrayList.add(new ef1());
        this.d.add(new hf1());
    }

    public static Intent f(Activity activity, AuthorizationRequest authorizationRequest) {
        Intent intentC = LoginActivity.c(activity, authorizationRequest);
        intentC.addFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
        return intentC;
    }

    public static AuthorizationResponse g(int i, Intent intent) {
        if (i == -1 && LoginActivity.e(intent) != null) {
            return LoginActivity.e(intent);
        }
        AuthorizationResponse.b bVar = new AuthorizationResponse.b();
        bVar.g(AuthorizationResponse.c.EMPTY);
        return bVar.a();
    }

    public static void h(Activity activity, int i, AuthorizationRequest authorizationRequest) {
        activity.startActivityForResult(f(activity, authorizationRequest), i);
    }

    public void b(AuthorizationRequest authorizationRequest) {
        if (this.b) {
            return;
        }
        this.b = true;
        for (af1 af1Var : this.d) {
            if (k(af1Var, authorizationRequest)) {
                this.c = af1Var;
                return;
            }
        }
    }

    public void c() {
        if (this.b) {
            this.b = false;
            d(this.c);
            b bVar = this.e;
            if (bVar != null) {
                bVar.a();
                this.e = null;
            }
        }
    }

    public final void d(af1 af1Var) {
        if (af1Var != null) {
            af1Var.b(null);
            af1Var.stop();
        }
    }

    public void e(AuthorizationResponse authorizationResponse) {
        i(this.c, authorizationResponse);
    }

    public final void i(af1 af1Var, AuthorizationResponse authorizationResponse) {
        this.b = false;
        d(af1Var);
        b bVar = this.e;
        if (bVar != null) {
            bVar.b(authorizationResponse);
            this.e = null;
        }
    }

    public void j(b bVar) {
        this.e = bVar;
    }

    public final boolean k(af1 af1Var, AuthorizationRequest authorizationRequest) {
        af1Var.b(new a(af1Var));
        if (af1Var.a(this.a, authorizationRequest)) {
            return true;
        }
        d(af1Var);
        return false;
    }
}
