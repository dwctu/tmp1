package com.wear.bean.official;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/wear/bean/official/OfficialLinkInfo;", "", "linkText", "", "linkUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getLinkText", "()Ljava/lang/String;", "setLinkText", "(Ljava/lang/String;)V", "getLinkUrl", "setLinkUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialLinkInfo {

    @Nullable
    private String linkText;

    @Nullable
    private String linkUrl;

    public OfficialLinkInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public OfficialLinkInfo(@Nullable String str, @Nullable String str2) {
        this.linkText = str;
        this.linkUrl = str2;
    }

    public static /* synthetic */ OfficialLinkInfo copy$default(OfficialLinkInfo officialLinkInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = officialLinkInfo.linkText;
        }
        if ((i & 2) != 0) {
            str2 = officialLinkInfo.linkUrl;
        }
        return officialLinkInfo.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getLinkText() {
        return this.linkText;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    public final OfficialLinkInfo copy(@Nullable String linkText, @Nullable String linkUrl) {
        return new OfficialLinkInfo(linkText, linkUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialLinkInfo)) {
            return false;
        }
        OfficialLinkInfo officialLinkInfo = (OfficialLinkInfo) other;
        return Intrinsics.areEqual(this.linkText, officialLinkInfo.linkText) && Intrinsics.areEqual(this.linkUrl, officialLinkInfo.linkUrl);
    }

    @Nullable
    public final String getLinkText() {
        return this.linkText;
    }

    @Nullable
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public int hashCode() {
        String str = this.linkText;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.linkUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setLinkText(@Nullable String str) {
        this.linkText = str;
    }

    public final void setLinkUrl(@Nullable String str) {
        this.linkUrl = str;
    }

    @NotNull
    public String toString() {
        return "OfficialLinkInfo(linkText=" + this.linkText + ", linkUrl=" + this.linkUrl + ')';
    }

    public /* synthetic */ OfficialLinkInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
