package com.wear.bean.chat;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: MessageConfig.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"defaultMessageConfig", "Lcom/wear/bean/chat/MessageConfig;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageConfigKt {
    @NotNull
    public static final MessageConfig defaultMessageConfig(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        MessageConfig messageConfig = new MessageConfig();
        messageConfig.setMessageId(messageId);
        messageConfig.setShowEmojiAnimation(false);
        return messageConfig;
    }
}
