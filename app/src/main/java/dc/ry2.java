package dc;

import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.bean.RoulettePublicBean;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: RouletteRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/roulette/repository/RouletteRepository;", "", "()V", "acceptMatch", "Lcom/wear/bean/response/BaseResponseBeanNew;", "Lcom/wear/network/presenter/bean/BaseResponseBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelRoulette", "endRoulette", "refuseMatch", "requestSettingInfo", "Lcom/wear/bean/RouletteSettingBean;", "startRoulette", "publicKey", "Lcom/wear/bean/RoulettePublicBean;", "(Lcom/wear/bean/RoulettePublicBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSettingInfo", "rouletteSettingBean", "(Lcom/wear/bean/RouletteSettingBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ry2 {

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.ry2$a$a, reason: collision with other inner class name */
        public static final class C0215a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public a(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new C0215a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public b(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public c(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public d(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGet$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements yn2<BaseResponseBeanNew<RouletteSettingBean>> {
        public final /* synthetic */ yy3 a;
        public final /* synthetic */ String b;

        public e(yy3 yy3Var, String str) {
            this.a = yy3Var;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull BaseResponseBeanNew<RouletteSettingBean> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (this.a.isActive()) {
                if (response.code != 0) {
                    yy3 yy3Var = this.a;
                    Result.Companion companion = Result.INSTANCE;
                    yy3Var.resumeWith(Result.m86constructorimpl(null));
                } else {
                    yy3 yy3Var2 = this.a;
                    Result.Companion companion2 = Result.INSTANCE;
                    yy3Var2.resumeWith(Result.m86constructorimpl(response.data));
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            if (this.a.isActive()) {
                String str = this.b;
                if (str == null || str.length() == 0) {
                    String str2 = e != null ? e.message : null;
                    if (str2 == null) {
                        str2 = "network error";
                    }
                    ToastUtils.z(str2, new Object[0]);
                } else {
                    ToastUtils.z(this.b, new Object[0]);
                }
                yy3 yy3Var = this.a;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(null));
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public f(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Object>> {
        }

        public g(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    @Nullable
    public final Object a(@NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        Object obj = new Object();
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/accept-match", WearUtils.A.toJson(obj), new a(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object b(@NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        Object obj = new Object();
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/exit-match", WearUtils.A.toJson(obj), new b(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object c(@NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        Object obj = new Object();
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/end", WearUtils.A.toJson(obj), new c(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        Object obj = new Object();
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/reject-match", WearUtils.A.toJson(obj), new d(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object e(@NotNull Continuation<? super RouletteSettingBean> continuation) {
        String strE = ah4.e(R.string.common_timeout_error);
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).d("/wear/toyRoulette/setting-info-v2", new e(zy3Var, strE));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object f(@NotNull RoulettePublicBean roulettePublicBean, @NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/start", WearUtils.A.toJson(roulettePublicBean), new f(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    @Nullable
    public final Object g(@NotNull RouletteSettingBean rouletteSettingBean, @NotNull Continuation<? super BaseResponseBeanNew<Object>> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/edit-setting-v2", WearUtils.A.toJson(rouletteSettingBean), new g(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }
}
