package dc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* compiled from: ChineseToPinyinResource.java */
/* loaded from: classes5.dex */
public class ka4 {
    public Properties a;

    /* compiled from: ChineseToPinyinResource.java */
    public static class b {
        public static final ka4 a = new ka4();
    }

    public static ka4 c() {
        return b.a;
    }

    public final String a(char c) {
        String property = d().getProperty(Integer.toHexString(c).toUpperCase());
        if (f(property)) {
            return property;
        }
        return null;
    }

    public String[] b(char c) {
        String strA = a(c);
        if (strA == null) {
            return null;
        }
        return strA.substring(strA.indexOf("(") + 1, strA.lastIndexOf(")")).split(",");
    }

    public final Properties d() {
        return this.a;
    }

    public final void e() throws IOException {
        try {
            g(new Properties());
            d().load(na4.a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean f(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    public final void g(Properties properties) {
        this.a = properties;
    }

    public ka4() throws IOException {
        this.a = null;
        e();
    }
}
