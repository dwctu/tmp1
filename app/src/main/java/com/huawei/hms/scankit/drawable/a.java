package com.huawei.hms.scankit.drawable;

import android.view.animation.Interpolator;
import java.math.BigDecimal;

/* compiled from: CubicBezierInterpolator.java */
/* loaded from: classes3.dex */
public class a implements Interpolator {
    private static final BigDecimal a;
    private static final BigDecimal b;
    private static final float c;
    private float d;
    private float e;
    private float f;
    private float g;

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        a = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(4000L));
        b = bigDecimal2;
        c = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    public a(float f, float f2, float f3, float f4) {
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
    }

    private long a(float f) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            float fB = b(c * j3);
            if (fB < f) {
                j = j3 + 1;
            } else {
                if (fB <= f) {
                    return j3;
                }
                j2 = j3 - 1;
            }
        }
        return j;
    }

    private float b(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.d) + (f3 * f * f * this.f) + (f * f * f);
    }

    private float c(float f) {
        float f2 = 1.0f - f;
        float f3 = 3.0f * f2;
        return (f2 * f3 * f * this.e) + (f3 * f * f * this.g) + (f * f * f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return c(c * a(f));
    }

    public String toString() {
        return a();
    }

    private String a() {
        return "CubicBezierInterpolator  mControlPoint1x = " + this.d + ", mControlPoint1y = " + this.e + ", mControlPoint2x = " + this.f + ", mControlPoint2y = " + this.g;
    }
}
