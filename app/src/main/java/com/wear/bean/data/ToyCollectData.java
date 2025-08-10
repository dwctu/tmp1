package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCollectResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/data/ToyCollectData;", "", "XSecondTime", "", "needReport", "", "NCount", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getNCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getXSecondTime", "getNeedReport", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/wear/bean/data/ToyCollectData;", "equals", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToyCollectData {

    @Nullable
    private final Integer NCount;

    @Nullable
    private final Integer XSecondTime;

    @Nullable
    private final Boolean needReport;

    public ToyCollectData(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2) {
        this.XSecondTime = num;
        this.needReport = bool;
        this.NCount = num2;
    }

    public static /* synthetic */ ToyCollectData copy$default(ToyCollectData toyCollectData, Integer num, Boolean bool, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = toyCollectData.XSecondTime;
        }
        if ((i & 2) != 0) {
            bool = toyCollectData.needReport;
        }
        if ((i & 4) != 0) {
            num2 = toyCollectData.NCount;
        }
        return toyCollectData.copy(num, bool, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getXSecondTime() {
        return this.XSecondTime;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getNeedReport() {
        return this.needReport;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getNCount() {
        return this.NCount;
    }

    @NotNull
    public final ToyCollectData copy(@Nullable Integer XSecondTime, @Nullable Boolean needReport, @Nullable Integer NCount) {
        return new ToyCollectData(XSecondTime, needReport, NCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyCollectData)) {
            return false;
        }
        ToyCollectData toyCollectData = (ToyCollectData) other;
        return Intrinsics.areEqual(this.XSecondTime, toyCollectData.XSecondTime) && Intrinsics.areEqual(this.needReport, toyCollectData.needReport) && Intrinsics.areEqual(this.NCount, toyCollectData.NCount);
    }

    @Nullable
    public final Integer getNCount() {
        return this.NCount;
    }

    @Nullable
    public final Boolean getNeedReport() {
        return this.needReport;
    }

    @Nullable
    public final Integer getXSecondTime() {
        return this.XSecondTime;
    }

    public int hashCode() {
        Integer num = this.XSecondTime;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.needReport;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.NCount;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ToyCollectData(XSecondTime=" + this.XSecondTime + ", needReport=" + this.needReport + ", NCount=" + this.NCount + ')';
    }
}
