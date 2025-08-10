package io.microshow.rxffmpeg.player;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class Helper {
    private static long lastClickTime;

    public static ViewGroup getDecorView(Context context) {
        Activity activityScanForActivity = scanForActivity(context);
        if (activityScanForActivity == null) {
            return null;
        }
        return (ViewGroup) activityScanForActivity.getWindow().getDecorView();
    }

    public static int getFullScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        scanForActivity(context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void hideSysBar(Activity activity, ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            systemUiVisibility |= 2;
        }
        if (i >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static synchronized boolean isFastClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime < 1000) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String secdsToDateFormat(int i, int i2) {
        String str;
        String str2;
        long j = i / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        long j2 = (i % SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT) / 60;
        long j3 = i % 60;
        String str3 = "00";
        if (j <= 0) {
            str = "00";
        } else if (j < 10) {
            str = "0" + j;
        } else {
            str = j + "";
        }
        if (j2 <= 0) {
            str2 = "00";
        } else if (j2 < 10) {
            str2 = "0" + j2;
        } else {
            str2 = j2 + "";
        }
        if (j3 > 0) {
            if (j3 < 10) {
                str3 = "0" + j3;
            } else {
                str3 = j3 + "";
            }
        }
        if (i2 < 3600) {
            return str2 + SignatureImpl.INNER_SEP + str3;
        }
        return str + SignatureImpl.INNER_SEP + str2 + SignatureImpl.INNER_SEP + str3;
    }

    public static ViewGroup setFullScreen(Context context, boolean z) {
        Activity activityScanForActivity = scanForActivity(context);
        ViewGroup decorView = getDecorView(activityScanForActivity);
        if (decorView == null) {
            return null;
        }
        if (z) {
            hideSysBar(activityScanForActivity, decorView);
            activityScanForActivity.setRequestedOrientation(0);
        } else {
            showSysBar(activityScanForActivity, decorView);
            activityScanForActivity.setRequestedOrientation(1);
        }
        return decorView;
    }

    public static void showSysBar(Activity activity, ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility();
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            systemUiVisibility &= -3;
        }
        if (i >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        activity.getWindow().clearFlags(1024);
    }

    public static ViewGroup getDecorView(Activity activity) {
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }
}
