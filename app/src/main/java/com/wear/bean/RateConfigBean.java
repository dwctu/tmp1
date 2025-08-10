package com.wear.bean;

import dc.g;
import dc.of1;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateConfigBean.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/wear/bean/RateConfigBean;", "Ljava/io/Serializable;", "appAccountCode", "", "lastShowFeature", "lastShowVersion", "lastShowTime", "", "needShowDialog", "", "featureConfigs", "", "Lcom/wear/bean/FeatureConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/util/List;)V", "getAppAccountCode", "()Ljava/lang/String;", "getFeatureConfigs", "()Ljava/util/List;", "getLastShowFeature", "getLastShowTime", "()J", "getLastShowVersion", "getNeedShowDialog", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class RateConfigBean implements Serializable {

    @NotNull
    private final String appAccountCode;

    @NotNull
    private final List<FeatureConfig> featureConfigs;

    @NotNull
    private final String lastShowFeature;
    private final long lastShowTime;

    @NotNull
    private final String lastShowVersion;
    private final boolean needShowDialog;

    public RateConfigBean(@NotNull String appAccountCode, @NotNull String lastShowFeature, @NotNull String lastShowVersion, long j, boolean z, @NotNull List<FeatureConfig> featureConfigs) {
        Intrinsics.checkNotNullParameter(appAccountCode, "appAccountCode");
        Intrinsics.checkNotNullParameter(lastShowFeature, "lastShowFeature");
        Intrinsics.checkNotNullParameter(lastShowVersion, "lastShowVersion");
        Intrinsics.checkNotNullParameter(featureConfigs, "featureConfigs");
        this.appAccountCode = appAccountCode;
        this.lastShowFeature = lastShowFeature;
        this.lastShowVersion = lastShowVersion;
        this.lastShowTime = j;
        this.needShowDialog = z;
        this.featureConfigs = featureConfigs;
    }

    public static /* synthetic */ RateConfigBean copy$default(RateConfigBean rateConfigBean, String str, String str2, String str3, long j, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rateConfigBean.appAccountCode;
        }
        if ((i & 2) != 0) {
            str2 = rateConfigBean.lastShowFeature;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = rateConfigBean.lastShowVersion;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = rateConfigBean.lastShowTime;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            z = rateConfigBean.needShowDialog;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            list = rateConfigBean.featureConfigs;
        }
        return rateConfigBean.copy(str, str4, str5, j2, z2, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getLastShowFeature() {
        return this.lastShowFeature;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getLastShowVersion() {
        return this.lastShowVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLastShowTime() {
        return this.lastShowTime;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getNeedShowDialog() {
        return this.needShowDialog;
    }

    @NotNull
    public final List<FeatureConfig> component6() {
        return this.featureConfigs;
    }

    @NotNull
    public final RateConfigBean copy(@NotNull String appAccountCode, @NotNull String lastShowFeature, @NotNull String lastShowVersion, long lastShowTime, boolean needShowDialog, @NotNull List<FeatureConfig> featureConfigs) {
        Intrinsics.checkNotNullParameter(appAccountCode, "appAccountCode");
        Intrinsics.checkNotNullParameter(lastShowFeature, "lastShowFeature");
        Intrinsics.checkNotNullParameter(lastShowVersion, "lastShowVersion");
        Intrinsics.checkNotNullParameter(featureConfigs, "featureConfigs");
        return new RateConfigBean(appAccountCode, lastShowFeature, lastShowVersion, lastShowTime, needShowDialog, featureConfigs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateConfigBean)) {
            return false;
        }
        RateConfigBean rateConfigBean = (RateConfigBean) other;
        return Intrinsics.areEqual(this.appAccountCode, rateConfigBean.appAccountCode) && Intrinsics.areEqual(this.lastShowFeature, rateConfigBean.lastShowFeature) && Intrinsics.areEqual(this.lastShowVersion, rateConfigBean.lastShowVersion) && this.lastShowTime == rateConfigBean.lastShowTime && this.needShowDialog == rateConfigBean.needShowDialog && Intrinsics.areEqual(this.featureConfigs, rateConfigBean.featureConfigs);
    }

    @NotNull
    public final String getAppAccountCode() {
        return this.appAccountCode;
    }

    @NotNull
    public final List<FeatureConfig> getFeatureConfigs() {
        return this.featureConfigs;
    }

    @NotNull
    public final String getLastShowFeature() {
        return this.lastShowFeature;
    }

    public final long getLastShowTime() {
        return this.lastShowTime;
    }

    @NotNull
    public final String getLastShowVersion() {
        return this.lastShowVersion;
    }

    public final boolean getNeedShowDialog() {
        return this.needShowDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((this.appAccountCode.hashCode() * 31) + this.lastShowFeature.hashCode()) * 31) + this.lastShowVersion.hashCode()) * 31) + g.a(this.lastShowTime)) * 31;
        boolean z = this.needShowDialog;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((iHashCode + i) * 31) + this.featureConfigs.hashCode();
    }

    @NotNull
    public String toString() {
        return "RateConfigBean(appAccountCode=" + this.appAccountCode + ", lastShowFeature=" + this.lastShowFeature + ", lastShowVersion=" + this.lastShowVersion + ", lastShowTime=" + this.lastShowTime + ", needShowDialog=" + this.needShowDialog + ", featureConfigs=" + this.featureConfigs + ')';
    }
}
