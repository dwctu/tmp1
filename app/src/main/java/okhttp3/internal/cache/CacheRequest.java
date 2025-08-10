package okhttp3.internal.cache;

import dc.ee4;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface CacheRequest {
    void abort();

    ee4 body() throws IOException;
}
