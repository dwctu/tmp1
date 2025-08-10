package com.wear.ui.discover.gaming;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.load.engine.GlideException;
import com.epicgames.unreal.SplashActivity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.BaseActivity;
import com.wear.adapter.game.NewGamingDetailsAdAdapter;
import com.wear.adapter.game.NewGamingDetailsAdFullScreenAdapter;
import com.wear.bean.NewGalleryList;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.discover.gaming.NewGamingDetailsActivity;
import com.wear.ui.discover.gaming.adapter.ApiListAdapter;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.cp;
import dc.cs3;
import dc.h32;
import dc.ij3;
import dc.is3;
import dc.kf;
import dc.kg3;
import dc.pj3;
import dc.po;
import dc.qf3;
import dc.qo;
import dc.sg;
import dc.t23;
import dc.vl2;
import dc.y12;
import dc.ye3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewGamingDetailsActivity.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010s\u001a\u00020qJ\b\u0010t\u001a\u00020qH\u0002J\b\u0010u\u001a\u00020qH\u0002J\u0006\u0010v\u001a\u00020qJ(\u0010w\u001a\u00020q2\u0006\u0010x\u001a\u0002072\b\u0010y\u001a\u0004\u0018\u00010$2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020q0{H\u0002J#\u0010|\u001a\u00020q2\u0006\u0010}\u001a\u00020]2\u0006\u0010~\u001a\u00020]2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0014J\t\u0010\u0081\u0001\u001a\u00020qH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020q2\u0007\u0010\u0083\u0001\u001a\u00020IH\u0007J\u0015\u0010\u0084\u0001\u001a\u00020q2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0014J\t\u0010\u0087\u0001\u001a\u00020qH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020q2\u0007\u0010\u0089\u0001\u001a\u00020\u0019H\u0002J\u0010\u0010\u008a\u0001\u001a\u00020q2\u0007\u0010\u008b\u0001\u001a\u00020]J\u0012\u0010\u008c\u0001\u001a\u00020q2\u0007\u0010\u008d\u0001\u001a\u00020]H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001e\u0010?\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R\u001e\u0010B\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010O\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010V\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010\u001fR\u001e\u0010Y\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010K\"\u0004\b[\u0010MR\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010^\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b`\u0010aR\u001e\u0010d\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010K\"\u0004\bf\u0010MR\u001e\u0010g\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000b\"\u0004\bi\u0010\rR\u001e\u0010j\u001a\u00020k8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006\u008e\u0001"}, d2 = {"Lcom/wear/ui/discover/gaming/NewGamingDetailsActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "adapter", "Lcom/wear/adapter/game/NewGamingDetailsAdAdapter;", "apiListAdapter", "Lcom/wear/ui/discover/gaming/adapter/ApiListAdapter;", "apiRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getApiRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setApiRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clTopBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClTopBar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setClTopBar", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "endTime", "", "fullAdapter", "Lcom/wear/adapter/game/NewGamingDetailsAdFullScreenAdapter;", "galleryDetails", "Lcom/wear/bean/NewGalleryList;", "gameDescription", "Landroid/widget/TextView;", "getGameDescription", "()Landroid/widget/TextView;", "setGameDescription", "(Landroid/widget/TextView;)V", "gameDetails", "getGameDetails", "setGameDetails", "gameId", "", "gameName", "getGameName", "setGameName", "guideline", "Landroidx/constraintlayout/widget/Guideline;", "getGuideline", "()Landroidx/constraintlayout/widget/Guideline;", "setGuideline", "(Landroidx/constraintlayout/widget/Guideline;)V", "imgList", "", "getImgList", "()Ljava/util/List;", "setImgList", "(Ljava/util/List;)V", "isCreateGameModeFlag", "", "ivAdBanner", "Landroid/widget/ImageView;", "getIvAdBanner", "()Landroid/widget/ImageView;", "setIvAdBanner", "(Landroid/widget/ImageView;)V", "ivIcon", "getIvIcon", "setIvIcon", "ivTopIcon", "getIvTopIcon", "setIvTopIcon", "llGamingDetails", "Landroid/widget/LinearLayout;", "getLlGamingDetails", "()Landroid/widget/LinearLayout;", "setLlGamingDetails", "(Landroid/widget/LinearLayout;)V", "placeholder", "Landroid/view/View;", "getPlaceholder", "()Landroid/view/View;", "setPlaceholder", "(Landroid/view/View;)V", "previewImgOrientation", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "startTime", "tvAuthor", "getTvAuthor", "setTvAuthor", "viewLine", "getViewLine", "setViewLine", "viewLineY", "", "viewModel", "Lcom/wear/ui/discover/gaming/GamingViewModel;", "getViewModel", "()Lcom/wear/ui/discover/gaming/GamingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewTopBarDivider", "getViewTopBarDivider", "setViewTopBarDivider", "vpGamingDetails", "getVpGamingDetails", "setVpGamingDetails", "vpGamingDetailsFullScreen", "Landroidx/viewpager2/widget/ViewPager2;", "getVpGamingDetailsFullScreen", "()Landroidx/viewpager2/widget/ViewPager2;", "setVpGamingDetailsFullScreen", "(Landroidx/viewpager2/widget/ViewPager2;)V", "closeProcess", "", "namePro", "dismissFullScreenAd", "endControl", "initData", "initView", "loadImageWithCallback", "imageView", "imageUrl", Callback.METHOD_NAME, "Lkotlin/Function0;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "view", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "settingBarColor", "showDeatls", "it", "showFullScreenAd", "position", "showLoginDialog", "resId", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewGamingDetailsActivity extends BaseActivity<vl2> {
    public int a;

    @BindView(R.id.recyclerView)
    public RecyclerView apiRecyclerView;
    public long b;
    public long c;

    @BindView(R.id.cl_top_bar)
    public ConstraintLayout clTopBar;
    public NewGamingDetailsAdFullScreenAdapter f;
    public NewGamingDetailsAdAdapter g;

    @BindView(R.id.tv_gaming_description)
    public TextView gameDescription;

    @BindView(R.id.tv_gaming_details)
    public TextView gameDetails;

    @BindView(R.id.tv_gaming_name)
    public TextView gameName;

    @BindView(R.id.guideline)
    public Guideline guideline;

    @Nullable
    public NewGalleryList h;
    public ApiListAdapter i;

    @BindView(R.id.iv_ad_banner)
    public ImageView ivAdBanner;

    @BindView(R.id.iv_icon_gaming)
    public ImageView ivIcon;

    @BindView(R.id.iv_top_icon)
    public ImageView ivTopIcon;
    public boolean l;

    @BindView(R.id.ll_gaming_details)
    public LinearLayout llGamingDetails;

    @BindView(R.id.placeholder)
    public View placeholder;

    @BindView(R.id.scroll_view)
    public ScrollView scrollView;

    @BindView(R.id.tv_author)
    public TextView tvAuthor;

    @BindView(R.id.view_line)
    public View viewLine;

    @BindView(R.id.view_top_bar_divider)
    public View viewTopBarDivider;

    @BindView(R.id.vp_gaming_details)
    public RecyclerView vpGamingDetails;

    @BindView(R.id.vp_gaming_details_full_screen)
    public ViewPager2 vpGamingDetailsFullScreen;

    @NotNull
    public final Lazy d = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GamingViewModel.class), new f(this), new e(this), new g(null, this));

    @Nullable
    public List<String> e = new ArrayList();

    @NotNull
    public String j = "";

    @NotNull
    public String k = "dcc4b002111b412c975028851e07ed30";

    /* compiled from: NewGamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/wear/ui/discover/gaming/NewGamingDetailsActivity$loadImageWithCallback$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements po<Drawable> {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // dc.po
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean d(@Nullable Drawable drawable, @Nullable Object obj, @Nullable cp<Drawable> cpVar, @Nullable sg sgVar, boolean z) {
            this.a.invoke();
            return false;
        }

        @Override // dc.po
        public boolean c(@Nullable GlideException glideException, @Nullable Object obj, @Nullable cp<Drawable> cpVar, boolean z) {
            return false;
        }
    }

    /* compiled from: NewGamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NewGalleryList $it;

        /* compiled from: NewGamingDetailsActivity.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ NewGamingDetailsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(NewGamingDetailsActivity newGamingDetailsActivity) {
                super(0);
                this.this$0 = newGamingDetailsActivity;
            }

            public static final void a(NewGamingDetailsActivity this$0, int i, View view, int i2, int i3, int i4, int i5) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.y4().setAlpha(i3 / ((float) ((this$0.D4().getHeight() * 0.94d) - i)));
                this$0.F4().setVisibility(this$0.y4().getAlpha() > 0.95f ? 0 : 4);
                int[] iArr = new int[2];
                this$0.K4().getLocationOnScreen(iArr);
                this$0.M4().setVisibility(this$0.y4().getHeight() < iArr[1] + this$0.K4().getHeight() ? 4 : 0);
            }

            public static final void b(NewGamingDetailsActivity this$0, int i) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.D4().getLayoutParams().height = (int) ((this$0.I4().getWidth() / this$0.D4().getWidth()) * this$0.D4().getHeight());
                this$0.D4().getLayoutParams().width = this$0.I4().getWidth();
                if (this$0.G4().getHeight() + this$0.y4().getHeight() + i < this$0.I4().getHeight()) {
                    this$0.H4().getLayoutParams().height = this$0.I4().getHeight() - ((this$0.G4().getHeight() + this$0.y4().getHeight()) + i);
                }
                this$0.C4().setGuidelineBegin((int) (this$0.D4().getLayoutParams().height * 0.94d));
                this$0.y4().setPadding(0, this$0.y4().getPaddingTop() + i, 0, this$0.y4().getPaddingBottom());
                int[] iArr = new int[2];
                this$0.K4().getLocationOnScreen(iArr);
                this$0.a = iArr[1];
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final int iA = kg3.a(this.this$0);
                if (Build.VERSION.SDK_INT >= 23) {
                    ScrollView scrollViewI4 = this.this$0.I4();
                    final NewGamingDetailsActivity newGamingDetailsActivity = this.this$0;
                    scrollViewI4.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: dc.cx2
                        @Override // android.view.View.OnScrollChangeListener
                        public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                            NewGamingDetailsActivity.b.a.a(newGamingDetailsActivity, iA, view, i, i2, i3, i4);
                        }
                    });
                }
                ScrollView scrollViewI42 = this.this$0.I4();
                final NewGamingDetailsActivity newGamingDetailsActivity2 = this.this$0;
                scrollViewI42.post(new Runnable() { // from class: dc.dx2
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewGamingDetailsActivity.b.a.b(newGamingDetailsActivity2, iA);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewGalleryList newGalleryList) {
            super(0);
            this.$it = newGalleryList;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NewGamingDetailsActivity newGamingDetailsActivity = NewGamingDetailsActivity.this;
            newGamingDetailsActivity.V4(newGamingDetailsActivity.F4(), this.$it.getApplicationLogoUrl(), new a(NewGamingDetailsActivity.this));
        }
    }

    /* compiled from: NewGamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/gaming/NewGamingDetailsActivity$showDeatls$3", "Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements NewGamingDetailsAdAdapter.a {
        public c() {
        }

        @Override // com.wear.adapter.game.NewGamingDetailsAdAdapter.a
        public void a(int i) {
            String str = "position===" + i;
            NewGamingDetailsActivity.this.X4(i);
        }
    }

    /* compiled from: NewGamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/gaming/NewGamingDetailsActivity$showDeatls$4", "Lcom/wear/adapter/game/NewGamingDetailsAdFullScreenAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements NewGamingDetailsAdFullScreenAdapter.a {
        public d() {
        }

        @Override // com.wear.adapter.game.NewGamingDetailsAdFullScreenAdapter.a
        public void a(int i) {
            NewGamingDetailsActivity.this.v4();
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

    public static final void Q4(NewGamingDetailsActivity this$0, NewGalleryList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.W4(it);
    }

    public static final void Y4(NewGamingDetailsActivity this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O4().setCurrentItem(i);
    }

    public static final void a5(NewGamingDetailsActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.t(this$0, LoginActivity.class, 2);
    }

    @NotNull
    public final TextView A4() {
        TextView textView = this.gameDetails;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameDetails");
        return null;
    }

    @NotNull
    public final TextView B4() {
        TextView textView = this.gameName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameName");
        return null;
    }

    @NotNull
    public final Guideline C4() {
        Guideline guideline = this.guideline;
        if (guideline != null) {
            return guideline;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guideline");
        return null;
    }

    @NotNull
    public final ImageView D4() {
        ImageView imageView = this.ivAdBanner;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivAdBanner");
        return null;
    }

    @NotNull
    public final ImageView E4() {
        ImageView imageView = this.ivIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        return null;
    }

    @NotNull
    public final ImageView F4() {
        ImageView imageView = this.ivTopIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTopIcon");
        return null;
    }

    @NotNull
    public final LinearLayout G4() {
        LinearLayout linearLayout = this.llGamingDetails;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llGamingDetails");
        return null;
    }

    @NotNull
    public final View H4() {
        View view = this.placeholder;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("placeholder");
        return null;
    }

    @NotNull
    public final ScrollView I4() {
        ScrollView scrollView = this.scrollView;
        if (scrollView != null) {
            return scrollView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        return null;
    }

    @NotNull
    public final TextView J4() {
        TextView textView = this.tvAuthor;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvAuthor");
        return null;
    }

    @NotNull
    public final View K4() {
        View view = this.viewLine;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewLine");
        return null;
    }

    public final GamingViewModel L4() {
        return (GamingViewModel) this.d.getValue();
    }

    @NotNull
    public final View M4() {
        View view = this.viewTopBarDivider;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewTopBarDivider");
        return null;
    }

    @NotNull
    public final RecyclerView N4() {
        RecyclerView recyclerView = this.vpGamingDetails;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vpGamingDetails");
        return null;
    }

    @NotNull
    public final ViewPager2 O4() {
        ViewPager2 viewPager2 = this.vpGamingDetailsFullScreen;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vpGamingDetailsFullScreen");
        return null;
    }

    public final void P4() {
        GamingViewModel gamingViewModelL4 = L4();
        String stringExtra = getIntent().getStringExtra(RemoteConfigConstants.RequestFieldKey.APP_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        gamingViewModelL4.e(stringExtra, stringExtra2 != null ? stringExtra2 : "");
        L4().b().observe(this, new Observer() { // from class: dc.bx2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewGamingDetailsActivity.Q4(this.a, (NewGalleryList) obj);
            }
        });
    }

    public final void R4() {
        Bundle extras = getIntent().getExtras();
        Serializable serializable = extras != null ? extras.getSerializable("galleryDetails") : null;
        NewGalleryList newGalleryList = serializable instanceof NewGalleryList ? (NewGalleryList) serializable : null;
        this.h = newGalleryList;
        String.valueOf(newGalleryList);
        NewGalleryList newGalleryList2 = this.h;
        if (newGalleryList2 == null) {
            P4();
        } else if (newGalleryList2 != null) {
            W4(newGalleryList2);
        }
    }

    public final void V4(ImageView imageView, String str, Function0<Unit> function0) {
        kf.w(imageView.getContext()).v(str).C0(new a(function0)).a(new qo().V(Integer.MIN_VALUE)).A0(imageView);
    }

    public final void W4(NewGalleryList newGalleryList) {
        List<String> list;
        B4().setText(newGalleryList.getApplicationName());
        z4().setText(newGalleryList.getApplicationSynopsis());
        ij3.c(this, E4(), newGalleryList.getApplicationLogoUrl());
        V4(D4(), newGalleryList.getApplicationCoverImgUrl(), new b(newGalleryList));
        List<String> previewImgUlrList = newGalleryList.getPreviewImgUlrList();
        if (previewImgUlrList != null && (list = this.e) != null) {
            list.addAll(previewImgUlrList);
        }
        List<String> list2 = this.e;
        String lowerCase = null;
        String.valueOf(list2 != null ? Integer.valueOf(list2.size()) : null);
        A4().setText(newGalleryList.getPreviewText());
        J4().setText(newGalleryList.getDeveloperName());
        String previewImgOrientation = newGalleryList.getPreviewImgOrientation();
        if (previewImgOrientation == null) {
            previewImgOrientation = "horizontal";
        }
        this.j = previewImgOrientation;
        String str = "previewImgOrientation11111====" + this.j;
        NewGamingDetailsAdAdapter newGamingDetailsAdAdapter = new NewGamingDetailsAdAdapter(this.e, new c());
        this.g = newGamingDetailsAdAdapter;
        if (newGamingDetailsAdAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            newGamingDetailsAdAdapter = null;
        }
        newGamingDetailsAdAdapter.p(this.j);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        linearLayoutManager.setOrientation(0);
        N4().setLayoutManager(linearLayoutManager);
        RecyclerView recyclerViewN4 = N4();
        NewGamingDetailsAdAdapter newGamingDetailsAdAdapter2 = this.g;
        if (newGamingDetailsAdAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            newGamingDetailsAdAdapter2 = null;
        }
        recyclerViewN4.setAdapter(newGamingDetailsAdAdapter2);
        this.f = new NewGamingDetailsAdFullScreenAdapter(this.e, new d());
        ViewPager2 viewPager2O4 = O4();
        NewGamingDetailsAdFullScreenAdapter newGamingDetailsAdFullScreenAdapter = this.f;
        if (newGamingDetailsAdFullScreenAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullAdapter");
            newGamingDetailsAdFullScreenAdapter = null;
        }
        viewPager2O4.setAdapter(newGamingDetailsAdFullScreenAdapter);
        O4().setOffscreenPageLimit(1);
        x4().setLayoutManager(new GridLayoutManager(this, 2));
        this.i = new ApiListAdapter();
        RecyclerView recyclerViewX4 = x4();
        ApiListAdapter apiListAdapter = this.i;
        if (apiListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiListAdapter");
            apiListAdapter = null;
        }
        recyclerViewX4.setAdapter(apiListAdapter);
        ApiListAdapter apiListAdapter2 = this.i;
        if (apiListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiListAdapter");
            apiListAdapter2 = null;
        }
        apiListAdapter2.y0(newGalleryList.getDataRequiredList());
        String applicationId = newGalleryList.getApplicationId();
        String applicationName = newGalleryList.getApplicationName();
        if (applicationName != null) {
            lowerCase = applicationName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        ye3.j("game", "game_preview_exposure", "exposure", applicationId, "", "", lowerCase, -1L);
    }

    public final void X4(final int i) {
        if (O4().getVisibility() == 8) {
            O4().setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            O4().startAnimation(animationSet);
            O4().post(new Runnable() { // from class: dc.zw2
                @Override // java.lang.Runnable
                public final void run() {
                    NewGamingDetailsActivity.Y4(this.a, i);
                }
            });
        }
    }

    public final void Z4(int i) {
        cs3.c(this, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.ax2
            @Override // dc.is3.d
            public final void doConfirm() {
                NewGamingDetailsActivity.a5(this.a);
            }
        }).show();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String applicationName;
        super.onActivityResult(requestCode, resultCode, data);
        this.c = System.currentTimeMillis();
        NewGalleryList newGalleryList = this.h;
        String lowerCase = null;
        String applicationId = newGalleryList != null ? newGalleryList.getApplicationId() : null;
        NewGalleryList newGalleryList2 = this.h;
        if (newGalleryList2 != null && (applicationName = newGalleryList2.getApplicationName()) != null) {
            lowerCase = applicationName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        ye3.j("game", "game_exit_click", "click", applicationId, "button", "", lowerCase, (this.c - this.b) / 1000);
        if (this.l) {
            h32.i().F(0);
            this.l = false;
        }
        u4("com.megame.beta");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (O4().getVisibility() == 0) {
            v4();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.iv_close, R.id.btn_play})
    public final void onClick(@NotNull View view) {
        String str;
        String applicationUrl;
        String applicationId;
        String applicationVersion;
        String applicationName;
        Collection collectionEmptyList;
        String applicationLogoUrl;
        String xremoteApiVersion;
        String applicationName2;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.btn_play) {
            if (id != R.id.iv_close) {
                return;
            }
            finish();
            return;
        }
        if (MyApplication.Z) {
            Z4(R.string.common_login_first);
            return;
        }
        String str2 = this.h == null ? "2" : "1";
        this.b = System.currentTimeMillis();
        if (this.h == null) {
            this.h = L4().b().getValue();
        }
        NewGalleryList newGalleryList = this.h;
        String applicationId2 = newGalleryList != null ? newGalleryList.getApplicationId() : null;
        NewGalleryList newGalleryList2 = this.h;
        if (newGalleryList2 == null || (applicationName2 = newGalleryList2.getApplicationName()) == null) {
            str = null;
        } else {
            String lowerCase = applicationName2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            str = lowerCase;
        }
        ye3.j("game", "game_open_click", "click", applicationId2, str2, "2", str, -1L);
        NewGalleryList newGalleryList3 = this.h;
        if (Intrinsics.areEqual(newGalleryList3 != null ? newGalleryList3.getApplicationId() : null, this.k)) {
            h32.i().F(1);
            this.l = true;
            pj3.o(this, SplashActivity.class, 10086);
        } else {
            t23.a aVar = t23.a;
            NewGalleryList newGalleryList4 = this.h;
            if (newGalleryList4 == null || (applicationUrl = newGalleryList4.getApplicationUrl()) == null) {
                applicationUrl = "";
            }
            NewGalleryList newGalleryList5 = this.h;
            if (newGalleryList5 == null || (applicationId = newGalleryList5.getApplicationId()) == null) {
                applicationId = "";
            }
            NewGalleryList newGalleryList6 = this.h;
            String str3 = (newGalleryList6 == null || (xremoteApiVersion = newGalleryList6.getXremoteApiVersion()) == null) ? "" : xremoteApiVersion;
            NewGalleryList newGalleryList7 = this.h;
            if (newGalleryList7 == null || (applicationVersion = newGalleryList7.getApplicationVersion()) == null) {
                applicationVersion = "";
            }
            NewGalleryList newGalleryList8 = this.h;
            if (newGalleryList8 == null || (applicationName = newGalleryList8.getApplicationName()) == null) {
                applicationName = "";
            }
            NewGalleryList newGalleryList9 = this.h;
            if (newGalleryList9 == null || (collectionEmptyList = newGalleryList9.getXremoteAllowDomainList()) == null) {
                collectionEmptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList<String> arrayList = collectionEmptyList instanceof ArrayList ? (ArrayList) collectionEmptyList : null;
            NewGalleryList newGalleryList10 = this.h;
            if (newGalleryList10 == null || (applicationLogoUrl = newGalleryList10.getApplicationLogoUrl()) == null) {
                applicationLogoUrl = "";
            }
            Bundle bundleB = aVar.b(applicationUrl, applicationId, applicationVersion, str3, applicationName, arrayList, applicationLogoUrl);
            if (bundleB != null) {
                pj3.p(this, XRemoteActivity.class, 10086, bundleB);
            }
        }
        w4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_details_new);
        ButterKnife.bind(this);
        R4();
    }

    public final void setPlaceholder(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.placeholder = view;
    }

    public final void setViewLine(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.viewLine = view;
    }

    public final void setViewTopBarDivider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.viewTopBarDivider = view;
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setStatusBarContrastEnforced(false);
        }
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
        getWindow().setNavigationBarColor(0);
        getWindow().setStatusBarColor(0);
    }

    public final void u4(String str) {
        Object systemService = getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            String processName = runningAppProcessInfo.processName;
            String str2 = "processName=" + processName;
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            if (StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) (str == null ? "" : str), false, 2, (Object) null)) {
                String str3 = "processName=" + processName;
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public final void v4() {
        if (O4().getVisibility() == 0) {
            O4().setVisibility(8);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            O4().startAnimation(animationSet);
        }
    }

    public final void w4() {
        if (MusicControl.h0().O()) {
            MusicControl.h0().S();
        }
        if (qf3.a) {
            qf3.u(0);
            qf3.C();
        }
        y12.c.a().t();
    }

    @NotNull
    public final RecyclerView x4() {
        RecyclerView recyclerView = this.apiRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apiRecyclerView");
        return null;
    }

    @NotNull
    public final ConstraintLayout y4() {
        ConstraintLayout constraintLayout = this.clTopBar;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clTopBar");
        return null;
    }

    @NotNull
    public final TextView z4() {
        TextView textView = this.gameDescription;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameDescription");
        return null;
    }
}
