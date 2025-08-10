package com.wear.ui.discover.roulette;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ViewKt;
import com.lovense.wear.R;
import com.wear.BaseBindingFragment;
import com.wear.bean.Account;
import com.wear.databinding.FragmentRouletteWelcomeBinding;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteWelcomeFragment.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteWelcomeFragment;", "Lcom/wear/BaseBindingFragment;", "Lcom/wear/databinding/FragmentRouletteWelcomeBinding;", "()V", "notifyUserAvatar", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Listeners", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteWelcomeFragment extends BaseBindingFragment<FragmentRouletteWelcomeBinding> {

    /* compiled from: RouletteWelcomeFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRouletteWelcomeBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentRouletteWelcomeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentRouletteWelcomeBinding;", 0);
        }

        @NotNull
        public final FragmentRouletteWelcomeBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRouletteWelcomeBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRouletteWelcomeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: RouletteWelcomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/discover/roulette/RouletteWelcomeFragment$Listeners;", "", "()V", "startTryOut", "", "view", "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            NavController navControllerFindNavController = ViewKt.findNavController(view);
            NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
            boolean z = false;
            if (currentDestination != null && currentDestination.getId() == R.id.rouletteWelcomeFragment) {
                z = true;
            }
            if (z) {
                navControllerFindNavController.navigate(R.id.action_rouletteWelcomeFragment_to_rouletteHomeFragment);
            }
        }
    }

    public RouletteWelcomeFragment() {
        super(a.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        t().d(new b());
        u();
    }

    public final void u() {
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            String avatar = accountU.getAvatar();
            if (!(avatar == null || avatar.length() == 0)) {
                WearUtils.u2(t().a, accountU.getAvatar());
                return;
            }
        }
        t().a.setImageResource(R.drawable.chat_avatar_default);
    }
}
