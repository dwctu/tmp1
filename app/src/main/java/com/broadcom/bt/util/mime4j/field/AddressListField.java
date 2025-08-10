package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.field.address.AddressList;
import com.broadcom.bt.util.mime4j.field.address.parser.ParseException;

/* loaded from: classes.dex */
public class AddressListField extends Field {
    private AddressList addressList;
    private ParseException parseException;

    public static class Parser implements FieldParser {
        private static Log log = LogFactory.getLog(Parser.class);

        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) throws ParseException {
            AddressList addressList;
            ParseException parseException;
            try {
                parseException = null;
                addressList = AddressList.parse(str2);
            } catch (ParseException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + e.getMessage());
                }
                addressList = null;
                parseException = e;
            }
            return new AddressListField(str, str2, str3, addressList, parseException);
        }
    }

    public AddressListField(String str, String str2, String str3, AddressList addressList, ParseException parseException) {
        super(str, str2, str3);
        this.addressList = addressList;
        this.parseException = parseException;
    }

    public AddressList getAddressList() {
        return this.addressList;
    }

    public ParseException getParseException() {
        return this.parseException;
    }
}
