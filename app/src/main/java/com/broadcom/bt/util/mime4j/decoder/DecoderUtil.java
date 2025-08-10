package com.broadcom.bt.util.mime4j.decoder;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import com.broadcom.bt.util.mime4j.util.CharsetUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.net.RFC1522Codec;

/* loaded from: classes.dex */
public class DecoderUtil {
    private static Log log = LogFactory.getLog(DecoderUtil.class);

    public static String decodeB(String str, String str2) throws UnsupportedEncodingException {
        return new String(decodeBase64(str), str2);
    }

    public static byte[] decodeBase64(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Base64InputStream base64InputStream = new Base64InputStream(new ByteArrayInputStream(str.getBytes("US-ASCII")));
            while (true) {
                int i = base64InputStream.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            }
        } catch (IOException e) {
            log.error(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decodeBaseQuotedPrintable(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            QuotedPrintableInputStream quotedPrintableInputStream = new QuotedPrintableInputStream(new ByteArrayInputStream(str.getBytes("US-ASCII")));
            while (true) {
                int i = quotedPrintableInputStream.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            }
        } catch (IOException e) {
            log.error(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String decodeEncodedWord(String str, int i, int i2) {
        int i3;
        int iIndexOf;
        int i4 = i + 2;
        int iIndexOf2 = str.indexOf(63, i4);
        int i5 = i2 - 2;
        if (iIndexOf2 == i5 || (iIndexOf = str.indexOf(63, (i3 = iIndexOf2 + 1))) == i5) {
            return null;
        }
        String strSubstring = str.substring(i4, iIndexOf2);
        String strSubstring2 = str.substring(i3, iIndexOf);
        String strSubstring3 = str.substring(iIndexOf + 1, i5);
        String javaCharset = CharsetUtil.toJavaCharset(strSubstring);
        if (javaCharset == null) {
            if (log.isWarnEnabled()) {
                log.warn("MIME charset '" + strSubstring + "' in encoded word '" + str.substring(i, i2) + "' doesn't have a corresponding Java charset");
            }
            return null;
        }
        if (!CharsetUtil.isDecodingSupported(javaCharset)) {
            if (log.isWarnEnabled()) {
                log.warn("Current JDK doesn't support decoding of charset '" + javaCharset + "' (MIME charset '" + strSubstring + "' in encoded word '" + str.substring(i, i2) + "')");
            }
            return null;
        }
        if (strSubstring3.length() == 0) {
            if (log.isWarnEnabled()) {
                log.warn("Missing encoded text in encoded word: '" + str.substring(i, i2) + "'");
            }
            return null;
        }
        try {
            if (strSubstring2.equalsIgnoreCase("Q")) {
                return decodeQ(strSubstring3, javaCharset);
            }
            if (strSubstring2.equalsIgnoreCase("B")) {
                return decodeB(strSubstring3, javaCharset);
            }
            if (log.isWarnEnabled()) {
                log.warn("Warning: Unknown encoding in encoded word '" + str.substring(i, i2) + "'");
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            if (log.isWarnEnabled()) {
                log.warn("Unsupported encoding in encoded word '" + str.substring(i, i2) + "'", e);
            }
            return null;
        } catch (RuntimeException e2) {
            if (log.isWarnEnabled()) {
                log.warn("Could not decode encoded word '" + str.substring(i, i2) + "'", e2);
            }
            return null;
        }
    }

    public static String decodeEncodedWords(String str) {
        int iIndexOf;
        if (str.indexOf(RFC1522Codec.PREFIX) == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        while (true) {
            int iIndexOf2 = str.indexOf(RFC1522Codec.PREFIX, i);
            int i2 = iIndexOf2 + 2;
            if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(63, str.indexOf(63, i2 + 2) + 1)) != -1) {
                i2 = iIndexOf + 1;
            }
            int iIndexOf3 = iIndexOf2 == -1 ? -1 : str.indexOf(RFC1522Codec.POSTFIX, i2);
            if (iIndexOf3 == -1) {
                break;
            }
            int i3 = iIndexOf3 + 2;
            String strSubstring = str.substring(i, iIndexOf2);
            String strDecodeEncodedWord = decodeEncodedWord(str, iIndexOf2, i3);
            if (strDecodeEncodedWord == null) {
                sb.append(strSubstring);
                sb.append(str.substring(iIndexOf2, i3));
            } else {
                if (!z || !CharsetUtil.isWhitespace(strSubstring)) {
                    sb.append(strSubstring);
                }
                sb.append(strDecodeEncodedWord);
            }
            z = strDecodeEncodedWord != null;
            i = i3;
        }
        if (i == 0) {
            return str;
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    public static String decodeQ(String str, String str2) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '_') {
                stringBuffer.append("=20");
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return new String(decodeBaseQuotedPrintable(stringBuffer.toString()), str2);
    }
}
