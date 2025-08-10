package dc;

import com.lovense.wear.R;
import com.wear.ext.ActivityKt;
import dc.is3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewCommonDialog.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"showNewCommonDialog", "", "message", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class mu1 {
    public static final void a(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        is3.b bVar = new is3.b(ActivityKt.e());
        bVar.p(message);
        bVar.o(ah4.e(R.string.common_ok));
        bVar.b(false);
        cs3.h(bVar).show();
    }
}
