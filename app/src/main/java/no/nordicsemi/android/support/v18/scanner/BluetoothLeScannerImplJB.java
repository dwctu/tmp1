package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;

/* loaded from: classes5.dex */
public class BluetoothLeScannerImplJB extends BluetoothLeScannerCompat {

    @Nullable
    private HandlerThread handlerThread;

    @Nullable
    private Handler powerSaveHandler;
    private long powerSaveRestInterval;
    private long powerSaveScanInterval;

    @NonNull
    private final ScanCallbackWrapperSet<BluetoothLeScannerCompat.ScanCallbackWrapper> wrappers = new ScanCallbackWrapperSet<>();
    private final Runnable powerSaveSleepTask = new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerImplJB.1
        @Override // java.lang.Runnable
        public void run() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || BluetoothLeScannerImplJB.this.powerSaveRestInterval <= 0 || BluetoothLeScannerImplJB.this.powerSaveScanInterval <= 0) {
                return;
            }
            defaultAdapter.stopLeScan(BluetoothLeScannerImplJB.this.scanCallback);
            BluetoothLeScannerImplJB.this.powerSaveHandler.postDelayed(BluetoothLeScannerImplJB.this.powerSaveScanTask, BluetoothLeScannerImplJB.this.powerSaveRestInterval);
        }
    };
    private final Runnable powerSaveScanTask = new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerImplJB.2
        @Override // java.lang.Runnable
        public void run() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || BluetoothLeScannerImplJB.this.powerSaveRestInterval <= 0 || BluetoothLeScannerImplJB.this.powerSaveScanInterval <= 0) {
                return;
            }
            defaultAdapter.startLeScan(BluetoothLeScannerImplJB.this.scanCallback);
            BluetoothLeScannerImplJB.this.powerSaveHandler.postDelayed(BluetoothLeScannerImplJB.this.powerSaveSleepTask, BluetoothLeScannerImplJB.this.powerSaveScanInterval);
        }
    };
    private final BluetoothAdapter.LeScanCallback scanCallback = new BluetoothAdapter.LeScanCallback() { // from class: dc.nb4
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.a.c(bluetoothDevice, i, bArr);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        final ScanResult scanResult = new ScanResult(bluetoothDevice, ScanRecord.parseFromBytes(bArr), i, SystemClock.elapsedRealtimeNanos());
        synchronized (this.wrappers) {
            for (final BluetoothLeScannerCompat.ScanCallbackWrapper scanCallbackWrapper : this.wrappers.values()) {
                scanCallbackWrapper.handler.post(new Runnable() { // from class: dc.mb4
                    @Override // java.lang.Runnable
                    public final void run() {
                        scanCallbackWrapper.handleScanResult(1, scanResult);
                    }
                });
            }
        }
    }

    private void setPowerSaveSettings() {
        long powerSaveRest;
        long powerSaveScan;
        synchronized (this.wrappers) {
            Iterator it = this.wrappers.values().iterator();
            powerSaveRest = Long.MAX_VALUE;
            powerSaveScan = Long.MAX_VALUE;
            while (it.hasNext()) {
                ScanSettings scanSettings = ((BluetoothLeScannerCompat.ScanCallbackWrapper) it.next()).scanSettings;
                if (scanSettings.hasPowerSaveMode()) {
                    if (powerSaveRest > scanSettings.getPowerSaveRest()) {
                        powerSaveRest = scanSettings.getPowerSaveRest();
                    }
                    if (powerSaveScan > scanSettings.getPowerSaveScan()) {
                        powerSaveScan = scanSettings.getPowerSaveScan();
                    }
                }
            }
        }
        if (powerSaveRest >= Long.MAX_VALUE || powerSaveScan >= Long.MAX_VALUE) {
            this.powerSaveScanInterval = 0L;
            this.powerSaveRestInterval = 0L;
            Handler handler = this.powerSaveHandler;
            if (handler != null) {
                handler.removeCallbacks(this.powerSaveScanTask);
                this.powerSaveHandler.removeCallbacks(this.powerSaveSleepTask);
                return;
            }
            return;
        }
        this.powerSaveRestInterval = powerSaveRest;
        this.powerSaveScanInterval = powerSaveScan;
        Handler handler2 = this.powerSaveHandler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.powerSaveScanTask);
            this.powerSaveHandler.removeCallbacks(this.powerSaveSleepTask);
            this.powerSaveHandler.postDelayed(this.powerSaveSleepTask, this.powerSaveScanInterval);
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void flushPendingScanResults(@NonNull ScanCallback scanCallback) {
        BluetoothLeScannerCompat.ScanCallbackWrapper scanCallbackWrapper;
        if (scanCallback == null) {
            throw new IllegalArgumentException("callback cannot be null!");
        }
        synchronized (this.wrappers) {
            scanCallbackWrapper = this.wrappers.get(scanCallback);
        }
        if (scanCallbackWrapper == null) {
            throw new IllegalArgumentException("callback not registered!");
        }
        scanCallbackWrapper.flushPendingScanResults();
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull ScanCallback scanCallback, @NonNull Handler handler) {
        boolean zIsEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        synchronized (this.wrappers) {
            if (this.wrappers.contains(scanCallback)) {
                throw new IllegalArgumentException("scanner already started with given scanCallback");
            }
            BluetoothLeScannerCompat.ScanCallbackWrapper scanCallbackWrapper = new BluetoothLeScannerCompat.ScanCallbackWrapper(false, false, list, scanSettings, new UserScanCallbackWrapper(scanCallback), handler);
            zIsEmpty = this.wrappers.isEmpty();
            this.wrappers.add(scanCallbackWrapper);
        }
        if (this.handlerThread == null) {
            HandlerThread handlerThread = new HandlerThread(BluetoothLeScannerImplJB.class.getName());
            this.handlerThread = handlerThread;
            handlerThread.start();
            this.powerSaveHandler = new Handler(this.handlerThread.getLooper());
        }
        setPowerSaveSettings();
        if (zIsEmpty) {
            defaultAdapter.startLeScan(this.scanCallback);
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void stopScanInternal(@NonNull ScanCallback scanCallback) {
        BluetoothLeScannerCompat.ScanCallbackWrapper scanCallbackWrapperRemove;
        boolean zIsEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        synchronized (this.wrappers) {
            scanCallbackWrapperRemove = this.wrappers.remove(scanCallback);
            zIsEmpty = this.wrappers.isEmpty();
        }
        if (scanCallbackWrapperRemove == null) {
            return;
        }
        scanCallbackWrapperRemove.close();
        setPowerSaveSettings();
        if (zIsEmpty) {
            defaultAdapter.stopLeScan(this.scanCallback);
            Handler handler = this.powerSaveHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.handlerThread = null;
            }
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void stopScanInternal(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        Intent intent = new Intent(context, (Class<?>) ScannerService.class);
        intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT", pendingIntent);
        intent.putExtra(ScannerService.EXTRA_REQUEST_CODE, i);
        intent.putExtra(ScannerService.EXTRA_START, false);
        context.startService(intent);
    }

    @Override // no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat
    public void startScanInternal(@NonNull List<ScanFilter> list, @NonNull ScanSettings scanSettings, @NonNull Context context, @NonNull PendingIntent pendingIntent, int i) {
        Intent intent = new Intent(context, (Class<?>) ScannerService.class);
        intent.putParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS", new ArrayList<>(list));
        intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS", scanSettings);
        intent.putExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT", pendingIntent);
        intent.putExtra(ScannerService.EXTRA_REQUEST_CODE, i);
        intent.putExtra(ScannerService.EXTRA_START, true);
        context.startService(intent);
    }
}
