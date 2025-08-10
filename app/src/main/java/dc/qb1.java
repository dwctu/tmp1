package dc;

import com.xtremeprog.sdk.ble.BleGattCharacteristic;
import com.xtremeprog.sdk.ble.IBle;
import com.xtremeprog.sdk.ble.IBleRequestHandler;
import java.util.LinkedList;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: DxBtCharacteristicBean.java */
/* loaded from: classes3.dex */
public class qb1 {
    public IBle a;
    public String b;
    public BleGattCharacteristic c;
    public int d;
    public boolean e;
    public boolean f;

    public qb1(IBle iBle, String str, BleGattCharacteristic bleGattCharacteristic, String str2, String str3, int i) {
        this.e = false;
        this.f = false;
        this.a = iBle;
        this.b = str;
        this.c = bleGattCharacteristic;
        this.d = i;
        if ((i & 48) > 0) {
            this.e = true;
        }
        if ((i & 12) > 0) {
            this.f = true;
        }
        int i2 = i & 2;
        if ((i & 16) > 0) {
            this.e = true;
        }
        int i3 = i & 32;
        if ((i & 8) > 0) {
            this.f = true;
        }
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e(String str) {
        IBle iBle = this.a;
        if (iBle != null) {
            return iBle.readRssi(str);
        }
        return false;
    }

    public void f() {
        this.a.requestCharacteristicNotification(this.b, this.c);
    }

    public void g(String str) {
        try {
            if (tb1.d().b) {
                String str2 = tb1.i;
                String str3 = "request.Write.address -> " + this.b + " value =>" + str;
                String str4 = "request.Write.address -> " + this.b + " bytes =>" + str.getBytes();
            }
            this.c.setValue(str.getBytes());
            if (!str.equals("DeviceType;") && !str.equals("GetLevel;") && !str.equals("BM;") && !str.equals("SGM;") && !str.startsWith("Gsensor:") && !str.startsWith("StartMove:") && !str.equals("EM;") && !str.startsWith("StopMove:")) {
                IBle iBle = this.a;
                if (iBle != null) {
                    ((IBleRequestHandler) iBle).writeCharacteristic(this.b, this.c, null);
                    return;
                }
                return;
            }
            this.a.requestWriteCharacteristic(this.b, this.c, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(rc1 rc1Var, zc1 zc1Var) {
        try {
            String strD = rc1Var.d();
            if (tb1.d().b) {
                String str = tb1.i;
                String str2 = "request.Write.address -> " + this.b + " value => " + strD;
            }
            if (strD.startsWith("LVS:")) {
                String[] strArrSplit = (strD.contains(";") ? strD.replace(";", "") : "").split(SignatureImpl.INNER_SEP)[1].split(",");
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < strArrSplit.length; i++) {
                    if (strArrSplit[i] != null && strArrSplit[i].length() > 0) {
                        linkedList.add(Integer.valueOf(strArrSplit[i]));
                    }
                }
                this.c.setValue(jf3.a(linkedList));
            } else if (strD.startsWith("aa")) {
                this.c.setValue(qd0.g(strD));
            } else {
                this.c.setValue(strD.getBytes());
            }
            if (!rc1Var.h()) {
                IBle iBle = this.a;
                if (iBle != null) {
                    ((IBleRequestHandler) iBle).writeCharacteristic(this.b, this.c, strD);
                    return;
                }
                return;
            }
            IBle iBle2 = this.a;
            if (iBle2 != null) {
                boolean zWriteCharacteristic = ((IBleRequestHandler) iBle2).writeCharacteristic(this.b, this.c, strD);
                xe3.a("SendCommandToWrite", "SpecialCommand requestWriteSpecialCommand: " + this.b + " \n == 发送的指令：" + rc1Var.d() + " \n success=" + zWriteCharacteristic);
                if (zc1Var == null || zWriteCharacteristic) {
                    return;
                }
                zc1Var.a(rc1Var);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
