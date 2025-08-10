package com.wear.vibematevideo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.bean.Pattern;
import com.wear.bean.vb.VbPatternAdBean;
import com.wear.bean.vb.VbPatternBean;
import com.wear.bean.vb.VbPatternResponse;
import com.wear.databinding.FragmentVbPatternBinding;
import com.wear.databinding.ItemInteractivePatternDataBinding;
import com.wear.main.BaseFragment;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.fragment.VbPatternFragment;
import com.wear.vibematevideo.ui.fragment.adapter.RecommendedAdapter;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import dc.ae1;
import dc.br;
import dc.db2;
import dc.eg3;
import dc.ff3;
import dc.h12;
import dc.hv1;
import dc.le1;
import dc.ll3;
import dc.mk3;
import dc.na2;
import dc.ne1;
import dc.pj3;
import dc.rf3;
import dc.rk3;
import dc.se0;
import dc.sg3;
import dc.tn2;
import dc.tq;
import dc.tz;
import dc.ue2;
import dc.ul2;
import dc.vl2;
import dc.xe2;
import dc.y12;
import dc.zn2;
import dc.zq;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import skin.support.constraint.SkinCompatConstraintLayout;

/* compiled from: VbPatternFragment.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J1\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00182\u0010\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020!\u0018\u00010)H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020/H\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\u001a\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\u00182\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u00020%J\u0006\u0010:\u001a\u00020%J$\u0010;\u001a\u00020%2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010=j\n\u0012\u0004\u0012\u00020/\u0018\u0001`>H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020AH\u0016J$\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020%H\u0016J\b\u0010K\u001a\u00020%H\u0016J\b\u0010L\u001a\u00020%H\u0016J\b\u0010M\u001a\u00020%H\u0016J\u001a\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020C2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010P\u001a\u00020%H\u0016J\u0018\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u0002082\u0006\u00105\u001a\u00020\rH\u0016J\"\u0010S\u001a\u00020%2\u001a\u0010<\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010=j\n\u0012\u0004\u0012\u00020/\u0018\u0001`>J\u0010\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020VH\u0007J$\u0010W\u001a\u00020%2\b\u0010X\u001a\u0004\u0018\u00010!2\u0006\u00105\u001a\u00020\r2\b\u0010Y\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010Z\u001a\u00020%2\u0006\u0010[\u001a\u00020\\H\u0016J,\u0010]\u001a\u00020%2\b\u0010^\u001a\u0004\u0018\u00010!2\u0006\u0010_\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\b\u0010Y\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010`\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\u00182\u0006\u00105\u001a\u00020\rH\u0016J\b\u0010a\u001a\u00020%H\u0002J\u0012\u0010b\u001a\u00020%2\b\u0010c\u001a\u0004\u0018\u00010!H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\rX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006d"}, d2 = {"Lcom/wear/vibematevideo/ui/fragment/VbPatternFragment;", "Lcom/wear/main/BaseFragment;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/wear/network/presenter/base/BaseView;", "Lcom/wear/listenter/IPatternPlayListener;", "()V", "binding", "Lcom/wear/databinding/FragmentVbPatternBinding;", "getBinding", "()Lcom/wear/databinding/FragmentVbPatternBinding;", "binding$delegate", "Lkotlin/Lazy;", "curPage", "", "getCurPage", "()I", "setCurPage", "(I)V", "linearLayoutManager", "Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "getLinearLayoutManager", "()Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "linearLayoutManager$delegate", "oldRunPattern", "Lcom/wear/bean/Pattern;", "pageSize", "getPageSize", "recommendedAdapter", "Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "getRecommendedAdapter", "()Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "recommendedAdapter$delegate", "type", "", "getType", "()Ljava/lang/String;", "addPrepareData", "", "i", "runPattern", "arr", "", "(ILcom/wear/bean/Pattern;[Ljava/lang/String;)V", "clickPatternAdItem", "videoBean", "Lcom/wear/bean/vb/VbPatternAdBean;", "clickPatternItem", "Lcom/wear/bean/vb/VbPatternBean;", "clickPatternPlayItem", "getRunPatternViewHolder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "initPatternListIndex", "pattern", "patternType", "isMulFunction", "isMul", "", "loadCacheData", "loadData", "loadMoreData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "onPause", "onResume", "onViewCreated", "view", "playEnd", "playOrPause", "isPause", "refreshData", "refreshVbPatternListEvent", "event", "Lcom/wear/vibematevideo/event/RefreshVbPatternListEvent;", "setBothLinePoint", "splits", "patternStoreTag", "setFirstLinePoint", "curY", "", "showTime", "time", "progress", "startPlay", "stopOldViewHolderPlay", "updatePlayMode", "nowMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class VbPatternFragment extends BaseFragment<vl2, ul2> implements hv1 {

    @NotNull
    public final Lazy k = LazyKt__LazyJVMKt.lazy(new a());

    @NotNull
    public final Lazy l = LazyKt__LazyJVMKt.lazy(new d());

    @NotNull
    public final Lazy m = LazyKt__LazyJVMKt.lazy(g.a);
    public int n = 1;
    public final int o = 20;

    @Nullable
    public Pattern p;

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/FragmentVbPatternBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<FragmentVbPatternBinding> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FragmentVbPatternBinding invoke() {
            return FragmentVbPatternBinding.c(VbPatternFragment.this.getLayoutInflater());
        }
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/ui/fragment/VbPatternFragment$clickPatternItem$1$waitAction$1$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ VbPatternFragment b;
        public final /* synthetic */ Ref.ObjectRef<List<Pattern>> c;

        public b(Pattern pattern, VbPatternFragment vbPatternFragment, Ref.ObjectRef<List<Pattern>> objectRef) {
            this.a = pattern;
            this.b = vbPatternFragment;
            this.c = objectRef;
        }

        public static final void e(Ref.ObjectRef patterns, Pattern pattern) {
            Intrinsics.checkNotNullParameter(patterns, "$patterns");
            Intrinsics.checkNotNullParameter(pattern, "$pattern");
            PatternPlayManagerImpl.O().X((List) patterns.element, 2);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        public static final void f(VbPatternFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            PatternPlayManagerImpl.O().U0();
            sg3.i(this$0.getActivity(), R.string.file_notfound);
        }

        @Override // dc.ff3
        public void b(boolean z, @NotNull Object message) throws Throwable {
            Intrinsics.checkNotNullParameter(message, "message");
            if (!z) {
                FragmentActivity activity = this.b.getActivity();
                if (activity != null) {
                    final VbPatternFragment vbPatternFragment = this.b;
                    activity.runOnUiThread(new Runnable() { // from class: dc.om3
                        @Override // java.lang.Runnable
                        public final void run() {
                            VbPatternFragment.b.f(vbPatternFragment);
                        }
                    });
                    return;
                }
                return;
            }
            String strN1 = WearUtils.N1(((File) message).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            FragmentActivity activity2 = this.b.getActivity();
            if (activity2 != null) {
                final Ref.ObjectRef<List<Pattern>> objectRef = this.c;
                final Pattern pattern = this.a;
                activity2.runOnUiThread(new Runnable() { // from class: dc.pm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        VbPatternFragment.b.e(objectRef, pattern);
                    }
                });
            }
        }
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/ui/fragment/VbPatternFragment$clickPatternPlayItem$1$waitAction$1$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ VbPatternFragment b;
        public final /* synthetic */ Ref.ObjectRef<List<Pattern>> c;

        public c(Pattern pattern, VbPatternFragment vbPatternFragment, Ref.ObjectRef<List<Pattern>> objectRef) {
            this.a = pattern;
            this.b = vbPatternFragment;
            this.c = objectRef;
        }

        public static final void e(Ref.ObjectRef patternList, Pattern pattern) {
            Intrinsics.checkNotNullParameter(patternList, "$patternList");
            Intrinsics.checkNotNullParameter(pattern, "$pattern");
            PatternPlayManagerImpl.O().X((List) patternList.element, 2);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        public static final void f(VbPatternFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            PatternPlayManagerImpl.O().U0();
            sg3.i(this$0.getActivity(), R.string.file_notfound);
        }

        @Override // dc.ff3
        public void b(boolean z, @NotNull Object message) throws Throwable {
            Intrinsics.checkNotNullParameter(message, "message");
            if (!z) {
                FragmentActivity activity = this.b.getActivity();
                if (activity != null) {
                    final VbPatternFragment vbPatternFragment = this.b;
                    activity.runOnUiThread(new Runnable() { // from class: dc.rm3
                        @Override // java.lang.Runnable
                        public final void run() {
                            VbPatternFragment.c.f(vbPatternFragment);
                        }
                    });
                    return;
                }
                return;
            }
            String strN1 = WearUtils.N1(((File) message).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            FragmentActivity activity2 = this.b.getActivity();
            if (activity2 != null) {
                final Ref.ObjectRef<List<Pattern>> objectRef = this.c;
                final Pattern pattern = this.a;
                activity2.runOnUiThread(new Runnable() { // from class: dc.qm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        VbPatternFragment.c.e(objectRef, pattern);
                    }
                });
            }
        }
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<RecyclerViewNoBugLinearLayoutManager> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RecyclerViewNoBugLinearLayoutManager invoke() {
            RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(VbPatternFragment.this.getContext());
            recyclerViewNoBugLinearLayoutManager.setOrientation(1);
            return recyclerViewNoBugLinearLayoutManager;
        }
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/wear/vibematevideo/ui/fragment/VbPatternFragment$loadCacheData$cacheVbPatternList$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/wear/bean/vb/VbPatternBean;", "Lkotlin/collections/ArrayList;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends TypeToken<ArrayList<VbPatternBean>> {
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/vibematevideo/ui/fragment/VbPatternFragment$loadData$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements zn2<String> {
        public f() {
        }

        public static final void d(VbPatternFragment this$0, VbPatternResponse vbPatternResponse) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = true;
            if (this$0.getN() != 1) {
                this$0.t0(vbPatternResponse.getData());
                return;
            }
            this$0.y0(vbPatternResponse.getData());
            ArrayList<VbPatternBean> data = vbPatternResponse.getData();
            if (data != null && !data.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
            eg3.i(WearUtils.x, mk3.a.g(), WearUtils.A.toJson(vbPatternResponse.getData()));
        }

        @Override // dc.zn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            String str2 = "onSuccess: " + str;
            try {
                final VbPatternResponse vbPatternResponse = (VbPatternResponse) WearUtils.A.fromJson(str, VbPatternResponse.class);
                final VbPatternFragment vbPatternFragment = VbPatternFragment.this;
                se0.f(new Runnable() { // from class: dc.tm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        VbPatternFragment.f.d(vbPatternFragment, vbPatternResponse);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                VbPatternFragment.this.e0().c.r();
                VbPatternFragment.this.e0().c.m();
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            if (e != null) {
                e.printStackTrace();
            }
            VbPatternFragment.this.e0().c.r();
            VbPatternFragment.this.e0().c.m();
        }
    }

    /* compiled from: VbPatternFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<RecommendedAdapter> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RecommendedAdapter invoke() {
            return new RecommendedAdapter("Syncable patterns");
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.util.ArrayList, java.util.Collection] */
    public static final void b0(VbPatternFragment this$0, Pattern pattern) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pattern, "$pattern");
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            PatternPlayManagerImpl.O().C0();
            PatternPlayManagerImpl.O().G(this$0);
            MusicControl.h0().S();
            String path = pattern.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "pattern.getPath()");
            if (pattern.getData() != null) {
                String data = pattern.getData();
                Intrinsics.checkNotNullExpressionValue(data, "pattern.getData()");
                if (StringsKt__StringsKt.contains$default((CharSequence) data, (CharSequence) "result", false, 2, (Object) null)) {
                    PatternPlayManagerImpl.O().U0();
                    sg3.i(this$0.getActivity(), R.string.file_notfound);
                    return;
                }
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Collection collectionK = this$0.h0().K();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionK) {
                if (obj instanceof VbPatternBean) {
                    arrayList.add(obj);
                }
            }
            ?? arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((VbPatternBean) it.next()).getPattern());
            }
            objectRef.element = arrayList2;
            h12.D.isPlayPatternOnHomePattern = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            if (WearUtils.e1(pattern.getData())) {
                WearUtils.E0(true, path, new b(pattern, this$0, objectRef));
            } else {
                int iF0 = PatternPlayManagerImpl.O().f0(pattern);
                if (iF0 <= 0) {
                    PatternPlayManagerImpl.O().X((List) objectRef.element, 2);
                    PatternPlayManagerImpl.O().G0(pattern);
                } else if (iF0 == 1) {
                    PatternPlayManagerImpl.O().E0();
                    h12.D.isPlayPatternOnHomePattern = false;
                }
            }
            Bundle bundle = new Bundle();
            Pattern patternT = PatternPlayManagerImpl.O().T();
            Iterator it2 = ((List) objectRef.element).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Pattern pattern2 = (Pattern) it2.next();
                if (Intrinsics.areEqual(pattern2 != null ? pattern2.getId() : null, patternT.getId())) {
                    bundle.putSerializable("pattern", pattern2);
                    break;
                }
            }
            if (PatternPlayManagerImpl.O().T() == null || PatternPlayManagerImpl.O().f0(pattern) == 0) {
                bundle.putSerializable("intoType", 1);
            } else {
                bundle.putSerializable("intoType", 1);
                bundle.putSerializable("isFlow", 1);
            }
            bundle.putString("from", "is_from_vibeMate_pattern");
            ue2 ue2VarL0 = xe2.L0();
            Intrinsics.checkNotNull(ue2VarL0, "null cannot be cast to non-null type com.wear.main.patterns.PatternManagerImpl");
            ((xe2) ue2VarL0).J1((List) objectRef.element);
            pj3.g(this$0.getContext(), PatternPlayActivity.class, bundle);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.util.ArrayList, java.util.Collection] */
    public static final void d0(VbPatternFragment this$0, Pattern pattern) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pattern, "$pattern");
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Collection collectionK = this$0.h0().K();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionK) {
                if (obj instanceof VbPatternBean) {
                    arrayList.add(obj);
                }
            }
            ?? arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((VbPatternBean) it.next()).getPattern());
            }
            objectRef.element = arrayList2;
            PatternPlayManagerImpl.O().C0();
            PatternPlayManagerImpl.O().G(this$0);
            MusicControl.h0().S();
            if (PatternPlayManagerImpl.O().f0(pattern) > 0) {
                PatternPlayManagerImpl.O().E0();
                h12.D.isPlayPatternOnHomePattern = false;
                return;
            }
            String path = pattern.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "pattern.getPath()");
            if (pattern.getData() != null) {
                String data = pattern.getData();
                Intrinsics.checkNotNullExpressionValue(data, "pattern.getData()");
                if (StringsKt__StringsKt.contains$default((CharSequence) data, (CharSequence) "result", false, 2, (Object) null)) {
                    PatternPlayManagerImpl.O().U0();
                    sg3.i(this$0.getActivity(), R.string.file_notfound);
                    return;
                }
            }
            h12.D.isPlayPatternOnHomePattern = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            if (WearUtils.e1(pattern.getData())) {
                WearUtils.E0(true, path, new c(pattern, this$0, objectRef));
            } else {
                PatternPlayManagerImpl.O().X((List) objectRef.element, 2);
                PatternPlayManagerImpl.O().G0(pattern);
            }
        }
    }

    public static final void u0(VbPatternFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.chad.library.adapter.base.entity.MultiItemEntity");
        tq tqVar = (tq) item;
        int itemType = tqVar.getItemType();
        if (itemType == 3) {
            this$0.a0((VbPatternBean) tqVar);
        } else {
            if (itemType != 4) {
                return;
            }
            this$0.X((VbPatternAdBean) tqVar);
        }
    }

    public static final void v0(VbPatternFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.chad.library.adapter.base.entity.MultiItemEntity");
        tq tqVar = (tq) item;
        if (tqVar.getItemType() == 3) {
            VbPatternBean vbPatternBean = (VbPatternBean) tqVar;
            int id = view.getId();
            if (id != R.id.pattern_ad_tv) {
                if (id != R.id.pattern_play) {
                    return;
                }
                this$0.c0(vbPatternBean);
            } else {
                ll3.E().e0("Syncable patterns", "click", "insert ad", vbPatternBean.getStaticPatternId(), null);
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    mk3.a.B(activity);
                }
            }
        }
    }

    public static final void w0(VbPatternFragment this$0, ae1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.n = 1;
        this$0.e0().c.C(false);
        this$0.r0();
    }

    public static final void x0(VbPatternFragment this$0, ae1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.n++;
        this$0.r0();
    }

    @Override // dc.hv1
    public void A3(@Nullable Pattern pattern, int i) {
        i0();
    }

    @Override // dc.hv1
    public void B3(@Nullable String str) {
    }

    @Override // dc.hv1
    public void D2(@Nullable Pattern pattern, int i) {
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
            itemInteractivePatternDataBindingA.g.b();
        }
    }

    @Override // dc.hv1
    public void O2(int i, @Nullable Pattern pattern, @Nullable String[] strArr) {
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.a(i, pattern, strArr);
        }
    }

    @Override // dc.hv1
    public void T3(@Nullable String str, int i, @Nullable String str2) {
        Pattern pattern;
        String patternStoreTag;
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            Object tag = baseViewHolderI0.itemView.getTag();
            VbPatternBean vbPatternBean = tag instanceof VbPatternBean ? (VbPatternBean) tag : null;
            if (vbPatternBean == null || (pattern = vbPatternBean.getPattern()) == null || (patternStoreTag = pattern.getPatternStoreTag()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(patternStoreTag, "patternStoreTag");
            if (TextUtils.equals(patternStoreTag, str2)) {
                ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
                Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
                itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
                itemInteractivePatternDataBindingA.g.setBothLinePoint(str);
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        i0();
    }

    public final void X(VbPatternAdBean vbPatternAdBean) {
        if (vbPatternAdBean.getAdType() == 1) {
            ll3.E().e0("Syncable patterns", "click", "top text", null, null);
        }
        if (vbPatternAdBean.getAdType() == 2) {
            ll3.E().e0("Syncable patterns", "click", "bottom text", null, null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            mk3.a.B(activity);
        }
    }

    @Override // dc.hv1
    public void X3(@Nullable String str, int i, int i2, @Nullable String str2) {
        Pattern pattern;
        String patternStoreTag;
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            Object tag = baseViewHolderI0.itemView.getTag();
            VbPatternBean vbPatternBean = tag instanceof VbPatternBean ? (VbPatternBean) tag : null;
            if (vbPatternBean == null || (pattern = vbPatternBean.getPattern()) == null || (patternStoreTag = pattern.getPatternStoreTag()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(patternStoreTag, "patternStoreTag");
            if (TextUtils.equals(patternStoreTag, str2)) {
                ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
                Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
                itemInteractivePatternDataBindingA.h.setText(str);
            }
        }
    }

    public final void a0(VbPatternBean vbPatternBean) {
        ll3.E().e0("Syncable patterns", "click", "curve", vbPatternBean.getStaticPatternId(), null);
        final Pattern pattern = vbPatternBean.getPattern();
        if (pattern != null) {
            db2.A().q(new db2.s() { // from class: dc.vm3
                @Override // dc.db2.s
                public final void a() {
                    VbPatternFragment.b0(this.a, pattern);
                }
            });
        }
    }

    public final void c0(VbPatternBean vbPatternBean) {
        ll3.E().e0("Syncable patterns", "click", "play", vbPatternBean.getStaticPatternId(), null);
        final Pattern pattern = vbPatternBean.getPattern();
        if (pattern != null) {
            db2.A().q(new db2.s() { // from class: dc.nm3
                @Override // dc.db2.s
                public final void a() {
                    VbPatternFragment.d0(this.a, pattern);
                }
            });
        }
    }

    @NotNull
    public final FragmentVbPatternBinding e0() {
        return (FragmentVbPatternBinding) this.k.getValue();
    }

    /* renamed from: f0, reason: from getter */
    public final int getN() {
        return this.n;
    }

    @NotNull
    public final RecyclerViewNoBugLinearLayoutManager g0() {
        return (RecyclerViewNoBugLinearLayoutManager) this.l.getValue();
    }

    public final RecommendedAdapter h0() {
        return (RecommendedAdapter) this.m.getValue();
    }

    public final BaseViewHolder i0() {
        BaseViewHolder baseViewHolder = null;
        if (PatternPlayManagerImpl.O().T() == null) {
            return null;
        }
        Iterator it = h0().K().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tq tqVar = (tq) it.next();
            if (tqVar instanceof VbPatternBean) {
                Pattern pattern = ((VbPatternBean) tqVar).getPattern();
                if (Intrinsics.areEqual(pattern != null ? pattern.getId() : null, PatternPlayManagerImpl.O().T().getId())) {
                    Pattern pattern2 = this.p;
                    if (!Intrinsics.areEqual(pattern2 != null ? pattern2.getId() : null, PatternPlayManagerImpl.O().T().getId())) {
                        z0();
                    }
                    this.p = PatternPlayManagerImpl.O().T();
                    View viewFindViewByPosition = g0().findViewByPosition(h0().K().indexOf(tqVar));
                    if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) e0().b.getChildViewHolder(viewFindViewByPosition)) != null) {
                        ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolder.itemView);
                        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
                        itemInteractivePatternDataBindingA.g.f();
                        if (PatternPlayManagerImpl.O().d0()) {
                            itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_play);
                        } else {
                            itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
                        }
                    }
                }
            }
        }
        return baseViewHolder;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        M(WearUtils.x);
        SkinCompatConstraintLayout root = e0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PatternPlayManagerImpl.O().N0(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PatternPlayManagerImpl.O().N0(this);
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        mk3.a.D();
        PatternPlayManagerImpl.O().G(this);
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        e0().b.setLayoutManager(g0());
        e0().b.setAdapter(h0());
        h0().E0(new br() { // from class: dc.um3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                VbPatternFragment.u0(this.a, baseQuickAdapter, view2, i);
            }
        });
        h0().A0(new zq() { // from class: dc.mm3
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                VbPatternFragment.v0(this.a, baseQuickAdapter, view2, i);
            }
        });
        PatternPlayManagerImpl.O().G(this);
        e0().c.G(new ne1() { // from class: dc.lm3
            @Override // dc.ne1
            public final void b(ae1 ae1Var) {
                VbPatternFragment.w0(this.a, ae1Var);
            }
        });
        e0().c.F(new le1() { // from class: dc.sm3
            @Override // dc.le1
            public final void f(ae1 ae1Var) {
                VbPatternFragment.x0(this.a, ae1Var);
            }
        });
        q0();
        ll3.E().e0("Syncable patterns", "open", null, null, null);
        e0().c.j();
    }

    public final void q0() {
        String strH = eg3.h(WearUtils.x, mk3.a.g(), null);
        if (strH == null || strH.length() == 0) {
            return;
        }
        ArrayList<VbPatternBean> arrayList = (ArrayList) WearUtils.A.fromJson(strH, new e().getType());
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        y0(arrayList);
    }

    public final void r0() {
        HashMap map = new HashMap();
        map.put("pageNo", Integer.valueOf(this.n));
        map.put("pageSize", Integer.valueOf(this.o));
        String strC = tz.a.c();
        Intrinsics.checkNotNull(strC);
        map.put("deviceUkey", strC);
        tn2.x(WearUtils.x).m("/surfease/anon/pattern/static/listV2", WearUtils.A.toJson(map), new f());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void refreshVbPatternListEvent(@NotNull rk3 event) {
        BaseViewHolder baseViewHolder;
        Intrinsics.checkNotNullParameter(event, "event");
        for (tq tqVar : h0().K()) {
            if (tqVar instanceof VbPatternBean) {
                VbPatternBean vbPatternBean = (VbPatternBean) tqVar;
                if (vbPatternBean.getId() == event.getA()) {
                    vbPatternBean.setStaticVideoUserIsLike(event.getB());
                    View viewFindViewByPosition = g0().findViewByPosition(h0().K().indexOf(tqVar));
                    if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) e0().b.getChildViewHolder(viewFindViewByPosition)) != null) {
                        ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolder.itemView);
                        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
                        itemInteractivePatternDataBindingA.c.setImageResource(event.getB() ? R.drawable.patterns_patternlist_favorite_click : R.drawable.patterns_patternlist_favorite);
                    }
                }
            }
        }
    }

    public final void t0(ArrayList<VbPatternBean> arrayList) {
        e0().c.m();
        if (arrayList == null || arrayList.size() == 0) {
            e0().c.C(false);
            h0().r(new VbPatternAdBean(2));
            return;
        }
        mk3.a.G(arrayList);
        h0().s(arrayList);
        if (arrayList.size() >= this.o) {
            e0().c.C(true);
        } else {
            h0().r(new VbPatternAdBean(2));
            e0().c.C(false);
        }
    }

    @Override // dc.hv1
    public void u3(boolean z) {
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.setShowBothLine(z);
        }
    }

    public final void y0(@Nullable ArrayList<VbPatternBean> arrayList) {
        e0().c.r();
        h0().K().clear();
        if (arrayList == null || arrayList.size() == 0) {
            e0().c.C(false);
            h0().r(new VbPatternAdBean(1));
            return;
        }
        mk3.a.G(arrayList);
        h0().r(new VbPatternAdBean(1));
        h0().s(arrayList);
        if (arrayList.size() >= this.o) {
            e0().c.C(true);
        } else {
            h0().r(new VbPatternAdBean(2));
            e0().c.C(false);
        }
    }

    public final void z0() {
        BaseViewHolder baseViewHolder;
        if (this.p == null) {
            return;
        }
        for (tq tqVar : h0().K()) {
            if (tqVar instanceof VbPatternBean) {
                Pattern pattern = ((VbPatternBean) tqVar).getPattern();
                String id = pattern != null ? pattern.getId() : null;
                Pattern pattern2 = this.p;
                if (Intrinsics.areEqual(id, pattern2 != null ? pattern2.getId() : null)) {
                    View viewFindViewByPosition = g0().findViewByPosition(h0().K().indexOf(tqVar));
                    if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) e0().b.getChildViewHolder(viewFindViewByPosition)) != null) {
                        h0().W0(baseViewHolder, tqVar);
                        h0().U0(baseViewHolder, tqVar);
                    }
                }
            }
        }
    }

    @Override // dc.hv1
    public void z1() {
        z0();
    }

    @Override // dc.hv1
    public void z3(float f2) {
        BaseViewHolder baseViewHolderI0 = i0();
        if (baseViewHolderI0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderI0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.setFirstLinePoint(f2);
        }
    }
}
