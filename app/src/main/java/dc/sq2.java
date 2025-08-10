package dc;

import android.net.Uri;
import dc.tq2;
import java.io.Serializable;

/* compiled from: TLoginBean.java */
/* loaded from: classes3.dex */
public class sq2 implements Serializable {
    private String email;
    private String id;
    private tq2.a loginType;
    private String token;
    private String typeValue;
    private Uri url;

    public String a() {
        return this.token;
    }

    public Uri b() {
        return this.url;
    }

    public void c(String str) {
        this.email = str;
    }

    public void d(String str) {
        this.id = str;
    }

    public void e(tq2.a aVar) {
        this.loginType = aVar;
    }

    public void f(String str) {
        this.token = str;
    }

    public void g(String str) {
        this.typeValue = str;
    }

    public void h(Uri uri) {
        this.url = uri;
    }
}
