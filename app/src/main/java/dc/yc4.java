package dc;

import com.koushikdutta.async.http.AsyncHttpDelete;
import dc.qc4;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Request.java */
/* loaded from: classes5.dex */
public final class yc4 {
    public final rc4 a;
    public final String b;
    public final qc4 c;
    public final zc4 d;
    public final Map<Class<?>, Object> e;
    public volatile zb4 f;

    public yc4(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.f();
        this.d = aVar.d;
        this.e = Util.immutableMap(aVar.e);
    }

    public zc4 a() {
        return this.d;
    }

    public zb4 b() {
        zb4 zb4Var = this.f;
        if (zb4Var != null) {
            return zb4Var;
        }
        zb4 zb4VarK = zb4.k(this.c);
        this.f = zb4VarK;
        return zb4VarK;
    }

    public String c(String str) {
        return this.c.c(str);
    }

    public List<String> d(String str) {
        return this.c.k(str);
    }

    public qc4 e() {
        return this.c;
    }

    public boolean f() {
        return this.a.o();
    }

    public String g() {
        return this.b;
    }

    public a h() {
        return new a(this);
    }

    public <T> T i(Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public rc4 j() {
        return this.a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + MessageFormatter.DELIM_STOP;
    }

    /* compiled from: Request.java */
    public static class a {
        public rc4 a;
        public String b;
        public qc4.a c;
        public zc4 d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new qc4.a();
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public yc4 b() {
            if (this.a != null) {
                return new yc4(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c(zc4 zc4Var) {
            g(AsyncHttpDelete.METHOD, zc4Var);
            return this;
        }

        public a d() {
            g("GET", null);
            return this;
        }

        public a e(String str, String str2) {
            this.c.i(str, str2);
            return this;
        }

        public a f(qc4 qc4Var) {
            this.c = qc4Var.f();
            return this;
        }

        public a g(String str, zc4 zc4Var) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (zc4Var != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (zc4Var != null || !HttpMethod.requiresRequestBody(str)) {
                this.b = str;
                this.d = zc4Var;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a h(zc4 zc4Var) {
            g("POST", zc4Var);
            return this;
        }

        public a i(String str) {
            this.c.h(str);
            return this;
        }

        public <T> a j(Class<? super T> cls, T t) {
            Objects.requireNonNull(cls, "type == null");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public a k(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            l(rc4.m(str));
            return this;
        }

        public a l(rc4 rc4Var) {
            Objects.requireNonNull(rc4Var, "url == null");
            this.a = rc4Var;
            return this;
        }

        public a(yc4 yc4Var) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.a = yc4Var.a;
            this.b = yc4Var.b;
            this.d = yc4Var.d;
            if (yc4Var.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(yc4Var.e);
            }
            this.e = linkedHashMap;
            this.c = yc4Var.c.f();
        }
    }
}
