package dc;

import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: PushLogUtils.java */
/* loaded from: classes4.dex */
public class vf3 {
    public static void a(String str, int i, int i2) {
        HashMap map;
        map = new HashMap();
        str.hashCode();
        switch (str) {
            case "A0021":
            case "A0023":
            case "A0025":
                map.put("source", Integer.valueOf(i));
                break;
            case "A0022":
            case "A0024":
            case "A0026":
                map.put("source", Integer.valueOf(i));
                map.put("button_type", Integer.valueOf(i2));
                break;
        }
        ye3.d(str, WearUtils.A.toJson(map));
    }
}
