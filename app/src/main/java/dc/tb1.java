package dc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.wear.bean.Toy;
import com.xtremeprog.sdk.ble.BleGattService;
import com.xtremeprog.sdk.ble.BleService;
import com.xtremeprog.sdk.ble.IBle;
import dc.pb1;
import dc.rb1;
import dc.sb1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DxBtUtils.java */
/* loaded from: classes3.dex */
public class tb1 {
    public static final String i = "tb1";
    public static Map<String, String> j = new HashMap();
    public static Map<String, String> k = new HashMap();
    public static tb1 l;
    public sb1 c;
    public rb1 d;
    public pb1 e;
    public BleService f;
    public IBle g;
    public boolean b = true;
    public final ServiceConnection h = new a();
    public Handler a = new Handler(Looper.getMainLooper());

    /* compiled from: DxBtUtils.java */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    if (iBinder instanceof BleService.LocalBinder) {
                        tb1.this.f = ((BleService.LocalBinder) iBinder).getService();
                        tb1 tb1Var = tb1.this;
                        tb1Var.g = tb1Var.f.getBle();
                        IBle iBle = tb1.this.g;
                        if (iBle != null) {
                            iBle.adapterEnabled();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            tb1.this.f = null;
            tb1.this.g = null;
        }
    }

    static {
        j.put("00001811-0000-1000-8000-00805F9B34FB", "Alert Notification Service");
        j.put("0000180F-0000-1000-8000-00805F9B34FB", "Battery Service");
        j.put("00001810-0000-1000-8000-00805F9B34FB", "Blood Pressure");
        j.put("00001805-0000-1000-8000-00805F9B34FB", "Current Time Service");
        j.put("00001818-0000-1000-8000-00805F9B34FB", "Cycling Power");
        j.put("00001816-0000-1000-8000-00805F9B34FB", "Cycling Speed and Cadence");
        j.put("0000180A-0000-1000-8000-00805F9B34FB", "Device Information");
        j.put("00001800-0000-1000-8000-00805F9B34FB", "Generic Access");
        j.put("00001801-0000-1000-8000-00805F9B34FB", "Generic Attribute");
        j.put("00001808-0000-1000-8000-00805F9B34FB", "Glucose");
        j.put("00001809-0000-1000-8000-00805F9B34FB", "Health Thermometer");
        j.put("0000180D-0000-1000-8000-00805F9B34FB", "Heart Rate");
        j.put("00001812-0000-1000-8000-00805F9B34FB", "Human Interface Device");
        j.put("00001802-0000-1000-8000-00805F9B34FB", "Immediate Alert");
        j.put("00001803-0000-1000-8000-00805F9B34FB", "Link Loss");
        j.put("00001819-0000-1000-8000-00805F9B34FB", "Location and Navigation");
        j.put("00001807-0000-1000-8000-00805F9B34FB", "Next DST Change Service");
        j.put("0000180E-0000-1000-8000-00805F9B34FB", "Phone Alert Status Service");
        j.put("00001806-0000-1000-8000-00805F9B34FB", "Reference Time Update Service");
        j.put("00001814-0000-1000-8000-00805F9B34FB", "Running Speed and Cadence");
        j.put("00001813-0000-1000-8000-00805F9B34FB", "Scan Parameters");
        j.put("00001804-0000-1000-8000-00805F9B34FB", "Tx Power");
        k.put("00002A43-0000-1000-8000-00805F9B34FB", "Alert Category ID");
        k.put("00002A42-0000-1000-8000-00805F9B34FB", "Alert Category ID Bit Mask");
        k.put("00002A06-0000-1000-8000-00805F9B34FB", "Alert Level");
        k.put("00002A44-0000-1000-8000-00805F9B34FB", "Alert Notification Control Point");
        k.put("00002A3F-0000-1000-8000-00805F9B34FB", "Alert Status");
        k.put("00002A01-0000-1000-8000-00805F9B34FB", "Appearance");
        k.put("00002A19-0000-1000-8000-00805F9B34FB", "Battery Level");
        k.put("00002A49-0000-1000-8000-00805F9B34FB", "Blood Pressure Feature");
        k.put("00002A35-0000-1000-8000-00805F9B34FB", "Blood Pressure Measurement");
        k.put("00002A38-0000-1000-8000-00805F9B34FB", "Body Sensor Location");
        k.put("00002A22-0000-1000-8000-00805F9B34FB", "Boot Keyboard Input Report");
        k.put("00002A32-0000-1000-8000-00805F9B34FB", "Boot Keyboard Output Report");
        k.put("00002A33-0000-1000-8000-00805F9B34FB", "Boot Mouse Input Report");
        k.put("00002A5C-0000-1000-8000-00805F9B34FB", "CSC Feature");
        k.put("00002A5B-0000-1000-8000-00805F9B34FB", "CSC Measurement");
        k.put("00002A2B-0000-1000-8000-00805F9B34FB", "Current Time");
        k.put("00002A66-0000-1000-8000-00805F9B34FB", "Cycling Power Control Point");
        k.put("00002A65-0000-1000-8000-00805F9B34FB", "Cycling Power Feature");
        k.put("00002A63-0000-1000-8000-00805F9B34FB", "Cycling Power Measurement");
        k.put("00002A64-0000-1000-8000-00805F9B34FB", "Cycling Power Vector");
        k.put("00002A08-0000-1000-8000-00805F9B34FB", "Date Time");
        k.put("00002A0A-0000-1000-8000-00805F9B34FB", "Day Date Time");
        k.put("00002A09-0000-1000-8000-00805F9B34FB", "Day of Week");
        k.put("00002A00-0000-1000-8000-00805F9B34FB", "Device Name");
        k.put("00002A0D-0000-1000-8000-00805F9B34FB", "DST Offset");
        k.put("00002A0C-0000-1000-8000-00805F9B34FB", "Exact Time 256");
        k.put("00002A26-0000-1000-8000-00805F9B34FB", "Firmware Revision String");
        k.put("00002A51-0000-1000-8000-00805F9B34FB", "Glucose Feature");
        k.put("00002A18-0000-1000-8000-00805F9B34FB", "Glucose Measurement");
        k.put("00002A34-0000-1000-8000-00805F9B34FB", "Glucose Measurement Context");
        k.put("00002A27-0000-1000-8000-00805F9B34FB", "Hardware Revision String");
        k.put("00002A39-0000-1000-8000-00805F9B34FB", "Heart Rate Control Point");
        k.put("00002A37-0000-1000-8000-00805F9B34FB", "Heart Rate Measurement");
        k.put("00002A4C-0000-1000-8000-00805F9B34FB", "HID Control Point");
        k.put("00002A4A-0000-1000-8000-00805F9B34FB", "HID Information");
        k.put("00002A2A-0000-1000-8000-00805F9B34FB", "IEEE 11073-20601 Regulatory Certification Data List");
        k.put("00002A36-0000-1000-8000-00805F9B34FB", "Intermediate Cuff Pressure");
        k.put("00002A1E-0000-1000-8000-00805F9B34FB", "Intermediate Temperature");
        k.put("00002A6B-0000-1000-8000-00805F9B34FB", "LN Control Point");
        k.put("00002A6A-0000-1000-8000-00805F9B34FB", "LN Feature");
        k.put("00002A0F-0000-1000-8000-00805F9B34FB", "Local Time Information");
        k.put("00002A67-0000-1000-8000-00805F9B34FB", "Location and Speed");
        k.put("00002A29-0000-1000-8000-00805F9B34FB", "Manufacturer Name String");
        k.put("00002A21-0000-1000-8000-00805F9B34FB", "Measurement Interval");
        k.put("00002A24-0000-1000-8000-00805F9B34FB", "Model Number String");
        k.put("00002A68-0000-1000-8000-00805F9B34FB", "Navigation");
        k.put("00002A46-0000-1000-8000-00805F9B34FB", "New Alert");
        k.put("00002A04-0000-1000-8000-00805F9B34FB", "Peripheral Preferred Connection Parameters");
        k.put("00002A02-0000-1000-8000-00805F9B34FB", "Peripheral Privacy Flag");
        k.put("00002A50-0000-1000-8000-00805F9B34FB", "PnP ID");
        k.put("00002A69-0000-1000-8000-00805F9B34FB", "Position Quality");
        k.put("00002A4E-0000-1000-8000-00805F9B34FB", "Protocol Mode");
        k.put("00002A03-0000-1000-8000-00805F9B34FB", "Reconnection Address");
        k.put("00002A52-0000-1000-8000-00805F9B34FB", "Record Access Control Point");
        k.put("00002A14-0000-1000-8000-00805F9B34FB", "Reference Time Information");
        k.put("00002A4D-0000-1000-8000-00805F9B34FB", "Report");
        k.put("00002A4B-0000-1000-8000-00805F9B34FB", "Report Map");
        k.put("00002A40-0000-1000-8000-00805F9B34FB", "Ringer Control Point");
        k.put("00002A41-0000-1000-8000-00805F9B34FB", "Ringer Setting");
        k.put("00002A54-0000-1000-8000-00805F9B34FB", "RSC Feature");
        k.put("00002A53-0000-1000-8000-00805F9B34FB", "RSC Measurement");
        k.put("00002A55-0000-1000-8000-00805F9B34FB", "SC Control Point");
        k.put("00002A4F-0000-1000-8000-00805F9B34FB", "Scan Interval Window");
        k.put("00002A31-0000-1000-8000-00805F9B34FB", "Scan Refresh");
        k.put("00002A5D-0000-1000-8000-00805F9B34FB", "Sensor Location");
        k.put("00002A25-0000-1000-8000-00805F9B34FB", "Serial Number String");
        k.put("00002A05-0000-1000-8000-00805F9B34FB", "Service Changed");
        k.put("00002A28-0000-1000-8000-00805F9B34FB", "Software Revision String");
        k.put("00002A47-0000-1000-8000-00805F9B34FB", "Supported New Alert Category");
        k.put("00002A48-0000-1000-8000-00805F9B34FB", "Supported Unread Alert Category");
        k.put("00002A23-0000-1000-8000-00805F9B34FB", "System ID");
        k.put("00002A1C-0000-1000-8000-00805F9B34FB", "Temperature Measurement");
        k.put("00002A1D-0000-1000-8000-00805F9B34FB", "Temperature Type");
        k.put("00002A12-0000-1000-8000-00805F9B34FB", "Time Accuracy");
        k.put("00002A13-0000-1000-8000-00805F9B34FB", "Time Source");
        k.put("00002A16-0000-1000-8000-00805F9B34FB", "Time Update Control Point");
        k.put("00002A17-0000-1000-8000-00805F9B34FB", "Time Update State");
        k.put("00002A11-0000-1000-8000-00805F9B34FB", "Time with DST");
        k.put("00002A0E-0000-1000-8000-00805F9B34FB", "Time Zone");
        k.put("00002A07-0000-1000-8000-00805F9B34FB", "Tx Power Level");
        k.put("00002A45-0000-1000-8000-00805F9B34FB", "Unread Alert Status");
    }

