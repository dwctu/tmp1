package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RoulettePublicBean.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/RoulettePublicBean;", "Landroid/os/Parcelable;", "data", "", "algorithm", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlgorithm", "()Ljava/lang/String;", "getData", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RoulettePublicBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RoulettePublicBean> CREATOR = new Creator();

    @Nullable
    private final String algorithm;

    @Nullable
    private final String data;

    /* compiled from: RoulettePublicBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RoulettePublicBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RoulettePublicBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RoulettePublicBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RoulettePublicBean[] newArray(int i) {
            return new RoulettePublicBean[i];
        }
    }

    public RoulettePublicBean(@Nullable String str, @Nullable String str2) {
        this.data = str;
        this.algorithm = str2;
    }

    public static /* synthetic */ RoulettePublicBean copy$default(RoulettePublicBean roulettePublicBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roulettePublicBean.data;
        }
        if ((i & 2) != 0) {
            str2 = roulettePublicBean.algorithm;
        }
        return roulettePublicBean.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @NotNull
    public final RoulettePublicBean copy(@Nullable String data, @Nullable String algorithm) {
        return new RoulettePublicBean(data, algorithm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoulettePublicBean)) {
            return false;
        }
        RoulettePublicBean roulettePublicBean = (RoulettePublicBean) other;
        return Intrinsics.areEqual(this.data, roulettePublicBean.data) && Intrinsics.areEqual(this.algorithm, roulettePublicBean.algorithm);
    }

    @Nullable
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        String str = this.data;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.algorithm;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RoulettePublicBean(data=" + this.data + ", algorithm=" + this.algorithm + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.data);
        parcel.writeString(this.algorithm);
    }

    public /* synthetic */ RoulettePublicBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "DH" : str2);
    }
}
