package org.jivesoftware.smackx.pubsub;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class AffiliationsExtension extends NodeExtension {
    public List<Affiliation> items;

    public AffiliationsExtension() {
        super(PubSubElementType.AFFILIATIONS);
        this.items = Collections.emptyList();
    }

    public List<Affiliation> getAffiliations() {
        return this.items;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public CharSequence toXML() {
        List<Affiliation> list = this.items;
        if (list == null || list.size() == 0) {
            return super.toXML();
        }
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        Iterator<Affiliation> it = this.items.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXML());
        }
        sb.append("</");
        sb.append(getElementName());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public AffiliationsExtension(List<Affiliation> list) {
        super(PubSubElementType.AFFILIATIONS);
        this.items = Collections.emptyList();
        this.items = list;
    }
}
