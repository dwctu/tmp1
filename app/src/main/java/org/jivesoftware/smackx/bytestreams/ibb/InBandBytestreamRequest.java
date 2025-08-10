package org.jivesoftware.smackx.bytestreams.ibb;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;

/* loaded from: classes5.dex */
public class InBandBytestreamRequest implements BytestreamRequest {
    private final Open byteStreamRequest;
    private final InBandBytestreamManager manager;

    public InBandBytestreamRequest(InBandBytestreamManager inBandBytestreamManager, Open open) {
        this.manager = inBandBytestreamManager;
        this.byteStreamRequest = open;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public String getFrom() {
        return this.byteStreamRequest.getFrom();
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public String getSessionID() {
        return this.byteStreamRequest.getSessionID();
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public void reject() throws SmackException.NotConnectedException {
        this.manager.replyRejectPacket(this.byteStreamRequest);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public InBandBytestreamSession accept() throws SmackException.NotConnectedException {
        XMPPConnection connection = this.manager.getConnection();
        Open open = this.byteStreamRequest;
        InBandBytestreamSession inBandBytestreamSession = new InBandBytestreamSession(connection, open, open.getFrom());
        this.manager.getSessions().put(this.byteStreamRequest.getSessionID(), inBandBytestreamSession);
        connection.sendStanza(IQ.createResultIQ(this.byteStreamRequest));
        return inBandBytestreamSession;
    }
}
