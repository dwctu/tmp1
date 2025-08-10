package dc;

import android.text.TextUtils;
import android.view.View;
import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogTracker.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J:\u0010\u001c\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/log/LogTracker;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnEditFocusChangeListener;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListener;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListener;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnViewClickListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "log", "", "methodName", "message", "onClickBefore", "view", "Landroid/view/View;", "onFocusChange", "hasFocus", "", "onKeyboard", "onKeyboardChange", "show", VideoCaptureFormat.keyHeight, "", "onNone", "onPanel", "panel", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "onPanelSizeChange", "portrait", "oldWidth", "oldHeight", VideoCaptureFormat.keyWidth, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class au2 implements tt2, ut2, wt2, yt2 {

    @NotNull
    public static final au2 a = new au2();

    @JvmStatic
    public static final void g(@NotNull String methodName, @NotNull String message) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(message, "message");
        if (TextUtils.isEmpty(methodName) || TextUtils.isEmpty(message) || !jt2.b) {
            return;
        }
        String str = methodName + " => " + message;
    }

    @Override // dc.yt2
    public void a(@Nullable View view) {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("view is ");
        if (view == null || (string = view.toString()) == null) {
            string = " null ";
        }
        sb.append(string);
        g("OnViewClickListener#onViewClick", sb.toString());
    }

    @Override // dc.wt2
    public void b(@Nullable vu2 vu2Var, boolean z, int i, int i2, int i3, int i4) {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("panelView is ");
        if (vu2Var == null || (string = vu2Var.toString()) == null) {
            string = "null portrait : " + z + " oldWidth : " + i + " oldHeight : " + i2 + " width : " + i3 + " height : " + i4;
        }
        sb.append(string);
        g("OnPanelChangeListener#onPanelSizeChange", sb.toString());
    }

    @Override // dc.wt2
    public void c(@Nullable vu2 vu2Var) {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("panel：");
        if (vu2Var == null || (string = vu2Var.toString()) == null) {
            string = "null";
        }
        sb.append(string);
        g("OnPanelChangeListener#onPanel", sb.toString());
    }

    @Override // dc.wt2
    public void d() {
        g("OnPanelChangeListener#onNone", "panel： none");
    }

    @Override // dc.wt2
    public void e() {
        g("OnPanelChangeListener#onKeyboard", "panel： keyboard");
    }

    @Override // dc.ut2
    public void f(boolean z, int i) {
        g("OnKeyboardStateListener#onKeyboardChange", "Keyboard is showing ( " + z + " ),height is " + i);
    }

    @Override // dc.tt2
    public void onFocusChange(@Nullable View view, boolean hasFocus) {
        g("OnEditFocusChangeListener#onFocusChange", "EditText has focus ( " + hasFocus + " )");
    }
}
