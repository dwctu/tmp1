package org.jivesoftware.smack.util;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.packet.DefaultExtensionElement;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ErrorIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StartTls;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.packet.UnparsedIQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class PacketParserUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    private static final Logger LOGGER = Logger.getLogger(PacketParserUtils.class.getName());
    private static final XmlPullParserFactory XML_PULL_PARSER_FACTORY;
    public static final boolean XML_PULL_PARSER_SUPPORTS_ROUNDTRIP;

    /* renamed from: org.jivesoftware.smack.util.PacketParserUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        boolean z = false;
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            XML_PULL_PARSER_FACTORY = xmlPullParserFactoryNewInstance;
            try {
                xmlPullParserFactoryNewInstance.newPullParser().setFeature(FEATURE_XML_ROUNDTRIP, true);
                z = true;
            } catch (XmlPullParserException e) {
                LOGGER.log(Level.FINEST, "XmlPullParser does not support XML_ROUNDTRIP", (Throwable) e);
            }
            XML_PULL_PARSER_SUPPORTS_ROUNDTRIP = z;
        } catch (XmlPullParserException e2) {
            throw new AssertionError(e2);
        }
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        addExtensionElement(stanza, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace());
    }

    public static void addExtensionTextElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, SmackException, IOException {
        collection.add(parseExtensionTextElement(str, str2, xmlPullParser));
    }

    @Deprecated
    public static void addPacketExtension(Stanza stanza, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        addExtensionElement(stanza, xmlPullParser);
    }

    private static String getLanguageAttribute(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static XmlPullParser getParserFor(String str) throws XmlPullParserException, IOException {
        return getParserFor(new StringReader(str));
    }

    public static XmlPullParser newXmppParser() throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        if (XML_PULL_PARSER_SUPPORTS_ROUNDTRIP) {
            try {
                xmlPullParserNewPullParser.setFeature(FEATURE_XML_ROUNDTRIP, true);
            } catch (XmlPullParserException e) {
                LOGGER.log(Level.SEVERE, "XmlPullParser does not support XML_ROUNDTRIP, although it was first determined to be supported", (Throwable) e);
            }
        }
        return xmlPullParserNewPullParser;
    }

    public static Compress.Feature parseCompressionFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        LinkedList linkedList = new LinkedList();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(FirebaseAnalytics.Param.METHOD)) {
                    linkedList.add(xmlPullParser.nextText());
                }
            } else if (next != 3) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals(Compress.Feature.ELEMENT) && xmlPullParser.getDepth() == depth) {
                    return new Compress.Feature(linkedList);
                }
            }
        }
    }

    public static CharSequence parseContent(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.isEmptyElementTag()) {
            return "";
        }
        xmlPullParser.next();
        return parseContentDepth(xmlPullParser, xmlPullParser.getDepth(), false);
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, i, false);
    }

    private static CharSequence parseContentDepthWithRoundtrip(XmlPullParser xmlPullParser, int i, boolean z) throws XmlPullParserException, IOException {
        StringBuilder sb = new StringBuilder();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2 || !xmlPullParser.isEmptyElementTag()) {
                sb.append(xmlPullParser.getText());
            }
            if (eventType == 3 && xmlPullParser.getDepth() <= i) {
                return sb;
            }
            eventType = xmlPullParser.next();
        }
    }

    private static CharSequence parseContentDepthWithoutRoundtrip(XmlPullParser xmlPullParser, int i, boolean z) throws XmlPullParserException, IOException {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        int eventType = xmlPullParser.getEventType();
        String name = null;
        boolean z2 = false;
        while (true) {
            if (eventType == 2) {
                xmlStringBuilder.halfOpenElement(xmlPullParser.getName());
                if (name == null || z) {
                    String namespace = xmlPullParser.getNamespace();
                    if (StringUtils.isNotEmpty(namespace)) {
                        xmlStringBuilder.attribute("xmlns", namespace);
                        name = xmlPullParser.getName();
                    }
                }
                for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                    xmlStringBuilder.attribute(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                }
                if (xmlPullParser.isEmptyElementTag()) {
                    xmlStringBuilder.closeEmptyElement();
                    z2 = true;
                } else {
                    xmlStringBuilder.rightAngleBracket();
                }
            } else if (eventType == 3) {
                if (z2) {
                    z2 = false;
                } else {
                    xmlStringBuilder.closeElement(xmlPullParser.getName());
                }
                if (name != null && name.equals(xmlPullParser.getName())) {
                    name = null;
                }
                if (xmlPullParser.getDepth() <= i) {
                    return xmlStringBuilder;
                }
            } else if (eventType == 4) {
                xmlStringBuilder.append((CharSequence) xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
        }
    }

    public static Map<String, String> parseDescriptiveTexts(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(getLanguageAttribute(xmlPullParser), xmlPullParser.nextText());
        return map;
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseElement(xmlPullParser, false);
    }

    public static String parseElementText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text = "";
        if (!xmlPullParser.isEmptyElementTag()) {
            int next = xmlPullParser.next();
            if (next != 4) {
                if (next == 3) {
                    return "";
                }
                throw new XmlPullParserException("Non-empty element tag not followed by text, while Mixed Content (XML 3.2.2) is disallowed");
            }
            text = xmlPullParser.getText();
            if (xmlPullParser.next() != 3) {
                throw new XmlPullParserException("Non-empty element tag contains child-elements, while Mixed Content (XML 3.2.2) is disallowed");
            }
        }
        return text;
    }

    public static XMPPError parseError(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        XMPPError.Type typeFromString = XMPPError.Type.fromString(xmlPullParser.getAttributeValue("", "type"));
        String attributeValue = xmlPullParser.getAttributeValue("", "by");
        XMPPError.Condition conditionFromString = null;
        String strNextText = null;
        Map<String, String> descriptiveTexts = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (namespace.equals(XMPPError.NAMESPACE)) {
                    name.hashCode();
                    if (name.equals("text")) {
                        descriptiveTexts = parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
                    } else {
                        conditionFromString = XMPPError.Condition.fromString(name);
                        if (!xmlPullParser.isEmptyElementTag()) {
                            strNextText = xmlPullParser.nextText();
                        }
                    }
                } else {
                    addExtensionElement(arrayList, xmlPullParser, name, namespace);
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new XMPPError(conditionFromString, strNextText, attributeValue, typeFromString, descriptiveTexts, arrayList);
            }
        }
    }

    public static ExtensionElement parseExtensionElement(String str, String str2, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(str, str2);
        if (extensionProvider != null) {
            return extensionProvider.parse(xmlPullParser);
        }
        int depth = xmlPullParser.getDepth();
        DefaultExtensionElement defaultExtensionElement = new DefaultExtensionElement(str, str2);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (xmlPullParser.isEmptyElementTag()) {
                    defaultExtensionElement.setValue(name, "");
                } else if (xmlPullParser.next() == 4) {
                    defaultExtensionElement.setValue(name, xmlPullParser.getText());
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return defaultExtensionElement;
            }
        }
    }

    public static ExtensionElement parseExtensionTextElement(String str, String str2, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(str, str2);
        if (extensionProvider != null) {
            return extensionProvider.parse(xmlPullParser);
        }
        int depth = xmlPullParser.getDepth();
        DefaultExtensionElement defaultExtensionElement = new DefaultExtensionElement(str, str2);
        while (true) {
            int next = xmlPullParser.next();
            if (next != 3) {
                if (next == 4) {
                    String text = xmlPullParser.getText();
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    defaultExtensionElement.setValue(str, text);
                }
            } else if (xmlPullParser.getDepth() == depth) {
                return defaultExtensionElement;
            }
        }
    }

    public static IQ parseIQ(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue("", "to");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue3 = xmlPullParser.getAttributeValue("", TtmlNode.ATTR_ID);
        IQ.Type typeFromString = IQ.Type.fromString(xmlPullParser.getAttributeValue("", "type"));
        IQ errorIQ = null;
        XMPPError error = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                name.hashCode();
                if (name.equals("error")) {
                    error = parseError(xmlPullParser);
                } else {
                    IQProvider<IQ> iQProvider = ProviderManager.getIQProvider(name, namespace);
                    errorIQ = iQProvider != null ? iQProvider.parse(xmlPullParser) : new UnparsedIQ(name, namespace, parseElement(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                break;
            }
        }
        if (errorIQ == null) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[typeFromString.ordinal()];
            if (i == 1) {
                errorIQ = new ErrorIQ(error);
            } else if (i == 2) {
                errorIQ = new EmptyResultIQ();
            }
        }
        errorIQ.setStanzaId(attributeValue3);
        errorIQ.setTo(attributeValue);
        errorIQ.setFrom(attributeValue2);
        errorIQ.setType(typeFromString);
        errorIQ.setError(error);
        return errorIQ;
    }

    public static Collection<String> parseMechanisms(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("mechanism")) {
                    arrayList.add(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(Mechanisms.ELEMENT)) {
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jivesoftware.smack.packet.Message parseMessage(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, org.jivesoftware.smack.SmackException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.PacketParserUtils.parseMessage(org.xmlpull.v1.XmlPullParser):org.jivesoftware.smack.packet.Message");
    }

    @Deprecated
    public static ExtensionElement parsePacketExtension(String str, String str2, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        return parseExtensionElement(str, str2, xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.jivesoftware.smack.packet.Presence parsePresence(org.xmlpull.v1.XmlPullParser r8) throws org.xmlpull.v1.XmlPullParserException, org.jivesoftware.smack.SmackException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.PacketParserUtils.parsePresence(org.xmlpull.v1.XmlPullParser):org.jivesoftware.smack.packet.Presence");
    }

    public static SaslStreamElements.SASLFailure parseSASLFailure(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        Map<String, String> descriptiveTexts = null;
        String name = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3 && xmlPullParser.getDepth() == depth) {
                    return new SaslStreamElements.SASLFailure(name, descriptiveTexts);
                }
            } else if (xmlPullParser.getName().equals("text")) {
                descriptiveTexts = parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
            } else {
                name = xmlPullParser.getName();
            }
        }
    }

    public static Session.Feature parseSessionFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        boolean z = false;
        if (!xmlPullParser.isEmptyElementTag()) {
            while (true) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    if (name.equals(Session.Feature.OPTIONAL_ELEMENT)) {
                        z = true;
                    }
                } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                    break;
                }
            }
        }
        return new Session.Feature(z);
    }

    public static Stanza parseStanza(String str) throws XmlPullParserException, SmackException, IOException {
        return parseStanza(getParserFor(str));
    }

    public static StartTls parseStartTlsFeature(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z = false;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("required")) {
                    z = true;
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new StartTls(z);
            }
        }
    }

    public static StreamError parseStreamError(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = new ArrayList();
        StreamError.Condition conditionFromString = null;
        String strNextText = null;
        Map<String, String> descriptiveTexts = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                namespace.hashCode();
                if (namespace.equals("jabber:client")) {
                    name.hashCode();
                    if (name.equals("bodyconflict")) {
                        String str = "name:" + name + ", namespace:" + namespace;
                        addExtensionTextElement(arrayList, xmlPullParser, name, namespace);
                    }
                } else if (namespace.equals(StreamError.NAMESPACE)) {
                    name.hashCode();
                    if (name.equals("text")) {
                        descriptiveTexts = parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
                    } else {
                        conditionFromString = StreamError.Condition.fromString(name);
                        if (!xmlPullParser.isEmptyElementTag()) {
                            strNextText = xmlPullParser.nextText();
                        }
                    }
                } else {
                    addExtensionElement(arrayList, xmlPullParser, name, namespace);
                }
            } else if (next == 3 && xmlPullParser.getDepth() == depth) {
                return new StreamError(conditionFromString, strNextText, descriptiveTexts, arrayList);
            }
        }
    }

    @Deprecated
    public static void addPacketExtension(Stanza stanza, XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, SmackException, IOException {
        addExtensionElement(stanza, xmlPullParser, str, str2);
    }

    public static XmlPullParser getParserFor(Reader reader) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewXmppParser = newXmppParser(reader);
        for (int eventType = xmlPullParserNewXmppParser.getEventType(); eventType != 2; eventType = xmlPullParserNewXmppParser.next()) {
            if (eventType == 1) {
                throw new IllegalArgumentException("Document contains no start tag");
            }
        }
        return xmlPullParserNewXmppParser;
    }

    public static CharSequence parseContentDepth(XmlPullParser xmlPullParser, int i, boolean z) throws XmlPullParserException, IOException {
        return xmlPullParser.getFeature(FEATURE_XML_ROUNDTRIP) ? parseContentDepthWithRoundtrip(xmlPullParser, i, z) : parseContentDepthWithoutRoundtrip(xmlPullParser, i, z);
    }

    public static CharSequence parseElement(XmlPullParser xmlPullParser, boolean z) throws XmlPullParserException, IOException {
        return parseContentDepth(xmlPullParser, xmlPullParser.getDepth(), z);
    }

    public static Stanza parseStanza(XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        String name;
        ParserUtils.assertAtStartTag(xmlPullParser);
        name = xmlPullParser.getName();
        name.hashCode();
        switch (name) {
            case "presence":
                return parsePresence(xmlPullParser);
            case "iq":
                return parseIQ(xmlPullParser);
            case "message":
                return parseMessage(xmlPullParser);
            default:
                throw new IllegalArgumentException("Can only parse message, iq or presence, not " + name);
        }
    }

    public static void addExtensionElement(Stanza stanza, XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, SmackException, IOException {
        stanza.addExtension(parseExtensionElement(str, str2, xmlPullParser));
    }

    @Deprecated
    public static void addPacketExtension(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        addExtensionElement(collection, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace());
    }

    @Deprecated
    public static void addPacketExtension(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, SmackException, IOException {
        addExtensionElement(collection, xmlPullParser, str, str2);
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        addExtensionElement(collection, xmlPullParser, xmlPullParser.getName(), xmlPullParser.getNamespace());
    }

    public static void addExtensionElement(Collection<ExtensionElement> collection, XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, SmackException, IOException {
        collection.add(parseExtensionElement(str, str2, xmlPullParser));
    }

    public static XmlPullParser getParserFor(String str, String str2) throws XmlPullParserException, IOException {
        XmlPullParser parserFor = getParserFor(str);
        while (true) {
            int eventType = parserFor.getEventType();
            String name = parserFor.getName();
            if (eventType == 2 && name.equals(str2)) {
                return parserFor;
            }
            if (eventType != 1) {
                parserFor.next();
            } else {
                throw new IllegalArgumentException("Could not find start tag '" + str2 + "' in stanza: " + str);
            }
        }
    }

    public static XmlPullParser newXmppParser(Reader reader) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewXmppParser = newXmppParser();
        xmlPullParserNewXmppParser.setInput(reader);
        return xmlPullParserNewXmppParser;
    }
}
