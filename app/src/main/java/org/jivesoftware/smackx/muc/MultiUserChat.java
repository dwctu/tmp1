package org.jivesoftware.smackx.muc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.PresenceListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithSubjectFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.filter.ToFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCAdmin;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCMember;
import org.jivesoftware.smackx.muc.packet.MUCOwner;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jivesoftware.smackx.muc.packet.MUCUsers;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class MultiUserChat {
    private static final Logger LOGGER = Logger.getLogger(MultiUserChat.class.getName());
    private final XMPPConnection connection;
    private final StanzaListener declinesListener;
    private final StanzaFilter fromRoomFilter;
    private final StanzaFilter fromRoomGroupchatFilter;
    private PacketCollector messageCollector;
    private final StanzaListener messageListener;
    private final MultiUserChatManager multiUserChatManager;
    private final StanzaListener presenceInterceptor;
    private final StanzaListener presenceListener;
    private final String room;
    private String subject;
    private final StanzaListener subjectListener;
    private final Map<String, Presence> occupantsMap = new ConcurrentHashMap();
    private final Set<InvitationRejectionListener> invitationRejectionListeners = new CopyOnWriteArraySet();
    private final Set<SubjectUpdatedListener> subjectUpdatedListeners = new CopyOnWriteArraySet();
    private final Set<UserStatusListener> userStatusListeners = new CopyOnWriteArraySet();
    private final Set<ParticipantStatusListener> participantStatusListeners = new CopyOnWriteArraySet();
    private final Set<MessageListener> messageListeners = new CopyOnWriteArraySet();
    private final Set<PresenceListener> presenceListeners = new CopyOnWriteArraySet();
    private final Set<PresenceListener> presenceInterceptors = new CopyOnWriteArraySet();
    private String nickname = null;
    private boolean joined = false;

    /* renamed from: org.jivesoftware.smackx.muc.MultiUserChat$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;

        static {
            int[] iArr = new int[Presence.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$Presence$Type = iArr;
            try {
                iArr[Presence.Type.available.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.unavailable.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MultiUserChat(XMPPConnection xMPPConnection, String str, MultiUserChatManager multiUserChatManager) {
        this.connection = xMPPConnection;
        this.room = str.toLowerCase(Locale.US);
        this.multiUserChatManager = multiUserChatManager;
        FromMatchesFilter fromMatchesFilterCreate = FromMatchesFilter.create(str);
        this.fromRoomFilter = fromMatchesFilterCreate;
        this.fromRoomGroupchatFilter = new AndFilter(fromMatchesFilterCreate, MessageTypeFilter.GROUPCHAT);
        this.messageListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.1
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                Message message = (Message) stanza;
                Iterator it = MultiUserChat.this.messageListeners.iterator();
                while (it.hasNext()) {
                    ((MessageListener) it.next()).processMessage(message);
                }
            }
        };
        this.subjectListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Message message = (Message) stanza;
                MultiUserChat.this.subject = message.getSubject();
                Iterator it = MultiUserChat.this.subjectUpdatedListeners.iterator();
                while (it.hasNext()) {
                    ((SubjectUpdatedListener) it.next()).subjectUpdated(MultiUserChat.this.subject, message.getFrom());
                }
            }
        };
        this.presenceListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Presence presence = (Presence) stanza;
                String from = presence.getFrom();
                String str2 = MultiUserChat.this.room + "/" + MultiUserChat.this.nickname;
                boolean zEquals = presence.getFrom().equals(str2);
                int i = AnonymousClass7.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MultiUserChat.this.occupantsMap.remove(from);
                        MUCUser mUCUserFrom = MUCUser.from(stanza);
                        if (mUCUserFrom != null && mUCUserFrom.hasStatus()) {
                            MultiUserChat.this.checkPresenceCode(mUCUserFrom.getStatus(), presence.getFrom().equals(str2), mUCUserFrom, from);
                        } else if (!zEquals) {
                            Iterator it = MultiUserChat.this.participantStatusListeners.iterator();
                            while (it.hasNext()) {
                                ((ParticipantStatusListener) it.next()).left(from);
                            }
                        }
                    }
                } else if (((Presence) MultiUserChat.this.occupantsMap.put(from, presence)) != null) {
                    MUCUser mUCUserFrom2 = MUCUser.from(stanza);
                    MUCAffiliation affiliation = mUCUserFrom2.getItem().getAffiliation();
                    MUCRole role = mUCUserFrom2.getItem().getRole();
                    MUCUser mUCUserFrom3 = MUCUser.from(stanza);
                    MUCAffiliation affiliation2 = mUCUserFrom3.getItem().getAffiliation();
                    MultiUserChat.this.checkRoleModifications(role, mUCUserFrom3.getItem().getRole(), zEquals, from);
                    MultiUserChat.this.checkAffiliationModifications(affiliation, affiliation2, zEquals, from);
                } else if (!zEquals) {
                    Iterator it2 = MultiUserChat.this.participantStatusListeners.iterator();
                    while (it2.hasNext()) {
                        ((ParticipantStatusListener) it2.next()).joined(from);
                    }
                }
                Iterator it3 = MultiUserChat.this.presenceListeners.iterator();
                while (it3.hasNext()) {
                    ((PresenceListener) it3.next()).processPresence(presence);
                }
            }
        };
        this.declinesListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                MUCUser mUCUserFrom = MUCUser.from(stanza);
                if (mUCUserFrom.getDecline() == null) {
                    return;
                }
                MultiUserChat.this.fireInvitationRejectionListeners(mUCUserFrom.getDecline().getFrom(), mUCUserFrom.getDecline().getReason());
            }
        };
        this.presenceInterceptor = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Presence presence = (Presence) stanza;
                Iterator it = MultiUserChat.this.presenceInterceptors.iterator();
                while (it.hasNext()) {
                    ((PresenceListener) it.next()).processPresence(presence);
                }
            }
        };
    }

    private void changeAffiliationByAdmin(String str, MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, mUCAffiliation, null);
    }

    private void changeRole(String str, MUCRole mUCRole, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCRole, str, str2));
        this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAffiliationModifications(MUCAffiliation mUCAffiliation, MUCAffiliation mUCAffiliation2, boolean z, String str) {
        if (!"owner".equals(mUCAffiliation) || "owner".equals(mUCAffiliation2)) {
            if (!"admin".equals(mUCAffiliation) || "admin".equals(mUCAffiliation2)) {
                if ("member".equals(mUCAffiliation) && !"member".equals(mUCAffiliation2)) {
                    if (z) {
                        Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                        while (it.hasNext()) {
                            it.next().membershipRevoked();
                        }
                    } else {
                        Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                        while (it2.hasNext()) {
                            it2.next().membershipRevoked(str);
                        }
                    }
                }
            } else if (z) {
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().adminRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().adminRevoked(str);
                }
            }
        } else if (z) {
            Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
            while (it5.hasNext()) {
                it5.next().ownershipRevoked();
            }
        } else {
            Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
            while (it6.hasNext()) {
                it6.next().ownershipRevoked(str);
            }
        }
        if (!"owner".equals(mUCAffiliation) && "owner".equals(mUCAffiliation2)) {
            if (z) {
                Iterator<UserStatusListener> it7 = this.userStatusListeners.iterator();
                while (it7.hasNext()) {
                    it7.next().ownershipGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it8 = this.participantStatusListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().ownershipGranted(str);
                }
                return;
            }
        }
        if (!"admin".equals(mUCAffiliation) && "admin".equals(mUCAffiliation2)) {
            if (z) {
                Iterator<UserStatusListener> it9 = this.userStatusListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().adminGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it10 = this.participantStatusListeners.iterator();
                while (it10.hasNext()) {
                    it10.next().adminGranted(str);
                }
                return;
            }
        }
        if ("member".equals(mUCAffiliation) || !"member".equals(mUCAffiliation2)) {
            return;
        }
        if (z) {
            Iterator<UserStatusListener> it11 = this.userStatusListeners.iterator();
            while (it11.hasNext()) {
                it11.next().membershipGranted();
            }
        } else {
            Iterator<ParticipantStatusListener> it12 = this.participantStatusListeners.iterator();
            while (it12.hasNext()) {
                it12.next().membershipGranted(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPresenceCode(Set<MUCUser.Status> set, boolean z, MUCUser mUCUser, String str) {
        if (set.contains(MUCUser.Status.KICKED_307)) {
            if (z) {
                this.joined = false;
                Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().kicked(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
                this.occupantsMap.clear();
                this.nickname = null;
                userHasLeft();
            } else {
                Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().kicked(str, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.BANNED_301)) {
            if (z) {
                this.joined = false;
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().banned(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
                this.occupantsMap.clear();
                this.nickname = null;
                userHasLeft();
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().banned(str, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.REMOVED_AFFIL_CHANGE_321) && z) {
            this.joined = false;
            Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
            while (it5.hasNext()) {
                it5.next().membershipRevoked();
            }
            this.occupantsMap.clear();
            this.nickname = null;
            userHasLeft();
        }
        if (set.contains(MUCUser.Status.NEW_NICKNAME_303)) {
            Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
            while (it6.hasNext()) {
                it6.next().nicknameChanged(str, mUCUser.getItem().getNick());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRoleModifications(MUCRole mUCRole, MUCRole mUCRole2, boolean z, String str) {
        if (("visitor".equals(mUCRole) || "none".equals(mUCRole)) && "participant".equals(mUCRole2)) {
            if (z) {
                Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().voiceGranted();
                }
            } else {
                Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().voiceGranted(str);
                }
            }
        } else if ("participant".equals(mUCRole) && ("visitor".equals(mUCRole2) || "none".equals(mUCRole2))) {
            if (z) {
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().voiceRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().voiceRevoked(str);
                }
            }
        }
        if (!"moderator".equals(mUCRole) && "moderator".equals(mUCRole2)) {
            if ("visitor".equals(mUCRole) || "none".equals(mUCRole)) {
                if (z) {
                    Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
                    while (it5.hasNext()) {
                        it5.next().voiceGranted();
                    }
                } else {
                    Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
                    while (it6.hasNext()) {
                        it6.next().voiceGranted(str);
                    }
                }
            }
            if (z) {
                Iterator<UserStatusListener> it7 = this.userStatusListeners.iterator();
                while (it7.hasNext()) {
                    it7.next().moderatorGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it8 = this.participantStatusListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().moderatorGranted(str);
                }
                return;
            }
        }
        if (!"moderator".equals(mUCRole) || "moderator".equals(mUCRole2)) {
            return;
        }
        if ("visitor".equals(mUCRole2) || "none".equals(mUCRole2)) {
            if (z) {
                Iterator<UserStatusListener> it9 = this.userStatusListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().voiceRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it10 = this.participantStatusListeners.iterator();
                while (it10.hasNext()) {
                    it10.next().voiceRevoked(str);
                }
            }
        }
        if (z) {
            Iterator<UserStatusListener> it11 = this.userStatusListeners.iterator();
            while (it11.hasNext()) {
                it11.next().moderatorRevoked();
            }
        } else {
            Iterator<ParticipantStatusListener> it12 = this.participantStatusListeners.iterator();
            while (it12.hasNext()) {
                it12.next().moderatorRevoked(str);
            }
        }
    }

    private Presence enter(String str, String str2, DiscussionHistory discussionHistory, long j) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        StringUtils.requireNotNullOrEmpty(str, "Nickname must not be null or blank.");
        Stanza presence = new Presence(Presence.Type.available);
        presence.setTo(this.room + "/" + str);
        MUCInitialPresence mUCInitialPresence = new MUCInitialPresence();
        if (str2 != null) {
            mUCInitialPresence.setPassword(str2);
        }
        if (discussionHistory != null) {
            mUCInitialPresence.setHistory(discussionHistory.getMUCHistory());
        }
        presence.addExtension(mUCInitialPresence);
        AndFilter andFilter = new AndFilter(FromMatchesFilter.createFull(this.room + "/" + str), new StanzaTypeFilter(Presence.class));
        this.connection.addSyncStanzaListener(this.messageListener, this.fromRoomGroupchatFilter);
        XMPPConnection xMPPConnection = this.connection;
        StanzaListener stanzaListener = this.presenceListener;
        StanzaTypeFilter stanzaTypeFilter = StanzaTypeFilter.PRESENCE;
        xMPPConnection.addSyncStanzaListener(stanzaListener, new AndFilter(this.fromRoomFilter, stanzaTypeFilter));
        this.connection.addSyncStanzaListener(this.subjectListener, new AndFilter(this.fromRoomFilter, MessageWithSubjectFilter.INSTANCE));
        this.connection.addSyncStanzaListener(this.declinesListener, new AndFilter(new StanzaExtensionFilter("x", "http://jabber.org/protocol/muc#user"), new NotFilter(MessageTypeFilter.ERROR)));
        this.connection.addPacketInterceptor(this.presenceInterceptor, new AndFilter(new ToFilter(this.room), stanzaTypeFilter));
        this.messageCollector = this.connection.createPacketCollector(this.fromRoomGroupchatFilter);
        try {
            Presence presence2 = (Presence) this.connection.createPacketCollectorAndSend(andFilter, presence).nextResultOrThrow(j);
            this.nickname = str;
            this.joined = true;
            this.multiUserChatManager.addJoinedRoom(this.room);
            return presence2;
        } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException e) {
            removeConnectionCallbacks();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireInvitationRejectionListeners(String str, String str2) {
        int size;
        InvitationRejectionListener[] invitationRejectionListenerArr;
        synchronized (this.invitationRejectionListeners) {
            size = this.invitationRejectionListeners.size();
            invitationRejectionListenerArr = new InvitationRejectionListener[size];
            this.invitationRejectionListeners.toArray(invitationRejectionListenerArr);
        }
        for (int i = 0; i < size; i++) {
            invitationRejectionListenerArr[i].invitationDeclined(str, str2);
        }
    }

    private List<Affiliate> getAffiliatesByAdmin(MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation));
        MUCAdmin mUCAdmin2 = (MUCAdmin) this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
        ArrayList arrayList = new ArrayList();
        Iterator<MUCItem> it = mUCAdmin2.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new Affiliate(it.next()));
        }
        return arrayList;
    }

    private void removeConnectionCallbacks() {
        this.connection.removeSyncStanzaListener(this.messageListener);
        this.connection.removeSyncStanzaListener(this.presenceListener);
        this.connection.removeSyncStanzaListener(this.declinesListener);
        this.connection.removePacketInterceptor(this.presenceInterceptor);
        PacketCollector packetCollector = this.messageCollector;
        if (packetCollector != null) {
            packetCollector.cancel();
            this.messageCollector = null;
        }
    }

    private synchronized void userHasLeft() {
        this.multiUserChatManager.removeJoinedRoom(this.room);
        removeConnectionCallbacks();
    }

    public boolean addInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.add(invitationRejectionListener);
    }

    public boolean addMessageListener(MessageListener messageListener) {
        return this.messageListeners.add(messageListener);
    }

    public boolean addParticipantListener(PresenceListener presenceListener) {
        return this.presenceListeners.add(presenceListener);
    }

    public boolean addParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.add(participantStatusListener);
    }

    public void addPresenceInterceptor(PresenceListener presenceListener) {
        this.presenceInterceptors.add(presenceListener);
    }

    public boolean addSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.add(subjectUpdatedListener);
    }

    public boolean addUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.add(userStatusListener);
    }

    public void banUser(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.outcast, str2);
    }

    public void banUsers(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.outcast);
    }

    public void changeAvailabilityStatus(String str, Presence.Mode mode) throws SmackException.NotConnectedException {
        StringUtils.requireNotNullOrEmpty(this.nickname, "Nickname must not be null or blank.");
        if (!this.joined) {
            throw new IllegalStateException("Must be logged into the room to change the availability status.");
        }
        Presence presence = new Presence(Presence.Type.available);
        presence.setStatus(str);
        presence.setMode(mode);
        presence.setTo(this.room + "/" + this.nickname);
        this.connection.sendStanza(presence);
    }

    public void changeNickname(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        StringUtils.requireNotNullOrEmpty(str, "Nickname must not be null or blank.");
        if (!this.joined) {
            throw new IllegalStateException("Must be logged into the room to change nickname.");
        }
        Presence presence = new Presence(Presence.Type.available);
        presence.setTo(this.room + "/" + str);
        this.connection.createPacketCollectorAndSend(new AndFilter(FromMatchesFilter.createFull(this.room + "/" + str), new StanzaTypeFilter(Presence.class)), presence).nextResultOrThrow();
        this.nickname = str;
    }

    public void changeSubject(final String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Message messageCreateMessage = createMessage();
        messageCreateMessage.setSubject(str);
        this.connection.createPacketCollectorAndSend(new AndFilter(this.fromRoomGroupchatFilter, new StanzaFilter() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.6
            @Override // org.jivesoftware.smack.filter.StanzaFilter
            public boolean accept(Stanza stanza) {
                return str.equals(((Message) stanza).getSubject());
            }
        }), messageCreateMessage).nextResultOrThrow();
    }

    public synchronized void create(String str) throws SmackException, XMPPException.XMPPErrorException {
        if (this.joined) {
            throw new IllegalStateException("Creation failed - User already joined the room.");
        }
        if (!createOrJoin(str)) {
            leave();
            throw new SmackException("Creation failed - Missing acknowledge of room creation.");
        }
    }

    public Message createMessage() {
        return new Message(this.room, Message.Type.groupchat);
    }

    public synchronized boolean createOrJoin(String str) throws SmackException, XMPPException.XMPPErrorException {
        return createOrJoin(str, null, null, this.connection.getPacketReplyTimeout());
    }

    public Chat createPrivateChat(String str, ChatMessageListener chatMessageListener) {
        return ChatManager.getInstanceFor(this.connection).createChat(str, chatMessageListener);
    }

    public void destroy(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        Destroy destroy = new Destroy();
        destroy.setReason(str);
        destroy.setJid(str2);
        mUCOwner.setDestroy(destroy);
        this.connection.createPacketCollectorAndSend(mUCOwner).nextResultOrThrow();
        this.occupantsMap.clear();
        this.nickname = null;
        this.joined = false;
        userHasLeft();
    }

    public List<Affiliate> getAdmins() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.admin);
    }

    public List<Affiliate> getAllOwners() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCMember mUCMember = new MUCMember();
        mUCMember.setTo(this.room);
        mUCMember.setType(IQ.Type.get);
        mUCMember.setRoom(this.room);
        MUCMember mUCMember2 = (MUCMember) this.connection.createPacketCollectorAndSend(mUCMember).nextResultOrThrow();
        ArrayList arrayList = new ArrayList();
        Iterator<MUCItem> it = mUCMember2.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new Affiliate(it.next()));
        }
        return arrayList;
    }

    public Form getConfigurationForm() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.get);
        return Form.getFormFrom((IQ) this.connection.createPacketCollectorAndSend(mUCOwner).nextResultOrThrow());
    }

    public List<Affiliate> getMembers() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.member);
    }

    public List<Occupant> getModerators() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getOccupants(MUCRole.moderator);
    }

    public String getNickname() {
        return this.nickname;
    }

    public Occupant getOccupant(String str) {
        Presence presence = this.occupantsMap.get(str);
        if (presence != null) {
            return new Occupant(presence);
        }
        return null;
    }

    public Presence getOccupantPresence(String str) {
        return this.occupantsMap.get(str);
    }

    public List<String> getOccupants() {
        return Collections.unmodifiableList(new ArrayList(this.occupantsMap.keySet()));
    }

    public int getOccupantsCount() {
        return this.occupantsMap.size();
    }

    public List<Affiliate> getOutcasts() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.outcast);
    }

    public List<Affiliate> getOwners() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.owner);
    }

    public List<Occupant> getParticipants() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getOccupants(MUCRole.participant);
    }

    public Form getRegistrationForm() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.get);
        registration.setTo(this.room);
        return Form.getFormFrom((IQ) this.connection.createPacketCollectorAndSend(registration).nextResultOrThrow());
    }

    public String getReservedNickname() throws SmackException {
        try {
            Iterator<DiscoverInfo.Identity> it = ServiceDiscoveryManager.getInstanceFor(this.connection).discoverInfo(this.room, "x-roomuser-item").getIdentities().iterator();
            if (it.hasNext()) {
                return it.next().getName();
            }
            return null;
        } catch (XMPPException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving room nickname", (Throwable) e);
            return null;
        }
    }

    public String getRoom() {
        return this.room;
    }

    public String getSubject() {
        return this.subject;
    }

    public void grantAdmin(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void grantMembership(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.member);
    }

    public void grantModerator(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.moderator);
    }

    public void grantOwnership(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.owner);
    }

    public void grantVoice(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.participant);
    }

    public void invite(String str, String str2) throws SmackException.NotConnectedException {
        invite(new Message(), str, str2);
    }

    public boolean isJoined() {
        return this.joined;
    }

    public void join(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        join(str, null, null, this.connection.getPacketReplyTimeout());
    }

    public void kickParticipant(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(str, MUCRole.none, str2);
    }

    public synchronized void leave() throws SmackException.NotConnectedException {
        if (this.joined) {
            Presence presence = new Presence(Presence.Type.unavailable);
            presence.setTo(this.room + "/" + this.nickname);
            this.connection.sendStanza(presence);
            this.occupantsMap.clear();
            this.nickname = null;
            this.joined = false;
            userHasLeft();
        }
    }

    public Message nextMessage() throws MUCNotJoinedException {
        PacketCollector packetCollector = this.messageCollector;
        if (packetCollector != null) {
            return (Message) packetCollector.nextResult();
        }
        throw new MUCNotJoinedException(this);
    }

    public Message pollMessage() throws MUCNotJoinedException {
        PacketCollector packetCollector = this.messageCollector;
        if (packetCollector != null) {
            return (Message) packetCollector.pollResult();
        }
        throw new MUCNotJoinedException(this);
    }

    public boolean removeInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.remove(invitationRejectionListener);
    }

    public boolean removeMessageListener(MessageListener messageListener) {
        return this.messageListeners.remove(messageListener);
    }

    public boolean removeParticipantListener(PresenceListener presenceListener) {
        return this.presenceListeners.remove(presenceListener);
    }

    public boolean removeParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.remove(participantStatusListener);
    }

    public void removePresenceInterceptor(StanzaListener stanzaListener) {
        this.presenceInterceptors.remove(stanzaListener);
    }

    public boolean removeSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.remove(subjectUpdatedListener);
    }

    public boolean removeUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.remove(userStatusListener);
    }

    public void requestVoice() throws SmackException.NotConnectedException {
        DataForm dataForm = new DataForm(DataForm.Type.submit);
        FormField formField = new FormField(FormField.FORM_TYPE);
        formField.addValue("http://jabber.org/protocol/muc#request");
        dataForm.addField(formField);
        FormField formField2 = new FormField("muc#role");
        formField2.setType(FormField.Type.text_single);
        formField2.setLabel("Requested role");
        formField2.addValue("participant");
        dataForm.addField(formField2);
        Message message = new Message(this.room);
        message.addExtension(dataForm);
        this.connection.sendStanza(message);
    }

    public void revokeAdmin(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeMembership(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.none);
    }

    public void revokeModerator(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.participant);
    }

    public void revokeOwnership(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeVoice(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.visitor);
    }

    public void sendConfigurationForm(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        mUCOwner.addExtension(form.getDataFormToSend());
        this.connection.createPacketCollectorAndSend(mUCOwner).nextResultOrThrow();
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException {
        Message messageCreateMessage = createMessage();
        messageCreateMessage.setBody(str);
        this.connection.sendStanza(messageCreateMessage);
    }

    public void sendRegistrationForm(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.set);
        registration.setTo(this.room);
        registration.addExtension(form.getDataFormToSend());
        this.connection.createPacketCollectorAndSend(registration).nextResultOrThrow();
    }

    public String toString() {
        return "MUC: " + this.room + "(" + this.connection.getUser() + ")";
    }

    private void changeAffiliationByAdmin(String str, MUCAffiliation mUCAffiliation, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation, str, str2));
        this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private List<Occupant> getOccupants(MUCRole mUCRole) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCRole));
        MUCAdmin mUCAdmin2 = (MUCAdmin) this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
        ArrayList arrayList = new ArrayList();
        Iterator<MUCItem> it = mUCAdmin2.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new Occupant(it.next()));
        }
        return arrayList;
    }

    public synchronized boolean createOrJoin(String str, String str2, DiscussionHistory discussionHistory, long j) throws SmackException, XMPPException.XMPPErrorException {
        if (this.joined) {
            throw new IllegalStateException("Creation failed - User already joined the room.");
        }
        MUCUser mUCUserFrom = MUCUser.from(enter(str, str2, discussionHistory, j));
        return mUCUserFrom != null && mUCUserFrom.getStatus().contains(MUCUser.Status.ROOM_CREATED_201);
    }

    public void grantAdmin(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.admin);
    }

    public void grantMembership(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.member, null);
    }

    public void grantModerator(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(str, MUCRole.moderator, null);
    }

    public void grantOwnership(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.owner, null);
    }

    public void grantVoice(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(str, MUCRole.participant, null);
    }

    public void invite(String[] strArr, String str) throws SmackException.NotConnectedException {
        Stanza message = new Message();
        message.setTo(this.room);
        MUCUsers mUCUsers = new MUCUsers();
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            MUCUser.Invite invite = new MUCUser.Invite();
            invite.setTo(str2);
            invite.setReason(str);
            arrayList.add(invite);
        }
        mUCUsers.setInvite(arrayList);
        message.addExtension(mUCUsers);
        this.connection.sendStanza(message);
    }

    public void join(String str, String str2) throws SmackException, XMPPException.XMPPErrorException {
        join(str, str2, null, this.connection.getPacketReplyTimeout());
    }

    public void revokeAdmin(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.member);
    }

    public void revokeMembership(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.none, null);
    }

    public void revokeModerator(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(str, MUCRole.participant, null);
    }

    public void revokeOwnership(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(str, MUCAffiliation.admin, null);
    }

    public void revokeVoice(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        changeRole(str, MUCRole.visitor, null);
    }

    public synchronized void join(String str, String str2, DiscussionHistory discussionHistory, long j) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (this.joined) {
            leave();
        }
        enter(str, str2, discussionHistory, j);
    }

    public Message nextMessage(long j) throws MUCNotJoinedException {
        PacketCollector packetCollector = this.messageCollector;
        if (packetCollector != null) {
            return (Message) packetCollector.nextResult(j);
        }
        throw new MUCNotJoinedException(this);
    }

    public void sendMessage(Message message) throws SmackException.NotConnectedException {
        message.setTo(this.room);
        message.setType(Message.Type.groupchat);
        this.connection.sendStanza(message);
    }

    private void changeRole(Collection<String> collection, MUCRole mUCRole) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            mUCAdmin.addItem(new MUCItem(mUCRole, it.next()));
        }
        this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private void changeAffiliationByAdmin(Collection<String> collection, MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            mUCAdmin.addItem(new MUCItem(mUCAffiliation, it.next()));
        }
        this.connection.createPacketCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    public void invite(Message message, String str, String str2) throws SmackException.NotConnectedException {
        message.setTo(this.room);
        MUCUser mUCUser = new MUCUser();
        MUCUser.Invite invite = new MUCUser.Invite();
        invite.setTo(str);
        invite.setReason(str2);
        mUCUser.setInvite(invite);
        message.addExtension(mUCUser);
        this.connection.sendStanza(message);
    }
}
