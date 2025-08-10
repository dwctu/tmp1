package org.jivesoftware.smackx.disco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.caps.EntityCapsManager;
import org.jivesoftware.smackx.disco.bean.BaseIQ;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.ExpirationCache;

/* loaded from: classes5.dex */
public class ServiceDiscoveryManager extends Manager {
    private EntityCapsManager capsManager;
    private DataForm extendedInfo;
    private final Set<String> features;
    private Set<DiscoverInfo.Identity> identities;
    private DiscoverInfo.Identity identity;
    private Map<String, NodeInformationProvider> nodeInformationProviders;
    private Cache<String, List<String>> services;
    private static final Logger LOGGER = Logger.getLogger(ServiceDiscoveryManager.class.getName());
    private static final String DEFAULT_IDENTITY_CATEGORY = "client";
    private static final String DEFAULT_IDENTITY_NAME = "Smack";
    private static final String DEFAULT_IDENTITY_TYPE = "pc";
    private static DiscoverInfo.Identity defaultIdentity = new DiscoverInfo.Identity(DEFAULT_IDENTITY_CATEGORY, DEFAULT_IDENTITY_NAME, DEFAULT_IDENTITY_TYPE);
    private static Map<XMPPConnection, ServiceDiscoveryManager> instances = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private ServiceDiscoveryManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.identities = new HashSet();
        this.identity = defaultIdentity;
        this.features = new HashSet();
        this.extendedInfo = null;
        this.nodeInformationProviders = new ConcurrentHashMap();
        this.services = new ExpirationCache(25, 86400000L);
        addFeature(DiscoverInfo.NAMESPACE);
        addFeature(DiscoverItems.NAMESPACE);
        addFeature(BaseIQ.NAMESPACE);
        IQ.Type type = IQ.Type.get;
        IQRequestHandler.Mode mode = IQRequestHandler.Mode.async;
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverItems.NAMESPACE, type, mode) { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                DiscoverItems discoverItems = (DiscoverItems) iq;
                DiscoverItems discoverItems2 = new DiscoverItems();
                discoverItems2.setType(IQ.Type.result);
                discoverItems2.setTo(discoverItems.getFrom());
                discoverItems2.setStanzaId(discoverItems.getStanzaId());
                discoverItems2.setNode(discoverItems.getNode());
                NodeInformationProvider nodeInformationProvider = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverItems.getNode());
                if (nodeInformationProvider != null) {
                    discoverItems2.addItems(nodeInformationProvider.getNodeItems());
                    discoverItems2.addExtensions(nodeInformationProvider.getNodePacketExtensions());
                } else if (discoverItems.getNode() != null) {
                    discoverItems2.setType(IQ.Type.error);
                    discoverItems2.setError(new XMPPError(XMPPError.Condition.item_not_found));
                }
                return discoverItems2;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", DiscoverInfo.NAMESPACE, type, mode) { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                DiscoverInfo discoverInfo = (DiscoverInfo) iq;
                DiscoverInfo discoverInfo2 = new DiscoverInfo();
                discoverInfo2.setType(IQ.Type.result);
                discoverInfo2.setTo(discoverInfo.getFrom());
                discoverInfo2.setStanzaId(discoverInfo.getStanzaId());
                discoverInfo2.setNode(discoverInfo.getNode());
                if (discoverInfo.getNode() == null) {
                    ServiceDiscoveryManager.this.addDiscoverInfoTo(discoverInfo2);
                } else {
                    NodeInformationProvider nodeInformationProvider = ServiceDiscoveryManager.this.getNodeInformationProvider(discoverInfo.getNode());
                    if (nodeInformationProvider != null) {
                        discoverInfo2.addFeatures(nodeInformationProvider.getNodeFeatures());
                        discoverInfo2.addIdentities(nodeInformationProvider.getNodeIdentities());
                        discoverInfo2.addExtensions(nodeInformationProvider.getNodePacketExtensions());
                    } else {
                        discoverInfo2.setType(IQ.Type.error);
                        discoverInfo2.setError(new XMPPError(XMPPError.Condition.item_not_found));
                    }
                }
                return discoverInfo2;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", BaseIQ.NAMESPACE, type, mode) { // from class: org.jivesoftware.smackx.disco.ServiceDiscoveryManager.4
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                return iq;
            }
        });
    }

    public static synchronized ServiceDiscoveryManager getInstanceFor(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager serviceDiscoveryManager;
        serviceDiscoveryManager = instances.get(xMPPConnection);
        if (serviceDiscoveryManager == null) {
            serviceDiscoveryManager = new ServiceDiscoveryManager(xMPPConnection);
            instances.put(xMPPConnection, serviceDiscoveryManager);
        }
        return serviceDiscoveryManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NodeInformationProvider getNodeInformationProvider(String str) {
        if (str == null) {
            return null;
        }
        return this.nodeInformationProviders.get(str);
    }

    private void renewEntityCapsVersion() {
        EntityCapsManager entityCapsManager = this.capsManager;
        if (entityCapsManager == null || !entityCapsManager.entityCapsEnabled()) {
            return;
        }
        this.capsManager.updateLocalEntityCaps();
    }

    public static void setDefaultIdentity(DiscoverInfo.Identity identity) {
        defaultIdentity = identity;
    }

    public synchronized void addDiscoverInfoTo(DiscoverInfo discoverInfo) {
        discoverInfo.addIdentities(getIdentities());
        Iterator<String> it = getFeatures().iterator();
        while (it.hasNext()) {
            discoverInfo.addFeature(it.next());
        }
        discoverInfo.addExtension(this.extendedInfo);
    }

    public synchronized void addFeature(String str) {
        this.features.add(str);
        renewEntityCapsVersion();
    }

    public synchronized void addIdentity(DiscoverInfo.Identity identity) {
        this.identities.add(identity);
        renewEntityCapsVersion();
    }

    public boolean canPublishItems(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return canPublishItems(discoverInfo(str));
    }

    public DiscoverInfo discoverInfo(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (str == null) {
            return discoverInfo(null, null);
        }
        DiscoverInfo discoverInfoByUser = EntityCapsManager.getDiscoverInfoByUser(str);
        if (discoverInfoByUser != null) {
            return discoverInfoByUser;
        }
        EntityCapsManager.NodeVerHash nodeVerHashByJid = EntityCapsManager.getNodeVerHashByJid(str);
        DiscoverInfo discoverInfo = discoverInfo(str, nodeVerHashByJid != null ? nodeVerHashByJid.getNodeVer() : null);
        if (nodeVerHashByJid != null && EntityCapsManager.verifyDiscoverInfoVersion(nodeVerHashByJid.getVer(), nodeVerHashByJid.getHash(), discoverInfo)) {
            EntityCapsManager.addDiscoverInfoByNode(nodeVerHashByJid.getNodeVer(), discoverInfo);
        }
        return discoverInfo;
    }

    public DiscoverItems discoverItems(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return discoverItems(str, null);
    }

    public List<String> findServices(String str, boolean z, boolean z2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        List<String> list;
        String serviceName = connection().getServiceName();
        if (z2 && (list = this.services.get(str)) != null) {
            return list;
        }
        LinkedList linkedList = new LinkedList();
        try {
            if (discoverInfo(serviceName).containsFeature(str)) {
                linkedList.add(serviceName);
                if (z) {
                    if (z2) {
                        this.services.put(str, linkedList);
                    }
                    return linkedList;
                }
            }
            try {
                for (DiscoverItems.Item item : discoverItems(serviceName).getItems()) {
                    try {
                        if (discoverInfo(item.getEntityID()).containsFeature(str)) {
                            linkedList.add(item.getEntityID());
                            if (z) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException e) {
                        LOGGER.log(Level.WARNING, "Exception while discovering info for feature " + str + " of " + item.getEntityID() + " node: " + item.getNode(), e);
                    }
                }
                if (z2) {
                    this.services.put(str, linkedList);
                }
                return linkedList;
            } catch (XMPPException.XMPPErrorException e2) {
                LOGGER.log(Level.WARNING, "Could not discover items about service", (Throwable) e2);
                return linkedList;
            }
        } catch (XMPPException.XMPPErrorException e3) {
            LOGGER.log(Level.WARNING, "Could not discover information about service", (Throwable) e3);
            return linkedList;
        }
    }

    public DataForm getExtendedInfo() {
        return this.extendedInfo;
    }

    public List<ExtensionElement> getExtendedInfoAsList() {
        if (this.extendedInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.extendedInfo);
        return arrayList;
    }

    public synchronized List<String> getFeatures() {
        return new ArrayList(this.features);
    }

    public Set<DiscoverInfo.Identity> getIdentities() {
        HashSet hashSet = new HashSet(this.identities);
        hashSet.add(defaultIdentity);
        return Collections.unmodifiableSet(hashSet);
    }

    public DiscoverInfo.Identity getIdentity() {
        return this.identity;
    }

    public String getIdentityName() {
        return this.identity.getName();
    }

    public String getIdentityType() {
        return this.identity.getType();
    }

    public synchronized boolean includesFeature(String str) {
        return this.features.contains(str);
    }

    public void publishItems(String str, DiscoverItems discoverItems) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        publishItems(str, null, discoverItems);
    }

    public synchronized void removeExtendedInfo() {
        this.extendedInfo = null;
        renewEntityCapsVersion();
    }

    public synchronized void removeFeature(String str) {
        this.features.remove(str);
        renewEntityCapsVersion();
    }

    public synchronized boolean removeIdentity(DiscoverInfo.Identity identity) {
        if (identity.equals(this.identity)) {
            return false;
        }
        this.identities.remove(identity);
        renewEntityCapsVersion();
        return true;
    }

    public void removeNodeInformationProvider(String str) {
        this.nodeInformationProviders.remove(str);
    }

    public boolean serverSupportsFeature(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return supportsFeature(connection().getServiceName(), str);
    }

    public void setEntityCapsManager(EntityCapsManager entityCapsManager) {
        this.capsManager = entityCapsManager;
    }

    public synchronized void setExtendedInfo(DataForm dataForm) {
        this.extendedInfo = dataForm;
        renewEntityCapsVersion();
    }

    public synchronized void setIdentity(DiscoverInfo.Identity identity) {
        this.identity = (DiscoverInfo.Identity) Objects.requireNonNull(identity, "Identity can not be null");
        renewEntityCapsVersion();
    }

    public void setNodeInformationProvider(String str, NodeInformationProvider nodeInformationProvider) {
        this.nodeInformationProviders.put(str, nodeInformationProvider);
    }

    public boolean supportsFeature(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return discoverInfo(str).containsFeature(str2);
    }

    public DiscoverItems discoverItems(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setType(IQ.Type.get);
        discoverItems.setTo(str);
        discoverItems.setNode(str2);
        return (DiscoverItems) connection().createPacketCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public void publishItems(String str, String str2, DiscoverItems discoverItems) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        discoverItems.setType(IQ.Type.set);
        discoverItems.setTo(str);
        discoverItems.setNode(str2);
        connection().createPacketCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public static boolean canPublishItems(DiscoverInfo discoverInfo) {
        return discoverInfo.containsFeature("http://jabber.org/protocol/disco#publish");
    }

    public DiscoverInfo discoverInfo(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        DiscoverInfo discoverInfo = new DiscoverInfo();
        discoverInfo.setType(IQ.Type.get);
        discoverInfo.setTo(str);
        discoverInfo.setNode(str2);
        return (DiscoverInfo) connection().createPacketCollectorAndSend(discoverInfo).nextResultOrThrow();
    }
}
