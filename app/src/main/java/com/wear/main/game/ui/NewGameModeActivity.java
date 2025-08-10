package com.wear.main.game.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.BaseBindActivity;
import com.wear.adapter.GameModeToyAdapter;
import com.wear.bean.GameModeToysBean;
import com.wear.bean.SetLanInfoEvent;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.event.GameModeAcceptConnectEvent;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.databinding.ActivityNewGameModeBinding;
import com.wear.main.game.ui.NewGameModeActivity;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.GameModeIntroduceDialog;
import com.wear.widget.dialog.GameModeWelcomeDialog;
import dc.ah4;
import dc.h32;
import dc.ke3;
import dc.pj3;
import dc.t32;
import dc.th4;
import dc.xc1;
import dc.ye3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewGameModeActivity.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001eH\u0007J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010!H\u0007J\u0012\u0010 \u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u0007J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/wear/main/game/ui/NewGameModeActivity;", "Lcom/wear/BaseBindActivity;", "Lcom/wear/databinding/ActivityNewGameModeBinding;", "()V", "acceptGameName", "", "acceptLogFlag", "", "controlGameBean", "Lcom/wear/main/game/network/ToyCtrlGameModeImpl$GameBean;", "gameModeToyAdapter", "Lcom/wear/adapter/GameModeToyAdapter;", "viewModel", "Lcom/wear/main/game/ui/NewGameVideModel;", "getViewModel", "()Lcom/wear/main/game/ui/NewGameVideModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCustomActionBarBounds", "Landroid/graphics/Rect;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMessage", "event", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "Lcom/wear/bean/SetLanInfoEvent;", "Lcom/wear/bean/event/ToyCtrlGameEvent;", "onMessageEvent", "Lcom/wear/bean/ToySelectEvent;", "Lcom/wear/bean/event/GameModeAcceptConnectEvent;", "setListener", "showGameModeIntroducePop", "showWelcomePop", "DividerItemDecoration", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewGameModeActivity extends BaseBindActivity<ActivityNewGameModeBinding> {

    @NotNull
    public final Lazy f;
    public GameModeToyAdapter g;

    @Nullable
    public t32.c h;
    public boolean i;

    @Nullable
    public String j;

    /* compiled from: NewGameModeActivity.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/main/game/ui/NewGameModeActivity$DividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "dividerResId", "", "(Landroid/content/Context;I)V", "divider", "Landroid/graphics/drawable/Drawable;", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends RecyclerView.ItemDecoration {
        public final int a;

        @Nullable
        public final Drawable b;

        public a(@NotNull Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = i;
            this.b = th4.d(context, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildCount() == 1) {
                return;
            }
            int childCount = parent.getChildCount() - 1;
            for (int i = 0; i < childCount; i++) {
                View childAt = parent.getChildAt(i);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
                Drawable drawable = this.b;
                int intrinsicHeight = (drawable != null ? drawable.getIntrinsicHeight() : 0) + bottom;
                Drawable drawable2 = this.b;
                if (drawable2 != null) {
                    drawable2.setBounds(0, bottom, parent.getWidth(), intrinsicHeight);
                }
                Drawable drawable3 = this.b;
                if (drawable3 != null) {
                    drawable3.draw(c);
                }
            }
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
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
    public static final class c extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
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
    public static final class d extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0, ComponentActivity componentActivity) {
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

    public NewGameModeActivity() {
        super(R.layout.activity_new_game_mode, 27);
        this.f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewGameVideModel.class), new c(this), new b(this), new d(null, this));
        this.j = "Unknown";
    }

    public static final void C4(NewGameModeActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.v4().c.setVisibility(0);
            this$0.v4().f.setVisibility(0);
            this$0.v4().h.setVisibility(0);
        } else {
            this$0.v4().c.setVisibility(8);
            this$0.v4().s.setText("");
            this$0.v4().t.setText("");
            this$0.v4().u.setText("");
            this$0.v4().f.setVisibility(8);
            this$0.v4().m.setText(ah4.e(R.string.games_control_toys4));
            this$0.v4().m.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_disable));
            this$0.i = false;
            this$0.j = "Unknown";
            this$0.v4().q.setText(ah4.e(R.string.games_control_toys4));
            this$0.v4().q.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_disable));
            this$0.v4().h.setVisibility(8);
            this$0.v4().q.setVisibility(0);
            this$0.v4().b.setVisibility(8);
            this$0.h = null;
        }
        ye3.j("Game Mode", "game_mode_enable_lan_click", "click", "game_mode_enable_lan", "button", it.booleanValue() ? "1" : "0", "", -1L);
    }

    public static final void D4(NewGameModeActivity this$0, List it) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean zIsEmpty = it.isEmpty();
        int i = R.drawable.icon_game_mode_control_disable;
        int i2 = R.color.game_mode_card_content_text_color_disable;
        int i3 = R.color.game_mode_card_title_text_color_disable;
        GameModeToyAdapter gameModeToyAdapter = null;
        if (zIsEmpty) {
            this$0.v4().o.setVisibility(0);
            this$0.v4().n.setTextColor(th4.b(this$0, R.color.game_mode_card_title_text_color_disable));
            this$0.v4().l.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_disable));
            this$0.v4().d.setImageResource(R.drawable.icon_game_mode_accept_control_disable);
            this$0.v4().g.setVisibility(8);
            this$0.v4().r.setTextColor(th4.b(this$0, R.color.game_mode_card_title_text_color_disable));
            this$0.v4().p.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_disable));
            this$0.v4().e.setImageResource(R.drawable.icon_game_mode_control_disable);
            this$0.v4().i.setVisibility(8);
            GameModeToyAdapter gameModeToyAdapter2 = this$0.g;
            if (gameModeToyAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
                gameModeToyAdapter2 = null;
            }
            gameModeToyAdapter2.K().clear();
            GameModeToyAdapter gameModeToyAdapter3 = this$0.g;
            if (gameModeToyAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
            } else {
                gameModeToyAdapter = gameModeToyAdapter3;
            }
            gameModeToyAdapter.notifyDataSetChanged();
            return;
        }
        this$0.v4().o.setVisibility(8);
        this$0.v4().c.setVisibility(0);
        this$0.v4().k.setChecked(true);
        this$0.v4().k.setClickable(true);
        this$0.v4().f.setVisibility(0);
        this$0.v4().g.setVisibility(0);
        this$0.v4().n.setTextColor(th4.b(this$0, R.color.game_mode_card_title_text_color_enable));
        this$0.v4().l.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_enable));
        this$0.v4().d.setImageResource(R.drawable.icon_game_mode_accept_control_enable);
        this$0.v4().h.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ArrayList arrayList = new ArrayList();
        for (Object obj : it) {
            if (((Toy) obj).isFeedbackModeEnableAndUpdateEnable() != -1) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            this$0.v4().r.setTextColor(th4.b(this$0, R.color.game_mode_card_title_text_color_disable));
            this$0.v4().p.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_disable));
            this$0.v4().e.setImageResource(R.drawable.icon_game_mode_control_disable);
            this$0.v4().i.setVisibility(8);
            this$0.v4().q.setVisibility(8);
            this$0.v4().b.setVisibility(8);
            this$0.v4().j.setVisibility(8);
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                next = it2.next();
                if (((Toy) next).isFeedbackModeEnableAndUpdateEnable() == 0) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        Toy toy = (Toy) next;
        TextView textView = this$0.v4().r;
        if (toy != null) {
            i3 = R.color.game_mode_card_title_text_color_enable;
        }
        textView.setTextColor(th4.b(this$0, i3));
        TextView textView2 = this$0.v4().p;
        if (toy != null) {
            i2 = R.color.game_mode_card_content_text_color_enable;
        }
        textView2.setTextColor(th4.b(this$0, i2));
        ImageView imageView = this$0.v4().e;
        if (toy != null) {
            i = R.drawable.icon_game_mode_control_enable;
        }
        imageView.setImageResource(i);
        this$0.v4().i.setVisibility(0);
        this$0.v4().q.setVisibility((toy == null || this$0.h != null) ? 8 : 0);
        this$0.v4().b.setVisibility(this$0.h == null ? 8 : 0);
        this$0.v4().x.setVisibility(this$0.v4().q.getVisibility() == 0 || this$0.v4().b.getVisibility() == 0 ? 0 : 8);
        this$0.v4().j.setVisibility(0);
        GameModeToyAdapter gameModeToyAdapter4 = this$0.g;
        if (gameModeToyAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
            gameModeToyAdapter4 = null;
        }
        gameModeToyAdapter4.K().clear();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((Toy) obj2).isFeedbackModeEnableAndUpdateEnable() == 0) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((Toy) obj3).isFeedbackModeEnableAndUpdateEnable() == 1) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : arrayList) {
            if (((Toy) obj4).isFeedbackModeEnableAndUpdateEnable() == 2) {
                arrayList4.add(obj4);
            }
        }
        if (!arrayList2.isEmpty()) {
            GameModeToysBean gameModeToysBean = new GameModeToysBean(0, arrayList2);
            GameModeToyAdapter gameModeToyAdapter5 = this$0.g;
            if (gameModeToyAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
                gameModeToyAdapter5 = null;
            }
            gameModeToyAdapter5.K().add(gameModeToysBean);
        }
        if (!arrayList3.isEmpty()) {
            GameModeToysBean gameModeToysBean2 = new GameModeToysBean(1, arrayList3);
            GameModeToyAdapter gameModeToyAdapter6 = this$0.g;
            if (gameModeToyAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
                gameModeToyAdapter6 = null;
            }
            gameModeToyAdapter6.K().add(gameModeToysBean2);
        }
        if (!arrayList4.isEmpty()) {
            GameModeToysBean gameModeToysBean3 = new GameModeToysBean(2, arrayList4);
            GameModeToyAdapter gameModeToyAdapter7 = this$0.g;
            if (gameModeToyAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
            } else {
                gameModeToyAdapter = gameModeToyAdapter7;
            }
            gameModeToyAdapter.K().add(gameModeToysBean3);
        }
        RecyclerView.Adapter adapter = this$0.v4().j.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public static final void E4(NewGameModeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, NewToyActivity.class);
    }

    public static final void F4(NewGameModeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R4();
    }

    public static final void G4(NewGameModeActivity this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.t4().e();
        } else {
            this$0.t4().f();
        }
    }

    public static final void P4(final NewGameModeActivity this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.runOnMainThread(new Runnable() { // from class: dc.b42
            @Override // java.lang.Runnable
            public final void run() {
                NewGameModeActivity.Q4(this.a, str);
            }
        });
    }

    public static final void Q4(NewGameModeActivity this$0, String name) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.i || !TextUtils.equals(name, this$0.j)) {
            this$0.i = true;
            this$0.j = name;
            String strE = WearUtils.E();
            if (name == null || name.length() == 0) {
                str = "Unknown";
            } else {
                Intrinsics.checkNotNullExpressionValue(name, "name");
                str = name;
            }
            ye3.j("Game Mode", "game_mode_control_from_third_party_success", "connect", strE, "", str, "", -1L);
        }
        TextView textView = this$0.v4().m;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE2 = ah4.e(R.string.games_control_toys3);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.games_control_toys3)");
        Object[] objArr = new Object[1];
        if (name == null || name.length() == 0) {
            name = "Unknown";
        } else {
            Intrinsics.checkNotNullExpressionValue(name, "name");
        }
        objArr[0] = name;
        String str2 = String.format(strE2, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        textView.setText(str2);
        this$0.v4().m.setTextColor(th4.b(this$0, R.color.game_mode_card_content_text_color_enable));
    }

    @NotNull
    public final Rect A4() {
        MyActionBar myActionBar = v4().a;
        Intrinsics.checkNotNullExpressionValue(myActionBar, "dataBinding.actionbar");
        Rect rect = new Rect();
        myActionBar.getGlobalVisibleRect(rect);
        return rect;
    }

    @Override // com.wear.BaseViewModelActivity
    @NotNull
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public NewGameVideModel t4() {
        return (NewGameVideModel) this.f.getValue();
    }

    public final void O4() {
        h32.i().A(new h32.e() { // from class: dc.x32
            @Override // dc.h32.e
            public final void a(String str) {
                NewGameModeActivity.P4(this.a, str);
            }
        });
    }

    public final void R4() {
        new GameModeIntroduceDialog(this, A4()).show();
    }

    public final void S4() {
        if (ke3.a("new_user", "game_mode")) {
            new GameModeWelcomeDialog(this, A4()).show();
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
        ye3.c("game mode", "into page", null);
        O4();
        t4().c();
        EventBus.getDefault().register(this);
        S4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        v4().a.s();
        EventBus.getDefault().unregister(this);
        t4().f();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@Nullable xc1 xc1Var) {
        t4().c();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable ToySelectEvent event) {
        t4().c();
    }

    @Override // com.wear.BaseBindActivity
    public void w4() {
        t4().b().observe(this, new Observer() { // from class: dc.z32
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewGameModeActivity.D4(this.a, (List) obj);
            }
        });
        t4().d().observe(this, new Observer() { // from class: dc.w32
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewGameModeActivity.C4(this.a, (Boolean) obj);
            }
        });
    }

    @Override // com.wear.BaseBindActivity
    public void x4() {
        v4().a.setToysActionRemote(new MyActionBar.f() { // from class: dc.v32
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                NewGameModeActivity.E4(this.a, view);
            }
        }, new MyActionBar.f() { // from class: dc.y32
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                NewGameModeActivity.F4(this.a, view);
            }
        }, R.drawable.icon_guide, false, this);
        v4().a.n();
        v4().k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.a42
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NewGameModeActivity.G4(this.a, compoundButton, z);
            }
        });
        GameModeToyAdapter gameModeToyAdapter = new GameModeToyAdapter();
        this.g = gameModeToyAdapter;
        GameModeToyAdapter gameModeToyAdapter2 = null;
        if (gameModeToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
            gameModeToyAdapter = null;
        }
        gameModeToyAdapter.r0(new ArrayList());
        RecyclerView recyclerView = v4().j;
        GameModeToyAdapter gameModeToyAdapter3 = this.g;
        if (gameModeToyAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameModeToyAdapter");
        } else {
            gameModeToyAdapter2 = gameModeToyAdapter3;
        }
        recyclerView.setAdapter(gameModeToyAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new a(context, R.drawable.game_mode_divider));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@NotNull SetLanInfoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        v4().s.setText(event.getLocalIp());
        v4().t.setText(event.getHttpPort());
        v4().u.setText(event.getSslPort());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable GameModeAcceptConnectEvent event) {
        if (v4().q.getVisibility() == 0) {
            v4().q.setText(ah4.e(R.string.toy_control_game_waiting));
            v4().q.setTextColor(th4.b(this, R.color.game_mode_card_title_text_color_enable));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@NotNull ToyCtrlGameEvent event) {
        MyApplication myApplication;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.type == 20) {
            ArrayList<t32.c> beanList = h32.i().h();
            Intrinsics.checkNotNullExpressionValue(beanList, "beanList");
            boolean z = !beanList.isEmpty();
            int i = R.string.not_connect;
            int i2 = R.drawable.bg_game_mode_game_tip_disconnect;
            if (z) {
                t32.c cVar = beanList.get(0);
                this.h = cVar;
                if (cVar != null) {
                    v4().q.setVisibility(8);
                    v4().b.setVisibility(0);
                    v4().v.setText(cVar.a);
                    boolean z2 = !TextUtils.isEmpty(cVar.a);
                    v4().v.setText(cVar.a);
                    View view = v4().y;
                    if (z2) {
                        i2 = R.drawable.bg_game_mode_game_tip_connected;
                    }
                    view.setBackgroundResource(i2);
                    TextView textView = v4().w;
                    if (z2) {
                        myApplication = WearUtils.x;
                        i = R.string.toy_connected;
                    } else {
                        myApplication = WearUtils.x;
                    }
                    textView.setText(myApplication.getString(i));
                    return;
                }
                return;
            }
            if (v4().b.getVisibility() == 0) {
                v4().y.setBackgroundResource(R.drawable.bg_game_mode_game_tip_disconnect);
                v4().w.setText(WearUtils.x.getString(R.string.not_connect));
            }
        }
    }
}
