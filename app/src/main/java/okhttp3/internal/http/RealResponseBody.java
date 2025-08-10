package okhttp3.internal.http;

import dc.bd4;
import dc.pd4;
import dc.tc4;

/* loaded from: classes5.dex */
public final class RealResponseBody extends bd4 {
    private final long contentLength;
    private final String contentTypeString;
    private final pd4 source;

    public RealResponseBody(String str, long j, pd4 pd4Var) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = pd4Var;
    }

    @Override // dc.bd4
    public long contentLength() {
        return this.contentLength;
    }

    @Override // dc.bd4
    public tc4 contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return tc4.d(str);
        }
        return null;
    }

    @Override // dc.bd4
    public pd4 source() {
        return this.source;
    }
}
