package dc;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.wear.util.WearUtils;

/* compiled from: ClsUtils.java */
/* loaded from: classes4.dex */
public class ud3 {
    public static boolean a(String str) {
        BluetoothDevice remoteDevice = ((BluetoothManager) WearUtils.x.getSystemService("bluetooth")).getAdapter().getRemoteDevice(str);
        return remoteDevice != null && remoteDevice.getBondState() == 12;
    }

    public static boolean b(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean c(String str, String str2) {
        BluetoothDevice remoteDevice = ((BluetoothManager) WearUtils.x.getSystemService("bluetooth")).getAdapter().getRemoteDevice(str2);
        xe3.a("removeBond", "removeBond   uuid = " + str + "   address = " + str2);
        if (remoteDevice == null || remoteDevice.getBondState() != 12) {
            return false;
        }
        try {
            boolean zB = b(BluetoothDevice.class, remoteDevice);
            xe3.a("removeBond", zB ? "解绑失败" : "解绑成功");
            return zB;
        } catch (Exception e) {
            e.printStackTrace();
            xe3.a("removeBond", "解绑失败");
            return false;
        }
    }
}
