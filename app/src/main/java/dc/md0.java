package dc;

import java.lang.reflect.Type;

/* compiled from: CloneUtils.java */
/* loaded from: classes.dex */
public final class md0 {
    public static <T> T a(T t, Type type) {
        try {
            return (T) xe0.l(xe0.S(t), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
