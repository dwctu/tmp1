package dc;

import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnKeyboardStateListener.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u000b2:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fJ\u0018\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016RF\u0010\u0003\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListenerBuilder;", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListener;", "()V", "onKeyboardChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "visible", "", VideoCaptureFormat.keyHeight, "", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardChange;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class vt2 implements ut2 {

    @Nullable
    public Function2<? super Boolean, ? super Integer, Unit> a;

    public final void a(@NotNull Function2<? super Boolean, ? super Integer, Unit> onKeyboardChange) {
        Intrinsics.checkNotNullParameter(onKeyboardChange, "onKeyboardChange");
        this.a = onKeyboardChange;
    }

    @Override // dc.ut2
    public void f(boolean z, int i) {
        Function2<? super Boolean, ? super Integer, Unit> function2 = this.a;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(z), Integer.valueOf(i));
        }
    }
}
