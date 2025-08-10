package com.spotify.sdk.android.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.EnvironmentCompat;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import dc.cf1;
import dc.ze1;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class LoginActivity extends Activity implements ze1.b {
    public static final String b = LoginActivity.class.getName();
    public ze1 a = new ze1(this);

    public static Intent c(Activity activity, AuthorizationRequest authorizationRequest) {
        if (activity == null || authorizationRequest == null) {
            throw new IllegalArgumentException("Context activity or request can't be null");
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(DeliveryReceiptRequest.ELEMENT, authorizationRequest);
        Intent intent = new Intent(activity, (Class<?>) LoginActivity.class);
        intent.putExtra("EXTRA_AUTH_REQUEST", bundle);
        return intent;
    }

    public static AuthorizationResponse e(Intent intent) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("EXTRA_AUTH_RESPONSE")) == null) {
            return null;
        }
        return (AuthorizationResponse) bundleExtra.getParcelable(SaslStreamElements.Response.ELEMENT);
    }

    @Override // dc.ze1.b
    public void a() {
        setResult(0);
    }

    @Override // dc.ze1.b
    public void b(AuthorizationResponse authorizationResponse) {
        Intent intent = new Intent();
        String.format("Spotify auth completing. The response is in EXTRA with key '%s'", SaslStreamElements.Response.ELEMENT);
        Bundle bundle = new Bundle();
        bundle.putParcelable(SaslStreamElements.Response.ELEMENT, authorizationResponse);
        intent.putExtra("EXTRA_AUTH_RESPONSE", bundle);
        setResult(-1, intent);
        finish();
    }

    public final AuthorizationRequest d() {
        Bundle bundleExtra = getIntent().getBundleExtra("EXTRA_AUTH_REQUEST");
        if (bundleExtra == null) {
            return null;
        }
        return (AuthorizationRequest) bundleExtra.getParcelable(DeliveryReceiptRequest.ELEMENT);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1138) {
            AuthorizationResponse.b bVar = new AuthorizationResponse.b();
            if (i2 == -2) {
                bVar.g(AuthorizationResponse.c.ERROR);
                String stringExtra = intent == null ? "Invalid message format" : intent.getStringExtra("ERROR");
                if (stringExtra == null) {
                    stringExtra = "Unknown error";
                }
                bVar.d(stringExtra);
            } else if (i2 == -1) {
                Bundle bundle = (Bundle) intent.getParcelableExtra("REPLY");
                if (bundle == null) {
                    bVar.g(AuthorizationResponse.c.ERROR);
                    bVar.d("Missing response data");
                } else {
                    String string = bundle.getString("RESPONSE_TYPE", EnvironmentCompat.MEDIA_UNKNOWN);
                    String str = "Response: " + string;
                    bVar.f(bundle.getString("STATE", null));
                    string.hashCode();
                    if (string.equals(XHTMLText.CODE)) {
                        String string2 = bundle.getString("AUTHORIZATION_CODE");
                        bVar.g(AuthorizationResponse.c.CODE);
                        bVar.c(string2);
                    } else if (string.equals("token")) {
                        String string3 = bundle.getString("ACCESS_TOKEN");
                        int i3 = bundle.getInt("EXPIRES_IN");
                        bVar.g(AuthorizationResponse.c.TOKEN);
                        bVar.b(string3);
                        bVar.e(i3);
                    } else {
                        bVar.g(AuthorizationResponse.c.UNKNOWN);
                    }
                }
            } else {
                bVar.g(AuthorizationResponse.c.EMPTY);
            }
            this.a.j(this);
            this.a.e(bVar.a());
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(cf1.com_spotify_sdk_login_activity);
        AuthorizationRequest authorizationRequestD = d();
        this.a.j(this);
        if (getCallingActivity() == null) {
            finish();
            return;
        }
        if (authorizationRequestD == null) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            String.format("Spotify Auth starting with the request [%s]", authorizationRequestD.h().toString());
            this.a.b(authorizationRequestD);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.a.c();
        this.a.j(null);
        super.onDestroy();
    }
}
