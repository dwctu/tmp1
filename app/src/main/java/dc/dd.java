package dc;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class dd {
    public static k7 a = new cd();

    public static void a(String str) {
        a.debug(str);
    }

    public static void b(String str, Throwable th) {
        a.error(str, th);
    }

    public static void c(String str) {
        a.a(str);
    }

    public static void d(String str, Throwable th) {
        a.b(str, th);
    }
}
