package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jxmpp.util.cache.Cache;
import org.jxmpp.util.cache.ExpirationCache;

/* loaded from: classes5.dex */
public class Socks5BytestreamRequest implements BytestreamRequest {
    private static final int BLACKLIST_MAX_SIZE = 100;
    private Bytestream bytestreamRequest;
    private Socks5BytestreamManager manager;
    private static final long BLACKLIST_LIFETIME = 7200000;
    private static final Cache<String, Integer> ADDRESS_BLACKLIST = new ExpirationCache(100, BLACKLIST_LIFETIME);
    private static int CONNECTION_FAILURE_THRESHOLD = 2;
    private int totalConnectTimeout = 10000;
    private int minimumConnectTimeout = 2000;

    public Socks5BytestreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
        this.manager = socks5BytestreamManager;
        this.bytestreamRequest = bytestream;
    }

    private void cancelRequest() throws SmackException.NotConnectedException, XMPPException.XMPPErrorException {
        XMPPError xMPPErrorFrom = XMPPError.from(XMPPError.Condition.item_not_found, "Could not establish socket with any provided host");
        this.manager.getConnection().sendStanza(IQ.createErrorResponse(this.bytestreamRequest, xMPPErrorFrom));
        throw new XMPPException.XMPPErrorException("Could not establish socket with any provided host", xMPPErrorFrom);
    }

    private Bytestream createUsedHostResponse(Bytestream.StreamHost streamHost) {
        Bytestream bytestream = new Bytestream(this.bytestreamRequest.getSessionID());
        bytestream.setTo(this.bytestreamRequest.getFrom());
        bytestream.setType(IQ.Type.result);
        bytestream.setStanzaId(this.bytestreamRequest.getStanzaId());
        bytestream.setUsedHost(streamHost.getJID());
        return bytestream;
    }

    public static int getConnectFailureThreshold() {
        return CONNECTION_FAILURE_THRESHOLD;
    }

    private int getConnectionFailures(String str) {
        Integer num = ADDRESS_BLACKLIST.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private void incrementConnectionFailures(String str) {
        Cache<String, Integer> cache = ADDRESS_BLACKLIST;
        Integer num = cache.get(str);
        cache.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static void setConnectFailureThreshold(int i) {
        CONNECTION_FAILURE_THRESHOLD = i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public String getFrom() {
        return this.bytestreamRequest.getFrom();
    }

    public int getMinimumConnectTimeout() {
        int i = this.minimumConnectTimeout;
        if (i <= 0) {
            return 2000;
        }
        return i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public String getSessionID() {
        return this.bytestreamRequest.getSessionID();
    }

    public int getTotalConnectTimeout() {
        int i = this.totalConnectTimeout;
        if (i <= 0) {
            return 10000;
        }
        return i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public void reject() throws SmackException.NotConnectedException {
        this.manager.replyRejectPacket(this.bytestreamRequest);
    }

    public void setMinimumConnectTimeout(int i) {
        this.minimumConnectTimeout = i;
    }

    public void setTotalConnectTimeout(int i) {
        this.totalConnectTimeout = i;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamRequest
    public Socks5BytestreamSession accept() throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        Bytestream.StreamHost next;
        Socket socket;
        List<Bytestream.StreamHost> streamHosts = this.bytestreamRequest.getStreamHosts();
        if (streamHosts.size() == 0) {
            cancelRequest();
        }
        String strCreateDigest = Socks5Utils.createDigest(this.bytestreamRequest.getSessionID(), this.bytestreamRequest.getFrom(), this.manager.getConnection().getUser());
        int iMax = Math.max(getTotalConnectTimeout() / streamHosts.size(), getMinimumConnectTimeout());
        Iterator<Bytestream.StreamHost> it = streamHosts.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                socket = null;
                break;
            }
            next = it.next();
            String str = next.getAddress() + SignatureImpl.INNER_SEP + next.getPort();
            int connectionFailures = getConnectionFailures(str);
            int i = CONNECTION_FAILURE_THRESHOLD;
            if (i <= 0 || connectionFailures < i) {
                try {
                    socket = new Socks5Client(next, strCreateDigest).getSocket(iMax);
                    break;
                } catch (IOException unused) {
                    incrementConnectionFailures(str);
                } catch (TimeoutException unused2) {
                    incrementConnectionFailures(str);
                } catch (XMPPException unused3) {
                    incrementConnectionFailures(str);
                }
            }
        }
        if (next == null || socket == null) {
            cancelRequest();
        }
        this.manager.getConnection().sendStanza(createUsedHostResponse(next));
        return new Socks5BytestreamSession(socket, next.getJID().equals(this.bytestreamRequest.getFrom()));
    }
}
