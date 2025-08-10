package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class SubscriptionsExtension extends NodeExtension {
    public List<Subscription> items;

    public SubscriptionsExtension(List<Subscription> list) {
        super(PubSubElementType.SUBSCRIPTIONS);
        this.items = Collections.emptyList();
        if (list != null) {
            this.items = list;
        }
    }

    public List<Subscription> getSubscriptions() {
        return this.items;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public CharSequence toXML() {
        List<Subscription> list = this.items;
        if (list == null || list.size() == 0) {
            return super.toXML();
        }
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        if (getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        Iterator<Subscription> it = this.items.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXML());
        }
        sb.append("</");
        sb.append(getElementName());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public SubscriptionsExtension(String str, List<Subscription> list) {
        super(PubSubElementType.SUBSCRIPTIONS, str);
        this.items = Collections.emptyList();
        if (list != null) {
            this.items = list;
        }
    }
}
