package com.wear.bean.chat;

import com.google.firebase.messaging.Constants;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageConfig.kt */
@DatabaseTable(tableName = "tb_roulette_message_config")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/wear/bean/chat/MessageConfig;", "", "()V", "isShowEmojiAnimation", "", "()Z", "setShowEmojiAnimation", "(Z)V", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageConfig {

    @DatabaseField(columnName = Constants.MessagePayloadKeys.MSGID_SERVER, id = true)
    @Nullable
    private String messageId = UUID.randomUUID().toString();

    @DatabaseField(columnName = "show_emoji_animation")
    private boolean isShowEmojiAnimation = true;

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: isShowEmojiAnimation, reason: from getter */
    public final boolean getIsShowEmojiAnimation() {
        return this.isShowEmojiAnimation;
    }

    public final void setMessageId(@Nullable String str) {
        this.messageId = str;
    }

    public final void setShowEmojiAnimation(boolean z) {
        this.isShowEmojiAnimation = z;
    }
}
