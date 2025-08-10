package com.google.android.gms.auth.api.identity;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public interface CredentialSavingClient extends HasApiKey<zbc> {
    @RecentlyNonNull
    Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(@RecentlyNonNull SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest);

    @RecentlyNonNull
    Task<SavePasswordResult> savePassword(@RecentlyNonNull SavePasswordRequest savePasswordRequest);
}
