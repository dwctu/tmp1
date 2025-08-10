package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbam;
import com.google.android.gms.internal.p000authapi.zbau;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public final class Identity {
    private Identity() {
    }

    @RecentlyNonNull
    public static CredentialSavingClient getCredentialSavingClient(@RecentlyNonNull Activity activity) {
        Activity activity2 = (Activity) Preconditions.checkNotNull(activity);
        int i = zbc.zba;
        return new zbam(activity2, new zbc());
    }

    @RecentlyNonNull
    public static SignInClient getSignInClient(@RecentlyNonNull Activity activity) {
        Activity activity2 = (Activity) Preconditions.checkNotNull(activity);
        int i = zbl.zba;
        return new zbau(activity2, new zbl());
    }

    @RecentlyNonNull
    public static CredentialSavingClient getCredentialSavingClient(@RecentlyNonNull Context context) {
        Context context2 = (Context) Preconditions.checkNotNull(context);
        int i = zbc.zba;
        return new zbam(context2, new zbc());
    }

    @RecentlyNonNull
    public static SignInClient getSignInClient(@RecentlyNonNull Context context) {
        Context context2 = (Context) Preconditions.checkNotNull(context);
        int i = zbl.zba;
        return new zbau(context2, new zbl());
    }
}
