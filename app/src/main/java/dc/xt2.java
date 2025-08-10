package dc;

import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnPanelChangeListener.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\u0003\u001a\u00020\u00052\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\bJ/\u0010\t\u001a\u00020\u00052'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\nj\u0002`\u000fJ\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0016J\u009a\u0001\u0010\u0010\u001a\u00020\u00052\u0091\u0001\u0010\u0010\u001a\u008c\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u001aJ:\u0010\u0010\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R3\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u009d\u0001\u0010\u0010\u001a\u0090\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\u0004\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListenerBuilder;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListener;", "()V", "onKeyboard", "Lkotlin/Function0;", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboard;", "onNone", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnNone;", "onPanel", "Lkotlin/Function1;", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "Lkotlin/ParameterName;", "name", "view", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanel;", "onPanelSizeChange", "Lkotlin/Function6;", "panelView", "", "portrait", "", "oldWidth", "oldHeight", VideoCaptureFormat.keyWidth, VideoCaptureFormat.keyHeight, "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelSizeChange;", "panel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xt2 implements wt2 {

    @Nullable
    public Function0<Unit> a;

    @Nullable
    public Function0<Unit> b;

    @Nullable
    public Function1<? super vu2, Unit> c;

    @Nullable
    public Function6<? super vu2, ? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> d;

    public final void a(@NotNull Function0<Unit> onNone) {
        Intrinsics.checkNotNullParameter(onNone, "onNone");
        this.b = onNone;
    }

    @Override // dc.wt2
    public void b(@Nullable vu2 vu2Var, boolean z, int i, int i2, int i3, int i4) {
        Function6<? super vu2, ? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function6 = this.d;
        if (function6 != null) {
            function6.invoke(vu2Var, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    @Override // dc.wt2
    public void c(@Nullable vu2 vu2Var) {
        Function1<? super vu2, Unit> function1 = this.c;
        if (function1 != null) {
            function1.invoke(vu2Var);
        }
    }

    @Override // dc.wt2
    public void d() {
        Function0<Unit> function0 = this.b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // dc.wt2
    public void e() {
        Function0<Unit> function0 = this.a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void f(@NotNull Function1<? super vu2, Unit> onPanel) {
        Intrinsics.checkNotNullParameter(onPanel, "onPanel");
        this.c = onPanel;
    }
}
