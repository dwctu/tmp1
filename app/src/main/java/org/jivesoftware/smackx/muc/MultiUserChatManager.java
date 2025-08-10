package org.jivesoftware.smackx.muc;

import dc.zb2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class MultiUserChatManager extends Manager {
    private static final String DISCO_NODE = "http://jabber.org/protocol/muc#rooms";
    private static final Map<XMPPConnection, MultiUserChatManager> INSTANCES;
    private static final StanzaFilter INVITATION_FILTER;
    private final StanzaFilter fromRoomGroupchatFilter;
    private final Set<InvitationListener> invitationsListeners;
    private final Set<String> joinedRooms;
    private final Map<String, WeakReference<MultiUserChat>> multiUserChats;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(MUCInitialPresence.NAMESPACE);
                final WeakReference weakReference = new WeakReference(xMPPConnection);
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider(MultiUserChatManager.DISCO_NODE, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.1.1
                    @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
                    public List<DiscoverItems.Item> getNodeItems() {
                        XMPPConnection xMPPConnection2 = (XMPPConnection) weakReference.get();
                        if (xMPPConnection2 == null) {
                            return Collections.emptyList();
                        }
                        Set<String> joinedRooms = MultiUserChatManager.getInstanceFor(xMPPConnection2).getJoinedRooms();
                        ArrayList arrayList = new ArrayList();
                        Iterator<String> it = joinedRooms.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new DiscoverItems.Item(it.next()));
                        }
                        return arrayList;
                    }
                });
            }
        });
        INSTANCES = new WeakHashMap();
        INVITATION_FILTER = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(new MUCUser()), new NotFilter(MessageTypeFilter.ERROR));
    }

    private MultiUserChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.invitationsListeners = new CopyOnWriteArraySet();
        this.joinedRooms = new HashSet();
        this.multiUserChats = new HashMap();
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Message message = (Message) stanza;
                MUCUser mUCUserFrom = MUCUser.from(message);
                if (mUCUserFrom.getInvite() != null) {
                    MultiUserChat multiUserChat = MultiUserChatManager.this.getMultiUserChat(stanza.getFrom());
                    Iterator it = MultiUserChatManager.this.invitationsListeners.iterator();
                    while (it.hasNext()) {
                        ((InvitationListener) it.next()).invitationReceived(MultiUserChatManager.this.connection(), multiUserChat, mUCUserFrom.getInvite().getFrom(), mUCUserFrom.getInvite().getReason(), mUCUserFrom.getPassword(), message);
                    }
                }
            }
        }, INVITATION_FILTER);
        AndFilter andFilter = new AndFilter(MessageTypeFilter.GROUPCHAT);
        this.fromRoomGroupchatFilter = andFilter;
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChatManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException, JSONException {
                zb2.O().processMessage((Message) stanza);
            }
        }, andFilter);
    }

    private MultiUserChat createNewMucAndAddToMap(String str) {
        MultiUserChat multiUserChat = new MultiUserChat(connection(), str, this);
        this.multiUserChats.put(str, new WeakReference<>(multiUserChat));
        return multiUserChat;
    }

    public static synchronized MultiUserChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        MultiUserChatManager multiUserChatManager;
        Map<XMPPConnection, MultiUserChatManager> map = INSTANCES;
        multiUserChatManager = map.get(xMPPConnection);
        if (multiUserChatManager == null) {
            multiUserChatManager = new MultiUserChatManager(xMPPConnection);
            map.put(xMPPConnection, multiUserChatManager);
        }
        return multiUserChatManager;
    }

    public void addInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.add(invitationListener);
    }

    public void addJoinedRoom(String str) {
        this.joinedRooms.add(str);
    }

    public void decline(String str, String str2, String str3) throws SmackException.NotConnectedException {
        Stanza message = new Message(str);
        MUCUser mUCUser = new MUCUser();
        MUCUser.Decline decline = new MUCUser.Decline();
        decline.setTo(str2);
        decline.setReason(str3);
        mUCUser.setDecline(decline);
        message.addExtension(mUCUser);
        connection().sendStanza(message);
    }

    public List<HostedRoom> getHostedRooms(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        List<DiscoverItems.Item> items = ServiceDiscoveryManager.getInstanceFor(connection()).discoverItems(str).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        Iterator<DiscoverItems.Item> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new HostedRoom(it.next()));
        }
        return arrayList;
    }

    public Set<String> getJoinedRooms() {
        return Collections.unmodifiableSet(this.joinedRooms);
    }

    public synchronized MultiUserChat getMultiUserChat(String str) {
        WeakReference<MultiUserChat> weakReference = this.multiUserChats.get(str);
        if (weakReference == null) {
            return createNewMucAndAddToMap(str);
        }
        MultiUserChat multiUserChat = weakReference.get();
        if (multiUserChat != null) {
            return multiUserChat;
        }
        return createNewMucAndAddToMap(str);
    }

    public RoomInfo getRoomInfo(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return new RoomInfo(ServiceDiscoveryManager.getInstanceFor(connection()).discoverInfo(str));
    }

    public List<String> getServiceNames() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).findServices(MUCInitialPresence.NAMESPACE, false, false);
    }

    public boolean isServiceEnabled(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, MUCInitialPresence.NAMESPACE);
    }

    public void removeInvitationListener(InvitationListener invitationListener) {
        this.invitationsListeners.remove(invitationListener);
    }

    public void removeJoinedRoom(String str) {
        this.joinedRooms.remove(str);
    }

    public List<String> getJoinedRooms(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        List<DiscoverItems.Item> items = ServiceDiscoveryManager.getInstanceFor(connection()).discoverItems(str, DISCO_NODE).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        Iterator<DiscoverItems.Item> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEntityID());
        }
        return arrayList;
    }
}
