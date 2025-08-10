package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoDialogUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogUtils;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class tr {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BILogAutoDialogUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogUtils$Companion;", "", "()V", "getActivity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Activity a(@NotNull Dialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextThemeWrapper)) {
                return null;
            }
            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
            return null;
        }
    }
}
