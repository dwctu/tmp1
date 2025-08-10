package dc;

import com.wear.util.WearUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Utils.java */
/* loaded from: classes4.dex */
public class bf3 {
    public static String a(File file) throws NoSuchAlgorithmException, IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    }
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                }
            }
            return String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
        } catch (FileNotFoundException | NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    public static boolean b(String str, File file) {
        String strA;
        if (WearUtils.e1(str) || file == null || (strA = a(file)) == null) {
            return false;
        }
        String str2 = "Calculated digest: " + strA;
        String str3 = "Provided digest: " + str;
        return strA.equalsIgnoreCase(str);
    }

    public static String c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
