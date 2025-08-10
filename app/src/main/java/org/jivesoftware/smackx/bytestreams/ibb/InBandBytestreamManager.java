package org.jivesoftware.smackx.bytestreams.ibb;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
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
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;

/* loaded from: classes5.dex */
public class InBandBytestreamManager implements BytestreamManager {
    public static final int MAXIMUM_BLOCK_SIZE = 65535;
    private static final String SESSION_ID_PREFIX = "jibb_";
    private static final Map<XMPPConnection, InBandBytestreamManager> managers;
    private static final Random randomGenerator;
    private final CloseListener closeListener;
    private final XMPPConnection connection;
    private final DataListener dataListener;
    private final InitiationListener initiationListener;
    private final Map<String, BytestreamListener> userListeners = new ConcurrentHashMap();
    private final List<BytestreamListener> allRequestListeners = Collections.synchronizedList(new LinkedList());
    private final Map<String, InBandBytestreamSession> sessions = new ConcurrentHashMap();
    private int defaultBlockSize = 4096;
    private int maximumBlockSize = 65535;
    private StanzaType stanza = StanzaType.IQ;
    private List<String> ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());

    public enum StanzaType {
        IQ,
        MESSAGE
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(final XMPPConnection xMPPConnection) {
                InBandBytestreamManager.getByteStreamManager(xMPPConnection);
                xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.1.1
                    @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
                    public void connectionTerminated() {
                        InBandBytestreamManager.getByteStreamManager(xMPPConnection).disableService();
                    }

                    @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
                    public void reconnectionSuccessful() {
                        InBandBytestreamManager.getByteStreamManager(xMPPConnection);
                    }
                });
            }
        });
        randomGenerator = new Random();
        managers = new HashMap();
    }

    private InBandBytestreamManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        InitiationListener initiationListener = new InitiationListener(this);
        this.initiationListener = initiationListener;
        xMPPConnection.registerIQRequestHandler(initiationListener);
        DataListener dataListener = new DataListener(this);
        this.dataListener = dataListener;
        xMPPConnection.registerIQRequestHandler(dataListener);
        CloseListener closeListener = new CloseListener(this);
        this.closeListener = closeListener;
        xMPPConnection.registerIQRequestHandler(closeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableService() {
        managers.remove(this.connection);
        this.connection.unregisterIQRequestHandler(this.initiationListener);
        this.connection.unregisterIQRequestHandler(this.dataListener);
        this.connection.unregisterIQRequestHandler(this.closeListener);
        this.initiationListener.shutdown();
        this.userListeners.clear();
        this.allRequestListeners.clear();
        this.sessions.clear();
        this.ignoredBytestreamRequests.clear();
    }

    public static synchronized InBandBytestreamManager getByteStreamManager(XMPPConnection xMPPConnection) {
        if (xMPPConnection == null) {
            return null;
        }
        Map<XMPPConnection, InBandBytestreamManager> map = managers;
        InBandBytestreamManager inBandBytestreamManager = map.get(xMPPConnection);
        if (inBandBytestreamManager == null) {
            inBandBytestreamManager = new InBandBytestreamManager(xMPPConnection);
            map.put(xMPPConnection, inBandBytestreamManager);
        }
        return inBandBytestreamManager;
    }

    private String getNextSessionID() {
        return SESSION_ID_PREFIX + Math.abs(randomGenerator.nextLong());
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    public List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    public XMPPConnection getConnection() {
        return this.connection;
    }

    public int getDefaultBlockSize() {
        return this.defaultBlockSize;
    }

    public List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }

    public int getMaximumBlockSize() {
        return this.maximumBlockSize;
    }

    public Map<String, InBandBytestreamSession> getSessions() {
        return this.sessions;
    }

    public StanzaType getStanza() {
        return this.stanza;
    }

    public BytestreamListener getUserListener(String str) {
        return this.userListeners.get(str);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    public void replyItemNotFoundPacket(IQ iq) throws SmackException.NotConnectedException {
        this.connection.sendStanza(IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.item_not_found)));
    }

    public void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException {
        this.connection.sendStanza(IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.not_acceptable)));
    }

    public void replyResourceConstraintPacket(IQ iq) throws SmackException.NotConnectedException {
        this.connection.sendStanza(IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.resource_constraint)));
    }

    public void setDefaultBlockSize(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Default block size must be between 1 and 65535");
        }
        this.defaultBlockSize = i;
    }

    public void setMaximumBlockSize(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Maximum block size must be between 1 and 65535");
        }
        this.maximumBlockSize = i;
    }

    public void setStanza(StanzaType stanzaType) {
        this.stanza = stanzaType;
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
    public InBandBytestreamSession establishSession(String str) throws SmackException, XMPPException {
        return establishSession(str, getNextSessionID());
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public InBandBytestreamSession establishSession(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Open open = new Open(str2, this.defaultBlockSize, this.stanza);
        open.setTo(str);
        this.connection.createPacketCollectorAndSend(open).nextResultOrThrow();
        InBandBytestreamSession inBandBytestreamSession = new InBandBytestreamSession(this.connection, open, str);
        this.sessions.put(str2, inBandBytestreamSession);
        return inBandBytestreamSession;
    }
}
