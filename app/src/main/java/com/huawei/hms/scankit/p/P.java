package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Code128Reader.java */
/* loaded from: classes3.dex */
public final class P extends Y {
    public static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static boolean a(C0413x c0413x, int i, int i2) {
        return c0413x.a(i, i2, false, false);
    }

    private static float b(C0413x c0413x, int[] iArr, int i) {
        int[] iArr2 = new int[7];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i2 : iArr) {
            i += i2;
        }
        boolean z = true;
        int i3 = 0;
        while (z && i < c0413x.d()) {
            if (c0413x.a(i)) {
                i3++;
                i++;
            } else {
                iArr2[6] = i3;
                z = false;
            }
        }
        int[][] iArr3 = a;
        return Y.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] c(StringBuilder sb, int[] iArr) throws C0309a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i < 100) {
            if (i < 10) {
                sb.append('0');
            }
            sb.append(i);
        } else {
            if (i != 106) {
                i4 = 0;
            }
            if (i != 106) {
                switch (i) {
                    case 100:
                        i5 = 100;
                        break;
                    case 101:
                        i5 = 101;
                        break;
                    case 102:
                        break;
                    default:
                        throw C0309a.a();
                }
            } else {
                i7 = 1;
            }
        }
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }

    private static int[] a(C0413x c0413x) throws C0309a {
        int iD = c0413x.d();
        int iB = c0413x.b(0);
        int[] iArr = new int[6];
        int i = iB;
        boolean z = false;
        int i2 = 0;
        while (iB < iD) {
            if (c0413x.a(iB) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = 0.25f;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fA = Y.a(iArr, a[i4], 0.7f);
                        if (fA < f) {
                            i3 = i4;
                            f = fA;
                        }
                    }
                    if (i3 >= 0) {
                        return new int[]{i, iB, i3};
                    }
                    i += iArr[0] + iArr[1];
                    int i5 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i2] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            iB++;
        }
        throw C0309a.a();
    }

    private int[] b(StringBuilder sb, int[] iArr) throws C0309a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i < 96) {
            if (i2 == i3) {
                sb.append((char) (i + 32));
            } else {
                sb.append((char) (i + 32 + 128));
            }
            i2 = 0;
        } else {
            if (i != 106) {
                i4 = 0;
            }
            if (i != 106) {
                switch (i) {
                    case 96:
                    case 97:
                    case 102:
                        break;
                    case 98:
                        i5 = 101;
                        i6 = 1;
                        break;
                    case 99:
                        i5 = 99;
                        break;
                    case 100:
                        if (i3 == 0 && i2 != 0) {
                            i2 = 0;
                            i3 = 1;
                            break;
                        } else if (i3 != 0 && i2 != 0) {
                            i2 = 0;
                            i3 = 0;
                            break;
                        } else {
                            i2 = 1;
                            break;
                        }
                    case 101:
                        i5 = 101;
                        break;
                    default:
                        throw C0309a.a();
                }
            } else {
                i7 = 1;
            }
        }
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }

    private static int a(C0413x c0413x, int[] iArr, int i) throws C0309a {
        float fA;
        Y.a(c0413x, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i3 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i3];
            if (i3 == iArr2.length - 1) {
                fA = b(c0413x, iArr, i);
            } else {
                fA = Y.a(iArr, iArr3, 0.7f);
            }
            if (fA < f) {
                i2 = i3;
                f = fA;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        int[] iArrA = a(c0413x);
        int i2 = iArrA[0] - (((iArrA[1] - iArrA[0]) / 11) * 10);
        if (i2 > 0 && i2 < iArrA[0]) {
            if (!a(c0413x, i2, iArrA[0])) {
                throw C0309a.a();
            }
        }
        int i3 = iArrA[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i3));
        int i4 = i3 == 103 ? 101 : i3 == 104 ? 100 : i3 == 105 ? 99 : 0;
        if (i4 != 0) {
            StringBuilder sb = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i4;
            a(sb, iArrA, iArr, i3, c0413x, arrayList);
            int i5 = iArr[0];
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            int i9 = iArr[4];
            boolean z = iArr[5] == 1;
            int i10 = iArr[6];
            int i11 = i6 - i5;
            if ((i8 - (i9 * i7)) % 103 == i7) {
                int length = sb.length();
                if (length != 0) {
                    if (length > 0 && z) {
                        if (i10 == 99) {
                            sb.delete(length - 2, length);
                        } else {
                            sb.delete(length - 1, length);
                        }
                    }
                    float f = iArrA[0];
                    float f2 = i5 + ((i11 * 13) / 11);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i12 = 0; i12 < size; i12++) {
                        bArr[i12] = arrayList.get(i12).byteValue();
                    }
                    float f3 = i;
                    return new com.huawei.hms.scankit.aiscan.common.x(sb.toString(), bArr, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(f, f3), new com.huawei.hms.scankit.aiscan.common.z(f2, f3)}, BarcodeFormat.CODE_128);
                }
                throw C0309a.a();
            }
            throw C0309a.a();
        }
        throw C0309a.a();
    }

    private void a(StringBuilder sb, int[] iArr, int[] iArr2, int i, C0413x c0413x, List<Byte> list) throws C0309a {
        P p = this;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int[] iArr3 = new int[6];
        int i4 = iArr2[6];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        boolean z = false;
        int i11 = 0;
        int i12 = i3;
        int i13 = i2;
        int i14 = i;
        while (i5 == 0) {
            int iA = a(c0413x, iArr3, i12);
            list.add(Byte.valueOf((byte) iA));
            if (iA != 106) {
                i7++;
                i14 += i7 * iA;
                i8 = 1;
            }
            int i15 = i12;
            for (int i16 = 0; i16 < 6; i16++) {
                i15 += iArr3[i16];
            }
            if (iA != 105) {
                int[] iArrC = {iA, i9, i10, i8, i4, 0, i5};
                if (i4 == 101) {
                    iArrC = p.a(sb, iArrC);
                } else if (i4 == 100) {
                    iArrC = p.b(sb, iArrC);
                } else if (i4 == 99) {
                    iArrC = p.c(sb, iArrC);
                }
                int i17 = iArrC[0];
                i9 = iArrC[1] == 1 ? 1 : 0;
                i10 = iArrC[2] == 1 ? 1 : 0;
                int i18 = iArrC[3] == 1 ? 1 : 0;
                boolean z2 = iArrC[5] == 1;
                int i19 = iArrC[6] == 1 ? 1 : 0;
                if (z) {
                    i4 = iArrC[4] == 101 ? 100 : 101;
                } else {
                    i4 = iArrC[4];
                }
                z = z2;
                i6 = i11;
                i5 = i19;
                i11 = i17;
                p = this;
                i8 = i18;
                i13 = i12;
                i12 = i15;
            } else {
                throw C0309a.a();
            }
        }
        iArr2[0] = i13;
        iArr2[1] = i12;
        iArr2[2] = i6;
        iArr2[3] = i14;
        iArr2[4] = i7;
        iArr2[5] = i8;
        iArr2[6] = i4;
    }

    private int[] a(StringBuilder sb, int[] iArr) throws C0309a {
        int i = iArr[0];
        int i2 = iArr[1] == 1 ? 1 : 0;
        int i3 = iArr[2] == 1 ? 1 : 0;
        int i4 = iArr[3] == 1 ? 1 : 0;
        int i5 = iArr[4];
        int i6 = iArr[5] == 1 ? 1 : 0;
        int i7 = iArr[6] == 1 ? 1 : 0;
        if (i < 64) {
            if (i2 == i3) {
                sb.append((char) (i + 32));
            } else {
                sb.append((char) (i + 32 + 128));
            }
        } else {
            if (i >= 96) {
                if (i != 106) {
                    i4 = 0;
                }
                if (i != 106) {
                    switch (i) {
                        case 96:
                        case 97:
                        case 102:
                            break;
                        case 98:
                            i5 = 100;
                            i6 = 1;
                            break;
                        case 99:
                            i5 = 99;
                            break;
                        case 100:
                            i5 = 100;
                            break;
                        case 101:
                            if (i3 == 0 && i2 != 0) {
                                i2 = 0;
                                i3 = 1;
                                break;
                            } else if (i3 != 0 && i2 != 0) {
                                i2 = 0;
                                i3 = 0;
                                break;
                            } else {
                                i2 = 1;
                                break;
                            }
                        default:
                            throw C0309a.a();
                    }
                } else {
                    i7 = 1;
                }
                return new int[]{i, i2, i3, i4, i5, i6, i7};
            }
            if (i2 == i3) {
                sb.append((char) (i - 64));
            } else {
                sb.append((char) (i + 64));
            }
        }
        i2 = 0;
        return new int[]{i, i2, i3, i4, i5, i6, i7};
    }
}
