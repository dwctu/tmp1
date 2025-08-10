package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FindMatchUserBean.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006("}, d2 = {"Lcom/wear/bean/FindMatchUserBean;", "Landroid/os/Parcelable;", "countdown", "", "gender", "", "intro", "plays", "", "toys", "Lcom/wear/bean/UserToy;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCountdown", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGender", "()Ljava/lang/String;", "getIntro", "getPlays", "()Ljava/util/List;", "getToys", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/wear/bean/FindMatchUserBean;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FindMatchUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FindMatchUserBean> CREATOR = new Creator();

    @Nullable
    private final Integer countdown;

    @Nullable
    private final String gender;

    @Nullable
    private final String intro;

    @Nullable
    private final List<String> plays;

    @Nullable
    private final List<UserToy> toys;

    /* compiled from: FindMatchUserBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FindMatchUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FindMatchUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(UserToy.CREATOR.createFromParcel(parcel));
                }
            }
            return new FindMatchUserBean(numValueOf, string, string2, arrayListCreateStringArrayList, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FindMatchUserBean[] newArray(int i) {
            return new FindMatchUserBean[i];
        }
    }

    public FindMatchUserBean() {
        this(null, null, null, null, null, 31, null);
    }

    public FindMatchUserBean(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable List<UserToy> list2) {
        this.countdown = num;
        this.gender = str;
        this.intro = str2;
        this.plays = list;
        this.toys = list2;
    }

    public static /* synthetic */ FindMatchUserBean copy$default(FindMatchUserBean findMatchUserBean, Integer num, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = findMatchUserBean.countdown;
        }
        if ((i & 2) != 0) {
            str = findMatchUserBean.gender;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = findMatchUserBean.intro;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            list = findMatchUserBean.plays;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = findMatchUserBean.toys;
        }
        return findMatchUserBean.copy(num, str3, str4, list3, list2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCountdown() {
        return this.countdown;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    public final List<String> component4() {
        return this.plays;
    }

    @Nullable
    public final List<UserToy> component5() {
        return this.toys;
    }

    @NotNull
    public final FindMatchUserBean copy(@Nullable Integer countdown, @Nullable String gender, @Nullable String intro, @Nullable List<String> plays, @Nullable List<UserToy> toys) {
        return new FindMatchUserBean(countdown, gender, intro, plays, toys);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FindMatchUserBean)) {
            return false;
        }
        FindMatchUserBean findMatchUserBean = (FindMatchUserBean) other;
        return Intrinsics.areEqual(this.countdown, findMatchUserBean.countdown) && Intrinsics.areEqual(this.gender, findMatchUserBean.gender) && Intrinsics.areEqual(this.intro, findMatchUserBean.intro) && Intrinsics.areEqual(this.plays, findMatchUserBean.plays) && Intrinsics.areEqual(this.toys, findMatchUserBean.toys);
    }

    @Nullable
    public final Integer getCountdown() {
        return this.countdown;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    public final List<String> getPlays() {
        return this.plays;
    }

    @Nullable
    public final List<UserToy> getToys() {
        return this.toys;
    }

    public int hashCode() {
        Integer num = this.countdown;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.gender;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.intro;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.plays;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<UserToy> list2 = this.toys;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FindMatchUserBean(countdown=" + this.countdown + ", gender=" + this.gender + ", intro=" + this.intro + ", plays=" + this.plays + ", toys=" + this.toys + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.countdown;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.gender);
        parcel.writeString(this.intro);
        parcel.writeStringList(this.plays);
        List<UserToy> list = this.toys;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<UserToy> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ FindMatchUserBean(Integer num, String str, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) == 0 ? str2 : "", (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
