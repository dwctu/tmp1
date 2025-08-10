package com.broadcom.bt.service.ftp;

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
import com.broadcom.bt.service.ftp.IBluetoothFTP;
import com.broadcom.bt.service.ftp.IBluetoothFTPCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class BluetoothFTP implements BluetoothProfile {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.broadcom.ftpserver.CONNECTION_STATE_CHANGED";
    public static final String ACTION_ON_FTS_ACCESS_REQUEST = "android.broadcom.ftpserver.ON_FTS_REQUEST_REQUEST";
    public static final String ACTION_ON_FTS_CLOSED = "android.broadcom.ftpserver.ON_FTPS_CLOSED";
    public static final String ACTION_ON_FTS_DEL_COMPLETE = "android.broadcom.ftpserver.ON_FTS_DEL_COMPLETE";
    public static final String ACTION_ON_FTS_GET_COMPLETE = "android.broadcom.ftpserver.ON_FTS_GET_COMPLETE";
    public static final String ACTION_ON_FTS_OPENED = "android.broadcom.ftpserver.ON_FTS_OPENED";
    public static final String ACTION_ON_FTS_PUT_COMPLETE = "android.broadcom.ftpserver.ON_FTPS_PUT_COMPLETE";
    public static final String ACTION_ON_FTS_XFR_PROGRESS = "android.broadcom.ftpserver.ON_FTS_XFR_PROGRESS";
    public static final String ACTION_PREFIX = "android.broadcom.ftpserver.";
    public static final int ACTION_PREFIX_LENGTH = 27;
    public static final String BLUETOOTH_ADMIN_PERM = "android.permission.BLUETOOTH_ADMIN";
    public static final String BLUETOOTH_PERM = "android.permission.BLUETOOTH";
    private static final boolean DBG = true;
    public static final String EXTRA_BYTES_TRANSFERRED = "BYTES_TRANSFERRED";
    public static final String EXTRA_FILEPATH = "FILEPATH";
    public static final String EXTRA_OPERATION = "android.broadcom.ftpserver.extra.OPERATION";
    public static final String EXTRA_RMT_DEV_ADDR = "android.broadcom.ftpserver.extra.RMT_DEV_ADDR";
    public static final String EXTRA_RMT_DEV_NAME = "android.broadcom.ftpserver.extra.RMT_DEV_NAME";
    public static final String EXTRA_STATUS = "STATUS";
    public static final String EXTRA_TOTAL_BYTES = "TOTAL_BYTES";
    public static final byte FTPS_OPER_CHG_DIR = 5;
    public static final byte FTPS_OPER_COPY = 7;
    public static final byte FTPS_OPER_DEL_DIR = 4;
    public static final byte FTPS_OPER_DEL_FILE = 3;
    public static final byte FTPS_OPER_GET = 2;
    public static final byte FTPS_OPER_MK_DIR = 6;
    public static final byte FTPS_OPER_MOVE = 8;
    public static final byte FTPS_OPER_PUT = 1;
    public static final byte FTPS_OPER_SET_PERM = 9;
    public static final int FTPS_STATUS_FAIL = 1;
    public static final int FTPS_STATUS_OK = 0;
    public static final String FTP_EXTRA_PREFIX = "android.broadcom.ftpserver.extra.";
    public static final int FTP_SERVER = 7;
    public static final String SERVICE_NAME = "bluetooth_ftp";
    private static final String TAG = "BluetoothFTP";
    private BluetoothAdapter mAdapter;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback;
    private final IBluetoothFTPCallback mCallback;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.broadcom.bt.service.ftp.BluetoothFTP.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BluetoothFTP.this.mService = IBluetoothFTP.Stub.asInterface(iBinder);
            if (BluetoothFTP.this.mServiceListener != null) {
                BluetoothFTP.this.mServiceListener.onServiceConnected(7, BluetoothFTP.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BluetoothFTP.this.mService = null;
            if (BluetoothFTP.this.mServiceListener != null) {
                BluetoothFTP.this.mServiceListener.onServiceDisconnected(7);
            }
        }
    };
    private Context mContext;
    private IBluetoothFTP mService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private IBluetoothManager mgr;

    public BluetoothFTP(Context context, BluetoothProfile.ServiceListener serviceListener) {
        IBluetoothStateChangeCallback.Stub stub = new IBluetoothStateChangeCallback.Stub() { // from class: com.broadcom.bt.service.ftp.BluetoothFTP.2
            public void onBluetoothStateChange(boolean z) {
                String str = "onBluetoothStateChange: up=" + z;
                if (z) {
                    synchronized (BluetoothFTP.this.mConnection) {
                        try {
                            if (BluetoothFTP.this.mService == null) {
                                BluetoothFTP.this.mContext.bindService(new Intent(IBluetoothFTP.class.getName()), BluetoothFTP.this.mConnection, 0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                synchronized (BluetoothFTP.this.mConnection) {
                    try {
                        BluetoothFTP.this.mService = null;
                        BluetoothFTP.this.mContext.unbindService(BluetoothFTP.this.mConnection);
                    } catch (Exception unused2) {
                    }
                }
            }
        };
        this.mBluetoothStateChangeCallback = stub;
        this.mCallback = new IBluetoothFTPCallback.Stub() { // from class: com.broadcom.bt.service.ftp.BluetoothFTP.3
            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerAccessRequested(String str, int i, String str2, byte b, String str3) throws RemoteException {
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerAuthen(String str, byte b, boolean z) throws RemoteException {
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerClosed() throws RemoteException {
                BluetoothFTP.this.mContext.sendOrderedBroadcast(new Intent(BluetoothFTP.ACTION_ON_FTS_CLOSED), BluetoothFTP.BLUETOOTH_PERM);
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerDelCompleted(String str, byte b) throws RemoteException {
                Intent intent = new Intent(BluetoothFTP.ACTION_ON_FTS_DEL_COMPLETE);
                intent.putExtra(BluetoothFTP.EXTRA_FILEPATH, str);
                intent.putExtra("STATUS", b);
                BluetoothFTP.this.mContext.sendOrderedBroadcast(intent, BluetoothFTP.BLUETOOTH_PERM);
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerEnabled() throws RemoteException {
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerFileTransferInProgress(int i, int i2) throws RemoteException {
                Intent intent = new Intent(BluetoothFTP.ACTION_ON_FTS_XFR_PROGRESS);
                intent.putExtra(BluetoothFTP.EXTRA_TOTAL_BYTES, i);
                intent.putExtra(BluetoothFTP.EXTRA_BYTES_TRANSFERRED, i2);
                BluetoothFTP.this.mContext.sendOrderedBroadcast(intent, BluetoothFTP.BLUETOOTH_PERM);
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerGetCompleted(String str, byte b) throws RemoteException {
                Intent intent = new Intent(BluetoothFTP.ACTION_ON_FTS_PUT_COMPLETE);
                intent.putExtra(BluetoothFTP.EXTRA_FILEPATH, str);
                intent.putExtra("STATUS", b);
                BluetoothFTP.this.mContext.sendOrderedBroadcast(intent, BluetoothFTP.BLUETOOTH_PERM);
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerOpened(String str) throws RemoteException {
                Intent intent = new Intent(BluetoothFTP.ACTION_ON_FTS_OPENED);
                intent.putExtra(BluetoothFTP.EXTRA_RMT_DEV_ADDR, str);
                BluetoothFTP.this.mContext.sendOrderedBroadcast(intent, BluetoothFTP.BLUETOOTH_PERM);
            }

            @Override // com.broadcom.bt.service.ftp.IBluetoothFTPCallback
            public void onFtpServerPutCompleted(String str, byte b) throws RemoteException {
                Intent intent = new Intent(BluetoothFTP.ACTION_ON_FTS_PUT_COMPLETE);
                intent.putExtra(BluetoothFTP.EXTRA_FILEPATH, str);
                intent.putExtra("STATUS", b);
                BluetoothFTP.this.mContext.sendOrderedBroadcast(intent, BluetoothFTP.BLUETOOTH_PERM);
            }
        };
        this.mContext = context;
        this.mServiceListener = serviceListener;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        IBluetoothManager iBluetoothManagerAsInterface = IBluetoothManager.Stub.asInterface(ServiceManager.checkService("bluetooth_manager"));
        this.mgr = iBluetoothManagerAsInterface;
        if (iBluetoothManagerAsInterface != null) {
            try {
                iBluetoothManagerAsInterface.registerStateChangeCallback(stub);
            } catch (RemoteException unused) {
            }
        }
        context.bindService(new Intent(IBluetoothFTP.class.getName()), this.mConnection, 0);
    }

    public static boolean getProfileProxy(Context context, BluetoothProfile.ServiceListener serviceListener) {
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            return false;
        }
        new BluetoothFTP(context, serviceListener);
        return true;
    }

    private boolean isDisabled() {
        return this.mAdapter.getState() == 10;
    }

    private boolean isEnabled() {
        return this.mAdapter.getState() == 12;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress());
    }

    private static void log(String str) {
    }

    public synchronized void close() {
        IBluetoothFTPCallback iBluetoothFTPCallback;
        IBluetoothManager iBluetoothManager = this.mgr;
        if (iBluetoothManager != null) {
            try {
                iBluetoothManager.registerStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (RemoteException unused) {
            }
        }
        synchronized (this.mConnection) {
            IBluetoothFTP iBluetoothFTP = this.mService;
            if (iBluetoothFTP != null && (iBluetoothFTPCallback = this.mCallback) != null) {
                try {
                    iBluetoothFTP.unregisterCallback(iBluetoothFTPCallback);
                    this.mService = null;
                    this.mContext.unbindService(this.mConnection);
                } catch (Exception unused2) {
                }
            }
        }
        this.mServiceListener = null;
    }

    public void ftpServerAccessRsp(byte b, boolean z, String str) {
        try {
            String str2 = "ftpServerAccessRsp(" + ((int) b) + ", " + z + "," + str + ")";
            this.mService.ftpServerAccessRsp(b, z, str);
        } catch (Throwable unused) {
        }
    }

    public void ftpServerAuthenRsp(String str, String str2) {
        try {
            this.mService.ftpServerAuthenRsp(str, str2);
        } catch (Throwable unused) {
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        log("getConnectedDevices()");
        if (this.mService == null || !isEnabled()) {
            IBluetoothFTP iBluetoothFTP = this.mService;
            return new ArrayList();
        }
        try {
            return this.mService.getConnectedDevices();
        } catch (RemoteException unused) {
            String str = "Stack:" + Log.getStackTraceString(new Throwable());
            return new ArrayList();
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        log("getState(" + bluetoothDevice + ")");
        if (this.mService == null || !isEnabled() || !isValidDevice(bluetoothDevice)) {
            IBluetoothFTP iBluetoothFTP = this.mService;
            return 0;
        }
        try {
            return this.mService.getConnectionState(bluetoothDevice);
        } catch (RemoteException unused) {
            String str = "Stack:" + Log.getStackTraceString(new Throwable());
            return 0;
        }
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        log("getDevicesMatchingStates()");
        if (this.mService == null || !isEnabled()) {
            IBluetoothFTP iBluetoothFTP = this.mService;
            return new ArrayList();
        }
        try {
            return this.mService.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException unused) {
            String str = "Stack:" + Log.getStackTraceString(new Throwable());
            return new ArrayList();
        }
    }

    public boolean init(IBinder iBinder) {
        try {
            IBluetoothFTP iBluetoothFTPAsInterface = IBluetoothFTP.Stub.asInterface(iBinder);
            this.mService = iBluetoothFTPAsInterface;
            IBluetoothFTPCallback iBluetoothFTPCallback = this.mCallback;
            if (iBluetoothFTPCallback == null) {
                return true;
            }
            iBluetoothFTPAsInterface.registerCallback(iBluetoothFTPCallback);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean requiresAccessProcessing() {
        return true;
    }

    public void setAccess(int i, boolean z, Object obj) {
        ftpServerAccessRsp((byte) i, z, (String) obj);
    }
}
