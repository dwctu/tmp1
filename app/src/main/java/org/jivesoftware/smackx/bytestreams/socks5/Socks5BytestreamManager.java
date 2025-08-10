package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* loaded from: classes5.dex */
public final class Socks5BytestreamManager implements BytestreamManager {
    private static final String SESSION_ID_PREFIX = "js5_";
    private static final Map<XMPPConnection, Socks5BytestreamManager> managers;
    private static final Random randomGenerator;
    private final XMPPConnection connection;
    private final Map<String, BytestreamListener> userListeners = new ConcurrentHashMap();
    private final List<BytestreamListener> allRequestListeners = Collections.synchronizedList(new LinkedList());
    private int targetResponseTimeout = 10000;
    private int proxyConnectionTimeout = 10000;
    private final List<String> proxyBlacklist = Collections.synchronizedList(new LinkedList());
    private String lastWorkingProxy = null;
    private boolean proxyPrioritizationEnabled = true;
    private List<String> ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());
    private final InitiationListener initiationListener = new InitiationListener(this);

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(final XMPPConnection xMPPConnection) {
                Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
                xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager.1.1
                    @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
                    public void connectionTerminated() {
                        Socks5BytestreamManager.getBytestreamManager(xMPPConnection).disableService();
                    }

                    @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
                    public void reconnectionSuccessful() {
                        Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
                    }
                });
            }
        });
        randomGenerator = new Random();
        managers = new HashMap();
    }

    private Socks5BytestreamManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
    }

    private void activate() {
        this.connection.registerIQRequestHandler(this.initiationListener);
        enableService();
    }

    private Bytestream createBytestreamInitiation(String str, String str2, List<Bytestream.StreamHost> list) {
        Bytestream bytestream = new Bytestream(str);
        Iterator<Bytestream.StreamHost> it = list.iterator();
        while (it.hasNext()) {
            bytestream.addStreamHost(it.next());
        }
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(str2);
        return bytestream;
    }

    private Bytestream createStreamHostRequest(String str) {
        Bytestream bytestream = new Bytestream();
        bytestream.setType(IQ.Type.get);
        bytestream.setTo(str);
        return bytestream;
    }

    private List<String> determineProxies() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(this.connection);
        ArrayList arrayList = new ArrayList();
        for (DiscoverItems.Item item : instanceFor.discoverItems(this.connection.getServiceName()).getItems()) {
            if (!this.proxyBlacklist.contains(item.getEntityID())) {
                try {
                    if (instanceFor.discoverInfo(item.getEntityID()).hasIdentity("proxy", "bytestreams")) {
                        arrayList.add(item.getEntityID());
                    } else {
                        this.proxyBlacklist.add(item.getEntityID());
                    }
                } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException unused) {
                    this.proxyBlacklist.add(item.getEntityID());
                }
            }
        }
        return arrayList;
    }

    private List<Bytestream.StreamHost> determineStreamHostInfos(List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<Bytestream.StreamHost> localStreamHost = getLocalStreamHost();
        if (localStreamHost != null) {
            arrayList.addAll(localStreamHost);
        }
        for (String str : list) {
            try {
                arrayList.addAll(((Bytestream) this.connection.createPacketCollectorAndSend(createStreamHostRequest(str)).nextResultOrThrow()).getStreamHosts());
            } catch (Exception unused) {
                this.proxyBlacklist.add(str);
            }
        }
        return arrayList;
    }

    private void enableService() {
        ServiceDiscoveryManager.getInstanceFor(this.connection).addFeature(Bytestream.NAMESPACE);
    }

    public static synchronized Socks5BytestreamManager getBytestreamManager(XMPPConnection xMPPConnection) {
        if (xMPPConnection == null) {
            return null;
        }
        Map<XMPPConnection, Socks5BytestreamManager> map = managers;
        Socks5BytestreamManager socks5BytestreamManager = map.get(xMPPConnection);
        if (socks5BytestreamManager == null) {
            socks5BytestreamManager = new Socks5BytestreamManager(xMPPConnection);
            map.put(xMPPConnection, socks5BytestreamManager);
            socks5BytestreamManager.activate();
        }
        return socks5BytestreamManager;
    }

    private List<Bytestream.StreamHost> getLocalStreamHost() {
        Socks5Proxy socks5Proxy = Socks5Proxy.getSocks5Proxy();
        if (!socks5Proxy.isRunning()) {
            return null;
        }
        List<String> localAddresses = socks5Proxy.getLocalAddresses();
        if (localAddresses.isEmpty()) {
            return null;
        }
        int port = socks5Proxy.getPort();
        ArrayList arrayList = new ArrayList();
        for (String str : localAddresses) {
            String[] strArr = {"127.0.0.1", "0:0:0:0:0:0:0:1", "::1"};
            int i = 0;
            while (true) {
                if (i >= 3) {
                    arrayList.add(new Bytestream.StreamHost(this.connection.getUser(), str, port));
                    break;
                }
                if (str.startsWith(strArr[i])) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private String getNextSessionID() {
        return SESSION_ID_PREFIX + Math.abs(randomGenerator.nextLong());
    }

    private boolean supportsSocks5(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(this.connection).supportsFeature(str, Bytestream.NAMESPACE);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    public synchronized void disableService() {
        this.connection.unregisterIQRequestHandler(this.initiationListener);
        this.initiationListener.shutdown();
        this.allRequestListeners.clear();
        this.userListeners.clear();
        this.lastWorkingProxy = null;
        this.proxyBlacklist.clear();
        this.ignoredBytestreamRequests.clear();
        Map<XMPPConnection, Socks5BytestreamManager> map = managers;
        map.remove(this.connection);
        if (map.size() == 0) {
            Socks5Proxy.getSocks5Proxy().stop();
        }
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(this.connection);
        if (instanceFor != null) {
            instanceFor.removeFeature(Bytestream.NAMESPACE);
        }
    }

    public List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    public XMPPConnection getConnection() {
        return this.connection;
    }

    public List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }

    public int getProxyConnectionTimeout() {
        if (this.proxyConnectionTimeout <= 0) {
            this.proxyConnectionTimeout = 10000;
        }
        return this.proxyConnectionTimeout;
    }

    public int getTargetResponseTimeout() {
        if (this.targetResponseTimeout <= 0) {
            this.targetResponseTimeout = 10000;
        }
        return this.targetResponseTimeout;
    }

    public BytestreamListener getUserListener(String str) {
        return this.userListeners.get(str);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    public boolean isProxyPrioritizationEnabled() {
        return this.proxyPrioritizationEnabled;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    public void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException {
        this.connection.sendStanza(IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.not_acceptable)));
    }

    public void setProxyConnectionTimeout(int i) {
        this.proxyConnectionTimeout = i;
    }

    public void setProxyPrioritizationEnabled(boolean z) {
        this.proxyPrioritizationEnabled = z;
    }

    public void setTargetResponseTimeout(int i) {
        this.targetResponseTimeout = i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener, String str) {
        this.userListeners.put(str, bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(String str) {
        this.userListeners.remove(str);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public Socks5BytestreamSession establishSession(String str) throws SmackException, InterruptedException, IOException, XMPPException {
        return establishSession(str, getNextSessionID());
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public Socks5BytestreamSession establishSession(String str, String str2) throws SmackException, InterruptedException, IOException, XMPPException {
        if (supportsSocks5(str)) {
            ArrayList arrayList = new ArrayList();
            Bytestream.StreamHost streamHost = null;
            try {
                arrayList.addAll(determineProxies());
                e = null;
            } catch (XMPPException.XMPPErrorException e) {
                e = e;
            }
            List<Bytestream.StreamHost> listDetermineStreamHostInfos = determineStreamHostInfos(arrayList);
            if (listDetermineStreamHostInfos.isEmpty()) {
                if (e != null) {
                    throw e;
                }
                throw new SmackException("no SOCKS5 proxies status_available");
            }
            String strCreateDigest = Socks5Utils.createDigest(str2, this.connection.getUser(), str);
            if (this.proxyPrioritizationEnabled && this.lastWorkingProxy != null) {
                Iterator<Bytestream.StreamHost> it = listDetermineStreamHostInfos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bytestream.StreamHost next = it.next();
                    if (next.getJID().equals(this.lastWorkingProxy)) {
                        streamHost = next;
                        break;
                    }
                }
                if (streamHost != null) {
                    listDetermineStreamHostInfos.remove(streamHost);
                    listDetermineStreamHostInfos.add(0, streamHost);
                }
            }
            Socks5Proxy socks5Proxy = Socks5Proxy.getSocks5Proxy();
            try {
                try {
                    socks5Proxy.addTransfer(strCreateDigest);
                    Bytestream bytestreamCreateBytestreamInitiation = createBytestreamInitiation(str2, str, listDetermineStreamHostInfos);
                    Bytestream.StreamHost streamHost2 = bytestreamCreateBytestreamInitiation.getStreamHost(((Bytestream) this.connection.createPacketCollectorAndSend(bytestreamCreateBytestreamInitiation).nextResultOrThrow(getTargetResponseTimeout())).getUsedHost().getJID());
                    if (streamHost2 != null) {
                        Socket socket = new Socks5ClientForInitiator(streamHost2, strCreateDigest, this.connection, str2, str).getSocket(getProxyConnectionTimeout());
                        this.lastWorkingProxy = streamHost2.getJID();
                        return new Socks5BytestreamSession(socket, streamHost2.getJID().equals(this.connection.getUser()));
                    }
                    throw new SmackException("Remote user responded with unknown host");
                } catch (TimeoutException unused) {
                    throw new IOException("Timeout while connecting to SOCKS5 proxy");
                }
            } finally {
                socks5Proxy.removeTransfer(strCreateDigest);
            }
        }
        throw new SmackException.FeatureNotSupportedException("SOCKS5 Bytestream", str);
    }
}
