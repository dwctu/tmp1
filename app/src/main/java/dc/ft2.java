package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import com.google.gson.JsonSyntaxException;
import com.wear.bean.chat.ChatMessage;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.NotifyClientOfflineBean;
import com.wear.bean.chat.NotifyClientonLineBean;
import com.wear.bean.chat.SignalingMessage;
import com.wear.bean.chat.SignalingToyMessage;
import com.wear.ext.AppInitializer;
import com.wear.ui.chat.action.im.ChatMessageHandler;
import com.wear.ui.chat.action.im.MessageHandlerDispatcher;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageManagerImpl.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\b\u00101\u001a\u00020-H\u0016J\u0012\u00102\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00104\u001a\u00020-H\u0016J\u0012\u00105\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00106\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00107\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0012\u0010;\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010<\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010=\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010>\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010?\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010@\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010A\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010B\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010C\u001a\u00020-H\u0016J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0016J\u000e\u0010H\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u0010I\u001a\u00020-2\u0006\u0010.\u001a\u00020/J#\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020OH\u0086Pø\u0001\u0000¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u0012\u0010U\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010V\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, d2 = {"Lcom/wear/ui/chat/manager/ChatMessageManagerImpl;", "Lcom/wear/main/socketio/SocketConnectListener;", "Lcom/wear/main/socketio/ISocketIoManager;", "Lcom/wear/ext/OnAppStatusChangedListener;", "()V", "TAG", "", "chatOfflinePullPresenter", "Lcom/wear/ui/chat/manager/ChatOfflinePullPresenter;", "continuationMap", "", "Lkotlin/coroutines/Continuation;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "im_ack_msg_deal_tc", "im_ack_new_msg_ts", "im_ack_send_msg_tc", "im_client_connect_tc", "im_client_disconnect_tc", "im_client_heartbeat_ts", "im_msg_receive_tc", "im_new_msg_ts", "im_send_msg_ts", "im_signaling_accept_tc", "im_signaling_accept_ts", "im_signaling_cancel_tc", "im_signaling_cancel_ts", "im_signaling_reject_tc", "im_signaling_reject_ts", "im_signaling_req_ack_tc", "im_signaling_req_ack_ts", "im_signaling_req_tc", "im_signaling_req_ts", "im_toy_order_tc", "im_toy_order_ts", "socketIoClient", "Lcom/wear/main/socketio/SocketIoClient;", "getSocketIoClient", "()Lcom/wear/main/socketio/SocketIoClient;", "socketIoClient$delegate", "Lkotlin/Lazy;", "toy_roulette_client_connect_ack_ts", "toy_roulette_client_panel_tc", "toy_roulette_toy_update_tc", "acceptSignaling", "", "signalingMessage", "Lcom/wear/bean/chat/SignalingMessage;", "cancelSignaling", "connectSuc", "continuationResume", NotificationCompat.CATEGORY_MESSAGE, "disConnect", "imAckMsgDealTc", "imAckSendMsgTc", "imClientConnectTc", "imClientDisconnectTc", "bean", "Lcom/wear/bean/chat/NotifyClientOfflineBean;", "imMsgReceiveTc", "imNewMsgTs", "imSignalingAcceptTc", "imSignalingCancelTc", "imSignalingRejectTc", "imSignalingReqAckTc", "imSignalingReqTc", "imToyOrderTc", "initListener", "onBackground", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "onForeground", "rejectSignaling", "requestSignaling", "sendMessage", "", "message", "Lcom/wear/bean/chat/Message;", "retryCount", "", "(Lcom/wear/bean/chat/Message;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendToyOrder", "signalingToyMessage", "Lcom/wear/bean/chat/SignalingToyMessage;", "startSignaling", "toyRouletteClientPanelTc", "toyRouletteToyUpdateTc", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ft2 implements tf2, ou1 {

    @NotNull
    public static final ft2 a;

    @NotNull
    public static final Lazy b;

    @NotNull
    public static final wz3 c;

    @NotNull
    public static gt2 d;

    @NotNull
    public static final Map<String, Continuation<String>> e;

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$connectSuc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {105, 106, 107}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[RETURN] */
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r6)
                goto L5e
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L51
            L21:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L44
            L25:
                kotlin.ResultKt.throwOnFailure(r6)
                android.app.Activity r6 = com.wear.ext.ActivityKt.e()
                if (r6 == 0) goto L37
                boolean r6 = r6 instanceof com.wear.ui.chat.NewChatActivity
                if (r6 == 0) goto L37
                dc.ny2 r6 = dc.ny2.a
                r6.i()
            L37:
                dc.gt2 r6 = dc.ft2.d()
                r5.label = r4
                java.lang.Object r6 = r6.b(r5)
                if (r6 != r0) goto L44
                return r0
            L44:
                dc.gt2 r6 = dc.ft2.d()
                r5.label = r3
                java.lang.Object r6 = r6.f(r5)
                if (r6 != r0) goto L51
                return r0
            L51:
                dc.gt2 r6 = dc.ft2.d()
                r5.label = r2
                java.lang.Object r6 = r6.e(r5)
                if (r6 != r0) goto L5e
                return r0
            L5e:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.ft2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imSignalingAcceptTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …ss.java\n                )");
            ht2Var.p((SignalingMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imSignalingCancelTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …ss.java\n                )");
            ht2Var.q((SignalingMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imSignalingRejectTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …ss.java\n                )");
            ht2Var.r((SignalingMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imSignalingReqAckTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …ss.java\n                )");
            ht2Var.s((SignalingMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imSignalingReqTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(\n         …ss.java\n                )");
            ht2Var.t((SignalingMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$imToyOrderTc$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $msg;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$msg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$msg, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws JsonSyntaxException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            if (str == null || str.length() == 0) {
                return Unit.INSTANCE;
            }
            ht2 ht2Var = ht2.a;
            Object objFromJson = WearUtils.A.fromJson(this.$msg, (Class<Object>) SignalingToyMessage.class);
            Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(msg, Signa…ngToyMessage::class.java)");
            ht2Var.u((SignalingToyMessage) objFromJson);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl", f = "ChatMessageManagerImpl.kt", i = {0, 0}, l = {394}, m = "sendMessage", n = {"timeoutDeferred", "serviceDeferred"}, s = {"L$2", "L$3"})
    public static final class h extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
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
            return ft2.this.u(null, 0, this);
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$sendMessage$msgId$1$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends SuspendLambda implements Function2 {
        public /* synthetic */ Object L$0;
        public int label;

        public i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable Void r1, @Nullable Continuation<? super String> continuation) {
            return ((i) create(r1, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            i iVar = new i(continuation);
            iVar.L$0 = obj;
            return iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (Void) this.L$0;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$sendMessage$msgId$1$2", f = "ChatMessageManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<String, Continuation<? super String>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable String str, @Nullable Continuation<? super String> continuation) {
            return ((j) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            j jVar = new j(continuation);
            jVar.L$0 = obj;
            return jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (String) this.L$0;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$sendMessage$serviceDeferred$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<wz3, Continuation<? super String>, Object> {
        public final /* synthetic */ Message $message;
        public Object L$0;
        public int label;

        /* compiled from: ChatMessageManagerImpl.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ Message $message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Message message) {
                super(1);
                this.$message = message;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Map map = ft2.e;
                TypeIntrinsics.asMutableMap(map).remove(this.$message.getMessageId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Message message, Continuation<? super k> continuation) {
            super(2, continuation);
            this.$message = message;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new k(this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super String> continuation) {
            return ((k) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Message message = this.$message;
                this.L$0 = message;
                this.label = 1;
                zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
                zy3Var.A();
                zy3Var.f(new a(message));
                Map map = ft2.e;
                String messageId = message.getMessageId();
                Intrinsics.checkNotNull(messageId);
                map.put(messageId, zy3Var);
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
            return obj;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.manager.ChatMessageManagerImpl$sendMessage$timeoutDeferred$1", f = "ChatMessageManagerImpl.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation, Object> {
        public int label;

        public l(Continuation<? super l> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (h04.a(10000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return null;
        }
    }

    /* compiled from: ChatMessageManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/main/socketio/SocketIoClient;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<uf2> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final uf2 invoke() {
            return uf2.v();
        }
    }

    static {
        ft2 ft2Var = new ft2();
        a = ft2Var;
        b = LazyKt__LazyJVMKt.lazy(m.a);
        wz3 wz3VarA = xz3.a(n04.c());
        c = wz3VarA;
        d = new gt2();
        AppInitializer.b.b(ft2Var);
        ChatMessageHandler.INSTANCE.register();
        ny2.a.c(wz3VarA);
        e = new LinkedHashMap();
    }

    public static /* synthetic */ Object v(ft2 ft2Var, Message message, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 3;
        }
        return ft2Var.u(message, i2, continuation);
    }

    @Override // dc.ou1
    public void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        MyApplication.N().O();
    }

    @Override // dc.ou1
    public void b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void c(@NotNull SignalingMessage signalingMessage) {
        Intrinsics.checkNotNullParameter(signalingMessage, "signalingMessage");
        uf2.v().D("im_signaling_accept_ts", signalingMessage);
    }

    @Override // dc.tf2
    public void connectSuc() {
        uy3.d(c, n04.b(), null, new a(null), 2, null);
    }

    @Override // dc.tf2
    public void disConnect() {
        ny2.a.m();
    }

    public final void f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("continuationResume start: continuationMap = ");
        Map<String, Continuation<String>> map = e;
        sb.append(map);
        sb.toString();
        ChatMessage chatMessage = (ChatMessage) WearUtils.A.fromJson(str, ChatMessage.class);
        Continuation<String> continuation = map.get(chatMessage.getMsgId());
        if (continuation != null) {
            Result.Companion companion = Result.INSTANCE;
            String msgId = chatMessage.getMsgId();
            Intrinsics.checkNotNull(msgId);
            continuation.resumeWith(Result.m86constructorimpl(msgId));
        }
        TypeIntrinsics.asMutableMap(map).remove(chatMessage.getMsgId());
        String str2 = "continuationResume end: continuationMap = " + map;
    }

    public final uf2 g() {
        Object value = b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-socketIoClient>(...)");
        return (uf2) value;
    }

    public final void h(@Nullable String str) {
        String str2 = "imAckMsgDealTc 消息流程结束：" + str;
    }

    public final void i(@Nullable String str) {
        String str2 = "imAckSendMsgTc：" + str;
        f(str);
    }

    public final void j(@Nullable String str) {
        NotifyClientonLineBean notifyClientonLineBean;
        if ((str == null || str.length() == 0) || (notifyClientonLineBean = (NotifyClientonLineBean) WearUtils.A.fromJson(str, NotifyClientonLineBean.class)) == null) {
            return;
        }
        ny2.a.g(notifyClientonLineBean);
    }

    public final void k(@Nullable NotifyClientOfflineBean notifyClientOfflineBean) {
        ny2.a.h(notifyClientOfflineBean);
    }

    public final void l(@Nullable String str) {
        String str2 = "imMsgReceiveTc 消息抵达对方：" + str;
    }

    public final void m(@Nullable String str) {
        String str2 = "imNewMsgTs: " + str;
        if (str == null || str.length() == 0) {
            String str3 = "message is null: " + str;
            return;
        }
        ChatMessage chatMessage = (ChatMessage) WearUtils.A.fromJson(str, ChatMessage.class);
        if (chatMessage.getType() == null) {
            return;
        }
        String strA = or2.a.a(chatMessage.getFrom(), chatMessage.getBody(), chatMessage.getEncryptionMode());
        if (strA == null || strA.length() == 0) {
            return;
        }
        chatMessage.setBody(nd3.n(strA));
        MessageHandlerDispatcher messageHandlerDispatcher = MessageHandlerDispatcher.INSTANCE;
        int iIntValue = chatMessage.getType().intValue();
        Intrinsics.checkNotNullExpressionValue(chatMessage, "chatMessage");
        messageHandlerDispatcher.invoke(iIntValue, chatMessage);
        g().D("im_ack_new_msg_ts", chatMessage);
    }

    public final void n(@Nullable String str) {
        String str2 = "imSignalingAcceptTc 接收接收方客户端接受连接：" + str;
        uy3.d(c, n04.c(), null, new b(str, null), 2, null);
    }

    public final void o(@Nullable String str) {
        String str2 = "imSignalingCancelTc 接收发送方客户端取消匹配：" + str;
        uy3.d(c, n04.c(), null, new c(str, null), 2, null);
    }

    public final void p(@Nullable String str) {
        String str2 = "imSignalingRejectTc 接收接收方客户端拒绝连接：" + str;
        uy3.d(c, n04.c(), null, new d(str, null), 2, null);
    }

    public final void q(@Nullable String str) {
        String str2 = "imSignalingReqAckTc 接收发送方发送开始信号：" + str;
        uy3.d(c, n04.c(), null, new e(str, null), 2, null);
    }

    public final void r(@Nullable String str) {
        String str2 = "imSignalingReqTc 接收发送方客户端请求进行连接：" + str;
        uy3.d(c, n04.c(), null, new f(str, null), 2, null);
    }

    public final void s(@Nullable String str) {
        String str2 = "imToyOrderTc 接收玩具指令：" + str;
        uy3.d(c, n04.c(), null, new g(str, null), 2, null);
    }

    public final void t(@NotNull SignalingMessage signalingMessage) {
        Intrinsics.checkNotNullParameter(signalingMessage, "signalingMessage");
        uf2.v().D("im_signaling_req_ts", signalingMessage);
    }

    /* JADX WARN: Path cross not found for [B:32:0x00f9, B:36:0x0102], limit reached: 44 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00e4 -> B:30:0x00ef). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(@org.jetbrains.annotations.NotNull com.wear.bean.chat.Message r21, int r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r23) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ft2.u(com.wear.bean.chat.Message, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void w(@NotNull SignalingToyMessage signalingToyMessage) {
        Intrinsics.checkNotNullParameter(signalingToyMessage, "signalingToyMessage");
        uf2.v().D("im_toy_order_ts", signalingToyMessage);
    }

    public final void x(@NotNull SignalingMessage signalingMessage) {
        Intrinsics.checkNotNullParameter(signalingMessage, "signalingMessage");
        uf2.v().D("im_signaling_req_ack_ts", signalingMessage);
    }

    public final void y(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ny2.a.o(str);
    }

    public final void z(@Nullable String str) {
        ny2.a.p(str);
    }
}
