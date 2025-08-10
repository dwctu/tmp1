package dc;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.wear.util.MyApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.codec.binary.Base64;

/* compiled from: Helper_SharedPreferences.java */
/* loaded from: classes4.dex */
public class pe3 {
    public static void a(String str) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    public static boolean b(String str) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).getBoolean(str, false);
    }

    public static boolean c(String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).getBoolean(str, z);
    }

    public static int d(String str) {
        return PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).getInt(str, 0);
    }

    public static <T> T e(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.N());
        String string = defaultSharedPreferences.getString(str, "");
        if ("".equals(string)) {
            return null;
        }
        try {
            return (T) new ObjectInputStream(new ByteArrayInputStream(Base64.decodeBase64(string.getBytes()))).readObject();
        } catch (ClassNotFoundException e) {
            String[] strArr = {str, "guserid"};
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            for (int i = 0; i < 2; i++) {
                String str2 = strArr[i];
                if (str2 != null && str2.trim().length() > 0) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T f(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.N());
        String strI = nd3.i(defaultSharedPreferences.getString(str, ""));
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        try {
            return (T) new ObjectInputStream(new ByteArrayInputStream(Base64.decodeBase64(strI.getBytes()))).readObject();
        } catch (ClassNotFoundException e) {
            String[] strArr = {str, "guserid"};
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            for (int i = 0; i < 2; i++) {
                String str2 = strArr[i];
                if (str2 != null && str2.trim().length() > 0) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized String g(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.N());
        if (defaultSharedPreferences.getString(str, null) == null) {
            return null;
        }
        return new String(Base64.decodeBase64(defaultSharedPreferences.getString(str, null).getBytes()));
    }

    public static void h(String str, Boolean bool) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        editorEdit.putBoolean(str, bool.booleanValue());
        editorEdit.commit();
    }

    public static void i(String str, Integer num) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        editorEdit.putInt(str, num.intValue());
        editorEdit.commit();
    }

    public static void j(String str, Object obj) throws IOException {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        if (str == null || obj == null) {
            return;
        }
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Serializable) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                editorEdit.putString(str, new String(Base64.encodeBase64(byteArrayOutputStream.toByteArray())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        editorEdit.commit();
    }

    public static void k(String str, Object obj) throws IOException {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        if (str == null || obj == null) {
            return;
        }
        if (obj instanceof Serializable) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                editorEdit.putString(str, nd3.u(new String(Base64.encodeBase64(byteArrayOutputStream.toByteArray()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        editorEdit.commit();
    }

    public static synchronized void l(String str, String str2) {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(MyApplication.N()).edit();
        editorEdit.putString(str, new String(Base64.encodeBase64(str2.getBytes())));
        editorEdit.commit();
    }
}
