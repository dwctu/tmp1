package org.jivesoftware.smackx.si.provider;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;
import org.jxmpp.util.XmppDateTime;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class StreamInitiationProvider extends IQProvider<StreamInitiation> {
    private static final Logger LOGGER = Logger.getLogger(StreamInitiationProvider.class.getName());

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public StreamInitiation parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException, NumberFormatException {
        String str;
        long j;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String str2 = "";
        String attributeValue = xmlPullParser2.getAttributeValue("", TtmlNode.ATTR_ID);
        String attributeValue2 = xmlPullParser2.getAttributeValue("", "mime-type");
        StreamInitiation streamInitiation = new StreamInitiation();
        DataFormProvider dataFormProvider = new DataFormProvider();
        DataForm dataForm = null;
        String attributeValue3 = null;
        String attributeValue4 = null;
        String attributeValue5 = null;
        String attributeValue6 = null;
        String strNextText = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            boolean z3 = z;
            String namespace = xmlPullParser.getNamespace();
            DataForm dataForm2 = dataForm;
            String str3 = attributeValue2;
            if (next == 2) {
                if (name.equals("file")) {
                    attributeValue4 = xmlPullParser2.getAttributeValue(str2, "name");
                    attributeValue3 = xmlPullParser2.getAttributeValue(str2, "size");
                    attributeValue5 = xmlPullParser2.getAttributeValue(str2, "hash");
                    attributeValue6 = xmlPullParser2.getAttributeValue(str2, "date");
                } else if (name.equals("desc")) {
                    strNextText = xmlPullParser.nextText();
                } else if (name.equals(ValidateElement.RangeValidateElement.METHOD)) {
                    z = z3;
                    dataForm = dataForm2;
                    attributeValue2 = str3;
                    z2 = true;
                } else {
                    if (name.equals("x") && namespace.equals("jabber:x:data")) {
                        dataForm = (DataForm) dataFormProvider.parse(xmlPullParser2);
                        z = z3;
                        attributeValue2 = str3;
                    }
                    str = str2;
                }
                z = z3;
                dataForm = dataForm2;
                attributeValue2 = str3;
            } else {
                if (next == 3) {
                    if (name.equals(StreamInitiation.ELEMENT)) {
                        dataForm = dataForm2;
                        attributeValue2 = str3;
                        z = true;
                    } else if (name.equals("file")) {
                        if (attributeValue3 == null || attributeValue3.trim().length() == 0) {
                            str = str2;
                            j = 0;
                        } else {
                            try {
                                str = str2;
                                j = Long.parseLong(attributeValue3);
                            } catch (NumberFormatException e) {
                                Logger logger = LOGGER;
                                Level level = Level.SEVERE;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to parse file size from ");
                                str = str2;
                                j = 0;
                                sb.append(0L);
                                logger.log(level, sb.toString(), (Throwable) e);
                            }
                        }
                        Date date = new Date();
                        if (attributeValue6 != null) {
                            try {
                                date = XmppDateTime.parseDate(attributeValue6);
                            } catch (ParseException unused) {
                            }
                        }
                        StreamInitiation.File file = new StreamInitiation.File(attributeValue4, j);
                        file.setHash(attributeValue5);
                        file.setDate(date);
                        file.setDesc(strNextText);
                        file.setRanged(z2);
                        streamInitiation.setFile(file);
                    }
                }
                str = str2;
            }
            xmlPullParser2 = xmlPullParser;
            str2 = str;
            z = z3;
            dataForm = dataForm2;
            attributeValue2 = str3;
        }
        streamInitiation.setSessionID(attributeValue);
        streamInitiation.setMimeType(attributeValue2);
        streamInitiation.setFeatureNegotiationForm(dataForm);
        return streamInitiation;
    }
}
