package com.wear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.wear.bean.chat.ToyInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserJoinChatBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020#HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011¨\u0006)"}, d2 = {"Lcom/wear/bean/UserJoinChatBean;", "Landroid/os/Parcelable;", "roomId", "", "userAccountCode", "publicKey", "Lcom/wear/bean/RoulettePublicBean;", "toys", "", "Lcom/wear/bean/chat/ToyInfo;", "encryptionMode", "startTime", "", "isFromOuter", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/wear/bean/RoulettePublicBean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Z)V", "getEncryptionMode", "()Ljava/lang/String;", "()Z", "setFromOuter", "(Z)V", "getPublicKey", "()Lcom/wear/bean/RoulettePublicBean;", "getRoomId", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getToys", "()Ljava/util/List;", "setToys", "(Ljava/util/List;)V", "getUserAccountCode", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UserJoinChatBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserJoinChatBean> CREATOR = new Creator();

    @Nullable
    private final String encryptionMode;
    private boolean isFromOuter;

    @Nullable
    private final RoulettePublicBean publicKey;

    @Nullable
    private final String roomId;

    @Nullable
    private Long startTime;

    @Nullable
    private List<ToyInfo> toys;

    @Nullable
    private final String userAccountCode;

    /* compiled from: UserJoinChatBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserJoinChatBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserJoinChatBean createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            RoulettePublicBean roulettePublicBeanCreateFromParcel = parcel.readInt() == 0 ? null : RoulettePublicBean.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(ToyInfo.CREATOR.createFromParcel(parcel));
                }
            }
            return new UserJoinChatBean(string, string2, roulettePublicBeanCreateFromParcel, arrayList, parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserJoinChatBean[] newArray(int i) {
            return new UserJoinChatBean[i];
        }
    }

    public UserJoinChatBean(@Nullable String str, @Nullable String str2, @Nullable RoulettePublicBean roulettePublicBean, @Nullable List<ToyInfo> list, @Nullable String str3, @Nullable Long l, boolean z) {
        this.roomId = str;
        this.userAccountCode = str2;
        this.publicKey = roulettePublicBean;
        this.toys = list;
        this.encryptionMode = str3;
        this.startTime = l;
        this.isFromOuter = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getEncryptionMode() {
        return this.encryptionMode;
    }

    @Nullable
    public final RoulettePublicBean getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final Long getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final List<ToyInfo> getToys() {
        return this.toys;
    }

    @Nullable
    public final String getUserAccountCode() {
        return this.userAccountCode;
    }

    /* renamed from: isFromOuter, reason: from getter */
    public final boolean getIsFromOuter() {
        return this.isFromOuter;
    }

    public final void setFromOuter(boolean z) {
        this.isFromOuter = z;
    }

    public final void setStartTime(@Nullable Long l) {
        this.startTime = l;
    }

    public final void setToys(@Nullable List<ToyInfo> list) {
        this.toys = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.roomId);
        parcel.writeString(this.userAccountCode);
        RoulettePublicBean roulettePublicBean = this.publicKey;
        if (roulettePublicBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            roulettePublicBean.writeToParcel(parcel, flags);
        }
        List<ToyInfo> list = this.toys;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<ToyInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.encryptionMode);
        Long l = this.startTime;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeInt(this.isFromOuter ? 1 : 0);
    }

    public /* synthetic */ UserJoinChatBean(String str, String str2, RoulettePublicBean roulettePublicBean, List list, String str3, Long l, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, roulettePublicBean, (i & 8) != 0 ? null : list, str3, (i & 32) != 0 ? null : l, (i & 64) != 0 ? false : z);
    }
}
