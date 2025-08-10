package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.field.address.AddressList;
import com.broadcom.bt.util.mime4j.field.address.MailboxList;
import com.broadcom.bt.util.mime4j.field.address.parser.ParseException;

/* loaded from: classes.dex */
public class MailboxListField extends Field {
    private MailboxList mailboxList;
    private ParseException parseException;

    public static class Parser implements FieldParser {
        private static Log log = LogFactory.getLog(Parser.class);

        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            MailboxList mailboxListFlatten;
            ParseException parseException;
            try {
                parseException = null;
                mailboxListFlatten = AddressList.parse(str2).flatten();
            } catch (ParseException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + e.getMessage());
                }
                mailboxListFlatten = null;
                parseException = e;
            }
            return new MailboxListField(str, str2, str3, mailboxListFlatten, parseException);
        }
    }

    public MailboxListField(String str, String str2, String str3, MailboxList mailboxList, ParseException parseException) {
        super(str, str2, str3);
        this.mailboxList = mailboxList;
        this.parseException = parseException;
    }

    public MailboxList getMailboxList() {
        return this.mailboxList;
    }

    public ParseException getParseException() {
        return this.parseException;
    }
}
