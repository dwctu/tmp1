package dc;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: CompressPhotoUtils.java */
/* loaded from: classes4.dex */
public class ri3 {
    public static String a(Context context, Bitmap bitmap, String str) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str2 = "SaveBitmap: " + str;
        return str;
    }
}
