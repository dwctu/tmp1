package dc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.chat.ReceiveToyOrderDataEntityAdapter;
import com.wear.bean.chat.SignalingMessageExtra;
import com.wear.bean.chat.SignalingRequest;
import com.wear.bean.chat.ToyInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.databinding.ViewLiveControlBinding;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ht2;
import dc.is3;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ControlLiveFunctionPanelAdapter.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006B3\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020#H\u0016J\n\u0010-\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020%H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u00100\u001a\u00020#J\u0010\u00101\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020#J\u0006\u00104\u001a\u00020#J)\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J)\u0010;\u001a\u00020#2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J)\u0010<\u001a\u00020#2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J)\u0010=\u001a\u00020#2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J1\u0010>\u001a\u00020#2\u0006\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020#2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020EH\u0016J\u0012\u0010F\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010G\u001a\u00020#H\u0002J\u0010\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020%H\u0016J\u0010\u0010L\u001a\u00020#2\u0006\u0010K\u001a\u00020%H\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/wear/ui/chat/controller/ControlLiveFunctionPanelAdapter;", "Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter$ReceiveToyOrderDataEntityListener;", "Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveMessageHandler;", "Lcom/wear/ui/chat/controller/FunctionPanelAdapter;", "Lcom/wear/databinding/ViewLiveControlBinding;", "Lcom/wear/main/longDistance/control/SyncLiveControlFuncListener;", "Lcom/wear/listenter/ISyncLiveListener;", "panelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "velvoPreviewView", "Lcom/wear/widget/velvo/VelvoPreviewView;", "userAccountCode", "", "userToy", "", "Lcom/wear/bean/chat/ToyInfo;", "(Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;Lcom/wear/widget/velvo/VelvoPreviewView;Ljava/lang/String;Ljava/util/List;)V", "binding", "getBinding", "()Lcom/wear/databinding/ViewLiveControlBinding;", "setBinding", "(Lcom/wear/databinding/ViewLiveControlBinding;)V", "isEndControl", "Ljava/util/concurrent/atomic/AtomicBoolean;", "liveControl", "Lcom/wear/main/longDistance/control/ChatLiveControl;", "showToastTime", "", "user", "Lcom/wear/bean/UserRoulette;", "getUser", "()Lcom/wear/bean/UserRoulette;", "setUser", "(Lcom/wear/bean/UserRoulette;)V", "addLiveControlEndLog", "", "elementContent", "", "addViewToActivity", "root", "Landroid/view/View;", "closeBottom", "tempUser", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "endControl", "getChatPeople", "getTriggerViewId", "getViewBinding", "initializeControl", "onBinding", "onPanelDestroyClear", "onPanelHidden", "onPanelVisible", "receiveActionCancel", "type", "syn", "extra", "Lcom/wear/bean/chat/SignalingMessageExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;)V", "receiveActionEnd", "receiveActionReject", "receiveActionRequest", "receiveActionStart", "receiveStart", "", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;Z)V", "receiveActionTimeout", "receiveToyOrder", "entity", "Lcom/wear/protocol/DataEntityAbstract;", "showLiveControl", "showPopupPermissionDialog", "switchControlToy", "mac", "switchControler", XHTMLText.CODE, "switchFunc", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ms2 extends rs2<ViewLiveControlBinding> implements ReceiveToyOrderDataEntityAdapter.ReceiveToyOrderDataEntityListener, ht2.a, va2, jv1 {

    @NotNull
    public final PanelSwitchLayout b;

    @NotNull
    public final VelvoPreviewView c;

    @Nullable
    public final String d;

    @Nullable
    public final List<ToyInfo> e;

    @Nullable
    public ViewLiveControlBinding f;

    @Nullable
    public UserRoulette g;
    public long h;

    @Nullable
    public ChatLiveControl i;

    @NotNull
    public AtomicBoolean j;

    /* compiled from: ControlLiveFunctionPanelAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewLiveControlBinding> {
        public static final a a = new a();

        public a() {
            super(3, ViewLiveControlBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/ViewLiveControlBinding;", 0);
        }

        @NotNull
        public final ViewLiveControlBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewLiveControlBinding.c(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewLiveControlBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms2(@NotNull PanelSwitchLayout panelSwitchLayout, @NotNull VelvoPreviewView velvoPreviewView, @Nullable String str, @Nullable List<ToyInfo> list) {
        super(a.a);
        Intrinsics.checkNotNullParameter(panelSwitchLayout, "panelSwitchLayout");
        Intrinsics.checkNotNullParameter(velvoPreviewView, "velvoPreviewView");
        this.b = panelSwitchLayout;
        this.c = velvoPreviewView;
        this.d = str;
        this.e = list;
        this.j = new AtomicBoolean(false);
    }

    public static final void A(ms2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PanelSwitchLayout.t(this$0.b, R.id.control_function_panel, false, 2, null);
        ChatLiveControl chatLiveControl = this$0.i;
        if (chatLiveControl != null) {
            chatLiveControl.c1();
        }
    }

    public static final void F() {
        od3.d(ActivityKt.e());
    }

    public static final void G() {
        MyApplication.i0 = true;
    }

    public static final void x(final ms2 this$0, ViewLiveControlBinding binding) {
        LinearLayout root;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        ViewLiveControlBinding viewLiveControlBinding = this$0.f;
        if (viewLiveControlBinding == null || (root = viewLiveControlBinding.getRoot()) == null) {
            return;
        }
        root.getHeight();
        ViewLiveControlBinding viewLiveControlBinding2 = this$0.f;
        Intrinsics.checkNotNull(viewLiveControlBinding2);
        LinearLayout root2 = viewLiveControlBinding2.getRoot();
        Intrinsics.checkNotNull(root2, "null cannot be cast to non-null type android.view.ViewGroup");
        int childCount = root2.getChildCount();
        int measuredHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View child = root2.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(child, "child");
            measuredHeight += child.getVisibility() == 0 ? child.getMeasuredHeight() : 0;
        }
        if ((ns2.a() == 0 || ns2.a() != measuredHeight) && measuredHeight != 0) {
            ns2.b(measuredHeight);
            ViewParent parent = binding.getRoot().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                layoutParams.height = measuredHeight;
                viewGroup.setLayoutParams(layoutParams);
            }
            this$0.b.post(new Runnable() { // from class: dc.fs2
                @Override // java.lang.Runnable
                public final void run() {
                    ms2.z(this.a);
                }
            });
        }
    }

    public static final void z(ms2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        ChatLiveControl chatLiveControl;
        ChatLiveControl chatLiveControl2 = this.i;
        if (chatLiveControl2 != null && ((User) chatLiveControl2.J()) != null && (chatLiveControl = this.i) != null) {
            chatLiveControl.o0(false, false);
        }
        ChatLiveControl chatLiveControl3 = this.i;
        if (chatLiveControl3 != null) {
            chatLiveControl3.u0();
        }
    }

    public final void C() {
        ChatLiveControl chatLiveControl = this.i;
        if (chatLiveControl != null && chatLiveControl.r()) {
            E();
            ChatLiveControl chatLiveControl2 = this.i;
            if (chatLiveControl2 != null) {
                chatLiveControl2.v0();
            }
            ChatLiveControl chatLiveControl3 = this.i;
            if (chatLiveControl3 != null) {
                chatLiveControl3.Y0();
            }
        }
    }

    public final void D() {
        ChatLiveControl chatLiveControl = this.i;
        if (chatLiveControl != null) {
            chatLiveControl.Y0();
        }
        ChatLiveControl chatLiveControl2 = this.i;
        if (chatLiveControl2 != null) {
            chatLiveControl2.u0();
        }
    }

    public final void E() {
        if (MyApplication.i0 || od3.c(ActivityKt.e()) || ActivityKt.e() == null) {
            return;
        }
        is3.b bVar = new is3.b(ActivityKt.e());
        bVar.p(ah4.e(R.string.enable_floating_window_des));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new is3.d() { // from class: dc.cs2
            @Override // dc.is3.d
            public final void doConfirm() {
                ms2.F();
            }
        });
        bVar.c(new is3.c() { // from class: dc.es2
            @Override // dc.is3.c
            public final void doCancel() {
                ms2.G();
            }
        });
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        is3 is3VarH = cs3.h(bVar);
        if (is3VarH != null) {
            is3VarH.show();
        }
    }

    @Override // dc.va2
    public void a() {
        this.j.set(true);
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        signalingMessageExtra.setType(1);
        ht2 ht2Var = ht2.a;
        String str = this.d;
        Intrinsics.checkNotNull(str);
        ht2Var.x(new SignalingRequest(null, str, "LiveControl", null, signalingMessageExtra, 9, null));
        PanelSwitchLayout.t(this.b, -1, false, 2, null);
        o(1);
    }

    @Override // dc.jv1
    public void addViewToActivity(@Nullable View root) {
    }

    @Override // dc.ht2.a
    public void b(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        it2.b.a().getA().set(false);
        if (!na2.m().i() && Intrinsics.areEqual(type, "LiveControl") && System.currentTimeMillis() - this.h > 10000) {
            sg3.h(R.string.player_connect_error);
            this.h = System.currentTimeMillis();
        }
    }

    @Override // dc.va2
    public void c(int i) {
    }

    @Override // dc.ht2.a
    public void d(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        q();
        ku1.f("control roulette chatroom", "control_roulette_control_start_click", "control_roulette_control_start", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : "1", (40 & 32) != 0 ? null : null);
    }

    @Override // dc.ht2.a
    public void e(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        String str;
        Integer type2;
        Intrinsics.checkNotNullParameter(type, "type");
        if (!((signalingMessageExtra == null || (type2 = signalingMessageExtra.getType()) == null || type2.intValue() != 1) ? false : true)) {
            if (it2.b.a().getA().get() || (str = this.d) == null) {
                return;
            }
            ht2.b(ht2.a, new SignalingRequest(l, str, type, null, signalingMessageExtra, 8, null), 0L, 2, null);
            return;
        }
        ChatLiveControl chatLiveControl = this.i;
        if (chatLiveControl != null) {
            chatLiveControl.o0(false, false);
        }
        PanelSwitchLayout.t(this.b, -1, false, 2, null);
        o(2);
    }

    @Override // dc.va2
    public void f(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
    }

    @Override // dc.ht2.a
    public void g(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // dc.va2
    public void h(int i) {
    }

    @Override // dc.ht2.a
    public void i(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // dc.rs2
    public int k() {
        return R.id.control_function_panel;
    }

    @Override // dc.jv1
    public void l(@Nullable IPeopleInfo iPeopleInfo) {
    }

    public final void o(int i) {
        Integer numValueOf = Integer.valueOf(i);
        ChatLiveControl chatLiveControl = this.i;
        ku1.f("control roulette chatroom", "control_roulette_control_end_click", "control_roulette_control_end", numValueOf, "1", Integer.valueOf(WearUtils.C0(chatLiveControl != null ? chatLiveControl.p0() : null)));
    }

    @Override // dc.rs2
    @Nullable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ViewLiveControlBinding m() {
        View viewS0 = ChatLiveControl.q0().s0();
        if (viewS0 == null) {
            return null;
        }
        return ViewLiveControlBinding.a(viewS0);
    }

    public final void q() {
        this.j.set(false);
        Activity activityE = ActivityKt.e();
        NewChatActivity newChatActivity = activityE instanceof NewChatActivity ? (NewChatActivity) activityE : null;
        if (newChatActivity != null) {
            newChatActivity.K4();
        }
        xz1.a();
        it2.b.a().getA().set(false);
        ChatLiveControl chatLiveControl = this.i;
        if (chatLiveControl != null) {
            chatLiveControl.W0(this);
        }
        String str = this.d;
        if (str != null) {
            UserRoulette userRoulette = new UserRoulette(this.e, str);
            this.g = userRoulette;
            ChatLiveControl chatLiveControl2 = this.i;
            if (chatLiveControl2 != null) {
                chatLiveControl2.y0(userRoulette);
            }
            ChatLiveControl chatLiveControl3 = this.i;
            if (chatLiveControl3 != null) {
                chatLiveControl3.e1(MessageType.live);
            }
        }
        PanelSwitchLayout.t(this.b, R.id.control_function_panel, false, 2, null);
    }

    @Override // com.wear.bean.chat.ReceiveToyOrderDataEntityAdapter.ReceiveToyOrderDataEntityListener
    public void receiveToyOrder(@NotNull DataEntityAbstract entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (this.j.get()) {
            return;
        }
        it2.b.a().c((EntityToy) entity);
    }

    @Override // dc.rs2
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull final ViewLiveControlBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f = binding;
        Intrinsics.checkNotNull(binding);
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: dc.ds2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ms2.x(this.a, binding);
            }
        });
        ht2 ht2Var = ht2.a;
        ht2Var.f("LiveControl", this);
        ht2Var.g("LiveControl", new ReceiveToyOrderDataEntityAdapter(this));
        ChatLiveControl chatLiveControlR0 = ChatLiveControl.r0(binding.getRoot());
        chatLiveControlR0.W0(this);
        chatLiveControlR0.X0(this.c);
        this.i = chatLiveControlR0;
        if (my2.i.a().getB()) {
            ChatLiveControl chatLiveControl = this.i;
            Intrinsics.checkNotNull(chatLiveControl);
            if (chatLiveControl.r()) {
                this.b.post(new Runnable() { // from class: dc.gs2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ms2.A(this.a);
                    }
                });
                ChatLiveControl chatLiveControl2 = this.i;
                if (chatLiveControl2 != null) {
                    chatLiveControl2.U0();
                }
            }
        }
    }

    @Override // dc.jv1
    public void y(@Nullable IPeopleInfo iPeopleInfo) {
    }
}
