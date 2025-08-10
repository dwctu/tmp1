package com.wear.bean.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BannerDataBean.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/wear/bean/data/BannerDataBean;", "Landroid/os/Parcelable;", "imageurl", "", "videoUrl", "videoCoverUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageurl", "()Ljava/lang/String;", "setImageurl", "(Ljava/lang/String;)V", "getVideoCoverUrl", "setVideoCoverUrl", "getVideoUrl", "setVideoUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getRealUrl", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BannerDataBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BannerDataBean> CREATOR = new Creator();

    @Nullable
    private String imageurl;

    @Nullable
    private String videoCoverUrl;

    @Nullable
    private String videoUrl;

    /* compiled from: BannerDataBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BannerDataBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BannerDataBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BannerDataBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BannerDataBean[] newArray(int i) {
            return new BannerDataBean[i];
        }
    }

    public BannerDataBean() {
        this(null, null, null, 7, null);
    }

    public BannerDataBean(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.imageurl = str;
        this.videoUrl = str2;
        this.videoCoverUrl = str3;
    }

    public static /* synthetic */ BannerDataBean copy$default(BannerDataBean bannerDataBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bannerDataBean.imageurl;
        }
        if ((i & 2) != 0) {
            str2 = bannerDataBean.videoUrl;
        }
        if ((i & 4) != 0) {
            str3 = bannerDataBean.videoCoverUrl;
        }
        return bannerDataBean.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getImageurl() {
        return this.imageurl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    @NotNull
    public final BannerDataBean copy(@Nullable String imageurl, @Nullable String videoUrl, @Nullable String videoCoverUrl) {
        return new BannerDataBean(imageurl, videoUrl, videoCoverUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerDataBean)) {
            return false;
        }
        BannerDataBean bannerDataBean = (BannerDataBean) other;
        return Intrinsics.areEqual(this.imageurl, bannerDataBean.imageurl) && Intrinsics.areEqual(this.videoUrl, bannerDataBean.videoUrl) && Intrinsics.areEqual(this.videoCoverUrl, bannerDataBean.videoCoverUrl);
    }

    @Nullable
    public final String getImageurl() {
        return this.imageurl;
    }

    @NotNull
    public final String getRealUrl() {
        String str;
        String str2 = this.videoCoverUrl;
        if (str2 == null || str2.length() == 0) {
            str = this.imageurl;
            if (str == null) {
                return "";
            }
        } else {
            str = this.videoCoverUrl;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Nullable
    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.imageurl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoCoverUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setImageurl(@Nullable String str) {
        this.imageurl = str;
    }

    public final void setVideoCoverUrl(@Nullable String str) {
        this.videoCoverUrl = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "BannerDataBean(imageurl=" + this.imageurl + ", videoUrl=" + this.videoUrl + ", videoCoverUrl=" + this.videoCoverUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.imageurl);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.videoCoverUrl);
    }

    public /* synthetic */ BannerDataBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
