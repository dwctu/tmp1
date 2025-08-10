package org.jivesoftware.smackx.muc.provider;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.nick.packet.Nick;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class MUCParserUtils {
    public static Destroy parseDestroy(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Destroy destroy = new Destroy();
        destroy.setJid(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key));
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    destroy.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(Destroy.ELEMENT)) {
                z = true;
            }
        }
        return destroy;
    }

    public static MUCItem parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        MUCAffiliation mUCAffiliationFromString = MUCAffiliation.fromString(xmlPullParser.getAttributeValue("", FirebaseAnalytics.Param.AFFILIATION));
        String attributeValue = xmlPullParser.getAttributeValue("", Nick.ELEMENT_NAME);
        MUCRole mUCRoleFromString = MUCRole.fromString(xmlPullParser.getAttributeValue("", "role"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "binval");
        String attributeValue4 = null;
        String strNextText = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                } else if (name.equals("actor")) {
                    attributeValue4 = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new MUCItem(mUCAffiliationFromString, mUCRoleFromString, attributeValue4, strNextText, attributeValue2, attributeValue, attributeValue3);
            }
        }
    }

    public static MUCItem parseNewItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        MUCAffiliation mUCAffiliationFromString = MUCAffiliation.fromString(xmlPullParser.getAttributeValue("", FirebaseAnalytics.Param.AFFILIATION));
        String attributeValue = xmlPullParser.getAttributeValue("", "nickname");
        MUCRole mUCRoleFromString = MUCRole.fromString(xmlPullParser.getAttributeValue("", "role"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "binval");
        String attributeValue4 = null;
        String strNextText = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                } else if (name.equals("actor")) {
                    attributeValue4 = xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key);
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new MUCItem(mUCAffiliationFromString, mUCRoleFromString, attributeValue4, strNextText, attributeValue2, attributeValue, attributeValue3);
            }
        }
    }
}
