package dc;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.wear.bean.RoulettePublicBean;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.chat.ChatMessage;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.ext.ActivityKt;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.is3;
import dc.kr2;
import dc.wz1;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: ChatOfflinePullPresenter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u000fH\u0086Pø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/manager/ChatOfflinePullPresenter;", "", "()V", "chatMessageAction", "Lcom/wear/ui/chat/action/ChatMessageAction;", "getChatMessageAction", "()Lcom/wear/ui/chat/action/ChatMessageAction;", "chatMessageAction$delegate", "Lkotlin/Lazy;", "messageDatabase", "Lcom/wear/ui/chat/db/MessageDatabase;", "getMessageDatabase", "()Lcom/wear/ui/chat/db/MessageDatabase;", "messageDatabase$delegate", "generateDHCode", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reConnectRoom", "startPullOfflineMessage", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class gt2 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/action/ChatMessageAction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<kr2> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kr2 invoke() {
            return kr2.c.a(kr2.b.MESSAGE);
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGet$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements yn2<BaseResponseBeanNew<RoulettePublicBean>> {
        public final /* synthetic */ yy3 a;
        public final /* synthetic */ String b;

        public b(yy3 yy3Var, String str) {
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
    public static final class c implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Object>> {
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

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatOfflinePullPresenter", f = "ChatOfflinePullPresenter.kt", i = {0, 0, 0, 1, 1}, l = {200, 215}, m = "generateDHCode", n = {"publicKeyName", "primaryKeyName", "url$iv", "url$iv", "params$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class d extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return gt2.this.b(this);
        }
    }

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/db/MessageDatabaseIml;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<ys2> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ys2 invoke() {
            return ys2.b.a();
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGet$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements yn2<BaseResponseBeanNew<UserJoinChatBean>> {
        public final /* synthetic */ yy3 a;
        public final /* synthetic */ String b;

        public f(yy3 yy3Var, String str) {
            this.a = yy3Var;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull BaseResponseBeanNew<UserJoinChatBean> response) {
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

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatOfflinePullPresenter", f = "ChatOfflinePullPresenter.kt", i = {0, 0}, l = {200, 121}, m = "reConnectRoom", n = {"this", "url$iv"}, s = {"L$0", "L$1"})
    public static final class g extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
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
            return gt2.this.e(this);
        }
    }

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatOfflinePullPresenter$reConnectRoom$2", f = "ChatOfflinePullPresenter.kt", i = {}, l = {Opcodes.IFNULL, 159, 161}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ UserJoinChatBean $userJoinChatBean;
        public int label;
        public final /* synthetic */ gt2 this$0;

        /* compiled from: ChatOfflinePullPresenter.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onConsumerDialogRequest"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a implements wz1.a {
            public final /* synthetic */ yy3<Boolean> a;

            /* compiled from: ChatOfflinePullPresenter.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "doConfirm"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: dc.gt2$h$a$a, reason: collision with other inner class name */
            public static final class C0181a implements is3.d {
                public final /* synthetic */ yy3<Boolean> a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0181a(yy3<? super Boolean> yy3Var) {
                    this.a = yy3Var;
                }

                @Override // dc.is3.d
                public final void doConfirm() {
                    yy3<Boolean> yy3Var = this.a;
                    Result.Companion companion = Result.INSTANCE;
                    yy3Var.resumeWith(Result.m86constructorimpl(Boolean.TRUE));
                    vz1.b(wz1.b.ROULETTE);
                }
            }

            /* compiled from: ChatOfflinePullPresenter.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "doCancel"}, k = 3, mv = {1, 7, 1}, xi = 48)
            public static final class b implements is3.c {
                public final /* synthetic */ yy3<Boolean> a;

                /* JADX WARN: Multi-variable type inference failed */
                public b(yy3<? super Boolean> yy3Var) {
                    this.a = yy3Var;
                }

                @Override // dc.is3.c
                public final void doCancel() {
                    yy3<Boolean> yy3Var = this.a;
                    Result.Companion companion = Result.INSTANCE;
                    yy3Var.resumeWith(Result.m86constructorimpl(Boolean.FALSE));
                    vz1.b(wz1.b.ROULETTE);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(yy3<? super Boolean> yy3Var) {
                this.a = yy3Var;
            }

            @Override // dc.wz1.a
            public final void a() {
                Activity activityE = ActivityKt.e();
                String strE = ah4.e(R.string.notification_estabished_control);
                String strE2 = ah4.e(R.string.common_confirm);
                String strE3 = ah4.e(R.string.common_cancel);
                yy3<Boolean> yy3Var = this.a;
                cs3.d(activityE, strE, strE2, strE3, new C0181a(yy3Var), new b(yy3Var)).show();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(UserJoinChatBean userJoinChatBean, gt2 gt2Var, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$userJoinChatBean = userJoinChatBean;
            this.this$0 = gt2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$userJoinChatBean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L28
                if (r1 == r5) goto L24
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                kotlin.ResultKt.throwOnFailure(r14)
                goto Ldf
            L17:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1f:
                kotlin.ResultKt.throwOnFailure(r14)
                goto Lbd
            L24:
                kotlin.ResultKt.throwOnFailure(r14)
                goto L58
            L28:
                kotlin.ResultKt.throwOnFailure(r14)
                r13.label = r5
                dc.zy3 r14 = new dc.zy3
                kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r13)
                r14.<init>(r1, r5)
                r14.A()
                dc.wz1 r1 = new dc.wz1
                dc.wz1$b r6 = dc.wz1.b.ROULETTE
                dc.gt2$h$a r7 = new dc.gt2$h$a
                r7.<init>(r14)
                r1.<init>(r6, r7)
                dc.vz1.a(r1)
                java.lang.Object r14 = r14.x()
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r14 != r1) goto L55
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r13)
            L55:
                if (r14 != r0) goto L58
                return r0
            L58:
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto La6
                com.wear.bean.chat.RouletteUser r14 = new com.wear.bean.chat.RouletteUser
                r14.<init>()
                com.wear.bean.UserJoinChatBean r0 = r13.$userJoinChatBean
                java.lang.String r0 = r0.getUserAccountCode()
                r14.setFriendId(r0)
                com.wear.bean.UserJoinChatBean r0 = r13.$userJoinChatBean
                com.wear.bean.RoulettePublicBean r0 = r0.getPublicKey()
                if (r0 == 0) goto L7b
                java.lang.String r1 = r0.getData()
                goto L7c
            L7b:
                r1 = r2
            L7c:
                if (r1 == 0) goto L85
                java.lang.String r0 = r0.getData()
                r14.setPublicKey(r0)
            L85:
                com.wear.dao.RouletteUserDao r0 = com.wear.dao.DaoUtils.getRouletteUserDao()
                r0.add(r14)
                com.wear.bean.UserJoinChatBean r14 = r13.$userJoinChatBean
                r14.setFromOuter(r5)
                android.app.Activity r7 = com.wear.ext.ActivityKt.e()
                if (r7 == 0) goto Lf3
                com.wear.bean.UserJoinChatBean r8 = r13.$userJoinChatBean
                com.wear.ui.chat.NewChatActivity$a r6 = com.wear.ui.chat.NewChatActivity.n
                r9 = 1
                r10 = 0
                r11 = 8
                r12 = 0
                com.wear.ui.chat.NewChatActivity.a.b(r6, r7, r8, r9, r10, r11, r12)
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                goto Lf3
            La6:
                com.wear.util.MyApplication r14 = com.wear.util.WearUtils.x
                r1 = 0
                java.lang.String r2 = "isInRouletteRoom"
                dc.eg3.j(r14, r2, r1)
                dc.gt2 r14 = r13.this$0
                dc.kr2 r14 = dc.gt2.a(r14)
                r13.label = r4
                java.lang.Object r14 = r14.g(r13)
                if (r14 != r0) goto Lbd
                return r0
            Lbd:
                com.wear.dao.RouletteUserDao r14 = com.wear.dao.DaoUtils.getRouletteUserDao()
                com.wear.bean.UserJoinChatBean r1 = r13.$userJoinChatBean
                java.lang.String r1 = r1.getUserAccountCode()
                r14.delete(r1)
                dc.gt2 r14 = r13.this$0
                dc.kr2 r14 = dc.gt2.a(r14)
                com.wear.bean.UserJoinChatBean r1 = r13.$userJoinChatBean
                java.lang.String r1 = r1.getUserAccountCode()
                r13.label = r3
                java.lang.Object r14 = r14.l(r1, r13)
                if (r14 != r0) goto Ldf
                return r0
            Ldf:
                dc.my2$c r14 = dc.my2.i
                dc.my2 r0 = r14.a()
                com.wear.bean.UserJoinChatBean r1 = r13.$userJoinChatBean
                r0.s(r1)
                dc.my2 r14 = r14.a()
                r14.D(r5)
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
            Lf3:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.gt2.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGet$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class i implements yn2<BaseResponseBeanNew<List<? extends ChatMessage>>> {
        public final /* synthetic */ yy3 a;
        public final /* synthetic */ String b;

        public i(yy3 yy3Var, String str) {
            this.a = yy3Var;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull BaseResponseBeanNew<List<? extends ChatMessage>> response) {
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
    public static final class j implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Unit>> {
        }

        public j(yy3 yy3Var) {
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
    public static final class k implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<Unit>> {
        }

        public k(yy3 yy3Var) {
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

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class l<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Long seq = ((ChatMessage) t).getSeq();
            Long lValueOf = Long.valueOf(seq != null ? seq.longValue() : 0L);
            Long seq2 = ((ChatMessage) t2).getSeq();
            return ComparisonsKt__ComparisonsKt.compareValues(lValueOf, Long.valueOf(seq2 != null ? seq2.longValue() : 0L));
        }
    }

    /* compiled from: ChatOfflinePullPresenter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatOfflinePullPresenter", f = "ChatOfflinePullPresenter.kt", i = {0, 1, 2, 2, 2}, l = {200, 219, 236}, m = "startPullOfflineMessage", n = {"url$iv", "url$iv", "chatMessageList", "msgIdList", "url$iv"}, s = {"L$1", "L$0", "L$1", "L$2", "L$3"})
    public static final class m extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public m(Continuation<? super m> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return gt2.this.f(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gt2.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final kr2 c() {
        return (kr2) this.b.getValue();
    }

    public final xs2 d() {
        return (xs2) this.a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            boolean r0 = r11 instanceof dc.gt2.g
            if (r0 == 0) goto L13
            r0 = r11
            dc.gt2$g r0 = (dc.gt2.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dc.gt2$g r0 = new dc.gt2$g
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "isInRouletteRoom"
            r4 = 2
            r5 = 0
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L45
            if (r2 == r7) goto L39
            if (r2 != r4) goto L31
            kotlin.ResultKt.throwOnFailure(r11)
            goto Ld0
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L39:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r0.L$0
            dc.gt2 r2 = (dc.gt2) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L88
        L45:
            kotlin.ResultKt.throwOnFailure(r11)
            android.app.Application r11 = dc.bu1.a()
            boolean r11 = dc.eg3.d(r11, r3, r5)
            if (r11 != 0) goto L55
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L55:
            java.lang.String r11 = "/wear/toyRoulette/check-in-room"
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r7
            dc.zy3 r2 = new dc.zy3
            kotlin.coroutines.Continuation r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r2.<init>(r8, r7)
            r2.A()
            com.wear.util.MyApplication r8 = com.wear.util.WearUtils.x
            dc.tn2 r8 = dc.tn2.x(r8)
            dc.gt2$f r9 = new dc.gt2$f
            r9.<init>(r2, r6)
            r8.d(r11, r9)
            java.lang.Object r11 = r2.x()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r11 != r2) goto L84
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L84:
            if (r11 != r1) goto L87
            return r1
        L87:
            r2 = r10
        L88:
            com.wear.bean.UserJoinChatBean r11 = (com.wear.bean.UserJoinChatBean) r11
            if (r11 == 0) goto Ld1
            java.lang.String r8 = r11.getUserAccountCode()
            if (r8 == 0) goto L9a
            int r8 = r8.length()
            if (r8 != 0) goto L99
            goto L9a
        L99:
            r7 = 0
        L9a:
            if (r7 == 0) goto L9d
            goto Ld1
        L9d:
            android.app.Activity r3 = com.wear.ext.ActivityKt.e()
            if (r3 != 0) goto La6
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        La6:
            android.app.Activity r3 = com.wear.ext.ActivityKt.e()
            boolean r3 = r3 instanceof com.wear.ui.chat.NewChatActivity
            if (r3 == 0) goto Lb1
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lb1:
            dc.my2$c r3 = dc.my2.i
            dc.my2 r3 = r3.a()
            r3.C()
            dc.s14 r3 = dc.n04.c()
            dc.gt2$h r5 = new dc.gt2$h
            r5.<init>(r11, r2, r6)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r11 = dc.sy3.g(r3, r5, r0)
            if (r11 != r1) goto Ld0
            return r1
        Ld0:
            return r11
        Ld1:
            android.app.Application r11 = dc.bu1.a()
            dc.eg3.j(r11, r3, r5)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gt2.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x003f, code lost:
    
        if (r15 != r1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.gt2.f(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
