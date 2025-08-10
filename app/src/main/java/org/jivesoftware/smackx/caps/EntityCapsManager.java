package org.jivesoftware.smackx.caps;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractConnectionListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.cache.LruCache;

/* loaded from: classes5.dex */
public class EntityCapsManager extends Manager {
    private static final LruCache<String, DiscoverInfo> CAPS_CACHE;
    private static String DEFAULT_ENTITY_NODE = null;
    private static final String DEFAULT_HASH = "SHA-1";
    public static final String ELEMENT = "c";
    private static final LruCache<String, NodeVerHash> JID_TO_NODEVER_CACHE;
    private static final Logger LOGGER = Logger.getLogger(EntityCapsManager.class.getName());
    public static final String NAMESPACE = "http://jabber.org/protocol/caps";
    private static final StanzaFilter PRESENCES;
    private static final StanzaFilter PRESENCES_WITHOUT_CAPS;
    private static final StanzaFilter PRESENCES_WITH_CAPS;
    private static final Map<String, MessageDigest> SUPPORTED_HASHES;
    private static boolean autoEnableEntityCaps;
    private static Map<XMPPConnection, EntityCapsManager> instances;
    public static EntityCapsPersistentCache persistentCache;
    private CapsVersionAndHash currentCapsVersion;
    private boolean entityCapsEnabled;
    private String entityNode;
    private final Queue<CapsVersionAndHash> lastLocalCapsVersions;
    private boolean presenceSend;
    private final ServiceDiscoveryManager sdm;

    public static class NodeVerHash {
        private String hash;
        private String node;
        private String nodeVer;
        private String ver;

        public NodeVerHash(String str, CapsVersionAndHash capsVersionAndHash) {
            this(str, capsVersionAndHash.version, capsVersionAndHash.hash);
        }

        public String getHash() {
            return this.hash;
        }

        public String getNode() {
            return this.node;
        }

        public String getNodeVer() {
            return this.nodeVer;
        }

        public String getVer() {
            return this.ver;
        }

        public NodeVerHash(String str, String str2, String str3) {
            this.node = str;
            this.ver = str2;
            this.hash = str3;
            this.nodeVer = str + "#" + str2;
        }
    }

