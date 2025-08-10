package org.jivesoftware.smackx.iqlast;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqlast.packet.LastActivity;

/* loaded from: classes5.dex */
public class LastActivityManager extends Manager {
    private boolean enabled;
    private volatile long lastMessageSent;
    private static final Map<XMPPConnection, LastActivityManager> instances = new WeakHashMap();
    private static boolean enabledPerDefault = true;

    /* renamed from: org.jivesoftware.smackx.iqlast.LastActivityManager$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode;

        static {
            int[] iArr = new int[Presence.Mode.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode = iArr;
            try {
                iArr[Presence.Mode.available.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Mode[Presence.Mode.chat.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.iqlast.LastActivityManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                LastActivityManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private LastActivityManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.enabled = false;
        xMPPConnection.addPacketSendingListener(new StanzaListener() { // from class: org.jivesoftware.smackx.iqlast.LastActivityManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Presence.Mode mode = ((Presence) stanza).getMode();
                if (mode == null) {
                    return;
                }
                int i = AnonymousClass5.$SwitchMap$org$jivesoftware$smack$packet$Presence$Mode[mode.ordinal()];
                if (i == 1 || i == 2) {
                    LastActivityManager.this.resetIdleTime();
                }
            }
        }, StanzaTypeFilter.PRESENCE);
        xMPPConnection.addPacketSendingListener(new StanzaListener() { // from class: org.jivesoftware.smackx.iqlast.LastActivityManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                if (((Message) stanza).getType() == Message.Type.error) {
                    return;
                }
                LastActivityManager.this.resetIdleTime();
            }
        }, StanzaTypeFilter.MESSAGE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", LastActivity.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iqlast.LastActivityManager.4
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (!LastActivityManager.this.enabled) {
                    return IQ.createErrorResponse(iq, new XMPPError(XMPPError.Condition.not_acceptable));
                }
                LastActivity lastActivity = new LastActivity();
                lastActivity.setType(IQ.Type.result);
                lastActivity.setTo(iq.getFrom());
                lastActivity.setFrom(iq.getTo());
                lastActivity.setStanzaId(iq.getStanzaId());
                lastActivity.setLastActivity(LastActivityManager.this.getIdleTime());
                return lastActivity;
            }
        });
        if (enabledPerDefault) {
            enable();
        }
        resetIdleTime();
        instances.put(xMPPConnection, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getIdleTime() {
        return (System.currentTimeMillis() - this.lastMessageSent) / 1000;
    }

    public static synchronized LastActivityManager getInstanceFor(XMPPConnection xMPPConnection) {
        LastActivityManager lastActivityManager;
        lastActivityManager = instances.get(xMPPConnection);
        if (lastActivityManager == null) {
            lastActivityManager = new LastActivityManager(xMPPConnection);
        }
        return lastActivityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetIdleTime() {
        this.lastMessageSent = System.currentTimeMillis();
    }

    public static void setEnabledPerDefault(boolean z) {
        enabledPerDefault = z;
    }

    public synchronized void disable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature(LastActivity.NAMESPACE);
        this.enabled = false;
    }

    public synchronized void enable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(LastActivity.NAMESPACE);
        this.enabled = true;
    }

    public LastActivity getLastActivity(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return (LastActivity) connection().createPacketCollectorAndSend(new LastActivity(str)).nextResultOrThrow();
    }

    public boolean isLastActivitySupported(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, LastActivity.NAMESPACE);
    }
}
