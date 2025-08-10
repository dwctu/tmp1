package com.wear.ui.discover.roulette;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.UserJoinChatBean;
import com.wear.databinding.ActivityToyRouletteBinding;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.widget.MyActionBar;
import dc.eg3;
import dc.my2;
import dc.pj3;
import dc.qy2;
import dc.vl2;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyRouletteActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0014J\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/roulette/ToyRouletteActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityToyRouletteBinding;", "checkFirstIncome", "", "initActionBar", "actionbar", "Lcom/wear/widget/MyActionBar;", "navigateToRouletteHomeFragment", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showNoToyPopupWindowOn", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToyRouletteActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a b = new a(null);
    public ActivityToyRouletteBinding a;

    /* compiled from: ToyRouletteActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/discover/roulette/ToyRouletteActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            my2.c cVar = my2.i;
            if (!cVar.a().getB()) {
                context.startActivity(new Intent(context, (Class<?>) ToyRouletteActivity.class));
                return;
            }
            UserJoinChatBean c = cVar.a().getC();
            if (c != null) {
                c.setFromOuter(false);
                NewChatActivity.a.b(NewChatActivity.n, context, c, false, false, 12, null);
            }
        }
    }

    public static final void u4(ToyRouletteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void v4(ToyRouletteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        my2.i.a().D(true);
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(savedInstanceState);
        ActivityToyRouletteBinding activityToyRouletteBindingC = ActivityToyRouletteBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityToyRouletteBindingC, "inflate(layoutInflater)");
        this.a = activityToyRouletteBindingC;
        if (activityToyRouletteBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityToyRouletteBindingC = null;
        }
        setContentView(activityToyRouletteBindingC.getRoot());
        ActivityToyRouletteBinding activityToyRouletteBinding = this.a;
        if (activityToyRouletteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityToyRouletteBinding = null;
        }
        MyActionBar myActionBar = activityToyRouletteBinding.b;
        Intrinsics.checkNotNullExpressionValue(myActionBar, "binding.actionbar");
        t4(myActionBar);
        ye3.c("control roulette", "into page", null);
        s4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityToyRouletteBinding activityToyRouletteBinding = this.a;
        if (activityToyRouletteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityToyRouletteBinding = null;
        }
        activityToyRouletteBinding.b.s();
    }

    public final void s4() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        if (eg3.d(this, "is_first_roulette", true)) {
            eg3.j(this, "is_first_roulette", false);
        } else {
            y4();
        }
    }

    public final void t4(MyActionBar myActionBar) {
        myActionBar.setToysAction(new MyActionBar.f() { // from class: dc.iy2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ToyRouletteActivity.u4(this.a, view);
            }
        }, false, this);
        myActionBar.setBackAction(new MyActionBar.f() { // from class: dc.jy2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ToyRouletteActivity.v4(this.a, view);
            }
        });
        myActionBar.n();
    }

    public final void y4() throws Resources.NotFoundException {
        ActivityToyRouletteBinding activityToyRouletteBinding = this.a;
        if (activityToyRouletteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityToyRouletteBinding = null;
        }
        NavController navController = ((NavHostFragment) activityToyRouletteBinding.c.getFragment()).getNavController();
        NavDestination currentDestination = navController.getCurrentDestination();
        boolean z = false;
        if (currentDestination != null && currentDestination.getId() == R.id.rouletteWelcomeFragment) {
            z = true;
        }
        if (z) {
            navController.navigate(R.id.action_rouletteWelcomeFragment_to_rouletteHomeFragment);
        }
    }

    public final void z4() {
        ActivityToyRouletteBinding activityToyRouletteBinding = this.a;
        ActivityToyRouletteBinding activityToyRouletteBinding2 = null;
        if (activityToyRouletteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityToyRouletteBinding = null;
        }
        ConstraintLayout root = activityToyRouletteBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        ActivityToyRouletteBinding activityToyRouletteBinding3 = this.a;
        if (activityToyRouletteBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityToyRouletteBinding2 = activityToyRouletteBinding3;
        }
        MyActionBar myActionBar = activityToyRouletteBinding2.b;
        Intrinsics.checkNotNullExpressionValue(myActionBar, "binding.actionbar");
        qy2.c(root, layoutInflater, myActionBar);
    }
}
