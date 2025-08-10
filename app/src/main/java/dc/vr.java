package dc;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.component.dxbilog.lib.bean.BILogContentBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.language.bm.Languages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoFragmentUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¨\u0006\u0010"}, d2 = {"Lcom/component/dxbilog/lib/auto/fragment/BILogAutoFragmentUtils;", "", "()V", "getPageUrl", "", Languages.ANY, "getUrlByView", "view", "isFragmentVisible", "", "fragment", "splicePageNameAndPageUrl", "", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "page_url", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class vr {

    @NotNull
    public static final vr a = new vr();

    @Nullable
    public final String a(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        Object objB = js.a.b(obj, Integer.valueOf(qr.a));
        String string = objB == null ? null : objB.toString();
        if (obj instanceof Fragment) {
            return string == null ? obj.getClass().getCanonicalName() : string;
        }
        if (obj instanceof androidx.fragment.app.Fragment) {
            return string == null ? obj.getClass().getCanonicalName() : string;
        }
        if (!(obj instanceof Dialog)) {
            return ((obj instanceof View) && string == null) ? b(obj) : string;
        }
        if (string != null) {
            return string;
        }
        Window window = ((Dialog) obj).getWindow();
        return b(window != null ? window.getDecorView() : null);
    }

    public final String b(Object obj) {
        Activity activityA;
        if (obj == null) {
            return null;
        }
        try {
            if (!(obj instanceof View)) {
                return null;
            }
            String str = (String) js.a.b(obj, Integer.valueOf(qr.a));
            if (!TextUtils.isEmpty(str) || (activityA = zr.a(((View) obj).getContext(), (View) obj)) == null) {
                return str;
            }
            Window window = activityA.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            return (!window.isActive() || window.getDecorView().getRootView().getTag(qr.b) == null) ? str : xr.h((View) obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean c(@Nullable Object obj) {
        if (obj == null || (!((obj instanceof Fragment) || (obj instanceof androidx.fragment.app.Fragment)) || Intrinsics.areEqual("com.bumptech.glide.manager.SupportRequestManagerFragment", obj.getClass().getCanonicalName()))) {
            return false;
        }
        return xr.f(obj);
    }

    public final void d(@NotNull BILogContentBean contentBean, @Nullable String str) {
        Intrinsics.checkNotNullParameter(contentBean, "contentBean");
        if (contentBean.getPage_name() == null || str == null) {
            return;
        }
        String page_name = contentBean.getPage_name();
        Intrinsics.checkNotNull(page_name);
        if (StringsKt__StringsKt.contains$default((CharSequence) page_name, (CharSequence) str, false, 2, (Object) null)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) contentBean.getPage_name());
        sb.append('|');
        sb.append((Object) str);
        contentBean.setPage_name(sb.toString());
    }
}
