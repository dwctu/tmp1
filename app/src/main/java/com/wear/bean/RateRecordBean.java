package com.wear.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateConfigBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/RateRecordBean;", "", "rateFeature", "Lcom/wear/bean/RateFeature;", TypedValues.TransitionType.S_DURATION, "", "(Lcom/wear/bean/RateFeature;I)V", "getDuration", "()I", "setDuration", "(I)V", "getRateFeature", "()Lcom/wear/bean/RateFeature;", "setRateFeature", "(Lcom/wear/bean/RateFeature;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RateRecordBean {
    private int duration;

    @NotNull
    private RateFeature rateFeature;

    public RateRecordBean(@NotNull RateFeature rateFeature, int i) {
        Intrinsics.checkNotNullParameter(rateFeature, "rateFeature");
        this.rateFeature = rateFeature;
        this.duration = i;
    }

    public static /* synthetic */ RateRecordBean copy$default(RateRecordBean rateRecordBean, RateFeature rateFeature, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            rateFeature = rateRecordBean.rateFeature;
        }
        if ((i2 & 2) != 0) {
            i = rateRecordBean.duration;
        }
        return rateRecordBean.copy(rateFeature, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final RateFeature getRateFeature() {
        return this.rateFeature;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final RateRecordBean copy(@NotNull RateFeature rateFeature, int duration) {
        Intrinsics.checkNotNullParameter(rateFeature, "rateFeature");
        return new RateRecordBean(rateFeature, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateRecordBean)) {
            return false;
        }
        RateRecordBean rateRecordBean = (RateRecordBean) other;
        return this.rateFeature == rateRecordBean.rateFeature && this.duration == rateRecordBean.duration;
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final RateFeature getRateFeature() {
        return this.rateFeature;
    }

    public int hashCode() {
        return (this.rateFeature.hashCode() * 31) + this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setRateFeature(@NotNull RateFeature rateFeature) {
        Intrinsics.checkNotNullParameter(rateFeature, "<set-?>");
        this.rateFeature = rateFeature;
    }

    @NotNull
    public String toString() {
        return "RateRecordBean(rateFeature=" + this.rateFeature + ", duration=" + this.duration + ')';
    }
}
