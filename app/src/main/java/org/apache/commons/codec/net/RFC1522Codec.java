package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: classes5.dex */
public abstract class RFC1522Codec {
    public static final String POSTFIX = "?=";
    public static final String PREFIX = "=?";
    public static final char SEP = '?';

    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int iIndexOf = str.indexOf(63, 2);
        if (iIndexOf == length) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String strSubstring = str.substring(2, iIndexOf);
        if (strSubstring.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i);
        if (iIndexOf2 == length) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String strSubstring2 = str.substring(i, iIndexOf2);
        if (getEncoding().equalsIgnoreCase(strSubstring2)) {
            int i2 = iIndexOf2 + 1;
            return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), strSubstring);
        }
        throw new DecoderException("This codec cannot decode " + strSubstring2 + " encoded content");
    }

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    public String encodeText(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return PREFIX + charset + SEP + getEncoding() + SEP + StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))) + POSTFIX;
    }

    public abstract String getEncoding();

    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return encodeText(str, Charset.forName(str2));
    }
}
