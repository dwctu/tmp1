package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FirebaseToyInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/wear/bean/FirebaseToyInfo;", "", "toyDeviceType", "", "battery", "", "isConnected", "", "isControl", "disConnectType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBattery", "()Ljava/lang/Integer;", "setBattery", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDisConnectType", "setDisConnectType", "()Ljava/lang/Boolean;", "setConnected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setControl", "getToyDeviceType", "()Ljava/lang/String;", "setToyDeviceType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/wear/bean/FirebaseToyInfo;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FirebaseToyInfo {

    @Nullable
    private Integer battery;

    @Nullable
    private Integer disConnectType;

    @Nullable
    private Boolean isConnected;

    @Nullable
    private Boolean isControl;

    @Nullable
    private String toyDeviceType;

    public FirebaseToyInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public FirebaseToyInfo(@Nullable String str, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num2) {
        this.toyDeviceType = str;
        this.battery = num;
        this.isConnected = bool;
        this.isControl = bool2;
        this.disConnectType = num2;
    }

    public static /* synthetic */ FirebaseToyInfo copy$default(FirebaseToyInfo firebaseToyInfo, String str, Integer num, Boolean bool, Boolean bool2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firebaseToyInfo.toyDeviceType;
        }
        if ((i & 2) != 0) {
            num = firebaseToyInfo.battery;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            bool = firebaseToyInfo.isConnected;
        }
        Boolean bool3 = bool;
        if ((i & 8) != 0) {
            bool2 = firebaseToyInfo.isControl;
        }
        Boolean bool4 = bool2;
        if ((i & 16) != 0) {
            num2 = firebaseToyInfo.disConnectType;
        }
        return firebaseToyInfo.copy(str, num3, bool3, bool4, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getToyDeviceType() {
        return this.toyDeviceType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getBattery() {
        return this.battery;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsConnected() {
        return this.isConnected;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getIsControl() {
        return this.isControl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getDisConnectType() {
        return this.disConnectType;
    }

    @NotNull
    public final FirebaseToyInfo copy(@Nullable String toyDeviceType, @Nullable Integer battery, @Nullable Boolean isConnected, @Nullable Boolean isControl, @Nullable Integer disConnectType) {
        return new FirebaseToyInfo(toyDeviceType, battery, isConnected, isControl, disConnectType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirebaseToyInfo)) {
            return false;
        }
        FirebaseToyInfo firebaseToyInfo = (FirebaseToyInfo) other;
        return Intrinsics.areEqual(this.toyDeviceType, firebaseToyInfo.toyDeviceType) && Intrinsics.areEqual(this.battery, firebaseToyInfo.battery) && Intrinsics.areEqual(this.isConnected, firebaseToyInfo.isConnected) && Intrinsics.areEqual(this.isControl, firebaseToyInfo.isControl) && Intrinsics.areEqual(this.disConnectType, firebaseToyInfo.disConnectType);
    }

    @Nullable
    public final Integer getBattery() {
        return this.battery;
    }

    @Nullable
    public final Integer getDisConnectType() {
        return this.disConnectType;
    }

    @Nullable
    public final String getToyDeviceType() {
        return this.toyDeviceType;
    }

    public int hashCode() {
        String str = this.toyDeviceType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.battery;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isConnected;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isControl;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num2 = this.disConnectType;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isConnected() {
        return this.isConnected;
    }

    @Nullable
    public final Boolean isControl() {
        return this.isControl;
    }

    public final void setBattery(@Nullable Integer num) {
        this.battery = num;
    }

    public final void setConnected(@Nullable Boolean bool) {
        this.isConnected = bool;
    }

    public final void setControl(@Nullable Boolean bool) {
        this.isControl = bool;
    }

    public final void setDisConnectType(@Nullable Integer num) {
        this.disConnectType = num;
    }

    public final void setToyDeviceType(@Nullable String str) {
        this.toyDeviceType = str;
    }

    @NotNull
    public String toString() {
        return "FirebaseToyInfo(toyDeviceType=" + this.toyDeviceType + ", battery=" + this.battery + ", isConnected=" + this.isConnected + ", isControl=" + this.isControl + ", disConnectType=" + this.disConnectType + ')';
    }

    public /* synthetic */ FirebaseToyInfo(String str, Integer num, Boolean bool, Boolean bool2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? Boolean.FALSE : bool2, (i & 16) != 0 ? 0 : num2);
    }
}
