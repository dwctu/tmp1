package org.jivesoftware.smackx.bytestreams.ibb.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class Close extends IQ {
    public static final String ELEMENT = "close";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final String sessionID;

    public Close(String str) {
        super(ELEMENT, "http://jabber.org/protocol/ibb");
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        this.sessionID = str;
        setType(IQ.Type.set);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(PSOProgramService.ServiceID_Key, this.sessionID);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getSessionID() {
        return this.sessionID;
    }
}
