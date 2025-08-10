package dc;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleGattCharacteristic;
import com.xtremeprog.sdk.ble.BleGattService;
import com.xtremeprog.sdk.ble.BleService;
import com.xtremeprog.sdk.ble.IBle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DxBtConnect.java */
/* loaded from: classes3.dex */
public class rb1 {
    public tb1 a;
    public b g;
    public c h;
    public Map<String, Integer> b = new ConcurrentHashMap();
    public Map<String, Integer> c = new ConcurrentHashMap();
    public Map<String, ArrayList<ArrayList<qb1>>> d = new ConcurrentHashMap();
    public Map<String, SimpleExpandableListAdapter> e = new ConcurrentHashMap();
    public Map<String, qb1> f = new ConcurrentHashMap();
    public final BroadcastReceiver i = new a();

    /* compiled from: DxBtConnect.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string;
            Bundle extras = intent.getExtras();
            if (extras == null || (string = extras.getString(BleService.EXTRA_ADDR)) == null || !rb1.this.l(string)) {
                return;
            }
            String action = intent.getAction();
            if (BleService.BLE_GATT_CONNECTED.equals(action)) {
                if (rb1.this.a.b) {
                    String str = tb1.i;
                    String str2 = "connect-> address:" + string;
                }
                rb1.this.c.put(string, 1);
                if (rb1.this.g != null) {
                    rb1.this.g.b(string);
                    return;
                }
                return;
            }
            if (BleService.BLE_GATT_DISCONNECTED.equals(action)) {
                if (rb1.this.a.b) {
                    String str3 = tb1.i;
                    String str4 = "disconnect-> address:" + string;
                }
                if (rb1.this.g != null) {
                    rb1.this.g.a(string, extras.getInt("STATUS", -1));
                }
                rb1.this.c.remove(string);
                rb1.this.d.remove(string);
                rb1.this.e.remove(string);
                rb1.this.f.remove(string);
                return;
            }
            if (BleService.BLE_SERVICE_DISCOVERED.equals(action)) {
                if (rb1.this.a.b) {
                    String str5 = tb1.i;
                    String str6 = "service.discovered-> address:" + string;
                }
                rb1 rb1Var = rb1.this;
                IBle iBle = rb1Var.a.g;
                if (iBle == null) {
                    return;
                }
                rb1Var.i(string, iBle.getServices(string));
                if (rb1.this.f.get(string) != null) {
                    if (rb1.this.h != null) {
                        rb1.this.h.b(string);
                    }
                } else {
                    rp1.i(string);
                    if (rb1.this.h != null) {
                        rb1.this.h.a(string);
                    }
                    rb1.this.h(string);
                }
            }
        }
    }

    /* compiled from: DxBtConnect.java */
    public interface b {
        void a(String str, int i);

        void b(String str);
    }

    /* compiled from: DxBtConnect.java */
    public interface c {
        void a(String str);

        void b(String str);

        boolean c(qb1 qb1Var);
    }

    public rb1(tb1 tb1Var) {
        this.a = tb1Var;
    }

    public void h(String str) {
        this.b.remove(str);
        tb1 tb1Var = this.a;
        if (tb1Var.g != null) {
            if (tb1Var.b) {
                String str2 = tb1.i;
                String str3 = "request.Disconnect! address:" + str;
            }
            this.a.g.disconnect(str);
            rp1.k(str);
            String str4 = "disconnectLog: " + str;
        }
    }

