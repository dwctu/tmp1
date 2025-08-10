package com.broadcom.bt.map;

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
import com.broadcom.bt.map.IBluetoothMap;
import java.util.List;

/* loaded from: classes.dex */
public class BluetoothMap implements BluetoothProfile {
    public static final String ACTION_DISCONNECT = "";
    public static final String ACTION_DS_DISCOVER = "com.broadcom.bt.service.map.DS_DISCOVER";
    public static final String ACTION_PREFIX = "com.broadcom.bt.service.map.";
    public static final int ACTION_PREFIX_LENGTH = 28;
    public static final String ACTION_START = "broadcom.bluetooth.map.START";
    public static final String ACTION_STOP = "broadcom.bluetooth.map.STOP";
    private static final int BIND_STATE_BINDING = 1;
    private static final int BIND_STATE_BOUND = 2;
    private static final int BIND_STATE_UNBINDING = 3;
    private static final int BIND_STATE_UNBOUND = 0;
    public static final boolean DBG = true;
    public static final String EXTRA_BDA = "BDA";
    public static final String EXTRA_BD_ADDR = "";
    public static final int MAP_LENGTH_ADJUSTER = 22;
    public static final byte MSG_STATUS_TYPE_DELETED = 1;
    public static final byte MSG_STATUS_TYPE_READ = 0;
    public static final byte NOTIFICATION_TYPE_DELIVERY_FAILURE = 3;
    public static final byte NOTIFICATION_TYPE_DELIVERY_SUCCESS = 1;
    public static final byte NOTIFICATION_TYPE_MESSAGE_DELETED = 7;
    public static final byte NOTIFICATION_TYPE_MESSAGE_SHIFT = 8;
    public static final byte NOTIFICATION_TYPE_NEW_MESSAGE = 0;
    public static final byte NOTIFICATION_TYPE_SENDING_FAILURE = 4;
    public static final byte NOTIFICATION_TYPE_SENDING_SUCCESS = 2;
    public static final String PROVIDER_PERMISSION = "android.Manifest.permission.BLUETOOTH";
    private static final int SERVICE_ID = 1000;
    public static final byte STATE_MSE_STARTED = 2;
    public static final byte STATE_MSE_STOPPED = 1;
    public static final int STATUS_MSE_CANNOT_START = 1;
    public static final int STATUS_MSE_RETURN_CODE_SUCCESS = 0;
    private static final String TAG = "BtMap.BluetoothMap";
    private int mBindingState;
    private Context mContext;
    private boolean mIsClosed;
    private IBluetoothManager mManagerService;
    private boolean mPendingClose;
    private IBluetoothMap mService;
    private BluetoothProfile.ServiceListener mServiceListener;
    private ServiceConnection mConnection = new MapServiceConnection();
    private IBluetoothStateChangeCallback mStateChangeCallback = new IBluetoothStateChangeCallback.Stub() { // from class: com.broadcom.bt.map.BluetoothMap.1
        public void onBluetoothStateChange(boolean z) throws RemoteException {
            if (!z) {
                BluetoothMap.this.debugPrintStackTrace();
                synchronized (BluetoothMap.this) {
                    try {
                    } catch (Throwable unused) {
                        BluetoothMap.this.mBindingState = 2;
                    }
                    if (BluetoothMap.this.mBindingState == 0) {
                        return;
                    }
                    if (BluetoothMap.this.mBindingState == 1) {
                        BluetoothMap.this.mPendingClose = true;
                        return;
                    }
                    BluetoothMap.this.mBindingState = 0;
                    BluetoothMap.this.mContext.unbindService(BluetoothMap.this.mConnection);
                    BluetoothMap.this.mService = null;
                    return;
                }
            }
            synchronized (BluetoothMap.this) {
                if (BluetoothMap.this.mBindingState == 0) {
                    BluetoothMap.this.mBindingState = 1;
                    String str = "mConnection=" + BluetoothMap.this.mConnection;
                    try {
                        if (!BluetoothMap.this.mContext.bindService(new Intent(IBluetoothMap.class.getName()), BluetoothMap.this.mConnection, 0)) {
                            BluetoothMap.this.mBindingState = 0;
                        }
                    } catch (Throwable unused2) {
                        String str2 = "mConnection=" + BluetoothMap.this.mConnection;
                        String str3 = "mContext=" + BluetoothMap.this.mContext;
                    }
                }
            }
        }
    };
    private BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();

    public class MapServiceConnection implements ServiceConnection {
        private MapServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z;
            synchronized (BluetoothMap.this) {
                BluetoothMap.this.mService = IBluetoothMap.Stub.asInterface(iBinder);
                BluetoothMap.this.mBindingState = 2;
                z = BluetoothMap.this.mPendingClose;
                BluetoothMap.this.mPendingClose = false;
            }
            if (BluetoothMap.this.mServiceListener != null) {
                BluetoothMap.this.mServiceListener.onServiceConnected(1000, BluetoothMap.this);
            }
            if (z) {
                BluetoothMap.this.close();
                BluetoothMap.this.mPendingClose = false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (BluetoothMap.this) {
                BluetoothMap.this.mService = null;
                BluetoothMap.this.mBindingState = 0;
                if (BluetoothMap.this.mServiceListener != null) {
                    BluetoothMap.this.mServiceListener.onServiceDisconnected(1000);
                }
            }
        }
    }

