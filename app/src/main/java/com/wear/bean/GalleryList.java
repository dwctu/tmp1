package com.wear.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryListBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/GalleryList;", "Ljava/io/Serializable;", "applicationCoverImgUrl", "", "applicationId", "applicationLogoUrl", "applicationName", "applicationSynopsis", "applicationUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplicationCoverImgUrl", "()Ljava/lang/String;", "getApplicationId", "getApplicationLogoUrl", "getApplicationName", "getApplicationSynopsis", "getApplicationUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GalleryList implements Serializable {

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

    public GalleryList() {
        this(null, null, null, null, null, null, 63, null);
    }

    public GalleryList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.applicationCoverImgUrl = str;
        this.applicationId = str2;
        this.applicationLogoUrl = str3;
        this.applicationName = str4;
        this.applicationSynopsis = str5;
        this.applicationUrl = str6;
    }

    public static /* synthetic */ GalleryList copy$default(GalleryList galleryList, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = galleryList.applicationCoverImgUrl;
        }
        if ((i & 2) != 0) {
            str2 = galleryList.applicationId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = galleryList.applicationLogoUrl;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = galleryList.applicationName;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = galleryList.applicationSynopsis;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = galleryList.applicationUrl;
        }
        return galleryList.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getApplicationCoverImgUrl() {
        return this.applicationCoverImgUrl;
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

    @NotNull
    public final GalleryList copy(@Nullable String applicationCoverImgUrl, @Nullable String applicationId, @Nullable String applicationLogoUrl, @Nullable String applicationName, @Nullable String applicationSynopsis, @Nullable String applicationUrl) {
        return new GalleryList(applicationCoverImgUrl, applicationId, applicationLogoUrl, applicationName, applicationSynopsis, applicationUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GalleryList)) {
            return false;
        }
        GalleryList galleryList = (GalleryList) other;
        return Intrinsics.areEqual(this.applicationCoverImgUrl, galleryList.applicationCoverImgUrl) && Intrinsics.areEqual(this.applicationId, galleryList.applicationId) && Intrinsics.areEqual(this.applicationLogoUrl, galleryList.applicationLogoUrl) && Intrinsics.areEqual(this.applicationName, galleryList.applicationName) && Intrinsics.areEqual(this.applicationSynopsis, galleryList.applicationSynopsis) && Intrinsics.areEqual(this.applicationUrl, galleryList.applicationUrl);
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
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GalleryList(applicationCoverImgUrl=" + this.applicationCoverImgUrl + ", applicationId=" + this.applicationId + ", applicationLogoUrl=" + this.applicationLogoUrl + ", applicationName=" + this.applicationName + ", applicationSynopsis=" + this.applicationSynopsis + ", applicationUrl=" + this.applicationUrl + ')';
    }

    public /* synthetic */ GalleryList(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }
}
