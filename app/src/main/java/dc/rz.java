package dc;

import android.content.Context;
import android.os.Build;
import com.google.android.vending.expansion.downloader.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceIdCreateUtils.java */
/* loaded from: classes.dex */
public class rz {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        String strReplace = c().replace(Constants.FILENAME_SEQUENCE_SEPARATOR, "");
        if (strReplace != null && strReplace.length() > 0) {
            sb.append(strReplace);
        }
        if (sb.length() > 0) {
            try {
                String strA = a(d(sb.toString()));
                if (strA != null && strA.length() > 0) {
                    return "rvtlar" + strA;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "rvtlar";
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("100001");
        sb.append(Build.BOARD);
        sb.append(Build.BRAND);
        sb.append(Build.DEVICE);
        sb.append(Build.HARDWARE);
        sb.append(Build.ID);
        sb.append(Build.MODEL);
        sb.append(Build.PRODUCT);
        sb.append(Build.SERIAL);
        return new UUID(sb.toString().hashCode(), r1.hashCode()).toString();
    }

    public static byte[] d(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }
}
