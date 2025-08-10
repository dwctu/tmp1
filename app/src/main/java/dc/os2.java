package dc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserRoulette;
import com.wear.bean.chat.PanelStatus;
import com.wear.bean.chat.ReceiveToyOrderDataEntityAdapter;
import com.wear.bean.chat.SignalingMessageExtra;
import com.wear.bean.chat.SignalingRequest;
import com.wear.bean.chat.ToyInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.databinding.ViewSyncControlBinding;
import com.wear.ext.ActivityKt;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ht2;
import dc.is3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ControlSyncFunctionPanelAdapter.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B/\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\n\u0010,\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020$H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eJ\u0010\u00103\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0006\u00104\u001a\u00020\"J\u0006\u00105\u001a\u00020\"J\u0006\u00106\u001a\u00020\"J)\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J)\u0010=\u001a\u00020\"2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J)\u0010>\u001a\u00020\"2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J)\u0010?\u001a\u00020\"2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J1\u0010@\u001a\u00020\"2\u0006\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010A\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020\"2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010H\u001a\u00020\"H\u0002J\u0010\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020\fH\u0016J\u0010\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020$H\u0016J\u0010\u0010M\u001a\u00020\"2\u0006\u0010L\u001a\u00020$H\u0016J\b\u0010N\u001a\u00020\"H\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/wear/ui/chat/controller/ControlSyncFunctionPanelAdapter;", "Lcom/wear/ui/chat/controller/FunctionPanelAdapter;", "Lcom/wear/databinding/ViewSyncControlBinding;", "Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveMessageHandler;", "Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter$ReceiveToyOrderDataEntityListener;", "Lcom/wear/main/longDistance/control/SyncLiveControlFuncListener;", "Lcom/wear/listenter/ISyncLiveListener;", "panelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "velvoPreviewView", "Lcom/wear/widget/velvo/VelvoPreviewView;", "userAccountCode", "", "userToy", "", "Lcom/wear/bean/chat/ToyInfo;", "(Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;Lcom/wear/widget/velvo/VelvoPreviewView;Ljava/lang/String;Ljava/util/List;)V", "binding", "chatSyncControl", "Lcom/wear/main/longDistance/control/ChatSyncControl;", "isInitiativeLaunch", "", "()Ljava/lang/Boolean;", "setInitiativeLaunch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "panelView", "Landroid/view/ViewGroup;", "recordSyncFeatures", "showToastTime", "", "user", "Lcom/wear/bean/UserRoulette;", "addSyncControlEndLog", "", "elementContent", "", "addViewToActivity", "root", "Landroid/view/View;", "closeBottom", "tempUser", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "endControl", "getChatPeople", "getTriggerViewId", "getViewBinding", "initializeControl", "panelStatus", "Lcom/wear/bean/chat/PanelStatus;", "ext", "onBinding", "onPanelDestroyClear", "onPanelHidden", "onPanelVisible", "receiveActionCancel", "type", "syn", "extra", "Lcom/wear/bean/chat/SignalingMessageExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;)V", "receiveActionEnd", "receiveActionReject", "receiveActionRequest", "receiveActionStart", "receiveStart", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;Z)V", "receiveActionTimeout", "receiveToyOrder", "entity", "Lcom/wear/protocol/DataEntityAbstract;", "showLiveControl", "showPopupPermissionDialog", "switchControlToy", "mac", "switchControler", XHTMLText.CODE, "switchFunc", "updataUserSelf", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class os2 extends rs2<ViewSyncControlBinding> implements ht2.a, ReceiveToyOrderDataEntityAdapter.ReceiveToyOrderDataEntityListener, va2, jv1 {

    @NotNull
    public final PanelSwitchLayout b;

    @NotNull
    public final VelvoPreviewView c;

    @Nullable
    public final String d;

    @Nullable
    public final List<ToyInfo> e;

    @Nullable
    public ViewSyncControlBinding f;

    @Nullable
    public Boolean g;

    @Nullable
    public UserRoulette h;

    @Nullable
    public ViewGroup i;

    @Nullable
    public ChatSyncControl j;
    public long k;

    @Nullable
    public List<String> l;

    /* compiled from: ControlSyncFunctionPanelAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewSyncControlBinding> {
        public static final a a = new a();

        public a() {
            super(3, ViewSyncControlBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/ViewSyncControlBinding;", 0);
        }

        @NotNull
        public final ViewSyncControlBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewSyncControlBinding.c(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewSyncControlBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os2(@NotNull PanelSwitchLayout panelSwitchLayout, @NotNull VelvoPreviewView velvoPreviewView, @Nullable String str, @Nullable List<ToyInfo> list) {
        super(a.a);
        Intrinsics.checkNotNullParameter(panelSwitchLayout, "panelSwitchLayout");
        Intrinsics.checkNotNullParameter(velvoPreviewView, "velvoPreviewView");
        this.b = panelSwitchLayout;
        this.c = velvoPreviewView;
        this.d = str;
        this.e = list;
        this.g = Boolean.FALSE;
    }

    public static final void A(os2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PanelSwitchLayout.t(this$0.b, R.id.control_sync_function_panel, false, 2, null);
        ChatSyncControl chatSyncControl = this$0.j;
        if (chatSyncControl != null) {
            chatSyncControl.l1();
        }
        ChatSyncControl chatSyncControl2 = this$0.j;
        if (chatSyncControl2 != null) {
            chatSyncControl2.H1();
        }
    }

    public static final void G() {
        od3.d(ActivityKt.e());
    }

    public static final void H() {
        MyApplication.i0 = true;
    }

    public static final void x(final os2 this$0, ViewSyncControlBinding binding) {
        LinearLayout root;
        int measuredHeight;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        ViewSyncControlBinding viewSyncControlBinding = this$0.f;
        if (viewSyncControlBinding == null || (root = viewSyncControlBinding.getRoot()) == null) {
            return;
        }
        root.getHeight();
        RelativeLayout root2 = binding.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.syncLdrLayer.root");
        if (root2.getVisibility() == 0) {
            measuredHeight = binding.d.getRoot().getMeasuredHeight();
        } else {
            ViewSyncControlBinding viewSyncControlBinding2 = this$0.f;
            Intrinsics.checkNotNull(viewSyncControlBinding2);
            LinearLayout linearLayout = viewSyncControlBinding2.c;
            Intrinsics.checkNotNull(linearLayout, "null cannot be cast to non-null type android.view.ViewGroup");
            int childCount = linearLayout.getChildCount();
            int measuredHeight2 = 0;
            for (int i = 0; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(i);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) childAt;
                measuredHeight2 += viewGroup.getVisibility() == 0 ? viewGroup.getMeasuredHeight() : 0;
            }
            NewLDRPanel newLDRPanel = binding.b;
            Intrinsics.checkNotNullExpressionValue(newLDRPanel, "binding.ldrPanel");
            int measuredHeight3 = measuredHeight2 + (newLDRPanel.getVisibility() == 0 ? binding.b.getMeasuredHeight() : 0);
            ViewGroup.LayoutParams layoutParams = binding.c.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            measuredHeight = measuredHeight3 - (layoutParams2 != null ? ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin : 0);
        }
        if ((ps2.a() == 0 || ps2.a() != measuredHeight) && measuredHeight != 0) {
            ps2.b(measuredHeight);
            ViewParent parent = binding.getRoot().getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                ViewGroup.LayoutParams layoutParams3 = viewGroup2.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                layoutParams3.height = measuredHeight;
                viewGroup2.setLayoutParams(layoutParams3);
            }
            this$0.b.post(new Runnable() { // from class: dc.hs2
                @Override // java.lang.Runnable
                public final void run() {
                    os2.z(this.a);
                }
            });
        }
    }

    public static final void z(os2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        ChatSyncControl chatSyncControl;
        ChatSyncControl chatSyncControl2 = this.j;
        if (chatSyncControl2 != null && ((User) chatSyncControl2.J()) != null && (chatSyncControl = this.j) != null) {
            chatSyncControl.I0(false, false);
        }
        ChatSyncControl chatSyncControl3 = this.j;
        if (chatSyncControl3 != null) {
            chatSyncControl3.Q0();
        }
    }

    public final void C() {
        ChatSyncControl chatSyncControl = this.j;
        if (chatSyncControl != null && chatSyncControl.r()) {
            F();
            ChatSyncControl chatSyncControl2 = this.j;
            if (chatSyncControl2 != null) {
                chatSyncControl2.B1();
            }
        }
    }

    public final void D() {
        ChatSyncControl chatSyncControl = this.j;
        if (chatSyncControl != null) {
            chatSyncControl.Q0();
        }
    }

    public final void E(@Nullable Boolean bool) {
        this.g = bool;
    }

    public final void F() {
        if (MyApplication.i0 || od3.c(ActivityKt.e())) {
            return;
        }
        is3.b bVar = new is3.b(ActivityKt.e());
        bVar.p(ah4.e(R.string.enable_floating_window_des));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new is3.d() { // from class: dc.ks2
            @Override // dc.is3.d
            public final void doConfirm() {
                os2.G();
            }
        });
        bVar.c(new is3.c() { // from class: dc.is2
            @Override // dc.is3.c
            public final void doCancel() {
                os2.H();
            }
        });
        bVar.q(ah4.e(R.string.enable_floating_window_title));
        is3 is3VarH = cs3.h(bVar);
        if (is3VarH != null) {
            is3VarH.show();
        }
    }

    public final void I() {
        Account accountU = WearUtils.y.u();
        if (accountU == null) {
            return;
        }
        accountU.setCurrentControlType(MessageType.sync);
        Boolean bool = this.g;
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        accountU.setLiveStatus(2);
    }

    @Override // dc.va2
    public void a() {
        this.g = Boolean.FALSE;
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        signalingMessageExtra.setType(1);
        ht2 ht2Var = ht2.a;
        String str = this.d;
        Intrinsics.checkNotNull(str);
        ht2Var.x(new SignalingRequest(null, str, "SyncControl", null, signalingMessageExtra, 9, null));
        PanelSwitchLayout.t(this.b, -1, false, 2, null);
        o(1);
    }

    @Override // dc.jv1
    public void addViewToActivity(@Nullable View root) {
        ViewParent parent = root != null ? root.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(root);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.addView(root);
        }
    }

    @Override // dc.ht2.a
    public void b(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        it2.b.a().getA().set(false);
        if (!na2.m().i() && Intrinsics.areEqual(type, "SyncControl") && System.currentTimeMillis() - this.k > 10000) {
            sg3.h(R.string.player_connect_error);
            this.k = System.currentTimeMillis();
        }
    }

    @Override // dc.va2
    public void c(int i) {
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        if (i == 0) {
            signalingMessageExtra.setControlMode(2);
        } else if (i == 1) {
            signalingMessageExtra.setControlMode(1);
        } else if (i == 2) {
            signalingMessageExtra.setControlMode(3);
        }
        String str = this.d;
        if (str != null) {
            ht2.a.x(new SignalingRequest(null, str, "SwitchControlMode", null, signalingMessageExtra, 8, null));
        }
    }

    @Override // dc.ht2.a
    public void d(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra, boolean z) {
        List<String> features;
        Intrinsics.checkNotNullParameter(type, "type");
        it2.b.a().getA().set(false);
        if ((signalingMessageExtra == null || (features = signalingMessageExtra.getFeatures()) == null || !(features.isEmpty() ^ true)) ? false : true) {
            q(null, signalingMessageExtra.getFeatures());
        } else {
            q(null, this.l);
        }
        PanelSwitchLayout.t(this.b, R.id.control_sync_function_panel, false, 2, null);
        ku1.f("control roulette chatroom", "control_roulette_control_start_click", "control_roulette_control_start", (40 & 8) != 0 ? null : null, (40 & 16) != 0 ? null : "2", (40 & 32) != 0 ? null : null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // dc.ht2.a
    public void e(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Integer controlMode;
        ChatSyncControl chatSyncControl;
        ChatSyncControl chatSyncControl2;
        oa2 oa2Var;
        Integer type2;
        Integer type3;
        Intrinsics.checkNotNullParameter(type, "type");
        switch (type.hashCode()) {
            case -1889565524:
                if (type.equals("SwitchControlMode")) {
                    controlMode = signalingMessageExtra != null ? signalingMessageExtra.getControlMode() : null;
                    if (controlMode == null || controlMode.intValue() != 1) {
                        if (controlMode == null || controlMode.intValue() != 2) {
                            if (controlMode != null && controlMode.intValue() == 3 && (chatSyncControl = this.j) != null) {
                                chatSyncControl.O1(-1, false);
                                break;
                            }
                        } else {
                            ChatSyncControl chatSyncControl3 = this.j;
                            if (chatSyncControl3 != null) {
                                chatSyncControl3.O1(-1, false);
                                break;
                            }
                        }
                    } else {
                        ChatSyncControl chatSyncControl4 = this.j;
                        if (chatSyncControl4 != null) {
                            chatSyncControl4.O1(-1, false);
                            break;
                        }
                    }
                }
                break;
            case -1307872971:
                if (type.equals("SwitchControlToy") && signalingMessageExtra != null && (chatSyncControl2 = this.j) != null && (oa2Var = chatSyncControl2.p) != null) {
                    oa2Var.g0(false, signalingMessageExtra.getToyMac());
                    break;
                }
                break;
            case 977827362:
                if (type.equals("SyncControl")) {
                    if (!((signalingMessageExtra == null || (type3 = signalingMessageExtra.getType()) == null || type3.intValue() != 1) ? false : true)) {
                        if (((signalingMessageExtra == null || (type2 = signalingMessageExtra.getType()) == null || type2.intValue() != 0) ? false : true) && !it2.b.a().getA().get()) {
                            this.l = signalingMessageExtra.getFeatures();
                            signalingMessageExtra.setFeatures(CollectionsKt__CollectionsJVMKt.listOf(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE));
                            ht2 ht2Var = ht2.a;
                            String str = this.d;
                            Intrinsics.checkNotNull(str);
                            ht2.b(ht2Var, new SignalingRequest(l, str, type, null, signalingMessageExtra, 8, null), 0L, 2, null);
                            break;
                        }
                    } else {
                        ChatSyncControl chatSyncControl5 = this.j;
                        if (chatSyncControl5 != null) {
                            chatSyncControl5.I0(false, false);
                        }
                        this.g = Boolean.FALSE;
                        PanelSwitchLayout.t(this.b, -1, false, 2, null);
                        o(2);
                        break;
                    }
                }
                break;
            case 1641156819:
                if (type.equals("SwitchPanelMode")) {
                    controlMode = signalingMessageExtra != null ? signalingMessageExtra.getPanelMode() : null;
                    if (controlMode == null || controlMode.intValue() != 1) {
                        if (controlMode == null || controlMode.intValue() != 2) {
                            if (controlMode == null || controlMode.intValue() != 3) {
                                if (controlMode != null) {
                                    controlMode.intValue();
                                    break;
                                }
                            } else {
                                ChatSyncControl chatSyncControl6 = this.j;
                                if (chatSyncControl6 != null) {
                                    chatSyncControl6.A0(4, false);
                                    break;
                                }
                            }
                        } else {
                            ChatSyncControl chatSyncControl7 = this.j;
                            if (chatSyncControl7 != null) {
                                chatSyncControl7.T1(false);
                                break;
                            }
                        }
                    } else {
                        ChatSyncControl chatSyncControl8 = this.j;
                        if (chatSyncControl8 != null) {
                            chatSyncControl8.A0(1, false);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // dc.va2
    public void f(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        signalingMessageExtra.setToyMac(mac);
        String str = this.d;
        if (str != null) {
            ht2.a.x(new SignalingRequest(null, str, "SwitchControlToy", null, signalingMessageExtra, 8, null));
        }
    }

    @Override // dc.ht2.a
    public void g(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // dc.va2
    public void h(int i) {
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        signalingMessageExtra.setPanelMode(Integer.valueOf(i));
        ht2 ht2Var = ht2.a;
        String str = this.d;
        Intrinsics.checkNotNull(str);
        ht2Var.x(new SignalingRequest(null, str, "SwitchPanelMode", null, signalingMessageExtra, 8, null));
    }

    @Override // dc.ht2.a
    public void i(@NotNull String type, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // dc.rs2
    public int k() {
        return R.id.control_sync_function_panel;
    }

    @Override // dc.jv1
    public void l(@Nullable IPeopleInfo iPeopleInfo) {
    }

    public final void o(int i) {
        Integer numValueOf = Integer.valueOf(i);
        ChatSyncControl chatSyncControl = this.j;
        ku1.f("control roulette chatroom", "control_roulette_control_end_click", "control_roulette_control_end", numValueOf, "2", Integer.valueOf(WearUtils.C0(chatSyncControl != null ? chatSyncControl.K0() : null)));
    }

    @Override // dc.rs2
    @Nullable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ViewSyncControlBinding m() {
        View viewO0 = ChatSyncControl.N0().O0();
        if (viewO0 == null) {
            return null;
        }
        return ViewSyncControlBinding.a(viewO0);
    }

    public final void q(@Nullable PanelStatus panelStatus, @Nullable List<String> list) {
        ChatSyncControl chatSyncControl;
        Activity activityE = ActivityKt.e();
        NewChatActivity newChatActivity = activityE instanceof NewChatActivity ? (NewChatActivity) activityE : null;
        if (newChatActivity != null) {
            newChatActivity.K4();
        }
        xz1.a();
        String str = this.d;
        if (str != null) {
            this.h = new UserRoulette(this.e, str);
            I();
            UserRoulette userRoulette = this.h;
            if (userRoulette != null) {
                userRoulette.setFeature(list);
            }
            UserRoulette userRoulette2 = this.h;
            if (userRoulette2 != null) {
                userRoulette2.setSupportLdrTouchPanel(true);
            }
            ChatSyncControl chatSyncControl2 = this.j;
            if (chatSyncControl2 != null) {
                chatSyncControl2.L(this.h);
            }
            if (Intrinsics.areEqual(this.g, Boolean.TRUE)) {
                ChatSyncControl chatSyncControl3 = this.j;
                if (chatSyncControl3 != null) {
                    chatSyncControl3.I1(MessageType.sync);
                }
            } else {
                ChatSyncControl chatSyncControl4 = this.j;
                if (chatSyncControl4 != null) {
                    chatSyncControl4.f0(this.h, false);
                }
                ChatSyncControl chatSyncControl5 = this.j;
                if (chatSyncControl5 != null) {
                    chatSyncControl5.e1(this.h);
                }
            }
            if (panelStatus != null) {
                Integer panelMode = panelStatus.getPanelMode();
                if (panelMode != null && panelMode.intValue() == 1) {
                    Integer controlMode = panelStatus.getControlMode();
                    if (controlMode != null && controlMode.intValue() == 3) {
                        ChatSyncControl chatSyncControl6 = this.j;
                        if (chatSyncControl6 != null) {
                            chatSyncControl6.A0(1, false);
                        }
                        ChatSyncControl chatSyncControl7 = this.j;
                        if (chatSyncControl7 != null) {
                            chatSyncControl7.O1(1, false);
                        }
                    } else {
                        ChatSyncControl chatSyncControl8 = this.j;
                        if (chatSyncControl8 != null) {
                            chatSyncControl8.A0(2, false);
                        }
                    }
                    ToyBean toyBean = new ToyBean();
                    toyBean.setAll(0);
                    na2.m().y(null, toyBean, false);
                } else if (panelMode != null && panelMode.intValue() == 2) {
                    ChatSyncControl chatSyncControl9 = this.j;
                    if (chatSyncControl9 != null) {
                        chatSyncControl9.T1(false);
                    }
                } else if (panelMode != null && panelMode.intValue() == 3 && (chatSyncControl = this.j) != null) {
                    chatSyncControl.A0(4, false);
                }
                PanelSwitchLayout.t(this.b, R.id.control_sync_function_panel, false, 2, null);
            }
        }
    }

    @Override // com.wear.bean.chat.ReceiveToyOrderDataEntityAdapter.ReceiveToyOrderDataEntityListener
    public void receiveToyOrder(@NotNull DataEntityAbstract entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        it2.b.a().c((EntityToy) entity);
    }

    @Override // dc.rs2
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull final ViewSyncControlBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f = binding;
        Intrinsics.checkNotNull(binding);
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: dc.ls2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                os2.x(this.a, binding);
            }
        });
        ViewParent parent = binding.getRoot().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        this.i = (ViewGroup) parent;
        ht2 ht2Var = ht2.a;
        ht2Var.f("SyncControl", this);
        ht2Var.f("SwitchControlMode", this);
        ht2Var.f("SwitchPanelMode", this);
        ht2Var.f("SwitchControlToy", this);
        ht2Var.g("SyncControl", new ReceiveToyOrderDataEntityAdapter(this));
        ChatSyncControl chatSyncControlN0 = ChatSyncControl.N0();
        chatSyncControlN0.w(this);
        chatSyncControlN0.z1(this);
        chatSyncControlN0.A1(this.c);
        this.j = chatSyncControlN0;
        if (my2.i.a().getB()) {
            ChatSyncControl chatSyncControl = this.j;
            Intrinsics.checkNotNull(chatSyncControl);
            if (chatSyncControl.r()) {
                this.b.post(new Runnable() { // from class: dc.js2
                    @Override // java.lang.Runnable
                    public final void run() {
                        os2.A(this.a);
                    }
                });
            }
        }
    }

    @Override // dc.jv1
    public void y(@Nullable IPeopleInfo iPeopleInfo) {
    }
}
