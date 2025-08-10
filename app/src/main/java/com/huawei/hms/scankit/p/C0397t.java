package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.broadcom.bt.util.io.IOUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.vending.expansion.downloader.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.spotify.sdk.android.player.Config;
import com.wear.widget.control.FingImageLayout;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: Decoder.java */
/* renamed from: com.huawei.hms.scankit.p.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0397t {
    private static final String[] a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] b = {"CTRL_PS", " ", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", "f", "g", XHTMLText.H, "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", XHTMLText.Q, StreamManagement.AckRequest.ELEMENT, "s", "t", "u", PSOProgramService.VS_Key, "w", "x", FingImageLayout.ObjectAnimatorY, "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", IOUtils.LINE_SEPARATOR_UNIX, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", Config.IN_FIELD_SEPARATOR, "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", "+", ",", Constants.FILENAME_SEQUENCE_SEPARATOR, ".", "/", SignatureImpl.INNER_SEP, ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] e = {"CTRL_PS", " ", "0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private C0386q f;

    /* compiled from: Decoder.java */
    /* renamed from: com.huawei.hms.scankit.p.t$a */
    public enum a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private boolean[] b(boolean[] zArr) throws Exception {
        com.huawei.hms.scankit.aiscan.common.h hVar;
        C0386q c0386q = this.f;
        if (c0386q == null) {
            throw C0309a.a();
        }
        int i = 8;
        if (c0386q.f() <= 2) {
            i = 6;
            hVar = com.huawei.hms.scankit.aiscan.common.h.c;
        } else if (this.f.f() <= 8) {
            hVar = com.huawei.hms.scankit.aiscan.common.h.g;
        } else if (this.f.f() <= 22) {
            i = 10;
            hVar = com.huawei.hms.scankit.aiscan.common.h.b;
        } else {
            i = 12;
            hVar = com.huawei.hms.scankit.aiscan.common.h.a;
        }
        int iE = this.f.e();
        int length = zArr.length / i;
        if (length < iE) {
            throw C0309a.a();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = a(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new com.huawei.hms.scankit.aiscan.common.u(hVar).a(iArr, length - iE);
            return a(iE, i, iArr);
        } catch (C0309a e2) {
            throw C0309a.a(e2.getMessage());
        }
    }

    public C0313e a(C0386q c0386q, Map<EnumC0312d, ?> map) throws Exception {
        this.f = c0386q;
        boolean[] zArrB = b(a(c0386q.a()));
        C0313e c0313e = new C0313e(a(zArrB), a(zArrB, map), null, null);
        c0313e.a(zArrB.length);
        return c0313e;
    }

    private static String a(boolean[] zArr, Map<EnumC0312d, ?> map) throws C0309a {
        a aVar = a.UPPER;
        StringBuilder sbA = a(zArr, aVar, aVar);
        int length = sbA.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) sbA.charAt(i);
        }
        try {
            return new String(bArr, com.huawei.hms.scankit.aiscan.common.B.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw C0309a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, a aVar, a aVar2) {
        int length = zArr.length;
        StringBuilder sb = new StringBuilder(20);
        int i = 0;
        loop0: while (true) {
            a aVar3 = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
            while (i < length) {
                if (aVar != a.BINARY) {
                    int i2 = aVar == a.DIGIT ? 4 : 5;
                    if (length - i < i2) {
                        break loop0;
                    }
                    int iA = a(zArr, i, i2);
                    i += i2;
                    String strA = a(aVar, iA);
                    if (strA.startsWith("CTRL_")) {
                        aVar2 = a(strA.charAt(5));
                        if (strA.charAt(6) == 'L') {
                        }
                    } else {
                        sb.append(strA);
                    }
                    aVar = aVar2;
                } else {
                    if (length - i < 5) {
                        break loop0;
                    }
                    int iA2 = a(zArr, i, 5);
                    i += 5;
                    if (iA2 == 0) {
                        if (length - i < 11) {
                            break loop0;
                        }
                        iA2 = a(zArr, i, 11) + 31;
                        i += 11;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= iA2) {
                            break;
                        }
                        if (length - i < 8) {
                            i = length;
                            break;
                        }
                        sb.append((char) a(zArr, i, 8));
                        i += 8;
                        i3++;
                    }
                    aVar = aVar2;
                }
            }
        }
        return sb;
    }

    private static a a(char c2) {
        if (c2 == 'B') {
            return a.BINARY;
        }
        if (c2 == 'D') {
            return a.DIGIT;
        }
        if (c2 == 'P') {
            return a.PUNCT;
        }
        if (c2 == 'L') {
            return a.LOWER;
        }
        if (c2 != 'M') {
            return a.UPPER;
        }
        return a.MIXED;
    }

    private static String a(a aVar, int i) {
        int i2 = C0393s.a[aVar.ordinal()];
        if (i2 == 1) {
            return a[i];
        }
        if (i2 == 2) {
            return b[i];
        }
        if (i2 == 3) {
            return c[i];
        }
        if (i2 == 4) {
            return d[i];
        }
        if (i2 == 5) {
            return e[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(int i, int i2, int[] iArr) throws C0309a {
        int i3 = (1 << i2) - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = iArr[i5];
            if (i6 == 0 || i6 == i3) {
                throw C0309a.a();
            }
            if (i6 == 1 || i6 == i3 - 1) {
                i4++;
            }
        }
        boolean[] zArr = new boolean[(i * i2) - i4];
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            int i9 = iArr[i8];
            if (i9 == 1 || i9 == i3 - 1) {
                Arrays.fill(zArr, i7, (i7 + i2) - 1, i9 > 1);
                i7 += i2 - 1;
            } else {
                int i10 = i2 - 1;
                while (i10 >= 0) {
                    int i11 = i7 + 1;
                    zArr[i7] = ((1 << i10) & i9) != 0;
                    i10--;
                    i7 = i11;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(C0417y c0417y) {
        C0386q c0386q = this.f;
        boolean z = c0386q != null && c0386q.g();
        C0386q c0386q2 = this.f;
        int iF = c0386q2 != null ? c0386q2.f() : 0;
        int i = (z ? 11 : 14) + (iF * 4);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(iF, z)];
        int i2 = 2;
        if (z) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iF) {
            int i10 = ((iF - i8) * 4) + (z ? 9 : 12);
            int i11 = i8 * 2;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = c0417y.b(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = c0417y.b(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = c0417y.b(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = c0417y.b(iArr[i19], iArr[i16]);
                    i15++;
                    z = z;
                    i2 = 2;
                }
                i13++;
                i2 = 2;
            }
            i9 += i10 * 8;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte a(boolean[] zArr, int i) {
        int iA;
        int length = zArr.length - i;
        if (length >= 8) {
            iA = a(zArr, i, 8);
        } else {
            iA = a(zArr, i, length) << (8 - length);
        }
        return (byte) iA;
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = a(zArr, i * 8);
        }
        return bArr;
    }
}
