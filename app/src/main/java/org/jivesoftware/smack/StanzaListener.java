package org.jivesoftware.smack;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Stanza;

/* loaded from: classes5.dex */
public interface StanzaListener {
    void processPacket(Stanza stanza) throws SmackException.NotConnectedException;
}
