package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class PayloadItem<E extends ExtensionElement> extends Item {
    private E payload;

    public PayloadItem(E e) {
        if (e == null) {
            throw new IllegalArgumentException("payload cannot be 'null'");
        }
        this.payload = e;
    }

    public E getPayload() {
        return this.payload;
    }

    @Override // org.jivesoftware.smackx.pubsub.Item, org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + " | Content [" + toXML() + "]";
    }

    @Override // org.jivesoftware.smackx.pubsub.Item, org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder("<item");
        if (getId() != null) {
            sb.append(" id='");
            sb.append(getId());
            sb.append("'");
        }
        if (getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        sb.append(this.payload.toXML());
        sb.append("</item>");
        return sb.toString();
    }

    public PayloadItem(String str, E e) {
        super(str);
        if (e != null) {
            this.payload = e;
            return;
        }
        throw new IllegalArgumentException("payload cannot be 'null'");
    }

    public PayloadItem(String str, String str2, E e) {
        super(str, str2);
        if (e != null) {
            this.payload = e;
            return;
        }
        throw new IllegalArgumentException("payload cannot be 'null'");
    }
}
