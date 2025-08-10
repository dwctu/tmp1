package org.jivesoftware.smackx.bytestreams.ibb.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.io.IOException;
import java.util.Locale;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class OpenIQProvider extends IQProvider<Open> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Open parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, NumberFormatException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", PSOProgramService.ServiceID_Key);
        int i2 = Integer.parseInt(xmlPullParser.getAttributeValue("", "block-size"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "stanza");
        InBandBytestreamManager.StanzaType stanzaTypeValueOf = attributeValue2 == null ? InBandBytestreamManager.StanzaType.IQ : InBandBytestreamManager.StanzaType.valueOf(attributeValue2.toUpperCase(Locale.US));
        xmlPullParser.next();
        return new Open(attributeValue, i2, stanzaTypeValueOf);
    }
}
