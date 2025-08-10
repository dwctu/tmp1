package dc;

/* compiled from: AssertionFailedError.java */
/* loaded from: classes4.dex */
public class wx3 extends AssertionError {
    private static final long serialVersionUID = 1;

    public wx3() {
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public wx3(String str) {
        super(a(str));
    }
}
