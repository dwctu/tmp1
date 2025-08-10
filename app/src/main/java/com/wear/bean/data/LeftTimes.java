package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LeftTimesResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/data/LeftTimes;", "", "leftTimes", "", "(Ljava/lang/Integer;)V", "getLeftTimes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/wear/bean/data/LeftTimes;", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LeftTimes {

    @Nullable
    private final Integer leftTimes;

    public LeftTimes() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LeftTimes(@Nullable Integer num) {
        this.leftTimes = num;
    }

    public static /* synthetic */ LeftTimes copy$default(LeftTimes leftTimes, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = leftTimes.leftTimes;
        }
        return leftTimes.copy(num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @NotNull
    public final LeftTimes copy(@Nullable Integer leftTimes) {
        return new LeftTimes(leftTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LeftTimes) && Intrinsics.areEqual(this.leftTimes, ((LeftTimes) other).leftTimes);
    }

    @Nullable
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    public int hashCode() {
        Integer num = this.leftTimes;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "LeftTimes(leftTimes=" + this.leftTimes + ')';
    }

    public /* synthetic */ LeftTimes(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 10 : num);
    }
}
