package dc;

import java.io.File;
import java.nio.charset.Charset;

/* compiled from: InternalZipConstants.java */
/* loaded from: classes5.dex */
public final class fa4 {
    public static final String a = File.separator;
    public static final Charset b;
    public static final Charset c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        b = charsetForName;
        c = charsetForName;
    }
}
