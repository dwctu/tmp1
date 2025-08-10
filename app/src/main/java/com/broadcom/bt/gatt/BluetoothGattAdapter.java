package com.broadcom.bt.gatt;

import android.bluetooth.BluetoothProfile;
import android.content.Context;

/* loaded from: classes.dex */
public class BluetoothGattAdapter {
    public static final int GATT = 7;
    public static final int GATT_SERVER = 8;

    public static void closeProfileProxy(int i, BluetoothProfile bluetoothProfile) {
        if (bluetoothProfile == null) {
            return;
        }
        if (i == 7) {
            ((BluetoothGatt) bluetoothProfile).close();
        } else {
            if (i != 8) {
                return;
            }
            ((BluetoothGattServer) bluetoothProfile).close();
        }
    }

    public static boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener serviceListener, int i) {
        if (context != null && serviceListener != null) {
            if (i == 7) {
                new BluetoothGatt(context, serviceListener);
                return true;
            }
            if (i == 8) {
                new BluetoothGattServer(context, serviceListener);
                return true;
            }
        }
        return false;
    }
}
