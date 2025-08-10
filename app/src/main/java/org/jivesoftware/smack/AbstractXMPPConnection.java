package org.jivesoftware.smack;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.debugger.SmackDebugger;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.PlainStreamElement;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.parsing.UnparsablePacket;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.SmackExecutorThreadFactory;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.dns.HostAddress;
import org.jxmpp.util.XmppStringUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public abstract class AbstractXMPPConnection implements XMPPConnection {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(AbstractXMPPConnection.class.getName());
    private static final AtomicInteger connectionCounter = new AtomicInteger(0);
    private static boolean replyToUnknownIqDefault;
    public boolean authenticated;
    private final ExecutorService cachedExecutorService;
    public XMPPInputOutputStream compressionHandler;
    public final ConnectionConfiguration config;
    public final int connectionCounterValue;
    private final ThreadPoolExecutor executorService;
    private XMPPConnection.FromMode fromMode;
    private final Map<String, IQRequestHandler> getIqRequestHandler;
    public String host;
    public List<HostAddress> hostAddresses;
    private long lastStanzaReceived;
    private ParsingExceptionCallback parsingExceptionCallback;
    public int port;
    public Reader reader;
    private final ScheduledExecutorService removeCallbacksService;
    private boolean replyToUnkownIq;
    private String serviceName;
    private final Map<String, IQRequestHandler> setIqRequestHandler;
    private final ExecutorService singleThreadedExecutorService;
    public String streamId;
    private String usedPassword;
    private String usedResource;
    private String usedUsername;
    public String user;
    public boolean wasAuthenticated;
    public Writer writer;
    public final Set<ConnectionListener> connectionListeners = new CopyOnWriteArraySet();
    private final Collection<PacketCollector> collectors = new ConcurrentLinkedQueue();
    private final Map<StanzaListener, ListenerWrapper> syncRecvListeners = new LinkedHashMap();
    private final Map<StanzaListener, ListenerWrapper> asyncRecvListeners = new LinkedHashMap();
    private final Map<StanzaListener, ListenerWrapper> sendListeners = new HashMap();
    private final Map<StanzaListener, InterceptorWrapper> interceptors = new HashMap();
    public final Lock connectionLock = new ReentrantLock();
    public final Map<String, ExtensionElement> streamFeatures = new HashMap();
    public boolean connected = false;
    private long packetReplyTimeout = SmackConfiguration.getDefaultPacketReplyTimeout();
    public SmackDebugger debugger = null;
    public final SynchronizationPoint<Exception> lastFeaturesReceived = new SynchronizationPoint<>(this);
    public final SynchronizationPoint<SmackException> saslFeatureReceived = new SynchronizationPoint<>(this);
    public SASLAuthentication saslAuthentication = new SASLAuthentication(this);

    /* renamed from: org.jivesoftware.smack.AbstractXMPPConnection$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode;
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode;
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQRequestHandler.Mode.values().length];
            $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode = iArr;
            try {
                iArr[IQRequestHandler.Mode.sync.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode[IQRequestHandler.Mode.async.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr2;
            try {
                iArr2[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.get.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[XMPPConnection.FromMode.values().length];
            $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode = iArr3;
            try {
                iArr3[XMPPConnection.FromMode.OMITTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[XMPPConnection.FromMode.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[XMPPConnection.FromMode.UNCHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class InterceptorWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetInterceptor;

        public InterceptorWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetInterceptor = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getInterceptor() {
            return this.packetInterceptor;
        }
    }

    public class ListenerNotification implements Runnable {
        private final Stanza packet;

        public ListenerNotification(Stanza stanza) {
            this.packet = stanza;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractXMPPConnection.this.invokePacketCollectorsAndNotifyRecvListeners(this.packet);
        }
    }

    public static class ListenerWrapper {
        private final StanzaFilter packetFilter;
        private final StanzaListener packetListener;

        public ListenerWrapper(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
            this.packetListener = stanzaListener;
            this.packetFilter = stanzaFilter;
        }

        public boolean filterMatches(Stanza stanza) {
            StanzaFilter stanzaFilter = this.packetFilter;
            return stanzaFilter == null || stanzaFilter.accept(stanza);
        }

        public StanzaListener getListener() {
            return this.packetListener;
        }
    }

    static {
        SmackConfiguration.getVersion();
        replyToUnknownIqDefault = true;
    }

    public AbstractXMPPConnection(ConnectionConfiguration connectionConfiguration) {
        int andIncrement = connectionCounter.getAndIncrement();
        this.connectionCounterValue = andIncrement;
        this.fromMode = XMPPConnection.FromMode.OMITTED;
        this.parsingExceptionCallback = SmackConfiguration.getDefaultParsingExceptionCallback();
        this.executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new SmackExecutorThreadFactory(andIncrement, "Incoming Processor"));
        this.removeCallbacksService = Executors.newSingleThreadScheduledExecutor(new SmackExecutorThreadFactory(andIncrement, "Remove Callbacks"));
        this.cachedExecutorService = Executors.newCachedThreadPool(new SmackExecutorThreadFactory(andIncrement, "Cached Executor"));
        this.singleThreadedExecutorService = Executors.newSingleThreadExecutor(new SmackExecutorThreadFactory(getConnectionCounter(), "Single Threaded Executor"));
        this.authenticated = false;
        this.wasAuthenticated = false;
        this.setIqRequestHandler = new HashMap();
        this.getIqRequestHandler = new HashMap();
        this.replyToUnkownIq = replyToUnknownIqDefault;
        this.config = connectionConfiguration;
    }

    private void addStreamFeature(ExtensionElement extensionElement) {
        this.streamFeatures.put(XmppStringUtils.generateKey(extensionElement.getElementName(), extensionElement.getNamespace()), extensionElement);
    }

    private void firePacketInterceptors(Stanza stanza) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.interceptors) {
            for (InterceptorWrapper interceptorWrapper : this.interceptors.values()) {
                if (interceptorWrapper.filterMatches(stanza)) {
                    linkedList.add(interceptorWrapper.getInterceptor());
                }
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            try {
                ((StanzaListener) it.next()).processPacket(stanza);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Packet interceptor threw exception", (Throwable) e);
            }
        }
    }

    public static Collection<ConnectionCreationListener> getConnectionCreationListeners() {
        return XMPPConnectionRegistry.getConnectionCreationListeners();
    }

    public static void setReplyToUnknownIqDefault(boolean z) {
        replyToUnknownIqDefault = z;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addAsyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaListener, "Packet listener is null.");
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.asyncRecvListeners) {
            this.asyncRecvListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener == null) {
            return;
        }
        this.connectionListeners.add(connectionListener);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addOneTimeSyncCallback(final StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        final StanzaListener stanzaListener2 = new StanzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.7
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                try {
                    stanzaListener.processPacket(stanza);
                } finally {
                    AbstractXMPPConnection.this.removeSyncStanzaListener(this);
                }
            }
        };
        addSyncStanzaListener(stanzaListener2, stanzaFilter);
        this.removeCallbacksService.schedule(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.8
            @Override // java.lang.Runnable
            public void run() {
                AbstractXMPPConnection.this.removeSyncStanzaListener(stanzaListener2);
            }
        }, getPacketReplyTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addPacketInterceptor(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaListener, "Packet interceptor is null.");
        InterceptorWrapper interceptorWrapper = new InterceptorWrapper(stanzaListener, stanzaFilter);
        synchronized (this.interceptors) {
            this.interceptors.put(stanzaListener, interceptorWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    @Deprecated
    public void addPacketListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        addAsyncStanzaListener(stanzaListener, stanzaFilter);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addPacketSendingListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaListener, "Packet listener is null.");
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.sendListeners) {
            this.sendListeners.put(stanzaListener, listenerWrapper);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void addSyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaListener, "Packet listener is null.");
        ListenerWrapper listenerWrapper = new ListenerWrapper(stanzaListener, stanzaFilter);
        synchronized (this.syncRecvListeners) {
            this.syncRecvListeners.put(stanzaListener, listenerWrapper);
        }
    }

    public void afterFeaturesReceived() throws SmackException.NotConnectedException, SmackException.SecurityRequiredException {
    }

    public void afterSuccessfulLogin(boolean z) throws SmackException.NotConnectedException {
        SmackDebugger smackDebugger;
        this.authenticated = true;
        if (this.config.isDebuggerEnabled() && (smackDebugger = this.debugger) != null) {
            smackDebugger.userHasLogged(this.user);
        }
        callConnectionAuthenticatedListener(z);
        if (!this.config.isSendPresence() || z) {
            return;
        }
        sendStanza(new Presence(Presence.Type.available));
    }

    public final void asyncGo(Runnable runnable) {
        this.cachedExecutorService.execute(runnable);
    }

    public void bindResourceAndEstablishSession(String str) throws SmackException, IOException, XMPPException.XMPPErrorException {
        LOGGER.finer("Waiting for last features to be received before continuing with resource binding");
        this.lastFeaturesReceived.checkIfSuccessOrWait();
        if (!hasFeature(Bind.ELEMENT, Bind.NAMESPACE)) {
            throw new SmackException.ResourceBindingNotOfferedException();
        }
        Bind bindNewSet = Bind.newSet(str);
        String jid = ((Bind) createPacketCollectorAndSend(new StanzaIdFilter(bindNewSet), bindNewSet).nextResultOrThrow()).getJid();
        this.user = jid;
        this.serviceName = XmppStringUtils.parseDomain(jid);
        Session.Feature feature = (Session.Feature) getFeature("session", Session.NAMESPACE);
        if (feature == null || feature.isOptional() || getConfiguration().isLegacySessionDisabled()) {
            return;
        }
        Session session = new Session();
        createPacketCollectorAndSend(new StanzaIdFilter(session), session).nextResultOrThrow();
    }

    public void callConnectionAuthenticatedListener(boolean z) {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().authenticated(this, z);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception in authenticated listener", (Throwable) e);
            }
        }
    }

    public void callConnectionClosedListener() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().connectionClosed();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", (Throwable) e);
            }
        }
    }

    public void callConnectionClosedOnErrorListener(Exception exc) {
        LOGGER.log(Level.WARNING, "Connection closed with error", (Throwable) exc);
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().connectionClosedOnError(exc);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error in listener while closing connection", (Throwable) e);
            }
        }
    }

    public void callConnectionConnectedListener() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            it.next().connected(this);
        }
    }

    public synchronized AbstractXMPPConnection connect() throws SmackException, IOException, XMPPException {
        throwAlreadyConnectedExceptionIfAppropriate();
        this.saslAuthentication.init();
        this.saslFeatureReceived.init();
        this.lastFeaturesReceived.init();
        this.streamId = null;
        connectInternal();
        return this;
    }

    public abstract void connectInternal() throws SmackException, IOException, XMPPException;

    @Override // org.jivesoftware.smack.XMPPConnection
    public PacketCollector createPacketCollector(StanzaFilter stanzaFilter) {
        return createPacketCollector(PacketCollector.newConfiguration().setStanzaFilter(stanzaFilter));
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public PacketCollector createPacketCollectorAndSend(IQ iq) throws SmackException.NotConnectedException {
        return createPacketCollectorAndSend(new IQReplyFilter(iq, this), iq);
    }

    public void disconnect() {
        try {
            disconnect(new Presence(Presence.Type.unavailable));
        } catch (SmackException.NotConnectedException e) {
            LOGGER.log(Level.FINEST, "Connection is already disconnected", (Throwable) e);
        }
    }

    public void finalize() throws Throwable {
        LOGGER.fine("finalizing XMPPConnection ( " + getConnectionCounter() + "): Shutting down executor services");
        try {
            this.executorService.shutdownNow();
            this.cachedExecutorService.shutdown();
            this.removeCallbacksService.shutdownNow();
            this.singleThreadedExecutorService.shutdownNow();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void firePacketSendingListeners(final Stanza stanza) {
        final LinkedList linkedList = new LinkedList();
        synchronized (this.sendListeners) {
            for (ListenerWrapper listenerWrapper : this.sendListeners.values()) {
                if (listenerWrapper.filterMatches(stanza)) {
                    linkedList.add(listenerWrapper.getListener());
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        asyncGo(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    try {
                        ((StanzaListener) it.next()).processPacket(stanza);
                    } catch (Exception e) {
                        AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Sending listener threw exception", (Throwable) e);
                    }
                }
            }
        });
    }

    public ConnectionConfiguration getConfiguration() {
        return this.config;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public int getConnectionCounter() {
        return this.connectionCounterValue;
    }

    public Lock getConnectionLock() {
        return this.connectionLock;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public <F extends ExtensionElement> F getFeature(String str, String str2) {
        return (F) this.streamFeatures.get(XmppStringUtils.generateKey(str, str2));
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public XMPPConnection.FromMode getFromMode() {
        return this.fromMode;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public String getHost() {
        return this.host;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public long getLastStanzaReceived() {
        return this.lastStanzaReceived;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public long getPacketReplyTimeout() {
        return this.packetReplyTimeout;
    }

    public ParsingExceptionCallback getParsingExceptionCallback() {
        return this.parsingExceptionCallback;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public int getPort() {
        return this.port;
    }

    public SASLAuthentication getSASLAuthentication() {
        return this.saslAuthentication;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public String getServiceName() {
        String str = this.serviceName;
        return str != null ? str : this.config.getServiceName();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public String getStreamId() {
        if (isConnected()) {
            return this.streamId;
        }
        return null;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final String getUser() {
        return this.user;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean hasFeature(String str, String str2) {
        return getFeature(str, str2) != null;
    }

    public void initDebugger() {
        if (this.reader == null || this.writer == null) {
            throw new NullPointerException("Reader or writer isn't initialized.");
        }
        if (this.config.isDebuggerEnabled()) {
            if (this.debugger == null) {
                this.debugger = SmackConfiguration.createDebugger(this, this.writer, this.reader);
            }
            SmackDebugger smackDebugger = this.debugger;
            if (smackDebugger == null) {
                LOGGER.severe("Debugging enabled but could not find debugger class");
            } else {
                this.reader = smackDebugger.newConnectionReader(this.reader);
                this.writer = this.debugger.newConnectionWriter(this.writer);
            }
        }
    }

    public void invokePacketCollectorsAndNotifyRecvListeners(final Stanza stanza) {
        final IQRequestHandler iQRequestHandler;
        if (stanza instanceof IQ) {
            final IQ iq = (IQ) stanza;
            IQ.Type type = iq.getType();
            int[] iArr = AnonymousClass9.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type;
            int i = iArr[type.ordinal()];
            if (i == 1 || i == 2) {
                String strGenerateKey = XmppStringUtils.generateKey(iq.getChildElementName(), iq.getChildElementNamespace());
                int i2 = iArr[type.ordinal()];
                if (i2 == 1) {
                    synchronized (this.setIqRequestHandler) {
                        iQRequestHandler = this.setIqRequestHandler.get(strGenerateKey);
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("Should only encounter IQ type 'get' or 'set'");
                    }
                    synchronized (this.getIqRequestHandler) {
                        iQRequestHandler = this.getIqRequestHandler.get(strGenerateKey);
                    }
                }
                if (iQRequestHandler != null) {
                    ExecutorService executorService = null;
                    int i3 = AnonymousClass9.$SwitchMap$org$jivesoftware$smack$iqrequest$IQRequestHandler$Mode[iQRequestHandler.getMode().ordinal()];
                    if (i3 == 1) {
                        executorService = this.singleThreadedExecutorService;
                    } else if (i3 == 2) {
                        executorService = this.cachedExecutorService;
                    }
                    executorService.execute(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IQ iqHandleIQRequest = iQRequestHandler.handleIQRequest(iq);
                            if (iqHandleIQRequest == null) {
                                return;
                            }
                            try {
                                AbstractXMPPConnection.this.sendStanza(iqHandleIQRequest);
                            } catch (SmackException.NotConnectedException e) {
                                AbstractXMPPConnection.LOGGER.log(Level.WARNING, "NotConnectedException while sending response to IQ request", (Throwable) e);
                            }
                        }
                    });
                    return;
                }
                if (!this.replyToUnkownIq) {
                    return;
                }
                try {
                    sendStanza(IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.feature_not_implemented)));
                } catch (SmackException.NotConnectedException e) {
                    LOGGER.log(Level.WARNING, "NotConnectedException while sending error IQ to unkown IQ request", (Throwable) e);
                }
            }
        }
        final LinkedList<StanzaListener> linkedList = new LinkedList();
        synchronized (this.asyncRecvListeners) {
            for (ListenerWrapper listenerWrapper : this.asyncRecvListeners.values()) {
                if (listenerWrapper.filterMatches(stanza)) {
                    linkedList.add(listenerWrapper.getListener());
                }
            }
        }
        for (final StanzaListener stanzaListener : linkedList) {
            asyncGo(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        stanzaListener.processPacket(stanza);
                    } catch (Exception e2) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in async packet listener", (Throwable) e2);
                    }
                }
            });
        }
        Iterator<PacketCollector> it = this.collectors.iterator();
        while (it.hasNext()) {
            it.next().processPacket(stanza);
        }
        linkedList.clear();
        synchronized (this.syncRecvListeners) {
            for (ListenerWrapper listenerWrapper2 : this.syncRecvListeners.values()) {
                if (listenerWrapper2.filterMatches(stanza)) {
                    linkedList.add(listenerWrapper2.getListener());
                }
            }
        }
        this.singleThreadedExecutorService.execute(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    try {
                        ((StanzaListener) it2.next()).processPacket(stanza);
                    } catch (SmackException.NotConnectedException e2) {
                        AbstractXMPPConnection.LOGGER.log(Level.WARNING, "Got not connected exception, aborting", (Throwable) e2);
                        return;
                    } catch (Exception e3) {
                        AbstractXMPPConnection.LOGGER.log(Level.SEVERE, "Exception in packet listener", (Throwable) e3);
                    }
                }
            }
        });
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isAnonymous() {
        return this.config.getUsername() == null && this.usedUsername == null && !this.config.allowNullOrEmptyUsername;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final boolean isConnected() {
        return this.connected;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract boolean isSecureConnection();

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract boolean isUsingCompression();

    public synchronized void login() throws SmackException, IOException, XMPPException {
        if (isAnonymous()) {
            throwNotConnectedExceptionIfAppropriate();
            throwAlreadyLoggedInExceptionIfAppropriate();
            loginAnonymously();
        } else {
            CharSequence username = this.usedUsername;
            if (username == null) {
                username = this.config.getUsername();
            }
            String password = this.usedPassword;
            if (password == null) {
                password = this.config.getPassword();
            }
            String resource = this.usedResource;
            if (resource == null) {
                resource = this.config.getResource();
            }
            login(username, password, resource);
        }
    }

    public abstract void loginAnonymously() throws SmackException, IOException, XMPPException;

    public abstract void loginNonAnonymously(String str, String str2, String str3) throws SmackException, IOException, XMPPException;

    public void notifyReconnection() {
        Iterator<ConnectionListener> it = this.connectionListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().reconnectionSuccessful();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "notifyReconnection()", (Throwable) e);
            }
        }
    }

    public void parseAndProcessStanza(XmlPullParser xmlPullParser) throws Exception {
        Stanza stanza;
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        try {
            stanza = PacketParserUtils.parseStanza(xmlPullParser);
        } catch (Exception e) {
            UnparsablePacket unparsablePacket = new UnparsablePacket(PacketParserUtils.parseContentDepth(xmlPullParser, depth), e);
            ParsingExceptionCallback parsingExceptionCallback = getParsingExceptionCallback();
            if (parsingExceptionCallback != null) {
                parsingExceptionCallback.handleUnparsablePacket(unparsablePacket);
            }
            stanza = null;
        }
        ParserUtils.assertAtEndTag(xmlPullParser);
        if (stanza != null) {
            processPacket(stanza);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseFeatures(org.xmlpull.v1.XmlPullParser r13) throws org.xmlpull.v1.XmlPullParserException, org.jivesoftware.smack.SmackException, java.io.IOException {
        /*
            r12 = this;
            java.util.Map<java.lang.String, org.jivesoftware.smack.packet.ExtensionElement> r0 = r12.streamFeatures
            r0.clear()
            int r0 = r13.getDepth()
        L9:
            int r1 = r13.next()
            java.lang.String r2 = "compression"
            java.lang.String r3 = "starttls"
            java.lang.String r4 = "bind"
            java.lang.String r5 = "mechanisms"
            r6 = 3
            r7 = 2
            if (r1 != r7) goto L95
            int r8 = r13.getDepth()
            int r9 = r0 + 1
            if (r8 != r9) goto L95
            r1 = 0
            java.lang.String r8 = r13.getName()
            java.lang.String r9 = r13.getNamespace()
            r8.hashCode()
            r10 = -1
            int r11 = r8.hashCode()
            switch(r11) {
                case -676919238: goto L5b;
                case 3023933: goto L52;
                case 1316817241: goto L49;
                case 1431984486: goto L42;
                case 1984987798: goto L37;
                default: goto L35;
            }
        L35:
            r6 = -1
            goto L63
        L37:
            java.lang.String r2 = "session"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L40
            goto L35
        L40:
            r6 = 4
            goto L63
        L42:
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L63
            goto L35
        L49:
            boolean r2 = r8.equals(r3)
            if (r2 != 0) goto L50
            goto L35
        L50:
            r6 = 2
            goto L63
        L52:
            boolean r2 = r8.equals(r4)
            if (r2 != 0) goto L59
            goto L35
        L59:
            r6 = 1
            goto L63
        L5b:
            boolean r2 = r8.equals(r5)
            if (r2 != 0) goto L62
            goto L35
        L62:
            r6 = 0
        L63:
            switch(r6) {
                case 0: goto L85;
                case 1: goto L82;
                case 2: goto L7d;
                case 3: goto L78;
                case 4: goto L73;
                default: goto L66;
            }
        L66:
            org.jivesoftware.smack.provider.ExtensionElementProvider r2 = org.jivesoftware.smack.provider.ProviderManager.getStreamFeatureProvider(r8, r9)
            if (r2 == 0) goto L8e
            org.jivesoftware.smack.packet.Element r1 = r2.parse(r13)
            org.jivesoftware.smack.packet.ExtensionElement r1 = (org.jivesoftware.smack.packet.ExtensionElement) r1
            goto L8e
        L73:
            org.jivesoftware.smack.packet.Session$Feature r1 = org.jivesoftware.smack.util.PacketParserUtils.parseSessionFeature(r13)
            goto L8e
        L78:
            org.jivesoftware.smack.compress.packet.Compress$Feature r1 = org.jivesoftware.smack.util.PacketParserUtils.parseCompressionFeature(r13)
            goto L8e
        L7d:
            org.jivesoftware.smack.packet.StartTls r1 = org.jivesoftware.smack.util.PacketParserUtils.parseStartTlsFeature(r13)
            goto L8e
        L82:
            org.jivesoftware.smack.packet.Bind$Feature r1 = org.jivesoftware.smack.packet.Bind.Feature.INSTANCE
            goto L8e
        L85:
            org.jivesoftware.smack.packet.Mechanisms r1 = new org.jivesoftware.smack.packet.Mechanisms
            java.util.Collection r2 = org.jivesoftware.smack.util.PacketParserUtils.parseMechanisms(r13)
            r1.<init>(r2)
        L8e:
            if (r1 == 0) goto L9
            r12.addStreamFeature(r1)
            goto L9
        L95:
            if (r1 != r6) goto L9
            int r1 = r13.getDepth()
            if (r1 != r0) goto L9
            java.lang.String r13 = "urn:ietf:params:xml:ns:xmpp-sasl"
            boolean r13 = r12.hasFeature(r5, r13)
            if (r13 == 0) goto Lbc
            java.lang.String r13 = "urn:ietf:params:xml:ns:xmpp-tls"
            boolean r13 = r12.hasFeature(r3, r13)
            if (r13 == 0) goto Lb7
            org.jivesoftware.smack.ConnectionConfiguration r13 = r12.config
            org.jivesoftware.smack.ConnectionConfiguration$SecurityMode r13 = r13.getSecurityMode()
            org.jivesoftware.smack.ConnectionConfiguration$SecurityMode r0 = org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.disabled
            if (r13 != r0) goto Lbc
        Lb7:
            org.jivesoftware.smack.SynchronizationPoint<org.jivesoftware.smack.SmackException> r13 = r12.saslFeatureReceived
            r13.reportSuccess()
        Lbc:
            java.lang.String r13 = "urn:ietf:params:xml:ns:xmpp-bind"
            boolean r13 = r12.hasFeature(r4, r13)
            if (r13 == 0) goto Ld9
            java.lang.String r13 = "http://jabber.org/protocol/compress"
            boolean r13 = r12.hasFeature(r2, r13)
            if (r13 == 0) goto Ld4
            org.jivesoftware.smack.ConnectionConfiguration r13 = r12.config
            boolean r13 = r13.isCompressionEnabled()
            if (r13 != 0) goto Ld9
        Ld4:
            org.jivesoftware.smack.SynchronizationPoint<java.lang.Exception> r13 = r12.lastFeaturesReceived
            r13.reportSuccess()
        Ld9:
            r12.afterFeaturesReceived()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.AbstractXMPPConnection.parseFeatures(org.xmlpull.v1.XmlPullParser):void");
    }

    public List<HostAddress> populateHostAddresses() {
        LinkedList linkedList = new LinkedList();
        ConnectionConfiguration connectionConfiguration = this.config;
        if (connectionConfiguration.host != null) {
            this.hostAddresses = new ArrayList(1);
            ConnectionConfiguration connectionConfiguration2 = this.config;
            this.hostAddresses.add(new HostAddress(connectionConfiguration2.host, connectionConfiguration2.port));
        } else {
            this.hostAddresses = DNSUtil.resolveXMPPDomain(connectionConfiguration.serviceName, linkedList);
        }
        return linkedList;
    }

    public void processPacket(Stanza stanza) {
        this.lastStanzaReceived = System.currentTimeMillis();
        this.executorService.submit(new ListenerNotification(stanza));
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public IQRequestHandler registerIQRequestHandler(IQRequestHandler iQRequestHandler) {
        IQRequestHandler iQRequestHandlerPut;
        IQRequestHandler iQRequestHandlerPut2;
        String strGenerateKey = XmppStringUtils.generateKey(iQRequestHandler.getElement(), iQRequestHandler.getNamespace());
        int i = AnonymousClass9.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[iQRequestHandler.getType().ordinal()];
        if (i == 1) {
            synchronized (this.setIqRequestHandler) {
                iQRequestHandlerPut = this.setIqRequestHandler.put(strGenerateKey, iQRequestHandler);
            }
            return iQRequestHandlerPut;
        }
        if (i != 2) {
            throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
        }
        synchronized (this.getIqRequestHandler) {
            iQRequestHandlerPut2 = this.getIqRequestHandler.put(strGenerateKey, iQRequestHandler);
        }
        return iQRequestHandlerPut2;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean removeAsyncStanzaListener(StanzaListener stanzaListener) {
        boolean z;
        synchronized (this.asyncRecvListeners) {
            z = this.asyncRecvListeners.remove(stanzaListener) != null;
        }
        return z;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removeConnectionListener(ConnectionListener connectionListener) {
        this.connectionListeners.remove(connectionListener);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removePacketCollector(PacketCollector packetCollector) {
        this.collectors.remove(packetCollector);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removePacketInterceptor(StanzaListener stanzaListener) {
        synchronized (this.interceptors) {
            this.interceptors.remove(stanzaListener);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    @Deprecated
    public boolean removePacketListener(StanzaListener stanzaListener) {
        return removeAsyncStanzaListener(stanzaListener);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void removePacketSendingListener(StanzaListener stanzaListener) {
        synchronized (this.sendListeners) {
            this.sendListeners.remove(stanzaListener);
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public boolean removeSyncStanzaListener(StanzaListener stanzaListener) {
        boolean z;
        synchronized (this.syncRecvListeners) {
            z = this.syncRecvListeners.remove(stanzaListener) != null;
        }
        return z;
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.removeCallbacksService.schedule(runnable, j, timeUnit);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public abstract void send(PlainStreamElement plainStreamElement) throws SmackException.NotConnectedException;

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendIqWithResponseCallback(IQ iq, StanzaListener stanzaListener) throws SmackException.NotConnectedException {
        sendIqWithResponseCallback(iq, stanzaListener, null);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    @Deprecated
    public void sendPacket(Stanza stanza) throws SmackException.NotConnectedException {
        sendStanza(stanza);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendStanza(Stanza stanza) throws SmackException.NotConnectedException {
        org.jivesoftware.smack.util.Objects.requireNonNull(stanza, "Packet must not be null");
        throwNotConnectedExceptionIfAppropriate();
        int i = AnonymousClass9.$SwitchMap$org$jivesoftware$smack$XMPPConnection$FromMode[this.fromMode.ordinal()];
        if (i == 1) {
            stanza.setFrom(null);
        } else if (i == 2) {
            stanza.setFrom(getUser());
        }
        firePacketInterceptors(stanza);
        sendStanzaInternal(stanza);
    }

    public abstract void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException;

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendStanzaWithResponseCallback(Stanza stanza, StanzaFilter stanzaFilter, StanzaListener stanzaListener) throws SmackException.NotConnectedException {
        sendStanzaWithResponseCallback(stanza, stanzaFilter, stanzaListener, null);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void setFromMode(XMPPConnection.FromMode fromMode) {
        this.fromMode = fromMode;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void setPacketReplyTimeout(long j) {
        this.packetReplyTimeout = j;
    }

    public void setParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback) {
        this.parsingExceptionCallback = parsingExceptionCallback;
    }

    public void setReplyToUnknownIq(boolean z) {
        this.replyToUnkownIq = z;
    }

    public void setWasAuthenticated() {
        if (this.wasAuthenticated) {
            return;
        }
        this.wasAuthenticated = this.authenticated;
    }

    public abstract void shutdown();

    public void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected()) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    public void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated()) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    public void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        if (!isConnected()) {
            throw new SmackException.NotConnectedException();
        }
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public final IQRequestHandler unregisterIQRequestHandler(IQRequestHandler iQRequestHandler) {
        return unregisterIQRequestHandler(iQRequestHandler.getElement(), iQRequestHandler.getNamespace(), iQRequestHandler.getType());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendIqWithResponseCallback(IQ iq, StanzaListener stanzaListener, ExceptionCallback exceptionCallback) throws SmackException.NotConnectedException {
        sendIqWithResponseCallback(iq, stanzaListener, exceptionCallback, getPacketReplyTimeout());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendStanzaWithResponseCallback(Stanza stanza, StanzaFilter stanzaFilter, StanzaListener stanzaListener, ExceptionCallback exceptionCallback) throws SmackException.NotConnectedException {
        sendStanzaWithResponseCallback(stanza, stanzaFilter, stanzaListener, exceptionCallback, getPacketReplyTimeout());
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public PacketCollector createPacketCollector(PacketCollector.Configuration configuration) {
        PacketCollector packetCollector = new PacketCollector(this, configuration);
        this.collectors.add(packetCollector);
        return packetCollector;
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public PacketCollector createPacketCollectorAndSend(StanzaFilter stanzaFilter, Stanza stanza) throws SmackException.NotConnectedException {
        PacketCollector packetCollectorCreatePacketCollector = createPacketCollector(stanzaFilter);
        try {
            sendStanza(stanza);
            return packetCollectorCreatePacketCollector;
        } catch (RuntimeException | SmackException.NotConnectedException e) {
            packetCollectorCreatePacketCollector.cancel();
            throw e;
        }
    }

    public synchronized void disconnect(Presence presence) throws SmackException.NotConnectedException {
        sendStanza(presence);
        shutdown();
        callConnectionClosedListener();
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendIqWithResponseCallback(IQ iq, StanzaListener stanzaListener, ExceptionCallback exceptionCallback, long j) throws SmackException.NotConnectedException {
        sendStanzaWithResponseCallback(iq, new IQReplyFilter(iq, this), stanzaListener, exceptionCallback, j);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public void sendStanzaWithResponseCallback(Stanza stanza, final StanzaFilter stanzaFilter, final StanzaListener stanzaListener, final ExceptionCallback exceptionCallback, long j) throws SmackException.NotConnectedException {
        org.jivesoftware.smack.util.Objects.requireNonNull(stanza, "stanza must not be null");
        org.jivesoftware.smack.util.Objects.requireNonNull(stanzaFilter, "replyFilter must not be null");
        org.jivesoftware.smack.util.Objects.requireNonNull(stanzaListener, "callback must not be null");
        final StanzaListener stanzaListener2 = new StanzaListener() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza2) throws SmackException.NotConnectedException {
                try {
                    try {
                        XMPPException.XMPPErrorException.ifHasErrorThenThrow(stanza2);
                        stanzaListener.processPacket(stanza2);
                    } catch (XMPPException.XMPPErrorException e) {
                        ExceptionCallback exceptionCallback2 = exceptionCallback;
                        if (exceptionCallback2 != null) {
                            exceptionCallback2.processException(e);
                        }
                    }
                } finally {
                    AbstractXMPPConnection.this.removeAsyncStanzaListener(this);
                }
            }
        };
        this.removeCallbacksService.schedule(new Runnable() { // from class: org.jivesoftware.smack.AbstractXMPPConnection.6
            @Override // java.lang.Runnable
            public void run() {
                ExceptionCallback exceptionCallback2;
                if (!AbstractXMPPConnection.this.removeAsyncStanzaListener(stanzaListener2) || (exceptionCallback2 = exceptionCallback) == null) {
                    return;
                }
                exceptionCallback2.processException(SmackException.NoResponseException.newWith(AbstractXMPPConnection.this, stanzaFilter));
            }
        }, j, TimeUnit.MILLISECONDS);
        addAsyncStanzaListener(stanzaListener2, stanzaFilter);
        sendStanza(stanza);
    }

    @Override // org.jivesoftware.smack.XMPPConnection
    public IQRequestHandler unregisterIQRequestHandler(String str, String str2, IQ.Type type) {
        IQRequestHandler iQRequestHandlerRemove;
        IQRequestHandler iQRequestHandlerRemove2;
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        int i = AnonymousClass9.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type.ordinal()];
        if (i == 1) {
            synchronized (this.setIqRequestHandler) {
                iQRequestHandlerRemove = this.setIqRequestHandler.remove(strGenerateKey);
            }
            return iQRequestHandlerRemove;
        }
        if (i == 2) {
            synchronized (this.getIqRequestHandler) {
                iQRequestHandlerRemove2 = this.getIqRequestHandler.remove(strGenerateKey);
            }
            return iQRequestHandlerRemove2;
        }
        throw new IllegalArgumentException("Only IQ type of 'get' and 'set' allowed");
    }

    public synchronized void login(CharSequence charSequence, String str) throws SmackException, IOException, XMPPException {
        login(charSequence, str, this.config.getResource());
    }

    public synchronized void login(CharSequence charSequence, String str, String str2) throws SmackException, IOException, XMPPException {
        if (!this.config.allowNullOrEmptyUsername) {
            StringUtils.requireNotNullOrEmpty(charSequence, "Username must not be null or empty");
        }
        throwNotConnectedExceptionIfAppropriate();
        throwAlreadyLoggedInExceptionIfAppropriate();
        String string = charSequence != null ? charSequence.toString() : null;
        this.usedUsername = string;
        this.usedPassword = str;
        this.usedResource = str2;
        loginNonAnonymously(string, str, str2);
    }
}
