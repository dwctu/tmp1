package com.broadcom.bt.util.mime4j.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class Field {
    public static final String BCC = "Bcc";
    public static final String CC = "Cc";
    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DATE = "Date";
    public static final String FROM = "From";
    public static final String REPLY_TO = "Reply-To";
    public static final String RESENT_BCC = "Resent-Bcc";
    public static final String RESENT_CC = "Resent-Cc";
    public static final String RESENT_DATE = "Resent-Date";
    public static final String RESENT_FROM = "Resent-From";
    public static final String RESENT_SENDER = "Resent-Sender";
    public static final String RESENT_TO = "Resent-To";
    public static final String SENDER = "Sender";
    public static final String SUBJECT = "Subject";
    public static final String TO = "To";
    private final String body;
    private final String name;
    private final String raw;
    private static final String FIELD_NAME_PATTERN = "^([\\x21-\\x39\\x3b-\\x7e]+)[ \t]*:";
    private static final Pattern fieldNamePattern = Pattern.compile(FIELD_NAME_PATTERN);
    private static final DefaultFieldParser parser = new DefaultFieldParser();

    public Field(String str, String str2, String str3) {
        this.name = str;
        this.body = str2;
        this.raw = str3;
    }

    public static DefaultFieldParser getParser() {
        return parser;
    }

    public static Field parse(String str) {
        String strReplaceAll = str.replaceAll("\r|\n", "");
        Matcher matcher = fieldNamePattern.matcher(strReplaceAll);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid field in string");
        }
        String strGroup = matcher.group(1);
        String strSubstring = strReplaceAll.substring(matcher.end());
        if (strSubstring.length() > 0 && strSubstring.charAt(0) == ' ') {
            strSubstring = strSubstring.substring(1);
        }
        return parser.parse(strGroup, strSubstring, str);
    }

    public String getBody() {
        return this.body;
    }

    public String getName() {
        return this.name;
    }

    public String getRaw() {
        return this.raw;
    }

    public boolean isContentType() {
        return "Content-Type".equalsIgnoreCase(this.name);
    }

    public boolean isFrom() {
        return "From".equalsIgnoreCase(this.name);
    }

    public boolean isSubject() {
        return SUBJECT.equalsIgnoreCase(this.name);
    }

    public boolean isTo() {
        return TO.equalsIgnoreCase(this.name);
    }

    public String toString() {
        return this.raw;
    }
}
