package com.wear.bean.data;

import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import dc.tq;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTStoryResponse.kt */
@DatabaseTable(tableName = "tb_chat_gpt_story")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0089\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\bHÖ\u0001J\t\u0010D\u001a\u00020\u0005HÖ\u0001R\"\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010,R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b.\u0010\u0015R \u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010,R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001a¨\u0006E"}, d2 = {"Lcom/wear/bean/data/ChatGPTStoryBean;", "Lcom/wear/bean/BaseEntity;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Ljava/io/Serializable;", "sessionTaskId", "", "topicId", "leftTimes", "", "sessionTimeoutSeconds", "localMsgId", "msgText", "remoteAccountId", "contentType", "failCode", NotificationCompat.CATEGORY_MESSAGE, "Lcom/wear/bean/data/ChatGPTStoryData;", "goneSendError", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/data/ChatGPTStoryData;Ljava/lang/Boolean;)V", "getContentType", "()Ljava/lang/Integer;", "setContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFailCode", "()Ljava/lang/String;", "getGoneSendError", "()Ljava/lang/Boolean;", "setGoneSendError", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemType", "getItemType", "()I", "getLeftTimes", "getLocalMsgId", "getMsg", "()Lcom/wear/bean/data/ChatGPTStoryData;", "setMsg", "(Lcom/wear/bean/data/ChatGPTStoryData;)V", "getMsgText", "getRemoteAccountId", "setRemoteAccountId", "(Ljava/lang/String;)V", "getSessionTaskId", "getSessionTimeoutSeconds", "storyDB", "getStoryDB", "setStoryDB", "getTopicId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/wear/bean/data/ChatGPTStoryData;Ljava/lang/Boolean;)Lcom/wear/bean/data/ChatGPTStoryBean;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTStoryBean extends BaseEntity implements tq, Serializable {

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
    private ChatGPTStoryData msg;

    @DatabaseField
    @Nullable
    private final String msgText;

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
    private String storyDB;

    @DatabaseField
    @Nullable
    private final String topicId;

    public ChatGPTStoryBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public /* synthetic */ ChatGPTStoryBean(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Integer num3, String str6, ChatGPTStoryData chatGPTStoryData, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? 0 : num2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? 0 : num3, (i & 256) == 0 ? str6 : "", (i & 512) != 0 ? null : chatGPTStoryData, (i & 1024) != 0 ? Boolean.TRUE : bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final ChatGPTStoryData getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getGoneSendError() {
        return this.goneSendError;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTopicId() {
        return this.topicId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getMsgText() {
        return this.msgText;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getContentType() {
        return this.contentType;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getFailCode() {
        return this.failCode;
    }

    @NotNull
    public final ChatGPTStoryBean copy(@Nullable String sessionTaskId, @Nullable String topicId, @Nullable Integer leftTimes, @Nullable Integer sessionTimeoutSeconds, @Nullable String localMsgId, @Nullable String msgText, @Nullable String remoteAccountId, @Nullable Integer contentType, @Nullable String failCode, @Nullable ChatGPTStoryData msg, @Nullable Boolean goneSendError) {
        return new ChatGPTStoryBean(sessionTaskId, topicId, leftTimes, sessionTimeoutSeconds, localMsgId, msgText, remoteAccountId, contentType, failCode, msg, goneSendError);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTStoryBean)) {
            return false;
        }
        ChatGPTStoryBean chatGPTStoryBean = (ChatGPTStoryBean) other;
        return Intrinsics.areEqual(this.sessionTaskId, chatGPTStoryBean.sessionTaskId) && Intrinsics.areEqual(this.topicId, chatGPTStoryBean.topicId) && Intrinsics.areEqual(this.leftTimes, chatGPTStoryBean.leftTimes) && Intrinsics.areEqual(this.sessionTimeoutSeconds, chatGPTStoryBean.sessionTimeoutSeconds) && Intrinsics.areEqual(this.localMsgId, chatGPTStoryBean.localMsgId) && Intrinsics.areEqual(this.msgText, chatGPTStoryBean.msgText) && Intrinsics.areEqual(this.remoteAccountId, chatGPTStoryBean.remoteAccountId) && Intrinsics.areEqual(this.contentType, chatGPTStoryBean.contentType) && Intrinsics.areEqual(this.failCode, chatGPTStoryBean.failCode) && Intrinsics.areEqual(this.msg, chatGPTStoryBean.msg) && Intrinsics.areEqual(this.goneSendError, chatGPTStoryBean.goneSendError);
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
    public final ChatGPTStoryData getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getMsgText() {
        return this.msgText;
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
    public final String getStoryDB() {
        return this.storyDB;
    }

    @Nullable
    public final String getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        String str = this.sessionTaskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.topicId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.leftTimes;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sessionTimeoutSeconds;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.localMsgId;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.msgText;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.remoteAccountId;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.contentType;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.failCode;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ChatGPTStoryData chatGPTStoryData = this.msg;
        int iHashCode10 = (iHashCode9 + (chatGPTStoryData == null ? 0 : chatGPTStoryData.hashCode())) * 31;
        Boolean bool = this.goneSendError;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setContentType(@Nullable Integer num) {
        this.contentType = num;
    }

    public final void setGoneSendError(@Nullable Boolean bool) {
        this.goneSendError = bool;
    }

    public final void setMsg(@Nullable ChatGPTStoryData chatGPTStoryData) {
        this.msg = chatGPTStoryData;
    }

    public final void setRemoteAccountId(@Nullable String str) {
        this.remoteAccountId = str;
    }

    public final void setStoryDB(@Nullable String str) {
        this.storyDB = str;
    }

    @NotNull
    public String toString() {
        return "ChatGPTStoryBean(sessionTaskId=" + this.sessionTaskId + ", topicId=" + this.topicId + ", leftTimes=" + this.leftTimes + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", localMsgId=" + this.localMsgId + ", msgText=" + this.msgText + ", remoteAccountId=" + this.remoteAccountId + ", contentType=" + this.contentType + ", failCode=" + this.failCode + ", msg=" + this.msg + ", goneSendError=" + this.goneSendError + ')';
    }

    public ChatGPTStoryBean(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num3, @Nullable String str6, @Nullable ChatGPTStoryData chatGPTStoryData, @Nullable Boolean bool) {
        this.sessionTaskId = str;
        this.topicId = str2;
        this.leftTimes = num;
        this.sessionTimeoutSeconds = num2;
        this.localMsgId = str3;
        this.msgText = str4;
        this.remoteAccountId = str5;
        this.contentType = num3;
        this.failCode = str6;
        this.msg = chatGPTStoryData;
        this.goneSendError = bool;
        this.storyDB = JSON.toJSONString(chatGPTStoryData);
    }
}
