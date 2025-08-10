package com.wear.ui.discover.gaming;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.epicgames.unreal.SplashActivity;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.game.GamingAdAdapter;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.discover.gaming.GamingActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.recycler.NoScrollRecyclerView;
import dc.ce3;
import dc.h32;
import dc.kf;
import dc.pj3;
import dc.qf3;
import dc.rx3;
import dc.vl2;
import dc.y12;
import dc.ye3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GamingActivity.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000103H\u0002J\b\u00109\u001a\u000207H\u0002J\u0006\u0010:\u001a\u000207J\u0006\u0010;\u001a\u000207J\"\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020'2\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\u0010\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020CH\u0007J\u0012\u0010D\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\b\u0010G\u001a\u000207H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u000e\u00101\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/wear/ui/discover/gaming/GamingActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "actionbar", "Lcom/wear/widget/MyActionBar;", "getActionbar", "()Lcom/wear/widget/MyActionBar;", "setActionbar", "(Lcom/wear/widget/MyActionBar;)V", "btnPlay", "Landroid/widget/TextView;", "getBtnPlay", "()Landroid/widget/TextView;", "setBtnPlay", "(Landroid/widget/TextView;)V", "clAdBanner", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClAdBanner", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setClAdBanner", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "endTime", "", "ivAdBanner", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "getIvAdBanner", "()Landroidx/constraintlayout/utils/widget/ImageFilterView;", "setIvAdBanner", "(Landroidx/constraintlayout/utils/widget/ImageFilterView;)V", "llGaming", "Landroid/widget/LinearLayout;", "getLlGaming", "()Landroid/widget/LinearLayout;", "setLlGaming", "(Landroid/widget/LinearLayout;)V", "position", "", "rvGaming1", "Lcom/wear/widget/recycler/NoScrollRecyclerView;", "getRvGaming1", "()Lcom/wear/widget/recycler/NoScrollRecyclerView;", "setRvGaming1", "(Lcom/wear/widget/recycler/NoScrollRecyclerView;)V", "rvGaming2", "getRvGaming2", "setRvGaming2", "startTime", "uuid", "", "viewModel", "Lcom/wear/ui/discover/gaming/GamingViewModel;", "closeProcess", "", "namePro", "endControl", "initTimer", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "GridSpaceItemDecoration", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GamingActivity extends BaseActivity<vl2> {

    @Nullable
    public Disposable a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public GamingViewModel b;

    @BindView(R.id.btn_play)
    public TextView btnPlay;

    @Nullable
    public String c = "";

    @BindView(R.id.cl_ad_banner)
    public ConstraintLayout clAdBanner;
    public long d;
    public long e;

    @BindView(R.id.iv_ad_banner)
    public ImageFilterView ivAdBanner;

    @BindView(R.id.ll_gaming)
    public LinearLayout llGaming;

    @BindView(R.id.rv_gaming1)
    public NoScrollRecyclerView rvGaming1;

    @BindView(R.id.rv_gaming2)
    public NoScrollRecyclerView rvGaming2;

    /* compiled from: GamingActivity.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/gaming/GamingActivity$GridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "mSpace", "", "(Landroid/content/Context;I)V", "mColumnSpacing", "mRowSpacing", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {

        @NotNull
        public final Context a;
        public final int b;
        public final int c;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.top = this.b;
            outRect.right = this.c;
            if (parent.getChildAdapterPosition(view) % 2 == 0) {
                outRect.left = -ce3.a(this.a, 92.0f);
            } else {
                outRect.left = 0;
            }
        }
    }

    /* compiled from: GamingActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<List<? extends String>, Unit> {
        public a() {
            super(1);
        }

        public final void a(@Nullable List<String> list) {
            if (list != null) {
                GamingActivity gamingActivity = GamingActivity.this;
                GamingAdAdapter gamingAdAdapter = new GamingAdAdapter(CollectionsKt___CollectionsKt.slice((List) list, RangesKt___RangesKt.until(0, list.size() / 2)));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(gamingActivity);
                linearLayoutManager.setOrientation(0);
                gamingActivity.y4().setLayoutManager(linearLayoutManager);
                gamingActivity.y4().setAdapter(gamingAdAdapter);
                gamingActivity.y4().scrollToPosition(gamingAdAdapter.getItemCount() - 1);
                GamingAdAdapter gamingAdAdapter2 = new GamingAdAdapter(CollectionsKt___CollectionsKt.slice((List) list, RangesKt___RangesKt.until(list.size() / 2, list.size())));
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(gamingActivity);
                linearLayoutManager2.setOrientation(0);
                gamingActivity.z4().setLayoutManager(linearLayoutManager2);
                gamingActivity.z4().setAdapter(gamingAdAdapter2);
                gamingActivity.x4().setVisibility(0);
                gamingActivity.A4();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            a(list);
            return Unit.INSTANCE;
        }
    }

    public static final void B4(GamingActivity this$0, Long l) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y4().smoothScrollBy(-ce3.a(this$0, 1.0f), 0);
        this$0.z4().smoothScrollBy(ce3.a(this$0, 1.0f), 0);
    }

    public static final void D4(GamingActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    public static final void E4(GamingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w4().getLayoutParams().height = (int) ((this$0.v4().getWidth() / this$0.w4().getWidth()) * this$0.w4().getHeight());
        this$0.w4().getLayoutParams().width = this$0.v4().getWidth();
        this$0.w4().requestLayout();
        if (this$0.isDestroyed() && this$0.isFinishing()) {
            return;
        }
        kf.z(this$0).t(Integer.valueOf(R.drawable.banner_gaming_projekt_melody)).j0(new rx3(ce3.a(this$0, 20.0f), 0, rx3.b.TOP)).A0(this$0.w4());
    }

    public final void A4() {
        this.a = Observable.interval(50L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.uw2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GamingActivity.B4(this.a, (Long) obj);
            }
        });
    }

    public final void C4() {
        ye3.j("game", "game_exposure", "exposure", "discover_game", "", "game", "", -1L);
        u4().n();
        u4().setToysAction(new MyActionBar.f() { // from class: dc.tw2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                GamingActivity.D4(this.a, view);
            }
        }, true, this);
        w4().post(new Runnable() { // from class: dc.vw2
            @Override // java.lang.Runnable
            public final void run() {
                GamingActivity.E4(this.a);
            }
        });
        if (WearUtils.D) {
            return;
        }
        GamingViewModel gamingViewModel = new GamingViewModel();
        this.b = gamingViewModel;
        if (gamingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            gamingViewModel = null;
        }
        gamingViewModel.a(this, new a());
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.e = jCurrentTimeMillis;
        ye3.j("game", "game_exit_click", "click", "game_exit", "button", "exit", this.c, (jCurrentTimeMillis - this.d) / 1000);
        s4("com.megame.beta");
    }

    @OnClick({R.id.btn_play, R.id.cl_ad_banner})
    public final void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.btn_play) {
            if (id != R.id.cl_ad_banner) {
                return;
            }
            ye3.j("game", "projekt_melody_click", "click", "projekt_melody", "button", "card", "", -1L);
            pj3.f(this, GamingDetailsActivity.class);
            return;
        }
        String string = UUID.randomUUID().toString();
        this.c = string;
        ye3.j("game", "projekt_melody_click", "click", "projekt_melody", "button", "play", string, -1L);
        this.d = System.currentTimeMillis();
        t4();
        h32.i().F(1);
        pj3.o(this, SplashActivity.class, 10086);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        ButterKnife.bind(this);
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        u4().s();
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

    public final void t4() {
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
    public final MyActionBar u4() {
        MyActionBar myActionBar = this.actionbar;
        if (myActionBar != null) {
            return myActionBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("actionbar");
        return null;
    }

    @NotNull
    public final ConstraintLayout v4() {
        ConstraintLayout constraintLayout = this.clAdBanner;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clAdBanner");
        return null;
    }

    @NotNull
    public final ImageFilterView w4() {
        ImageFilterView imageFilterView = this.ivAdBanner;
        if (imageFilterView != null) {
            return imageFilterView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivAdBanner");
        return null;
    }

    @NotNull
    public final LinearLayout x4() {
        LinearLayout linearLayout = this.llGaming;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llGaming");
        return null;
    }

    @NotNull
    public final NoScrollRecyclerView y4() {
        NoScrollRecyclerView noScrollRecyclerView = this.rvGaming1;
        if (noScrollRecyclerView != null) {
            return noScrollRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvGaming1");
        return null;
    }

    @NotNull
    public final NoScrollRecyclerView z4() {
        NoScrollRecyclerView noScrollRecyclerView = this.rvGaming2;
        if (noScrollRecyclerView != null) {
            return noScrollRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvGaming2");
        return null;
    }
}
