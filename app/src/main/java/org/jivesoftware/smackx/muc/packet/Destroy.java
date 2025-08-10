package org.jivesoftware.smackx.muc.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class Destroy implements NamedElement {
    public static final String ELEMENT = "destroy";
    private String jid;
    private String reason;

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getJid() {
        return this.jid;
    }

    public String getReason() {
        return this.reason;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
        xmlStringBuilder.optAttribute(PSOProgramService.JobID_Key, getJid());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("reason", getReason());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
