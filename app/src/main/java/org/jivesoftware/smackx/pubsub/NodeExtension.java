package org.jivesoftware.smackx.pubsub;

import kotlin.text.Typography;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class NodeExtension implements ExtensionElement {
    private final PubSubElementType element;
    private final String node;

    public NodeExtension(PubSubElementType pubSubElementType, String str) {
        this.element = pubSubElementType;
        this.node = str;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.element.getElementName();
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return this.element.getNamespace().getXmlns();
    }

    public String getNode() {
        return this.node;
    }

    public String toString() {
        return getClass().getName() + " - content [" + ((Object) toXML()) + "]";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.less);
        sb.append(getElementName());
        if (this.node == null) {
            str = "";
        } else {
            str = " node='" + this.node + '\'';
        }
        sb.append(str);
        sb.append("/>");
        return sb.toString();
    }

    public NodeExtension(PubSubElementType pubSubElementType) {
        this(pubSubElementType, null);
    }
}
