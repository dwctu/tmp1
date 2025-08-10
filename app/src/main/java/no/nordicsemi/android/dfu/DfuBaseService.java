package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;
import org.jivesoftware.smack.sm.packet.StreamManagement;

@SuppressLint({"MissingPermission"})
/* loaded from: classes5.dex */
public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    public static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_PROGRESS_LOST = 4111;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DATA_OBJECT_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_DATA_OBJECT_DELAY";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    public static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SCAN_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_DELAY";
    public static final String EXTRA_SCAN_TIMEOUT = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_TIMEOUT";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    public static final int STATE_CLOSED = -5;
    public static final int STATE_CONNECTED = -2;
    public static final int STATE_CONNECTED_AND_READY = -3;
    public static final int STATE_CONNECTING = -1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    private boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver;
    private final BroadcastReceiver mBondStateBroadcastReceiver;
    public int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver;
    private String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver;
    private DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    private int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback;
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress;
    private final Object mLock;
    public DfuProgressInfo mProgressInfo;

    public DfuBaseService() {
        super(TAG);
        this.mLock = new Object();
        this.mLastProgress = -1;
        this.mDfuActionReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
                DfuBaseService.this.logi("User action received: " + intExtra);
                if (intExtra == 0) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.pause();
                        return;
                    }
                    return;
                }
                if (intExtra == 1) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.resume();
                        return;
                    }
                    return;
                }
                if (intExtra != 2) {
                    return;
                }
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                DfuBaseService.this.mAborted = true;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        };
        this.mBluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
                DfuBaseService.this.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
                if (intExtra2 == 12) {
                    if (intExtra == 13 || intExtra == 10) {
                        DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                        synchronized (DfuBaseService.this.mLock) {
                            DfuBaseService.this.mLock.notifyAll();
                        }
                    }
                }
            }
        };
        this.mBondStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress) || (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) == 11 || DfuBaseService.this.mDfuServiceImpl == null) {
                    return;
                }
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        };
        this.mConnectionStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                    return;
                }
                String action = intent.getAction();
                DfuBaseService.this.logi("Action received: " + action);
                DfuBaseService.this.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
            }
        };
        this.mGattCallback = new BluetoothGattCallback() { // from class: no.nordicsemi.android.dfu.DfuBaseService.5
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                if (i != 0) {
                    if (i == 8 || i == 19) {
                        DfuBaseService.this.logw("Target device disconnected with status: " + i);
                    } else {
                        DfuBaseService.this.loge("Connection state change error: " + i + " newState: " + i2);
                    }
                    DfuBaseService.this.mError = i | 32768;
                    if (i2 == 0) {
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                } else if (i2 == 2) {
                    DfuBaseService.this.logi("Connected to GATT server");
                    DfuBaseService.this.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                    DfuBaseService.this.mConnectionState = -2;
                    if (bluetoothGatt.getDevice().getBondState() == 12) {
                        DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                        DfuBaseService.this.waitFor(1600L);
                    }
                    DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                    DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                    boolean zDiscoverServices = bluetoothGatt.discoverServices();
                    DfuBaseService dfuBaseService2 = DfuBaseService.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to start service discovery... ");
                    sb.append(zDiscoverServices ? "succeed" : StreamManagement.Failed.ELEMENT);
                    dfuBaseService2.logi(sb.toString());
                    if (zDiscoverServices) {
                        return;
                    } else {
                        DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                    }
                } else if (i2 == 0) {
                    DfuBaseService.this.logi("Disconnected from GATT server");
                    DfuBaseService dfuBaseService3 = DfuBaseService.this;
                    dfuBaseService3.mConnectionState = 0;
                    if (dfuBaseService3.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, i, i2);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, i, i2, i3);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                if (i == 0) {
                    DfuBaseService.this.logi("Services discovered");
                    DfuBaseService.this.mConnectionState = -3;
                } else {
                    DfuBaseService.this.loge("Service discovery error: " + i);
                    DfuBaseService.this.mError = i | 16384;
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        };
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(String str) {
    }

    private void loge(String str, Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logi(String str) {
        boolean z = DEBUG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logw(String str) {
        boolean z = DEBUG;
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    private InputStream openInputStream(@NonNull String str, String str2, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        return MIME_TYPE_ZIP.equals(str2) ? new ArchiveInputStream(fileInputStream, i, i2) : str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, i) : fileInputStream;
    }

    private void report(int i) {
        sendErrorBroadcast(i);
        if (this.mDisableNotification) {
            return;
        }
        String str = this.mDeviceAddress;
        String string = this.mDeviceName;
        if (string == null) {
            string = getString(R.string.dfu_unknown_name);
        }
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(android.R.drawable.stat_sys_upload).setOnlyAlertOnce(true).setColor(SupportMenu.CATEGORY_MASK).setOngoing(false).setContentTitle(getString(R.string.dfu_status_error)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_error_msg)).setAutoCancel(true);
        Intent intent = new Intent(this, getNotificationTarget());
        intent.addFlags(268435456);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
        intent.putExtra(EXTRA_DEVICE_NAME, string);
        intent.putExtra(EXTRA_PROGRESS, i);
        autoCancel.setContentIntent(PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
        updateErrorNotification(autoCancel);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, autoCancel.build());
        }
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((i & 16384) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-16385));
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-32769));
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-8193));
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, dfuProgressInfo.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, dfuProgressInfo.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, dfuProgressInfo.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, dfuProgressInfo.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, dfuProgressInfo.getAverageSpeed());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void startForeground() {
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(android.R.drawable.stat_sys_upload).setContentTitle(getString(R.string.dfu_status_foreground_title)).setContentText(getString(R.string.dfu_status_foreground_content)).setColor(-7829368).setPriority(-1).setOngoing(true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            ongoing.setContentIntent(PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(ongoing);
        startForeground(NOTIFICATION_ID, ongoing.build());
    }

    public void close(@NonNull BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    public BluetoothGatt connect(@NonNull String str) {
        BluetoothGatt bluetoothGattConnectGatt;
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M | LE_2M)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2, 3);
        } else if (i >= 23) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2);
        } else {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    int i2 = this.mConnectionState;
                    if ((i2 != -1 && i2 != -2) || this.mError != 0 || this.mAborted) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return bluetoothGattConnectGatt;
    }

    public void disconnect(@NonNull BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState == 0) {
            return;
        }
        sendLogBroadcast(1, "Disconnecting...");
        this.mProgressInfo.setProgress(-5);
        logi("Disconnecting from the device...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        waitUntilDisconnected();
        sendLogBroadcast(5, "Disconnected");
    }

    @NonNull
    public DfuDeviceSelector getDeviceSelector() {
        return new DfuDefaultDeviceSelector();
    }

    @Nullable
    public abstract Class<? extends Activity> getNotificationTarget();

    public boolean isDebug() {
        return false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        logi("DFU service created. Version: 2.4.1");
        initialize();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilterMakeDfuActionIntentFilter = makeDfuActionIntentFilter();
        localBroadcastManager.registerReceiver(this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter);
        ContextCompat.registerReceiver(this, this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter, 2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        ContextCompat.registerReceiver(this, this.mConnectionStateBroadcastReceiver, intentFilter, 2);
        ContextCompat.registerReceiver(this, this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"), 2);
        ContextCompat.registerReceiver(this, this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x021a A[Catch: all -> 0x0180, Exception -> 0x0184, IOException -> 0x0188, SizeValidationException -> 0x018c, FileNotFoundException -> 0x0190, SecurityException -> 0x0194, TryCatch #9 {FileNotFoundException -> 0x0190, blocks: (B:64:0x012b, B:66:0x0135, B:73:0x014c, B:79:0x016e, B:97:0x019c, B:99:0x01a2, B:101:0x01a7, B:103:0x01b0, B:105:0x01b4, B:108:0x01bd, B:109:0x01c4, B:110:0x01c5, B:112:0x01c9, B:115:0x01d2, B:116:0x01d9, B:117:0x01da, B:119:0x01de, B:122:0x01e7, B:123:0x01ee, B:126:0x01f2, B:128:0x01f8, B:137:0x021a, B:139:0x0223, B:140:0x022a, B:129:0x0202, B:131:0x0208, B:102:0x01ac, B:82:0x0178, B:83:0x017f, B:75:0x0157, B:77:0x0161, B:68:0x013c, B:70:0x0143), top: B:306:0x012b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0242 A[Catch: all -> 0x0180, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0180, blocks: (B:64:0x012b, B:66:0x0135, B:73:0x014c, B:79:0x016e, B:97:0x019c, B:99:0x01a2, B:101:0x01a7, B:103:0x01b0, B:105:0x01b4, B:108:0x01bd, B:109:0x01c4, B:110:0x01c5, B:112:0x01c9, B:115:0x01d2, B:116:0x01d9, B:117:0x01da, B:119:0x01de, B:122:0x01e7, B:123:0x01ee, B:126:0x01f2, B:128:0x01f8, B:137:0x021a, B:139:0x0223, B:140:0x022a, B:141:0x0234, B:144:0x0242, B:148:0x0255, B:150:0x0271, B:154:0x0286, B:160:0x0297, B:187:0x03a6, B:193:0x03b6, B:195:0x03ba, B:200:0x03ce, B:202:0x03d2, B:206:0x03e9, B:213:0x0411, B:224:0x0432, B:254:0x050c, B:246:0x04ac, B:268:0x0538, B:269:0x053b, B:129:0x0202, B:131:0x0208, B:102:0x01ac, B:82:0x0178, B:83:0x017f, B:75:0x0157, B:77:0x0161, B:68:0x013c, B:70:0x0143, B:270:0x053c, B:274:0x0564, B:278:0x058c, B:282:0x05a3, B:286:0x05ba), top: B:298:0x0129, inners: #9, #11, #12, #17, #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0255 A[Catch: all -> 0x0180, TRY_ENTER, TryCatch #0 {all -> 0x0180, blocks: (B:64:0x012b, B:66:0x0135, B:73:0x014c, B:79:0x016e, B:97:0x019c, B:99:0x01a2, B:101:0x01a7, B:103:0x01b0, B:105:0x01b4, B:108:0x01bd, B:109:0x01c4, B:110:0x01c5, B:112:0x01c9, B:115:0x01d2, B:116:0x01d9, B:117:0x01da, B:119:0x01de, B:122:0x01e7, B:123:0x01ee, B:126:0x01f2, B:128:0x01f8, B:137:0x021a, B:139:0x0223, B:140:0x022a, B:141:0x0234, B:144:0x0242, B:148:0x0255, B:150:0x0271, B:154:0x0286, B:160:0x0297, B:187:0x03a6, B:193:0x03b6, B:195:0x03ba, B:200:0x03ce, B:202:0x03d2, B:206:0x03e9, B:213:0x0411, B:224:0x0432, B:254:0x050c, B:246:0x04ac, B:268:0x0538, B:269:0x053b, B:129:0x0202, B:131:0x0208, B:102:0x01ac, B:82:0x0178, B:83:0x017f, B:75:0x0157, B:77:0x0161, B:68:0x013c, B:70:0x0143, B:270:0x053c, B:274:0x0564, B:278:0x058c, B:282:0x05a3, B:286:0x05ba), top: B:298:0x0129, inners: #9, #11, #12, #17, #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04ac A[Catch: all -> 0x0180, PHI: r2
  0x04ac: PHI (r2v40 no.nordicsemi.android.dfu.DfuService) = 
  (r2v38 no.nordicsemi.android.dfu.DfuService)
  (r2v39 no.nordicsemi.android.dfu.DfuService)
  (r2v41 no.nordicsemi.android.dfu.DfuService)
 binds: [B:262:0x052c, B:245:0x04aa, B:260:0x051a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0180, blocks: (B:64:0x012b, B:66:0x0135, B:73:0x014c, B:79:0x016e, B:97:0x019c, B:99:0x01a2, B:101:0x01a7, B:103:0x01b0, B:105:0x01b4, B:108:0x01bd, B:109:0x01c4, B:110:0x01c5, B:112:0x01c9, B:115:0x01d2, B:116:0x01d9, B:117:0x01da, B:119:0x01de, B:122:0x01e7, B:123:0x01ee, B:126:0x01f2, B:128:0x01f8, B:137:0x021a, B:139:0x0223, B:140:0x022a, B:141:0x0234, B:144:0x0242, B:148:0x0255, B:150:0x0271, B:154:0x0286, B:160:0x0297, B:187:0x03a6, B:193:0x03b6, B:195:0x03ba, B:200:0x03ce, B:202:0x03d2, B:206:0x03e9, B:213:0x0411, B:224:0x0432, B:254:0x050c, B:246:0x04ac, B:268:0x0538, B:269:0x053b, B:129:0x0202, B:131:0x0208, B:102:0x01ac, B:82:0x0178, B:83:0x017f, B:75:0x0157, B:77:0x0161, B:68:0x013c, B:70:0x0143, B:270:0x053c, B:274:0x0564, B:278:0x058c, B:282:0x05a3, B:286:0x05ba), top: B:298:0x0129, inners: #9, #11, #12, #17, #18 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04d5 A[Catch: all -> 0x044b, TRY_LEAVE, TryCatch #7 {all -> 0x044b, blocks: (B:208:0x03f4, B:250:0x04b5, B:252:0x04d5, B:258:0x0515, B:240:0x0451, B:242:0x0459, B:244:0x049c, B:243:0x047c, B:261:0x051b), top: B:305:0x03f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0515 A[Catch: all -> 0x044b, TRY_ENTER, TryCatch #7 {all -> 0x044b, blocks: (B:208:0x03f4, B:250:0x04b5, B:252:0x04d5, B:258:0x0515, B:240:0x0451, B:242:0x0459, B:244:0x049c, B:243:0x047c, B:261:0x051b), top: B:305:0x03f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:329:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113  */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onHandleIntent(@androidx.annotation.Nullable android.content.Intent r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
        stopSelf();
    }

    public void refreshDeviceCache(@NonNull BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                logi("Refreshing result: " + ((Boolean) bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0])).booleanValue());
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void sendLogBroadcast(int i, String str) {
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + str);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void terminateConnection(@NonNull BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600L);
        if (i != 0) {
            report(i);
        }
    }

    public void updateErrorNotification(@NonNull NotificationCompat.Builder builder) {
    }

    public void updateForegroundNotification(@NonNull NotificationCompat.Builder builder) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressInfo.ProgressListener
    public void updateProgressNotification() {
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress == progress) {
            return;
        }
        this.mLastProgress = progress;
        sendProgressBroadcast(dfuProgressInfo);
        if (this.mDisableNotification) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
            this.mLastNotificationTime = jElapsedRealtime;
            String str = this.mDeviceAddress;
            String string = this.mDeviceName;
            if (string == null) {
                string = getString(R.string.dfu_unknown_name);
            }
            NotificationCompat.Builder onlyAlertOnce = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(android.R.drawable.stat_sys_upload).setOnlyAlertOnce(true);
            onlyAlertOnce.setColor(-7829368);
            switch (progress) {
                case -7:
                    onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_aborted)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_aborted_msg)).setAutoCancel(true);
                    break;
                case -6:
                    onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_completed)).setSmallIcon(android.R.drawable.stat_sys_upload_done).setContentText(getString(R.string.dfu_status_completed_msg)).setAutoCancel(true).setColor(-16730086);
                    break;
                case -5:
                    onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_disconnecting)).setContentText(getString(R.string.dfu_status_disconnecting_msg, new Object[]{string})).setProgress(100, 0, true);
                    break;
                case -4:
                    onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_validating)).setContentText(getString(R.string.dfu_status_validating_msg)).setProgress(100, 0, true);
                    break;
                case -3:
                    onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_switching_to_dfu)).setContentText(getString(R.string.dfu_status_switching_to_dfu_msg)).setProgress(100, 0, true);
                    break;
                case -2:
                    onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_starting)).setContentText(getString(R.string.dfu_status_starting_msg)).setProgress(100, 0, true);
                    break;
                case -1:
                    onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_connecting)).setContentText(getString(R.string.dfu_status_connecting_msg, new Object[]{string})).setProgress(100, 0, true);
                    break;
                default:
                    onlyAlertOnce.setOngoing(true).setContentTitle(dfuProgressInfo.getTotalParts() == 1 ? getString(R.string.dfu_status_uploading) : getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts())})).setContentText(getString(R.string.dfu_status_uploading_msg, new Object[]{string})).setProgress(100, progress, false);
                    break;
            }
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, string);
            intent.putExtra(EXTRA_PROGRESS, progress);
            onlyAlertOnce.setContentIntent(PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
            updateProgressNotification(onlyAlertOnce, progress);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, onlyAlertOnce.build());
            }
        }
    }

    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + ")");
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    private InputStream openInputStream(@NonNull Uri uri, String str, int i, int i2) throws IOException {
        InputStream inputStreamOpenInputStream;
        if (uri.toString().startsWith("file:///android_asset/")) {
            inputStreamOpenInputStream = getAssets().open(uri.getPath().substring(15));
        } else {
            inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        }
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(inputStreamOpenInputStream, i, i2);
        }
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext() && cursorQuery.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(inputStreamOpenInputStream, i);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return hexInputStream;
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return inputStreamOpenInputStream;
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws Resources.NotFoundException, IOException {
        InputStream inputStreamOpenRawResource = getResources().openRawResource(i);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(inputStreamOpenRawResource, i2, i3);
        }
        inputStreamOpenRawResource.mark(2);
        int i4 = inputStreamOpenRawResource.read();
        inputStreamOpenRawResource.reset();
        return i4 == 58 ? new HexInputStream(inputStreamOpenRawResource, i2) : inputStreamOpenRawResource;
    }

    public void updateProgressNotification(@NonNull NotificationCompat.Builder builder, int i) {
        if (i == -7 || i == -6) {
            return;
        }
        Intent intent = new Intent(BROADCAST_ACTION);
        intent.putExtra(EXTRA_ACTION, 2);
        builder.addAction(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
    }
}
