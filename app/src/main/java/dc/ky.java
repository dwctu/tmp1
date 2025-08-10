package dc;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.component.dxhttp.NetException;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.sun.jna.Callback;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

/* compiled from: NetworkUtil.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007JP\u0010\u000f\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JP\u0010\u0018\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JP\u0010\u0019\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JP\u0010\u001a\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007Ji\u0010\u001b\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u001e0\u001d2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JX\u0010\u001f\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JX\u0010!\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007Ji\u0010\"\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u001e0\u001d2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007J^\u0010#\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007Jl\u0010&\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007J`\u0010)\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\u0006\u0010*\u001a\u00020+2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007J`\u0010,\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\u0006\u0010*\u001a\u00020+2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JX\u0010-\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007JX\u0010.\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017H\u0007J\"\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u001100\"\u0004\b\u0000\u0010\u00112\u0006\u00101\u001a\u000202H\u0002J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u001100\"\u0004\b\u0000\u0010\u0011H\u0002J\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u001100\"\u0004\b\u0000\u0010\u0011H\u0002J\u0012\u00105\u001a\u00020\f2\b\b\u0002\u00106\u001a\u00020+H\u0007J\u0010\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209H\u0007J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006<"}, d2 = {"Lcom/component/dxhttp/NetworkUtil;", "", "()V", "baseUrl", "", "networkClient", "Lcom/component/dxhttp/NetworkClient;", "getNetworkClient", "()Lcom/component/dxhttp/NetworkClient;", "networkClient$delegate", "Lkotlin/Lazy;", "addInterceptor", "", "interceptor", "Lokhttp3/Interceptor;", "executeGet", "Lio/reactivex/disposables/Disposable;", ExifInterface.GPS_DIRECTION_TRUE, ImagesContract.URL, "headerMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Callback.METHOD_NAME, "Lcom/component/dxhttp/callback/ResponseCallback;", "executeGetAllRaw", "executeGetAllRawAsync", "executeGetNoRule", "executePost", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "Lkotlin/jvm/JvmSuppressWildcards;", "executePostAllRaw", "bean", "executePostAllRawAsync", "executePostAsync", "executePostUpLoad", "pathList", "", "executePostUpLoadFileAndParams", "file", "Ljava/io/File;", "executePostZip", "isUrlEncode", "", "executePostZipAsync", "executeUpload", "executeUploadAsync", "getSchedulersTransformer", "Lio/reactivex/FlowableTransformer;", "observeScheduler", "Lio/reactivex/Scheduler;", "getSchedulersTransformerAsync", "getSchedulersTransformerMain", "openDebug", "isDebug", "setAppConfig", "appConfig", "Lcom/component/dxhttp/IAppConfig;", "setGlobalDomain", "globalDomain", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ky {

    @Nullable
    public static String b;

    @NotNull
    public static final ky a = new ky();

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: NetworkUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxhttp/NetworkClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<iy> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final iy invoke() {
            Unit unit;
            iy iyVar = new iy();
            String str = ky.b;
            if (str == null) {
                unit = null;
            } else {
                iyVar.e((gy) hy.d.a().a(gy.class, str));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                de0.l("Please setGlobalDomain at firstly, before any methods be used ");
            }
            return iyVar;
        }
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable b(@NotNull String url, @Nullable HashMap<String, String> map, @NotNull ny<T> callback) {
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableA = iyVarH.a(url, map);
        if (flowableA == null || (flowableCompose = flowableA.compose(kyVar.l())) == 0) {
            return null;
        }
        return (ry) flowableCompose.subscribeWith(new ry(url, typeA, callback));
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable c(@NotNull String url, @Nullable HashMap<String, String> map, @NotNull ny<T> callback) {
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableB = iyVarH.b(url, map);
        if (flowableB == null || (flowableCompose = flowableB.compose(kyVar.l())) == 0) {
            return null;
        }
        return (ry) flowableCompose.subscribeWith(new ry(url, typeA, callback));
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable d(@NotNull String url, @NotNull Object bean, @Nullable HashMap<String, String> map, @NotNull ny<T> callback) {
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        zc4 body = zc4.create(tc4.d(FastJsonJsonView.DEFAULT_CONTENT_TYPE), xd0.j(bean));
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        Intrinsics.checkNotNullExpressionValue(body, "body");
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableD = iyVarH.d(url, body, map);
        if (flowableD == null || (flowableCompose = flowableD.compose(kyVar.l())) == 0) {
            return null;
        }
        return (ry) flowableCompose.subscribeWith(new ry(url, typeA, callback));
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable e(@NotNull String url, @NotNull Object bean, @Nullable HashMap<String, String> map, @NotNull ny<T> callback) {
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        zc4 mBody = zc4.create(tc4.d(FastJsonJsonView.DEFAULT_CONTENT_TYPE), xd0.j(bean));
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        Intrinsics.checkNotNullExpressionValue(mBody, "mBody");
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableD = iyVarH.d(url, mBody, map);
        if (flowableD == null || (flowableCompose = flowableD.compose(kyVar.k())) == 0) {
            return null;
        }
        return (ry) flowableCompose.subscribeWith(new ry(url, typeA, callback));
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable f(@NotNull String url, @NotNull String params, @Nullable HashMap<String, String> map, boolean z, @NotNull ny<T> callback) {
        zc4 zc4VarCreate;
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        try {
            tc4 tc4VarD = tc4.d("text/plain; charset=UTF-8");
            if (z) {
                params = sd0.c(params);
            }
            zc4VarCreate = zc4.create(tc4VarD, dz.a(params));
        } catch (Exception e) {
            e.printStackTrace();
            zc4VarCreate = null;
        }
        if (zc4VarCreate == null) {
            callback.b(new NetException("", "gzip post error"));
            return null;
        }
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableC = iyVarH.c(url, zc4VarCreate, map);
        if (flowableC == null || (flowableCompose = flowableC.compose(kyVar.l())) == 0) {
            return null;
        }
        return (sy) flowableCompose.subscribeWith(new sy(url, typeA, callback));
    }

    @JvmStatic
    @Nullable
    public static final <T> Disposable g(@NotNull String url, @NotNull String params, @Nullable HashMap<String, String> map, boolean z, @NotNull ny<T> callback) {
        zc4 zc4VarCreate;
        Flowable<R> flowableCompose;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Type typeA = wd0.a(callback.getClass());
        if (typeA == null) {
            return null;
        }
        try {
            tc4 tc4VarD = tc4.d("text/plain; charset=UTF-8");
            if (z) {
                params = sd0.c(params);
            }
            zc4VarCreate = zc4.create(tc4VarD, dz.a(params));
        } catch (Exception e) {
            e.printStackTrace();
            zc4VarCreate = null;
        }
        if (zc4VarCreate == null) {
            callback.b(new NetException("", "gzip post error"));
            return null;
        }
        ky kyVar = a;
        iy iyVarH = kyVar.h();
        if (map == null) {
            map = new HashMap<>();
        }
        Flowable<bd4> flowableC = iyVarH.c(url, zc4VarCreate, map);
        if (flowableC == null || (flowableCompose = flowableC.compose(kyVar.k())) == 0) {
            return null;
        }
        return (sy) flowableCompose.subscribeWith(new sy(url, typeA, callback));
    }

    public static final Publisher j(Scheduler observeScheduler, Flowable upstream) {
        Intrinsics.checkNotNullParameter(observeScheduler, "$observeScheduler");
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        return upstream.subscribeOn(Schedulers.io()).observeOn(observeScheduler);
    }

    @JvmStatic
    public static final void n(@NotNull fy appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        hy.d.a().g(appConfig);
    }

    @JvmStatic
    public static final void o(@NotNull String globalDomain) {
        Intrinsics.checkNotNullParameter(globalDomain, "globalDomain");
        b = globalDomain;
    }

    public final iy h() {
        return (iy) c.getValue();
    }

    public final <T> FlowableTransformer<T, T> i(final Scheduler scheduler) {
        return new FlowableTransformer() { // from class: dc.cy
            @Override // io.reactivex.FlowableTransformer
            public final Publisher apply(Flowable flowable) {
                return ky.j(scheduler, flowable);
            }
        };
    }

    public final <T> FlowableTransformer<T, T> k() {
        Scheduler schedulerIo = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(schedulerIo, "io()");
        return i(schedulerIo);
    }

    public final <T> FlowableTransformer<T, T> l() {
        Scheduler schedulerMainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(schedulerMainThread, "mainThread()");
        return i(schedulerMainThread);
    }
}
