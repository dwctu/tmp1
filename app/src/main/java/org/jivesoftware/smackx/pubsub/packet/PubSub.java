package org.jivesoftware.smackx.pubsub.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.pubsub.PubSubElementType;

/* loaded from: classes5.dex */
public class PubSub extends IQ {
    public static final String ELEMENT = "pubsub";
    public static final String NAMESPACE = "http://jabber.org/protocol/pubsub";

    public PubSub() {
        super("pubsub", "http://jabber.org/protocol/pubsub");
    }

    public static PubSub createPubsubPacket(String str, IQ.Type type, ExtensionElement extensionElement, PubSubNamespace pubSubNamespace) {
        PubSub pubSub = new PubSub(str, type, pubSubNamespace);
        pubSub.addExtension(extensionElement);
        return pubSub;
    }

    public String getElementName() {
        return "pubsub";
    }

    public <PE extends ExtensionElement> PE getExtension(PubSubElementType pubSubElementType) {
        return (PE) getExtension(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns());
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public PubSub(PubSubNamespace pubSubNamespace) {
        super("pubsub", pubSubNamespace.getXmlns());
    }

    public PubSub(String str, IQ.Type type, PubSubNamespace pubSubNamespace) {
        super("pubsub", (pubSubNamespace == null ? PubSubNamespace.BASIC : pubSubNamespace).getXmlns());
        setTo(str);
        setType(type);
    }
}
