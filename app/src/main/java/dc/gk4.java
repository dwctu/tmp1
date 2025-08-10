package dc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: PlayerUtils.java */
/* loaded from: classes5.dex */
public final class gk4 {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static String b() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }

    public static int c(Context context) {
        if (!j(context)) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE));
    }

    public static int d(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 0;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 3;
        }
        if (activeNetworkInfo.getType() != 0) {
            return -1;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return 4;
        }
        switch (subtype) {
        }
        return 0;
    }

    public static int e(Context context, boolean z) {
        return z ? context.getResources().getDisplayMetrics().heightPixels + c(context) : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int f(Context context, boolean z) {
        return z ? context.getResources().getDisplayMetrics().widthPixels + c(context) : context.getResources().getDisplayMetrics().widthPixels;
    }

    @NonNull
    public static <T> List<T> g(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static double h(Context context) {
        return context.getResources().getIdentifier("status_bar_height_portrait", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE) > 0 ? context.getResources().getDimensionPixelSize(r0) : 0;
    }

    public static WindowManager i(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean j(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = i(context).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.x == point.x && point2.y == point.y) ? false : true;
    }

    public static boolean k(Context context, MotionEvent motionEvent) {
        int iA = a(context, 40.0f);
        float f = iA;
        return motionEvent.getRawX() < f || motionEvent.getRawX() > ((float) (f(context, true) - iA)) || motionEvent.getRawY() < f || motionEvent.getRawY() > ((float) (e(context, true) - iA));
    }

    public static Activity l(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return l(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String m(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        return i5 > 0 ? String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)) : String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3));
    }
}
