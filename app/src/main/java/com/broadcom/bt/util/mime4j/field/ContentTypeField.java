package com.broadcom.bt.util.mime4j.field;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.field.contenttype.parser.ContentTypeParser;
import com.broadcom.bt.util.mime4j.field.contenttype.parser.ParseException;
import com.broadcom.bt.util.mime4j.field.contenttype.parser.TokenMgrError;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ContentTypeField extends Field {
    public static final String PARAM_BOUNDARY = "boundary";
    public static final String PARAM_CHARSET = "charset";
    public static final String TYPE_MESSAGE_RFC822 = "message/rfc822";
    public static final String TYPE_MULTIPART_DIGEST = "multipart/digest";
    public static final String TYPE_MULTIPART_PREFIX = "multipart/";
    public static final String TYPE_TEXT_PLAIN = "text/plain";
    private String mimeType;
    private Map parameters;
    private ParseException parseException;

    public static class Parser implements FieldParser {
        private static Log log = LogFactory.getLog(Parser.class);

        @Override // com.broadcom.bt.util.mime4j.field.FieldParser
        public Field parse(String str, String str2, String str3) {
            ParseException parseException;
            String lowerCase = "";
            ContentTypeParser contentTypeParser = new ContentTypeParser(new StringReader(str2));
            HashMap map = null;
            try {
                contentTypeParser.parseAll();
                parseException = null;
            } catch (ParseException e) {
                parseException = e;
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + parseException.getMessage());
                }
            } catch (TokenMgrError e2) {
                if (log.isDebugEnabled()) {
                    log.debug("Parsing value '" + str2 + "': " + e2.getMessage());
                }
                parseException = new ParseException(e2.getMessage());
            }
            try {
                String type = contentTypeParser.getType();
                String subType = contentTypeParser.getSubType();
                if (type != null && subType != null) {
                    lowerCase = (type + "/" + contentTypeParser.getSubType()).toLowerCase();
                    ArrayList paramNames = contentTypeParser.getParamNames();
                    ArrayList paramValues = contentTypeParser.getParamValues();
                    if (paramNames != null && paramValues != null) {
                        for (int i = 0; i < paramNames.size() && i < paramValues.size(); i++) {
                            if (map == null) {
                                map = new HashMap((int) ((paramNames.size() * 1.3d) + 1.0d));
                            }
                            map.put(((String) paramNames.get(i)).toLowerCase(), (String) paramValues.get(i));
                        }
                    }
                }
            } catch (NullPointerException unused) {
            }
            return new ContentTypeField(str, str2, str3, lowerCase, map, parseException);
        }
    }

    public ContentTypeField(String str, String str2, String str3, String str4, Map map, ParseException parseException) {
        super(str, str2, str3);
        this.mimeType = "";
        this.parameters = null;
        this.mimeType = str4;
        this.parameters = map;
        this.parseException = parseException;
    }

    public String getBoundary() {
        return getParameter(PARAM_BOUNDARY);
    }

    public String getCharset() {
        return getParameter(PARAM_CHARSET);
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getParameter(String str) {
        Map map = this.parameters;
        if (map != null) {
            return (String) map.get(str.toLowerCase());
        }
        return null;
    }

    public Map getParameters() {
        Map map = this.parameters;
        return map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
    }

    public ParseException getParseException() {
        return this.parseException;
    }

    public boolean isMimeType(String str) {
        return this.mimeType.equalsIgnoreCase(str);
    }

    public boolean isMultipart() {
        return this.mimeType.startsWith("multipart/");
    }

    public static String getCharset(ContentTypeField contentTypeField) {
        return (contentTypeField == null || contentTypeField.getCharset() == null || contentTypeField.getCharset().length() <= 0) ? "us-ascii" : contentTypeField.getCharset();
    }

    public static String getMimeType(ContentTypeField contentTypeField, ContentTypeField contentTypeField2) {
        return (contentTypeField == null || contentTypeField.getMimeType().length() == 0 || (contentTypeField.isMultipart() && contentTypeField.getBoundary() == null)) ? (contentTypeField2 == null || !contentTypeField2.isMimeType(TYPE_MULTIPART_DIGEST)) ? "text/plain" : TYPE_MESSAGE_RFC822 : contentTypeField.getMimeType();
    }
}
