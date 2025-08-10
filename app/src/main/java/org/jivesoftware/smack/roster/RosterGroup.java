package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class RosterGroup {
    private final XMPPConnection connection;
    private final Set<RosterEntry> entries = new LinkedHashSet();
    private final String name;

    public RosterGroup(String str, XMPPConnection xMPPConnection) {
        this.name = str;
        this.connection = xMPPConnection;
    }

    public void addEntry(RosterEntry rosterEntry) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PacketCollector packetCollectorCreatePacketCollectorAndSend;
        synchronized (this.entries) {
            if (this.entries.contains(rosterEntry)) {
                packetCollectorCreatePacketCollectorAndSend = null;
            } else {
                RosterPacket rosterPacket = new RosterPacket();
                rosterPacket.setType(IQ.Type.set);
                RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
                rosterItem.addGroupName(getName());
                rosterPacket.addRosterItem(rosterItem);
                packetCollectorCreatePacketCollectorAndSend = this.connection.createPacketCollectorAndSend(rosterPacket);
            }
        }
        if (packetCollectorCreatePacketCollectorAndSend != null) {
            packetCollectorCreatePacketCollectorAndSend.nextResultOrThrow();
        }
    }

    public void addEntryLocal(RosterEntry rosterEntry) {
        synchronized (this.entries) {
            this.entries.remove(rosterEntry);
            this.entries.add(rosterEntry);
        }
    }

    public boolean contains(RosterEntry rosterEntry) {
        boolean zContains;
        synchronized (this.entries) {
            zContains = this.entries.contains(rosterEntry);
        }
        return zContains;
    }

    public List<RosterEntry> getEntries() {
        ArrayList arrayList;
        synchronized (this.entries) {
            arrayList = new ArrayList(this.entries);
        }
        return arrayList;
    }

    public RosterEntry getEntry(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = XmppStringUtils.parseBareJid(str).toLowerCase(Locale.US);
        synchronized (this.entries) {
            for (RosterEntry rosterEntry : this.entries) {
                if (rosterEntry.getUser().equals(lowerCase)) {
                    return rosterEntry;
                }
            }
            return null;
        }
    }

    public int getEntryCount() {
        int size;
        synchronized (this.entries) {
            size = this.entries.size();
        }
        return size;
    }

    public String getName() {
        return this.name;
    }

    public void removeEntry(RosterEntry rosterEntry) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PacketCollector packetCollectorCreatePacketCollectorAndSend;
        synchronized (this.entries) {
            if (this.entries.contains(rosterEntry)) {
                RosterPacket rosterPacket = new RosterPacket();
                rosterPacket.setType(IQ.Type.set);
                RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
                rosterItem.removeGroupName(getName());
                rosterPacket.addRosterItem(rosterItem);
                packetCollectorCreatePacketCollectorAndSend = this.connection.createPacketCollectorAndSend(rosterPacket);
            } else {
                packetCollectorCreatePacketCollectorAndSend = null;
            }
        }
        if (packetCollectorCreatePacketCollectorAndSend != null) {
            packetCollectorCreatePacketCollectorAndSend.nextResultOrThrow();
        }
    }

    public void removeEntryLocal(RosterEntry rosterEntry) {
        synchronized (this.entries) {
            if (this.entries.contains(rosterEntry)) {
                this.entries.remove(rosterEntry);
            }
        }
    }

    public void setName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        synchronized (this.entries) {
            for (RosterEntry rosterEntry : this.entries) {
                RosterPacket rosterPacket = new RosterPacket();
                rosterPacket.setType(IQ.Type.set);
                RosterPacket.Item rosterItem = RosterEntry.toRosterItem(rosterEntry);
                rosterItem.removeGroupName(this.name);
                rosterItem.addGroupName(str);
                rosterPacket.addRosterItem(rosterItem);
                this.connection.createPacketCollectorAndSend(rosterPacket).nextResultOrThrow();
            }
        }
    }

    public boolean contains(String str) {
        return getEntry(str) != null;
    }
}
