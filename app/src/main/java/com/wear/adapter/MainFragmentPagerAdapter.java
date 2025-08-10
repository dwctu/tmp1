package com.wear.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.githang.viewpagerindicator.IconPagerAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.main.BaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainFragmentPagerAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/wear/adapter/MainFragmentPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "Lcom/githang/viewpagerindicator/IconPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "fragmentList", "getCount", "", "getIconResId", FirebaseAnalytics.Param.INDEX, "getItem", "position", "getPageTitle", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MainFragmentPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    @NotNull
    public final List<Fragment> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MainFragmentPagerAdapter(@NotNull FragmentManager fm, @NotNull List<? extends Fragment> fragments) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.a = fragments;
    }

    @Override // androidx.viewpager.widget.PagerAdapter, com.githang.viewpagerindicator.IconPagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // com.githang.viewpagerindicator.IconPagerAdapter
    public int getIconResId(int index) {
        if (!(this.a.get(index) instanceof BaseFragment)) {
            return 0;
        }
        Fragment fragment = this.a.get(index);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.wear.main.BaseFragment<*, *>");
        return ((BaseFragment) fragment).A();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        return this.a.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        if (!(this.a.get(position) instanceof BaseFragment)) {
            return "";
        }
        Fragment fragment = this.a.get(position);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.wear.main.BaseFragment<*, *>");
        return ((BaseFragment) fragment).B();
    }
}
