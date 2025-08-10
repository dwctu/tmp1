package com.wear.widget.seekbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes4.dex */
public class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public float a;
    public float b;
    public float c;
    public int d;
    public float e;
    public float f;

    public class a implements Parcelable.Creator<SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    }

    public /* synthetic */ SavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
    }

    public SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public SavedState(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.readFloat();
        this.f = parcel.readFloat();
    }
}
