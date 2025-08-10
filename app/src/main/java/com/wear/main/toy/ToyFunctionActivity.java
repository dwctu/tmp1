package com.wear.main.toy;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseBindActivity;
import com.wear.adapter.ViewsPagerAdapter;
import com.wear.bean.Toy;
import com.wear.bean.event.SolaceProFunctionChangeEvent;
import com.wear.databinding.ActivityToyFunctionBinding;
import com.wear.main.toy.ToyFunctionActivity;
import com.wear.main.toy.ToyFunctionAdapter;
import com.wear.main.toy.newtoy.ToyFunctionModel;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.ShimmerLayout;
import dc.ah4;
import dc.ce3;
import dc.ek2;
import dc.fe3;
import dc.fk2;
import dc.me0;
import dc.na2;
import dc.pc1;
import dc.th4;
import dc.wi1;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* compiled from: ToyFunctionActivity.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002<=B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020,H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u0010.\u001a\u00020,H\u0016J\b\u00102\u001a\u00020\"H\u0014J\"\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u000bH\u0002J\b\u00108\u001a\u00020\"H\u0002J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00112\b\b\u0002\u0010;\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006>"}, d2 = {"Lcom/wear/main/toy/ToyFunctionActivity;", "Lcom/wear/BaseBindActivity;", "Lcom/wear/databinding/ActivityToyFunctionBinding;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/View$OnClickListener;", "()V", "activityCreateTime", "", "behavior", "Lcom/wear/main/toy/ToyFunctionActivity$ToyFunctionScrollingBehavior;", "canChangeFunction", "", "descrViews", "", "Landroid/view/View;", "modeViews", "selectMode", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "supportFunctionsAdapter", "Lcom/wear/main/toy/ToyFunctionAdapter;", "supportUnFunctionsAdapter", "toolbarLayoutTouchX", "", "toy", "Lcom/wear/bean/Toy;", "toyAddress", "", "viewModel", "Lcom/wear/main/toy/newtoy/ToyFunctionModel;", "getViewModel", "()Lcom/wear/main/toy/newtoy/ToyFunctionModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initBottomView", "", "initData", "initView", "onClick", PSOProgramService.VS_Key, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPageScrollStateChanged", "state", "", "onPageScrolled", "position", "positionOffset", "positionOffsetPixels", "onPageSelected", "onResume", "playVideo", "Lcom/wear/ui/longDistance/video/player/MyVideoView;", "itemView", FirebaseAnalytics.Param.INDEX, "isSelect", "setupViewPager", "showSelectMode", "mode", "isInit", "Companion", "ToyFunctionScrollingBehavior", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToyFunctionActivity extends BaseBindActivity<ActivityToyFunctionBinding> implements ViewPager.OnPageChangeListener, View.OnClickListener {

    @Nullable
    public String f;

    @NotNull
    public final ToyFunctionAdapter g;

    @NotNull
    public final ToyFunctionAdapter h;

    @Nullable
    public Toy i;

    @NotNull
    public ek2 j;
    public float k;

    @NotNull
    public List<View> l;

    @NotNull
    public List<View> m;

    @Nullable
    public ToyFunctionScrollingBehavior n;
    public long o;
    public boolean p;

    @NotNull
    public final Lazy q;

    /* compiled from: ToyFunctionActivity.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/wear/main/toy/ToyFunctionActivity$ToyFunctionScrollingBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "controlVideoView", "Lcom/wear/ui/longDistance/video/player/MyVideoView;", "getControlVideoView", "()Lcom/wear/ui/longDistance/video/player/MyVideoView;", "setControlVideoView", "(Lcom/wear/ui/longDistance/video/player/MyVideoView;)V", "controlViewMinHeight", "", "controlViewMinWidth", "controlViewOrgHeight", "controlViewOrgWidth", "controlViewPager", "Landroid/view/View;", "getControlViewPager", "()Landroid/view/View;", "setControlViewPager", "(Landroid/view/View;)V", "mAppBarStartY", "", "mPercent", "getMPercent", "()F", "setMPercent", "(F)V", "mTotalScrollRange", "viewPagerParentViewTop", "initVar", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "onDependentViewChanged", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ToyFunctionScrollingBehavior extends AppBarLayout.ScrollingViewBehavior {
        public float a;
        public int b;
        public float c;

        @Nullable
        public View d;

        @Nullable
        public MyVideoView e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToyFunctionScrollingBehavior(@NotNull Context context, @NotNull AttributeSet attr) {
            super(context, attr);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attr, "attr");
            this.a = -1.0f;
            this.b = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MyVideoView getE() {
            return this.e;
        }

        /* renamed from: b, reason: from getter */
        public final float getC() {
            return this.c;
        }

        public final void c(AppBarLayout appBarLayout) {
            if (this.a < 0.0f) {
                this.a = appBarLayout.getY();
            }
            if (this.b < 0) {
                this.b = appBarLayout.getTotalScrollRange();
            }
            View view = this.d;
            if (view != null) {
                if (this.g < 0) {
                    this.g = view.getMeasuredHeight();
                }
                if (this.h < 0) {
                    this.h = view.getMinimumHeight();
                }
                if (this.i < 0) {
                    this.i = view.getMeasuredWidth();
                }
                if (this.j < 0) {
                    this.j = view.getMinimumWidth();
                }
                if (this.f < 0) {
                    View view2 = (View) view.getParent();
                    this.f = view2 != null ? view2.getTop() : -1;
                }
            }
        }

        public final void d(@Nullable MyVideoView myVideoView) {
            this.e = myVideoView;
        }

        public final void e(@Nullable View view) {
            this.d = view;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(dependency, "dependency");
            if (dependency instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                c(appBarLayout);
                if (this.a - appBarLayout.getY() <= this.f) {
                    this.c = 0.0f;
                } else {
                    this.c = (((this.a - dependency.getY()) - this.f) * 1.0f) / (this.b - r1);
                }
                View view = this.d;
                if (view != null) {
                    view.getLayoutParams().height = (int) (this.g - (this.c * (r3 - this.h)));
                    view.getLayoutParams().width = (int) (this.i - (this.c * (r3 - this.j)));
                    view.requestLayout();
                }
                if (this.c <= 0.0f) {
                    MyVideoView myVideoView = this.e;
                    if (myVideoView != null) {
                        myVideoView.start();
                    }
                } else {
                    MyVideoView myVideoView2 = this.e;
                    if (myVideoView2 != null) {
                        myVideoView2.pause();
                    }
                }
            }
            return super.onDependentViewChanged(parent, child, dependency);
        }
    }

    /* compiled from: ToyFunctionActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/wear/main/toy/ToyFunctionActivity$playVideo$2", "Lxyz/doikki/videoplayer/player/BaseVideoView$OnStateChangeListener;", "onPlayStateChanged", "", "playState", "", "onPlayerStateChanged", "playerState", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements BaseVideoView.a {
        public final /* synthetic */ int b;
        public final /* synthetic */ MyVideoView c;
        public final /* synthetic */ View d;

        public a(int i, MyVideoView myVideoView, View view) {
            this.b = i;
            this.c = myVideoView;
            this.d = view;
        }

        public static final void d(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            ShimmerLayout shimmerLayout = (ShimmerLayout) itemView.findViewById(R.id.shimmerLayout);
            if (shimmerLayout != null) {
                shimmerLayout.n();
            }
            View viewFindViewById = itemView.findViewById(R.id.placeholderRoot);
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(8);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r5) {
            /*
                r4 = this;
                com.wear.main.toy.ToyFunctionActivity r0 = com.wear.main.toy.ToyFunctionActivity.this
                boolean r0 = r0.isFinishing()
                if (r0 != 0) goto L8b
                com.wear.main.toy.ToyFunctionActivity r0 = com.wear.main.toy.ToyFunctionActivity.this
                boolean r0 = r0.isDestroyed()
                if (r0 == 0) goto L12
                goto L8b
            L12:
                r0 = 2
                if (r5 == r0) goto L19
                r1 = 3
                if (r5 == r1) goto L19
                goto L65
            L19:
                com.wear.main.toy.ToyFunctionActivity r1 = com.wear.main.toy.ToyFunctionActivity.this
                androidx.databinding.ViewDataBinding r1 = r1.v4()
                com.wear.databinding.ActivityToyFunctionBinding r1 = (com.wear.databinding.ActivityToyFunctionBinding) r1
                androidx.viewpager.widget.ViewPager r1 = r1.g
                int r1 = r1.getCurrentItem()
                int r2 = r4.b
                if (r1 != r2) goto L54
                com.wear.main.toy.ToyFunctionActivity r1 = com.wear.main.toy.ToyFunctionActivity.this
                com.wear.main.toy.ToyFunctionActivity$ToyFunctionScrollingBehavior r1 = com.wear.main.toy.ToyFunctionActivity.A4(r1)
                r2 = 0
                if (r1 == 0) goto L39
                float r1 = r1.getC()
                goto L3a
            L39:
                r1 = 0
            L3a:
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 != 0) goto L40
                r1 = 1
                goto L41
            L40:
                r1 = 0
            L41:
                if (r1 != 0) goto L44
                goto L54
            L44:
                if (r5 != r0) goto L59
                com.wear.ui.longDistance.video.player.MyVideoView r0 = r4.c
                boolean r0 = r0.isPlaying()
                if (r0 != 0) goto L59
                com.wear.ui.longDistance.video.player.MyVideoView r0 = r4.c
                r0.start()
                goto L59
            L54:
                com.wear.ui.longDistance.video.player.MyVideoView r0 = r4.c
                r0.pause()
            L59:
                android.view.View r0 = r4.d
                dc.th2 r1 = new dc.th2
                r1.<init>()
                r2 = 400(0x190, double:1.976E-321)
                r0.postDelayed(r1, r2)
            L65:
                r0 = -1
                if (r5 != r0) goto L8b
                android.view.View r5 = r4.d
                r0 = 2131364548(0x7f0a0ac4, float:1.8348936E38)
                android.view.View r5 = r5.findViewById(r0)
                com.wear.widget.ShimmerLayout r5 = (com.wear.widget.ShimmerLayout) r5
                if (r5 == 0) goto L78
                r5.n()
            L78:
                android.view.View r5 = r4.d
                r0 = 2131364104(0x7f0a0908, float:1.8348036E38)
                android.view.View r5 = r5.findViewById(r0)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                if (r5 == 0) goto L8b
                r0 = 2131232326(0x7f080646, float:1.8080758E38)
                r5.setImageResource(r0)
            L8b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.ToyFunctionActivity.a.a(int):void");
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void b(int i) {
        }
    }

    /* compiled from: ToyFunctionActivity.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/wear/main/toy/ToyFunctionActivity$playVideo$3", "Lcom/wear/util/DownVideoUtil$DownCallBack;", "onDownError", "", "result", "", "onDownFinish", "s", "onDownProgress", "", "onDownStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements fe3.b {
        public final /* synthetic */ String b;
        public final /* synthetic */ MyVideoView c;
        public final /* synthetic */ View d;

        public b(String str, MyVideoView myVideoView, View view) {
            this.b = str;
            this.c = myVideoView;
            this.d = view;
        }

        public static final void e(ToyFunctionActivity this$0) {
            MyVideoView e;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ToyFunctionScrollingBehavior toyFunctionScrollingBehavior = this$0.n;
            if (toyFunctionScrollingBehavior == null || (e = toyFunctionScrollingBehavior.getE()) == null) {
                return;
            }
            e.start();
        }

        @Override // dc.fe3.b
        public void a(long j) {
        }

        @Override // dc.fe3.b
        public void b(@Nullable String str) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) this.d.findViewById(R.id.shimmerLayout);
            if (shimmerLayout != null) {
                shimmerLayout.n();
            }
            ImageView imageView = (ImageView) this.d.findViewById(R.id.placeholder);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_video_load_fail);
            }
        }

        @Override // dc.fe3.b
        public void c(@Nullable String str) {
            ToyFunctionScrollingBehavior toyFunctionScrollingBehavior;
            MyVideoView e;
            if (ToyFunctionActivity.this.isFinishing() || ToyFunctionActivity.this.isDestroyed()) {
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(String.valueOf(str)));
            me0.k(this.b, true);
            this.c.setUrl(uriFromFile.toString());
            this.c.start();
            MyVideoView myVideoView = this.c;
            ToyFunctionScrollingBehavior toyFunctionScrollingBehavior2 = ToyFunctionActivity.this.n;
            if (Intrinsics.areEqual(myVideoView, toyFunctionScrollingBehavior2 != null ? toyFunctionScrollingBehavior2.getE() : null) || (toyFunctionScrollingBehavior = ToyFunctionActivity.this.n) == null || (e = toyFunctionScrollingBehavior.getE()) == null) {
                return;
            }
            final ToyFunctionActivity toyFunctionActivity = ToyFunctionActivity.this;
            e.postDelayed(new Runnable() { // from class: dc.uh2
                @Override // java.lang.Runnable
                public final void run() {
                    ToyFunctionActivity.b.e(toyFunctionActivity);
                }
            }, 100L);
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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
    public static final class d extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ComponentActivity componentActivity) {
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
    public static final class e extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0 function0, ComponentActivity componentActivity) {
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

    public ToyFunctionActivity() {
        super(R.layout.activity_toy_function, 27);
        this.g = new ToyFunctionAdapter();
        this.h = new ToyFunctionAdapter();
        this.j = ek2.POSITION;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.o = -1L;
        this.p = !na2.m().i();
        this.q = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ToyFunctionModel.class), new d(this), new c(this), new e(null, this));
    }

    public static final void D4(ToyFunctionActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void E4(ToyFunctionActivity this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.f;
        if (str != null) {
            fk2.a.i(str, this$0.j);
            EventBus.getDefault().post(new SolaceProFunctionChangeEvent(this$0.i, this$0.j));
        }
        this$0.finish();
    }

    public static final void L4(ToyFunctionActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v4().h.requestLayout();
    }

    public static final void N4(MyVideoView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "$videoView");
        videoView.start();
    }

    public static final boolean P4(ToyFunctionActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k = motionEvent.getX();
        return false;
    }

    public static final void Q4(ToyFunctionActivity this$0, View view, int i, View view2) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.k < ((view2.getMeasuredWidth() / 2) - (view.getMeasuredWidth() / 2)) - i) {
            S4(this$0, ek2.POSITION, false, 2, null);
        }
        if (this$0.k > (view2.getMeasuredWidth() / 2) + (view.getMeasuredWidth() / 2) + i) {
            S4(this$0, ek2.SPEED, false, 2, null);
        }
    }

    public static /* synthetic */ void S4(ToyFunctionActivity toyFunctionActivity, ek2 ek2Var, boolean z, int i, Object obj) throws Resources.NotFoundException {
        if ((i & 2) != 0) {
            z = false;
        }
        toyFunctionActivity.R4(ek2Var, z);
    }

    @Override // com.wear.BaseViewModelActivity
    @NotNull
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public ToyFunctionModel t4() {
        return (ToyFunctionModel) this.q.getValue();
    }

    public final void C4() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_remote, R.string.closeRange_remoteControl, true));
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_pattern, R.string.chat_pattern_by_create_default_name, true));
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_live, R.string.message_notification_type_live, true));
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_sync, R.string.message_notification_type_sync, true));
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_video, R.string.solace2_position_support_call, true));
        arrayList.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_ds, R.string.group_chat_menu_ds, true));
        this.g.y0(arrayList);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        View view0 = layoutInflaterFrom.inflate(R.layout.item_toy_funtion_list, (ViewGroup) null);
        View view1 = layoutInflaterFrom.inflate(R.layout.item_toy_funtion_list, (ViewGroup) null);
        List<View> list = this.m;
        Intrinsics.checkNotNullExpressionValue(view0, "view0");
        list.add(view0);
        List<View> list2 = this.m;
        Intrinsics.checkNotNullExpressionValue(view1, "view1");
        list2.add(view1);
        ViewsPagerAdapter viewsPagerAdapter = new ViewsPagerAdapter(this.m);
        v4().h.setAdapter(viewsPagerAdapter);
        v4().h.setOffscreenPageLimit(this.m.size());
        viewsPagerAdapter.notifyDataSetChanged();
        v4().h.addOnPageChangeListener(this);
        RecyclerView recyclerView = (RecyclerView) view0.findViewById(R.id.function_support_recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.g);
        recyclerView.setBackground(th4.d(this, R.drawable.round_toy_support_list_bg));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_music, R.string.closeRange_music, false));
        arrayList2.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_sound, R.string.closeRange_sound, false));
        arrayList2.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_speed, R.string.discover_speed_mode, false));
        arrayList2.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_long_dis, R.string.chat_control_tochange_ldr, false));
        arrayList2.add(new ToyFunctionAdapter.ToyFunctionSupportBean(R.drawable.icon_support_function_local_synce, R.string.fys_button, false));
        this.h.y0(arrayList2);
        RecyclerView recyclerView2 = (RecyclerView) view0.findViewById(R.id.function_no_support_recycler);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(this.h);
        recyclerView2.setBackground(th4.d(this, R.drawable.round_toy_support_list_bg));
        ((TextView) view1.findViewById(R.id.tvFunctionTitle)).setText(ah4.e(R.string.solace2_speed_des));
        ((TextView) view1.findViewById(R.id.tvFunctionDescr)).setText(ah4.e(R.string.solace2_speed_feature_supported));
        view1.findViewById(R.id.function_support_recycler).setVisibility(8);
        view1.findViewById(R.id.function_no_support_recycler).setVisibility(8);
    }

    public final MyVideoView M4(View view, int i, boolean z) {
        String str = ((MyApplication.m0 == 0 && MyApplication.l0) || MyApplication.m0 == 2) ? i == 0 ? "https://cdn.lovense.com/UploadFiles/wear/solace/position.mp4" : "https://cdn.lovense.com/UploadFiles/wear/solace/speed.mp4" : i == 0 ? "https://cdn.lovense.com/UploadFiles/wear/solace/position_white.mp4" : "https://cdn.lovense.com/UploadFiles/wear/solace/speed_white.mp4";
        final MyVideoView myVideoView = (MyVideoView) view.findViewById(R.id.videoPlayer);
        if (myVideoView == null) {
            return null;
        }
        Object tag = myVideoView.getTag(R.id.tag1);
        BaseVideoView.a aVar = tag instanceof BaseVideoView.a ? (BaseVideoView.a) tag : null;
        if (aVar != null) {
            myVideoView.v(aVar);
        }
        a aVar2 = new a(i, myVideoView, view);
        myVideoView.setTag(R.id.tag1, aVar2);
        myVideoView.i(aVar2);
        String strR0 = WearUtils.r0(str);
        String str2 = "DOWNLOAD_VIDEO_" + strR0;
        boolean zA = me0.a(str2, false);
        File fileH = fe3.h(strR0);
        if (zA && fileH.exists()) {
            myVideoView.setUrl(Uri.fromFile(fileH).toString());
        } else if (myVideoView.getTag(R.id.tag2) == null) {
            b bVar = new b(str2, myVideoView, view);
            myVideoView.setTag(R.id.tag2, bVar);
            new fe3().n(str, WearUtils.r0(str), this, true, bVar);
        }
        myVideoView.setScreenScaleType(3);
        myVideoView.setBackgroundColor(0);
        myVideoView.setLooping(true);
        if (zA) {
            ToyFunctionScrollingBehavior toyFunctionScrollingBehavior = this.n;
            if (((toyFunctionScrollingBehavior != null ? toyFunctionScrollingBehavior.getC() : 0.0f) == 0.0f) && z) {
                myVideoView.postDelayed(new Runnable() { // from class: dc.qh2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToyFunctionActivity.N4(myVideoView);
                    }
                }, 100L);
            } else {
                myVideoView.start();
                myVideoView.pause();
            }
        }
        return myVideoView;
    }

    public final void O4() throws Resources.NotFoundException {
        v4().e.setOnClickListener(this);
        v4().f.setOnClickListener(this);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        final View view0 = layoutInflaterFrom.inflate(R.layout.item_toy_funtion_mode, (ViewGroup) null);
        View view1 = layoutInflaterFrom.inflate(R.layout.item_toy_funtion_mode, (ViewGroup) null);
        List<View> list = this.l;
        Intrinsics.checkNotNullExpressionValue(view0, "view0");
        list.add(view0);
        List<View> list2 = this.l;
        Intrinsics.checkNotNullExpressionValue(view1, "view1");
        list2.add(view1);
        ViewsPagerAdapter viewsPagerAdapter = new ViewsPagerAdapter(this.l);
        v4().g.setAdapter(viewsPagerAdapter);
        viewsPagerAdapter.notifyDataSetChanged();
        v4().g.addOnPageChangeListener(this);
        v4().g.setOffscreenPageLimit(this.l.size());
        final int iA = ce3.a(this, 16.0f);
        v4().g.setPageMargin(iA);
        v4().g.setClipChildren(false);
        v4().d.setOnTouchListener(new View.OnTouchListener() { // from class: dc.ph2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ToyFunctionActivity.P4(this.a, view, motionEvent);
            }
        });
        v4().d.setOnClickListener(new View.OnClickListener() { // from class: dc.rh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ToyFunctionActivity.Q4(this.a, view0, iA, view);
            }
        });
        ShimmerLayout shimmerLayout = (ShimmerLayout) view0.findViewById(R.id.shimmerLayout);
        if (shimmerLayout != null) {
            shimmerLayout.m();
        }
        ShimmerLayout shimmerLayout2 = (ShimmerLayout) view1.findViewById(R.id.shimmerLayout);
        if (shimmerLayout2 != null) {
            shimmerLayout2.m();
        }
        ViewGroup.LayoutParams layoutParams = v4().c.getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        Object behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
        ToyFunctionScrollingBehavior toyFunctionScrollingBehavior = behavior instanceof ToyFunctionScrollingBehavior ? (ToyFunctionScrollingBehavior) behavior : null;
        this.n = toyFunctionScrollingBehavior;
        if (toyFunctionScrollingBehavior == null) {
            return;
        }
        toyFunctionScrollingBehavior.e(v4().g);
    }

    public final void R4(ek2 ek2Var, boolean z) throws Resources.NotFoundException {
        if (ek2Var == ek2.POSITION) {
            v4().e.setBackground(th4.d(this, R.drawable.round_toy_function_tab_item_bg));
            v4().e.setStrokeWidthType(MediumBoldTextView.h, false);
            v4().e.setTextColor(th4.b(this, R.color.toy_function_tab_text));
            v4().f.setBackgroundResource(R.color.transparent);
            v4().f.setStrokeWidthType(MediumBoldTextView.f, false);
            v4().f.setTextColor(th4.b(this, R.color.toy_function_tab_text_unselect));
            v4().g.setCurrentItem(0);
            v4().h.setCurrentItem(0);
        } else {
            v4().e.setBackgroundResource(R.color.transparent);
            v4().e.setStrokeWidthType(MediumBoldTextView.f, false);
            v4().e.setTextColor(th4.b(this, R.color.toy_function_tab_text_unselect));
            v4().f.setBackground(th4.d(this, R.drawable.round_toy_function_tab_item_bg));
            v4().f.setStrokeWidthType(MediumBoldTextView.h, false);
            v4().f.setTextColor(th4.b(this, R.color.toy_function_tab_text));
            v4().g.setCurrentItem(1);
            v4().h.setCurrentItem(1);
            v4().c.smoothScrollTo(0, 0);
        }
        if (!z && SystemClock.elapsedRealtime() - this.o > 300 && this.p) {
            Button yesBtn = v4().a.getYesBtn();
            Intrinsics.checkNotNullExpressionValue(yesBtn, "dataBinding.appBar.yesBtn");
            wi1.a(yesBtn, true);
        }
        this.j = ek2Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) throws Resources.NotFoundException {
        if (Intrinsics.areEqual(v, v4().e)) {
            S4(this, ek2.POSITION, false, 2, null);
        } else if (Intrinsics.areEqual(v, v4().f)) {
            S4(this, ek2.SPEED, false, 2, null);
        }
    }

    @Override // com.wear.BaseBindActivity, com.wear.BaseViewModelActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i = MyApplication.m0;
        if (i == 0) {
            if (!MyApplication.l0) {
                setTheme(R.style.ToySearchTheme);
            }
        } else if (i == 1) {
            setTheme(R.style.ToySearchTheme);
        }
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) throws Resources.NotFoundException {
        MyVideoView myVideoView = null;
        if (position == 0) {
            S4(this, ek2.POSITION, false, 2, null);
        } else {
            S4(this, ek2.SPEED, false, 2, null);
        }
        Iterator<T> it = this.l.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) next;
            View viewFindViewById = view.findViewById(R.id.showLayout);
            if (i == position) {
                viewFindViewById.setAlpha(1.0f);
                viewFindViewById.setBackgroundResource(R.color.toy_function_mode_select_bg);
            } else {
                viewFindViewById.setAlpha(0.7f);
                viewFindViewById.setBackgroundResource(R.color.transparent);
            }
            MyVideoView myVideoViewM4 = M4(view, i, i == position);
            if (i == position) {
                myVideoView = myVideoViewM4;
            }
            i = i2;
        }
        ToyFunctionScrollingBehavior toyFunctionScrollingBehavior = this.n;
        if (toyFunctionScrollingBehavior != null) {
            toyFunctionScrollingBehavior.d(myVideoView);
        }
        v4().h.setControlHeight(position == 1 ? (v4().b.getMeasuredHeight() - v4().d.getMinimumHeight()) - ce3.a(this, 20.0f) : 0);
        v4().h.postDelayed(new Runnable() { // from class: dc.oh2
            @Override // java.lang.Runnable
            public final void run() {
                ToyFunctionActivity.L4(this.a);
            }
        }, 100L);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        boolean z = !na2.m().i();
        this.p = z;
        if (z) {
            v4().i.setVisibility(8);
            return;
        }
        Button yesBtn = v4().a.getYesBtn();
        Intrinsics.checkNotNullExpressionValue(yesBtn, "dataBinding.appBar.yesBtn");
        wi1.a(yesBtn, false);
        v4().i.setVisibility(0);
    }

    @Override // com.wear.BaseBindActivity
    public void w4() {
    }

    @Override // com.wear.BaseBindActivity
    public void x4() throws Resources.NotFoundException {
        this.o = SystemClock.elapsedRealtime();
        String stringExtra = getIntent().getStringExtra("toy_function_address_Id");
        this.f = stringExtra;
        Toy toyQ = stringExtra != null ? pc1.a.Q(stringExtra) : null;
        this.i = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        v4().a.setBackAction(new MyActionBar.f() { // from class: dc.nh2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ToyFunctionActivity.D4(this.a, view);
            }
        });
        v4().a.setYesAction(ah4.e(R.string.common_save), new MyActionBar.f() { // from class: dc.sh2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                ToyFunctionActivity.E4(this.a, view);
            }
        });
        Button yesBtn = v4().a.getYesBtn();
        Intrinsics.checkNotNullExpressionValue(yesBtn, "dataBinding.appBar.yesBtn");
        wi1.a(yesBtn, false);
        O4();
        C4();
        String str = this.f;
        if (str != null) {
            ek2 ek2VarC = fk2.a.c(str);
            this.j = ek2VarC;
            R4(ek2VarC, true);
        }
        ek2 ek2Var = this.j;
        if (ek2Var == ek2.POSITION) {
            onPageSelected(0);
        } else if (ek2Var == ek2.SPEED) {
            onPageSelected(1);
        }
    }
}
