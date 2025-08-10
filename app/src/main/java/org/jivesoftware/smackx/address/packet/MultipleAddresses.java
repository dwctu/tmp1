package org.jivesoftware.smackx.address.packet;

import androidx.core.app.NotificationCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class MultipleAddresses implements ExtensionElement {
    public static final String ELEMENT = "addresses";
    public static final String NAMESPACE = "http://jabber.org/protocol/address";
    private List<Address> addresses = new ArrayList();

    public static class Address implements NamedElement {
        public static final String ELEMENT = "address";
        private boolean delivered;
        private String description;
        private String jid;
        private String node;
        private final Type type;
        private String uri;

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelivered(boolean z) {
            this.delivered = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescription(String str) {
            this.description = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJid(String str) {
            this.jid = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNode(String str) {
            this.node = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUri(String str) {
            this.uri = str;
        }

        public String getDescription() {
            return this.description;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public String getJid() {
            return this.jid;
        }

        public String getNode() {
            return this.node;
        }

        public Type getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public boolean isDelivered() {
            return this.delivered;
        }

        private Address(Type type) {
            this.type = type;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(this).attribute("type", this.type);
            xmlStringBuilder.optAttribute(PSOProgramService.JobID_Key, this.jid);
            xmlStringBuilder.optAttribute("node", this.node);
            xmlStringBuilder.optAttribute("desc", this.description);
            String str = this.description;
            if (str != null && str.trim().length() > 0) {
                xmlStringBuilder.append((CharSequence) " desc=\"");
                xmlStringBuilder.append((CharSequence) this.description).append((CharSequence) "\"");
            }
            xmlStringBuilder.optBooleanAttribute("delivered", this.delivered);
            xmlStringBuilder.optAttribute(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, this.uri);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public enum Type {
        bcc,
        cc,
        noreply,
        replyroom,
        replyto,
        to,
        ofrom
    }

    public void addAddress(Type type, String str, String str2, String str3, boolean z, String str4) {
        Address address = new Address(type);
        address.setJid(str);
        address.setNode(str2);
        address.setDescription(str3);
        address.setDelivered(z);
        address.setUri(str4);
        this.addresses.add(address);
    }

    public List<Address> getAddressesOfType(Type type) {
        ArrayList arrayList = new ArrayList(this.addresses.size());
        for (Address address : this.addresses) {
            if (address.getType().equals(type)) {
                arrayList.add(address);
            }
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public void setNoReply() {
        this.addresses.add(new Address(Type.noreply));
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<Address> it = this.addresses.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next().toXML());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
