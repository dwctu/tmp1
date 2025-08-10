package com.wear.bean.vb;

import dc.tq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/wear/bean/vb/VbPatternAdBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "adType", "", "(I)V", "getAdType", "()I", "itemType", "getItemType", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VbPatternAdBean implements tq {
    private final int adType;

    public VbPatternAdBean(int i) {
        this.adType = i;
    }

    public static /* synthetic */ VbPatternAdBean copy$default(VbPatternAdBean vbPatternAdBean, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vbPatternAdBean.adType;
        }
        return vbPatternAdBean.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAdType() {
        return this.adType;
    }

    @NotNull
    public final VbPatternAdBean copy(int adType) {
        return new VbPatternAdBean(adType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VbPatternAdBean) && this.adType == ((VbPatternAdBean) other).adType;
    }

    public final int getAdType() {
        return this.adType;
    }

    @Override // dc.tq
    public int getItemType() {
        return 4;
    }

    public int hashCode() {
        return this.adType;
    }

    @NotNull
    public String toString() {
        return "VbPatternAdBean(adType=" + this.adType + ')';
    }
}
