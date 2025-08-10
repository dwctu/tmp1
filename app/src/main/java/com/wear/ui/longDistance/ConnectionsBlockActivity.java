package com.wear.ui.longDistance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ConnectionBlockBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.databinding.ActivityConnectionsBlockBinding;
import com.wear.main.longDistance.HandlerBlockedFriendsActivity;
import com.wear.ui.longDistance.ConnectionsBlockActivity;
import com.wear.ui.longDistance.adapter.ConnectionsBlockAdapter;
import com.wear.ui.longDistance.viewmodel.ConnectionsBlockViewModel;
import com.wear.util.WearUtils;
import com.wear.widget.ConnectionsSideBar;
import com.wear.widget.sticky.StickyHeadContainer;
import com.wear.widget.sticky.StickyItemDecoration;
import dc.br;
import dc.kg3;
import dc.o44;
import dc.pj3;
import dc.q93;
import dc.th4;
import dc.tq;
import dc.u34;
import dc.uy3;
import dc.vl2;
import dc.wz3;
import dc.xu1;
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

/* compiled from: ConnectionsBlockActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/longDistance/ConnectionsBlockActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityConnectionsBlockBinding;", "viewModel", "Lcom/wear/ui/longDistance/viewmodel/ConnectionsBlockViewModel;", "getViewModel", "()Lcom/wear/ui/longDistance/viewmodel/ConnectionsBlockViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initData", "", "initListener", "initRecyclerView", "initSideBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "skipBaseSettingBarColor", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectionsBlockActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a c = new a(null);
    public ActivityConnectionsBlockBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ConnectionsBlockViewModel.class), new e(this), new d(this), new f(null, this));

    /* compiled from: ConnectionsBlockActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/longDistance/ConnectionsBlockActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) ConnectionsBlockActivity.class));
        }
    }

    /* compiled from: ConnectionsBlockActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.ConnectionsBlockActivity$initData$1", f = "ConnectionsBlockActivity.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: ConnectionsBlockActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "intent", "Lcom/wear/ui/longDistance/intent/ConnectionsBlockIntent;", "emit", "(Lcom/wear/ui/longDistance/intent/ConnectionsBlockIntent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34 {
            public final /* synthetic */ ConnectionsBlockActivity a;

            public a(ConnectionsBlockActivity connectionsBlockActivity) {
                this.a = connectionsBlockActivity;
            }

            @Override // dc.u34
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull q93 q93Var, @NotNull Continuation<? super Unit> continuation) {
                if (q93Var instanceof q93.a) {
                    ActivityConnectionsBlockBinding activityConnectionsBlockBinding = this.a.a;
                    ActivityConnectionsBlockBinding activityConnectionsBlockBinding2 = null;
                    if (activityConnectionsBlockBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityConnectionsBlockBinding = null;
                    }
                    RecyclerView.Adapter adapter = activityConnectionsBlockBinding.c.getAdapter();
                    ConnectionsBlockAdapter connectionsBlockAdapter = adapter instanceof ConnectionsBlockAdapter ? (ConnectionsBlockAdapter) adapter : null;
                    if (connectionsBlockAdapter == null) {
                        return Unit.INSTANCE;
                    }
                    q93.a aVar = (q93.a) q93Var;
                    connectionsBlockAdapter.y0(aVar.a());
                    boolean z = !aVar.a().isEmpty();
                    ActivityConnectionsBlockBinding activityConnectionsBlockBinding3 = this.a.a;
                    if (activityConnectionsBlockBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityConnectionsBlockBinding3 = null;
                    }
                    StickyHeadContainer stickyHeadContainer = activityConnectionsBlockBinding3.e;
                    Intrinsics.checkNotNullExpressionValue(stickyHeadContainer, "binding.stickyHeaderContainer");
                    stickyHeadContainer.setVisibility(z ? 0 : 8);
                    ActivityConnectionsBlockBinding activityConnectionsBlockBinding4 = this.a.a;
                    if (activityConnectionsBlockBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityConnectionsBlockBinding2 = activityConnectionsBlockBinding4;
                    }
                    ConnectionsSideBar connectionsSideBar = activityConnectionsBlockBinding2.d;
                    Intrinsics.checkNotNullExpressionValue(connectionsSideBar, "binding.sideBar");
                    connectionsSideBar.setVisibility(z ? 0 : 8);
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
            return ConnectionsBlockActivity.this.new b(continuation);
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
                o44<q93> o44VarA = ConnectionsBlockActivity.this.u4().a();
                a aVar = new a(ConnectionsBlockActivity.this);
                this.label = 1;
                if (o44VarA.collect(aVar, this) == coroutine_suspended) {
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

    /* compiled from: ConnectionsBlockActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/wear/ui/longDistance/ConnectionsBlockActivity$initSideBar$1", "Lcom/wear/widget/ConnectionsSideBar$OnLetterChangeListener;", "onLetterChange", "", "letter", "", "onReset", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements ConnectionsSideBar.a {
        public c() {
        }

        @Override // com.wear.widget.ConnectionsSideBar.a
        public void a() {
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding = ConnectionsBlockActivity.this.a;
            if (activityConnectionsBlockBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding = null;
            }
            activityConnectionsBlockBinding.b.setVisibility(8);
        }

        @Override // com.wear.widget.ConnectionsSideBar.a
        public void b(@NotNull String letter) {
            Intrinsics.checkNotNullParameter(letter, "letter");
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding = ConnectionsBlockActivity.this.a;
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding2 = null;
            if (activityConnectionsBlockBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding = null;
            }
            Context context = activityConnectionsBlockBinding.d.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.sideBar.context");
            xu1.a(context);
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding3 = ConnectionsBlockActivity.this.a;
            if (activityConnectionsBlockBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding3 = null;
            }
            TextView textView = activityConnectionsBlockBinding3.b;
            ConnectionsBlockActivity connectionsBlockActivity = ConnectionsBlockActivity.this;
            textView.setText(letter);
            textView.setVisibility(0);
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding4 = connectionsBlockActivity.a;
            if (activityConnectionsBlockBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding4 = null;
            }
            float y = activityConnectionsBlockBinding4.d.getY();
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding5 = connectionsBlockActivity.a;
            if (activityConnectionsBlockBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding5 = null;
            }
            int cellHeight = activityConnectionsBlockBinding5.d.getE();
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding6 = connectionsBlockActivity.a;
            if (activityConnectionsBlockBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding6 = null;
            }
            float currentIndex = y + (cellHeight * activityConnectionsBlockBinding6.d.getF());
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding7 = connectionsBlockActivity.a;
            if (activityConnectionsBlockBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding7 = null;
            }
            textView.setY(currentIndex - ((activityConnectionsBlockBinding7.d.getE() / 4) * 3));
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding8 = ConnectionsBlockActivity.this.a;
            if (activityConnectionsBlockBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityConnectionsBlockBinding8 = null;
            }
            RecyclerView.Adapter adapter = activityConnectionsBlockBinding8.c.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.longDistance.adapter.ConnectionsBlockAdapter");
            Iterator it = ((ConnectionsBlockAdapter) adapter).K().iterator();
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
            ConnectionsBlockActivity connectionsBlockActivity2 = ConnectionsBlockActivity.this;
            if (i == -1) {
                return;
            }
            ActivityConnectionsBlockBinding activityConnectionsBlockBinding9 = connectionsBlockActivity2.a;
            if (activityConnectionsBlockBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityConnectionsBlockBinding2 = activityConnectionsBlockBinding9;
            }
            RecyclerView.LayoutManager layoutManager = activityConnectionsBlockBinding2.c.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
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
    public static final class e extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
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
    public static final class f extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function0 function0, ComponentActivity componentActivity) {
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

    public static final void A4(BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = adapter.K().get(i);
        if (obj instanceof ConnectionBlockBean) {
            pj3.i(view.getContext(), HandlerBlockedFriendsActivity.class, "values", ((ConnectionBlockBean) obj).convertBlockFriend());
        }
    }

    @JvmStatic
    public static final void F4(@NotNull Context context) {
        c.a(context);
    }

    public static final void x4(ConnectionsBlockActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void z4(RecyclerView this_with, ConnectionsBlockActivity this$0, int i) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this_with.getAdapter();
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding = null;
        ConnectionsBlockAdapter connectionsBlockAdapter = adapter instanceof ConnectionsBlockAdapter ? (ConnectionsBlockAdapter) adapter : null;
        if (connectionsBlockAdapter == null) {
            return;
        }
        List<T> listK = connectionsBlockAdapter.K();
        if (listK.isEmpty()) {
            return;
        }
        Object obj = listK.get(i);
        ConnectionLetterBean connectionLetterBean = obj instanceof ConnectionLetterBean ? (ConnectionLetterBean) obj : null;
        if (connectionLetterBean == null) {
            return;
        }
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding2 = this$0.a;
        if (activityConnectionsBlockBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBinding2 = null;
        }
        activityConnectionsBlockBinding2.f.e(connectionLetterBean.getLetter());
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding3 = this$0.a;
        if (activityConnectionsBlockBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBlockBinding = activityConnectionsBlockBinding3;
        }
        activityConnectionsBlockBinding.f.executePendingBindings();
    }

    public final void B4() {
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding = this.a;
        if (activityConnectionsBlockBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBinding = null;
        }
        activityConnectionsBlockBinding.d.setOnLetterChangeListener(new c());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityConnectionsBlockBinding activityConnectionsBlockBindingB = ActivityConnectionsBlockBinding.b(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityConnectionsBlockBindingB, "inflate(layoutInflater)");
        this.a = activityConnectionsBlockBindingB;
        if (activityConnectionsBlockBindingB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBindingB = null;
        }
        setContentView(activityConnectionsBlockBindingB.getRoot());
        y4();
        B4();
        w4();
        v4();
        WearUtils.o2(this, "key_show_red_by_connections");
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground));
        return true;
    }

    public final ConnectionsBlockViewModel u4() {
        return (ConnectionsBlockViewModel) this.b.getValue();
    }

    public final void v4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(null), 3, null);
    }

    public final void w4() {
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding = this.a;
        if (activityConnectionsBlockBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBinding = null;
        }
        activityConnectionsBlockBinding.a.setOnClickListener(new View.OnClickListener() { // from class: dc.b63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectionsBlockActivity.x4(this.a, view);
            }
        });
    }

    public final void y4() {
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding = this.a;
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding2 = null;
        if (activityConnectionsBlockBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBinding = null;
        }
        final RecyclerView recyclerView = activityConnectionsBlockBinding.c;
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding3 = this.a;
        if (activityConnectionsBlockBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectionsBlockBinding3 = null;
        }
        activityConnectionsBlockBinding3.e.setDataCallback(new StickyHeadContainer.a() { // from class: dc.d63
            @Override // com.wear.widget.sticky.StickyHeadContainer.a
            public final void a(int i) {
                ConnectionsBlockActivity.z4(recyclerView, this, i);
            }
        });
        ActivityConnectionsBlockBinding activityConnectionsBlockBinding4 = this.a;
        if (activityConnectionsBlockBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectionsBlockBinding2 = activityConnectionsBlockBinding4;
        }
        recyclerView.addItemDecoration(new StickyItemDecoration(activityConnectionsBlockBinding2.e, 0));
        ConnectionsBlockAdapter connectionsBlockAdapter = new ConnectionsBlockAdapter(new ArrayList());
        connectionsBlockAdapter.E0(new br() { // from class: dc.c63
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ConnectionsBlockActivity.A4(baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(connectionsBlockAdapter);
        connectionsBlockAdapter.u0(R.layout.empty_connections_block);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.ui.longDistance.ConnectionsBlockActivity$initRecyclerView$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                ActivityConnectionsBlockBinding activityConnectionsBlockBinding5 = null;
                ConnectionsBlockAdapter connectionsBlockAdapter2 = adapter instanceof ConnectionsBlockAdapter ? (ConnectionsBlockAdapter) adapter : null;
                if (connectionsBlockAdapter2 == null || connectionsBlockAdapter2.K().isEmpty()) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                tq tqVar = (tq) connectionsBlockAdapter2.getItem(((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
                String letter = tqVar instanceof ConnectionLetterBean ? ((ConnectionLetterBean) tqVar).getLetter() : null;
                if (letter != null) {
                    ActivityConnectionsBlockBinding activityConnectionsBlockBinding6 = this.a.a;
                    if (activityConnectionsBlockBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityConnectionsBlockBinding5 = activityConnectionsBlockBinding6;
                    }
                    activityConnectionsBlockBinding5.d.setLetter(letter);
                }
            }
        });
    }
}