    public tb1() {
        f();
        u(true);
    }

    public static tb1 d() {
        if (l == null) {
            l = new tb1();
        }
        return l;
    }

    public static boolean h(String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    public void c(String str) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            rb1Var.h(str);
        }
    }

    public qb1 e(String str) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            return rb1Var.j(str);
        }
        return null;
    }

    public void f() {
        this.c = new sb1(this);
        this.d = new rb1(this);
        this.e = new pb1(this);
        ve0.a().bindService(new Intent(ve0.a(), (Class<?>) BleService.class), this.h, 1);
    }

    public boolean g(String str) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            return rb1Var.k(str);
        }
        return false;
    }

    public boolean i(Toy toy) {
        ArrayList<BleGattService> services;
        if (toy == null || (services = this.g.getServices(toy.getAddress())) == null) {
            return false;
        }
        Iterator<BleGattService> it = services.iterator();
        while (it.hasNext()) {
            String string = it.next().getUuid().toString();
            String str = "OTA Service: " + string + "   address=" + toy.getAddress();
            if ("1D14D6EE-FD63-4FA1-BFA4-8F47B42119F0".equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public void j(String str) {
        this.g.readPhy(str);
    }

    public void k() {
        pb1 pb1Var = this.e;
        if (pb1Var != null) {
            pb1Var.b();
        }
    }

    public void l() {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            rb1Var.m();
        }
    }

    public void m() {
        sb1 sb1Var = this.c;
        if (sb1Var != null) {
            sb1Var.d();
        }
    }

    public int n(String str) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            return rb1Var.n(str);
        }
        return -992;
    }

    public void o() {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            rb1Var.o();
        }
    }

    public void p(boolean z) {
        sb1 sb1Var = this.c;
        if (sb1Var != null) {
            sb1Var.e(z);
        }
    }

    public void q(pb1.b bVar) {
        pb1 pb1Var = this.e;
        if (pb1Var != null) {
            pb1Var.c(bVar);
        }
    }

    public void r(rb1.b bVar) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            rb1Var.p(bVar);
        }
    }

    public void s(sb1.c cVar) {
        sb1 sb1Var = this.c;
        if (sb1Var != null) {
            sb1Var.f(cVar);
        }
    }

    public void t(rb1.c cVar) {
        rb1 rb1Var = this.d;
        if (rb1Var != null) {
            rb1Var.q(cVar);
        }
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void v(String str, vt vtVar) {
        this.g.setPhyListenCallBack(str, vtVar);
    }

    public void w(String str, int i2, int i3, int i4) {
        this.g.setPreferredPhy(str, i2, i3, i4);
    }
}
