package org.jivesoftware.smack.chat;

import dc.zb2;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ThreadFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class ChatManager extends Manager {
    private static final Map<XMPPConnection, ChatManager> INSTANCES = new WeakHashMap();
    private static boolean defaultIsNormalInclude = true;
    private static MatchMode defaultMatchMode = MatchMode.BARE_JID;
    private Map<String, Chat> baseJidChats;
    private Set<ChatManagerListener> chatManagerListeners;
    private Map<MessageListener, StanzaFilter> interceptors;
    private Map<String, Chat> jidChats;
    private MatchMode matchMode;
    private boolean normalIncluded;
    private final StanzaFilter packetFilter;
    private final StanzaFilter packetFilterBoard;
    private final StanzaFilter packetFilterOfflinemsg;
    private final StanzaFilter packetFilterSub;
    private Map<String, Chat> threadChats;

    public enum MatchMode {
        NONE,
        SUPPLIED_JID,
        BARE_JID
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        OrFilter orFilter = new OrFilter(MessageTypeFilter.CHAT, new FlexibleStanzaTypeFilter<Message>() { // from class: org.jivesoftware.smack.chat.ChatManager.1
            @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
            public boolean acceptSpecific(Message message) {
                return ChatManager.this.normalIncluded && message.getType() == Message.Type.normal;
            }
        });
        this.packetFilter = orFilter;
        OrFilter orFilter2 = new OrFilter(MessageTypeFilter.BROAD, new FlexibleStanzaTypeFilter<Message>() { // from class: org.jivesoftware.smack.chat.ChatManager.2
            @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
            public boolean acceptSpecific(Message message) {
                return message.getType() == Message.Type.broad;
            }
        });
        this.packetFilterBoard = orFilter2;
        OrFilter orFilter3 = new OrFilter(MessageTypeFilter.SUB, new FlexibleStanzaTypeFilter<Message>() { // from class: org.jivesoftware.smack.chat.ChatManager.3
            @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
            public boolean acceptSpecific(Message message) {
                return message.getType() == Message.Type.sub;
            }
        });
        this.packetFilterSub = orFilter3;
        OrFilter orFilter4 = new OrFilter(MessageTypeFilter.OFFLINEMSG, new FlexibleStanzaTypeFilter<Message>() { // from class: org.jivesoftware.smack.chat.ChatManager.4
            @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
            public boolean acceptSpecific(Message message) {
                return message.getType() == Message.Type.offlinemsg;
            }
        });
        this.packetFilterOfflinemsg = orFilter4;
        this.normalIncluded = defaultIsNormalInclude;
        this.matchMode = defaultMatchMode;
        this.threadChats = new ConcurrentHashMap();
        this.jidChats = new ConcurrentHashMap();
        this.baseJidChats = new ConcurrentHashMap();
        this.chatManagerListeners = new CopyOnWriteArraySet();
        this.interceptors = new WeakHashMap();
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat.ChatManager.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Message message = (Message) stanza;
                Chat userChat = message.getThread() == null ? ChatManager.this.getUserChat(message.getFrom()) : ChatManager.this.getThreadChat(message.getThread());
                if (userChat == null) {
                    userChat = ChatManager.this.createChat(message);
                }
                if (userChat == null) {
                    return;
                }
                ChatManager.this.deliverMessage(userChat, message);
            }
        }, orFilter);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat.ChatManager.6
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                zb2.O().H((Message) stanza);
            }
        }, orFilter2);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat.ChatManager.7
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                zb2.O().T0((Message) stanza);
            }
        }, orFilter3);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smack.chat.ChatManager.8
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                zb2.O().J((Message) stanza);
            }
        }, orFilter4);
        INSTANCES.put(xMPPConnection, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverMessage(Chat chat, Message message) {
        chat.deliver(message);
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        chatManager = INSTANCES.get(xMPPConnection);
        if (chatManager == null) {
            chatManager = new ChatManager(xMPPConnection);
        }
        return chatManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Chat getUserChat(String str) {
        if (this.matchMode == MatchMode.NONE || str == null) {
            return null;
        }
        Chat chat = this.jidChats.get(str);
        return (chat == null && this.matchMode == MatchMode.BARE_JID) ? this.baseJidChats.get(XmppStringUtils.parseBareJid(str)) : chat;
    }

    private static String nextID() {
        return UUID.randomUUID().toString();
    }

    public static void setDefaultIsNormalIncluded(boolean z) {
        defaultIsNormalInclude = z;
    }

    public static void setDefaultMatchMode(MatchMode matchMode) {
        defaultMatchMode = matchMode;
    }

    public void addChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.add(chatManagerListener);
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener) {
        addOutgoingMessageInterceptor(messageListener, null);
    }

    public void closeChat(Chat chat) {
        this.threadChats.remove(chat.getThreadID());
        String participant = chat.getParticipant();
        this.jidChats.remove(participant);
        this.baseJidChats.remove(XmppStringUtils.parseBareJid(participant));
    }

    public Chat createChat(String str) {
        return createChat(str, null);
    }

    public PacketCollector createPacketCollector(Chat chat) {
        return connection().createPacketCollector(new AndFilter(new ThreadFilter(chat.getThreadID()), FromMatchesFilter.create(chat.getParticipant())));
    }

    public Set<ChatManagerListener> getChatListeners() {
        return Collections.unmodifiableSet(this.chatManagerListeners);
    }

    public MatchMode getMatchMode() {
        return this.matchMode;
    }

    public Chat getThreadChat(String str) {
        return this.threadChats.get(str);
    }

    public boolean isNormalIncluded() {
        return this.normalIncluded;
    }

    public void removeChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.remove(chatManagerListener);
    }

    public void sendMessage(Chat chat, Message message) throws SmackException.NotConnectedException {
        for (Map.Entry<MessageListener, StanzaFilter> entry : this.interceptors.entrySet()) {
            StanzaFilter value = entry.getValue();
            if (value != null && value.accept(message)) {
                entry.getKey().processMessage(message);
            }
        }
        if (message.getFrom() == null) {
            message.setFrom(connection().getUser());
        }
        connection().sendStanza(message);
    }

    public void setMatchMode(MatchMode matchMode) {
        this.matchMode = matchMode;
    }

    public void setNormalIncluded(boolean z) {
        this.normalIncluded = z;
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener, StanzaFilter stanzaFilter) {
        if (messageListener == null) {
            return;
        }
        this.interceptors.put(messageListener, stanzaFilter);
    }

    public Chat createChat(String str, ChatMessageListener chatMessageListener) {
        return createChat(str, (String) null, chatMessageListener);
    }

    public Chat createChat(String str, String str2, ChatMessageListener chatMessageListener) {
        if (str2 == null) {
            str2 = nextID();
        }
        if (this.threadChats.get(str2) == null) {
            Chat chatCreateChat = createChat(str, str2, true);
            chatCreateChat.addMessageListener(chatMessageListener);
            return chatCreateChat;
        }
        throw new IllegalArgumentException("ThreadID is already used");
    }

    private Chat createChat(String str, String str2, boolean z) {
        Chat chat = new Chat(this, str, str2);
        this.threadChats.put(str2, chat);
        this.jidChats.put(str, chat);
        this.baseJidChats.put(XmppStringUtils.parseBareJid(str), chat);
        Iterator<ChatManagerListener> it = this.chatManagerListeners.iterator();
        while (it.hasNext()) {
            it.next().chatCreated(chat, z);
        }
        return chat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Chat createChat(Message message) {
        String from = message.getFrom();
        if (from == null) {
            return null;
        }
        String thread = message.getThread();
        if (thread == null) {
            thread = nextID();
        }
        return createChat(from, thread, false);
    }
}
