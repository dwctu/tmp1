package org.jivesoftware.smackx.bytestreams.ibb.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* loaded from: classes5.dex */
public class DataPacketExtension implements ExtensionElement {
    public static final String ELEMENT = "data";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final String data;
    private byte[] decodedData;
    private final long seq;
    private final String sessionID;

    public DataPacketExtension(String str, long j, String str2) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (j < 0 || j > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            throw new IllegalArgumentException("Sequence must not be between 0 and 65535");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Data must not be null");
        }
        this.sessionID = str;
        this.seq = j;
        this.data = str2;
    }

    public String getData() {
        return this.data;
    }

    public byte[] getDecodedData() {
        byte[] bArr = this.decodedData;
        if (bArr != null) {
            return bArr;
        }
        if (this.data.matches(".*={1,2}+.+")) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(this.data);
        this.decodedData = bArrDecode;
        return bArrDecode;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "data";
    }

    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seq", Long.toString(this.seq));
        iQChildElementXmlStringBuilder.attribute(PSOProgramService.ServiceID_Key, this.sessionID);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) this.data);
        return iQChildElementXmlStringBuilder;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "http://jabber.org/protocol/ibb";
    }

    public long getSeq() {
        return this.seq;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        IQ.IQChildElementXmlStringBuilder iQChildElementBuilder = getIQChildElementBuilder(new IQ.IQChildElementXmlStringBuilder(this));
        iQChildElementBuilder.closeElement(this);
        return iQChildElementBuilder;
    }
}