    static {
        HashMap map = new HashMap();
        SUPPORTED_HASHES = map;
        DEFAULT_ENTITY_NODE = "http://www.igniterealtime.org/projects/smack";
        autoEnableEntityCaps = true;
        instances = new WeakHashMap();
        PRESENCES_WITH_CAPS = new AndFilter(new StanzaTypeFilter(Presence.class), new StanzaExtensionFilter("c", "http://jabber.org/protocol/caps"));
        PRESENCES_WITHOUT_CAPS = new AndFilter(new StanzaTypeFilter(Presence.class), new NotFilter(new StanzaExtensionFilter("c", "http://jabber.org/protocol/caps")));
        PRESENCES = StanzaTypeFilter.PRESENCE;
        CAPS_CACHE = new LruCache<>(1000);
        JID_TO_NODEVER_CACHE = new LruCache<>(10000);
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                EntityCapsManager.getInstanceFor(xMPPConnection);
            }
        });
        try {
            map.put("SHA-1", MessageDigest.getInstance("SHA-1"));
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    private EntityCapsManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.lastLocalCapsVersions = new ConcurrentLinkedQueue();
        this.presenceSend = false;
        this.entityNode = DEFAULT_ENTITY_NODE;
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.sdm = instanceFor;
        instances.put(xMPPConnection, this);
        xMPPConnection.addConnectionListener(new AbstractConnectionListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.2
            private void processCapsStreamFeatureIfAvailable(XMPPConnection xMPPConnection2) {
                CapsExtension capsExtension = (CapsExtension) xMPPConnection2.getFeature("c", "http://jabber.org/protocol/caps");
                if (capsExtension == null) {
                    return;
                }
                EntityCapsManager.addCapsExtensionInfo(xMPPConnection2.getServiceName(), capsExtension);
            }

            @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                processCapsStreamFeatureIfAvailable(xMPPConnection2);
                if (z) {
                    return;
                }
                EntityCapsManager.this.presenceSend = false;
            }

            @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
            public void connected(XMPPConnection xMPPConnection2) {
                processCapsStreamFeatureIfAvailable(xMPPConnection2);
            }
        });
        updateLocalEntityCaps();
        if (autoEnableEntityCaps) {
            enableEntityCaps();
        }
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                if (EntityCapsManager.this.entityCapsEnabled()) {
                    EntityCapsManager.addCapsExtensionInfo(stanza.getFrom(), CapsExtension.from(stanza));
                }
            }
        }, PRESENCES_WITH_CAPS);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                EntityCapsManager.JID_TO_NODEVER_CACHE.remove(stanza.getFrom());
            }
        }, PRESENCES_WITHOUT_CAPS);
        StanzaListener stanzaListener = new StanzaListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                EntityCapsManager.this.presenceSend = true;
            }
        };
        StanzaFilter stanzaFilter = PRESENCES;
        xMPPConnection.addPacketSendingListener(stanzaListener, stanzaFilter);
        xMPPConnection.addPacketInterceptor(new StanzaListener() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.6
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                if (EntityCapsManager.this.entityCapsEnabled) {
                    CapsVersionAndHash capsVersionAndHash = EntityCapsManager.this.getCapsVersionAndHash();
                    stanza.addExtension(new CapsExtension(EntityCapsManager.this.entityNode, capsVersionAndHash.version, capsVersionAndHash.hash));
                }
            }
        }, stanzaFilter);
        instanceFor.setEntityCapsManager(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCapsExtensionInfo(String str, CapsExtension capsExtension) {
        String hash = capsExtension.getHash();
        Locale locale = Locale.US;
        if (SUPPORTED_HASHES.containsKey(hash.toUpperCase(locale))) {
            String lowerCase = hash.toLowerCase(locale);
            JID_TO_NODEVER_CACHE.put(str, new NodeVerHash(capsExtension.getNode(), capsExtension.getVer(), lowerCase));
        }
    }

    public static void addDiscoverInfoByNode(String str, DiscoverInfo discoverInfo) {
        CAPS_CACHE.put(str, discoverInfo);
        EntityCapsPersistentCache entityCapsPersistentCache = persistentCache;
        if (entityCapsPersistentCache != null) {
            entityCapsPersistentCache.addDiscoverInfoByNodePersistent(str, discoverInfo);
        }
    }

    public static void clearMemoryCache() {
        JID_TO_NODEVER_CACHE.clear();
        CAPS_CACHE.clear();
    }

    private static void formFieldValuesToCaps(List<String> list, StringBuilder sb) {
        TreeSet treeSet = new TreeSet();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next());
        }
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
        }
    }

    public static CapsVersionAndHash generateVerificationString(DiscoverInfo discoverInfo) {
        return generateVerificationString(discoverInfo, null);
    }

    public static DiscoverInfo getDiscoverInfoByUser(String str) {
        NodeVerHash nodeVerHash = JID_TO_NODEVER_CACHE.get(str);
        if (nodeVerHash == null) {
            return null;
        }
        return getDiscoveryInfoByNodeVer(nodeVerHash.nodeVer);
    }

    public static DiscoverInfo getDiscoveryInfoByNodeVer(String str) {
        EntityCapsPersistentCache entityCapsPersistentCache;
        LruCache<String, DiscoverInfo> lruCache = CAPS_CACHE;
        DiscoverInfo discoverInfoLookup = lruCache.get(str);
        if (discoverInfoLookup == null && (entityCapsPersistentCache = persistentCache) != null && (discoverInfoLookup = entityCapsPersistentCache.lookup(str)) != null) {
            lruCache.put(str, discoverInfoLookup);
        }
        return discoverInfoLookup != null ? new DiscoverInfo(discoverInfoLookup) : discoverInfoLookup;
    }

    public static synchronized EntityCapsManager getInstanceFor(XMPPConnection xMPPConnection) {
        EntityCapsManager entityCapsManager;
        if (SUPPORTED_HASHES.size() <= 0) {
            throw new IllegalStateException("No supported hashes for EntityCapsManager");
        }
        entityCapsManager = instances.get(xMPPConnection);
        if (entityCapsManager == null) {
            entityCapsManager = new EntityCapsManager(xMPPConnection);
        }
        return entityCapsManager;
    }

    public static NodeVerHash getNodeVerHashByJid(String str) {
        return JID_TO_NODEVER_CACHE.get(str);
    }

    public static String getNodeVersionByJid(String str) {
        NodeVerHash nodeVerHash = JID_TO_NODEVER_CACHE.get(str);
        if (nodeVerHash != null) {
            return nodeVerHash.nodeVer;
        }
        return null;
    }

    public static void setDefaultEntityNode(String str) {
        DEFAULT_ENTITY_NODE = str;
    }

    public static void setMaxsCacheSizes(int i, int i2) {
        JID_TO_NODEVER_CACHE.setMaxCacheSize(i);
        CAPS_CACHE.setMaxCacheSize(i2);
    }

    public static void setPersistentCache(EntityCapsPersistentCache entityCapsPersistentCache) {
        persistentCache = entityCapsPersistentCache;
    }

    public static boolean verifyDiscoverInfoVersion(String str, String str2, DiscoverInfo discoverInfo) {
        return (discoverInfo.containsDuplicateIdentities() || discoverInfo.containsDuplicateFeatures() || verifyPacketExtensions(discoverInfo) || !str.equals(generateVerificationString(discoverInfo, str2).version)) ? false : true;
    }

    public static boolean verifyPacketExtensions(DiscoverInfo discoverInfo) {
        LinkedList linkedList = new LinkedList();
        for (ExtensionElement extensionElement : discoverInfo.getExtensions()) {
            if (extensionElement.getNamespace().equals("jabber:x:data")) {
                for (FormField formField : ((DataForm) extensionElement).getFields()) {
                    if (formField.getVariable().equals(FormField.FORM_TYPE)) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            if (formField.equals((FormField) it.next())) {
                                return true;
                            }
                        }
                        linkedList.add(formField);
                    }
                }
            }
        }
        return false;
    }

    public boolean areEntityCapsSupported(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return this.sdm.supportsFeature(str, "http://jabber.org/protocol/caps");
    }

    public boolean areEntityCapsSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return areEntityCapsSupported(connection().getServiceName());
    }

    public synchronized void disableEntityCaps() {
        this.entityCapsEnabled = false;
        this.sdm.removeFeature("http://jabber.org/protocol/caps");
    }

    public synchronized void enableEntityCaps() {
        this.sdm.addFeature("http://jabber.org/protocol/caps");
        updateLocalEntityCaps();
        this.entityCapsEnabled = true;
    }

    public boolean entityCapsEnabled() {
        return this.entityCapsEnabled;
    }

    public CapsVersionAndHash getCapsVersionAndHash() {
        return this.currentCapsVersion;
    }

    public String getLocalNodeVer() {
        CapsVersionAndHash capsVersionAndHash = getCapsVersionAndHash();
        if (capsVersionAndHash == null) {
            return null;
        }
        return this.entityNode + '#' + capsVersionAndHash.version;
    }

    public void removeUserCapsNode(String str) {
        JID_TO_NODEVER_CACHE.remove(str);
    }

    public void setEntityNode(String str) throws SmackException.NotConnectedException {
        this.entityNode = str;
        updateLocalEntityCaps();
    }

    public void updateLocalEntityCaps() {
        XMPPConnection xMPPConnectionConnection = connection();
        DiscoverInfo discoverInfo = new DiscoverInfo();
        discoverInfo.setType(IQ.Type.result);
        this.sdm.addDiscoverInfoTo(discoverInfo);
        this.currentCapsVersion = generateVerificationString(discoverInfo);
        String localNodeVer = getLocalNodeVer();
        discoverInfo.setNode(localNodeVer);
        addDiscoverInfoByNode(localNodeVer, discoverInfo);
        if (this.lastLocalCapsVersions.size() > 10) {
            CapsVersionAndHash capsVersionAndHashPoll = this.lastLocalCapsVersions.poll();
            this.sdm.removeNodeInformationProvider(this.entityNode + '#' + capsVersionAndHashPoll.version);
        }
        this.lastLocalCapsVersions.add(this.currentCapsVersion);
        if (xMPPConnectionConnection != null) {
            JID_TO_NODEVER_CACHE.put(xMPPConnectionConnection.getUser(), new NodeVerHash(this.entityNode, this.currentCapsVersion));
        }
        final LinkedList linkedList = new LinkedList(ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection).getIdentities());
        this.sdm.setNodeInformationProvider(localNodeVer, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.7
            public List<String> features;
            public List<ExtensionElement> packetExtensions;

            {
                this.features = EntityCapsManager.this.sdm.getFeatures();
                this.packetExtensions = EntityCapsManager.this.sdm.getExtendedInfoAsList();
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<String> getNodeFeatures() {
                return this.features;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverInfo.Identity> getNodeIdentities() {
                return linkedList;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<ExtensionElement> getNodePacketExtensions() {
                return this.packetExtensions;
            }
        });
        if (xMPPConnectionConnection != null && xMPPConnectionConnection.isAuthenticated() && this.presenceSend) {
            try {
                xMPPConnectionConnection.sendStanza(new Presence(Presence.Type.available));
            } catch (SmackException.NotConnectedException e) {
                LOGGER.log(Level.WARNING, "Could could not update presence with caps info", (Throwable) e);
            }
        }
    }

    public static CapsVersionAndHash generateVerificationString(DiscoverInfo discoverInfo, String str) {
        byte[] bArrDigest;
        if (str == null) {
            str = "SHA-1";
        }
        Map<String, MessageDigest> map = SUPPORTED_HASHES;
        Locale locale = Locale.US;
        MessageDigest messageDigest = map.get(str.toUpperCase(locale));
        FormField formField = null;
        if (messageDigest == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(locale);
        DataForm dataFormFrom = DataForm.from(discoverInfo);
        StringBuilder sb = new StringBuilder();
        TreeSet<DiscoverInfo.Identity> treeSet = new TreeSet();
        Iterator<DiscoverInfo.Identity> it = discoverInfo.getIdentities().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next());
        }
        for (DiscoverInfo.Identity identity : treeSet) {
            sb.append(identity.getCategory());
            sb.append("/");
            sb.append(identity.getType());
            sb.append("/");
            sb.append(identity.getLanguage() == null ? "" : identity.getLanguage());
            sb.append("/");
            sb.append(identity.getName() == null ? "" : identity.getName());
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
        }
        TreeSet treeSet2 = new TreeSet();
        Iterator<DiscoverInfo.Feature> it2 = discoverInfo.getFeatures().iterator();
        while (it2.hasNext()) {
            treeSet2.add(it2.next().getVar());
        }
        Iterator it3 = treeSet2.iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
        }
        if (dataFormFrom != null && dataFormFrom.hasHiddenFormTypeField()) {
            synchronized (dataFormFrom) {
                TreeSet<FormField> treeSet3 = new TreeSet(new Comparator<FormField>() { // from class: org.jivesoftware.smackx.caps.EntityCapsManager.8
                    @Override // java.util.Comparator
                    public int compare(FormField formField2, FormField formField3) {
                        return formField2.getVariable().compareTo(formField3.getVariable());
                    }
                });
                for (FormField formField2 : dataFormFrom.getFields()) {
                    if (formField2.getVariable().equals(FormField.FORM_TYPE)) {
                        formField = formField2;
                    } else {
                        treeSet3.add(formField2);
                    }
                }
                if (formField != null) {
                    formFieldValuesToCaps(formField.getValues(), sb);
                }
                for (FormField formField3 : treeSet3) {
                    sb.append(formField3.getVariable());
                    sb.append(SimpleComparison.LESS_THAN_OPERATION);
                    formFieldValuesToCaps(formField3.getValues(), sb);
                }
            }
        }
        synchronized (messageDigest) {
            bArrDigest = messageDigest.digest(sb.toString().getBytes());
        }
        return new CapsVersionAndHash(Base64.encodeToString(bArrDigest), lowerCase);
    }
}