    public BluetoothMap(Context context, BluetoothProfile.ServiceListener serviceListener) throws UnsupportedOperationException, RemoteException {
        this.mContext = context;
        this.mServiceListener = serviceListener;
        IBinder service = ServiceManager.getService("bluetooth_manager");
        if (service == null) {
            throw new UnsupportedOperationException("Bluetooth is not available");
        }
        IBluetoothManager iBluetoothManagerAsInterface = IBluetoothManager.Stub.asInterface(service);
        this.mManagerService = iBluetoothManagerAsInterface;
        try {
            iBluetoothManagerAsInterface.registerStateChangeCallback(this.mStateChangeCallback);
            synchronized (this) {
                if (isEnabled() && this.mBindingState == 0) {
                    this.mBindingState = 1;
                    if (!context.bindService(new Intent(IBluetoothMap.class.getName()), this.mConnection, 0)) {
                        this.mBindingState = 0;
                    }
                }
            }
        } catch (RemoteException unused) {
            throw new RemoteException("Bluetooth is not available");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debugPrintStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (int i = 3; i < 5 && i < stackTrace.length; i++) {
                getDebugStackTrace(stackTrace[i]);
            }
        }
    }

    public static String getDebugStackTrace(StackTraceElement stackTraceElement) {
        return "" + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(): [" + stackTraceElement.getLineNumber() + ", " + Thread.currentThread().getName() + "]";
    }

    public static BluetoothMap getProxy(Context context, BluetoothProfile.ServiceListener serviceListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("getProxy() ctx = ");
        sb.append(context == null ? "null" : context);
        sb.append("l =");
        sb.append(serviceListener != null ? serviceListener : "null");
        sb.toString();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (int i = 3; i < 5 && i < stackTrace.length; i++) {
                getDebugStackTrace(stackTrace[i]);
            }
        }
        try {
            return new BluetoothMap(context, serviceListener);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean isEnabled() {
        return this.mAdapter.getState() == 12;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress());
    }

    public synchronized void close() {
        debugPrintStackTrace();
        if (this.mIsClosed) {
            return;
        }
        int i = this.mBindingState;
        if (i != 0 && i != 1) {
            try {
                this.mBindingState = 3;
                this.mContext.unbindService(this.mConnection);
                this.mService = null;
                this.mConnection = null;
            } catch (Throwable unused) {
            }
            this.mBindingState = 0;
        }
        this.mServiceListener = null;
        try {
            this.mManagerService.unregisterStateChangeCallback(this.mStateChangeCallback);
        } catch (RemoteException unused2) {
        }
        this.mIsClosed = true;
    }

    public void disconnect(String str, String str2) {
    }

    public void finalize() {
        close();
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getConnectedDevices() {
        return null;
    }

    @Override // android.bluetooth.BluetoothProfile
    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        return 0;
    }

    @Override // android.bluetooth.BluetoothProfile
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        return null;
    }

    public void registerDatasource(String str, String str2, byte b, String str3, String str4, boolean z, boolean z2, String[] strArr, IBluetoothMapDatasourceCallback iBluetoothMapDatasourceCallback) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.registerDatasource(str, str2, b, str3, str4, z, z2, strArr, iBluetoothMapDatasourceCallback);
            } catch (Throwable unused) {
            }
        }
    }

    public void returnMessage(RequestId requestId, String str, String str2) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.returnMessage(requestId, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public void sendNotification(String str, String str2, String str3, byte b, byte b2, String str4, String str5) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.sendNotification(str, str2, str3, b, b2, str4, str5);
            } catch (Throwable unused) {
            }
        }
    }

    public void setFolderListing(RequestId requestId, String str, List<FolderInfo> list) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.setFolderListing(requestId, str, list);
            } catch (Throwable unused) {
            }
        }
    }

    public void setMessageDeletedResult(RequestId requestId, String str, boolean z, boolean z2, String str2) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.setMessageDeletedResult(requestId, str, z, z2, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public void setMessageListing(RequestId requestId, String str, List<MessageInfo> list, String str2) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.setMessageListing(requestId, str, list, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public void setMessageListingCount(RequestId requestId, String str, int i, String str2, boolean z) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.setMessageListingCount(requestId, str, i, str2, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void setPushMessageResult(RequestId requestId, String str, String str2) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.setPushMessageResult(requestId, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public void unregisterDatasource(String str, String str2, boolean z) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.unregisterDatasource(str, str2, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void updateMessageId(String str, String str2, String str3, String str4) {
        IBluetoothMap iBluetoothMap = this.mService;
        if (iBluetoothMap != null) {
            try {
                iBluetoothMap.updateMessageId(str, str2, str3, str4);
            } catch (Throwable unused) {
            }
        }
    }
}
