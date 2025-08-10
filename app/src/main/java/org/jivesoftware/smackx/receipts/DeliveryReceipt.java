package org.jivesoftware.smackx.receipts;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class DeliveryReceipt implements ExtensionElement {
    public static final String ELEMENT = "received";
    public static final String NAMESPACE = "urn:xmpp:receipts";
    private final String id;

    public static class Provider extends EmbeddedExtensionProvider<DeliveryReceipt> {
        @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
        public /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
            return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
        }

        @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
        public DeliveryReceipt createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
            return new DeliveryReceipt(map.get(TtmlNode.ATTR_ID));
        }
    }

    public DeliveryReceipt(String str) {
        this.id = str;
    }

    public static DeliveryReceipt from(Message message) {
        return (DeliveryReceipt) message.getExtension(ELEMENT, NAMESPACE);
    }

    @Deprecated
    public static DeliveryReceipt getFrom(Message message) {
        return from(message);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(TtmlNode.ATTR_ID, this.id);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
