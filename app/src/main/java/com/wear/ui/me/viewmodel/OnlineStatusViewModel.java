package com.wear.ui.me.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.bean.Account;
import com.wear.bean.me.OnlineStatusFriendCheckParam;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.eg3;
import dc.g44;
import dc.hu3;
import dc.kc3;
import dc.lc3;
import dc.n04;
import dc.o44;
import dc.q44;
import dc.uy3;
import dc.v34;
import dc.wz3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.packet.Presence;

/* compiled from: OnlineStatusViewModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0005J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\"\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150!J\u0014\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006&"}, d2 = {"Lcom/wear/ui/me/viewmodel/OnlineStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_onlineStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_onlineStatusUserIntentFlow", "Lcom/wear/ui/me/intent/OnlineStatusUserIntent;", "onlineStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOnlineStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onlineStatusRepository", "Lcom/wear/ui/me/repository/OnlineStatusRepository;", "getOnlineStatusRepository", "()Lcom/wear/ui/me/repository/OnlineStatusRepository;", "onlineStatusRepository$delegate", "Lkotlin/Lazy;", "onlineStatusUserIntentFlow", "getOnlineStatusUserIntentFlow", "changeOnlineStatus", "", "status", "getFriendList", "getOnlineStatus", "getSelectedList", "", "Lcom/wear/bean/me/OnlineStatusUserBean;", "intersectFriendList", "removeFriend", "friendId", "", Callback.METHOD_NAME, "Lkotlin/Function1;", "", "saveFriendList", "list", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineStatusViewModel extends ViewModel {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public final g44<Integer> b;

    @NotNull
    public final o44<Integer> c;

    @NotNull
    public final g44<kc3> d;

    @NotNull
    public final o44<kc3> e;

    /* compiled from: OnlineStatusViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Presence.Mode.values().length];
            iArr[Presence.Mode.dnd.ordinal()] = 1;
            iArr[Presence.Mode.away.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: OnlineStatusViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.viewmodel.OnlineStatusViewModel$changeOnlineStatus$1", f = "OnlineStatusViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ int $status;
        public int label;
        public final /* synthetic */ OnlineStatusViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, OnlineStatusViewModel onlineStatusViewModel, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$status = i;
            this.this$0 = onlineStatusViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$status, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = this.$status;
            if (hu3.t0(i != 1 ? i != 2 ? Presence.Mode.chat : Presence.Mode.away : Presence.Mode.dnd)) {
                MyApplication myApplication = WearUtils.x;
                StringBuilder sb = new StringBuilder();
                sb.append("init_on_line_status");
                Account accountU = ch3.n().u();
                sb.append(accountU != null ? accountU.getId() : null);
                eg3.k(myApplication, sb.toString(), this.$status);
                this.this$0.b.setValue(Boxing.boxInt(this.$status));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OnlineStatusViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.viewmodel.OnlineStatusViewModel$getFriendList$1", f = "OnlineStatusViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OnlineStatusViewModel.this.new c(continuation);
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
                lc3 lc3VarH = OnlineStatusViewModel.this.h();
                int iIntValue = OnlineStatusViewModel.this.g().getValue().intValue();
                this.label = 1;
                obj = lc3VarH.e(iIntValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            OnlineStatusViewModel.this.d.setValue(new kc3.a((List) obj));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OnlineStatusViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/me/repository/OnlineStatusRepository;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<lc3> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final lc3 invoke() {
            return lc3.a.a();
        }
    }

    /* compiled from: OnlineStatusViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.viewmodel.OnlineStatusViewModel$saveFriendList$1", f = "OnlineStatusViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List<OnlineStatusUserBean> $list;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List<OnlineStatusUserBean> list, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OnlineStatusViewModel.this.new e(this.$list, continuation);
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
                lc3 lc3VarH = OnlineStatusViewModel.this.h();
                List<OnlineStatusUserBean> list = this.$list;
                int iIntValue = OnlineStatusViewModel.this.g().getValue().intValue();
                this.label = 1;
                if (lc3VarH.h(list, iIntValue, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            hu3.s0();
            OnlineStatusViewModel.this.e();
            return Unit.INSTANCE;
        }
    }

    public OnlineStatusViewModel() {
        g44<Integer> g44VarA = q44.a(Integer.valueOf(f()));
        this.b = g44VarA;
        this.c = v34.b(g44VarA);
        g44<kc3> g44VarA2 = q44.a(new kc3.a(new ArrayList()));
        this.d = g44VarA2;
        this.e = v34.b(g44VarA2);
    }

    public final void d(int i) {
        if (!MyApplication.P) {
            ToastUtils.x(R.string.net_connect_error_tip);
        } else if (ch3.n().u() != null) {
            uy3.d(ViewModelKt.getViewModelScope(this), n04.b(), null, new b(i, this, null), 2, null);
        }
    }

    public final void e() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new c(null), 3, null);
    }

    public final int f() {
        Account accountU = ch3.n().u();
        Presence.Mode statusMode = accountU != null ? accountU.getStatusMode() : null;
        int i = statusMode == null ? -1 : a.a[statusMode.ordinal()];
        if (i != 1) {
            return i != 2 ? 0 : 2;
        }
        return 1;
    }

    @NotNull
    public final o44<Integer> g() {
        return this.c;
    }

    public final lc3 h() {
        return (lc3) this.a.getValue();
    }

    @NotNull
    public final o44<kc3> i() {
        return this.e;
    }

    @NotNull
    public final List<OnlineStatusUserBean> j() {
        kc3 value = this.e.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.wear.ui.me.intent.OnlineStatusUserIntent.FriendList");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((kc3.a) value).a());
        return arrayList;
    }

    @NotNull
    public final List<OnlineStatusUserBean> k() {
        kc3 value = this.e.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.wear.ui.me.intent.OnlineStatusUserIntent.FriendList");
        return h().f(((kc3.a) value).a());
    }

    public final void l(@NotNull String friendId, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendId, "friendId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Account accountU = ch3.n().u();
        h().i(ViewModelKt.getViewModelScope(this), new OnlineStatusFriendCheckParam(friendId, (accountU != null ? accountU.getStatusMode() : null) == Presence.Mode.away ? 2 : 1, Boolean.FALSE), callback);
    }

    public final void m(@NotNull List<OnlineStatusUserBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new e(list, null), 3, null);
    }
}
