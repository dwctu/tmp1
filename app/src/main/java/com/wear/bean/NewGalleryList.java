package com.wear.bean;

import dc.of1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewGalleryListBean.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÃ\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00069"}, d2 = {"Lcom/wear/bean/NewGalleryList;", "Ljava/io/Serializable;", "applicationCoverImgUrl", "", "applicationId", "applicationLogoUrl", "applicationName", "applicationSynopsis", "applicationUrl", "dataRequiredList", "", "developerName", "previewImgOrientation", "previewImgUlrList", "previewText", "xremoteApiVersion", "applicationVersion", "xremoteAllowDomainList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getApplicationCoverImgUrl", "()Ljava/lang/String;", "getApplicationId", "getApplicationLogoUrl", "getApplicationName", "getApplicationSynopsis", "getApplicationUrl", "getApplicationVersion", "getDataRequiredList", "()Ljava/util/List;", "getDeveloperName", "getPreviewImgOrientation", "getPreviewImgUlrList", "getPreviewText", "getXremoteAllowDomainList", "getXremoteApiVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class NewGalleryList implements Serializable {

    @Nullable
    private final String applicationCoverImgUrl;

    @Nullable
    private final String applicationId;

    @Nullable
    private final String applicationLogoUrl;

    @Nullable
    private final String applicationName;

    @Nullable
    private final String applicationSynopsis;

    @Nullable
    private final String applicationUrl;

    @Nullable
    private final String applicationVersion;

    @Nullable
    private final List<String> dataRequiredList;

    @Nullable
    private final String developerName;

    @Nullable
    private final String previewImgOrientation;

    @Nullable
    private final List<String> previewImgUlrList;

    @Nullable
    private final String previewText;

    @Nullable
    private final List<String> xremoteAllowDomainList;

    @Nullable
    private final String xremoteApiVersion;

    public NewGalleryList() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public NewGalleryList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<String> list, @Nullable String str7, @Nullable String str8, @Nullable List<String> list2, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable List<String> list3) {
        this.applicationCoverImgUrl = str;
        this.applicationId = str2;
        this.applicationLogoUrl = str3;
        this.applicationName = str4;
        this.applicationSynopsis = str5;
        this.applicationUrl = str6;
        this.dataRequiredList = list;
        this.developerName = str7;
        this.previewImgOrientation = str8;
        this.previewImgUlrList = list2;
        this.previewText = str9;
        this.xremoteApiVersion = str10;
        this.applicationVersion = str11;
        this.xremoteAllowDomainList = list3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getApplicationCoverImgUrl() {
        return this.applicationCoverImgUrl;
    }

    @Nullable
    public final List<String> component10() {
        return this.previewImgUlrList;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getPreviewText() {
        return this.previewText;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getXremoteApiVersion() {
        return this.xremoteApiVersion;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getApplicationVersion() {
        return this.applicationVersion;
    }

    @Nullable
    public final List<String> component14() {
        return this.xremoteAllowDomainList;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getApplicationLogoUrl() {
        return this.applicationLogoUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getApplicationName() {
        return this.applicationName;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getApplicationSynopsis() {
        return this.applicationSynopsis;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getApplicationUrl() {
        return this.applicationUrl;
    }

    @Nullable
    public final List<String> component7() {
        return this.dataRequiredList;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getDeveloperName() {
        return this.developerName;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getPreviewImgOrientation() {
        return this.previewImgOrientation;
    }

    @NotNull
    public final NewGalleryList copy(@Nullable String applicationCoverImgUrl, @Nullable String applicationId, @Nullable String applicationLogoUrl, @Nullable String applicationName, @Nullable String applicationSynopsis, @Nullable String applicationUrl, @Nullable List<String> dataRequiredList, @Nullable String developerName, @Nullable String previewImgOrientation, @Nullable List<String> previewImgUlrList, @Nullable String previewText, @Nullable String xremoteApiVersion, @Nullable String applicationVersion, @Nullable List<String> xremoteAllowDomainList) {
        return new NewGalleryList(applicationCoverImgUrl, applicationId, applicationLogoUrl, applicationName, applicationSynopsis, applicationUrl, dataRequiredList, developerName, previewImgOrientation, previewImgUlrList, previewText, xremoteApiVersion, applicationVersion, xremoteAllowDomainList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewGalleryList)) {
            return false;
        }
        NewGalleryList newGalleryList = (NewGalleryList) other;
        return Intrinsics.areEqual(this.applicationCoverImgUrl, newGalleryList.applicationCoverImgUrl) && Intrinsics.areEqual(this.applicationId, newGalleryList.applicationId) && Intrinsics.areEqual(this.applicationLogoUrl, newGalleryList.applicationLogoUrl) && Intrinsics.areEqual(this.applicationName, newGalleryList.applicationName) && Intrinsics.areEqual(this.applicationSynopsis, newGalleryList.applicationSynopsis) && Intrinsics.areEqual(this.applicationUrl, newGalleryList.applicationUrl) && Intrinsics.areEqual(this.dataRequiredList, newGalleryList.dataRequiredList) && Intrinsics.areEqual(this.developerName, newGalleryList.developerName) && Intrinsics.areEqual(this.previewImgOrientation, newGalleryList.previewImgOrientation) && Intrinsics.areEqual(this.previewImgUlrList, newGalleryList.previewImgUlrList) && Intrinsics.areEqual(this.previewText, newGalleryList.previewText) && Intrinsics.areEqual(this.xremoteApiVersion, newGalleryList.xremoteApiVersion) && Intrinsics.areEqual(this.applicationVersion, newGalleryList.applicationVersion) && Intrinsics.areEqual(this.xremoteAllowDomainList, newGalleryList.xremoteAllowDomainList);
    }

    @Nullable
    public final String getApplicationCoverImgUrl() {
        return this.applicationCoverImgUrl;
    }

    @Nullable
    public final String getApplicationId() {
        return this.applicationId;
    }

    @Nullable
    public final String getApplicationLogoUrl() {
        return this.applicationLogoUrl;
    }

    @Nullable
    public final String getApplicationName() {
        return this.applicationName;
    }

    @Nullable
    public final String getApplicationSynopsis() {
        return this.applicationSynopsis;
    }

    @Nullable
    public final String getApplicationUrl() {
        return this.applicationUrl;
    }

    @Nullable
    public final String getApplicationVersion() {
        return this.applicationVersion;
    }

    @Nullable
    public final List<String> getDataRequiredList() {
        return this.dataRequiredList;
    }

    @Nullable
    public final String getDeveloperName() {
        return this.developerName;
    }

    @Nullable
    public final String getPreviewImgOrientation() {
        return this.previewImgOrientation;
    }

    @Nullable
    public final List<String> getPreviewImgUlrList() {
        return this.previewImgUlrList;
    }

    @Nullable
    public final String getPreviewText() {
        return this.previewText;
    }

    @Nullable
    public final List<String> getXremoteAllowDomainList() {
        return this.xremoteAllowDomainList;
    }

    @Nullable
    public final String getXremoteApiVersion() {
        return this.xremoteApiVersion;
    }

    public int hashCode() {
        String str = this.applicationCoverImgUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.applicationId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.applicationLogoUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.applicationName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.applicationSynopsis;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.applicationUrl;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list = this.dataRequiredList;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.developerName;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.previewImgOrientation;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<String> list2 = this.previewImgUlrList;
        int iHashCode10 = (iHashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str9 = this.previewText;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.xremoteApiVersion;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.applicationVersion;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<String> list3 = this.xremoteAllowDomainList;
        return iHashCode13 + (list3 != null ? list3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewGalleryList(applicationCoverImgUrl=" + this.applicationCoverImgUrl + ", applicationId=" + this.applicationId + ", applicationLogoUrl=" + this.applicationLogoUrl + ", applicationName=" + this.applicationName + ", applicationSynopsis=" + this.applicationSynopsis + ", applicationUrl=" + this.applicationUrl + ", dataRequiredList=" + this.dataRequiredList + ", developerName=" + this.developerName + ", previewImgOrientation=" + this.previewImgOrientation + ", previewImgUlrList=" + this.previewImgUlrList + ", previewText=" + this.previewText + ", xremoteApiVersion=" + this.xremoteApiVersion + ", applicationVersion=" + this.applicationVersion + ", xremoteAllowDomainList=" + this.xremoteAllowDomainList + ')';
    }

    public /* synthetic */ NewGalleryList(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, List list2, String str9, String str10, String str11, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? new ArrayList() : list, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "horizontal" : str8, (i & 512) != 0 ? new ArrayList() : list2, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) == 0 ? str11 : "", (i & 8192) != 0 ? new ArrayList() : list3);
    }
}
