package com.wear.ui.longDistance.imagepicker.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class MediaFile implements Parcelable {
    public static final Parcelable.Creator<MediaFile> CREATOR = new a();
    public long a;
    public String b;
    public String c;
    public Integer d;
    public String e;
    public long f;
    public long g;
    public long h;

    public class a implements Parcelable.Creator<MediaFile> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaFile createFromParcel(Parcel parcel) {
            return new MediaFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaFile[] newArray(int i) {
            return new MediaFile[i];
        }
    }

    public MediaFile() {
    }

    public long a() {
        return this.g;
    }

    public long b() {
        return this.f;
    }

    public Integer c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public void g(long j) {
        this.g = j;
    }

    public void h(long j) {
        this.f = j;
    }

    public void i(Integer num) {
        this.d = num;
    }

    public void j(String str) {
        this.e = str;
    }

    public void k(long j) {
        this.a = j;
    }

    public void l(String str) {
        this.c = str;
    }

    public void m(String str) {
        this.b = str;
    }

    public void n(long j) {
        this.h = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        if (this.d == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.d.intValue());
        }
        parcel.writeString(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
    }

    public MediaFile(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        if (parcel.readByte() == 0) {
            this.d = null;
        } else {
            this.d = Integer.valueOf(parcel.readInt());
        }
        this.e = parcel.readString();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readLong();
    }
}
