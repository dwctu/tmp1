package dc;

import com.google.android.vending.expansion.downloader.Constants;
import com.wear.util.WearUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: UuidDevice.java */
/* loaded from: classes3.dex */
public class xb1 {

    /* compiled from: UuidDevice.java */
    public static class a {
        public String a;
        public String b;
        public String c;

        public a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str3;
            this.c = str4;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.c;
        }
    }

    public static String a(String str) {
        String str2;
        if (WearUtils.e1(str)) {
            return str;
        }
        if (str.toUpperCase().endsWith("-BBD5-A6920E4C5653") && (str2 = str.split(Constants.FILENAME_SEQUENCE_SEPARATOR)[0]) != null && str2.length() >= 2) {
            String strSubstring = str2.substring(0, str2.length() - 2);
            if (str2.endsWith("01")) {
                str = str.replaceFirst(str2, strSubstring + "11");
            } else if (str2.endsWith("11")) {
                str = str.replaceFirst(str2, strSubstring + "01");
            }
        }
        String str3 = "changeUuidOnOrOff: " + str;
        return str;
    }

    public static boolean b(String str, String str2) {
        if (!WearUtils.e1(str) && str.toUpperCase().endsWith("-BBD5-A6920E4C5653")) {
            String[] strArrSplit = str.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
            if (strArrSplit[0] != null && !strArrSplit[0].endsWith("01") && strArrSplit[0].endsWith("11")) {
                return false;
            }
        }
        return true;
    }

    public static a c(String str, byte[] bArr, String str2) {
        String str3;
        try {
            List<UUID> listD = d(bArr);
            if (listD == null) {
                return null;
            }
            Iterator<UUID> it = listD.iterator();
            String str4 = "";
            String str5 = str4;
            String str6 = str5;
            while (it.hasNext()) {
                String string = it.next().toString();
                if (string.toUpperCase().endsWith("-BBD5-A6920E4C5653")) {
                    char cA = ub1.a(Integer.valueOf(string.substring(0, 2), 16).intValue());
                    char cA2 = ub1.a(Integer.valueOf(string.substring(2, 4), 16).intValue());
                    if (cA2 == '0') {
                        str3 = cA + "";
                    } else {
                        str3 = cA + "" + cA2;
                    }
                    int iIntValue = Integer.valueOf(string.substring(9, 13), 16).intValue();
                    String str7 = "LVS-" + str3 + "" + iIntValue;
                    str5 = str3 + SignatureImpl.INNER_SEP + iIntValue + SignatureImpl.INNER_SEP + str.replaceAll(SignatureImpl.INNER_SEP, "") + ";";
                    str4 = str7;
                    str6 = string;
                }
            }
            if (tb1.h(str4)) {
                return null;
            }
            if (WearUtils.e1(str2)) {
                str2 = str4;
            }
            return new a(str2, str, str5, str6);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<UUID> d(byte[] bArr) {
        byte b;
        ArrayList arrayList = new ArrayList();
        try {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            while (byteBufferOrder.remaining() > 2 && (b = byteBufferOrder.get()) != 0) {
                byte b2 = byteBufferOrder.get();
                if (b2 == 2 || b2 == 3) {
                    while (b >= 2) {
                        arrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", Short.valueOf(byteBufferOrder.getShort()))));
                        b = (byte) (b - 2);
                    }
                } else if (b2 == 6 || b2 == 7) {
                    while (b >= 16) {
                        arrayList.add(new UUID(byteBufferOrder.getLong(), byteBufferOrder.getLong()));
                        b = (byte) (b - 16);
                    }
                } else {
                    byteBufferOrder.position((byteBufferOrder.position() + b) - 1);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
