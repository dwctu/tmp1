package dc;

import android.content.res.Resources;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.util.IllegalFormatException;

/* compiled from: StringUtils.java */
/* loaded from: classes.dex */
public final class re0 {
    public static String a(@Nullable String str, Object... objArr) {
        if (d(str) || objArr == null || objArr.length <= 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String b(@StringRes int i) {
        return c(i, null);
    }

    public static String c(@StringRes int i, Object... objArr) {
        try {
            return a(ve0.a().getString(i), objArr);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return String.valueOf(i);
        }
    }

    public static boolean d(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean e(String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    public static boolean f(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
