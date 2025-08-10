package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.util.WearUtils;
import dc.kd4;
import dc.vc4;
import dc.xk2;
import dc.yf1;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/* compiled from: Api.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0082\b¢\u0006\u0002\u0010\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/wear/net/Api;", "", "()V", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "createApi", ExifInterface.GPS_DIRECTION_TRUE, "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "Holder", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xk2 {

    @NotNull
    public static final a c = new a(null);

    @NotNull
    public static final xk2 d;

    @NotNull
    public static final bl2 e;

    @NotNull
    public static final cl2 f;

    @NotNull
    public static final dl2 g;

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(new d());

    /* compiled from: Api.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/wear/net/Api$Companion;", "", "()V", "commandApiService", "Lcom/wear/net/service/CommandApiService;", "getCommandApiService", "()Lcom/wear/net/service/CommandApiService;", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/net/Api;", "longDistanceApiService", "Lcom/wear/net/service/LongDistanceApiService;", "getLongDistanceApiService", "()Lcom/wear/net/service/LongDistanceApiService;", "rouletteApiService", "Lcom/wear/net/service/ToyRouletteApiService;", "getRouletteApiService", "()Lcom/wear/net/service/ToyRouletteApiService;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final bl2 a() {
            return xk2.e;
        }

        @NotNull
        public final cl2 b() {
            return xk2.f;
        }

        @NotNull
        public final dl2 c() {
            return xk2.g;
        }
    }

    /* compiled from: Api.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/net/Api$Holder;", "", "()V", "holder", "Lcom/wear/net/Api;", "getHolder", "()Lcom/wear/net/Api;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        @NotNull
        public static final b a = new b();

        @NotNull
        public static final xk2 b = new xk2();

        @NotNull
        public final xk2 a() {
            return b;
        }
    }

    /* compiled from: Api.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<vc4> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        public static final void b(String str) {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final vc4 invoke() {
            vc4.b bVar = new vc4.b();
            bVar.a(new yk2());
            bVar.a(un2.a());
            kd4 kd4Var = new kd4(new kd4.b() { // from class: dc.wk2
                @Override // dc.kd4.b
                public final void log(String str) {
                    xk2.c.b(str);
                }
            });
            kd4Var.c(kd4.a.BODY);
            bVar.a(kd4Var);
            return bVar.b();
        }
    }

    /* compiled from: Api.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Retrofit> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Retrofit invoke() {
            yf1.a aVar = new yf1.a();
            aVar.a(new eg1());
            return new Retrofit.Builder().client(xk2.this.e()).baseUrl(WearUtils.e).addConverterFactory(MoshiConverterFactory.create(aVar.b())).build();
        }
    }

    static {
        xk2 xk2VarA = b.a.a();
        d = xk2VarA;
        Object objCreate = xk2VarA.f().create(bl2.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "instance.retrofit.create(type)");
        e = (bl2) objCreate;
        Object objCreate2 = xk2VarA.f().create(cl2.class);
        Intrinsics.checkNotNullExpressionValue(objCreate2, "instance.retrofit.create(type)");
        f = (cl2) objCreate2;
        Object objCreate3 = xk2VarA.f().create(dl2.class);
        Intrinsics.checkNotNullExpressionValue(objCreate3, "instance.retrofit.create(type)");
        g = (dl2) objCreate3;
    }

    public final vc4 e() {
        Object value = this.a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-httpClient>(...)");
        return (vc4) value;
    }

    public final Retrofit f() {
        Object value = this.b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-retrofit>(...)");
        return (Retrofit) value;
    }
}
