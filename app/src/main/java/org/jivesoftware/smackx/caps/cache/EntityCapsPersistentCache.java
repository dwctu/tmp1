package org.jivesoftware.smackx.caps.cache;

import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

/* loaded from: classes5.dex */
public interface EntityCapsPersistentCache {
    void addDiscoverInfoByNodePersistent(String str, DiscoverInfo discoverInfo);

    void emptyCache();

    DiscoverInfo lookup(String str);
}
