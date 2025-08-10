package org.jivesoftware.smackx.disco.bean;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public abstract class BaseIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://www.jivesoftware.org/protocol/room";

    public BaseIQ() {
        super("query", NAMESPACE);
    }
}
