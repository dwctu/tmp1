package dc;

import android.app.Activity;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

/* compiled from: AuthorizationHandler.java */
/* loaded from: classes3.dex */
public interface af1 {

    /* compiled from: AuthorizationHandler.java */
    public interface a {
        void a(AuthorizationResponse authorizationResponse);

        void onCancel();

        void onError(Throwable th);
    }

    boolean a(Activity activity, AuthorizationRequest authorizationRequest);

    void b(a aVar);

    void stop();
}
