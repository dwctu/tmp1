package com.wear.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import dc.g;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateConfigBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/wear/bean/FeatureConfig;", "", "feature", "", TypedValues.TransitionType.S_DURATION, "", "ratingEnable", "", "(Ljava/lang/String;JZ)V", "getDuration", "()J", "getFeature", "()Ljava/lang/String;", "getRatingEnable", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class FeatureConfig {
    private final long duration;

    @NotNull
    private final String feature;
    private final boolean ratingEnable;

    public FeatureConfig(@NotNull String feature, long j, boolean z) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        this.feature = feature;
        this.duration = j;
        this.ratingEnable = z;
    }

    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig featureConfig, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = featureConfig.feature;
        }
        if ((i & 2) != 0) {
            j = featureConfig.duration;
        }
        if ((i & 4) != 0) {
            z = featureConfig.ratingEnable;
        }
        return featureConfig.copy(str, j, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFeature() {
        return this.feature;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRatingEnable() {
        return this.ratingEnable;
    }

    @NotNull
    public final FeatureConfig copy(@NotNull String feature, long duration, boolean ratingEnable) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return new FeatureConfig(feature, duration, ratingEnable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureConfig)) {
            return false;
        }
        FeatureConfig featureConfig = (FeatureConfig) other;
        return Intrinsics.areEqual(this.feature, featureConfig.feature) && this.duration == featureConfig.duration && this.ratingEnable == featureConfig.ratingEnable;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getFeature() {
        return this.feature;
    }

    public final boolean getRatingEnable() {
        return this.ratingEnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.feature.hashCode() * 31) + g.a(this.duration)) * 31;
        boolean z = this.ratingEnable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @NotNull
    public String toString() {
        return "FeatureConfig(feature=" + this.feature + ", duration=" + this.duration + ", ratingEnable=" + this.ratingEnable + ')';
    }
}
