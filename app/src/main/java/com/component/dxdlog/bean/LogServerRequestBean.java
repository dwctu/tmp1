package com.component.dxdlog.bean;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogServerRequestBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/component/dxdlog/bean/LogServerRequestBean;", "", "appCode", "", MLApplicationSetting.BundleKeyConstants.AppInfo.appName, "platform", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "osVersion", "deviceType", "deviceId", "accountCode", "fileUrl", "updateFileDate", "logDateStart", "logDateEnd", "uploadReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountCode", "()Ljava/lang/String;", "getAppCode", "getAppName", "getAppVersion", "getDeviceId", "getDeviceType", "getFileUrl", "getLogDateEnd", "getLogDateStart", "getOsVersion", "getPlatform", "getUpdateFileDate", "getUploadReason", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LogServerRequestBean {

    @Nullable
    private final String accountCode;

    @NotNull
    private final String appCode;

    @NotNull
    private final String appName;

    @NotNull
    private final String appVersion;

    @Nullable
    private final String deviceId;

    @NotNull
    private final String deviceType;

    @Nullable
    private final String fileUrl;

    @Nullable
    private final String logDateEnd;

    @Nullable
    private final String logDateStart;

    @NotNull
    private final String osVersion;

    @NotNull
    private final String platform;

    @Nullable
    private final String updateFileDate;

    @Nullable
    private final String uploadReason;

    public LogServerRequestBean(@NotNull String appCode, @NotNull String appName, @NotNull String platform, @NotNull String appVersion, @NotNull String osVersion, @NotNull String deviceType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        this.appCode = appCode;
        this.appName = appName;
        this.platform = platform;
        this.appVersion = appVersion;
        this.osVersion = osVersion;
        this.deviceType = deviceType;
        this.deviceId = str;
        this.accountCode = str2;
        this.fileUrl = str3;
        this.updateFileDate = str4;
        this.logDateStart = str5;
        this.logDateEnd = str6;
        this.uploadReason = str7;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAppCode() {
        return this.appCode;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getUpdateFileDate() {
        return this.updateFileDate;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getLogDateStart() {
        return this.logDateStart;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getLogDateEnd() {
        return this.logDateEnd;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getUploadReason() {
        return this.uploadReason;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getAccountCode() {
        return this.accountCode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @NotNull
    public final LogServerRequestBean copy(@NotNull String appCode, @NotNull String appName, @NotNull String platform, @NotNull String appVersion, @NotNull String osVersion, @NotNull String deviceType, @Nullable String deviceId, @Nullable String accountCode, @Nullable String fileUrl, @Nullable String updateFileDate, @Nullable String logDateStart, @Nullable String logDateEnd, @Nullable String uploadReason) {
        Intrinsics.checkNotNullParameter(appCode, "appCode");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new LogServerRequestBean(appCode, appName, platform, appVersion, osVersion, deviceType, deviceId, accountCode, fileUrl, updateFileDate, logDateStart, logDateEnd, uploadReason);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogServerRequestBean)) {
            return false;
        }
        LogServerRequestBean logServerRequestBean = (LogServerRequestBean) other;
        return Intrinsics.areEqual(this.appCode, logServerRequestBean.appCode) && Intrinsics.areEqual(this.appName, logServerRequestBean.appName) && Intrinsics.areEqual(this.platform, logServerRequestBean.platform) && Intrinsics.areEqual(this.appVersion, logServerRequestBean.appVersion) && Intrinsics.areEqual(this.osVersion, logServerRequestBean.osVersion) && Intrinsics.areEqual(this.deviceType, logServerRequestBean.deviceType) && Intrinsics.areEqual(this.deviceId, logServerRequestBean.deviceId) && Intrinsics.areEqual(this.accountCode, logServerRequestBean.accountCode) && Intrinsics.areEqual(this.fileUrl, logServerRequestBean.fileUrl) && Intrinsics.areEqual(this.updateFileDate, logServerRequestBean.updateFileDate) && Intrinsics.areEqual(this.logDateStart, logServerRequestBean.logDateStart) && Intrinsics.areEqual(this.logDateEnd, logServerRequestBean.logDateEnd) && Intrinsics.areEqual(this.uploadReason, logServerRequestBean.uploadReason);
    }

    @Nullable
    public final String getAccountCode() {
        return this.accountCode;
    }

    @NotNull
    public final String getAppCode() {
        return this.appCode;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getFileUrl() {
        return this.fileUrl;
    }

    @Nullable
    public final String getLogDateEnd() {
        return this.logDateEnd;
    }

    @Nullable
    public final String getLogDateStart() {
        return this.logDateStart;
    }

    @NotNull
    public final String getOsVersion() {
        return this.osVersion;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    public final String getUpdateFileDate() {
        return this.updateFileDate;
    }

    @Nullable
    public final String getUploadReason() {
        return this.uploadReason;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.appCode.hashCode() * 31) + this.appName.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.deviceType.hashCode()) * 31;
        String str = this.deviceId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accountCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.updateFileDate;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.logDateStart;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.logDateEnd;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.uploadReason;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LogServerRequestBean(appCode=" + this.appCode + ", appName=" + this.appName + ", platform=" + this.platform + ", appVersion=" + this.appVersion + ", osVersion=" + this.osVersion + ", deviceType=" + this.deviceType + ", deviceId=" + this.deviceId + ", accountCode=" + this.accountCode + ", fileUrl=" + this.fileUrl + ", updateFileDate=" + this.updateFileDate + ", logDateStart=" + this.logDateStart + ", logDateEnd=" + this.logDateEnd + ", uploadReason=" + this.uploadReason + ')';
    }

    public /* synthetic */ LogServerRequestBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13);
    }
}
