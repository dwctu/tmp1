package dc;

import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: LogsByToy.java */
/* loaded from: classes4.dex */
public class ze3 {
    static {
        new CopyOnWriteArrayList();
        new HashMap();
    }

    public static void a(List<Toy> list) {
    }

    public static void b(String str, String str2, String str3) {
    }

    public static void c(Toy toy, BleResultBean bleResultBean) {
        if (WearUtils.x == null) {
            return;
        }
        if (toy == null || toy.canAddConnectingLog(false)) {
            if (toy.isSelect()) {
                rp1.o(toy.getNewLogToyTypeAndRssi(bleResultBean));
            }
            rp1.a(toy);
        }
    }

    public static void d() {
    }

    public static void e() {
    }

    public static String f(int i) {
        if (i == 0) {
            return "GATT_CONN_UNKNOWN";
        }
        if (i == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (i == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i == 133) {
            return "GATT ERROR";
        }
        if (i == 256) {
            return "GATT CONN CANCEL ";
        }
        return "UNKNOWN (" + i + ")";
    }
}
