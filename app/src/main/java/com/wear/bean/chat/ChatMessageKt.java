package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatMessage.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"convertToChatMessage", "Lcom/wear/bean/chat/ChatMessage;", "Lcom/wear/bean/chat/Message;", "convertToMessage", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMessageKt {
    @NotNull
    public static final ChatMessage convertToChatMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "<this>");
        String messageId = message.getMessageId();
        Long createTime = message.getCreateTime();
        Long createTime2 = message.getCreateTime();
        String fromAccountId = message.getFromAccountId();
        String toAccountId = message.getToAccountId();
        int type = message.getType();
        int chatType = message.getChatType();
        String content = message.getContent();
        return new ChatMessage(messageId, createTime, createTime2, null, fromAccountId, toAccountId, Integer.valueOf(type), chatType, message.getEncryptionMode(), content, null, 1032, null);
    }

    @NotNull
    public static final Message convertToMessage(@NotNull ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(chatMessage, "<this>");
        Message message = new Message();
        message.setMessageId(chatMessage.getMsgId());
        message.setCreateTime(chatMessage.getSeq());
        message.setFromAccountId(chatMessage.getFrom());
        message.setToAccountId(chatMessage.getTo());
        Integer type = chatMessage.getType();
        message.setType(type != null ? type.intValue() : -1);
        message.setChatType(chatMessage.getChatType());
        message.setEncryptionMode(chatMessage.getEncryptionMode());
        message.setContent(chatMessage.getBody());
        return message;
    }
}
