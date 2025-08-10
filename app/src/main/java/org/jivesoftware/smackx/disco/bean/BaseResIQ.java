package org.jivesoftware.smackx.disco.bean;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class BaseResIQ extends BaseIQ {
    private String body;

    public <T> T getBody() {
        return (T) this.body;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public void setBody(String str) {
        this.body = str;
    }
}
