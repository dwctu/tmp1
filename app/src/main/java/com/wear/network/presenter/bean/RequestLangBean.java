package com.wear.network.presenter.bean;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestLangBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/wear/network/presenter/bean/RequestLangBean;", "", MLApplicationSetting.BundleKeyConstants.AppInfo.appName, "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "device", "lang", "Lcom/wear/network/presenter/bean/Lang;", "timeMillis", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wear/network/presenter/bean/Lang;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppVersion", "setAppVersion", "getDevice", "setDevice", "getLang", "()Lcom/wear/network/presenter/bean/Lang;", "setLang", "(Lcom/wear/network/presenter/bean/Lang;)V", "getTimeMillis", "setTimeMillis", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class RequestLangBean {

    @Nullable
    private String appName;

    @Nullable
    private String appVersion;

    @Nullable
    private String device;

    @Nullable
    private Lang lang;

    @Nullable
    private String timeMillis;

    public RequestLangBean() {
        this(null, null, null, null, null, 31, null);
    }

    public RequestLangBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Lang lang, @Nullable String str4) {
        this.appName = str;
        this.appVersion = str2;
        this.device = str3;
        this.lang = lang;
        this.timeMillis = str4;
    }

    public static /* synthetic */ RequestLangBean copy$default(RequestLangBean requestLangBean, String str, String str2, String str3, Lang lang, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestLangBean.appName;
        }
        if ((i & 2) != 0) {
            str2 = requestLangBean.appVersion;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = requestLangBean.device;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            lang = requestLangBean.lang;
        }
        Lang lang2 = lang;
        if ((i & 16) != 0) {
            str4 = requestLangBean.timeMillis;
        }
        return requestLangBean.copy(str, str5, str6, lang2, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Lang getLang() {
        return this.lang;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTimeMillis() {
        return this.timeMillis;
    }

    @NotNull
    public final RequestLangBean copy(@Nullable String appName, @Nullable String appVersion, @Nullable String device, @Nullable Lang lang, @Nullable String timeMillis) {
        return new RequestLangBean(appName, appVersion, device, lang, timeMillis);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestLangBean)) {
            return false;
        }
        RequestLangBean requestLangBean = (RequestLangBean) other;
        return Intrinsics.areEqual(this.appName, requestLangBean.appName) && Intrinsics.areEqual(this.appVersion, requestLangBean.appVersion) && Intrinsics.areEqual(this.device, requestLangBean.device) && Intrinsics.areEqual(this.lang, requestLangBean.lang) && Intrinsics.areEqual(this.timeMillis, requestLangBean.timeMillis);
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final String getDevice() {
        return this.device;
    }

    @Nullable
    public final Lang getLang() {
        return this.lang;
    }

    @Nullable
    public final String getTimeMillis() {
        return this.timeMillis;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appVersion;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.device;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Lang lang = this.lang;
        int iHashCode4 = (iHashCode3 + (lang == null ? 0 : lang.hashCode())) * 31;
        String str4 = this.timeMillis;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAppName(@Nullable String str) {
        this.appName = str;
    }

    public final void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public final void setDevice(@Nullable String str) {
        this.device = str;
    }

    public final void setLang(@Nullable Lang lang) {
        this.lang = lang;
    }

    public final void setTimeMillis(@Nullable String str) {
        this.timeMillis = str;
    }

    @NotNull
    public String toString() {
        return "RequestLangBean(appName=" + this.appName + ", appVersion=" + this.appVersion + ", device=" + this.device + ", lang=" + this.lang + ", timeMillis=" + this.timeMillis + ')';
    }

    public /* synthetic */ RequestLangBean(String str, String str2, String str3, Lang lang, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : lang, (i & 16) != 0 ? "" : str4);
    }
}
