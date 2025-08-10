package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public final class IdentityProviders {

    @RecentlyNonNull
    public static final String FACEBOOK = "https://www.facebook.com";

    @RecentlyNonNull
    public static final String GOOGLE = "https://accounts.google.com";

    @RecentlyNonNull
    public static final String LINKEDIN = "https://www.linkedin.com";

    @RecentlyNonNull
    public static final String MICROSOFT = "https://login.live.com";

    @RecentlyNonNull
    public static final String PAYPAL = "https://www.paypal.com";

    @RecentlyNonNull
    public static final String TWITTER = "https://twitter.com";

    @RecentlyNonNull
    public static final String YAHOO = "https://login.yahoo.com";

    private IdentityProviders() {
    }

    @RecentlyNullable
    public static final String getIdentityProviderForAccount(@RecentlyNonNull Account account) {
        Preconditions.checkNotNull(account, "account cannot be null");
        if ("com.google".equals(account.type)) {
            return GOOGLE;
        }
        if ("com.facebook.auth.login".equals(account.type)) {
            return FACEBOOK;
        }
        return null;
    }
}
