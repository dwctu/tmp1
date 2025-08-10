package org.jivesoftware.smackx.filetransfer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamManager;
import org.jivesoftware.smackx.bytestreams.socks5.Socks5BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.si.packet.StreamInitiation;

/* loaded from: classes5.dex */
public class Socks5TransferNegotiator extends StreamNegotiator {
    private XMPPConnection connection;
    private Socks5BytestreamManager manager;

    public static class ByteStreamRequest extends Socks5BytestreamRequest {
        private ByteStreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
            super(socks5BytestreamManager, bytestream);
        }
    }

    public Socks5TransferNegotiator(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
        this.manager = Socks5BytestreamManager.getBytestreamManager(xMPPConnection);
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        this.manager.ignoreBytestreamRequestOnce(streamInitiation.getSessionID());
        return negotiateIncomingStream(initiateIncomingStream(this.connection, streamInitiation));
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public OutputStream createOutgoingStream(String str, String str2, String str3) throws SmackException, XMPPException {
        try {
            return this.manager.establishSession(str3, str).getOutputStream();
        } catch (IOException e) {
            throw new SmackException("error establishing SOCKS5 Bytestream", e);
        } catch (InterruptedException e2) {
            throw new SmackException("error establishing SOCKS5 Bytestream", e2);
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public String[] getNamespaces() {
        return new String[]{Bytestream.NAMESPACE};
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public InputStream negotiateIncomingStream(Stanza stanza) throws SmackException, InterruptedException, IOException, XMPPException.XMPPErrorException {
        try {
            PushbackInputStream pushbackInputStream = new PushbackInputStream(new ByteStreamRequest(this.manager, (Bytestream) stanza).accept().getInputStream());
            pushbackInputStream.unread(pushbackInputStream.read());
            return pushbackInputStream;
        } catch (IOException e) {
            throw new SmackException("Error establishing input stream", e);
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.StreamNegotiator
    public void newStreamInitiation(String str, String str2) {
        this.manager.ignoreBytestreamRequestOnce(str2);
    }
}
