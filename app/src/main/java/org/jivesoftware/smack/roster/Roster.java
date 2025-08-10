package org.jivesoftware.smack.roster;

import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ExceptionCallback;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.roster.rosterstore.RosterStore;
import org.jivesoftware.smack.util.Objects;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class Roster extends Manager {
    private final Map<String, RosterEntry> entries;
    private final Map<String, RosterGroup> groups;
    private boolean loaded;
    private final Map<String, Map<String, Presence>> presenceMap;
    private final PresencePacketListener presencePacketListener;
    private final Set<RosterListener> rosterListeners;
    private final Object rosterListenersAndEntriesLock;
    private boolean rosterLoadedAtLogin;
    private final Set<RosterLoadedListener> rosterLoadedListeners;
    private RosterStore rosterStore;
    private SubscriptionMode subscriptionMode;
    private final Set<RosterEntry> unfiledEntries;
    private static final Logger LOGGER = Logger.getLogger(Roster.class.getName());
    private static final Map<XMPPConnection, Roster> INSTANCES = new WeakHashMap();
    private static final StanzaFilter PRESENCE_PACKET_FILTER = StanzaTypeFilter.PRESENCE;
    private static boolean rosterLoadedAtLoginDefault = true;
    private static SubscriptionMode defaultSubscriptionMode = SubscriptionMode.accept_all;

    /* renamed from: org.jivesoftware.smack.roster.Roster$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode;
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType;

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
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.subscribe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.unsubscribe.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[SubscriptionMode.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode = iArr2;
            try {
                iArr2[SubscriptionMode.accept_all.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[SubscriptionMode.reject_all.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[SubscriptionMode.manual.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[RosterPacket.ItemType.values().length];
            $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType = iArr3;
            try {
                iArr3[RosterPacket.ItemType.from.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.both.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.none.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.to.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[RosterPacket.ItemType.remove.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public class PresencePacketListener implements StanzaListener {
        private PresencePacketListener() {
        }

        private Map<String, Presence> getUserPresences(String str) {
            Map<String, Presence> map = (Map) Roster.this.presenceMap.get(str);
            if (map != null) {
                return map;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Roster.this.presenceMap.put(str, concurrentHashMap);
            return concurrentHashMap;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
            boolean z;
            XMPPConnection xMPPConnectionConnection = Roster.this.connection();
            Presence presence = (Presence) stanza;
            String from = WearUtils.e1(presence.getFrom()) ? "" : presence.getFrom();
            String mapKey = Roster.this.getMapKey(from);
            Presence presence2 = null;
            int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
            if (i == 1) {
                Map<String, Presence> userPresences = getUserPresences(mapKey);
                userPresences.remove("");
                userPresences.put(XmppStringUtils.parseResource(from), presence);
                String str = "entries====" + Roster.this.entries.keySet();
                z = DaoUtils.getUserDao().findById(WearUtils.X(mapKey)) != null;
                if (Roster.this.entries.containsKey(mapKey) || z) {
                    Roster.this.fireRosterPresenceEvent(presence);
                    return;
                }
                return;
            }
            if (i == 2) {
                if ("".equals(XmppStringUtils.parseResource(from))) {
                    getUserPresences(mapKey).put("", presence);
                } else if (Roster.this.presenceMap.get(mapKey) != null) {
                    ((Map) Roster.this.presenceMap.get(mapKey)).put(XmppStringUtils.parseResource(from), presence);
                }
                z = DaoUtils.getUserDao().findById(WearUtils.X(mapKey)) != null;
                if (Roster.this.entries.containsKey(mapKey) || z) {
                    Roster.this.fireRosterPresenceEvent(presence);
                    return;
                }
                return;
            }
            if (i == 3) {
                int i2 = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$roster$Roster$SubscriptionMode[Roster.this.subscriptionMode.ordinal()];
                if (i2 == 1) {
                    presence2 = new Presence(Presence.Type.subscribed);
                } else if (i2 == 2) {
                    presence2 = new Presence(Presence.Type.unsubscribed);
                }
                if (presence2 != null) {
                    presence2.setTo(presence.getFrom());
                    xMPPConnectionConnection.sendStanza(presence2);
                    return;
                }
                return;
            }
            if (i == 4) {
                if (Roster.this.subscriptionMode != SubscriptionMode.manual) {
                    Presence presence3 = new Presence(Presence.Type.unsubscribed);
                    presence3.setTo(presence.getFrom());
                    xMPPConnectionConnection.sendStanza(presence3);
                    return;
                }
                return;
            }
            if (i == 5 && "".equals(XmppStringUtils.parseResource(from))) {
                Map<String, Presence> userPresences2 = getUserPresences(mapKey);
                userPresences2.clear();
                userPresences2.put("", presence);
                DaoUtils.getUserDao().findById(WearUtils.X(mapKey));
                if (Roster.this.entries.containsKey(mapKey)) {
                    Roster.this.fireRosterPresenceEvent(presence);
                }
            }
        }
    }

    public class RosterPushListener extends AbstractIqRequestHandler {
        @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
        public IQ handleIQRequest(IQ iq) {
            XMPPConnection xMPPConnectionConnection = Roster.this.connection();
            RosterPacket rosterPacket = (RosterPacket) iq;
            String bareJid = XmppStringUtils.parseBareJid(xMPPConnectionConnection.getUser());
            String from = rosterPacket.getFrom();
            if (from != null && !from.equals(bareJid)) {
                Roster.LOGGER.warning("Ignoring roster push with a non matching 'from' ourJid='" + bareJid + "' from='" + from + "'");
                return IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.service_unavailable));
            }
            List<RosterPacket.Item> rosterItems = rosterPacket.getRosterItems();
            if (rosterItems.size() != 1) {
                Roster.LOGGER.warning("Ignoring roster push with not exaclty one entry. size=" + rosterItems.size());
                return IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.bad_request));
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            RosterPacket.Item next = rosterItems.iterator().next();
            RosterEntry rosterEntry = new RosterEntry(next.getUser(), next.getName(), next.getItemType(), next.getItemStatus(), Roster.this, xMPPConnectionConnection);
            String version = rosterPacket.getVersion();
            if (Roster.hasValidSubscriptionType(next)) {
                Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, next, rosterEntry);
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.addEntry(next, version);
                }
            }
            Roster.this.removeEmptyGroups();
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            return IQ.createResultIQ(rosterPacket);
        }

        private RosterPushListener() {
            super("query", RosterPacket.NAMESPACE, IQ.Type.set, IQRequestHandler.Mode.sync);
        }
    }

    public class RosterResultListener implements StanzaListener {
        private RosterResultListener() {
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processPacket(Stanza stanza) {
            XMPPConnection xMPPConnectionConnection = Roster.this.connection();
            Roster.LOGGER.fine("RosterResultListener received stanza");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (stanza instanceof RosterPacket) {
                RosterPacket rosterPacket = (RosterPacket) stanza;
                ArrayList arrayList5 = new ArrayList();
                for (RosterPacket.Item item : rosterPacket.getRosterItems()) {
                    if (Roster.hasValidSubscriptionType(item)) {
                        arrayList5.add(item);
                    }
                }
                Iterator it = arrayList5.iterator();
                while (it.hasNext()) {
                    RosterPacket.Item item2 = (RosterPacket.Item) it.next();
                    Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, item2, new RosterEntry(item2.getUser(), item2.getName(), item2.getItemType(), item2.getItemStatus(), Roster.this, xMPPConnectionConnection));
                }
                HashSet<String> hashSet = new HashSet();
                Iterator it2 = Roster.this.entries.values().iterator();
                while (it2.hasNext()) {
                    hashSet.add(((RosterEntry) it2.next()).getUser());
                }
                hashSet.removeAll(arrayList);
                hashSet.removeAll(arrayList2);
                hashSet.removeAll(arrayList4);
                for (String str : hashSet) {
                    Roster roster = Roster.this;
                    roster.deleteEntry(arrayList3, (RosterEntry) roster.entries.get(str));
                }
                if (Roster.this.rosterStore != null) {
                    Roster.this.rosterStore.resetEntries(arrayList5, rosterPacket.getVersion());
                }
                Roster.this.removeEmptyGroups();
            } else {
                for (RosterPacket.Item item3 : Roster.this.rosterStore.getEntries()) {
                    Roster.this.addUpdateEntry(arrayList, arrayList2, arrayList4, item3, new RosterEntry(item3.getUser(), item3.getName(), item3.getItemType(), item3.getItemStatus(), Roster.this, xMPPConnectionConnection));
                }
            }
            Roster.this.loaded = true;
            synchronized (Roster.this) {
                Roster.this.notifyAll();
            }
            Roster.this.fireRosterChangedEvent(arrayList, arrayList2, arrayList3);
            try {
                synchronized (Roster.this.rosterLoadedListeners) {
                    Iterator it3 = Roster.this.rosterLoadedListeners.iterator();
                    while (it3.hasNext()) {
                        ((RosterLoadedListener) it3.next()).onRosterLoaded(Roster.this);
                    }
                }
            } catch (Exception e) {
                Roster.LOGGER.log(Level.WARNING, "RosterLoadedListener threw exception", (Throwable) e);
            }
        }
    }

    public enum SubscriptionMode {
        accept_all,
        reject_all,
        manual
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smack.roster.Roster.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                Roster.getInstanceFor(xMPPConnection);
            }
        });
    }

    private Roster(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.groups = new ConcurrentHashMap();
        this.entries = new ConcurrentHashMap();
        this.unfiledEntries = new CopyOnWriteArraySet();
        this.rosterListeners = new LinkedHashSet();
        this.presenceMap = new ConcurrentHashMap();
        this.rosterLoadedListeners = new LinkedHashSet();
        this.rosterListenersAndEntriesLock = new Object();
        PresencePacketListener presencePacketListener = new PresencePacketListener();
        this.presencePacketListener = presencePacketListener;
        this.loaded = false;
        this.rosterLoadedAtLogin = rosterLoadedAtLoginDefault;
        this.subscriptionMode = getDefaultSubscriptionMode();
        xMPPConnection.registerIQRequestHandler(new RosterPushListener());
        xMPPConnection.addSyncStanzaListener(presencePacketListener, PRESENCE_PACKET_FILTER);
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smack.roster.Roster.2
            @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (xMPPConnection2.isAnonymous() || !Roster.this.isRosterLoadedAtLogin() || z) {
                    return;
                }
                try {
                    Roster.this.reload();
                } catch (SmackException e) {
                    Roster.LOGGER.log(Level.SEVERE, "Could not reload Roster", (Throwable) e);
                }
            }

            @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
            public void connectionTerminated() {
                Roster.this.setOfflinePresencesAndResetLoaded();
            }
        });
        if (xMPPConnection.isAuthenticated()) {
            try {
                reload();
            } catch (SmackException e) {
                LOGGER.log(Level.SEVERE, "Could not reload Roster", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUpdateEntry(Collection<String> collection, Collection<String> collection2, Collection<String> collection3, RosterPacket.Item item, RosterEntry rosterEntry) {
        RosterEntry rosterEntryPut;
        synchronized (this.rosterListenersAndEntriesLock) {
            rosterEntryPut = this.entries.put(item.getUser(), rosterEntry);
        }
        if (rosterEntryPut == null) {
            collection.add(item.getUser());
        } else {
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntryPut);
            if (rosterEntryPut.equalsDeep(rosterEntry) && item.getGroupNames().equals(rosterItem.getGroupNames())) {
                collection3.add(item.getUser());
            } else {
                collection2.add(item.getUser());
            }
        }
        if (item.getGroupNames().isEmpty()) {
            this.unfiledEntries.add(rosterEntry);
        } else {
            this.unfiledEntries.remove(rosterEntry);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : item.getGroupNames()) {
            arrayList.add(str);
            RosterGroup group = getGroup(str);
            if (group == null) {
                group = createGroup(str);
                this.groups.put(str, group);
            }
            group.addEntryLocal(rosterEntry);
        }
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator<RosterGroup> it = getGroups().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getName());
        }
        arrayList2.removeAll(arrayList);
        for (String str2 : arrayList2) {
            RosterGroup group2 = getGroup(str2);
            group2.removeEntryLocal(rosterEntry);
            if (group2.getEntryCount() == 0) {
                this.groups.remove(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEntry(Collection<String> collection, RosterEntry rosterEntry) {
        String user = rosterEntry.getUser();
        this.entries.remove(user);
        this.unfiledEntries.remove(rosterEntry);
        this.presenceMap.remove(XmppStringUtils.parseBareJid(user));
        collection.add(user);
        for (Map.Entry<String, RosterGroup> entry : this.groups.entrySet()) {
            RosterGroup value = entry.getValue();
            value.removeEntryLocal(rosterEntry);
            if (value.getEntryCount() == 0) {
                this.groups.remove(entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRosterChangedEvent(Collection<String> collection, Collection<String> collection2, Collection<String> collection3) {
        synchronized (this.rosterListenersAndEntriesLock) {
            for (RosterListener rosterListener : this.rosterListeners) {
                if (!collection.isEmpty()) {
                    rosterListener.entriesAdded(collection);
                }
                if (!collection2.isEmpty()) {
                    rosterListener.entriesUpdated(collection2);
                }
                if (!collection3.isEmpty()) {
                    rosterListener.entriesDeleted(collection3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireRosterPresenceEvent(Presence presence) {
        synchronized (this.rosterListenersAndEntriesLock) {
            Iterator<RosterListener> it = this.rosterListeners.iterator();
            while (it.hasNext()) {
                it.next().presenceChanged(presence);
            }
        }
    }

    public static SubscriptionMode getDefaultSubscriptionMode() {
        return defaultSubscriptionMode;
    }

    public static synchronized Roster getInstanceFor(XMPPConnection xMPPConnection) {
        Roster roster;
        Map<XMPPConnection, Roster> map = INSTANCES;
        roster = map.get(xMPPConnection);
        if (roster == null) {
            roster = new Roster(xMPPConnection);
            map.put(xMPPConnection, roster);
        }
        return roster;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMapKey(String str) {
        if (str == null) {
            return null;
        }
        return this.entries.containsKey(str) ? str : XmppStringUtils.parseBareJid(str).toLowerCase(Locale.US);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasValidSubscriptionType(RosterPacket.Item item) {
        int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[item.getItemType().ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEmptyGroups() {
        for (RosterGroup rosterGroup : getGroups()) {
            if (rosterGroup.getEntryCount() == 0) {
                this.groups.remove(rosterGroup.getName());
            }
        }
    }

    public static void setDefaultSubscriptionMode(SubscriptionMode subscriptionMode) {
        defaultSubscriptionMode = subscriptionMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflinePresencesAndResetLoaded() {
        for (String str : this.presenceMap.keySet()) {
            Map<String, Presence> map = this.presenceMap.get(str);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    Presence presence = new Presence(Presence.Type.unavailable);
                    presence.setFrom(str + "/" + str2);
                    try {
                        this.presencePacketListener.processPacket(presence);
                    } catch (SmackException.NotConnectedException e) {
                        throw new IllegalStateException("presencePakcetListener should never throw a NotConnectedException when processPacket is called with a presence of type unavailable", e);
                    }
                }
            }
        }
        this.loaded = false;
    }

    public boolean addRosterListener(RosterListener rosterListener) {
        boolean zAdd;
        synchronized (this.rosterListenersAndEntriesLock) {
            zAdd = this.rosterListeners.add(rosterListener);
        }
        return zAdd;
    }

    public boolean addRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean zAdd;
        synchronized (rosterLoadedListener) {
            zAdd = this.rosterLoadedListeners.add(rosterLoadedListener);
        }
        return zAdd;
    }

    public boolean contains(String str) {
        return getEntry(str) != null;
    }

    public void createEntry(String str, String str2, String[] strArr) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!xMPPConnectionConnection.isAuthenticated()) {
            throw new SmackException.NotLoggedInException();
        }
        if (xMPPConnectionConnection.isAnonymous()) {
            throw new IllegalStateException("Anonymous users can't have a roster.");
        }
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setType(IQ.Type.set);
        RosterPacket.Item item = new RosterPacket.Item(str, str2);
        if (strArr != null) {
            for (String str3 : strArr) {
                if (str3 != null && str3.trim().length() > 0) {
                    item.addGroupName(str3);
                }
            }
        }
        rosterPacket.addRosterItem(item);
        xMPPConnectionConnection.createPacketCollectorAndSend(rosterPacket).nextResultOrThrow();
        Presence presence = new Presence(Presence.Type.subscribe);
        presence.setTo(str);
        xMPPConnectionConnection.sendStanza(presence);
    }

    public RosterGroup createGroup(String str) {
        XMPPConnection xMPPConnectionConnection = connection();
        if (xMPPConnectionConnection.isAnonymous()) {
            throw new IllegalStateException("Anonymous users can't have a roster.");
        }
        if (this.groups.containsKey(str)) {
            return this.groups.get(str);
        }
        RosterGroup rosterGroup = new RosterGroup(str, xMPPConnectionConnection);
        this.groups.put(str, rosterGroup);
        return rosterGroup;
    }

    public List<Presence> getAllPresences(String str) {
        Map<String, Presence> map = this.presenceMap.get(getMapKey(str));
        if (map == null) {
            Presence presence = new Presence(Presence.Type.unavailable);
            presence.setFrom(str);
            return new ArrayList(Arrays.asList(presence));
        }
        ArrayList arrayList = new ArrayList(map.values().size());
        Iterator<Presence> it = map.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().clone());
        }
        return arrayList;
    }

    public List<Presence> getAvailablePresences(String str) {
        List<Presence> allPresences = getAllPresences(str);
        ArrayList arrayList = new ArrayList(allPresences.size());
        for (Presence presence : allPresences) {
            if (presence.isAvailable()) {
                arrayList.add(presence);
            }
        }
        return arrayList;
    }

    public Set<RosterEntry> getEntries() {
        HashSet hashSet;
        synchronized (this.rosterListenersAndEntriesLock) {
            hashSet = new HashSet(this.entries.size());
            Iterator<RosterEntry> it = this.entries.values().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return hashSet;
    }

    public void getEntriesAndAddListener(RosterListener rosterListener, RosterEntries rosterEntries) {
        Objects.requireNonNull(rosterListener, "listener must not be null");
        Objects.requireNonNull(rosterEntries, "rosterEntries must not be null");
        synchronized (this.rosterListenersAndEntriesLock) {
            rosterEntries.rosterEntires(this.entries.values());
            addRosterListener(rosterListener);
        }
    }

    public RosterEntry getEntry(String str) {
        if (str == null) {
            return null;
        }
        return this.entries.get(getMapKey(str));
    }

    public int getEntryCount() {
        return getEntries().size();
    }

    public RosterGroup getGroup(String str) {
        return this.groups.get(str);
    }

    public int getGroupCount() {
        return this.groups.size();
    }

    public Collection<RosterGroup> getGroups() {
        return Collections.unmodifiableCollection(this.groups.values());
    }

    public Presence getPresence(String str) {
        Map<String, Presence> map = this.presenceMap.get(getMapKey(XmppStringUtils.parseBareJid(str)));
        if (map == null) {
            Presence presence = new Presence(Presence.Type.unavailable);
            presence.setFrom(str);
            return presence;
        }
        Iterator<String> it = map.keySet().iterator();
        Presence presence2 = null;
        Presence presence3 = null;
        while (it.hasNext()) {
            Presence presence4 = map.get(it.next());
            if (presence4.isAvailable()) {
                if (presence2 != null && presence4.getPriority() <= presence2.getPriority()) {
                    if (presence4.getPriority() == presence2.getPriority()) {
                        Presence.Mode mode = presence4.getMode();
                        if (mode == null) {
                            mode = Presence.Mode.available;
                        }
                        Presence.Mode mode2 = presence2.getMode();
                        if (mode2 == null) {
                            mode2 = Presence.Mode.available;
                        }
                        if (mode.compareTo(mode2) < 0) {
                        }
                    }
                }
                presence2 = presence4;
            } else {
                presence3 = presence4;
            }
        }
        if (presence2 != null) {
            return presence2.clone();
        }
        if (presence3 != null) {
            return presence3.clone();
        }
        Presence presence5 = new Presence(Presence.Type.unavailable);
        presence5.setFrom(str);
        return presence5;
    }

    public Presence getPresenceResource(String str) {
        String mapKey = getMapKey(str);
        String resource = WearUtils.e1(str) ? "" : XmppStringUtils.parseResource(str);
        Map<String, Presence> map = this.presenceMap.get(mapKey);
        if (map == null) {
            Presence presence = new Presence(Presence.Type.unavailable);
            presence.setFrom(str);
            return presence;
        }
        Presence presence2 = map.get(resource);
        if (presence2 != null) {
            return presence2.clone();
        }
        Presence presence3 = new Presence(Presence.Type.unavailable);
        presence3.setFrom(str);
        return presence3;
    }

    public List<Presence> getPresences(String str) {
        Map<String, Presence> map = this.presenceMap.get(getMapKey(str));
        if (map == null) {
            Presence presence = new Presence(Presence.Type.unavailable);
            presence.setFrom(str);
            return Arrays.asList(presence);
        }
        ArrayList arrayList = new ArrayList();
        Presence presence2 = null;
        for (Presence presence3 : map.values()) {
            if (presence3.isAvailable()) {
                arrayList.add(presence3.clone());
            } else {
                presence2 = presence3;
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        if (presence2 != null) {
            return Arrays.asList(presence2.clone());
        }
        Presence presence4 = new Presence(Presence.Type.unavailable);
        presence4.setFrom(str);
        return Arrays.asList(presence4);
    }

    public RosterStore getRosterStore() {
        return this.rosterStore;
    }

    public SubscriptionMode getSubscriptionMode() {
        return this.subscriptionMode;
    }

    public Set<RosterEntry> getUnfiledEntries() {
        return Collections.unmodifiableSet(this.unfiledEntries);
    }

    public int getUnfiledEntryCount() {
        return this.unfiledEntries.size();
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public boolean isRosterLoadedAtLogin() {
        return this.rosterLoadedAtLogin;
    }

    public boolean isRosterVersioningSupported() {
        return connection().hasFeature(RosterVer.ELEMENT, RosterVer.NAMESPACE);
    }

    public boolean isSubscribedToMyPresence(String str) {
        if (connection().getServiceName().equals(str)) {
            return true;
        }
        RosterEntry entry = getEntry(str);
        if (entry == null) {
            return false;
        }
        int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$roster$packet$RosterPacket$ItemType[entry.getType().ordinal()];
        return i == 1 || i == 2;
    }

    public void reload() throws SmackException.NotConnectedException, SmackException.NotLoggedInException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!xMPPConnectionConnection.isAuthenticated()) {
            throw new SmackException.NotLoggedInException();
        }
        if (xMPPConnectionConnection.isAnonymous()) {
            throw new IllegalStateException("Anonymous users can't have a roster.");
        }
        RosterPacket rosterPacket = new RosterPacket();
        if (this.rosterStore != null && isRosterVersioningSupported()) {
            rosterPacket.setVersion(this.rosterStore.getRosterVersion());
        }
        xMPPConnectionConnection.sendIqWithResponseCallback(rosterPacket, new RosterResultListener(), new ExceptionCallback() { // from class: org.jivesoftware.smack.roster.Roster.3
            @Override // org.jivesoftware.smack.ExceptionCallback
            public void processException(Exception exc) {
                Roster.LOGGER.log(Level.SEVERE, "Exception reloading roster", (Throwable) exc);
            }
        });
    }

    public void reloadAndWait() throws SmackException.NotConnectedException, SmackException.NotLoggedInException {
        reload();
        waitUntilLoaded();
    }

    public void removeAllRosterLoadedListeners() {
        synchronized (this.rosterLoadedListeners) {
            this.rosterLoadedListeners.clear();
        }
    }

    public void removeEntry(RosterEntry rosterEntry) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!xMPPConnectionConnection.isAuthenticated()) {
            throw new SmackException.NotLoggedInException();
        }
        if (xMPPConnectionConnection.isAnonymous()) {
            throw new IllegalStateException("Anonymous users can't have a roster.");
        }
        if (this.entries.containsKey(rosterEntry.getUser())) {
            RosterPacket rosterPacket = new RosterPacket();
            rosterPacket.setType(IQ.Type.set);
            RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
            rosterItem.setItemType(RosterPacket.ItemType.remove);
            rosterPacket.addRosterItem(rosterItem);
            xMPPConnectionConnection.createPacketCollectorAndSend(rosterPacket).nextResultOrThrow();
        }
    }

    public boolean removeRosterListener(RosterListener rosterListener) {
        boolean zRemove;
        synchronized (this.rosterListenersAndEntriesLock) {
            zRemove = this.rosterListeners.remove(rosterListener);
        }
        return zRemove;
    }

    public boolean removeRosterLoadedListener(RosterLoadedListener rosterLoadedListener) {
        boolean zRemove;
        synchronized (rosterLoadedListener) {
            zRemove = this.rosterLoadedListeners.remove(rosterLoadedListener);
        }
        return zRemove;
    }

    public void setRosterLoadedAtLogin(boolean z) {
        this.rosterLoadedAtLogin = z;
    }

    public boolean setRosterStore(RosterStore rosterStore) {
        this.rosterStore = rosterStore;
        try {
            reload();
            return true;
        } catch (SmackException.NotConnectedException | SmackException.NotLoggedInException e) {
            LOGGER.log(Level.FINER, "Could not reload roster", e);
            return false;
        }
    }

    public void setSubscriptionMode(SubscriptionMode subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public boolean waitUntilLoaded() {
        XMPPConnection xMPPConnectionConnection = connection();
        while (!this.loaded) {
            long packetReplyTimeout = xMPPConnectionConnection.getPacketReplyTimeout();
            System.currentTimeMillis();
            if (packetReplyTimeout <= 0) {
                break;
            }
            try {
                synchronized (this) {
                    if (!this.loaded) {
                        wait(packetReplyTimeout);
                    }
                }
                System.currentTimeMillis();
            } catch (InterruptedException e) {
                LOGGER.log(Level.FINE, "interrupted", (Throwable) e);
            }
        }
        return isLoaded();
    }
}
