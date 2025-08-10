package org.jivesoftware.smackx.bytestreams.ibb;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.filetransfer.StreamNegotiator;

/* loaded from: classes5.dex */
public class InitiationListener extends AbstractIqRequestHandler {
    private static final Logger LOGGER = Logger.getLogger(InitiationListener.class.getName());
    private final ExecutorService initiationListenerExecutor;
    private final InBandBytestreamManager manager;

    public InitiationListener(InBandBytestreamManager inBandBytestreamManager) {
        super("open", "http://jabber.org/protocol/ibb", IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = inBandBytestreamManager;
        this.initiationListenerExecutor = Executors.newCachedThreadPool();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRequest(Stanza stanza) throws SmackException.NotConnectedException {
        Open open = (Open) stanza;
        if (open.getBlockSize() > this.manager.getMaximumBlockSize()) {
            this.manager.replyResourceConstraintPacket(open);
            return;
        }
        StreamNegotiator.signal(open.getFrom() + '\t' + open.getSessionID(), open);
        if (this.manager.getIgnoredBytestreamRequests().remove(open.getSessionID())) {
            return;
        }
        InBandBytestreamRequest inBandBytestreamRequest = new InBandBytestreamRequest(this.manager, open);
        BytestreamListener userListener = this.manager.getUserListener(open.getFrom());
        if (userListener != null) {
            userListener.incomingBytestreamRequest(inBandBytestreamRequest);
        } else {
            if (this.manager.getAllRequestListeners().isEmpty()) {
                this.manager.replyRejectPacket(open);
                return;
            }
            Iterator<BytestreamListener> it = this.manager.getAllRequestListeners().iterator();
            while (it.hasNext()) {
                it.next().incomingBytestreamRequest(inBandBytestreamRequest);
            }
        }
    }

    @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQ handleIQRequest(final IQ iq) {
        this.initiationListenerExecutor.execute(new Runnable() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InitiationListener.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InitiationListener.this.processRequest(iq);
                } catch (SmackException.NotConnectedException e) {
                    InitiationListener.LOGGER.log(Level.WARNING, "proccessRequest", (Throwable) e);
                }
            }
        });
        return null;
    }

    public void shutdown() {
        this.initiationListenerExecutor.shutdownNow();
    }
}
