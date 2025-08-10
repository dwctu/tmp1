package org.jxmpp.stringprep.simple;

import com.broadcom.bt.util.io.IOUtils;
import java.util.Locale;
import kotlin.text.Typography;
import org.jxmpp.stringprep.XmppStringPrepUtil;
import org.jxmpp.stringprep.XmppStringprep;
import org.jxmpp.stringprep.XmppStringprepException;

/* loaded from: classes5.dex */
public class SimpleXmppStringprep implements XmppStringprep {
    private static final char[] LOCALPART_FURTHER_EXCLUDED_CHARACTERS = {Typography.quote, Typography.amp, '\'', IOUtils.DIR_SEPARATOR_UNIX, ',', Typography.less, Typography.greater, '@', ' '};
    private static SimpleXmppStringprep instance;

    private SimpleXmppStringprep() {
    }

    public static SimpleXmppStringprep getInstance() {
        if (instance == null) {
            instance = new SimpleXmppStringprep();
        }
        return instance;
    }

    public static void setup() {
        XmppStringPrepUtil.setXmppStringprep(getInstance());
    }

    private static String simpleStringprep(String str) {
        return str.toLowerCase(Locale.US);
    }

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String domainprep(String str) throws XmppStringprepException {
        return simpleStringprep(str);
    }

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String localprep(String str) throws XmppStringprepException {
        String strSimpleStringprep = simpleStringprep(str);
        for (char c : strSimpleStringprep.toCharArray()) {
            for (char c2 : LOCALPART_FURTHER_EXCLUDED_CHARACTERS) {
                if (c == c2) {
                    throw new XmppStringprepException(strSimpleStringprep, "Localpart must not contain '" + c2 + "'");
                }
            }
        }
        return strSimpleStringprep;
    }

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String resourceprep(String str) throws XmppStringprepException {
        return str;
    }
}
