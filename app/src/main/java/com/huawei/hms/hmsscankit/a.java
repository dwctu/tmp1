package com.huawei.hms.hmsscankit;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: DetailRect.java */
/* loaded from: classes3.dex */
public class a implements Parcelable.Creator<DetailRect> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DetailRect createFromParcel(Parcel parcel) {
        return new DetailRect(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DetailRect[] newArray(int i) {
        return new DetailRect[i];
    }
}
