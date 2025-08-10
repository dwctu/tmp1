package org.jivesoftware.smackx.muc.packet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes5.dex */
public class MUCUser implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc#user";
    private Decline decline;
    private Destroy destroy;
    private Invite invite;
    private MUCItem item;
    private String password;
    private final Set<Status> statusCodes = new HashSet(4);

    public static class Decline implements NamedElement {
        public static final String ELEMENT = "decline";
        private String from;
        private String reason;
        private String to;

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "decline";
        }

        public String getFrom() {
            return this.from;
        }

        public String getReason() {
            return this.reason;
        }

        public String getTo() {
            return this.to;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        public void setTo(String str) {
            this.to = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optAttribute("to", getTo());
            xmlStringBuilder.optAttribute("from", getFrom());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("reason", getReason());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public static class Invite implements NamedElement {
        public static final String ELEMENT = "invite";
        private String from;
        private String reason;
        private String room;
        private String to;

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public String getFrom() {
            return this.from;
        }

        public String getReason() {
            return this.reason;
        }

        public String getRoom() {
            return this.room;
        }

        public String getTo() {
            return this.to;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        public void setRoom(String str) {
            this.room = str;
        }

        public void setTo(String str) {
            this.to = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optAttribute("to", getTo());
            xmlStringBuilder.optAttribute("from", getFrom());
            xmlStringBuilder.optAttribute("room", getRoom());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("reason", getReason());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public static class Status implements NamedElement {
        public static final String ELEMENT = "status";
        private final Integer code;
        private static final Map<Integer, Status> statusMap = new HashMap(8);
        public static final Status ROOM_CREATED_201 = create((Integer) 201);
        public static final Status BANNED_301 = create((Integer) 301);
        public static final Status NEW_NICKNAME_303 = create((Integer) 303);
        public static final Status KICKED_307 = create((Integer) 307);
        public static final Status REMOVED_AFFIL_CHANGE_321 = create((Integer) 321);

        private Status(int i) {
            this.code = Integer.valueOf(i);
        }

        public static Status create(String str) {
            return create(Integer.valueOf(str));
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Status)) {
                return this.code.equals(Integer.valueOf(((Status) obj).getCode()));
            }
            return false;
        }

        public int getCode() {
            return this.code.intValue();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "status";
        }

        public int hashCode() {
            return this.code.intValue();
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.attribute(XHTMLText.CODE, getCode());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public static Status create(Integer num) {
            Map<Integer, Status> map = statusMap;
            Status status = map.get(num);
            if (status != null) {
                return status;
            }
            Status status2 = new Status(num.intValue());
            map.put(num, status2);
            return status2;
        }
    }

    public static MUCUser from(Stanza stanza) {
        return (MUCUser) stanza.getExtension("x", "http://jabber.org/protocol/muc#user");
    }

    @Deprecated
    public static MUCUser getFrom(Stanza stanza) {
        return from(stanza);
    }

    public void addStatusCode(Status status) {
        this.statusCodes.add(status);
    }

    public void addStatusCodes(Set<Status> set) {
        this.statusCodes.addAll(set);
    }

    public Decline getDecline() {
        return this.decline;
    }

    public Destroy getDestroy() {
        return this.destroy;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    public Invite getInvite() {
        return this.invite;
    }

    public MUCItem getItem() {
        return this.item;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "http://jabber.org/protocol/muc#user";
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Status> getStatus() {
        return this.statusCodes;
    }

    public boolean hasStatus() {
        return !this.statusCodes.isEmpty();
    }

    public void setDecline(Decline decline) {
        this.decline = decline;
    }

    public void setDestroy(Destroy destroy) {
        this.destroy = destroy;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }

    public void setItem(MUCItem mUCItem) {
        this.item = mUCItem;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getInvite());
        xmlStringBuilder.optElement(getDecline());
        xmlStringBuilder.optElement(getItem());
        xmlStringBuilder.optElement("password", getPassword());
        xmlStringBuilder.append(this.statusCodes);
        xmlStringBuilder.optElement(getDestroy());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
