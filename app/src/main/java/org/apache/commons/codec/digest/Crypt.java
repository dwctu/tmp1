package org.apache.commons.codec.digest;

import org.apache.commons.codec.Charsets;

/* loaded from: classes5.dex */
public class Crypt {
    public static String crypt(byte[] bArr) {
        return crypt(bArr, (String) null);
    }

    public static String crypt(byte[] bArr, String str) {
        return str == null ? Sha2Crypt.sha512Crypt(bArr) : str.startsWith(Sha2Crypt.SHA512_PREFIX) ? Sha2Crypt.sha512Crypt(bArr, str) : str.startsWith(Sha2Crypt.SHA256_PREFIX) ? Sha2Crypt.sha256Crypt(bArr, str) : str.startsWith(Md5Crypt.MD5_PREFIX) ? Md5Crypt.md5Crypt(bArr, str) : UnixCrypt.crypt(bArr, str);
    }

    public static String crypt(String str) {
        return crypt(str, (String) null);
    }

    public static String crypt(String str, String str2) {
        return crypt(str.getBytes(Charsets.UTF_8), str2);
    }
}
