package com.wear.bean.chat;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.nd3;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Message.kt */
@DatabaseTable(tableName = "tb_roulette_message")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0001J!\u0010I\u001a\u0004\u0018\u0001HJ\"\u0004\b\u0000\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0L¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\"\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00105\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\"\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b9\u00101\"\u0004\b:\u00103R\u0016\u0010;\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u001a\u0010=\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R \u0010@\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000eR\u001e\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\b¨\u0006P"}, d2 = {"Lcom/wear/bean/chat/Message;", "", "()V", "chatType", "", "getChatType", "()I", "setChatType", "(I)V", FirebaseAnalytics.Param.CONTENT, "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "direction", "getDirection", "encryptionMode", "getEncryptionMode", "setEncryptionMode", "extra", "getExtra", "setExtra", "fromAccountId", "getFromAccountId", "setFromAccountId", "isSelected", "", "()Z", "setSelected", "(Z)V", "messageConfig", "Lcom/wear/bean/chat/MessageConfig;", "getMessageConfig", "()Lcom/wear/bean/chat/MessageConfig;", "setMessageConfig", "(Lcom/wear/bean/chat/MessageConfig;)V", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "getMessageId", "setMessageId", "receiveStatus", "getReceiveStatus", "()Ljava/lang/Integer;", "setReceiveStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "replyMessage", "getReplyMessage", "setReplyMessage", "sendStatus", "getSendStatus", "setSendStatus", "signalingType", "getSignalingType", "skipSend", "getSkipSend", "setSkipSend", "toAccountId", "getToAccountId", "setToAccountId", "type", "getType", "setType", "bindContentData", "", Languages.ANY, "getContentData", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class Message {
    public static final int DIRECTION_RECEIVE = 1;
    public static final int DIRECTION_SEND = 0;
    public static final int STATUS_RECEIVE_READ = 1;
    public static final int STATUS_RECEIVE_UNREAD = 0;
    public static final int STATUS_SENDING = 0;
    public static final int STATUS_SEND_FAIL = 2;
    public static final int STATUS_SEND_SUCCESS = 1;
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_NOT_SUPPORT = -1;
    public static final int TYPE_SYSTEM = 0;
    public static final int TYPE_TEXT = 1;

    @DatabaseField(columnName = "chat_type")
    private int chatType;

    @DatabaseField(columnName = FirebaseAnalytics.Param.CONTENT)
    @Nullable
    private String content;

    @DatabaseField(columnName = "extra")
    @Nullable
    private String extra;

    @DatabaseField(columnName = "from_account_id")
    @Nullable
    private String fromAccountId;
    private boolean isSelected;

    @Nullable
    private MessageConfig messageConfig;

    @DatabaseField(columnName = "reply_message")
    @Nullable
    private String replyMessage;

    @DatabaseField(columnName = "send_status")
    @Nullable
    private Integer sendStatus;

    @DatabaseField(columnName = "signaling_type")
    private final int signalingType;
    private boolean skipSend;

    @DatabaseField(columnName = "to_account_id")
    @Nullable
    private String toAccountId;

    @DatabaseField(columnName = "type")
    private int type;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<Integer> supportType = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 3});

    @DatabaseField(columnName = Constants.MessagePayloadKeys.MSGID_SERVER, id = true)
    @Nullable
    private String messageId = UUID.randomUUID().toString();

    @DatabaseField(columnName = "create_time")
    @Nullable
    private Long createTime = Long.valueOf(System.currentTimeMillis() - MyApplication.N().h);

    @DatabaseField(columnName = "encryption_mode")
    @Nullable
    private String encryptionMode = "DH";

    @DatabaseField(columnName = "receive_status")
    @Nullable
    private Integer receiveStatus = 1;

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/chat/Message$Companion;", "", "()V", "DIRECTION_RECEIVE", "", "DIRECTION_SEND", "STATUS_RECEIVE_READ", "STATUS_RECEIVE_UNREAD", "STATUS_SENDING", "STATUS_SEND_FAIL", "STATUS_SEND_SUCCESS", "TYPE_AUDIO", "TYPE_NOT_SUPPORT", "TYPE_SYSTEM", "TYPE_TEXT", "supportType", "", "getSupportType", "()Ljava/util/List;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Integer> getSupportType() {
            return Message.supportType;
        }
    }

    public final void bindContentData(@NotNull Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        this.content = nd3.n(WearUtils.A.toJson(any));
    }

    public final int getChatType() {
        return this.chatType;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final <T> T getContentData(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) WearUtils.A.fromJson(nd3.d(this.content), (Class) clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return clazz.newInstance();
        }
    }

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    public final int getDirection() {
        return Intrinsics.areEqual(this.toAccountId, ch3.n().o().getAppAccountCode()) ? 1 : 0;
    }

    @Nullable
    public final String getEncryptionMode() {
        return this.encryptionMode;
    }

    @Nullable
    public final String getExtra() {
        return this.extra;
    }

    @Nullable
    public final String getFromAccountId() {
        return this.fromAccountId;
    }

    @Nullable
    public final MessageConfig getMessageConfig() {
        String str = this.messageId;
        if (str != null) {
            return DaoUtils.getChatMessageConfigDao().queryForMessageId(str);
        }
        return null;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final Integer getReceiveStatus() {
        return this.receiveStatus;
    }

    @Nullable
    public final String getReplyMessage() {
        return this.replyMessage;
    }

    @Nullable
    public final Integer getSendStatus() {
        return this.sendStatus;
    }

    public int getSignalingType() {
        return this.signalingType;
    }

    public final boolean getSkipSend() {
        return this.skipSend;
    }

    @Nullable
    public final String getToAccountId() {
        return this.toAccountId;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setChatType(int i) {
        this.chatType = i;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCreateTime(@Nullable Long l) {
        this.createTime = l;
    }

    public final void setEncryptionMode(@Nullable String str) {
        this.encryptionMode = str;
    }

    public final void setExtra(@Nullable String str) {
        this.extra = str;
    }

    public final void setFromAccountId(@Nullable String str) {
        this.fromAccountId = str;
    }

    public final void setMessageConfig(@Nullable MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }

    public final void setMessageId(@Nullable String str) {
        this.messageId = str;
    }

    public final void setReceiveStatus(@Nullable Integer num) {
        this.receiveStatus = num;
    }

    public final void setReplyMessage(@Nullable String str) {
        this.replyMessage = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setSendStatus(@Nullable Integer num) {
        this.sendStatus = num;
    }

    public final void setSkipSend(boolean z) {
        this.skipSend = z;
    }

    public final void setToAccountId(@Nullable String str) {
        this.toAccountId = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "Message(messageId='" + this.messageId + "', fromAccountId=" + this.fromAccountId + ", toAccountId=" + this.toAccountId + ", createTime=" + this.createTime + ", type=" + this.type + ", signalingType=" + getSignalingType() + ", content=" + this.content + ", sendStatus=" + this.sendStatus + ", receiveStatus=" + this.receiveStatus + ", chatType=" + this.chatType + ", replyMessage=" + this.replyMessage + ", extra=" + this.extra + ", direction=" + getDirection() + ')';
    }
}
