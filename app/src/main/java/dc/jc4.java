package dc;

import java.util.Collections;
import java.util.List;

/* compiled from: CookieJar.java */
/* loaded from: classes5.dex */
public interface jc4 {
    public static final jc4 a = new a();

    /* compiled from: CookieJar.java */
    public class a implements jc4 {
        @Override // dc.jc4
        public List<ic4> loadForRequest(rc4 rc4Var) {
            return Collections.emptyList();
        }

        @Override // dc.jc4
        public void saveFromResponse(rc4 rc4Var, List<ic4> list) {
        }
    }

    List<ic4> loadForRequest(rc4 rc4Var);

    void saveFromResponse(rc4 rc4Var, List<ic4> list);
}
