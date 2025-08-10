package dc;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import dc.tq2;

/* compiled from: GoogleLogin.java */
/* loaded from: classes3.dex */
public class oq2 implements rq2 {
    public GoogleSignInClient a;
    public pq2 b;

    /* compiled from: GoogleLogin.java */
    public class a implements OnCompleteListener<Void> {
        public final /* synthetic */ qq2 a;

        public a(oq2 oq2Var, qq2 qq2Var) {
            this.a = qq2Var;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            qq2 qq2Var = this.a;
            if (qq2Var != null) {
                qq2Var.a();
            }
        }
    }

    @Override // dc.rq2
    public void a(Activity activity, pq2 pq2Var) {
        this.b = pq2Var;
        GoogleSignInClient client = GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("132294203598-gaichf7o6cvo69vfbcrlelvn3n7nhuf2.apps.googleusercontent.com").requestEmail().build());
        this.a = client;
        activity.startActivityForResult(client.getSignInIntent(), 1);
    }

    @Override // dc.rq2
    public void b(int i, int i2, Intent intent) throws Throwable {
        if (i == 1) {
            e(GoogleSignIn.getSignedInAccountFromIntent(intent));
        }
    }

    @Override // dc.rq2
    public void c(Activity activity, qq2 qq2Var) {
        if (this.a == null) {
            this.a = GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("132294203598-gaichf7o6cvo69vfbcrlelvn3n7nhuf2.apps.googleusercontent.com").requestServerAuthCode("132294203598-gaichf7o6cvo69vfbcrlelvn3n7nhuf2.apps.googleusercontent.com").requestEmail().build());
        }
        this.a.signOut().addOnCompleteListener(new a(this, qq2Var));
    }

    public final void d(String str) {
        pq2 pq2Var = this.b;
        if (pq2Var != null) {
            pq2Var.a(str);
            this.b = null;
        }
    }

    public final void e(Task<GoogleSignInAccount> task) throws Throwable {
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            f(result);
            de0.v("GoogleLogin", "signInResult:success code = 0, accout.token = " + result.getIdToken() + "  id = " + result.getId());
        } catch (ApiException e) {
            de0.l("GoogleLogin", "signInResult:failed code=" + e.getStatusCode() + "   " + e.getMessage());
            if (e.getStatusCode() != 12501) {
                d("Sign in Failed!");
                return;
            }
            pq2 pq2Var = this.b;
            if (pq2Var != null) {
                pq2Var.onCancel();
                this.b = null;
            }
        }
    }

    public final void f(GoogleSignInAccount googleSignInAccount) {
        sq2 sq2Var = new sq2();
        sq2Var.f(googleSignInAccount.getIdToken());
        sq2Var.d(googleSignInAccount.getId());
        sq2Var.c(googleSignInAccount.getEmail());
        sq2Var.h(googleSignInAccount.getPhotoUrl());
        sq2Var.e(tq2.a.Google);
        sq2Var.g("Google");
        pq2 pq2Var = this.b;
        if (pq2Var != null) {
            pq2Var.b(sq2Var);
        }
        String str = "successCallback: " + googleSignInAccount.getIdToken() + "  id = " + googleSignInAccount.getId();
        this.b = null;
    }

    @Override // dc.rq2
    public void release() {
        this.a = null;
        this.b = null;
    }
}
