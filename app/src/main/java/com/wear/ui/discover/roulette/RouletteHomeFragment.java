package com.wear.ui.discover.roulette;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.broadcom.bt.util.io.IOUtils;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.lovense.wear.R;
import com.wear.BaseBindingFragment;
import com.wear.bean.Account;
import com.wear.bean.RouletteBan;
import com.wear.bean.RouletteRequestStatus;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.RouletteStatus;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.databinding.FragmentRouletteHomeBinding;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import dc.ah4;
import dc.hf3;
import dc.ku1;
import dc.na2;
import dc.o44;
import dc.pc1;
import dc.qy2;
import dc.ru1;
import dc.sg3;
import dc.ue0;
import dc.uf2;
import dc.uy3;
import dc.v34;
import dc.wz3;
import dc.yu1;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteHomeFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0014\u0010\u0015\u001a\u00020\u000b2\n\u0010\u0016\u001a\u00060\u0017R\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0019\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteHomeFragment;", "Lcom/wear/BaseBindingFragment;", "Lcom/wear/databinding/FragmentRouletteHomeBinding;", "()V", "viewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addStartMatchLog", "", "elementContent", "", "changeSearchButtonStatus", "status", "", "handleBanLogic", "rouletteBan", "Lcom/wear/bean/RouletteBan;", "initData", "initListener", "listeners", "Lcom/wear/ui/discover/roulette/RouletteHomeFragment$Listeners;", "initView", "notifyUserAvatar", "onDestroy", "onMessageEvent", "message", "Lcom/wear/bean/event/LoginOrOfflineEvent;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "startSearchReal", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Listeners", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteHomeFragment extends BaseBindingFragment<FragmentRouletteHomeBinding> {

    @NotNull
    public final Lazy c;

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRouletteHomeBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentRouletteHomeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentRouletteHomeBinding;", 0);
        }

        @NotNull
        public final FragmentRouletteHomeBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRouletteHomeBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRouletteHomeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteHomeFragment$Listeners;", "", "(Lcom/wear/ui/discover/roulette/RouletteHomeFragment;)V", "openFilter", "", "view", "Landroid/view/View;", "openSettings", "startSearch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class b {

        /* compiled from: RouletteHomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$Listeners$openFilter$1", f = "RouletteHomeFragment.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ RouletteHomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RouletteHomeFragment rouletteHomeFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = rouletteHomeFragment;
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
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RouletteViewModel rouletteViewModelE = this.this$0.E();
                    this.label = 1;
                    obj = rouletteViewModelE.r(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    ToastUtils.z(this.this$0.getString(R.string.common_timeout_error), new Object[0]);
                    return Unit.INSTANCE;
                }
                RouletteSettingBean rouletteSettingBean = this.this$0.E().q().get();
                if (!(rouletteSettingBean != null && rouletteSettingBean.isGenderSet()) || Intrinsics.areEqual(rouletteSettingBean.getGender(), EnvironmentCompat.MEDIA_UNKNOWN)) {
                    if (rouletteSettingBean != null) {
                        rouletteSettingBean.setGender(null);
                    }
                    this.this$0.E().D(rouletteSettingBean);
                    this.this$0.C(ExifInterface.GPS_MEASUREMENT_3D);
                } else {
                    RouletteFilterFragmentBottom rouletteFilterFragmentBottom = new RouletteFilterFragmentBottom();
                    Pair[] pairArr = new Pair[1];
                    RouletteSettingBean rouletteSettingBean2 = this.this$0.E().q().get();
                    pairArr[0] = TuplesKt.to("settingInfo", rouletteSettingBean2 != null ? RouletteSettingBean.copy$default(rouletteSettingBean2, null, null, null, null, null, null, null, 127, null) : null);
                    rouletteFilterFragmentBottom.setArguments(BundleKt.bundleOf(pairArr));
                    if (this.this$0.isResumed()) {
                        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        rouletteFilterFragmentBottom.show(parentFragmentManager, "filterDialog");
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* compiled from: RouletteHomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$Listeners$openSettings$1", f = "RouletteHomeFragment.kt", i = {}, l = {CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.wear.ui.discover.roulette.RouletteHomeFragment$b$b, reason: collision with other inner class name */
        public static final class C0144b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ RouletteHomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0144b(RouletteHomeFragment rouletteHomeFragment, Continuation<? super C0144b> continuation) {
                super(2, continuation);
                this.this$0 = rouletteHomeFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0144b(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((C0144b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    RouletteViewModel rouletteViewModelE = this.this$0.E();
                    this.label = 1;
                    obj = rouletteViewModelE.r(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
                RouletteSettingsFragmentBottom rouletteSettingsFragmentBottom = new RouletteSettingsFragmentBottom();
                Pair[] pairArr = new Pair[1];
                RouletteSettingBean rouletteSettingBean = this.this$0.E().q().get();
                pairArr[0] = TuplesKt.to("settingInfo", rouletteSettingBean != null ? RouletteSettingBean.copy$default(rouletteSettingBean, null, null, null, null, null, null, null, 127, null) : null);
                rouletteSettingsFragmentBottom.setArguments(BundleKt.bundleOf(pairArr));
                if (this.this$0.isResumed()) {
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    rouletteSettingsFragmentBottom.show(parentFragmentManager, "settingDialog");
                }
                return Unit.INSTANCE;
            }
        }

        /* compiled from: RouletteHomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$Listeners$startSearch$1", f = "RouletteHomeFragment.kt", i = {}, l = {214, 218, 221}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ RouletteHomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(RouletteHomeFragment rouletteHomeFragment, Continuation<? super c> continuation) {
                super(2, continuation);
                this.this$0 = rouletteHomeFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new c(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
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
                    if (r1 == 0) goto L26
                    if (r1 == r4) goto L22
                    if (r1 == r3) goto L1e
                    if (r1 != r2) goto L16
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L8a
                L16:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1e:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L52
                L22:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L38
                L26:
                    kotlin.ResultKt.throwOnFailure(r6)
                    com.wear.ui.discover.roulette.RouletteHomeFragment r6 = r5.this$0
                    com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.RouletteHomeFragment.y(r6)
                    r5.label = r4
                    java.lang.Object r6 = r6.r(r5)
                    if (r6 != r0) goto L38
                    return r0
                L38:
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    if (r6 != 0) goto L43
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                L43:
                    com.wear.ui.discover.roulette.RouletteHomeFragment r6 = r5.this$0
                    com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r6 = com.wear.ui.discover.roulette.RouletteHomeFragment.y(r6)
                    r5.label = r3
                    java.lang.Object r6 = r6.s(r5)
                    if (r6 != r0) goto L52
                    return r0
                L52:
                    com.wear.bean.RouletteBan r6 = (com.wear.bean.RouletteBan) r6
                    com.wear.ui.discover.roulette.RouletteHomeFragment r1 = r5.this$0
                    boolean r1 = r1.isResumed()
                    if (r1 != 0) goto L5f
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                L5f:
                    java.lang.Boolean r1 = r6.getBan()
                    java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
                    if (r1 != 0) goto L85
                    com.wear.ui.discover.roulette.RouletteHomeFragment r6 = r5.this$0
                    androidx.viewbinding.ViewBinding r1 = r6.t()
                    com.wear.databinding.FragmentRouletteHomeBinding r1 = (com.wear.databinding.FragmentRouletteHomeBinding) r1
                    android.widget.FrameLayout r1 = r1.e
                    java.lang.String r3 = "binding.searchContainer"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                    r5.label = r2
                    java.lang.Object r6 = com.wear.ui.discover.roulette.RouletteHomeFragment.B(r6, r1, r5)
                    if (r6 != r0) goto L8a
                    return r0
                L85:
                    com.wear.ui.discover.roulette.RouletteHomeFragment r0 = r5.this$0
                    com.wear.ui.discover.roulette.RouletteHomeFragment.A(r0, r6)
                L8a:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.RouletteHomeFragment.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public b() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!hf3.d(view.getContext())) {
                ToastUtils.z(RouletteHomeFragment.this.getString(R.string.net_connect_error_tip), new Object[0]);
            } else {
                if (MyApplication.O) {
                    uy3.d(LifecycleOwnerKt.getLifecycleScope(RouletteHomeFragment.this), null, null, new a(RouletteHomeFragment.this, null), 3, null);
                    return;
                }
                Context contextRequireContext = RouletteHomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                qy2.b(contextRequireContext);
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!hf3.d(view.getContext())) {
                ToastUtils.z(RouletteHomeFragment.this.getString(R.string.net_connect_error_tip), new Object[0]);
            } else {
                if (MyApplication.O) {
                    uy3.d(LifecycleOwnerKt.getLifecycleScope(RouletteHomeFragment.this), null, null, new C0144b(RouletteHomeFragment.this, null), 3, null);
                    return;
                }
                Context contextRequireContext = RouletteHomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                qy2.b(contextRequireContext);
            }
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!hf3.d(view.getContext())) {
                ToastUtils.z(RouletteHomeFragment.this.getString(R.string.net_connect_error_tip), new Object[0]);
                RouletteHomeFragment.this.C("4");
                return;
            }
            if (!MyApplication.O) {
                Context contextRequireContext = RouletteHomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                qy2.b(contextRequireContext);
                RouletteHomeFragment.this.C("2");
                return;
            }
            if (!pc1.a.P().isEmpty()) {
                if (!na2.m().i()) {
                    uy3.d(LifecycleOwnerKt.getLifecycleScope(RouletteHomeFragment.this), null, null, new c(RouletteHomeFragment.this, null), 3, null);
                    return;
                } else {
                    na2.m().t();
                    RouletteHomeFragment.this.C("5");
                    return;
                }
            }
            FragmentActivity activity = RouletteHomeFragment.this.getActivity();
            ToyRouletteActivity toyRouletteActivity = activity instanceof ToyRouletteActivity ? (ToyRouletteActivity) activity : null;
            if (toyRouletteActivity == null) {
                return;
            }
            toyRouletteActivity.z4();
            RouletteHomeFragment.this.C("1");
        }
    }

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$initData$1", f = "RouletteHomeFragment.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: RouletteHomeFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/RouletteStatus;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$initData$1$1", f = "RouletteHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<RouletteStatus, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ RouletteHomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RouletteHomeFragment rouletteHomeFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = rouletteHomeFragment;
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

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.t().f((RouletteStatus) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteHomeFragment.this.new c(continuation);
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
                o44<RouletteStatus> o44VarP = RouletteHomeFragment.this.E().p();
                a aVar = new a(RouletteHomeFragment.this, null);
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

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$initData$2", f = "RouletteHomeFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: RouletteHomeFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/bean/RouletteRequestStatus;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment$initData$2$1", f = "RouletteHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<RouletteRequestStatus, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object L$0;
            public int label;
            public final /* synthetic */ RouletteHomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(RouletteHomeFragment rouletteHomeFragment, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = rouletteHomeFragment;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull RouletteRequestStatus rouletteRequestStatus, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(rouletteRequestStatus, continuation)).invokeSuspend(Unit.INSTANCE);
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
                RouletteRequestStatus rouletteRequestStatus = (RouletteRequestStatus) this.L$0;
                if (rouletteRequestStatus instanceof RouletteRequestStatus.BanInfo) {
                    this.this$0.F(((RouletteRequestStatus.BanInfo) rouletteRequestStatus).getRouletteBan());
                } else {
                    boolean z = rouletteRequestStatus instanceof RouletteRequestStatus.Loading;
                    if (z || (rouletteRequestStatus instanceof RouletteRequestStatus.LoadingFailed) || (rouletteRequestStatus instanceof RouletteRequestStatus.LoadingSuccess)) {
                        if (z) {
                            this.this$0.D(false);
                        }
                        if ((rouletteRequestStatus instanceof RouletteRequestStatus.LoadingFailed) || (rouletteRequestStatus instanceof RouletteRequestStatus.LoadingSuccess)) {
                            this.this$0.D(true);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteHomeFragment.this.new d(continuation);
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
                o44<RouletteRequestStatus> o44VarO = RouletteHomeFragment.this.E().o();
                a aVar = new a(RouletteHomeFragment.this, null);
                this.label = 1;
                if (v34.g(o44VarO, aVar, this) == coroutine_suspended) {
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

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ b $listeners;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b bVar) {
            super(1);
            this.$listeners = bVar;
        }

        public final void a(@NotNull View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.$listeners.c(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            a(view);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Unit> {
        public static final f a = new f();

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
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
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
    public static final class h extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Function0 function0, Fragment fragment) {
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
    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment) {
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

    /* compiled from: RouletteHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.RouletteHomeFragment", f = "RouletteHomeFragment.kt", i = {0, 0}, l = {236}, m = "startSearchReal", n = {"this", "view"}, s = {"L$0", "L$1"})
    public static final class j extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RouletteHomeFragment.this.M(null, this);
        }
    }

    public RouletteHomeFragment() {
        super(a.a);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new g(this), new h(null, this), new i(this));
    }

    public final void C(String str) {
        ku1.f("Control Roulette", "control_roulette_start_match_click", "control_roulette_start_match", (40 & 8) != 0 ? null : str, (40 & 16) != 0 ? null : "start match", (40 & 32) != 0 ? null : null);
    }

    public final void D(boolean z) {
        ImageView imageView = t().c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivRouletteRouletteHomeSearch");
        imageView.setVisibility(z ^ true ? 8 : 0);
        LottieAnimationView lottieAnimationView = t().d;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.lottieRouletteHomeSearch");
        lottieAnimationView.setVisibility(z ? 8 : 0);
    }

    public final RouletteViewModel E() {
        return (RouletteViewModel) this.c.getValue();
    }

    public final void F(RouletteBan rouletteBan) {
        if (Intrinsics.areEqual(rouletteBan.getBan(), Boolean.TRUE)) {
            TextView textView = t().g;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvHint");
            textView.setVisibility(8);
            sg3.l(ah4.e(R.string.control_roulette_disabled_toast));
            SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = t().b;
            Intrinsics.checkNotNullExpressionValue(skinRoundAutoLinearLayout, "binding.banContainerView");
            skinRoundAutoLinearLayout.setVisibility(0);
            Long endTime = rouletteBan.getEndTime();
            String strN = ue0.n(endTime != null ? endTime.longValue() : 0L, new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault()));
            TextView textView2 = t().f;
            String strE = ah4.e(R.string.control_roulette_disabled_notify);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.contr…roulette_disabled_notify)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{strN}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            textView2.setText(StringsKt__StringsJVMKt.replace$default(str, "\\n", IOUtils.LINE_SEPARATOR_UNIX, false, 4, (Object) null));
        }
    }

    public final void I() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c(null), 3, null);
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d(null), 3, null);
        E().u();
    }

    public final void J(b bVar) {
        EventBus.getDefault().register(this);
        FrameLayout frameLayout = t().e;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchContainer");
        yu1.b(frameLayout, 0, false, new e(bVar), 3, null);
    }

    public final void K() {
        L();
    }

    public final void L() {
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M(android.view.View r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wear.ui.discover.roulette.RouletteHomeFragment.j
            if (r0 == 0) goto L13
            r0 = r8
            com.wear.ui.discover.roulette.RouletteHomeFragment$j r0 = (com.wear.ui.discover.roulette.RouletteHomeFragment.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.discover.roulette.RouletteHomeFragment$j r0 = new com.wear.ui.discover.roulette.RouletteHomeFragment$j
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$1
            android.view.View r7 = (android.view.View) r7
            java.lang.Object r0 = r0.L$0
            com.wear.ui.discover.roulette.RouletteHomeFragment r0 = (com.wear.ui.discover.roulette.RouletteHomeFragment) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L76
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r8 = r6.E()
            androidx.databinding.ObservableField r8 = r8.q()
            java.lang.Object r8 = r8.get()
            com.wear.bean.RouletteSettingBean r8 = (com.wear.bean.RouletteSettingBean) r8
            if (r8 == 0) goto L55
            boolean r2 = r8.isGenderSet()
            if (r2 != r4) goto L55
            r2 = 1
            goto L56
        L55:
            r2 = 0
        L56:
            if (r2 == 0) goto L9c
            java.lang.String r2 = r8.getGender()
            java.lang.String r5 = "unknown"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)
            if (r2 != 0) goto L9c
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r8 = r6.E()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.m(r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            r0 = r6
        L76:
            androidx.navigation.NavController r8 = androidx.navigation.fragment.FragmentKt.findNavController(r0)
            androidx.navigation.NavDestination r8 = r8.getCurrentDestination()
            if (r8 == 0) goto L8a
            int r8 = r8.getId()
            r1 = 2131364340(0x7f0a09f4, float:1.8348514E38)
            if (r8 != r1) goto L8a
            r3 = 1
        L8a:
            if (r3 == 0) goto Laf
            androidx.navigation.NavController r7 = androidx.navigation.ViewKt.findNavController(r7)
            r8 = 2131361975(0x7f0a00b7, float:1.8343718E38)
            r7.navigate(r8)
            java.lang.String r7 = ""
            r0.C(r7)
            goto Laf
        L9c:
            if (r8 != 0) goto L9f
            goto La3
        L9f:
            r7 = 0
            r8.setGender(r7)
        La3:
            com.wear.ui.discover.roulette.viewmodel.RouletteViewModel r7 = r6.E()
            r7.D(r8)
            java.lang.String r7 = "3"
            r6.C(r7)
        Laf:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.RouletteHomeFragment.M(android.view.View, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull LoginOrOfflineEvent message) {
        Intrinsics.checkNotNullParameter(message, "message");
        L();
        if (message.isLogin()) {
            E().u();
        } else {
            E().k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        uf2 uf2VarV = uf2.v();
        Intrinsics.checkNotNullExpressionValue(uf2VarV, "getInstance()");
        ru1.a(uf2VarV, f.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        t().setLifecycleOwner(this);
        t().e(E().q());
        b bVar = new b();
        t().d(bVar);
        K();
        J(bVar);
        I();
    }
}
