package dc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: UuidDeviceUtils.java */
/* loaded from: classes.dex */
public class ha0 {

    /* compiled from: UuidDeviceUtils.java */
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

    public static boolean a(String str) {
        return Pattern.compile("^\\w+:\\d+:[a-zA-Z0-9]{12}(;)?$").matcher(str).find();
    }

    public static a b(String str, byte[] bArr, String str2) {
        String str3;
        try {
            List<UUID> listC = c(bArr);
            if (listC == null) {
                return null;
            }
            Iterator<UUID> it = listC.iterator();
            String str4 = "";
            String str5 = str4;
            String str6 = str5;
            while (it.hasNext()) {
                String string = it.next().toString();
                if (string.toUpperCase().endsWith("-BBD5-A6920E4C5653")) {
                    char cA = ga0.a(Integer.valueOf(string.substring(0, 2), 16).intValue());
                    char cA2 = ga0.a(Integer.valueOf(string.substring(2, 4), 16).intValue());
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
            if (re0.e(str4)) {
                return null;
            }
            if (re0.e(str2)) {
                str2 = str4;
            }
            return new a(str2, str, str5, str6);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<UUID> c(byte[] bArr) {
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
