package org.jivesoftware.smackx.delay.provider;

import java.text.ParseException;
import java.util.Date;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class LegacyDelayInformationProvider extends AbstractDelayInformationProvider {
    @Override // org.jivesoftware.smackx.delay.provider.AbstractDelayInformationProvider
    public Date parseDate(String str) throws ParseException {
        return XmppDateTime.parseDate(str);
    }
}
