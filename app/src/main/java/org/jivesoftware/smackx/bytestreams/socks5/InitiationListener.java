package org.jivesoftware.smackx.bytestreams.socks5;

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
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.filetransfer.StreamNegotiator;

/* loaded from: classes5.dex */
public final class InitiationListener extends AbstractIqRequestHandler {
    private static final Logger LOGGER = Logger.getLogger(InitiationListener.class.getName());
    private final ExecutorService initiationListenerExecutor;
    private final Socks5BytestreamManager manager;

    public InitiationListener(Socks5BytestreamManager socks5BytestreamManager) {
        super("query", Bytestream.NAMESPACE, IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = socks5BytestreamManager;
        this.initiationListenerExecutor = Executors.newCachedThreadPool();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRequest(Stanza stanza) throws SmackException.NotConnectedException {
        Bytestream bytestream = (Bytestream) stanza;
        StreamNegotiator.signal(bytestream.getFrom() + '\t' + bytestream.getSessionID(), bytestream);
        if (this.manager.getIgnoredBytestreamRequests().remove(bytestream.getSessionID())) {
            return;
        }
        Socks5BytestreamRequest socks5BytestreamRequest = new Socks5BytestreamRequest(this.manager, bytestream);
        BytestreamListener userListener = this.manager.getUserListener(bytestream.getFrom());
        if (userListener != null) {
            userListener.incomingBytestreamRequest(socks5BytestreamRequest);
        } else {
            if (this.manager.getAllRequestListeners().isEmpty()) {
                this.manager.replyRejectPacket(bytestream);
                return;
            }
            Iterator<BytestreamListener> it = this.manager.getAllRequestListeners().iterator();
            while (it.hasNext()) {
                it.next().incomingBytestreamRequest(socks5BytestreamRequest);
            }
        }
    }

    @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQ handleIQRequest(final IQ iq) {
        this.initiationListenerExecutor.execute(new Runnable() { // from class: org.jivesoftware.smackx.bytestreams.socks5.InitiationListener.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InitiationListener.this.processRequest(iq);
                } catch (SmackException.NotConnectedException e) {
                    InitiationListener.LOGGER.log(Level.WARNING, "process request", (Throwable) e);
                }
            }
        });
        return null;
    }

    public void shutdown() {
        this.initiationListenerExecutor.shutdownNow();
    }
}
