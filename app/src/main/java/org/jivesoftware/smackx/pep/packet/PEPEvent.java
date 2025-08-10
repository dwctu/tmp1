package org.jivesoftware.smackx.pep.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class PEPEvent implements ExtensionElement {
    public PEPItem item;

    public PEPEvent() {
    }

    public void addPEPItem(PEPItem pEPItem) {
        this.item = pEPItem;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "event";
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "http://jabber.org/protocol/pubsub";
    }

    public PEPEvent(PEPItem pEPItem) {
        this.item = pEPItem;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        return SimpleComparison.LESS_THAN_OPERATION + getElementName() + " xmlns=\"" + getNamespace() + "\">" + this.item.toXML() + "</" + getElementName() + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
