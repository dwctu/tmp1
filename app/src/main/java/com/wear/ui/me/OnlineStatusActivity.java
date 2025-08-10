package com.wear.ui.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.me.OnlineStatusHeadBean;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.databinding.ActivityOnlineStatusBinding;
import com.wear.ui.me.OnlineStatusActivity;
import com.wear.ui.me.adapter.GridSpaceItemDecoration;
import com.wear.ui.me.adapter.OnlineStatusHeaderAdapter;
import com.wear.ui.me.adapter.OnlineStatusUserAdapter;
import com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom;
import com.wear.ui.me.viewmodel.OnlineStatusViewModel;
import com.wear.widget.swipe.EasySwipeMenuLayout;
import dc.ah4;
import dc.br;
import dc.kc3;
import dc.ku1;
import dc.o44;
import dc.qe0;
import dc.uy3;
import dc.v34;
import dc.vl2;
import dc.wz3;
import dc.zq;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/wear/ui/me/OnlineStatusActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityOnlineStatusBinding;", "isShowDialog", "", "onlineStatusViewModel", "Lcom/wear/ui/me/viewmodel/OnlineStatusViewModel;", "getOnlineStatusViewModel", "()Lcom/wear/ui/me/viewmodel/OnlineStatusViewModel;", "onlineStatusViewModel$delegate", "Lkotlin/Lazy;", "getOnlineStatusLogName", "", "position", "", "initData", "", "initHeaderRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initListener", "initRecyclerView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineStatusActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a d = new a(null);
    public ActivityOnlineStatusBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(OnlineStatusViewModel.class), new f(this), new e(this), new g(null, this));
    public boolean c;

    /* compiled from: OnlineStatusActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/me/OnlineStatusActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) OnlineStatusActivity.class));
        }
    }

    /* compiled from: OnlineStatusActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.OnlineStatusActivity$initData$1", f = "OnlineStatusActivity.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: OnlineStatusActivity.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.me.OnlineStatusActivity$initData$1$1", f = "OnlineStatusActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
            public /* synthetic */ int I$0;
            public int label;
            public final /* synthetic */ OnlineStatusActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OnlineStatusActivity onlineStatusActivity, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = onlineStatusActivity;
            }

            @Nullable
            public final Object c(int i, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                a aVar = new a(this.this$0, continuation);
                aVar.I$0 = ((Number) obj).intValue();
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                return c(num.intValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                int i = this.I$0;
                ActivityOnlineStatusBinding activityOnlineStatusBinding = this.this$0.a;
                ActivityOnlineStatusBinding activityOnlineStatusBinding2 = null;
                if (activityOnlineStatusBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityOnlineStatusBinding = null;
                }
                TextView textView = activityOnlineStatusBinding.a;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.add");
                textView.setVisibility(i == 1 ? 8 : 0);
                ActivityOnlineStatusBinding activityOnlineStatusBinding3 = this.this$0.a;
                if (activityOnlineStatusBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityOnlineStatusBinding2 = activityOnlineStatusBinding3;
                }
                activityOnlineStatusBinding2.d(Boxing.boxInt(i));
                if (this.this$0.c) {
                    this.this$0.showLoadingProgress();
                } else {
                    this.this$0.c = true;
                }
                this.this$0.x4().e();
                return Unit.INSTANCE;
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OnlineStatusActivity.this.new b(continuation);
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
                o44<Integer> o44VarG = OnlineStatusActivity.this.x4().g();
                a aVar = new a(OnlineStatusActivity.this, null);
                this.label = 1;
                if (v34.g(o44VarG, aVar, this) == coroutine_suspended) {
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

    /* compiled from: OnlineStatusActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.OnlineStatusActivity$initData$2", f = "OnlineStatusActivity.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: OnlineStatusActivity.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/ui/me/intent/OnlineStatusUserIntent;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.me.OnlineStatusActivity$initData$2$1", f = "OnlineStatusActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<kc3, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ OnlineStatusActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OnlineStatusActivity onlineStatusActivity, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = onlineStatusActivity;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull kc3 kc3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(kc3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                a aVar = new a(this.this$0, continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                kc3 kc3Var = (kc3) this.L$0;
                if (kc3Var instanceof kc3.a) {
                    this.this$0.dismissLoadingProgress();
                    ActivityOnlineStatusBinding activityOnlineStatusBinding = this.this$0.a;
                    ActivityOnlineStatusBinding activityOnlineStatusBinding2 = null;
                    if (activityOnlineStatusBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityOnlineStatusBinding = null;
                    }
                    kc3.a aVar = (kc3.a) kc3Var;
                    activityOnlineStatusBinding.e(Boxing.boxInt(aVar.a().size()));
                    ActivityOnlineStatusBinding activityOnlineStatusBinding3 = this.this$0.a;
                    if (activityOnlineStatusBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityOnlineStatusBinding2 = activityOnlineStatusBinding3;
                    }
                    RecyclerView.Adapter adapter = activityOnlineStatusBinding2.b.getAdapter();
                    Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.me.adapter.OnlineStatusUserAdapter");
                    ((OnlineStatusUserAdapter) adapter).y0(aVar.a());
                }
                return Unit.INSTANCE;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OnlineStatusActivity.this.new c(continuation);
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
                o44<kc3> o44VarI = OnlineStatusActivity.this.x4().i();
                a aVar = new a(OnlineStatusActivity.this, null);
                this.label = 1;
                if (v34.g(o44VarI, aVar, this) == coroutine_suspended) {
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

    /* compiled from: OnlineStatusActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ BaseQuickAdapter<?, ?> $adapter;
        public final /* synthetic */ int $position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BaseQuickAdapter<?, ?> baseQuickAdapter, int i) {
            super(1);
            this.$adapter = baseQuickAdapter;
            this.$position = i;
        }

        public final void a(boolean z) {
            OnlineStatusActivity.this.dismissLoadingProgress();
            if (z) {
                this.$adapter.q0(this.$position);
                ActivityOnlineStatusBinding activityOnlineStatusBinding = OnlineStatusActivity.this.a;
                if (activityOnlineStatusBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityOnlineStatusBinding = null;
                }
                activityOnlineStatusBinding.e(Integer.valueOf(this.$adapter.getItemCount()));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
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

    public static final void A4(OnlineStatusHeaderAdapter onlineStatusHeaderAdapter, OnlineStatusActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(onlineStatusHeaderAdapter, "$onlineStatusHeaderAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        int size = onlineStatusHeaderAdapter.K().size();
        for (int i2 = 0; i2 < size; i2++) {
            onlineStatusHeaderAdapter.K().get(i2).setSelected(false);
        }
        onlineStatusHeaderAdapter.K().get(i).setSelected(true);
        onlineStatusHeaderAdapter.notifyDataSetChanged();
        this$0.x4().d(i);
        ku1.f("my status", "online_status_click", "online_status", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : this$0.w4(i), (40 & 32) != 0 ? null : null);
    }

    public static final void C4(OnlineStatusActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnlineStatusUserFragmentBottom onlineStatusUserFragmentBottom = new OnlineStatusUserFragmentBottom();
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        onlineStatusUserFragmentBottom.show(supportFragmentManager, "OnlineStatusUserFragmentBottom");
        ku1.f("my status", "status_add_friends_click", "add_friends", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : this$0.x4().f() == 0 ? "available" : "invisible", (40 & 32) != 0 ? null : null);
    }

    public static final void E4(OnlineStatusUserAdapter onlineStatusUserAdapter, OnlineStatusActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(onlineStatusUserAdapter, "$onlineStatusUserAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        View viewZ = adapter.Z(i, R.id.swipe_layout);
        EasySwipeMenuLayout easySwipeMenuLayout = viewZ instanceof EasySwipeMenuLayout ? (EasySwipeMenuLayout) viewZ : null;
        if (easySwipeMenuLayout != null) {
            easySwipeMenuLayout.d();
        }
        OnlineStatusUserBean onlineStatusUserBean = onlineStatusUserAdapter.K().get(i);
        this$0.showLoadingProgress();
        String email = onlineStatusUserBean.getEmail();
        if (email != null) {
            this$0.x4().l(email, this$0.new d(adapter, i));
        }
        ku1.f("my status", "status_friend_delete_click", "status_friend_delete", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : this$0.x4().f() == 0 ? "available" : "invisible", (40 & 32) != 0 ? null : null);
    }

    public final void B4() {
        ActivityOnlineStatusBinding activityOnlineStatusBinding = this.a;
        if (activityOnlineStatusBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOnlineStatusBinding = null;
        }
        activityOnlineStatusBinding.a.setOnClickListener(new View.OnClickListener() { // from class: dc.ib3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusActivity.C4(this.a, view);
            }
        });
    }

    public final void D4(RecyclerView recyclerView) {
        final int iA = qe0.a(16.0f);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.wear.ui.me.OnlineStatusActivity$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                outRect.bottom = iA;
            }
        });
        final OnlineStatusUserAdapter onlineStatusUserAdapter = new OnlineStatusUserAdapter(new ArrayList());
        onlineStatusUserAdapter.n(R.id.tv_delete);
        onlineStatusUserAdapter.A0(new zq() { // from class: dc.jb3
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OnlineStatusActivity.E4(onlineStatusUserAdapter, this, baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(onlineStatusUserAdapter);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOnlineStatusBinding activityOnlineStatusBindingB = ActivityOnlineStatusBinding.b(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityOnlineStatusBindingB, "inflate(layoutInflater)");
        this.a = activityOnlineStatusBindingB;
        ActivityOnlineStatusBinding activityOnlineStatusBinding = null;
        if (activityOnlineStatusBindingB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOnlineStatusBindingB = null;
        }
        setContentView(activityOnlineStatusBindingB.getRoot());
        ku1.j("my status", "my_status_exposure", "exposure", "my_status", null, 16, null);
        ActivityOnlineStatusBinding activityOnlineStatusBinding2 = this.a;
        if (activityOnlineStatusBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOnlineStatusBinding2 = null;
        }
        RecyclerView recyclerView = activityOnlineStatusBinding2.c;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerViewHeader");
        z4(recyclerView);
        ActivityOnlineStatusBinding activityOnlineStatusBinding3 = this.a;
        if (activityOnlineStatusBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityOnlineStatusBinding = activityOnlineStatusBinding3;
        }
        RecyclerView recyclerView2 = activityOnlineStatusBinding.b;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        D4(recyclerView2);
        B4();
        y4();
    }

    public final String w4(int i) {
        return i != 1 ? i != 2 ? "available" : "invisible" : "busy";
    }

    public final OnlineStatusViewModel x4() {
        return (OnlineStatusViewModel) this.b.getValue();
    }

    public final void y4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(null), 3, null);
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c(null), 3, null);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void z4(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpaceItemDecoration(3, qe0.a(10.0f), false));
        String strE = ah4.e(R.string.user_profile_status_available);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.user_profile_status_available)");
        String strE2 = ah4.e(R.string.user_profile_status_busy);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.user_profile_status_busy)");
        String strE3 = ah4.e(R.string.user_profile_status_invisible);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.user_profile_status_invisible)");
        List listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new OnlineStatusHeadBean(strE, R.drawable.online_status_available, false, 4, null), new OnlineStatusHeadBean(strE2, R.drawable.online_status_busy, false, 4, null), new OnlineStatusHeadBean(strE3, R.drawable.online_status_incisible, false, 4, null));
        ((OnlineStatusHeadBean) listMutableListOf.get(x4().f())).setSelected(true);
        final OnlineStatusHeaderAdapter onlineStatusHeaderAdapter = new OnlineStatusHeaderAdapter(listMutableListOf);
        onlineStatusHeaderAdapter.E0(new br() { // from class: dc.kb3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OnlineStatusActivity.A4(onlineStatusHeaderAdapter, this, baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(onlineStatusHeaderAdapter);
    }
}
