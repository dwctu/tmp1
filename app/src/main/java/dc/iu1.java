package dc;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.google.android.gms.common.internal.ImagesContract;
import com.wear.util.WearUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageView.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a'\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a\"\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u001a\"\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000e"}, d2 = {"setImageFile", "", "Landroid/widget/ImageView;", "file", "Ljava/io/File;", "setImageUrl", "imageResource", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/ImageView;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)V", ImagesContract.URL, "", "setImageUrlWithHost", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class iu1 {
    public static final void a(@NotNull ImageView imageView, @NotNull File file) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        rf rfVarX = kf.x(imageView);
        Uri uriFromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(this)");
        rfVarX.r(uriFromFile).c().A0(imageView);
    }

    @BindingAdapter(requireAll = false, value = {"imageResource", "placeholder"})
    public static final void b(@NotNull ImageView imageView, @Nullable Integer num, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (num == null || num.intValue() == 0) {
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(th4.d(imageView.getContext(), num.intValue()));
        }
    }

    @BindingAdapter(requireAll = false, value = {"imageUrl", "placeholder"})
    public static final void c(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        kf.x(imageView).v(str).Y(drawable).i(drawable).A0(imageView);
    }

    @BindingAdapter(requireAll = false, value = {"imageUrlWithHost", "placeholder"})
    public static final void d(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str == null || str.length() == 0) {
            imageView.setImageDrawable(drawable);
            return;
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
            c(imageView, str, drawable);
            return;
        }
        c(imageView, WearUtils.e + str, drawable);
    }
}
