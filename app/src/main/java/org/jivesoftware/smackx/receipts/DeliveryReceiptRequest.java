package org.jivesoftware.smackx.receipts;

import java.io.IOException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.id.StanzaIdUtil;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DeliveryReceiptRequest implements ExtensionElement {
    public static final String ELEMENT = "request";

    public static class Provider extends ExtensionElementProvider<DeliveryReceiptRequest> {
        @Override // org.jivesoftware.smack.provider.Provider
        public DeliveryReceiptRequest parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            return new DeliveryReceiptRequest();
        }
    }

    public static String addTo(Message message) {
        if (message.getStanzaId() == null) {
            message.setStanzaId(StanzaIdUtil.newStanzaId());
        }
        message.addExtension(new DeliveryReceiptRequest());
        return message.getStanzaId();
    }

    public static DeliveryReceiptRequest from(Stanza stanza) {
        return (DeliveryReceiptRequest) stanza.getExtension(ELEMENT, DeliveryReceipt.NAMESPACE);
    }

    @Deprecated
    public static DeliveryReceiptRequest getFrom(Stanza stanza) {
        return from(stanza);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return DeliveryReceipt.NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return "<request xmlns='urn:xmpp:receipts'/>";
    }
}
