package com.broadcom.bt.util.mime4j.field;

/* loaded from: classes.dex */
public class ContentTransferEncodingField extends Field {
    public static final String ENC_7BIT = "7bit";
    public static final String ENC_8BIT = "8bit";
    public static final String ENC_BASE64 = "base64";
    public static final String ENC_BINARY = "binary";
    public static final String ENC_QUOTED_PRINTABLE = "quoted-printable";
    private String encoding;

    public static class Parser implements FieldParser {
        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            return new ContentTransferEncodingField(str, str2, str3, str2.trim().toLowerCase());
        }
    }

    public ContentTransferEncodingField(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.encoding = str4;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public static String getEncoding(ContentTransferEncodingField contentTransferEncodingField) {
        return (contentTransferEncodingField == null || contentTransferEncodingField.getEncoding().length() == 0) ? ENC_7BIT : contentTransferEncodingField.getEncoding();
    }
}
