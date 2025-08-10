package org.jivesoftware.smackx.bytestreams.socks5.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class BytestreamsProvider extends IQProvider<Bytestream> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Bytestream parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        Bytestream bytestream = new Bytestream();
        String attributeValue = xmlPullParser.getAttributeValue("", PSOProgramService.ServiceID_Key);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "mode");
        boolean z = false;
        loop0: while (true) {
            String attributeValue3 = null;
            String attributeValue4 = null;
            String attributeValue5 = null;
            while (!z) {
                int next = xmlPullParser.next();
                String name = xmlPullParser.getName();
                if (next == 2) {
                    if (name.equals(Bytestream.StreamHost.ELEMENTNAME)) {
                        attributeValue4 = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
                        attributeValue5 = xmlPullParser.getAttributeValue("", "host");
                        attributeValue3 = xmlPullParser.getAttributeValue("", "port");
                    } else if (name.equals(Bytestream.StreamHostUsed.ELEMENTNAME)) {
                        bytestream.setUsedHost(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key));
                    } else if (name.equals(Bytestream.Activate.ELEMENTNAME)) {
                        bytestream.setToActivate(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key));
                    }
                } else if (next != 3) {
                    continue;
                } else if (name.equals("streamhost")) {
                    if (attributeValue3 == null) {
                        bytestream.addStreamHost(attributeValue4, attributeValue5);
                    } else {
                        bytestream.addStreamHost(attributeValue4, attributeValue5, Integer.parseInt(attributeValue3));
                    }
                } else if (name.equals("query")) {
                    z = true;
                }
            }
            break loop0;
        }
        if (attributeValue2 == null) {
            bytestream.setMode(Bytestream.Mode.tcp);
        } else {
            bytestream.setMode(Bytestream.Mode.fromName(attributeValue2));
        }
        bytestream.setSessionID(attributeValue);
        return bytestream;
    }
}
