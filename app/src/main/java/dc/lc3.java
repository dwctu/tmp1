package dc;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.gson.reflect.TypeToken;
import com.sun.jna.Callback;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.me.OnlineStatusFriendCheckParam;
import com.wear.bean.me.OnlineStatusFriendCheckResponse;
import com.wear.bean.me.OnlineStatusFriendListParam;
import com.wear.bean.me.OnlineStatusFriendListResponse;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: OnlineStatusRepository.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015J'\u0010\u0016\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/wear/ui/me/repository/OnlineStatusRepository;", "", "()V", "checkFriendOnlineStatus", "", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "checkParam", "Lcom/wear/bean/me/OnlineStatusFriendCheckParam;", Callback.METHOD_NAME, "Lkotlin/Function1;", "", "getAllFriendList", "", "Lcom/wear/bean/me/OnlineStatusUserBean;", "getFriendListWithType", "type", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intersectFriendList", "list", "", "saveFriendList", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFriendOnlineStatus", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class lc3 {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static lc3 b;

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/me/repository/OnlineStatusRepository$Companion;", "", "()V", "onlineStatusRepository", "Lcom/wear/ui/me/repository/OnlineStatusRepository;", "newInstance", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final lc3 a() {
            lc3 lc3Var = lc3.b;
            if (lc3Var == null) {
                synchronized (this) {
                    lc3Var = lc3.b;
                    if (lc3Var == null) {
                        lc3Var = new lc3();
                        a aVar = lc3.a;
                        lc3.b = lc3Var;
                    }
                }
            }
            return lc3Var;
        }
    }

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.repository.OnlineStatusRepository$checkFriendOnlineStatus$1", f = "OnlineStatusRepository.kt", i = {0, 0}, l = {142}, m = "invokeSuspend", n = {"url$iv", "params$iv"}, s = {"L$0", "L$1"})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Boolean, Unit> $callback;
        public final /* synthetic */ OnlineStatusFriendCheckParam $checkParam;
        public Object L$0;
        public Object L$1;
        public int label;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements zn2<String> {
            public final /* synthetic */ yy3 a;

            /* compiled from: HttpCoroutine.kt */
            @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: dc.lc3$b$a$a, reason: collision with other inner class name */
            public static final class C0196a extends TypeToken<BaseResponseBeanNew<OnlineStatusFriendCheckResponse>> {
            }

            public a(yy3 yy3Var) {
                this.a = yy3Var;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NotNull String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new C0196a().getType());
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(OnlineStatusFriendCheckParam onlineStatusFriendCheckParam, Function1<? super Boolean, Unit> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$checkParam = onlineStatusFriendCheckParam;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$checkParam, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            OnlineStatusFriendCheckResponse onlineStatusFriendCheckResponse;
            Boolean open;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OnlineStatusFriendCheckParam onlineStatusFriendCheckParam = this.$checkParam;
                String strB = qx.b(onlineStatusFriendCheckParam.getFriend());
                Intrinsics.checkNotNullExpressionValue(strB, "dtxEncrypt(checkParam.friend)");
                onlineStatusFriendCheckParam.setFriend(strB);
                OnlineStatusFriendCheckParam onlineStatusFriendCheckParam2 = this.$checkParam;
                this.L$0 = "/userOnlineSetting/checkFriendSetting";
                this.L$1 = onlineStatusFriendCheckParam2;
                this.label = 1;
                zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
                zy3Var.A();
                tn2.x(WearUtils.x).m("/userOnlineSetting/checkFriendSetting", WearUtils.A.toJson(onlineStatusFriendCheckParam2), new a(zy3Var));
                obj = zy3Var.x();
                if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) obj;
            this.$callback.invoke(Boxing.boxBoolean((baseResponseBeanNew == null || (onlineStatusFriendCheckResponse = (OnlineStatusFriendCheckResponse) baseResponseBeanNew.data) == null || (open = onlineStatusFriendCheckResponse.getOpen()) == null) ? false : open.booleanValue()));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            String lowerCase;
            String showName = ((OnlineStatusUserBean) t).getShowName();
            String lowerCase2 = null;
            if (showName != null) {
                lowerCase = showName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            } else {
                lowerCase = null;
            }
            String showName2 = ((OnlineStatusUserBean) t2).getShowName();
            if (showName2 != null) {
                lowerCase2 = showName2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            return ComparisonsKt__ComparisonsKt.compareValues(lowerCase, lowerCase2);
        }
    }

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "invoke", "(Lcom/wear/bean/handlerbean/IPeopleInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<IPeopleInfo, Boolean> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@NotNull IPeopleInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf((it.isGroup() || Intrinsics.areEqual(it.getId(), "lovenseRemoteOfficial")) ? false : true);
        }
    }

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/wear/bean/me/OnlineStatusUserBean;", "it", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<IPeopleInfo, OnlineStatusUserBean> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OnlineStatusUserBean invoke(@NotNull IPeopleInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new OnlineStatusUserBean(it.getId(), it.getShowNickName(), it.getUserName(), it.getRemark(), it.getAvatar());
        }
    }

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/me/OnlineStatusUserBean;", "invoke", "(Lcom/wear/bean/me/OnlineStatusUserBean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<OnlineStatusUserBean, Boolean> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
        @Override // kotlin.jvm.functions.Function1
        @org.jetbrains.annotations.NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.wear.bean.me.OnlineStatusUserBean r4) {
            /*
                r3 = this;
                java.lang.String r0 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.wear.util.MyApplication r0 = com.wear.util.MyApplication.N()
                dc.n82 r0 = r0.i
                java.lang.String r1 = r4.getEmail()
                java.lang.String r1 = com.wear.util.WearUtils.i0(r1)
                boolean r0 = r0.k(r1)
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L2e
                java.lang.String r4 = r4.getNickname()
                if (r4 == 0) goto L2a
                int r4 = r4.length()
                if (r4 != 0) goto L28
                goto L2a
            L28:
                r4 = 0
                goto L2b
            L2a:
                r4 = 1
            L2b:
                if (r4 != 0) goto L2e
                goto L2f
            L2e:
                r1 = 0
            L2f:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.lc3.f.invoke(com.wear.bean.me.OnlineStatusUserBean):java.lang.Boolean");
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<OnlineStatusFriendListResponse>> {
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

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.repository.OnlineStatusRepository", f = "OnlineStatusRepository.kt", i = {1, 1, 1}, l = {70, 142}, m = "getFriendListWithType", n = {"this", "url$iv", "params$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class h extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
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
            return lc3.this.e(0, this);
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class i implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Object>> {
        }

        public i(yy3 yy3Var) {
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

    /* compiled from: OnlineStatusRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.repository.OnlineStatusRepository$setFriendOnlineStatus$1", f = "OnlineStatusRepository.kt", i = {0, 0}, l = {142}, m = "invokeSuspend", n = {"url$iv", "params$iv"}, s = {"L$0", "L$1"})
    public static final class j extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Boolean, Unit> $callback;
        public final /* synthetic */ OnlineStatusFriendCheckParam $checkParam;
        public Object L$0;
        public Object L$1;
        public int label;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements zn2<String> {
            public final /* synthetic */ yy3 a;

            /* compiled from: HttpCoroutine.kt */
            @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: dc.lc3$j$a$a, reason: collision with other inner class name */
            public static final class C0197a extends TypeToken<BaseResponseBeanNew<Object>> {
            }

            public a(yy3 yy3Var) {
                this.a = yy3Var;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NotNull String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new C0197a().getType());
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(OnlineStatusFriendCheckParam onlineStatusFriendCheckParam, Function1<? super Boolean, Unit> function1, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$checkParam = onlineStatusFriendCheckParam;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new j(this.$checkParam, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OnlineStatusFriendCheckParam onlineStatusFriendCheckParam = this.$checkParam;
                String strB = qx.b(onlineStatusFriendCheckParam.getFriend());
                Intrinsics.checkNotNullExpressionValue(strB, "dtxEncrypt(checkParam.friend)");
                onlineStatusFriendCheckParam.setFriend(strB);
                OnlineStatusFriendCheckParam onlineStatusFriendCheckParam2 = this.$checkParam;
                this.L$0 = "/userOnlineSetting/changeFriendSetting";
                this.L$1 = onlineStatusFriendCheckParam2;
                this.label = 1;
                zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
                zy3Var.A();
                tn2.x(WearUtils.x).m("/userOnlineSetting/changeFriendSetting", WearUtils.A.toJson(onlineStatusFriendCheckParam2), new a(zy3Var));
                obj = zy3Var.x();
                if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) obj;
            this.$callback.invoke(Boxing.boxBoolean(baseResponseBeanNew != null && baseResponseBeanNew.result));
            if (baseResponseBeanNew != null && baseResponseBeanNew.result) {
                hu3.s0();
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    @NotNull
    public static final lc3 g() {
        return a.a();
    }

    public final void c(@NotNull LifecycleCoroutineScope scope, @NotNull OnlineStatusFriendCheckParam checkParam, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(checkParam, "checkParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        uy3.d(scope, null, null, new b(checkParam, callback, null), 3, null);
    }

    public final List<OnlineStatusUserBean> d() {
        List<IPeopleInfo> users = ch3.i;
        Intrinsics.checkNotNullExpressionValue(users, "users");
        return SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filterNotNull(CollectionsKt___CollectionsKt.asSequence(users)), d.a), e.a), f.a), new c()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(int r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.wear.bean.me.OnlineStatusUserBean>> r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.lc3.e(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final List<OnlineStatusUserBean> f(@NotNull List<OnlineStatusUserBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<OnlineStatusUserBean> listD = d();
        for (OnlineStatusUserBean onlineStatusUserBean : listD) {
            onlineStatusUserBean.setSelected(list.contains(onlineStatusUserBean));
        }
        return listD;
    }

    @Nullable
    public final Object h(@NotNull List<OnlineStatusUserBean> list, int i2, @NotNull Continuation<? super Unit> continuation) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(qx.b(((OnlineStatusUserBean) it.next()).getEmail()));
        }
        OnlineStatusFriendListParam onlineStatusFriendListParam = new OnlineStatusFriendListParam(arrayList, i2 == 0 ? 1 : 2);
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/userOnlineSetting/saveFriendList", WearUtils.A.toJson(onlineStatusFriendListParam), new i(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }

    public final void i(@NotNull wz3 scope, @NotNull OnlineStatusFriendCheckParam checkParam, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(checkParam, "checkParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        uy3.d(scope, null, null, new j(checkParam, callback, null), 3, null);
    }
}
