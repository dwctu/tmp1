package com.broadcom.bt.service.sap;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.IBluetoothManager;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.broadcom.bt.service.sap.IBluetoothSap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BluetoothSap implements BluetoothProfile {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.broadcom.sap.CONNECTION_STATE_CHANGED";
    private static final boolean DBG = true;
    public static final int SAP = 101;
    public static final int SAP_DISCONNECT_FAILED_NOT_CONNECTED = 1000;
    private static final String TAG = "Bluetoothsap";
    private Context mContext;
    private IBluetoothSap mSapService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private IBluetoothManager mgr;
    private IBluetoothStateChangeCallback mStateChangeCallback = new IBluetoothStateChangeCallback.Stub() { // from class: com.broadcom.bt.service.sap.BluetoothSap.1
        public void onBluetoothStateChange(boolean z) throws RemoteException {
            if (z) {
                BluetoothSap.this.mContext.bindService(new Intent(IBluetoothSap.class.getName()), BluetoothSap.this.mConnection, 0);
                return;
            }
            synchronized (BluetoothSap.this.mConnection) {
                try {
                    BluetoothSap.this.mSapService = null;
                    BluetoothSap.this.mContext.unbindService(BluetoothSap.this.mConnection);
                } catch (Exception unused) {
                }
            }
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.broadcom.bt.service.sap.BluetoothSap.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BluetoothSap.this.mSapService = IBluetoothSap.Stub.asInterface(iBinder);
            if (BluetoothSap.this.mServiceListener != null) {
                BluetoothSap.this.mServiceListener.onServiceConnected(101, BluetoothSap.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BluetoothSap.this.mSapService = null;
            if (BluetoothSap.this.mServiceListener != null) {
                BluetoothSap.this.mServiceListener.onServiceDisconnected(101);
            }
        }
    };
    private BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();

    public BluetoothSap(Context context, BluetoothProfile.ServiceListener serviceListener) {
        this.mContext = context;
        this.mServiceListener = serviceListener;
        IBluetoothManager iBluetoothManagerAsInterface = IBluetoothManager.Stub.asInterface(ServiceManager.checkService("bluetooth_manager"));
        this.mgr = iBluetoothManagerAsInterface;
        if (iBluetoothManagerAsInterface != null) {
            try {
                iBluetoothManagerAsInterface.registerStateChangeCallback(this.mStateChangeCallback);
            } catch (RemoteException unused) {
            }
        }
        context.bindService(new Intent(IBluetoothSap.class.getName()), this.mConnection, 0);
    }

    private boolean isEnabled() {
        return this.mAdapter.getState() == 12;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress());
    }

    public void close() {
        ServiceConnection serviceConnection = this.mConnection;
        if (serviceConnection != null) {
            this.mContext.unbindService(serviceConnection);
            this.mConnection = null;
        }
        this.mServiceListener = null;
        IBluetoothManager iBluetoothManager = this.mgr;
        if (iBluetoothManager != null) {
            try {
                iBluetoothManager.unregisterStateChangeCallback(this.mStateChangeCallback);
            } catch (RemoteException unused) {
            }
        }
    }

    public boolean disconnect(BluetoothDevice bluetoothDevice) {
        String str = "disconnect(" + bluetoothDevice + ")";
        if (this.mSapService == null || !isEnabled() || !isValidDevice(bluetoothDevice)) {
            IBluetoothSap iBluetoothSap = this.mSapService;
            return false;
        }
        try {
            return this.mSapService.disconnect(bluetoothDevice);
        } catch (RemoteException unused) {
            String str2 = "Stack:" + Log.getStackTraceString(new Throwable());
            return false;
        }
    }

    public void finalize() {
        close();
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        if (this.mSapService == null || !isEnabled()) {
            IBluetoothSap iBluetoothSap = this.mSapService;
            return new ArrayList();
        }
        try {
            return this.mSapService.getConnectedDevices();
        } catch (RemoteException unused) {
            String str = "Stack:" + Log.getStackTraceString(new Throwable());
            return new ArrayList();
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        String str = "getConnectionState(" + bluetoothDevice + ")";
        if (this.mSapService == null || !isEnabled() || !isValidDevice(bluetoothDevice)) {
            IBluetoothSap iBluetoothSap = this.mSapService;
            return 0;
        }
        try {
            return this.mSapService.getConnectionState(bluetoothDevice);
        } catch (RemoteException unused) {
            String str2 = "Stack:" + Log.getStackTraceString(new Throwable());
            return 0;
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        if (this.mSapService == null || !isEnabled()) {
            IBluetoothSap iBluetoothSap = this.mSapService;
            return new ArrayList();
        }
        try {
            return this.mSapService.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException unused) {
            String str = "Stack:" + Log.getStackTraceString(new Throwable());
            return new ArrayList();
        }
    }
}
