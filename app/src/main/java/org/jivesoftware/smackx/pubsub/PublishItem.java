package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.jivesoftware.smackx.pubsub.Item;

/* loaded from: classes5.dex */
public class PublishItem<T extends Item> extends NodeExtension {
    public Collection<T> items;

    public PublishItem(String str, T t) {
        super(PubSubElementType.PUBLISH, str);
        ArrayList arrayList = new ArrayList(1);
        this.items = arrayList;
        arrayList.add(t);
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        sb.append(" node='");
        sb.append(getNode());
        sb.append("'>");
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXML());
        }
        sb.append("</publish>");
        return sb.toString();
    }

    public PublishItem(String str, Collection<T> collection) {
        super(PubSubElementType.PUBLISH, str);
        this.items = collection;
    }
}
