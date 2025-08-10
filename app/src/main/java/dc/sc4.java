package dc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Interceptor.java */
/* loaded from: classes5.dex */
public interface sc4 {

    /* compiled from: Interceptor.java */
    public interface a {
        int connectTimeoutMillis();

        fc4 connection();

        ad4 proceed(yc4 yc4Var) throws IOException;

        int readTimeoutMillis();

        yc4 request();

        a withConnectTimeout(int i, TimeUnit timeUnit);

        a withReadTimeout(int i, TimeUnit timeUnit);

        a withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    ad4 intercept(a aVar) throws IOException;
}
