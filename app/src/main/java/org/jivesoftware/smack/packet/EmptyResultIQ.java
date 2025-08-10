package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class EmptyResultIQ extends IQ {
    public EmptyResultIQ() {
        super(null, null);
        setType(IQ.Type.result);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        return null;
    }

    public EmptyResultIQ(IQ iq) {
        this();
        if (iq.getType() != IQ.Type.get && iq.getType() != IQ.Type.set) {
            throw new IllegalArgumentException("IQ must be of type 'set' or 'get'. Original IQ: " + ((Object) iq.toXML()));
        }
        setStanzaId(iq.getStanzaId());
        setFrom(iq.getTo());
        setTo(iq.getFrom());
    }
}
