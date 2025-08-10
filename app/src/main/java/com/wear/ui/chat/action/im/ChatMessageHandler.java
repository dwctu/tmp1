package com.wear.ui.chat.action.im;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wear.bean.chat.ChatMessage;
import com.wear.bean.chat.ChatMessageKt;
import com.wear.bean.chat.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* compiled from: ChatMessageHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/chat/action/im/ChatMessageHandler;", "", "()V", "TAG", "", "listeners", "", "Lcom/wear/ui/chat/action/im/ChatMessageHandler$MessageHandlerListener;", "appendListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "handlerAudioMessage", "chatMessage", "Lcom/wear/bean/chat/ChatMessage;", "handlerMessage", "handlerMessages", "chatMessageList", "", "handlerTextMessage", "handlerUnSupportMessage", Registration.Feature.ELEMENT, "removeListener", "MessageHandlerListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMessageHandler {

    @NotNull
    private static final String TAG = "ChatMessageHandler";

    @NotNull
    public static final ChatMessageHandler INSTANCE = new ChatMessageHandler();

    @NotNull
    private static final List<MessageHandlerListener> listeners = new ArrayList();

    /* compiled from: ChatMessageHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/action/im/ChatMessageHandler$MessageHandlerListener;", "", "handlerMessage", "", "message", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface MessageHandlerListener {
        void handlerMessage(@NotNull Message message);
    }

    private ChatMessageHandler() {
    }

    private final void handlerMessage(ChatMessage chatMessage) {
        String str = "handlerMessage: " + chatMessage;
        Message messageConvertToMessage = ChatMessageKt.convertToMessage(chatMessage);
        messageConvertToMessage.setReceiveStatus(1);
        Iterator<MessageHandlerListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().handlerMessage(messageConvertToMessage);
        }
    }

    public final void appendListener(@NotNull MessageHandlerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    @CMD(id = 3)
    public final void handlerAudioMessage(@NotNull ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        handlerMessage(chatMessage);
    }

    public final void handlerMessages(@NotNull List<ChatMessage> chatMessageList) {
        Intrinsics.checkNotNullParameter(chatMessageList, "chatMessageList");
        Iterator<ChatMessage> it = chatMessageList.iterator();
        while (it.hasNext()) {
            handlerMessage(it.next());
        }
    }

    @CMD(id = 1)
    public final void handlerTextMessage(@NotNull ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        handlerMessage(chatMessage);
    }

    @CMD(id = -1)
    public final void handlerUnSupportMessage(@NotNull ChatMessage chatMessage) {
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        handlerMessage(chatMessage);
    }

    public final void register() {
        MessageHandlerDispatcher.INSTANCE.register(this);
    }

    public final void removeListener(@NotNull MessageHandlerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }
}
