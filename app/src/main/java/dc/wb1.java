package dc;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ScanDevices.java */
/* loaded from: classes3.dex */
public class wb1 {
    public ArrayList<BluetoothDevice> a = new ArrayList<>();
    public ArrayList<vb1> b = new ArrayList<>();
    public Map<BluetoothDevice, vb1> c = new HashMap();

    public void a(String str) {
        Map<BluetoothDevice, vb1> map;
        vb1 vb1Var;
        BluetoothDevice bluetoothDeviceC = c(str);
        if (bluetoothDeviceC == null || (map = this.c) == null || (vb1Var = map.get(bluetoothDeviceC)) == null) {
            return;
        }
        vb1Var.a();
    }

    public void b(vb1 vb1Var) {
        if (!this.a.contains(vb1Var.d())) {
            this.a.add(vb1Var.d());
            this.b.add(vb1Var);
            this.c.put(vb1Var.d(), vb1Var);
        } else {
            vb1 vb1Var2 = this.c.get(vb1Var.d());
            if (vb1Var2 != null) {
                vb1Var2.f(vb1Var.e());
            }
        }
    }

    public BluetoothDevice c(String str) {
        Iterator<BluetoothDevice> it = this.a.iterator();
        while (it.hasNext()) {
            BluetoothDevice next = it.next();
            if (next.getAddress().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public boolean d(String str) {
        Map<BluetoothDevice, vb1> map;
        BluetoothDevice bluetoothDeviceC = c(str);
        if (bluetoothDeviceC == null || (map = this.c) == null) {
            return false;
        }
        return map.containsKey(bluetoothDeviceC);
    }

    public boolean e(String str) {
        Map<BluetoothDevice, vb1> map;
        BluetoothDevice bluetoothDeviceC = c(str);
        if (bluetoothDeviceC == null || (map = this.c) == null) {
            return false;
        }
        vb1 vb1Var = map.get(bluetoothDeviceC);
        if (vb1Var != null && vb1Var.c() >= 5) {
            String str2 = "needConnectDevice: 连接扫描玩具次数超标记 address=" + str + "  count: " + vb1Var.c();
        }
        return vb1Var != null && vb1Var.c() <= 5;
    }

    public void f(String str) {
        vb1 vb1Var;
        BluetoothDevice bluetoothDeviceC = c(str);
        if (bluetoothDeviceC == null || (vb1Var = this.c.get(bluetoothDeviceC)) == null) {
            return;
        }
        this.a.remove(vb1Var.d());
        this.c.remove(vb1Var.d());
        this.b.remove(vb1Var);
    }
}