    public final void i(String str, List<BleGattService> list) {
        if (list == null) {
            return;
        }
        ArrayList<ArrayList<qb1>> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<BleGattService> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String str2 = BleService.EXTRA_UUID;
            if (!zHasNext) {
                break;
            }
            BleGattService next = it.next();
            HashMap map = new HashMap();
            String upperCase = next.getUuid().toString().toUpperCase();
            map.put("NAME", tb1.j.containsKey(upperCase) ? tb1.j.get(upperCase) : "Unknown service");
            map.put(BleService.EXTRA_UUID, upperCase);
            arrayList2.add(map);
            ArrayList arrayList4 = new ArrayList();
            List<BleGattCharacteristic> characteristics = next.getCharacteristics();
            ArrayList<qb1> arrayList5 = new ArrayList<>();
            for (BleGattCharacteristic bleGattCharacteristic : characteristics) {
                HashMap map2 = new HashMap();
                String upperCase2 = bleGattCharacteristic.getUuid().toString().toUpperCase();
                map2.put("NAME", tb1.k.containsKey(upperCase2) ? tb1.k.get(upperCase2) : "Unknown characteristic");
                map2.put(str2, upperCase2);
                arrayList4.add(map2);
                Iterator<BleGattService> it2 = it;
                ArrayList arrayList6 = arrayList2;
                ArrayList<qb1> arrayList7 = arrayList5;
                String str3 = str2;
                ArrayList arrayList8 = arrayList4;
                qb1 qb1Var = new qb1(this.a.g, str, bleGattCharacteristic, upperCase, upperCase2, bleGattCharacteristic.getProperties());
                arrayList7.add(qb1Var);
                if (this.g != null) {
                    if (this.h.c(qb1Var)) {
                        this.f.put(str, qb1Var);
                    } else if (this.a.b) {
                        String str4 = tb1.i;
                        String str5 = "Toy not filterService " + str + " S_uuid:" + upperCase + " C_uuid:" + upperCase2 + " getCharaProp=" + qb1Var.b() + " address:" + str;
                    }
                }
                arrayList4 = arrayList8;
                arrayList5 = arrayList7;
                it = it2;
                arrayList2 = arrayList6;
                str2 = str3;
            }
            arrayList.add(arrayList5);
            arrayList3.add(arrayList4);
            arrayList2 = arrayList2;
        }
        ArrayList arrayList9 = arrayList2;
        if (list.size() == 0) {
            if (this.a.b) {
                String str6 = tb1.i;
                String str7 = "Toy gattServices.size() == 0 -> address:" + str;
            }
            rp1.i(str);
        }
        this.d.put(str, arrayList);
        this.e.put(str, new SimpleExpandableListAdapter(WearUtils.x, arrayList9, R.layout.simple_expandable_list_item_2, new String[]{"NAME", BleService.EXTRA_UUID}, new int[]{R.id.text1, R.id.text2}, arrayList3, R.layout.simple_expandable_list_item_2, new String[]{"NAME", BleService.EXTRA_UUID}, new int[]{R.id.text1, R.id.text2}));
    }

    public qb1 j(String str) {
        return this.f.get(str);
    }

    public boolean k(String str) {
        tb1 tb1Var;
        IBle iBle;
        ArrayList<BleGattService> services;
        return (WearUtils.e1(str) || (tb1Var = this.a) == null || (iBle = tb1Var.g) == null || (services = iBle.getServices(str)) == null || services.size() == 0 || !WearUtils.x.G().y(WearUtils.x, false)) ? false : true;
    }

    public boolean l(String str) {
        boolean zContains = this.b.keySet().contains(str);
        if (zContains || !pc1.a.z(str)) {
            return zContains;
        }
        return true;
    }

    public void m() {
        LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.i, BleService.getIntentConnectFilter());
    }

    public int n(String str) {
        this.b.put(str, 1);
        if (this.a.g == null) {
            return -993;
        }
        xe3.a("connectScan", "send.Connect.address: 发送连接请求！" + str);
        boolean zRequestConnect = this.a.g.requestConnect(str);
        if (zRequestConnect) {
            xe3.a("reconnectOneLoopFlag", "requestConnect send==" + zRequestConnect + " == time = " + be3.n());
            return 1;
        }
        if (tb1.d().b) {
            String str2 = tb1.i;
            String str3 = "send.Connect.Failed! address:" + str;
        }
        xe3.a("connectScan", "requestConnect:  发送连接请求失败：" + str);
        return -998;
    }

    public void o() {
        IBle iBle = this.a.g;
        if (iBle != null) {
            iBle.resetBleParams();
        }
    }

    public void p(b bVar) {
        this.g = bVar;
    }

    public void q(c cVar) {
        this.h = cVar;
    }
}
