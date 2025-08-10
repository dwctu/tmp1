package dc;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.lovense.wear.R;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: DataBindingOnlineStatusAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¨\u0006\u000f"}, d2 = {"setDescText", "", "Landroid/widget/TextView;", "onlineStatus", "", "size", "setHeaderIcon", "Landroid/widget/ImageView;", "icon", "setHighlightWithKeyword", "keyword", "", "text", "setSecondHighlightWithKeyword", "keyword2", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class bc3 {
    @BindingAdapter(requireAll = true, value = {"onlineStatus", "size"})
    public static final void a(@NotNull TextView textView, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String desc = i != 0 ? i != 1 ? i != 2 ? "" : ah4.e(R.string.appear_available_to_friends) : ah4.e(R.string.appear_busy_to_friends) : ah4.e(R.string.appear_invisible_to_friends);
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        String str = String.format(desc, Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        textView.setText(str);
    }

    @BindingAdapter({"headerIcon"})
    public static final void b(@NotNull ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Drawable drawableD = th4.d(imageView.getContext(), i);
        if (drawableD != null) {
            imageView.setImageDrawable(drawableD);
        }
    }

    @BindingAdapter(requireAll = true, value = {"keyword", "text"})
    public static final void c(@NotNull TextView textView, @NotNull String keyword, @NotNull String text) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(text, "text");
        String lowerCase = text.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase, keyword, 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            if (keyword.length() > 0) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(text);
                Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
                spannableStringValueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF2D89")), iIndexOf$default, keyword.length() + iIndexOf$default, 33);
                textView.setText(spannableStringValueOf);
                return;
            }
        }
        textView.setText(text);
    }

    @BindingAdapter(requireAll = true, value = {"keyword2", "text"})
    @SuppressLint({"SetTextI18n"})
    public static final void d(@NotNull TextView textView, @NotNull String keyword2, @NotNull String text) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keyword2, "keyword2");
        Intrinsics.checkNotNullParameter(text, "text");
        String lowerCase = text.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase, keyword2, 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            if (keyword2.length() > 0) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(text);
                Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
                spannableStringValueOf.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF2D89")), iIndexOf$default, keyword2.length() + iIndexOf$default, 33);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ah4.e(R.string.signup_name_hint) + ':');
                spannableStringBuilder.append((CharSequence) spannableStringValueOf);
                textView.setText(spannableStringBuilder);
                return;
            }
        }
        textView.setText(ah4.e(R.string.signup_name_hint) + ':' + text);
    }
}
