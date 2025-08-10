package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class BaseKeyUtil {
    private static final String a = "BaseKeyUtil";
    private static final int b = 16;
    private static final int c = 16;
    private static final int d = 10000;

    private static int a(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    private static boolean a(int i) {
        return i >= 16;
    }

    private static boolean a(int i, byte[] bArr) {
        return a(i) & a(bArr);
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i, z));
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) throws UnsupportedEncodingException {
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] bArrHexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int iA = a(bArrHexStr2ByteArray.length, bArrHexStr2ByteArray2.length, bArrHexStr2ByteArray3.length);
        if (!a(iA, bArr)) {
            throw new IllegalArgumentException("key length must be more than 128bit.");
        }
        char[] cArr = new char[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            cArr[i2] = (char) ((bArrHexStr2ByteArray[i2] ^ bArrHexStr2ByteArray2[i2]) ^ bArrHexStr2ByteArray3[i2]);
        }
        if (z) {
            b.c(a, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, 10000, i * 8);
        }
        b.c(a, "exportRootKey: sha1");
        return PBKDF2.pbkdf2(cArr, bArr, 10000, i * 8);
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i, boolean z) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i, z);
    }
}
