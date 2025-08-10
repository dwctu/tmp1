package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PointData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/wear/bean/data/PointData;", "", "radiusPath", "", "defaultPath", "radius", "degrees", "", "alpha", "color", "(FFFIFI)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColor", "()I", "getDefaultPath", "getDegrees", "getRadius", "getRadiusPath", "setRadiusPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PointData {
    private float alpha;
    private final int color;
    private final float defaultPath;
    private final int degrees;
    private final float radius;
    private float radiusPath;

    public PointData(float f, float f2, float f3, int i, float f4, int i2) {
        this.radiusPath = f;
        this.defaultPath = f2;
        this.radius = f3;
        this.degrees = i;
        this.alpha = f4;
        this.color = i2;
    }

    public static /* synthetic */ PointData copy$default(PointData pointData, float f, float f2, float f3, int i, float f4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f = pointData.radiusPath;
        }
        if ((i3 & 2) != 0) {
            f2 = pointData.defaultPath;
        }
        float f5 = f2;
        if ((i3 & 4) != 0) {
            f3 = pointData.radius;
        }
        float f6 = f3;
        if ((i3 & 8) != 0) {
            i = pointData.degrees;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            f4 = pointData.alpha;
        }
        float f7 = f4;
        if ((i3 & 32) != 0) {
            i2 = pointData.color;
        }
        return pointData.copy(f, f5, f6, i4, f7, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getRadiusPath() {
        return this.radiusPath;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDefaultPath() {
        return this.defaultPath;
    }

    /* renamed from: component3, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDegrees() {
        return this.degrees;
    }

    /* renamed from: component5, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: component6, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final PointData copy(float radiusPath, float defaultPath, float radius, int degrees, float alpha, int color) {
        return new PointData(radiusPath, defaultPath, radius, degrees, alpha, color);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointData)) {
            return false;
        }
        PointData pointData = (PointData) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.radiusPath), (Object) Float.valueOf(pointData.radiusPath)) && Intrinsics.areEqual((Object) Float.valueOf(this.defaultPath), (Object) Float.valueOf(pointData.defaultPath)) && Intrinsics.areEqual((Object) Float.valueOf(this.radius), (Object) Float.valueOf(pointData.radius)) && this.degrees == pointData.degrees && Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(pointData.alpha)) && this.color == pointData.color;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getDefaultPath() {
        return this.defaultPath;
    }

    public final int getDegrees() {
        return this.degrees;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getRadiusPath() {
        return this.radiusPath;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.radiusPath) * 31) + Float.floatToIntBits(this.defaultPath)) * 31) + Float.floatToIntBits(this.radius)) * 31) + this.degrees) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.color;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setRadiusPath(float f) {
        this.radiusPath = f;
    }

    @NotNull
    public String toString() {
        return "PointData(radiusPath=" + this.radiusPath + ", defaultPath=" + this.defaultPath + ", radius=" + this.radius + ", degrees=" + this.degrees + ", alpha=" + this.alpha + ", color=" + this.color + ')';
    }
}
