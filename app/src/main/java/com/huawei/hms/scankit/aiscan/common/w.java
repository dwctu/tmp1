package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Result.java */
/* loaded from: classes3.dex */
public class w implements Parcelable.Creator<x> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public x createFromParcel(Parcel parcel) {
        return new x(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public x[] newArray(int i) {
        return new x[i];
    }
}
