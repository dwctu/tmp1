package dc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: ResourceUtils.java */
/* loaded from: classes.dex */
public final class je0 {
    public static String a(String str) {
        return b(str, null);
    }

    public static String b(String str, String str2) {
        try {
            byte[] bArrD = xe0.D(ve0.a().getAssets().open(str));
            if (bArrD == null) {
                return "";
            }
            if (xe0.K(str2)) {
                return new String(bArrD);
            }
            try {
                return new String(bArrD, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
