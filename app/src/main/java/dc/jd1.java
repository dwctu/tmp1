package dc;

/* compiled from: QLog.java */
/* loaded from: classes3.dex */
public final class jd1 {
    public static int a = 5;

    public static void a(Exception exc) {
        if (d()) {
            exc.printStackTrace();
        }
    }

    public static void b(Object obj) {
        if (d()) {
            String str = c() + String.valueOf(obj);
            String str2 = c() + String.valueOf(obj);
        }
    }

    public static String c() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public static boolean d() {
        return a > 0;
    }

    public static boolean e() {
        return a > 4;
    }

    public static void f(Object obj) {
        if (e()) {
            String str = c() + String.valueOf(obj);
        }
    }
}
