package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.p._a;

/* compiled from: ResultPoint.java */
/* loaded from: classes3.dex */
public class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new y();
    private final float a;
    private final float b;
    private int c;
    private boolean d;

    public z(float f, float f2, int i) {
        this.c = 0;
        this.d = false;
        this.a = f;
        this.b = f2;
        this.c = i;
    }

    private static int[] a(float f, float f2, float f3) {
        int i;
        int i2;
        int i3;
        if (f < f2 || f < f3) {
            if (f3 >= f && f3 >= f2) {
                i = 1;
                if (f > f2) {
                    i2 = 0;
                    i3 = 2;
                } else {
                    i2 = 2;
                }
            } else if (f > f) {
                i = 2;
                i2 = 0;
                i3 = 1;
            } else {
                i = 2;
                i2 = 1;
            }
            i3 = 0;
        } else if (f2 > f3) {
            i = 0;
            i2 = 2;
            i3 = 1;
        } else {
            i = 0;
            i2 = 1;
            i3 = 2;
        }
        return new int[]{i, i2, i3};
    }

    public int a() {
        return this.c;
    }

    public final float b() {
        return this.a;
    }

    public final float c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return ((double) Math.abs(this.a - zVar.a)) < 1.0E-4d && ((double) Math.abs(this.b - zVar.b)) < 1.0E-4d;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
    }

    public static void a(z[] zVarArr) {
        float fA = a(zVarArr[0], zVarArr[1]);
        float fA2 = a(zVarArr[1], zVarArr[2]);
        float fA3 = a(zVarArr[0], zVarArr[2]);
        int[] iArrA = a(fA2, fA, fA3);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int i3 = iArrA[2];
        z zVar = zVarArr[i];
        z zVar2 = zVarArr[i2];
        z zVar3 = zVarArr[i3];
        float[] fArr = {fA2, fA3, fA};
        if (_a.f % 2 == 0 && fArr[i2] / fArr[i] < 1.1d) {
            zVar = zVarArr[i];
            zVar2 = zVarArr[i2];
            zVar3 = zVarArr[i3];
        }
        if (a(zVar2, zVar, zVar3) < 0.0f) {
            z zVar4 = zVar3;
            zVar3 = zVar2;
            zVar2 = zVar4;
        }
        zVarArr[0] = zVar2;
        zVarArr[1] = zVar;
        zVarArr[2] = zVar3;
    }

    public z(float f, float f2) {
        this.c = 0;
        this.d = false;
        this.a = f;
        this.b = f2;
    }

    public z(float f, float f2, boolean z) {
        this.c = 0;
        this.d = false;
        this.a = f;
        this.b = f2;
        this.d = z;
    }

    public z(Parcel parcel) {
        this.c = 0;
        this.d = false;
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
    }

    public static float a(z zVar, z zVar2) {
        return n.a(zVar.a, zVar.b, zVar2.a, zVar2.b);
    }

    private static float a(z zVar, z zVar2, z zVar3) {
        float f = zVar2.a;
        float f2 = zVar2.b;
        return ((zVar3.a - f) * (zVar.b - f2)) - ((zVar3.b - f2) * (zVar.a - f));
    }
}
