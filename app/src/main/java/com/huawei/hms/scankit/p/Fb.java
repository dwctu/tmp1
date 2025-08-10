package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: ResultParser.java */
/* loaded from: classes3.dex */
public abstract class Fb {
    private static final Fb[] a = {new C0419yb(), new Cb(), new Hb(), new Gb(), new Lb(), new C0407vb(), new Jb(), new Kb(), new Ab(), new Ib(), new Db(), new C0403ub(), new C0399tb(), new Bb(), new Eb(), new C0415xb()};
    private static final SparseArray<Integer> b;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    public static final String[] f;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        b = sparseArray;
        sparseArray.put(BarcodeFormat.AZTEC.ordinal(), Integer.valueOf(HmsScanBase.AZTEC_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODABAR.ordinal(), Integer.valueOf(HmsScanBase.CODABAR_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_39.ordinal(), Integer.valueOf(HmsScanBase.CODE39_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_93.ordinal(), Integer.valueOf(HmsScanBase.CODE93_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_128.ordinal(), Integer.valueOf(HmsScanBase.CODE128_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.DATA_MATRIX.ordinal(), Integer.valueOf(HmsScanBase.DATAMATRIX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_8.ordinal(), Integer.valueOf(HmsScanBase.EAN8_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_13.ordinal(), Integer.valueOf(HmsScanBase.EAN13_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.ITF.ordinal(), Integer.valueOf(HmsScanBase.ITF14_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.PDF_417.ordinal(), Integer.valueOf(HmsScanBase.PDF417_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.QR_CODE.ordinal(), Integer.valueOf(HmsScanBase.QRCODE_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_A.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_A_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_E.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_E_SCAN_TYPE));
        c = Pattern.compile("\\d+");
        d = Pattern.compile(ContainerUtils.FIELD_DELIMITER);
        e = Pattern.compile("=");
        f = new String[0];
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int a(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == null) {
            return HmsScanBase.FORMAT_UNKNOWN;
        }
        Integer num = b.get(barcodeFormat.ordinal());
        return num == null ? HmsScanBase.FORMAT_UNKNOWN : num.intValue();
    }

    public static String b(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    public static HmsScan c(com.huawei.hms.scankit.aiscan.common.x xVar) {
        if (xVar == null) {
            return null;
        }
        for (Fb fb : a) {
            HmsScan hmsScanB = fb.b(xVar);
            if (hmsScanB != null) {
                return hmsScanB;
            }
        }
        return new HmsScan(xVar.i(), a(xVar.b()), xVar.i(), HmsScan.PURE_TEXT_FORM, xVar.g(), a(xVar.h()), null, null).setZoomValue(xVar.j());
    }

    public abstract HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar);

    public static Point[] a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        if (zVarArr == null || zVarArr.length <= 0) {
            return new Point[0];
        }
        Point[] pointArr = new Point[zVarArr.length];
        for (int i = 0; i < zVarArr.length; i++) {
            if (zVarArr[i] != null) {
                pointArr[i] = new Point((int) zVarArr[i].b(), (int) zVarArr[i].c());
            }
        }
        return pointArr;
    }

    private static int b(CharSequence charSequence, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    public static String a(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strI = xVar.i();
        return strI == null ? "" : strI.startsWith("\ufeff") ? strI.substring(1) : strI;
    }

    public static String b(String str, String str2, char c2, boolean z) {
        String[] strArrA = a(str, str2, c2, z);
        return (strArrA == null || strArrA.length == 0 || strArrA[0] == null) ? "" : strArrA[0];
    }

    public static HmsScan[] a(com.huawei.hms.scankit.aiscan.common.x[] xVarArr) {
        if (xVarArr == null || xVarArr.length <= 0) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArr = new HmsScan[xVarArr.length];
        for (int i = 0; i < xVarArr.length; i++) {
            if (xVarArr[i] == null) {
                hmsScanArr[i] = null;
            } else {
                hmsScanArr[i] = c(xVarArr[i]);
            }
        }
        return hmsScanArr;
    }

    public static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && c.matcher(charSequence).matches();
    }

    public static String[] a(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int iIndexOf = str2.indexOf(str, i);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z2 = true;
            int length3 = length2;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (b(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strB = b(str2.substring(length2, iIndexOf2));
                    if (z) {
                        strB = strB.trim();
                    }
                    arrayList2.add(strB);
                    length3 = iIndexOf2 + 1;
                }
                z2 = false;
            }
            i = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(f);
    }

    public static String a(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < str.length() ? str.substring(0, length) : str;
    }
}
