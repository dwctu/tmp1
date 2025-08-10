package dc;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.main.account.WebViewActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpannableTextColorUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/wear/util/SpannableTextColorUtil;", "", "()V", "changeTextColor", "", "allText", "", "spannableText", "view", "Landroid/widget/TextView;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class jg3 {

    @NotNull
    public static final b a = new b(null);

    @NotNull
    public static final Lazy<jg3> b = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    /* compiled from: SpannableTextColorUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/util/SpannableTextColorUtil;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<jg3> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final jg3 invoke() {
            return new jg3();
        }
    }

    /* compiled from: SpannableTextColorUtil.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/util/SpannableTextColorUtil$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/util/SpannableTextColorUtil;", "getInstance", "()Lcom/wear/util/SpannableTextColorUtil;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final jg3 a() {
            return (jg3) jg3.b.getValue();
        }
    }

    /* compiled from: SpannableTextColorUtil.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/util/SpannableTextColorUtil$changeTextColor$2", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends ClickableSpan {
        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH != null && fragmentActivityH.isDestroyed()) {
                return;
            }
            if (fragmentActivityH != null && fragmentActivityH.isFinishing()) {
                return;
            }
            String strC = lg3.c(lg3.e(fragmentActivityH));
            Intrinsics.checkNotNullExpressionValue(strC, "getLangParms(locale)");
            String strF = pg3.h().f();
            Intrinsics.checkNotNullExpressionValue(strF, "getInstance().groupChatGuideline");
            Bundle bundle = new Bundle();
            bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.group_chat_guidelines_title));
            if (WearUtils.e1(strF)) {
                strF = "https://c.lovense.com/remote-web/group-chat-guidelines";
            }
            bundle.putString(ImagesContract.URL, strF + "?lang=" + strC);
            pj3.g(fragmentActivityH, WebViewActivity.class, bundle);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }

    public final void b(@Nullable String str, @Nullable String str2, @Nullable TextView textView, @NotNull Activity activity) {
        int iIndexOf$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int iIndexOf$default2 = str != null ? StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) : 0;
            iIndexOf$default = str != null ? StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) + str2.length() : 0;
            i = iIndexOf$default2;
        } else {
            iIndexOf$default = 0;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.lvs_ui_standard_systemTextRegular)), i, iIndexOf$default, 17);
        spannableStringBuilder.setSpan(new UnderlineSpan(), i, iIndexOf$default, 17);
        spannableStringBuilder.setSpan(new c(), i, iIndexOf$default, 17);
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
        if (textView == null) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
