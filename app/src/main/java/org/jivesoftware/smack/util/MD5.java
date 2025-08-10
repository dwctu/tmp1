package org.jivesoftware.smack.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes5.dex */
public class MD5 {
    private static MessageDigest MD5_DIGEST;

    static {
        try {
            MD5_DIGEST = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static synchronized byte[] bytes(byte[] bArr) {
        return MD5_DIGEST.digest(bArr);
    }

    public static String hex(byte[] bArr) {
        return StringUtils.encodeHex(bytes(bArr));
    }

    public static byte[] bytes(String str) {
        return bytes(StringUtils.toBytes(str));
    }

    public static String hex(String str) {
        return hex(StringUtils.toBytes(str));
    }
}
