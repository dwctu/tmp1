package dc;

import dc.sc4;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeoutInterceptor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/component/dxhttp/interceptor/TimeoutInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class vy implements sc4 {
    @Override // dc.sc4
    @NotNull
    public ad4 intercept(@NotNull sc4.a chain) throws NumberFormatException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        yc4 yc4VarRequest = chain.request();
        String strC = yc4VarRequest.c("connect_timeout");
        if (strC == null) {
            strC = "30000";
        }
        String strC2 = yc4VarRequest.c("read_timeout");
        if (strC2 == null) {
            strC2 = "30000";
        }
        String strC3 = yc4VarRequest.c("write_timeout");
        String str = strC3 != null ? strC3 : "30000";
        int i = Integer.parseInt(strC);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ad4 ad4VarProceed = chain.withConnectTimeout(i, timeUnit).withReadTimeout(Integer.parseInt(strC2), timeUnit).withWriteTimeout(Integer.parseInt(str), timeUnit).proceed(yc4VarRequest);
        Intrinsics.checkNotNullExpressionValue(ad4VarProceed, "chain\n                .w…        .proceed(request)");
        return ad4VarProceed;
    }
}
