package com.google.android.gms.safetynet;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public class SafetyNetClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public SafetyNetClient(@NonNull Activity activity) {
        super(activity, (Api<Api.ApiOptions>) SafetyNet.API, (Api.ApiOptions) null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public SafetyNetClient(@NonNull Context context) {
        super(context, SafetyNet.API, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    public Task<SafetyNetApi.AttestationResponse> attest(@NonNull byte[] bArr, @NonNull String str) {
        return PendingResultUtil.toResponseTask(com.google.android.gms.internal.safetynet.zzk.zza(asGoogleApiClient(), bArr, str), new SafetyNetApi.AttestationResponse());
    }

    public Task<SafetyNetApi.VerifyAppsUserResponse> enableVerifyApps() {
        return PendingResultUtil.toResponseTask(SafetyNet.SafetyNetApi.enableVerifyApps(asGoogleApiClient()), new SafetyNetApi.VerifyAppsUserResponse());
    }

    public Task<Void> initSafeBrowsing() {
        return doRead(new zzl(this));
    }

    public Task<SafetyNetApi.VerifyAppsUserResponse> isVerifyAppsEnabled() {
        return PendingResultUtil.toResponseTask(SafetyNet.SafetyNetApi.isVerifyAppsEnabled(asGoogleApiClient()), new SafetyNetApi.VerifyAppsUserResponse());
    }

    public Task<SafetyNetApi.HarmfulAppsResponse> listHarmfulApps() {
        return PendingResultUtil.toResponseTask(SafetyNet.SafetyNetApi.listHarmfulApps(asGoogleApiClient()), new SafetyNetApi.HarmfulAppsResponse());
    }

    public Task<SafetyNetApi.SafeBrowsingResponse> lookupUri(@NonNull String str, @NonNull String str2, int... iArr) {
        return PendingResultUtil.toResponseTask(com.google.android.gms.internal.safetynet.zzk.zza(asGoogleApiClient(), str, 3, str2, iArr), new SafetyNetApi.SafeBrowsingResponse());
    }

    public Task<Void> shutdownSafeBrowsing() {
        return doRead(new zzn(this));
    }

    public Task<SafetyNetApi.RecaptchaTokenResponse> verifyWithRecaptcha(@NonNull String str) {
        return PendingResultUtil.toResponseTask(SafetyNet.SafetyNetApi.verifyWithRecaptcha(asGoogleApiClient(), str), new SafetyNetApi.RecaptchaTokenResponse());
    }
}
