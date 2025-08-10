package dc;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class lg {
    public static int a(int i, int i2, int i3, int i4) {
        int iMin = Math.min(i2 / i4, i / i3);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("Utils", 2) && iMax > 1) {
            String str = "Downsampling WEBP, sampleSize: " + iMax + ", target dimens: [" + i3 + "x" + i4 + "], actual dimens: [" + i + "x" + i2 + "]";
        }
        return iMax;
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException unused) {
            Log.isLoggable("Utils", 5);
            return null;
        }
    }
}
