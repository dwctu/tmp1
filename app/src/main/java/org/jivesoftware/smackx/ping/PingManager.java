package org.jivesoftware.smackx.ping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.SmackExecutorThreadFactory;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ping.packet.Ping;

/* loaded from: classes5.dex */
public class PingManager extends Manager {
    private static int defaultPingInterval;
    private final ScheduledExecutorService executorService;
    private ScheduledFuture<?> nextAutomaticPing;
    private final Set<PingFailedListener> pingFailedListeners;
    private int pingInterval;
    private final Runnable pingServerRunnable;
    private static final Logger LOGGER = Logger.getLogger(PingManager.class.getName());
    private static final Map<XMPPConnection, PingManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.ping.PingManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PingManager.getInstanceFor(xMPPConnection);
            }
        });
        defaultPingInterval = 1800;
    }

    private PingManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pingFailedListeners = Collections.synchronizedSet(new HashSet());
        this.pingInterval = defaultPingInterval;
        this.pingServerRunnable = new Runnable() { // from class: org.jivesoftware.smackx.ping.PingManager.4
            @Override // java.lang.Runnable
            public void run() {
                PingManager.LOGGER.fine("ServerPingTask run()");
                PingManager.this.pingServerIfNecessary();
            }
        };
        this.executorService = Executors.newSingleThreadScheduledExecutor(new SmackExecutorThreadFactory(xMPPConnection.getConnectionCounter(), "Ping"));
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(Ping.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(Ping.ELEMENT, Ping.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.ping.PingManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                return ((Ping) iq).getPong();
            }
        });
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smackx.ping.PingManager.3
            @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                PingManager.this.maybeSchedulePingServerTask();
            }

            @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
            public void connectionTerminated() {
                PingManager.this.maybeStopPingServerTask();
            }
        });
        maybeSchedulePingServerTask();
    }

    public static synchronized PingManager getInstanceFor(XMPPConnection xMPPConnection) {
        PingManager pingManager;
        Map<XMPPConnection, PingManager> map = INSTANCES;
        pingManager = map.get(xMPPConnection);
        if (pingManager == null) {
            pingManager = new PingManager(xMPPConnection);
            map.put(xMPPConnection, pingManager);
        }
        return pingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeSchedulePingServerTask() {
        maybeSchedulePingServerTask(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeStopPingServerTask() {
        ScheduledFuture<?> scheduledFuture = this.nextAutomaticPing;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.nextAutomaticPing = null;
        }
    }

    public static void setDefaultPingInterval(int i) {
        defaultPingInterval = i;
    }

    public void finalize() throws Throwable {
        LOGGER.fine("finalizing PingManager: Shutting down executor service");
        try {
            this.executorService.shutdown();
        } finally {
            try {
            } finally {
            }
        }
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public boolean isPingSupported(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, Ping.NAMESPACE);
    }

    public boolean ping(String str, long j) throws SmackException.NotConnectedException, SmackException.NoResponseException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (!xMPPConnectionConnection.isAuthenticated()) {
            throw new SmackException.NotConnectedException();
        }
        try {
            xMPPConnectionConnection.createPacketCollectorAndSend(new Ping(str)).nextResultOrThrow(j);
            return true;
        } catch (XMPPException unused) {
            return str.equals(xMPPConnectionConnection.getServiceName());
        }
    }

    public boolean pingMyServer() throws SmackException.NotConnectedException {
        return pingMyServer(true);
    }

    public synchronized void pingServerIfNecessary() {
        int iCurrentTimeMillis;
        XMPPConnection xMPPConnectionConnection = connection();
        if (xMPPConnectionConnection == null) {
            return;
        }
        if (this.pingInterval <= 0) {
            return;
        }
        long lastStanzaReceived = xMPPConnectionConnection.getLastStanzaReceived();
        if (lastStanzaReceived > 0 && (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - lastStanzaReceived) / 1000)) < this.pingInterval) {
            maybeSchedulePingServerTask(iCurrentTimeMillis);
            return;
        }
        if (xMPPConnectionConnection.isAuthenticated()) {
            boolean zPingMyServer = false;
            for (int i = 0; i < 3; i++) {
                if (i != 0) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
                try {
                    zPingMyServer = pingMyServer(false);
                } catch (SmackException e) {
                    LOGGER.log(Level.WARNING, "SmackError while pinging server", (Throwable) e);
                    zPingMyServer = false;
                }
                if (zPingMyServer) {
                    break;
                }
            }
            if (zPingMyServer) {
                maybeSchedulePingServerTask();
            } else {
                Iterator<PingFailedListener> it = this.pingFailedListeners.iterator();
                while (it.hasNext()) {
                    it.next().pingFailed();
                }
            }
        } else {
            LOGGER.warning("XMPPConnection was not authenticated");
        }
    }

    public void registerPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.add(pingFailedListener);
    }

    public void setPingInterval(int i) {
        this.pingInterval = i;
        maybeSchedulePingServerTask();
    }

    public void unregisterPingFailedListener(PingFailedListener pingFailedListener) {
        this.pingFailedListeners.remove(pingFailedListener);
    }

    private synchronized void maybeSchedulePingServerTask(int i) {
        maybeStopPingServerTask();
        int i2 = this.pingInterval;
        if (i2 > 0) {
            int i3 = i2 - i;
            LOGGER.fine("Scheduling ServerPingTask in " + i3 + " seconds (pingInterval=" + this.pingInterval + ", delta=" + i + ")");
            this.nextAutomaticPing = this.executorService.schedule(this.pingServerRunnable, (long) i3, TimeUnit.SECONDS);
        }
    }

    public boolean pingMyServer(boolean z) throws SmackException.NotConnectedException {
        return pingMyServer(z, connection().getPacketReplyTimeout());
    }

    public boolean pingMyServer(boolean z, long j) throws SmackException.NotConnectedException {
        boolean zPing;
        try {
            zPing = ping(connection().getServiceName(), j);
        } catch (SmackException.NoResponseException unused) {
            zPing = false;
        }
        if (!zPing && z) {
            Iterator<PingFailedListener> it = this.pingFailedListeners.iterator();
            while (it.hasNext()) {
                it.next().pingFailed();
            }
        }
        return zPing;
    }

    public boolean ping(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException {
        return ping(str, connection().getPacketReplyTimeout());
    }
}
