package com.component.dxtoy.config.bean;

import androidx.core.os.EnvironmentCompat;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyConfigReqBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/component/dxtoy/config/bean/ToyConfigReqBean;", "", "appType", "", "platform", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "dataVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppType", "()Ljava/lang/String;", "getAppVersion", "getDataVersion", "getPlatform", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyConfigReqBean {

    @Nullable
    private final String appType;

    @Nullable
    private final String appVersion;

    @Nullable
    private final String dataVersion;

    @Nullable
    private final String platform;

    public ToyConfigReqBean() {
        this(null, null, null, null, 15, null);
    }

    public ToyConfigReqBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.appType = str;
        this.platform = str2;
        this.appVersion = str3;
        this.dataVersion = str4;
    }

    public static /* synthetic */ ToyConfigReqBean copy$default(ToyConfigReqBean toyConfigReqBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toyConfigReqBean.appType;
        }
        if ((i & 2) != 0) {
            str2 = toyConfigReqBean.platform;
        }
        if ((i & 4) != 0) {
            str3 = toyConfigReqBean.appVersion;
        }
        if ((i & 8) != 0) {
            str4 = toyConfigReqBean.dataVersion;
        }
        return toyConfigReqBean.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDataVersion() {
        return this.dataVersion;
    }

    @NotNull
    public final ToyConfigReqBean copy(@Nullable String appType, @Nullable String platform, @Nullable String appVersion, @Nullable String dataVersion) {
        return new ToyConfigReqBean(appType, platform, appVersion, dataVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyConfigReqBean)) {
            return false;
        }
        ToyConfigReqBean toyConfigReqBean = (ToyConfigReqBean) other;
        return Intrinsics.areEqual(this.appType, toyConfigReqBean.appType) && Intrinsics.areEqual(this.platform, toyConfigReqBean.platform) && Intrinsics.areEqual(this.appVersion, toyConfigReqBean.appVersion) && Intrinsics.areEqual(this.dataVersion, toyConfigReqBean.dataVersion);
    }

    @Nullable
    public final String getAppType() {
        return this.appType;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final String getDataVersion() {
        return this.dataVersion;
    }

    @Nullable
    public final String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        String str = this.appType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.platform;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appVersion;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.dataVersion;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ToyConfigReqBean(appType=" + this.appType + ", platform=" + this.platform + ", appVersion=" + this.appVersion + ", dataVersion=" + this.dataVersion + ')';
    }

    public /* synthetic */ ToyConfigReqBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EnvironmentCompat.MEDIA_UNKNOWN : str, (i & 2) != 0 ? DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "1" : str4);
    }
}
