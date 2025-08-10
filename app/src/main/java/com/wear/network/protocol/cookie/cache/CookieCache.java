package com.wear.network.protocol.cookie.cache;

import dc.ic4;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface CookieCache extends Iterable<ic4> {
    void addAll(Collection<ic4> collection);

    void clear();
}
