package org.jivesoftware.smackx.bytestreams.ibb.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.util.Locale;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* loaded from: classes5.dex */
public class Open extends IQ {
    public static final String ELEMENT = "open";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final int blockSize;
    private final String sessionID;
    private final InBandBytestreamManager.StanzaType stanza;

    public Open(String str, int i, InBandBytestreamManager.StanzaType stanzaType) {
        super("open", "http://jabber.org/protocol/ibb");
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("Block size must be greater than zero");
        }
        this.sessionID = str;
        this.blockSize = i;
        this.stanza = stanzaType;
        setType(IQ.Type.set);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("block-size", Integer.toString(this.blockSize));
        iQChildElementXmlStringBuilder.attribute(PSOProgramService.ServiceID_Key, this.sessionID);
        iQChildElementXmlStringBuilder.attribute("stanza", this.stanza.toString().toLowerCase(Locale.US));
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public InBandBytestreamManager.StanzaType getStanza() {
        return this.stanza;
    }

    public Open(String str, int i) {
        this(str, i, InBandBytestreamManager.StanzaType.IQ);
    }
}
