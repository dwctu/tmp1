package com.wear.bean;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppGalleryScanBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/wear/bean/AppGalleryScanBean;", "", "allowDomains", "", "", "permission", "version", RemoteConfigConstants.RequestFieldKey.APP_ID, RemoteConfigConstants.RequestFieldKey.APP_VERSION, "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllowDomains", "()Ljava/util/List;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppVersion", "setAppVersion", "getPermission", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppGalleryScanBean {

    @Nullable
    private final List<String> allowDomains;

    @Nullable
    private String appId;

    @Nullable
    private String appVersion;

    @Nullable
    private final List<String> permission;

    @Nullable
    private final String version;

    public AppGalleryScanBean() {
        this(null, null, null, null, null, 31, null);
    }

    public AppGalleryScanBean(@Nullable List<String> list, @Nullable List<String> list2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.allowDomains = list;
        this.permission = list2;
        this.version = str;
        this.appId = str2;
        this.appVersion = str3;
    }

    public static /* synthetic */ AppGalleryScanBean copy$default(AppGalleryScanBean appGalleryScanBean, List list, List list2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = appGalleryScanBean.allowDomains;
        }
        if ((i & 2) != 0) {
            list2 = appGalleryScanBean.permission;
        }
        List list3 = list2;
        if ((i & 4) != 0) {
            str = appGalleryScanBean.version;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = appGalleryScanBean.appId;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = appGalleryScanBean.appVersion;
        }
        return appGalleryScanBean.copy(list, list3, str4, str5, str3);
    }

    @Nullable
    public final List<String> component1() {
        return this.allowDomains;
    }

    @Nullable
    public final List<String> component2() {
        return this.permission;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final AppGalleryScanBean copy(@Nullable List<String> allowDomains, @Nullable List<String> permission, @Nullable String version, @Nullable String appId, @Nullable String appVersion) {
        return new AppGalleryScanBean(allowDomains, permission, version, appId, appVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppGalleryScanBean)) {
            return false;
        }
        AppGalleryScanBean appGalleryScanBean = (AppGalleryScanBean) other;
        return Intrinsics.areEqual(this.allowDomains, appGalleryScanBean.allowDomains) && Intrinsics.areEqual(this.permission, appGalleryScanBean.permission) && Intrinsics.areEqual(this.version, appGalleryScanBean.version) && Intrinsics.areEqual(this.appId, appGalleryScanBean.appId) && Intrinsics.areEqual(this.appVersion, appGalleryScanBean.appVersion);
    }

    @Nullable
    public final List<String> getAllowDomains() {
        return this.allowDomains;
    }

    @Nullable
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final List<String> getPermission() {
        return this.permission;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<String> list = this.allowDomains;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.permission;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.version;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appVersion;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAppId(@Nullable String str) {
        this.appId = str;
    }

    public final void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    @NotNull
    public String toString() {
        return "AppGalleryScanBean(allowDomains=" + this.allowDomains + ", permission=" + this.permission + ", version=" + this.version + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ')';
    }

    public /* synthetic */ AppGalleryScanBean(List list, List list2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) == 0 ? str3 : "");
    }
}
