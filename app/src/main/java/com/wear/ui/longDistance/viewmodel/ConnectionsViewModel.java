package com.wear.ui.longDistance.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.C;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.lovense.wear.R;
import com.wear.bean.ConnectionUserBean;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.ui.longDistance.viewmodel.ConnectionsViewModel;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.bo3;
import dc.ch3;
import dc.df3;
import dc.ea3;
import dc.ep1;
import dc.g44;
import dc.gp1;
import dc.h04;
import dc.h14;
import dc.hu3;
import dc.ip1;
import dc.n82;
import dc.o44;
import dc.q44;
import dc.r93;
import dc.sg3;
import dc.t34;
import dc.uy3;
import dc.v34;
import dc.wz3;
import dc.ye3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: ConnectionsViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014J2\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014J2\u0010\u0019\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/wear/ui/longDistance/viewmodel/ConnectionsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_connectionsIntentFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "connectionsIntentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionsIntentFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "connectionsRepository", "Lcom/wear/ui/longDistance/repository/ConnectionsRepository;", "requestUser", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/wear/bean/ConnectionUserBean;", "acceptUserRequest", "", "userBean", "showProgress", "Lkotlin/Function0;", "dismissProgress", "rejectUserRequest", "context", "Landroid/content/Context;", "trySendXmppMessage", AMPExtension.Action.ATTRIBUTE_NAME, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsViewModel extends ViewModel {

    @NotNull
    public final ea3 a;

    @NotNull
    public final t34<List<ConnectionUserBean>> b;

    @NotNull
    public final g44<r93> c;

    @NotNull
    public final o44<r93> d;

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.viewmodel.ConnectionsViewModel$1", f = "ConnectionsViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: ConnectionsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "", "Lcom/wear/bean/ConnectionUserBean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.longDistance.viewmodel.ConnectionsViewModel$1$1", f = "ConnectionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.wear.ui.longDistance.viewmodel.ConnectionsViewModel$a$a, reason: collision with other inner class name */
        public static final class C0153a extends SuspendLambda implements Function2<List<ConnectionUserBean>, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ ConnectionsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0153a(ConnectionsViewModel connectionsViewModel, Continuation<? super C0153a> continuation) {
                super(2, continuation);
                this.this$0 = connectionsViewModel;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull List<ConnectionUserBean> list, @Nullable Continuation<? super Unit> continuation) {
                return ((C0153a) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C0153a c0153a = new C0153a(this.this$0, continuation);
                c0153a.L$0 = obj;
                return c0153a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.c.setValue(new r93.c((List) this.L$0));
                return Unit.INSTANCE;
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ConnectionsViewModel.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                t34 t34Var = ConnectionsViewModel.this.b;
                C0153a c0153a = new C0153a(ConnectionsViewModel.this, null);
                this.label = 1;
                if (v34.g(t34Var, c0153a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ConnectionsViewModel.this.c.setValue(new r93.b(ConnectionsViewModel.this.a.c()));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $email;
        public final /* synthetic */ ConnectionsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, ConnectionsViewModel connectionsViewModel) {
            super(0);
            this.$email = str;
            this.this$0 = connectionsViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            hu3.a(this.$email);
            User userT = ch3.n().t(this.$email);
            if (userT != null) {
                String str = this.$email;
                userT.resetFriendType(1);
                ch3.j.remove(userT);
                ch3.i.add(userT);
                UserSetting userSettingZ = WearUtils.y.z(str);
                userSettingZ.setFriendsRequestClick(true);
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                df3.e().c(userT.getId());
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ah4.e(R.string.str_add_friends_suc);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.str_add_friends_suc)");
                String str2 = String.format(strE, Arrays.copyOf(new Object[]{userT.getUserName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                sg3.l(str2);
            }
            ye3.d("F0012", WearUtils.A.toJson(MapsKt__MapsKt.mapOf(TuplesKt.to("who_oppo", this.$email), TuplesKt.to("invite_result", 1))));
            String str3 = this.$email;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            this.this$0.c.setValue(new r93.a(this.$email));
            this.this$0.c.setValue(new r93.b(this.this$0.a.c()));
        }
    }

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $email;
        public final /* synthetic */ ConnectionUserBean $userBean;
        public final /* synthetic */ ConnectionsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, ConnectionUserBean connectionUserBean, ConnectionsViewModel connectionsViewModel) {
            super(0);
            this.$email = str;
            this.$userBean = connectionUserBean;
            this.this$0 = connectionsViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            hu3.Z(this.$email);
            User userT = ch3.n().t(this.$email);
            boolean z = true;
            if (userT != null) {
                String str = this.$email;
                ConnectionUserBean connectionUserBean = this.$userBean;
                userT.resetFriendType(16);
                ch3.j.remove(userT);
                UserSetting userSettingZ = WearUtils.y.z(str);
                userSettingZ.setFriendsRequestClick(false);
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ah4.e(R.string.str_decline_add_friends_suc);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.str_decline_add_friends_suc)");
                String str2 = String.format(strE, Arrays.copyOf(new Object[]{connectionUserBean.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                sg3.l(str2);
                ye3.d("F0012", WearUtils.A.toJson(MapsKt__MapsKt.mapOf(TuplesKt.to("who_oppo", str), TuplesKt.to("invite_result", 0))));
            }
            String email = this.$userBean.getEmail();
            if (email != null && email.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            this.this$0.c.setValue(new r93.d(this.$userBean.getEmail()));
        }
    }

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0<Unit> $dismissProgress;
        public final /* synthetic */ String $email;
        public final /* synthetic */ Function0<Unit> $showProgress;
        public final /* synthetic */ ConnectionUserBean $userBean;
        public final /* synthetic */ ConnectionsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0<Unit> function0, String str, Function0<Unit> function02, ConnectionUserBean connectionUserBean, ConnectionsViewModel connectionsViewModel) {
            super(0);
            this.$showProgress = function0;
            this.$email = str;
            this.$dismissProgress = function02;
            this.$userBean = connectionUserBean;
            this.this$0 = connectionsViewModel;
        }

        public static final void a(Function0 dismissProgress, ConnectionUserBean userBean, String str, ConnectionsViewModel this$0, boolean z) {
            Intrinsics.checkNotNullParameter(dismissProgress, "$dismissProgress");
            Intrinsics.checkNotNullParameter(userBean, "$userBean");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dismissProgress.invoke();
            if (z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ah4.e(R.string.str_block_add_friends_suc);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.str_block_add_friends_suc)");
                boolean z2 = true;
                String str2 = String.format(strE, Arrays.copyOf(new Object[]{userBean.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                sg3.l(str2);
                ye3.d("F0012", WearUtils.A.toJson(MapsKt__MapsKt.mapOf(TuplesKt.to("who_oppo", str), TuplesKt.to("invite_result", 2))));
                String email = userBean.getEmail();
                if (email != null && email.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
                this$0.c.setValue(new r93.d(userBean.getEmail()));
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$showProgress.invoke();
            n82 n82Var = WearUtils.x.i;
            String strI0 = WearUtils.i0(this.$email);
            final Function0<Unit> function0 = this.$dismissProgress;
            final ConnectionUserBean connectionUserBean = this.$userBean;
            final String str = this.$email;
            final ConnectionsViewModel connectionsViewModel = this.this$0;
            n82Var.b(strI0, 1, new n82.d() { // from class: dc.ma3
                @Override // dc.n82.d
                public final void a(boolean z) {
                    ConnectionsViewModel.d.a(function0, connectionUserBean, str, connectionsViewModel, z);
                }
            });
        }
    }

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.viewmodel.ConnectionsViewModel$trySendXmppMessage$delayJob$1", f = "ConnectionsViewModel.kt", i = {}, l = {DownloaderService.STATUS_PENDING}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Unit> $dismissProgress;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0<Unit> function0, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$dismissProgress = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$dismissProgress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$dismissProgress.invoke();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ConnectionsViewModel.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/viewmodel/ConnectionsViewModel$trySendXmppMessage$runablePoxy$2", "Lcom/wear/backwork/XmppLoginListener;", "fail", "", "suc", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements ip1 {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ h14 b;

        public f(Function0<Unit> function0, h14 h14Var) {
            this.a = function0;
            this.b = h14Var;
        }

        @Override // dc.ip1
        public void G() {
            this.a.invoke();
        }

        @Override // dc.ip1
        public void d() {
            h14.a.a(this.b, null, 1, null);
        }
    }

    public ConnectionsViewModel() {
        ea3 ea3Var = new ea3();
        this.a = ea3Var;
        this.b = ea3Var.e();
        g44<r93> g44VarA = q44.a(new r93.c(new ArrayList()));
        this.c = g44VarA;
        this.d = g44VarA;
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new a(null), 3, null);
    }

    public static final void j(ConnectionsViewModel this$0, Function0 showProgress, Function0 dismissProgress, String str, ConnectionUserBean userBean, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showProgress, "$showProgress");
        Intrinsics.checkNotNullParameter(dismissProgress, "$dismissProgress");
        Intrinsics.checkNotNullParameter(userBean, "$userBean");
        this$0.l(showProgress, dismissProgress, new c(str, userBean, this$0));
    }

    public static final void k(ConnectionsViewModel this$0, Function0 showProgress, Function0 dismissProgress, String str, ConnectionUserBean userBean, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showProgress, "$showProgress");
        Intrinsics.checkNotNullParameter(dismissProgress, "$dismissProgress");
        Intrinsics.checkNotNullParameter(userBean, "$userBean");
        this$0.l(showProgress, dismissProgress, new d(showProgress, str, dismissProgress, userBean, this$0));
    }

    public static final void m(Function0 dismissProgress, Function0 action) {
        Intrinsics.checkNotNullParameter(dismissProgress, "$dismissProgress");
        Intrinsics.checkNotNullParameter(action, "$action");
        dismissProgress.invoke();
        action.invoke();
    }

    public final void a(@NotNull ConnectionUserBean userBean, @NotNull Function0<Unit> showProgress, @NotNull Function0<Unit> dismissProgress) {
        Intrinsics.checkNotNullParameter(userBean, "userBean");
        Intrinsics.checkNotNullParameter(showProgress, "showProgress");
        Intrinsics.checkNotNullParameter(dismissProgress, "dismissProgress");
        String email = userBean.getEmail();
        if (TextUtils.isEmpty(email)) {
            return;
        }
        l(showProgress, dismissProgress, new b(email, this));
    }

    @NotNull
    public final o44<r93> e() {
        return this.d;
    }

    public final void i(@NotNull Context context, @NotNull final ConnectionUserBean userBean, @NotNull final Function0<Unit> showProgress, @NotNull final Function0<Unit> dismissProgress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userBean, "userBean");
        Intrinsics.checkNotNullParameter(showProgress, "showProgress");
        Intrinsics.checkNotNullParameter(dismissProgress, "dismissProgress");
        final String email = userBean.getEmail();
        if (TextUtils.isEmpty(email)) {
            return;
        }
        bo3 bo3Var = new bo3(context, R.layout.view_decline_friends_tip);
        bo3Var.show();
        bo3Var.d(R.id.tv_decline, new bo3.d() { // from class: dc.ka3
            @Override // dc.bo3.d
            public final void a(int i) {
                ConnectionsViewModel.j(this.a, showProgress, dismissProgress, email, userBean, i);
            }
        });
        bo3Var.d(R.id.tv_block, new bo3.d() { // from class: dc.ja3
            @Override // dc.bo3.d
            public final void a(int i) {
                ConnectionsViewModel.k(this.a, showProgress, dismissProgress, email, userBean, i);
            }
        });
        bo3Var.d(R.id.tv_cancel, null);
        View viewA = bo3Var.a(R.id.tv_name);
        TextView textView = viewA instanceof TextView ? (TextView) viewA : null;
        if (textView != null) {
            textView.setText(userBean.getName());
        }
        View viewA2 = bo3Var.a(R.id.riv_user_img);
        WearUtils.u2(viewA2 instanceof ImageView ? (ImageView) viewA2 : null, userBean.getAvatar());
    }

    public final void l(Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        gp1 gp1Var = new gp1(new Runnable() { // from class: dc.la3
            @Override // java.lang.Runnable
            public final void run() {
                ConnectionsViewModel.m(function02, function03);
            }
        }, new f(function02, uy3.d(ViewModelKt.getViewModelScope(this), null, null, new e(function02, null), 3, null)));
        function0.invoke();
        ep1.b().r(this, gp1Var);
    }
}
