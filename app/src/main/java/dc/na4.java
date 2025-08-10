package dc;

import java.io.BufferedInputStream;

/* compiled from: ResourceHelper.java */
/* loaded from: classes5.dex */
public class na4 {
    public static BufferedInputStream a(String str) {
        return new BufferedInputStream(na4.class.getResourceAsStream(str));
    }
}
