package com.wear.ui.longDistance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ConnectionGroupBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.bean.ConnectionUserBean;
import com.wear.databinding.ActivityConnectionsBinding;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.ui.longDistance.ConnectionsActivity;
import com.wear.ui.longDistance.adapter.ConnectionsAdapter;
import com.wear.ui.longDistance.adapter.ConnectionsRequestAdapter;
import com.wear.ui.longDistance.behavior.ConnectionsBehavior;
import com.wear.ui.longDistance.behavior.ConnectionsSlideBehavior;
import com.wear.ui.longDistance.behavior.GuideVideoBottom;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.viewmodel.ConnectionsViewModel;
import com.wear.util.WearUtils;
import com.wear.widget.ConnectionsSideBar;
import com.wear.widget.sticky.StickyHeadContainer;
import com.wear.widget.sticky.StickyItemDecoration;
import dc.br;
import dc.eg3;
import dc.h04;
import dc.kg3;
import dc.mu3;
import dc.o44;
import dc.pf3;
import dc.pj3;
import dc.r93;
import dc.th4;
import dc.tq;
import dc.u34;
import dc.uy3;
import dc.v83;
import dc.vl2;
import dc.wz3;
import dc.xu1;
import dc.zq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionsActivity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/wear/ui/longDistance/ConnectionsActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityConnectionsBinding;", "viewModel", "Lcom/wear/ui/longDistance/viewmodel/ConnectionsViewModel;", "getViewModel", "()Lcom/wear/ui/longDistance/viewmodel/ConnectionsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initData", "", "initListener", "initRecyclerRequest", "initRecyclerView", "initShadowConfig", "initSideBar", "initVideo", "intentFriendsSearchListActivity", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "removeUserFromRequest", "email", "", "skipBaseSettingBarColor", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionsActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a c = new a(null);
    public ActivityConnectionsBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ConnectionsViewModel.class), new j(this), new i(this), new k(null, this));

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/longDistance/ConnectionsActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) ConnectionsActivity.class));
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.ConnectionsActivity$initData$1", f = "ConnectionsActivity.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: ConnectionsActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "intent", "Lcom/wear/ui/longDistance/intent/ConnectionsIntent;", "emit", "(Lcom/wear/ui/longDistance/intent/ConnectionsIntent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34 {
            public final /* synthetic */ ConnectionsActivity a;

            public a(ConnectionsActivity connectionsActivity) {
                this.a = connectionsActivity;
            }

            @Override // dc.u34
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull r93 r93Var, @NotNull Continuation<? super Unit> continuation) {
                BaseQuickAdapter baseQuickAdapter;
                if (r93Var instanceof r93.c) {
                    ActivityConnectionsBinding activityConnectionsBinding = this.a.a;
                    if (activityConnectionsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityConnectionsBinding = null;
                    }
                    RecyclerView.Adapter adapter = activityConnectionsBinding.h.getAdapter();
                    baseQuickAdapter = adapter instanceof ConnectionsRequestAdapter ? (ConnectionsRequestAdapter) adapter : null;
                    if (baseQuickAdapter == null) {
                        return Unit.INSTANCE;
                    }
                    baseQuickAdapter.y0(((r93.c) r93Var).a());
                } else if (r93Var instanceof r93.b) {
                    ActivityConnectionsBinding activityConnectionsBinding2 = this.a.a;
                    if (activityConnectionsBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityConnectionsBinding2 = null;
                    }
                    RecyclerView.Adapter adapter2 = activityConnectionsBinding2.g.getAdapter();
                    baseQuickAdapter = adapter2 instanceof ConnectionsAdapter ? (ConnectionsAdapter) adapter2 : null;
                    if (baseQuickAdapter == null) {
                        return Unit.INSTANCE;
                    }
                    baseQuickAdapter.y0(((r93.b) r93Var).a());
                } else if (r93Var instanceof r93.a) {
                    this.a.O4(((r93.a) r93Var).getA());
                } else if (r93Var instanceof r93.d) {
                    this.a.O4(((r93.d) r93Var).getA());
                }
                return Unit.INSTANCE;
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ConnectionsActivity.this.new b(continuation);
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
                o44<r93> o44VarE = ConnectionsActivity.this.v4().e();
                a aVar = new a(ConnectionsActivity.this);
                this.label = 1;
                if (o44VarE.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {
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
            ConnectionsActivity.this.showLoadingProgress();
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Unit> {
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
            ConnectionsActivity.this.dismissLoadingProgress();
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Unit> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ConnectionsActivity.this.showLoadingProgress();
        }
    }

    /* compiled from: ConnectionsActivity.kt */
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
            ConnectionsActivity.this.dismissLoadingProgress();
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/wear/ui/longDistance/ConnectionsActivity$initSideBar$1", "Lcom/wear/widget/ConnectionsSideBar$OnLetterChangeListener;", "onLetterChange", "", "letter", "", "onReset", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements ConnectionsSideBar.a {
        public g() {
        }

        @Override // com.wear.widget.ConnectionsSideBar.a
        public void a() {
            ActivityConnectionsBinding activityConnectionsBinding = ConnectionsActivity.this.a;
            if (activityConnectionsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding = null;
            }
            activityConnectionsBinding.f.setVisibility(8);
        }

        @Override // com.wear.widget.ConnectionsSideBar.a
        public void b(@NotNull String letter) {
            Intrinsics.checkNotNullParameter(letter, "letter");
            ActivityConnectionsBinding activityConnectionsBinding = ConnectionsActivity.this.a;
            ActivityConnectionsBinding activityConnectionsBinding2 = null;
            if (activityConnectionsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding = null;
            }
            activityConnectionsBinding.g.stopScroll();
            ActivityConnectionsBinding activityConnectionsBinding3 = ConnectionsActivity.this.a;
            if (activityConnectionsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding3 = null;
            }
            Context context = activityConnectionsBinding3.j.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.sideBar.context");
            xu1.a(context);
            ActivityConnectionsBinding activityConnectionsBinding4 = ConnectionsActivity.this.a;
            if (activityConnectionsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding4 = null;
            }
            TextView textView = activityConnectionsBinding4.f;
            ConnectionsActivity connectionsActivity = ConnectionsActivity.this;
            textView.setText(letter);
            textView.setVisibility(0);
            ActivityConnectionsBinding activityConnectionsBinding5 = connectionsActivity.a;
            if (activityConnectionsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding5 = null;
            }
            float y = activityConnectionsBinding5.j.getY();
            ActivityConnectionsBinding activityConnectionsBinding6 = connectionsActivity.a;
            if (activityConnectionsBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding6 = null;
            }
            int e = activityConnectionsBinding6.j.getE();
            ActivityConnectionsBinding activityConnectionsBinding7 = connectionsActivity.a;
            if (activityConnectionsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding7 = null;
            }
            float f = y + (e * activityConnectionsBinding7.j.getF()) + textView.getHeight();
            ActivityConnectionsBinding activityConnectionsBinding8 = connectionsActivity.a;
            if (activityConnectionsBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding8 = null;
            }
            textView.setY(f - (activityConnectionsBinding8.j.getE() / 2));
            ActivityConnectionsBinding activityConnectionsBinding9 = ConnectionsActivity.this.a;
            if (activityConnectionsBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding9 = null;
            }
            RecyclerView.Adapter adapter = activityConnectionsBinding9.g.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.longDistance.adapter.ConnectionsAdapter");
            Iterator it = ((ConnectionsAdapter) adapter).K().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                tq tqVar = (tq) it.next();
                if ((tqVar instanceof ConnectionLetterBean) && Intrinsics.areEqual(((ConnectionLetterBean) tqVar).getLetter(), letter)) {
                    break;
                } else {
                    i++;
                }
            }
            ConnectionsActivity connectionsActivity2 = ConnectionsActivity.this;
            if (i == -1) {
                return;
            }
            ActivityConnectionsBinding activityConnectionsBinding10 = connectionsActivity2.a;
            if (activityConnectionsBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding10 = null;
            }
            RecyclerView.LayoutManager layoutManager = activityConnectionsBinding10.g.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
            ActivityConnectionsBinding activityConnectionsBinding11 = connectionsActivity2.a;
            if (activityConnectionsBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding11 = null;
            }
            ViewGroup.LayoutParams layoutParams = activityConnectionsBinding11.b.getLayoutParams();
            CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
            CoordinatorLayout.Behavior behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
            AppBarLayout.Behavior behavior2 = behavior instanceof AppBarLayout.Behavior ? (AppBarLayout.Behavior) behavior : null;
            ActivityConnectionsBinding activityConnectionsBinding12 = connectionsActivity2.a;
            if (activityConnectionsBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding12 = null;
            }
            int height = activityConnectionsBinding12.b.getHeight();
            if (behavior2 != null) {
                behavior2.setTopAndBottomOffset(-height);
            }
            ActivityConnectionsBinding activityConnectionsBinding13 = connectionsActivity2.a;
            if (activityConnectionsBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding13 = null;
            }
            activityConnectionsBinding13.d.requestLayout();
            ActivityConnectionsBinding activityConnectionsBinding14 = connectionsActivity2.a;
            if (activityConnectionsBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding14 = null;
            }
            View view = activityConnectionsBinding14.l.a;
            Intrinsics.checkNotNullExpressionValue(view, "binding.stickyHeaderItem.bottomLine");
            view.setVisibility(0);
            ActivityConnectionsBinding activityConnectionsBinding15 = connectionsActivity2.a;
            if (activityConnectionsBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBinding15 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = activityConnectionsBinding15.j.getLayoutParams();
            CoordinatorLayout.LayoutParams layoutParams4 = layoutParams3 instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams3 : null;
            CoordinatorLayout.Behavior behavior3 = layoutParams4 != null ? layoutParams4.getBehavior() : null;
            ConnectionsSlideBehavior connectionsSlideBehavior = behavior3 instanceof ConnectionsSlideBehavior ? (ConnectionsSlideBehavior) behavior3 : null;
            if (connectionsSlideBehavior != null) {
                ActivityConnectionsBinding activityConnectionsBinding16 = connectionsActivity2.a;
                if (activityConnectionsBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityConnectionsBinding2 = activityConnectionsBinding16;
                }
                connectionsSlideBehavior.a(activityConnectionsBinding2.e.getHeight());
            }
        }
    }

    /* compiled from: ConnectionsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.ConnectionsActivity$initVideo$1", f = "ConnectionsActivity.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ GuideVideoBottom $guideVideoBottom;
        public int label;
        public final /* synthetic */ ConnectionsActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(GuideVideoBottom guideVideoBottom, ConnectionsActivity connectionsActivity, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$guideVideoBottom = guideVideoBottom;
            this.this$0 = connectionsActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$guideVideoBottom, this.this$0, continuation);
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
                this.label = 1;
                if (h04.a(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            GuideVideoBottom guideVideoBottom = this.$guideVideoBottom;
            FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            guideVideoBottom.show(supportFragmentManager, "guideVideoBottom");
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            Function0 function0 = this.$extrasProducer;
            if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                return creationExtras;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    public static final void B4(ConnectionsActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ConnectionsRequestAdapter connectionsRequestAdapter = adapter instanceof ConnectionsRequestAdapter ? (ConnectionsRequestAdapter) adapter : null;
        if (connectionsRequestAdapter == null) {
            return;
        }
        ConnectionUserBean connectionUserBean = connectionsRequestAdapter.K().get(i2);
        if (view.getId() == R.id.btn_user_accept) {
            this$0.v4().a(connectionUserBean, this$0.new c(), this$0.new d());
        } else if (view.getId() == R.id.btn_user_reject) {
            ConnectionsViewModel connectionsViewModelV4 = this$0.v4();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            connectionsViewModelV4.i(context, connectionUserBean, this$0.new e(), this$0.new f());
        }
    }

    public static final void D4(RecyclerView this_with, ConnectionsActivity this$0, int i2) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this_with.getAdapter();
        ActivityConnectionsBinding activityConnectionsBinding = null;
        ConnectionsAdapter connectionsAdapter = adapter instanceof ConnectionsAdapter ? (ConnectionsAdapter) adapter : null;
        if (connectionsAdapter == null) {
            return;
        }
        List<T> listK = connectionsAdapter.K();
        if (listK.isEmpty()) {
            return;
        }
        Object obj = listK.get(i2);
        ConnectionLetterBean connectionLetterBean = obj instanceof ConnectionLetterBean ? (ConnectionLetterBean) obj : null;
        if (connectionLetterBean == null) {
            return;
        }
        ActivityConnectionsBinding activityConnectionsBinding2 = this$0.a;
        if (activityConnectionsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding2 = null;
        }
        activityConnectionsBinding2.l.e(connectionLetterBean.getLetter());
        ActivityConnectionsBinding activityConnectionsBinding3 = this$0.a;
        if (activityConnectionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding3 = null;
        }
        activityConnectionsBinding3.l.d(Boolean.TRUE);
        ActivityConnectionsBinding activityConnectionsBinding4 = this$0.a;
        if (activityConnectionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBinding = activityConnectionsBinding4;
        }
        activityConnectionsBinding.l.executePendingBindings();
    }

    public static final void E4(BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = adapter.K().get(i2);
        if (obj instanceof ConnectionUserBean) {
            ConnectionUserBean connectionUserBean = (ConnectionUserBean) obj;
            if (connectionUserBean.isOfficialAccount()) {
                pj3.f(view.getContext(), OfficialAccountActivity.class);
            } else {
                pj3.j(view.getContext(), ChatActivity.class, "userId", connectionUserBean.getEmail());
            }
        } else if (obj instanceof ConnectionGroupBean) {
            pj3.j(view.getContext(), ChatRoomActivity.class, "roomId", ((ConnectionGroupBean) obj).getEmail());
        }
        v83.a();
    }

    @JvmStatic
    public static final void P4(@NotNull Context context) {
        c.a(context);
    }

    public static final void y4(ConnectionsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void z4(ConnectionsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4();
    }

    public final void A4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        ActivityConnectionsBinding activityConnectionsBinding2 = null;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        RecyclerView recyclerView = activityConnectionsBinding.h;
        ActivityConnectionsBinding activityConnectionsBinding3 = this.a;
        if (activityConnectionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBinding2 = activityConnectionsBinding3;
        }
        RecyclerView.ItemAnimator itemAnimator = activityConnectionsBinding2.g.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        ConnectionsRequestAdapter connectionsRequestAdapter = new ConnectionsRequestAdapter(new ArrayList());
        connectionsRequestAdapter.n(R.id.btn_user_accept, R.id.btn_user_reject);
        connectionsRequestAdapter.A0(new zq() { // from class: dc.w53
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                ConnectionsActivity.B4(this.a, baseQuickAdapter, view, i2);
            }
        });
        recyclerView.setAdapter(connectionsRequestAdapter);
        connectionsRequestAdapter.u0(R.layout.empty_connections_request);
    }

    public final void C4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        ActivityConnectionsBinding activityConnectionsBinding2 = null;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        final RecyclerView recyclerView = activityConnectionsBinding.g;
        ActivityConnectionsBinding activityConnectionsBinding3 = this.a;
        if (activityConnectionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding3 = null;
        }
        activityConnectionsBinding3.k.setDataCallback(new StickyHeadContainer.a() { // from class: dc.y53
            @Override // com.wear.widget.sticky.StickyHeadContainer.a
            public final void a(int i2) {
                ConnectionsActivity.D4(recyclerView, this, i2);
            }
        });
        ActivityConnectionsBinding activityConnectionsBinding4 = this.a;
        if (activityConnectionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBinding2 = activityConnectionsBinding4;
        }
        recyclerView.addItemDecoration(new StickyItemDecoration(activityConnectionsBinding2.k, 0));
        ConnectionsAdapter connectionsAdapter = new ConnectionsAdapter(new ArrayList());
        connectionsAdapter.E0(new br() { // from class: dc.z53
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                ConnectionsActivity.E4(baseQuickAdapter, view, i2);
            }
        });
        recyclerView.setAdapter(connectionsAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.ui.longDistance.ConnectionsActivity$initRecyclerView$1$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                ActivityConnectionsBinding activityConnectionsBinding5 = null;
                ConnectionsAdapter connectionsAdapter2 = adapter instanceof ConnectionsAdapter ? (ConnectionsAdapter) adapter : null;
                if (connectionsAdapter2 == null || connectionsAdapter2.K().isEmpty()) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                for (int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition(); -1 < iFindFirstVisibleItemPosition; iFindFirstVisibleItemPosition--) {
                    tq tqVar = (tq) connectionsAdapter2.getItem(iFindFirstVisibleItemPosition);
                    if (tqVar instanceof ConnectionLetterBean) {
                        String letter = ((ConnectionLetterBean) tqVar).getLetter();
                        ActivityConnectionsBinding activityConnectionsBinding6 = this.a.a;
                        if (activityConnectionsBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityConnectionsBinding5 = activityConnectionsBinding6;
                        }
                        activityConnectionsBinding5.j.setLetter(letter);
                        return;
                    }
                }
            }
        });
    }

    public final void F4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        ActivityConnectionsBinding activityConnectionsBinding2 = null;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        ViewGroup.LayoutParams layoutParams = activityConnectionsBinding.e.getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        CoordinatorLayout.Behavior behavior = layoutParams2.getBehavior();
        ConnectionsBehavior connectionsBehavior = behavior instanceof ConnectionsBehavior ? (ConnectionsBehavior) behavior : null;
        if (connectionsBehavior == null) {
            return;
        }
        ActivityConnectionsBinding activityConnectionsBinding3 = this.a;
        if (activityConnectionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBinding2 = activityConnectionsBinding3;
        }
        View view = activityConnectionsBinding2.l.a;
        Intrinsics.checkNotNullExpressionValue(view, "binding.stickyHeaderItem.bottomLine");
        connectionsBehavior.a(view);
    }

    public final void G4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        activityConnectionsBinding.j.setOnLetterChangeListener(new g());
    }

    public final void H4() {
        if (!pf3.d(this) && eg3.d(this, "key_show_video_by_connections", true)) {
            uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new h(new GuideVideoBottom(), this, null), 3, null);
        }
    }

    public final void I4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, activityConnectionsBinding.i, "editTransition").toBundle();
        if (bundle == null) {
            bundle = new Bundle();
        }
        FriendsSearchSingleActivity.t4(this, bundle);
    }

    public final void O4(String str) {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        RecyclerView.Adapter adapter = activityConnectionsBinding.h.getAdapter();
        ConnectionsRequestAdapter connectionsRequestAdapter = adapter instanceof ConnectionsRequestAdapter ? (ConnectionsRequestAdapter) adapter : null;
        if (connectionsRequestAdapter == null) {
            return;
        }
        Iterator<ConnectionUserBean> it = connectionsRequestAdapter.K().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(str, it.next().getEmail())) {
                break;
            } else {
                i2++;
            }
        }
        Integer numValueOf = Integer.valueOf(i2);
        Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
        if (num != null) {
            connectionsRequestAdapter.J0(num.intValue());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityConnectionsBinding activityConnectionsBindingC = ActivityConnectionsBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityConnectionsBindingC, "inflate(layoutInflater)");
        this.a = activityConnectionsBindingC;
        if (activityConnectionsBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBindingC = null;
        }
        setContentView(activityConnectionsBindingC.getRoot());
        A4();
        C4();
        G4();
        F4();
        x4();
        w4();
        H4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        activityConnectionsBinding.f.setVisibility(8);
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground));
        return true;
    }

    public final ConnectionsViewModel v4() {
        return (ConnectionsViewModel) this.b.getValue();
    }

    public final void w4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(null), 3, null);
        mu3.c = 0;
    }

    public final void x4() {
        ActivityConnectionsBinding activityConnectionsBinding = this.a;
        ActivityConnectionsBinding activityConnectionsBinding2 = null;
        if (activityConnectionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBinding = null;
        }
        activityConnectionsBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.a63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectionsActivity.y4(this.a, view);
            }
        });
        ActivityConnectionsBinding activityConnectionsBinding3 = this.a;
        if (activityConnectionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBinding2 = activityConnectionsBinding3;
        }
        activityConnectionsBinding2.i.setOnClickListener(new View.OnClickListener() { // from class: dc.x53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectionsActivity.z4(this.a, view);
            }
        });
    }
}
