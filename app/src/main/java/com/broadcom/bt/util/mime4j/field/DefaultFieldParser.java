package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.field.AddressListField;
import com.broadcom.bt.util.mime4j.field.ContentTransferEncodingField;
import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.broadcom.bt.util.mime4j.field.DateTimeField;
import com.broadcom.bt.util.mime4j.field.MailboxField;
import com.broadcom.bt.util.mime4j.field.MailboxListField;

/* loaded from: classes.dex */
public class DefaultFieldParser extends DelegatingFieldParser {
    public DefaultFieldParser() {
        setFieldParser(Field.CONTENT_TRANSFER_ENCODING, new ContentTransferEncodingField.Parser());
        setFieldParser("Content-Type", new ContentTypeField.Parser());
        DateTimeField.Parser parser = new DateTimeField.Parser();
        setFieldParser("Date", parser);
        setFieldParser(Field.RESENT_DATE, parser);
        MailboxListField.Parser parser2 = new MailboxListField.Parser();
        setFieldParser("From", parser2);
        setFieldParser(Field.RESENT_FROM, parser2);
        MailboxField.Parser parser3 = new MailboxField.Parser();
        setFieldParser(Field.SENDER, parser3);
        setFieldParser(Field.RESENT_SENDER, parser3);
        AddressListField.Parser parser4 = new AddressListField.Parser();
        setFieldParser(Field.TO, parser4);
        setFieldParser(Field.RESENT_TO, parser4);
        setFieldParser(Field.CC, parser4);
        setFieldParser(Field.RESENT_CC, parser4);
        setFieldParser(Field.BCC, parser4);
        setFieldParser(Field.RESENT_BCC, parser4);
        setFieldParser(Field.REPLY_TO, parser4);
    }
}
