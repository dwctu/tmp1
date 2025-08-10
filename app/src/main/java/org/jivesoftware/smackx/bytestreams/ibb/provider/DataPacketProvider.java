package org.jivesoftware.smackx.bytestreams.ibb.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class DataPacketProvider {

    public static class IQProvider extends org.jivesoftware.smack.provider.IQProvider<Data> {
        private static final PacketExtensionProvider packetExtensionProvider = new PacketExtensionProvider();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.jivesoftware.smack.provider.Provider
        public Data parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
            return new Data((DataPacketExtension) packetExtensionProvider.parse(xmlPullParser));
        }
    }

    public static class PacketExtensionProvider extends ExtensionElementProvider<DataPacketExtension> {
        @Override // org.jivesoftware.smack.provider.Provider
        public DataPacketExtension parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            return new DataPacketExtension(xmlPullParser.getAttributeValue("", PSOProgramService.ServiceID_Key), Long.parseLong(xmlPullParser.getAttributeValue("", "seq")), xmlPullParser.nextText());
        }
    }
}
