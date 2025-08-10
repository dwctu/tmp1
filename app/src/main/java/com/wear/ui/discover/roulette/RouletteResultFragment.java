package com.wear.ui.discover.roulette;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import com.lovense.wear.R;
import com.wear.BaseBindingFragment;
import com.wear.bean.Account;
import com.wear.bean.FindMatchUserBean;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.RouletteStatus;
import com.wear.databinding.FragmentRouletteResultBinding;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;
import com.wear.util.WearUtils;
import com.wear.widget.RadarScanView;
import dc.my2;
import dc.o44;
import dc.uy3;
import dc.v34;
import dc.wz3;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteResultFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006("}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteResultFragment;", "Lcom/wear/BaseBindingFragment;", "Lcom/wear/databinding/FragmentRouletteResultBinding;", "Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$OnCountdownEndListener;", "()V", "matchingTime", "", "rouletteMatchSuccessFragment", "Lcom/wear/ui/discover/roulette/RouletteMatchSuccessFragment;", "viewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animatorView", "", "isStart", "", "initData", "initView", "navigationToRouletteHomeFragment", "notifyUserAvatar", "onDestroy", "onEnd", "onEventMsg", "event", "Lcom/wear/bean/FindMatchUserBean;", "onProgress", "countTime", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showRouletteMatchSuccessFragment", "rouletteStatus", "Lcom/wear/bean/RouletteStatus$MatchSuccess;", "Listeners", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteResultFragment extends BaseBindingFragment<FragmentRouletteResultBinding> implements RoundProgressBar.a {

    @NotNull
    public final Lazy c;

    @Nullable
    public RouletteMatchSuccessFragment d;
    public long e;

    /* compiled from: RouletteResultFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRouletteResultBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentRouletteResultBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentRouletteResultBinding;", 0);
        }

        @NotNull
        public final FragmentRouletteResultBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRouletteResultBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRouletteResultBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: RouletteResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteResultFragment$Listeners;", "", "(Lcom/wear/ui/discover/roulette/RouletteResultFragment;)V", "cancelMatching", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class b {
        public b() {
        }

        public final void a() {
            RouletteResultFragment.this.E().z();
        }
    }

    /* compiled from: Animator.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ RouletteResultFragment b;

        public c(boolean z, RouletteResultFragment rouletteResultFragment) {
            this.a = z;
            this.b = rouletteResultFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.a) {
                return;
            }
            this.b.J();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: RouletteResultFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteResultFragment$initData$1", f = "RouletteResultFragment.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: RouletteResultFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/RouletteStatus;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteResultFragment$initData$1$1", f = "RouletteResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<RouletteStatus, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ RouletteResultFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RouletteResultFragment rouletteResultFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = rouletteResultFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull RouletteStatus rouletteStatus, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(rouletteStatus, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                a aVar = new a(this.this$0, continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
                /*
                    Method dump skipped, instructions count: 339
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.RouletteResultFragment.d.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteResultFragment.this.new d(continuation);
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
                o44<RouletteStatus> o44VarP = RouletteResultFragment.this.E().p();
                a aVar = new a(RouletteResultFragment.this, null);
                this.label = 1;
                if (v34.g(o44VarP, aVar, this) == coroutine_suspended) {
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

    /* compiled from: RouletteResultFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteResultFragment$navigationToRouletteHomeFragment$1", f = "RouletteResultFragment.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: RouletteResultFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteResultFragment$navigationToRouletteHomeFragment$1$1", f = "RouletteResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ RouletteResultFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RouletteResultFragment rouletteResultFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = rouletteResultFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Resources.NotFoundException {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                NavDestination currentDestination = FragmentKt.findNavController(this.this$0).getCurrentDestination();
                boolean z = false;
                if (currentDestination != null && currentDestination.getId() == R.id.rouletteResultFragment) {
                    z = true;
                }
                if (z) {
                    FragmentKt.findNavController(this.this$0).navigate(R.id.action_rouletteResultFragment_to_rouletteHomeFragment);
                }
                return Unit.INSTANCE;
            }
        }

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteResultFragment.this.new e(continuation);
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
                Lifecycle lifecycle = RouletteResultFragment.this.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                Lifecycle.State state = Lifecycle.State.RESUMED;
                a aVar = new a(RouletteResultFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, aVar, this) == coroutine_suspended) {
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

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$5"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Function0 function0, Fragment fragment) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_activityViewModels = fragment;
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
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$6"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public RouletteResultFragment() {
        super(a.a);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new f(this), new g(null, this), new h(this));
    }

    public final void D(boolean z) {
        CircleImageView circleImageView = t().a;
        float[] fArr = new float[2];
        fArr[0] = z ? 1.0f : 0.0f;
        fArr[1] = z ? 0.0f : 1.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(circleImageView, "alpha", fArr);
        RadarScanView radarScanView = t().b;
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 0.0f : 1.0f;
        fArr2[1] = z ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(radarScanView, "alpha", fArr2);
        RadarScanView radarScanView2 = t().b;
        float[] fArr3 = new float[2];
        fArr3[0] = z ? 0.0f : 1.0f;
        fArr3[1] = z ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(radarScanView2, "scaleX", fArr3);
        RadarScanView radarScanView3 = t().b;
        float[] fArr4 = new float[2];
        fArr4[0] = z ? 0.0f : 1.0f;
        fArr4[1] = z ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(radarScanView3, "scaleY", fArr4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4);
        animatorSet.removeAllListeners();
        animatorSet.addListener(new c(z, this));
        animatorSet.start();
    }

    public final RouletteViewModel E() {
        return (RouletteViewModel) this.c.getValue();
    }

    public final void F() {
        EventBus.getDefault().register(this);
        RouletteViewModel.y(E(), false, 1, null);
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d(null), 3, null);
    }

    public final void I() {
        RoundProgressBar roundProgressBar = t().c;
        RouletteSettingBean rouletteSettingBean = E().q().get();
        if (rouletteSettingBean != null) {
            Integer countdown = rouletteSettingBean.getCountdown();
            roundProgressBar.setTimeMillis(countdown != null ? countdown.intValue() : 30);
        }
        roundProgressBar.setCountdownProgressListener(this);
        roundProgressBar.g();
        K();
        D(true);
    }

    public final void J() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new e(null), 3, null);
        my2.i.a().D(true);
    }

    public final void K() {
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            String avatar = accountU.getAvatar();
            if (!(avatar == null || avatar.length() == 0)) {
                WearUtils.u2(t().a, accountU.getAvatar());
                return;
            }
        }
        t().a.setImageResource(R.drawable.chat_avatar_default);
    }

    public final void L(RouletteStatus.MatchSuccess matchSuccess) {
        RouletteMatchSuccessFragment rouletteMatchSuccessFragment = new RouletteMatchSuccessFragment();
        this.d = rouletteMatchSuccessFragment;
        Intrinsics.checkNotNull(rouletteMatchSuccessFragment);
        rouletteMatchSuccessFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("findMatchUserBean", matchSuccess.getFindMatchUserBean())));
        RouletteMatchSuccessFragment rouletteMatchSuccessFragment2 = this.d;
        Intrinsics.checkNotNull(rouletteMatchSuccessFragment2);
        rouletteMatchSuccessFragment2.show(getChildFragmentManager(), "matchSuccess");
    }

    @Override // com.wear.ui.discover.roulette.widget.RoundProgressBar.a
    public void a(int i) {
    }

    @Override // com.wear.ui.discover.roulette.widget.RoundProgressBar.a
    public void e() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@Nullable FindMatchUserBean event) {
        if (event != null) {
            E().A(event);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        t().d(new b());
        I();
        F();
        my2.i.a().C();
    }
}
