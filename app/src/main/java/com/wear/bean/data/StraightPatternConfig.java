package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlConfigBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/wear/bean/data/StraightPatternConfig;", "", "a", "", "b", "D", "(FFF)V", "getD", "()F", "setD", "(F)V", "getA", "setA", "getB", "setB", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StraightPatternConfig {
    private float D;
    private float a;
    private float b;

    public StraightPatternConfig(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.D = f3;
    }

    public static /* synthetic */ StraightPatternConfig copy$default(StraightPatternConfig straightPatternConfig, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = straightPatternConfig.a;
        }
        if ((i & 2) != 0) {
            f2 = straightPatternConfig.b;
        }
        if ((i & 4) != 0) {
            f3 = straightPatternConfig.D;
        }
        return straightPatternConfig.copy(f, f2, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getA() {
        return this.a;
    }

    /* renamed from: component2, reason: from getter */
    public final float getB() {
        return this.b;
    }

    /* renamed from: component3, reason: from getter */
    public final float getD() {
        return this.D;
    }

    @NotNull
    public final StraightPatternConfig copy(float a, float b, float D) {
        return new StraightPatternConfig(a, b, D);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StraightPatternConfig)) {
            return false;
        }
        StraightPatternConfig straightPatternConfig = (StraightPatternConfig) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.a), (Object) Float.valueOf(straightPatternConfig.a)) && Intrinsics.areEqual((Object) Float.valueOf(this.b), (Object) Float.valueOf(straightPatternConfig.b)) && Intrinsics.areEqual((Object) Float.valueOf(this.D), (Object) Float.valueOf(straightPatternConfig.D));
    }

    public final float getA() {
        return this.a;
    }

    public final float getB() {
        return this.b;
    }

    public final float getD() {
        return this.D;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.D);
    }

    public final void setA(float f) {
        this.a = f;
    }

    public final void setB(float f) {
        this.b = f;
    }

    public final void setD(float f) {
        this.D = f;
    }

    @NotNull
    public String toString() {
        return "StraightPatternConfig(a=" + this.a + ", b=" + this.b + ", D=" + this.D + ')';
    }
}
