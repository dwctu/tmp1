package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.util.Async;

/* loaded from: classes5.dex */
public class ReconnectionManager {
    private static int defaultFixedDelay;
    private static ReconnectionPolicy defaultReconnectionPolicy;
    private static boolean enabledPerDefault;
    private Thread reconnectionThread;
    private final WeakReference<AbstractXMPPConnection> weakRefConnection;
    private static final Logger LOGGER = Logger.getLogger(ReconnectionManager.class.getName());
    private static final Map<AbstractXMPPConnection, ReconnectionManager> INSTANCES = new WeakHashMap();
    private final int randomBase = new Random().nextInt(13) + 2;
    private volatile int fixedDelay = defaultFixedDelay;
    private volatile ReconnectionPolicy reconnectionPolicy = defaultReconnectionPolicy;
    private boolean automaticReconnectEnabled = false;
    public boolean done = false;
    private final ConnectionListener connectionListener = new AbstractConnectionListener() { // from class: org.jivesoftware.smack.ReconnectionManager.3
        @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
        public void authenticated(XMPPConnection xMPPConnection, boolean z) {
            ReconnectionManager.this.done = false;
        }

        @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
        public void connectionClosed() {
            ReconnectionManager.this.done = true;
        }

        @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
        public void connectionClosedOnError(Exception exc) {
            ReconnectionManager reconnectionManager = ReconnectionManager.this;
            reconnectionManager.done = false;
            if (reconnectionManager.isAutomaticReconnectEnabled()) {
                if (exc instanceof XMPPException.StreamErrorException) {
                    if (StreamError.Condition.conflict == ((XMPPException.StreamErrorException) exc).getStreamError().getCondition()) {
                        return;
                    }
                }
                ReconnectionManager.this.reconnect();
            }
        }
    };
    private final Runnable reconnectionRunnable = new Thread() { // from class: org.jivesoftware.smack.ReconnectionManager.2
        private int attempts = 0;

        private int timeDelay() {
            this.attempts++;
            int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy[ReconnectionManager.this.reconnectionPolicy.ordinal()];
            if (i == 1) {
                return ReconnectionManager.this.fixedDelay;
            }
            if (i == 2) {
                int i2 = this.attempts;
                return i2 > 13 ? ReconnectionManager.this.randomBase * 6 * 5 : i2 > 7 ? ReconnectionManager.this.randomBase * 6 : ReconnectionManager.this.randomBase;
            }
            throw new AssertionError("Unknown reconnection policy " + ReconnectionManager.this.reconnectionPolicy);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            AbstractXMPPConnection abstractXMPPConnection = (AbstractXMPPConnection) ReconnectionManager.this.weakRefConnection.get();
            if (abstractXMPPConnection == null) {
                return;
            }
            while (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection)) {
                int iTimeDelay = timeDelay();
                while (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection) && iTimeDelay > 0) {
                    try {
                        Thread.sleep(1000L);
                        iTimeDelay--;
                        Iterator<ConnectionListener> it = abstractXMPPConnection.connectionListeners.iterator();
                        while (it.hasNext()) {
                            it.next().reconnectingIn(iTimeDelay);
                        }
                    } catch (InterruptedException e) {
                        ReconnectionManager.LOGGER.log(Level.FINE, "waiting for reconnection interrupted", (Throwable) e);
                    }
                }
                Iterator<ConnectionListener> it2 = abstractXMPPConnection.connectionListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().reconnectingIn(0);
                }
                try {
                    if (ReconnectionManager.this.isReconnectionPossible(abstractXMPPConnection)) {
                        abstractXMPPConnection.connect();
                    }
                } catch (Exception e2) {
                    Iterator<ConnectionListener> it3 = abstractXMPPConnection.connectionListeners.iterator();
                    while (it3.hasNext()) {
                        it3.next().reconnectionFailed(e2);
                    }
                }
            }
        }
    };

    /* renamed from: org.jivesoftware.smack.ReconnectionManager$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy;

        static {
            int[] iArr = new int[ReconnectionPolicy.values().length];
            $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy = iArr;
            try {
                iArr[ReconnectionPolicy.FIXED_DELAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy[ReconnectionPolicy.RANDOM_INCREASING_DELAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum ReconnectionPolicy {
        RANDOM_INCREASING_DELAY,
        FIXED_DELAY
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smack.ReconnectionManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (xMPPConnection instanceof AbstractXMPPConnection) {
                    ReconnectionManager.getInstanceFor((AbstractXMPPConnection) xMPPConnection);
                }
            }
        });
        enabledPerDefault = false;
        defaultFixedDelay = 15;
        defaultReconnectionPolicy = ReconnectionPolicy.RANDOM_INCREASING_DELAY;
    }

    private ReconnectionManager(AbstractXMPPConnection abstractXMPPConnection) {
        this.weakRefConnection = new WeakReference<>(abstractXMPPConnection);
        if (getEnabledPerDefault()) {
            enableAutomaticReconnection();
        }
    }

    public static boolean getEnabledPerDefault() {
        return enabledPerDefault;
    }

    public static synchronized ReconnectionManager getInstanceFor(AbstractXMPPConnection abstractXMPPConnection) {
        ReconnectionManager reconnectionManager;
        Map<AbstractXMPPConnection, ReconnectionManager> map = INSTANCES;
        reconnectionManager = map.get(abstractXMPPConnection);
        if (reconnectionManager == null) {
            reconnectionManager = new ReconnectionManager(abstractXMPPConnection);
            map.put(abstractXMPPConnection, reconnectionManager);
        }
        return reconnectionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReconnectionPossible(XMPPConnection xMPPConnection) {
        return (this.done || xMPPConnection.isConnected() || !isAutomaticReconnectEnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reconnect() {
        AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
        if (abstractXMPPConnection == null) {
            LOGGER.fine("Connection is null, will not reconnect");
            return;
        }
        Thread thread = this.reconnectionThread;
        if (thread == null || !thread.isAlive()) {
            this.reconnectionThread = Async.go(this.reconnectionRunnable, "Smack Reconnection Manager (" + abstractXMPPConnection.getConnectionCounter() + ')');
        }
    }

    public static void setDefaultFixedDelay(int i) {
        defaultFixedDelay = i;
        setDefaultReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public static void setDefaultReconnectionPolicy(ReconnectionPolicy reconnectionPolicy) {
        defaultReconnectionPolicy = reconnectionPolicy;
    }

    public static void setEnabledPerDefault(boolean z) {
        enabledPerDefault = z;
    }

    public synchronized void disableAutomaticReconnection() {
        if (this.automaticReconnectEnabled) {
            AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
            if (abstractXMPPConnection == null) {
                throw new IllegalStateException("Connection instance no longer status_available");
            }
            abstractXMPPConnection.removeConnectionListener(this.connectionListener);
            this.automaticReconnectEnabled = false;
        }
    }

    public synchronized void enableAutomaticReconnection() {
        if (this.automaticReconnectEnabled) {
            return;
        }
        AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
        if (abstractXMPPConnection == null) {
            throw new IllegalStateException("Connection instance no longer status_available");
        }
        abstractXMPPConnection.addConnectionListener(this.connectionListener);
        this.automaticReconnectEnabled = true;
    }

    public boolean isAutomaticReconnectEnabled() {
        return this.automaticReconnectEnabled;
    }

    public void setFixedDelay(int i) {
        this.fixedDelay = i;
        setReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public void setReconnectionPolicy(ReconnectionPolicy reconnectionPolicy) {
        this.reconnectionPolicy = reconnectionPolicy;
    }
}
