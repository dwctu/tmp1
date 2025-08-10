package org.jivesoftware.smackx.pep.packet;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class PEPPubSub extends IQ {
    public static final String ELEMENT = "pubsub";
    public static final String NAMESPACE = "http://jabber.org/protocol/pubsub";
    private final PEPItem item;

    public PEPPubSub(PEPItem pEPItem) {
        super("pubsub", "http://jabber.org/protocol/pubsub");
        this.item = pEPItem;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.openElement("publish").attribute("node", this.item.getNode()).rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) this.item.toXML());
        iQChildElementXmlStringBuilder.closeElement("publish");
        return iQChildElementXmlStringBuilder;
    }
}
