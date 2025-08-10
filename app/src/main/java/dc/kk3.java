package dc;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextViewUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/wear/vibematevideo/TextViewUtil;", "", "()V", "setSpanColorStr", "Landroid/text/SpannableString;", FirebaseAnalytics.Param.CONTENT, "", "keyStr", "color", "", "keyStrs", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class kk3 {

    @NotNull
    public static final kk3 a = new kk3();

    /* compiled from: TextViewUtil.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/vibematevideo/TextViewUtil$setSpanColorStr$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ClickableSpan {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.a);
            ds.setUnderlineText(false);
        }
    }

    @Nullable
    public final SpannableString a(@NotNull String content, @NotNull String keyStr, int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(keyStr, "keyStr");
        SpannableString spannableString = new SpannableString(content);
        if (StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) keyStr, false, 2, (Object) null)) {
            String strSubstring = content;
            int i2 = 0;
            while (StringsKt__StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) keyStr, false, 2, (Object) null)) {
                spannableString.setSpan(new a(i), i2 + StringsKt__StringsKt.indexOf$default((CharSequence) strSubstring, keyStr, 0, false, 6, (Object) null), StringsKt__StringsKt.indexOf$default((CharSequence) strSubstring, keyStr, 0, false, 6, (Object) null) + i2 + keyStr.length(), 33);
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strSubstring, keyStr, 0, false, 6, (Object) null) + keyStr.length();
                i2 += iIndexOf$default;
                strSubstring = strSubstring.substring(iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
        }
        return spannableString;
    }
}
