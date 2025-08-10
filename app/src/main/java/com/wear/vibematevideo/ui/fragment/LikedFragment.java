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
import com.wear.bean.vb.VideoBean;
import com.wear.databinding.FragmentLikedBinding;
import com.wear.databinding.ItemInteractivePatternDataBinding;
import com.wear.main.BaseFragment;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.HtmlVideoActivity;
import com.wear.vibematevideo.ui.fragment.LikedFragment;
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

/* compiled from: LikedFragment.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J1\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u001e2\u0010\u00100\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u000101H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020-2\u0006\u00106\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u00106\u001a\u000209H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u00106\u001a\u00020<H\u0002J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u001a\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020\u0013H\u0016J\u0010\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u000204H\u0016J$\u0010D\u001a\u00020-2\u001a\u0010E\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u00010Fj\n\u0012\u0004\u0012\u000209\u0018\u0001`GH\u0002J\b\u0010H\u001a\u00020-H\u0002J\b\u0010I\u001a\u00020-H\u0002J\u0010\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020LH\u0016J$\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020-H\u0016J\b\u0010V\u001a\u00020-H\u0016J\b\u0010W\u001a\u00020-H\u0016J\b\u0010X\u001a\u00020-H\u0016J\u001a\u0010Y\u001a\u00020-2\u0006\u0010Z\u001a\u00020N2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010[\u001a\u00020-H\u0016J\u0018\u0010\\\u001a\u00020-2\u0006\u0010]\u001a\u0002042\u0006\u0010A\u001a\u00020\u0013H\u0016J\u0010\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u00020`H\u0007J\b\u0010a\u001a\u00020-H\u0002J\"\u0010b\u001a\u00020-2\u001a\u0010E\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u00010Fj\n\u0012\u0004\u0012\u000209\u0018\u0001`GJ\u0010\u0010&\u001a\u00020-2\u0006\u0010c\u001a\u00020\u0007H\u0002J$\u0010d\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010\u00072\u0006\u0010A\u001a\u00020\u00132\b\u0010f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010g\u001a\u00020-2\u0006\u0010h\u001a\u00020iH\u0016J,\u0010j\u001a\u00020-2\b\u0010k\u001a\u0004\u0018\u00010\u00072\u0006\u0010l\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u00132\b\u0010f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010m\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020\u0013H\u0016J\b\u0010n\u001a\u00020-H\u0002J\u0012\u0010o\u001a\u00020-2\b\u0010p\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\t¨\u0006q"}, d2 = {"Lcom/wear/vibematevideo/ui/fragment/LikedFragment;", "Lcom/wear/main/BaseFragment;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/wear/network/presenter/base/BaseView;", "Lcom/wear/listenter/IPatternPlayListener;", "()V", "PATTERN", "", "getPATTERN", "()Ljava/lang/String;", "VIDEO", "getVIDEO", "binding", "Lcom/wear/databinding/FragmentLikedBinding;", "getBinding", "()Lcom/wear/databinding/FragmentLikedBinding;", "binding$delegate", "Lkotlin/Lazy;", "curPage", "", "getCurPage", "()I", "setCurPage", "(I)V", "linearLayoutManager", "Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "getLinearLayoutManager", "()Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "linearLayoutManager$delegate", "oldRunPattern", "Lcom/wear/bean/Pattern;", "pageSize", "getPageSize", "recommendedAdapter", "Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "getRecommendedAdapter", "()Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "recommendedAdapter$delegate", "selectTag", "getSelectTag", "setSelectTag", "(Ljava/lang/String;)V", "type", "getType", "addPrepareData", "", "i", "runPattern", "arr", "", "(ILcom/wear/bean/Pattern;[Ljava/lang/String;)V", "checkControl", "", "clickPatternAdItem", "videoBean", "Lcom/wear/bean/vb/VbPatternAdBean;", "clickPatternItem", "Lcom/wear/bean/vb/VbPatternBean;", "clickPatternPlayItem", "clickVideoItem", "Lcom/wear/bean/vb/VideoBean;", "getRunPatternViewHolder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "initPatternListIndex", "pattern", "patternType", "isMulFunction", "isMul", "loadMorePatternData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadPatternCacheData", "loadPatternData", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "onPause", "onResume", "onViewCreated", "view", "playEnd", "playOrPause", "isPause", "refreshData", "event", "Lcom/wear/vibematevideo/event/RefreshVbPatternListEvent;", "refreshDataLayout", "refreshPatternData", "tag", "setBothLinePoint", "splits", "patternStoreTag", "setFirstLinePoint", "curY", "", "showTime", "time", "progress", "startPlay", "stopOldViewHolderPlay", "updatePlayMode", "nowMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class LikedFragment extends BaseFragment<vl2, ul2> implements hv1 {

    @NotNull
    public final String k = "video";

    @NotNull
    public final String l = "pattern";

    @NotNull
    public String m = "pattern";

    @NotNull
    public final Lazy n = LazyKt__LazyJVMKt.lazy(new d());

    @NotNull
    public final Lazy o = LazyKt__LazyJVMKt.lazy(new a());

    @NotNull
    public final Lazy p = LazyKt__LazyJVMKt.lazy(g.a);
    public int q = 1;
    public final int r = 20;

    @Nullable
    public Pattern s;

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/FragmentLikedBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<FragmentLikedBinding> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FragmentLikedBinding invoke() {
            return FragmentLikedBinding.c(LikedFragment.this.getLayoutInflater());
        }
    }

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/ui/fragment/LikedFragment$clickPatternItem$1$waitAction$1$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ LikedFragment b;
        public final /* synthetic */ Ref.ObjectRef<List<Pattern>> c;

        public b(Pattern pattern, LikedFragment likedFragment, Ref.ObjectRef<List<Pattern>> objectRef) {
            this.a = pattern;
            this.b = likedFragment;
            this.c = objectRef;
        }

        public static final void e(Ref.ObjectRef patterns, Pattern pattern) {
            Intrinsics.checkNotNullParameter(patterns, "$patterns");
            Intrinsics.checkNotNullParameter(pattern, "$pattern");
            PatternPlayManagerImpl.O().X((List) patterns.element, 2);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        public static final void f(LikedFragment this$0) {
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
                    final LikedFragment likedFragment = this.b;
                    activity.runOnUiThread(new Runnable() { // from class: dc.bm3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LikedFragment.b.f(likedFragment);
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
                activity2.runOnUiThread(new Runnable() { // from class: dc.cm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LikedFragment.b.e(objectRef, pattern);
                    }
                });
            }
        }
    }

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/ui/fragment/LikedFragment$clickPatternPlayItem$1$waitAction$1$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ LikedFragment b;
        public final /* synthetic */ Ref.ObjectRef<List<Pattern>> c;

        public c(Pattern pattern, LikedFragment likedFragment, Ref.ObjectRef<List<Pattern>> objectRef) {
            this.a = pattern;
            this.b = likedFragment;
            this.c = objectRef;
        }

        public static final void e(Ref.ObjectRef patternList, Pattern pattern) {
            Intrinsics.checkNotNullParameter(patternList, "$patternList");
            Intrinsics.checkNotNullParameter(pattern, "$pattern");
            PatternPlayManagerImpl.O().X((List) patternList.element, 2);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        public static final void f(LikedFragment this$0) {
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
                    final LikedFragment likedFragment = this.b;
                    activity.runOnUiThread(new Runnable() { // from class: dc.dm3
                        @Override // java.lang.Runnable
                        public final void run() {
                            LikedFragment.c.f(likedFragment);
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
                activity2.runOnUiThread(new Runnable() { // from class: dc.em3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LikedFragment.c.e(objectRef, pattern);
                    }
                });
            }
        }
    }

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/widget/RecyclerViewNoBugLinearLayoutManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<RecyclerViewNoBugLinearLayoutManager> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RecyclerViewNoBugLinearLayoutManager invoke() {
            RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(LikedFragment.this.getContext());
            recyclerViewNoBugLinearLayoutManager.setOrientation(1);
            return recyclerViewNoBugLinearLayoutManager;
        }
    }

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/wear/vibematevideo/ui/fragment/LikedFragment$loadPatternCacheData$cachePatternList$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/wear/bean/vb/VbPatternBean;", "Lkotlin/collections/ArrayList;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends TypeToken<ArrayList<VbPatternBean>> {
    }

    /* compiled from: LikedFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/vibematevideo/ui/fragment/LikedFragment$loadPatternData$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements zn2<String> {
        public f() {
        }

        public static final void d(LikedFragment this$0, VbPatternResponse vbPatternResponse) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z = true;
            if (this$0.getQ() != 1) {
                this$0.v0(vbPatternResponse.getData());
                return;
            }
            this$0.M0(vbPatternResponse.getData());
            ArrayList<VbPatternBean> data = vbPatternResponse.getData();
            if (data != null && !data.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
            eg3.i(WearUtils.x, mk3.a.f(), WearUtils.A.toJson(vbPatternResponse.getData()));
        }

        @Override // dc.zn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            String str2 = "onSuccess: " + str;
            try {
                final VbPatternResponse vbPatternResponse = (VbPatternResponse) WearUtils.A.fromJson(str, VbPatternResponse.class);
                final LikedFragment likedFragment = LikedFragment.this;
                se0.f(new Runnable() { // from class: dc.hm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LikedFragment.f.d(likedFragment, vbPatternResponse);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                LikedFragment.this.g0().e.r();
                LikedFragment.this.g0().e.m();
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            if (e != null) {
                e.printStackTrace();
            }
            LikedFragment.this.g0().e.r();
            LikedFragment.this.g0().e.m();
        }
    }

    /* compiled from: LikedFragment.kt */
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
            return new RecommendedAdapter("Liked");
        }
    }

    public static final void A0(LikedFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.chad.library.adapter.base.entity.MultiItemEntity");
        tq tqVar = (tq) item;
        int itemType = tqVar.getItemType();
        if (itemType == 1) {
            this$0.f0((VideoBean) tqVar);
        } else if (itemType == 3) {
            this$0.b0((VbPatternBean) tqVar);
        } else {
            if (itemType != 4) {
                return;
            }
            this$0.a0((VbPatternAdBean) tqVar);
        }
    }

    public static final void C0(LikedFragment this$0, BaseQuickAdapter adapter, View view, int i) {
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
                this$0.d0(vbPatternBean);
            } else {
                ll3.E().e0("Liked", "click", "insert ad", vbPatternBean.getStaticPatternId(), null);
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    mk3.a.B(activity);
                }
            }
        }
    }

    public static final void E0(LikedFragment this$0, ae1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.m, this$0.l)) {
            this$0.q = 1;
            this$0.g0().e.C(false);
            this$0.x0();
        }
    }

    public static final void J0(LikedFragment this$0, ae1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(this$0.m, this$0.l)) {
            this$0.q++;
            this$0.x0();
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.util.ArrayList, java.util.Collection] */
    public static final void c0(LikedFragment this$0, Pattern pattern) {
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
            Collection collectionK = this$0.j0().K();
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
    public static final void e0(LikedFragment this$0, Pattern pattern) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pattern, "$pattern");
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Collection collectionK = this$0.j0().K();
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

    public static final void y0(LikedFragment this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0(this$0.k);
    }

    public static final void z0(LikedFragment this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0(this$0.l);
    }

    @Override // dc.hv1
    public void A3(@Nullable Pattern pattern, int i) {
        k0();
    }

    @Override // dc.hv1
    public void B3(@Nullable String str) {
    }

    @Override // dc.hv1
    public void D2(@Nullable Pattern pattern, int i) {
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
            itemInteractivePatternDataBindingA.g.b();
        }
    }

    public final void K0() {
        if (j0().K().size() == 0) {
            g0().b.setVisibility(0);
        } else {
            g0().b.setVisibility(8);
        }
    }

    public final void M0(@Nullable ArrayList<VbPatternBean> arrayList) {
        g0().e.r();
        j0().K().clear();
        if (arrayList == null || arrayList.size() == 0) {
            g0().e.C(false);
            K0();
            return;
        }
        mk3.a.G(arrayList);
        j0().s(arrayList);
        if (arrayList.size() < this.r) {
            g0().e.C(false);
            if (arrayList.size() > 5) {
                j0().r(new VbPatternAdBean(2));
            }
        } else {
            g0().e.C(true);
        }
        if (j0().K().size() > 5) {
            j0().d1(true);
        }
        K0();
    }

    @Override // dc.hv1
    public void O2(int i, @Nullable Pattern pattern, @Nullable String[] strArr) {
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.a(i, pattern, strArr);
        }
    }

    public final void P0(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Intrinsics.areEqual(this.m, str)) {
            return;
        }
        this.m = str;
        if (Intrinsics.areEqual(str, this.k)) {
            g0().f.setSelected(true);
            g0().c.setSelected(false);
            g0().e.D(false);
            g0().e.C(false);
            j0().y0(mk3.a.i());
            if (j0().K().size() > 5) {
                j0().d1(true);
            }
            K0();
            return;
        }
        if (Intrinsics.areEqual(str, this.l)) {
            g0().f.setSelected(false);
            g0().c.setSelected(true);
            mk3.a.D();
            w0();
            g0().e.D(true);
            g0().e.C(false);
            g0().e.j();
        }
    }

    public final void Q0() {
        BaseViewHolder baseViewHolder;
        if (this.s == null) {
            return;
        }
        for (tq tqVar : j0().K()) {
            if (tqVar instanceof VbPatternBean) {
                Pattern pattern = ((VbPatternBean) tqVar).getPattern();
                String id = pattern != null ? pattern.getId() : null;
                Pattern pattern2 = this.s;
                if (Intrinsics.areEqual(id, pattern2 != null ? pattern2.getId() : null)) {
                    View viewFindViewByPosition = i0().findViewByPosition(j0().K().indexOf(tqVar));
                    if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) g0().d.getChildViewHolder(viewFindViewByPosition)) != null) {
                        j0().W0(baseViewHolder, tqVar);
                        j0().U0(baseViewHolder, tqVar);
                    }
                }
            }
        }
    }

    @Override // dc.hv1
    public void T3(@Nullable String str, int i, @Nullable String str2) {
        Pattern pattern;
        String patternStoreTag;
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            Object tag = baseViewHolderK0.itemView.getTag();
            VbPatternBean vbPatternBean = tag instanceof VbPatternBean ? (VbPatternBean) tag : null;
            if (vbPatternBean == null || (pattern = vbPatternBean.getPattern()) == null || (patternStoreTag = pattern.getPatternStoreTag()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(patternStoreTag, "patternStoreTag");
            if (TextUtils.equals(patternStoreTag, str2)) {
                ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
                Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
                itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
                itemInteractivePatternDataBindingA.g.setBothLinePoint(str);
            }
        }
    }

    @Override // dc.hv1
    public void V1(boolean z, int i) {
        k0();
    }

    public final boolean X() {
        if (!na2.m().i()) {
            return y12.c.a().s(y12.c.TYPE_MEDIA_PATTERN);
        }
        na2.m().t();
        return false;
    }

    @Override // dc.hv1
    public void X3(@Nullable String str, int i, int i2, @Nullable String str2) {
        Pattern pattern;
        String patternStoreTag;
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            Object tag = baseViewHolderK0.itemView.getTag();
            VbPatternBean vbPatternBean = tag instanceof VbPatternBean ? (VbPatternBean) tag : null;
            if (vbPatternBean == null || (pattern = vbPatternBean.getPattern()) == null || (patternStoreTag = pattern.getPatternStoreTag()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(patternStoreTag, "patternStoreTag");
            if (TextUtils.equals(patternStoreTag, str2)) {
                ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
                Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
                itemInteractivePatternDataBindingA.h.setText(str);
            }
        }
    }

    public final void a0(VbPatternAdBean vbPatternAdBean) {
        if (vbPatternAdBean.getAdType() == 2) {
            ll3.E().e0("Liked", "click", "bottom text", null, null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            mk3.a.B(activity);
        }
    }

    public final void b0(VbPatternBean vbPatternBean) {
        ll3.E().e0("Liked", "click", "curve", vbPatternBean.getStaticPatternId(), null);
        final Pattern pattern = vbPatternBean.getPattern();
        if (pattern != null) {
            db2.A().q(new db2.s() { // from class: dc.im3
                @Override // dc.db2.s
                public final void a() {
                    LikedFragment.c0(this.a, pattern);
                }
            });
        }
    }

    public final void d0(VbPatternBean vbPatternBean) {
        ll3.E().e0("Liked", "click", "play", vbPatternBean.getStaticPatternId(), null);
        final Pattern pattern = vbPatternBean.getPattern();
        if (pattern != null) {
            db2.A().q(new db2.s() { // from class: dc.yl3
                @Override // dc.db2.s
                public final void a() {
                    LikedFragment.e0(this.a, pattern);
                }
            });
        }
    }

    public final void f0(VideoBean videoBean) {
        ll3.E().e0("Liked", "click", "video", videoBean.getWebUrl(), null);
        if (X()) {
            Bundle bundle = new Bundle();
            bundle.putString("videoUrl", videoBean.getWebUrl());
            bundle.putString("patternUrl", videoBean.getPatternUrl());
            pj3.m(getContext(), HtmlVideoActivity.class, bundle);
        }
    }

    @NotNull
    public final FragmentLikedBinding g0() {
        return (FragmentLikedBinding) this.o.getValue();
    }

    /* renamed from: h0, reason: from getter */
    public final int getQ() {
        return this.q;
    }

    @NotNull
    public final RecyclerViewNoBugLinearLayoutManager i0() {
        return (RecyclerViewNoBugLinearLayoutManager) this.n.getValue();
    }

    public final RecommendedAdapter j0() {
        return (RecommendedAdapter) this.p.getValue();
    }

    public final BaseViewHolder k0() {
        BaseViewHolder baseViewHolder = null;
        if (Intrinsics.areEqual(this.m, this.k) || PatternPlayManagerImpl.O().T() == null) {
            return null;
        }
        Iterator it = j0().K().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tq tqVar = (tq) it.next();
            if (tqVar instanceof VbPatternBean) {
                Pattern pattern = ((VbPatternBean) tqVar).getPattern();
                if (Intrinsics.areEqual(pattern != null ? pattern.getId() : null, PatternPlayManagerImpl.O().T().getId())) {
                    Pattern pattern2 = this.s;
                    if (!Intrinsics.areEqual(pattern2 != null ? pattern2.getId() : null, PatternPlayManagerImpl.O().T().getId())) {
                        Q0();
                    }
                    this.s = PatternPlayManagerImpl.O().T();
                    View viewFindViewByPosition = i0().findViewByPosition(j0().K().indexOf(tqVar));
                    if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) g0().d.getChildViewHolder(viewFindViewByPosition)) != null) {
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
        SkinCompatConstraintLayout root = g0().getRoot();
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
    public void onResume() {
        super.onResume();
        if (Intrinsics.areEqual(this.m, this.k)) {
            j0().y0(mk3.a.i());
        } else {
            PatternPlayManagerImpl.O().G(this);
        }
        K0();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        P0(this.k);
        g0().f.setOnClickListener(new View.OnClickListener() { // from class: dc.xl3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                LikedFragment.y0(this.a, view2);
            }
        });
        g0().c.setOnClickListener(new View.OnClickListener() { // from class: dc.zl3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                LikedFragment.z0(this.a, view2);
            }
        });
        g0().d.setLayoutManager(i0());
        g0().d.setAdapter(j0());
        j0().E0(new br() { // from class: dc.jm3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                LikedFragment.A0(this.a, baseQuickAdapter, view2, i);
            }
        });
        j0().A0(new zq() { // from class: dc.am3
            @Override // dc.zq
            public final void O1(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                LikedFragment.C0(this.a, baseQuickAdapter, view2, i);
            }
        });
        PatternPlayManagerImpl.O().G(this);
        g0().e.G(new ne1() { // from class: dc.gm3
            @Override // dc.ne1
            public final void b(ae1 ae1Var) {
                LikedFragment.E0(this.a, ae1Var);
            }
        });
        g0().e.F(new le1() { // from class: dc.fm3
            @Override // dc.le1
            public final void f(ae1 ae1Var) {
                LikedFragment.J0(this.a, ae1Var);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void refreshData(@NotNull rk3 event) {
        BaseViewHolder baseViewHolder;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(this.m, this.l)) {
            for (tq tqVar : j0().K()) {
                if (tqVar instanceof VbPatternBean) {
                    VbPatternBean vbPatternBean = (VbPatternBean) tqVar;
                    if (vbPatternBean.getId() == event.getA()) {
                        vbPatternBean.setStaticVideoUserIsLike(event.getB());
                        View viewFindViewByPosition = i0().findViewByPosition(j0().K().indexOf(tqVar));
                        if (viewFindViewByPosition != null && (baseViewHolder = (BaseViewHolder) g0().d.getChildViewHolder(viewFindViewByPosition)) != null) {
                            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolder.itemView);
                            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
                            itemInteractivePatternDataBindingA.c.setImageResource(event.getB() ? R.drawable.patterns_patternlist_favorite_click : R.drawable.patterns_patternlist_favorite);
                        }
                    }
                }
            }
        }
    }

    @Override // dc.hv1
    public void u3(boolean z) {
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.setShowBothLine(z);
        }
    }

    public final void v0(ArrayList<VbPatternBean> arrayList) {
        g0().e.m();
        if (arrayList == null || arrayList.size() == 0) {
            g0().e.C(false);
            j0().r(new VbPatternAdBean(2));
            return;
        }
        mk3.a.G(arrayList);
        j0().s(arrayList);
        if (arrayList.size() >= this.r) {
            g0().e.C(true);
        } else {
            j0().r(new VbPatternAdBean(2));
            g0().e.C(false);
        }
    }

    public final void w0() {
        String strH = eg3.h(WearUtils.x, mk3.a.f(), null);
        if (strH == null || strH.length() == 0) {
            return;
        }
        ArrayList<VbPatternBean> arrayList = (ArrayList) WearUtils.A.fromJson(strH, new e().getType());
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        M0(arrayList);
    }

    public final void x0() {
        HashMap map = new HashMap();
        map.put("pageNo", Integer.valueOf(this.q));
        map.put("pageSize", Integer.valueOf(this.r));
        String strC = tz.a.c();
        Intrinsics.checkNotNull(strC);
        map.put("deviceUkey", strC);
        tn2.x(WearUtils.x).m("/surfease/anon/pattern/static/userlike/listV2", WearUtils.A.toJson(map), new f());
    }

    @Override // dc.hv1
    public void z1() {
        Q0();
    }

    @Override // dc.hv1
    public void z3(float f2) {
        BaseViewHolder baseViewHolderK0 = k0();
        if (baseViewHolderK0 != null) {
            ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolderK0.itemView);
            Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(it.itemView)");
            itemInteractivePatternDataBindingA.g.setFirstLinePoint(f2);
        }
    }
}
