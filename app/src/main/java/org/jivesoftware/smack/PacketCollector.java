package org.jivesoftware.smack;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public class PacketCollector {
    private static final Logger LOGGER = Logger.getLogger(PacketCollector.class.getName());
    private boolean cancelled = false;
    private final PacketCollector collectorToReset;
    private final XMPPConnection connection;
    private final StanzaFilter packetFilter;
    private final ArrayBlockingQueue<Stanza> resultQueue;
    private volatile long waitStart;

    public static class Configuration {
        private PacketCollector collectorToReset;
        private StanzaFilter packetFilter;
        private int size;

        public Configuration setCollectorToReset(PacketCollector packetCollector) {
            this.collectorToReset = packetCollector;
            return this;
        }

        @Deprecated
        public Configuration setPacketFilter(StanzaFilter stanzaFilter) {
            return setStanzaFilter(stanzaFilter);
        }

        public Configuration setSize(int i) {
            this.size = i;
            return this;
        }

        public Configuration setStanzaFilter(StanzaFilter stanzaFilter) {
            this.packetFilter = stanzaFilter;
            return this;
        }

        private Configuration() {
            this.size = SmackConfiguration.getPacketCollectorSize();
        }
    }

    public PacketCollector(XMPPConnection xMPPConnection, Configuration configuration) {
        this.connection = xMPPConnection;
        this.packetFilter = configuration.packetFilter;
        this.resultQueue = new ArrayBlockingQueue<>(configuration.size);
        this.collectorToReset = configuration.collectorToReset;
    }

    public static Configuration newConfiguration() {
        return new Configuration();
    }

    private final void throwIfCancelled() {
        if (this.cancelled) {
            throw new IllegalStateException("Packet collector already cancelled");
        }
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.connection.removePacketCollector(this);
    }

    public int getCollectedCount() {
        return this.resultQueue.size();
    }

    @Deprecated
    public StanzaFilter getPacketFilter() {
        return getStanzaFilter();
    }

    public StanzaFilter getStanzaFilter() {
        return this.packetFilter;
    }

    public <P extends Stanza> P nextResult() {
        return (P) nextResult(this.connection.getPacketReplyTimeout());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.jivesoftware.smack.packet.Stanza] */
    public <P extends Stanza> P nextResultBlockForever() throws InterruptedException {
        throwIfCancelled();
        P pTake = null;
        while (pTake == null) {
            try {
                pTake = this.resultQueue.take();
            } catch (InterruptedException e) {
                LOGGER.log(Level.FINE, "nextResultBlockForever was interrupted", (Throwable) e);
            }
        }
        return pTake;
    }

    public <P extends Stanza> P nextResultOrThrow() throws SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return (P) nextResultOrThrow(this.connection.getPacketReplyTimeout());
    }

    public <P extends Stanza> P pollResult() {
        return (P) this.resultQueue.poll();
    }

    public <P extends Stanza> P pollResultOrThrow() throws XMPPException.XMPPErrorException {
        P p = (P) pollResult();
        if (p != null) {
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(p);
        }
        return p;
    }

    public void processPacket(Stanza stanza) {
        StanzaFilter stanzaFilter = this.packetFilter;
        if (stanzaFilter == null || stanzaFilter.accept(stanza)) {
            while (!this.resultQueue.offer(stanza)) {
                this.resultQueue.poll();
            }
            PacketCollector packetCollector = this.collectorToReset;
            if (packetCollector != null) {
                packetCollector.waitStart = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.jivesoftware.smack.packet.Stanza] */
    public <P extends Stanza> P nextResult(long j) throws InterruptedException {
        throwIfCancelled();
        this.waitStart = System.currentTimeMillis();
        long jCurrentTimeMillis = j;
        P pPoll = null;
        do {
            try {
                pPoll = this.resultQueue.poll(jCurrentTimeMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                LOGGER.log(Level.FINE, "nextResult was interrupted", (Throwable) e);
            }
            if (pPoll != null) {
                return pPoll;
            }
            jCurrentTimeMillis = j - (System.currentTimeMillis() - this.waitStart);
        } while (jCurrentTimeMillis > 0);
        return null;
    }

    public <P extends Stanza> P nextResultOrThrow(long j) throws SmackException.NoResponseException, XMPPException.XMPPErrorException {
        P p = (P) nextResult(j);
        cancel();
        if (p == null) {
            throw SmackException.NoResponseException.newWith(this.connection, this);
        }
        XMPPException.XMPPErrorException.ifHasErrorThenThrow(p);
        return p;
    }
}
