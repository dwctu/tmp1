package dc;

import com.wear.bean.Account;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatSynTimeUtils.java */
/* loaded from: classes4.dex */
public class td3 implements yc1 {
    public static td3 d;
    public HashMap<String, Object> a;
    public int b = 0;
    public MessageType c;

    public td3() {
        new HashMap();
        this.a = new HashMap<>();
        new HashMap();
        pc1.a.t(this);
    }

    public static td3 c() {
        if (d == null) {
            d = new td3();
        }
        return d;
    }

    public static int d() {
        return ((Integer) eg3.b(WearUtils.x, "ldrSensitivity", 75)).intValue();
    }

    public static void f(int i) {
        eg3.i(WearUtils.x, "ldrSensitivity", Integer.valueOf(i));
    }

    public HashMap<String, Object> a() {
        HashMap<String, Object> map = new HashMap<>();
        String[] strArrB = c().b();
        if (strArrB != null && strArrB.length > 0 && !WearUtils.e1(strArrB[0]) && this.b != 0) {
            String str = strArrB[0];
            Account accountU = WearUtils.y.u();
            if (accountU != null && accountU.getLiveStatus() != 0 && this.c != null) {
                map.put("to", str);
                map.put("type", this.c.name());
                map.put("req", Integer.valueOf(this.b));
            }
        }
        return map;
    }

    public String[] b() {
        HashMap<String, Object> map = this.a;
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[this.a.size()];
        int i = 0;
        Iterator<String> it = this.a.keySet().iterator();
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }

    public synchronized void e(EntityToy entityToy) {
        if (!ChatVideoControl.a1().r()) {
            ChatSyncControl.N0().r();
        }
        if (ChatVideoControl.a1().r()) {
            ChatVideoControl.a1().F1(entityToy, false);
        }
    }

    public void g(MessageType messageType, int i) {
        this.c = messageType;
        this.b = i;
        hu3.T();
    }

    @Override // dc.yc1
    public void j(String str, List<Integer> list, List<Integer> list2) {
        if (ChatSyncControl.N0().r()) {
            ChatSyncControl.N0().p.R(str, list, list2);
        }
        if (ChatVideoControl.a1().r()) {
            ChatVideoControl.a1().o.R(str, list, list2);
        }
    }
}
