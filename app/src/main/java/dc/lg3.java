package dc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Store.java */
/* loaded from: classes4.dex */
public class lg3 {
    public static Map<String, String> a = new a();

    /* compiled from: Store.java */
    public class a extends LinkedHashMap {
        public a() {
            put("English", "en");
            put("Français", "fr");
            put("Español", "es");
            put("Polski", "pl");
            put("Pусский", "ru");
            put("简体中文", "zh");
            put("繁体中文", "zh-rTW");
            put("日本語", "ja");
            put("한국어", "ko");
            put("Deutsch", "de");
        }
    }

    public static void a(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale localeE = e(context);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(localeE);
            LocaleList localeList = new LocaleList(localeE);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
        } else {
            configuration.setLocale(localeE);
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static String b(Context context) {
        return c(e(context));
    }

    public static String c(Locale locale) {
        String language = locale.getLanguage();
        if (language == null) {
            language = "en";
        }
        if (!"zh".equals(language.toLowerCase())) {
            return language;
        }
        String lowerCase = locale.getCountry().toLowerCase();
        return (lowerCase.equals("ch") || lowerCase.equals("cn")) ? language : "zh-tw";
    }

    public static String d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("language", "");
    }

    public static Locale e(Context context) {
        String strD = d(context);
        return !TextUtils.isEmpty(strD) ? strD.contains("zh") ? !strD.equals("zh") ? new Locale("zh", "TW") : new Locale("zh", "CH") : new Locale(strD) : Build.VERSION.SDK_INT >= 24 ? Resources.getSystem().getConfiguration().getLocales().get(0) : Locale.getDefault();
    }

    public static String f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("language", "");
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putString("language", str);
        editorEdit.commit();
    }

    public static Context h(Context context) {
        Resources resources = context.getResources();
        Locale localeE = e(context);
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(localeE);
            LocaleList localeList = new LocaleList(localeE);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
        } else {
            configuration.setLocale(localeE);
        }
        return context.createConfigurationContext(configuration);
    }
}
