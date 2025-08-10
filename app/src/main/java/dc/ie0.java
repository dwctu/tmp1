package dc;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: ProcessUtils.java */
/* loaded from: classes.dex */
public final class ie0 {
    public static String a() throws IOException {
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strB = b();
        return !TextUtils.isEmpty(strB) ? strB : d();
    }

    public static String b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) ve0.a().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() != 0) {
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid && (str = runningAppProcessInfo.processName) != null) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String c() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return strTrim;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Application applicationA = ve0.a();
            Field field = applicationA.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(applicationA);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
