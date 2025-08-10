package com.wear.bean;

import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteBan.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/RouletteBan;", "", "ban", "", "endTime", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getBan", "()Ljava/lang/Boolean;", "setBan", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/wear/bean/RouletteBan;", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class RouletteBan {

    @Nullable
    private Boolean ban;

    @Nullable
    private Long endTime;

    public RouletteBan() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RouletteBan(@Nullable Boolean bool, @Nullable Long l) {
        this.ban = bool;
        this.endTime = l;
    }

    public static /* synthetic */ RouletteBan copy$default(RouletteBan rouletteBan, Boolean bool, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = rouletteBan.ban;
        }
        if ((i & 2) != 0) {
            l = rouletteBan.endTime;
        }
        return rouletteBan.copy(bool, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getBan() {
        return this.ban;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final RouletteBan copy(@Nullable Boolean ban, @Nullable Long endTime) {
        return new RouletteBan(ban, endTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouletteBan)) {
            return false;
        }
        RouletteBan rouletteBan = (RouletteBan) other;
        return Intrinsics.areEqual(this.ban, rouletteBan.ban) && Intrinsics.areEqual(this.endTime, rouletteBan.endTime);
    }

    @Nullable
    public final Boolean getBan() {
        return this.ban;
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    public int hashCode() {
        Boolean bool = this.ban;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.endTime;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public final void setBan(@Nullable Boolean bool) {
        this.ban = bool;
    }

    public final void setEndTime(@Nullable Long l) {
        this.endTime = l;
    }

    @NotNull
    public String toString() {
        return "RouletteBan(ban=" + this.ban + ", endTime=" + this.endTime + ')';
    }

    public /* synthetic */ RouletteBan(Boolean bool, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? 0L : l);
    }
}
