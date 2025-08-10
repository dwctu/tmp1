package org.jivesoftware.smackx.pubsub;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class Affiliation implements ExtensionElement {
    public String node;
    public Type type;

    public enum Type {
        member,
        none,
        outcast,
        owner,
        publisher
    }

    public Affiliation(String str, Type type) {
        this.node = str;
        this.type = type;
    }

    private void appendAttribute(StringBuilder sb, String str, String str2) {
        sb.append(" ");
        sb.append(str);
        sb.append("='");
        sb.append(str2);
        sb.append("'");
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "subscription";
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return null;
    }

    public String getNodeId() {
        return this.node;
    }

    public Type getType() {
        return this.type;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        appendAttribute(sb, "node", this.node);
        appendAttribute(sb, FirebaseAnalytics.Param.AFFILIATION, this.type.toString());
        sb.append("/>");
        return sb.toString();
    }
}
