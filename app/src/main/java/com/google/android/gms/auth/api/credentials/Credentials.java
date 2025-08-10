package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.Auth;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public class Credentials {
    @RecentlyNonNull
    public static CredentialsClient getClient(@RecentlyNonNull Activity activity) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    @RecentlyNonNull
    public static CredentialsClient getClient(@RecentlyNonNull Activity activity, @RecentlyNonNull CredentialsOptions credentialsOptions) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) credentialsOptions);
    }

    @RecentlyNonNull
    public static CredentialsClient getClient(@RecentlyNonNull Context context) {
        return new CredentialsClient(context, CredentialsOptions.DEFAULT);
    }

    @RecentlyNonNull
    public static CredentialsClient getClient(@RecentlyNonNull Context context, @RecentlyNonNull CredentialsOptions credentialsOptions) {
        return new CredentialsClient(context, credentialsOptions);
    }
}
