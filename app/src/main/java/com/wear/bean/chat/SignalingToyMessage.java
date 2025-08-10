package com.wear.bean.chat;

import com.wear.bean.SyncWsProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignalingToyMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006&"}, d2 = {"Lcom/wear/bean/chat/SignalingToyMessage;", "", "from", "", "to", SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY, "version", "type", "module", "extData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtData", "()Ljava/lang/String;", "setExtData", "(Ljava/lang/String;)V", "getFrom", "getModule", "setModule", "getOrder", "getTo", "getType", "setType", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SignalingToyMessage {

    @Nullable
    private String extData;

    @Nullable
    private final String from;

    @Nullable
    private String module;

    @Nullable
    private final String order;

    @Nullable
    private final String to;

    @Nullable
    private String type;

    @Nullable
    private String version;

    public SignalingToyMessage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.from = str;
        this.to = str2;
        this.order = str3;
        this.version = str4;
        this.type = str5;
        this.module = str6;
        this.extData = str7;
    }

    public static /* synthetic */ SignalingToyMessage copy$default(SignalingToyMessage signalingToyMessage, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signalingToyMessage.from;
        }
        if ((i & 2) != 0) {
            str2 = signalingToyMessage.to;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = signalingToyMessage.order;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = signalingToyMessage.version;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = signalingToyMessage.type;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = signalingToyMessage.module;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = signalingToyMessage.extData;
        }
        return signalingToyMessage.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getOrder() {
        return this.order;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getExtData() {
        return this.extData;
    }

    @NotNull
    public final SignalingToyMessage copy(@Nullable String from, @Nullable String to, @Nullable String order, @Nullable String version, @Nullable String type, @Nullable String module, @Nullable String extData) {
        return new SignalingToyMessage(from, to, order, version, type, module, extData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignalingToyMessage)) {
            return false;
        }
        SignalingToyMessage signalingToyMessage = (SignalingToyMessage) other;
        return Intrinsics.areEqual(this.from, signalingToyMessage.from) && Intrinsics.areEqual(this.to, signalingToyMessage.to) && Intrinsics.areEqual(this.order, signalingToyMessage.order) && Intrinsics.areEqual(this.version, signalingToyMessage.version) && Intrinsics.areEqual(this.type, signalingToyMessage.type) && Intrinsics.areEqual(this.module, signalingToyMessage.module) && Intrinsics.areEqual(this.extData, signalingToyMessage.extData);
    }

    @Nullable
    public final String getExtData() {
        return this.extData;
    }

    @Nullable
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    public final String getModule() {
        return this.module;
    }

    @Nullable
    public final String getOrder() {
        return this.order;
    }

    @Nullable
    public final String getTo() {
        return this.to;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.from;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.to;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.order;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.type;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.module;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.extData;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setExtData(@Nullable String str) {
        this.extData = str;
    }

    public final void setModule(@Nullable String str) {
        this.module = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setVersion(@Nullable String str) {
        this.version = str;
    }

    @NotNull
    public String toString() {
        return "SignalingToyMessage(from=" + this.from + ", to=" + this.to + ", order=" + this.order + ", version=" + this.version + ", type=" + this.type + ", module=" + this.module + ", extData=" + this.extData + ')';
    }

    public /* synthetic */ SignalingToyMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "1.0" : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }
}
