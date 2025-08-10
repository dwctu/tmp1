package org.jxmpp.stringprep;

/* loaded from: classes5.dex */
public class XmppStringprepException extends Exception {
    private static final long serialVersionUID = -8491853210107124624L;
    private final String causingString;

    public XmppStringprepException(String str, Exception exc) {
        super("XmppStringprepException caused by '" + str + "': " + exc, exc);
        this.causingString = str;
    }

    public String getCausingString() {
        return this.causingString;
    }

    public XmppStringprepException(String str, String str2) {
        super(str2);
        this.causingString = str;
    }
}
