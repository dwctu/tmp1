package com.wear.bean.data;

import dc.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyReportData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/wear/bean/data/ToyReportData;", "", "deviceType", "", "timestamp", "", "toyData", "(Ljava/lang/String;JLjava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getTimestamp", "()J", "getToyData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToyReportData {

    @NotNull
    private final String deviceType;
    private final long timestamp;

    @NotNull
    private final String toyData;

    public ToyReportData(@NotNull String deviceType, long j, @NotNull String toyData) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(toyData, "toyData");
        this.deviceType = deviceType;
        this.timestamp = j;
        this.toyData = toyData;
    }

    public static /* synthetic */ ToyReportData copy$default(ToyReportData toyReportData, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toyReportData.deviceType;
        }
        if ((i & 2) != 0) {
            j = toyReportData.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = toyReportData.toyData;
        }
        return toyReportData.copy(str, j, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getToyData() {
        return this.toyData;
    }

    @NotNull
    public final ToyReportData copy(@NotNull String deviceType, long timestamp, @NotNull String toyData) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(toyData, "toyData");
        return new ToyReportData(deviceType, timestamp, toyData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyReportData)) {
            return false;
        }
        ToyReportData toyReportData = (ToyReportData) other;
        return Intrinsics.areEqual(this.deviceType, toyReportData.deviceType) && this.timestamp == toyReportData.timestamp && Intrinsics.areEqual(this.toyData, toyReportData.toyData);
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getToyData() {
        return this.toyData;
    }

    public int hashCode() {
        return (((this.deviceType.hashCode() * 31) + g.a(this.timestamp)) * 31) + this.toyData.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToyReportData(deviceType=" + this.deviceType + ", timestamp=" + this.timestamp + ", toyData=" + this.toyData + ')';
    }
}
