package com.wear.bean.official;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006("}, d2 = {"Lcom/wear/bean/official/OfficialLangInfo;", "", MessageBundle.TITLE_ENTRY, "", FirebaseAnalytics.Param.CONTENT, "pictureList", "", "videoList", "Lcom/wear/bean/official/OfficialVideoInfo;", "link", "Lcom/wear/bean/official/OfficialLinkInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/wear/bean/official/OfficialLinkInfo;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getLink", "()Lcom/wear/bean/official/OfficialLinkInfo;", "setLink", "(Lcom/wear/bean/official/OfficialLinkInfo;)V", "getPictureList", "()Ljava/util/List;", "setPictureList", "(Ljava/util/List;)V", "getTitle", "setTitle", "getVideoList", "setVideoList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialLangInfo {

    @Nullable
    private String content;

    @Nullable
    private OfficialLinkInfo link;

    @Nullable
    private List<String> pictureList;

    @Nullable
    private String title;

    @Nullable
    private List<OfficialVideoInfo> videoList;

    public OfficialLangInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public OfficialLangInfo(@Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable List<OfficialVideoInfo> list2, @Nullable OfficialLinkInfo officialLinkInfo) {
        this.title = str;
        this.content = str2;
        this.pictureList = list;
        this.videoList = list2;
        this.link = officialLinkInfo;
    }

    public static /* synthetic */ OfficialLangInfo copy$default(OfficialLangInfo officialLangInfo, String str, String str2, List list, List list2, OfficialLinkInfo officialLinkInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = officialLangInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = officialLangInfo.content;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            list = officialLangInfo.pictureList;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = officialLangInfo.videoList;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            officialLinkInfo = officialLangInfo.link;
        }
        return officialLangInfo.copy(str, str3, list3, list4, officialLinkInfo);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<String> component3() {
        return this.pictureList;
    }

    @Nullable
    public final List<OfficialVideoInfo> component4() {
        return this.videoList;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final OfficialLinkInfo getLink() {
        return this.link;
    }

    @NotNull
    public final OfficialLangInfo copy(@Nullable String title, @Nullable String content, @Nullable List<String> pictureList, @Nullable List<OfficialVideoInfo> videoList, @Nullable OfficialLinkInfo link) {
        return new OfficialLangInfo(title, content, pictureList, videoList, link);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialLangInfo)) {
            return false;
        }
        OfficialLangInfo officialLangInfo = (OfficialLangInfo) other;
        return Intrinsics.areEqual(this.title, officialLangInfo.title) && Intrinsics.areEqual(this.content, officialLangInfo.content) && Intrinsics.areEqual(this.pictureList, officialLangInfo.pictureList) && Intrinsics.areEqual(this.videoList, officialLangInfo.videoList) && Intrinsics.areEqual(this.link, officialLangInfo.link);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final OfficialLinkInfo getLink() {
        return this.link;
    }

    @Nullable
    public final List<String> getPictureList() {
        return this.pictureList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<OfficialVideoInfo> getVideoList() {
        return this.videoList;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.pictureList;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<OfficialVideoInfo> list2 = this.videoList;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        OfficialLinkInfo officialLinkInfo = this.link;
        return iHashCode4 + (officialLinkInfo != null ? officialLinkInfo.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setLink(@Nullable OfficialLinkInfo officialLinkInfo) {
        this.link = officialLinkInfo;
    }

    public final void setPictureList(@Nullable List<String> list) {
        this.pictureList = list;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setVideoList(@Nullable List<OfficialVideoInfo> list) {
        this.videoList = list;
    }

    @NotNull
    public String toString() {
        return "OfficialLangInfo(title=" + this.title + ", content=" + this.content + ", pictureList=" + this.pictureList + ", videoList=" + this.videoList + ", link=" + this.link + ')';
    }

    public /* synthetic */ OfficialLangInfo(String str, String str2, List list, List list2, OfficialLinkInfo officialLinkInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) == 0 ? str2 : "", (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : officialLinkInfo);
    }
}
