package com.component.dxfunctionkits.forbidden.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ForbiddenRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/component/dxfunctionkits/forbidden/bean/ForbiddenRequest;", "", "deviceId", "", "pswd", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getPswd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "forbidden_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ForbiddenRequest {

    @Nullable
    private final String deviceId;

    @Nullable
    private final String pswd;

    public ForbiddenRequest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ForbiddenRequest(@Nullable String str, @Nullable String str2) {
        this.deviceId = str;
        this.pswd = str2;
    }

    public static /* synthetic */ ForbiddenRequest copy$default(ForbiddenRequest forbiddenRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = forbiddenRequest.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = forbiddenRequest.pswd;
        }
        return forbiddenRequest.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPswd() {
        return this.pswd;
    }

    @NotNull
    public final ForbiddenRequest copy(@Nullable String deviceId, @Nullable String pswd) {
        return new ForbiddenRequest(deviceId, pswd);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForbiddenRequest)) {
            return false;
        }
        ForbiddenRequest forbiddenRequest = (ForbiddenRequest) other;
        return Intrinsics.areEqual(this.deviceId, forbiddenRequest.deviceId) && Intrinsics.areEqual(this.pswd, forbiddenRequest.pswd);
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final String getPswd() {
        return this.pswd;
    }

    public int hashCode() {
        String str = this.deviceId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.pswd;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ForbiddenRequest(deviceId=" + this.deviceId + ", pswd=" + this.pswd + ')';
    }

    public /* synthetic */ ForbiddenRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
