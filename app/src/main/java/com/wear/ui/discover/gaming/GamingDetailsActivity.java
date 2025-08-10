package com.wear.ui.discover.gaming;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.epicgames.unreal.SplashActivity;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.game.GamingDetailsAdAdapter;
import com.wear.adapter.game.GamingDetailsAdFullScreenAdapter;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.discover.gaming.GamingDetailsActivity;
import dc.ce3;
import dc.gg3;
import dc.h32;
import dc.kg3;
import dc.pj3;
import dc.qf3;
import dc.vl2;
import dc.y12;
import dc.ye3;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GamingDetailsActivity.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010/H\u0002J\u0006\u0010D\u001a\u00020BJ\b\u0010E\u001a\u00020BH\u0002J\f\u0010F\u001a\b\u0012\u0004\u0012\u0002040GJ\u0006\u0010H\u001a\u00020BJ\"\u0010I\u001a\u00020B2\u0006\u0010J\u001a\u0002042\u0006\u0010K\u001a\u0002042\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020BH\u0016J\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\"H\u0007J\u0012\u0010Q\u001a\u00020B2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\b\u0010T\u001a\u00020BH\u0016J\u000e\u0010U\u001a\u00020B2\u0006\u0010V\u001a\u000204R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=¨\u0006W"}, d2 = {"Lcom/wear/ui/discover/gaming/GamingDetailsActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "clTopBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClTopBar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setClTopBar", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "endTime", "", "guideline", "Landroidx/constraintlayout/widget/Guideline;", "getGuideline", "()Landroidx/constraintlayout/widget/Guideline;", "setGuideline", "(Landroidx/constraintlayout/widget/Guideline;)V", "ivAdBanner", "Landroid/widget/ImageView;", "getIvAdBanner", "()Landroid/widget/ImageView;", "setIvAdBanner", "(Landroid/widget/ImageView;)V", "ivTopIcon", "getIvTopIcon", "setIvTopIcon", "llGamingDetails", "Landroid/widget/LinearLayout;", "getLlGamingDetails", "()Landroid/widget/LinearLayout;", "setLlGamingDetails", "(Landroid/widget/LinearLayout;)V", "placeholder", "Landroid/view/View;", "getPlaceholder", "()Landroid/view/View;", "setPlaceholder", "(Landroid/view/View;)V", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "startTime", "uuid", "", "viewLine", "getViewLine", "setViewLine", "viewLineY", "", "viewTopBarDivider", "getViewTopBarDivider", "setViewTopBarDivider", "vpGamingDetails", "Landroidx/viewpager2/widget/ViewPager2;", "getVpGamingDetails", "()Landroidx/viewpager2/widget/ViewPager2;", "setVpGamingDetails", "(Landroidx/viewpager2/widget/ViewPager2;)V", "vpGamingDetailsFullScreen", "getVpGamingDetailsFullScreen", "setVpGamingDetailsFullScreen", "closeProcess", "", "namePro", "dismissFullScreenAd", "endControl", "getGamingAdList", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "view", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "settingBarColor", "showFullScreenAd", "position", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GamingDetailsActivity extends BaseActivity<vl2> {
    public int a;

    @Nullable
    public String b = "";
    public long c;

    @BindView(R.id.cl_top_bar)
    public ConstraintLayout clTopBar;
    public long d;

    @BindView(R.id.guideline)
    public Guideline guideline;

    @BindView(R.id.iv_ad_banner)
    public ImageView ivAdBanner;

    @BindView(R.id.iv_top_icon)
    public ImageView ivTopIcon;

    @BindView(R.id.ll_gaming_details)
    public LinearLayout llGamingDetails;

    @BindView(R.id.placeholder)
    public View placeholder;

    @BindView(R.id.scroll_view)
    public ScrollView scrollView;

    @BindView(R.id.view_line)
    public View viewLine;

    @BindView(R.id.view_top_bar_divider)
    public View viewTopBarDivider;

    @BindView(R.id.vp_gaming_details)
    public ViewPager2 vpGamingDetails;

    @BindView(R.id.vp_gaming_details_full_screen)
    public ViewPager2 vpGamingDetailsFullScreen;

    /* compiled from: GamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/gaming/GamingDetailsActivity$initView$adapter$1", "Lcom/wear/adapter/game/GamingDetailsAdAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements GamingDetailsAdAdapter.a {
        public a() {
        }

        @Override // com.wear.adapter.game.GamingDetailsAdAdapter.a
        public void a(int i) {
            GamingDetailsActivity.this.O4(i);
        }
    }

    /* compiled from: GamingDetailsActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/gaming/GamingDetailsActivity$initView$fullAdapter$1", "Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements GamingDetailsAdFullScreenAdapter.a {
        public b() {
        }

        @Override // com.wear.adapter.game.GamingDetailsAdFullScreenAdapter.a
        public void a(int i) {
            GamingDetailsActivity.this.t4();
        }
    }

    public static final void I4(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        int width = page.getWidth();
        int height = page.getHeight();
        if (f < -1.0f) {
            page.setAlpha(0.0f);
            return;
        }
        if (f > 1.0f) {
            page.setAlpha(0.0f);
            return;
        }
        float f2 = 1;
        float fMax = Math.max(0.85f, f2 - Math.abs(f));
        float f3 = f2 - fMax;
        float f4 = 2;
        float f5 = (height * f3) / f4;
        float f6 = (width * f3) / f4;
        if (f < 0.0f) {
            page.setTranslationX(f6 - (f5 / f4));
        } else {
            page.setTranslationX((-f6) + (f5 / f4));
        }
        page.setScaleX(fMax);
        page.setScaleY(fMax);
        page.setAlpha((((fMax - 0.85f) / (f2 - 0.85f)) * (f2 - 0.5f)) + 0.5f);
    }

    public static final void J4(GamingDetailsActivity this$0, int i, View view, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v4().setAlpha(i3 / ((float) ((this$0.y4().getHeight() * 0.94d) - i)));
        this$0.z4().setVisibility(this$0.v4().getAlpha() > 0.95f ? 0 : 4);
        int[] iArr = new int[2];
        this$0.D4().getLocationOnScreen(iArr);
        this$0.E4().setVisibility(this$0.v4().getHeight() < iArr[1] + this$0.D4().getHeight() ? 4 : 0);
    }

    public static final void K4(GamingDetailsActivity this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y4().getLayoutParams().height = (int) ((this$0.C4().getWidth() / this$0.y4().getWidth()) * this$0.y4().getHeight());
        this$0.y4().getLayoutParams().width = this$0.C4().getWidth();
        if (this$0.A4().getHeight() + this$0.v4().getHeight() + i < this$0.C4().getHeight()) {
            this$0.B4().getLayoutParams().height = this$0.C4().getHeight() - ((this$0.A4().getHeight() + this$0.v4().getHeight()) + i);
        }
        this$0.x4().setGuidelineBegin((int) (this$0.y4().getLayoutParams().height * 0.94d));
        this$0.v4().setPadding(0, this$0.v4().getPaddingTop() + i, 0, this$0.v4().getPaddingBottom());
        int[] iArr = new int[2];
        this$0.D4().getLocationOnScreen(iArr);
        this$0.a = iArr[1];
    }

    @NotNull
    public final LinearLayout A4() {
        LinearLayout linearLayout = this.llGamingDetails;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llGamingDetails");
        return null;
    }

    @NotNull
    public final View B4() {
        View view = this.placeholder;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("placeholder");
        return null;
    }

    @NotNull
    public final ScrollView C4() {
        ScrollView scrollView = this.scrollView;
        if (scrollView != null) {
            return scrollView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        return null;
    }

    @NotNull
    public final View D4() {
        View view = this.viewLine;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewLine");
        return null;
    }

    @NotNull
    public final View E4() {
        View view = this.viewTopBarDivider;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewTopBarDivider");
        return null;
    }

    @NotNull
    public final ViewPager2 F4() {
        ViewPager2 viewPager2 = this.vpGamingDetails;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vpGamingDetails");
        return null;
    }

    @NotNull
    public final ViewPager2 G4() {
        ViewPager2 viewPager2 = this.vpGamingDetailsFullScreen;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vpGamingDetailsFullScreen");
        return null;
    }

    public final void H4() {
        ye3.j("game", "projekt_melody_preview_exposure", "exposure", "projekt_melody_preview", "", "projekt_melody", "", -1L);
        List<Integer> listW4 = w4();
        GamingDetailsAdAdapter gamingDetailsAdAdapter = new GamingDetailsAdAdapter(listW4, new a());
        int iE = gg3.e(this);
        F4().getLayoutParams().height = (iE * 9) / 16;
        F4().setAdapter(gamingDetailsAdAdapter);
        F4().setOffscreenPageLimit(1);
        View childAt = F4().getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "vpGamingDetails.getChildAt(0)");
        if (childAt instanceof RecyclerView) {
            int i = iE / 15;
            childAt.setPadding(i, 0, i * 2, 0);
            ((RecyclerView) childAt).setClipToPadding(false);
        }
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(ce3.a(this, 10.0f)));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() { // from class: dc.ww2
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(View view, float f) {
                GamingDetailsActivity.I4(view, f);
            }
        });
        F4().setPageTransformer(compositePageTransformer);
        final int iA = kg3.a(this);
        if (Build.VERSION.SDK_INT >= 23) {
            C4().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: dc.xw2
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                    GamingDetailsActivity.J4(this.a, iA, view, i2, i3, i4, i5);
                }
            });
        }
        C4().post(new Runnable() { // from class: dc.yw2
            @Override // java.lang.Runnable
            public final void run() {
                GamingDetailsActivity.K4(this.a, iA);
            }
        });
        G4().setAdapter(new GamingDetailsAdFullScreenAdapter(listW4, new b()));
        G4().setOffscreenPageLimit(1);
    }

    public final void O4(int i) {
        if (G4().getVisibility() == 8) {
            G4().setCurrentItem(i);
            G4().setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            G4().startAnimation(animationSet);
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.d = jCurrentTimeMillis;
        ye3.j("game", "game_exit_click", "click", "game_exit", "button", "exit", this.b, (jCurrentTimeMillis - this.c) / 1000);
        s4("com.megame.beta");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (G4().getVisibility() == 0) {
            t4();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.iv_close, R.id.btn_play})
    public final void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.btn_play) {
            if (id != R.id.iv_close) {
                return;
            }
            finish();
            return;
        }
        String string = UUID.randomUUID().toString();
        this.b = string;
        ye3.j("game", "projekt_melody_perview_click", "click", "projekt_melody_perview", "button", "play", string, -1L);
        this.c = System.currentTimeMillis();
        u4();
        h32.i().F(1);
        pj3.o(this, SplashActivity.class, 10086);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_details);
        ButterKnife.bind(this);
        H4();
    }

    public final void s4(String str) {
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

    public final void t4() {
        if (G4().getVisibility() == 0) {
            G4().setVisibility(8);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            G4().startAnimation(animationSet);
            F4().setCurrentItem(G4().getCurrentItem());
        }
    }

    public final void u4() {
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
    public final ConstraintLayout v4() {
        ConstraintLayout constraintLayout = this.clTopBar;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clTopBar");
        return null;
    }

    @NotNull
    public final List<Integer> w4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.drawable.banner_gaming_project_melody_ad_1));
        arrayList.add(Integer.valueOf(R.drawable.banner_gaming_project_melody_ad_2));
        arrayList.add(Integer.valueOf(R.drawable.banner_gaming_project_melody_ad_3));
        arrayList.add(Integer.valueOf(R.drawable.banner_gaming_project_melody_ad_4));
        arrayList.add(Integer.valueOf(R.drawable.banner_gaming_project_melody_ad_5));
        return arrayList;
    }

    @NotNull
    public final Guideline x4() {
        Guideline guideline = this.guideline;
        if (guideline != null) {
            return guideline;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guideline");
        return null;
    }

    @NotNull
    public final ImageView y4() {
        ImageView imageView = this.ivAdBanner;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivAdBanner");
        return null;
    }

    @NotNull
    public final ImageView z4() {
        ImageView imageView = this.ivTopIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivTopIcon");
        return null;
    }
}
