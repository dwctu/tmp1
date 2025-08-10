package dc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: LanguageUtils.java */
/* loaded from: classes.dex */
public class ce0 {
    public static void a(Activity activity) {
        String strG = xe0.x().g("KEY_LOCALE");
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        Locale localeB = "VALUE_FOLLOW_SYSTEM".equals(strG) ? b(Resources.getSystem().getConfiguration()) : f(strG);
        if (localeB == null) {
            return;
        }
        h(activity, localeB);
        h(ve0.a(), localeB);
    }

    public static Locale b(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static Locale c() {
        return b(Resources.getSystem().getConfiguration());
    }

    public static boolean d(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '$') {
                if (i >= 1) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }

    public static void e(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }

    public static Locale f(String str) {
        Locale localeG = g(str);
        if (localeG == null) {
            de0.l("LanguageUtils", "The string of " + str + " is not in the correct format.");
            xe0.x().s("KEY_LOCALE");
        }
        return localeG;
    }

    public static Locale g(String str) {
        if (!d(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void h(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        e(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
