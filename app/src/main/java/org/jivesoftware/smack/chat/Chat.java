package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes5.dex */
public class Chat {
    private ChatManager chatManager;
    private final Set<ChatMessageListener> listeners = new CopyOnWriteArraySet();
    private String participant;
    private String threadID;

    public Chat(ChatManager chatManager, String str, String str2) {
        if (StringUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Thread ID must not be null");
        }
        this.chatManager = chatManager;
        this.participant = str;
        this.threadID = str2;
    }

    public void addMessageListener(ChatMessageListener chatMessageListener) {
        if (chatMessageListener == null) {
            return;
        }
        this.listeners.add(chatMessageListener);
    }

    public void close() {
        this.chatManager.closeChat(this);
        this.listeners.clear();
    }

    public PacketCollector createCollector() {
        return this.chatManager.createPacketCollector(this);
    }

    public void deliver(Message message) {
        message.setThread(this.threadID);
        Iterator<ChatMessageListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().processMessage(this, message);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Chat) {
            Chat chat = (Chat) obj;
            if (this.threadID.equals(chat.getThreadID()) && this.participant.equals(chat.getParticipant())) {
                return true;
            }
        }
        return false;
    }

    public Set<ChatMessageListener> getListeners() {
        return Collections.unmodifiableSet(this.listeners);
    }

    public String getParticipant() {
        return this.participant;
    }

    public String getThreadID() {
        return this.threadID;
    }

    public int hashCode() {
        return ((this.threadID.hashCode() + 31) * 31) + this.participant.hashCode();
    }

    public void removeMessageListener(ChatMessageListener chatMessageListener) {
        this.listeners.remove(chatMessageListener);
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException {
        Message message = new Message();
        message.setBody(str);
        sendMessage(message);
    }

    public String toString() {
        return "Chat [(participant=" + this.participant + "), (thread=" + this.threadID + ")]";
    }

    public void sendMessage(Message message) throws SmackException.NotConnectedException {
        message.setTo(this.participant);
        message.setType(Message.Type.chat);
        message.setThread(this.threadID);
        this.chatManager.sendMessage(this, message);
    }
}
