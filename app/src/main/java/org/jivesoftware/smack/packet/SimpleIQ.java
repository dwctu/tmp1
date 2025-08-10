package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public abstract class SimpleIQ extends IQ {
    public SimpleIQ(String str, String str2) {
        super(str, str2);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }
}
