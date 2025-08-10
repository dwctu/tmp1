package com.component.dxtoy.data.bean;

import dc.g;
import dc.nb0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OuterToyData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J}\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0006\u0010.\u001a\u00020/R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017¨\u00060"}, d2 = {"Lcom/component/dxtoy/data/bean/OuterToyData;", "", "rmId", "", "uuid", "version", "", "mac", "deviceType", "isVirtualToy", "", "isSelect", "isLedOpen", "ledColor", "updateTime", "", "formApp", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZZIJLjava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getFormApp", "()Z", "getLedColor", "()I", "getMac", "getRmId", "getUpdateTime", "()J", "getUuid", "getVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "toToyInfo", "Lcom/component/dxtoy/core/toy/ToyInfo;", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OuterToyData {

    @Nullable
    private final String deviceType;

    @Nullable
    private final String formApp;
    private final boolean isLedOpen;
    private final boolean isSelect;
    private final boolean isVirtualToy;
    private final int ledColor;

    @NotNull
    private final String mac;

    @Nullable
    private final String rmId;
    private final long updateTime;

    @NotNull
    private final String uuid;
    private final int version;

    public OuterToyData(@Nullable String str, @NotNull String uuid, int i, @NotNull String mac, @Nullable String str2, boolean z, boolean z2, boolean z3, int i2, long j, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.rmId = str;
        this.uuid = uuid;
        this.version = i;
        this.mac = mac;
        this.deviceType = str2;
        this.isVirtualToy = z;
        this.isSelect = z2;
        this.isLedOpen = z3;
        this.ledColor = i2;
        this.updateTime = j;
        this.formApp = str3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getRmId() {
        return this.rmId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getFormApp() {
        return this.formApp;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsVirtualToy() {
        return this.isVirtualToy;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsLedOpen() {
        return this.isLedOpen;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLedColor() {
        return this.ledColor;
    }

    @NotNull
    public final OuterToyData copy(@Nullable String rmId, @NotNull String uuid, int version, @NotNull String mac, @Nullable String deviceType, boolean isVirtualToy, boolean isSelect, boolean isLedOpen, int ledColor, long updateTime, @Nullable String formApp) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new OuterToyData(rmId, uuid, version, mac, deviceType, isVirtualToy, isSelect, isLedOpen, ledColor, updateTime, formApp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OuterToyData)) {
            return false;
        }
        OuterToyData outerToyData = (OuterToyData) other;
        return Intrinsics.areEqual(this.rmId, outerToyData.rmId) && Intrinsics.areEqual(this.uuid, outerToyData.uuid) && this.version == outerToyData.version && Intrinsics.areEqual(this.mac, outerToyData.mac) && Intrinsics.areEqual(this.deviceType, outerToyData.deviceType) && this.isVirtualToy == outerToyData.isVirtualToy && this.isSelect == outerToyData.isSelect && this.isLedOpen == outerToyData.isLedOpen && this.ledColor == outerToyData.ledColor && this.updateTime == outerToyData.updateTime && Intrinsics.areEqual(this.formApp, outerToyData.formApp);
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getFormApp() {
        return this.formApp;
    }

    public final int getLedColor() {
        return this.ledColor;
    }

    @NotNull
    public final String getMac() {
        return this.mac;
    }

    @Nullable
    public final String getRmId() {
        return this.rmId;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public final int getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.rmId;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.uuid.hashCode()) * 31) + this.version) * 31) + this.mac.hashCode()) * 31;
        String str2 = this.deviceType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isVirtualToy;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z2 = this.isSelect;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.isLedOpen;
        int iA = (((((i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.ledColor) * 31) + g.a(this.updateTime)) * 31;
        String str3 = this.formApp;
        return iA + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isLedOpen() {
        return this.isLedOpen;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final boolean isVirtualToy() {
        return this.isVirtualToy;
    }

    @NotNull
    public String toString() {
        return "OuterToyData(rmId=" + this.rmId + ", uuid=" + this.uuid + ", version=" + this.version + ", mac=" + this.mac + ", deviceType=" + this.deviceType + ", isVirtualToy=" + this.isVirtualToy + ", isSelect=" + this.isSelect + ", isLedOpen=" + this.isLedOpen + ", ledColor=" + this.ledColor + ", updateTime=" + this.updateTime + ", formApp=" + this.formApp + ')';
    }

    @NotNull
    public final nb0 toToyInfo() {
        nb0 nb0Var = new nb0();
        nb0Var.d0(this.rmId);
        nb0Var.w(this.uuid);
        nb0Var.x(this.version);
        nb0Var.q(this.mac);
        nb0Var.p(this.deviceType);
        nb0Var.z(this.isVirtualToy);
        nb0Var.r(this.isSelect);
        nb0Var.g0(true);
        nb0Var.X(this.isLedOpen);
        nb0Var.W(this.ledColor);
        nb0Var.h0(this.updateTime);
        nb0Var.U(this.formApp);
        return nb0Var;
    }

    public /* synthetic */ OuterToyData(String str, String str2, int i, String str3, String str4, boolean z, boolean z2, boolean z3, int i2, long j, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, str4, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? true : z3, (i3 & 256) != 0 ? 7 : i2, (i3 & 512) != 0 ? 0L : j, (i3 & 1024) != 0 ? null : str5);
    }
}
