package org.jivesoftware.smackx.bytestreams.ibb;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes5.dex */
public class CloseListener extends AbstractIqRequestHandler {
    private final InBandBytestreamManager manager;

    public CloseListener(InBandBytestreamManager inBandBytestreamManager) {
        super(Close.ELEMENT, "http://jabber.org/protocol/ibb", IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = inBandBytestreamManager;
    }

    @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQ handleIQRequest(IQ iq) {
        Close close = (Close) iq;
        InBandBytestreamSession inBandBytestreamSession = this.manager.getSessions().get(close.getSessionID());
        if (inBandBytestreamSession == null) {
            try {
                this.manager.replyItemNotFoundPacket(close);
            } catch (SmackException.NotConnectedException unused) {
                return null;
            }
        } else {
            try {
                inBandBytestreamSession.closeByPeer(close);
                this.manager.getSessions().remove(close.getSessionID());
            } catch (SmackException.NotConnectedException unused2) {
            }
        }
        return null;
    }
}
