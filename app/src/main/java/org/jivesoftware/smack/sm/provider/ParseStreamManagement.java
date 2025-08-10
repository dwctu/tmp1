package org.jivesoftware.smack.sm.provider;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class ParseStreamManagement {
    public static StreamManagement.AckAnswer ackAnswer(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long jLongValue = ParserUtils.getLongAttribute(xmlPullParser, XHTMLText.H).longValue();
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.AckAnswer(jLongValue);
    }

    public static StreamManagement.AckRequest ackRequest(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return StreamManagement.AckRequest.INSTANCE;
    }

    public static StreamManagement.Enabled enabled(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, StreamManagement.Resume.ELEMENT, false);
        String attributeValue = xmlPullParser.getAttributeValue("", TtmlNode.ATTR_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", FirebaseAnalytics.Param.LOCATION);
        int integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, "max", -1);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Enabled(attributeValue, booleanAttribute, attributeValue2, integerAttribute);
    }

    public static StreamManagement.Failed failed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        XMPPError.Condition conditionFromString = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (XMPPError.NAMESPACE.equals(xmlPullParser.getNamespace())) {
                    conditionFromString = XMPPError.Condition.fromString(name);
                }
            } else if (next == 3 && StreamManagement.Failed.ELEMENT.equals(xmlPullParser.getName())) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return new StreamManagement.Failed(conditionFromString);
            }
        }
    }

    public static StreamManagement.Resumed resumed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long jLongValue = ParserUtils.getLongAttribute(xmlPullParser, XHTMLText.H).longValue();
        String attributeValue = xmlPullParser.getAttributeValue("", "previd");
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Resumed(jLongValue, attributeValue);
    }
}
