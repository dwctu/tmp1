package org.jivesoftware.smackx.chatstates;

import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatMessageListener;

/* loaded from: classes5.dex */
public interface ChatStateListener extends ChatMessageListener {
    void stateChanged(Chat chat, ChatState chatState);
}
