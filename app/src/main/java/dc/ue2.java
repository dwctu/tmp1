package dc;

import com.wear.bean.Pattern;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: IPatternManager.java */
/* loaded from: classes3.dex */
public interface ue2 extends te2 {

    /* compiled from: IPatternManager.java */
    public interface a {
        void a(int i, String str);

        void b(File file);
    }

    List<Pattern> C(String str);

    void E(Pattern pattern, boolean z);

    void F(LinkedHashMap<String, Pattern> linkedHashMap, boolean z);

    Pattern K(String str);

    boolean O(String str, String str2);

    void b(Pattern pattern);

    void d(Pattern pattern, boolean z);

    void e(Pattern pattern);

    void f(String str, String str2, a aVar);

    void g(String str, String str2);

    boolean l(String str, String str2);

    List<Pattern> m(String str);

    void s();

    void t(Pattern pattern, boolean z);

    List<Pattern> w(String str);

    List<Pattern> y(String str);

    List<Pattern> z(String str, int i);
}
