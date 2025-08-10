package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.field.UnstructuredField;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DelegatingFieldParser implements FieldParser {
    private Map parsers = new HashMap();
    private FieldParser defaultParser = new UnstructuredField.Parser();

    public FieldParser getParser(String str) {
        FieldParser fieldParser = (FieldParser) this.parsers.get(str.toLowerCase());
        return fieldParser == null ? this.defaultParser : fieldParser;
    }

    @Override // com.broadcom.bt.util.mime4j.field.FieldParser
    public Field parse(String str, String str2, String str3) {
        return getParser(str).parse(str, str2, str3);
    }

    public void setFieldParser(String str, FieldParser fieldParser) {
        this.parsers.put(str.toLowerCase(), fieldParser);
    }
}
