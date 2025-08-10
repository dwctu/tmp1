package com.wear.bean.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageSelected.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006)"}, d2 = {"Lcom/wear/bean/chat/MessageSelected;", "Landroid/os/Parcelable;", "msgId", "", FirebaseAnalytics.Param.CONTENT, "role", "seq", "", "from", "to", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getFrom", "getMsgId", "getRole", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/wear/bean/chat/MessageSelected;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessageSelected implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MessageSelected> CREATOR = new Creator();

    @Nullable
    private final String content;

    @Nullable
    private final String from;

    @Nullable
    private final String msgId;

    @Nullable
    private final String role;

    @Nullable
    private final Long seq;

    @Nullable
    private final String to;

    /* compiled from: MessageSelected.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MessageSelected> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessageSelected createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MessageSelected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessageSelected[] newArray(int i) {
            return new MessageSelected[i];
        }
    }

    public MessageSelected(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l, @Nullable String str4, @Nullable String str5) {
        this.msgId = str;
        this.content = str2;
        this.role = str3;
        this.seq = l;
        this.from = str4;
        this.to = str5;
    }

    public static /* synthetic */ MessageSelected copy$default(MessageSelected messageSelected, String str, String str2, String str3, Long l, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageSelected.msgId;
        }
        if ((i & 2) != 0) {
            str2 = messageSelected.content;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = messageSelected.role;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            l = messageSelected.seq;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            str4 = messageSelected.from;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = messageSelected.to;
        }
        return messageSelected.copy(str, str6, str7, l2, str8, str5);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    @NotNull
    public final MessageSelected copy(@Nullable String msgId, @Nullable String content, @Nullable String role, @Nullable Long seq, @Nullable String from, @Nullable String to) {
        return new MessageSelected(msgId, content, role, seq, from, to);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSelected)) {
            return false;
        }
        MessageSelected messageSelected = (MessageSelected) other;
        return Intrinsics.areEqual(this.msgId, messageSelected.msgId) && Intrinsics.areEqual(this.content, messageSelected.content) && Intrinsics.areEqual(this.role, messageSelected.role) && Intrinsics.areEqual(this.seq, messageSelected.seq) && Intrinsics.areEqual(this.from, messageSelected.from) && Intrinsics.areEqual(this.to, messageSelected.to);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final String getRole() {
        return this.role;
    }

    @Nullable
    public final Long getSeq() {
        return this.seq;
    }

    @Nullable
    public final String getTo() {
        return this.to;
    }

    public int hashCode() {
        String str = this.msgId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.role;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.seq;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.from;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.to;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageSelected(msgId=" + this.msgId + ", content=" + this.content + ", role=" + this.role + ", seq=" + this.seq + ", from=" + this.from + ", to=" + this.to + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.msgId);
        parcel.writeString(this.content);
        parcel.writeString(this.role);
        Long l = this.seq;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.from);
        parcel.writeString(this.to);
    }
}
