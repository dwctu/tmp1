package dc;

import android.text.TextUtils;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.bean.chat.NotifyClientLineTcBean;
import com.wear.bean.chat.PanelStatus;
import com.wear.bean.chat.SignalingMessageExtra;
import com.wear.bean.chat.SignalingRequest;
import com.wear.databinding.PanelChatContainerBinding;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.ui.chat.NewChatViewModel;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.ui.chat.pancel.helper.view.pannel.PanelContainer;
import com.wear.util.WearUtils;
import com.wear.widget.velvo.VelvoPreviewView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionPanelIml.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/wear/ui/chat/controller/FunctionPanelIml;", "Lcom/wear/ui/chat/controller/FunctionPanel;", "()V", "controlLiveAdapter", "Lcom/wear/ui/chat/controller/ControlLiveFunctionPanelAdapter;", "controlSyncAdapter", "Lcom/wear/ui/chat/controller/ControlSyncFunctionPanelAdapter;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "isInitiativeLaunch", "", "Ljava/lang/Boolean;", "panelSwitchLayout", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "viewModel", "Lcom/wear/ui/chat/NewChatViewModel;", "bindFunctionPanelsViewModel", "", "createLiveControl", "createPanels", "binding", "Lcom/wear/databinding/PanelChatContainerBinding;", "velvoPreview", "Lcom/wear/widget/velvo/VelvoPreviewView;", "createSyncControl", "initFunctionPanels", "initiate", "onPanelDestroyClear", "onPanelHidden", "triggerViewId", "", "onPanelVisible", "onReconnectLiveControlSyncControlState", "notifyClientLineTcBean", "Lcom/wear/bean/chat/NotifyClientLineTcBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ts2 {

    @Nullable
    public NewChatViewModel a;

    @Nullable
    public ie3 b;

    @Nullable
    public PanelSwitchLayout c;

    @Nullable
    public Boolean d = Boolean.FALSE;

    @Nullable
    public ms2 e;

    @Nullable
    public os2 f;

    public void a(@NotNull NewChatViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.a = viewModel;
    }

    public void b() {
        String c;
        if (ChatLiveControl.q0().r()) {
            PanelSwitchLayout panelSwitchLayout = this.c;
            if (panelSwitchLayout != null) {
                PanelSwitchLayout.t(panelSwitchLayout, R.id.control_function_panel, false, 2, null);
                return;
            }
            return;
        }
        if (ChatSyncControl.N0().r()) {
            sg3.h(R.string.sync_conflict_toast);
            return;
        }
        NewChatViewModel newChatViewModel = this.a;
        if (newChatViewModel != null && (c = newChatViewModel.getC()) != null) {
            SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
            signalingMessageExtra.setType(0);
            ht2.a.x(new SignalingRequest(null, c, "LiveControl", null, signalingMessageExtra, 9, null));
        }
        it2.b.a().getA().set(true);
        sg3.h(R.string.chat_waiting_accep_tance_auto);
    }

    public final void c(PanelChatContainerBinding panelChatContainerBinding, VelvoPreviewView velvoPreviewView) {
        panelChatContainerBinding.getRoot().removeAllViews();
        ss2 ss2Var = new ss2(panelChatContainerBinding);
        NewChatViewModel newChatViewModel = this.a;
        Intrinsics.checkNotNull(newChatViewModel);
        ie3 ie3Var = this.b;
        Intrinsics.checkNotNull(ie3Var);
        ss2Var.a(new qs2(newChatViewModel, ie3Var));
        PanelSwitchLayout panelSwitchLayout = this.c;
        Intrinsics.checkNotNull(panelSwitchLayout);
        NewChatViewModel newChatViewModel2 = this.a;
        String c = newChatViewModel2 != null ? newChatViewModel2.getC() : null;
        NewChatViewModel newChatViewModel3 = this.a;
        ms2 ms2Var = new ms2(panelSwitchLayout, velvoPreviewView, c, newChatViewModel3 != null ? newChatViewModel3.q() : null);
        this.e = ms2Var;
        Intrinsics.checkNotNull(ms2Var);
        ss2Var.a(ms2Var);
        PanelSwitchLayout panelSwitchLayout2 = this.c;
        Intrinsics.checkNotNull(panelSwitchLayout2);
        NewChatViewModel newChatViewModel4 = this.a;
        String c2 = newChatViewModel4 != null ? newChatViewModel4.getC() : null;
        NewChatViewModel newChatViewModel5 = this.a;
        os2 os2Var = new os2(panelSwitchLayout2, velvoPreviewView, c2, newChatViewModel5 != null ? newChatViewModel5.q() : null);
        this.f = os2Var;
        if (os2Var != null) {
            ss2Var.a(os2Var);
            os2Var.E(this.d);
        }
    }

    public void d() {
        String c;
        if (ChatSyncControl.N0().r()) {
            PanelSwitchLayout panelSwitchLayout = this.c;
            if (panelSwitchLayout != null) {
                PanelSwitchLayout.t(panelSwitchLayout, R.id.control_sync_function_panel, false, 2, null);
                return;
            }
            return;
        }
        if (ChatLiveControl.q0().r()) {
            sg3.h(R.string.live_conflict_toast);
            return;
        }
        NewChatViewModel newChatViewModel = this.a;
        if (newChatViewModel != null && (c = newChatViewModel.getC()) != null) {
            SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
            signalingMessageExtra.setType(0);
            signalingMessageExtra.setFeatures(CollectionsKt__CollectionsJVMKt.listOf(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE));
            ht2.a.x(new SignalingRequest(null, c, "SyncControl", null, signalingMessageExtra, 9, null));
            f();
        }
        it2.b.a().getA().set(true);
        sg3.h(R.string.chat_waiting_accep_tance_auto);
    }

    public void e(@NotNull PanelSwitchLayout panelSwitchLayout, @NotNull ie3 emojisUtils, @NotNull VelvoPreviewView velvoPreview) {
        Intrinsics.checkNotNullParameter(panelSwitchLayout, "panelSwitchLayout");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        Intrinsics.checkNotNullParameter(velvoPreview, "velvoPreview");
        this.b = emojisUtils;
        this.c = panelSwitchLayout;
        PanelContainer panelContainer$app_marketRelease = panelSwitchLayout.getPanelContainer$app_marketRelease();
        PanelChatContainerBinding panelChatContainerBindingA = PanelChatContainerBinding.a(panelContainer$app_marketRelease);
        Intrinsics.checkNotNullExpressionValue(panelChatContainerBindingA, "bind(panelContainer)");
        c(panelChatContainerBindingA, velvoPreview);
        panelContainer$app_marketRelease.a();
        panelSwitchLayout.u();
    }

    public final void f() {
        Boolean bool = Boolean.TRUE;
        this.d = bool;
        os2 os2Var = this.f;
        if (os2Var != null) {
            os2Var.E(bool);
        }
    }

    public void g() {
        ms2 ms2Var = this.e;
        if (ms2Var != null) {
            ms2Var.B();
        }
        os2 os2Var = this.f;
        if (os2Var != null) {
            os2Var.B();
        }
    }

    public void h(int i) {
        os2 os2Var;
        if (i == -1) {
            ms2 ms2Var = this.e;
            if (ms2Var != null) {
                ms2Var.C();
            }
            os2 os2Var2 = this.f;
            if (os2Var2 != null) {
                os2Var2.C();
                return;
            }
            return;
        }
        if (i != R.id.control_function_panel) {
            if (i == R.id.control_sync_function_panel && (os2Var = this.f) != null) {
                os2Var.C();
                return;
            }
            return;
        }
        ms2 ms2Var2 = this.e;
        if (ms2Var2 != null) {
            ms2Var2.C();
        }
    }

    public void i(int i) {
        os2 os2Var;
        if (i != R.id.control_function_panel) {
            h(R.id.control_function_panel);
        }
        if (i != R.id.control_sync_function_panel) {
            h(R.id.control_sync_function_panel);
        }
        if (i != R.id.control_function_panel) {
            if (i == R.id.control_sync_function_panel && (os2Var = this.f) != null) {
                os2Var.D();
                return;
            }
            return;
        }
        ms2 ms2Var = this.e;
        if (ms2Var != null) {
            ms2Var.D();
        }
    }

    public void j(@Nullable NotifyClientLineTcBean notifyClientLineTcBean) {
        os2 os2Var;
        if (notifyClientLineTcBean == null || TextUtils.isEmpty(notifyClientLineTcBean.getPanelStatus())) {
            return;
        }
        Object objFromJson = WearUtils.A.fromJson(notifyClientLineTcBean.getPanelStatus(), (Class<Object>) PanelStatus.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(notifyClie… PanelStatus::class.java)");
        PanelStatus panelStatus = (PanelStatus) objFromJson;
        if (TextUtils.equals(panelStatus.getControlType(), "LiveControl")) {
            ms2 ms2Var = this.e;
            if (ms2Var != null) {
                ms2Var.q();
                return;
            }
            return;
        }
        if (!TextUtils.equals(panelStatus.getControlType(), "SyncControl") || (os2Var = this.f) == null) {
            return;
        }
        os2Var.q(panelStatus, panelStatus.getFeatures());
    }
}
