package com.wear.bean.chat;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignalingMessage.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003Jb\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006."}, d2 = {"Lcom/wear/bean/chat/SignalingMessage;", "", "from", "", "to", "type", "syn", "", "ack", "extData", SettingsJsonConstants.FEATURES_KEY, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)V", "getAck", "()Ljava/lang/Long;", "setAck", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExtData", "()Ljava/lang/String;", "setExtData", "(Ljava/lang/String;)V", "getFeatures", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "getFrom", "getSyn", "setSyn", "getTo", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;)Lcom/wear/bean/chat/SignalingMessage;", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SignalingMessage {

    @Nullable
    private Long ack;

    @Nullable
    private String extData;

    @Nullable
    private List<String> features;

    @NotNull
    private final String from;

    @Nullable
    private Long syn;

    @NotNull
    private final String to;

    @NotNull
    private final String type;

    public SignalingMessage(@NotNull String from, @NotNull String to, @NotNull String type, @Nullable Long l, @Nullable Long l2, @Nullable String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(type, "type");
        this.from = from;
        this.to = to;
        this.type = type;
        this.syn = l;
        this.ack = l2;
        this.extData = str;
        this.features = list;
    }

    public static /* synthetic */ SignalingMessage copy$default(SignalingMessage signalingMessage, String str, String str2, String str3, Long l, Long l2, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signalingMessage.from;
        }
        if ((i & 2) != 0) {
            str2 = signalingMessage.to;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = signalingMessage.type;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            l = signalingMessage.syn;
        }
        Long l3 = l;
        if ((i & 16) != 0) {
            l2 = signalingMessage.ack;
        }
        Long l4 = l2;
        if ((i & 32) != 0) {
            str4 = signalingMessage.extData;
        }
        String str7 = str4;
        if ((i & 64) != 0) {
            list = signalingMessage.features;
        }
        return signalingMessage.copy(str, str5, str6, l3, l4, str7, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getSyn() {
        return this.syn;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getAck() {
        return this.ack;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getExtData() {
        return this.extData;
    }

    @Nullable
    public final List<String> component7() {
        return this.features;
    }

    @NotNull
    public final SignalingMessage copy(@NotNull String from, @NotNull String to, @NotNull String type, @Nullable Long syn, @Nullable Long ack, @Nullable String extData, @Nullable List<String> features) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SignalingMessage(from, to, type, syn, ack, extData, features);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignalingMessage)) {
            return false;
        }
        SignalingMessage signalingMessage = (SignalingMessage) other;
        return Intrinsics.areEqual(this.from, signalingMessage.from) && Intrinsics.areEqual(this.to, signalingMessage.to) && Intrinsics.areEqual(this.type, signalingMessage.type) && Intrinsics.areEqual(this.syn, signalingMessage.syn) && Intrinsics.areEqual(this.ack, signalingMessage.ack) && Intrinsics.areEqual(this.extData, signalingMessage.extData) && Intrinsics.areEqual(this.features, signalingMessage.features);
    }

    @Nullable
    public final Long getAck() {
        return this.ack;
    }

    @Nullable
    public final String getExtData() {
        return this.extData;
    }

    @Nullable
    public final List<String> getFeatures() {
        return this.features;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    public final Long getSyn() {
        return this.syn;
    }

    @NotNull
    public final String getTo() {
        return this.to;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + this.type.hashCode()) * 31;
        Long l = this.syn;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.ack;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.extData;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.features;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public final void setAck(@Nullable Long l) {
        this.ack = l;
    }

    public final void setExtData(@Nullable String str) {
        this.extData = str;
    }

    public final void setFeatures(@Nullable List<String> list) {
        this.features = list;
    }

    public final void setSyn(@Nullable Long l) {
        this.syn = l;
    }

    @NotNull
    public String toString() {
        return "SignalingMessage(from=" + this.from + ", to=" + this.to + ", type=" + this.type + ", syn=" + this.syn + ", ack=" + this.ack + ", extData=" + this.extData + ", features=" + this.features + ')';
    }

    public /* synthetic */ SignalingMessage(String str, String str2, String str3, Long l, Long l2, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : list);
    }
}
