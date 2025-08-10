package com.wear.bean.official;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/wear/bean/official/OfficialVideoInfo;", "", "videoUrl", "", "videoCoverUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getVideoCoverUrl", "()Ljava/lang/String;", "setVideoCoverUrl", "(Ljava/lang/String;)V", "getVideoUrl", "setVideoUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialVideoInfo {

    @Nullable
    private String videoCoverUrl;

    @Nullable
    private String videoUrl;

    public OfficialVideoInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public OfficialVideoInfo(@Nullable String str, @Nullable String str2) {
        this.videoUrl = str;
        this.videoCoverUrl = str2;
    }

    public static /* synthetic */ OfficialVideoInfo copy$default(OfficialVideoInfo officialVideoInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = officialVideoInfo.videoUrl;
        }
        if ((i & 2) != 0) {
            str2 = officialVideoInfo.videoCoverUrl;
        }
        return officialVideoInfo.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    @NotNull
    public final OfficialVideoInfo copy(@Nullable String videoUrl, @Nullable String videoCoverUrl) {
        return new OfficialVideoInfo(videoUrl, videoCoverUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialVideoInfo)) {
            return false;
        }
        OfficialVideoInfo officialVideoInfo = (OfficialVideoInfo) other;
        return Intrinsics.areEqual(this.videoUrl, officialVideoInfo.videoUrl) && Intrinsics.areEqual(this.videoCoverUrl, officialVideoInfo.videoCoverUrl);
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
        String str = this.videoUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoCoverUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setVideoCoverUrl(@Nullable String str) {
        this.videoCoverUrl = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "OfficialVideoInfo(videoUrl=" + this.videoUrl + ", videoCoverUrl=" + this.videoCoverUrl + ')';
    }

    public /* synthetic */ OfficialVideoInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
