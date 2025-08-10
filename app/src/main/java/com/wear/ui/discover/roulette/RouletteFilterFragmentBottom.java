package com.wear.ui.discover.roulette;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.RouletteItemSelectBean;
import com.wear.bean.RouletteSettingBean;
import com.wear.databinding.DialogFragmentRouletteFilterBinding;
import com.wear.databinding.ItemRouletteSelectedBinding;
import com.wear.ui.discover.roulette.RouletteFilterFragmentBottom;
import com.wear.ui.discover.roulette.viewmodel.RouletteViewModel;
import dc.ah4;
import dc.gg3;
import dc.ku1;
import dc.qu1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteFilterFragmentBottom.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0003J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0003J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteFilterFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/DialogFragmentRouletteFilterBinding;", "()V", "rouletteSettingBean", "Lcom/wear/bean/RouletteSettingBean;", "viewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "getViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addFilterLog", "", "generateGenderSelectItemView", "datas", "", "Lcom/wear/bean/RouletteItemSelectBean;", "generatePlaySelectItemView", "", "initGenderRecyclerView", "initListener", "initPlaysRecyclerView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteFilterFragmentBottom extends BaseBindingBottomDialogFragment<DialogFragmentRouletteFilterBinding> {

    @NotNull
    public final Lazy c;

    @Nullable
    public RouletteSettingBean d;

    /* compiled from: RouletteFilterFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogFragmentRouletteFilterBinding> {
        public static final a a = new a();

        public a() {
            super(3, DialogFragmentRouletteFilterBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/DialogFragmentRouletteFilterBinding;", 0);
        }

        @NotNull
        public final DialogFragmentRouletteFilterBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogFragmentRouletteFilterBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogFragmentRouletteFilterBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
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

    public RouletteFilterFragmentBottom() {
        super(a.a);
        this.c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RouletteViewModel.class), new b(this), new c(null, this), new d(this));
    }

    public static final void B(RouletteFilterFragmentBottom this$0, List datas, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(datas, "$datas");
        ItemRouletteSelectedBinding itemRouletteSelectedBinding = (ItemRouletteSelectedBinding) DataBindingUtil.getBinding(view);
        if (itemRouletteSelectedBinding != null) {
            RouletteItemSelectBean rouletteItemSelectBeanB = itemRouletteSelectedBinding.b();
            if (rouletteItemSelectBeanB != null) {
                rouletteItemSelectBeanB.setSelected(!(itemRouletteSelectedBinding.b() != null ? r2.isSelected() : false));
            }
            itemRouletteSelectedBinding.e(itemRouletteSelectedBinding.b());
        }
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : datas) {
            if (((RouletteItemSelectBean) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((RouletteItemSelectBean) it.next()).getService());
        }
        rouletteSettingBean.setPlays((String[]) arrayList2.toArray(new String[0]));
    }

    public static final void F(RouletteFilterFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void I(RouletteFilterFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void J(RouletteFilterFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean != null) {
            this$0.C().D(rouletteSettingBean);
        }
        this$0.u(this$0.d);
        this$0.dismiss();
    }

    public static final void y(List datas, RouletteFilterFragmentBottom this$0, View view) {
        RouletteItemSelectBean rouletteItemSelectBeanB;
        Intrinsics.checkNotNullParameter(datas, "$datas");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ItemRouletteSelectedBinding itemRouletteSelectedBinding = (ItemRouletteSelectedBinding) DataBindingUtil.getBinding(view);
        if ((itemRouletteSelectedBinding == null || (rouletteItemSelectBeanB = itemRouletteSelectedBinding.b()) == null || !rouletteItemSelectBeanB.isSelected()) ? false : true) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : datas) {
                if (((RouletteItemSelectBean) obj).isSelected()) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() <= 1) {
                return;
            }
        }
        if (itemRouletteSelectedBinding != null) {
            RouletteItemSelectBean rouletteItemSelectBeanB2 = itemRouletteSelectedBinding.b();
            if (rouletteItemSelectBeanB2 != null) {
                rouletteItemSelectBeanB2.setSelected(!(itemRouletteSelectedBinding.b() != null ? r3.isSelected() : false));
            }
            itemRouletteSelectedBinding.e(itemRouletteSelectedBinding.b());
        }
        RouletteSettingBean rouletteSettingBean = this$0.d;
        if (rouletteSettingBean == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : datas) {
            if (((RouletteItemSelectBean) obj2).isSelected()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((RouletteItemSelectBean) it.next()).getService());
        }
        rouletteSettingBean.setPreferGender(arrayList3);
    }

    public final void A(final List<RouletteItemSelectBean> list) {
        int iE = (int) ((gg3.e(t().getRoot().getContext()) - qu1.a(80)) / 3);
        float fA = qu1.a(8);
        int size = list.size();
        int i = 0;
        while (i < size) {
            RouletteItemSelectBean rouletteItemSelectBean = list.get(i);
            ItemRouletteSelectedBinding itemRouletteSelectedBindingC = ItemRouletteSelectedBinding.c(getLayoutInflater(), t().d, true);
            Intrinsics.checkNotNullExpressionValue(itemRouletteSelectedBindingC, "inflate(\n               …   true\n                )");
            View root = itemRouletteSelectedBindingC.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "itemBinding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = i == 3 ? -2 : iE;
            root.setLayoutParams(layoutParams);
            int iA = (int) (i == 3 ? qu1.a(12) : 0.0f);
            int i2 = (int) fA;
            itemRouletteSelectedBindingC.getRoot().setPadding(iA, i2, iA, i2);
            itemRouletteSelectedBindingC.e(rouletteItemSelectBean);
            itemRouletteSelectedBindingC.executePendingBindings();
            itemRouletteSelectedBindingC.getRoot().setOnClickListener(new View.OnClickListener() { // from class: dc.zx2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RouletteFilterFragmentBottom.B(this.a, list, view);
                }
            });
            i++;
        }
    }

    public final RouletteViewModel C() {
        return (RouletteViewModel) this.c.getValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void D() {
        List<String> listEmptyList;
        RouletteSettingBean rouletteSettingBean = this.d;
        if (rouletteSettingBean == null || (listEmptyList = rouletteSettingBean.getPreferGender()) == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String strE = ah4.e(R.string.settings_gender_male);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.settings_gender_male)");
        String strE2 = ah4.e(R.string.settings_gender_female);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.settings_gender_female)");
        String strE3 = ah4.e(R.string.settings_gender_non_binary);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.settings_gender_non_binary)");
        v(CollectionsKt__CollectionsKt.mutableListOf(new RouletteItemSelectBean(strE, "male", listEmptyList.contains("male")), new RouletteItemSelectBean(strE2, "female", listEmptyList.contains("female")), new RouletteItemSelectBean(strE3, "non_binary", listEmptyList.contains("non_binary"))));
    }

    public final void E() {
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.vx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFilterFragmentBottom.F(this.a, view);
            }
        });
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.wx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFilterFragmentBottom.I(this.a, view);
            }
        });
        t().e.setOnClickListener(new View.OnClickListener() { // from class: dc.yx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFilterFragmentBottom.J(this.a, view);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void K() {
        RouletteSettingBean rouletteSettingBean = this.d;
        String[] plays = rouletteSettingBean != null ? rouletteSettingBean.getPlays() : null;
        RouletteItemSelectBean[] rouletteItemSelectBeanArr = new RouletteItemSelectBean[4];
        String strE = ah4.e(R.string.filter_sexting);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.filter_sexting)");
        rouletteItemSelectBeanArr[0] = new RouletteItemSelectBean(strE, "sexting", plays != null && ArraysKt___ArraysKt.contains(plays, "sexting"));
        String strE2 = ah4.e(R.string.filter_dirty_talk);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.filter_dirty_talk)");
        rouletteItemSelectBeanArr[1] = new RouletteItemSelectBean(strE2, "dirty_talk", plays != null && ArraysKt___ArraysKt.contains(plays, "dirty_talk"));
        String strE3 = ah4.e(R.string.filter_no_chat);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.filter_no_chat)");
        rouletteItemSelectBeanArr[2] = new RouletteItemSelectBean(strE3, "no_chat", plays != null && ArraysKt___ArraysKt.contains(plays, "no_chat"));
        String strE4 = ah4.e(R.string.filter_voice_messages);
        Intrinsics.checkNotNullExpressionValue(strE4, "getString(R.string.filter_voice_messages)");
        rouletteItemSelectBeanArr[3] = new RouletteItemSelectBean(strE4, "voice_messages", plays != null && ArraysKt___ArraysKt.contains(plays, "voice_messages"));
        A(CollectionsKt__CollectionsKt.mutableListOf(rouletteItemSelectBeanArr));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        this.d = arguments != null ? (RouletteSettingBean) arguments.getParcelable("settingInfo") : null;
        t().d(this.d);
        D();
        K();
        E();
    }

    public final void u(RouletteSettingBean rouletteSettingBean) {
        if (rouletteSettingBean == null) {
            return;
        }
        String[] plays = rouletteSettingBean.getPlays();
        if (plays == null) {
            plays = new String[0];
        }
        ku1.f("Control Roulette", "control_roulette_filter_click", "control_roulette_filter", (40 & 8) != 0 ? null : plays, (40 & 16) != 0 ? null : rouletteSettingBean.getPreferGender(), (40 & 32) != 0 ? null : null);
    }

    public final void v(final List<RouletteItemSelectBean> list) {
        int iE = (int) ((gg3.e(t().getRoot().getContext()) - qu1.a(80)) / 3);
        for (RouletteItemSelectBean rouletteItemSelectBean : list) {
            ItemRouletteSelectedBinding itemRouletteSelectedBindingC = ItemRouletteSelectedBinding.c(getLayoutInflater(), t().c, true);
            Intrinsics.checkNotNullExpressionValue(itemRouletteSelectedBindingC, "inflate(\n               …   true\n                )");
            View root = itemRouletteSelectedBindingC.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "itemBinding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = iE;
            root.setLayoutParams(layoutParams);
            itemRouletteSelectedBindingC.e(rouletteItemSelectBean);
            itemRouletteSelectedBindingC.executePendingBindings();
            itemRouletteSelectedBindingC.getRoot().setOnClickListener(new View.OnClickListener() { // from class: dc.xx2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RouletteFilterFragmentBottom.y(list, this, view);
                }
            });
        }
    }
}
