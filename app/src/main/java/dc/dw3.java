package dc;

/* compiled from: ProgressHelper.java */
/* loaded from: classes4.dex */
public class dw3 {
    public static zc4 a(zc4 zc4Var, ew3 ew3Var) {
        if (zc4Var == null) {
            throw new IllegalArgumentException("requestBody == null");
        }
        if (ew3Var != null) {
            return new gw3(zc4Var, ew3Var);
        }
        throw new IllegalArgumentException("progressListener == null");
    }
}
