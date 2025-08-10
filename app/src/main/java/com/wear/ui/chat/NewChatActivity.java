package com.wear.ui.chat;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.lovense.wear.R;
import com.wear.bean.RecyclerViewStatus;
import com.wear.bean.RouletteEndBean;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.NotifyClientLineTcBean;
import com.wear.databinding.ActivityChatBuildBinding;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.chat.action.im.ChatMessageHandler;
import com.wear.ui.chat.adapter.ChatAdapter;
import com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.ui.chat.widget.AutoHidePanelRecyclerView;
import com.wear.ui.discover.roulette.RouletteChatEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.BaseImageButton;
import com.wear.widget.ChatEditText;
import com.wear.widget.MyActionBar;
import com.wear.widget.ScrollSpeedLinearLayoutManager;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import com.wear.widget.velvo.VelvoPreviewView;
import com.wear.xmpp.FragmentStateLossActivity;
import dc.ah4;
import dc.ar;
import dc.au1;
import dc.br;
import dc.cs3;
import dc.du2;
import dc.eg3;
import dc.hf3;
import dc.ie3;
import dc.is3;
import dc.iv1;
import dc.kg3;
import dc.kt2;
import dc.ku1;
import dc.my2;
import dc.n04;
import dc.ns2;
import dc.ny2;
import dc.od3;
import dc.ps2;
import dc.pt2;
import dc.rt2;
import dc.sg3;
import dc.t34;
import dc.th4;
import dc.ts2;
import dc.u34;
import dc.uq2;
import dc.uy3;
import dc.vl2;
import dc.vt2;
import dc.vu2;
import dc.ws2;
import dc.wu2;
import dc.wz3;
import dc.xt2;
import dc.zq;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Unexpected interfaces in signature: [com.wear.ui.chat.fragment.ChatActionMenuFragmentBottom$d] */
/* compiled from: NewChatActivity.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0002wxB\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u0011\u0010*\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H\u0096\u0001J\u0006\u0010+\u001a\u00020(J\b\u0010,\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0019H\u0002J\t\u0010/\u001a\u00020(H\u0096\u0001J\t\u00100\u001a\u00020(H\u0096\u0001J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u00020(J\b\u00105\u001a\u00020(H\u0016J\b\u00106\u001a\u00020(H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J!\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>H\u0096\u0001J\b\u0010?\u001a\u00020(H\u0002J\b\u0010@\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020(H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\b\u0010D\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020(H\u0015J\u0011\u0010F\u001a\u00020(H\u0082Pø\u0001\u0000¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\u0019H\u0002J\u0010\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020\u0015H\u0016J\u0006\u0010L\u001a\u00020(J\u0012\u0010M\u001a\u00020(2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0010\u0010P\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\b\u0010Q\u001a\u00020(H\u0014J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0019H\u0002J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020VH\u0007J\u0010\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020\u001eH\u0016J(\u0010Y\u001a\u00020(2\u000e\u0010Z\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0015H\u0016J(\u0010_\u001a\u00020\u00192\u000e\u0010Z\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0015H\u0016J\t\u0010`\u001a\u00020(H\u0096\u0001J\u0011\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010c\u001a\u00020(2\u0006\u0010b\u001a\u00020\u0015H\u0096\u0001J\b\u0010d\u001a\u00020(H\u0014J\u0013\u0010e\u001a\u00020(2\b\u0010f\u001a\u0004\u0018\u00010gH\u0096\u0001J\u0012\u0010h\u001a\u00020(2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010i\u001a\u00020(H\u0014J#\u0010j\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u001e2\b\u0010l\u001a\u0004\u0018\u00010\u001eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020(H\u0016J\b\u0010o\u001a\u00020(H\u0016J\u0012\u0010p\u001a\u00020(2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u0010\u0010s\u001a\u00020(2\u0006\u0010t\u001a\u00020\u0015H\u0002J\b\u0010u\u001a\u00020(H\u0016J\b\u0010v\u001a\u00020(H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, d2 = {"Lcom/wear/ui/chat/NewChatActivity;", "Lcom/wear/xmpp/FragmentStateLossActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Lcom/wear/ui/chat/controller/FunctionPanel;", "Lcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "Lcom/wear/ui/chat/popup/ChatItemMenuPopup$OnActionCallback;", "Lcom/wear/ui/chat/action/im/ChatMessageHandler$MessageHandlerListener;", "Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper$HookBackUpSuccess;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "Lcom/wear/ui/discover/roulette/action/RouletteHeartbeatAction$RouletteHeartbeatListener;", "Lcom/wear/widget/chatMic/VoiceMessagePanelView$RecordActionListener;", "Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom$OnChatActionMenuClickListener;", "()V", "binding", "Lcom/wear/databinding/ActivityChatBuildBinding;", "chatActionMenuFragmentBottom", "Lcom/wear/ui/chat/fragment/ChatActionMenuFragmentBottom;", "chatItemMenuPopup", "Lcom/wear/ui/chat/popup/ChatItemMenuPopup;", "currentTime", "", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "isCurrentTimeEnd", "", "mPanelSwitchHelper", "Lcom/wear/ui/chat/pancel/helper/PanelSwitchHelper;", "unfilledHeight", "userAccountCode", "", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "viewModel", "Lcom/wear/ui/chat/NewChatViewModel;", "getViewModel", "()Lcom/wear/ui/chat/NewChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addChatRoomCloseLog", "", "elementContent", "bindFunctionPanelsViewModel", "cancelAudioRecord", "cancelRecord", "clearBefore", "isActive", "createLiveControl", "createSyncControl", "handlerMessage", "message", "Lcom/wear/bean/chat/Message;", "hiddenChatActionMenuFragmentBottom", "hookBackUpSuccess", "initActionBar", "initChatGroupContainer", "initData", "initEditText", "initFunctionPanels", "panelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "velvoPreview", "Lcom/wear/widget/velvo/VelvoPreviewView;", "initIntentData", "initRecyclerView", "initView", "initVoiceMessagePanelView", "isPlayed", "isPlaying", "loadSkinSuccessInvoke", "looperTimeCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackPressClick", "canFinish", "onChatActionMenuClick", "type", "onClickExpandToMax", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDelete", "onDestroy", "onEditTextChanged", "isEmpty", "onEventMsg", "event", "Lcom/wear/bean/RouletteEndBean;", "onHeartbeatSendSystemMessage", "text", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onItemChildLongClick", "onPanelDestroyClear", "onPanelHidden", "triggerViewId", "onPanelVisible", "onPause", "onReconnectLiveControlSyncControlState", "notifyClientLineTcBean", "Lcom/wear/bean/chat/NotifyClientLineTcBean;", "onRouletteClientPanel", "onStart", "playAudioUrl", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRecord", "settingBarColor", "showLevitateButtonWithBack", "levitateListener", "Lcom/wear/listenter/IShowTipLevitateListener;", "showRouletteChatEndFragment", "reason", "startRecord", "stopPlayAudio", "Companion", "Listeners", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewChatActivity extends FragmentStateLossActivity<vl2> implements Object, ChatAdapter.a, ar, wu2.a, ChatMessageHandler.MessageHandlerListener, kt2.b, zq, ny2.a, VoiceMessagePanelView.b {

    @NotNull
    public static final a n = new a(null);

    @Nullable
    public String c;
    public ActivityChatBuildBinding e;

    @Nullable
    public kt2 f;
    public int g;
    public int i;
    public boolean j;

    @Nullable
    public ChatActionMenuFragmentBottom k;

    @Nullable
    public UserJoinChatBean l;

    @Nullable
    public wu2 m;
    public final /* synthetic */ ts2 b = new ts2();

    @NotNull
    public final Lazy d = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewChatViewModel.class), new q(this), new p(this), new r(null, this));

    @NotNull
    public final ie3 h = new ie3();

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/ui/chat/NewChatActivity$Companion;", "", "()V", "USER_ACCOUNT_CODE", "", "USER_JOIN_CHAT_BEAN", "startAtc", "", "context", "Landroid/content/Context;", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "isReconnect", "", "clearDatabase", "userAccountCode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, UserJoinChatBean userJoinChatBean, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            aVar.a(context, userJoinChatBean, z, z2);
        }

        public final void a(@NotNull Context context, @NotNull UserJoinChatBean userJoinChatBean, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
            Intent intent = new Intent(context, (Class<?>) NewChatActivity.class);
            intent.putExtra("userJoinChatBean", userJoinChatBean);
            intent.putExtra("isReconnect", z);
            intent.putExtra("clearDatabase", z2);
            my2.i.a().s(userJoinChatBean);
            context.startActivity(intent);
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/NewChatActivity$Listeners;", "", "(Lcom/wear/ui/chat/NewChatActivity;)V", "clickSendBtn", "", "clickVoiceBtn", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class b {
        public b() {
        }

        public final void a() {
            NewChatActivity.this.J4().F();
            NewChatActivity.this.J4().m().set("");
        }

        public final void b() {
            ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = NewChatActivity.this.k;
            if (chatActionMenuFragmentBottom != null) {
                FragmentManager supportFragmentManager = NewChatActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                chatActionMenuFragmentBottom.show(supportFragmentManager, "ChatActionMenuFragmentBottom");
            }
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatActivity$initActionBar$3", f = "NewChatActivity.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatActivity.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NewChatActivity newChatActivity = NewChatActivity.this;
                this.label = 1;
                if (newChatActivity.h5(this) == coroutine_suspended) {
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

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatActivity$initData$1", f = "NewChatActivity.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "status", "Lcom/wear/bean/RecyclerViewStatus;", "emit", "(Lcom/wear/bean/RecyclerViewStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements u34 {
            public final /* synthetic */ NewChatActivity a;

            public a(NewChatActivity newChatActivity) {
                this.a = newChatActivity;
            }

            public static final void c(NewChatActivity this$0, RecyclerViewStatus status) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(status, "$status");
                ActivityChatBuildBinding activityChatBuildBinding = this$0.e;
                if (activityChatBuildBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatBuildBinding = null;
                }
                AutoHidePanelRecyclerView autoHidePanelRecyclerView = activityChatBuildBinding.l;
                Intrinsics.checkNotNullExpressionValue(autoHidePanelRecyclerView, "binding.recyclerView");
                ws2.f(autoHidePanelRecyclerView, status);
            }

            @Override // dc.u34
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull final RecyclerViewStatus recyclerViewStatus, @NotNull Continuation<? super Unit> continuation) {
                wu2 wu2Var = this.a.m;
                if (wu2Var != null && wu2Var.isShowing()) {
                    wu2Var.dismiss();
                }
                ActivityChatBuildBinding activityChatBuildBinding = this.a.e;
                if (activityChatBuildBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatBuildBinding = null;
                }
                AutoHidePanelRecyclerView autoHidePanelRecyclerView = activityChatBuildBinding.l;
                final NewChatActivity newChatActivity = this.a;
                autoHidePanelRecyclerView.post(new Runnable() { // from class: dc.ar2
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewChatActivity.d.a.c(newChatActivity, recyclerViewStatus);
                    }
                });
                return Unit.INSTANCE;
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatActivity.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                t34<RecyclerViewStatus> t34VarN = NewChatActivity.this.J4().n();
                a aVar = new a(NewChatActivity.this);
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

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatActivity$initData$2", f = "NewChatActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatActivity.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NewChatActivity.this.J4().A();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n*L\n1#1,97:1\n78#2:98\n71#3:99\n*E\n"})
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            NewChatActivity.this.k5((text != null ? text.length() : 0) == 0);
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatActivity$initIntentData$1$1", f = "NewChatActivity.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ UserJoinChatBean $it;
        public int label;
        public final /* synthetic */ NewChatActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(UserJoinChatBean userJoinChatBean, NewChatActivity newChatActivity, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$it = userJoinChatBean;
            this.this$0 = newChatActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$it, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L31
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                com.wear.bean.UserJoinChatBean r4 = r3.$it
                java.lang.String r4 = r4.getRoomId()
                if (r4 == 0) goto L39
                com.wear.ui.chat.NewChatActivity r1 = r3.this$0
                com.wear.ui.chat.NewChatViewModel r1 = com.wear.ui.chat.NewChatActivity.y4(r1)
                r3.label = r2
                java.lang.Object r4 = r1.h(r4, r3)
                if (r4 != r0) goto L31
                return r0
            L31:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                if (r4 == 0) goto L39
                boolean r2 = r4.booleanValue()
            L39:
                if (r2 != 0) goto L47
                com.wear.ui.chat.NewChatActivity r4 = r3.this$0
                r0 = 0
                com.wear.ui.chat.NewChatActivity.s4(r4, r0)
                com.wear.ui.chat.NewChatActivity r4 = r3.this$0
                r0 = 2
                com.wear.ui.chat.NewChatActivity.D4(r4, r0)
            L47:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.NewChatActivity.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<Unit> {
        public h() {
            super(0);
        }

        public static final void a(NewChatActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.finish();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final NewChatActivity newChatActivity = NewChatActivity.this;
            newChatActivity.p5(new iv1() { // from class: dc.br2
                @Override // dc.iv1
                public final void next() {
                    NewChatActivity.h.a(newChatActivity);
                }
            });
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatActivity", f = "NewChatActivity.kt", i = {}, l = {323}, m = "looperTimeCount", n = {}, s = {})
    public static final class i extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NewChatActivity.this.h5(this);
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListenerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<vt2, Unit> {

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visible", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function2<Boolean, Integer, Unit> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(NewChatActivity newChatActivity) {
                super(2);
                this.this$0 = newChatActivity;
            }

            public final void a(boolean z, int i) {
                if (z) {
                    this.this$0.m5(-1);
                    ActivityChatBuildBinding activityChatBuildBinding = this.this$0.e;
                    if (activityChatBuildBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityChatBuildBinding = null;
                    }
                    activityChatBuildBinding.c.setSelected(false);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                a(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }
        }

        public j() {
            super(1);
        }

        public final void a(@NotNull vt2 addKeyboardStateListener) {
            Intrinsics.checkNotNullParameter(addKeyboardStateListener, "$this$addKeyboardStateListener");
            addKeyboardStateListener.a(new a(NewChatActivity.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(vt2 vt2Var) {
            a(vt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<pt2, Unit> {

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "defaultDistance", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function1<Integer, Integer> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(NewChatActivity newChatActivity) {
                super(1);
                this.this$0 = newChatActivity;
            }

            @NotNull
            public final Integer a(int i) {
                return Integer.valueOf(i - this.this$0.g);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return a(num.intValue());
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function0<Integer> {
            public static final b a = new b();

            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(R.id.recycler_view);
            }
        }

        public k() {
            super(1);
        }

        public final void a(@NotNull pt2 addContentScrollMeasurer) {
            Intrinsics.checkNotNullParameter(addContentScrollMeasurer, "$this$addContentScrollMeasurer");
            addContentScrollMeasurer.c(new a(NewChatActivity.this));
            addContentScrollMeasurer.d(b.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(pt2 pt2Var) {
            a(pt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<pt2, Unit> {
        public static final l a = new l();

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function1<Integer, Integer> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @NotNull
            public final Integer a(int i) {
                return 0;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return a(num.intValue());
            }
        }

        public l() {
            super(1);
        }

        public final void a(@NotNull pt2 addContentScrollMeasurer) {
            Intrinsics.checkNotNullParameter(addContentScrollMeasurer, "$this$addContentScrollMeasurer");
            addContentScrollMeasurer.c(a.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(pt2 pt2Var) {
            a(pt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListenerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<xt2, Unit> {

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iPanelView", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function1<vu2, Unit> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(NewChatActivity newChatActivity) {
                super(1);
                this.this$0 = newChatActivity;
            }

            public final void a(@Nullable vu2 vu2Var) {
                ActivityChatBuildBinding activityChatBuildBinding = this.this$0.e;
                if (activityChatBuildBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatBuildBinding = null;
                }
                activityChatBuildBinding.c.setSelected(vu2Var != null && vu2Var.getA() == R.id.chat_emojis);
                if (vu2Var != null && vu2Var.getA() == R.id.chat_emojis) {
                    this.this$0.h.I();
                }
                if (vu2Var != null) {
                    this.this$0.n5(vu2Var.getA());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(vu2 vu2Var) {
                a(vu2Var);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(NewChatActivity newChatActivity) {
                super(0);
                this.this$0 = newChatActivity;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.m5(-1);
            }
        }

        public m() {
            super(1);
        }

        public final void a(@NotNull xt2 addPanelChangeListener) {
            Intrinsics.checkNotNullParameter(addPanelChangeListener, "$this$addPanelChangeListener");
            addPanelChangeListener.f(new a(NewChatActivity.this));
            addPanelChangeListener.a(new b(NewChatActivity.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(xt2 xt2Var) {
            a(xt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<rt2, Unit> {

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function0<Integer> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(R.id.control_sync_function_panel);
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function0<Boolean> {
            public static final b a = new b();

            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class c extends Lambda implements Function0<Integer> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(NewChatActivity newChatActivity) {
                super(0);
                this.this$0 = newChatActivity;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ps2.a() == 0 ? du2.a(this.this$0) : ps2.a());
            }
        }

        public n() {
            super(1);
        }

        public final void a(@NotNull rt2 addPanelHeightMeasurer) {
            Intrinsics.checkNotNullParameter(addPanelHeightMeasurer, "$this$addPanelHeightMeasurer");
            addPanelHeightMeasurer.d(a.a);
            addPanelHeightMeasurer.f(b.a);
            addPanelHeightMeasurer.e(new c(NewChatActivity.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(rt2 rt2Var) {
            a(rt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurerBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<rt2, Unit> {

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function0<Integer> {
            public static final a a = new a();

            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(R.id.control_function_panel);
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function0<Boolean> {
            public static final b a = new b();

            public b() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        }

        /* compiled from: NewChatActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class c extends Lambda implements Function0<Integer> {
            public final /* synthetic */ NewChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(NewChatActivity newChatActivity) {
                super(0);
                this.this$0 = newChatActivity;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ns2.a() == 0 ? du2.a(this.this$0) : ns2.a());
            }
        }

        public o() {
            super(1);
        }

        public final void a(@NotNull rt2 addPanelHeightMeasurer) {
            Intrinsics.checkNotNullParameter(addPanelHeightMeasurer, "$this$addPanelHeightMeasurer");
            addPanelHeightMeasurer.d(a.a);
            addPanelHeightMeasurer.f(b.a);
            addPanelHeightMeasurer.e(new c(NewChatActivity.this));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(rt2 rt2Var) {
            a(rt2Var);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ComponentActivity componentActivity) {
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
    public static final class q extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ComponentActivity componentActivity) {
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
    public static final class r extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Function0 function0, ComponentActivity componentActivity) {
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

    public static final void H4(NewChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityChatBuildBinding activityChatBuildBinding = this$0.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.n.l();
    }

    public static final void M4(final NewChatActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p5(new iv1() { // from class: dc.yq2
            @Override // dc.iv1
            public final void next() {
                NewChatActivity.N4(this.a);
            }
        });
    }

    public static final void N4(NewChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void O4(NewChatActivity this$0, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kt2 kt2Var = this$0.f;
        if (kt2Var != null) {
            kt2Var.b();
        }
        this$0.I4(true);
        this$0.s5(1);
    }

    public static final void V4(NewChatActivity this$0, BaseQuickAdapter baseQuickAdapter, View view, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        this$0.i5(false);
    }

    public static final void X4(NewChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityChatBuildBinding activityChatBuildBinding = this$0.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        PanelSwitchLayout panelSwitchLayout = activityChatBuildBinding.k;
        Intrinsics.checkNotNullExpressionValue(panelSwitchLayout, "binding.panelSwitchLayout");
        ie3 ie3Var = this$0.h;
        ActivityChatBuildBinding activityChatBuildBinding3 = this$0.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding3;
        }
        VelvoPreviewView velvoPreviewView = activityChatBuildBinding2.m;
        Intrinsics.checkNotNullExpressionValue(velvoPreviewView, "binding.velvoPreview");
        this$0.S4(panelSwitchLayout, ie3Var, velvoPreviewView);
    }

    public static final void q5() {
    }

    public static final void r5(NewChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        od3.d(this$0.activity);
    }

    public final void E4(int i2) {
        ku1.f("control roulette chatroom", "control_roulette_control_all_over_click", "control_roulette_control_all_over", Integer.valueOf(i2), null, Integer.valueOf(this.i));
    }

    public void F4(@NotNull NewChatViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.b.a(viewModel);
    }

    @Override // dc.ny2.a
    public void G1(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        J4().E(text);
    }

    public final void G4() {
        runOnUiThread(new Runnable() { // from class: dc.dr2
            @Override // java.lang.Runnable
            public final void run() {
                NewChatActivity.H4(this.a);
            }
        });
    }

    public final void I4(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(this, "isInRouletteRoom", false);
        ny2.a.n();
        J4().y();
        l5();
        my2.i.a().D(z);
    }

    public final NewChatViewModel J4() {
        return (NewChatViewModel) this.d.getValue();
    }

    @Override // dc.wu2.a
    public void K2(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        J4().j(message);
    }

    public final void K4() {
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom;
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom2 = this.k;
        if (!(chatActionMenuFragmentBottom2 != null && chatActionMenuFragmentBottom2.isVisible()) || (chatActionMenuFragmentBottom = this.k) == null) {
            return;
        }
        chatActionMenuFragmentBottom.dismiss();
    }

    public final void L4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.a.setBackAction(new MyActionBar.f() { // from class: dc.xq2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                NewChatActivity.M4(this.a, view);
            }
        });
        ActivityChatBuildBinding activityChatBuildBinding2 = this.e;
        if (activityChatBuildBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding2 = null;
        }
        activityChatBuildBinding2.i.setOnClickListener(new View.OnClickListener() { // from class: dc.wq2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                NewChatActivity.O4(this.a, view);
            }
        });
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c(null), 3, null);
    }

    @Override // dc.ar
    public boolean M1(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int i2) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.chat_audio_view && id != R.id.content_container && id != R.id.user_message) {
            return false;
        }
        Object obj = adapter.K().get(i2);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.wear.bean.chat.Message");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        wu2 wu2Var = new wu2(context, (Message) obj, this);
        wu2Var.c(view, 0, 0);
        this.m = wu2Var;
        return true;
    }

    @Override // com.wear.ui.chat.adapter.ChatAdapter.b
    public void N2(@NotNull Message message) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        J4().Q(message, true);
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void O() {
        NewChatViewModel.P(J4(), true, 0, 2, null);
    }

    @Override // dc.zq
    public void O1(@NotNull BaseQuickAdapter<?, ?> adapter, @NotNull View view, int i2) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.block_sync) {
            if (!hf3.d(view.getContext())) {
                sg3.h(R.string.common_settingTip);
            } else {
                J4().v(((ChatAdapter) adapter).K().get(i2));
            }
        }
    }

    public final void P4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        LayoutTransition layoutTransition = activityChatBuildBinding.b.getLayoutTransition();
        layoutTransition.disableTransitionType(2);
        layoutTransition.disableTransitionType(3);
    }

    public final void Q4() {
        EventBus.getDefault().register(this);
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), n04.c(), null, new d(null), 2, null);
        ChatMessageHandler.INSTANCE.appendListener(this);
        ny2 ny2Var = ny2.a;
        ny2Var.j(this);
        boolean booleanExtra = getIntent().getBooleanExtra("isReconnect", false);
        if (getIntent().getBooleanExtra("clearDatabase", false)) {
            uy3.d(LifecycleOwnerKt.getLifecycleScope(this), n04.b(), null, new e(null), 2, null);
        } else {
            J4().z();
        }
        ny2Var.k(booleanExtra);
    }

    public final void R4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.d.setHorizontallyScrolling(false);
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        activityChatBuildBinding3.d.setMaxLines(5);
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding4 = null;
        }
        activityChatBuildBinding4.d.setFocusableInTouchMode(true);
        ActivityChatBuildBinding activityChatBuildBinding5 = this.e;
        if (activityChatBuildBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding5 = null;
        }
        activityChatBuildBinding5.d.setRawInputType(1);
        ActivityChatBuildBinding activityChatBuildBinding6 = this.e;
        if (activityChatBuildBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding6;
        }
        ChatEditText chatEditText = activityChatBuildBinding2.d;
        Intrinsics.checkNotNullExpressionValue(chatEditText, "binding.chatMessage");
        chatEditText.addTextChangedListener(new f());
    }

    public void S4(@NotNull PanelSwitchLayout panelSwitchLayout, @NotNull ie3 emojisUtils, @NotNull VelvoPreviewView velvoPreview) {
        Intrinsics.checkNotNullParameter(panelSwitchLayout, "panelSwitchLayout");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        Intrinsics.checkNotNullParameter(velvoPreview, "velvoPreview");
        this.b.e(panelSwitchLayout, emojisUtils, velvoPreview);
    }

    public final void T4() {
        int iLongValue;
        UserJoinChatBean userJoinChatBean = (UserJoinChatBean) getIntent().getParcelableExtra("userJoinChatBean");
        this.l = userJoinChatBean;
        if (userJoinChatBean != null) {
            this.c = userJoinChatBean.getUserAccountCode();
            J4().L(userJoinChatBean.getToys());
            J4().H(userJoinChatBean.getEncryptionMode());
            if (au1.a(userJoinChatBean.getStartTime())) {
                iLongValue = 0;
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long startTime = userJoinChatBean.getStartTime();
                iLongValue = (int) ((jCurrentTimeMillis - (startTime != null ? startTime.longValue() : 0L)) / 1000);
            }
            this.i = iLongValue;
            uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g(userJoinChatBean, this, null), 3, null);
        }
        String str = this.c;
        if (str == null || str.length() == 0) {
            this.c = getIntent().getStringExtra("userAccountCode");
        }
    }

    @Override // dc.ny2.a
    public void U0(@Nullable NotifyClientLineTcBean notifyClientLineTcBean) {
        o5(notifyClientLineTcBean);
    }

    public final void U4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        RecyclerView.ItemAnimator itemAnimator = activityChatBuildBinding.l.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        activityChatBuildBinding3.l.setLayoutManager(new ScrollSpeedLinearLayoutManager(this));
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding4 = null;
        }
        activityChatBuildBinding4.l.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.ui.chat.NewChatActivity$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() <= 2) {
                    this.a.J4().u();
                }
            }
        });
        ChatAdapter chatAdapter = new ChatAdapter(this.h, false, this);
        chatAdapter.o(R.id.content_container, R.id.user_message, R.id.chat_audio_view);
        chatAdapter.n(R.id.block_sync);
        chatAdapter.A0(this);
        chatAdapter.C0(this);
        chatAdapter.E0(new br() { // from class: dc.cr2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                NewChatActivity.V4(this.a, baseQuickAdapter, view, i2);
            }
        });
        ActivityChatBuildBinding activityChatBuildBinding5 = this.e;
        if (activityChatBuildBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding5 = null;
        }
        activityChatBuildBinding5.l.setAdapter(chatAdapter);
        ActivityChatBuildBinding activityChatBuildBinding6 = this.e;
        if (activityChatBuildBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding6;
        }
        activityChatBuildBinding2.l.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.wear.ui.chat.NewChatActivity$initRecyclerView$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                View viewFindViewByPosition;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null || !(layoutManager instanceof LinearLayoutManager) || (viewFindViewByPosition = layoutManager.findViewByPosition(((LinearLayoutManager) layoutManager).findLastVisibleItemPosition())) == null) {
                    return;
                }
                ActivityChatBuildBinding activityChatBuildBinding7 = this.a.e;
                ActivityChatBuildBinding activityChatBuildBinding8 = null;
                if (activityChatBuildBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityChatBuildBinding7 = null;
                }
                int height = activityChatBuildBinding7.l.getHeight();
                ActivityChatBuildBinding activityChatBuildBinding9 = this.a.e;
                if (activityChatBuildBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityChatBuildBinding8 = activityChatBuildBinding9;
                }
                this.a.g = (height - activityChatBuildBinding8.l.getPaddingBottom()) - viewFindViewByPosition.getBottom();
            }
        });
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void W2() {
        NewChatViewModel newChatViewModelJ4 = J4();
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        VoiceMessagePanelView voiceMessagePanelView = activityChatBuildBinding.n;
        Intrinsics.checkNotNullExpressionValue(voiceMessagePanelView, "binding.voiceMessagePanelView");
        newChatViewModelJ4.M(voiceMessagePanelView);
    }

    public final void W4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.d(J4().m());
        ActivityKt.c(this, null, new h(), 1, null);
        P4();
        R4();
        U4();
        F4(J4());
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        activityChatBuildBinding3.k.post(new Runnable() { // from class: dc.zq2
            @Override // java.lang.Runnable
            public final void run() {
                NewChatActivity.X4(this.a);
            }
        });
        Y4();
        if (this.k == null) {
            this.k = ChatActionMenuFragmentBottom.f.a(3);
        }
        ChatActionMenuFragmentBottom chatActionMenuFragmentBottom = this.k;
        Intrinsics.checkNotNull(chatActionMenuFragmentBottom);
        chatActionMenuFragmentBottom.F(this);
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding4;
        }
        activityChatBuildBinding2.a.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
    }

    public final void Y4() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        VoiceMessagePanelView voiceMessagePanelView = activityChatBuildBinding.n;
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        BaseImageButton baseImageButton = activityChatBuildBinding3.h;
        Intrinsics.checkNotNullExpressionValue(baseImageButton, "binding.chatVoice");
        voiceMessagePanelView.h(baseImageButton);
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding4 = null;
        }
        activityChatBuildBinding4.n.setRecordActionListener(this);
        ActivityChatBuildBinding activityChatBuildBinding5 = this.e;
        if (activityChatBuildBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding5 = null;
        }
        VoiceMessagePanelView voiceMessagePanelView2 = activityChatBuildBinding5.n;
        Intrinsics.checkNotNullExpressionValue(voiceMessagePanelView2, "binding.voiceMessagePanelView");
        ActivityChatBuildBinding activityChatBuildBinding6 = this.e;
        if (activityChatBuildBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding6;
        }
        RelativeLayout relativeLayout = activityChatBuildBinding2.b;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.bottomAction");
        VoiceMessagePanelView.q(voiceMessagePanelView2, relativeLayout, null, false, 6, null);
    }

    @Override // com.wear.widget.chatMic.VoiceMessagePanelView.b
    public void a1() {
        NewChatViewModel newChatViewModelJ4 = J4();
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        newChatViewModelJ4.O(false, activityChatBuildBinding.n.getE());
    }

    @Override // dc.vr2.b
    @Nullable
    public Object c3(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super Boolean> continuation) {
        G4();
        return J4().t(str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h5(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.wear.ui.chat.NewChatActivity.i
            if (r0 == 0) goto L13
            r0 = r10
            com.wear.ui.chat.NewChatActivity$i r0 = (com.wear.ui.chat.NewChatActivity.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.chat.NewChatActivity$i r0 = new com.wear.ui.chat.NewChatActivity$i
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r2 = r0.L$0
            com.wear.ui.chat.NewChatActivity r2 = (com.wear.ui.chat.NewChatActivity) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L39
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r9
        L39:
            boolean r10 = r2.j
            if (r10 == 0) goto L40
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L40:
            int r10 = r2.i
            int r4 = r10 + 1
            r2.i = r4
            long[] r10 = dc.be3.K(r10)
            com.wear.databinding.ActivityChatBuildBinding r4 = r2.e
            if (r4 != 0) goto L54
            java.lang.String r4 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = 0
        L54:
            android.widget.TextView r4 = r4.j
            r5 = 0
            r5 = r10[r5]
            int r6 = (int) r5
            r7 = r10[r3]
            int r5 = (int) r7
            r7 = 2
            r7 = r10[r7]
            int r10 = (int) r7
            java.lang.String r10 = dc.be3.z(r6, r5, r10)
            r4.setText(r10)
            r4 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = dc.h04.a(r4, r0)
            if (r10 != r1) goto L39
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.NewChatActivity.h5(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.wear.ui.chat.action.im.ChatMessageHandler.MessageHandlerListener
    public void handlerMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        RecyclerView.Adapter adapter = activityChatBuildBinding.l.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.chad.library.adapter.base.BaseQuickAdapter<*, *>");
        List listK = ((BaseQuickAdapter) adapter).K();
        ArrayList arrayList = new ArrayList();
        Iterator it = listK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if ((next instanceof Message) && Intrinsics.areEqual(((Message) next).getMessageId(), message.getMessageId())) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return;
        }
        J4().w(message);
    }

    public final void i5(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kt2 kt2Var = this.f;
        if (kt2Var != null) {
            Intrinsics.checkNotNull(kt2Var);
            if (kt2Var.a()) {
                return;
            }
        }
        if (z) {
            I4(true);
            s5(1);
        }
    }

    @Override // dc.vr2.b
    public boolean isPlaying() {
        return J4().s();
    }

    public final void j5() {
        K4();
        if (ChatLiveControl.q0().r()) {
            ChatLiveControl.q0().c1();
            kt2 kt2Var = this.f;
            if (kt2Var != null) {
                kt2Var.d(R.id.control_function_panel);
                return;
            }
            return;
        }
        if (ChatSyncControl.N0().r()) {
            ChatSyncControl.N0().H1();
            kt2 kt2Var2 = this.f;
            if (kt2Var2 != null) {
                kt2Var2.d(R.id.control_sync_function_panel);
            }
        }
    }

    public final void k5(boolean z) {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        ActivityChatBuildBinding activityChatBuildBinding2 = null;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        LinearLayout linearLayout = activityChatBuildBinding.e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.chatMessageContainer");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(16, z ? R.id.chat_voice : R.id.chat_send);
        linearLayout.setLayoutParams(layoutParams2);
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        activityChatBuildBinding3.h.setVisibility(z ? 0 : 4);
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding2 = activityChatBuildBinding4;
        }
        activityChatBuildBinding2.g.setVisibility(z ? 8 : 0);
    }

    public void l5() {
        this.b.g();
    }

    @Override // com.wear.BaseActivity
    @SuppressLint({"NotifyDataSetChanged"})
    public void loadSkinSuccessInvoke() {
        super.loadSkinSuccessInvoke();
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        RecyclerView.Adapter adapter = activityChatBuildBinding.l.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void m5(int i2) {
        this.b.h(i2);
    }

    public void n1(int i2) {
        if (i2 == 0) {
            v();
        } else {
            if (i2 != 1) {
                return;
            }
            t();
        }
    }

    public void n5(int i2) {
        this.b.i(i2);
    }

    @Override // dc.kt2.b
    public void o3() {
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.c.setSelected(false);
    }

    public void o5(@Nullable NotifyClientLineTcBean notifyClientLineTcBean) {
        this.b.j(notifyClientLineTcBean);
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatBuildBinding activityChatBuildBindingB = ActivityChatBuildBinding.b(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityChatBuildBindingB, "inflate(layoutInflater)");
        this.e = activityChatBuildBindingB;
        ActivityChatBuildBinding activityChatBuildBinding = null;
        if (activityChatBuildBindingB == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBindingB = null;
        }
        setContentView(activityChatBuildBindingB.getRoot());
        T4();
        ActivityChatBuildBinding activityChatBuildBinding2 = this.e;
        if (activityChatBuildBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding2 = null;
        }
        activityChatBuildBinding2.setLifecycleOwner(this);
        ActivityChatBuildBinding activityChatBuildBinding3 = this.e;
        if (activityChatBuildBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding3 = null;
        }
        activityChatBuildBinding3.e(new b());
        ActivityChatBuildBinding activityChatBuildBinding4 = this.e;
        if (activityChatBuildBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding = activityChatBuildBinding4;
        }
        activityChatBuildBinding.f(this.c);
        J4().K(this.c);
        J4().G(this.h);
        L4();
        W4();
        Q4();
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ChatMessageHandler.INSTANCE.removeListener(this);
        ny2.a.j(null);
        EventBus.getDefault().unregister(this);
        if (ChatLiveControl.q0().r()) {
            ChatLiveControl.q0().u0();
        }
        if (ChatSyncControl.N0().r()) {
            ChatSyncControl.N0().Q0();
        }
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@NotNull RouletteEndBean event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(event, "event");
        O();
        I4(false);
        s5(2);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ActivityChatBuildBinding activityChatBuildBinding = this.e;
        if (activityChatBuildBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatBuildBinding = null;
        }
        activityChatBuildBinding.n.l();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ActivityChatBuildBinding activityChatBuildBinding = null;
        if (this.f == null) {
            kt2.a aVar = new kt2.a(this);
            aVar.b(new j());
            aVar.a(new k());
            aVar.a(l.a);
            aVar.c(new m());
            aVar.d(new n());
            aVar.d(new o());
            aVar.t(false);
            this.f = kt2.a.f(aVar, false, 1, null);
        }
        kt2 kt2Var = this.f;
        if (kt2Var != null) {
            kt2Var.c(this);
        }
        ActivityChatBuildBinding activityChatBuildBinding2 = this.e;
        if (activityChatBuildBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatBuildBinding = activityChatBuildBinding2;
        }
        activityChatBuildBinding.l.setPanelSwitchHelper(this.f);
    }

    public final void p5(iv1 iv1Var) {
        uq2 uq2Var = new is3.c() { // from class: dc.uq2
            @Override // dc.is3.c
            public final void doCancel() {
                NewChatActivity.q5();
            }
        };
        if (od3.c(this.activity)) {
            if (iv1Var != null) {
                iv1Var.next();
                return;
            }
            return;
        }
        is3.b bVar = new is3.b(this.activity);
        bVar.p(ah4.e(R.string.enable_floating_window_des2));
        bVar.o(ah4.e(R.string.button_go_to_settings));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new is3.d() { // from class: dc.vq2
            @Override // dc.is3.d
            public final void doConfirm() {
                NewChatActivity.r5(this.a);
            }
        });
        bVar.c(uq2Var);
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        cs3.h(bVar).show();
    }

    public final void s5(int i2) {
        this.j = true;
        G4();
        UserJoinChatBean userJoinChatBean = this.l;
        if (userJoinChatBean == null) {
            finish();
            return;
        }
        Unit unit = null;
        ActivityChatBuildBinding activityChatBuildBinding = null;
        if (userJoinChatBean != null) {
            RouletteChatEndActivity.a aVar = RouletteChatEndActivity.g;
            ActivityChatBuildBinding activityChatBuildBinding2 = this.e;
            if (activityChatBuildBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityChatBuildBinding = activityChatBuildBinding2;
            }
            aVar.a(this, userJoinChatBean, i2, activityChatBuildBinding.j.getText().toString());
            E4(i2);
            finish();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            finish();
        }
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        super.settingBarColor();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        Window window = getWindow();
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                window.setNavigationBarColor(Color.parseColor("#1E1F29"));
                return;
            } else {
                window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
                return;
            }
        }
        if (i2 == 2) {
            window.setNavigationBarColor(Color.parseColor("#1E1F29"));
        } else {
            window.setNavigationBarColor(Color.parseColor("#F7F8F9"));
        }
    }

    public void t() {
        this.b.d();
    }

    @Override // dc.vr2.b
    public void t2() {
        G4();
        J4().N();
    }

    public void v() {
        this.b.b();
    }
}
