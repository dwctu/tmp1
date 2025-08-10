package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PermissionUtils.java */
/* loaded from: classes2.dex */
public final class m61 {
    public static final Handler a = new Handler(Looper.getMainLooper());

    public static boolean a(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return n51.f() ? !packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)).isEmpty() : !packageManager.queryIntentActivities(intent, 65536).isEmpty();
    }

    @NonNull
    public static <T> ArrayList<T> b(@Nullable T... tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr != null ? tArr.length : 0);
        if (tArr != null && tArr.length != 0) {
            for (T t : tArr) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NonNull
    @SafeVarargs
    public static <T> ArrayList<T> c(@Nullable T[]... tArr) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (tArr != null && tArr.length != 0) {
            for (T[] tArr2 : tArr) {
                arrayList.addAll(b(tArr2));
            }
        }
        return arrayList;
    }

    @RequiresApi(19)
    public static boolean d(Context context, String str) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        return (n51.c() ? appOpsManager.unsafeCheckOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName()) : appOpsManager.checkOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName())) == 0;
    }

    @RequiresApi(19)
    public static boolean e(Context context, String str, int i) throws ClassNotFoundException {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            try {
                i = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    @RequiresApi(api = 23)
    public static boolean f(@NonNull Context context, @NonNull String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static boolean g(@NonNull Collection<String> collection, @NonNull String str) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (h(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(@NonNull String str, @NonNull String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static Activity i(@NonNull Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    @SuppressLint({"PrivateApi"})
    public static int j(@NonNull Context context, @NonNull String str) throws NoSuchMethodException, SecurityException {
        AssetManager assets = context.getAssets();
        try {
            if (n51.b(context) >= 28 && n51.a() >= 28 && n51.a() < 30) {
                Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.invoke(AssetManager.class, "findCookieForPath", new Class[]{String.class});
                if (method != null) {
                    method.setAccessible(true);
                    Integer num = (Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            Integer num2 = (Integer) assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return 0;
    }

    @Nullable
    public static l51 k(Context context) throws NoSuchMethodException, SecurityException {
        int iJ = j(context, context.getApplicationInfo().sourceDir);
        l51 l51Var = null;
        if (iJ == 0) {
            return null;
        }
        try {
            l51 l51VarB = m51.b(context, iJ);
            try {
                if (TextUtils.equals(context.getPackageName(), l51VarB.a)) {
                    return l51VarB;
                }
                return null;
            } catch (IOException e) {
                e = e;
                l51Var = l51VarB;
                e.printStackTrace();
                return l51Var;
            } catch (XmlPullParserException e2) {
                e = e2;
                l51Var = l51VarB;
                e.printStackTrace();
                return l51Var;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (XmlPullParserException e4) {
            e = e4;
        }
    }

    public static Uri l(@NonNull Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    public static Intent m(@NonNull Context context, @Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return l61.b(context);
        }
        if (!w51.a(list)) {
            return list.size() == 1 ? w51.e(context, list.get(0)) : l61.b(context);
        }
        int size = list.size();
        if (size == 1) {
            return w51.e(context, list.get(0));
        }
        if (size != 2) {
            if (size == 3 && n51.d() && g(list, "android.permission.MANAGE_EXTERNAL_STORAGE") && g(list, "android.permission.READ_EXTERNAL_STORAGE") && g(list, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return w51.e(context, "android.permission.MANAGE_EXTERNAL_STORAGE");
            }
        } else if (!n51.f() && g(list, "android.permission.NOTIFICATION_SERVICE") && g(list, "android.permission.POST_NOTIFICATIONS")) {
            return w51.e(context, "android.permission.NOTIFICATION_SERVICE");
        }
        return l61.b(context);
    }

    public static boolean n(@NonNull Activity activity) {
        int rotation = n51.d() ? activity.getDisplay().getRotation() : activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 2 || rotation == 3;
    }

    public static boolean o(@NonNull Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean p(@NonNull Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || !bundle.containsKey("ScopedStorage")) {
                return false;
            }
            return Boolean.parseBoolean(String.valueOf(bundle.get("ScopedStorage")));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean q(@NonNull String str) {
        return h(str, "android.permission.MANAGE_EXTERNAL_STORAGE") || h(str, "android.permission.REQUEST_INSTALL_PACKAGES") || h(str, "android.permission.SYSTEM_ALERT_WINDOW") || h(str, "android.permission.WRITE_SETTINGS") || h(str, "android.permission.NOTIFICATION_SERVICE") || h(str, "android.permission.PACKAGE_USAGE_STATS") || h(str, "android.permission.SCHEDULE_EXACT_ALARM") || h(str, "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE") || h(str, "android.permission.ACCESS_NOTIFICATION_POLICY") || h(str, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") || h(str, "android.permission.BIND_VPN_SERVICE") || h(str, "android.permission.PICTURE_IN_PICTURE");
    }

    @SuppressLint({"SwitchIntDef"})
    public static void r(@NonNull Activity activity) {
        try {
            int i = activity.getResources().getConfiguration().orientation;
            if (i == 1) {
                activity.setRequestedOrientation(n(activity) ? 9 : 1);
            } else if (i == 2) {
                activity.setRequestedOrientation(n(activity) ? 8 : 0);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void s(Activity activity, String[] strArr, int[] iArr) {
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            boolean zJ = w51.j(str);
            if (n51.f() && n51.b(activity) >= 33 && h(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                zJ = true;
            }
            if (!n51.f() && (h(str, "android.permission.POST_NOTIFICATIONS") || h(str, "android.permission.NEARBY_WIFI_DEVICES") || h(str, "android.permission.BODY_SENSORS_BACKGROUND") || h(str, "android.permission.READ_MEDIA_IMAGES") || h(str, "android.permission.READ_MEDIA_VIDEO") || h(str, "android.permission.READ_MEDIA_AUDIO"))) {
                zJ = true;
            }
            if (!n51.e() && (h(str, "android.permission.BLUETOOTH_SCAN") || h(str, "android.permission.BLUETOOTH_CONNECT") || h(str, "android.permission.BLUETOOTH_ADVERTISE"))) {
                zJ = true;
            }
            if (!n51.c() && (h(str, "android.permission.ACCESS_BACKGROUND_LOCATION") || h(str, "android.permission.ACTIVITY_RECOGNITION") || h(str, "android.permission.ACCESS_MEDIA_LOCATION"))) {
                zJ = true;
            }
            if (!n51.o() && h(str, "android.permission.ACCEPT_HANDOVER")) {
                zJ = true;
            }
            if (!n51.n() && (h(str, "android.permission.ANSWER_PHONE_CALLS") || h(str, "android.permission.READ_PHONE_NUMBERS"))) {
                zJ = true;
            }
            if (h(str, "com.android.permission.GET_INSTALLED_APPS") ? true : zJ) {
                iArr[i] = w51.f(activity, str) ? 0 : -1;
            }
        }
    }

    public static void t(@NonNull List<String> list, @NonNull Runnable runnable) {
        long j = 300;
        long j2 = n51.d() ? 200L : 300L;
        if (!n61.j() && !n61.k()) {
            j = (n61.m() && n51.d() && g(list, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) ? 1000L : j2;
        } else if (!n51.n()) {
            j = 500;
        }
        u(runnable, j);
    }

    public static void u(@NonNull Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }

    @RequiresApi(api = 23)
    public static boolean v(@NonNull Activity activity, @NonNull String str) {
        if (n51.a() == 31) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
