package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public interface GoogleSignInApi {

    @RecentlyNonNull
    public static final String EXTRA_SIGN_IN_ACCOUNT = "signInAccount";

    @RecentlyNonNull
    Intent getSignInIntent(@RecentlyNonNull GoogleApiClient googleApiClient);

    @RecentlyNullable
    GoogleSignInResult getSignInResultFromIntent(@RecentlyNonNull Intent intent);

    @RecentlyNonNull
    PendingResult<Status> revokeAccess(@RecentlyNonNull GoogleApiClient googleApiClient);

    @RecentlyNonNull
    PendingResult<Status> signOut(@RecentlyNonNull GoogleApiClient googleApiClient);

    @RecentlyNonNull
    OptionalPendingResult<GoogleSignInResult> silentSignIn(@RecentlyNonNull GoogleApiClient googleApiClient);
}
