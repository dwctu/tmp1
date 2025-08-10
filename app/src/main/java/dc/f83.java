package dc;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DataBindingConnectionsBinding.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"setWearAvatar", "", "Landroid/widget/ImageView;", "avatar", "", "setWearGroupAvatar", "setWearUserOrGroupAvatar", "friendType", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class f83 {
    @BindingAdapter({"wearAvatar"})
    public static final void a(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        WearUtils.u2(imageView, str);
    }

    @BindingAdapter({"wearGroupAvatar"})
    public static final void b(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        tg3.j(imageView, str);
    }

    @BindingAdapter(requireAll = true, value = {"wearAvatar", "friendType"})
    public static final void c(@NotNull ImageView imageView, @Nullable String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (i == 1) {
            b(imageView, str);
        } else if (i != 2) {
            a(imageView, str);
        } else {
            imageView.setImageResource(R.drawable.avatar_official);
        }
    }
}
