package org.jivesoftware.smack.tcp;

import dc.xe3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.SynchronizationPoint;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.PlainStreamElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamOpen;
import org.jivesoftware.smack.sm.SMUtils;
import org.jivesoftware.smack.sm.StreamManagementException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.sm.predicates.Predicate;
import org.jivesoftware.smack.util.ArrayBlockingQueueWithShutdown;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.dns.HostAddress;
import org.jxmpp.util.XmppStringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class XMPPTCPConnection extends AbstractXMPPConnection {
    private static final int QUEUE_SIZE = 500;
    private static BundleAndDeferCallback defaultBundleAndDeferCallback;
    private BundleAndDeferCallback bundleAndDeferCallback;
    private long clientHandledStanzasCount;
    private final SynchronizationPoint<XMPPException> compressSyncPoint;
    private final XMPPTCPConnectionConfiguration config;
    private boolean disconnectedButResumeable;
    private final SynchronizationPoint<Exception> initalOpenStreamSend;
    private final SynchronizationPoint<XMPPException> maybeCompressFeaturesReceived;
    public PacketReader packetReader;
    public PacketWriter packetWriter;
    private final Set<StanzaFilter> requestAckPredicates;
    private long serverHandledStanzasCount;
    private int smClientMaxResumptionTime;
    private final SynchronizationPoint<XMPPException> smEnabledSyncPoint;
    private final SynchronizationPoint<XMPPException> smResumedSyncPoint;
    private int smServerMaxResumptimTime;
    private String smSessionId;
    private boolean smWasEnabledAtLeastOnce;
    private Socket socket;
    private volatile boolean socketClosed;
    private final Collection<StanzaListener> stanzaAcknowledgedListeners;
    private final Map<String, StanzaListener> stanzaIdAcknowledgedListeners;
    private BlockingQueue<Stanza> unacknowledgedStanzas;
    private boolean useSm;
    private boolean useSmResumption;
    private boolean usingTLS;
    private static final Logger LOGGER = Logger.getLogger(XMPPTCPConnection.class.getName());
    private static boolean useSmDefault = false;
    private static boolean useSmResumptionDefault = true;

    public class PacketReader {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean done;
        public XmlPullParser parser;

        public PacketReader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:121:0x02f2  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02f5  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x031e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void parsePackets() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 1102
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketReader.parsePackets():void");
        }

        public void init() {
            this.done = false;
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketReader.1
                @Override // java.lang.Runnable
                public void run() throws Exception {
                    PacketReader.this.parsePackets();
                }
            }, "Smack Packet Reader (" + XMPPTCPConnection.this.getConnectionCounter() + ")");
        }

        public void shutdown() {
            this.done = true;
        }
    }

    public class PacketWriter {
        public static final int QUEUE_SIZE = 500;
        private volatile boolean instantShutdown;
        private boolean shouldBundleAndDefer;
        public SynchronizationPoint<SmackException.NoResponseException> shutdownDone;
        private final ArrayBlockingQueueWithShutdown<Element> queue = new ArrayBlockingQueueWithShutdown<>(500, true);
        public volatile Long shutdownTimestamp = null;

        public PacketWriter() {
            this.shutdownDone = new SynchronizationPoint<>(XMPPTCPConnection.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean done() {
            return this.shutdownTimestamp != null;
        }

        private void drainWriterQueueToUnacknowledgedStanzas() {
            ArrayList<Element> arrayList = new ArrayList(this.queue.size());
            this.queue.drainTo(arrayList);
            for (Element element : arrayList) {
                if (element instanceof Stanza) {
                    XMPPTCPConnection.this.unacknowledgedStanzas.add((Stanza) element);
                }
            }
        }

        private Element nextStreamElement() {
            if (this.queue.isEmpty()) {
                this.shouldBundleAndDefer = true;
            }
            try {
                return this.queue.take();
            } catch (InterruptedException e) {
                if (this.queue.isShutdown()) {
                    return null;
                }
                XMPPTCPConnection.LOGGER.log(Level.WARNING, "Packet writer thread was interrupted. Don't do that. Use disconnect() instead.", (Throwable) e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writePackets() {
            try {
                try {
                    XMPPTCPConnection.this.openStream();
                    XMPPTCPConnection.this.initalOpenStreamSend.reportSuccess();
                    while (!done()) {
                        Element elementNextStreamElement = nextStreamElement();
                        if (elementNextStreamElement != null) {
                            BundleAndDeferCallback bundleAndDeferCallback = XMPPTCPConnection.this.bundleAndDeferCallback;
                            if (bundleAndDeferCallback != null && XMPPTCPConnection.this.isAuthenticated() && this.shouldBundleAndDefer) {
                                this.shouldBundleAndDefer = false;
                                AtomicBoolean atomicBoolean = new AtomicBoolean();
                                int bundleAndDeferMillis = bundleAndDeferCallback.getBundleAndDeferMillis(new BundleAndDefer(atomicBoolean));
                                if (bundleAndDeferMillis > 0) {
                                    long j = bundleAndDeferMillis;
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    synchronized (atomicBoolean) {
                                        for (long jCurrentTimeMillis2 = j; !atomicBoolean.get() && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j - (System.currentTimeMillis() - jCurrentTimeMillis)) {
                                            atomicBoolean.wait(jCurrentTimeMillis2);
                                        }
                                    }
                                }
                            }
                            Stanza stanza = null;
                            if (elementNextStreamElement instanceof Stanza) {
                                stanza = (Stanza) elementNextStreamElement;
                            } else if (elementNextStreamElement instanceof StreamManagement.Enable) {
                                XMPPTCPConnection.this.unacknowledgedStanzas = new ArrayBlockingQueue(500);
                            }
                            if (XMPPTCPConnection.this.unacknowledgedStanzas != null && stanza != null) {
                                if (XMPPTCPConnection.this.unacknowledgedStanzas.size() == 400.0d) {
                                    XMPPTCPConnection.this.writer.write(StreamManagement.AckRequest.INSTANCE.toXML().toString());
                                    XMPPTCPConnection.this.writer.flush();
                                }
                                try {
                                    XMPPTCPConnection.this.unacknowledgedStanzas.put(stanza);
                                } catch (InterruptedException e) {
                                    throw new IllegalStateException(e);
                                }
                            }
                            XMPPTCPConnection.this.writer.write(elementNextStreamElement.toXML().toString());
                            if (this.queue.isEmpty()) {
                                XMPPTCPConnection.this.writer.flush();
                            }
                            if (stanza != null) {
                                XMPPTCPConnection.this.firePacketSendingListeners(stanza);
                            }
                        }
                    }
                    if (!this.instantShutdown) {
                        while (!this.queue.isEmpty()) {
                            try {
                                XMPPTCPConnection.this.writer.write(this.queue.remove().toXML().toString());
                            } catch (Exception e2) {
                                XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception flushing queue during shutdown, ignore and continue", (Throwable) e2);
                            }
                        }
                        XMPPTCPConnection.this.writer.flush();
                        try {
                            XMPPTCPConnection.this.writer.write("</stream:stream>");
                            XMPPTCPConnection.this.writer.flush();
                        } catch (Exception e3) {
                            XMPPTCPConnection.LOGGER.log(Level.WARNING, "Exception writing closing stream element", (Throwable) e3);
                        }
                        this.queue.clear();
                    } else if (this.instantShutdown && XMPPTCPConnection.this.isSmEnabled()) {
                        drainWriterQueueToUnacknowledgedStanzas();
                    }
                    try {
                        XMPPTCPConnection.this.writer.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e4) {
                    if (done() || XMPPTCPConnection.this.isSocketClosed()) {
                        XMPPTCPConnection.LOGGER.log(Level.FINE, "Ignoring Exception in writePackets()", (Throwable) e4);
                    } else {
                        XMPPTCPConnection.this.notifyConnectionError(e4);
                    }
                }
            } finally {
                XMPPTCPConnection.LOGGER.fine("Reporting shutdownDone success in writer thread");
                this.shutdownDone.reportSuccess();
            }
        }

        public void init() {
            this.shutdownDone.init();
            this.shutdownTimestamp = null;
            if (XMPPTCPConnection.this.unacknowledgedStanzas != null) {
                drainWriterQueueToUnacknowledgedStanzas();
            }
            this.queue.start();
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    PacketWriter.this.writePackets();
                }
            }, "Smack Packet Writer (" + XMPPTCPConnection.this.getConnectionCounter() + ")");
        }

        public void sendStreamElement(Element element) throws SmackException.NotConnectedException {
            throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
            boolean z = false;
            while (!z) {
                try {
                    this.queue.put(element);
                    z = true;
                } catch (InterruptedException e) {
                    throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
                    XMPPTCPConnection.LOGGER.log(Level.WARNING, "Sending thread was interrupted", (Throwable) e);
                }
            }
        }

        public void shutdown(boolean z) {
            this.instantShutdown = z;
            this.shutdownTimestamp = Long.valueOf(System.currentTimeMillis());
            this.queue.shutdown();
            try {
                this.shutdownDone.checkIfSuccessOrWait();
            } catch (SmackException.NoResponseException e) {
                XMPPTCPConnection.LOGGER.log(Level.WARNING, "shutdownDone was not marked as successful by the writer thread", (Throwable) e);
            }
        }

        public void throwNotConnectedExceptionIfDoneAndResumptionNotPossible() throws SmackException.NotConnectedException {
            if (done() && !XMPPTCPConnection.this.isSmResumptionPossible()) {
                throw new SmackException.NotConnectedException();
            }
        }
    }

    public XMPPTCPConnection(XMPPTCPConnectionConfiguration xMPPTCPConnectionConfiguration) {
        super(xMPPTCPConnectionConfiguration);
        this.disconnectedButResumeable = false;
        this.socketClosed = false;
        this.usingTLS = false;
        this.initalOpenStreamSend = new SynchronizationPoint<>(this);
        this.maybeCompressFeaturesReceived = new SynchronizationPoint<>(this);
        this.compressSyncPoint = new SynchronizationPoint<>(this);
        this.bundleAndDeferCallback = defaultBundleAndDeferCallback;
        this.smResumedSyncPoint = new SynchronizationPoint<>(this);
        this.smEnabledSyncPoint = new SynchronizationPoint<>(this);
        this.smClientMaxResumptionTime = -1;
        this.smServerMaxResumptimTime = -1;
        this.useSm = useSmDefault;
        this.useSmResumption = useSmResumptionDefault;
        this.serverHandledStanzasCount = 0L;
        this.clientHandledStanzasCount = 0L;
        this.smWasEnabledAtLeastOnce = false;
        this.stanzaAcknowledgedListeners = new ConcurrentLinkedQueue();
        this.stanzaIdAcknowledgedListeners = new ConcurrentHashMap();
        this.requestAckPredicates = new LinkedHashSet();
        this.config = xMPPTCPConnectionConfiguration;
    }

    private void connectUsingConfiguration() throws Exception {
        Iterator it;
        List<HostAddress> listPopulateHostAddresses = populateHostAddresses();
        SocketFactory socketFactory = this.config.getSocketFactory();
        if (socketFactory == null) {
            socketFactory = SocketFactory.getDefault();
        }
        for (HostAddress hostAddress : this.hostAddresses) {
            String fqdn = hostAddress.getFQDN();
            int port = hostAddress.getPort();
            this.socket = socketFactory.createSocket();
            try {
                xe3.a("Message", "socket：" + this.socket);
                it = Arrays.asList(InetAddress.getAllByName(fqdn)).iterator();
            } catch (Exception e) {
                hostAddress.setException(e);
                listPopulateHostAddresses.add(hostAddress);
            }
            if (!it.hasNext()) {
                LOGGER.warning("InetAddress.getAllByName() returned empty result array.");
                throw new UnknownHostException(fqdn);
            }
            while (it.hasNext()) {
                InetAddress inetAddress = (InetAddress) it.next();
                String str = inetAddress + " chat_notification_at port " + port;
                Logger logger = LOGGER;
                logger.finer("Trying to establish TCP connection to " + str);
                try {
                    xe3.a("Message", "socket：" + inetAddress + SignatureImpl.INNER_SEP + port);
                    this.socket.connect(new InetSocketAddress(inetAddress, port), this.config.getConnectTimeout());
                    logger.finer("Established TCP connection to " + str);
                    this.host = fqdn;
                    this.port = port;
                    return;
                } catch (Exception e2) {
                    xe3.a("Message", "socket：" + e2.getMessage());
                    if (!it.hasNext()) {
                        throw e2;
                    }
                }
            }
        }
        throw SmackException.ConnectionException.from(listPopulateHostAddresses);
    }

    private void initConnection() throws IOException {
        boolean z = this.packetReader == null || this.packetWriter == null;
        this.compressionHandler = null;
        initReaderAndWriter();
        if (z) {
            this.packetWriter = new PacketWriter();
            this.packetReader = new PacketReader();
            if (this.config.isDebuggerEnabled()) {
                addAsyncStanzaListener(this.debugger.getReaderListener(), null);
                if (this.debugger.getWriterListener() != null) {
                    addPacketSendingListener(this.debugger.getWriterListener(), null);
                }
            }
        }
        this.packetWriter.init();
        this.packetReader.init();
        if (z) {
            Iterator<ConnectionCreationListener> it = AbstractXMPPConnection.getConnectionCreationListeners().iterator();
            while (it.hasNext()) {
                it.next().connectionCreated(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReaderAndWriter() throws IOException {
        InputStream inputStream = this.socket.getInputStream();
        OutputStream outputStream = this.socket.getOutputStream();
        XMPPInputOutputStream xMPPInputOutputStream = this.compressionHandler;
        if (xMPPInputOutputStream != null) {
            inputStream = xMPPInputOutputStream.getInputStream(inputStream);
            outputStream = this.compressionHandler.getOutputStream(outputStream);
        }
        this.writer = new OutputStreamWriter(outputStream, "UTF-8");
        this.reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        initDebugger();
    }

    private XMPPInputOutputStream maybeGetCompressionHandler() {
        Compress.Feature feature = (Compress.Feature) getFeature(Compress.Feature.ELEMENT, "http://jabber.org/protocol/compress");
        if (feature == null) {
            return null;
        }
        for (XMPPInputOutputStream xMPPInputOutputStream : SmackConfiguration.getCompresionHandlers()) {
            if (feature.getMethods().contains(xMPPInputOutputStream.getCompressionMethod())) {
                return xMPPInputOutputStream;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyConnectionError(Exception exc) {
        PacketWriter packetWriter;
        PacketReader packetReader = this.packetReader;
        if ((packetReader != null && !packetReader.done) || ((packetWriter = this.packetWriter) != null && !packetWriter.done())) {
            instantShutdown();
            callConnectionClosedOnErrorListener(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e3 A[Catch: NullPointerException -> 0x00f6, TRY_ENTER, TryCatch #0 {NullPointerException -> 0x00f6, blocks: (B:20:0x00e3, B:22:0x00f1, B:21:0x00e7), top: B:39:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e7 A[Catch: NullPointerException -> 0x00f6, TryCatch #0 {NullPointerException -> 0x00f6, blocks: (B:20:0x00e3, B:22:0x00f1, B:21:0x00e7), top: B:39:0x00e1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void proceedTLSReceived() throws org.jivesoftware.smack.SmackException, java.lang.NoSuchMethodException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException, javax.security.auth.callback.UnsupportedCallbackException, java.io.IOException, java.lang.SecurityException, java.security.KeyStoreException, java.security.KeyManagementException, java.security.cert.CertificateException, java.security.NoSuchProviderException {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.XMPPTCPConnection.proceedTLSReceived():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHandledCount(long j) throws SmackException.NotConnectedException, StreamManagementException.StreamManagementCounterError {
        long jCalculateDelta = SMUtils.calculateDelta(j, this.serverHandledStanzasCount);
        final ArrayList arrayList = new ArrayList(j <= 2147483647L ? (int) j : Integer.MAX_VALUE);
        for (long j2 = 0; j2 < jCalculateDelta; j2++) {
            Stanza stanzaPoll = this.unacknowledgedStanzas.poll();
            if (stanzaPoll == null) {
                throw new StreamManagementException.StreamManagementCounterError(j, this.serverHandledStanzasCount, jCalculateDelta, arrayList);
            }
            arrayList.add(stanzaPoll);
        }
        boolean z = false;
        if (!this.stanzaAcknowledgedListeners.isEmpty()) {
            z = true;
            break;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String stanzaId = ((Stanza) it.next()).getStanzaId();
            if (stanzaId != null && this.stanzaIdAcknowledgedListeners.containsKey(stanzaId)) {
                z = true;
                break;
            }
        }
        if (z) {
            asyncGo(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.2
                @Override // java.lang.Runnable
                public void run() {
                    StanzaListener stanzaListener;
                    for (Stanza stanza : arrayList) {
                        Iterator it2 = XMPPTCPConnection.this.stanzaAcknowledgedListeners.iterator();
                        while (it2.hasNext()) {
                            try {
                                ((StanzaListener) it2.next()).processPacket(stanza);
                            } catch (SmackException.NotConnectedException e) {
                                XMPPTCPConnection.LOGGER.log(Level.FINER, "Received not connected exception", (Throwable) e);
                            }
                        }
                        String stanzaId2 = stanza.getStanzaId();
                        if (!StringUtils.isNullOrEmpty(stanzaId2) && (stanzaListener = (StanzaListener) XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(stanzaId2)) != null) {
                            try {
                                stanzaListener.processPacket(stanza);
                            } catch (SmackException.NotConnectedException e2) {
                                XMPPTCPConnection.LOGGER.log(Level.FINER, "Received not connected exception", (Throwable) e2);
                            }
                        }
                    }
                }
            });
        }
        this.serverHandledStanzasCount = j;
    }

    private void requestSmAcknowledgementInternal() throws SmackException.NotConnectedException {
        this.packetWriter.sendStreamElement(StreamManagement.AckRequest.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSmAcknowledgementInternal() throws SmackException.NotConnectedException {
        this.packetWriter.sendStreamElement(new StreamManagement.AckAnswer(this.clientHandledStanzasCount));
    }

    public static void setDefaultBundleAndDeferCallback(BundleAndDeferCallback bundleAndDeferCallback) {
        defaultBundleAndDeferCallback = bundleAndDeferCallback;
    }

    public static void setUseStreamManagementDefault(boolean z) {
        useSmDefault = z;
    }

    public static void setUseStreamManagementResumptiodDefault(boolean z) {
        if (z) {
            setUseStreamManagementDefault(z);
        }
        useSmResumptionDefault = z;
    }

    private void useCompression() throws Exception {
        this.maybeCompressFeaturesReceived.checkIfSuccessOrWait();
        XMPPInputOutputStream xMPPInputOutputStreamMaybeGetCompressionHandler = maybeGetCompressionHandler();
        this.compressionHandler = xMPPInputOutputStreamMaybeGetCompressionHandler;
        if (xMPPInputOutputStreamMaybeGetCompressionHandler != null) {
            this.compressSyncPoint.sendAndWaitForResponseOrThrow(new Compress(xMPPInputOutputStreamMaybeGetCompressionHandler.getCompressionMethod()));
        } else {
            LOGGER.warning("Could not enable compression because no matching handler/method pair was found");
        }
    }

    public boolean addRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean zAdd;
        synchronized (this.requestAckPredicates) {
            zAdd = this.requestAckPredicates.add(stanzaFilter);
        }
        return zAdd;
    }

    public void addStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        this.stanzaAcknowledgedListeners.add(stanzaListener);
    }

    public StanzaListener addStanzaIdAcknowledgedListener(final String str, StanzaListener stanzaListener) throws StreamManagementException.StreamManagementNotEnabledException {
        if (!this.smWasEnabledAtLeastOnce) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        schedule(new Runnable() { // from class: org.jivesoftware.smack.tcp.XMPPTCPConnection.1
            @Override // java.lang.Runnable
            public void run() {
                XMPPTCPConnection.this.stanzaIdAcknowledgedListeners.remove(str);
            }
        }, Math.min(getMaxSmResumptionTime(), 43200), TimeUnit.SECONDS);
        return this.stanzaIdAcknowledgedListeners.put(str, stanzaListener);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void afterFeaturesReceived() throws SmackException.NotConnectedException, SmackException.SecurityRequiredException {
        StartTls startTls = (StartTls) getFeature(StartTls.ELEMENT, StartTls.NAMESPACE);
        if (startTls != null) {
            if (startTls.required() && this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled) {
                notifyConnectionError(new SmackException.SecurityRequiredByServerException());
                return;
            } else if (this.config.getSecurityMode() == ConnectionConfiguration.SecurityMode.disabled) {
                return;
            } else {
                send(new StartTls());
            }
        }
        if (!isSecureConnection() && startTls == null && getConfiguration().getSecurityMode() == ConnectionConfiguration.SecurityMode.required) {
            throw new SmackException.SecurityRequiredByClientException();
        }
        if (getSASLAuthentication().authenticationSuccessful()) {
            this.maybeCompressFeaturesReceived.reportSuccess();
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void afterSuccessfulLogin(boolean z) throws SmackException.NotConnectedException {
        this.disconnectedButResumeable = false;
        super.afterSuccessfulLogin(z);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void connectInternal() throws Exception {
        connectUsingConfiguration();
        this.socketClosed = false;
        initConnection();
        this.saslFeatureReceived.checkIfSuccessOrWaitOrThrow();
        this.connected = true;
        callConnectionConnectedListener();
        if (this.wasAuthenticated) {
            login();
            notifyReconnection();
        }
    }

    public int getMaxSmResumptionTime() {
        int i = this.smClientMaxResumptionTime;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        int i2 = this.smServerMaxResumptimTime;
        return Math.min(i, i2 > 0 ? i2 : Integer.MAX_VALUE);
    }

    public synchronized void instantShutdown() {
        shutdown(true);
    }

    public boolean isDisconnectedButSmResumptionPossible() {
        return this.disconnectedButResumeable && isSmResumptionPossible();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isSecureConnection() {
        return this.usingTLS;
    }

    public boolean isSmAvailable() {
        return hasFeature(StreamManagement.StreamManagementFeature.ELEMENT, StreamManagement.NAMESPACE);
    }

    public boolean isSmEnabled() {
        return this.smEnabledSyncPoint.wasSuccessful();
    }

    public boolean isSmResumptionPossible() {
        if (this.smSessionId == null) {
            return false;
        }
        Long l = this.packetWriter.shutdownTimestamp;
        if (l == null) {
            return true;
        }
        return System.currentTimeMillis() <= l.longValue() + (((long) getMaxSmResumptionTime()) * 1000);
    }

    public boolean isSocketClosed() {
        return this.socketClosed;
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public boolean isUsingCompression() {
        return this.compressionHandler != null && this.compressSyncPoint.wasSuccessful();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public synchronized void loginAnonymously() throws SmackException, IOException, XMPPException {
        this.saslFeatureReceived.checkIfSuccessOrWaitOrThrow();
        if (!this.saslAuthentication.hasAnonymousAuthentication()) {
            throw new SmackException("No anonymous SASL authentication mechanism status_available");
        }
        this.saslAuthentication.authenticateAnonymously();
        if (this.config.isCompressionEnabled()) {
            useCompression();
        }
        bindResourceAndEstablishSession(null);
        afterSuccessfulLogin(false);
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public synchronized void loginNonAnonymously(String str, String str2, String str3) throws SmackException, IOException, XMPPException {
        if (!this.saslAuthentication.hasNonAnonymousAuthentication()) {
            throw new SmackException("No non-anonymous SASL authentication mechanism status_available");
        }
        if (str2 != null) {
            this.saslAuthentication.authenticate(str, str2, str3);
        } else {
            this.saslAuthentication.authenticate(str3, this.config.getCallbackHandler());
        }
        if (this.config.isCompressionEnabled()) {
            useCompression();
        }
        if (isSmResumptionPossible()) {
            this.smResumedSyncPoint.sendAndWaitForResponse(new StreamManagement.Resume(this.clientHandledStanzasCount, this.smSessionId));
            if (this.smResumedSyncPoint.wasSuccessful()) {
                afterSuccessfulLogin(true);
                return;
            }
            LOGGER.fine("Stream resumption failed, continuing with normal stream establishment process");
        }
        bindResourceAndEstablishSession(str3);
        LinkedList linkedList = new LinkedList();
        BlockingQueue<Stanza> blockingQueue = this.unacknowledgedStanzas;
        if (blockingQueue != null) {
            blockingQueue.drainTo(linkedList);
            this.unacknowledgedStanzas = null;
        }
        if (isSmAvailable() && this.useSm) {
            this.serverHandledStanzasCount = 0L;
            this.smEnabledSyncPoint.sendAndWaitForResponseOrThrow(new StreamManagement.Enable(this.useSmResumption, this.smClientMaxResumptionTime));
            synchronized (this.requestAckPredicates) {
                if (this.requestAckPredicates.isEmpty()) {
                    this.requestAckPredicates.add(Predicate.forMessagesOrAfter5Stanzas());
                }
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sendStanzaInternal((Stanza) it.next());
        }
        afterSuccessfulLogin(false);
    }

    public void openStream() throws SmackException {
        String serviceName = getServiceName();
        CharSequence username = this.config.getUsername();
        send(new StreamOpen(serviceName, username != null ? XmppStringUtils.completeJidFrom(username, serviceName) : null, getStreamId()));
        try {
            this.packetReader.parser = PacketParserUtils.newXmppParser(this.reader);
        } catch (XmlPullParserException e) {
            throw new SmackException(e);
        }
    }

    public void removeAllRequestAckPredicates() {
        synchronized (this.requestAckPredicates) {
            this.requestAckPredicates.clear();
        }
    }

    public void removeAllStanzaAcknowledgedListeners() {
        this.stanzaAcknowledgedListeners.clear();
    }

    public void removeAllStanzaIdAcknowledgedListeners() {
        this.stanzaIdAcknowledgedListeners.clear();
    }

    public boolean removeRequestAckPredicate(StanzaFilter stanzaFilter) {
        boolean zRemove;
        synchronized (this.requestAckPredicates) {
            zRemove = this.requestAckPredicates.remove(stanzaFilter);
        }
        return zRemove;
    }

    public boolean removeStanzaAcknowledgedListener(StanzaListener stanzaListener) {
        return this.stanzaAcknowledgedListeners.remove(stanzaListener);
    }

    public StanzaListener removeStanzaIdAcknowledgedListener(String str) {
        return this.stanzaIdAcknowledgedListeners.remove(str);
    }

    public void requestSmAcknowledgement() throws SmackException.NotConnectedException, StreamManagementException.StreamManagementNotEnabledException {
        if (!isSmEnabled()) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        requestSmAcknowledgementInternal();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection, org.jivesoftware.smack.XMPPConnection
    public void send(PlainStreamElement plainStreamElement) throws SmackException.NotConnectedException {
        this.packetWriter.sendStreamElement(plainStreamElement);
    }

    public void sendSmAcknowledgement() throws SmackException.NotConnectedException, StreamManagementException.StreamManagementNotEnabledException {
        if (!isSmEnabled()) {
            throw new StreamManagementException.StreamManagementNotEnabledException();
        }
        sendSmAcknowledgementInternal();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void sendStanzaInternal(Stanza stanza) throws SmackException.NotConnectedException {
        this.packetWriter.sendStreamElement(stanza);
        if (isSmEnabled()) {
            Iterator<StanzaFilter> it = this.requestAckPredicates.iterator();
            while (it.hasNext()) {
                if (it.next().accept(stanza)) {
                    requestSmAcknowledgementInternal();
                    return;
                }
            }
        }
    }

    public void setBundleandDeferCallback(BundleAndDeferCallback bundleAndDeferCallback) {
        this.bundleAndDeferCallback = bundleAndDeferCallback;
    }

    public void setPreferredResumptionTime(int i) {
        this.smClientMaxResumptionTime = i;
    }

    public void setUseStreamManagement(boolean z) {
        this.useSm = z;
    }

    public void setUseStreamManagementResumption(boolean z) {
        if (z) {
            setUseStreamManagement(z);
        }
        this.useSmResumption = z;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void shutdown() throws IOException {
        if (isSmEnabled()) {
            try {
                sendSmAcknowledgementInternal();
            } catch (SmackException.NotConnectedException e) {
                LOGGER.log(Level.FINE, "Can not send final SM ack as connection is not connected", (Throwable) e);
            }
        }
        shutdown(false);
    }

    public boolean streamWasResumed() {
        return this.smResumedSyncPoint.wasSuccessful();
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void throwAlreadyConnectedExceptionIfAppropriate() throws SmackException.AlreadyConnectedException {
        if (isConnected() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyConnectedException();
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void throwAlreadyLoggedInExceptionIfAppropriate() throws SmackException.AlreadyLoggedInException {
        if (isAuthenticated() && !this.disconnectedButResumeable) {
            throw new SmackException.AlreadyLoggedInException();
        }
    }

    @Override // org.jivesoftware.smack.AbstractXMPPConnection
    public void throwNotConnectedExceptionIfAppropriate() throws SmackException.NotConnectedException {
        PacketWriter packetWriter = this.packetWriter;
        if (packetWriter == null) {
            throw new SmackException.NotConnectedException();
        }
        packetWriter.throwNotConnectedExceptionIfDoneAndResumptionNotPossible();
    }

    private void shutdown(boolean z) throws IOException {
        if (this.disconnectedButResumeable) {
            return;
        }
        PacketReader packetReader = this.packetReader;
        if (packetReader != null) {
            packetReader.shutdown();
        }
        PacketWriter packetWriter = this.packetWriter;
        if (packetWriter != null) {
            packetWriter.shutdown(z);
        }
        this.socketClosed = true;
        try {
            this.socket.close();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "shutdown", (Throwable) e);
        }
        setWasAuthenticated();
        if (isSmResumptionPossible() && z) {
            this.disconnectedButResumeable = true;
        } else {
            this.disconnectedButResumeable = false;
            this.smSessionId = null;
        }
        this.authenticated = false;
        this.connected = false;
        this.usingTLS = false;
        this.reader = null;
        this.writer = null;
        this.maybeCompressFeaturesReceived.init();
        this.compressSyncPoint.init();
        this.smResumedSyncPoint.init();
        this.smEnabledSyncPoint.init();
        this.initalOpenStreamSend.init();
    }

    public XMPPTCPConnection(CharSequence charSequence, String str) {
        this(XmppStringUtils.parseLocalpart(charSequence.toString()), str, XmppStringUtils.parseDomain(charSequence.toString()));
    }

    public XMPPTCPConnection(CharSequence charSequence, String str, String str2) {
        this(XMPPTCPConnectionConfiguration.builder().setUsernameAndPassword(charSequence, str).setServiceName(str2).build());
    }
}
