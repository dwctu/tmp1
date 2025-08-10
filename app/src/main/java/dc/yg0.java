package dc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IInputPanel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/freddy/kulakeyboard/library/IInputPanel;", "Lcom/freddy/kulakeyboard/library/IPanel;", "onSoftKeyboardClosed", "", "onSoftKeyboardOpened", "keyBoardHeight", "", "onSoftKeyboardOpenedResize", "setOnInputStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/freddy/kulakeyboard/library/OnInputPanelStateChangedListener;", "setOnLayoutAnimatorHandleListener", "Lcom/freddy/kulakeyboard/library/OnLayoutAnimatorHandleListener;", "library_kulakeyboard_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public interface yg0 extends zg0 {
    void a();

    void b(int i);

    void c(int i);

    void setOnInputStateChangedListener(@Nullable dh0 dh0Var);

    void setOnLayoutAnimatorHandleListener(@NotNull eh0 eh0Var);
}
