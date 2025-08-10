package org.jivesoftware.smackx.iqlast.packet;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class LastActivity extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:last";
    public long lastActivity;
    public String message;

    public static class Provider extends IQProvider<LastActivity> {
        @Override // org.jivesoftware.smack.provider.Provider
        public LastActivity parse(XmlPullParser xmlPullParser, int i) throws SmackException, XmlPullParserException {
            LastActivity lastActivity = new LastActivity();
            String attributeValue = xmlPullParser.getAttributeValue("", "seconds");
            if (attributeValue != null) {
                try {
                    lastActivity.setLastActivity(Long.parseLong(attributeValue));
                } catch (NumberFormatException e) {
                    throw new SmackException("Could not parse last activity number", e);
                }
            }
            try {
                lastActivity.setMessage(xmlPullParser.nextText());
                return lastActivity;
            } catch (IOException e2) {
                throw new SmackException(e2);
            }
        }
    }

    public LastActivity() {
        super("query", NAMESPACE);
        this.lastActivity = -1L;
        setType(IQ.Type.get);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        this.message = str;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optLongAttribute("seconds", Long.valueOf(this.lastActivity));
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public long getIdleTime() {
        return this.lastActivity;
    }

    public String getStatusMessage() {
        return this.message;
    }

    public void setLastActivity(long j) {
        this.lastActivity = j;
    }

    public LastActivity(String str) {
        this();
        setTo(str);
    }
}
