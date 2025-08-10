package dc;

import android.content.Context;
import android.content.SharedPreferences;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: SPUtils.java */
/* loaded from: classes4.dex */
public class eg3 {
    public static final String a = WearUtils.r0("f01_show_again");

    /* compiled from: SPUtils.java */
    public static class a {
        public static final Method a = b();

        public static void a(SharedPreferences.Editor editor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                Method method = a;
                if (method != null) {
                    method.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.commit();
        }

        public static Method b() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static boolean a(Context context, String str) {
        return context.getSharedPreferences("wear_share_data", 0).contains(str);
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wear_share_data", 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Map<String, ?> c(Context context) {
        return context.getSharedPreferences("wear_share_data", 0).getAll();
    }

    public static boolean d(Context context, String str, boolean z) {
        return context.getSharedPreferences("wear_share_data", 0).getBoolean(str, z);
    }

    public static int e(Context context, String str) {
        return f(context, str, 0);
    }

    public static int f(Context context, String str, int i) {
        return context.getSharedPreferences("wear_share_data", 0).getInt(str, i);
    }

    public static long g(Context context, String str, long j) {
        return context.getSharedPreferences("wear_share_data", 0).getLong(str, j);
    }

    public static String h(Context context, String str, String str2) {
        return context.getSharedPreferences("wear_share_data", 0).getString(str, str2);
    }

    public static void i(Context context, String str, Object obj) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("wear_share_data", 0).edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else {
            editorEdit.putString(str, obj.toString());
        }
        a.a(editorEdit);
    }

    public static void j(Context context, String str, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("wear_share_data", 0).edit();
        editorEdit.putBoolean(str, z);
        a.a(editorEdit);
    }

    public static void k(Context context, String str, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("wear_share_data", 0).edit();
        editorEdit.putInt(str, i);
        a.a(editorEdit);
    }

    public static void l(Context context, String str, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("wear_share_data", 0).edit();
        editorEdit.putLong(str, j);
        a.a(editorEdit);
    }

    public static void m(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("wear_share_data", 0).edit();
        editorEdit.remove(str);
        a.a(editorEdit);
    }
}
