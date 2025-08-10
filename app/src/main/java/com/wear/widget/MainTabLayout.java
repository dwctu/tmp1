package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.adapter.MainFragmentPagerAdapter;
import dc.ce3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.design.widget.SkinMaterialTabLayout;

/* compiled from: MainTabLayout.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/wear/widget/MainTabLayout;", "Lskin/support/design/widget/SkinMaterialTabLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTabReselectedListener", "Lcom/wear/widget/MainTabLayout$OnTabReselectedListener;", "setOnTabReselectedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setupWithViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "updateRedDot", FirebaseAnalytics.Param.INDEX, "isShow", "", "updateRedNum", "num", "OnTabReselectedListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class MainTabLayout extends SkinMaterialTabLayout {

    @Nullable
    public b e;

    /* compiled from: MainTabLayout.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/wear/widget/MainTabLayout$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements TabLayout.OnTabSelectedListener {
        public final /* synthetic */ Animation a;
        public final /* synthetic */ MainTabLayout b;

        public a(Animation animation, MainTabLayout mainTabLayout) {
            this.a = animation;
            this.b = mainTabLayout;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
            if (tab != null) {
                MainTabLayout mainTabLayout = this.b;
                tab.view.setSelected(true);
                b bVar = mainTabLayout.e;
                if (bVar != null) {
                    bVar.onTabReselected(tab);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (tab != null) {
                Animation animation = this.a;
                tab.view.setSelected(true);
                View viewFindViewById = tab.view.findViewById(R.id.ic_tab);
                ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
                if (imageView != null) {
                    imageView.startAnimation(animation);
                }
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            if (tab != null) {
                tab.view.setSelected(false);
            }
        }
    }

    /* compiled from: MainTabLayout.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/widget/MainTabLayout$OnTabReselectedListener;", "", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void onTabReselected(@Nullable TabLayout.Tab tab);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a(AnimationUtils.loadAnimation(getContext(), R.anim.anim_tabs), this));
    }

    public final void b(int i, boolean z) {
        TabLayout.Tab tabAt = getTabAt(i);
        if (tabAt != null) {
            View customView = tabAt.getCustomView();
            View viewFindViewById = customView != null ? customView.findViewById(R.id.v_red_dot) : null;
            if (viewFindViewById == null) {
                return;
            }
            viewFindViewById.setVisibility(z ? 0 : 8);
        }
    }

    public final void c(int i, int i2) {
        TabLayout.Tab tabAt = getTabAt(i);
        if (tabAt != null) {
            View customView = tabAt.getCustomView();
            View viewFindViewById = customView != null ? customView.findViewById(R.id.tv_red_tips) : null;
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById;
            textView.setText(i2 <= 99 ? String.valueOf(i2) : "99+");
            textView.setVisibility(i2 > 0 ? 0 : 8);
            if (i2 > 9) {
                textView.setPadding(ce3.a(getContext(), 5.0f), 0, ce3.a(getContext(), 5.0f), 0);
            } else {
                textView.setPadding(0, 0, 0, 0);
            }
        }
    }

    public final void setOnTabReselectedListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.e = listener;
    }

    @Override // com.google.android.material.tabs.TabLayout
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        if (viewPager == null || viewPager.getAdapter() == null || !(viewPager.getAdapter() instanceof MainFragmentPagerAdapter)) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.adapter.MainFragmentPagerAdapter");
        MainFragmentPagerAdapter mainFragmentPagerAdapter = (MainFragmentPagerAdapter) adapter;
        int count = mainFragmentPagerAdapter.getCount();
        for (int i = 0; i < count; i++) {
            TabLayout.Tab tabAt = getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView(R.layout.item_main_tab);
                View customView = tabAt.getCustomView();
                View viewFindViewById = customView != null ? customView.findViewById(R.id.tv_tab) : null;
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById).setText(mainFragmentPagerAdapter.getPageTitle(i));
                View customView2 = tabAt.getCustomView();
                ImageView imageView = customView2 != null ? (ImageView) customView2.findViewById(R.id.ic_tab) : null;
                Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type android.widget.ImageView");
                imageView.setImageResource(mainFragmentPagerAdapter.getIconResId(i));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainTabLayout(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
