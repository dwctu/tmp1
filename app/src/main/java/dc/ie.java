package dc;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/* compiled from: APKExpansionSupport.java */
/* loaded from: classes.dex */
public class ie {
    public static String[] a(Context context, int i, int i2) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i > 0) {
                    String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                    if (new File(str).isFile()) {
                        vector.add(str);
                    }
                }
                if (i2 > 0) {
                    String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                    if (new File(str2).isFile()) {
                        vector.add(str2);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static je b(Context context, int i, int i2) throws IOException {
        return c(a(context, i, i2));
    }

    public static je c(String[] strArr) throws IOException {
        je jeVar = null;
        for (String str : strArr) {
            if (jeVar == null) {
                jeVar = new je(str);
            } else {
                jeVar.a(str);
            }
        }
        return jeVar;
    }
}
