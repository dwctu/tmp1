package org.jivesoftware.smack.packet;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jivesoftware.smack.packet.id.StanzaIdUtil;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public abstract class Stanza implements TopLevelStreamElement, Packet {
    public static final String DEFAULT_LANGUAGE = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
    public static final String ITEM = "item";
    public static final String TEXT = "text";
    private XMPPError error;
    private String from;
    private String id;
    public String language;
    private final MultiMap<String, ExtensionElement> packetExtensions;
    private String to;

    public Stanza() {
        this(StanzaIdUtil.newStanzaId());
    }

    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    public void addCommonAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("to", getTo());
        xmlStringBuilder.optAttribute("from", getFrom());
        xmlStringBuilder.optAttribute(TtmlNode.ATTR_ID, getStanzaId());
        xmlStringBuilder.xmllangAttribute(getLanguage());
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void addExtension(ExtensionElement extensionElement) {
        if (extensionElement == null) {
            return;
        }
        String strGenerateKey = XmppStringUtils.generateKey(extensionElement.getElementName(), extensionElement.getNamespace());
        synchronized (this.packetExtensions) {
            this.packetExtensions.put(strGenerateKey, extensionElement);
        }
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void addExtensions(Collection<ExtensionElement> collection) {
        if (collection == null) {
            return;
        }
        Iterator<ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            addExtension(it.next());
        }
    }

    public void appendErrorIfExists(XmlStringBuilder xmlStringBuilder) {
        XMPPError error = getError();
        if (error != null) {
            xmlStringBuilder.append(error.toXML());
        }
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public XMPPError getError() {
        return this.error;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), null, str);
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public List<ExtensionElement> getExtensions() {
        List<ExtensionElement> listValues;
        synchronized (this.packetExtensions) {
            listValues = this.packetExtensions.values();
        }
        return listValues;
    }

    public final XmlStringBuilder getExtensionsXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        Iterator<ExtensionElement> it = getExtensions().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next().toXML());
        }
        return xmlStringBuilder;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public String getFrom() {
        return this.from;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public String getLanguage() {
        return this.language;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    @Deprecated
    public String getPacketID() {
        return getStanzaId();
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public String getStanzaId() {
        return this.id;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public String getTo() {
        return this.to;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public boolean hasExtension(String str, String str2) {
        boolean zContainsKey;
        if (str == null) {
            return hasExtension(str2);
        }
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            zContainsKey = this.packetExtensions.containsKey(strGenerateKey);
        }
        return zContainsKey;
    }

    public boolean hasStanzaIdSet() {
        return this.id != null;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public ExtensionElement removeExtension(String str, String str2) {
        ExtensionElement extensionElementRemove;
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            extensionElementRemove = this.packetExtensions.remove(strGenerateKey);
        }
        return extensionElementRemove;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void setError(XMPPError xMPPError) {
        this.error = xMPPError;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void setFrom(String str) {
        this.from = str;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void setLanguage(String str) {
        this.language = str;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    @Deprecated
    public void setPacketID(String str) {
        setStanzaId(str);
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void setStanzaId(String str) {
        if (str != null) {
            StringUtils.requireNotNullOrEmpty(str, "id must either be null or not the empty String");
        }
        this.id = str;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public void setTo(String str) {
        this.to = str;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public String toString() {
        return toXML().toString();
    }

    public Stanza(String str) {
        this.packetExtensions = new MultiMap<>();
        this.id = null;
        this.to = null;
        this.from = null;
        this.error = null;
        setStanzaId(str);
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        PE pe;
        if (str2 == null) {
            return null;
        }
        String strGenerateKey = XmppStringUtils.generateKey(str, str2);
        synchronized (this.packetExtensions) {
            pe = (PE) this.packetExtensions.getFirst(strGenerateKey);
        }
        if (pe == null) {
            return null;
        }
        return pe;
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public Set<ExtensionElement> getExtensions(String str, String str2) {
        StringUtils.requireNotNullOrEmpty(str, "elementName must not be null or empty");
        StringUtils.requireNotNullOrEmpty(str2, "namespace must not be null or empty");
        return this.packetExtensions.getAll(XmppStringUtils.generateKey(str, str2));
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public ExtensionElement removeExtension(ExtensionElement extensionElement) {
        return removeExtension(extensionElement.getElementName(), extensionElement.getNamespace());
    }

    @Override // org.jivesoftware.smack.packet.Packet
    public boolean hasExtension(String str) {
        synchronized (this.packetExtensions) {
            Iterator<ExtensionElement> it = this.packetExtensions.values().iterator();
            while (it.hasNext()) {
                if (it.next().getNamespace().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Stanza(Stanza stanza) {
        this.packetExtensions = new MultiMap<>();
        this.id = null;
        this.to = null;
        this.from = null;
        this.error = null;
        this.id = stanza.getStanzaId();
        this.to = stanza.getTo();
        this.from = stanza.getFrom();
        this.error = stanza.error;
        Iterator<ExtensionElement> it = stanza.getExtensions().iterator();
        while (it.hasNext()) {
            addExtension(it.next());
        }
    }
}
