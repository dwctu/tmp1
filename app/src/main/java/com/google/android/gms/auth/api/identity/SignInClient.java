package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public interface SignInClient extends HasApiKey<zbl> {
    @RecentlyNonNull
    Task<BeginSignInResult> beginSignIn(@RecentlyNonNull BeginSignInRequest beginSignInRequest);

    @RecentlyNonNull
    SignInCredential getSignInCredentialFromIntent(@Nullable Intent intent) throws ApiException;

    @RecentlyNonNull
    Task<PendingIntent> getSignInIntent(@RecentlyNonNull GetSignInIntentRequest getSignInIntentRequest);

    @RecentlyNonNull
    Task<Void> signOut();
}
