package org.jivesoftware.smackx.amp.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.amp.AMPDeliverCondition;
import org.jivesoftware.smackx.amp.AMPExpireAtCondition;
import org.jivesoftware.smackx.amp.AMPMatchResourceCondition;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class AMPExtensionProvider extends ExtensionElementProvider<AMPExtension> {
    private static final Logger LOGGER = Logger.getLogger(AMPExtensionProvider.class.getName());

    private AMPExtension.Condition createCondition(String str, String str2) {
        if (str == null || str2 == null) {
            LOGGER.severe("Can't create rule condition from null name and/or value");
            return null;
        }
        if (AMPDeliverCondition.NAME.equals(str)) {
            try {
                return new AMPDeliverCondition(AMPDeliverCondition.Value.valueOf(str2));
            } catch (IllegalArgumentException unused) {
                LOGGER.severe("Found invalid rule delivery condition value " + str2);
                return null;
            }
        }
        if (AMPExpireAtCondition.NAME.equals(str)) {
            return new AMPExpireAtCondition(str2);
        }
        if (!AMPMatchResourceCondition.NAME.equals(str)) {
            LOGGER.severe("Found unknown rule condition name " + str);
            return null;
        }
        try {
            return new AMPMatchResourceCondition(AMPMatchResourceCondition.Value.valueOf(str2));
        } catch (IllegalArgumentException unused2) {
            LOGGER.severe("Found invalid rule match-resource condition value " + str2);
            return null;
        }
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public AMPExtension parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        AMPExtension.Status statusValueOf;
        AMPExtension.Action actionValueOf;
        String attributeValue = xmlPullParser.getAttributeValue(null, "from");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "to");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "status");
        if (attributeValue3 != null) {
            try {
                statusValueOf = AMPExtension.Status.valueOf(attributeValue3);
            } catch (IllegalArgumentException unused) {
                LOGGER.severe("Found invalid amp status " + attributeValue3);
            }
        } else {
            statusValueOf = null;
        }
        AMPExtension aMPExtension = new AMPExtension(attributeValue, attributeValue2, statusValueOf);
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "per-hop");
        if (attributeValue4 != null) {
            aMPExtension.setPerHop(Boolean.parseBoolean(attributeValue4));
        }
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(AMPExtension.Rule.ELEMENT)) {
                    String attributeValue5 = xmlPullParser.getAttributeValue(null, AMPExtension.Action.ATTRIBUTE_NAME);
                    AMPExtension.Condition conditionCreateCondition = createCondition(xmlPullParser.getAttributeValue(null, AMPExtension.Condition.ATTRIBUTE_NAME), xmlPullParser.getAttributeValue(null, "value"));
                    if (attributeValue5 != null) {
                        try {
                            actionValueOf = AMPExtension.Action.valueOf(attributeValue5);
                        } catch (IllegalArgumentException unused2) {
                            LOGGER.severe("Found invalid rule action value " + attributeValue5);
                        }
                        if (actionValueOf != null || conditionCreateCondition == null) {
                            LOGGER.severe("Rule is skipped because either it's action or it's condition is invalid");
                        } else {
                            aMPExtension.addRule(new AMPExtension.Rule(actionValueOf, conditionCreateCondition));
                        }
                    } else {
                        actionValueOf = null;
                        if (actionValueOf != null) {
                        }
                        LOGGER.severe("Rule is skipped because either it's action or it's condition is invalid");
                    }
                }
            } else if (next == 3 && xmlPullParser.getName().equals(AMPExtension.ELEMENT)) {
                z = true;
            }
        }
        return aMPExtension;
    }
}
