package okhttp3.internal.http;

import dc.ad4;
import dc.ee4;
import dc.fe4;
import dc.qc4;
import dc.yc4;
import java.io.IOException;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes5.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    RealConnection connection();

    ee4 createRequestBody(yc4 yc4Var, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    fe4 openResponseBodySource(ad4 ad4Var) throws IOException;

    ad4.a readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(ad4 ad4Var) throws IOException;

    qc4 trailers() throws IOException;

    void writeRequestHeaders(yc4 yc4Var) throws IOException;
}
