package dc;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ObjectDescriptorFactory.java */
/* loaded from: classes2.dex */
public class x41 {
    public static Logger a = Logger.getLogger(x41.class.getName());
    public static Map<Integer, Map<Integer, Class<? extends n41>>> b = new HashMap();

    static {
        HashSet<Class<? extends n41>> hashSet = new HashSet();
        hashSet.add(r41.class);
        hashSet.add(z41.class);
        hashSet.add(n41.class);
        hashSet.add(u41.class);
        hashSet.add(w41.class);
        hashSet.add(y41.class);
        hashSet.add(m41.class);
        hashSet.add(v41.class);
        hashSet.add(t41.class);
        hashSet.add(q41.class);
        for (Class<? extends n41> cls : hashSet) {
            s41 s41Var = (s41) cls.getAnnotation(s41.class);
            int[] iArrTags = s41Var.tags();
            int iObjectTypeIndication = s41Var.objectTypeIndication();
            Map<Integer, Class<? extends n41>> map = b.get(Integer.valueOf(iObjectTypeIndication));
            if (map == null) {
                map = new HashMap<>();
            }
            for (int i : iArrTags) {
                map.put(Integer.valueOf(i), cls);
            }
            b.put(Integer.valueOf(iObjectTypeIndication), map);
        }
    }

    public static n41 a(int i, ByteBuffer byteBuffer) throws IOException {
        n41 a51Var;
        int iL = df0.l(byteBuffer);
        Map<Integer, Class<? extends n41>> map = b.get(Integer.valueOf(i));
        if (map == null) {
            map = b.get(-1);
        }
        Class<? extends n41> cls = map.get(Integer.valueOf(iL));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            a.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(iL) + " found: " + cls);
            a51Var = new a51();
        } else {
            try {
                a51Var = cls.newInstance();
            } catch (Exception e) {
                a.log(Level.SEVERE, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + iL, (Throwable) e);
                throw new RuntimeException(e);
            }
        }
        a51Var.d(iL, byteBuffer);
        return a51Var;
    }
}
