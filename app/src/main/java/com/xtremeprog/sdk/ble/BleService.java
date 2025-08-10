package com.xtremeprog.sdk.ble;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleRequest;
import dc.be3;
import dc.rp1;
import dc.tb1;
import dc.xe3;
import dc.ze3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

/* loaded from: classes4.dex */
public class BleService extends Service {
    public static final String BLE_CHARACTERISTIC_CHANGED = "com.lovense.wear.characteristic_changed";
    public static final String BLE_CHARACTERISTIC_INDICATION = "com.lovense.wear.characteristic_indication";
    public static final String BLE_CHARACTERISTIC_NOTIFICATION = "com.lovense.wear.characteristic_notification";
    public static final String BLE_CHARACTERISTIC_READ = "com.lovense.wear.characteristic_read";
    public static final String BLE_CHARACTERISTIC_WRITE = "com.lovense.wear.characteristic_write";
    public static final String BLE_CONNECT_STATE_VALUE = "com.lovense.wear.onConnectionStateChange";
    public static final String BLE_DEVICE_FOUND = "com.lovense.wear.device_found";
    public static final String BLE_GATT_CONNECTED = "com.lovense.wear.gatt_connected";
    public static final String BLE_GATT_DISCONNECTED = "com.lovense.wear.gatt_disconnected";
    public static final String BLE_NOT_SUPPORTED = "com.lovense.wear.not_supported";
    public static final String BLE_NO_BT_ADAPTER = "com.lovense.wear.no_bt_adapter";
    public static final String BLE_ONREAD_RSSI = "com.lovense.wear.onread_rssi";
    public static final String BLE_REQUEST_FAILED = "com.lovense.wear.request_failed";
    public static final String BLE_SERVICE_DISCOVERED = "com.lovense.wear.service_discovered";
    public static final String BLE_STATUS_ABNORMAL = "com.lovense.wear.status_abnormal";
    public static final UUID DESC_CCC = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final int DEVICE_SOURCE_BONDED = 1;
    public static final int DEVICE_SOURCE_CONNECTED = 2;
    public static final int DEVICE_SOURCE_SCAN = 0;
    public static final String EXTRA_ADDR = "ADDRESS";
    public static final String EXTRA_CONNECTED = "CONNECTED";
    public static final String EXTRA_DEVICE = "DEVICE";
    public static final String EXTRA_REASON = "REASON";
    public static final String EXTRA_REQUEST = "REQUEST";
    public static final String EXTRA_RSSI = "RSSI";
    public static final String EXTRA_SCAN_RECORD = "SCAN_RECORD";
    public static final String EXTRA_SOURCE = "SOURCE";
    public static final String EXTRA_STATUS = "STATUS";
    public static final String EXTRA_UUID = "UUID";
    public static final String EXTRA_VALUE = "VALUE";
    private static final int REQUEST_TIMEOUT = 110;
    private IBle mBle;
    private BLESDK mBleSDK;
    private String mNotificationAddress;
    private Thread mRequestTimeout;
    private final IBinder mBinder = new LocalBinder();
    private Queue<BleRequest> mRequestQueue = new LinkedList();
    private BleRequest mCurrentRequest = null;
    private boolean mCheckTimeout = false;
    private int mElapsed = 0;
    private Runnable mTimeoutRunnable = new Runnable() { // from class: com.xtremeprog.sdk.ble.BleService.1
        /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
        
            if (r6.this$0.mCurrentRequest == null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
        
            r2 = "-processrequest type ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
        
            r4 = " null ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        
            if (r6.this$0.mCurrentRequest == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        
            r3 = r6.this$0.mCurrentRequest.type;
            r5 = new java.lang.StringBuilder();
            r5.append("-processrequest type ");
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
        
            if (r3 != null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            r3 = " null ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        
            r5.append(r3);
            r2 = r5.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
        
            if (r6.this$0.mCurrentRequest == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
        
            r1 = r6.this$0.mCurrentRequest.address;
            r3 = new java.lang.StringBuilder();
            r3.append(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        
            if (com.wear.util.WearUtils.e1(r1) == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
        
            r4 = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        
            r3.append(r4);
            r2 = r3.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
        
            r1 = r6.this$0;
            r1.bleRequestFailed(r1.mCurrentRequest.address, r6.this$0.mCurrentRequest.type, com.xtremeprog.sdk.ble.BleRequest.FailReason.TIMEOUT);
            r1 = "";
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.InterruptedException {
            /*
                r6 = this;
                java.lang.String r0 = "blelib"
                java.lang.String r1 = "monitoring thread start"
                dc.xe3.a(r0, r1)
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this
                r2 = 0
                com.xtremeprog.sdk.ble.BleService.access$002(r1, r2)
            Ld:
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                boolean r1 = com.xtremeprog.sdk.ble.BleService.access$100(r1)     // Catch: java.lang.InterruptedException -> Lda
                if (r1 == 0) goto Le3
                r1 = 110(0x6e, double:5.43E-322)
                java.lang.Thread.sleep(r1)     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService.access$008(r1)     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                int r1 = com.xtremeprog.sdk.ble.BleService.access$000(r1)     // Catch: java.lang.InterruptedException -> Lda
                r2 = 110(0x6e, float:1.54E-43)
                if (r1 <= r2) goto Ld
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest r1 = com.xtremeprog.sdk.ble.BleService.access$200(r1)     // Catch: java.lang.InterruptedException -> Lda
                if (r1 == 0) goto Ld
                com.xtremeprog.sdk.ble.BleService r1 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest r2 = com.xtremeprog.sdk.ble.BleService.access$200(r1)     // Catch: java.lang.InterruptedException -> Lda
                java.lang.String r2 = r2.address     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest r3 = com.xtremeprog.sdk.ble.BleService.access$200(r3)     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest$RequestType r3 = r3.type     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest$FailReason r4 = com.xtremeprog.sdk.ble.BleRequest.FailReason.TIMEOUT     // Catch: java.lang.InterruptedException -> Lda
                r1.bleRequestFailed(r2, r3, r4)     // Catch: java.lang.InterruptedException -> Lda
                java.lang.String r1 = ""
                com.xtremeprog.sdk.ble.BleService r2 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleRequest r2 = com.xtremeprog.sdk.ble.BleService.access$200(r2)     // Catch: java.lang.InterruptedException -> Lda
                if (r2 == 0) goto Lb3
                java.lang.String r2 = "-processrequest type "
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.Exception -> L9d
                com.xtremeprog.sdk.ble.BleRequest r3 = com.xtremeprog.sdk.ble.BleService.access$200(r3)     // Catch: java.lang.Exception -> L9d
                java.lang.String r4 = " null "
                if (r3 == 0) goto L77
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.Exception -> L9d
                com.xtremeprog.sdk.ble.BleRequest r3 = com.xtremeprog.sdk.ble.BleService.access$200(r3)     // Catch: java.lang.Exception -> L9d
                com.xtremeprog.sdk.ble.BleRequest$RequestType r3 = r3.type     // Catch: java.lang.Exception -> L9d
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9d
                r5.<init>()     // Catch: java.lang.Exception -> L9d
                r5.append(r2)     // Catch: java.lang.Exception -> L9d
                if (r3 != 0) goto L6f
                goto L70
            L6f:
                r3 = r4
            L70:
                r5.append(r3)     // Catch: java.lang.Exception -> L9d
                java.lang.String r2 = r5.toString()     // Catch: java.lang.Exception -> L9d
            L77:
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.Exception -> L9d
                com.xtremeprog.sdk.ble.BleRequest r3 = com.xtremeprog.sdk.ble.BleService.access$200(r3)     // Catch: java.lang.Exception -> L9d
                if (r3 == 0) goto L9d
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.Exception -> L9d
                com.xtremeprog.sdk.ble.BleRequest r3 = com.xtremeprog.sdk.ble.BleService.access$200(r3)     // Catch: java.lang.Exception -> L9d
                java.lang.String r1 = r3.address     // Catch: java.lang.Exception -> L9d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9d
                r3.<init>()     // Catch: java.lang.Exception -> L9d
                r3.append(r2)     // Catch: java.lang.Exception -> L9d
                boolean r5 = com.wear.util.WearUtils.e1(r1)     // Catch: java.lang.Exception -> L9d
                if (r5 == 0) goto L96
                r4 = r1
            L96:
                r3.append(r4)     // Catch: java.lang.Exception -> L9d
                java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L9d
            L9d:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.InterruptedException -> Lda
                r3.<init>()     // Catch: java.lang.InterruptedException -> Lda
                r3.append(r2)     // Catch: java.lang.InterruptedException -> Lda
                java.lang.String r2 = " [timeout]"
                r3.append(r2)     // Catch: java.lang.InterruptedException -> Lda
                java.lang.String r2 = r3.toString()     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService r3 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                r3.bleStatusAbnormal(r2)     // Catch: java.lang.InterruptedException -> Lda
            Lb3:
                com.xtremeprog.sdk.ble.BleService r2 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.IBle r2 = com.xtremeprog.sdk.ble.BleService.access$300(r2)     // Catch: java.lang.InterruptedException -> Lda
                if (r2 == 0) goto Lca
                boolean r2 = com.wear.util.WearUtils.e1(r1)     // Catch: java.lang.InterruptedException -> Lda
                if (r2 != 0) goto Lca
                com.xtremeprog.sdk.ble.BleService r2 = com.xtremeprog.sdk.ble.BleService.this     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.IBle r2 = com.xtremeprog.sdk.ble.BleService.access$300(r2)     // Catch: java.lang.InterruptedException -> Lda
                r2.disconnect(r1)     // Catch: java.lang.InterruptedException -> Lda
            Lca:
                java.lang.Thread r1 = new java.lang.Thread     // Catch: java.lang.InterruptedException -> Lda
                com.xtremeprog.sdk.ble.BleService$1$1 r2 = new com.xtremeprog.sdk.ble.BleService$1$1     // Catch: java.lang.InterruptedException -> Lda
                r2.<init>()     // Catch: java.lang.InterruptedException -> Lda
                java.lang.String r3 = "th-ble"
                r1.<init>(r2, r3)     // Catch: java.lang.InterruptedException -> Lda
                r1.start()     // Catch: java.lang.InterruptedException -> Lda
                goto Le3
            Lda:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.String r1 = "monitoring thread exception"
                dc.xe3.a(r0, r1)
            Le3:
                java.lang.String r1 = "monitoring thread stop"
                dc.xe3.a(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xtremeprog.sdk.ble.BleService.AnonymousClass1.run():void");
        }
    };

    /* renamed from: com.xtremeprog.sdk.ble.BleService$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType;

        static {
            int[] iArr = new int[BleRequest.RequestType.values().length];
            $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType = iArr;
            try {
                iArr[BleRequest.RequestType.CONNECT_GATT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.DISCOVER_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.CHARACTERISTIC_INDICATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.READ_CHARACTERISTIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.WRITE_CHARACTERISTIC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[BleRequest.RequestType.READ_DESCRIPTOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum BLESDK {
        NOT_SUPPORTED,
        ANDROID,
        SAMSUNG,
        BROADCOM
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BleService getService() {
            return BleService.this;
        }
    }

    public static /* synthetic */ int access$008(BleService bleService) {
        int i = bleService.mElapsed;
        bleService.mElapsed = i + 1;
        return i;
    }

    private void clearTimeoutThread() throws InterruptedException {
        Thread thread = this.mRequestTimeout;
        if (thread == null || !thread.isAlive()) {
            return;
        }
        try {
            this.mCheckTimeout = false;
            this.mRequestTimeout.join();
            this.mRequestTimeout = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private BLESDK getBleSDK() {
        if (getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return BLESDK.ANDROID;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : getPackageManager().getSystemSharedLibraryNames()) {
            arrayList.add(str);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (arrayList.contains("com.samsung.android.sdk.bt")) {
                return BLESDK.SAMSUNG;
            }
            if (arrayList.contains("com.broadcom.bt")) {
                return BLESDK.BROADCOM;
            }
        }
        bleNotSupported();
        return BLESDK.NOT_SUPPORTED;
    }

    public static IntentFilter getIntentCharacteristicFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLE_CHARACTERISTIC_NOTIFICATION);
        intentFilter.addAction(BLE_CHARACTERISTIC_INDICATION);
        intentFilter.addAction(BLE_CHARACTERISTIC_READ);
        intentFilter.addAction(BLE_CHARACTERISTIC_WRITE);
        intentFilter.addAction(BLE_REQUEST_FAILED);
        intentFilter.addAction(BLE_CHARACTERISTIC_CHANGED);
        intentFilter.addAction(BLE_ONREAD_RSSI);
        intentFilter.addAction(BLE_CONNECT_STATE_VALUE);
        return intentFilter;
    }

    public static IntentFilter getIntentConnectFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLE_GATT_CONNECTED);
        intentFilter.addAction(BLE_GATT_DISCONNECTED);
        intentFilter.addAction(BLE_SERVICE_DISCOVERED);
        return intentFilter;
    }

    public static IntentFilter getIntentScanFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BLE_NOT_SUPPORTED);
        intentFilter.addAction(BLE_NO_BT_ADAPTER);
        intentFilter.addAction(BLE_DEVICE_FOUND);
        return intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void processNextRequest() {
        BleRequest.RequestType requestType;
        if (this.mCurrentRequest != null) {
            return;
        }
        if (this.mRequestQueue.isEmpty()) {
            return;
        }
        try {
            BleRequest bleRequestRemove = this.mRequestQueue.remove();
            this.mCurrentRequest = bleRequestRemove;
            String str = bleRequestRemove != null ? bleRequestRemove.address : "";
            startTimeoutThread();
            boolean zConnect = false;
            BleRequest bleRequest = this.mCurrentRequest;
            if (bleRequest != null && (requestType = bleRequest.type) != null) {
                switch (AnonymousClass4.$SwitchMap$com$xtremeprog$sdk$ble$BleRequest$RequestType[requestType.ordinal()]) {
                    case 1:
                        zConnect = ((IBleRequestHandler) this.mBle).connect(str);
                        break;
                    case 2:
                        zConnect = this.mBle.discoverServices(str);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        zConnect = ((IBleRequestHandler) this.mBle).characteristicNotification(str, this.mCurrentRequest.characteristic);
                        break;
                    case 6:
                        zConnect = ((IBleRequestHandler) this.mBle).readCharacteristic(str, this.mCurrentRequest.characteristic);
                        break;
                    case 7:
                        zConnect = ((IBleRequestHandler) this.mBle).writeCharacteristic(str, this.mCurrentRequest.characteristic, null);
                        break;
                }
            }
            if (!zConnect) {
                clearTimeoutThread();
                if (this.mCurrentRequest != null) {
                    xe3.a(IBle.TAG, "请求失败：" + this.mCurrentRequest.type);
                    BleRequest bleRequest2 = this.mCurrentRequest;
                    bleRequestFailed(str, bleRequest2 == null ? BleRequest.RequestType.CONNECT_GATT : bleRequest2.type, BleRequest.FailReason.START_FAILED);
                }
                new Thread(new Runnable() { // from class: com.xtremeprog.sdk.ble.BleService.3
                    @Override // java.lang.Runnable
                    public void run() {
                        BleService.this.mCurrentRequest = null;
                        BleService.this.processNextRequest();
                    }
                }, "th-ble").start();
            }
        } catch (Exception unused) {
            this.mCurrentRequest = null;
            this.mRequestQueue.clear();
        }
    }

    private void startTimeoutThread() {
        this.mCheckTimeout = true;
        Thread thread = new Thread(this.mTimeoutRunnable);
        this.mRequestTimeout = thread;
        thread.start();
    }

    public void addBleRequest(BleRequest bleRequest) {
        Toy toyQ;
        synchronized (this.mRequestQueue) {
            if (!existGattBleRequest(bleRequest)) {
                if (tb1.d().b) {
                    String str = tb1.i;
                    String str2 = "request.Connect! address:" + bleRequest.address;
                }
                if (bleRequest.type == BleRequest.RequestType.CONNECT_GATT && (toyQ = WearUtils.x.G().Q(bleRequest.address)) != null && toyQ.canAddConnectingLog(true)) {
                    toyQ.setRquestConnectTime(Long.valueOf(be3.I().getTime()));
                    toyQ.setDisConnectType(0);
                    ze3.b(toyQ.getName(), toyQ.getAddress(), toyQ.getDeviceType());
                }
                this.mRequestQueue.add(bleRequest);
            }
            processNextRequest();
        }
    }

    public void bleCharacteristicChanged(String str, String str2, byte[] bArr) {
        Intent intent = new Intent(BLE_CHARACTERISTIC_CHANGED);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_UUID, str2);
        intent.putExtra(EXTRA_VALUE, bArr);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
    }

    public void bleCharacteristicIndication(String str, String str2, int i) throws InterruptedException {
        Intent intent = new Intent(BLE_CHARACTERISTIC_INDICATION);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_UUID, str2);
        intent.putExtra("STATUS", i);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(str, BleRequest.RequestType.CHARACTERISTIC_INDICATION, true);
        setNotificationAddress(str);
    }

    public void bleCharacteristicNotification(String str, String str2, boolean z, int i) throws InterruptedException {
        Intent intent = new Intent(BLE_CHARACTERISTIC_NOTIFICATION);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_UUID, str2);
        intent.putExtra(EXTRA_VALUE, z);
        intent.putExtra("STATUS", i);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        if (z) {
            requestProcessed(str, BleRequest.RequestType.CHARACTERISTIC_NOTIFICATION, true);
        } else {
            requestProcessed(str, BleRequest.RequestType.CHARACTERISTIC_STOP_NOTIFICATION, true);
        }
        setNotificationAddress(str);
    }

    public void bleCharacteristicRead(String str, String str2, int i, byte[] bArr) throws InterruptedException {
        Intent intent = new Intent(BLE_CHARACTERISTIC_READ);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_UUID, str2);
        intent.putExtra("STATUS", i);
        intent.putExtra(EXTRA_VALUE, bArr);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(str, BleRequest.RequestType.READ_CHARACTERISTIC, true);
    }

    public void bleCharacteristicWrite(String str, String str2, int i) throws InterruptedException {
        Intent intent = new Intent(BLE_CHARACTERISTIC_WRITE);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_UUID, str2);
        intent.putExtra("STATUS", i);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(str, BleRequest.RequestType.WRITE_CHARACTERISTIC, true);
    }

