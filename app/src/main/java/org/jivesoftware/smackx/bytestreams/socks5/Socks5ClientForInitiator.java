package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

/* loaded from: classes5.dex */
public class Socks5ClientForInitiator extends Socks5Client {
    private XMPPConnection connection;
    private String sessionID;
    private String target;

    public Socks5ClientForInitiator(Bytestream.StreamHost streamHost, String str, XMPPConnection xMPPConnection, String str2, String str3) {
        super(streamHost, str);
        this.connection = xMPPConnection;
        this.sessionID = str2;
        this.target = str3;
    }

    private void activate() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        this.connection.createPacketCollectorAndSend(createStreamHostActivation()).nextResultOrThrow();
    }

    private Bytestream createStreamHostActivation() {
        Bytestream bytestream = new Bytestream(this.sessionID);
        bytestream.setMode(null);
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(this.streamHost.getJID());
        bytestream.setToActivate(this.target);
        return bytestream;
    }

    @Override // org.jivesoftware.smackx.bytestreams.socks5.Socks5Client
    public Socket getSocket(int i) throws SmackException, InterruptedException, TimeoutException, IOException, XMPPException {
        Socket socket;
        if (this.streamHost.getJID().equals(this.connection.getUser())) {
            socket = Socks5Proxy.getSocks5Proxy().getSocket(this.digest);
            if (socket == null) {
                throw new SmackException("target is not connected to SOCKS5 proxy");
            }
        } else {
            socket = super.getSocket(i);
            try {
                activate();
            } catch (SmackException.NoResponseException e) {
                socket.close();
                throw e;
            } catch (XMPPException e2) {
                socket.close();
                throw e2;
            }
        }
        return socket;
    }
}
