package org.jivesoftware.smack.roster;

import java.util.Collection;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes5.dex */
public interface RosterListener {
    void entriesAdded(Collection<String> collection);

    void entriesDeleted(Collection<String> collection);

    void entriesUpdated(Collection<String> collection);

    void presenceChanged(Presence presence);
}
