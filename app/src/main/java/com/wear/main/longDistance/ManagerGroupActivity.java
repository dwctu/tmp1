package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.activity.ComponentActivity;
import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.GroupMemberAdmin;
import com.wear.bean.GroupMemberHeader;
import com.wear.bean.GroupMemberRequest;
import com.wear.bean.IGroupMember;
import com.wear.bean.ManagerGroupStatus;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.event.GroupInvitationEvent;
import com.wear.bean.event.GroupInvitationSettingEvent;
import com.wear.bean.event.GroupNameChangeEvent;
import com.wear.databinding.ActivityManagerGroupBinding;
import com.wear.main.longDistance.ManagerGroupActivity;
import com.wear.main.longDistance.adapter.ManagerGroupMemberAdapter;
import com.wear.main.longDistance.viewmodel.ManagerGroupViewModel;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.ch3;
import dc.cr;
import dc.cs3;
import dc.is3;
import dc.o44;
import dc.pj3;
import dc.u34;
import dc.uy3;
import dc.vl2;
import dc.wz3;
import dc.zq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.apache.commons.codec.net.RFC1522Codec;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ManagerGroupActivity.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00019B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\"\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u000fH\u0014J(\u0010%\u001a\u00020\u000f2\u000e\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dH\u0016J(\u0010+\u001a\u00020,2\u000e\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dH\u0016J\u0012\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0007J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u000200H\u0007J\u0012\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u000101H\u0007J\u0012\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u000102H\u0007J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006:"}, d2 = {"Lcom/wear/main/longDistance/ManagerGroupActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "()V", "binding", "Lcom/wear/databinding/ActivityManagerGroupBinding;", "viewModel", "Lcom/wear/main/longDistance/viewmodel/ManagerGroupViewModel;", "getViewModel", "()Lcom/wear/main/longDistance/viewmodel/ManagerGroupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handlerGroupCheckChange", "", "it", "Lcom/wear/bean/ManagerGroupStatus$GroupCheckChange;", "handlerOperateGroupMember", "status", "Lcom/wear/bean/ManagerGroupStatus$OperateGroupMember;", "initData", "initListener", "initRecyclerView", "initSwitchButton", "initToolbar", "intentCreateChatRoomActivityForResult", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onItemLongClick", "", "onMessageEvent", "event", "Lcom/wear/bean/event/FinishChatPageEvent;", "Lcom/wear/bean/event/GroupInvitationEvent;", "Lcom/wear/bean/event/GroupInvitationSettingEvent;", "Lcom/wear/bean/event/GroupNameChangeEvent;", "showRemoveAdminDialog", "item", "Lcom/wear/bean/GroupMemberAdmin;", "updateToolbarName", MessageBundle.TITLE_ENTRY, "", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ManagerGroupActivity extends BaseActivity<vl2> implements cr, zq {

    @NotNull
    public static final a c = new a(null);
    public ActivityManagerGroupBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ManagerGroupViewModel.class), new d(this), new c(this), new e(null, this));

    /* compiled from: ManagerGroupActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/wear/main/longDistance/ManagerGroupActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "roomId", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String roomId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intent intent = new Intent(context, (Class<?>) ManagerGroupActivity.class);
            intent.putExtra("roomId", roomId);
            context.startActivity(intent);
        }
    }

    /* compiled from: ManagerGroupActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.ManagerGroupActivity$initData$1", f = "ManagerGroupActivity.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: ManagerGroupActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "status", "Lcom/wear/bean/ManagerGroupStatus;", "emit", "(Lcom/wear/bean/ManagerGroupStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34 {
            public final /* synthetic */ ManagerGroupActivity a;

            public a(ManagerGroupActivity managerGroupActivity) {
                this.a = managerGroupActivity;
            }

            @Override // dc.u34
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull ManagerGroupStatus managerGroupStatus, @NotNull Continuation<? super Unit> continuation) {
                if (managerGroupStatus instanceof ManagerGroupStatus.GroupCheckChange) {
                    this.a.x4((ManagerGroupStatus.GroupCheckChange) managerGroupStatus);
                } else {
                    ActivityManagerGroupBinding activityManagerGroupBinding = null;
                    if (managerGroupStatus instanceof ManagerGroupStatus.GroupMemberList) {
                        ActivityManagerGroupBinding activityManagerGroupBinding2 = this.a.a;
                        if (activityManagerGroupBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityManagerGroupBinding = activityManagerGroupBinding2;
                        }
                        RecyclerView.Adapter adapter = activityManagerGroupBinding.e.getAdapter();
                        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.main.longDistance.adapter.ManagerGroupMemberAdapter");
                        ((ManagerGroupMemberAdapter) adapter).y0(((ManagerGroupStatus.GroupMemberList) managerGroupStatus).getList());
                    } else if (managerGroupStatus instanceof ManagerGroupStatus.RemoveAdmin) {
                        ActivityManagerGroupBinding activityManagerGroupBinding3 = this.a.a;
                        if (activityManagerGroupBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityManagerGroupBinding = activityManagerGroupBinding3;
                        }
                        RecyclerView.Adapter adapter2 = activityManagerGroupBinding.e.getAdapter();
                        Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.wear.main.longDistance.adapter.ManagerGroupMemberAdapter");
                        ((ManagerGroupMemberAdapter) adapter2).o0(((ManagerGroupStatus.RemoveAdmin) managerGroupStatus).getItem());
                    } else if (managerGroupStatus instanceof ManagerGroupStatus.OperateGroupMember) {
                        this.a.y4((ManagerGroupStatus.OperateGroupMember) managerGroupStatus);
                    } else {
                        Intrinsics.areEqual(managerGroupStatus, ManagerGroupStatus.Init.INSTANCE);
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ManagerGroupActivity.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o44<ManagerGroupStatus> o44VarJ = ManagerGroupActivity.this.w4().j();
                a aVar = new a(ManagerGroupActivity.this);
                this.label = 1;
                if (o44VarJ.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
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

    public static final void B4(ManagerGroupActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H4();
    }

    public static final void E4(ManagerGroupActivity this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w4().r(0, z);
    }

    public static final void F4(ManagerGroupActivity this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w4().r(1, z);
    }

    public static final void N4(ManagerGroupActivity this$0, GroupMemberAdmin item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.w4().o(item);
    }

    public final void A4() {
        EventBus.getDefault().register(this);
        ActivityManagerGroupBinding activityManagerGroupBinding = this.a;
        if (activityManagerGroupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding = null;
        }
        activityManagerGroupBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.y72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManagerGroupActivity.B4(this.a, view);
            }
        });
    }

    public final void C4() {
        ActivityManagerGroupBinding activityManagerGroupBinding = this.a;
        if (activityManagerGroupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding = null;
        }
        RecyclerView recyclerView = activityManagerGroupBinding.e;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ManagerGroupMemberAdapter managerGroupMemberAdapter = new ManagerGroupMemberAdapter();
        managerGroupMemberAdapter.G0(this);
        managerGroupMemberAdapter.n(R.id.btn_user_reject, R.id.btn_user_accept);
        managerGroupMemberAdapter.A0(this);
        recyclerView.setAdapter(managerGroupMemberAdapter);
    }

    public final void D4() {
        ActivityManagerGroupBinding activityManagerGroupBinding = this.a;
        ActivityManagerGroupBinding activityManagerGroupBinding2 = null;
        if (activityManagerGroupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding = null;
        }
        SwitchView switchView = activityManagerGroupBinding.h;
        switchView.setCheckedImmediatelyNoEvent(true);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.x72
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ManagerGroupActivity.E4(this.a, compoundButton, z);
            }
        });
        ActivityManagerGroupBinding activityManagerGroupBinding3 = this.a;
        if (activityManagerGroupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityManagerGroupBinding2 = activityManagerGroupBinding3;
        }
        SwitchView switchView2 = activityManagerGroupBinding2.g;
        switchView2.setCheckedImmediatelyNoEvent(true);
        switchView2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.z72
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ManagerGroupActivity.F4(this.a, compoundButton, z);
            }
        });
    }

    public final void G4() {
        String strE = ah4.e(R.string.group_chat_manage_group);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.group_chat_manage_group)");
        O4(strE);
    }

    public final void H4() {
        pj3.p(this, CreateChatRoomActivity.class, 18, BundleKt.bundleOf(TuplesKt.to("flag", 2), TuplesKt.to("roomId", w4().i().getValue())));
    }

    @Override // dc.cr
    public boolean J0(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = adapter.getItem(i);
        if (item == null) {
            return false;
        }
        if (!(item instanceof GroupMemberAdmin)) {
            return true;
        }
        M4((GroupMemberAdmin) item);
        return true;
    }

    public final void M4(final GroupMemberAdmin groupMemberAdmin) {
        if (Intrinsics.areEqual(groupMemberAdmin.getId(), ch3.n().r())) {
            return;
        }
        cs3.a(this, ah4.e(R.string.group_chat_dismiss_admin) + RFC1522Codec.SEP, new is3.d() { // from class: dc.a82
            @Override // dc.is3.d
            public final void doConfirm() {
                ManagerGroupActivity.N4(this.a, groupMemberAdmin);
            }
        }).show();
    }

    @Override // dc.zq
    public void O1(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = adapter.getItem(i);
        if (item != null && (item instanceof GroupMemberRequest)) {
            int id = view.getId();
            if (id == R.id.btn_user_accept) {
                w4().a((GroupMemberRequest) item);
            } else {
                if (id != R.id.btn_user_reject) {
                    return;
                }
                w4().n((GroupMemberRequest) item);
            }
        }
    }

    public final void O4(String str) {
        ActivityManagerGroupBinding activityManagerGroupBinding = this.a;
        if (activityManagerGroupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding = null;
        }
        activityManagerGroupBinding.b.setTitle(str);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 18 && resultCode == -1) {
            w4().p();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManagerGroupBinding activityManagerGroupBindingC = ActivityManagerGroupBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityManagerGroupBindingC, "inflate(layoutInflater)");
        this.a = activityManagerGroupBindingC;
        if (activityManagerGroupBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBindingC = null;
        }
        setContentView(activityManagerGroupBindingC.getRoot());
        G4();
        D4();
        C4();
        A4();
        z4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull GroupInvitationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (w4().m(event.roomId)) {
            w4().p();
        }
    }

    public final ManagerGroupViewModel w4() {
        return (ManagerGroupViewModel) this.b.getValue();
    }

    public final void x4(ManagerGroupStatus.GroupCheckChange groupCheckChange) {
        ActivityManagerGroupBinding activityManagerGroupBinding = null;
        if (groupCheckChange.getMode() != 0) {
            if (groupCheckChange.getMode() == 1) {
                ActivityManagerGroupBinding activityManagerGroupBinding2 = this.a;
                if (activityManagerGroupBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityManagerGroupBinding = activityManagerGroupBinding2;
                }
                activityManagerGroupBinding.g.setCheckedImmediatelyNoEvent(groupCheckChange.getIsChecked());
                return;
            }
            return;
        }
        ActivityManagerGroupBinding activityManagerGroupBinding3 = this.a;
        if (activityManagerGroupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding3 = null;
        }
        activityManagerGroupBinding3.h.setCheckedImmediatelyNoEvent(groupCheckChange.getIsChecked());
        int i = groupCheckChange.getIsChecked() ? 0 : 8;
        ActivityManagerGroupBinding activityManagerGroupBinding4 = this.a;
        if (activityManagerGroupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding4 = null;
        }
        activityManagerGroupBinding4.i.setVisibility(i);
        ActivityManagerGroupBinding activityManagerGroupBinding5 = this.a;
        if (activityManagerGroupBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding5 = null;
        }
        activityManagerGroupBinding5.f.setVisibility(i);
        ActivityManagerGroupBinding activityManagerGroupBinding6 = this.a;
        if (activityManagerGroupBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityManagerGroupBinding = activityManagerGroupBinding6;
        }
        activityManagerGroupBinding.d.setVisibility(i);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void y4(ManagerGroupStatus.OperateGroupMember operateGroupMember) {
        Object next;
        ActivityManagerGroupBinding activityManagerGroupBinding = this.a;
        if (activityManagerGroupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityManagerGroupBinding = null;
        }
        RecyclerView.Adapter adapter = activityManagerGroupBinding.e.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.main.longDistance.adapter.ManagerGroupMemberAdapter");
        ManagerGroupMemberAdapter managerGroupMemberAdapter = (ManagerGroupMemberAdapter) adapter;
        List<IGroupMember> listK = managerGroupMemberAdapter.K();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (obj instanceof GroupMemberRequest) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size() - 1;
        managerGroupMemberAdapter.o0(operateGroupMember.getItem());
        Iterator<T> it = managerGroupMemberAdapter.K().iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (((IGroupMember) next) instanceof GroupMemberHeader) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        IGroupMember iGroupMember = (IGroupMember) next;
        if (size > 0) {
            GroupMemberHeader groupMemberHeader = iGroupMember instanceof GroupMemberHeader ? (GroupMemberHeader) iGroupMember : null;
            if (groupMemberHeader != null) {
                groupMemberHeader.setCount(size);
            }
        } else if (iGroupMember != null) {
            managerGroupMemberAdapter.o0(iGroupMember);
        }
        managerGroupMemberAdapter.notifyDataSetChanged();
    }

    public final void z4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(null), 3, null);
        w4().q();
        w4().p();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable GroupNameChangeEvent event) {
        if (w4().m(event != null ? event.roomId : null)) {
            String strH = w4().h();
            if (strH == null) {
                strH = "";
            }
            O4(strH);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable GroupInvitationSettingEvent event) {
        w4().k(event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable FinishChatPageEvent event) {
        finish();
    }
}
