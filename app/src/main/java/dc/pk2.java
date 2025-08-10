package dc;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.WebSockQRCode;
import com.wear.util.WearUtils;
import java.util.HashMap;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SocketTranToLocalHttpService.java */
/* loaded from: classes3.dex */
public class pk2 {
    public static Integer a(String str) {
        HashMap map = (HashMap) WearUtils.A.fromJson(str, HashMap.class);
        if (map == null || map.get("type") == null || map.get("data") == null || map.get("from") == null) {
            return null;
        }
        if (map.get("type").equals("131")) {
            return 131;
        }
        if (map.get("type").equals("132")) {
            return 132;
        }
        if (map.get("type").equals(SyncWsProtocol.CONTROL_133_TYPE_CODE_WEB_TRAN_HTTP)) {
            return Integer.valueOf(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA);
        }
        return null;
    }

    public static void b(LinkedTreeMap linkedTreeMap) {
        SyncWsProtocol.DataBean dataBean;
        try {
            if (linkedTreeMap.get("type") != null && linkedTreeMap.get("type").toString().equals("createSync")) {
                Gson gson = WearUtils.A;
                WebSockQRCode webSockQRCode = (WebSockQRCode) gson.fromJson(gson.toJson(linkedTreeMap), WebSockQRCode.class);
                if (webSockQRCode != null) {
                    EventBus.getDefault().post(webSockQRCode);
                    return;
                }
                return;
            }
            if (linkedTreeMap.get("data") == null || db2.A().b == null || db2.A().b.j == null) {
                return;
            }
            SyncWsProtocol syncWsProtocol = new SyncWsProtocol();
            syncWsProtocol.setType(SyncWsProtocol.CONTROL_SYNC_TYPE_KEY);
            if (linkedTreeMap.get("type") == null || !linkedTreeMap.get("type").toString().equals(SyncWsProtocol.CONTROL_ORDER_TOY_TYPE_KEY)) {
                Gson gson2 = WearUtils.A;
                dataBean = (SyncWsProtocol.DataBean) gson2.fromJson(gson2.toJson(linkedTreeMap.get("data")), SyncWsProtocol.DataBean.class);
            } else {
                Gson gson3 = WearUtils.A;
                dataBean = (SyncWsProtocol.DataBean) gson3.fromJson(gson3.toJson(linkedTreeMap), SyncWsProtocol.DataBean.class);
            }
            if (dataBean != null) {
                syncWsProtocol.setData(dataBean);
                db2.A().b.j.d(WearUtils.A.toJson(syncWsProtocol));
            }
        } catch (Exception unused) {
        }
    }

    public static void c(String str, LinkedTreeMap linkedTreeMap) {
        if (linkedTreeMap == null || linkedTreeMap.get("type") == null || !linkedTreeMap.get("type").equals("gt")) {
            return;
        }
        db2.A().N(str);
    }

    public static void d(int i, String str) {
        HashMap map = (HashMap) WearUtils.A.fromJson(str, HashMap.class);
        if (map == null || map.get("data") == null || map.get("from") == null) {
            return;
        }
        LinkedTreeMap linkedTreeMap = null;
        try {
            linkedTreeMap = (LinkedTreeMap) map.get("data");
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        if (linkedTreeMap != null) {
            if (i == 131) {
                b(linkedTreeMap);
            } else {
                if (i != 132) {
                    return;
                }
                c((String) map.get("from"), linkedTreeMap);
            }
        }
    }
}
