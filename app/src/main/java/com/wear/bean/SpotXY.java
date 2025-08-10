package com.wear.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.widget.control.FingImageLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpotXY.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/wear/bean/SpotXY;", "", FirebaseAnalytics.Param.INDEX, "", "x", "", FingImageLayout.ObjectAnimatorY, "i", "(IFFF)V", "getI", "()F", "setI", "(F)V", "getIndex", "()I", "setIndex", "(I)V", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpotXY {
    private float i;
    private int index;
    private float x;
    private float y;

    public SpotXY(int i, float f, float f2, float f3) {
        this.index = i;
        this.x = f;
        this.y = f2;
        this.i = f3;
    }

    public static /* synthetic */ SpotXY copy$default(SpotXY spotXY, int i, float f, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = spotXY.index;
        }
        if ((i2 & 2) != 0) {
            f = spotXY.x;
        }
        if ((i2 & 4) != 0) {
            f2 = spotXY.y;
        }
        if ((i2 & 8) != 0) {
            f3 = spotXY.i;
        }
        return spotXY.copy(i, f, f2, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component3, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: component4, reason: from getter */
    public final float getI() {
        return this.i;
    }

    @NotNull
    public final SpotXY copy(int index, float x, float y, float i) {
        return new SpotXY(index, x, y, i);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpotXY)) {
            return false;
        }
        SpotXY spotXY = (SpotXY) other;
        return this.index == spotXY.index && Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(spotXY.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(spotXY.y)) && Intrinsics.areEqual((Object) Float.valueOf(this.i), (Object) Float.valueOf(spotXY.i));
    }

    public final float getI() {
        return this.i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (((((this.index * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.i);
    }

    public final void setI(float f) {
        this.i = f;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }

    @NotNull
    public String toString() {
        return "SpotXY(index=" + this.index + ", x=" + this.x + ", y=" + this.y + ", i=" + this.i + ')';
    }
}
