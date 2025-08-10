package dc;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.broadcom.bt.util.io.IOUtils;
import com.component.dxhyttoutils.lib.bean.DtxCheckBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.qz;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContentProviderCheckUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/provider/ContentProviderCheckUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class bq2 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ContentProviderCheckUtils.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0007J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/wear/provider/ContentProviderCheckUtils$Companion;", "", "()V", "checkStringTime", "Lkotlin/Pair;", "", "Lcom/component/dxhyttoutils/lib/bean/DtxCheckBean;", "value", "", "checkUri", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "checkUriEnable", "param", "createCheckStringTime", "getParamFromUri", FirebaseAnalytics.Param.INDEX, "", "removeParamFromUri", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Pair<Boolean, DtxCheckBean> a(@Nullable String str) {
            return qz.a.b(qz.a, str, 500L, 0L, 4, null);
        }

        @JvmStatic
        @Nullable
        public final Uri b(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            de0.l("xxx__isUriEnable: " + uri);
            String strD = d(uri, 1);
            if (c(strD)) {
                return strD != null ? e(uri, strD) : uri;
            }
            return null;
        }

        public final boolean c(String str) {
            if (str == null) {
                return true;
            }
            Pair<Boolean, DtxCheckBean> pairA = a(str);
            boolean zBooleanValue = pairA.component1().booleanValue();
            DtxCheckBean dtxCheckBeanComponent2 = pairA.component2();
            if (!zBooleanValue) {
                return false;
            }
            de0.l("xxx__isUriEnable: " + xd0.j(dtxCheckBeanComponent2), str);
            return true;
        }

        @JvmStatic
        @Nullable
        public final String d(@NotNull Uri uri, int i) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() > i) {
                return pathSegments.get(i);
            }
            return null;
        }

        public final Uri e(Uri uri, String str) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
            Uri uri2 = Uri.parse(StringsKt__StringsJVMKt.replace$default(string, IOUtils.DIR_SEPARATOR_UNIX + str, "", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(uri2, "parse(str)");
            return uri2;
        }
    }

    @JvmStatic
    @Nullable
    public static final Uri a(@NotNull Uri uri) {
        return a.b(uri);
    }
}
