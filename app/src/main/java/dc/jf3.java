package dc;

import com.wear.util.WearUtils;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* compiled from: OX16Utils.java */
/* loaded from: classes4.dex */
public class jf3 {
    public static String a = "0123456789abcdef";

    public static byte[] a(List<Integer> list) {
        byte[] bArr = new byte[list.size() + 5];
        bArr[0] = 76;
        bArr[1] = 86;
        bArr[2] = 83;
        bArr[3] = 58;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).intValue() < 0) {
                bArr[i + 4] = (list.get(i).intValue() == -1 ? 255 : Integer.valueOf(128 - list.get(i).intValue())).byteValue();
            } else {
                bArr[i + 4] = list.get(i).byteValue();
            }
        }
        bArr[list.size() + 4] = 59;
        return bArr;
    }

    public static String b(String str) {
        if (WearUtils.e1(str) || str.length() <= 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String c(String str) {
        if (WearUtils.e1(str)) {
            str = "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write((a.indexOf(str.charAt(i)) << 4) | a.indexOf(str.charAt(i + 1)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String d(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }
}
