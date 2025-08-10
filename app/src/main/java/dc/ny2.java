package dc;

import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.chat.NotifyClientLineTcBean;
import com.wear.bean.chat.NotifyClientOfflineBean;
import com.wear.bean.chat.NotifyClientonLineBean;
import com.wear.bean.chat.NotifyToysStatusBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.date.request.AppUserToysBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.RouletteUserDao;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.h14;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: RouletteHeartbeatAction.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0010\u0010\u001c\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fJ\u0011\u0010 \u001a\u00020\u0010H\u0082Pø\u0001\u0000¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0012J\u0010\u0010&\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/wear/ui/discover/roulette/action/RouletteHeartbeatAction;", "", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "job", "Lkotlinx/coroutines/Job;", "rouletteHeartbeatListener", "Lcom/wear/ui/discover/roulette/action/RouletteHeartbeatAction$RouletteHeartbeatListener;", "socketIoClient", "Lcom/wear/main/socketio/SocketIoClient;", "getSocketIoClient", "()Lcom/wear/main/socketio/SocketIoClient;", "socketIoClient$delegate", "Lkotlin/Lazy;", "bindCoroutineScope", "", "getEnPersData", "", "pers", "getEnUsernameData", "userName", "imClientConnectTc", "bean", "Lcom/wear/bean/chat/NotifyClientonLineBean;", "imClientDisconnectTc", "Lcom/wear/bean/chat/NotifyClientOfflineBean;", "reconnectSocketIO", "setRouletteHeartbeatListener", "startHeartbeat", "isReconnect", "", "startHeartbeatLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "statusUpdate", "stopHeartbeat", "toyRouletteClientPanelTc", NotificationCompat.CATEGORY_MESSAGE, "toyRouletteToyUpdateTc", "RouletteHeartbeatListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ny2 {

    @NotNull
    public static final ny2 a = new ny2();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(e.a);

    @Nullable
    public static wz3 c;

    @Nullable
    public static h14 d;

    @Nullable
    public static a e;

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/wear/ui/discover/roulette/action/RouletteHeartbeatAction$RouletteHeartbeatListener;", "", "onHeartbeatSendSystemMessage", "", "text", "", "onRouletteClientPanel", "notifyClientLineTcBean", "Lcom/wear/bean/chat/NotifyClientLineTcBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void G1(@NotNull String str);

        void U0(@Nullable NotifyClientLineTcBean notifyClientLineTcBean);
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$imClientConnectTc$1", f = "RouletteHeartbeatAction.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ NotifyClientonLineBean $bean;
        public int label;

        /* compiled from: RouletteHeartbeatAction.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$imClientConnectTc$1$1", f = "RouletteHeartbeatAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                String text = ah4.e(R.string.control_link_user_reconnected);
                a aVar = ny2.e;
                if (aVar == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(text, "text");
                aVar.G1(text);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NotifyClientonLineBean notifyClientonLineBean, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$bean = notifyClientonLineBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$bean, continuation);
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
                NotifyClientonLineBean notifyClientonLineBean = this.$bean;
                String userAccountCode = notifyClientonLineBean != null ? notifyClientonLineBean.getUserAccountCode() : null;
                if (userAccountCode == null || userAccountCode.length() == 0) {
                    return Unit.INSTANCE;
                }
                RouletteUserDao rouletteUserDao = DaoUtils.getRouletteUserDao();
                NotifyClientonLineBean notifyClientonLineBean2 = this.$bean;
                Intrinsics.checkNotNull(notifyClientonLineBean2);
                String userAccountCode2 = notifyClientonLineBean2.getUserAccountCode();
                Intrinsics.checkNotNull(userAccountCode2);
                if (!rouletteUserDao.isOfflineBefore(userAccountCode2)) {
                    return Unit.INSTANCE;
                }
                s14 s14VarC = n04.c();
                a aVar = new a(null);
                this.label = 1;
                if (sy3.g(s14VarC, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String userAccountCode3 = this.$bean.getUserAccountCode();
            if (userAccountCode3 != null) {
                DaoUtils.getRouletteUserDao().updateOfflineBefore(userAccountCode3, false);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$imClientDisconnectTc$2", f = "RouletteHeartbeatAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String text = ah4.e(R.string.control_link_user_disconnected);
            a aVar = ny2.e;
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                aVar.G1(text);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$reconnectSocketIO$1", f = "RouletteHeartbeatAction.kt", i = {0, 0}, l = {218}, m = "invokeSuspend", n = {"url$iv", "map$iv"}, s = {"L$0", "L$1"})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePostForm$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements yn2<BaseResponseBeanNew<Object>> {
            public final /* synthetic */ yy3 a;

            public a(yy3 yy3Var) {
                this.a = yy3Var;
            }

            @Override // dc.yn2, dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable BaseResponseBeanNew<Object> baseResponseBeanNew) {
                yy3 yy3Var = this.a;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
            }

            @Override // dc.yn2
            public void onCompleted() {
            }

            @Override // dc.yn2, dc.zn2
            public void onError(@Nullable NetException e) {
                yy3 yy3Var = this.a;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(null));
            }

            @Override // dc.yn2
            public void onStart() {
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map<String, Object> mapEmptyMap = MapsKt__MapsKt.emptyMap();
                this.L$0 = "/wear/toyRoulette/re-connect";
                this.L$1 = mapEmptyMap;
                this.label = 1;
                zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
                zy3Var.A();
                tn2.x(WearUtils.x).i("/wear/toyRoulette/re-connect", mapEmptyMap, new a(zy3Var));
                Object objX = zy3Var.x();
                if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (objX == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/main/socketio/SocketIoClient;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<uf2> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final uf2 invoke() {
            return uf2.v();
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$startHeartbeat$1", f = "RouletteHeartbeatAction.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ny2 ny2Var = ny2.a;
                this.label = 1;
                if (ny2Var.l(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction", f = "RouletteHeartbeatAction.kt", i = {}, l = {85}, m = "startHeartbeatLoop", n = {}, s = {})
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
            return ny2.this.l(this);
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$statusUpdate$1", f = "RouletteHeartbeatAction.kt", i = {0, 0}, l = {218}, m = "invokeSuspend", n = {"url$iv", "params$iv"}, s = {"L$0", "L$1"})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ AppUserToysBean $appUserToysBean;
        public Object L$0;
        public Object L$1;
        public int label;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements zn2<String> {
            public final /* synthetic */ yy3 a;

            /* compiled from: HttpCoroutine.kt */
            @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: dc.ny2$h$a$a, reason: collision with other inner class name */
            public static final class C0205a extends TypeToken<BaseResponseBeanNew<Object>> {
            }

            public a(yy3 yy3Var) {
                this.a = yy3Var;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NotNull String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new C0205a().getType());
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
        public h(AppUserToysBean appUserToysBean, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$appUserToysBean = appUserToysBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$appUserToysBean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppUserToysBean appUserToysBean = this.$appUserToysBean;
                this.L$0 = "/toy/statusUpdate";
                this.L$1 = appUserToysBean;
                this.label = 1;
                zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
                zy3Var.A();
                tn2.x(WearUtils.x).m("/toy/statusUpdate", WearUtils.A.toJson(appUserToysBean), new a(zy3Var));
                Object objX = zy3Var.x();
                if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (objX == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$toyRouletteClientPanelTc$1", f = "RouletteHeartbeatAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, Continuation<? super i> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new i(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotifyClientLineTcBean notifyClientLineTcBean = (NotifyClientLineTcBean) WearUtils.A.fromJson(this.$msg, NotifyClientLineTcBean.class);
            a aVar = ny2.e;
            if (aVar != null) {
                aVar.U0(notifyClientLineTcBean);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHeartbeatAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.action.RouletteHeartbeatAction$toyRouletteToyUpdateTc$1", f = "RouletteHeartbeatAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            j jVar = new j(this.$msg, continuation);
            jVar.L$0 = obj;
            return jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Resources.NotFoundException {
            User user;
            Object objM86constructorimpl;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (!(str == null || str.length() == 0) && my2.i.a().getB()) {
                NotifyToysStatusBean notifyToysStatusBean = (NotifyToysStatusBean) WearUtils.A.fromJson(this.$msg, NotifyToysStatusBean.class);
                if (notifyToysStatusBean != null && (user = (User) ChatLiveControl.q0().J()) != null) {
                    Intrinsics.checkNotNullExpressionValue(user, "ChatLiveControl.getInstance().user ?: return@let");
                    if (Intrinsics.areEqual(user.getUserCode(), notifyToysStatusBean.getAppAccountCode())) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            user.updateSyncLinkToy(notifyToysStatusBean.getToys());
                            objM86constructorimpl = Result.m86constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM86constructorimpl = Result.m86constructorimpl(ResultKt.createFailure(th));
                        }
                        Throwable thM89exceptionOrNullimpl = Result.m89exceptionOrNullimpl(objM86constructorimpl);
                        if (thM89exceptionOrNullimpl != null) {
                            FirebaseCrashlytics.getInstance().recordException(new Throwable("updateSyncLinkToy 异常, " + user.getUserCode(), thM89exceptionOrNullimpl));
                        }
                        UserJoinChatBean c = my2.i.a().getC();
                        if (c != null) {
                            c.setToys(notifyToysStatusBean.getToys());
                        }
                        ChatLiveControl.q0().S();
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    public final void c(@NotNull wz3 coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        c = coroutineScope;
    }

    public final String d(String str) {
        return CommunMessage.encryp(str);
    }

    public final String e(String str) {
        return nd3.q(str);
    }

    public final uf2 f() {
        Object value = b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-socketIoClient>(...)");
        return (uf2) value;
    }

    public final void g(@Nullable NotifyClientonLineBean notifyClientonLineBean) {
        String userAccountCode = notifyClientonLineBean != null ? notifyClientonLineBean.getUserAccountCode() : null;
        if (userAccountCode == null || userAccountCode.length() == 0) {
            return;
        }
        String userAccountCode2 = notifyClientonLineBean != null ? notifyClientonLineBean.getUserAccountCode() : null;
        String appAccountCode = ch3.n().o().getAppAccountCode();
        String strR = na2.m().r();
        Intrinsics.checkNotNullExpressionValue(strR, "getInstance().panelStatusString");
        uf2.v().D("toy_roulette_client_connect_ack_ts", new NotifyClientLineTcBean(userAccountCode2, appAccountCode, strR));
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, n04.b(), null, new b(notifyClientonLineBean, null), 2, null);
        }
    }

    public final void h(@Nullable NotifyClientOfflineBean notifyClientOfflineBean) {
        String appAccountCode;
        if (notifyClientOfflineBean != null && (appAccountCode = notifyClientOfflineBean.getAppAccountCode()) != null) {
            DaoUtils.getRouletteUserDao().updateOfflineBefore(appAccountCode, true);
        }
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, n04.c(), null, new c(null), 2, null);
        }
    }

    public final void i() {
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, null, null, new d(null), 3, null);
        }
    }

    public final void j(@Nullable a aVar) {
        e = aVar;
    }

    public final void k(boolean z) {
        if (z) {
            i();
        }
        wz3 wz3Var = c;
        d = wz3Var != null ? uy3.d(wz3Var, null, null, new f(null), 3, null) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof dc.ny2.g
            if (r0 == 0) goto L13
            r0 = r7
            dc.ny2$g r0 = (dc.ny2.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dc.ny2$g r0 = new dc.ny2$g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r2 = r0.L$0
            dc.ny2 r2 = (dc.ny2) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L39
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r6
        L39:
            dc.uf2 r7 = r2.f()
            java.lang.String r4 = "im_client_heartbeat_ts"
            r7.F(r4)
            r4 = 8000(0x1f40, double:3.9525E-320)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = dc.h04.a(r4, r0)
            if (r7 != r1) goto L39
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ny2.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void m() {
        Account accountU = ch3.n().u();
        String id = accountU != null ? accountU.getId() : null;
        if (id == null) {
            return;
        }
        SyncLinkToy syncLinkToy = new SyncLinkToy();
        syncLinkToy.setPlatform(DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        syncLinkToy.setV(100);
        syncLinkToy.setVersion(ye3.s());
        pc1 pc1Var = pc1.a;
        if (pc1Var.o().size() > 0) {
            Iterator<Toy> it = pc1Var.o().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                SyncLinkToy.ToysBean toysBeanFromToy = SyncLinkToy.getToysBeanFromToy(next);
                if (next.isSupportLdr()) {
                    toysBeanFromToy.setIsSupportLdr(1);
                }
                if (next.isSelect()) {
                    syncLinkToy.addToys(toysBeanFromToy);
                }
            }
        }
        AppUserToysBean appUserToysBean = new AppUserToysBean();
        appUserToysBean.toys = "";
        String sss = JSON.toJSONString(syncLinkToy);
        Intrinsics.checkNotNullExpressionValue(sss, "sss");
        appUserToysBean.toyJson = d(sss);
        int size = pc1.a.P().size();
        for (int i2 = 0; i2 < size; i2++) {
            appUserToysBean.toys += pc1.a.P().get(i2).getName();
            if (i2 < size - 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(appUserToysBean.toys);
                sb.append(',');
                appUserToysBean.toys = sb.toString();
            }
        }
        appUserToysBean.userName = e(id);
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, null, null, new h(appUserToysBean, null), 3, null);
        }
    }

    public final void n() {
        h14 h14Var = d;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        d = null;
    }

    public final void o(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, n04.c(), null, new i(msg, null), 2, null);
        }
    }

    public final void p(@Nullable String str) {
        wz3 wz3Var = c;
        if (wz3Var != null) {
            uy3.d(wz3Var, n04.c(), null, new j(str, null), 2, null);
        }
    }
}
