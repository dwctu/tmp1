package com.wear.ui.longDistance.fragment;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.UserActionMenuBean;
import com.wear.bean.event.AddFriendsRefreshList;
import com.wear.bean.official.OfficialAcount;
import com.wear.bean.official.OfficialMsg;
import com.wear.bean.official.OfficialSetInfo;
import com.wear.databinding.FragmentLongUserActionMenuBinding;
import com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom;
import com.wear.ui.longDistance.fragment.LongUserActionMenuFragmentBottom;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import dc.ah4;
import dc.g73;
import dc.h73;
import dc.p73;
import dc.q73;
import dc.th4;
import dc.uy3;
import dc.wz3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LongUserActionMenuFragmentBottom.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/wear/ui/longDistance/fragment/LongUserActionMenuFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/FragmentLongUserActionMenuBinding;", "()V", "groupRelationshipAction", "Lcom/wear/ui/longDistance/action/GroupRelationshipAction;", "longUserActionMenuListener", "Lcom/wear/ui/longDistance/fragment/LongUserActionMenuFragmentBottom$OnLongUserActionMenuListener;", "userActionMenuBean", "Lcom/wear/bean/UserActionMenuBean;", "getUserActionMenuBean", "()Lcom/wear/bean/UserActionMenuBean;", "userActionMenuBean$delegate", "Lkotlin/Lazy;", "userRelationshipAction", "Lcom/wear/ui/longDistance/action/UserRelationshipAction;", "initListener", "", "initViews", "isRemoteOfficial", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setOnLeaveGroupListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "OnLongUserActionMenuListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class LongUserActionMenuFragmentBottom extends BaseBindingBottomDialogFragment<FragmentLongUserActionMenuBinding> {

    @NotNull
    public final Lazy c;

    @Nullable
    public h73 d;

    @Nullable
    public g73 e;

    @Nullable
    public b f;

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLongUserActionMenuBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentLongUserActionMenuBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentLongUserActionMenuBinding;", 0);
        }

        @NotNull
        public final FragmentLongUserActionMenuBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLongUserActionMenuBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLongUserActionMenuBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/longDistance/fragment/LongUserActionMenuFragmentBottom$OnLongUserActionMenuListener;", "", "onLeaveGroup", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a();
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EventBus.getDefault().post(new AddFriendsRefreshList());
        }
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EventBus.getDefault().post(new AddFriendsRefreshList());
        }
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.fragment.LongUserActionMenuFragmentBottom$initListener$4$1$1", f = "LongUserActionMenuFragmentBottom.kt", i = {0}, l = {207}, m = "invokeSuspend", n = {"model"}, s = {"L$0"})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public Object L$0;
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            OfficialaCountModel officialaCountModel;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
                this.L$0 = officialaCountModelA;
                this.label = 1;
                Object objJ = officialaCountModelA.j(this);
                if (objJ == coroutine_suspended) {
                    return coroutine_suspended;
                }
                officialaCountModel = officialaCountModelA;
                obj = objJ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                officialaCountModel = (OfficialaCountModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                List<OfficialMsg> value = officialaCountModel.q().getValue();
                if (value != null) {
                    value.clear();
                }
                officialaCountModel.K(0L);
                officialaCountModel.M();
                officialaCountModel.q().postValue(new ArrayList());
                OfficialAcount value2 = officialaCountModel.o().getValue();
                if (value2 != null) {
                    value2.setMessage(null);
                }
                officialaCountModel.o().postValue(officialaCountModel.o().getValue());
                EventBus.getDefault().post(new AddFriendsRefreshList());
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Unit> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            b bVar = LongUserActionMenuFragmentBottom.this.f;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: LongUserActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/bean/UserActionMenuBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<UserActionMenuBean> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserActionMenuBean invoke() {
            UserActionMenuBean userActionMenuBean;
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle arguments = LongUserActionMenuFragmentBottom.this.getArguments();
                return (arguments == null || (userActionMenuBean = (UserActionMenuBean) arguments.getParcelable("argument_user_action_menu", UserActionMenuBean.class)) == null) ? new UserActionMenuBean(null, null, null, 0) : userActionMenuBean;
            }
            Bundle arguments2 = LongUserActionMenuFragmentBottom.this.getArguments();
            UserActionMenuBean userActionMenuBean2 = arguments2 != null ? (UserActionMenuBean) arguments2.getParcelable("argument_user_action_menu") : null;
            return userActionMenuBean2 == null ? new UserActionMenuBean(null, null, null, 0) : userActionMenuBean2;
        }
    }

    public LongUserActionMenuFragmentBottom() {
        super(a.a);
        this.c = LazyKt__LazyJVMKt.lazy(new g());
    }

    public static final void A(final LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongUserActionMenuConfirmFragmentBottom longUserActionMenuConfirmFragmentBottom = new LongUserActionMenuConfirmFragmentBottom();
        longUserActionMenuConfirmFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("argument_type", 1), TuplesKt.to("argument_name", this$0.v().getNickname())));
        longUserActionMenuConfirmFragmentBottom.C(new LongUserActionMenuConfirmFragmentBottom.b() { // from class: dc.t83
            @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom.b
            public final void a() {
                LongUserActionMenuFragmentBottom.B(this.a);
            }
        });
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        longUserActionMenuConfirmFragmentBottom.show(parentFragmentManager, LongUserActionMenuConfirmFragmentBottom.class.getSimpleName());
        this$0.dismissAllowingStateLoss();
    }

    public static final void B(LongUserActionMenuFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h73 h73Var = this$0.d;
        if (h73Var != null) {
            h73Var.b();
        }
    }

    public static final void C(final LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongUserActionMenuConfirmFragmentBottom longUserActionMenuConfirmFragmentBottom = new LongUserActionMenuConfirmFragmentBottom();
        longUserActionMenuConfirmFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("argument_type", 2), TuplesKt.to("argument_name", this$0.v().getNickname())));
        longUserActionMenuConfirmFragmentBottom.C(new LongUserActionMenuConfirmFragmentBottom.b() { // from class: dc.r83
            @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom.b
            public final void a() {
                LongUserActionMenuFragmentBottom.D(this.a);
            }
        });
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        longUserActionMenuConfirmFragmentBottom.show(parentFragmentManager, LongUserActionMenuConfirmFragmentBottom.class.getSimpleName());
        this$0.dismissAllowingStateLoss();
    }

    public static final void D(LongUserActionMenuFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g73 g73Var = this$0.e;
        if (g73Var != null) {
            g73Var.d(this$0.new f());
        }
    }

    public static final void E(final LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongUserActionMenuConfirmFragmentBottom longUserActionMenuConfirmFragmentBottom = new LongUserActionMenuConfirmFragmentBottom();
        longUserActionMenuConfirmFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("argument_type", 4), TuplesKt.to("argument_name", this$0.v().getNickname())));
        longUserActionMenuConfirmFragmentBottom.C(new LongUserActionMenuConfirmFragmentBottom.b() { // from class: dc.m83
            @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom.b
            public final void a() {
                LongUserActionMenuFragmentBottom.F(this.a);
            }
        });
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        longUserActionMenuConfirmFragmentBottom.show(parentFragmentManager, LongUserActionMenuConfirmFragmentBottom.class.getSimpleName());
        this$0.dismissAllowingStateLoss();
    }

    public static final void F(LongUserActionMenuFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g73 g73Var = this$0.e;
        if (g73Var != null) {
            g73Var.g();
        }
    }

    public static final void I(LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.v().getFriendType() == 1) {
            if (this$0.v().getIsTop()) {
                g73 g73Var = this$0.e;
                if (g73Var != null) {
                    g73Var.a();
                }
            } else {
                g73 g73Var2 = this$0.e;
                if (g73Var2 != null) {
                    g73Var2.c();
                }
            }
        } else if (this$0.Q()) {
            OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
            OfficialSetInfo value = officialaCountModelA.s().getValue();
            if (value != null) {
                OfficialSetInfo value2 = officialaCountModelA.s().getValue();
                boolean z = false;
                if (value2 != null && value2.getStickyToTop()) {
                    z = true;
                }
                value.setStickyToTop(true ^ z);
            }
            officialaCountModelA.s().postValue(officialaCountModelA.s().getValue());
            officialaCountModelA.w(c.a);
        } else if (this$0.v().getIsTop()) {
            h73 h73Var = this$0.d;
            if (h73Var != null) {
                h73Var.a();
            }
        } else {
            h73 h73Var2 = this$0.d;
            if (h73Var2 != null) {
                h73Var2.c();
            }
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void J(LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.v().getFriendType() == 1) {
            if (this$0.v().getIsMuteNotification()) {
                g73 g73Var = this$0.e;
                if (g73Var != null) {
                    g73Var.e();
                }
            } else {
                g73 g73Var2 = this$0.e;
                if (g73Var2 != null) {
                    g73Var2.b();
                }
            }
        } else if (this$0.Q()) {
            OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
            OfficialSetInfo value = officialaCountModelA.s().getValue();
            if (value != null) {
                OfficialSetInfo value2 = officialaCountModelA.s().getValue();
                boolean z = false;
                if (value2 != null && value2.getOfficialMsgMuteNotification()) {
                    z = true;
                }
                value.setOfficialMsgMuteNotification(true ^ z);
            }
            officialaCountModelA.s().postValue(officialaCountModelA.s().getValue());
            officialaCountModelA.w(d.a);
        } else if (this$0.v().getIsMuteNotification()) {
            h73 h73Var = this$0.d;
            if (h73Var != null) {
                h73Var.h();
            }
        } else {
            h73 h73Var2 = this$0.d;
            if (h73Var2 != null) {
                h73Var2.i();
            }
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void K(final LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongUserActionMenuConfirmFragmentBottom longUserActionMenuConfirmFragmentBottom = new LongUserActionMenuConfirmFragmentBottom();
        longUserActionMenuConfirmFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("argument_type", 3), TuplesKt.to("argument_name", this$0.v().getNickname())));
        longUserActionMenuConfirmFragmentBottom.C(new LongUserActionMenuConfirmFragmentBottom.b() { // from class: dc.u83
            @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom.b
            public final void a() {
                LongUserActionMenuFragmentBottom.L(this.a);
            }
        });
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        longUserActionMenuConfirmFragmentBottom.show(parentFragmentManager, LongUserActionMenuConfirmFragmentBottom.class.getSimpleName());
        this$0.dismissAllowingStateLoss();
    }

    public static final void L(LongUserActionMenuFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h73 h73Var = this$0.d;
        if (h73Var != null) {
            h73Var.f();
        }
    }

    public static final void M(final LongUserActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongUserActionMenuConfirmFragmentBottom longUserActionMenuConfirmFragmentBottom = new LongUserActionMenuConfirmFragmentBottom();
        longUserActionMenuConfirmFragmentBottom.setArguments(BundleKt.bundleOf(TuplesKt.to("argument_type", 0), TuplesKt.to("argument_name", this$0.v().getNickname())));
        longUserActionMenuConfirmFragmentBottom.C(new LongUserActionMenuConfirmFragmentBottom.b() { // from class: dc.o83
            @Override // com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom.b
            public final void a() {
                LongUserActionMenuFragmentBottom.O(this.a);
            }
        });
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        longUserActionMenuConfirmFragmentBottom.show(parentFragmentManager, LongUserActionMenuConfirmFragmentBottom.class.getSimpleName());
        this$0.dismissAllowingStateLoss();
    }

    public static final void O(LongUserActionMenuFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.v().getFriendType() == 1) {
            g73 g73Var = this$0.e;
            if (g73Var != null) {
                g73Var.i();
                return;
            }
            return;
        }
        if (this$0.Q()) {
            uy3.d(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new e(null), 3, null);
            return;
        }
        h73 h73Var = this$0.d;
        if (h73Var != null) {
            h73Var.d();
        }
    }

    public final void P() {
        if (v().getFriendType() == 1) {
            UserActionMenuBean userActionMenuBeanV = v();
            g73 g73Var = this.e;
            userActionMenuBeanV.setTop(g73Var != null ? g73Var.f() : false);
            UserActionMenuBean userActionMenuBeanV2 = v();
            g73 g73Var2 = this.e;
            userActionMenuBeanV2.setMuteNotification(g73Var2 != null ? g73Var2.h() : false);
        } else if (Q()) {
            OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
            UserActionMenuBean userActionMenuBeanV3 = v();
            OfficialSetInfo value = officialaCountModelA.s().getValue();
            userActionMenuBeanV3.setTop(value != null ? value.getStickyToTop() : false);
            UserActionMenuBean userActionMenuBeanV4 = v();
            OfficialSetInfo value2 = officialaCountModelA.s().getValue();
            userActionMenuBeanV4.setMuteNotification(value2 != null ? value2.getOfficialMsgMuteNotification() : false);
        } else {
            UserActionMenuBean userActionMenuBeanV5 = v();
            h73 h73Var = this.d;
            userActionMenuBeanV5.setTop(h73Var != null ? h73Var.g() : false);
            UserActionMenuBean userActionMenuBeanV6 = v();
            h73 h73Var2 = this.d;
            userActionMenuBeanV6.setMuteNotification(h73Var2 != null ? h73Var2.e() : false);
        }
        t().g.setCompoundDrawablesWithIntrinsicBounds(th4.d(requireContext(), v().getIsTop() ? R.drawable.icon_long_sticky_top_unselected : R.drawable.icon_long_sticky_top), (Drawable) null, (Drawable) null, (Drawable) null);
        t().g.setText(ah4.e(v().getIsTop() ? R.string.chat_menu_remove_top : R.string.partner_profile_to_top_setting));
        t().f.setCompoundDrawablesWithIntrinsicBounds(th4.d(requireContext(), v().getIsMuteNotification() ? R.drawable.icon_long_mute_notification_unselected : R.drawable.icon_long_mute_notification), (Drawable) null, (Drawable) null, (Drawable) null);
        t().f.setText(ah4.e(v().getIsMuteNotification() ? R.string.chat_menu_unmute_notifications : R.string.partner_profile_mute_notifications_setting));
    }

    public final boolean Q() {
        return Intrinsics.areEqual(v().getEmail(), "lovenseRemoteOfficial");
    }

    public final void i0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f = listener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String email = v().getEmail();
        if (email != null) {
            if (v().getFriendType() == 1) {
                this.e = new p73(LifecycleOwnerKt.getLifecycleScope(this), email);
            } else {
                this.d = new q73(LifecycleOwnerKt.getLifecycleScope(this), email);
            }
        }
        P();
        t().d(v());
        y();
    }

    public final UserActionMenuBean v() {
        return (UserActionMenuBean) this.c.getValue();
    }

    public final void y() {
        t().g.setOnClickListener(new View.OnClickListener() { // from class: dc.n83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.I(this.a, view);
            }
        });
        t().f.setOnClickListener(new View.OnClickListener() { // from class: dc.l83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.J(this.a, view);
            }
        });
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.s83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.K(this.a, view);
            }
        });
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.k83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.M(this.a, view);
            }
        });
        t().c.setOnClickListener(new View.OnClickListener() { // from class: dc.q83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.A(this.a, view);
            }
        });
        t().e.setOnClickListener(new View.OnClickListener() { // from class: dc.j83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.C(this.a, view);
            }
        });
        t().d.setOnClickListener(new View.OnClickListener() { // from class: dc.p83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuFragmentBottom.E(this.a, view);
            }
        });
    }
}
