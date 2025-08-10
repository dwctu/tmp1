package dc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Lifecycle.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÂ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001e\b\u0002\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u001e\b\u0002\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¨\u0006\u000f"}, d2 = {"doOnActivityLifecycle", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Application;", "onActivityCreated", "Lkotlin/Function2;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "", "onActivityStarted", "Lkotlin/Function1;", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "onActivityDestroyed", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ju1 {

    /* compiled from: Lifecycle.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/wear/ext/LifecycleKt$doOnActivityLifecycle$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ Function2<Activity, Bundle, Unit> a;
        public final /* synthetic */ Function1<Activity, Unit> b;
        public final /* synthetic */ Function1<Activity, Unit> c;
        public final /* synthetic */ Function1<Activity, Unit> d;
        public final /* synthetic */ Function1<Activity, Unit> e;
        public final /* synthetic */ Function2<Activity, Bundle, Unit> f;
        public final /* synthetic */ Function1<Activity, Unit> g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Activity, ? super Bundle, Unit> function2, Function1<? super Activity, Unit> function1, Function1<? super Activity, Unit> function12, Function1<? super Activity, Unit> function13, Function1<? super Activity, Unit> function14, Function2<? super Activity, ? super Bundle, Unit> function22, Function1<? super Activity, Unit> function15) {
            this.a = function2;
            this.b = function1;
            this.c = function12;
            this.d = function13;
            this.e = function14;
            this.f = function22;
            this.g = function15;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function2<Activity, Bundle, Unit> function2 = this.a;
            if (function2 != null) {
                function2.invoke(activity, savedInstanceState);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function1<Activity, Unit> function1 = this.g;
            if (function1 != null) {
                function1.invoke(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function1<Activity, Unit> function1 = this.d;
            if (function1 != null) {
                function1.invoke(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function1<Activity, Unit> function1 = this.c;
            if (function1 != null) {
                function1.invoke(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
            Function2<Activity, Bundle, Unit> function2 = this.f;
            if (function2 != null) {
                function2.invoke(activity, outState);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function1<Activity, Unit> function1 = this.b;
            if (function1 != null) {
                function1.invoke(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Function1<Activity, Unit> function1 = this.e;
            if (function1 != null) {
                function1.invoke(activity);
            }
        }
    }

    @NotNull
    public static final Application.ActivityLifecycleCallbacks a(@NotNull Application application, @Nullable Function2<? super Activity, ? super Bundle, Unit> function2, @Nullable Function1<? super Activity, Unit> function1, @Nullable Function1<? super Activity, Unit> function12, @Nullable Function1<? super Activity, Unit> function13, @Nullable Function1<? super Activity, Unit> function14, @Nullable Function2<? super Activity, ? super Bundle, Unit> function22, @Nullable Function1<? super Activity, Unit> function15) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        a aVar = new a(function2, function1, function12, function13, function14, function22, function15);
        application.registerActivityLifecycleCallbacks(aVar);
        return aVar;
    }

    public static /* synthetic */ Application.ActivityLifecycleCallbacks b(Application application, Function2 function2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function2 function22, Function1 function15, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        if ((i & 16) != 0) {
            function14 = null;
        }
        if ((i & 32) != 0) {
            function22 = null;
        }
        if ((i & 64) != 0) {
            function15 = null;
        }
        return a(application, function2, function1, function12, function13, function14, function22, function15);
    }
}
