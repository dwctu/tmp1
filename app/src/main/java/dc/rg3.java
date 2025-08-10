package dc;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.lang.reflect.Method;

/* compiled from: SystemBarTintManager.java */
/* loaded from: classes4.dex */
public class rg3 {
    public static String f;
    public final b a;
    public boolean b;
    public boolean c;
    public View d;
    public View e;

    /* compiled from: SystemBarTintManager.java */
    public static class b {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final boolean e;
        public final float f;

        @TargetApi(14)
        public final int a(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        public final int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int c() {
            return this.c;
        }

        @TargetApi(14)
        public final int d(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, this.e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        public int e() {
            return this.d;
        }

        @TargetApi(14)
        public final int f(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !i(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        @SuppressLint({"NewApi"})
        public final float g(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f = displayMetrics.widthPixels;
            float f2 = displayMetrics.density;
            return Math.min(f / f2, displayMetrics.heightPixels / f2);
        }

        public int h() {
            return this.a;
        }

        @TargetApi(14)
        public final boolean i(Context context) throws Resources.NotFoundException {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(rg3.f)) {
                return false;
            }
            if ("0".equals(rg3.f)) {
                return true;
            }
            return z;
        }

        public boolean j() {
            return this.b;
        }

        public boolean k() {
            return this.f >= 600.0f || this.e;
        }

        public b(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.e = resources.getConfiguration().orientation == 1;
            this.f = g(activity);
            this.a = b(resources, "status_bar_height");
            a(activity);
            int iD = d(activity);
            this.c = iD;
            this.d = f(activity);
            this.b = iD > 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f = null;
            }
        }
    }

    @SuppressLint({"ResourceType"})
    @TargetApi(19)
    public rg3(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(new int[]{R.attr.windowTranslucentStatus, R.attr.windowTranslucentNavigation});
            try {
                this.b = typedArrayObtainStyledAttributes.getBoolean(0, false);
                this.c = typedArrayObtainStyledAttributes.getBoolean(1, false);
                typedArrayObtainStyledAttributes.recycle();
                int i = window.getAttributes().flags;
                if ((67108864 & i) != 0) {
                    this.b = true;
                }
                if ((i & 134217728) != 0) {
                    this.c = true;
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.b, this.c);
        this.a = bVar;
        if (!bVar.j()) {
            this.c = false;
        }
        if (this.b) {
            e(activity, viewGroup);
        }
        if (this.c) {
            d(activity, viewGroup);
        }
    }

    public void b(int i) {
        if (this.b) {
            this.d.setBackgroundColor(i);
        }
    }

    public void c(boolean z) {
        if (this.b) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.e = new View(context);
        if (this.a.k()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.a.c());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.a.e(), -1);
            layoutParams.gravity = 5;
        }
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundColor(-1728053248);
        this.e.setVisibility(8);
        viewGroup.addView(this.e);
    }

    public final void e(Context context, ViewGroup viewGroup) {
        this.d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.a.h());
        layoutParams.gravity = 48;
        if (this.c && !this.a.k()) {
            layoutParams.rightMargin = this.a.e();
        }
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1728053248);
        this.d.setVisibility(8);
        viewGroup.addView(this.d);
    }
}
