package dc;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: CloseUtils.java */
/* loaded from: classes.dex */
public final class nd0 {
    public static void a(Closeable... closeableArr) throws IOException {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
