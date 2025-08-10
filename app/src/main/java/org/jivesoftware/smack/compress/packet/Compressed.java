package org.jivesoftware.smack.compress.packet;

import org.jivesoftware.smack.packet.FullStreamElement;

/* loaded from: classes5.dex */
public class Compressed extends FullStreamElement {
    public static final String ELEMENT = "compressed";
    public static final Compressed INSTANCE = new Compressed();
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";

    private Compressed() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return "<compressed xmlns='http://jabber.org/protocol/compress'/>";
    }
}
