package okhttp3.internal.cache;

import dc.ad4;
import dc.yc4;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface InternalCache {
    ad4 get(yc4 yc4Var) throws IOException;

    CacheRequest put(ad4 ad4Var) throws IOException;

    void remove(yc4 yc4Var) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(ad4 ad4Var, ad4 ad4Var2);
}
