package com.wear.ui.discover.roulette;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.RouletteItemSelectBean;
import com.wear.bean.RouletteSettingBean;
import com.wear.databinding.DialogFragmentRouletteSettingsBinding;
import com.wear.ui.discover.roulette.RouletteSettingsFragmentBottom;
import com.wear.ui.discover.roulette.adapter.GridSpaceItemDecoration;
import com.wear.ui.discover.roulette.adapter.RouletteSelectedAdapter;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import dc.br;
import dc.ku1;
import dc.qe0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteSettingsFragmentBottom.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0003J\b\u0010\u000f\u001a\u00020\rH\u0002J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteSettingsFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/DialogFragmentRouletteSettingsBinding;", "()V", "rouletteSettingBean", "Lcom/wear/bean/RouletteSettingBean;", "viewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addSettingLog", "", "initGenderRecyclerView", "initListener", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteSettingsFragmentBottom extends BaseBindingBottomDialogFragment<DialogFragmentRouletteSettingsBinding> {

    @NotNull
    public final Lazy c;

    @Nullable
    public RouletteSettingBean d;

    /* compiled from: RouletteSettingsFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogFragmentRouletteSettingsBinding> {
        public static final a a = new a();

        public a() {
            super(3, DialogFragmentRouletteSettingsBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/DialogFragmentRouletteSettingsBinding;", 0);
        }

        @NotNull
        public final DialogFragmentRouletteSettingsBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogFragmentRouletteSettingsBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogFragmentRouletteSettingsBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
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

    public RouletteSettingsFragmentBottom() {
        super(a.a);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new b(this), new c(null, this), new d(this));
    }

    public static final void A(RouletteSettingsFragmentBottom this$0, List datas, RouletteSelectedAdapter genderAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(datas, "$datas");
        Intrinsics.checkNotNullParameter(genderAdapter, "$genderAdapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean != null) {
            rouletteSettingBean.setGender(((RouletteItemSelectBean) datas.get(i)).getService());
        }
        int i2 = 0;
        for (Object obj : datas) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((RouletteItemSelectBean) obj).setSelected(i2 == i);
            i2 = i3;
        }
        genderAdapter.notifyDataSetChanged();
    }

    public static final void C(RouletteSettingsFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void D(RouletteSettingsFragmentBottom this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean == null) {
            return;
        }
        rouletteSettingBean.setSendFriendRequest(Boolean.valueOf(z));
    }

    public static final void E(RouletteSettingsFragmentBottom this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean == null) {
            return;
        }
        rouletteSettingBean.setReceiveFriendRequest(Boolean.valueOf(z));
    }

    public static final void F(RouletteSettingsFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean != null) {
            this$0.v().D(rouletteSettingBean);
        }
        this$0.u(this$0.d);
        this$0.dismiss();
    }

    public final void B() {
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.ey2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteSettingsFragmentBottom.C(this.a, view);
            }
        });
        t().d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.fy2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RouletteSettingsFragmentBottom.D(this.a, compoundButton, z);
            }
        });
        t().c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.dy2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RouletteSettingsFragmentBottom.E(this.a, compoundButton, z);
            }
        });
        t().e.setOnClickListener(new View.OnClickListener() { // from class: dc.hy2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteSettingsFragmentBottom.F(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.d = arguments != null ? (RouletteSettingBean) arguments.getParcelable("settingInfo") : null;
        t().d(this.d);
        y();
        B();
    }

    public final void u(RouletteSettingBean rouletteSettingBean) {
        if (rouletteSettingBean == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("about me-");
        String intro = rouletteSettingBean.getIntro();
        sb.append(((intro == null || intro.length() == 0) ? 1 : 0) ^ 1);
        arrayList.add(sb.toString());
        String gender = rouletteSettingBean.getGender();
        if (gender == null) {
            gender = "";
        }
        ku1.f("Control Roulette", "control_roulette_settings_click", "control_roulette_settings", (40 & 8) != 0 ? null : arrayList, (40 & 16) != 0 ? null : gender, (40 & 32) != 0 ? null : null);
    }

    public final RouletteViewModel v() {
        return (RouletteViewModel) this.c.getValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void y() {
        t().b.addItemDecoration(new GridSpaceItemDecoration(3, qe0.a(16.0f), false));
        t().b.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        RouletteSettingBean rouletteSettingBean = this.d;
        String gender = rouletteSettingBean != null ? rouletteSettingBean.getGender() : null;
        String string = getString(R.string.settings_gender_male);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.settings_gender_male)");
        String string2 = getString(R.string.settings_gender_female);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.settings_gender_female)");
        String string3 = getString(R.string.settings_gender_non_binary);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.settings_gender_non_binary)");
        final List listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new RouletteItemSelectBean(string, "male", Intrinsics.areEqual("male", gender)), new RouletteItemSelectBean(string2, "female", Intrinsics.areEqual("female", gender)), new RouletteItemSelectBean(string3, "non_binary", Intrinsics.areEqual("non_binary", gender)));
        final RouletteSelectedAdapter rouletteSelectedAdapter = new RouletteSelectedAdapter(R.layout.item_roulette_selected, listMutableListOf);
        t().b.setAdapter(rouletteSelectedAdapter);
        rouletteSelectedAdapter.E0(new br() { // from class: dc.gy2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RouletteSettingsFragmentBottom.A(this.a, listMutableListOf, rouletteSelectedAdapter, baseQuickAdapter, view, i);
            }
        });
    }
}
