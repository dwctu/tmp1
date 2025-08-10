package dc;

import dc.sc4;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: OkHttpExceptionInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/wear/net/OkHttpExceptionInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class yk2 implements sc4 {
    @Override // dc.sc4
    @NotNull
    public ad4 intercept(@NotNull sc4.a chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            ad4 ad4VarProceed = chain.proceed(chain.request());
            Intrinsics.checkNotNullExpressionValue(ad4VarProceed, "chain.proceed(chain.request())");
            return ad4VarProceed;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException(th);
        }
    }
}
