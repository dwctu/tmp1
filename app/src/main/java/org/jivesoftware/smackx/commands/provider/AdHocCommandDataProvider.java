package org.jivesoftware.smackx.commands.provider;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.AdHocCommandNote;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class AdHocCommandDataProvider extends IQProvider<AdHocCommandData> {

    public static class BadActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badAction);
        }
    }

    public static class BadLocaleError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badLocale);
        }
    }

    public static class BadPayloadError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badPayload);
        }
    }

    public static class BadSessionIDError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badSessionid);
        }
    }

    public static class MalformedActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.malformedAction);
        }
    }

    public static class SessionExpiredError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.sessionExpired);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public AdHocCommandData parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        DataFormProvider dataFormProvider = new DataFormProvider();
        adHocCommandData.setSessionID(xmlPullParser.getAttributeValue("", "sessionid"));
        adHocCommandData.setNode(xmlPullParser.getAttributeValue("", "node"));
        String attributeValue = xmlPullParser.getAttributeValue("", "status");
        AdHocCommand.Status status = AdHocCommand.Status.executing;
        if (status.toString().equalsIgnoreCase(attributeValue)) {
            adHocCommandData.setStatus(status);
        } else {
            AdHocCommand.Status status2 = AdHocCommand.Status.completed;
            if (status2.toString().equalsIgnoreCase(attributeValue)) {
                adHocCommandData.setStatus(status2);
            } else {
                AdHocCommand.Status status3 = AdHocCommand.Status.canceled;
                if (status3.toString().equalsIgnoreCase(attributeValue)) {
                    adHocCommandData.setStatus(status3);
                }
            }
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("", AMPExtension.Action.ATTRIBUTE_NAME);
        if (attributeValue2 != null) {
            AdHocCommand.Action actionValueOf = AdHocCommand.Action.valueOf(attributeValue2);
            if (actionValueOf == null || actionValueOf.equals(AdHocCommand.Action.unknown)) {
                adHocCommandData.setAction(AdHocCommand.Action.unknown);
            } else {
                adHocCommandData.setAction(actionValueOf);
            }
        }
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            String namespace = xmlPullParser.getNamespace();
            if (next == 2) {
                if (xmlPullParser.getName().equals("actions")) {
                    String attributeValue3 = xmlPullParser.getAttributeValue("", "execute");
                    if (attributeValue3 != null) {
                        adHocCommandData.setExecuteAction(AdHocCommand.Action.valueOf(attributeValue3));
                    }
                } else if (xmlPullParser.getName().equals("next")) {
                    adHocCommandData.addAction(AdHocCommand.Action.next);
                } else if (xmlPullParser.getName().equals("complete")) {
                    adHocCommandData.addAction(AdHocCommand.Action.complete);
                } else if (xmlPullParser.getName().equals("prev")) {
                    adHocCommandData.addAction(AdHocCommand.Action.prev);
                } else if (name.equals("x") && namespace.equals("jabber:x:data")) {
                    adHocCommandData.setForm((DataForm) dataFormProvider.parse(xmlPullParser));
                } else if (xmlPullParser.getName().equals("note")) {
                    adHocCommandData.addNote(new AdHocCommandNote(AdHocCommandNote.Type.valueOf(xmlPullParser.getAttributeValue("", "type")), xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("error")) {
                    adHocCommandData.setError(PacketParserUtils.parseError(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("command")) {
                z = true;
            }
        }
        return adHocCommandData;
    }
}
