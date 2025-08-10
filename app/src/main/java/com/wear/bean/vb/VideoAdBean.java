package com.wear.bean.vb;

import dc.tq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/vb/VideoAdBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "adType", "", "(I)V", "getAdType", "()I", "itemType", "getItemType", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VideoAdBean implements tq {
    public static final int AD_TYPE_BOTTOM = 3;
    public static final int AD_TYPE_MIDDLE_DOWNLOAD = 2;
    public static final int AD_TYPE_NO_MORE = 4;
    public static final int AD_TYPE_TOP = 1;
    private final int adType;

    public VideoAdBean(int i) {
        this.adType = i;
    }

    public static /* synthetic */ VideoAdBean copy$default(VideoAdBean videoAdBean, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoAdBean.adType;
        }
        return videoAdBean.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdType() {
        return this.adType;
    }

    @NotNull
    public final VideoAdBean copy(int adType) {
        return new VideoAdBean(adType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VideoAdBean) && this.adType == ((VideoAdBean) other).adType;
    }

    public final int getAdType() {
        return this.adType;
    }

    @Override // dc.tq
    public int getItemType() {
        return 2;
    }

    public int hashCode() {
        return this.adType;
    }

    @NotNull
    public String toString() {
        return "VideoAdBean(adType=" + this.adType + ')';
    }
}
