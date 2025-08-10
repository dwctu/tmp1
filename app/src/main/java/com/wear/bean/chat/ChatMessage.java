package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\t\u00101\u001a\u00020\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0090\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u000bHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012¨\u0006:"}, d2 = {"Lcom/wear/bean/chat/ChatMessage;", "", "msgId", "", "seq", "", "timestamp", "version", "from", "to", "type", "", "chatType", "encryptionMode", "body", "module", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "getChatType", "()I", "setChatType", "(I)V", "getEncryptionMode", "setEncryptionMode", "getFrom", "getModule", "getMsgId", "setMsgId", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp", "getTo", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/wear/bean/chat/ChatMessage;", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatMessage {

    @Nullable
    private String body;
    private int chatType;

    @Nullable
    private String encryptionMode;

    @Nullable
    private final String from;

    @Nullable
    private final String module;

    @Nullable
    private String msgId;

    @Nullable
    private final Long seq;

    @Nullable
    private final Long timestamp;

    @Nullable
    private final String to;

    @Nullable
    private final Integer type;

    @Nullable
    private final String version;

    public ChatMessage(@Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, int i, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.msgId = str;
        this.seq = l;
        this.timestamp = l2;
        this.version = str2;
        this.from = str3;
        this.to = str4;
        this.type = num;
        this.chatType = i;
        this.encryptionMode = str5;
        this.body = str6;
        this.module = str7;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
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

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final int getChatType() {
        return this.chatType;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getEncryptionMode() {
        return this.encryptionMode;
    }

    @NotNull
    public final ChatMessage copy(@Nullable String msgId, @Nullable Long seq, @Nullable Long timestamp, @Nullable String version, @Nullable String from, @Nullable String to, @Nullable Integer type, int chatType, @Nullable String encryptionMode, @Nullable String body, @Nullable String module) {
        return new ChatMessage(msgId, seq, timestamp, version, from, to, type, chatType, encryptionMode, body, module);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) other;
        return Intrinsics.areEqual(this.msgId, chatMessage.msgId) && Intrinsics.areEqual(this.seq, chatMessage.seq) && Intrinsics.areEqual(this.timestamp, chatMessage.timestamp) && Intrinsics.areEqual(this.version, chatMessage.version) && Intrinsics.areEqual(this.from, chatMessage.from) && Intrinsics.areEqual(this.to, chatMessage.to) && Intrinsics.areEqual(this.type, chatMessage.type) && this.chatType == chatMessage.chatType && Intrinsics.areEqual(this.encryptionMode, chatMessage.encryptionMode) && Intrinsics.areEqual(this.body, chatMessage.body) && Intrinsics.areEqual(this.module, chatMessage.module);
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    public final int getChatType() {
        return this.chatType;
    }

    @Nullable
    public final String getEncryptionMode() {
        return this.encryptionMode;
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
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final Long getSeq() {
        return this.seq;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getTo() {
        return this.to;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.msgId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.seq;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.timestamp;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.from;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.to;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.type;
        int iHashCode7 = (((iHashCode6 + (num == null ? 0 : num.hashCode())) * 31) + this.chatType) * 31;
        String str5 = this.encryptionMode;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.body;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.module;
        return iHashCode9 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setBody(@Nullable String str) {
        this.body = str;
    }

    public final void setChatType(int i) {
        this.chatType = i;
    }

    public final void setEncryptionMode(@Nullable String str) {
        this.encryptionMode = str;
    }

    public final void setMsgId(@Nullable String str) {
        this.msgId = str;
    }

    @NotNull
    public String toString() {
        return "ChatMessage(msgId=" + this.msgId + ", seq=" + this.seq + ", timestamp=" + this.timestamp + ", version=" + this.version + ", from=" + this.from + ", to=" + this.to + ", type=" + this.type + ", chatType=" + this.chatType + ", encryptionMode=" + this.encryptionMode + ", body=" + this.body + ", module=" + this.module + ')';
    }

    public /* synthetic */ ChatMessage(String str, Long l, Long l2, String str2, String str3, String str4, Integer num, int i, String str5, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, l2, (i2 & 8) != 0 ? "1.0" : str2, str3, str4, num, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? "none" : str5, str6, (i2 & 1024) != 0 ? "ToyRoulette" : str7);
    }
}
