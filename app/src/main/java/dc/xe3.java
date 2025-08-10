package dc;

import android.os.Looper;
import android.text.TextUtils;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: LogLog.java */
/* loaded from: classes4.dex */
public class xe3 {
    public static boolean a = false;

    public static void a(String str, CharSequence charSequence) {
        b(str, "", charSequence);
    }

    public static void b(String str, CharSequence charSequence, CharSequence charSequence2) {
        c(str, charSequence, charSequence2);
    }

    public static void c(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            String str2 = ((Object) charSequence) + SignatureImpl.INNER_SEP + charSequence2.toString();
            try {
                if (a) {
                    h42.c().e(str, charSequence2);
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        String str3 = ((Object) charSequence) + SignatureImpl.INNER_SEP + charSequence2.toString();
        try {
            if (a) {
                h42.c().e(str, charSequence2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d() {
        StringBuilder sb = new StringBuilder();
        sb.append("当前是否是主线程==");
        sb.append(Thread.currentThread() == Looper.getMainLooper().getThread());
        a("printlnThread", sb.toString());
    }
}
