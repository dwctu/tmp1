package com.wear.ui.discover.roulette;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.lovense.wear.R;
import com.wear.BaseBindingDialogFragment;
import com.wear.bean.FindMatchUserBean;
import com.wear.bean.UserAcceptBean;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.UserRejectBean;
import com.wear.databinding.FragmentRouletteMatchSuccessBinding;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.discover.roulette.RouletteMatchSuccessFragment;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import com.wear.ui.discover.roulette.widget.RouletteToyAndPlaysView;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;
import dc.eg3;
import dc.ku1;
import java.lang.reflect.InvocationTargetException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteMatchSuccessFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001dH\u0007J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteMatchSuccessFragment;", "Lcom/wear/BaseBindingDialogFragment;", "Lcom/wear/databinding/FragmentRouletteMatchSuccessBinding;", "Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$OnCountdownEndListener;", "()V", "countTime", "", "findMatchUserBean", "Lcom/wear/bean/FindMatchUserBean;", "viewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addMatchingSuccessLog", "", "elementContent", "", "initListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "onEventMsg", "event", "Lcom/wear/bean/UserAcceptBean;", "Lcom/wear/bean/UserJoinChatBean;", "Lcom/wear/bean/UserRejectBean;", "onProgress", "onViewCreated", "view", "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteMatchSuccessFragment extends BaseBindingDialogFragment<FragmentRouletteMatchSuccessBinding> implements RoundProgressBar.a {

    @NotNull
    public final Lazy c;

    @Nullable
    public FindMatchUserBean d;
    public int e;

    /* compiled from: RouletteMatchSuccessFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRouletteMatchSuccessBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentRouletteMatchSuccessBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentRouletteMatchSuccessBinding;", 0);
        }

        @NotNull
        public final FragmentRouletteMatchSuccessBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRouletteMatchSuccessBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRouletteMatchSuccessBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
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
    public static final class c extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function0 function0, Fragment fragment) {
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
    public static final class d extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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

    public RouletteMatchSuccessFragment() {
        super(a.a);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new b(this), new c(null, this), new d(this));
        this.e = -1;
    }

    public static final void A(RouletteMatchSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v().v();
        this$0.dismissAllowingStateLoss();
        this$0.u("rematch");
    }

    public static final void B(RouletteMatchSuccessFragment this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eg3.j(view.getContext(), "isInRouletteRoom", true);
        this$0.v().a();
        this$0.t().e(Boolean.TRUE);
        this$0.u("accept");
    }

    public static final void C(RouletteMatchSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v().j();
        this$0.dismissAllowingStateLoss();
        this$0.u("cancel");
    }

    public final void D() {
        Bundle arguments = getArguments();
        this.d = arguments != null ? (FindMatchUserBean) arguments.getParcelable("findMatchUserBean") : null;
        t().d(this.d);
        RoundProgressBar roundProgressBar = t().g;
        int i = this.e;
        if (i == -1) {
            roundProgressBar.setTimeMillis(16);
        } else {
            roundProgressBar.setTimeMillis(i);
        }
        roundProgressBar.setCountdownProgressListener(this);
        roundProgressBar.g();
        RouletteToyAndPlaysView rouletteToyAndPlaysView = t().i;
        FindMatchUserBean findMatchUserBean = this.d;
        if (findMatchUserBean == null) {
            return;
        }
        rouletteToyAndPlaysView.setFindMatchUserBean(findMatchUserBean);
    }

    @Override // com.wear.ui.discover.roulette.widget.RoundProgressBar.a
    public void a(int i) {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        this.e = i;
    }

    @Override // com.wear.ui.discover.roulette.widget.RoundProgressBar.a
    public void e() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        dismissAllowingStateLoss();
        v().B();
        u("timeout");
    }

    @Override // androidx.fragment.app.FixDialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Window window;
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setStyle(0, R.style.Dialog_Fragment_Fullscreen);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@NotNull UserRejectBean event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getTag();
        v().G();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        D();
        y();
    }

    public final void u(String str) {
        ku1.f("Control Roulette", "control_roulette_match_selection_click", "control_roulette_match_selection", (40 & 8) != 0 ? null : str, (40 & 16) != 0 ? null : null, (40 & 32) != 0 ? null : null);
    }

    public final RouletteViewModel v() {
        return (RouletteViewModel) this.c.getValue();
    }

    public final void y() {
        t().c.setOnClickListener(new View.OnClickListener() { // from class: dc.cy2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteMatchSuccessFragment.A(this.a, view);
            }
        });
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.by2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                RouletteMatchSuccessFragment.B(this.a, view);
            }
        });
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.ay2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteMatchSuccessFragment.C(this.a, view);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@NotNull UserAcceptBean event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getTag();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@NotNull UserJoinChatBean event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getTag();
        dismissAllowingStateLoss();
        event.setFromOuter(false);
        if (event.getUserAccountCode() != null) {
            NewChatActivity.a aVar = NewChatActivity.n;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            NewChatActivity.a.b(aVar, contextRequireContext, event, false, true, 4, null);
        }
        requireActivity().finish();
        String strN = v().getJ();
        if (strN != null) {
            ku1.d("control roulette chatroom", "control_roulette_chat_page_enter", strN);
        }
    }
}
