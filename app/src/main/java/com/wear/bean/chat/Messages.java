package com.wear.bean.chat;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Messages.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/wear/bean/chat/Messages;", "", "()V", "obtainAudioMessage", "Lcom/wear/bean/chat/Message;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "audioUrl", TypedValues.TransitionType.S_DURATION, "", "obtainSystemMessage", "text", "obtainTextMessage", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Messages {

    @NotNull
    public static final Messages INSTANCE = new Messages();

    private Messages() {
    }

    @NotNull
    public final Message obtainAudioMessage(@NotNull String messageId, @NotNull String audioUrl, int duration) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        Message message = new Message();
        message.setMessageId(messageId);
        message.setType(3);
        message.bindContentData(new MessageBody(null, audioUrl, null, null, Integer.valueOf(duration), null, 45, null));
        return message;
    }

    @NotNull
    public final Message obtainSystemMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Message message = new Message();
        message.setType(0);
        message.bindContentData(new MessageBody(text, null, null, null, null, null, 62, null));
        return message;
    }

    @NotNull
    public final Message obtainTextMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Message message = new Message();
        message.setType(1);
        message.bindContentData(new MessageBody(text, null, null, null, null, null, 62, null));
        return message;
    }
}
