package org.jivesoftware.smackx.pep;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.pep.packet.PEPEvent;
import org.jivesoftware.smackx.pep.packet.PEPItem;
import org.jivesoftware.smackx.pep.packet.PEPPubSub;

/* loaded from: classes5.dex */
public class PEPManager {
    private XMPPConnection connection;
    private StanzaListener packetListener;
    private List<PEPListener> pepListeners = new ArrayList();
    private StanzaFilter packetFilter = new StanzaExtensionFilter("event", "http://jabber.org/protocol/pubsub#event");

    public PEPManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firePEPListeners(String str, PEPEvent pEPEvent) {
        int size;
        PEPListener[] pEPListenerArr;
        synchronized (this.pepListeners) {
            size = this.pepListeners.size();
            pEPListenerArr = new PEPListener[size];
            this.pepListeners.toArray(pEPListenerArr);
        }
        for (int i = 0; i < size; i++) {
            pEPListenerArr[i].eventReceived(str, pEPEvent);
        }
    }

    private void init() {
        StanzaListener stanzaListener = new StanzaListener() { // from class: org.jivesoftware.smackx.pep.PEPManager.1
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                Message message = (Message) stanza;
                PEPManager.this.firePEPListeners(message.getFrom(), (PEPEvent) message.getExtension("event", "http://jabber.org/protocol/pubsub#event"));
            }
        };
        this.packetListener = stanzaListener;
        this.connection.addSyncStanzaListener(stanzaListener, this.packetFilter);
    }

    public void addPEPListener(PEPListener pEPListener) {
        synchronized (this.pepListeners) {
            if (!this.pepListeners.contains(pEPListener)) {
                this.pepListeners.add(pEPListener);
            }
        }
    }

    public void destroy() {
        XMPPConnection xMPPConnection = this.connection;
        if (xMPPConnection != null) {
            xMPPConnection.removeSyncStanzaListener(this.packetListener);
        }
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public void publish(PEPItem pEPItem) throws SmackException.NotConnectedException {
        PEPPubSub pEPPubSub = new PEPPubSub(pEPItem);
        pEPPubSub.setType(IQ.Type.set);
        this.connection.sendStanza(pEPPubSub);
    }

    public void removePEPListener(PEPListener pEPListener) {
        synchronized (this.pepListeners) {
            this.pepListeners.remove(pEPListener);
        }
    }
}
