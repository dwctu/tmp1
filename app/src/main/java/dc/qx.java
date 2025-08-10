package dc;

import com.component.dxdtxutils.lib.D;

/* compiled from: DXDtxUtils.java */
/* loaded from: classes.dex */
public class qx {
    public static String a(String str) {
        try {
            return D._free(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        try {
            return D._rand(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }
}
