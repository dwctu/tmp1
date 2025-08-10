package dc;

import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: IContentContainer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\tH&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H&¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/content/IInputAction;", "", "addSecondaryInputView", "", "editText", "Landroid/widget/EditText;", "getFullScreenPixelInputView", "hideKeyboard", "isKeyboardShowing", "", "clearFocus", "recycler", "removeSecondaryInputView", "requestKeyboard", "setEditTextClickListener", "l", "Landroid/view/View$OnClickListener;", "setEditTextFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "showKeyboard", "updateFullScreenParams", "isFullScreen", "panelId", "", "panelHeight", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface tu2 {
    boolean a();

    void b(@NotNull View.OnClickListener onClickListener);

    void c();

    void d(boolean z, int i, int i2);

    void e(boolean z, boolean z2);

    void f(@NotNull View.OnFocusChangeListener onFocusChangeListener);

    @NotNull
    EditText g();

    void h();
}
