package com.wear.ui.discover.chatgpt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.bean.data.AskingData;
import com.wear.bean.data.ChatGPTMsgExtKt;
import com.wear.databinding.FragmentChatGptBinding;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.ui.discover.chatgpt.ChatGPTFragment;
import com.wear.ui.discover.chatgpt.adapter.AskingAdapter;
import com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel;
import dc.ah4;
import dc.br;
import dc.ch3;
import dc.eg3;
import dc.is3;
import dc.ye3;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH$J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0004J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001cH$J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/wear/ui/discover/chatgpt/ChatGPTFragment;", "Landroidx/fragment/app/Fragment;", "()V", "askingAdapter", "Lcom/wear/ui/discover/chatgpt/adapter/AskingAdapter;", "binding", "Lcom/wear/databinding/FragmentChatGptBinding;", "getBinding", "()Lcom/wear/databinding/FragmentChatGptBinding;", "setBinding", "(Lcom/wear/databinding/FragmentChatGptBinding;)V", "dialog", "Lcom/wear/widget/dialog/NewCommonDialog;", "", "getDialog", "()Lcom/wear/widget/dialog/NewCommonDialog;", "setDialog", "(Lcom/wear/widget/dialog/NewCommonDialog;)V", "showAskingAbout", "", "viewModel", "Lcom/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel;", "getViewModel", "()Lcom/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getAskingList", "", "Lcom/wear/bean/data/AskingData;", "hideInputLayout", "", "hideKeyBoard", "notifyAskingAdapter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "sendAsking", "askingData", "setEventListener", "showKeyBoard", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ChatGPTFragment extends Fragment {

    @NotNull
    public final Lazy a = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatGPTViewModel.class), new a(this), new b(null, this), new c(this));
    public FragmentChatGptBinding b;
    public AskingAdapter c;

    @Nullable
    public is3<Object> d;
    public boolean e;

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
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
    public static final class b extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0, Fragment fragment) {
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
    public static final class c extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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

    public static final void M(ChatGPTFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = adapter.K().get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.wear.bean.data.AskingData");
        this$0.O((AskingData) obj);
        this$0.v().b.setVisibility(8);
    }

    public static final void V(final ChatGPTFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e = !this$0.e;
        ViewGroup.LayoutParams layoutParams = this$0.v().i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (this$0.e) {
            view.postDelayed(new Runnable() { // from class: dc.sv2
                @Override // java.lang.Runnable
                public final void run() {
                    ChatGPTFragment.W(marginLayoutParams, this$0);
                }
            }, 100L);
            this$0.C();
            marginLayoutParams.bottomMargin = 765;
        } else {
            view.postDelayed(new Runnable() { // from class: dc.nv2
                @Override // java.lang.Runnable
                public final void run() {
                    ChatGPTFragment.X(marginLayoutParams, this$0);
                }
            }, 100L);
            this$0.v().b.setVisibility(8);
            marginLayoutParams.bottomMargin = 765;
        }
        ye3.i(this$0 instanceof PatternChatGPTFragment ? "chatgpt pattern" : "chatgpt story", "default_question_click", "click", "default_question", "button");
    }

    public static final void W(ViewGroup.MarginLayoutParams params, ChatGPTFragment this$0) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        params.bottomMargin = 0;
        this$0.v().c.clearFocus();
        this$0.v().b.setVisibility(0);
    }

    public static final void X(ViewGroup.MarginLayoutParams params, ChatGPTFragment this$0) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        params.bottomMargin = 0;
        this$0.v().c.requestFocus();
        this$0.c0();
    }

    public static final void a0(ChatGPTFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.e && z) {
            ViewGroup.LayoutParams layoutParams = this$0.v().i.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this$0.e = false;
            view.postDelayed(new Runnable() { // from class: dc.ov2
                @Override // java.lang.Runnable
                public final void run() {
                    ChatGPTFragment.b0(marginLayoutParams);
                }
            }, 10L);
            this$0.v().b.setVisibility(8);
            marginLayoutParams.bottomMargin = 765;
            this$0.c0();
        }
    }

    public static final void b0(ViewGroup.MarginLayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "$params");
        params.bottomMargin = 0;
    }

    @NotNull
    public final ChatGPTViewModel A() {
        return (ChatGPTViewModel) this.a.getValue();
    }

    public final void B() {
        C();
        v().b.setVisibility(8);
        this.e = false;
    }

    public final void C() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(v().c.getWindowToken(), 2);
    }

    public final void L() {
        boolean z = true;
        AskingAdapter askingAdapter = null;
        if (this instanceof PatternChatGPTFragment) {
            String strH = eg3.h(requireContext(), ch3.n().o().getRemoteAccountId(), "");
            AskingAdapter askingAdapter2 = this.c;
            if (askingAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
                askingAdapter2 = null;
            }
            AskingData askingData = askingAdapter2.K().get(0);
            if (strH != null && strH.length() != 0) {
                z = false;
            }
            if (z) {
                if (Intrinsics.areEqual(askingData.getId(), "PatternTplMsgId001")) {
                    AskingAdapter askingAdapter3 = this.c;
                    if (askingAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
                    } else {
                        askingAdapter = askingAdapter3;
                    }
                    askingAdapter.q0(0);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(askingData.getId(), "PatternTplMsgId001")) {
                return;
            }
            AskingAdapter askingAdapter4 = this.c;
            if (askingAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
            } else {
                askingAdapter = askingAdapter4;
            }
            String strE = ah4.e(R.string.gpt_another_pattern_item);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.gpt_another_pattern_item)");
            askingAdapter.p(0, new AskingData(strE, "PatternTplMsgId001"));
            return;
        }
        LoginUserBean loginUserBeanO = ch3.n().o();
        Intrinsics.checkNotNullExpressionValue(loginUserBeanO, "getInstance().loginUserBean");
        String strH2 = eg3.h(requireContext(), ChatGPTMsgExtKt.toTopicId(loginUserBeanO), "");
        AskingAdapter askingAdapter5 = this.c;
        if (askingAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
            askingAdapter5 = null;
        }
        AskingData askingData2 = askingAdapter5.K().get(0);
        if (strH2 != null && strH2.length() != 0) {
            z = false;
        }
        if (z) {
            if (Intrinsics.areEqual(askingData2.getId(), "StoryTplMsgId001")) {
                AskingAdapter askingAdapter6 = this.c;
                if (askingAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
                } else {
                    askingAdapter = askingAdapter6;
                }
                askingAdapter.q0(0);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(askingData2.getId(), "StoryTplMsgId001")) {
            return;
        }
        AskingAdapter askingAdapter7 = this.c;
        if (askingAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
        } else {
            askingAdapter = askingAdapter7;
        }
        String strE2 = ah4.e(R.string.gpt_another_story_item);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.gpt_another_story_item)");
        askingAdapter.p(0, new AskingData(strE2, "StoryTplMsgId001"));
    }

    public abstract void O(@NotNull AskingData askingData);

    public final void P(@NotNull FragmentChatGptBinding fragmentChatGptBinding) {
        Intrinsics.checkNotNullParameter(fragmentChatGptBinding, "<set-?>");
        this.b = fragmentChatGptBinding;
    }

    public final void Q(@Nullable is3<Object> is3Var) {
        this.d = is3Var;
    }

    public final void R() {
        v().d.setOnClickListener(new View.OnClickListener() { // from class: dc.pv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatGPTFragment.V(this.a, view);
            }
        });
        v().c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: dc.qv2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ChatGPTFragment.a0(this.a, view, z);
            }
        });
        v().g.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.ui.discover.chatgpt.ChatGPTFragment$setEventListener$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                int scaledTouchSlop = ViewConfiguration.get(this.a.requireContext()).getScaledTouchSlop();
                if (dy >= 0 || scaledTouchSlop + dy <= 0) {
                    return;
                }
                this.a.B();
            }
        });
    }

    public final void c0() {
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(v().c, 1);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentChatGptBinding fragmentChatGptBindingC = FragmentChatGptBinding.c(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentChatGptBindingC, "inflate(inflater, container, false)");
        P(fragmentChatGptBindingC);
        return v().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AskingAdapter askingAdapter = new AskingAdapter(u());
        askingAdapter.E0(new br() { // from class: dc.rv2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                ChatGPTFragment.M(this.a, baseQuickAdapter, view2, i);
            }
        });
        this.c = askingAdapter;
        RecyclerView recyclerView = v().b;
        AskingAdapter askingAdapter2 = this.c;
        if (askingAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("askingAdapter");
            askingAdapter2 = null;
        }
        recyclerView.setAdapter(askingAdapter2);
        v().b.getLayoutParams().height = 765;
        R();
    }

    @NotNull
    public abstract List<AskingData> u();

    @NotNull
    public final FragmentChatGptBinding v() {
        FragmentChatGptBinding fragmentChatGptBinding = this.b;
        if (fragmentChatGptBinding != null) {
            return fragmentChatGptBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final is3<Object> y() {
        return this.d;
    }
}
