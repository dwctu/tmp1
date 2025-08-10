package com.google.android.gms.auth.api.credentials;

import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Response;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    @RecentlyNullable
    public Credential getCredential() {
        return getResult().getCredential();
    }
}
