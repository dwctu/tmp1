package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.field.address.AddressList;
import com.broadcom.bt.util.mime4j.field.address.Mailbox;
import com.broadcom.bt.util.mime4j.field.address.MailboxList;
import com.broadcom.bt.util.mime4j.field.address.parser.ParseException;

/* loaded from: classes.dex */
public class MailboxField extends Field {
    private final Mailbox mailbox;
    private final ParseException parseException;

    public static class Parser implements FieldParser {
        private static Log log = LogFactory.getLog(Parser.class);

        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            Mailbox mailbox;
            ParseException parseException;
            try {
                MailboxList mailboxListFlatten = AddressList.parse(str2).flatten();
                parseException = null;
                mailbox = mailboxListFlatten.size() > 0 ? mailboxListFlatten.get(0) : null;
            } catch (ParseException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + e.getMessage());
                }
                mailbox = null;
                parseException = e;
            }
            return new MailboxField(str, str2, str3, mailbox, parseException);
        }
    }

    public MailboxField(String str, String str2, String str3, Mailbox mailbox, ParseException parseException) {
        super(str, str2, str3);
        this.mailbox = mailbox;
        this.parseException = parseException;
    }

    public Mailbox getMailbox() {
        return this.mailbox;
    }

    public ParseException getParseException() {
        return this.parseException;
    }
}
