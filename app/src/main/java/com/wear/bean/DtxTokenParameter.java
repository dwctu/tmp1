package com.wear.bean;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DtxTokenParameter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/wear/bean/DtxTokenParameter;", "", MLApplicationSetting.BundleKeyConstants.AppInfo.appName, "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getVersion", "setVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DtxTokenParameter {

    @NotNull
    private String appName;

    @Nullable
    private String version;

    public DtxTokenParameter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DtxTokenParameter(@NotNull String appName, @Nullable String str) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.appName = appName;
        this.version = str;
    }

    public static /* synthetic */ DtxTokenParameter copy$default(DtxTokenParameter dtxTokenParameter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dtxTokenParameter.appName;
        }
        if ((i & 2) != 0) {
            str2 = dtxTokenParameter.version;
        }
        return dtxTokenParameter.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final DtxTokenParameter copy(@NotNull String appName, @Nullable String version) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        return new DtxTokenParameter(appName, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DtxTokenParameter)) {
            return false;
        }
        DtxTokenParameter dtxTokenParameter = (DtxTokenParameter) other;
        return Intrinsics.areEqual(this.appName, dtxTokenParameter.appName) && Intrinsics.areEqual(this.version, dtxTokenParameter.version);
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.appName.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAppName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setVersion(@Nullable String str) {
        this.version = str;
    }

    @NotNull
    public String toString() {
        return "DtxTokenParameter(appName=" + this.appName + ", version=" + this.version + ')';
    }

    public /* synthetic */ DtxTokenParameter(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Lovense Remote" : str, (i & 2) != 0 ? "" : str2);
    }
}
