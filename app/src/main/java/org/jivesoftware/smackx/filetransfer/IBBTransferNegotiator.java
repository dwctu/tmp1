package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.si.packet.StreamInitiation;

/* loaded from: classes5.dex */
public class IBBTransferNegotiator extends StreamNegotiator {
    private XMPPConnection connection;
    private InBandBytestreamManager manager;

    public static class ByteStreamRequest extends InBandBytestreamRequest {
        private ByteStreamRequest(InBandBytestreamManager inBandBytestreamManager, Open open) {
            super(inBandBytestreamManager, open);
        }
    }

    public IBBTransferNegotiator(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        this.manager = InBandBytestreamManager.getByteStreamManager(xMPPConnection);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        this.manager.ignoreBytestreamRequestOnce(streamInitiation.getSessionID());
        return negotiateIncomingStream(initiateIncomingStream(this.connection, streamInitiation));
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public OutputStream createOutgoingStream(String str, String str2, String str3) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        InBandBytestreamSession inBandBytestreamSessionEstablishSession = this.manager.establishSession(str3, str);
        inBandBytestreamSessionEstablishSession.setCloseBothStreamsEnabled(true);
        return inBandBytestreamSessionEstablishSession.getOutputStream();
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public String[] getNamespaces() {
        return new String[]{"http://jabber.org/protocol/ibb"};
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream negotiateIncomingStream(Stanza stanza) throws SmackException.NotConnectedException {
        InBandBytestreamSession inBandBytestreamSessionAccept = new ByteStreamRequest(this.manager, (Open) stanza).accept();
        inBandBytestreamSessionAccept.setCloseBothStreamsEnabled(true);
        return inBandBytestreamSessionAccept.getInputStream();
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public void newStreamInitiation(String str, String str2) {
        this.manager.ignoreBytestreamRequestOnce(str2);
    }
}
