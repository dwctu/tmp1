package dc;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.component.dxbilog.lib.bean.BILogContentBean;
import dc.js;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoDialogCallback.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogCallback;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class sr {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BILogAutoDialogCallback.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\bH\u0002J,\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u000b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/component/dxbilog/lib/auto/dialog/BILogAutoDialogCallback$Companion;", "", "()V", "isIntercept", "", "dialog", "onStart", "", "Landroid/app/Dialog;", "onStop", "setDialogConfig", "trackPageDialog", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "isShow", "logNo", "", "dilaog", "traverseView", "name", "root", "Landroid/view/ViewGroup;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void g(a aVar, Dialog dialog, BILogContentBean bILogContentBean, boolean z, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            aVar.e(dialog, bILogContentBean, z, str);
        }

        public final boolean a(Object obj) {
            return !ks.a.f() || js.a.e(obj);
        }

        public final void b(@NotNull Dialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            d(dialog);
            f(dialog, true);
        }

        public final void c(@NotNull Dialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            f(dialog, false);
        }

        public final void d(Dialog dialog) {
            View decorView;
            View decorView2;
            Window window;
            View decorView3;
            View rootView;
            String name = dialog.getClass().getCanonicalName();
            if (name == null) {
                name = dialog.getClass().getName();
            }
            js.a aVar = js.a;
            int i = qr.a;
            aVar.f(dialog, Integer.valueOf(i), name);
            Window window2 = dialog.getWindow();
            aVar.f((window2 == null || (decorView = window2.getDecorView()) == null) ? null : decorView.getRootView(), Integer.valueOf(i), name);
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Window window3 = dialog.getWindow();
            View rootView2 = (window3 == null || (decorView2 = window3.getDecorView()) == null) ? null : decorView2.getRootView();
            h(name, rootView2 instanceof ViewGroup ? (ViewGroup) rootView2 : null);
            if (!(dialog.getContext() instanceof Activity) || (window = ((Activity) dialog.getContext()).getWindow()) == null || (decorView3 = window.getDecorView()) == null || (rootView = decorView3.getRootView()) == null) {
                return;
            }
            rootView.setTag(qr.b, "");
        }

        public final void e(@NotNull Dialog dialog, @NotNull BILogContentBean contentBean, boolean z, @Nullable String str) {
            Class<?> cls;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            Activity activityA = tr.a.a(dialog);
            vr vrVar = vr.a;
            String strA = vrVar.a(dialog);
            String page_name = contentBean.getPage_name();
            if (page_name == null) {
                page_name = (activityA == null || (cls = activityA.getClass()) == null) ? null : cls.getCanonicalName();
            }
            contentBean.setPage_name(page_name);
            vrVar.d(contentBean, strA);
            is.a.p(dialog, contentBean, z, str);
        }

        public final void f(@Nullable Dialog dialog, boolean z) {
            if (dialog == null || a(dialog)) {
                return;
            }
            try {
                g(this, dialog, js.a.a(dialog), z, null, 8, null);
            } catch (Exception unused) {
            }
        }

        public final void h(String str, ViewGroup viewGroup) {
            try {
                if (!TextUtils.isEmpty(str) && viewGroup != null) {
                    int childCount = viewGroup.getChildCount();
                    int i = 0;
                    while (i < childCount) {
                        int i2 = i + 1;
                        View childAt = viewGroup.getChildAt(i);
                        childAt.setTag(qr.a, str);
                        if ((childAt instanceof ViewGroup) && !(childAt instanceof ListView) && !(childAt instanceof GridView) && !(childAt instanceof Spinner) && !(childAt instanceof RadioGroup)) {
                            h(str, (ViewGroup) childAt);
                        }
                        i = i2;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
