package org.jivesoftware.smackx.pep.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public abstract class PEPItem implements ExtensionElement {
    public String id;

    public PEPItem(String str) {
        this.id = str;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "item";
    }

    public abstract String getItemDetailsXML();

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "http://jabber.org/protocol/pubsub";
    }

    public abstract String getNode();

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return SimpleComparison.LESS_THAN_OPERATION + getElementName() + " id=\"" + this.id + "\">" + getItemDetailsXML() + "</" + getElementName() + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
