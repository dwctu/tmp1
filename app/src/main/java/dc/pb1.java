package dc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import com.xtremeprog.sdk.ble.BleService;

/* compiled from: DxBtCharacteristic.java */
/* loaded from: classes3.dex */
public class pb1 {
    public tb1 a;
    public final BroadcastReceiver b = new a();
    public b c;

    /* compiled from: DxBtCharacteristic.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string;
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            try {
                string = extras.getString(BleService.EXTRA_ADDR);
            } catch (Exception e) {
                e.printStackTrace();
                ye3.d("S0003", "查找 DxBtCharacteristic request_failed 问题-->" + e.getMessage());
                string = "";
            }
            if (string != null && pb1.this.a.d.l(string)) {
                String action = intent.getAction();
                if (BleService.BLE_CHARACTERISTIC_NOTIFICATION.equals(action)) {
                    String string2 = extras.getString(BleService.EXTRA_UUID);
                    boolean z = extras.getBoolean(BleService.EXTRA_VALUE);
                    if (pb1.this.c != null) {
                        pb1.this.c.e(string, string2, z);
                    }
                    if (pb1.this.a.b) {
                        String str = tb1.i;
                        String str2 = "characteristic.notification-> address:" + string + " started:" + z;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_CHARACTERISTIC_INDICATION.equals(action)) {
                    int i = extras.getInt("STATUS");
                    if (pb1.this.c != null) {
                        pb1.this.c.f(string, i);
                    }
                    if (pb1.this.a.b) {
                        String str3 = tb1.i;
                        String str4 = "characteristic.indication-> address:" + string + " status:" + i;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_CHARACTERISTIC_READ.equals(action)) {
                    String str5 = new String(extras.getByteArray(BleService.EXTRA_VALUE));
                    if (pb1.this.c != null) {
                        pb1.this.c.d(string, str5);
                    }
                    if (pb1.this.a.b) {
                        String str6 = tb1.i;
                        String str7 = "characteristic.read-> address:" + string + " readValue:" + str5;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_CHARACTERISTIC_WRITE.equals(action)) {
                    int i2 = extras.getInt("STATUS");
                    if (pb1.this.c != null) {
                        pb1.this.c.b(string, i2);
                    }
                    if (pb1.this.a.b) {
                        String str8 = tb1.i;
                        String str9 = "characteristic.write.success-> address:" + string + " status:" + i2;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_REQUEST_FAILED.equals(action)) {
                    BleRequest.RequestType requestType = (BleRequest.RequestType) extras.get(BleService.EXTRA_REQUEST);
                    int i3 = extras.getInt(BleService.EXTRA_REASON);
                    if (pb1.this.c != null) {
                        pb1.this.c.c(string, requestType, i3);
                    }
                    if (pb1.this.a.b) {
                        String str10 = tb1.i;
                        String str11 = "characteristic.request.failed-> address:" + string + " type:" + requestType + " ordinal:" + i3;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_CHARACTERISTIC_CHANGED.equals(action)) {
                    byte[] byteArray = extras.getByteArray(BleService.EXTRA_VALUE);
                    String str12 = new String(byteArray);
                    if (pb1.this.c != null) {
                        String[] strArrSplit = str12.split(";");
                        if (strArrSplit == null || strArrSplit.length <= 1) {
                            pb1.this.c.a(string, str12, byteArray);
                        } else {
                            for (String str13 : strArrSplit) {
                                pb1.this.c.a(string, str13 + ";", byteArray);
                            }
                        }
                    }
                    if (pb1.this.a.b) {
                        String str14 = tb1.i;
                        String str15 = "characteristic.changed-> address:" + string + " changeValue:" + str12;
                        return;
                    }
                    return;
                }
                if (BleService.BLE_ONREAD_RSSI.equals(action)) {
                    int i4 = extras.getInt(BleService.EXTRA_VALUE);
                    if (pb1.this.a.b) {
                        String str16 = tb1.i;
                        String str17 = "rssi.read-> address:" + string + " rssi:" + i4;
                    }
                    if (pb1.this.c != null) {
                        pb1.this.c.g(string, i4);
                        return;
                    }
                    return;
                }
                if (BleService.BLE_CONNECT_STATE_VALUE.equals(action)) {
                    int i5 = extras.getInt(BleService.EXTRA_VALUE);
                    int i6 = extras.getInt(BleService.EXTRA_SOURCE);
                    if (pb1.this.a.b) {
                        String str18 = tb1.i;
                        String str19 = "connect.status-> address:" + string + " status:" + i5 + " newState:" + i6;
                    }
                    if (pb1.this.c != null) {
                        pb1.this.c.onConnectionStateChange(string, i5, i6);
                    }
                }
            }
        }
    }

    /* compiled from: DxBtCharacteristic.java */
    public interface b {
        void a(String str, String str2, byte[] bArr);

        void b(String str, int i);

        void c(String str, BleRequest.RequestType requestType, int i);

        void d(String str, String str2);

        void e(String str, String str2, boolean z);

        void f(String str, int i);

        void g(String str, int i);

        void onConnectionStateChange(String str, int i, int i2);
    }

    public pb1(tb1 tb1Var) {
        this.a = tb1Var;
    }

    public void b() {
        LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.b, BleService.getIntentCharacteristicFilter());
    }

    public void c(b bVar) {
        this.c = bVar;
    }
}
