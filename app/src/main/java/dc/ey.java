package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.vc4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

/* compiled from: BaseNetworkApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0012H&R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/component/dxhttp/BaseNetworkApi;", "", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "getApi", ExifInterface.GPS_DIRECTION_TRUE, "serviceClass", "Ljava/lang/Class;", "baseUrl", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "setHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "builder", "setRetrofitBuilder", "Lretrofit2/Retrofit$Builder;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ey {
    public final <T> T a(@NotNull Class<T> serviceClass, @NotNull String baseUrl) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        if (!StringsKt__StringsJVMKt.endsWith$default(baseUrl, "/", false, 2, null)) {
            baseUrl = Intrinsics.stringPlus(baseUrl, "/");
        }
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl).client(b());
        Intrinsics.checkNotNullExpressionValue(retrofitBuilder, "retrofitBuilder");
        d(retrofitBuilder);
        return (T) retrofitBuilder.build().create(serviceClass);
    }

    public final vc4 b() {
        vc4.b builder = RetrofitUrlManager.getInstance().with(new vc4.b());
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder);
        vc4 vc4VarB = builder.b();
        Intrinsics.checkNotNullExpressionValue(vc4VarB, "builder.build()");
        return vc4VarB;
    }

    @NotNull
    public abstract vc4.b c(@NotNull vc4.b bVar);

    @NotNull
    public abstract Retrofit.Builder d(@NotNull Retrofit.Builder builder);
}
