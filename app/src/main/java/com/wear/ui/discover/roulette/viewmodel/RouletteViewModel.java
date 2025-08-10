package com.wear.ui.discover.roulette.viewmodel;

import androidx.core.os.EnvironmentCompat;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.wear.bean.FindMatchUserBean;
import com.wear.bean.RouletteBan;
import com.wear.bean.RoulettePublicBean;
import com.wear.bean.RouletteRequestStatus;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.RouletteStatus;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.g44;
import dc.h04;
import dc.h14;
import dc.o44;
import dc.q44;
import dc.ry2;
import dc.uy3;
import dc.v34;
import dc.wz3;
import dc.yn2;
import dc.yy3;
import dc.zn2;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: RouletteViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\b\u0010&\u001a\u00020\u001eH\u0002J\u0011\u0010'\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010+\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0013\u0010,\u001a\u0004\u0018\u00010-H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0006\u0010.\u001a\u00020#J\u0006\u0010/\u001a\u00020#J\u0010\u00100\u001a\u00020#2\b\b\u0002\u00101\u001a\u00020*J\u0006\u00102\u001a\u00020#J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020#J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010:\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u0007H\u0002J\u0006\u0010=\u001a\u00020#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_rouletteRequestStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wear/bean/RouletteRequestStatus;", "_rouletteStatus", "Lcom/wear/bean/RouletteStatus;", "cacheRouletteBan", "Lcom/wear/bean/RouletteBan;", "isRequestSettingInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "matchingJob", "Lkotlinx/coroutines/Job;", "matchingUuid", "", "getMatchingUuid", "()Ljava/lang/String;", "setMatchingUuid", "(Ljava/lang/String;)V", "rouletteRepository", "Lcom/wear/ui/discover/roulette/repository/RouletteRepository;", "rouletteRequestStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getRouletteRequestStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "rouletteState", "getRouletteState", "settingInfo", "Landroidx/databinding/ObservableField;", "Lcom/wear/bean/RouletteSettingBean;", "getSettingInfo", "()Landroidx/databinding/ObservableField;", "timeoutNoUserJob", "acceptMatch", "", "cancelMatching", "clearSettingInfo", "defaultRouletteSettingBean", "generateDHCode", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRequestSettingInfoEnd", "", "queryRouletteBanAsync", "queryRouletteBanLimit", "Lcom/wear/bean/RouletteLimit;", "queryRouletteSettingInfo", "rejectMatch", "startMatching", "notifyServer", "stopMatching", "successMatching", "findMatchUserBean", "Lcom/wear/bean/FindMatchUserBean;", "timeoutMatchingForAgree", "timeoutMatchingForNoUser", "updateRouletteSetting", "rouletteSettingBean", "updateRouletteSettingServer", "updateRouletteStatus", "rouletteStatus", "userRejectMatching", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteViewModel extends ViewModel {

    @NotNull
    public static final a l = new a(null);

    @Nullable
    public static RouletteSettingBean m;

    @NotNull
    public final g44<RouletteStatus> a;

    @NotNull
    public final o44<RouletteStatus> b;

    @NotNull
    public final g44<RouletteRequestStatus> c;

    @NotNull
    public final o44<RouletteRequestStatus> d;

    @NotNull
    public final ObservableField<RouletteSettingBean> e;

    @NotNull
    public AtomicBoolean f;

    @NotNull
    public final ry2 g;

    @Nullable
    public h14 h;

    @Nullable
    public h14 i;

    @Nullable
    public String j;

    @Nullable
    public RouletteBan k;

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel$Companion;", "", "()V", "cacheRouletteSettingBean", "Lcom/wear/bean/RouletteSettingBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$acceptMatch$1", f = "RouletteViewModel.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ry2 ry2Var = RouletteViewModel.this.g;
                this.label = 1;
                obj = ry2Var.a(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((BaseResponseBeanNew) obj) == null ? Unit.INSTANCE : Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$cancelMatching$1", f = "RouletteViewModel.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h14 h14Var = RouletteViewModel.this.h;
                if (h14Var != null) {
                    h14.a.a(h14Var, null, 1, null);
                }
                RouletteViewModel.this.F(RouletteStatus.Idle.INSTANCE);
                ry2 ry2Var = RouletteViewModel.this.g;
                this.label = 1;
                obj = ry2Var.b(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((BaseResponseBeanNew) obj) == null ? Unit.INSTANCE : Unit.INSTANCE;
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGet$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements yn2<BaseResponseBeanNew<RoulettePublicBean>> {
        public final /* synthetic */ yy3 a;
        public final /* synthetic */ String b;

        public d(yy3 yy3Var, String str) {
            this.a = yy3Var;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull BaseResponseBeanNew<RoulettePublicBean> response) {
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
    public static final class e implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Object>> {
        }

        public e(yy3 yy3Var) {
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

    /* compiled from: RouletteViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel", f = "RouletteViewModel.kt", i = {0, 0, 0, 1, 1}, l = {346, 361}, m = "generateDHCode", n = {"publicKeyName", "primaryKeyName", "url$iv", "url$iv", "params$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class f extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RouletteViewModel.this.m(this);
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel", f = "RouletteViewModel.kt", i = {0}, l = {118}, m = "isRequestSettingInfoEnd", n = {"this"}, s = {"L$0"})
    public static final class g extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RouletteViewModel.this.r(this);
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel", f = "RouletteViewModel.kt", i = {0, 0}, l = {325}, m = "queryRouletteBanAsync", n = {"this", "isShowToast$iv$iv"}, s = {"L$0", "I$0"})
    public static final class h extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RouletteViewModel.this.s(this);
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel", f = "RouletteViewModel.kt", i = {0}, l = {340}, m = "queryRouletteBanLimit", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class i extends ContinuationImpl {
        public int I$0;
        public int label;
        public /* synthetic */ Object result;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RouletteViewModel.this.t(this);
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$queryRouletteSettingInfo$1", f = "RouletteViewModel.kt", i = {}, l = {88, 92}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new j(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L5c
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.g44 r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.e(r6)
                com.wear.bean.RouletteRequestStatus$Loading r1 = com.wear.bean.RouletteRequestStatus.Loading.INSTANCE
                r6.setValue(r1)
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                r5.label = r3
                java.lang.Object r6 = r6.s(r5)
                if (r6 != r0) goto L37
                return r0
            L37:
                com.wear.bean.RouletteBan r6 = (com.wear.bean.RouletteBan) r6
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r1 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.g44 r1 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.e(r1)
                com.wear.bean.RouletteRequestStatus$BanInfo r4 = new com.wear.bean.RouletteRequestStatus$BanInfo
                r4.<init>(r6)
                r1.setValue(r4)
                com.wear.bean.RouletteSettingBean r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.b()
                if (r6 != 0) goto L74
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.ry2 r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.d(r6)
                r5.label = r2
                java.lang.Object r6 = r6.e(r5)
                if (r6 != r0) goto L5c
                return r0
            L5c:
                com.wear.bean.RouletteSettingBean r6 = (com.wear.bean.RouletteSettingBean) r6
                if (r6 != 0) goto L6e
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.g44 r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.e(r6)
                com.wear.bean.RouletteRequestStatus$LoadingFailed r0 = com.wear.bean.RouletteRequestStatus.LoadingFailed.INSTANCE
                r6.setValue(r0)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L6e:
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$a r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.l
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.g(r6)
                goto L7b
            L74:
                com.wear.bean.RouletteSettingBean r6 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.b()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            L7b:
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.g44 r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.e(r0)
                com.wear.bean.RouletteRequestStatus$LoadingSuccess r1 = com.wear.bean.RouletteRequestStatus.LoadingSuccess.INSTANCE
                r0.setValue(r1)
                java.lang.String r0 = r6.getGender()
                if (r0 == 0) goto L95
                int r0 = r0.length()
                if (r0 != 0) goto L93
                goto L95
            L93:
                r0 = 0
                goto L96
            L95:
                r0 = 1
            L96:
                if (r0 == 0) goto L9d
                java.lang.String r0 = "unknown"
                r6.setGender(r0)
            L9d:
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                java.util.concurrent.atomic.AtomicBoolean r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.f(r0)
                r0.set(r3)
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r0 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                androidx.databinding.ObservableField r0 = r0.q()
                r0.set(r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$rejectMatch$1", f = "RouletteViewModel.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new k(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((k) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ry2 ry2Var = RouletteViewModel.this.g;
                this.label = 1;
                obj = ry2Var.d(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((BaseResponseBeanNew) obj) == null) {
                return Unit.INSTANCE;
            }
            RouletteViewModel.this.x(false);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$startMatching$1", f = "RouletteViewModel.kt", i = {}, l = {200, 210}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $notifyServer;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(boolean z, Continuation<? super l> continuation) {
            super(2, continuation);
            this.$notifyServer = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new l(this.$notifyServer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x009b A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L24
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                kotlin.ResultKt.throwOnFailure(r10)
                goto L9c
            L14:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1c:
                java.lang.Object r1 = r9.L$0
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r1 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L49
            L24:
                kotlin.ResultKt.throwOnFailure(r10)
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r10 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                com.wear.bean.RouletteStatus$Matching r1 = com.wear.bean.RouletteStatus.Matching.INSTANCE
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.i(r10, r1)
                boolean r10 = r9.$notifyServer
                if (r10 == 0) goto L71
                com.wear.bean.RoulettePublicBean r10 = com.wear.bean.RoulettePublicBeanKt.generateRoulettePublicBean$default(r4, r3, r4)
                if (r10 == 0) goto L6b
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r1 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                dc.ry2 r5 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.d(r1)
                r9.L$0 = r1
                r9.label = r3
                java.lang.Object r10 = r5.f(r10, r9)
                if (r10 != r0) goto L49
                return r0
            L49:
                com.wear.bean.response.BaseResponseBeanNew r10 = (com.wear.bean.response.BaseResponseBeanNew) r10
                if (r10 != 0) goto L50
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            L50:
                boolean r3 = r10.result
                if (r3 != 0) goto L68
                int r10 = r10.code
                r3 = 610003(0x94ed3, float:8.54796E-40)
                if (r10 != r3) goto L68
                r10 = 2131886857(0x7f120309, float:1.9408305E38)
                java.lang.String r10 = dc.ah4.e(r10)
                dc.sg3.l(r10)
                r1.z()
            L68:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                goto L6c
            L6b:
                r10 = r4
            L6c:
                if (r10 != 0) goto L71
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            L71:
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r10 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                androidx.databinding.ObservableField r10 = r10.q()
                java.lang.Object r10 = r10.get()
                com.wear.bean.RouletteSettingBean r10 = (com.wear.bean.RouletteSettingBean) r10
                if (r10 == 0) goto L8a
                java.lang.Integer r10 = r10.getCountdown()
                if (r10 == 0) goto L8a
                int r10 = r10.intValue()
                goto L8c
            L8a:
                r10 = 30
            L8c:
                long r5 = (long) r10
                r7 = 1000(0x3e8, double:4.94E-321)
                long r5 = r5 * r7
                r9.L$0 = r4
                r9.label = r2
                java.lang.Object r10 = dc.h04.a(r5, r9)
                if (r10 != r0) goto L9c
                return r0
            L9c:
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r10 = com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.this
                com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.h(r10)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$stopMatching$1", f = "RouletteViewModel.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public m(Continuation<? super m> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new m(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h14 h14Var = RouletteViewModel.this.h;
                if (h14Var != null) {
                    h14.a.a(h14Var, null, 1, null);
                }
                RouletteViewModel.this.F(RouletteStatus.Idle.INSTANCE);
                ry2 ry2Var = RouletteViewModel.this.g;
                this.label = 1;
                obj = ry2Var.c(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((BaseResponseBeanNew) obj) == null ? Unit.INSTANCE : Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$timeoutMatchingForNoUser$1", f = "RouletteViewModel.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
    public static final class n extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public n(Continuation<? super n> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new n(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((n) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RouletteViewModel.this.F(RouletteStatus.Idle.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$updateRouletteSettingServer$1", f = "RouletteViewModel.kt", i = {}, l = {CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RouletteSettingBean $rouletteSettingBean;
        public int label;
        public final /* synthetic */ RouletteViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(RouletteSettingBean rouletteSettingBean, RouletteViewModel rouletteViewModel, Continuation<? super o> continuation) {
            super(2, continuation);
            this.$rouletteSettingBean = rouletteSettingBean;
            this.this$0 = rouletteViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new o(this.$rouletteSettingBean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((o) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RouletteSettingBean rouletteSettingBean = this.$rouletteSettingBean;
                String gender = rouletteSettingBean != null ? rouletteSettingBean.getGender() : null;
                if (!(gender == null || gender.length() == 0)) {
                    RouletteSettingBean rouletteSettingBean2 = this.$rouletteSettingBean;
                    if (!Intrinsics.areEqual(rouletteSettingBean2 != null ? rouletteSettingBean2.getGender() : null, EnvironmentCompat.MEDIA_UNKNOWN)) {
                        RouletteSettingBean rouletteSettingBean3 = this.$rouletteSettingBean;
                        if (rouletteSettingBean3 != null) {
                            RouletteViewModel rouletteViewModel = this.this$0;
                            a aVar = RouletteViewModel.l;
                            RouletteViewModel.m = rouletteSettingBean3;
                            ry2 ry2Var = rouletteViewModel.g;
                            this.label = 1;
                            if (ry2Var.g(rouletteSettingBean3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$userRejectMatching$1", f = "RouletteViewModel.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    public static final class p extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public p(Continuation<? super p> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteViewModel.this.new p(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((p) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RouletteViewModel.y(RouletteViewModel.this, false, 1, null);
            return Unit.INSTANCE;
        }
    }

    public RouletteViewModel() {
        g44<RouletteStatus> g44VarA = q44.a(RouletteStatus.Idle.INSTANCE);
        this.a = g44VarA;
        this.b = v34.b(g44VarA);
        g44<RouletteRequestStatus> g44VarA2 = q44.a(RouletteRequestStatus.Loading.INSTANCE);
        this.c = g44VarA2;
        this.d = v34.b(g44VarA2);
        this.e = new ObservableField<>(l());
        this.f = new AtomicBoolean(false);
        this.g = new ry2();
    }

    public static /* synthetic */ void y(RouletteViewModel rouletteViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        rouletteViewModel.x(z);
    }

    public final void A(@NotNull FindMatchUserBean findMatchUserBean) {
        Intrinsics.checkNotNullParameter(findMatchUserBean, "findMatchUserBean");
        h14 h14Var = this.h;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        F(new RouletteStatus.MatchSuccess(findMatchUserBean));
    }

    public final void B() {
        F(RouletteStatus.MatchFailedTimeoutAgree.INSTANCE);
        x(false);
    }

    public final void C() {
        F(RouletteStatus.MatchFailedTimeoutNoUser.INSTANCE);
        this.i = uy3.d(ViewModelKt.getViewModelScope(this), null, null, new n(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(@org.jetbrains.annotations.Nullable com.wear.bean.RouletteSettingBean r13) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L8
            java.lang.String r1 = r13.getGender()
            goto L9
        L8:
            r1 = r0
        L9:
            if (r1 == 0) goto L14
            int r1 = r1.length()
            if (r1 != 0) goto L12
            goto L14
        L12:
            r1 = 0
            goto L15
        L14:
            r1 = 1
        L15:
            if (r1 != 0) goto L27
            if (r13 == 0) goto L1e
            java.lang.String r1 = r13.getGender()
            goto L1f
        L1e:
            r1 = r0
        L1f:
            java.lang.String r2 = "unknown"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L2d
        L27:
            if (r13 != 0) goto L2a
            goto L2d
        L2a:
            r13.setGender(r0)
        L2d:
            androidx.databinding.ObservableField<com.wear.bean.RouletteSettingBean> r1 = r12.e
            if (r13 == 0) goto L40
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 0
            r2 = r13
            com.wear.bean.RouletteSettingBean r0 = com.wear.bean.RouletteSettingBean.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L40:
            r1.set(r0)
            r12.E(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.D(com.wear.bean.RouletteSettingBean):void");
    }

    public final void E(RouletteSettingBean rouletteSettingBean) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new o(rouletteSettingBean, this, null), 3, null);
    }

    public final void F(RouletteStatus rouletteStatus) {
        g44<RouletteStatus> g44Var = this.a;
        while (!g44Var.compareAndSet(g44Var.getValue(), rouletteStatus)) {
        }
    }

    public final void G() {
        F(RouletteStatus.MatchFailedOtherUserDeclined.INSTANCE);
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new p(null), 3, null);
    }

    public final void a() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new b(null), 3, null);
    }

    public final void j() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new c(null), 3, null);
    }

    public final void k() {
        this.f.set(false);
        this.e.set(l());
    }

    public final RouletteSettingBean l() {
        return new RouletteSettingBean(EnvironmentCompat.MEDIA_UNKNOWN, null, null, null, null, null, 30);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.m(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getJ() {
        return this.j;
    }

    @NotNull
    public final o44<RouletteRequestStatus> o() {
        return this.d;
    }

    @NotNull
    public final o44<RouletteStatus> p() {
        return this.b;
    }

    @NotNull
    public final ObservableField<RouletteSettingBean> q() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.g
            if (r0 == 0) goto L13
            r0 = r6
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$g r0 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$g r0 = new com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r0 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5a
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f
            boolean r6 = r6.get()
            if (r6 == 0) goto L45
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L45:
            dc.g44<com.wear.bean.RouletteRequestStatus> r6 = r5.c
            com.wear.bean.RouletteRequestStatus$Loading r2 = com.wear.bean.RouletteRequestStatus.Loading.INSTANCE
            r6.setValue(r2)
            dc.ry2 r6 = r5.g
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.e(r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r5
        L5a:
            com.wear.bean.RouletteSettingBean r6 = (com.wear.bean.RouletteSettingBean) r6
            r1 = 0
            if (r6 != 0) goto L6b
            dc.g44<com.wear.bean.RouletteRequestStatus> r6 = r0.c
            com.wear.bean.RouletteRequestStatus$LoadingFailed r0 = com.wear.bean.RouletteRequestStatus.LoadingFailed.INSTANCE
            r6.setValue(r0)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r6
        L6b:
            dc.g44<com.wear.bean.RouletteRequestStatus> r2 = r0.c
            com.wear.bean.RouletteRequestStatus$LoadingSuccess r4 = com.wear.bean.RouletteRequestStatus.LoadingSuccess.INSTANCE
            r2.setValue(r4)
            java.lang.String r2 = r6.getGender()
            if (r2 == 0) goto L7e
            int r2 = r2.length()
            if (r2 != 0) goto L7f
        L7e:
            r1 = 1
        L7f:
            if (r1 == 0) goto L86
            java.lang.String r1 = "unknown"
            r6.setGender(r1)
        L86:
            androidx.databinding.ObservableField<com.wear.bean.RouletteSettingBean> r1 = r0.e
            r1.set(r6)
            java.util.concurrent.atomic.AtomicBoolean r6 = r0.f
            r6.set(r3)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002b, B:26:0x005f, B:28:0x0067, B:29:0x006d, B:31:0x0073, B:33:0x007c, B:34:0x007f), top: B:51:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002b, B:26:0x005f, B:28:0x0067, B:29:0x006d, B:31:0x0073, B:33:0x007c, B:34:0x007f), top: B:51:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.wear.bean.RouletteBan> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.h
            if (r0 == 0) goto L13
            r0 = r5
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$h r0 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.h) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$h r0 = new com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r3 = r0.I$0
            java.lang.Object r0 = r0.L$0
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r0 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2f
            goto L5f
        L2f:
            r5 = move-exception
            goto L99
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r5)
            com.wear.bean.RouletteBan r5 = r4.k
            if (r5 == 0) goto L4b
            dc.g44<com.wear.bean.RouletteRequestStatus> r0 = r4.c
            com.wear.bean.RouletteRequestStatus$BanInfo r1 = new com.wear.bean.RouletteRequestStatus$BanInfo
            r1.<init>(r5)
            r0.setValue(r1)
            return r5
        L4b:
            dc.xk2$a r5 = dc.xk2.c     // Catch: java.lang.Exception -> L97
            dc.dl2 r5 = r5.c()     // Catch: java.lang.Exception -> L97
            r0.L$0 = r4     // Catch: java.lang.Exception -> L97
            r0.I$0 = r3     // Catch: java.lang.Exception -> L97
            r0.label = r3     // Catch: java.lang.Exception -> L97
            java.lang.Object r5 = r5.a(r0)     // Catch: java.lang.Exception -> L97
            if (r5 != r1) goto L5e
            return r1
        L5e:
            r0 = r4
        L5f:
            com.wear.net.model.RemoteResult r5 = (com.wear.net.model.RemoteResult) r5     // Catch: java.lang.Exception -> L2f
            boolean r1 = r5.isSuccess()     // Catch: java.lang.Exception -> L2f
            if (r1 == 0) goto L6d
            com.wear.net.model.RemoteResponse$Success r1 = new com.wear.net.model.RemoteResponse$Success     // Catch: java.lang.Exception -> L2f
            r1.<init>(r5)     // Catch: java.lang.Exception -> L2f
            goto La2
        L6d:
            java.lang.String r1 = r5.getMessage()     // Catch: java.lang.Exception -> L2f
            if (r1 != 0) goto L7a
            r1 = 2131886634(0x7f12022a, float:1.9407852E38)
            java.lang.String r1 = dc.ah4.e(r1)     // Catch: java.lang.Exception -> L2f
        L7a:
            if (r3 == 0) goto L7f
            dc.sg3.l(r1)     // Catch: java.lang.Exception -> L2f
        L7f:
            dc.zk2 r2 = dc.zk2.a     // Catch: java.lang.Exception -> L2f
            int r3 = r5.getCode()     // Catch: java.lang.Exception -> L2f
            r2.a(r3, r1)     // Catch: java.lang.Exception -> L2f
            com.wear.net.model.RemoteResponse$Error r2 = new com.wear.net.model.RemoteResponse$Error     // Catch: java.lang.Exception -> L2f
            int r5 = r5.getCode()     // Catch: java.lang.Exception -> L2f
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Exception -> L2f
            r2.<init>(r5, r1)     // Catch: java.lang.Exception -> L2f
            r1 = r2
            goto La2
        L97:
            r5 = move-exception
            r0 = r4
        L99:
            r5.printStackTrace()
            dc.al2 r1 = dc.al2.a
            com.wear.net.model.RemoteResponse$Error r1 = r1.a(r5)
        La2:
            boolean r5 = r1 instanceof com.wear.net.model.RemoteResponse.Success
            r2 = 0
            if (r5 == 0) goto Lb6
            com.wear.net.model.RemoteResponse$Success r1 = (com.wear.net.model.RemoteResponse.Success) r1
            java.lang.Object r5 = r1.getData()
            com.wear.net.model.RemoteResult r5 = (com.wear.net.model.RemoteResult) r5
            if (r5 == 0) goto Lb6
            java.lang.Object r5 = r5.getData()
            goto Lb7
        Lb6:
            r5 = r2
        Lb7:
            com.wear.bean.RouletteBan r5 = (com.wear.bean.RouletteBan) r5
            if (r5 != 0) goto Lce
            com.wear.bean.RouletteBan r5 = new com.wear.bean.RouletteBan
            r1 = 3
            r5.<init>(r2, r2, r1, r2)
            r0.k = r5
            dc.g44<com.wear.bean.RouletteRequestStatus> r0 = r0.c
            com.wear.bean.RouletteRequestStatus$BanInfo r1 = new com.wear.bean.RouletteRequestStatus$BanInfo
            r1.<init>(r5)
            r0.setValue(r1)
            return r5
        Lce:
            r0.k = r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.wear.bean.RouletteLimit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.i
            if (r0 == 0) goto L13
            r0 = r5
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$i r0 = (com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$i r0 = new com.wear.ui.discover.roulette.viewmodel.RouletteViewModel$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r3 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2b
            goto L49
        L2b:
            r5 = move-exception
            goto L81
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            dc.xk2$a r5 = dc.xk2.c     // Catch: java.lang.Exception -> L2b
            dc.dl2 r5 = r5.c()     // Catch: java.lang.Exception -> L2b
            r0.I$0 = r3     // Catch: java.lang.Exception -> L2b
            r0.label = r3     // Catch: java.lang.Exception -> L2b
            java.lang.Object r5 = r5.b(r0)     // Catch: java.lang.Exception -> L2b
            if (r5 != r1) goto L49
            return r1
        L49:
            com.wear.net.model.RemoteResult r5 = (com.wear.net.model.RemoteResult) r5     // Catch: java.lang.Exception -> L2b
            boolean r0 = r5.isSuccess()     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L57
            com.wear.net.model.RemoteResponse$Success r0 = new com.wear.net.model.RemoteResponse$Success     // Catch: java.lang.Exception -> L2b
            r0.<init>(r5)     // Catch: java.lang.Exception -> L2b
            goto L8a
        L57:
            java.lang.String r0 = r5.getMessage()     // Catch: java.lang.Exception -> L2b
            if (r0 != 0) goto L64
            r0 = 2131886634(0x7f12022a, float:1.9407852E38)
            java.lang.String r0 = dc.ah4.e(r0)     // Catch: java.lang.Exception -> L2b
        L64:
            if (r3 == 0) goto L69
            dc.sg3.l(r0)     // Catch: java.lang.Exception -> L2b
        L69:
            dc.zk2 r1 = dc.zk2.a     // Catch: java.lang.Exception -> L2b
            int r2 = r5.getCode()     // Catch: java.lang.Exception -> L2b
            r1.a(r2, r0)     // Catch: java.lang.Exception -> L2b
            com.wear.net.model.RemoteResponse$Error r1 = new com.wear.net.model.RemoteResponse$Error     // Catch: java.lang.Exception -> L2b
            int r5 = r5.getCode()     // Catch: java.lang.Exception -> L2b
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Exception -> L2b
            r1.<init>(r5, r0)     // Catch: java.lang.Exception -> L2b
            r0 = r1
            goto L8a
        L81:
            r5.printStackTrace()
            dc.al2 r0 = dc.al2.a
            com.wear.net.model.RemoteResponse$Error r0 = r0.a(r5)
        L8a:
            boolean r5 = r0 instanceof com.wear.net.model.RemoteResponse.Success
            r1 = 0
            if (r5 == 0) goto L9d
            com.wear.net.model.RemoteResponse$Success r0 = (com.wear.net.model.RemoteResponse.Success) r0
            java.lang.Object r5 = r0.getData()
            com.wear.net.model.RemoteResult r5 = (com.wear.net.model.RemoteResult) r5
            if (r5 == 0) goto L9d
            java.lang.Object r1 = r5.getData()
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteViewModel.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void u() {
        if (!MyApplication.O) {
            this.c.setValue(RouletteRequestStatus.LoadingFailed.INSTANCE);
        } else {
            if (this.f.get()) {
                return;
            }
            uy3.d(ViewModelKt.getViewModelScope(this), null, null, new j(null), 3, null);
        }
    }

    public final void v() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new k(null), 3, null);
    }

    public final void w(@Nullable String str) {
        this.j = str;
    }

    public final void x(boolean z) {
        F(RouletteStatus.Matching.INSTANCE);
        h14 h14Var = this.i;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        h14 h14Var2 = this.h;
        if (h14Var2 != null) {
            h14.a.a(h14Var2, null, 1, null);
        }
        this.h = uy3.d(ViewModelKt.getViewModelScope(this), null, null, new l(z, null), 3, null);
    }

    public final void z() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new m(null), 3, null);
    }
}
