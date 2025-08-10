package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new a();
    public final String a;
    public int b;
    public int c;
    public String d;

    public class a implements Parcelable.Creator<ParcelableMMKV> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            String string2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(string, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), string2, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableMMKV[] newArray(int i) {
            return new ParcelableMMKV[i];
        }
    }

    public /* synthetic */ ParcelableMMKV(String str, int i, int i2, String str2, a aVar) {
        this(str, i, i2, str2);
    }

    public MMKV a() {
        int i;
        int i2 = this.b;
        if (i2 < 0 || (i = this.c) < 0) {
            return null;
        }
        return MMKV.x(this.a, i2, i, this.d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) throws IOException {
        try {
            parcel.writeString(this.a);
            ParcelFileDescriptor parcelFileDescriptorFromFd = ParcelFileDescriptor.fromFd(this.b);
            ParcelFileDescriptor parcelFileDescriptorFromFd2 = ParcelFileDescriptor.fromFd(this.c);
            int i2 = i | 1;
            parcelFileDescriptorFromFd.writeToParcel(parcel, i2);
            parcelFileDescriptorFromFd2.writeToParcel(parcel, i2);
            String str = this.d;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.b = -1;
        this.c = -1;
        this.d = null;
        this.a = mmkv.mmapID();
        this.b = mmkv.ashmemFD();
        this.c = mmkv.ashmemMetaFD();
        this.d = mmkv.cryptKey();
    }

    public ParcelableMMKV(String str, int i, int i2, String str2) {
        this.b = -1;
        this.c = -1;
        this.d = null;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
    }
}
