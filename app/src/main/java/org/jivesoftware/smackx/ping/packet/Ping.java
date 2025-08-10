package org.jivesoftware.smackx.ping.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;

/* loaded from: classes5.dex */
public class Ping extends SimpleIQ {
    public static final String ELEMENT = "ping";
    public static final String NAMESPACE = "urn:xmpp:ping";

    public Ping() {
        super(ELEMENT, NAMESPACE);
    }

    public IQ getPong() {
        return IQ.createResultIQ(this);
    }

    public Ping(String str) {
        this();
        setTo(str);
        setType(IQ.Type.get);
    }
}
