package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.decoder.DecoderUtil;

/* loaded from: classes.dex */
public class UnstructuredField extends Field {
    private String value;

    public static class Parser implements FieldParser {
        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            return new UnstructuredField(str, str2, str3, DecoderUtil.decodeEncodedWords(str2));
        }
    }

    public UnstructuredField(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.value = str4;
    }

    public String getValue() {
        return this.value;
    }
}
