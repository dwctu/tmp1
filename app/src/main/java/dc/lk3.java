package dc;

import android.webkit.WebView;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: UrlUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/vibematevideo/UrlUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class lk3 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: UrlUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/vibematevideo/UrlUtils$Companion;", "", "()V", "reCorrectUrl", "", "view", "Landroid/webkit/WebView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull WebView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            String url = view.getUrl();
            String url2 = view.getUrl();
            if (!WearUtils.e1(url) && !WearUtils.e1(url2)) {
                Intrinsics.checkNotNull(url);
                int length = url.length();
                Intrinsics.checkNotNull(url2);
                return StringsKt__StringsJVMKt.replace$default(length > url2.length() ? url : url2, "#chat-", "", false, 4, (Object) null);
            }
            if (!WearUtils.e1(url)) {
                Intrinsics.checkNotNull(url);
                return StringsKt__StringsJVMKt.replace$default(url, "#chat-", "", false, 4, (Object) null);
            }
            if (WearUtils.e1(url2)) {
                return "";
            }
            Intrinsics.checkNotNull(url2);
            return StringsKt__StringsJVMKt.replace$default(url2, "#chat-", "", false, 4, (Object) null);
        }
    }
}
