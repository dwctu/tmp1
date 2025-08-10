package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteSettingBean.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0010Jn\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00102J\t\u00103\u001a\u00020\rHÖ\u0001J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\rHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\rHÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u0006>"}, d2 = {"Lcom/wear/bean/RouletteSettingBean;", "Landroid/os/Parcelable;", "gender", "", "preferGender", "", "plays", "", "sendFriendRequest", "", "receiveFriendRequest", "intro", "countdown", "", "(Ljava/lang/String;Ljava/util/List;[Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCountdown", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGender", "()Ljava/lang/String;", "setGender", "(Ljava/lang/String;)V", "getIntro", "setIntro", "isGenderSet", "()Z", "getPlays", "()[Ljava/lang/String;", "setPlays", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getPreferGender", "()Ljava/util/List;", "setPreferGender", "(Ljava/util/List;)V", "getReceiveFriendRequest", "()Ljava/lang/Boolean;", "setReceiveFriendRequest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSendFriendRequest", "setSendFriendRequest", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/List;[Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/wear/bean/RouletteSettingBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RouletteSettingBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RouletteSettingBean> CREATOR = new Creator();

    @Nullable
    private final Integer countdown;

    @Nullable
    private String gender;

    @Nullable
    private String intro;

    @Nullable
    private String[] plays;

    @Nullable
    private List<String> preferGender;

    @Nullable
    private Boolean receiveFriendRequest;

    @Nullable
    private Boolean sendFriendRequest;

    /* compiled from: RouletteSettingBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RouletteSettingBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RouletteSettingBean createFromParcel(@NotNull Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            String[] strArrCreateStringArray = parcel.createStringArray();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new RouletteSettingBean(string, arrayListCreateStringArrayList, strArrCreateStringArray, boolValueOf, boolValueOf2, parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RouletteSettingBean[] newArray(int i) {
            return new RouletteSettingBean[i];
        }
    }

    public RouletteSettingBean(@Nullable String str, @Nullable List<String> list, @Nullable String[] strArr, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable Integer num) {
        this.gender = str;
        this.preferGender = list;
        this.plays = strArr;
        this.sendFriendRequest = bool;
        this.receiveFriendRequest = bool2;
        this.intro = str2;
        this.countdown = num;
    }

    public static /* synthetic */ RouletteSettingBean copy$default(RouletteSettingBean rouletteSettingBean, String str, List list, String[] strArr, Boolean bool, Boolean bool2, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rouletteSettingBean.gender;
        }
        if ((i & 2) != 0) {
            list = rouletteSettingBean.preferGender;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            strArr = rouletteSettingBean.plays;
        }
        String[] strArr2 = strArr;
        if ((i & 8) != 0) {
            bool = rouletteSettingBean.sendFriendRequest;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            bool2 = rouletteSettingBean.receiveFriendRequest;
        }
        Boolean bool4 = bool2;
        if ((i & 32) != 0) {
            str2 = rouletteSettingBean.intro;
        }
        String str3 = str2;
        if ((i & 64) != 0) {
            num = rouletteSettingBean.countdown;
        }
        return rouletteSettingBean.copy(str, list2, strArr2, bool3, bool4, str3, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final List<String> component2() {
        return this.preferGender;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String[] getPlays() {
        return this.plays;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getSendFriendRequest() {
        return this.sendFriendRequest;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getReceiveFriendRequest() {
        return this.receiveFriendRequest;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getCountdown() {
        return this.countdown;
    }

    @NotNull
    public final RouletteSettingBean copy(@Nullable String gender, @Nullable List<String> preferGender, @Nullable String[] plays, @Nullable Boolean sendFriendRequest, @Nullable Boolean receiveFriendRequest, @Nullable String intro, @Nullable Integer countdown) {
        return new RouletteSettingBean(gender, preferGender, plays, sendFriendRequest, receiveFriendRequest, intro, countdown);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouletteSettingBean)) {
            return false;
        }
        RouletteSettingBean rouletteSettingBean = (RouletteSettingBean) other;
        return Intrinsics.areEqual(this.gender, rouletteSettingBean.gender) && Intrinsics.areEqual(this.preferGender, rouletteSettingBean.preferGender) && Intrinsics.areEqual(this.plays, rouletteSettingBean.plays) && Intrinsics.areEqual(this.sendFriendRequest, rouletteSettingBean.sendFriendRequest) && Intrinsics.areEqual(this.receiveFriendRequest, rouletteSettingBean.receiveFriendRequest) && Intrinsics.areEqual(this.intro, rouletteSettingBean.intro) && Intrinsics.areEqual(this.countdown, rouletteSettingBean.countdown);
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
    public final String[] getPlays() {
        return this.plays;
    }

    @Nullable
    public final List<String> getPreferGender() {
        return this.preferGender;
    }

    @Nullable
    public final Boolean getReceiveFriendRequest() {
        return this.receiveFriendRequest;
    }

    @Nullable
    public final Boolean getSendFriendRequest() {
        return this.sendFriendRequest;
    }

    public int hashCode() {
        String str = this.gender;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.preferGender;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String[] strArr = this.plays;
        int iHashCode3 = (iHashCode2 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Boolean bool = this.sendFriendRequest;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.receiveFriendRequest;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.intro;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.countdown;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isGenderSet() {
        String str = this.gender;
        return !(str == null || str.length() == 0);
    }

    public final void setGender(@Nullable String str) {
        this.gender = str;
    }

    public final void setIntro(@Nullable String str) {
        this.intro = str;
    }

    public final void setPlays(@Nullable String[] strArr) {
        this.plays = strArr;
    }

    public final void setPreferGender(@Nullable List<String> list) {
        this.preferGender = list;
    }

    public final void setReceiveFriendRequest(@Nullable Boolean bool) {
        this.receiveFriendRequest = bool;
    }

    public final void setSendFriendRequest(@Nullable Boolean bool) {
        this.sendFriendRequest = bool;
    }

    @NotNull
    public String toString() {
        return "RouletteSettingBean(gender=" + this.gender + ", preferGender=" + this.preferGender + ", plays=" + Arrays.toString(this.plays) + ", sendFriendRequest=" + this.sendFriendRequest + ", receiveFriendRequest=" + this.receiveFriendRequest + ", intro=" + this.intro + ", countdown=" + this.countdown + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.gender);
        parcel.writeStringList(this.preferGender);
        parcel.writeStringArray(this.plays);
        Boolean bool = this.sendFriendRequest;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.receiveFriendRequest;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.intro);
        Integer num = this.countdown;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
    }
}
