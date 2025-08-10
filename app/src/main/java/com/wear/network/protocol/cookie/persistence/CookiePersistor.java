package com.wear.network.protocol.cookie.persistence;

import dc.ic4;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public interface CookiePersistor {
    void clear();

    List<ic4> loadAll();

    void removeAll(Collection<ic4> collection);

    void saveAll(Collection<ic4> collection);
}
