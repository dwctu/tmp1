package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class GetItemsRequest extends NodeExtension {
    public final int maxItems;
    public final String subId;

    public GetItemsRequest(String str) {
        this(str, null, -1);
    }

    public int getMaxItems() {
        return this.maxItems;
    }

    public String getSubscriptionId() {
        return this.subId;
    }

    public GetItemsRequest(String str, String str2) {
        this(str, str2, -1);
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(getElementName());
        xmlStringBuilder.attribute("node", getNode());
        xmlStringBuilder.optAttribute("subid", getSubscriptionId());
        xmlStringBuilder.optIntAttribute("max_items", getMaxItems());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public GetItemsRequest(String str, int i) {
        this(str, null, i);
    }

    public GetItemsRequest(String str, String str2, int i) {
        super(PubSubElementType.ITEMS, str);
        this.maxItems = i;
        this.subId = str2;
    }
}
