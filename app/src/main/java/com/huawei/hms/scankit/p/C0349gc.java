package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: ErrorCorrection.java */
/* renamed from: com.huawei.hms.scankit.p.gc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0349gc {
    private static final int[] a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 134, PsExtractor.VIDEO_STREAM_MASK, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, DownloaderService.STATUS_WAITING_TO_RETRY, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, DownloaderService.STATUS_WAITING_FOR_NETWORK, 100, 39, 188, 75, 66, 61, 241, 213, 109, TsExtractor.TS_STREAM_TYPE_AC3, 94, 254, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 48, 90, 188}, new int[]{15, DownloaderService.STATUS_WAITING_FOR_NETWORK, 244, 9, 233, 71, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 2, 188, 160, 153, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 253, 79, 108, 82, 27, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 186, 172}, new int[]{52, DownloaderService.STATUS_PENDING, 88, 205, 109, 39, 176, 21, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, DownloaderService.STATUS_QUEUED_FOR_WIFI, 251, 223, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 120, 151, 233, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 95, 119, 115, 44, 175, 184, 59, 25, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 98, 81, 112}, new int[]{77, 193, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 238, 231, 205, 188, 237, 87, 191, 106, 16, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, PsExtractor.VIDEO_STREAM_MASK, 82, 44, 176, 87, Opcodes.NEW, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 160, 175, 69, 213, 92, 253, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 159, 36, 223, 38, 200, 132, 54, 228, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 218, 234, 117, 203, 29, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 238, 22, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 201, 117, 62, 207, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 13, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 245, 127, 67, 247, 28, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 43, 203, 107, 233, 53, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 46}, new int[]{242, 93, 169, 50, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 210, 39, 118, 202, 188, 201, PsExtractor.PRIVATE_STREAM_1, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 108, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, 37, 185, 112, 134, 230, 245, 63, DownloaderService.STATUS_QUEUED_FOR_WIFI, DownloaderService.STATUS_PENDING, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 89, 251, 149, 159, 56, 89, 33, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 244, 154, 36, 73, 127, 213, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 248, 180, 234, DownloaderService.STATUS_QUEUED_FOR_WIFI, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 153, 185, 202, 167, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 25, 220, 232, 96, 210, 231, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] c = new int[256];
    private static final int[] d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            try {
                int[] iArr = d;
                if (com.huawei.hms.scankit.util.b.a(iArr, i2)) {
                    iArr[i2] = i;
                }
                int[] iArr2 = c;
                if (com.huawei.hms.scankit.util.b.a(iArr2, i)) {
                    iArr2[i] = i2;
                }
                i *= 2;
                if (i >= 256) {
                    i ^= 301;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw e;
            }
        }
    }

    public static String a(String str, C0357ic c0357ic) throws Exception {
        if (str.length() != c0357ic.a()) {
            try {
                throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
            } catch (Exception e) {
                throw e;
            }
        }
        StringBuilder sb = new StringBuilder(c0357ic.a() + c0357ic.b());
        sb.append(str);
        int iC = c0357ic.c();
        if (iC == 1) {
            sb.append(a(str, c0357ic.b()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[iC];
            int[] iArr2 = new int[iC];
            int[] iArr3 = new int[iC];
            int i = 0;
            while (i < iC) {
                int i2 = i + 1;
                iArr[i] = c0357ic.a(i2);
                iArr2[i] = c0357ic.b(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < iC; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < c0357ic.a(); i4 += iC) {
                    sb2.append(str.charAt(i4));
                }
                String strA = a(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * iC) {
                    sb.setCharAt(c0357ic.a() + i5, strA.charAt(i6));
                    i5 += iC;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String a(CharSequence charSequence, int i) {
        return a(charSequence, 0, charSequence.length(), i);
    }

    private static String a(CharSequence charSequence, int i, int i2, int i3) throws Exception {
        int i4 = 0;
        while (true) {
            int[] iArr = a;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            }
            if (iArr[i4] == i3) {
                break;
            }
            i4++;
        }
        if (i4 >= 0) {
            int[] iArr2 = b[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                int iCharAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (iCharAt != 0 && iArr2[i7] != 0) {
                        char c2 = cArr[i7 - 1];
                        int[] iArr3 = d;
                        int[] iArr4 = c;
                        cArr[i7] = (char) (c2 ^ iArr3[(iArr4[iCharAt] + iArr4[iArr2[i7]]) % 255]);
                    } else {
                        cArr[i7] = cArr[i7 - 1];
                    }
                    i7--;
                }
                if (iCharAt != 0 && iArr2[0] != 0) {
                    int[] iArr5 = d;
                    int[] iArr6 = c;
                    cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[iArr2[0]]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal number of error correction codewords specified: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }
}
