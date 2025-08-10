package org.jivesoftware.smack.roster.rosterstore;

import java.util.Collection;
import org.jivesoftware.smack.roster.packet.RosterPacket;

/* loaded from: classes5.dex */
public interface RosterStore {
    boolean addEntry(RosterPacket.Item item, String str);

    Collection<RosterPacket.Item> getEntries();

    RosterPacket.Item getEntry(String str);

    String getRosterVersion();

    boolean removeEntry(String str, String str2);

    boolean resetEntries(Collection<RosterPacket.Item> collection, String str);
}
