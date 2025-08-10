package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.broadcom.bt.service.ftp.BluetoothFTP;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

/* loaded from: classes5.dex */
public class ScannerService extends Service {
    public static final String EXTRA_FILTERS = "no.nordicsemi.android.support.v18.EXTRA_FILTERS";
    public static final String EXTRA_PENDING_INTENT = "no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT";
    public static final String EXTRA_REQUEST_CODE = "no.nordicsemi.android.support.v18.REQUEST_CODE";
    public static final String EXTRA_SETTINGS = "no.nordicsemi.android.support.v18.EXTRA_SETTINGS";
    public static final String EXTRA_START = "no.nordicsemi.android.support.v18.EXTRA_START";
    private static final String TAG = "ScannerService";

    @NonNull
    private final Object LOCK = new Object();
    private HashMap<Integer, ScanCallback> callbacks;
    private Handler handler;

    @RequiresPermission(allOf = {BluetoothFTP.BLUETOOTH_ADMIN_PERM, BluetoothFTP.BLUETOOTH_PERM})
    private void startScan(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull PendingIntent pendingIntent, int i) {
        PendingIntentExecutor pendingIntentExecutor = new PendingIntentExecutor(pendingIntent, scanSettings, this);
        synchronized (this.LOCK) {
            this.callbacks.put(Integer.valueOf(i), pendingIntentExecutor);
        }
        try {
            BluetoothLeScannerCompat.getScanner().startScanInternal(list, scanSettings, pendingIntentExecutor, this.handler);
        } catch (Exception unused) {
        }
    }

    @RequiresPermission(allOf = {BluetoothFTP.BLUETOOTH_ADMIN_PERM, BluetoothFTP.BLUETOOTH_PERM})
    private void stopScan(int i) {
        ScanCallback scanCallbackRemove;
        boolean zIsEmpty;
        synchronized (this.LOCK) {
            scanCallbackRemove = this.callbacks.remove(Integer.valueOf(i));
            zIsEmpty = this.callbacks.isEmpty();
        }
        if (scanCallbackRemove == null) {
            return;
        }
        try {
            BluetoothLeScannerCompat.getScanner().stopScan(scanCallbackRemove);
        } catch (Exception unused) {
        }
        if (zIsEmpty) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.callbacks = new HashMap<>();
        this.handler = new Handler();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {BluetoothFTP.BLUETOOTH_ADMIN_PERM, BluetoothFTP.BLUETOOTH_PERM})
    public void onDestroy() {
        BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
        Iterator<ScanCallback> it = this.callbacks.values().iterator();
        while (it.hasNext()) {
            try {
                scanner.stopScan(it.next());
            } catch (Exception unused) {
            }
        }
        this.callbacks.clear();
        this.callbacks = null;
        this.handler = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {BluetoothFTP.BLUETOOTH_ADMIN_PERM, BluetoothFTP.BLUETOOTH_PERM})
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean zContainsKey;
        boolean zIsEmpty;
        if (intent != null) {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
            int intExtra = intent.getIntExtra(EXTRA_REQUEST_CODE, 0);
            boolean booleanExtra = intent.getBooleanExtra(EXTRA_START, false);
            boolean z = !booleanExtra;
            if (pendingIntent == null) {
                synchronized (this.LOCK) {
                    zIsEmpty = this.callbacks.isEmpty();
                }
                if (zIsEmpty) {
                    stopSelf();
                }
                return 2;
            }
            synchronized (this.LOCK) {
                zContainsKey = this.callbacks.containsKey(Integer.valueOf(intExtra));
            }
            if (booleanExtra && !zContainsKey) {
                List<ScanFilter> parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
                ScanSettings scanSettingsBuild = (ScanSettings) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
                if (parcelableArrayListExtra == null) {
                    parcelableArrayListExtra = Collections.emptyList();
                }
                if (scanSettingsBuild == null) {
                    scanSettingsBuild = new ScanSettings.Builder().build();
                }
                startScan(parcelableArrayListExtra, scanSettingsBuild, pendingIntent, intExtra);
            } else if (z && zContainsKey) {
                stopScan(intExtra);
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}
