package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.field.datetime.DateTime;
import com.broadcom.bt.util.mime4j.field.datetime.parser.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class DateTimeField extends Field {
    private Date date;
    private ParseException parseException;

    public static class Parser implements FieldParser {
        private static Log log = LogFactory.getLog(Parser.class);

        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            Date date;
            ParseException parseException;
            try {
                parseException = null;
                date = DateTime.parse(str2).getDate();
            } catch (ParseException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + e.getMessage());
                }
                date = null;
                parseException = e;
            }
            return new DateTimeField(str, str2, str3, date, parseException);
        }
    }

    public DateTimeField(String str, String str2, String str3, Date date, ParseException parseException) {
        super(str, str2, str3);
        this.date = date;
        this.parseException = parseException;
    }

    public Date getDate() {
        return this.date;
    }

    public ParseException getParseException() {
        return this.parseException;
    }
}
