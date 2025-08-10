package com.wear.bean.chat;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageBody.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/wear/bean/chat/MessageBody;", "", "text", "", "assetURL", "alarmType", "", "isBurn", TypedValues.TransitionType.S_DURATION, "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getAlarmType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAssetURL", "()Ljava/lang/String;", "setAssetURL", "(Ljava/lang/String;)V", "getDuration", "getExtra", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/wear/bean/chat/MessageBody;", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessageBody {

    @Nullable
    private final Integer alarmType;

    @Nullable
    private String assetURL;

    @Nullable
    private final Integer duration;

    @Nullable
    private final String extra;

    @Nullable
    private final Integer isBurn;

    @Nullable
    private final String text;

    public MessageBody() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MessageBody(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str3) {
        this.text = str;
        this.assetURL = str2;
        this.alarmType = num;
        this.isBurn = num2;
        this.duration = num3;
        this.extra = str3;
    }

    public static /* synthetic */ MessageBody copy$default(MessageBody messageBody, String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageBody.text;
        }
        if ((i & 2) != 0) {
            str2 = messageBody.assetURL;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = messageBody.alarmType;
        }
        Integer num4 = num;
        if ((i & 8) != 0) {
            num2 = messageBody.isBurn;
        }
        Integer num5 = num2;
        if ((i & 16) != 0) {
            num3 = messageBody.duration;
        }
        Integer num6 = num3;
        if ((i & 32) != 0) {
            str3 = messageBody.extra;
        }
        return messageBody.copy(str, str4, num4, num5, num6, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAssetURL() {
        return this.assetURL;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getAlarmType() {
        return this.alarmType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getIsBurn() {
        return this.isBurn;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    @NotNull
    public final MessageBody copy(@Nullable String text, @Nullable String assetURL, @Nullable Integer alarmType, @Nullable Integer isBurn, @Nullable Integer duration, @Nullable String extra) {
        return new MessageBody(text, assetURL, alarmType, isBurn, duration, extra);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageBody)) {
            return false;
        }
        MessageBody messageBody = (MessageBody) other;
        return Intrinsics.areEqual(this.text, messageBody.text) && Intrinsics.areEqual(this.assetURL, messageBody.assetURL) && Intrinsics.areEqual(this.alarmType, messageBody.alarmType) && Intrinsics.areEqual(this.isBurn, messageBody.isBurn) && Intrinsics.areEqual(this.duration, messageBody.duration) && Intrinsics.areEqual(this.extra, messageBody.extra);
    }

    @Nullable
    public final Integer getAlarmType() {
        return this.alarmType;
    }

    @Nullable
    public final String getAssetURL() {
        return this.assetURL;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getExtra() {
        return this.extra;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.assetURL;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.alarmType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isBurn;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.duration;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.extra;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    @Nullable
    public final Integer isBurn() {
        return this.isBurn;
    }

    public final void setAssetURL(@Nullable String str) {
        this.assetURL = str;
    }

    @NotNull
    public String toString() {
        return "MessageBody(text=" + this.text + ", assetURL=" + this.assetURL + ", alarmType=" + this.alarmType + ", isBurn=" + this.isBurn + ", duration=" + this.duration + ", extra=" + this.extra + ')';
    }

    public /* synthetic */ MessageBody(String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3);
    }
}