    public void bleConnectState(String str, int i, int i2) {
        Intent intent = new Intent(BLE_CONNECT_STATE_VALUE);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_VALUE, i);
        intent.putExtra(EXTRA_SOURCE, i2);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
    }

    public void bleDeviceFound(BluetoothDevice bluetoothDevice, int i, byte[] bArr, int i2) {
        Intent intent = new Intent(BLE_DEVICE_FOUND);
        intent.putExtra(EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(EXTRA_RSSI, i);
        intent.putExtra(EXTRA_SCAN_RECORD, bArr);
        intent.putExtra(EXTRA_SOURCE, i2);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
    }

    public void bleGattConnected(BluetoothDevice bluetoothDevice) throws InterruptedException {
        Intent intent = new Intent(BLE_GATT_CONNECTED);
        intent.putExtra(EXTRA_DEVICE, bluetoothDevice);
        intent.putExtra(EXTRA_ADDR, bluetoothDevice.getAddress());
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(bluetoothDevice.getAddress(), BleRequest.RequestType.CONNECT_GATT, true);
    }

    public void bleGattDisConnected(String str, int i) throws InterruptedException {
        Intent intent = new Intent(BLE_GATT_DISCONNECTED);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra("STATUS", i);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(str, BleRequest.RequestType.CONNECT_GATT, false);
    }

    public void bleNoBtAdapter() {
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent(BLE_NO_BT_ADAPTER));
    }

    public void bleNotSupported() {
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(new Intent(BLE_NOT_SUPPORTED));
    }

    public void bleOnReadRssi(String str, int i) {
        Intent intent = new Intent(BLE_ONREAD_RSSI);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_VALUE, i);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
    }

    public void bleRequestFailed(String str, BleRequest.RequestType requestType, BleRequest.FailReason failReason) {
        Intent intent = new Intent(BLE_REQUEST_FAILED);
        intent.putExtra(EXTRA_ADDR, str);
        intent.putExtra(EXTRA_REQUEST, requestType);
        intent.putExtra(EXTRA_REASON, failReason.ordinal());
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
    }

    public void bleServiceDiscovered(String str) throws InterruptedException {
        Intent intent = new Intent(BLE_SERVICE_DISCOVERED);
        intent.putExtra(EXTRA_ADDR, str);
        LocalBroadcastManager.getInstance(WearUtils.x).sendBroadcast(intent);
        requestProcessed(str, BleRequest.RequestType.DISCOVER_SERVICE, true);
    }

    public void bleStatusAbnormal(String str) {
    }

    public boolean existGattBleRequest(BleRequest bleRequest) {
        BleRequest.RequestType requestType;
        if (bleRequest == null) {
            return false;
        }
        try {
            if (bleRequest.type != BleRequest.RequestType.CONNECT_GATT) {
                return false;
            }
            for (BleRequest bleRequest2 : this.mRequestQueue) {
                if (bleRequest2 != null && (requestType = bleRequest2.type) != null && requestType == BleRequest.RequestType.CONNECT_GATT && bleRequest2.address.equals(bleRequest.address)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public IBle getBle() {
        return this.mBle;
    }

    public BleRequest getCurrentRequest() {
        return this.mCurrentRequest;
    }

    public String getNotificationAddress() {
        return this.mNotificationAddress;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        BLESDK bleSDK = getBleSDK();
        this.mBleSDK = bleSDK;
        if (bleSDK == BLESDK.NOT_SUPPORTED) {
            return;
        }
        xe3.a(IBle.TAG, " " + this.mBleSDK);
        rp1.w(this.mBleSDK.toString());
        BLESDK blesdk = this.mBleSDK;
        if (blesdk == BLESDK.BROADCOM) {
            this.mBle = new BroadcomBle(this);
        } else if (blesdk == BLESDK.ANDROID) {
            this.mBle = new AndroidBle(this);
        } else if (blesdk == BLESDK.SAMSUNG) {
            this.mBle = new SamsungBle(this);
        }
    }

    public void requestProcessed(String str, BleRequest.RequestType requestType, boolean z) throws InterruptedException {
        BleRequest bleRequest = this.mCurrentRequest;
        if (bleRequest == null || bleRequest.type != requestType) {
            return;
        }
        clearTimeoutThread();
        xe3.a(IBle.TAG, "-processrequest type " + requestType + " address " + str + " [success: " + z + "]");
        if (!z) {
            BleRequest bleRequest2 = this.mCurrentRequest;
            bleRequestFailed(bleRequest2.address, bleRequest2.type, BleRequest.FailReason.RESULT_FAILED);
        }
        new Thread(new Runnable() { // from class: com.xtremeprog.sdk.ble.BleService.2
            @Override // java.lang.Runnable
            public void run() {
                BleService.this.mCurrentRequest = null;
                BleService.this.processNextRequest();
            }
        }, "th-ble").start();
    }

    public void resetBleParams() throws InterruptedException {
        this.mCurrentRequest = null;
        this.mRequestQueue.clear();
        clearTimeoutThread();
    }

    public void setCurrentRequest(BleRequest bleRequest) {
        this.mCurrentRequest = bleRequest;
    }

    public void setNotificationAddress(String str) {
        this.mNotificationAddress = str;
    }
}
