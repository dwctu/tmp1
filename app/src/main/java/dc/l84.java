package dc;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.codec.net.URLCodec;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: AESEngine.java */
/* loaded from: classes5.dex */
public class l84 {
    public static final byte[] g = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, ExifInterface.START_CODE, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, URLCodec.ESCAPE_CHAR, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, ExifInterface.MARKER_APP1, -8, -104, 17, 105, ExifInterface.MARKER_EOI, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};
    public static final int[] h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, 154, 47, 94, 188, 99, Opcodes.IFNULL, 151, 53, 106, 212, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, EACTags.SECURE_MESSAGING_TEMPLATE, 250, 239, DownloaderService.STATUS_QUEUED_FOR_WIFI, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    public static final int[] i = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    public int a;
    public int[][] b = null;
    public int c;
    public int d;
    public int e;
    public int f;

    public l84(byte[] bArr) throws ZipException {
        c(bArr);
    }

    public final void a(int[][] iArr) {
        this.c ^= iArr[0][0];
        this.d ^= iArr[0][1];
        this.e ^= iArr[0][2];
        this.f ^= iArr[0][3];
        int i2 = 1;
        while (i2 < this.a - 1) {
            int[] iArr2 = i;
            int iF = (((iArr2[this.c & 255] ^ f(iArr2[(this.d >> 8) & 255], 24)) ^ f(iArr2[(this.e >> 16) & 255], 16)) ^ f(iArr2[(this.f >> 24) & 255], 8)) ^ iArr[i2][0];
            int iF2 = (((iArr2[this.d & 255] ^ f(iArr2[(this.e >> 8) & 255], 24)) ^ f(iArr2[(this.f >> 16) & 255], 16)) ^ f(iArr2[(this.c >> 24) & 255], 8)) ^ iArr[i2][1];
            int iF3 = (((iArr2[this.e & 255] ^ f(iArr2[(this.f >> 8) & 255], 24)) ^ f(iArr2[(this.c >> 16) & 255], 16)) ^ f(iArr2[(this.d >> 24) & 255], 8)) ^ iArr[i2][2];
            int i3 = i2 + 1;
            int iF4 = iArr[i2][3] ^ (((iArr2[this.f & 255] ^ f(iArr2[(this.c >> 8) & 255], 24)) ^ f(iArr2[(this.d >> 16) & 255], 16)) ^ f(iArr2[(this.e >> 24) & 255], 8));
            this.c = (((iArr2[iF & 255] ^ f(iArr2[(iF2 >> 8) & 255], 24)) ^ f(iArr2[(iF3 >> 16) & 255], 16)) ^ f(iArr2[(iF4 >> 24) & 255], 8)) ^ iArr[i3][0];
            this.d = (((iArr2[iF2 & 255] ^ f(iArr2[(iF3 >> 8) & 255], 24)) ^ f(iArr2[(iF4 >> 16) & 255], 16)) ^ f(iArr2[(iF >> 24) & 255], 8)) ^ iArr[i3][1];
            this.e = (((iArr2[iF3 & 255] ^ f(iArr2[(iF4 >> 8) & 255], 24)) ^ f(iArr2[(iF >> 16) & 255], 16)) ^ f(iArr2[(iF2 >> 24) & 255], 8)) ^ iArr[i3][2];
            this.f = (((iArr2[iF4 & 255] ^ f(iArr2[(iF >> 8) & 255], 24)) ^ f(iArr2[(iF2 >> 16) & 255], 16)) ^ f(iArr2[(iF3 >> 24) & 255], 8)) ^ iArr[i3][3];
            i2 = i3 + 1;
        }
        int[] iArr3 = i;
        int iF5 = (((iArr3[this.c & 255] ^ f(iArr3[(this.d >> 8) & 255], 24)) ^ f(iArr3[(this.e >> 16) & 255], 16)) ^ f(iArr3[(this.f >> 24) & 255], 8)) ^ iArr[i2][0];
        int iF6 = (((iArr3[this.d & 255] ^ f(iArr3[(this.e >> 8) & 255], 24)) ^ f(iArr3[(this.f >> 16) & 255], 16)) ^ f(iArr3[(this.c >> 24) & 255], 8)) ^ iArr[i2][1];
        int iF7 = (((iArr3[this.e & 255] ^ f(iArr3[(this.f >> 8) & 255], 24)) ^ f(iArr3[(this.c >> 16) & 255], 16)) ^ f(iArr3[(this.d >> 24) & 255], 8)) ^ iArr[i2][2];
        int i4 = i2 + 1;
        int iF8 = iArr[i2][3] ^ (f(iArr3[(this.e >> 24) & 255], 8) ^ ((iArr3[this.f & 255] ^ f(iArr3[(this.c >> 8) & 255], 24)) ^ f(iArr3[(this.d >> 16) & 255], 16)));
        byte[] bArr = g;
        this.c = iArr[i4][0] ^ ((((bArr[iF5 & 255] & 255) ^ ((bArr[(iF6 >> 8) & 255] & 255) << 8)) ^ ((bArr[(iF7 >> 16) & 255] & 255) << 16)) ^ (bArr[(iF8 >> 24) & 255] << Ascii.CAN));
        this.d = ((((bArr[iF6 & 255] & 255) ^ ((bArr[(iF7 >> 8) & 255] & 255) << 8)) ^ ((bArr[(iF8 >> 16) & 255] & 255) << 16)) ^ (bArr[(iF5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i4][1];
        this.e = ((((bArr[iF7 & 255] & 255) ^ ((bArr[(iF8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(iF5 >> 16) & 255] & 255) << 16)) ^ (bArr[(iF6 >> 24) & 255] << Ascii.CAN)) ^ iArr[i4][2];
        this.f = ((((bArr[iF8 & 255] & 255) ^ ((bArr[(iF5 >> 8) & 255] & 255) << 8)) ^ ((bArr[(iF6 >> 16) & 255] & 255) << 16)) ^ (bArr[(iF7 >> 24) & 255] << Ascii.CAN)) ^ iArr[i4][3];
    }

    public final int[][] b(byte[] bArr) throws ZipException {
        int length = bArr.length / 4;
        if ((length != 4 && length != 6 && length != 8) || length * 4 != bArr.length) {
            throw new ZipException("invalid key length (not 128/192/256)");
        }
        int i2 = length + 6;
        this.a = i2;
        int i3 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i2 + 1, 4);
        int i4 = 0;
        while (i3 < bArr.length) {
            iArr[i4 >> 2][i4 & 3] = (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | (bArr[i3 + 3] << Ascii.CAN);
            i3 += 4;
            i4++;
        }
        int i5 = (this.a + 1) << 2;
        for (int i6 = length; i6 < i5; i6++) {
            int i7 = i6 - 1;
            int i8 = iArr[i7 >> 2][i7 & 3];
            int i9 = i6 % length;
            if (i9 == 0) {
                i8 = i(f(i8, 8)) ^ h[(i6 / length) - 1];
            } else if (length > 6 && i9 == 4) {
                i8 = i(i8);
            }
            int i10 = i6 - length;
            iArr[i6 >> 2][i6 & 3] = i8 ^ iArr[i10 >> 2][i10 & 3];
        }
        return iArr;
    }

    public final void c(byte[] bArr) throws ZipException {
        this.b = b(bArr);
    }

    public int d(byte[] bArr, int i2, byte[] bArr2, int i3) throws ZipException {
        if (this.b == null) {
            throw new ZipException("AES engine not initialised");
        }
        if (i2 + 16 > bArr.length) {
            throw new ZipException("input buffer too short");
        }
        if (i3 + 16 > bArr2.length) {
            throw new ZipException("output buffer too short");
        }
        g(bArr, i2);
        a(this.b);
        h(bArr2, i3);
        return 16;
    }

    public int e(byte[] bArr, byte[] bArr2) throws ZipException {
        return d(bArr, 0, bArr2, 0);
    }

    public final int f(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    public final void g(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = bArr[i2] & 255;
        this.c = i4;
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.c = i6;
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.c = i8;
        int i9 = i7 + 1;
        this.c = i8 | (bArr[i7] << Ascii.CAN);
        int i10 = i9 + 1;
        int i11 = bArr[i9] & 255;
        this.d = i11;
        int i12 = i10 + 1;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.d = i13;
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.d = i15;
        int i16 = i14 + 1;
        this.d = i15 | (bArr[i14] << Ascii.CAN);
        int i17 = i16 + 1;
        int i18 = bArr[i16] & 255;
        this.e = i18;
        int i19 = i17 + 1;
        int i20 = ((bArr[i17] & 255) << 8) | i18;
        this.e = i20;
        int i21 = i19 + 1;
        int i22 = i20 | ((bArr[i19] & 255) << 16);
        this.e = i22;
        int i23 = i21 + 1;
        this.e = i22 | (bArr[i21] << Ascii.CAN);
        int i24 = i23 + 1;
        int i25 = bArr[i23] & 255;
        this.f = i25;
        int i26 = i24 + 1;
        int i27 = ((bArr[i24] & 255) << 8) | i25;
        this.f = i27;
        int i28 = i27 | ((bArr[i26] & 255) << 16);
        this.f = i28;
        this.f = (bArr[i26 + 1] << Ascii.CAN) | i28;
    }

    public final void h(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = this.c;
        bArr[i2] = (byte) i4;
        int i5 = i3 + 1;
        bArr[i3] = (byte) (i4 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i4 >> 16);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i4 >> 24);
        int i8 = i7 + 1;
        int i9 = this.d;
        bArr[i7] = (byte) i9;
        int i10 = i8 + 1;
        bArr[i8] = (byte) (i9 >> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >> 16);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i9 >> 24);
        int i13 = i12 + 1;
        int i14 = this.e;
        bArr[i12] = (byte) i14;
        int i15 = i13 + 1;
        bArr[i13] = (byte) (i14 >> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i14 >> 16);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i14 >> 24);
        int i18 = i17 + 1;
        int i19 = this.f;
        bArr[i17] = (byte) i19;
        int i20 = i18 + 1;
        bArr[i18] = (byte) (i19 >> 8);
        bArr[i20] = (byte) (i19 >> 16);
        bArr[i20 + 1] = (byte) (i19 >> 24);
    }

    public final int i(int i2) {
        byte[] bArr = g;
        return (bArr[(i2 >> 24) & 255] << Ascii.CAN) | (bArr[i2 & 255] & 255) | ((bArr[(i2 >> 8) & 255] & 255) << 8) | ((bArr[(i2 >> 16) & 255] & 255) << 16);
    }
}
