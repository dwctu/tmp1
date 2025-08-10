package org.jivesoftware.smackx.muc.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class GroupChatInvitation implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:conference";
    private final String roomAddress;

    public static class Provider extends ExtensionElementProvider<GroupChatInvitation> {
        @Override // org.jivesoftware.smack.provider.Provider
        public GroupChatInvitation parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            String attributeValue = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
            xmlPullParser.next();
            return new GroupChatInvitation(attributeValue);
        }
    }

    public GroupChatInvitation(String str) {
        this.roomAddress = str;
    }

    public static GroupChatInvitation from(Stanza stanza) {
        return (GroupChatInvitation) stanza.getExtension("x", NAMESPACE);
    }

    @Deprecated
    public static GroupChatInvitation getFrom(Stanza stanza) {
        return from(stanza);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public String getRoomAddress() {
        return this.roomAddress;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(PSOProgramService.JobID_Key, getRoomAddress());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
