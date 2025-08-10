package org.jivesoftware.smack.util.dns;

import java.util.List;

/* loaded from: classes5.dex */
public interface DNSResolver {
    List<SRVRecord> lookupSRVRecords(String str) throws Exception;
}
