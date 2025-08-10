package org.jivesoftware.smack.util;

import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class ParserUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void assertAtEndTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void assertAtStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void forwardToEndTagOfDepth(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getDepth() == i) {
                return;
            } else {
                eventType = xmlPullParser.next();
            }
        }
    }

    public static Boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        String lowerCase = attributeValue.toLowerCase(Locale.US);
        return (lowerCase.equals("true") || lowerCase.equals("0")) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Integer getIntegerAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Integer.valueOf(attributeValue);
    }

    public static int getIntegerFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Integer.valueOf(xmlPullParser.nextText()).intValue();
    }

    public static Long getLongAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Long.valueOf(attributeValue);
    }

    public static int getIntegerAttribute(XmlPullParser xmlPullParser, String str, int i) {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        return integerAttribute == null ? i : integerAttribute.intValue();
    }

    public static long getLongAttribute(XmlPullParser xmlPullParser, String str, long j) {
        Long longAttribute = getLongAttribute(xmlPullParser, str);
        return longAttribute == null ? j : longAttribute.longValue();
    }

    public static boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str, boolean z) {
        Boolean booleanAttribute = getBooleanAttribute(xmlPullParser, str);
        return booleanAttribute == null ? z : booleanAttribute.booleanValue();
    }
}
