package com.wear.network.protocol.cookie;

import dc.ic4;
import dc.jc4;
import dc.rc4;
import java.util.List;

/* loaded from: classes3.dex */
public interface ClearableCookieJar extends jc4 {
    void clear();

    void clearSession();

    @Override // dc.jc4
    /* synthetic */ List<ic4> loadForRequest(rc4 rc4Var);

    @Override // dc.jc4
    /* synthetic */ void saveFromResponse(rc4 rc4Var, List<ic4> list);
}
