package com.wear.ui.discover.gaming;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.epicgames.unreal.SplashActivity;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.NewGalleryList;
import com.wear.databinding.ActivityGalleryListBinding;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.ui.discover.gaming.GalleryListActivity;
import com.wear.ui.discover.gaming.adapter.GalleryListAdapter;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.NewGalleryBottomDialog;
import dc.ah4;
import dc.cs3;
import dc.eg3;
import dc.h32;
import dc.is3;
import dc.pj3;
import dc.t23;
import dc.tg0;
import dc.ug0;
import dc.vg0;
import dc.vl2;
import dc.ye3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryListActivity.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\"\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0012\u00104\u001a\u00020,2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020,H\u0014J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u000206H\u0014J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u000200H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&¨\u0006="}, d2 = {"Lcom/wear/ui/discover/gaming/GalleryListActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "applicationId", "", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "applicationName", "getApplicationName", "setApplicationName", "binding", "Lcom/wear/databinding/ActivityGalleryListBinding;", "galleryListAdapter", "Lcom/wear/ui/discover/gaming/adapter/GalleryListAdapter;", "gameId", "isCreateGameModeFlag", "", "list1", "", "Lcom/wear/bean/NewGalleryList;", "getList1", "()Ljava/util/List;", "setList1", "(Ljava/util/List;)V", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "viewModel", "Lcom/wear/ui/discover/gaming/GamingViewModel;", "getViewModel", "()Lcom/wear/ui/discover/gaming/GamingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCustomActionBarBounds", "Landroid/graphics/Rect;", "initData", "", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSaveInstanceState", "outState", "showLoginDialog", "resId", "StrokeGradientLRDrawable", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GalleryListActivity extends BaseActivity<vl2> {
    public GalleryListAdapter a;
    public ActivityGalleryListBinding b;
    public boolean f;

    @Nullable
    public vg0 g;
    public long h;

    @NotNull
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GamingViewModel.class), new d(this), new c(this), new e(null, this));

    @NotNull
    public String d = "dcc4b002111b412c975028851e07ed30";

    @NotNull
    public List<NewGalleryList> e = new ArrayList();

    @NotNull
    public String i = "";

    @NotNull
    public String j = "";

    /* compiled from: GalleryListActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/gaming/GalleryListActivity$initData$2", "Lcom/wear/ui/discover/gaming/adapter/GalleryListAdapter$OnItemClickListener;", "itemClick", "", "item", "Lcom/wear/bean/NewGalleryList;", "position", "", "playClick", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements GalleryListAdapter.a {
        public a() {
        }

        @Override // com.wear.ui.discover.gaming.adapter.GalleryListAdapter.a
        public void a(@NotNull NewGalleryList item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            Bundle bundle = new Bundle();
            bundle.putSerializable("galleryDetails", item);
            pj3.g(GalleryListActivity.this, NewGamingDetailsActivity.class, bundle);
        }

        @Override // com.wear.ui.discover.gaming.adapter.GalleryListAdapter.a
        public void b(@NotNull NewGalleryList item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (MyApplication.Z) {
                GalleryListActivity.this.H4(R.string.common_login_first);
                return;
            }
            String lowerCase = null;
            if (Intrinsics.areEqual(item.getApplicationId(), GalleryListActivity.this.d)) {
                h32.i().F(1);
                GalleryListActivity.this.f = true;
                pj3.o(GalleryListActivity.this, SplashActivity.class, 10086);
            } else {
                t23.a aVar = t23.a;
                String applicationUrl = item.getApplicationUrl();
                String str = applicationUrl == null ? "" : applicationUrl;
                String applicationId = item.getApplicationId();
                String str2 = applicationId == null ? "" : applicationId;
                String xremoteApiVersion = item.getXremoteApiVersion();
                String str3 = xremoteApiVersion == null ? "" : xremoteApiVersion;
                String applicationVersion = item.getApplicationVersion();
                String str4 = applicationVersion == null ? "" : applicationVersion;
                String applicationName = item.getApplicationName();
                String str5 = applicationName == null ? "" : applicationName;
                List<String> xremoteAllowDomainList = item.getXremoteAllowDomainList();
                if (xremoteAllowDomainList == null) {
                    xremoteAllowDomainList = CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList<String> arrayList = xremoteAllowDomainList instanceof ArrayList ? (ArrayList) xremoteAllowDomainList : null;
                String applicationLogoUrl = item.getApplicationLogoUrl();
                Bundle bundleB = aVar.b(str, str2, str4, str3, str5, arrayList, applicationLogoUrl == null ? "" : applicationLogoUrl);
                if (bundleB != null) {
                    pj3.p(GalleryListActivity.this, XRemoteActivity.class, 10086, bundleB);
                }
            }
            GalleryListActivity galleryListActivity = GalleryListActivity.this;
            String applicationId2 = item.getApplicationId();
            if (applicationId2 == null) {
                applicationId2 = "";
            }
            galleryListActivity.E4(applicationId2);
            GalleryListActivity galleryListActivity2 = GalleryListActivity.this;
            String applicationName2 = item.getApplicationName();
            galleryListActivity2.F4(applicationName2 != null ? applicationName2 : "");
            GalleryListActivity.this.G4(System.currentTimeMillis());
            String applicationId3 = item.getApplicationId();
            String applicationName3 = item.getApplicationName();
            if (applicationName3 != null) {
                lowerCase = applicationName3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            ye3.j("game", "game_open_click", "click", applicationId3, "", "1", lowerCase, -1L);
        }
    }

    /* compiled from: GalleryListActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/wear/ui/discover/gaming/GalleryListActivity$initView$2", "Lcom/wear/widget/NewGalleryBottomDialog$ClickListener;", "doCancel", "", "doConfirm", "name", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements NewGalleryBottomDialog.a {
        @Override // com.wear.widget.NewGalleryBottomDialog.a
        public void a(@Nullable String str) {
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

    public static final void A4(GalleryListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, NewToyActivity.class);
    }

    public static final void I4(GalleryListActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.t(this$0, LoginActivity.class, 2);
    }

    public static final void y4(GalleryListActivity this$0, List it) {
        GalleryListAdapter galleryListAdapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ArrayList arrayList = new ArrayList();
        for (Object obj : it) {
            if (Intrinsics.areEqual(((NewGalleryList) obj).getApplicationId(), this$0.d)) {
                arrayList.add(obj);
            }
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (WearUtils.u1() && WearUtils.v1()) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            it.removeAll(arrayList);
        }
        if (!this$0.e.isEmpty()) {
            this$0.e.clear();
        }
        this$0.e.addAll(it);
        GalleryListAdapter galleryListAdapter2 = null;
        View footView = LayoutInflater.from(this$0).inflate(R.layout.view_more_app_data, (ViewGroup) null);
        GalleryListAdapter galleryListAdapter3 = this$0.a;
        if (galleryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
            galleryListAdapter3 = null;
        }
        galleryListAdapter3.p0();
        GalleryListAdapter galleryListAdapter4 = this$0.a;
        if (galleryListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
            galleryListAdapter = null;
        } else {
            galleryListAdapter = galleryListAdapter4;
        }
        Intrinsics.checkNotNullExpressionValue(footView, "footView");
        BaseQuickAdapter.u(galleryListAdapter, footView, 0, 0, 6, null);
        GalleryListAdapter galleryListAdapter5 = this$0.a;
        if (galleryListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
        } else {
            galleryListAdapter2 = galleryListAdapter5;
        }
        galleryListAdapter2.notifyDataSetChanged();
        vg0 vg0Var = this$0.g;
        if (vg0Var != null) {
            vg0Var.a();
        }
    }

    public final void E4(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void F4(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void G4(long j) {
        this.h = j;
    }

    public final void H4(int i) {
        cs3.c(this, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.sw2
            @Override // dc.is3.d
            public final void doConfirm() {
                GalleryListActivity.I4(this.a);
            }
        }).show();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.i;
        String lowerCase = this.j.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        ye3.j("game", "game_exit_click", "click", str, "button", "", lowerCase, (jCurrentTimeMillis - this.h) / 1000);
        if (this.f) {
            h32.i().F(0);
            this.f = false;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(savedInstanceState);
        ActivityGalleryListBinding activityGalleryListBindingC = ActivityGalleryListBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityGalleryListBindingC, "inflate(layoutInflater)");
        this.b = activityGalleryListBindingC;
        if (activityGalleryListBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBindingC = null;
        }
        setContentView(activityGalleryListBindingC.getRoot());
        ye3.c("app gallery", "into page", null);
        w4().d(this);
        z4();
        x4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityGalleryListBinding activityGalleryListBinding = this.b;
        if (activityGalleryListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding = null;
        }
        activityGalleryListBinding.b.s();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("background", getResources().getIdentifier("background_name", "drawable", getPackageName()));
    }

    public final Rect v4() {
        ActivityGalleryListBinding activityGalleryListBinding = this.b;
        if (activityGalleryListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding = null;
        }
        MyActionBar myActionBar = activityGalleryListBinding.b;
        Intrinsics.checkNotNullExpressionValue(myActionBar, "binding.actionbar");
        Rect rect = new Rect();
        myActionBar.getGlobalVisibleRect(rect);
        return rect;
    }

    public final GamingViewModel w4() {
        return (GamingViewModel) this.c.getValue();
    }

    public final void x4() {
        w4().c().observe(this, new Observer() { // from class: dc.rw2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GalleryListActivity.y4(this.a, (List) obj);
            }
        });
        GalleryListAdapter galleryListAdapter = this.a;
        if (galleryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
            galleryListAdapter = null;
        }
        galleryListAdapter.N0(new a());
    }

    public final void z4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a = new GalleryListAdapter(this.e);
        ActivityGalleryListBinding activityGalleryListBinding = this.b;
        GalleryListAdapter galleryListAdapter = null;
        if (activityGalleryListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding = null;
        }
        RecyclerView recyclerView = activityGalleryListBinding.c;
        GalleryListAdapter galleryListAdapter2 = this.a;
        if (galleryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
            galleryListAdapter2 = null;
        }
        recyclerView.setAdapter(galleryListAdapter2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (!eg3.d(this, "show_gallery", false)) {
            new NewGalleryBottomDialog(this, R.layout.dialog_welcom, 2, v4(), new b()).show();
            ye3.i("game", "game_welcome_popup_exposure", "exposure", "game_welcome_popup", "popup");
            eg3.j(this, "show_gallery", true);
        }
        ActivityGalleryListBinding activityGalleryListBinding2 = this.b;
        if (activityGalleryListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding2 = null;
        }
        activityGalleryListBinding2.b.setToysAction(new MyActionBar.f() { // from class: dc.qw2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                GalleryListActivity.A4(this.a, view);
            }
        }, false, this);
        ActivityGalleryListBinding activityGalleryListBinding3 = this.b;
        if (activityGalleryListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding3 = null;
        }
        activityGalleryListBinding3.b.n();
        ActivityGalleryListBinding activityGalleryListBinding4 = this.b;
        if (activityGalleryListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGalleryListBinding4 = null;
        }
        tg0.b bVarA = ug0.a(activityGalleryListBinding4.c);
        GalleryListAdapter galleryListAdapter3 = this.a;
        if (galleryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryListAdapter");
        } else {
            galleryListAdapter = galleryListAdapter3;
        }
        bVarA.j(galleryListAdapter);
        bVarA.p(false);
        bVarA.k(5);
        bVarA.n(true);
        bVarA.m(1000);
        bVarA.l(10);
        bVarA.o(R.layout.item_gallery_loading);
        this.g = bVarA.q();
    }
}
