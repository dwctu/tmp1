package dc;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: StoreUtil.java */
/* loaded from: classes5.dex */
public class ah4 {
    public static Application b;
    public static HashMap<String, String> a = new HashMap<>(1000);
    public static LinkedList<ch4> c = new LinkedList<>();
    public static boolean d = true;

    public static void a() {
        Iterator<ch4> it = c.iterator();
        while (it.hasNext()) {
            bh4 bh4Var = it.next().get();
            if (bh4Var == null) {
                it.remove();
            } else {
                bh4Var.a();
            }
        }
    }

    public static String b(int i, String str) throws Resources.NotFoundException {
        String str2;
        String string = "";
        try {
            str2 = a.get(b.getResources().getResourceEntryName(i));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            str2 = "";
        }
        try {
            string = b.getResources().getString(i);
            if (TextUtils.isEmpty(str2)) {
                str2 = string;
            }
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
        return (str.equals(str2) || str.equals(string)) ? str2 : str;
    }

    public static String c(int i) {
        String strE = e(i);
        if (TextUtils.isEmpty(strE)) {
            return strE;
        }
        return strE.substring(0, 1).toUpperCase(Locale.ROOT) + strE.substring(1);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
    }

    public static String e(int i) {
        String str;
        try {
            str = a.get(b.getResources().getResourceEntryName(i));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        try {
            return TextUtils.isEmpty(str) ? b.getResources().getString(i) : str;
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String f(int i, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? e(i) : b.getResources().getString(i, objArr);
    }

    public static String g(String str) {
        try {
            return a.get(str);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void h(Application application) {
        b = application;
    }

    public static void i(HashMap<String, String> map) {
        a.clear();
        a.putAll(map);
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(TextView textView, int i, Object... objArr) throws Resources.NotFoundException {
        if (textView == 0) {
            return;
        }
        if (textView instanceof bh4) {
            ((bh4) textView).setTextResId(i, objArr);
            return;
        }
        String string = a.get(b.getResources().getResourceEntryName(i));
        if (TextUtils.isEmpty(string)) {
            string = b.getResources().getString(i);
        }
        textView.setText(string);
    }

    public static void k() {
    }
}
