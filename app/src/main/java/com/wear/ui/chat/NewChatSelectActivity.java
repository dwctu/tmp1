package com.wear.ui.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.RecyclerViewStatus;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageBody;
import com.wear.bean.chat.MessageSelected;
import com.wear.databinding.ActivityChatNewSelectBinding;
import com.wear.ui.chat.NewChatSelectActivity;
import com.wear.ui.chat.adapter.ChatAdapter;
import com.wear.util.WearUtils;
import com.wear.widget.ScrollSpeedLinearLayoutManager;
import dc.ah4;
import dc.br;
import dc.ch3;
import dc.ie3;
import dc.kg3;
import dc.n04;
import dc.sg3;
import dc.t34;
import dc.th4;
import dc.u34;
import dc.uy3;
import dc.vl2;
import dc.ws2;
import dc.wz3;
import dc.zq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewChatSelectActivity.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J(\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00102\u000e\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Lcom/wear/ui/chat/NewChatSelectActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "()V", "binding", "Lcom/wear/databinding/ActivityChatNewSelectBinding;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "viewModel", "Lcom/wear/ui/chat/NewChatViewModel;", "getViewModel", "()Lcom/wear/ui/chat/NewChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initData", "", "initIntentData", "initListener", "initRecyclerView", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "onSelectModelClick", "skipBaseSettingBarColor", "", "updateChatSelectCountText", "count", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewChatSelectActivity extends BaseActivity<vl2> implements zq {

    @NotNull
    public static final a d = new a(null);
    public ActivityChatNewSelectBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewChatViewModel.class), new d(this), new c(this), new e(null, this));

    @NotNull
    public final ie3 c = new ie3();

    /* compiled from: NewChatSelectActivity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/NewChatSelectActivity$Companion;", "", "()V", "CHAT_SELECTED_LIST", "", "MAX_SELECTED", "", "REQUEST_CODE", "USER_JOIN_CHAT_BEAN", "startAtcForResult", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "selectedList", "Ljava/util/ArrayList;", "Lcom/wear/bean/chat/MessageSelected;", "Lkotlin/collections/ArrayList;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull UserJoinChatBean userJoinChatBean, @Nullable ArrayList<MessageSelected> arrayList) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
            Intent intent = new Intent(activity, (Class<?>) NewChatSelectActivity.class);
            intent.putExtra("userJoinChatBean", userJoinChatBean);
            intent.putParcelableArrayListExtra("chatSelectedList", arrayList);
            activity.startActivityForResult(intent, 100);
        }
    }

    /* compiled from: NewChatSelectActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatSelectActivity$initData$1", f = "NewChatSelectActivity.kt", i = {}, l = {CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: NewChatSelectActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "status", "Lcom/wear/bean/RecyclerViewStatus;", "emit", "(Lcom/wear/bean/RecyclerViewStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34 {
            public final /* synthetic */ NewChatSelectActivity a;

            public a(NewChatSelectActivity newChatSelectActivity) {
                this.a = newChatSelectActivity;
            }

            public static final void c(NewChatSelectActivity this$0, RecyclerViewStatus status) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(status, "$status");
                ActivityChatNewSelectBinding activityChatNewSelectBinding = this$0.a;
                if (activityChatNewSelectBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatNewSelectBinding = null;
                }
                RecyclerView recyclerView = activityChatNewSelectBinding.c;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
                ws2.f(recyclerView, status);
            }

            @Override // dc.u34
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull final RecyclerViewStatus recyclerViewStatus, @NotNull Continuation<? super Unit> continuation) {
                ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a.a;
                if (activityChatNewSelectBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatNewSelectBinding = null;
                }
                RecyclerView recyclerView = activityChatNewSelectBinding.c;
                final NewChatSelectActivity newChatSelectActivity = this.a;
                recyclerView.post(new Runnable() { // from class: dc.fr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewChatSelectActivity.b.a.c(newChatSelectActivity, recyclerViewStatus);
                    }
                });
                return Unit.INSTANCE;
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatSelectActivity.this.new b(continuation);
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
                t34<RecyclerViewStatus> t34VarN = NewChatSelectActivity.this.u4().n();
                a aVar = new a(NewChatSelectActivity.this);
                this.label = 1;
                if (t34VarN.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
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

    public static final void A4(NewChatSelectActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        this$0.E4(adapter, i);
    }

    public static final void y4(NewChatSelectActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this$0.a;
        if (activityChatNewSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding = null;
        }
        RecyclerView.Adapter adapter = activityChatNewSelectBinding.c.getAdapter();
        ChatAdapter chatAdapter = adapter instanceof ChatAdapter ? (ChatAdapter) adapter : null;
        if (chatAdapter == null) {
            return;
        }
        List<Message> listK = chatAdapter.K();
        ArrayList<Message> arrayList = new ArrayList();
        for (Object obj : listK) {
            if (((Message) obj).getIsSelected()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Message message : arrayList) {
            MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
            arrayList2.add(new MessageSelected(message.getMessageId(), messageBody != null ? messageBody.getText() : null, Intrinsics.areEqual(message.getFromAccountId(), ch3.n().o().getAppAccountCode()) ? "reporter" : "reportee", message.getCreateTime(), message.getFromAccountId(), message.getToAccountId()));
        }
        List list = CollectionsKt___CollectionsKt.toList(arrayList2);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("chatSelectedList", new ArrayList<>(list));
        Unit unit = Unit.INSTANCE;
        this$0.setResult(-1, intent);
        this$0.finish();
    }

    public final void B4() {
        ArrayList<MessageSelected> arrayListO = u4().o();
        F4(arrayListO != null ? arrayListO.size() : 0);
    }

    public final void E4(BaseQuickAdapter<?, ?> baseQuickAdapter, int i) {
        ChatAdapter chatAdapter = baseQuickAdapter instanceof ChatAdapter ? (ChatAdapter) baseQuickAdapter : null;
        if (chatAdapter == null) {
            return;
        }
        Message message = chatAdapter.K().get(i);
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a;
        if (activityChatNewSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding = null;
        }
        Object tag = activityChatNewSelectBinding.b.getTag();
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue >= 50 && !message.getIsSelected()) {
            sg3.l(ah4.e(R.string.control_roulette_chats_upload_upon_toast));
            return;
        }
        message.setSelected(!message.getIsSelected());
        F4(message.getIsSelected() ? iIntValue + 1 : iIntValue - 1);
        baseQuickAdapter.notifyItemChanged(i);
    }

    public final void F4(int i) {
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a;
        ActivityChatNewSelectBinding activityChatNewSelectBinding2 = null;
        if (activityChatNewSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding = null;
        }
        activityChatNewSelectBinding.b.setEnabled(i > 0);
        ActivityChatNewSelectBinding activityChatNewSelectBinding3 = this.a;
        if (activityChatNewSelectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding3 = null;
        }
        activityChatNewSelectBinding3.b.setTag(Integer.valueOf(i));
        ActivityChatNewSelectBinding activityChatNewSelectBinding4 = this.a;
        if (activityChatNewSelectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatNewSelectBinding2 = activityChatNewSelectBinding4;
        }
        TextView textView = activityChatNewSelectBinding2.b;
        String str = String.format("Done(%d)", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        textView.setText(str);
    }

    @Override // dc.zq
    public void O1(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.user_message) {
            E4(adapter, i);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatNewSelectBinding activityChatNewSelectBindingB = ActivityChatNewSelectBinding.b(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityChatNewSelectBindingB, "inflate(layoutInflater)");
        this.a = activityChatNewSelectBindingB;
        ActivityChatNewSelectBinding activityChatNewSelectBinding = null;
        if (activityChatNewSelectBindingB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBindingB = null;
        }
        setContentView(activityChatNewSelectBindingB.getRoot());
        w4();
        ActivityChatNewSelectBinding activityChatNewSelectBinding2 = this.a;
        if (activityChatNewSelectBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatNewSelectBinding = activityChatNewSelectBinding2;
        }
        activityChatNewSelectBinding.setLifecycleOwner(this);
        u4().I(true);
        u4().G(this.c);
        B4();
        z4();
        x4();
        v4();
    }

    @Override // com.wear.BaseActivity
    public boolean skipBaseSettingBarColor() {
        kg3.i(this, !WearUtils.Y0());
        kg3.g(this, th4.b(this, R.color.lvs_ui_standard_systemBackground));
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a;
        if (activityChatNewSelectBinding != null) {
            if (activityChatNewSelectBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityChatNewSelectBinding = null;
            }
            activityChatNewSelectBinding.a.setParentBackgroundColor(0);
        }
        return true;
    }

    public final NewChatViewModel u4() {
        return (NewChatViewModel) this.b.getValue();
    }

    public final void v4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), n04.c(), null, new b(null), 2, null);
        u4().z();
    }

    public final void w4() {
        UserJoinChatBean userJoinChatBean = (UserJoinChatBean) getIntent().getParcelableExtra("userJoinChatBean");
        if (userJoinChatBean != null) {
            u4().K(userJoinChatBean.getUserAccountCode());
            u4().L(userJoinChatBean.getToys());
            u4().H(userJoinChatBean.getEncryptionMode());
        }
        NewChatViewModel newChatViewModelU4 = u4();
        ArrayList<MessageSelected> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("chatSelectedList");
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList<>();
        }
        newChatViewModelU4.J(parcelableArrayListExtra);
    }

    public final void x4() {
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a;
        if (activityChatNewSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding = null;
        }
        activityChatNewSelectBinding.b.setOnClickListener(new View.OnClickListener() { // from class: dc.gr2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewChatSelectActivity.y4(this.a, view);
            }
        });
    }

    public final void z4() {
        ActivityChatNewSelectBinding activityChatNewSelectBinding = this.a;
        ActivityChatNewSelectBinding activityChatNewSelectBinding2 = null;
        if (activityChatNewSelectBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding = null;
        }
        RecyclerView.ItemAnimator itemAnimator = activityChatNewSelectBinding.c.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        ActivityChatNewSelectBinding activityChatNewSelectBinding3 = this.a;
        if (activityChatNewSelectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatNewSelectBinding3 = null;
        }
        activityChatNewSelectBinding3.c.setLayoutManager(new ScrollSpeedLinearLayoutManager(this));
        ChatAdapter chatAdapter = new ChatAdapter(this.c, true, null);
        chatAdapter.o(R.id.content_container, R.id.user_message, R.id.chat_audio_view);
        chatAdapter.n(R.id.user_message);
        chatAdapter.A0(this);
        chatAdapter.E0(new br() { // from class: dc.er2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NewChatSelectActivity.A4(this.a, baseQuickAdapter, view, i);
            }
        });
        ActivityChatNewSelectBinding activityChatNewSelectBinding4 = this.a;
        if (activityChatNewSelectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatNewSelectBinding2 = activityChatNewSelectBinding4;
        }
        activityChatNewSelectBinding2.c.setAdapter(chatAdapter);
    }
}
