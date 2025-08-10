package dc;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import com.lovense.wear.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommandLoadingDialog.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/widget/dialog/CommandLoadingDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class vr3 extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr3(@NotNull Context context) {
        super(context, R.style.progress_dialog);
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(R.layout.dialog_loading_command);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        setCancelable(false);
    }
}
