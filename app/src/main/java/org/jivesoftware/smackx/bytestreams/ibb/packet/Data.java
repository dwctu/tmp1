package org.jivesoftware.smackx.bytestreams.ibb.packet;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class Data extends IQ {
    private final DataPacketExtension dataPacketExtension;

    public Data(DataPacketExtension dataPacketExtension) {
        super("data", "http://jabber.org/protocol/ibb");
        if (dataPacketExtension == null) {
            throw new IllegalArgumentException("Data must not be null");
        }
        this.dataPacketExtension = dataPacketExtension;
        setType(IQ.Type.set);
    }

    public DataPacketExtension getDataPacketExtension() {
        return this.dataPacketExtension;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        return this.dataPacketExtension.getIQChildElementBuilder(iQChildElementXmlStringBuilder);
    }
}
