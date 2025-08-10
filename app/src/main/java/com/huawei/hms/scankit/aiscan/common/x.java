package com.huawei.hms.scankit.aiscan.common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.p.L;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Result.java */
/* loaded from: classes3.dex */
public final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new w();
    private final String a;
    private final byte[] b;
    private final int c;
    private z[] d;
    private BarcodeFormat e;
    private final long f;
    private boolean g;
    private final boolean h;
    private final float i;
    private int j;
    private List<Rect> k;
    private boolean l;
    private int m;
    private List<Rect> n;

    public x(float f) {
        this.g = false;
        this.i = f;
        this.a = null;
        this.b = new byte[0];
        this.c = 0;
        this.d = new z[0];
        this.e = BarcodeFormat.NONE;
        this.f = 0L;
        this.h = false;
        this.j = 0;
        this.l = false;
        this.m = 0;
        this.k = new ArrayList();
        this.n = new ArrayList();
    }

    public void a(float f) {
        if (f < 50.0f) {
            this.j = 2;
            return;
        }
        if (f < 90.0f) {
            this.j = 1;
            return;
        }
        if (f < 140.0f) {
            this.j = 0;
        } else if (f < 190.0f) {
            this.j = -1;
        } else if (f <= 255.0f) {
            this.j = -2;
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public List<Rect> c() {
        return this.k;
    }

    public int d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Rect> e() {
        return this.n;
    }

    public int f() {
        return this.m;
    }

    public byte[] g() {
        return this.b;
    }

    public z[] h() {
        return this.d;
    }

    public String i() {
        return this.a;
    }

    public float j() {
        return this.i;
    }

    public boolean k() {
        return this.l;
    }

    public String toString() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeFloat(this.i);
        parcel.writeInt(this.j);
        parcel.writeList(this.k);
    }

    public void b(float f) {
        if (f < 50.0f) {
            this.m = 2;
            return;
        }
        if (f < 90.0f) {
            this.m = 1;
            return;
        }
        if (f < 140.0f) {
            this.m = 0;
        } else if (f < 190.0f) {
            this.m = -1;
        } else if (f <= 255.0f) {
            this.m = -2;
        }
    }

    public void a(L l) {
        int iD = (int) l.d();
        int iE = (int) l.e();
        this.k.add(new Rect(iD, iE, ((int) l.f()) + iD, ((int) l.c()) + iE));
    }

    public void b(L l) {
        int iD = (int) l.d();
        int iE = (int) l.e();
        this.n.add(new Rect(iD, iE, ((int) l.f()) + iD, ((int) l.c()) + iE));
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void a(int i) {
        this.m = i;
    }

    public BarcodeFormat b() {
        return this.e;
    }

    public void a(z[] zVarArr) {
        z[] zVarArr2 = this.d;
        if (zVarArr2 == null) {
            this.d = zVarArr;
            return;
        }
        if (zVarArr == null || zVarArr.length <= 0) {
            return;
        }
        z[] zVarArr3 = new z[zVarArr2.length + zVarArr.length];
        System.arraycopy(zVarArr2, 0, zVarArr3, 0, zVarArr2.length);
        System.arraycopy(zVarArr, 0, zVarArr3, zVarArr2.length, zVarArr.length);
        this.d = zVarArr3;
    }

    public void b(z[] zVarArr) {
        this.d = zVarArr;
    }

    public x(String str, byte[] bArr, z[] zVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, zVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public x(String str, byte[] bArr, z[] zVarArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, zVarArr, barcodeFormat, j);
    }

    public x(String str, byte[] bArr, int i, z[] zVarArr, BarcodeFormat barcodeFormat, long j) {
        this.g = false;
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = zVarArr;
        this.e = barcodeFormat;
        this.f = j;
        this.i = 1.0f;
        this.h = false;
    }

    public void a() {
        this.d = new z[0];
    }

    public x(Parcel parcel) {
        this.g = false;
        this.a = parcel.readString();
        this.b = parcel.createByteArray();
        this.c = parcel.readInt();
        this.d = (z[]) parcel.createTypedArray(z.CREATOR);
        this.e = (BarcodeFormat) parcel.readParcelable(x.class.getClassLoader());
        this.f = parcel.readLong();
        this.g = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
        this.i = parcel.readFloat();
        this.j = parcel.readInt();
        if (this.k == null) {
            this.k = new ArrayList();
        }
        parcel.readList(this.k, x.class.getClassLoader());
    }
}
