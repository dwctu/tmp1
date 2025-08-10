package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Code128Writer.java */
/* renamed from: com.huawei.hms.scankit.p.nc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0377nc extends AbstractC0400tc {

    /* compiled from: Code128Writer.java */
    /* renamed from: com.huawei.hms.scankit.p.nc$a */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) throws NumberFormatException {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int iA = 0;
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt < ' ' || cCharAt > '~') {
                    switch (cCharAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + cCharAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i2 < length) {
                int iA2 = a(str, i2, i4);
                if (iA2 == i4) {
                    switch (str.charAt(i2)) {
                        case 241:
                            iA2 = 102;
                            break;
                        case 242:
                            iA2 = 97;
                            break;
                        case 243:
                            iA2 = 96;
                            break;
                        case 244:
                            iA2 = 100;
                            break;
                        default:
                            if (i4 == 100) {
                                iA2 = str.charAt(i2) - ' ';
                                break;
                            } else {
                                try {
                                    iA2 = Integer.parseInt(str.substring(i2, i2 + 2));
                                    i2++;
                                    break;
                                } catch (NumberFormatException unused) {
                                    throw new IllegalArgumentException("contents substring can not format integer");
                                }
                            }
                    }
                    i2++;
                } else if (i4 != 0) {
                    i4 = iA2;
                } else if (iA2 == 100) {
                    i4 = iA2;
                    iA2 = 104;
                } else {
                    i4 = iA2;
                    iA2 = 105;
                }
                arrayList.add(P.a[iA2]);
                i3 += iA2 * i5;
                if (i2 != 0) {
                    i5++;
                }
            }
            int[][] iArr = P.a;
            arrayList.add(iArr[i3 % 103]);
            arrayList.add(iArr[106]);
            int i6 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i7 : iArr2) {
                    i6 += i7;
                }
            }
            boolean[] zArr = new boolean[i6];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iA += AbstractC0400tc.a(zArr, iA, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static a a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return a.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == 241) {
            return a.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return a.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return a.TWO_DIGITS;
        }
        return a.ONE_DIGIT;
    }

    private static int a(CharSequence charSequence, int i, int i2) {
        a aVar;
        a aVarA;
        a aVarA2;
        a aVarA3 = a(charSequence, i);
        a aVar2 = a.UNCODABLE;
        if (aVarA3 != aVar2 && aVarA3 != (aVar = a.ONE_DIGIT)) {
            if (i2 == 99) {
                return 99;
            }
            if (i2 == 100) {
                a aVar3 = a.FNC_1;
                if (aVarA3 == aVar3 || (aVarA = a(charSequence, i + 2)) == aVar2 || aVarA == aVar) {
                    return 100;
                }
                if (aVarA == aVar3) {
                    return a(charSequence, i + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    aVarA2 = a(charSequence, i3);
                    if (aVarA2 != a.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return aVarA2 == a.ONE_DIGIT ? 100 : 99;
            }
            if (aVarA3 == a.FNC_1) {
                aVarA3 = a(charSequence, i + 1);
            }
            if (aVarA3 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
