package dc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.core.graphics.drawable.IconCompat;
import com.component.dxbilog.lib.bean.BILogContentBean;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoFragmentCallback.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/fragment/BILogAutoFragmentCallback;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ur {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static final HashSet<Integer> b = new HashSet<>();

    @NotNull
    public static final HashSet<Integer> c = new HashSet<>();

    /* compiled from: BILogAutoFragmentCallback.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0007J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\tH\u0007J,\u0010\u001a\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010\u001a\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u001a\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/component/dxbilog/lib/auto/fragment/BILogAutoFragmentCallback$Companion;", "", "()V", "mCreatedFragments", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mResumedFragments", "isIntercept", "", "fragment", "onHiddenChanged", "", IconCompat.EXTRA_OBJ, "hidden", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "rootView", "Landroid/view/View;", "bundle", "Landroid/os/Bundle;", "setUserVisibleHint", "isVisibleToUser", "trackPageFragment", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "isShow", "logNo", "", "trackPageFragmentHide", "trackPageFragmentShow", "traverseView", "fragmentName", "root", "Landroid/view/ViewGroup;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void k(a aVar, Object obj, BILogContentBean bILogContentBean, boolean z, String str, int i, Object obj2) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            aVar.i(obj, bILogContentBean, z, str);
        }

        public final boolean a(Object obj) {
            return !ks.a.f() || js.a.e(obj);
        }

        @JvmStatic
        public final void b(@NotNull Object obj, boolean z) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (vr.a.c(obj)) {
                m(obj);
            } else {
                l(obj);
            }
        }

        @JvmStatic
        public final void c(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            l(obj);
        }

        @JvmStatic
        public final void d(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (vr.a.c(obj)) {
                m(obj);
            }
        }

        @JvmStatic
        public final void e(@Nullable Object obj) {
        }

        @JvmStatic
        public final void f(@Nullable Object obj) {
        }

        @JvmStatic
        public final void g(@NotNull Object obj, @NotNull View rootView, @Nullable Bundle bundle) {
            Window window;
            View decorView;
            View rootView2;
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            try {
                String fragmentName = obj.getClass().getName();
                rootView.setTag(qr.a, fragmentName);
                ur.c.add(Integer.valueOf(obj.hashCode()));
                if (rootView instanceof ViewGroup) {
                    Intrinsics.checkNotNullExpressionValue(fragmentName, "fragmentName");
                    n(fragmentName, (ViewGroup) rootView);
                }
                Activity activityA = zr.a(rootView.getContext(), rootView);
                if (activityA != null && (window = activityA.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootView2 = decorView.getRootView()) != null) {
                    rootView2.setTag(qr.b, "");
                }
                xr.g(fragmentName, obj);
            } catch (Exception unused) {
            }
        }

        @JvmStatic
        public final void h(@NotNull Object obj, boolean z) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            if (ur.c.contains(Integer.valueOf(obj.hashCode()))) {
                if (vr.a.c(obj)) {
                    m(obj);
                } else {
                    l(obj);
                }
            }
        }

        public final void i(@NotNull Object fragment, @NotNull BILogContentBean contentBean, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            Activity activityD = xr.d(fragment);
            if (activityD == null) {
                return;
            }
            vr vrVar = vr.a;
            String strA = vrVar.a(fragment);
            String page_name = contentBean.getPage_name();
            if (page_name == null) {
                page_name = activityD.getClass().getCanonicalName();
            }
            contentBean.setPage_name(page_name);
            vrVar.d(contentBean, strA);
            yr.b(strA);
            String referrer = contentBean.getReferrer();
            if (referrer == null) {
                referrer = yr.a();
            }
            contentBean.setReferrer(referrer);
            is.a.p(fragment, contentBean, z, str);
        }

        public final void j(@Nullable Object obj, boolean z) {
            if (obj == null || a(obj)) {
                return;
            }
            try {
                k(this, obj, js.a.a(obj), z, null, 8, null);
            } catch (Exception unused) {
            }
        }

        public final void l(Object obj) {
            int iHashCode = obj.hashCode();
            if (ur.b.contains(Integer.valueOf(iHashCode))) {
                ur.b.remove(Integer.valueOf(iHashCode));
                j(obj, false);
            }
        }

        public final void m(Object obj) {
            ur.b.add(Integer.valueOf(obj.hashCode()));
            j(obj, true);
        }

        public final void n(String str, ViewGroup viewGroup) {
            try {
                if (!TextUtils.isEmpty(str) && viewGroup != null) {
                    int childCount = viewGroup.getChildCount();
                    int i = 0;
                    while (i < childCount) {
                        int i2 = i + 1;
                        View childAt = viewGroup.getChildAt(i);
                        childAt.setTag(qr.a, str);
                        if ((childAt instanceof ViewGroup) && !(childAt instanceof ListView) && !(childAt instanceof GridView) && !(childAt instanceof Spinner) && !(childAt instanceof RadioGroup)) {
                            n(str, (ViewGroup) childAt);
                        }
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
