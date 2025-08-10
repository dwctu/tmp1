package org.jivesoftware.smackx.privacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AbstractConnectionListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.IQResultReplyFilter;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.privacy.filter.SetActiveListFilter;
import org.jivesoftware.smackx.privacy.filter.SetDefaultListFilter;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

/* loaded from: classes5.dex */
public class PrivacyListManager extends Manager {
    private static final Map<XMPPConnection, PrivacyListManager> INSTANCES;
    public static final String NAMESPACE = "jabber:iq:privacy";
    public static final StanzaFilter PRIVACY_FILTER;
    private static final StanzaFilter PRIVACY_RESULT;
    private volatile String cachedActiveListName;
    private volatile String cachedDefaultListName;
    private final Set<PrivacyListListener> listeners;

    static {
        StanzaTypeFilter stanzaTypeFilter = new StanzaTypeFilter(Privacy.class);
        PRIVACY_FILTER = stanzaTypeFilter;
        PRIVACY_RESULT = new AndFilter(IQTypeFilter.RESULT, stanzaTypeFilter);
        INSTANCES = new WeakHashMap();
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PrivacyListManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private PrivacyListManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.listeners = new CopyOnWriteArraySet();
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", "jabber:iq:privacy", IQ.Type.set, IQRequestHandler.Mode.sync) { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                Privacy privacy = (Privacy) iq;
                for (PrivacyListListener privacyListListener : PrivacyListManager.this.listeners) {
                    for (Map.Entry<String, List<PrivacyItem>> entry : privacy.getItemLists().entrySet()) {
                        String key = entry.getKey();
                        List<PrivacyItem> value = entry.getValue();
                        if (value.isEmpty()) {
                            privacyListListener.updatedPrivacyList(key);
                        } else {
                            privacyListListener.setPrivacyList(key, value);
                        }
                    }
                }
                return IQ.createResultIQ(privacy);
            }
        });
        xMPPConnection.addPacketSendingListener(new StanzaListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                XMPPConnection xMPPConnectionConnection = PrivacyListManager.this.connection();
                Privacy privacy = (Privacy) stanza;
                IQResultReplyFilter iQResultReplyFilter = new IQResultReplyFilter(privacy, xMPPConnectionConnection);
                final String activeName = privacy.getActiveName();
                final boolean zIsDeclineActiveList = privacy.isDeclineActiveList();
                xMPPConnectionConnection.addOneTimeSyncCallback(new StanzaListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.3.1
                    @Override // org.jivesoftware.smack.StanzaListener
                    public void processPacket(Stanza stanza2) throws SmackException.NotConnectedException {
                        if (zIsDeclineActiveList) {
                            PrivacyListManager.this.cachedActiveListName = null;
                        } else {
                            PrivacyListManager.this.cachedActiveListName = activeName;
                        }
                    }
                }, iQResultReplyFilter);
            }
        }, SetActiveListFilter.INSTANCE);
        xMPPConnection.addPacketSendingListener(new StanzaListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                XMPPConnection xMPPConnectionConnection = PrivacyListManager.this.connection();
                Privacy privacy = (Privacy) stanza;
                IQResultReplyFilter iQResultReplyFilter = new IQResultReplyFilter(privacy, xMPPConnectionConnection);
                final String defaultName = privacy.getDefaultName();
                final boolean zIsDeclineDefaultList = privacy.isDeclineDefaultList();
                xMPPConnectionConnection.addOneTimeSyncCallback(new StanzaListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.4.1
                    @Override // org.jivesoftware.smack.StanzaListener
                    public void processPacket(Stanza stanza2) throws SmackException.NotConnectedException {
                        if (zIsDeclineDefaultList) {
                            PrivacyListManager.this.cachedDefaultListName = null;
                        } else {
                            PrivacyListManager.this.cachedDefaultListName = defaultName;
                        }
                    }
                }, iQResultReplyFilter);
            }
        }, SetDefaultListFilter.INSTANCE);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                Privacy privacy = (Privacy) stanza;
                String activeName = privacy.getActiveName();
                if (activeName != null) {
                    PrivacyListManager.this.cachedActiveListName = activeName;
                }
                String defaultName = privacy.getDefaultName();
                if (defaultName != null) {
                    PrivacyListManager.this.cachedDefaultListName = defaultName;
                }
            }
        }, PRIVACY_RESULT);
        xMPPConnection.addConnectionListener(new AbstractConnectionListener() { // from class: org.jivesoftware.smackx.privacy.PrivacyListManager.6
            @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (z) {
                    return;
                }
                PrivacyListManager privacyListManager = PrivacyListManager.this;
                privacyListManager.cachedActiveListName = privacyListManager.cachedDefaultListName = null;
            }
        });
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("jabber:iq:privacy");
    }

    public static synchronized PrivacyListManager getInstanceFor(XMPPConnection xMPPConnection) {
        PrivacyListManager privacyListManager;
        Map<XMPPConnection, PrivacyListManager> map = INSTANCES;
        privacyListManager = map.get(xMPPConnection);
        if (privacyListManager == null) {
            privacyListManager = new PrivacyListManager(xMPPConnection);
            map.put(xMPPConnection, privacyListManager);
        }
        return privacyListManager;
    }

    private List<PrivacyItem> getPrivacyListItems(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, new ArrayList());
        return getRequest(privacy).getPrivacyList(str);
    }

    private Privacy getPrivacyWithListNames() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getRequest(new Privacy());
    }

    private Privacy getRequest(Privacy privacy) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        privacy.setType(IQ.Type.get);
        return (Privacy) connection().createPacketCollectorAndSend(privacy).nextResultOrThrow();
    }

    private Stanza setRequest(Privacy privacy) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        privacy.setType(IQ.Type.set);
        return connection().createPacketCollectorAndSend(privacy).nextResultOrThrow();
    }

    public boolean addListener(PrivacyListListener privacyListListener) {
        return this.listeners.add(privacyListListener);
    }

    public void createPrivacyList(String str, List<PrivacyItem> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        updatePrivacyList(str, list);
    }

    public void declineActiveList() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setDeclineActiveList(true);
        setRequest(privacy);
    }

    public void declineDefaultList() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setDeclineDefaultList(true);
        setRequest(privacy);
    }

    public void deletePrivacyList(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, new ArrayList());
        setRequest(privacy);
    }

    public PrivacyList getActiveList() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String activeName = privacyWithListNames.getActiveName();
        return new PrivacyList(true, activeName != null && activeName.equals(privacyWithListNames.getDefaultName()), activeName, getPrivacyListItems(activeName));
    }

    public String getActiveListName() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return this.cachedActiveListName != null ? this.cachedActiveListName : getPrivacyWithListNames().getActiveName();
    }

    public PrivacyList getDefaultList() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String defaultName = privacyWithListNames.getDefaultName();
        return new PrivacyList(defaultName != null && defaultName.equals(privacyWithListNames.getActiveName()), true, defaultName, getPrivacyListItems(defaultName));
    }

    public String getDefaultListName() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return this.cachedDefaultListName != null ? this.cachedDefaultListName : getPrivacyWithListNames().getDefaultName();
    }

    public String getEffectiveListName() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        String activeListName = getActiveListName();
        return activeListName != null ? activeListName : getDefaultListName();
    }

    public PrivacyList getPrivacyList(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return new PrivacyList(false, false, str, getPrivacyListItems(str));
    }

    public List<PrivacyList> getPrivacyLists() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        Set<String> privacyListNames = privacyWithListNames.getPrivacyListNames();
        ArrayList arrayList = new ArrayList(privacyListNames.size());
        for (String str : privacyListNames) {
            arrayList.add(new PrivacyList(str.equals(privacyWithListNames.getActiveName()), str.equals(privacyWithListNames.getDefaultName()), str, getPrivacyListItems(str)));
        }
        return arrayList;
    }

    public boolean isSupported() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("jabber:iq:privacy");
    }

    public boolean removeListener(PrivacyListListener privacyListListener) {
        return this.listeners.remove(privacyListListener);
    }

    public void setActiveListName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setActiveName(str);
        setRequest(privacy);
    }

    public void setDefaultListName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setDefaultName(str);
        setRequest(privacy);
    }

    public void updatePrivacyList(String str, List<PrivacyItem> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, list);
        setRequest(privacy);
    }
}
