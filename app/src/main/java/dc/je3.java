package dc;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: ExceptionUtil.java */
/* loaded from: classes4.dex */
public class je3 {
    public static String a(Exception exc) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exc.printStackTrace(printWriter);
            for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
