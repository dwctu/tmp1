package com.wear.ui.me.fragment;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.databinding.FragmentOnlineStatusUserBinding;
import com.wear.ui.me.adapter.OnlineStatusUserHeaderAdapter;
import com.wear.ui.me.adapter.OnlineStatusUserSelectAdapter;
import com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom;
import com.wear.ui.me.viewmodel.OnlineStatusViewModel;
import dc.ah4;
import dc.br;
import dc.ku1;
import dc.qe0;
import dc.zq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineStatusUserFragmentBottom.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/wear/ui/me/fragment/OnlineStatusUserFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/FragmentOnlineStatusUserBinding;", "()V", "intersectFriendList", "", "Lcom/wear/bean/me/OnlineStatusUserBean;", "onlineStatusUserHeaderAdapter", "Lcom/wear/ui/me/adapter/OnlineStatusUserHeaderAdapter;", "onlineStatusUserSelectAdapter", "Lcom/wear/ui/me/adapter/OnlineStatusUserSelectAdapter;", "onlineStatusViewModel", "Lcom/wear/ui/me/viewmodel/OnlineStatusViewModel;", "getOnlineStatusViewModel", "()Lcom/wear/ui/me/viewmodel/OnlineStatusViewModel;", "onlineStatusViewModel$delegate", "Lkotlin/Lazy;", "initData", "", "initHeaderRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initListener", "initRecyclerView", "initView", "notifyFriendCount", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineStatusUserFragmentBottom extends BaseBindingBottomDialogFragment<FragmentOnlineStatusUserBinding> {
    public OnlineStatusUserHeaderAdapter c;
    public OnlineStatusUserSelectAdapter d;

    @NotNull
    public final Lazy e;

    @NotNull
    public List<OnlineStatusUserBean> f;

    /* compiled from: OnlineStatusUserFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentOnlineStatusUserBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentOnlineStatusUserBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentOnlineStatusUserBinding;", 0);
        }

        @NotNull
        public final FragmentOnlineStatusUserBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentOnlineStatusUserBinding.c(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentOnlineStatusUserBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
    public static final class b implements TextWatcher {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable r12) {
            /*
                r11 = this;
                com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom r12 = com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom.this
                androidx.viewbinding.ViewBinding r12 = r12.t()
                com.wear.databinding.FragmentOnlineStatusUserBinding r12 = (com.wear.databinding.FragmentOnlineStatusUserBinding) r12
                android.widget.EditText r12 = r12.e
                android.text.Editable r12 = r12.getText()
                java.lang.String r12 = r12.toString()
                java.util.Locale r0 = java.util.Locale.ROOT
                java.lang.String r12 = r12.toLowerCase(r0)
                java.lang.String r0 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
                com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom r1 = com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom.this
                java.util.List r1 = com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom.u(r1)
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r1 = r1.iterator()
            L2c:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L7d
                java.lang.Object r3 = r1.next()
                r4 = r3
                com.wear.bean.me.OnlineStatusUserBean r4 = (com.wear.bean.me.OnlineStatusUserBean) r4
                java.lang.String r5 = r4.getNickname()
                r6 = 0
                r7 = 2
                r8 = 1
                r9 = 0
                if (r5 == 0) goto L56
                java.util.Locale r10 = java.util.Locale.ROOT
                java.lang.String r5 = r5.toLowerCase(r10)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                if (r5 == 0) goto L56
                boolean r5 = kotlin.text.StringsKt__StringsKt.contains$default(r5, r12, r9, r7, r6)
                if (r5 != r8) goto L56
                r5 = 1
                goto L57
            L56:
                r5 = 0
            L57:
                if (r5 != 0) goto L77
                java.lang.String r4 = r4.getRemark()
                if (r4 == 0) goto L72
                java.util.Locale r5 = java.util.Locale.ROOT
                java.lang.String r4 = r4.toLowerCase(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                if (r4 == 0) goto L72
                boolean r4 = kotlin.text.StringsKt__StringsKt.contains$default(r4, r12, r9, r7, r6)
                if (r4 != r8) goto L72
                r4 = 1
                goto L73
            L72:
                r4 = 0
            L73:
                if (r4 == 0) goto L76
                goto L77
            L76:
                r8 = 0
            L77:
                if (r8 == 0) goto L2c
                r2.add(r3)
                goto L2c
            L7d:
                com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom r0 = com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom.this
                androidx.viewbinding.ViewBinding r0 = r0.t()
                com.wear.databinding.FragmentOnlineStatusUserBinding r0 = (com.wear.databinding.FragmentOnlineStatusUserBinding) r0
                androidx.recyclerview.widget.RecyclerView r0 = r0.g
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                java.lang.String r1 = "null cannot be cast to non-null type com.wear.ui.me.adapter.OnlineStatusUserSelectAdapter"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                com.wear.ui.me.adapter.OnlineStatusUserSelectAdapter r0 = (com.wear.ui.me.adapter.OnlineStatusUserSelectAdapter) r0
                r0.J0(r12)
                java.util.List r12 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r2)
                r0.y0(r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom.b.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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
    public static final class d extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0, Fragment fragment) {
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
    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    public OnlineStatusUserFragmentBottom() {
        super(a.a);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnlineStatusViewModel.class), new c(this), new d(null, this), new e(this));
        this.f = new ArrayList();
    }

    public static final void B(OnlineStatusUserFragmentBottom this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter = this$0.c;
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter = null;
        if (onlineStatusUserHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
            onlineStatusUserHeaderAdapter = null;
        }
        OnlineStatusUserBean onlineStatusUserBean = onlineStatusUserHeaderAdapter.K().get(i);
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter2 = this$0.c;
        if (onlineStatusUserHeaderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
            onlineStatusUserHeaderAdapter2 = null;
        }
        onlineStatusUserHeaderAdapter2.q0(i);
        int iIndexOf = this$0.f.indexOf(onlineStatusUserBean);
        if (iIndexOf != -1) {
            this$0.f.get(iIndexOf).setSelected(false);
        }
        this$0.R();
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter2 = this$0.d;
        if (onlineStatusUserSelectAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter2 = null;
        }
        int iIndexOf2 = onlineStatusUserSelectAdapter2.K().indexOf(onlineStatusUserBean);
        if (iIndexOf2 == -1) {
            return;
        }
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter3 = this$0.d;
        if (onlineStatusUserSelectAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter3 = null;
        }
        onlineStatusUserSelectAdapter3.K().get(iIndexOf2).setSelected(false);
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter4 = this$0.d;
        if (onlineStatusUserSelectAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
        } else {
            onlineStatusUserSelectAdapter = onlineStatusUserSelectAdapter4;
        }
        onlineStatusUserSelectAdapter.notifyItemChanged(iIndexOf2);
    }

    public static final void D(OnlineStatusUserFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void E(OnlineStatusUserFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter = this$0.c;
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter2 = null;
        if (onlineStatusUserHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
            onlineStatusUserHeaderAdapter = null;
        }
        List<OnlineStatusUserBean> listK = onlineStatusUserHeaderAdapter.K();
        FragmentActivity activity = this$0.getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.showLoadingProgress();
        }
        this$0.v().m(listK);
        this$0.dismissAllowingStateLoss();
        String str = this$0.v().f() == 0 ? "available" : "invisible";
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter3 = this$0.c;
        if (onlineStatusUserHeaderAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
        } else {
            onlineStatusUserHeaderAdapter2 = onlineStatusUserHeaderAdapter3;
        }
        ku1.f("my status", "status_add_friends_done_click", "status_add_friends_done", (40 & 8) != 0 ? null : Integer.valueOf(onlineStatusUserHeaderAdapter2.getItemCount()), (40 & 16) != 0 ? null : str, (40 & 32) != 0 ? null : null);
    }

    public static final void I(final OnlineStatusUserFragmentBottom this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter = this$0.d;
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter2 = null;
        if (onlineStatusUserSelectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter = null;
        }
        OnlineStatusUserBean onlineStatusUserBean = onlineStatusUserSelectAdapter.K().get(i);
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter3 = this$0.d;
        if (onlineStatusUserSelectAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter3 = null;
        }
        onlineStatusUserBean.setSelected(!onlineStatusUserSelectAdapter3.K().get(i).getIsSelected());
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter4 = this$0.d;
        if (onlineStatusUserSelectAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter4 = null;
        }
        onlineStatusUserSelectAdapter4.notifyItemChanged(i);
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter5 = this$0.d;
        if (onlineStatusUserSelectAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter5 = null;
        }
        if (onlineStatusUserSelectAdapter5.K().get(i).getIsSelected()) {
            OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter = this$0.c;
            if (onlineStatusUserHeaderAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
                onlineStatusUserHeaderAdapter = null;
            }
            OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter6 = this$0.d;
            if (onlineStatusUserSelectAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            } else {
                onlineStatusUserSelectAdapter2 = onlineStatusUserSelectAdapter6;
            }
            onlineStatusUserHeaderAdapter.p(0, onlineStatusUserSelectAdapter2.K().get(i));
            this$0.t().h.post(new Runnable() { // from class: dc.fc3
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusUserFragmentBottom.J(this.a);
                }
            });
        } else {
            OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter2 = this$0.c;
            if (onlineStatusUserHeaderAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
                onlineStatusUserHeaderAdapter2 = null;
            }
            OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter7 = this$0.d;
            if (onlineStatusUserSelectAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            } else {
                onlineStatusUserSelectAdapter2 = onlineStatusUserSelectAdapter7;
            }
            onlineStatusUserHeaderAdapter2.o0(onlineStatusUserSelectAdapter2.K().get(i));
        }
        this$0.R();
    }

    public static final void J(OnlineStatusUserFragmentBottom this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t().h.scrollToPosition(0);
    }

    public final void A(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter = new OnlineStatusUserHeaderAdapter(new ArrayList());
        this.c = onlineStatusUserHeaderAdapter;
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter2 = null;
        if (onlineStatusUserHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
            onlineStatusUserHeaderAdapter = null;
        }
        onlineStatusUserHeaderAdapter.n(R.id.delete_avatar);
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter3 = this.c;
        if (onlineStatusUserHeaderAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
            onlineStatusUserHeaderAdapter3 = null;
        }
        onlineStatusUserHeaderAdapter3.A0(new zq() { // from class: dc.jc3
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OnlineStatusUserFragmentBottom.B(this.a, baseQuickAdapter, view, i);
            }
        });
        OnlineStatusUserHeaderAdapter onlineStatusUserHeaderAdapter4 = this.c;
        if (onlineStatusUserHeaderAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserHeaderAdapter");
        } else {
            onlineStatusUserHeaderAdapter2 = onlineStatusUserHeaderAdapter4;
        }
        recyclerView.setAdapter(onlineStatusUserHeaderAdapter2);
    }

    public final void C() {
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.gc3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusUserFragmentBottom.D(this.a, view);
            }
        });
        t().d.setOnClickListener(new View.OnClickListener() { // from class: dc.hc3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusUserFragmentBottom.E(this.a, view);
            }
        });
        EditText editText = t().e;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.addTextChangedListener(new b());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void F(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter = null;
        DefaultItemAnimator defaultItemAnimator = itemAnimator instanceof DefaultItemAnimator ? (DefaultItemAnimator) itemAnimator : null;
        if (defaultItemAnimator != null) {
            defaultItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        final int iA = qe0.a(16.0f);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.wear.ui.me.fragment.OnlineStatusUserFragmentBottom$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                outRect.bottom = iA;
            }
        });
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter2 = new OnlineStatusUserSelectAdapter(new ArrayList());
        this.d = onlineStatusUserSelectAdapter2;
        if (onlineStatusUserSelectAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
            onlineStatusUserSelectAdapter2 = null;
        }
        onlineStatusUserSelectAdapter2.E0(new br() { // from class: dc.ic3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OnlineStatusUserFragmentBottom.I(this.a, baseQuickAdapter, view, i);
            }
        });
        OnlineStatusUserSelectAdapter onlineStatusUserSelectAdapter3 = this.d;
        if (onlineStatusUserSelectAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlineStatusUserSelectAdapter");
        } else {
            onlineStatusUserSelectAdapter = onlineStatusUserSelectAdapter3;
        }
        recyclerView.setAdapter(onlineStatusUserSelectAdapter);
    }

    public final void K() {
        t().c.setText(ah4.e(v().f() == 2 ? R.string.des_choosing_specific_friend2 : R.string.des_choosing_specific_friend1));
    }

    public final void R() {
        int i;
        List<OnlineStatusUserBean> list = this.f;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((OnlineStatusUserBean) it.next()).getIsSelected() && (i = i + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        RelativeLayout relativeLayout = t().i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.recyclerViewHeaderContainer");
        relativeLayout.setVisibility(i <= 0 ? 8 : 0);
        TextView textView = t().f;
        String strE = ah4.e(R.string.friends_list);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.friends_list)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        textView.setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        K();
        RecyclerView recyclerView = t().h;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerViewHeader");
        A(recyclerView);
        RecyclerView recyclerView2 = t().g;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        F(recyclerView2);
        C();
        y();
    }

    public final OnlineStatusViewModel v() {
        return (OnlineStatusViewModel) this.e.getValue();
    }

    public final void y() {
        List<OnlineStatusUserBean> listJ = v().j();
        RecyclerView.Adapter adapter = t().h.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.me.adapter.OnlineStatusUserHeaderAdapter");
        ((OnlineStatusUserHeaderAdapter) adapter).y0(listJ);
        this.f = v().k();
        RecyclerView.Adapter adapter2 = t().g.getAdapter();
        Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.wear.ui.me.adapter.OnlineStatusUserSelectAdapter");
        ((OnlineStatusUserSelectAdapter) adapter2).y0(this.f);
        R();
    }
}
