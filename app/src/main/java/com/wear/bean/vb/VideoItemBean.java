package com.wear.bean.vb;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoItemBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/wear/bean/vb/VideoItemBean;", "", "patternUrl", "", "videoUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getPatternUrl", "()Ljava/lang/String;", "setPatternUrl", "(Ljava/lang/String;)V", "getVideoUrl", "setVideoUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "noEmpty", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VideoItemBean {

    @Nullable
    private String patternUrl;

    @Nullable
    private String videoUrl;

    public VideoItemBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public VideoItemBean(@Nullable String str, @Nullable String str2) {
        this.patternUrl = str;
        this.videoUrl = str2;
    }

    public static /* synthetic */ VideoItemBean copy$default(VideoItemBean videoItemBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoItemBean.patternUrl;
        }
        if ((i & 2) != 0) {
            str2 = videoItemBean.videoUrl;
        }
        return videoItemBean.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @NotNull
    public final VideoItemBean copy(@Nullable String patternUrl, @Nullable String videoUrl) {
        return new VideoItemBean(patternUrl, videoUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoItemBean)) {
            return false;
        }
        VideoItemBean videoItemBean = (VideoItemBean) other;
        return Intrinsics.areEqual(this.patternUrl, videoItemBean.patternUrl) && Intrinsics.areEqual(this.videoUrl, videoItemBean.videoUrl);
    }

    @Nullable
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.patternUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean noEmpty() {
        return (this.patternUrl == null || this.videoUrl == null) ? false : true;
    }

    public final void setPatternUrl(@Nullable String str) {
        this.patternUrl = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "VideoItemBean(patternUrl=" + this.patternUrl + ", videoUrl=" + this.videoUrl + ')';
    }

    public /* synthetic */ VideoItemBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
