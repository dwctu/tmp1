package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import com.component.dxbilog.lib.bean.BILogContentBean;
import dc.js;
import dc.ve0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoActivityHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/activity/BILogAutoActivityHelper;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class or {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static ve0.a b;

    @Nullable
    public static ve0.c c;

    /* compiled from: BILogAutoActivityHelper.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J,\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/component/dxbilog/lib/auto/activity/BILogAutoActivityHelper$Companion;", "", "()V", "appStatusChangedListener", "Lcom/component/dxutilcode/lib/utils/Utils$OnAppStatusChangedListener;", "lifecycleCallbacks", "Lcom/component/dxutilcode/lib/utils/Utils$ActivityLifecycleCallbacks;", "init", "", "initActivityLifecycleCallbacks", "initAppStatusChangedListener", "trackPageActivity", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "isShow", "", "logNo", "", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* compiled from: BILogAutoActivityHelper.kt */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/component/dxbilog/lib/auto/activity/BILogAutoActivityHelper$Companion$initActivityLifecycleCallbacks$1", "Lcom/component/dxutilcode/lib/utils/Utils$ActivityLifecycleCallbacks;", "onActivityStarted", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "onActivityStopped", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.or$a$a, reason: collision with other inner class name */
        public static final class C0207a extends ve0.a {
            @Override // dc.ve0.a
            public void e(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.e(activity);
                or.a.f(activity, true);
            }

            @Override // dc.ve0.a
            public void f(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.f(activity);
                or.a.f(activity, false);
            }
        }

        /* compiled from: BILogAutoActivityHelper.kt */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/component/dxbilog/lib/auto/activity/BILogAutoActivityHelper$Companion$initAppStatusChangedListener$1", "Lcom/component/dxutilcode/lib/utils/Utils$OnAppStatusChangedListener;", "onBackground", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "onForeground", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b implements ve0.c {
            @Override // dc.ve0.c
            public void a(@Nullable Activity activity) {
            }

            @Override // dc.ve0.c
            public void b(@Nullable Activity activity) {
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void g(a aVar, Activity activity, BILogContentBean bILogContentBean, boolean z, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            aVar.e(activity, bILogContentBean, z, str);
        }

        public final void b() {
            c();
            d();
        }

        public final void c() {
            if (!ks.a.f()) {
                ve0.a aVar = or.b;
                if (aVar == null) {
                    return;
                }
                ed0.i(aVar);
                return;
            }
            if (or.b == null) {
                C0207a c0207a = new C0207a();
                a aVar2 = or.a;
                or.b = c0207a;
                ed0.a(or.b);
            }
        }

        public final void d() {
            if (!ks.a.d()) {
                ve0.c cVar = or.c;
                if (cVar == null) {
                    return;
                }
                gd0.n(cVar);
                return;
            }
            if (or.c == null) {
                b bVar = new b();
                a aVar = or.a;
                or.c = bVar;
            }
            ve0.c cVar2 = or.c;
            if (cVar2 == null) {
                return;
            }
            gd0.n(cVar2);
            gd0.l(cVar2);
        }

        public final void e(@NotNull Activity activity, @NotNull BILogContentBean contentBean, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            String page_name = contentBean.getPage_name();
            if (page_name == null) {
                page_name = activity.getClass().getCanonicalName();
            }
            contentBean.setPage_name(page_name);
            is.a.p(activity, contentBean, z, str);
        }

        public final void f(Activity activity, boolean z) {
            if (activity != null) {
                js.a aVar = js.a;
                if (aVar.e(activity)) {
                    return;
                }
                try {
                    g(this, activity, aVar.a(activity), z, null, 8, null);
                } catch (Exception unused) {
                }
            }
        }
    }
}
