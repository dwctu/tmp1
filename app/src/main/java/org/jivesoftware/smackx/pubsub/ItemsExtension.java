package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class ItemsExtension extends NodeExtension implements EmbeddedPacketExtension {
    public List<? extends ExtensionElement> items;
    public Boolean notify;
    public ItemsElementType type;

    public enum ItemsElementType {
        items(PubSubElementType.ITEMS, "max_items"),
        retract(PubSubElementType.RETRACT, "notify");

        private String att;
        private PubSubElementType elem;

        ItemsElementType(PubSubElementType pubSubElementType, String str) {
            this.elem = pubSubElementType;
            this.att = str;
        }

        public String getElementAttribute() {
            return this.att;
        }

        public PubSubElementType getNodeElement() {
            return this.elem;
        }
    }

    public ItemsExtension(ItemsElementType itemsElementType, String str, List<? extends ExtensionElement> list) {
        super(itemsElementType.getNodeElement(), str);
        this.type = itemsElementType;
        this.items = list;
    }

    @Override // org.jivesoftware.smackx.pubsub.EmbeddedPacketExtension
    public List<ExtensionElement> getExtensions() {
        return getItems();
    }

    public List<? extends ExtensionElement> getItems() {
        return this.items;
    }

    public ItemsElementType getItemsElementType() {
        return this.type;
    }

    public boolean getNotify() {
        return this.notify.booleanValue();
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + "Content [" + ((Object) toXML()) + "]";
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public CharSequence toXML() {
        List<? extends ExtensionElement> list = this.items;
        if (list == null || list.size() == 0) {
            return super.toXML();
        }
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        sb.append(" node='");
        sb.append(getNode());
        if (this.notify != null) {
            sb.append("' ");
            sb.append(this.type.getElementAttribute());
            sb.append("='");
            sb.append(this.notify.equals(Boolean.TRUE) ? 1 : 0);
            sb.append("'>");
        } else {
            sb.append("'>");
            Iterator<? extends ExtensionElement> it = this.items.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toXML());
            }
        }
        sb.append("</");
        sb.append(getElementName());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ItemsExtension(String str, List<? extends ExtensionElement> list, boolean z) {
        ItemsElementType itemsElementType = ItemsElementType.retract;
        super(itemsElementType.getNodeElement(), str);
        this.type = itemsElementType;
        this.items = list;
        this.notify = Boolean.valueOf(z);
    }
}
