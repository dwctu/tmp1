package com.wear.bean.data;

import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTPatternBean.kt */
@DatabaseTable(tableName = "tb_chat_gpt_pattern")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0089\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0092\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\bHÖ\u0001J\t\u0010A\u001a\u00020\u0004HÖ\u0001R\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010*R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b.\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019¨\u0006B"}, d2 = {"Lcom/wear/bean/data/ChatGPTPatternBean;", "Lcom/wear/bean/BaseEntity;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "remoteAccountId", "", "localMsgId", "topicId", "leftTimes", "", "msgText", "contentType", "sessionTaskId", "sessionTimeoutSeconds", NotificationCompat.CATEGORY_MESSAGE, "Lcom/wear/bean/data/ChatGPTPattern;", "failCode", "goneSendError", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/wear/bean/data/ChatGPTPattern;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContentType", "()Ljava/lang/Integer;", "setContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFailCode", "()Ljava/lang/String;", "getGoneSendError", "()Ljava/lang/Boolean;", "setGoneSendError", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemType", "getItemType", "()I", "getLeftTimes", "getLocalMsgId", "getMsg", "()Lcom/wear/bean/data/ChatGPTPattern;", "getMsgText", "patternDB", "getPatternDB", "setPatternDB", "(Ljava/lang/String;)V", "getRemoteAccountId", "setRemoteAccountId", "getSessionTaskId", "getSessionTimeoutSeconds", "getTopicId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/wear/bean/data/ChatGPTPattern;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/wear/bean/data/ChatGPTPatternBean;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTPatternBean extends BaseEntity implements tq {

    @DatabaseField
    @Nullable
    private Integer contentType;

    @Nullable
    private final String failCode;

    @Nullable
    private Boolean goneSendError;

    @DatabaseField
    @Nullable
    private final Integer leftTimes;

    @DatabaseField
    @Nullable
    private final String localMsgId;

    @Nullable
    private final ChatGPTPattern msg;

    @DatabaseField
    @Nullable
    private final String msgText;

    @DatabaseField
    @NotNull
    private String patternDB;

    @DatabaseField
    @Nullable
    private String remoteAccountId;

    @DatabaseField
    @Nullable
    private final String sessionTaskId;

    @DatabaseField
    @Nullable
    private final Integer sessionTimeoutSeconds;

    @DatabaseField
    @Nullable
    private final String topicId;

    public ChatGPTPatternBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public /* synthetic */ ChatGPTPatternBean(String str, String str2, String str3, Integer num, String str4, Integer num2, String str5, Integer num3, ChatGPTPattern chatGPTPattern, String str6, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? 0 : num, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? 0 : num2, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? 0 : num3, (i & 256) != 0 ? null : chatGPTPattern, (i & 512) == 0 ? str6 : "", (i & 1024) != 0 ? Boolean.TRUE : bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getFailCode() {
        return this.failCode;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getGoneSendError() {
        return this.goneSendError;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTopicId() {
        return this.topicId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMsgText() {
        return this.msgText;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getContentType() {
        return this.contentType;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final ChatGPTPattern getMsg() {
        return this.msg;
    }

    @NotNull
    public final ChatGPTPatternBean copy(@Nullable String remoteAccountId, @Nullable String localMsgId, @Nullable String topicId, @Nullable Integer leftTimes, @Nullable String msgText, @Nullable Integer contentType, @Nullable String sessionTaskId, @Nullable Integer sessionTimeoutSeconds, @Nullable ChatGPTPattern msg, @Nullable String failCode, @Nullable Boolean goneSendError) {
        return new ChatGPTPatternBean(remoteAccountId, localMsgId, topicId, leftTimes, msgText, contentType, sessionTaskId, sessionTimeoutSeconds, msg, failCode, goneSendError);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTPatternBean)) {
            return false;
        }
        ChatGPTPatternBean chatGPTPatternBean = (ChatGPTPatternBean) other;
        return Intrinsics.areEqual(this.remoteAccountId, chatGPTPatternBean.remoteAccountId) && Intrinsics.areEqual(this.localMsgId, chatGPTPatternBean.localMsgId) && Intrinsics.areEqual(this.topicId, chatGPTPatternBean.topicId) && Intrinsics.areEqual(this.leftTimes, chatGPTPatternBean.leftTimes) && Intrinsics.areEqual(this.msgText, chatGPTPatternBean.msgText) && Intrinsics.areEqual(this.contentType, chatGPTPatternBean.contentType) && Intrinsics.areEqual(this.sessionTaskId, chatGPTPatternBean.sessionTaskId) && Intrinsics.areEqual(this.sessionTimeoutSeconds, chatGPTPatternBean.sessionTimeoutSeconds) && Intrinsics.areEqual(this.msg, chatGPTPatternBean.msg) && Intrinsics.areEqual(this.failCode, chatGPTPatternBean.failCode) && Intrinsics.areEqual(this.goneSendError, chatGPTPatternBean.goneSendError);
    }

    @Nullable
    public final Integer getContentType() {
        return this.contentType;
    }

    @Nullable
    public final String getFailCode() {
        return this.failCode;
    }

    @Nullable
    public final Boolean getGoneSendError() {
        return this.goneSendError;
    }

    @Override // dc.tq
    public int getItemType() {
        Integer num = this.contentType;
        if (num != null) {
            return num.intValue();
        }
        return 10;
    }

    @Nullable
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @Nullable
    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    @Nullable
    public final ChatGPTPattern getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getMsgText() {
        return this.msgText;
    }

    @NotNull
    public final String getPatternDB() {
        return this.patternDB;
    }

    @Nullable
    public final String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    @Nullable
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    @Nullable
    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    @Nullable
    public final String getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        String str = this.remoteAccountId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.localMsgId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.topicId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.leftTimes;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.msgText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.contentType;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.sessionTaskId;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.sessionTimeoutSeconds;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ChatGPTPattern chatGPTPattern = this.msg;
        int iHashCode9 = (iHashCode8 + (chatGPTPattern == null ? 0 : chatGPTPattern.hashCode())) * 31;
        String str6 = this.failCode;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.goneSendError;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setContentType(@Nullable Integer num) {
        this.contentType = num;
    }

    public final void setGoneSendError(@Nullable Boolean bool) {
        this.goneSendError = bool;
    }

    public final void setPatternDB(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.patternDB = str;
    }

    public final void setRemoteAccountId(@Nullable String str) {
        this.remoteAccountId = str;
    }

    @NotNull
    public String toString() {
        return "ChatGPTPatternBean(remoteAccountId=" + this.remoteAccountId + ", localMsgId=" + this.localMsgId + ", topicId=" + this.topicId + ", leftTimes=" + this.leftTimes + ", msgText=" + this.msgText + ", contentType=" + this.contentType + ", sessionTaskId=" + this.sessionTaskId + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", msg=" + this.msg + ", failCode=" + this.failCode + ", goneSendError=" + this.goneSendError + ')';
    }

    public ChatGPTPatternBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2, @Nullable String str5, @Nullable Integer num3, @Nullable ChatGPTPattern chatGPTPattern, @Nullable String str6, @Nullable Boolean bool) {
        this.remoteAccountId = str;
        this.localMsgId = str2;
        this.topicId = str3;
        this.leftTimes = num;
        this.msgText = str4;
        this.contentType = num2;
        this.sessionTaskId = str5;
        this.sessionTimeoutSeconds = num3;
        this.msg = chatGPTPattern;
        this.failCode = str6;
        this.goneSendError = bool;
        String jSONString = JSON.toJSONString(chatGPTPattern);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(msg)");
        this.patternDB = jSONString;
    }
}
