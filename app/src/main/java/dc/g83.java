package dc;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DataBindingUserActionMenuBinding.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"setConfirmContent", "", "Landroid/widget/TextView;", FirebaseAnalytics.Param.CONTENT, "", "nickname", "", "setSkinDrawableStart", "drawableRes", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class g83 {
    @BindingAdapter(requireAll = true, value = {"contentText", "nickname"})
    public static final void a(@NotNull TextView textView, int i, @Nullable String str) {
        String strE;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str == null || str.length() == 0) {
            strE = ah4.e(i);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE2 = ah4.e(i);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(content)");
            strE = String.format(strE2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(strE, "format(format, *args)");
        }
        textView.setText(strE);
    }
}
