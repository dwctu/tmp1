package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: GalleryDetailsV2Bean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/GalleryDetailsV2Bean;", "", XHTMLText.CODE, "", "data", "Lcom/wear/bean/GalleryDetailData;", "message", "", "result", "", "(Ljava/lang/Integer;Lcom/wear/bean/GalleryDetailData;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/wear/bean/GalleryDetailData;", "getMessage", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/wear/bean/GalleryDetailData;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/wear/bean/GalleryDetailsV2Bean;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GalleryDetailsV2Bean {

    @Nullable
    private final Integer code;

    @Nullable
    private final GalleryDetailData data;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean result;

    public GalleryDetailsV2Bean() {
        this(null, null, null, null, 15, null);
    }

    public GalleryDetailsV2Bean(@Nullable Integer num, @Nullable GalleryDetailData galleryDetailData, @Nullable String str, @Nullable Boolean bool) {
        this.code = num;
        this.data = galleryDetailData;
        this.message = str;
        this.result = bool;
    }

    public static /* synthetic */ GalleryDetailsV2Bean copy$default(GalleryDetailsV2Bean galleryDetailsV2Bean, Integer num, GalleryDetailData galleryDetailData, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = galleryDetailsV2Bean.code;
        }
        if ((i & 2) != 0) {
            galleryDetailData = galleryDetailsV2Bean.data;
        }
        if ((i & 4) != 0) {
            str = galleryDetailsV2Bean.message;
        }
        if ((i & 8) != 0) {
            bool = galleryDetailsV2Bean.result;
        }
        return galleryDetailsV2Bean.copy(num, galleryDetailData, str, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GalleryDetailData getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @NotNull
    public final GalleryDetailsV2Bean copy(@Nullable Integer code, @Nullable GalleryDetailData data, @Nullable String message, @Nullable Boolean result) {
        return new GalleryDetailsV2Bean(code, data, message, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GalleryDetailsV2Bean)) {
            return false;
        }
        GalleryDetailsV2Bean galleryDetailsV2Bean = (GalleryDetailsV2Bean) other;
        return Intrinsics.areEqual(this.code, galleryDetailsV2Bean.code) && Intrinsics.areEqual(this.data, galleryDetailsV2Bean.data) && Intrinsics.areEqual(this.message, galleryDetailsV2Bean.message) && Intrinsics.areEqual(this.result, galleryDetailsV2Bean.result);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final GalleryDetailData getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        GalleryDetailData galleryDetailData = this.data;
        int iHashCode2 = (iHashCode + (galleryDetailData == null ? 0 : galleryDetailData.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.result;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GalleryDetailsV2Bean(code=" + this.code + ", data=" + this.data + ", message=" + this.message + ", result=" + this.result + ')';
    }

    public /* synthetic */ GalleryDetailsV2Bean(Integer num, GalleryDetailData galleryDetailData, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : galleryDetailData, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? Boolean.FALSE : bool);
    }
}
