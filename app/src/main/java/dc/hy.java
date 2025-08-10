package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.gson.GsonBuilder;
import dc.vc4;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* compiled from: NetworkApi.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0018H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/component/dxhttp/NetworkApi;", "Lcom/component/dxhttp/BaseNetworkApi;", "()V", "appConfig", "Lcom/component/dxhttp/IAppConfig;", "getAppConfig", "()Lcom/component/dxhttp/IAppConfig;", "setAppConfig", "(Lcom/component/dxhttp/IAppConfig;)V", "interceptorList", "Ljava/util/ArrayList;", "Lokhttp3/Interceptor;", "Lkotlin/collections/ArrayList;", "openDebug", "", "addInterceptor", "", "interceptor", "deleteAllInterceptor", "isDebug", "setHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "builder", "setRetrofitBuilder", "Lretrofit2/Retrofit$Builder;", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class hy extends ey {

    @NotNull
    public static final b d = new b(null);

    @NotNull
    public static final Lazy<hy> e = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    @NotNull
    public final ArrayList<sc4> a = new ArrayList<>();
    public boolean b = true;

    @Nullable
    public fy c;

    /* compiled from: NetworkApi.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxhttp/NetworkApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<hy> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final hy invoke() {
            return new hy();
        }
    }

    /* compiled from: NetworkApi.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/component/dxhttp/NetworkApi$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/component/dxhttp/NetworkApi;", "getInstance$annotations", "getInstance", "()Lcom/component/dxhttp/NetworkApi;", "instance$delegate", "Lkotlin/Lazy;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final hy a() {
            return (hy) hy.e.getValue();
        }
    }

    @Override // dc.ey
    @NotNull
    public vc4.b c(@NotNull vc4.b builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.a(new ty());
        builder.a(new uy());
        Iterator<sc4> it = this.a.iterator();
        while (it.hasNext()) {
            builder.a(it.next());
        }
        if (gd0.i() && this.b) {
            builder.a(new yy());
        }
        builder.a(new vy());
        return builder;
    }

    @Override // dc.ey
    @NotNull
    public Retrofit.Builder d(@NotNull Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.addConverterFactory(oy.a(new GsonBuilder().create()));
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final fy getC() {
        return this.c;
    }

    public final void g(@Nullable fy fyVar) {
        this.c = fyVar;
    }
}
