package com.wear.vibematevideo.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.vb.VideoAdBean;
import com.wear.bean.vb.VideoBean;
import com.wear.databinding.FragmentRecommendedBinding;
import com.wear.main.BaseFragment;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.HtmlVideoActivity;
import com.wear.vibematevideo.ui.fragment.RecommendedFragment;
import com.wear.vibematevideo.ui.fragment.adapter.RecommendedAdapter;
import dc.br;
import dc.ll3;
import dc.mk3;
import dc.na2;
import dc.pj3;
import dc.tq;
import dc.ul2;
import dc.vl2;
import dc.y12;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.constraint.SkinCompatConstraintLayout;

/* compiled from: RecommendedFragment.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/wear/vibematevideo/ui/fragment/RecommendedFragment;", "Lcom/wear/main/BaseFragment;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/wear/network/presenter/base/BaseView;", "()V", "binding", "Lcom/wear/databinding/FragmentRecommendedBinding;", "getBinding", "()Lcom/wear/databinding/FragmentRecommendedBinding;", "binding$delegate", "Lkotlin/Lazy;", "recommendedAdapter", "Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "getRecommendedAdapter", "()Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "recommendedAdapter$delegate", "checkControl", "", "clickAdItem", "", "videoBean", "Lcom/wear/bean/vb/VideoAdBean;", "clickVideoItem", "Lcom/wear/bean/vb/VideoBean;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "setAdapterData", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RecommendedFragment extends BaseFragment<vl2, ul2> {

    @NotNull
    public final Lazy k = LazyKt__LazyJVMKt.lazy(new a());

    @NotNull
    public final Lazy l = LazyKt__LazyJVMKt.lazy(b.a);

    /* compiled from: RecommendedFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/FragmentRecommendedBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<FragmentRecommendedBinding> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FragmentRecommendedBinding invoke() {
            return FragmentRecommendedBinding.c(RecommendedFragment.this.getLayoutInflater());
        }
    }

    /* compiled from: RecommendedFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<RecommendedAdapter> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RecommendedAdapter invoke() {
            return new RecommendedAdapter("Recommended");
        }
    }

    public static final void e0(RecommendedFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.chad.library.adapter.base.entity.MultiItemEntity");
        tq tqVar = (tq) item;
        int itemType = tqVar.getItemType();
        if (itemType == 1) {
            this$0.a0((VideoBean) tqVar);
        } else {
            if (itemType != 2) {
                return;
            }
            this$0.X((VideoAdBean) tqVar);
        }
    }

    public final boolean W() {
        if (!na2.m().i()) {
            return y12.c.a().s(y12.c.TYPE_MEDIA_PATTERN);
        }
        na2.m().t();
        return false;
    }

    public final void X(VideoAdBean videoAdBean) {
        FragmentActivity activity;
        int adType = videoAdBean.getAdType();
        if (adType == 1) {
            ll3.E().e0("Interactive video", "click", "top text", null, null);
        } else if (adType == 2) {
            ll3.E().e0("Interactive video", "click", "middle text", null, null);
        } else if (adType == 3) {
            ll3.E().e0("Interactive video", "click", "bottom text", null, null);
        }
        if (videoAdBean.getAdType() == 4 || (activity = getActivity()) == null) {
            return;
        }
        mk3.a.B(activity);
    }

    public final void a0(VideoBean videoBean) {
        ll3.E().e0("Interactive video", "click", "video", videoBean.getWebUrl(), null);
        if (W()) {
            Bundle bundle = new Bundle();
            bundle.putString("videoUrl", videoBean.getWebUrl());
            bundle.putString("patternUrl", videoBean.getPatternUrl());
            pj3.m(getContext(), HtmlVideoActivity.class, bundle);
        }
    }

    @NotNull
    public final FragmentRecommendedBinding b0() {
        return (FragmentRecommendedBinding) this.k.getValue();
    }

    public final RecommendedAdapter c0() {
        return (RecommendedAdapter) this.l.getValue();
    }

    public final void f0() {
        String json = WearUtils.A.toJson(c0().K());
        ArrayList<tq> arrayListM = mk3.a.m();
        if (TextUtils.equals(json, WearUtils.A.toJson(arrayListM))) {
            return;
        }
        c0().y0(arrayListM);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        M(WearUtils.x);
        SkinCompatConstraintLayout root = b0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        f0();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        b0().b.setAdapter(c0());
        mk3.a.e();
        c0().E0(new br() { // from class: dc.km3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RecommendedFragment.e0(this.a, baseQuickAdapter, view2, i);
            }
        });
    }
}
