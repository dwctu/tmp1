package com.wear.bean;

import dc.g;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateConfigBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/RateInfoBean;", "", "operationTime", "", "dialogFeature", "", "rateApp", "", "(JLjava/lang/String;Z)V", "getDialogFeature", "()Ljava/lang/String;", "getOperationTime", "()J", "setOperationTime", "(J)V", "getRateApp", "()Z", "setRateApp", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class RateInfoBean {

    @NotNull
    private final String dialogFeature;
    private long operationTime;
    private boolean rateApp;

    public RateInfoBean(long j, @NotNull String dialogFeature, boolean z) {
        Intrinsics.checkNotNullParameter(dialogFeature, "dialogFeature");
        this.operationTime = j;
        this.dialogFeature = dialogFeature;
        this.rateApp = z;
    }

    public static /* synthetic */ RateInfoBean copy$default(RateInfoBean rateInfoBean, long j, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = rateInfoBean.operationTime;
        }
        if ((i & 2) != 0) {
            str = rateInfoBean.dialogFeature;
        }
        if ((i & 4) != 0) {
            z = rateInfoBean.rateApp;
        }
        return rateInfoBean.copy(j, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getOperationTime() {
        return this.operationTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDialogFeature() {
        return this.dialogFeature;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRateApp() {
        return this.rateApp;
    }

    @NotNull
    public final RateInfoBean copy(long operationTime, @NotNull String dialogFeature, boolean rateApp) {
        Intrinsics.checkNotNullParameter(dialogFeature, "dialogFeature");
        return new RateInfoBean(operationTime, dialogFeature, rateApp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateInfoBean)) {
            return false;
        }
        RateInfoBean rateInfoBean = (RateInfoBean) other;
        return this.operationTime == rateInfoBean.operationTime && Intrinsics.areEqual(this.dialogFeature, rateInfoBean.dialogFeature) && this.rateApp == rateInfoBean.rateApp;
    }

    @NotNull
    public final String getDialogFeature() {
        return this.dialogFeature;
    }

    public final long getOperationTime() {
        return this.operationTime;
    }

    public final boolean getRateApp() {
        return this.rateApp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = ((g.a(this.operationTime) * 31) + this.dialogFeature.hashCode()) * 31;
        boolean z = this.rateApp;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iA + i;
    }

    public final void setOperationTime(long j) {
        this.operationTime = j;
    }

    public final void setRateApp(boolean z) {
        this.rateApp = z;
    }

    @NotNull
    public String toString() {
        return "RateInfoBean(operationTime=" + this.operationTime + ", dialogFeature=" + this.dialogFeature + ", rateApp=" + this.rateApp + ')';
    }
}
