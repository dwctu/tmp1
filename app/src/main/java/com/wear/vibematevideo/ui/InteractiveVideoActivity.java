package com.wear.vibematevideo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.databinding.ActivityInteractiveVideoBinding;
import com.wear.main.toy.ToyActivity;
import com.wear.vibematevideo.ui.InteractiveVideoActivity;
import com.wear.vibematevideo.ui.fragment.LikedFragment;
import com.wear.vibematevideo.ui.fragment.RecommendedFragment;
import com.wear.vibematevideo.ui.fragment.VbPatternFragment;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.ll3;
import dc.mk3;
import dc.pj3;
import dc.vl2;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InteractiveVideoActivity.kt */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/vibematevideo/ui/InteractiveVideoActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityInteractiveVideoBinding;", "getBinding", "()Lcom/wear/databinding/ActivityInteractiveVideoBinding;", "binding$delegate", "Lkotlin/Lazy;", "fragmentAdapter", "com/wear/vibematevideo/ui/InteractiveVideoActivity$fragmentAdapter$1", "Lcom/wear/vibematevideo/ui/InteractiveVideoActivity$fragmentAdapter$1;", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "initFragment", "", "initInject", "initTabLayout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class InteractiveVideoActivity extends BaseActivity<vl2> {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(new a());

    @NotNull
    public final List<Fragment> b = new ArrayList();

    @NotNull
    public final InteractiveVideoActivity$fragmentAdapter$1 c;

    /* compiled from: InteractiveVideoActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/ActivityInteractiveVideoBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ActivityInteractiveVideoBinding> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ActivityInteractiveVideoBinding invoke() {
            return ActivityInteractiveVideoBinding.c(InteractiveVideoActivity.this.getLayoutInflater());
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.wear.vibematevideo.ui.InteractiveVideoActivity$fragmentAdapter$1] */
    public InteractiveVideoActivity() {
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        final Lifecycle lifecycle = getLifecycle();
        this.c = new FragmentStateAdapter(supportFragmentManager, lifecycle) { // from class: com.wear.vibematevideo.ui.InteractiveVideoActivity$fragmentAdapter$1
            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) this.a.b.get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.a.b.size();
            }
        };
    }

    public static final void A4(InteractiveVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void B4(InteractiveVideoActivity this$0) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TabLayout.Tab tabAt = this$0.t4().c.getTabAt(1);
        if (tabAt != null) {
            int[] iArr = new int[2];
            tabAt.view.getLocationInWindow(iArr);
            mk3.a.E(this$0, iArr);
        }
    }

    public static final void w4(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i == 0) {
            tab.setText(ah4.e(R.string.tab_title_recommended));
        } else if (i == 1) {
            tab.setText(ah4.e(R.string.interctive_video_menu2));
        } else {
            if (i != 2) {
                return;
            }
            tab.setText(ah4.e(R.string.common_liked));
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle extras;
        super.onCreate(savedInstanceState);
        setContentView(t4().getRoot());
        String string = null;
        ye3.c("interactive video", "into page", null);
        t4().b.setToysAction(new MyActionBar.f() { // from class: dc.rl3
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                InteractiveVideoActivity.A4(this.a, view);
            }
        }, true, this);
        t4().b.n();
        u4();
        v4();
        ll3.E().e0("Interactive video", "open", null, null, null);
        mk3.a.w().clear();
        t4().c.post(new Runnable() { // from class: dc.tl3
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                InteractiveVideoActivity.B4(this.a);
            }
        });
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            string = extras.getString("intoType");
        }
        if (string == null || !Intrinsics.areEqual(string, "1")) {
            return;
        }
        t4().d.setCurrentItem(1, false);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        t4().b.s();
    }

    @NotNull
    public final ActivityInteractiveVideoBinding t4() {
        return (ActivityInteractiveVideoBinding) this.a.getValue();
    }

    public final void u4() {
        this.b.add(new RecommendedFragment());
        this.b.add(new VbPatternFragment());
        this.b.add(new LikedFragment());
        t4().d.setAdapter(this.c);
    }

    public final void v4() {
        new TabLayoutMediator(t4().c, t4().d, new TabLayoutMediator.TabConfigurationStrategy() { // from class: dc.sl3
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                InteractiveVideoActivity.w4(tab, i);
            }
        }).attach();
    }
}
