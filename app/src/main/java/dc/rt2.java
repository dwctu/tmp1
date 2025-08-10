package dc;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PanelHeightMeasurer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\bJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\t\u001a\u00020\r2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bR\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurerBuilder;", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurer;", "()V", "getPanelDefaultHeight", "Lkotlin/Function0;", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/GetTargetPanelDefaultHeight;", "getPanelId", "Lcom/wear/ui/chat/pancel/helper/interfaces/GetPanelId;", "synchronizeKeyboardHeight", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/SynchronizeKeyboardHeight;", "getPanelTriggerId", "", "getTargetPanelDefaultHeight", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class rt2 implements qt2 {

    @Nullable
    public Function0<Integer> a;

    @Nullable
    public Function0<Integer> b;

    @Nullable
    public Function0<Boolean> c;

    @Override // dc.qt2
    public int a() {
        Function0<Integer> function0 = this.a;
        if (function0 != null) {
            return function0.invoke().intValue();
        }
        return 0;
    }

    @Override // dc.qt2
    public boolean b() {
        Function0<Boolean> function0 = this.c;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return true;
    }

    @Override // dc.qt2
    public int c() {
        Function0<Integer> function0 = this.b;
        if (function0 != null) {
            return function0.invoke().intValue();
        }
        return -1;
    }

    public final void d(@NotNull Function0<Integer> getPanelId) {
        Intrinsics.checkNotNullParameter(getPanelId, "getPanelId");
        this.b = getPanelId;
    }

    public final void e(@NotNull Function0<Integer> getPanelDefaultHeight) {
        Intrinsics.checkNotNullParameter(getPanelDefaultHeight, "getPanelDefaultHeight");
        this.a = getPanelDefaultHeight;
    }

    public final void f(@NotNull Function0<Boolean> synchronizeKeyboardHeight) {
        Intrinsics.checkNotNullParameter(synchronizeKeyboardHeight, "synchronizeKeyboardHeight");
        this.c = synchronizeKeyboardHeight;
    }
}
