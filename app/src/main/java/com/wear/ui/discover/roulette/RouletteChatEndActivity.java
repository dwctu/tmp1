package com.wear.ui.discover.roulette;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.RouletteLimit;
import com.wear.bean.UserJoinChatBean;
import com.wear.databinding.ActivityRouletteChatEndBinding;
import com.wear.ui.chat.NewChatViewModel;
import com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom;
import com.wear.ui.discover.roulette.RouletteChatEndActivity;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import com.wear.ui.me.ControlRouletteReportActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.kg3;
import dc.ku1;
import dc.sg3;
import dc.th4;
import dc.uy3;
import dc.vl2;
import dc.wz3;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteChatEndActivity.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020!H\u0014J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020,H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteChatEndActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityRouletteChatEndBinding;", "cheViewModel", "Lcom/wear/ui/chat/NewChatViewModel;", "getCheViewModel", "()Lcom/wear/ui/chat/NewChatViewModel;", "cheViewModel$delegate", "Lkotlin/Lazy;", "reason", "", "getReason", "()I", "reason$delegate", "rouletteViewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getRouletteViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "rouletteViewModel$delegate", "time", "", "getTime", "()Ljava/lang/String;", "time$delegate", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "getUserJoinChatBean", "()Lcom/wear/bean/UserJoinChatBean;", "userJoinChatBean$delegate", "initIntentData", "", "initListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showReportActionMenuFragmentBottom", "view", "Landroid/view/View;", "skipBaseSettingBarColor", "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteChatEndActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a g = new a(null);
    public ActivityRouletteChatEndBinding a;

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(new l());

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(new c());

    @NotNull
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new k());

    @NotNull
    public final Lazy e = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewChatViewModel.class), new f(this), new e(this), new g(null, this));

    @NotNull
    public final Lazy f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new i(this), new h(this), new j(null, this));

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteChatEndActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "reason", "", "time", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull UserJoinChatBean userJoinChatBean, int i, @NotNull String time) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
            Intrinsics.checkNotNullParameter(time, "time");
            Intent intent = new Intent(context, (Class<?>) RouletteChatEndActivity.class);
            intent.putExtra("userJoinChatBean", userJoinChatBean);
            intent.putExtra("reason", i);
            intent.putExtra("time", time);
            context.startActivity(intent);
        }
    }

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteChatEndActivity$initListener$4$1", f = "RouletteChatEndActivity.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ View $view;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$view = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteChatEndActivity.this.new b(this.$view, continuation);
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
                RouletteViewModel rouletteViewModelX4 = RouletteChatEndActivity.this.x4();
                this.label = 1;
                obj = rouletteViewModelX4.t(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RouletteLimit rouletteLimit = (RouletteLimit) obj;
            if (!(rouletteLimit != null ? Intrinsics.areEqual(rouletteLimit.getEnable(), Boxing.boxBoolean(true)) : false)) {
                sg3.l(ah4.e(R.string.control_roulette_report_frequently_toast));
                RouletteChatEndActivity.this.dismissLoadingProgress();
                return Unit.INSTANCE;
            }
            RouletteChatEndActivity.this.dismissLoadingProgress();
            RouletteChatEndActivity rouletteChatEndActivity = RouletteChatEndActivity.this;
            View view = this.$view;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            rouletteChatEndActivity.J4(view);
            UserJoinChatBean userJoinChatBeanZ4 = RouletteChatEndActivity.this.z4();
            ku1.f("Control Roulette", "control_roulette_end_page_report_click", "control_roulette_end_page_report", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : userJoinChatBeanZ4 != null ? userJoinChatBeanZ4.getUserAccountCode() : null, (40 & 32) != 0 ? null : null);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Integer> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(RouletteChatEndActivity.this.getIntent().getIntExtra("reason", 0));
        }
    }

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/roulette/RouletteChatEndActivity$showReportActionMenuFragmentBottom$1", "Lcom/wear/ui/chat/fragment/ReportActionMenuFragmentBottom$OnReportActionMenuClickListener;", "onReportActionMenuClick", "", "type", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements ReportActionMenuFragmentBottom.b {
        public final /* synthetic */ View b;

        public d(View view) {
            this.b = view;
        }

        @Override // com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom.b
        public void a(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            UserJoinChatBean userJoinChatBeanZ4 = RouletteChatEndActivity.this.z4();
            if (userJoinChatBeanZ4 != null) {
                View view = this.b;
                ControlRouletteReportActivity.a aVar = ControlRouletteReportActivity.i;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                aVar.a(context, type, userJoinChatBeanZ4);
            }
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ComponentActivity componentActivity) {
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
    public static final class f extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
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
    public static final class g extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Function0 function0, ComponentActivity componentActivity) {
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

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
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
    public static final class i extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
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
    public static final class j extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Function0 function0, ComponentActivity componentActivity) {
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

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<String> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = RouletteChatEndActivity.this.getIntent().getStringExtra("time");
            return stringExtra == null ? "" : stringExtra;
        }
    }

    /* compiled from: RouletteChatEndActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/bean/UserJoinChatBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function0<UserJoinChatBean> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserJoinChatBean invoke() {
            return Build.VERSION.SDK_INT >= 33 ? (UserJoinChatBean) RouletteChatEndActivity.this.getIntent().getParcelableExtra("userJoinChatBean", UserJoinChatBean.class) : (UserJoinChatBean) RouletteChatEndActivity.this.getIntent().getParcelableExtra("userJoinChatBean");
        }
    }

    public static final void C4(RouletteChatEndActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnBackPressedDispatcher().onBackPressed();
    }

    public static final void D4(RouletteChatEndActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnBackPressedDispatcher().onBackPressed();
    }

    public static final void E4(RouletteChatEndActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showLoadingProgress();
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, this$0.new b(view, null), 3, null);
    }

    public final void A4() {
        UserJoinChatBean userJoinChatBeanZ4 = z4();
        if (userJoinChatBeanZ4 != null) {
            v4().K(userJoinChatBeanZ4.getUserAccountCode());
            v4().L(userJoinChatBeanZ4.getToys());
            v4().H(userJoinChatBeanZ4.getEncryptionMode());
        }
    }

    public final void B4() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.wear.ui.discover.roulette.RouletteChatEndActivity$initListener$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                UserJoinChatBean userJoinChatBeanZ4 = this.a.z4();
                if (userJoinChatBeanZ4 != null && userJoinChatBeanZ4.getIsFromOuter()) {
                    this.a.finish();
                } else {
                    ToyRouletteActivity.b.a(this.a);
                    this.a.finish();
                }
            }
        });
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding = this.a;
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding2 = null;
        if (activityRouletteChatEndBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBinding = null;
        }
        activityRouletteChatEndBinding.a.setBackAction(new MyActionBar.f() { // from class: dc.ux2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                RouletteChatEndActivity.C4(this.a, view);
            }
        });
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding3 = this.a;
        if (activityRouletteChatEndBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBinding3 = null;
        }
        activityRouletteChatEndBinding3.b.setOnClickListener(new View.OnClickListener() { // from class: dc.tx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteChatEndActivity.D4(this.a, view);
            }
        });
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding4 = this.a;
        if (activityRouletteChatEndBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityRouletteChatEndBinding2 = activityRouletteChatEndBinding4;
        }
        activityRouletteChatEndBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: dc.sx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteChatEndActivity.E4(this.a, view);
            }
        });
    }

    public final void F4() {
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding = this.a;
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding2 = null;
        if (activityRouletteChatEndBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBinding = null;
        }
        activityRouletteChatEndBinding.d.getPaint().setFlags(8);
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding3 = this.a;
        if (activityRouletteChatEndBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBinding3 = null;
        }
        activityRouletteChatEndBinding3.d.getPaint().setAntiAlias(true);
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding4 = this.a;
        if (activityRouletteChatEndBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBinding4 = null;
        }
        activityRouletteChatEndBinding4.d(y4());
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding5 = this.a;
        if (activityRouletteChatEndBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityRouletteChatEndBinding2 = activityRouletteChatEndBinding5;
        }
        activityRouletteChatEndBinding2.c.setText(ah4.e(w4() == 1 ? R.string.control_roulette_end_session : R.string.control_roulette_end_session2));
    }

    public final void J4(View view) {
        ReportActionMenuFragmentBottom reportActionMenuFragmentBottom = new ReportActionMenuFragmentBottom();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        reportActionMenuFragmentBottom.show(supportFragmentManager, "ReportActionMenuFragmentBottom");
        reportActionMenuFragmentBottom.E(new d(view));
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRouletteChatEndBinding activityRouletteChatEndBindingB = ActivityRouletteChatEndBinding.b(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityRouletteChatEndBindingB, "inflate(layoutInflater)");
        this.a = activityRouletteChatEndBindingB;
        if (activityRouletteChatEndBindingB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRouletteChatEndBindingB = null;
        }
        setContentView(activityRouletteChatEndBindingB.getRoot());
        A4();
        F4();
        B4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v4().i();
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground));
        ActivityRouletteChatEndBinding activityRouletteChatEndBinding = this.a;
        if (activityRouletteChatEndBinding != null) {
            if (activityRouletteChatEndBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityRouletteChatEndBinding = null;
            }
            activityRouletteChatEndBinding.a.setParentBackgroundColor(0);
        }
        return true;
    }

    public final NewChatViewModel v4() {
        return (NewChatViewModel) this.e.getValue();
    }

    public final int w4() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final RouletteViewModel x4() {
        return (RouletteViewModel) this.f.getValue();
    }

    public final String y4() {
        return (String) this.d.getValue();
    }

    public final UserJoinChatBean z4() {
        return (UserJoinChatBean) this.b.getValue();
    }
}
