package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: RouletteBan.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/RouletteLimit;", "", StreamManagement.Enable.ELEMENT, "", "(Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/wear/bean/RouletteLimit;", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RouletteLimit {

    @Nullable
    private final Boolean enable;

    public RouletteLimit() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RouletteLimit(@Nullable Boolean bool) {
        this.enable = bool;
    }

    public static /* synthetic */ RouletteLimit copy$default(RouletteLimit rouletteLimit, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = rouletteLimit.enable;
        }
        return rouletteLimit.copy(bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final RouletteLimit copy(@Nullable Boolean enable) {
        return new RouletteLimit(enable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RouletteLimit) && Intrinsics.areEqual(this.enable, ((RouletteLimit) other).enable);
    }

    @Nullable
    public final Boolean getEnable() {
        return this.enable;
    }

    public int hashCode() {
        Boolean bool = this.enable;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        return "RouletteLimit(enable=" + this.enable + ')';
    }

    public /* synthetic */ RouletteLimit(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool);
    }
}
