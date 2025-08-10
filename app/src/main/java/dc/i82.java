package dc;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.lovense.wear.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AdapterGroupMemberAdapterBinding.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"setInviteBy", "", "Landroid/widget/TextView;", "type", "", "inviteBy", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class i82 {
    @BindingAdapter(requireAll = true, value = {"type", "inviteBy"})
    public static final void a(@NotNull TextView textView, int i, @NotNull String inviteBy) {
        String strE;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(inviteBy, "inviteBy");
        if (i == 1) {
            strE = ah4.e(R.string.group_chat_joined_by_qr);
        } else {
            String strE2 = ah4.e(R.string.common_added_by);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.common_added_by)");
            strE = String.format(strE2, Arrays.copyOf(new Object[]{inviteBy}, 1));
            Intrinsics.checkNotNullExpressionValue(strE, "format(this, *args)");
        }
        textView.setText(strE);
    }
}
