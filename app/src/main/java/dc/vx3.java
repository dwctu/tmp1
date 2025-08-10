package dc;

/* compiled from: Assert.java */
@Deprecated
/* loaded from: classes4.dex */
public class vx3 {
    public static void c(String str, Object obj) {
        d(str, obj != null);
    }

    public static void d(String str, boolean z) {
        if (z) {
            return;
        }
        e(str);
        throw null;
    }

    public static void e(String str) {
        if (str != null) {
            throw new wx3(str);
        }
        throw new wx3();
    }
}
