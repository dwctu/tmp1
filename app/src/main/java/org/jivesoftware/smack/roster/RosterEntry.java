package org.jivesoftware.smack.roster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.roster.packet.RosterPacket;

/* loaded from: classes5.dex */
public final class RosterEntry extends Manager {
    private String name;
    private final Roster roster;
    private RosterPacket.ItemStatus status;
    private RosterPacket.ItemType type;
    private final String user;

    public RosterEntry(String str, String str2, RosterPacket.ItemType itemType, RosterPacket.ItemStatus itemStatus, Roster roster, XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.user = str;
        this.name = str2;
        this.type = itemType;
        this.status = itemStatus;
        this.roster = roster;
    }

    public static RosterPacket.Item toRosterItem(RosterEntry rosterEntry) {
        return toRosterItem(rosterEntry, rosterEntry.getName());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RosterEntry)) {
            return false;
        }
        return this.user.equals(((RosterEntry) obj).getUser());
    }

    public boolean equalsDeep(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RosterEntry.class != obj.getClass()) {
            return false;
        }
        RosterEntry rosterEntry = (RosterEntry) obj;
        String str = this.name;
        if (str == null) {
            if (rosterEntry.name != null) {
                return false;
            }
        } else if (!str.equals(rosterEntry.name)) {
            return false;
        }
        RosterPacket.ItemStatus itemStatus = this.status;
        if (itemStatus == null) {
            if (rosterEntry.status != null) {
                return false;
            }
        } else if (!itemStatus.equals(rosterEntry.status)) {
            return false;
        }
        RosterPacket.ItemType itemType = this.type;
        if (itemType == null) {
            if (rosterEntry.type != null) {
                return false;
            }
        } else if (!itemType.equals(rosterEntry.type)) {
            return false;
        }
        String str2 = this.user;
        if (str2 == null) {
            if (rosterEntry.user != null) {
                return false;
            }
        } else if (!str2.equals(rosterEntry.user)) {
            return false;
        }
        return true;
    }

    public List<RosterGroup> getGroups() {
        ArrayList arrayList = new ArrayList();
        for (RosterGroup rosterGroup : this.roster.getGroups()) {
            if (rosterGroup.contains(this)) {
                arrayList.add(rosterGroup);
            }
        }
        return arrayList;
    }

    public String getName() {
        return this.name;
    }

    public RosterPacket.ItemStatus getStatus() {
        return this.status;
    }

    public RosterPacket.ItemType getType() {
        return this.type;
    }

    public String getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.user;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public synchronized void setName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (str == null) {
            RosterPacket rosterPacket = new RosterPacket();
            rosterPacket.setType(IQ.Type.set);
            rosterPacket.addRosterItem(toRosterItem(this, str));
            connection().createPacketCollectorAndSend(rosterPacket).nextResultOrThrow();
            this.name = str;
            return;
        }
        if (str.equals(this.name)) {
            return;
        }
        RosterPacket rosterPacket2 = new RosterPacket();
        rosterPacket2.setType(IQ.Type.set);
        rosterPacket2.addRosterItem(toRosterItem(this, str));
        connection().createPacketCollectorAndSend(rosterPacket2).nextResultOrThrow();
        this.name = str;
        return;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.name;
        if (str != null) {
            sb.append(str);
            sb.append(": ");
        }
        sb.append(this.user);
        List<RosterGroup> groups = getGroups();
        if (!groups.isEmpty()) {
            sb.append(" [");
            Iterator<RosterGroup> it = groups.iterator();
            sb.append(it.next().getName());
            while (it.hasNext()) {
                sb.append(", ");
                sb.append(it.next().getName());
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public void updateState(String str, RosterPacket.ItemType itemType, RosterPacket.ItemStatus itemStatus) {
        this.name = str;
        this.type = itemType;
        this.status = itemStatus;
    }

    private static RosterPacket.Item toRosterItem(RosterEntry rosterEntry, String str) {
        RosterPacket.Item item = new RosterPacket.Item(rosterEntry.getUser(), str);
        item.setItemType(rosterEntry.getType());
        item.setItemStatus(rosterEntry.getStatus());
        Iterator<RosterGroup> it = rosterEntry.getGroups().iterator();
        while (it.hasNext()) {
            item.addGroupName(it.next().getName());
        }
        return item;
    }
}
